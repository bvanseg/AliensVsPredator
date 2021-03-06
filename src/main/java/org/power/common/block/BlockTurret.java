package org.power.common.block;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants.NBT;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import org.avp.AVP;
import org.avp.common.AVPGui;
import org.avp.common.AVPNetworking;
import org.avp.common.item.init.AVPItems;
import org.power.common.network.packet.server.PacketAddTurretTarget;
import org.power.common.tile.TileEntityTurret;

import java.util.Collection;
import java.util.stream.Collectors;

public class BlockTurret extends Block
{
    public BlockTurret(Material material)
    {
        super(material);
        this.setTickRandomly(true);
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
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
    	TileEntity tileEntity = new TileEntityTurret();
    	tileEntity.setWorld(world);
        return tileEntity;
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntityTurret tile = (TileEntityTurret) world.getTileEntity(pos);

        if (tile != null)
        {
            if (!world.isRemote)
            {
            	Collection<String> entityIdentifiers = tile.getTargetHelper().getDangerousTargets().stream().map((e) -> Entities.getEntityRegistrationId(e)).collect(Collectors.toList());
                AVPNetworking.instance.sendToAll(new PacketAddTurretTarget(pos.getX(), pos.getY(), pos.getZ(), entityIdentifiers));
            }
        }

        ItemStack activeHandStack = player.getHeldItem(hand);

        if (!world.isRemote && activeHandStack.getItem() == AVPItems.ITEM_FLASH_DRIVE) {
            if (!activeHandStack.hasTagCompound()) {
                TileEntityTurret turretTileEntity = (TileEntityTurret) world.getTileEntity(pos);
                NBTTagCompound nbt = new NBTTagCompound();
                NBTTagList targetListTag = turretTileEntity.getTargetHelper().getTargetListTag();
                nbt.setTag("Targets", targetListTag);
                activeHandStack.setTagCompound(nbt);
                activeHandStack.setStackDisplayName("NBT Drive - " + "TURRET (" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")");
                player.sendMessage(new TextComponentString("Successfully wrote data to NBT Drive."));
            } else {
                NBTTagList targetList = activeHandStack.getTagCompound().getTagList("Targets", NBT.TAG_STRING);
                TileEntityTurret turretTileEntity = (TileEntityTurret) world.getTileEntity(pos);
                turretTileEntity.getTargetHelper().readTargetList(targetList);
                player.sendMessage(new TextComponentString("Successfully loaded NBT data to turret (" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")."));
            }

        	return true;
        }

        FMLNetworkHandler.openGui(player, AVP.instance, AVPGui.GUI_TURRET, world, pos.getX(), pos.getY(), pos.getZ());

        return true;
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
        TileEntity tileentity = worldIn.getTileEntity(pos);
        if (tileentity instanceof TileEntityTurret) {
            InventoryHelper.dropInventoryItems(worldIn, pos, ((TileEntityTurret) tileentity).getAmmoHelper().inventoryAmmo);
            InventoryHelper.dropInventoryItems(worldIn, pos, ((TileEntityTurret) tileentity).inventoryExpansion);
            InventoryHelper.dropInventoryItems(worldIn, pos, ((TileEntityTurret) tileentity).inventoryDrive);
            // TODO: Might not be necessary?
            worldIn.updateComparatorOutputLevel(pos, this);
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityTurret tile = (TileEntityTurret) world.getTileEntity(pos);

        if (tile != null)
        {
            tile.setRotationYAxis(Entities.getEntityFacingRotY(placer).getOpposite());
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }
}
