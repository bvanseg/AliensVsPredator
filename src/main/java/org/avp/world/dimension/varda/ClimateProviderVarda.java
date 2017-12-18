package org.avp.world.dimension.varda;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.Texture;
import com.arisux.mdx.lib.client.render.world.ClimateProvider;
import com.arisux.mdx.lib.client.render.world.IStormProvider;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.util.MDXMath;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;

public class ClimateProviderVarda extends ClimateProvider
{
    public StormProviderVarda stormProvider = new StormProviderVarda();
    
    @Override
    public Texture getCloudTexture()
    {
        return AliensVsPredator.resources().SKY_VARDA_CLOUDS;
    }

    @Override
    public boolean areCloudsApplicableTo(WorldProvider provider)
    {
        return provider instanceof WorldProviderVarda;
    }

    @Override
    public double getCloudMovementX(World world, float cloudTicksPrev, float cloudTicks)
    {
        return 0;
    }

    @Override
    public double getCloudMovementZ(World world, float cloudTicksPrev, float cloudTicks)
    {
        return -MDXMath.interpolateRotation(cloudTicksPrev, cloudTicks, Game.partialTicks());
    }
    
    @Override
    public void render(float partialTicks, WorldClient world, Minecraft mc)
    {
        super.render(partialTicks, world, mc);
    }
    
    @Override
    public IStormProvider getStormProvider()
    {
        return stormProvider;
    }
}
