package org.avp.common.entity;

import com.asx.mdx.common.minecraft.entity.Entities;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.avp.common.tile.TileEntitySupplyCrate;

public class EntitySupplyChute extends Entity
{
    public int metadata;
    public int fallTime;
    public boolean shouldDropItem;
    private boolean hurtEntities;
    private int fallHurtMax;
    private float fallHurtAmount;
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

    @Override
    protected void entityInit() { /* Do Nothing */ }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    private static final String DATA_NBT_KEY = "Data";
    private static final String TIME_NBT_KEY = "Time";
    private static final String DROP_ITEM_NBT_KEY = "DropItem";
    private static final String HURT_ENTITIES_NBT_KEY = "HurtEntities";
    private static final String FALL_HURT_AMOUNT_NBT_KEY = "FallHurtAmount";
    private static final String FALL_HURT_MAX_NBT_KEY = "FallHurtMax";
    private static final String TILE_ENTITY_DATA_NBT_KEY = "TileEntityData";

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbtTagCompound)
    {
        nbtTagCompound.setByte(DATA_NBT_KEY, (byte) this.metadata);
        nbtTagCompound.setByte(TIME_NBT_KEY, (byte) this.fallTime);
        nbtTagCompound.setBoolean(DROP_ITEM_NBT_KEY, this.shouldDropItem);
        nbtTagCompound.setBoolean(HURT_ENTITIES_NBT_KEY, this.hurtEntities);
        nbtTagCompound.setFloat(FALL_HURT_AMOUNT_NBT_KEY, this.fallHurtAmount);
        nbtTagCompound.setInteger(FALL_HURT_MAX_NBT_KEY, this.fallHurtMax);

        if (this.tileEntityData != null)
        {
            nbtTagCompound.setTag(TILE_ENTITY_DATA_NBT_KEY, this.tileEntityData);
        }
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbtTagCompound)
    {
        this.metadata = nbtTagCompound.getByte(DATA_NBT_KEY) & 255;
        this.fallTime = nbtTagCompound.getByte(TIME_NBT_KEY) & 255;

        if (nbtTagCompound.hasKey(HURT_ENTITIES_NBT_KEY, Constants.NBT.TAG_ANY_NUMERIC))
        {
            this.hurtEntities = nbtTagCompound.getBoolean(HURT_ENTITIES_NBT_KEY);
            this.fallHurtAmount = nbtTagCompound.getFloat(FALL_HURT_AMOUNT_NBT_KEY);
            this.fallHurtMax = nbtTagCompound.getInteger(FALL_HURT_MAX_NBT_KEY);
        }

        if (nbtTagCompound.hasKey(DROP_ITEM_NBT_KEY, Constants.NBT.TAG_ANY_NUMERIC))
        {
            this.shouldDropItem = nbtTagCompound.getBoolean(DROP_ITEM_NBT_KEY);
        }

        if (nbtTagCompound.hasKey(TILE_ENTITY_DATA_NBT_KEY, Constants.NBT.TAG_COMPOUND))
        {
            this.tileEntityData = nbtTagCompound.getCompoundTag(TILE_ENTITY_DATA_NBT_KEY);
        }
    }

    @SideOnly(Side.CLIENT)
    public World getworld()
    {
        return this.world;
    }

    @Override
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

                                    for (String s : this.tileEntityData.getKeySet()) {
                                        NBTBase nbtbase = this.tileEntityData.getTag(s);

                                        if (!s.equals("x") && !s.equals("y") && !s.equals("z")) {
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
            return material == Material.WATER || material == Material.LAVA;
        }
    }

    public SupplyChuteType getType()
    {
        // TODO: Support other supply chute types.
        return SupplyChuteType.UNBRANDED;
    }
}
