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
	private TileEntityTurretLookHelper lookHelper;
	private TileEntityTurretTargetHelper targetHelper;
	private boolean isFiring;
	private int fireRate;

	public TileEntityTurretAttackHelper(TileEntityTurretAmmoHelper ammoHelper, TileEntityTurretLookHelper lookHelper, TileEntityTurretTargetHelper targetHelper) {
		this.ammoHelper = ammoHelper;
		this.lookHelper = lookHelper;
		this.targetHelper = targetHelper;
        this.fireRate = 2;
	}
	
	public void update(World world, Pos pos, TileEntityTurretLookHelper lookHelper) {
        this.isFiring = false;

        Entity targetEntity = targetHelper.getTargetEntity();
        
        if (targetEntity != null) {
            if (this.targetHelper.canSee(targetEntity, pos))
            {
            	
                if (world.getTotalWorldTime() % fireRate == 0L && this.lookHelper.isLockedOn()) {
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
