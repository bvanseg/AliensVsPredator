package org.avp.world.fluids;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.FillBucketEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class BucketHandlingEvent
{
    public static BucketHandlingEvent instance = new BucketHandlingEvent();
    public Map<Block, Item>           buckets  = new HashMap<Block, Item>();

    private BucketHandlingEvent()
    {
        ;
    }

    @SubscribeEvent
    public void onBucketFill(FillBucketEvent event)
    {
        ItemStack bucket = fillCustomBucket(event.getWorld(), event.getTarget());

        if (bucket == null)
        {
            return;
        }

        event.setFilledBucket(bucket);
        event.setResult(Result.ALLOW);
    }

    private ItemStack fillCustomBucket(World world, RayTraceResult result)
    {
        if (result != null && result.getBlockPos() != null && world != null)
        {
            Block block = world.getBlockState(result.getBlockPos()).getBlock();
            Item bucket = buckets.get(block);

            if (bucket != null)
            {
                world.setBlockToAir(result.getBlockPos());
                return new ItemStack(bucket);
            }
        }

        return null;
    }
}
