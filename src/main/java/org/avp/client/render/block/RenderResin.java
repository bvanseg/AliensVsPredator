package org.avp.client.render.block;

import org.avp.AliensVsPredator;
import org.avp.Settings.ClientSettings;
import org.avp.tile.TileEntityHiveResin;

import com.arisux.mdx.config.GraphicsSetting;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

//implements ISimpleBlockRenderingHandler
public class RenderResin
{
    private int renderId;

    public RenderResin(int renderId)
    {
        this.renderId = renderId;
    }

//    @Override
//    public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer)
//    {
//        ;
//    }

//    @Override
//    public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer)
//    {
//        if (world != null)
//        {
//            GraphicsSetting hiveTessellation = ClientSettings.instance.hiveTessellation().value();
//            Block renderBlock = AliensVsPredator.blocks().blockStandardHiveResin;
//            TileEntityHiveResin resin = (TileEntityHiveResin) world.getTileEntity(new BlockPos(x, y, z));
//
//            if (hiveTessellation != GraphicsSetting.LOW)
//            {
//                if (resin != null && resin.getBlockCovering() != null)
//                {
//                    renderBlock = resin.getBlockCovering().getBlock();
//                }
//            }
//
//            if (resin != null && renderBlock != null)
//            {
////                RenderBlocks.getInstance().blockAccess = world;
////                RenderBlocks.getInstance().renderBlockAllFaces(renderBlock, x, y, z);
////                RenderBlocks.getInstance().blockAccess = null;
//            }
//        }
//
//        return false;
//    }
}
