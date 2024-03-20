package org.avp.common.data.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;

import org.avp.common.item.AVPElectronicItems;
import org.avp.common.item.AVPItems;
import org.avp.common.item.AVPWeaponItems;

/**
 * @author Boston Vanseghi
 */
public final class AVPAmmoRecipes {

    public static void addAmmoRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPWeaponItems.AMMO_AR.get())
            .define('A', Items.IRON_INGOT)
            .define('B', AVPItems.INGOT_ALUMINUM.get())
            .define('C', Items.GUNPOWDER)
            .define('D', Items.COPPER_INGOT)
            .pattern(" A ")
            .pattern("BCB")
            .pattern("BDB")
            .unlockedBy("has_aluminum", AVPRecipeProvider.has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPWeaponItems.AMMO_CHARGE_PACK.get())
            .define('A', Items.GOLD_NUGGET)
            .define('B', AVPElectronicItems.CAPACITOR.get())
            .define('C', AVPElectronicItems.RESISTOR.get())
            .define('D', AVPItems.POLYCARBONATE.get())
            .define('E', AVPItems.INGOT_LITHIUM.get())
            .pattern("AAA")
            .pattern("BCB")
            .pattern("DED")
            .unlockedBy("has_capacitor", AVPRecipeProvider.has(AVPElectronicItems.CAPACITOR.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPWeaponItems.AMMO_FLAMETHROWER.get())
            .define('A', Items.SLIME_BALL)
            .define('B', AVPItems.INGOT_ALUMINUM.get())
            .define('C', Items.BLAZE_POWDER)
            .define('D', AVPItems.POLYCARBONATE.get())
            .pattern("DAD")
            .pattern("BCB")
            .pattern("BBB")
            .unlockedBy("has_blaze_powder", AVPRecipeProvider.has(Items.BLAZE_POWDER))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPWeaponItems.AMMO_PISTOL.get())
            .define('A', Items.COPPER_INGOT)
            .define('B', AVPItems.INGOT_ALUMINUM.get())
            .define('C', Items.GUNPOWDER)
            .pattern(" A ")
            .pattern("BCB")
            .pattern("BCB")
            .unlockedBy("has_gunpowder", AVPRecipeProvider.has(Items.GUNPOWDER))
            .save(recipeOutput);
    }

    private AVPAmmoRecipes() {
        throw new UnsupportedOperationException();
    }
}
