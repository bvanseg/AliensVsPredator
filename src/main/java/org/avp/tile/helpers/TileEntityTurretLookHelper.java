package org.avp.tile.helpers;

import com.asx.mdx.lib.client.util.Rotation;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/**
 * 
 * @author Ri5ux
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretLookHelper {
	
	private final TileEntityTurretTargetHelper targetHelper;
    private boolean isLockedOn;
    private float turretRotateSpeed;
    private Rotation turretRotation;
    private Rotation previousTurretRotation;
    private Rotation targetTurretRotation;
    public EnumFacing direction;
    
    public TileEntityTurretLookHelper(TileEntityTurretTargetHelper targetHelper) {
    	this.targetHelper = targetHelper;
        this.isLockedOn = false;
        this.turretRotateSpeed = 100f;
        this.turretRotation = new Rotation(0F, 0F);
        this.previousTurretRotation = new Rotation(0F, 0F);
        this.targetTurretRotation = new Rotation(0F, 0F);
    }
    
    public void update(Pos pos) {
    	Entity targetEntity = this.targetHelper.getTargetEntity();
    	
		if (targetEntity != null) {
    		this.setFocusRotation(this.turnTurretToPoint(pos, targetEntity.getPositionVector(), 360F, 90F));
    		this.rotateTurret();
		}
    }

    public void rotateTurret()
    {
    	this.previousTurretRotation = new Rotation(this.turretRotation.yaw, this.turretRotation.pitch);

    	this.updateTurretYawLerp();
    	this.updateTurretPitchLerp();
    	
    	float turretYaw = turretRotation.yaw;
    	float turretPitch = turretRotation.pitch;
    	float focusYaw = targetTurretRotation.yaw;
    	float focusPitch = targetTurretRotation.pitch;
    	boolean isTargetInRange = turretYaw == focusYaw && turretPitch == focusPitch;
    	
        if (isTargetInRange) {
        	this.isLockedOn = true;
            this.previousTurretRotation.pitch = this.turretRotation.pitch;
            this.previousTurretRotation.yaw = this.turretRotation.yaw;
            this.turretRotation.pitch = this.targetTurretRotation.pitch;
            this.turretRotation.yaw = this.targetTurretRotation.yaw;
        }
    }
    
    private float lerp(float pointA, float pointB, float percentage) {
        return (pointA * (1.0f - percentage)) + (pointB * percentage);
    }
    
    private void updateTurretYawLerp() {
    	float yawDeltaLeft = (this.targetTurretRotation.yaw - this.turretRotation.yaw);
    	float yawDeltaRight = (this.turretRotation.yaw - this.targetTurretRotation.yaw);
    	float yawDeltaLeftNormalized = yawDeltaLeft < 0 ? yawDeltaLeft + 360 : yawDeltaLeft;
    	float yawDeltaRightNormalized = yawDeltaRight < 0 ? yawDeltaRight + 360 : yawDeltaRight;
    	
    	float yawScaleFactor = (yawDeltaLeftNormalized < yawDeltaRightNormalized ? yawDeltaLeft : yawDeltaRight) / this.turretRotateSpeed;
    	float yawLerpValue = lerp(this.turretRotation.yaw, this.targetTurretRotation.yaw, 0.1f / (yawScaleFactor + 0.1f)) - this.turretRotation.yaw;
    	
    	this.turretRotation.yaw += yawLerpValue;
    }
    
    private void updateTurretPitchLerp() {
    	float pitchDeltaLeft = (this.targetTurretRotation.pitch - this.turretRotation.pitch);
    	float pitchDeltaRight = (this.turretRotation.pitch - this.targetTurretRotation.pitch);
    	float pitchDeltaLeftNormalized = pitchDeltaLeft < 0 ? pitchDeltaLeft + 360 : pitchDeltaLeft;
    	float pitchDeltaRightNormalized = pitchDeltaRight < 0 ? pitchDeltaRight + 360 : pitchDeltaRight;
    	
    	float pitchScaleFactor = (pitchDeltaLeftNormalized < pitchDeltaRightNormalized ? pitchDeltaLeft : pitchDeltaRight) / this.turretRotateSpeed;
    	float pitchLerpValue = lerp(this.turretRotation.pitch, this.targetTurretRotation.pitch, 0.1f / (pitchScaleFactor + 0.1f)) - this.turretRotation.pitch;
    	
    	this.turretRotation.pitch += pitchLerpValue;
    }

    public Rotation turnTurretToPoint(Pos turretPos, Vec3d targetPos, float deltaYaw, float deltaPitch)
    {
        double x = targetPos.x - turretPos.x - 0.5;
        double y = targetPos.y - turretPos.y;
        double z = targetPos.z - turretPos.z - 0.25;
        double sq = MathHelper.sqrt(x * x + z * z);

        float newYaw = (float) (Math.atan2(z, x) * 180.0D / Math.PI) - 90.0F;
        float f1 = (float) (-(Math.atan2(y, sq) * 180.0D / Math.PI));

        float yaw = MDXMath.wrapAngle(this.turretRotation.yaw, newYaw, deltaYaw);
        float pitch = MDXMath.wrapAngle(this.turretRotation.pitch, f1, deltaPitch);
        return new Rotation(yaw, pitch);
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

	public void setPreviousTurretRotation(Rotation rotation) {
		this.previousTurretRotation = rotation;
	}

	public void setTurretRotation(Rotation rotation) {
		this.turretRotation = rotation;
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
	
	public float getTurretRotateSpeed() {
		return this.turretRotateSpeed;
	}
	
	public void setTurretRotateSpeed(float turretRotateSpeed) {
		this.turretRotateSpeed = turretRotateSpeed;
	}

    public EnumFacing getRotationYAxis()
    {
        return this.direction;
    }

    public void setRotationYAxis(EnumFacing facing)
    {
        this.direction = facing;
    }
	
    public void readFromNBT(NBTTagCompound nbt)
    {
    	float yaw = nbt.getFloat("Yaw");
    	float pitch = nbt.getFloat("Pitch");
    	// TODO: Eventually use one instance here, not doing so yet because of mutability issues.
    	this.setPreviousTurretRotation(new Rotation(yaw, pitch));
    	this.setTurretRotation(new Rotation(yaw, pitch));
    	this.setFocusRotation(new Rotation(yaw, pitch));

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
    	Rotation turretRotation = this.getRotation();
    	
    	nbt.setFloat("Yaw", turretRotation.yaw);
    	nbt.setFloat("Pitch", turretRotation.pitch);

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }
        
        return nbt;
    }
}
