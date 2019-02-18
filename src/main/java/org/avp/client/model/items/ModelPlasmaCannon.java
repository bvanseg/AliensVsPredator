package org.avp.client.model.items;

import com.arisux.mdx.lib.client.util.models.Model;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;


public class ModelPlasmaCannon extends Model
{
    public ModelRenderer supportBar;
    public ModelRenderer swivelHinge;
    public ModelRenderer supportBarTop;
    public ModelRenderer top;
    public ModelRenderer lTop;
    public ModelRenderer rTop;
    public ModelRenderer lBottom;
    public ModelRenderer rBottom;
    public ModelRenderer bottom;
    public ModelRenderer barrel;

    public ModelPlasmaCannon()
    {
        this.lTop = new ModelRenderer(this, 0, 8);
        this.lTop.mirror = true;
        this.lTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lTop.addBox(1.0F, -1.2F, -9.2F, 1, 2, 10, 0.0F);
        this.setRotation(lTop, -0.7546803685623481F, -0.22060961745208327F, -0.22759093446006054F);
        this.bottom = new ModelRenderer(this, 23, 9);
        this.bottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottom.addBox(-1.0F, 0.9F, -9.0F, 2, 1, 9, 0.0F);
        this.setRotation(bottom, -0.7853981633974483F, -0.0F, 0.0F);
        this.supportBar = new ModelRenderer(this, 38, 20);
        this.supportBar.setRotationPoint(0.0F, 10.8F, 10.0F);
        this.supportBar.addBox(-1.0F, -1.0F, 0.0F, 2, 2, 10, 0.0F);
        this.setRotation(supportBar, 1.3089969389957472F, -0.0F, 0.0F);
        this.rBottom = new ModelRenderer(this, 0, 20);
        this.rBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rBottom.addBox(-2.1F, -0.5F, -9.2F, 1, 2, 10, 0.0F);
        this.setRotation(rBottom, -0.7546803685623481F, -0.22060961745208327F, -0.22759093446006054F);
        this.top = new ModelRenderer(this, 35, 0);
        this.top.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.top.addBox(-1.0F, -1.4F, -9.2F, 2, 1, 8, 0.0F);
        this.setRotation(top, -0.7853981633974483F, -0.0F, 0.0F);
        this.rTop = new ModelRenderer(this, 0, 8);
        this.rTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rTop.addBox(-2.0F, -1.2F, -9.2F, 1, 2, 10, 0.0F);
        this.setRotation(rTop, -0.7546803685623481F, 0.22060961745208327F, 0.22759093446006054F);
        this.lBottom = new ModelRenderer(this, 0, 20);
        this.lBottom.mirror = true;
        this.lBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lBottom.addBox(1.1F, -0.5F, -9.2F, 1, 2, 10, 0.0F);
        this.setRotation(lBottom, -0.7546803685623481F, 0.22060961745208327F, 0.22759093446006054F);
        this.barrel = new ModelRenderer(this, 23, 20);
        this.barrel.setRotationPoint(0.0F, -1.9F, -9.0F);
        this.barrel.addBox(-1.0F, -1.0F, -4.2F, 2, 2, 5, 0.0F);
        this.setRotation(barrel, -0.15009831567151233F, 0.143116998663535F, 0.7853981633974483F);
        this.swivelHinge = new ModelRenderer(this, 16, 0);
        this.swivelHinge.setRotationPoint(0.0F, 0.3F, 11.0F);
        this.swivelHinge.addBox(-2.5F, -2.0F, -2.0F, 5, 4, 4, 0.0F);
        this.setRotation(swivelHinge, -0.5235987755982988F, 0.0F, 0.0F);
        this.supportBarTop = new ModelRenderer(this, 0, 0);
        this.supportBarTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.supportBarTop.addBox(-0.5F, -2.7F, -6.9F, 1, 1, 7, 0.0F);
        this.setRotation(supportBarTop, -0.5759586531581287F, -0.0F, 0.0F);
        this.swivelHinge.addChild(this.lTop);
        this.swivelHinge.addChild(this.bottom);
        this.swivelHinge.addChild(this.rBottom);
        this.swivelHinge.addChild(this.top);
        this.swivelHinge.addChild(this.rTop);
        this.swivelHinge.addChild(this.lBottom);
        this.supportBarTop.addChild(this.barrel);
        this.supportBar.addChild(this.swivelHinge);
        this.swivelHinge.addChild(this.supportBarTop);
    }

    @Override
    public void render(Object obj)
    {
        if (obj != null && obj instanceof EntityPlayer)
        {
            this.supportBar.rotateAngleX = (float) Math.toRadians(75);
            this.supportBar.rotateAngleZ = 0;
            this.supportBar.rotateAngleX += MathHelper.sin(idleProgress(obj) * 0.067F) * 0.05F;
            this.supportBar.rotateAngleZ += MathHelper.cos(idleProgress(obj) * 0.09F) * 0.05F + 0.05F;

            if (swingProgress(obj) > -9990.0F)
            {
//                float progress = swingProgress(obj);
//                progress = 1.0F - swingProgress(obj);
//                progress *= progress;
//                progress *= progress;
//                progress = 1.0F - progress;
//                float p1 = MathHelper.sin(progress * (float)Math.PI);
//                float p2 = -MathHelper.sin((float) (swingProgress(obj) * 0.67F)) * -(0F - 0.7F) * 0.75F;
//                
////                p1 = 0F;
////                p2 = 0F;
////                
////                p1 = swingProgress(obj);
//                this.supportBar.rotateAngleX = (float)((double)this.supportBar.rotateAngleX - ((double)p1 * 1.2D + (double)p2));
////                this.supportBar.rotateAngleZ = MathHelper.sin(swingProgress(obj) * (float)Math.PI) * -0.4F;
            }

            this.swivelHinge.rotateAngleX = (float) Math.toRadians(-30 + headPitch(obj));
            this.swivelHinge.rotateAngleZ = -headYaw(obj) / (180F / (float)Math.PI);
        }

        draw(supportBar);
    }
}
