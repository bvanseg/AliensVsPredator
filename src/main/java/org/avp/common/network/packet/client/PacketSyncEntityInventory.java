package org.avp.common.network.packet.client;

import com.asx.mdx.client.ClientGame;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import org.lib.common.InventoryHolder;
import org.lib.common.inventory.InventoryNBTUtil;

/**
 * @author Boston Vanseghi
 */
public class PacketSyncEntityInventory implements IMessage, IMessageHandler<PacketSyncEntityInventory, PacketSyncEntityInventory> {

    private NBTTagCompound inventoryTag;
    private int entityId;

    private static final String INVENTORY_NBT_KEY = "Inventory";

    public PacketSyncEntityInventory() { /* Do Nothing */ }

    public PacketSyncEntityInventory(Entity entity, IInventory inventory) {
        this.entityId = entity.getEntityId();
        this.inventoryTag = InventoryNBTUtil.writeInventoryToNBT(INVENTORY_NBT_KEY, inventory);
    }

    @Override
    public void fromBytes(ByteBuf byteBuf) {
        this.entityId = byteBuf.readInt();
        this.inventoryTag = ByteBufUtils.readTag(byteBuf);
    }

    @Override
    public void toBytes(ByteBuf byteBuf) {
        byteBuf.writeInt(this.entityId);
        ByteBufUtils.writeTag(byteBuf, this.inventoryTag);
    }

    @Override
    public PacketSyncEntityInventory onMessage(PacketSyncEntityInventory packet, MessageContext messageContext) {
        ClientGame.instance.minecraft().addScheduledTask(() -> {
            Entity entity = ClientGame.instance.minecraft().player.world.getEntityByID(packet.entityId);

            if (entity == null || !(entity instanceof InventoryHolder)) return;

            InventoryHolder inventoryHolder = (InventoryHolder) entity;
            InventoryNBTUtil.readInventoryFromNBT(INVENTORY_NBT_KEY, packet.inventoryTag, inventoryHolder.getInventory());
        });

        return null;
    }
}
