package org.avp.tile.helpers;

import com.asx.mdx.lib.client.util.Rotation;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * 
 * @author Ri5ux
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretLookHelper {
	
	private TileEntityTurretTargetHelper targetHelper;
	private Pos pos;
    private int cycleCount;
    private Rotation turretRotation;
    private Rotation previousTurretRotation;
    private Pos targetEntityPosition;
    private Rotation targetTurretRotation;
    
    public TileEntityTurretLookHelper(TileEntityTurretTargetHelper targetHelper, Pos pos) {
    	this.targetHelper = targetHelper;
		this.pos = pos;
        this.cycleCount = getBaseCycleCount();
        this.turretRotation = new Rotation(0F, 0F);
        this.previousTurretRotation = new Rotation(0F, 0F);
        this.targetTurretRotation = new Rotation(0F, 0F);
    }
    
    public void update() {
    	Entity targetEntity = this.targetHelper.getTargetEntity();

        this.lookAtFocusPoint();
    	
    	if (targetEntity != null) {
            this.updatePosition(targetEntity.posX, targetEntity.posY, targetEntity.posZ);
            this.setFocusRotation(this.turnTurretToPoint(this.getFocusPosition(), this.getFocusRotation(), 360F, 90F));
    	}

    }

    public void lookAtFocusPoint()
    {
        if (this.targetEntityPosition != null)
        {
            for (int runCycles = this.cycleCount; runCycles > 0; runCycles--)
            {
                if (Math.ceil(this.getRotationYaw()) < Math.ceil(this.targetTurretRotation.yaw))
                {
                    this.previousTurretRotation.yaw = this.turretRotation.yaw;
                    this.turretRotation.yaw += 1;
                }
                else if (Math.ceil(this.getRotationYaw()) > Math.ceil(this.targetTurretRotation.yaw))
                {
                    this.previousTurretRotation.yaw = this.turretRotation.yaw;
                    this.turretRotation.yaw -= 1;
                }

                if (Math.ceil(this.getRotationPitch()) < Math.ceil(this.targetTurretRotation.pitch))
                {
                    this.previousTurretRotation.pitch = this.turretRotation.pitch;
                    this.turretRotation.pitch += 1;
                }
                else if (Math.ceil(this.getRotationPitch()) > Math.ceil(this.targetTurretRotation.pitch))
                {
                    this.previousTurretRotation.pitch = this.turretRotation.pitch;
                    this.turretRotation.pitch -= 1;
                }

                double focus = 1;

                if (Math.ceil(this.getRotationPitch()) >= Math.ceil(this.targetTurretRotation.pitch - focus) && Math.ceil(this.getRotationPitch()) <= Math.ceil(this.targetTurretRotation.pitch + focus) && Math.ceil(this.getRotationYaw()) >= Math.ceil(this.targetTurretRotation.yaw - focus) && Math.ceil(this.getRotationYaw()) <= Math.ceil(this.targetTurretRotation.yaw + focus))
                {
                    this.previousTurretRotation.pitch = this.turretRotation.pitch;
                    this.previousTurretRotation.yaw = this.turretRotation.yaw;
                    this.turretRotation.pitch = this.targetTurretRotation.pitch;
                    this.turretRotation.yaw = this.targetTurretRotation.yaw;
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

        return rotation.setYaw(MDXMath.wrapAngle(this.turretRotation.yaw, newYaw, deltaYaw)).setPitch(MDXMath.wrapAngle(this.turretRotation.pitch, f1, deltaPitch));
    }

    public void updatePosition(double x, double y, double z) {
    	this.targetEntityPosition = new Pos(x, y, z);
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
        return this.turretRotation.yaw;
    }

    public float getRotationPitch()
    {
        return this.turretRotation.pitch;
    }

    public Rotation getRotationPrev()
    {
        return previousTurretRotation;
    }

    public Rotation getRotation()
    {
        return this.turretRotation;
    }

    public Rotation getFocusRotation()
    {
        return this.targetTurretRotation;
    }

    public Pos getFocusPosition()
    {
        return targetEntityPosition;
    }

	public void setFocusPosition(Pos foc) {
		this.targetEntityPosition = foc;
	}

	public void setFocusRotation(Rotation focrot) {
		this.targetTurretRotation = focrot;
	}
}
