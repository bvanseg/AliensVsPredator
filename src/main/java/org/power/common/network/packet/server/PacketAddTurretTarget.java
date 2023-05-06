package org.power.common.network.packet.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.power.common.tile.TileEntityTurret;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class PacketAddTurretTarget implements IMessage, IMessageHandler<PacketAddTurretTarget, PacketAddTurretTarget>
{
    // TODO: Move this somewhere more appropriate.
    private static final HashMap<String, EntityEntry> forgeEntityEntriesByRegistryName = new HashMap<>();

    private int    x, y, z;
    private int    size;
    private Collection<String> entityIdentifiers;

    public PacketAddTurretTarget() {}

    public PacketAddTurretTarget(int x, int y, int z, String globalID) {
        this(x, y, z, Arrays.asList(globalID));
    }
    
    public PacketAddTurretTarget(int x, int y, int z, Collection<String> globalIDs)
    {
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = globalIDs.size();
        this.entityIdentifiers = globalIDs;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.size = buf.readInt();
        this.entityIdentifiers = new ArrayList<>();
        
        
        for (int i = 0; i < this.size; i++) {
        	String identifier = ByteBufUtils.readUTF8String(buf);
        	this.entityIdentifiers.add(identifier);
        }
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeInt(size); 
        this.entityIdentifiers.forEach((e) -> ByteBufUtils.writeUTF8String(buf, e));
    }

	@Override
	public PacketAddTurretTarget onMessage(PacketAddTurretTarget packet, MessageContext ctx) {
		BlockPos tilePos = new BlockPos(packet.x, packet.y, packet.z);
		TileEntityTurret tile = (TileEntityTurret) ctx.getServerHandler().player.world.getTileEntity(tilePos);

		if (tile != null) {
			// If the forge entity entries have yet to be computed, compute them.
			if (forgeEntityEntriesByRegistryName.isEmpty()) {
				for (EntityEntry entityEntry : ForgeRegistries.ENTITIES) {
					String entityRegistryName = entityEntry.getRegistryName().toString().toLowerCase();
					forgeEntityEntriesByRegistryName.put(entityRegistryName, entityEntry);
				}
			}

			for (String identifier : packet.entityIdentifiers) {
				EntityEntry currentEntityEntry = forgeEntityEntriesByRegistryName.get(identifier.toLowerCase());

				if (currentEntityEntry != null) {
					tile.getTargetHelper().addTargetType((Class<? extends Entity>) currentEntityEntry.getEntityClass());
				}
			}
		}

		return null;
	}
}
