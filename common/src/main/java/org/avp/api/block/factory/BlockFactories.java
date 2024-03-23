package org.avp.api.block.factory;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.WallBlock;

import java.util.function.Function;

import org.avp.api.block.TransparentBlock;
import org.avp.common.util.GameObject;

public class BlockFactories {

    public static final BlockFactory CUBE = Block::new;

    public static final BlockFactory ROTATED_PILLAR = RotatedPillarBlock::new;

    public static final BlockFactory SLAB = SlabBlock::new;

    public static final Function<GameObject<Block>, BlockFactory> STAIRS = StairBlockFactory::new;

    public static final BlockFactory TRANSPARENT = TransparentBlock::new;

    public static final BlockFactory WALL = WallBlock::new;

    private BlockFactories() {
        throw new UnsupportedOperationException();
    }
}
