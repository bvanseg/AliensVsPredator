package org.avp.common.block;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.tile.IRotatableYAxis;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.avp.common.entity.EntitySupplyChute;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.avp.common.tile.TileEntitySupplyCrate;

import java.util.Random;

public class BlockSupplyCrate extends BlockFalling
{
    private final SupplyChuteType type;
    
    public BlockSupplyCrate(SupplyChuteType type)
    {
        super(Material.IRON);
        this.type = type;
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        TileEntitySupplyCrate crate = new TileEntitySupplyCrate();
        crate.setType(this.type);
        
        return crate;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public int tickRate(World world)
    {
        return 2;
    }
    
    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        if (!world.isRemote)
        {
            if (canFallThrough(world.getBlockState(pos.add(0, -1, 0))) && pos.getY() > 0)
            {
                byte r = 32;
                
                if (!fallInstantly && world.isBlockLoaded(pos.add(-r, -r, -r)) && world.isBlockLoaded(pos.add(r, r, r)))
                {
                    this.spawnParachute(world, pos);
                }
            }
        }
    }

    public void spawnParachute(World world, BlockPos pos)
    {
        EntitySupplyChute chute = this.getType().createEntity(world, (double) ((float) pos.getX() + 0.5F), (double) ((float) pos.getY() + 0.5F), (double) ((float) pos.getZ() + 0.5F));
        world.spawnEntity(chute);
    }
    
    public SupplyChuteType getType()
    {
        return this.type;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity != null && tileEntity instanceof TileEntitySupplyCrate)
        {
            TileEntitySupplyCrate supplyCrate = (TileEntitySupplyCrate) tileEntity;

            if (!player.isSneaking())
            {
                supplyCrate.openGui(player);
            }
            else
            {
                supplyCrate.setOpen(!supplyCrate.isOpen());
            }
        }

        return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof IRotatableYAxis && placer != null)
        {
            IRotatableYAxis rotatable = (IRotatableYAxis) tile;
            rotatable.setRotationYAxis(Entities.getEntityFacingRotY(placer));
        }
    }
    
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(worldIn, pos, playerIn);
        
        TileEntitySupplyCrate crate = (TileEntitySupplyCrate) worldIn.getTileEntity(pos);
        
        if (crate != null)
        {
            for (int i = crate.inventory.getSizeInventory(); i > 0; i--)
            {
                ItemStack stack = crate.inventory.getStackInSlot(i);
                
                if (stack != null)
                {
                    EntityItem entityItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
                    worldIn.spawnEntity(entityItem);
                }
            }
        }
    }
}
