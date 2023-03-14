package org.avp.client.model.tile;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.tile.TileEntityLocker;

public class ModelLocker extends Model<TileEntityLocker>
{
    public final ModelRenderer wallLeft;
    public final ModelRenderer wallRight;
    public final ModelRenderer back;
    public final ModelRenderer top;
    public final ModelRenderer floor;
    public final ModelRenderer door;

    public ModelLocker()
    {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.top = new ModelRenderer(this, 0, 49);
        this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top.addBox(-8.0F, -10.0F, -8.0F, 16, 1, 16, 0.0F);
        this.back = new ModelRenderer(this, 100, 14);
        this.back.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.back.addBox(-8.0F, -9.0F, 7.0F, 16, 32, 1, 0.0F);
        this.floor = new ModelRenderer(this, 0, 69);
        this.floor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.floor.addBox(-8.0F, 23.0F, -8.0F, 16, 1, 16, 0.0F);
        this.wallLeft = new ModelRenderer(this, 37, 0);
        this.wallLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wallLeft.addBox(-8.0F, -9.0F, -7.0F, 1, 32, 14, 0.0F);
        this.wallRight = new ModelRenderer(this, 68, 0);
        this.wallRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wallRight.addBox(7.0F, -9.0F, -7.0F, 1, 32, 14, 0.0F);
        this.door = new ModelRenderer(this, 0, 0);
        this.door.setRotationPoint(8.0F, 0.0F, -7.0F);
        this.door.addBox(-16.0F, -9.0F, -1.0F, 16, 32, 1, 0.0F);
    }

    @Override
    public void render(TileEntityLocker obj)
    {
        draw(top);
        draw(back);
        draw(floor);
        draw(wallLeft);
        draw(wallRight);
        draw(door);        
    }
}
