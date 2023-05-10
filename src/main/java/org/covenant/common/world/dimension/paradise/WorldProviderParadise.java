package org.covenant.common.world.dimension.paradise;

import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.gen.IChunkGenerator;
import org.covenant.common.CovenantDimensions;

/**
 * @author Boston Vanseghi
 */
public class WorldProviderParadise extends WorldProvider {

    @Override
    public IChunkGenerator createChunkGenerator() {
        return new ChunkProviderParadise(this.world, this.getSeed(), this.world.getWorldInfo().getGeneratorOptions());
    }

    @Override
    protected void init() {
        this.hasSkyLight = true;
        this.biomeProvider = new BiomeProviderParadise(this.getSeed(), WorldType.DEFAULT);
    }

    @Override
    public DimensionType getDimensionType() {
        return CovenantDimensions.PARADISE.getType();
    }
}
