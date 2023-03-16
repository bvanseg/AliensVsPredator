package org.alien.common.world.dimension.varda;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.model.texture.Texture;
import com.asx.mdx.client.world.CloudProvider;
import com.asx.mdx.common.math.MDXMath;
import net.minecraft.world.World;
import net.minecraft.world.WorldProvider;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.Resources;

public class CloudProviderVarda extends CloudProvider
{
    @SideOnly(Side.CLIENT)
    @Override
    public Texture getCloudTexture()
    {
        return Resources.instance.SKY_VARDA_CLOUDS;
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
        return -MDXMath.interpolateRotation(cloudTicksPrev, cloudTicks, ClientGame.instance.partialTicks());
    }
}
