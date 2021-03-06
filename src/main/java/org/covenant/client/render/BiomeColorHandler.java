package org.covenant.client.render;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.color.IBlockColor;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.ItemBlock;
import net.minecraft.world.ColorizerGrass;
import net.minecraft.world.biome.BiomeColorHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.covenant.common.block.init.CovenantParadiseBlocks;
import org.avp.common.config.ModelConfig;

import java.util.Random;

@SideOnly(Side.CLIENT)
public class BiomeColorHandler implements IInitEvent
{
    public static final BiomeColorHandler instance  = new BiomeColorHandler();

    @SuppressWarnings("deprecation")
    private static final IItemColor       ITEMBLOCK = (stack, tintIndex) -> {
                                                        IBlockState iblockstate = ((ItemBlock) stack.getItem()).getBlock().getStateFromMeta(stack.getMetadata());
                                                        return ClientGame.instance.minecraft().getBlockColors().colorMultiplier(iblockstate, null, null, tintIndex);
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
        registerFoliageColorHandler(CovenantParadiseBlocks.PARADISE_LEAVES_SMALL);
        registerFoliageColorHandler(CovenantParadiseBlocks.PARADISE_LEAVES_MED);
        registerFoliageColorHandler(CovenantParadiseBlocks.PARADISE_LEAVES_LARGE);
    }

    public static void registerFoliageColorHandler(Block block)
    {
        ClientGame.instance.minecraft().getItemColors().registerItemColorHandler((stack, tintIndex) -> 0x228833, block);

        ClientGame.instance.minecraft().getBlockColors().registerBlockColorHandler((state, worldIn, pos, tintIndex) -> {
            if (ModelConfig.getInstance().isHalloweenEventEnabled())
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
        }, block);
    }

    public static void registerGrassColorHandler(Block block)
    {
        ClientGame.instance.minecraft().getBlockColors().registerBlockColorHandler(GRASS, block);
        ClientGame.instance.minecraft().getItemColors().registerItemColorHandler(ITEMBLOCK, block);
    }
}