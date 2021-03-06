package org.weapon.client.model.item;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.avp.common.api.client.render.FirearmModel;

public class ModelM56SG extends Model<Object> implements FirearmModel
{
    public final ModelRenderer handleBase;
    public final ModelRenderer base;
    public final ModelRenderer ammoHolder;
    public final ModelRenderer handleWire;
    public final ModelRenderer autoTargetEye;
    public final ModelRenderer baseUnder;
    public final ModelRenderer topHandle;
    public final ModelRenderer topHandleBase;
    public final ModelRenderer barrelHolderBase;
    public final ModelRenderer barrelSupportLeft;
    public final ModelRenderer barrelSupportRight;
    public final ModelRenderer autoTargetControl;
    public final ModelRenderer barrel;
    public final ModelRenderer handle;
    public final ModelRenderer base2;
    public final ModelRenderer base3;
    public final ModelRenderer baseUnder2;
    public final ModelRenderer handleTop;
    public final ModelRenderer topHandleBase2;

    public ModelM56SG()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.handleBase = new ModelRenderer(this, 30, 0);
        this.handleBase.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1);
        this.handleBase.setRotationPoint(0.5F, 0.1F, -2.0F);
        this.handleBase.mirror = true;
        this.setRotation(this.handleBase, 0.0F, 0.0F, 0.0F);
        this.base = new ModelRenderer(this, 37, 0);
        this.base.addBox(-0.5F, 0.0F, 0.0F, 1, 2, 2);
        this.base.setRotationPoint(1.5F, 0.2F, 1.0F);
        this.base.mirror = true;
        this.setRotation(this.base, 0.0F, 0.0F, 0.0F);
        this.ammoHolder = new ModelRenderer(this, 0, 7);
        this.ammoHolder.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3);
        this.ammoHolder.setRotationPoint(0.0F, 0.0F, 2.9F);
        this.ammoHolder.mirror = true;
        this.setRotation(this.ammoHolder, 0.0F, 0.0F, 0.0F);
        this.handleWire = new ModelRenderer(this, 44, 0);
        this.handleWire.addBox(0.0F, 0.0F, 0.0F, 2, 0, 4);
        this.handleWire.setRotationPoint(0.5F, 1.7F, -1.0F);
        this.handleWire.mirror = true;
        this.setRotation(this.handleWire, 0.0F, 0.0F, 0.0F);
        this.autoTargetEye = new ModelRenderer(this, 19, 5);
        this.autoTargetEye.addBox(0.0F, 0.0F, 0.0F, 1, 1, 3);
        this.autoTargetEye.setRotationPoint(1.0F, -0.1F, 10.5F);
        this.autoTargetEye.mirror = true;
        this.setRotation(this.autoTargetEye, 0.0F, 0.0F, 0.0F);
        this.baseUnder = new ModelRenderer(this, 19, 0);
        this.baseUnder.addBox(0.0F, -1.0F, -0.6F, 2, 1, 3);
        this.baseUnder.setRotationPoint(0.5F, 2.0F, 8.5F);
        this.baseUnder.mirror = true;
        this.setRotation(this.baseUnder, ((float) Math.PI / 10F), 0.0F, 0.0F);
        this.topHandle = new ModelRenderer(this, 28, 5);
        this.topHandle.addBox(0.0F, 0.0F, 0.0F, 5, 1, 1);
        this.topHandle.setRotationPoint(-2.5F, -0.9F, 9.0F);
        this.topHandle.mirror = true;
        this.setRotation(this.topHandle, -0.418879F, 0.0F, 0.0F);
        this.topHandleBase = new ModelRenderer(this, 7, 24);
        this.topHandleBase.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
        this.topHandleBase.setRotationPoint(0.4F, -0.5F, 9.5F);
        this.topHandleBase.mirror = true;
        this.setRotation(this.topHandleBase, 0.0F, 0.0F, 0.0F);
        this.barrelHolderBase = new ModelRenderer(this, 28, 8);
        this.barrelHolderBase.addBox(0.0F, 1.0F, 5.0F, 2, 1, 1);
        this.barrelHolderBase.setRotationPoint(0.5F, -0.5F, 8.9F);
        this.barrelHolderBase.mirror = true;
        this.setRotation(this.barrelHolderBase, 0.0F, 0.0F, 0.0F);
        this.barrelSupportLeft = new ModelRenderer(this, 19, 10);
        this.barrelSupportLeft.addBox(0.0F, 0.0F, 0.0F, 0, 1, 4);
        this.barrelSupportLeft.setRotationPoint(0.7F, -0.4F, 11.03333F);
        this.barrelSupportLeft.mirror = true;
        this.setRotation(this.barrelSupportLeft, -0.2094395F, 0.0F, 0.0F);
        this.barrelSupportRight = new ModelRenderer(this, 19, 16);
        this.barrelSupportRight.addBox(0.0F, 0.0F, 0.0F, 0, 1, 4);
        this.barrelSupportRight.setRotationPoint(2.3F, -0.4F, 11.0F);
        this.barrelSupportRight.mirror = true;
        this.setRotation(this.barrelSupportRight, -0.2094395F, 0.0F, 0.0F);
        this.autoTargetControl = new ModelRenderer(this, 11, 7);
        this.autoTargetControl.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2);
        this.autoTargetControl.setRotationPoint(1.0F, -0.9F, 9.0F);
        this.autoTargetControl.mirror = true;
        this.setRotation(this.autoTargetControl, 0.0F, 0.0F, 0.0F);
        this.barrel = new ModelRenderer(this, 28, 11);
        this.barrel.addBox(0.0F, 0.0F, 0.0F, 1, 1, 9);
        this.barrel.setRotationPoint(1.0F, 0.4F, 10.0F);
        this.barrel.mirror = true;
        this.setRotation(this.barrel, 0.0F, 0.0F, 0.0F);
        this.handle = new ModelRenderer(this, 19, 23);
        this.handle.addBox(-0.5F, 0.0F, 1.0F, 0, 1, 4);
        this.handle.setRotationPoint(2.0F, 2.2F, -6.8F);
        this.handle.mirror = true;
        this.setRotation(this.handle, 0.2792527F, 0.0F, 0.0F);
        this.base2 = new ModelRenderer(this, 0, 15);
        this.base2.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 7);
        this.base2.setRotationPoint(1.5F, 0.2F, 3.0F);
        this.base2.mirror = true;
        this.setRotation(this.base2, 0.0F, 0.0F, 0.0F);
        this.base3 = new ModelRenderer(this, 11, 11);
        this.base3.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 2);
        this.base3.setRotationPoint(1.5F, 0.2F, -1.0F);
        this.base3.mirror = true;
        this.setRotation(this.base3, 0.0F, 0.0F, 0.0F);
        this.baseUnder2 = new ModelRenderer(this, 0, 0);
        this.baseUnder2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 5);
        this.baseUnder2.setRotationPoint(0.5F, 1.2F, 2.9F);
        this.baseUnder2.mirror = true;
        this.setRotation(this.baseUnder2, 0.0F, 0.0F, 0.0F);
        this.handleTop = new ModelRenderer(this, 41, 5);
        this.handleTop.addBox(-0.5F, 0.0F, 0.0F, 1, 1, 4);
        this.handleTop.setRotationPoint(1.5F, 0.2F, -6.0F);
        this.handleTop.mirror = true;
        this.setRotation(this.handleTop, 0.0F, 0.0F, 0.0F);
        this.topHandleBase2 = new ModelRenderer(this, 0, 24);
        this.topHandleBase2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 2);
        this.topHandleBase2.setRotationPoint(1.6F, -0.5F, 9.5F);
        this.topHandleBase2.mirror = true;
        this.setRotation(this.topHandleBase2, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(Object obj)
    {
        draw(handleBase);
        draw(base);
        draw(ammoHolder);
        draw(handleWire);
        draw(autoTargetEye);
        draw(baseUnder);
        draw(topHandle);
        draw(topHandleBase);
        draw(barrelHolderBase);
        draw(barrelSupportLeft);
        draw(barrelSupportRight);
        draw(autoTargetControl);
        draw(barrel);
        draw(handle);
        draw(base2);
        draw(base3);
        draw(baseUnder2);
        draw(handleTop);
        draw(topHandleBase2);        
    }

    @Override
    public ModelRenderer[] getBarrel()
    {
        return group(barrel, barrelHolderBase);
    }

    @Override
    public ModelRenderer[] getAction()
    {
        return group(base, base2, base3, baseUnder, baseUnder2, ammoHolder, topHandle, topHandleBase, topHandleBase2);
    }

    @Override
    public ModelRenderer[] getStock()
    {
        return group(handle, handleBase, handleTop, handleWire);
    }

    @Override
    public ModelRenderer[] getScope()
    {
        return group();
    }

    @Override
    public ModelRenderer[] getPeripherals()
    {
        return group(barrelSupportLeft, barrelSupportRight);
    }

    @Override
    public ModelRenderer[] getAccessories()
    {
        return group(autoTargetControl, autoTargetEye);
    }
}
