package org.avp.common.data.recipes;

import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;

import org.avp.common.item.AVPItems;

/**
 * @author Boston Vanseghi
 */
public final class AVPMaterialsRecipes {

    public static void addMaterialRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AVPItems.CARBON.get(), 8)
            .define('A', ItemTags.COALS)
            .pattern("AA")
            .pattern("AA")
            .unlockedBy("has_coal", AVPRecipeProvider.has(ItemTags.COALS))
            .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, AVPItems.POLYCARBONATE.get(), 4)
            .define('A', AVPItems.SILICA.get())
            .define('B', AVPItems.CARBON.get())
            .pattern("AAA")
            .pattern("BBB")
            .pattern("BBB")
            .unlockedBy("has_carbon", AVPRecipeProvider.has(AVPItems.CARBON.get()))
            .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, AVPItems.NEODYMIUM_MAGNET.get(), 4)
            .requires(AVPItems.NEODYMIUM.get())
            .requires(AVPItems.COBALT.get(), 2)
            .unlockedBy("has_cobalt", AVPRecipeProvider.has(AVPItems.COBALT.get()))
            .save(recipeOutput);
    }

    private AVPMaterialsRecipes() {
        throw new UnsupportedOperationException();
    }
}
