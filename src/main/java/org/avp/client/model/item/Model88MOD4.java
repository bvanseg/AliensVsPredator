package org.avp.client.model.item;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.api.client.render.FirearmModel;

public class Model88MOD4 extends Model<Object> implements FirearmModel
{
    public final ModelRenderer barrelRight;
    public final ModelRenderer underGrip;
    public final ModelRenderer barrelLeft;
    public final ModelRenderer rack;
    public final ModelRenderer trigger;
    public final ModelRenderer handleGrip;
    public final ModelRenderer butt1;
    public final ModelRenderer barrelNose;
    public final ModelRenderer barrelSupport;
    public final ModelRenderer gripSupport;

    public Model88MOD4()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.barrelNose = new ModelRenderer(this, 7, 25);
        this.barrelNose.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.barrelNose.addBox(0.0F, -0.7F, -2.5F, 1, 1, 2, 0.0F);
        this.butt1 = new ModelRenderer(this, 50, 0);
        this.butt1.mirror = true;
        this.butt1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.butt1.addBox(0.0F, -7.9F, 3.5F, 1, 2, 1, 0.0F);
        this.setRotation(butt1, -1.1693705988362009F, -0.0F, 0.0F);
        this.barrelLeft = new ModelRenderer(this, 25, 0);
        this.barrelLeft.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.barrelLeft.addBox(0.2F, -1.0F, -2.0F, 1, 2, 11, 0.0F);
        this.barrelSupport = new ModelRenderer(this, 14, 25);
        this.barrelSupport.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.barrelSupport.addBox(0.0F, -1.5F, -2.0F, 1, 1, 1, 0.0F);
        this.setRotation(barrelSupport, 0.767944870877505F, -0.0F, 0.0F);
        this.rack = new ModelRenderer(this, 0, 25);
        this.rack.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rack.addBox(0.0F, 1.3F, -2.0F, 1, 1, 2, 0.0F);
        this.gripSupport = new ModelRenderer(this, 43, 15);
        this.gripSupport.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.gripSupport.addBox(0.0F, 2.0F, 4.3F, 1, 3, 2, 0.0F);
        this.setRotation(gripSupport, 0.13962634015954636F, -0.0F, 0.0F);
        this.underGrip = new ModelRenderer(this, 0, 14);
        this.underGrip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.underGrip.addBox(0.0F, 0.7F, -1.5F, 1, 1, 9, 0.0F);
        this.trigger = new ModelRenderer(this, 21, 14);
        this.trigger.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.trigger.addBox(0.5F, 1.5F, 0.0F, 0, 3, 5, 0.0F);
        this.barrelRight = new ModelRenderer(this, 0, 0);
        this.barrelRight.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.barrelRight.addBox(-0.2F, -1.0F, -2.0F, 1, 2, 11, 0.0F);
        this.handleGrip = new ModelRenderer(this, 36, 15);
        this.handleGrip.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.handleGrip.addBox(0.0F, 0.5F, 4.0F, 1, 5, 2, 0.0F);
        this.setRotation(handleGrip, 0.13962634015954636F, -0.0F, 0.0F);
    }

    @Override
    public void render(Object obj)
    {
        draw(barrelNose);
        draw(butt1);
        draw(barrelLeft);
        draw(barrelSupport);
        draw(rack);
        draw(gripSupport);
        draw(underGrip);
        draw(trigger);
        draw(barrelRight);
        draw(handleGrip);        
    }

    @Override
    public ModelRenderer[] getBarrel()
    {
        return group(barrelLeft, barrelRight, barrelNose, barrelSupport);
    }

    @Override
    public ModelRenderer[] getAction()
    {
        return group(rack, underGrip, trigger, gripSupport, trigger);
    }

    @Override
    public ModelRenderer[] getStock()
    {
        return group(handleGrip, butt1, gripSupport);
    }

    @Override
    public ModelRenderer[] getScope()
    {
        return group();
    }

    @Override
    public ModelRenderer[] getPeripherals()
    {
        return group();
    }

    @Override
    public ModelRenderer[] getAccessories()
    {
        return group();
    }
}
