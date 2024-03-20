package org.avp.common.data.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

import org.avp.common.item.AVPFoodItems;

/**
 * @author Boston Vanseghi
 */
public final class AVPFoodRecipes {

    public static void addFoodRecipes(RecipeOutput recipeOutput) {
        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(AVPFoodItems.RAW_TENTACLE.get()),
            RecipeCategory.FOOD,
            AVPFoodItems.TRILO_BITE.get(),
            0.35F,
            200
        )
            .unlockedBy("has_trilo_bite", AVPRecipeProvider.has(AVPFoodItems.RAW_TENTACLE.get()))
            .save(recipeOutput);
    }

    private AVPFoodRecipes() {
        throw new UnsupportedOperationException();
    }
}
