package org.avp.item;

import java.util.List;

import org.avp.entities.EntityAPC;

import com.arisux.mdxlib.lib.world.item.HookedItem;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ItemAPC extends HookedItem
{
    public ItemAPC()
    {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
    }

    public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn)
    {
        float partialTicks = 1.0F;
        float pitch = playerIn.prevRotationPitch + (playerIn.rotationPitch - playerIn.prevRotationPitch) * partialTicks;
        float yaw = playerIn.prevRotationYaw + (playerIn.rotationYaw - playerIn.prevRotationYaw) * partialTicks;
        double dX = playerIn.prevPosX + (playerIn.posX - playerIn.prevPosX) * (double) partialTicks;
        double dY = playerIn.prevPosY + (playerIn.posY - playerIn.prevPosY) * (double) partialTicks + 1.62D;
        double dZ = playerIn.prevPosZ + (playerIn.posZ - playerIn.prevPosZ) * (double) partialTicks;
        float rC = MathHelper.cos(-yaw * 0.017453292F - (float) Math.PI);
        float rS = MathHelper.sin(-yaw * 0.017453292F - (float) Math.PI);
        float mult = -MathHelper.cos(-pitch * 0.017453292F);
        float y = MathHelper.sin(-pitch * 0.017453292F);
        float x = rS * mult;
        float z = rC * mult;
        double range = 5.0D;
        Vec3d vec1 = new Vec3d(dX, dY, dZ);
        Vec3d vec2 = vec1.addVector((double) x * range, (double) y * range, (double) z * range);
        RayTraceResult result = worldIn.rayTraceBlocks(vec1, vec2, true);

        if (result == null)
        {
            return itemStackIn;
        }
        else
        {
            Vec3d look = playerIn.getLook(partialTicks);
            boolean flag = false;
            float f9 = 1.0F;
            List<Entity> list = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, playerIn.getEntityBoundingBox().addCoord(look.xCoord * range, look.yCoord * range, look.zCoord * range).expand((double) f9, (double) f9, (double) f9));

            for (int idx = 0; idx < list.size(); ++idx)
            {
                Entity entity = (Entity) list.get(idx);

                if (entity.canBeCollidedWith())
                {
                    float f10 = entity.getCollisionBorderSize();
                    AxisAlignedBB axisalignedbb = entity.getEntityBoundingBox().expand((double) f10, (double) f10, (double) f10);

                    if (axisalignedbb.isVecInside(vec1))
                    {
                        flag = true;
                    }
                }
            }

            if (flag)
            {
                return itemStackIn;
            }
            else
            {
                if (result.typeOfHit == RayTraceResult.Type.BLOCK)
                {
                    int hitX = (int) result.hitVec.xCoord;
                    int hitY = (int) result.hitVec.yCoord;
                    int hitZ = (int) result.hitVec.zCoord;

                    if (worldIn.getBlockState(new BlockPos(hitX, hitY, hitZ)).getBlock() == Blocks.SNOW_LAYER)
                    {
                        --hitY;
                    }

                    EntityAPC entityapc = new EntityAPC(worldIn, (double) ((float) hitX + 0.5F), (double) ((float) hitY + 1.0F), (double) ((float) hitZ + 0.5F));
                    entityapc.rotationYaw = (float) (((MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90);

                    if (!worldIn.getCollisionBoxes(entityapc, entityapc.getEntityBoundingBox().expand(-0.1D, -0.1D, -0.1D)).isEmpty())
                    {
                        List<Entity> e = worldIn.getEntitiesWithinAABBExcludingEntity(playerIn, entityapc.getEntityBoundingBox());
                        for (Entity entityIn : e)
                        {
                            if (entityIn instanceof EntityLivingBase)
                            {
                                EntityLivingBase entity = (EntityLivingBase) entityIn;
                                entity.setHealth(0);
                            }
                            else
                            {
                                entityIn.setDead();
                            }
                        }
                    }

                    if (!worldIn.isRemote)
                    {
                        worldIn.spawnEntity(entityapc);
                    }

                    if (!playerIn.capabilities.isCreativeMode)
                    {
                        --itemStackIn.stackSize;
                    }
                }

                return itemStackIn;
            }
        }
    }
}
