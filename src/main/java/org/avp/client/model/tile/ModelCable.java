package org.avp.client.model.tile;

import org.avp.tile.TileEntityElectrical;

import com.arisux.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;


public class ModelCable extends Model
{
    public ModelRenderer cableWest;
    public ModelRenderer cableEast;
    public ModelRenderer cableSouth;
    public ModelRenderer cableNorth;
    public ModelRenderer cableBottom;
    public ModelRenderer cableTop;
    public ModelRenderer nodeX;
    public ModelRenderer nodeY;
    public ModelRenderer nodeZ;

    public ModelCable()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.cableTop = new ModelRenderer(this, 41, 0);
        this.cableTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cableTop.addBox(-0.5F, -7.5F, -0.5F, 1, 7, 1, 0.0F);
        this.nodeZ = new ModelRenderer(this, 0, 0);
        this.nodeZ.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nodeZ.addBox(-0.5F, -0.0F, -1.0F, 1, 1, 2, 0.0F);
        this.cableEast = new ModelRenderer(this, 41, 12);
        this.cableEast.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cableEast.addBox(-8.0F, 0.0F, -0.5F, 7, 1, 1, 0.0F);
        this.cableSouth = new ModelRenderer(this, 20, 0);
        this.cableSouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cableSouth.addBox(-0.5F, 0.0F, 1.0F, 1, 1, 7, 0.0F);
        this.nodeX = new ModelRenderer(this, 0, 4);
        this.nodeX.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nodeX.addBox(-1.0F, 0.0F, -0.5F, 2, 1, 1, 0.0F);
        this.cableWest = new ModelRenderer(this, 0, 12);
        this.cableWest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cableWest.addBox(1.0F, 0.0F, -0.5F, 7, 1, 1, 0.0F);
        this.cableBottom = new ModelRenderer(this, 48, 0);
        this.cableBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cableBottom.addBox(-0.5F, 1.5F, -0.5F, 1, 7, 1, 0.0F);
        this.nodeY = new ModelRenderer(this, 0, 4);
        this.nodeY.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nodeY.addBox(-0.5F, -0.5F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotation(nodeY, 0.0F, 0.0F, 1.5707963267948966F);
        this.cableNorth = new ModelRenderer(this, 20, 16);
        this.cableNorth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cableNorth.addBox(-0.5F, 0.0F, -8.0F, 1, 1, 7, 0.0F);
    }

    @Override
    public void render(Object obj)
    {
        TileEntity tile = (TileEntity) obj;

        nodeX.isHidden = false;
        nodeY.isHidden = false;
        nodeZ.isHidden = false;
        
        cableTop.isHidden = true;
        cableBottom.isHidden = true;
        cableWest.isHidden = false;
        cableEast.isHidden = false;
        cableSouth.isHidden = false;
        cableNorth.isHidden = false;
        
        if (tile != null)
        {
            TileEntity leftTile = tile.getWorld().getTileEntity(tile.getPos().add(1, 0, 0));
            cableWest.isHidden = !(leftTile instanceof TileEntityElectrical && ((TileEntityElectrical) leftTile).canProvideEnergyToReceiver(EnumFacing.EAST));

            TileEntity rightTile = tile.getWorld().getTileEntity(tile.getPos().add(-1, 0, 0));
            cableEast.isHidden = !(rightTile instanceof TileEntityElectrical && ((TileEntityElectrical) rightTile).canProvideEnergyToReceiver(EnumFacing.WEST));

            TileEntity topTile = tile.getWorld().getTileEntity(tile.getPos().add(0, 1, 0));
            cableTop.isHidden = !(topTile instanceof TileEntityElectrical && ((TileEntityElectrical) topTile).canProvideEnergyToReceiver(EnumFacing.UP));

            TileEntity bottomTile = tile.getWorld().getTileEntity(tile.getPos().add(0, -1, 0));
            cableBottom.isHidden = !(bottomTile instanceof TileEntityElectrical && ((TileEntityElectrical) bottomTile).canProvideEnergyToReceiver(EnumFacing.DOWN));

            TileEntity backTile = tile.getWorld().getTileEntity(tile.getPos().add(0, 0, 1));
            cableSouth.isHidden = !(backTile instanceof TileEntityElectrical && ((TileEntityElectrical) backTile).canProvideEnergyToReceiver(EnumFacing.NORTH));

            TileEntity frontTile = tile.getWorld().getTileEntity(tile.getPos().add(0, 0, -1));
            cableNorth.isHidden = !(frontTile instanceof TileEntityElectrical && ((TileEntityElectrical) frontTile).canProvideEnergyToReceiver(EnumFacing.SOUTH));

            nodeX.isHidden = cableEast.isHidden && cableWest.isHidden;
            nodeY.isHidden = cableTop.isHidden && cableBottom.isHidden;
            nodeZ.isHidden = cableNorth.isHidden && cableSouth.isHidden;
            
            if (nodeX.isHidden && nodeY.isHidden && nodeZ.isHidden)
            {
                nodeX.isHidden = false;
                nodeY.isHidden = false;
                nodeZ.isHidden = false;
                
                cableWest.isHidden = false;
                cableEast.isHidden = false;
                cableSouth.isHidden = false;
                cableNorth.isHidden = false;
            }
        }

        draw(cableTop);
        draw(cableEast);
        draw(cableSouth);
        draw(cableWest);
        draw(cableBottom);
        draw(cableNorth);
        draw(nodeX);
        draw(nodeY);
        draw(nodeZ);
    }
}
