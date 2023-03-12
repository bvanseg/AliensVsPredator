package org.avp.common.world.dimension.varda;

import org.avp.AVP;

import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.world.StormProvider;

import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class StormProviderVarda extends StormProvider
{
    @Override
    public boolean isStormApplicableTo(WorldProvider provider)
    {
        return provider instanceof WorldProviderVarda;
    }

    @Override
    public boolean isStormActive(World world)
    {
        return world.getWorldTime() > 3000 && world.getWorldTime() < 7000;
    }

    @Override
    public int getStormSize()
    {
        return 32;
    }

    @Override
    public float getStormDownfallSpeed()
    {
        return 32F;
    }

    @Override
    public float getStormWindSpeed()
    {
        return 2F;
    }

    @Override
    public float getStormDirection()
    {
        return 0;
    }

    @Override
    public boolean doesLightingApply()
    {
        return true;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public Texture getStormTexture(World world, Biome biome)
    {
        return AVP.resources().SKY_SILICA;
    }

    @Override
    public void spawnParticleOnGround(World world, double pX, double pY, double pZ)
    {
        world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, pX, pY, pZ, 0.0D, 0.1D, 1.0D, new int[0]);
    }
}
