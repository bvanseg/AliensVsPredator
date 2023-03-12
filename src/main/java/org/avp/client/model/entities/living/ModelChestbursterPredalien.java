package org.avp.client.model.entities.living;

import org.avp.common.entities.living.species.xenomorphs.EntityPredalienChestburster;

import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;


public class ModelChestbursterPredalien extends Model<EntityPredalienChestburster>
{
    public ModelRenderer body15;
    public ModelRenderer body16;
    public ModelRenderer body13;
    public ModelRenderer body14;
    public ModelRenderer body11;
    public ModelRenderer body12;
    public ModelRenderer body10;
    public ModelRenderer body2;
    public ModelRenderer body3;
    public ModelRenderer body4;
    public ModelRenderer body5;
    public ModelRenderer body7;
    public ModelRenderer body8;
    public ModelRenderer body17;
    public ModelRenderer body9;
    public ModelRenderer tail2;
    public ModelRenderer mouth;
    public ModelRenderer body1;
    public ModelRenderer lMandible1;
    public ModelRenderer rMandible1;
    public ModelRenderer rMandibleTop;
    public ModelRenderer lMandibleTop;
    public ModelRenderer rFangLower;
    public ModelRenderer lFangLower;
    public ModelRenderer rFangTop;
    public ModelRenderer lFangTop;
    public ModelRenderer rtendon;
    public ModelRenderer ltendon;
    public ModelRenderer tail1;
    public ModelRenderer tail3;
    public ModelRenderer tail4;
    public ModelRenderer tail5;
    public ModelRenderer tail6;
    public ModelRenderer tail7;

