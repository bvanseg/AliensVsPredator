package org.avp.world.dimension.acheron;

import org.avp.AliensVsPredator;

import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraftforge.client.IRenderHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ProviderAcheron extends WorldProvider
{
    @SideOnly(Side.CLIENT)
    private IRenderHandler skyProvider;

    public ProviderAcheron()
    {
        this.hasNoSky = false;
        this.isHellWorld = false;
    }
    
    @Override
    protected void createBiomeProvider()
    {
        this.biomeProvider = new BiomeProviderAcheron(BiomeAcheron.acheron);
    }
    
    @Override
    public IChunkGenerator createChunkGenerator()
    {
        return new ChunkProviderAcheron(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().getGeneratorOptions());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IRenderHandler getSkyRenderer()
    {
        return skyProvider == null ? skyProvider = new SkyProviderAcheron() : skyProvider;
    }

    @Override
    public IRenderHandler getCloudRenderer()
    {
        return skyProvider == null ? skyProvider = new SkyProviderAcheron() : skyProvider;
    }

    @Override
    public String getSaveFolder()
    {
        return AliensVsPredator.properties().DIMENSION_ID_ACHERON;
    }

    @Override
    public String getWelcomeMessage()
    {
        return "Enterring " + AliensVsPredator.properties().DIMENSION_NAME_ACHERON;
    }

    @Override
    public String getDepartMessage()
    {
        return "Leaving" + AliensVsPredator.properties().DIMENSION_NAME_ACHERON;
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
        return new Vec3d(0.0F, 0.0F, 0.0F);
    }

    @Override
    public Vec3d getCloudColor(float partialTicks)
    {
        return new Vec3d(0F, 0F, 0F);
    }

    @Override
    public float getSunBrightness(float angle)
    {
        float celestialAngle = this.worldObj.getCelestialAngle(angle);
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
        brightness = (float) (brightness * (1.0D - this.worldObj.getRainStrength(angle) * 5.0F / 16.0D));
        brightness = (float) (brightness * (1.0D - this.worldObj.getThunderStrength(angle) * 5.0F / 16.0D));
        return brightness * 0.25F;
    }

    @Override
    public boolean canDoRainSnowIce(Chunk chunk)
    {
        return false;
    }

    @Override
    public DimensionType getDimensionType()
    {
        return AliensVsPredator.dimensions().ACHERON.getType();
    }
}
