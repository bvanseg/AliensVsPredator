package org.avp.common.world.dimension.acheron;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;

public class WorldProviderAcheron extends WorldProvider
{
    @SideOnly(Side.CLIENT)
    private IRenderHandler skyProvider;

    public WorldProviderAcheron()
    {
        this.nether = false;
    }
    
    @Override
    public boolean isSurfaceWorld()
    {
        return true;
    }
    
    @Override
    protected void init()
    {
        this.hasSkyLight = true;
        this.biomeProvider = new BiomeProviderAcheron(BiomeAcheron.acheron);
        this.generateLightBrightnessTable();
    }
    
    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkProviderAcheron(this.world);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
        return skyProvider == null ? skyProvider = SkyProviderAcheron.instance : skyProvider;
    }

    @Override
    public IRenderHandler getCloudRenderer()
    {
        return skyProvider == null ? skyProvider = SkyProviderAcheron.instance : skyProvider;
    }

    @Override
    public String getSaveFolder()
    {
        return AVP.dimensions().DIMENSION_ID_ACHERON;
    }

    @Override
    public int getAverageGroundLevel()
    {
        return 16;
    }

    @Override
    public boolean canRespawnHere()
    {
        return true;
    }

    @Override
    public float getCloudHeight()
    {
        return 110.0F;
    }

    @Override
    public double getMovementFactor()
    {
        return 32.0D;
    }

    @Override
    public float getStarBrightness(float var1)
    {
        return 0.2F;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Vec3d getFogColor(float var1, float var2)
    {
        return new Vec3d(0F, 0.015F, 0.035F);
    }

    @Override
    public Vec3d getCloudColor(float partialTicks)
    {
        return new Vec3d(0F, 0F, 0F);
    }

    @Override
    public float getSunBrightness(float angle)
    {
        float celestialAngle = this.world.getCelestialAngle(angle);
        float brightness = 1.0F - (MathHelper.cos(celestialAngle * (float) Math.PI * 2.0F) * 2.0F + 0.2F);

        if (brightness < 0.0F)
        {
            brightness = 0.0F;
        }

        if (brightness > 1.0F)
        {
            brightness = 1.0F;
        }

        brightness = 1.0F - brightness;
        brightness = (float) (brightness * (1.0D - this.world.getRainStrength(angle) * 5.0F / 16.0D));
        brightness = (float) (brightness * (1.0D - this.world.getThunderStrength(angle) * 5.0F / 16.0D));
        return brightness * 0.05F;
    }
    
    @Override
    public float getSunBrightnessFactor(float par1)
    {
        return super.getSunBrightnessFactor(par1);
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }

    @Override
    public DimensionType getDimensionType()
    {
        return AVP.dimensions().ACHERON.getType();
    }
}
