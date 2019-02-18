package org.avp.world.dimension.varda;

import org.avp.AliensVsPredator;

import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.client.world.CloudProvider;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.MDXMath;

import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CloudProviderVarda extends CloudProvider
{
    @SideOnly(Side.CLIENT)
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
}
