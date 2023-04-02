package org.avp.common.item.supply.chute;

import com.asx.mdx.client.render.model.MapModelTexture;
import net.minecraft.block.Block;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.Resources;
import org.avp.client.model.entity.ModelSupplyChute;
import org.avp.common.block.init.AVPTileEntityBlocks;

public enum SupplyChuteType {
    UNBRANDED(0),
    MARINES(1),
    SEEGSON(2);

    private final int id;

    SupplyChuteType(int id)
    {
        this.id = id;
    }

    public int id()
    {
        return id;
    }

    public static SupplyChuteType get(int id)
    {
        for (SupplyChuteType type : values())
        {
            if (type.id == id)
            {
                return type;
            }
        }

        return UNBRANDED;
    }

    public static SupplyChuteType get(Block block)
    {
        for (SupplyChuteType type : values())
        {
            if (type.getBlock() == block)
            {
                return type;
            }
        }

        return UNBRANDED;
    }

    @SideOnly(Side.CLIENT)
    public MapModelTexture<ModelSupplyChute> getModel()
    {
        return SupplyChuteType.getModel(this);
    }

    @SideOnly(Side.CLIENT)
    public static MapModelTexture<ModelSupplyChute> getModel(SupplyChuteType type)
    {
        switch (type)
        {
            case MARINES:
                return Resources.instance.models().SUPPLY_CHUTE_MARINES;

            case SEEGSON:
                return Resources.instance.models().SUPPLY_CHUTE_SEEGSON;

            default:
                return Resources.instance.models().SUPPLY_CHUTE;

        }
    }

    public Block getBlock()
    {
        return SupplyChuteType.getBlock(this);
    }

    public static Block getBlock(SupplyChuteType type)
    {
        switch (type)
        {
            case MARINES:
                return AVPTileEntityBlocks.CRATE_MARINES;

            case SEEGSON:
                return AVPTileEntityBlocks.CRATE_SEEGSON;

            default:
                return AVPTileEntityBlocks.SUPPLY_CRATE;
        }
    }
}