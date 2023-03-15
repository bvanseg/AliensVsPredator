package org.alien.client.model.entity.living;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import org.alien.common.entity.living.SpeciesEngineer;


public class ModelEngineer extends Model<SpeciesEngineer>
{
    public final ModelRenderer chest;
    public final ModelRenderer stomach;
    public final ModelRenderer lThigh;
    public final ModelRenderer rThigh;
    public final ModelRenderer lShin;
    public final ModelRenderer rShin;
    public final ModelRenderer lFoot;
    public final ModelRenderer rFoot;
    public final ModelRenderer lArmUpper;
    public final ModelRenderer lArmLower;
    public final ModelRenderer rArmUpper;
    public final ModelRenderer lArmLower_1;
    public final ModelRenderer neck;
    public final ModelRenderer head1;
    public final ModelRenderer head2;
    public final ModelRenderer nozzle1;
    public final ModelRenderer nozzle2;
    public final ModelRenderer nozzle3a;
    public final ModelRenderer nozzle3b;
    public final ModelRenderer nozzle3c;
    public final ModelRenderer nozzle3d;
    public final ModelRenderer hose;
    public final ModelRenderer rJaw;
    public final ModelRenderer lJaw;
    public final ModelRenderer sexyFace;

    public ModelEngineer()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.nozzle3c = new ModelRenderer(this, 57, 5);
        this.nozzle3c.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.nozzle3c.addBox(-0.699999988079071F, -4.699999809265137F, -2.4000000953674316F, 1, 1, 2, 0.0F);
        this.setRotation(nozzle3c, 1.2217304706573486F, -0.0F, 0.0F);
        this.rShin = new ModelRenderer(this, 71, 35);
        this.rShin.setRotationPoint(-1.5F, 9.0F, 0.0F);
        this.rShin.addBox(-1.5F, 6.0F, -3.0F, 2, 8, 3, 0.0F);
        this.setRotation(rShin, 0.05235987901687623F, -0.0F, 0.05235987901687623F);
        this.lArmUpper = new ModelRenderer(this, 55, 22);
        this.lArmUpper.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.lArmUpper.addBox(0.0F, 0.0F, -1.0F, 2, 6, 3, 0.0F);
        this.setRotation(lArmUpper, -0.12217304855585097F, -0.0F, -0.2617993950843811F);
        this.head1 = new ModelRenderer(this, 17, 0);
        this.head1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head1.addBox(-2.5F, -6.0F, -2.5F, 5, 4, 4, 0.0F);
        this.setRotation(head1, 0.12217304855585097F, -0.0F, 0.0F);
        this.nozzle1 = new ModelRenderer(this, 36, 0);
        this.nozzle1.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.nozzle1.addBox(-1.5F, -4.800000190734863F, -1.2000000476837158F, 3, 2, 2, 0.0F);
        this.setRotation(nozzle1, 0.7330383062362671F, -0.0F, 0.0F);
        this.rFoot = new ModelRenderer(this, 71, 47);
        this.rFoot.setRotationPoint(-1.5F, 9.0F, 0.0F);
        this.rFoot.addBox(-2.299999952316284F, 13.0F, -4.199999809265137F, 2, 2, 5, 0.0F);
        this.lThigh = new ModelRenderer(this, 88, 22);
        this.lThigh.setRotationPoint(1.5F, 9.0F, 0.0F);
        this.lThigh.addBox(-1.0F, 0.0F, -2.0F, 3, 8, 4, 0.0F);
        this.setRotation(lThigh, -0.13962633907794952F, -0.0F, -0.05235987901687623F);
        this.lFoot = new ModelRenderer(this, 88, 47);
        this.lFoot.setRotationPoint(1.5F, 9.0F, 0.0F);
        this.lFoot.addBox(0.20000000298023224F, 13.0F, -4.199999809265137F, 2, 2, 5, 0.0F);
        this.rJaw = new ModelRenderer(this, 17, 9);
        this.rJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rJaw.addBox(-2.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F);
        this.setRotation(rJaw, 0.8157965990099155F, -0.18959362787687614F, -0.1599701935335199F);
        this.rThigh = new ModelRenderer(this, 71, 22);
        this.rThigh.setRotationPoint(-1.5F, 9.0F, 0.0F);
        this.rThigh.addBox(-2.0F, 0.0F, -2.0F, 3, 8, 4, 0.0F);
        this.setRotation(rThigh, -0.13962633907794952F, -0.0F, 0.05235987901687623F);
        this.rArmUpper = new ModelRenderer(this, 44, 22);
        this.rArmUpper.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.rArmUpper.addBox(-2.0F, 0.0F, -1.0F, 2, 6, 3, 0.0F);
        this.setRotation(rArmUpper, -0.12217304855585097F, -0.0F, 0.2617993950843811F);
        this.lShin = new ModelRenderer(this, 88, 35);
        this.lShin.setRotationPoint(1.5F, 9.0F, 0.0F);
        this.lShin.addBox(-0.5F, 6.0F, -3.0F, 2, 8, 3, 0.0F);
        this.setRotation(lShin, 0.05235987901687623F, -0.0F, -0.05235987901687623F);
        this.nozzle2 = new ModelRenderer(this, 47, 0);
        this.nozzle2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.nozzle2.addBox(-1.0F, -4.900000095367432F, -2.299999952316284F, 2, 2, 2, 0.0F);
        this.setRotation(nozzle2, 0.9250245094299316F, -0.0F, 0.0F);
        this.lArmLower = new ModelRenderer(this, 55, 33);
        this.lArmLower.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.lArmLower.addBox(-0.4000000059604645F, 5.0F, 0.30000001192092896F, 2, 7, 2, 0.0F);
        this.setRotation(lArmLower, -0.2617993950843811F, -0.0F, -0.33161255717277527F);
        this.nozzle3a = new ModelRenderer(this, 57, 0);
        this.nozzle3a.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.nozzle3a.addBox(-0.699999988079071F, -5.199999809265137F, -2.4000000953674316F, 1, 1, 2, 0.0F);
        this.setRotation(nozzle3a, 1.2217304706573486F, -0.0F, 0.0F);
        this.lJaw = new ModelRenderer(this, 32, 9);
        this.lJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lJaw.addBox(1.0F, -4.0F, -2.0F, 1, 1, 4, 0.0F);
        this.setRotation(lJaw, 0.8157965990099155F, 0.18959362787687614F, 0.1599701935335199F);
        this.stomach = new ModelRenderer(this, 0, 36);
        this.stomach.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.stomach.addBox(-2.5F, 3.0F, -2.5F, 5, 7, 5, 0.0F);
        this.chest = new ModelRenderer(this, 0, 23);
        this.chest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.chest.addBox(-3.0F, -1.0F, -3.0F, 6, 6, 6, 0.0F);
        this.nozzle3b = new ModelRenderer(this, 64, 0);
        this.nozzle3b.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.nozzle3b.addBox(-0.30000001192092896F, -5.199999809265137F, -2.4000000953674316F, 1, 1, 2, 0.0F);
        this.setRotation(nozzle3b, 1.2217304706573486F, -0.0F, 0.0F);
        this.sexyFace = new ModelRenderer(this, 82, 0);
        this.sexyFace.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.sexyFace.addBox(-2.5F, -6.0F, -2.5F, 5, 5, 5, 0.0F);
        this.hose = new ModelRenderer(this, 71, 0);
        this.hose.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.hose.addBox(-0.5F, -1.0F, -5.5F, 1, 3, 1, 0.0F);
        this.setRotation(hose, 0.19198621809482574F, -0.0F, 0.0F);
        this.lArmLower_1 = new ModelRenderer(this, 44, 33);
        this.lArmLower_1.setRotationPoint(-2.0F, 0.0F, 0.0F);
        this.lArmLower_1.addBox(-1.600000023841858F, 5.0F, 0.30000001192092896F, 2, 7, 2, 0.0F);
        this.setRotation(lArmLower_1, -0.2617993950843811F, -0.0F, 0.33161255717277527F);
        this.neck = new ModelRenderer(this, 0, 15);
        this.neck.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.neck.addBox(-2.0F, -2.5F, -2.0F, 4, 3, 4, 0.0F);
        this.setRotation(neck, 0.12217304855585097F, -0.0F, 0.0F);
        this.nozzle3d = new ModelRenderer(this, 64, 5);
        this.nozzle3d.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.nozzle3d.addBox(-0.30000001192092896F, -4.699999809265137F, -2.4000000953674316F, 1, 1, 2, 0.0F);
        this.setRotation(nozzle3d, 1.2217304706573486F, -0.0F, 0.0F);
        this.head2 = new ModelRenderer(this, 0, 0);
        this.head2.setRotationPoint(0.0F, -1.0F, 0.0F);
        this.head2.addBox(-2.0F, -5.900000095367432F, -1.0F, 4, 5, 4, 0.0F);
        this.setRotation(head2, -0.03490658476948738F, -0.0F, 0.0F);
    }

    @Override
    public void render(SpeciesEngineer obj)
    {
        this.lShin.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.0F * swingProgressPrev(obj);
        this.lThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.0F * swingProgressPrev(obj) - 0.2014257F;
        this.lFoot.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.0F * swingProgressPrev(obj);

        this.rShin.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.0F * swingProgressPrev(obj);
        this.rThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.0F * swingProgressPrev(obj) - 0.2014257F;
        this.rFoot.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.0F * swingProgressPrev(obj);

        this.rArmUpper.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.13F;
        this.lArmLower_1.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 1.4F * swingProgressPrev(obj) - 0.3F;

        this.lArmUpper.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.1F * swingProgressPrev(obj) - 0.13F;
        this.lArmLower.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 1.1F * swingProgressPrev(obj) - 0.3F;

        draw(rShin);
        draw(lArmUpper);
        draw(rFoot);
        draw(lThigh);
        draw(lFoot);
        draw(rThigh);
        draw(rArmUpper);
        draw(lShin);
        draw(lArmLower);
        draw(stomach);
        draw(chest);
        draw(lArmLower_1);
        draw(neck);

        if (obj != null && obj.isWearingMask() || obj == null)
        {
            draw(nozzle3c);
            draw(head1);
            draw(nozzle1);
            draw(nozzle3b);
            draw(nozzle3d);
            draw(head2);
            draw(hose);
            draw(lJaw);
            draw(nozzle3a);
            draw(nozzle2);
            draw(rJaw);
        }
        else
        {
            draw(sexyFace);
        }       
    }
}
