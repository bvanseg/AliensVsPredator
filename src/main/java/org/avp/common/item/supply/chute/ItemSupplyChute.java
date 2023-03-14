package org.avp.common.item.supply.chute;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemSupplyChute extends HookedItem
{
    private final SupplyChuteType type;

    public ItemSupplyChute(SupplyChuteType type)
    {
        setTranslationKey("supplyChute");
        setMaxStackSize(1);
        this.type = type;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (playerIn.capabilities.isCreativeMode || Inventories.consumeItem(playerIn, this))
        {
            int x = (int) (playerIn.posX + 1);
            int y = (int) (playerIn.posY + 80);
            int z = (int) (playerIn.posZ);

            if (!worldIn.isRemote)
            {
                worldIn.setBlockState(new BlockPos(x, y, z), this.type.getBlock().getDefaultState());
            }
        }
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    public SupplyChuteType getType()
    {
        return type;
    }
}
