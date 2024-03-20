package org.avp.common.data.recipes;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class AVPRecipeProvider extends RecipeProvider {

    public AVPRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        AVPArmorRecipes.addArmorRecipes(recipeOutput);
        AVPFoodRecipes.addFoodRecipes(recipeOutput);
        AVPElectronicRecipes.addElectronicRecipes(recipeOutput);
    }

    public static @NotNull Criterion<InventoryChangeTrigger.TriggerInstance> has(@NotNull ItemLike itemLike) {
        return RecipeProvider.has(itemLike);
    }
}
