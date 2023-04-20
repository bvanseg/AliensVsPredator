package org.predator.common.item;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.predator.common.entity.EntityLaserMine;

import java.util.List;

public class ItemLaserMine extends Item
{
    @Override
    public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        byte metaValue = (byte) (facing.ordinal() == 5 ? 3 : facing.ordinal() == 4 ? 1 : facing.ordinal() == 3 ? 2 : 0);
        EntityLaserMine entity = new EntityLaserMine(world, pos, metaValue, player.getUniqueID().toString());

        if (entity.canStay()) {
            if (!world.isRemote) {
                world.spawnEntity(entity);
            }

            ItemStack stack = player.getHeldItem(hand);
            stack.shrink(1);

            return EnumActionResult.SUCCESS;
        }
        
        return EnumActionResult.FAIL;
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Right click to place on wall.");
        tooltip.add("Laser contact triggers explosion.");
    }
}
