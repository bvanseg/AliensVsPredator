package org.avp.tile.helpers;

import com.asx.mdx.lib.client.util.Rotation;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

/**
 * 
 * @author Ri5ux
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretLookHelper {
	
	private TileEntityTurretTargetHelper targetHelper;
    private int cycleCount;
    private boolean isLockedOn;
    private Rotation turretRotation;
    private Rotation previousTurretRotation;
    private Rotation targetTurretRotation;
    
    public TileEntityTurretLookHelper(TileEntityTurretTargetHelper targetHelper) {
    	this.targetHelper = targetHelper;
        this.cycleCount = getBaseCycleCount();
        this.isLockedOn = false;
        this.turretRotation = new Rotation(0F, 0F);
        this.previousTurretRotation = new Rotation(0F, 0F);
        this.targetTurretRotation = new Rotation(0F, 0F);
    }
    
    public void update(Pos pos) {
    	Entity targetEntity = this.targetHelper.getTargetEntity();
    	
		this.rotateTurret();
		
		if (targetEntity != null) {
    		this.setFocusRotation(this.turnTurretToPoint(pos, targetEntity.getPosition(), 360F, 90F));
    		this.tryLockOnToTarget();
		}
    }

    public void rotateTurret()
    {
    	if (Math.ceil(this.getRotationYaw()) < Math.ceil(this.targetTurretRotation.yaw))
        {
            this.previousTurretRotation.yaw = this.turretRotation.yaw;
            this.turretRotation.yaw += this.cycleCount;
        }
        else if (Math.ceil(this.getRotationYaw()) > Math.ceil(this.targetTurretRotation.yaw))
        {
            this.previousTurretRotation.yaw = this.turretRotation.yaw;
            this.turretRotation.yaw -= this.cycleCount;
        }

        if (Math.ceil(this.getRotationPitch()) < Math.ceil(this.targetTurretRotation.pitch))
        {
            this.previousTurretRotation.pitch = this.turretRotation.pitch;
            this.turretRotation.pitch += this.cycleCount;
        }
        else if (Math.ceil(this.getRotationPitch()) > Math.ceil(this.targetTurretRotation.pitch))
        {
            this.previousTurretRotation.pitch = this.turretRotation.pitch;
            this.turretRotation.pitch -= this.cycleCount;
        }
    }
    
    public void tryLockOnToTarget() {
    	float turretYaw = turretRotation.yaw;
    	float focusYaw = targetTurretRotation.yaw;
    	float minYaw = focusYaw - this.cycleCount;
    	float maxYaw = focusYaw + this.cycleCount;
    	boolean isTargetInRange = minYaw < turretYaw && turretYaw < maxYaw;
    	
        if (isTargetInRange) {
        	this.isLockedOn = true;
            this.previousTurretRotation.pitch = this.turretRotation.pitch;
            this.previousTurretRotation.yaw = this.turretRotation.yaw;
            this.turretRotation.pitch = this.targetTurretRotation.pitch;
            this.turretRotation.yaw = this.targetTurretRotation.yaw;
        }
    }

    public Rotation turnTurretToPoint(Pos turretPos, BlockPos targetPos, float deltaYaw, float deltaPitch)
    {
        double x = targetPos.getX() - turretPos.x;
        double y = targetPos.getY() - turretPos.y;
        double z = targetPos.getZ() - turretPos.z;
        double sq = MathHelper.sqrt(x * x + z * z);

        float newYaw = (float) (Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
        float f1 = (float) (-(Math.atan2(y, sq) * 180.0D / Math.PI));

        float yaw = MDXMath.wrapAngle(this.turretRotation.yaw, newYaw, deltaYaw);
        float pitch = MDXMath.wrapAngle(this.turretRotation.pitch, f1, deltaPitch);
        return new Rotation(yaw, pitch);
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

	public void setFocusRotation(Rotation focrot) {
		this.targetTurretRotation = focrot;
	}
	
	public boolean isLockedOn() {
		return this.isLockedOn;
	}

	public void setLockedOn(boolean isLockedOn) {
		this.isLockedOn = isLockedOn;
	}
}
