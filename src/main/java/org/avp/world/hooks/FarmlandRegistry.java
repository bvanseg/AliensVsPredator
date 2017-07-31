package org.avp.world.hooks;

import java.util.ArrayList;

import org.avp.AliensVsPredator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.UseHoeEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class FarmlandRegistry
{
    public static FarmlandRegistry instance = new FarmlandRegistry();
    private ArrayList<Block> farmlandRegistry = new ArrayList<Block>();

    private FarmlandRegistry()
    {
        this.farmlandRegistry.add(Blocks.DIRT);
        this.farmlandRegistry.add(Blocks.GRASS);
        this.farmlandRegistry.add(AliensVsPredator.blocks().unidirt);
    }
    
    @SubscribeEvent
    public void onUseHoe(UseHoeEvent event)
    {
        Block block = event.getWorld().getBlockState(event.getPos()).getBlock();
        BlockPos posUp = event.getPos().add(0, 1, 0);
        IBlockState up = event.getWorld().getBlockState(posUp);

        if (up.getBlock().isAir(up, event.getWorld(), posUp) && (farmlandRegistry.contains(block)))
        {
            Block farmland = Blocks.FARMLAND;
            event.getWorld().playSound(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), farmland.getSoundType().getStepSound(), SoundCategory.BLOCKS, (farmland.getSoundType().getVolume() + 1.0F) / 2.0F, farmland.getSoundType().getPitch() * 0.8F, false);

            if (event.getWorld().isRemote)
            {
                event.setResult(Result.ALLOW);
            }
            else
            {
                event.getWorld().setBlockState(event.getPos(), farmland.getDefaultState());
                event.getCurrent().damageItem(1, event.getEntityPlayer());
                event.setResult(Result.ALLOW);
            }
        }
        else
        {
            event.setResult(Result.DENY);
        }
    }
}
