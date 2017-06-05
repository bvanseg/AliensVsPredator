package org.avp.tile;

import java.util.Random;
import java.util.UUID;

import org.avp.world.hives.HiveHandler;
import org.avp.world.hives.XenomorphHive;

import com.arisux.mdx.lib.world.Worlds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraftforge.fml.common.registry.GameRegistry;

//TODO: Redo this
public class TileEntityHiveResin extends TileEntity implements ITickable
{
    private ResinVariant variant;
    private UUID         signature;
    private IBlockState  blockCovering;
    public Block         northBlock;
    public Block         northTopBlock;
    public Block         northBottomBlock;
    public Block         southBlock;
    public Block         southTopBlock;
    public Block         southBottomBlock;
    public Block         eastBlock;
    public Block         eastTopBlock;
    public Block         eastBottomBlock;
    public Block         westBlock;
    public Block         westTopBlock;
    public Block         westBottomBlock;
    public Block         bottomBlock;
    public Block         topBlock;

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
    public void update()
    {
        if (this.world.getWorldTime() % 20 == 0)
        {
            if (variant != null)
            {
                bottomBlock = this.world.getBlockState(this.getPos().add(0, -1, 0)).getBlock();
                topBlock = this.world.getBlockState(this.getPos().add(0, 1, 0)).getBlock();

                northBlock = this.world.getBlockState(this.getPos().add(variant.nX, 0, variant.nZ)).getBlock();
                northTopBlock = this.world.getBlockState(this.getPos().add(variant.nX, 1, variant.nZ)).getBlock();
                northBottomBlock = this.world.getBlockState(this.getPos().add(variant.nX, -1, variant.nZ)).getBlock();

                southBlock = this.world.getBlockState(this.getPos().add(variant.sX, 0, variant.sZ)).getBlock();
                southTopBlock = this.world.getBlockState(this.getPos().add(variant.sX, 1, variant.sZ)).getBlock();
                southBottomBlock = this.world.getBlockState(this.getPos().add(variant.sX, -1, variant.sZ)).getBlock();

                eastBlock = this.world.getBlockState(this.getPos().add(variant.eX, 0, variant.eZ)).getBlock();
                eastTopBlock = this.world.getBlockState(this.getPos().add(variant.eX, 1, variant.eZ)).getBlock();
                eastBottomBlock = this.world.getBlockState(this.getPos().add(variant.eX, -1, variant.eZ)).getBlock();

                westBlock = this.world.getBlockState(this.getPos().add(variant.wX, 0, variant.wZ)).getBlock();
                westTopBlock = this.world.getBlockState(this.getPos().add(variant.wX, 1, variant.wZ)).getBlock();
                westBottomBlock = this.world.getBlockState(this.getPos().add(variant.wX, -1, variant.wZ)).getBlock();
            }
            else
            {
                this.variant = ResinVariant.fromId(1 + new Random().nextInt(ResinVariant.values().length));
            }
        }
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
            this.blockCovering = GameRegistry.findBlock(identifier[0], identifier[1]).getDefaultState();
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
