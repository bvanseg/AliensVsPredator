package org.alien.common.world.dimension.varda;

import com.asx.mdx.lib.client.world.IClimateProvider;
import com.asx.mdx.lib.client.world.ICloudProvider;
import com.asx.mdx.lib.client.world.IStormProvider;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;

public class WorldProviderVarda extends WorldProvider implements IClimateProvider
{
    private StormProviderVarda storm = new StormProviderVarda();
    private CloudProviderVarda clouds = new CloudProviderVarda();
    private SkyProviderVarda sky;
    
    @Override
    public IStormProvider getStormProvider()
    {
        return storm;
    }
    
    @Override
    public ICloudProvider getCloudProvider()
    {
        return clouds;
    }
    

    public WorldProviderVarda()
    {
        this.nether = false;
    }
    
    @Override
    public boolean isSurfaceWorld()
    {
        return true;
    }
    
    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkProviderVarda(this.world);
    }

    @Override
    protected void init()
    {
        this.hasSkyLight = true;
        this.biomeProvider = new BiomeProviderVarda(this.getSeed(), WorldType.DEFAULT);
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
        return sky == null ? sky = new SkyProviderVarda() : sky;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getCloudRenderer()
    {
        return (CloudProviderVarda) getCloudProvider();
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getWeatherRenderer()
    {
        return null;
    }

    @Override
    public String getSaveFolder()
    {
        return AVP.dimensions().DIMENSION_ID_VARDA;
    }
    
    @Override
    public void updateWeather()
    {
        super.updateWeather();
    }
    
    @Override
    public int getAverageGroundLevel()
    {
        return 110;
    }
    
    @Override
    public boolean canRespawnHere()
    {
        return false;
    }

    @Override
    public float getCloudHeight()
    {
        return 140.0F;
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
        return new Vec3d(0.0F, 0.0F, 0.01F);
    }
    
    @Override
    public Vec3d getCloudColor(float partialTicks)
    {
        return new Vec3d(0.075F, 0.1F, 0.15F);
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
        return brightness * 0.45F;
    }

    @Override
    public boolean canSnowAt(BlockPos pos, boolean checkLight)
    {
        return false;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }

    @Override
    public DimensionType getDimensionType()
    {
        return AVP.dimensions().VARDA.getType();
    }
}
