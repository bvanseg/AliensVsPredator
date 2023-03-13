package org.avp.client.model.tile;

import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.tile.TileEntityRepulsionGenerator;

public class ModelRepulsionGenerator extends Model<TileEntityRepulsionGenerator>
{
    public final ModelRenderer side1;
    public final ModelRenderer side3;
    public final ModelRenderer side5;
    public final ModelRenderer side7;
    public final ModelRenderer side6;
    public final ModelRenderer side8;
    public final ModelRenderer side2;
    public final ModelRenderer side3_1;
    public final ModelRenderer rotor;
    public final ModelRenderer magnetbase;
    public final ModelRenderer wireframe3;
    public final ModelRenderer wireframe2;
    public final ModelRenderer wireframe1;
    public final ModelRenderer top;
    public final ModelRenderer base;
    public final ModelRenderer magnet1;
    public final ModelRenderer magnet2;
    public final ModelRenderer magnet3;
    public final ModelRenderer magnet4;
    public final ModelRenderer magnet5;
    public final ModelRenderer magnet6;
    public final ModelRenderer magnet7;
    public final ModelRenderer magnet8;

    public ModelRepulsionGenerator()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.wireframe2 = new ModelRenderer(this, 27, 17);
        this.wireframe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wireframe2.addBox(-9.0F, 16.5F, -9.0F, 18, 0, 18, 0.0F);
        this.setRotation(wireframe2, 0.0F, -0.7853981633974483F, 0.0F);
        this.magnet8 = new ModelRenderer(this, 0, 29);
        this.magnet8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet8.addBox(-1.5F, 12.5F, -3.5F, 3, 3, 1, 0.0F);
        this.setRotation(magnet8, 0.0F, -1.5707963267948966F, 0.0F);
        this.side7 = new ModelRenderer(this, 42, 0);
        this.side7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side7.addBox(-1.5F, 9.0F, 4.0F, 3, 12, 4, 0.0F);
        this.base = new ModelRenderer(this, 64, 45);
        this.base.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.base.addBox(-8.0F, 21.0F, -8.0F, 16, 3, 16, 0.0F);
        this.magnet7 = new ModelRenderer(this, 0, 29);
        this.magnet7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet7.addBox(-1.5F, 16.5F, -3.5F, 3, 3, 1, 0.0F);
        this.setRotation(magnet7, 0.0F, -1.5707963267948966F, 0.0F);
        this.side6 = new ModelRenderer(this, 56, 0);
        this.side6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side6.addBox(-1.5F, 12.0F, 4.0F, 3, 9, 5, 0.0F);
        this.setRotation(side6, 0.0F, -0.7853981633974483F, 0.0F);
        this.magnet4 = new ModelRenderer(this, 0, 29);
        this.magnet4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet4.addBox(-1.5F, 12.5F, -3.5F, 3, 3, 1, 0.0F);
        this.setRotation(magnet4, 0.0F, 1.5707963267948966F, 0.0F);
        this.magnet1 = new ModelRenderer(this, 0, 29);
        this.magnet1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet1.addBox(-1.5F, 12.5F, -3.5F, 3, 3, 1, 0.0F);
        this.wireframe3 = new ModelRenderer(this, 27, 17);
        this.wireframe3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wireframe3.addBox(-9.0F, 13.0F, -9.0F, 18, 0, 18, 0.0F);
        this.setRotation(wireframe3, 0.0F, -0.7853981633974483F, 0.0F);
        this.magnet3 = new ModelRenderer(this, 0, 29);
        this.magnet3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet3.addBox(-1.5F, 16.5F, -3.5F, 3, 3, 1, 0.0F);
        this.setRotation(magnet3, 0.0F, 1.5707963267948966F, 0.0F);
        this.top = new ModelRenderer(this, 0, 47);
        this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top.addBox(-8.0F, 8.0F, -8.0F, 16, 1, 16, 0.0F);
        this.side5 = new ModelRenderer(this, 28, 0);
        this.side5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side5.addBox(-1.5F, 9.0F, 4.0F, 3, 12, 4, 0.0F);
        this.setRotation(side5, 0.0F, -1.5707963267948966F, 0.0F);
        this.wireframe1 = new ModelRenderer(this, 27, 17);
        this.wireframe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wireframe1.addBox(-9.0F, 20.0F, -9.0F, 18, 0, 18, 0.0F);
        this.setRotation(wireframe1, 0.0F, -0.7853981633974483F, 0.0F);
        this.side8 = new ModelRenderer(this, 72, 0);
        this.side8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side8.addBox(-1.5F, 12.0F, 4.0F, 3, 9, 5, 0.0F);
        this.setRotation(side8, 0.0F, 0.7853981633974483F, 0.0F);
        this.rotor = new ModelRenderer(this, 4, 29);
        this.rotor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rotor.addBox(-2.5F, 12.0F, -2.5F, 5, 8, 5, 0.0F);
        this.side1 = new ModelRenderer(this, 0, 0);
        this.side1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side1.addBox(-1.5F, 9.0F, 4.0F, 3, 12, 4, 0.0F);
        this.setRotation(side1, 3.141592653589793F, 1.5707963267948966F, 3.141592653589793F);
        this.side3_1 = new ModelRenderer(this, 104, 0);
        this.side3_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side3_1.addBox(-1.5F, 12.0F, 4.0F, 3, 9, 5, 0.0F);
        this.setRotation(side3_1, 3.141592653589793F, -0.7853981633974483F, 3.141592653589793F);
        this.side2 = new ModelRenderer(this, 88, 0);
        this.side2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side2.addBox(-1.5F, 12.0F, 4.0F, 3, 9, 5, 0.0F);
        this.setRotation(side2, 3.141592653589793F, 0.7853981633974483F, 3.141592653589793F);
        this.magnetbase = new ModelRenderer(this, 0, 16);
        this.magnetbase.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnetbase.addBox(-5.5F, 20.0F, -5.5F, 11, 1, 11, 0.0F);
        this.setRotation(magnetbase, 0.0F, -0.7853981633974483F, 0.0F);
        this.side3 = new ModelRenderer(this, 14, 0);
        this.side3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.side3.addBox(-1.5F, 9.0F, 4.0F, 3, 12, 4, 0.0F);
        this.setRotation(side3, 3.141592653589793F, 0.0F, 3.141592653589793F);
        this.magnet5 = new ModelRenderer(this, 0, 29);
        this.magnet5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet5.addBox(-1.5F, 16.5F, -3.5F, 3, 3, 1, 0.0F);
        this.setRotation(magnet5, 0.0F, 3.141592653589793F, 0.0F);
        this.magnet6 = new ModelRenderer(this, 0, 29);
        this.magnet6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet6.addBox(-1.5F, 12.5F, -3.5F, 3, 3, 1, 0.0F);
        this.setRotation(magnet6, 0.0F, 3.141592653589793F, 0.0F);
        this.magnet2 = new ModelRenderer(this, 0, 29);
        this.magnet2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.magnet2.addBox(-1.5F, 16.5F, -3.5F, 3, 3, 1, 0.0F);
        this.rotor.addChild(this.magnet8);
        this.rotor.addChild(this.magnet7);
        this.rotor.addChild(this.magnet4);
        this.rotor.addChild(this.magnet1);
        this.rotor.addChild(this.magnet3);
        this.rotor.addChild(this.magnet5);
        this.rotor.addChild(this.magnet6);
        this.rotor.addChild(this.magnet2);
    }

    @Override
    public void render(TileEntityRepulsionGenerator obj)
    {
        if (obj instanceof TileEntityRepulsionGenerator)
        {
            TileEntityRepulsionGenerator generator = (TileEntityRepulsionGenerator) obj;
            this.rotor.rotateAngleY = ((Minecraft.getMinecraft().player.world.getTotalWorldTime() % 360) + Game.partialTicks()) * (generator.getRotationSpeed());
        }

        this.wireframe2.render(DEFAULT_SCALE);
        this.side7.render(DEFAULT_SCALE);
        this.base.render(DEFAULT_SCALE);
        this.side6.render(DEFAULT_SCALE);
        this.wireframe3.render(DEFAULT_SCALE);
        this.top.render(DEFAULT_SCALE);
        this.side5.render(DEFAULT_SCALE);
        this.wireframe1.render(DEFAULT_SCALE);
        this.side8.render(DEFAULT_SCALE);
        this.rotor.render(DEFAULT_SCALE);
        this.side1.render(DEFAULT_SCALE);
        this.side3_1.render(DEFAULT_SCALE);
        this.side2.render(DEFAULT_SCALE);
        this.magnetbase.render(DEFAULT_SCALE);
        this.side3.render(DEFAULT_SCALE);
    }
}
