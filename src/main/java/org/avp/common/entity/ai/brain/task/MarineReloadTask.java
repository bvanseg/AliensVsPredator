package org.avp.common.entity.ai.brain.task;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import org.avp.client.AVPSounds;
import org.avp.common.AVPNetworking;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.network.packet.client.PacketSyncEntityInventory;
import org.lib.brain.impl.AbstractEntityBrainTask;
import org.lib.common.inventory.InventorySnapshot;
import org.weapon.common.item.firearm.rework.FirearmProperties;

import java.util.Optional;

/**
 * @author Boston Vanseghi
 */
public class MarineReloadTask extends AbstractEntityBrainTask {

    private int reloadTimer;

    @Override
    protected boolean shouldExecute() {
        if (!(ctx.getEntity() instanceof EntityMarine)) return false;
        EntityMarine marine = (EntityMarine) ctx.getEntity();

        return !marine.hasLoadedAmmunition() && this.reloadTimer <= 0 && this.hasReloadItem();
    }

    @Override
    protected boolean shouldContinueExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        return !marine.hasLoadedAmmunition() && this.reloadTimer >= 0;
    }

    @Override
    protected void startExecuting() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        FirearmProperties firearmProperties = marine.getMarineType().getFirearmItem().getFirearmProperties();
        int reloadTimerForWeapon = firearmProperties.getReloadTimeInTicks();

        InventorySnapshot inventorySnapshot = marine.getInventorySnapshot();

        // These should be guaranteed to exist based on shouldExecute conditions.
        Item reloadItem = this.getReloadItem().get();
        ItemStack reloadItemStack = inventorySnapshot.getFirstNonEmptyStack(reloadItem);

        if (this.reloadTimer == 0) {
            ctx.getEntity().world.playSound(null, ctx.getEntity().getPosition(), AVPSounds.WEAPON_RELOAD.event(), SoundCategory.NEUTRAL, 1F, 1F);
            marine.setHeldItem(EnumHand.OFF_HAND, reloadItemStack);
        }

        if (this.reloadTimer++ >= reloadTimerForWeapon) {
                inventorySnapshot.consumeItem(reloadItem, 1);
                marine.setLoadedAmmunition(firearmProperties.getMaxAmmunition());

                // Sync inventory edit to clients.
                AVPNetworking.instance.sendToAll(new PacketSyncEntityInventory(marine, marine.getInventory()));

                marine.setHeldItem(EnumHand.OFF_HAND, ItemStack.EMPTY);
        }
    }

    private Optional<Item> getReloadItem() {
        EntityMarine marine = (EntityMarine) ctx.getEntity();
        FirearmProperties firearmProperties = marine.getMarineType().getFirearmItem().getFirearmProperties();
        InventorySnapshot inventorySnapshot = marine.getInventorySnapshot();
        return inventorySnapshot.getItemsMatchingPredicate(item -> firearmProperties.getConsumablesForReload().contains(item)).stream().findFirst();
    }

    private boolean hasReloadItem() {
        return this.getReloadItem().isPresent();
    }

    @Override
    public void finish() {
        super.finish();
        this.reloadTimer = 0;
    }
}
