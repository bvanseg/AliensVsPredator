package org.power.common.tile.helper;

import com.asx.mdx.common.minecraft.Pos;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.avp.client.AVPSounds;
import org.avp.common.AVPDamageSources;
import org.avp.common.AVPNetworking;
import org.power.common.network.packet.server.PacketTurretAmmoSync;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretAttackHelper {

	private final TileEntityTurretAmmoHelper ammoHelper;
	private final TileEntityTurretLookHelper lookHelper;
	private final TileEntityTurretTargetHelper targetHelper;
	private boolean isFiring;
	private int fireRate;

	public TileEntityTurretAttackHelper(TileEntityTurretAmmoHelper ammoHelper, TileEntityTurretLookHelper lookHelper, TileEntityTurretTargetHelper targetHelper) {
		this.ammoHelper = ammoHelper;
		this.lookHelper = lookHelper;
		this.targetHelper = targetHelper;
        this.fireRate = 2;
	}
	
	public void update(World world, Pos pos) {
        Entity targetEntity = targetHelper.getTargetEntity();
        
        if (targetEntity != null) {
            if (this.targetHelper.canSee(targetEntity, pos))
            {
            	
                if (world.getTotalWorldTime() % fireRate == 0L && this.lookHelper.isLockedOn()) {
                    if (this.ammoHelper.getCurrentAmmo() > 0)
                    {
                    	this.ammoHelper.setCurrentAmmoCount(this.ammoHelper.getCurrentAmmo() - 1);
                        this.fire(world, pos);
                    }
                    else
                    {
                        this.ammoHelper.reload();
                    }
                }
            }
        } else if (this.isFiring) {
            this.isFiring = false;
            if (!world.isRemote) {
                AVPNetworking.instance.sendToAll(new PacketTurretAmmoSync(pos.blockPos(), this.ammoHelper.getCurrentAmmo()));
            }
        }
	}

    public void fire(World world, Pos pos) {
        this.isFiring = true;
        this.targetHelper.getTargetEntity().attackEntityFrom(AVPDamageSources.BULLET, 1F);
        this.targetHelper.getTargetEntity().hurtResistantTime = 0;
        // this.world.spawnParticle(EnumParticleTypes.CLOUD, this.pos.x, this.pos.y,
        // this.pos.z, 0, 10, 0);
        AVPSounds.WEAPON_M56SG.playSound(world, pos.x, pos.y, pos.z, 1F, 1F);
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
