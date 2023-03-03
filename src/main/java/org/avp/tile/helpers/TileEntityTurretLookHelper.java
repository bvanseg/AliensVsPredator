package org.avp.tile.helpers;

import com.asx.mdx.lib.client.util.Rotation;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;

import net.minecraft.util.math.MathHelper;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretLookHelper {
	
	private Pos pos;
    private int cycleCount;
    private Rotation rot;
    private Rotation rotPrev;
    private Pos foc;
    private Rotation focrot;
    
    public TileEntityTurretLookHelper(Pos pos) {
		this.pos = pos;
        this.cycleCount = getBaseCycleCount();
        this.rot = new Rotation(0F, 0F);
        this.rotPrev = new Rotation(0F, 0F);
        this.focrot = new Rotation(0F, 0F);
    }

    public void lookAtFocusPoint()
    {
        if (this.foc != null)
        {
            for (int runCycles = this.cycleCount; runCycles > 0; runCycles--)
            {
                if (Math.ceil(this.getRotationYaw()) < Math.ceil(this.focrot.yaw))
                {
                    this.rotPrev.yaw = this.rot.yaw;
                    this.rot.yaw += 1;
                }
                else if (Math.ceil(this.getRotationYaw()) > Math.ceil(this.focrot.yaw))
                {
                    this.rotPrev.yaw = this.rot.yaw;
                    this.rot.yaw -= 1;
                }

                if (Math.ceil(this.getRotationPitch()) < Math.ceil(this.focrot.pitch))
                {
                    this.rotPrev.pitch = this.rot.pitch;
                    this.rot.pitch += 1;
                }
                else if (Math.ceil(this.getRotationPitch()) > Math.ceil(this.focrot.pitch))
                {
                    this.rotPrev.pitch = this.rot.pitch;
                    this.rot.pitch -= 1;
                }

                double focus = 1;

                if (Math.ceil(this.getRotationPitch()) >= Math.ceil(this.focrot.pitch - focus) && Math.ceil(this.getRotationPitch()) <= Math.ceil(this.focrot.pitch + focus) && Math.ceil(this.getRotationYaw()) >= Math.ceil(this.focrot.yaw - focus) && Math.ceil(this.getRotationYaw()) <= Math.ceil(this.focrot.yaw + focus))
                {
                    this.rotPrev.pitch = this.rot.pitch;
                    this.rotPrev.yaw = this.rot.yaw;
                    this.rot.pitch = this.focrot.pitch;
                    this.rot.yaw = this.focrot.yaw;
                }
            }
        }
    }

    public Rotation turnTurretToPoint(Pos pos, Rotation rotation, float deltaYaw, float deltaPitch)
    {
        double x = pos.x - this.pos.x;
        double y = pos.y - this.pos.y;
        double z = pos.z - this.pos.z;
        double sq = MathHelper.sqrt(x * x + z * z);

        float newYaw = (float) (Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
        float f1 = (float) (-(Math.atan2(y, sq) * 180.0D / Math.PI));

        return rotation.setYaw(MDXMath.wrapAngle(this.rot.yaw, newYaw, deltaYaw)).setPitch(MDXMath.wrapAngle(this.rot.pitch, f1, deltaPitch));
    }

    private void updatePosition(double x, double y, double z) {
    	this.foc = new Pos(x, y, z);
    }

    public void setCycleCount(int count)
    {
        this.cycleCount = count;
    }

    public int getCycleCount()
    {
        return cycleCount;
    }

    public int getBaseCycleCount()
    {
        return 4;
    }

    public float getRotationYaw()
    {
        // this.getDirection() * 90F +
        return this.rot.yaw;
    }

    public float getRotationPitch()
    {
        return this.rot.pitch;
    }

    public Rotation getRotationPrev()
    {
        return rotPrev;
    }

    public Rotation getRotation()
    {
        return this.rot;
    }

    public Rotation getFocusRotation()
    {
        return this.focrot;
    }

    public Pos getFocusPosition()
    {
        return foc;
    }

	public void setFocusPosition(Pos foc) {
		this.foc = foc;
	}

	public void setFocusRotation(Rotation focrot) {
		this.focrot = focrot;
	}
}
