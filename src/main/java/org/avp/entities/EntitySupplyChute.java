package org.avp.entities;

import java.util.ArrayList;
import java.util.Iterator;

import org.avp.item.ItemSupplyChute.SupplyChuteType;
import org.avp.tile.TileEntitySupplyCrate;

import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntitySupplyChute extends Entity
{
    public int            metadata;
    public int            fallTime;
    public boolean        shouldDropItem;
    private boolean       hurtEntities;
    private int           fallHurtMax;
    private float         fallHurtAmount;
    public NBTTagCompound tileEntityData;

    public EntitySupplyChute(World world)
    {
        super(world);
        this.shouldDropItem = true;
        this.fallHurtMax = 40;
        this.fallHurtAmount = 2.0F;
    }
    
    public EntitySupplyChute(World world, double posX, double posY, double posZ)
    {
        this(world, posX, posY, posZ, 0);
    }

    public EntitySupplyChute(World world, double posX, double posY, double posZ, int meta)
    {
        super(world);
        this.shouldDropItem = true;
        this.fallHurtMax = 40;
        this.fallHurtAmount = 2.0F;
        this.metadata = meta;
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.setPosition(posX, posY, posZ);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = posX;
        this.prevPosY = posY;
        this.prevPosZ = posZ;
    }

    protected void entityInit()
    {
        ;
    }

    protected boolean canTriggerWalking()
    {
        return false;
    }

    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    protected void fall(float distance)
    {
        if (this.hurtEntities)
        {
            int i = MathHelper.ceil(distance - 1.0F);

            if (i > 0)
            {
                ArrayList arraylist = new ArrayList(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox()));
                DamageSource damagesource = DamageSource.FALLING_BLOCK;
                Iterator iterator = arraylist.iterator();

                while (iterator.hasNext())
                {
                    Entity entity = (Entity) iterator.next();
                    entity.attackEntityFrom(damagesource, (float) Math.min(MathHelper.floor((float) i * this.fallHurtAmount), this.fallHurtMax));
                }
            }
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound tagCompound)
    {
        tagCompound.setByte("Data", (byte) this.metadata);
        tagCompound.setByte("Time", (byte) this.fallTime);
        tagCompound.setBoolean("DropItem", this.shouldDropItem);
        tagCompound.setBoolean("HurtEntities", this.hurtEntities);
        tagCompound.setFloat("FallHurtAmount", this.fallHurtAmount);
        tagCompound.setInteger("FallHurtMax", this.fallHurtMax);

        if (this.tileEntityData != null)
        {
            tagCompound.setTag("TileEntityData", this.tileEntityData);
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound tagCompund)
    {
        this.metadata = tagCompund.getByte("Data") & 255;
        this.fallTime = tagCompund.getByte("Time") & 255;

        if (tagCompund.hasKey("HurtEntities", 99))
        {
            this.hurtEntities = tagCompund.getBoolean("HurtEntities");
            this.fallHurtAmount = tagCompund.getFloat("FallHurtAmount");
            this.fallHurtMax = tagCompund.getInteger("FallHurtMax");
        }

        if (tagCompund.hasKey("DropItem", 99))
        {
            this.shouldDropItem = tagCompund.getBoolean("DropItem");
        }

        if (tagCompund.hasKey("TileEntityData", 10))
        {
            this.tileEntityData = tagCompund.getCompoundTag("TileEntityData");
        }
    }

    public void setHurtEntities(boolean hurtEntities)
    {
        this.hurtEntities = hurtEntities;
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    @SideOnly(Side.CLIENT)
    public World getworld()
    {
        return this.world;
    }

    @SideOnly(Side.CLIENT)
    public boolean canRenderOnFire()
    {
        return false;
    }

    public Block getBlock()
    {
        return this.getType().getBlock();
    }

    @Override
    public void onUpdate()
    {
        if (this.getBlock() == null || this.getBlock().getDefaultState().getMaterial() == Material.AIR)
        {
            this.setDead();
        }
        else
        {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            ++this.fallTime;
            this.motionY -= 0.03999999910593033D;
            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            this.motionX *= 0.9800000190734863D;
            this.motionY *= 0.9800000190734863D;
            this.motionZ *= 0.9800000190734863D;

            if (!this.world.isRemote)
            {
                int x = MathHelper.floor(this.posX);
                int y = MathHelper.floor(this.posY);
                int z = MathHelper.floor(this.posZ);
                BlockPos pos = new BlockPos(x, y, z);
                BlockPos posBelow = new BlockPos(x, y - 1, z);
                IBlockState blockstate = this.world.getBlockState(pos);
                Block block = blockstate.getBlock();

                if (this.fallTime == 1)
                {
                    if (block != this.getBlock())
                    {
                        this.setDead();
                        return;
                    }

                    this.world.setBlockToAir(pos);
                }

                if (this.onGround)
                {
                    this.motionX *= 0.699999988079071D;
                    this.motionZ *= 0.699999988079071D;
                    this.motionY *= -0.5D;

                    if (block != Blocks.PISTON_EXTENSION)
                    {
                        this.setDead();

                        if (Entities.canPlaceEntityOnSide(this.world, this.getBlock(), pos, true, 1, (Entity) null, (ItemStack) null) && !canFallBelow(this.world, posBelow) && this.world.setBlockState(pos, this.getBlock().getDefaultState()))
                        {
                            if (this.tileEntityData != null && this.getBlock() instanceof ITileEntityProvider)
                            {
                                TileEntitySupplyCrate crate = (TileEntitySupplyCrate) this.world.getTileEntity(pos);

                                if (crate != null)
                                {
                                    crate.setType(this.getType());

                                    NBTTagCompound nbttagcompound = new NBTTagCompound();
                                    crate.writeToNBT(nbttagcompound);
                                    Iterator iterator = this.tileEntityData.getKeySet().iterator();

                                    while (iterator.hasNext())
                                    {
                                        String s = (String) iterator.next();
                                        NBTBase nbtbase = this.tileEntityData.getTag(s);

                                        if (!s.equals("x") && !s.equals("y") && !s.equals("z"))
                                        {
                                            nbttagcompound.setTag(s, nbtbase.copy());
                                        }
                                    }

                                    crate.readFromNBT(nbttagcompound);
                                    crate.markDirty();
                                }
                            }
                        }
                        else if (this.shouldDropItem)
                        {
                            this.entityDropItem(new ItemStack(this.getBlock(), 1, this.getBlock().damageDropped(this.getBlock().getStateFromMeta(this.metadata))), 0.0F);
                        }
                    }
                }
                else if (this.fallTime > 100 && !this.world.isRemote && (y < 1 || y > 256) || this.fallTime > 600)
                {
                    if (this.shouldDropItem)
                    {
                        this.entityDropItem(new ItemStack(this.getBlock(), 1, this.getBlock().damageDropped(this.getBlock().getStateFromMeta(this.metadata))), 0.0F);
                    }

                    this.setDead();
                }
            }
        }
    }
    

    public static boolean canFallBelow(World world, BlockPos pos)
    {
        IBlockState blockstate = world.getBlockState(pos);
        Block block = blockstate.getBlock();

        if (block.isAir(blockstate, world, pos))
        {
            return true;
        }
        else if (block == Blocks.FIRE)
        {
            return true;
        }
        else
        {
            Material material = blockstate.getMaterial();
            return material == Material.WATER ? true : material == Material.LAVA;
        }
    }

    public SupplyChuteType getType()
    {
        return SupplyChuteType.get(this.getClass());
    }
}
