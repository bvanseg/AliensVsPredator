package org.alien.common.entity.living.xenomorph;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Maturable;
import org.alien.common.entity.ai.brain.DroneBrain;
import org.alien.common.entity.ai.brain.XenomorphBrain;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.world.hive.HiveMember;

import java.util.ArrayList;

public class EntityDrone extends SpeciesXenomorph implements Maturable, HiveMember
{
    public int             					mobType;
    public EntityOvamorph 					targetOvamorph;
    
    public EntityDrone(World world)
    {
        super(world);

        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
        this.mobType = this.rand.nextInt(2);
    }

    @Override
    public XenomorphBrain getBrain() {
        if (this.brain == null) {
            this.brain = new DroneBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.53D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return AlienSounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return AlienSounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.ALIEN_DEATH.event();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.tickRepurposingAI();

        if (this.getAlienHive() != null)
        {
            if (!this.getAlienHive().isEntityWithinRange(this))
            {
                Path path = this.getNavigator().getPathToPos(this.getAlienHive().getCoreBlockPos());

                if (path != null)
                {
                    this.getNavigator().setPath(path, 0.8D);
                }
            }
        }
    }

    public void tickRepurposingAI()
    {
        if (!this.world.isRemote)
        {
            if (this.world.getTotalWorldTime() % 20 == 0)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    ArrayList<EntityOvamorph> ovamorphs = (ArrayList<EntityOvamorph>) Entities.getEntitiesInCoordsRange(this.world, EntityOvamorph.class, new Pos(this), 16);

                    if (this.getAlienHive() != null)
                    {
                        for (EntityOvamorph ovamorph : ovamorphs)
                        {
                            if (!ovamorph.containsFacehugger)
                            {
                                targetOvamorph = ovamorph;
                                this.getNavigator().tryMoveToEntityLiving(ovamorph, this.getMoveHelper().getSpeed());
                            }
                        }
                    }
                }

                if (this.targetOvamorph != null)
                {
                    double distance = this.getDistanceSq(targetOvamorph);

                    if (distance <= 2)
                    {
                        this.setJellyLevel(this.getJellyLevel() + targetOvamorph.getJellyLevel());
                        this.targetOvamorph.setDead();
                        this.targetOvamorph = null;
                    }
                }
            }
        }
    }

    @Override
    public void produceJelly()
    {
        if (this.world.isRemote) return;
        if (this.world.getTotalWorldTime() % 20 != 0) return;
        if (this.getJellyLevel() >= (this.getMaturityLevel() / 2)) return;

        this.setJellyLevel(this.getJellyLevel() + 20);
    }

    @Override
    public Class<? extends Entity> getMatureState()
    {
        return EntityWarrior.class;
    }

    @Override
    public int getMaturityLevel()
    {
        return 1024 * 6;
    }

    @Override
    public int getMaturityTime()
    {
        return (15 * 60) * 20;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_DRONE);
    }
}
