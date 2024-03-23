package org.avp.api.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.api.block.drop.BlockDrop;
import org.avp.api.block.drop.BlockDrops;
import org.avp.api.block.factory.BlockFactories;
import org.avp.api.block.factory.BlockFactory;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class BlockData {

    public static BlockData.Builder builder(BlockBehaviour.Properties properties) {
        return new BlockData.Builder(properties);
    }

    public static BlockData simple(BlockBehaviour.Properties properties) {
        return new BlockData(GameObject.empty(), BlockFactories.CUBE, BlockDrops.SELF, properties);
    }

    private final GameObject<Block> parentBlockGameObject;

    private final BlockFactory blockFactory;

    private final BlockDrop blockDrop;

    private final BlockBehaviour.Properties properties;

    private BlockData(
        GameObject<Block> parentBlockGameObject,
        BlockFactory blockFactory,
        BlockDrop blockDrop,
        BlockBehaviour.Properties properties
    ) {
        this.parentBlockGameObject = parentBlockGameObject;
        this.blockFactory = blockFactory;
        this.blockDrop = blockDrop;
        this.properties = properties;
    }

    public Block create() {
        return blockFactory.create(properties);
    }

    public GameObject<Block> getParent() {
        return parentBlockGameObject;
    }

    public BlockDrop getDrop() {
        return blockDrop;
    }

    public BlockFactory getFactory() {
        return blockFactory;
    }

    public static class Builder {

        private GameObject<Block> parentGameObject;

        private BlockFactory blockFactory;

        private BlockDrop blockDrop;

        private final BlockBehaviour.Properties properties;

        private Builder(BlockBehaviour.Properties properties) {
            blockFactory = BlockFactories.CUBE;
            blockDrop = BlockDrops.SELF;
            this.properties = properties;
        }

        public Builder drop(BlockDrop blockDrop) {
            this.blockDrop = blockDrop;
            return this;
        }

        public Builder factory(BlockFactory blockFactory) {
            this.blockFactory = blockFactory;
            return this;
        }

        public Builder parent(GameObject<Block> parentGameObject) {
            this.parentGameObject = parentGameObject;
            return this;
        }

        public BlockData build() {
            return new BlockData(parentGameObject, blockFactory, blockDrop, properties);
        }
    }
}
