package org.avp.client.render;

import java.util.Random;

import javax.annotation.Nullable;

import org.avp.AliensVsPredator;
import org.avp.common.AVPBlocks;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.lib.util.Game;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class BiomeColorHandler implements IInitEvent
{
    public static final BiomeColorHandler instance  = new BiomeColorHandler();

    @SuppressWarnings("deprecation")
    private static final IItemColor       ITEMBLOCK = (stack, tintIndex) -> {
                                                        IBlockState iblockstate = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                                                        return Game.minecraft().getBlockColors().colorMultiplier(iblockstate, null, null, tintIndex);
                                                    };

    private static final IBlockColor      GRASS     = (state, blockAccess, pos, tintIndex) -> {
                                                        if (blockAccess != null && pos != null)
                                                        {
                                                            return BiomeColorHelper.getGrassColorAtPos(blockAccess, pos);
                                                        }

                                                        return ColorizerGrass.getGrassColor(0.5D, 1.0D);
                                                    };

    @Override
    public void init(FMLInitializationEvent event)
    {
        registerFoliageColorHandler(AVPBlocks.PARADISE_LEAVES_SMALL);
        registerFoliageColorHandler(AVPBlocks.PARADISE_LEAVES_MED);
        registerFoliageColorHandler(AVPBlocks.PARADISE_LEAVES_LARGE);
    }

    public static void registerFoliageColorHandler(Block block)
    {
        Game.minecraft().getItemColors().registerItemColorHandler(new IItemColor() {
            @Override
            public int colorMultiplier(ItemStack stack, int tintIndex)
            {
                return 0x228833;
            }
        }, block);

        Game.minecraft().getBlockColors().registerBlockColorHandler(new IBlockColor() {
            public int colorMultiplier(IBlockState state, @Nullable IBlockAccess worldIn, @Nullable BlockPos pos, int tintIndex)
            {
                if (AliensVsPredator.settings().isHalloweenEventEnabled())
                {
                    switch (new Random(pos.getX() + pos.getY() + pos.getZ()).nextInt(5))
                    {
                        case 1:
                            return 0xF1CC0C; //Yellow
                        case 2:
                            return 0xF08C00; //Orange
                        case 3:
                            return 0xAA1111; //Red

                        default:
                            return 0xAA6644; //Brown
                    }
                }

                return 0x228833; //Default
            }
        }, block);
    }

    public static void registerGrassColorHandler(Block block)
    {
        Game.minecraft().getBlockColors().registerBlockColorHandler(GRASS, block);
        Game.minecraft().getItemColors().registerItemColorHandler(ITEMBLOCK, block);
    }
}