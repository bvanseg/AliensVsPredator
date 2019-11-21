package org.avp.tile;

import java.util.Random;
import java.util.UUID;

import org.avp.block.BlockHiveResin;
import org.avp.world.hives.HiveHandler;
import org.avp.world.hives.XenomorphHive;

import com.asx.mdx.lib.world.Worlds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

//TODO: Redo this
public class TileEntityHiveResin extends TileEntity
{
    public ResinVariant variant;
    private UUID        signature;
    private IBlockState blockCovering;
    public Block        northBlock;
    public Block        northTopBlock;
    public Block        northBottomBlock;
    public Block        southBlock;
    public Block        southTopBlock;
    public Block        southBottomBlock;
    public Block        eastBlock;
    public Block        eastTopBlock;
    public Block        eastBottomBlock;
    public Block        westBlock;
    public Block        westTopBlock;
    public Block        westBottomBlock;
    public Block        bottomBlock;
    public Block        topBlock;

    public enum ResinVariant
    {
        VARIANT1(1, 0, -1, +1, 0, 0, +1, -1, 0),
        VARIANT2(2, -1, 0, 0, -1, +1, 0, 0, +1),
        VARIANT3(3, 0, +1, -1, 0, 0, -1, +1, 0),
        VARIANT4(4, +1, 0, 0, +1, -1, 0, 0, -1);

        public int id;
        public int nX;
        public int nZ;
        public int sX;
        public int sZ;
        public int eX;
        public int eZ;
        public int wX;
        public int wZ;

        ResinVariant(int id, int nX, int nZ, int eX, int eZ, int sX, int sZ, int wX, int wZ)
        {
            this.id = id;
            this.nX = nX;
            this.nZ = nZ;
            this.sX = sX;
            this.sZ = sZ;
            this.eX = eX;
            this.eZ = eZ;
            this.wX = wX;
            this.wZ = wZ;
        }

        public static ResinVariant fromId(int id)
        {
            for (ResinVariant rotation : values())
            {
                if (rotation.id == id)
                {
                    return rotation;
                }
            }

            return null;
        }
    }

    @Override
    public void onLoad()
    {
        super.onLoad();
        ((BlockHiveResin) world.getBlockState(pos).getBlock()).evaluateNeighbors(world, pos);
    }

    public XenomorphHive getHive()
    {
        return HiveHandler.instance.getHiveForUUID(this.signature);
    }

    public UUID getHiveSignature()
    {
        return this.signature;
    }

    public void setHiveSignature(UUID signature)
    {
        this.signature = signature;
    }

    public void setBlockCovering(IBlockState blockCovering, int meta)
    {
        this.blockCovering = blockCovering;
    }

    public IBlockState getBlockCovering()
    {
        return this.blockCovering;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.getPos(), 1, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
    {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        int variantOrdinal = compound.getInteger("RandomVariant");
        String blockString = compound.getString("BlockCovered");

        if (blockString != null && blockString.contains(":"))
        {
            String[] identifier = blockString.split(":");
            this.blockCovering = GameRegistry.findRegistry(Block.class).getValue(new ResourceLocation(identifier[0], identifier[1])).getDefaultState();
        }

        this.signature = Worlds.uuidFromNBT(compound, "HiveSignature");
        this.variant = ResinVariant.fromId(variantOrdinal == 0 ? 1 + new Random().nextInt(ResinVariant.values().length) : variantOrdinal);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        if (blockCovering != null)
        {
            if (this.blockCovering.getBlock().getRegistryName() != null)
            {
                nbt.setString("BlockCovered", this.blockCovering.getBlock().getRegistryName().toString());
            }
        }

        nbt.setString("HiveSignature", signature != null ? this.signature.toString() : "");
        nbt.setInteger("RandomVariant", this.variant != null ? this.variant.id : 0);

        return nbt;
    }

    public ResinVariant getVariant()
    {
        return this.variant;
    }

    public void setVariant(ResinVariant variant)
    {
        this.variant = variant;
    }
}