    public ModelChestbursterPredalien()
    {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.body7 = new ModelRenderer(this, 0, 0);
        this.body7.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body7.addBox(-2.0F, -10.0F, 0.8999999761581421F, 4, 9, 3, 0.0F);
        this.setRotation(body7, 1.3089970350265503F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 12, 13);
        this.tail2.setRotationPoint(0.0F, 22.5F, 5.0F);
        this.tail2.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 4, 0.0F);
        this.body14 = new ModelRenderer(this, 48, 10);
        this.body14.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body14.addBox(-1.5F, -1.2000000476837158F, -2.700000047683716F, 1, 0, 2, 0.0F);
        this.setRotation(body14, 0.7853981852531433F, 0.0F, 0.13962629437446594F);
        this.lFangTop = new ModelRenderer(this, 5, 26);
        this.lFangTop.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lFangTop.addBox(-0.9F, -2.7F, -10.8F, 2, 1, 0, 0.0F);
        this.setRotation(lFangTop, -0.136659280431156F, -0.12217304763960307F, 0.0F);
        this.rtendon = new ModelRenderer(this, 32, 21);
        this.rtendon.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rtendon.addBox(-0.7F, -7.2F, -7.2F, 0, 3, 4, 0.0F);
        this.setRotation(rtendon, 0.36425021489121656F, 0.12217304763960307F, 0.0F);
        this.tail4 = new ModelRenderer(this, 28, 12);
        this.tail4.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail4.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.body8 = new ModelRenderer(this, 42, 6);
        this.body8.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body8.addBox(-1.5F, -0.5F, -1.0F, 3, 1, 3, 0.0F);
        this.setRotation(body8, 0.2967059910297394F, 0.0F, 0.0F);
        this.lMandible1 = new ModelRenderer(this, 15, 24);
        this.lMandible1.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lMandible1.addBox(0.0F, -4.5F, -8.4F, 1, 1, 5, 0.0F);
        this.setRotation(lMandible1, 0.36425021489121656F, -0.12217304763960307F, 0.0F);
        this.rMandibleTop = new ModelRenderer(this, 15, 24);
        this.rMandibleTop.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rMandibleTop.addBox(-1.4F, -2.7F, -11.1F, 1, 1, 5, 0.0F);
        this.setRotation(rMandibleTop, -0.136659280431156F, 0.12217304763960307F, 0.0F);
        this.body1 = new ModelRenderer(this, 14, 0);
        this.body1.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body1.addBox(-2.0F, 0.0F, 1.0F, 4, 3, 4, 0.0F);
        this.body17 = new ModelRenderer(this, 28, 18);
        this.body17.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body17.addBox(-2.0F, -2.0999999046325684F, 0.4000000059604645F, 4, 2, 3, 0.0F);
        this.setRotation(body17, 1.0122909545898438F, 0.0F, 0.0F);
        this.body15 = new ModelRenderer(this, 58, 6);
        this.body15.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body15.addBox(0.5F, -1.2000000476837158F, -1.7000000476837158F, 1, 2, 1, 0.0F);
        this.setRotation(body15, 0.7853981852531433F, 0.0F, -0.13962629437446594F);
        this.rFangLower = new ModelRenderer(this, 0, 27);
        this.rFangLower.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rFangLower.addBox(-0.5F, -6.0F, -8.2F, 0, 2, 1, 0.0F);
        this.setRotation(rFangLower, 0.36425021489121656F, 0.12217304763960307F, 0.0F);
        this.body5 = new ModelRenderer(this, 30, 4);
        this.body5.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body5.addBox(-1.5F, -2.799999952316284F, -0.800000011920929F, 3, 3, 3, 0.0F);
        this.setRotation(body5, 0.8377580046653748F, 0.0F, 0.0F);
        this.body13 = new ModelRenderer(this, 42, 10);
        this.body13.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body13.addBox(0.5F, -1.2000000476837158F, -2.700000047683716F, 1, 0, 2, 0.0F);
        this.setRotation(body13, 0.7853981852531433F, 0.0F, -0.13962629437446594F);
        this.tail7 = new ModelRenderer(this, 54, 10);
        this.tail7.setRotationPoint(0.0F, 0.0F, 4.1F);
        this.tail7.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 4, 0.0F);
        this.body3 = new ModelRenderer(this, 42, 0);
        this.body3.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body3.addBox(-1.5F, -5.0F, -0.10000000149011612F, 3, 3, 3, 0.0F);
        this.setRotation(body3, 1.1344640254974365F, 0.0F, 0.0F);
        this.body16 = new ModelRenderer(this, 58, 6);
        this.body16.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body16.addBox(-1.5F, -1.2000000476837158F, -1.7000000476837158F, 1, 2, 1, 0.0F);
        this.setRotation(body16, 0.7853981852531433F, 0.0F, 0.13962629437446594F);
        this.body11 = new ModelRenderer(this, 54, 6);
        this.body11.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body11.addBox(1.0F, -1.7999999523162842F, -1.5F, 1, 3, 1, 0.0F);
        this.setRotation(body11, 0.5585054159164429F, 0.0F, -0.13962629437446594F);
        this.rFangTop = new ModelRenderer(this, 0, 26);
        this.rFangTop.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rFangTop.addBox(-1.0F, -2.7F, -10.8F, 2, 1, 0, 0.0F);
        this.setRotation(rFangTop, -0.136659280431156F, 0.12217304763960307F, 0.0F);
        this.tail1 = new ModelRenderer(this, 12, 13);
        this.tail1.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail1.addBox(-2.0F, -1.5F, 0.0F, 4, 3, 4, 0.0F);
        this.body12 = new ModelRenderer(this, 0, 12);
        this.body12.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body12.addBox(-1.5F, -10.5F, 1.5F, 3, 9, 3, 0.0F);
        this.setRotation(body12, 1.3089970350265503F, 0.0F, 0.0F);
        this.mouth = new ModelRenderer(this, 54, 0);
        this.mouth.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.mouth.addBox(-1.5F, -9.0F, 1.0F, 3, 5, 1, 0.0F);
        this.setRotation(mouth, 1.4137170314788818F, 0.0F, 0.0F);
        this.body9 = new ModelRenderer(this, 30, 10);
        this.body9.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body9.addBox(-2.5F, -1.7999999523162842F, -2.5F, 5, 1, 1, 0.0F);
        this.lMandibleTop = new ModelRenderer(this, 15, 24);
        this.lMandibleTop.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lMandibleTop.addBox(0.4F, -2.7F, -11.1F, 1, 1, 5, 0.0F);
        this.setRotation(lMandibleTop, -0.136659280431156F, -0.12217304763960307F, 0.0F);
        this.tail3 = new ModelRenderer(this, 28, 12);
        this.tail3.setRotationPoint(0.0F, 0.5F, 4.1F);
        this.tail3.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.ltendon = new ModelRenderer(this, 32, 21);
        this.ltendon.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.ltendon.addBox(0.6F, -7.2F, -7.2F, 0, 3, 4, 0.0F);
        this.setRotation(ltendon, 0.36425021489121656F, -0.12217304763960307F, 0.0F);
        this.tail5 = new ModelRenderer(this, 28, 12);
        this.tail5.setRotationPoint(0.0F, 0.0F, 3.7F);
        this.tail5.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 4, 0.0F);
        this.body2 = new ModelRenderer(this, 30, 0);
        this.body2.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body2.addBox(-1.5F, -1.0F, -1.0F, 3, 1, 3, 0.0F);
        this.setRotation(body2, 0.2967059910297394F, 0.0F, 0.0F);
        this.body4 = new ModelRenderer(this, 14, 7);
        this.body4.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body4.addBox(-2.0F, -1.7999999523162842F, 0.0F, 4, 3, 3, 0.0F);
        this.setRotation(body4, -0.8552113175392152F, 0.0F, 0.0F);
        this.lFangLower = new ModelRenderer(this, 0, 27);
        this.lFangLower.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.lFangLower.addBox(0.5F, -6.0F, -8.2F, 0, 2, 1, 0.0F);
        this.setRotation(lFangLower, 0.36425021489121656F, -0.12217304763960307F, 0.0F);
        this.body10 = new ModelRenderer(this, 54, 6);
        this.body10.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.body10.addBox(-2.0F, -1.7999999523162842F, -1.5F, 1, 3, 1, 0.0F);
        this.setRotation(body10, 0.5585054159164429F, 0.0F, 0.13962629437446594F);
        this.rMandible1 = new ModelRenderer(this, 15, 24);
        this.rMandible1.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.rMandible1.addBox(-1.0F, -4.5F, -8.4F, 1, 1, 5, 0.0F);
        this.setRotation(rMandible1, 0.36425021489121656F, 0.12217304763960307F, 0.0F);
        this.tail6 = new ModelRenderer(this, 42, 12);
        this.tail6.setRotationPoint(0.0F, 0.4F, 4.1F);
        this.tail6.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 4, 0.0F);
        this.tail3.addChild(this.tail4);
        this.tail6.addChild(this.tail7);
        this.tail2.addChild(this.tail1);
        this.tail1.addChild(this.tail3);
        this.tail4.addChild(this.tail5);
        this.tail5.addChild(this.tail6);
    }

    @Override
    public void render(EntityPredalienChestburster obj)
    {
        EntityLivingBase base = (EntityLivingBase) obj;;

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

        draw(body7);
        draw(tail2);
        draw(body14);
        draw(lFangTop);
        draw(rtendon);
        draw(body8);
        draw(lMandible1);
        draw(rMandibleTop);
        draw(body1);
        draw(body17);
        draw(body15);
        draw(rFangLower);
        draw(body5);
        draw(body13);
        draw(body3);
        draw(body16);
        draw(body11);
        draw(rFangTop);
        draw(body12);
        draw(mouth);
        draw(body9);
        draw(lMandibleTop);
        draw(ltendon);
        draw(body2);
        draw(body4);
        draw(lFangLower);
        draw(body10);
        draw(rMandible1);
    }
}
