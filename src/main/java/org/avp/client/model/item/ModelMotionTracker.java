package org.avp.client.model.item;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;

public class ModelMotionTracker extends Model<Object>
{
    ModelRenderer handleBottom;
    ModelRenderer handle;
    ModelRenderer display;
    ModelRenderer keypad;
    ModelRenderer handleTop;
    ModelRenderer base;
    ModelRenderer sensorSupport;
    ModelRenderer sensor;

    public ModelMotionTracker()
    {
        textureWidth = 64;
        textureHeight = 32;
        handleBottom = new ModelRenderer(this, 20, 6);
        handleBottom.addBox(0F, 0F, 0F, 1, 1, 4);
        handleBottom.setRotationPoint(-0.5F, 2F, -0.5F);
        handleBottom.mirror = true;
        setRotation(handleBottom, 0F, 0F, 0F);
        handle = new ModelRenderer(this, 20, 12);
        handle.addBox(0F, 0F, 0F, 1, 5, 2);
        handle.setRotationPoint(-0.5F, -3F, -0.5F);
        handle.mirror = true;
        setRotation(handle, 0F, 0F, 0F);
        display = new ModelRenderer(this, 22, 0);
        display.addBox(0F, 0F, 0F, 4, 3, 2);
        display.setRotationPoint(1F, -2.5F, 3.4F);
        display.mirror = true;
        setRotation(display, 0F, 0F, 0F);
        keypad = new ModelRenderer(this, 11, 6);
        keypad.addBox(0F, 0F, 3F, 1, 2, 3);
        keypad.setRotationPoint(-1.3F, -1F, 0.5F);
        keypad.mirror = true;
        setRotation(keypad, 0F, 0F, 0F);
        handleTop = new ModelRenderer(this, 9, 0);
        handleTop.addBox(0F, 0F, 0F, 2, 1, 4);
        handleTop.setRotationPoint(-1F, -4F, -1F);
        handleTop.mirror = true;
        setRotation(handleTop, 0F, 0F, 0F);
        base = new ModelRenderer(this, 0, 7);
        base.addBox(0F, 0F, 0F, 2, 8, 3);
        base.setRotationPoint(-1F, -4F, 3F);
        base.mirror = true;
        setRotation(base, 0F, 0F, 0F);
        sensorSupport = new ModelRenderer(this, 0, 0);
        sensorSupport.addBox(0F, 0F, 0F, 2, 4, 2);
        sensorSupport.setRotationPoint(-1F, -2.1F, 6.3F);
        sensorSupport.mirror = true;
        setRotation(sensorSupport, -0.5759587F, 0F, 0F);
        sensor = new ModelRenderer(this, 11, 12);
        sensor.addBox(0F, 0F, 0F, 2, 3, 2);
        sensor.setRotationPoint(-1F, -4F, 6F);
        sensor.mirror = true;
        setRotation(sensor, 0F, 0F, 0F);
    }

    @Override
    public void render(Object obj)
    {
        handleBottom.render(DEFAULT_SCALE);
        handle.render(DEFAULT_SCALE);
        display.render(DEFAULT_SCALE);
        keypad.render(DEFAULT_SCALE);
        handleTop.render(DEFAULT_SCALE);
        base.render(DEFAULT_SCALE);
        sensorSupport.render(DEFAULT_SCALE);
        sensor.render(DEFAULT_SCALE);        
    }
}
