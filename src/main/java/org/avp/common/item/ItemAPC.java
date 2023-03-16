package org.avp.common.item;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.avp.common.entity.EntityAPC;

public class ItemAPC extends HookedItem
{
    public ItemAPC()
    {
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabs.TRANSPORTATION);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        float partialTicks = ClientGame.instance.partialTicks();
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
        Vec3d vec2 = vec1.add((double) x * range, (double) y * range, (double) z * range);
        RayTraceResult result = worldIn.rayTraceBlocks(vec1, vec2, true);

        if (result == null)
        {
            return new ActionResult<ItemStack>(EnumActionResult.FAIL, playerIn.getActiveItemStack());
        }
        else if (result.typeOfHit == RayTraceResult.Type.BLOCK)
        {
            int hitX = (int) result.hitVec.x;
            int hitY = (int) result.hitVec.y;
            int hitZ = (int) result.hitVec.z;

            EntityAPC entityapc = new EntityAPC(worldIn, (double) ((float) hitX + 0.5F), (double) ((float) hitY + 1.0F), (double) ((float) hitZ + 0.5F));
            entityapc.rotationYaw = (float) (((MathHelper.floor((double) (playerIn.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3) - 1) * 90);

            if (!worldIn.isRemote)
            {
                worldIn.spawnEntity(entityapc);
            }
        }

        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, playerIn.getActiveItemStack());
    }
}
