package org.predator.common.world.dimension.preserve;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IChunkGenerator;
import org.predator.common.PredatorDimensions;

/**
 * @author Boston Vanseghi
 */
public class WorldProviderPreserve extends WorldProvider {

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderPreserve(this.world, this.getSeed(), this.world.getWorldInfo().getGeneratorOptions());
    }

    @Override
    protected void init() {
        this.hasSkyLight = true;
        this.biomeProvider = new BiomeProviderPreserve(this.getSeed(), WorldType.DEFAULT);
    }

    @Override
    public DimensionType getDimensionType() {
        return PredatorDimensions.PRESERVE.getType();
    }
}
