package org.avp.common.data.recipes;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.avp.common.block.AVPIndustrialBlocks;
import org.avp.common.item.AVPArmorItems;
import org.avp.common.item.AVPItems;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class AVPArmorRecipeProvider extends RecipeProvider {

    public AVPArmorRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    public void buildRecipes(@NotNull RecipeOutput recipeOutput) {
        addAluminumArmorRecipes(recipeOutput);
        addMK50ArmorRecipes(recipeOutput);
        addPressureArmorRecipes(recipeOutput);
        addTacticalArmorRecipes(recipeOutput);
    }

    private void addAluminumArmorRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_BODY.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_BOOTS.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .pattern("A A")
            .pattern("A A")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_HELMET.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .pattern("AAA")
            .pattern("A A")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.ALUMINUM_LEGGINGS.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
    }

    private void addMK50ArmorRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.MK50_BODY.get())
            .define('A', Items.COPPER_INGOT)
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .pattern("B B")
            .pattern("ABA")
            .pattern("BAB")
            .unlockedBy("has_copper", has(Items.COPPER_INGOT))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.MK50_BOOTS.get())
            .define('A', Items.COPPER_INGOT)
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .pattern("B B")
            .pattern("A A")
            .unlockedBy("has_copper", has(Items.COPPER_INGOT))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.MK50_HELMET.get())
            .define('A', Items.COPPER_INGOT)
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .define('C', AVPItems.CARBON.get())
            .define('D', AVPItems.SILICA.get())
            .pattern("AAA")
            .pattern("B B")
            .pattern("DCD")
            .unlockedBy("has_copper", has(Items.COPPER_INGOT))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.MK50_LEGGINGS.get())
            .define('A', Items.COPPER_INGOT)
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .pattern("BAB")
            .pattern("B B")
            .pattern("A A")
            .unlockedBy("has_copper", has(Items.COPPER_INGOT))
            .save(recipeOutput);
    }

    private void addPressureArmorRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.PRESSURE_BODY.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .pattern("B B")
            .pattern("ABA")
            .pattern("BAB")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.PRESSURE_BOOTS.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .pattern("B B")
            .pattern("A A")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.PRESSURE_HELMET.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .define('C', AVPItems.CARBON.get())
            .define('D', AVPItems.SILICA.get())
            .pattern("AAA")
            .pattern("B B")
            .pattern("DCD")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.PRESSURE_LEGGINGS.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .define('B', AVPIndustrialBlocks.INDUSTRIAL_GLASS.get())
            .pattern("BAB")
            .pattern("B B")
            .pattern("A A")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
    }

    private void addTacticalArmorRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.TACTICAL_BODY.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .define('B', ItemTags.WOOL)
            .pattern("B B")
            .pattern("ABA")
            .pattern("BAB")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.TACTICAL_BOOTS.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .define('B', ItemTags.WOOL)
            .pattern("B B")
            .pattern("A A")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, AVPArmorItems.TACTICAL_LEGGINGS.get())
            .define('A', AVPItems.INGOT_ALUMINUM.get())
            .define('B', ItemTags.WOOL)
            .pattern("BAB")
            .pattern("B B")
            .pattern("A A")
            .unlockedBy("has_aluminum", has(AVPItems.INGOT_ALUMINUM.get()))
            .save(recipeOutput);
    }
}
