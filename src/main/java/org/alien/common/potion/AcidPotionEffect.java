package org.alien.common.potion;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.math.MathHelper;
import org.alien.common.entity.living.SpeciesAlien;
import org.avp.common.AVPDamageSources;

/**
 * @author Boston Vanseghi
 */
public class AcidPotionEffect extends Potion {

    protected AcidPotionEffect() {
        super(true, 0xAAFF0000);
        setPotionName("effect.acid");
        setRegistryName("effect.acid");
        setIconIndex(6, 0);
    }

    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier) {
        super.performEffect(entityLivingBaseIn, amplifier);

        // Do not damage aliens.
        if (entityLivingBaseIn instanceof SpeciesAlien) return;
        if (entityLivingBaseIn.world.getTotalWorldTime() % MathHelper.clamp(20 - amplifier, 1, 20) != 0) return;

        if (entityLivingBaseIn instanceof EntityPlayer) {
            EntityPlayer entityPlayer = (EntityPlayer) entityLivingBaseIn;

            int randomArmorIndex = entityPlayer.getRNG().nextInt(4);
            ItemStack armorPiece = entityPlayer.inventory.armorInventory.get(randomArmorIndex);

            // If the player has armor equipped in the random slot, damage that.
            if (!armorPiece.isEmpty() && armorPiece != ItemStack.EMPTY && armorPiece.getItem() instanceof ItemArmor) {
                armorPiece.damageItem(1 + amplifier, entityPlayer);
            }
            // Otherwise, damage the player directly.
            else {
                entityLivingBaseIn.attackEntityFrom(AVPDamageSources.ACID, 1F + amplifier);
            }
        }
    }
}
