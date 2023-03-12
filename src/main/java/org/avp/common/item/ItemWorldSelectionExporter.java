package org.avp.common.item;

import java.util.List;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Pos.BlockDataStore;
import com.asx.mdx.lib.world.item.HookedItem;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemWorldSelectionExporter extends HookedItem
{
    public ItemWorldSelectionExporter()
    {
        super();
        this.maxStackSize = 1;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        if (!player.world.isRemote)
        {
            this.writeSelectionDataToStack(new Pos(pos).store(new BlockDataStore(player.world.getBlockState(pos).getBlock(), (byte) 0)), null, itemstack);
        }
        return true;
    }
    
    @Override
    public EnumActionResult onItemUseFirst(EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand)
    {
        if (!player.world.isRemote)
        {
            this.writeSelectionDataToStack(null, new Pos(pos).store(new BlockDataStore(player.world.getBlockState(pos).getBlock(), (byte) 0)), player.getActiveItemStack());
        }
        
        return super.onItemUseFirst(player, world, pos, side, hitX, hitY, hitZ, hand);
    }

    public void writeSelectionDataToStack(Pos pos1, Pos pos2, ItemStack stack)
    {
        NBTTagCompound tag = stack.getTagCompound() != null ? stack.getTagCompound() : new NBTTagCompound();
        NBTTagCompound lastSelection1 = (NBTTagCompound) tag.getTag("SelectedPos1");
        NBTTagCompound lastSelection2 = (NBTTagCompound) tag.getTag("SelectedPos2");
        Pos lastPos1 = lastSelection1 != null ? new Pos(lastSelection1.getInteger("PosX"), lastSelection1.getInteger("PosY"), lastSelection1.getInteger("PosZ")) : null;
        Pos lastPos2 = lastSelection2 != null ? new Pos(lastSelection2.getInteger("PosX"), lastSelection2.getInteger("PosY"), lastSelection2.getInteger("PosZ")) : null;

        if (pos1 != null)
        {
            tag.setTag("SelectedPos1", pos1.writeToNBT());
        }

        if (pos2 != null)
        {
            tag.setTag("SelectedPos2", pos2.writeToNBT());
        }

        stack.setTagCompound(tag);

        if (lastPos1 != null && lastPos2 != null)
        {
            stack.setStackDisplayName(String.format("World Selector - Pos1(%s, %s, %s) - Pos2(%s, %s, %s)", lastPos1.x, lastPos1.y, lastPos1.z, lastPos2.x, lastPos2.y, lastPos2.z));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("World Selection Exporter");
    }
}
