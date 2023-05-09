package org.alien.common.potion;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.alien.common.item.ItemArmorXeno;
import org.avp.common.AVPDamageSources;

import java.util.Random;

/**
 * @author boston Vanseghi
 */
public class PotionEffectEventHandler {
    public static final PotionEffectEventHandler instance = new PotionEffectEventHandler();

    private PotionEffectEventHandler() {}

    @SubscribeEvent
    public void livingUpdateEvent(LivingEvent.LivingUpdateEvent event) {
        EntityLivingBase entityLivingBase = event.getEntityLiving();
        this.handleAcidEffect(entityLivingBase);
    }

    private void handleAcidEffect(EntityLivingBase entityLivingBase) {
        PotionEffect acidEffect = entityLivingBase.getActivePotionEffect(AlienPotions.ACID);
        if (acidEffect == null) return;

        int amplifier = acidEffect.getAmplifier();

        if (entityLivingBase.world.getTotalWorldTime() % MathHelper.clamp(20 - amplifier, 1, 20) != 0) return;

        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entityLivingBase;

            if (ItemArmorXeno.isPlayerWearingXenoArmorSet(entityPlayer)) {
                return;
            }

            int randomArmorIndex = entityPlayer.getRNG().nextInt(4);
            ItemStack armorPiece = entityPlayer.inventory.armorInventory.get(randomArmorIndex);

            // If the player has armor equipped in the random slot, try and damage that.
            if (!entityLivingBase.world.isRemote && !armorPiece.isEmpty() && armorPiece != ItemStack.EMPTY) {
                // The player wearing xeno armor will "soak" acid damage ticks.
                if (armorPiece.getItem() instanceof ItemArmorXeno) {
                    return;
                }

                // Normal armor is damaged significantly.
                if (armorPiece.getItem() instanceof ItemArmor) {
                    armorPiece.damageItem(10 + 10 * amplifier, entityPlayer);
                    entityLivingBase.world.playSound(null, entityLivingBase.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 0.5F, 1F);
                    return;
                }
            }
        }

        if (!entityLivingBase.world.isRemote) {
            entityLivingBase.attackEntityFrom(AVPDamageSources.ACID, 1F + amplifier);
            entityLivingBase.world.playSound(null, entityLivingBase.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 0.5F, 1F);
        } else {
            Random rand = entityLivingBase.getRNG();
            for (int i = 0; i < 10; i++) {
                entityLivingBase.world.spawnParticle(
                        EnumParticleTypes.SMOKE_NORMAL,
                        entityLivingBase.posX + rand.nextDouble(),
                        entityLivingBase.posY + rand.nextDouble(),
                        entityLivingBase.posZ + rand.nextDouble(),
                        0.0D, 0.0D, 0.0D
                );
            }
        }
    }
}
