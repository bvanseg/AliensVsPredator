package org.avp.entities.living.species.xenomorphs;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.api.parasitoidic.IMaturable;
import org.avp.client.Sounds;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.tile.TileEntityHiveResin;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.pathfinding.Path;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityDrone extends SpeciesXenomorph implements IMaturable
{
    public int             					mobType;
    private EntityOvamorph 					targetOvamorph;
    private static final ArrayList<Block> 	blockBlacklist = new ArrayList<Block>();
    
    public EntityDrone(World world)
    {
        super(world);

        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
        this.mobType = this.rand.nextInt(2);
        blockBlacklist.add(Blocks.BEDROCK);
        blockBlacklist.add(Blocks.AIR);
        blockBlacklist.add(AliensVsPredator.blocks().resin);
        blockBlacklist.add(AliensVsPredator.blocks().naturalResin);
        

        this.addStandardXenomorphAISet();
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
        return Sounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.ALIEN_DEATH.event();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        this.tickRepurposingAI();
        this.tickHiveBuildingAI();

        if (this.hive != null)
        {
            if (!this.hive.isEntityWithinRange(this))
            {
                Path path = this.getNavigator().getPathToXYZ(this.hive.xCoord(), this.hive.yCoord(), this.hive.zCoord());

                if (path != null)
                {
                    this.getNavigator().setPath(path, 0.8D);
                }
            }
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float damage)
    {
        return super.attackEntityFrom(source, damage);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        return super.attackEntityAsMob(entity);
    }

    public void tickRepurposingAI()
    {
        if (!this.world.isRemote)
        {
            if (this.world.getWorldTime() % 20 == 0)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    ArrayList<EntityOvamorph> ovamorphs = (ArrayList<EntityOvamorph>) Entities.getEntitiesInCoordsRange(this.world, EntityOvamorph.class, new Pos(this), 16);

                    if (this.getHive() != null)
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
        if (!this.world.isRemote)
        {
            if (this.world.getWorldTime() % 20 == 0)
            {
                if (this.getJellyLevel() < (this.getMaturityLevel() / 2))
                {
                    this.setJellyLevel(this.getJellyLevel() + 20);
                }
            }
        }
    }
    public void tickHiveBuildingAI()
    {
        if (!this.world.isRemote)
        {
            if (this.targetOvamorph == null)
            {
                if (this.getHive() != null && this.world.getWorldTime() % 10 == 0 && rand.nextInt(3) == 0)
                {
                    if (this.getJellyLevel() >= 16)
                    {
                        BlockPos pos = findNextSuitableResinLocation(3);

                        if (pos != null)
                        {
                            IBlockState state = this.world.getBlockState(pos);
                            Block block = state.getBlock();

                            if (block != null)
                            {
                                Path path = this.getNavigator().getPathToXYZ((int) pos.getX(), (int) pos.getY(), (int) pos.getZ());

                                if (path == null)
                                {
                                    return;
                                }

                                this.getNavigator().setPath(path, 0.8D);
                                this.world.setBlockState(pos, AliensVsPredator.blocks().naturalResin.getDefaultState());

                                TileEntity tileEntity = this.world.getTileEntity(pos);

                                if (tileEntity != null && tileEntity instanceof TileEntityHiveResin)
                                {
                                    TileEntityHiveResin resin = (TileEntityHiveResin) tileEntity;
                                    resin.setHiveSignature(this.getHive().getUniqueIdentifier());
                                    resin.setBlockCovering(state, 0);
                                    this.hive.addResin(resin);
                                }

                                this.setJellyLevel(this.getJellyLevel() - 16);
                            }
                        }
                    }
                }
            }
        }
    }

    public BlockPos findNextSuitableResinLocation(int range)
    {
        ArrayList<BlockPos> data = new ArrayList<BlockPos>();

        for (int x = (int) (posX - range); x < posX + range; x++)
        {
            for (int y = (int) (posY - range); y < posY + range; y++)
            {
                for (int z = (int) (posZ - range); z < posZ + range; z++)
                {
                    BlockPos location = new BlockPos(x, y, z);
                    IBlockState blockstate = this.world.getBlockState(location);
                    Block block = blockstate.getBlock();

                    if (this.canReplaceWithResin(blockstate))
                    {
                        Vec3d start = new Vec3d(this.posX, this.posY + (double) this.getEyeHeight(), this.posZ);
                        Vec3d end = new Vec3d(x, y, z);
                        RayTraceResult hit = this.world.rayTraceBlocks(start, end);

                        if (hit != null && hit.typeOfHit == RayTraceResult.Type.BLOCK || hit == null)
                        {
                            boolean canSeeCoord = true;

                            if (hit != null)
                            {
                                canSeeCoord = hit.hitVec.x == x && hit.hitVec.y == y && hit.hitVec.z == z;
                            }

                            if (Pos.isAnySurfaceEmpty(location, this.world) && canSeeCoord)
                            {
                                data.add(location);
                            }
                        }
                    }
                }
            }
        }

        return data.size() > 0 ? data.get(this.rand.nextInt(data.size())) : null;
    }

    protected boolean canReplaceWithResin(IBlockState blockstate)
    {
    	return (!blockBlacklist.contains(blockstate.getBlock()) && blockstate.isOpaqueCube());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
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
}
