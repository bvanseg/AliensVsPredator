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

	private World world;
	private Pos pos;
	private TileEntityTurretAmmoHelper ammoHelper;
	private TileEntityTurretTargetHelper targetHelper;
	private boolean isFiring;
	private int fireRate;
	private int timeout;
	private int timeoutMax;

	public TileEntityTurretAttackHelper(World world, TileEntityTurretAmmoHelper ammoHelper, TileEntityTurretTargetHelper targetHelper, Pos pos) {
		this.world = world;
		this.ammoHelper = ammoHelper;
		this.targetHelper = targetHelper;
		this.pos = pos;
        this.fireRate = 2;
        this.timeoutMax = 60;
	}
	
	public void update(TileEntityTurretLookHelper lookHelper) {
        this.isFiring = false;
        this.timeout = this.timeout > 0 ? this.timeout - 1 : this.timeout;

        Entity targetEntity = targetHelper.getTargetEntity();
        
        if (targetEntity != null) {
            if (this.targetHelper.canSee(targetEntity))
            {
                if (world.getTotalWorldTime() % fireRate == 0L && lookHelper.getRotation().yaw == lookHelper.getFocusRotation().yaw) {
                    if (this.ammoHelper.getCurAmmo() - 1 > 0)
                    {
                    	this.ammoHelper.setCurAmmo(this.ammoHelper.getCurAmmo() - 1);
                        this.fire();
                    }
                    else
                    {
                        this.ammoHelper.reload();
                    }
                }
            }
        }
	}

    public void fire() {
        this.isFiring = true;
        this.timeout = this.timeoutMax;
        this.targetHelper.getTargetEntity().attackEntityFrom(DamageSources.bullet, 1F);
        this.targetHelper.getTargetEntity().hurtResistantTime = 0;
        // this.world.spawnParticle(EnumParticleTypes.CLOUD, this.pos.x, this.pos.y,
        // this.pos.z, 0, 10, 0);
        Sounds.WEAPON_M56SG.playSound(this.world, this.pos.x, this.pos.y, this.pos.z, 1F, 1F);
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
