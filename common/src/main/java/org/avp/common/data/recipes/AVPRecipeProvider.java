package org.avp.common.data.recipes;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import org.jetbrains.annotations.NotNull;

import org.avp.common.item.AVPArmorItems;
import org.avp.common.item.AVPItems;

/**
 * @author Boston Vanseghi
 */
public class AVPRecipeProvider extends RecipeProvider {

    public AVPRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_BODY.get())
            .define('X', AVPItems.INGOT_ALUMINUM.get())
            .pattern("X X")
            .pattern("XXX")
            .pattern("XXX")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_BOOTS.get())
            .define('X', AVPItems.INGOT_ALUMINUM.get())
            .pattern("X X")
            .pattern("X X")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_HELMET.get())
            .define('X', AVPItems.INGOT_ALUMINUM.get())
            .pattern("XXX")
            .pattern("X X")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_LEGGINGS.get())
            .define('X', AVPItems.INGOT_ALUMINUM.get())
            .pattern("XXX")
            .pattern("X X")
            .pattern("X X")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
    }
}
