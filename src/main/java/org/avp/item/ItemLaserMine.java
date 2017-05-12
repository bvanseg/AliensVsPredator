package org.avp.item;

import java.util.List;

import org.avp.entities.EntityLaserMine;

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

public class ItemLaserMine extends Item
{
    @Override
    public EnumActionResult onItemUse(ItemStack itemstack, EntityPlayer player, World world, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        byte metaValue = (byte) (facing.ordinal() == 5 ? 3 : facing.ordinal() == 4 ? 1 : facing.ordinal() == 3 ? 2 : 0);

        EntityLaserMine entity = new EntityLaserMine(world, pos, metaValue, player.getUniqueID().toString());

        if (!world.isRemote && entity.canStay())
        {
            --itemstack.stackSize;
            world.spawnEntity(entity);
            return EnumActionResult.SUCCESS;
        }
        
        return EnumActionResult.FAIL;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    @SuppressWarnings("all")
    public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4)
    {
        par3List.add("Right click to place on wall (Explodes when entities pass through laser)");
    }
}
