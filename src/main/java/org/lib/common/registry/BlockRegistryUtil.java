package org.lib.common.registry;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.common.AVPCreativeTabs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class BlockRegistryUtil
{
    private static final HashMap<Block, ItemBlock> ITEM_BLOCKS = new HashMap<>();

    private static final ArrayList<BlockFluidBase> FLUIDS = new ArrayList<>();

    private BlockRegistryUtil() {}

    public static void registerBlock(Block block) {
        if (block.getCreativeTab() == null)
            block.setCreativeTab(AVPCreativeTabs.BLOCKS);

        // Register block
        block.setTranslationKey(block.getRegistryName().getNamespace() + ":" + block.getRegistryName().getPath());
        ForgeRegistries.BLOCKS.register(block);

        // Register fluid
        if (block instanceof BlockFluidBase) {
            BlockRegistryUtil.registerFluid(block);
        }
    }

    public static void registerItemBlock(Block block) {
        BlockRegistryUtil.registerItemBlock(block, new ItemBlock(block));
    }

    public static void registerItemBlock(Block block, ItemBlock itemblock) {
        itemblock.setRegistryName(block.getRegistryName());
        itemblock.setTranslationKey(itemblock.getRegistryName().toString());

        ITEM_BLOCKS.put(block, itemblock);

        registerModel(itemblock);

        // Register item block
        ForgeRegistries.ITEMS.register(itemblock);
        registerModel(itemblock);

        // Set up creative tab.
        BlockRegistryUtil.setCreativeTab(block, itemblock);
    }

    private static void registerFluid(Block block) {
        BlockFluidBase fluid = (BlockFluidBase) block;
        FLUIDS.add(fluid);
    }

    private static void setCreativeTab(Block block, ItemBlock itemblock) {
        CreativeTabs creativeTab = block.getCreativeTab() != null ? block.getCreativeTab() : AVPCreativeTabs.BLOCKS;
        itemblock.setCreativeTab(creativeTab);
    }

    public static Block createFluidBlock(Fluid fluid, Class<? extends BlockFluidBase> c, String registryName)
    {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);

        try
        {
            Object o = c.getConstructor().newInstance();

            if (o instanceof BlockFluidBase)
            {
                return ((BlockFluidBase) o).setRegistryName(registryName);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private static void registerModel(ItemBlock item)
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            ModelResourceLocation modelResource = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelResource);
        }

    }

    public static ItemBlock getItemFromBlock(Block block)
    {
        return BlockRegistryUtil.ITEM_BLOCKS.get(block);
    }

    public static List<BlockFluidBase> getFluids()
    {
        return BlockRegistryUtil.FLUIDS;
    }
}
