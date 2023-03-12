package org.avp.client.model.entities.living;

import org.avp.common.entities.living.species.xenomorphs.EntityChestburster;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;


public class ModelChestburster extends Model<EntityChestburster>
{
    public ModelRenderer body1, body2, body3, body4, body5, body7, mouth, body8, body9, body10, body11, body12, body13, body14, body15, body16, tail1, tail2, tail3, tail4, tail5, tail6, tail7, body17;

    public ModelChestburster()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body4 = new ModelRenderer(this, 14, 7);
        this.body4.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body4.addBox(-2.0F, -1.7999999523162842F, 0.0F, 4, 3, 3, 0.0F);
        this.setRotation(body4, -0.8552113175392152F, 0.0F, 0.0F);
        this.body15 = new ModelRenderer(this, 58, 6);
        this.body15.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body15.addBox(0.5F, -1.2000000476837158F, -1.7000000476837158F, 1, 2, 1, 0.0F);
        this.setRotation(body15, 0.7853981852531433F, 0.0F, -0.13962629437446594F);
        this.body2 = new ModelRenderer(this, 30, 0);
        this.body2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body2.addBox(-1.5F, -1.0F, -1.0F, 3, 1, 3, 0.0F);
        this.setRotation(body2, 0.2967059910297394F, 0.0F, 0.0F);
        this.tail5 = new ModelRenderer(this, 28, 12);
        this.tail5.setRotationPoint(0.0F, 0.0F, 3.7F);
        this.tail5.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.tail6 = new ModelRenderer(this, 42, 12);
        this.tail6.setRotationPoint(0.0F, 0.4F, 4.1F);
        this.tail6.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 4, 0.0F);
        this.body16 = new ModelRenderer(this, 58, 6);
        this.body16.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body16.addBox(-1.5F, -1.2000000476837158F, -1.7000000476837158F, 1, 2, 1, 0.0F);
        this.setRotation(body16, 0.7853981852531433F, 0.0F, 0.13962629437446594F);
        this.body12 = new ModelRenderer(this, 0, 12);
        this.body12.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body12.addBox(-1.5F, -10.5F, 1.5F, 3, 9, 3, 0.0F);
        this.setRotation(body12, 1.3089970350265503F, 0.0F, 0.0F);
        this.body7 = new ModelRenderer(this, 0, 0);
        this.body7.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body7.addBox(-2.0F, -10.0F, 0.8999999761581421F, 4, 9, 3, 0.0F);
        this.setRotation(body7, 1.3089970350265503F, 0.0F, 0.0F);
        this.body9 = new ModelRenderer(this, 30, 10);
        this.body9.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body9.addBox(-2.5F, -1.7999999523162842F, -2.5F, 5, 1, 1, 0.0F);
        this.body1 = new ModelRenderer(this, 14, 0);
        this.body1.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body1.addBox(-2.0F, 0.0F, 1.0F, 4, 3, 4, 0.0F);
        this.body5 = new ModelRenderer(this, 30, 4);
        this.body5.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body5.addBox(-1.5F, -2.799999952316284F, -0.800000011920929F, 3, 3, 3, 0.0F);
        this.setRotation(body5, 0.8377580046653748F, 0.0F, 0.0F);
        this.body13 = new ModelRenderer(this, 42, 10);
        this.body13.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body13.addBox(0.5F, -1.2000000476837158F, -2.700000047683716F, 1, 0, 2, 0.0F);
        this.setRotation(body13, 0.7853981852531433F, 0.0F, -0.13962629437446594F);
        this.tail1 = new ModelRenderer(this, 12, 13);
        this.tail1.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail1.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 4, 0.0F);
        this.tail4 = new ModelRenderer(this, 28, 12);
        this.tail4.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail4.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.tail3 = new ModelRenderer(this, 28, 12);
        this.tail3.setRotationPoint(0.0F, 0.5F, 4.1F);
        this.tail3.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.mouth = new ModelRenderer(this, 54, 0);
        this.mouth.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.mouth.addBox(-1.5F, -9.0F, 1.0F, 3, 5, 1, 0.0F);
        this.setRotation(mouth, 1.4137170314788818F, 0.0F, 0.0F);
        this.body8 = new ModelRenderer(this, 42, 6);
        this.body8.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body8.addBox(-1.5F, -0.5F, -1.0F, 3, 1, 3, 0.0F);
        this.setRotation(body8, 0.2967059910297394F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 12, 13);
        this.tail2.setRotationPoint(0.0F, 22.5F, 5.0F);
        this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 4, 0.0F);
        this.body17 = new ModelRenderer(this, 28, 18);
        this.body17.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body17.addBox(-2.0F, -2.0999999046325684F, 0.4000000059604645F, 4, 2, 3, 0.0F);
        this.setRotation(body17, 1.0122909545898438F, 0.0F, 0.0F);
        this.tail7 = new ModelRenderer(this, 54, 10);
        this.tail7.setRotationPoint(0.0F, 0.0F, 4.1F);
        this.tail7.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 4, 0.0F);
        this.body14 = new ModelRenderer(this, 48, 10);
        this.body14.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body14.addBox(-1.5F, -1.2000000476837158F, -2.700000047683716F, 1, 0, 2, 0.0F);
        this.setRotation(body14, 0.7853981852531433F, 0.0F, 0.13962629437446594F);
        this.body10 = new ModelRenderer(this, 54, 6);
        this.body10.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body10.addBox(-2.0F, -1.7999999523162842F, -1.5F, 1, 3, 1, 0.0F);
        this.setRotation(body10, 0.5585054159164429F, 0.0F, 0.13962629437446594F);
        this.body11 = new ModelRenderer(this, 54, 6);
        this.body11.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body11.addBox(1.0F, -1.7999999523162842F, -1.5F, 1, 3, 1, 0.0F);
        this.setRotation(body11, 0.5585054159164429F, 0.0F, -0.13962629437446594F);
        this.body3 = new ModelRenderer(this, 42, 0);
        this.body3.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body3.addBox(-1.5F, -5.0F, -0.10000000149011612F, 3, 3, 3, 0.0F);
        this.setRotation(body3, 1.1344640254974365F, 0.0F, 0.0F);
        this.tail4.addChild(this.tail5);
        this.tail5.addChild(this.tail6);
        this.tail2.addChild(this.tail1);
        this.tail3.addChild(this.tail4);
        this.tail1.addChild(this.tail3);
        this.tail6.addChild(this.tail7);
    }
    
    @Override
    public void render(EntityChestburster obj)
    {
        EntityLivingBase base = (EntityLivingBase) obj;
        float newangle = MathHelper.cos(idleProgress(obj) * 4.0F * 0.1F) * (float) Math.PI * 0.9F * swingProgressPrev(obj);
        float distMult = 0.05F;

        if (base != null && base.prevPosX == base.posX && base.prevPosY == base.posY && base.prevPosZ == base.posZ)
        {
            newangle = newangle + MathHelper.cos(idleProgress(obj) * 0.15F);
            distMult = 0.05F;
        }

        this.tail1.rotateAngleY = newangle * distMult;
        this.tail2.rotateAngleY = newangle * distMult;
        this.tail3.rotateAngleY = newangle * distMult;
        this.tail4.rotateAngleY = newangle * distMult;
        this.tail5.rotateAngleY = newangle * distMult;
        this.tail6.rotateAngleY = newangle * distMult;
        this.tail7.rotateAngleY = newangle * distMult;
        
        draw(body4);
        draw(body15);
        draw(body2);
        draw(body16);
        draw(body12);
        draw(body7);
        draw(body9);
        draw(body1);
        draw(body5);
        draw(body13);
        draw(mouth);
        draw(body8);
        draw(tail2);
        draw(body17);
        draw(body14);
        draw(body10);
        draw(body11);
        draw(body3);
    }
}
