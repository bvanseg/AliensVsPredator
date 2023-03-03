package org.avp.tile.helpers;

import org.avp.DamageSources;
import org.avp.client.Sounds;

import com.asx.mdx.lib.world.Pos;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretAttackHelper {

	private TileEntityTurretAmmoHelper ammoHelper;
	private TileEntityTurretTargetHelper targetHelper;
	private boolean isFiring;
	private int fireRate;
	private int timeout;
	private int timeoutMax;

	public TileEntityTurretAttackHelper(TileEntityTurretAmmoHelper ammoHelper, TileEntityTurretTargetHelper targetHelper) {
		this.ammoHelper = ammoHelper;
		this.targetHelper = targetHelper;
        this.fireRate = 2;
        this.timeoutMax = 60;
	}
	
	public void update(World world, Pos pos, TileEntityTurretLookHelper lookHelper) {
        this.isFiring = false;
        this.timeout = this.timeout > 0 ? this.timeout - 1 : this.timeout;

        Entity targetEntity = targetHelper.getTargetEntity();
        
        if (targetEntity != null) {
            if (this.targetHelper.canSee(targetEntity, pos))
            {
            	float turretYaw = lookHelper.getRotation().yaw;
            	float focusYaw = lookHelper.getFocusRotation().yaw;
            	float minYaw = focusYaw - 1.5f;
            	float maxYaw = focusYaw + 1.5f;
            	boolean isTargetInRange = minYaw < turretYaw && turretYaw < maxYaw;
            	
                if (world.getTotalWorldTime() % fireRate == 0L && isTargetInRange) {
                    if (this.ammoHelper.getCurAmmo() - 1 > 0)
                    {
                    	this.ammoHelper.setCurrentAmmoCount(this.ammoHelper.getCurAmmo() - 1);
                        this.fire(world, pos);
                    }
                    else
                    {
                        this.ammoHelper.reload();
                    }
                }
            }
        }
	}

    public void fire(World world, Pos pos) {
        this.isFiring = true;
        this.timeout = this.timeoutMax;
        this.targetHelper.getTargetEntity().attackEntityFrom(DamageSources.bullet, 1F);
        this.targetHelper.getTargetEntity().hurtResistantTime = 0;
        // this.world.spawnParticle(EnumParticleTypes.CLOUD, this.pos.x, this.pos.y,
        // this.pos.z, 0, 10, 0);
        Sounds.WEAPON_M56SG.playSound(world, pos.x, pos.y, pos.z, 1F, 1F);
    }

    public long getFireRate()
    {
        return fireRate;
    }

    public void setFireRate(int fireRate)
    {
        this.fireRate = fireRate;
    }

    public boolean isFiring()
    {
        return isFiring;
    }
}
