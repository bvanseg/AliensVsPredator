package org.predator.common.item;

import com.asx.mdx.client.render.Draw;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import org.avp.common.AVPArmorMaterials;
import org.predator.client.PredatorResources;

import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public class ItemArmorCopper extends ItemArmor {
    public ItemArmorCopper(int renderIndex, EntityEquipmentSlot armorType) {
        super(AVPArmorMaterials.COPPER, renderIndex, armorType);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type) {
        if (Objects.requireNonNull(slot) == EntityEquipmentSlot.LEGS) {
            return Draw.getPath(PredatorResources.instance.COPPER2);
        }
        return Draw.getPath(PredatorResources.instance.COPPER1);
    }
}
