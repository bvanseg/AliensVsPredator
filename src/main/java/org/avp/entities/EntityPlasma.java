package org.avp.entities;

import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.Settings;
import org.avp.client.Sounds;
import org.avp.client.entityfx.EntityFXElectricArc;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.Worlds;
import com.arisux.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityPlasma extends EntityThrowable
{
    private static final DataParameter<Float> PLASMA_SIZE = EntityDataManager.<Float> createKey(EntityPlasma.class, DataSerializers.FLOAT);
    private static final DataParameter<Integer> IMPACT_TIMER = EntityDataManager.<Integer> createKey(EntityPlasma.class, DataSerializers.VARINT);
    public float    syncSize;
    public boolean  synced;
    private boolean impacted;

    public EntityPlasma(World world)
    {
        super(world);
    }

    public EntityPlasma(World world, EntityLivingBase shootingEntity, float size)
    {
        super(world, shootingEntity);
        this.setSize(size, size);
        this.syncSize = size;
        this.noClip = true;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(PLASMA_SIZE, 1F);
        this.getDataManager().register(IMPACT_TIMER, -1);
    }

    @Override
    public void onUpdate()
    {
        this.move(this.motionX, this.motionY, this.motionZ);

        if (!this.world.isRemote && !this.synced)
        {
            this.getDataManager().set(PLASMA_SIZE, this.syncSize);
            this.synced = true;
        }

        if (!this.world.isRemote)
        {
            if (this.getImpactTimer() == this.getMaxImpactTimer())
            {
                this.getDataManager().set(IMPACT_TIMER, this.getImpactTimer());
            }
        }

        if (this.getImpactTimer() > 0)
        {
            if (!this.world.isRemote)
            {
                this.updateImpactTimer(this.getImpactTimer() - 1);
            }
        }

        if (!this.world.isRemote)
        {
            if (this.getImpactTimer() == -1 && this.ticksExisted >= 20 * 20 || this.getImpactTimer() == 0)
            {
                this.setDead();
            }
        }

        RayTraceResult RayTraceResult = this.world.rayTraceBlocks(new Vec3d(this.posX, this.posY, this.posZ), new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ));

        if (!this.world.isRemote)
        {
            Entity entityHit = Entities.getEntityInCoordsRange(world, EntityLiving.class, new Pos(this), 1, 1);

            if (entityHit != null)
            {
                this.onImpact(RayTraceResult);
            }
        }

        if (RayTraceResult != null || this.isCollidedHorizontally)
        {
            this.onImpact(RayTraceResult);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        nbt.setFloat("PlasmaSize", this.getPlasmaSize());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.syncSize = nbt.getFloat("PlasmaSize");
    }

    @Override
    protected void doBlockCollisions()
    {
        super.doBlockCollisions();
    }

    @Override
    public void onImpact(RayTraceResult RayTraceResult)
    {
        if (!this.world.isRemote)
        {
            if (Settings.instance.arePlasmaCannonExplosionsEnabled())
            {
                Worlds.createExplosion(null, world, new Pos(this), 3F * this.getPlasmaSize(), false, true, AliensVsPredator.settings().areExplosionsEnabled());
            }

            Sounds.WEAPON_PLASMA_EXPLOSION.playSound(this, 7F, 1.0F);

            @SuppressWarnings("unchecked")
            List<Entity> entities = (List<Entity>) Entities.getEntitiesInCoordsRange(world, Entity.class, new Pos(this.posX, this.posY, this.posZ), (int) Math.ceil(this.getPlasmaSize()));

            for (Entity entity : entities)
            {
                if (entity != this.getThrower())
                {
                    entity.attackEntityFrom(DamageSources.plasmacaster, 20F * this.getPlasmaSize());
                    entity.hurtResistantTime = 0;
                }
            }

            if (!this.impacted)
            {
                this.updateImpactTimer(this.getMaxImpactTimer());
                this.impacted = true;
            }

            this.motionX = 0;
            this.motionY = 0;
            this.motionZ = 0;
        }

        if (this.world.isRemote)
        {
            this.specialEffect();
        }
    }

    @SideOnly(Side.CLIENT)
    private void specialEffect()
    {
        float spread = this.getPlasmaSize() * 5F;

        for (int i = (int) Math.round(spread); i > 0; i--)
        {
            double pX = this.posX + (this.rand.nextDouble() * spread) - (this.rand.nextDouble() * spread);
            double pY = this.posY + (this.rand.nextDouble() * spread) - (this.rand.nextDouble() * spread);
            double pZ = this.posZ + (this.rand.nextDouble() * spread) - (this.rand.nextDouble() * spread);

            Game.minecraft().effectRenderer.addEffect(new EntityFXElectricArc(this.world, this.posX, this.posY, this.posZ, pX, pY, pZ, 10, 0xFF66AAFF));
        }
    }

    public float getPlasmaSize()
    {
        return this.getDataManager().get(PLASMA_SIZE);
    }

    public int getImpactTimer()
    {
        return this.getDataManager().get(IMPACT_TIMER);
    }

    public void updateImpactTimer(int time)
    {
        this.getDataManager().set(IMPACT_TIMER, time);
    }

    public int getImpactPrev()
    {
        return this.getImpactTimer() - 1;
    }

    public int getMaxImpactTimer()
    {
        return 6;
    }
}
