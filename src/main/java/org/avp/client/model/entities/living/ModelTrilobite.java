package org.avp.client.model.entities.living;

import static com.asx.mdx.lib.client.model.animations.AnimationHelper.bob;
import static com.asx.mdx.lib.client.model.animations.AnimationHelper.flap;
import static com.asx.mdx.lib.client.model.animations.AnimationHelper.swing;

import org.avp.entities.living.species.species223ode.EntityTrilobite;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;

public class ModelTrilobite extends Model<EntityTrilobite>
{
    public Part body;
    public Part smallToobBase;
    public Part lowerBody;
    public Part lFrontTenticle1;
    public Part rFrontTenticle1;
    public Part lMiddleTenticle1;
    public Part rMiddleTenticle1;
    public Part lJaw;
    public Part rJaw;
    public Part lFrontPetal;
    public Part rFrontPetal;
    public Part lMiddlePetal;
    public Part rMiddlePetal;
    public Part lBackPetal;
    public Part rBackPetal;
    public Part tube01;
    public Part lBackTenticle1;
    public Part rBackTenticle1;
    public Part tail;
    public Part tailPetal;
    public Part lBackTenticle2;
    public Part lBackTenticle3;
    public Part lBackTenticle4;
    public Part lBackTenticle5;
    public Part lBackClaw;
    public Part rBackTenticle2;
    public Part rBackTenticle3;
    public Part rBackTenticle4;
    public Part rBackTenticle5;
    public Part rBackClaw;
    public Part tail2;
    public Part tail3;
    public Part tail4;
    public Part tail5;
    public Part tailClaw;
    public Part lFrontTenticle2;
    public Part lFrontTenticle3;
    public Part lFrontTenticle4;
    public Part lFrontTenticle5;
    public Part lFrontClaw;
    public Part rFrontTenticle2;
    public Part rFrontTenticle3;
    public Part rFrontTenticle4;
    public Part rFrontTenticle5;
    public Part rFrontClaw;
    public Part lMiddleTenticle2;
    public Part lMiddleTenticle3;
    public Part lMiddleTenticle4;
    public Part lMiddleTenticle5;
    public Part lMiddleClaw;
    public Part rMiddleTenticle2;
    public Part rMiddleTenticle3;
    public Part rMiddleTenticle4;
    public Part rMiddleTenticle5;
    public Part rMiddleClaw;
    public Part tube02;
    public Part tube03;
    public Part tube04;
    public Part tube05;
    public Part tube06;
    public Part tube07;
    public Part tube08;
    public Part tube09;
    public Part tube10;
    public Part tube11;
    public Part tube12;
    public Part lFrontSmallTube01;
    public Part rFrontSmallTube01;
    public Part lMiddleSmallTube01;
    public Part rMiddleSmallTube01;
    public Part lBackSmallTube01;
    public Part rBackSmallTube01;
    public Part tailSmallTube01;
    public Part lFrontSmallTube02;
    public Part lFrontSmallTube03;
    public Part lFrontSmallTube04;
    public Part lFrontSmallTube05;
    public Part lFrontSmallTube06;
    public Part lFrontSmallTube07;
    public Part lFrontSmallTube08;
    public Part lFrontSmallTube09;
    public Part lFrontSmallTube10;
    public Part lFrontSmallTube11;
    public Part lFrontSmallTube12;
    public Part rFrontSmallTube02;
    public Part rFrontSmallTube03;
    public Part rFrontSmallTube04;
    public Part rFrontSmallTube05;
    public Part rFrontSmallTube06;
    public Part rFrontSmallTube07;
    public Part rFrontSmallTube08;
    public Part rFrontSmallTube09;
    public Part rFrontSmallTube10;
    public Part rFrontSmallTube11;
    public Part rFrontSmallTube12;
    public Part lMiddleSmallTube02;
    public Part lMiddleSmallTube03;
    public Part lMiddleSmallTube04;
    public Part lMiddleSmallTube05;
    public Part lMiddleSmallTube06;
    public Part lMiddleSmallTube07;
    public Part lMiddleSmallTube08;
    public Part lMiddleSmallTube09;
    public Part lMiddleSmallTube10;
    public Part lMiddleSmallTube11;
    public Part lMiddleSmallTube12;
    public Part rMiddleSmallTube02;
    public Part rMiddleSmallTube03;
    public Part rMiddleSmallTube04;
    public Part rMiddleSmallTube05;
    public Part rMiddleSmallTube06;
    public Part rMiddleSmallTube07;
    public Part rMiddleSmallTube08;
    public Part rMiddleSmallTube09;
    public Part rMiddleSmallTube10;
    public Part rMiddleSmallTube11;
    public Part rMiddleSmallTube12;
    public Part lBackSmallTube02;
    public Part lBackSmallTube03;
    public Part lBackSmallTube04;
    public Part lBackSmallTube05;
    public Part lBackSmallTube06;
    public Part lBackSmallTube07;
    public Part lBackSmallTube08;
    public Part lBackSmallTube09;
    public Part lBackSmallTube10;
    public Part lBackSmallTube11;
    public Part lBackSmallTube12;
    public Part rBackSmallTube02;
    public Part rBackSmallTube03;
    public Part rBackSmallTube04;
    public Part rBackSmallTube05;
    public Part rBackSmallTube06;
    public Part rBackSmallTube07;
    public Part rBackSmallTube08;
    public Part rBackSmallTube09;
    public Part rBackSmallTube10;
    public Part rBackSmallTube11;
    public Part rBackSmallTube12;
    public Part tailSmallTube02;
    public Part tailSmallTube03;
    public Part tailSmallTube04;
    public Part tailSmallTube05;
    public Part tailSmallTube06;
    public Part tailSmallTube07;
    public Part tailSmallTube08;
    public Part tailSmallTube09;
    public Part tailSmallTube10;
    public Part tailSmallTube11;
    public Part tailSmallTube12;

    public ModelTrilobite()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.rFrontSmallTube08 = new Part(this, 92, 6);
        this.rFrontSmallTube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontSmallTube01 = new Part(this, 92, 6);
        this.lFrontSmallTube01.setRotationPoint(-3.0F, 1.5F, -2.4F);
        this.lFrontSmallTube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackTenticle1 = new Part(this, 30, 8);
        this.rBackTenticle1.mirror = true;
        this.rBackTenticle1.setRotationPoint(-1.7F, 0.0F, 2.4F);
        this.rBackTenticle1.addBox(-4.0F, -1.0F, -1.5F, 4, 2, 3, 0.0F);
        this.setRotation(rBackTenticle1, 0.17453292519943295F, 0.5410520681182421F, -0.17453292519943295F);
        this.lBackSmallTube10 = new Part(this, 92, 6);
        this.lBackSmallTube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube12 = new Part(this, 99, 6);
        this.lBackSmallTube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube03 = new Part(this, 92, 0);
        this.tube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.setRotation(tube03, -0.136659280431156F, 0.0F, 0.0F);
        this.lFrontSmallTube08 = new Part(this, 92, 6);
        this.lFrontSmallTube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontSmallTube01 = new Part(this, 92, 6);
        this.rFrontSmallTube01.setRotationPoint(3.0F, 1.5F, -2.4F);
        this.rFrontSmallTube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleTenticle4 = new Part(this, 27, 28);
        this.rMiddleTenticle4.mirror = true;
        this.rMiddleTenticle4.setRotationPoint(-5.6F, 0.0F, 0.0F);
        this.rMiddleTenticle4.addBox(-6.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(rMiddleTenticle4, 0.0F, 0.0F, 0.45378560551852565F);
        this.rFrontSmallTube03 = new Part(this, 92, 6);
        this.rFrontSmallTube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube09 = new Part(this, 92, 6);
        this.tailSmallTube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube03 = new Part(this, 92, 6);
        this.rBackSmallTube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube06 = new Part(this, 92, 6);
        this.rMiddleSmallTube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackTenticle1 = new Part(this, 30, 8);
        this.lBackTenticle1.setRotationPoint(1.7F, 0.0F, 2.4F);
        this.lBackTenticle1.addBox(0.0F, -1.0F, -1.5F, 4, 2, 3, 0.0F);
        this.setRotation(lBackTenticle1, 0.17453292519943295F, -0.5410520681182421F, 0.17453292519943295F);
        this.rMiddleTenticle1 = new Part(this, 30, 8);
        this.rMiddleTenticle1.mirror = true;
        this.rMiddleTenticle1.setRotationPoint(-2.5F, 0.0F, 1.0F);
        this.rMiddleTenticle1.addBox(-4.0F, -1.0F, -1.5F, 4, 2, 3, 0.0F);
        this.setRotation(rMiddleTenticle1, 0.0F, 0.0F, -0.3141592653589793F);
        this.rBackSmallTube12 = new Part(this, 99, 6);
        this.rBackSmallTube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontSmallTube02 = new Part(this, 92, 6);
        this.rFrontSmallTube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontSmallTube11 = new Part(this, 92, 6);
        this.rFrontSmallTube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube04 = new Part(this, 92, 6);
        this.tailSmallTube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube03 = new Part(this, 92, 6);
        this.rMiddleSmallTube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleTenticle4 = new Part(this, 27, 28);
        this.lMiddleTenticle4.setRotationPoint(5.6F, 0.5F, 0.0F);
        this.lMiddleTenticle4.addBox(0.0F, -1.5F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(lMiddleTenticle4, 0.0F, 0.0F, -0.45378560551852565F);
        this.lBackPetal = new Part(this, 81, 45);
        this.lBackPetal.setRotationPoint(1.4F, 0.9F, 3.9F);
        this.lBackPetal.addBox(0.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotation(lBackPetal, -0.5759586531581287F, 0.45378560551852565F, 2.0943951023931953F);
        this.lMiddleSmallTube08 = new Part(this, 92, 6);
        this.lMiddleSmallTube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube01 = new Part(this, 92, 6);
        this.rMiddleSmallTube01.setRotationPoint(3.6F, 1.5F, 1.2F);
        this.rMiddleSmallTube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleTenticle5 = new Part(this, 27, 36);
        this.rMiddleTenticle5.mirror = true;
        this.rMiddleTenticle5.setRotationPoint(-5.8F, 0.0F, 0.0F);
        this.rMiddleTenticle5.addBox(-7.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotation(rMiddleTenticle5, 0.0F, 0.0F, 0.4886921905584123F);
        this.lBackTenticle5 = new Part(this, 27, 36);
        this.lBackTenticle5.setRotationPoint(5.7F, -0.5F, 0.0F);
        this.lBackTenticle5.addBox(0.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotation(lBackTenticle5, 0.0F, 0.0F, -0.41887902047863906F);
        this.tube02 = new Part(this, 92, 0);
        this.tube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontSmallTube05 = new Part(this, 92, 6);
        this.rFrontSmallTube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube07 = new Part(this, 92, 6);
        this.rMiddleSmallTube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube10 = new Part(this, 92, 6);
        this.tailSmallTube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleTenticle1 = new Part(this, 30, 8);
        this.lMiddleTenticle1.setRotationPoint(2.5F, 0.0F, 1.0F);
        this.lMiddleTenticle1.addBox(0.0F, -1.0F, -1.5F, 4, 2, 3, 0.0F);
        this.setRotation(lMiddleTenticle1, 0.0F, 0.0F, 0.3141592653589793F);
        this.lFrontSmallTube09 = new Part(this, 92, 6);
        this.lFrontSmallTube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackTenticle3 = new Part(this, 27, 21);
        this.rBackTenticle3.mirror = true;
        this.rBackTenticle3.setRotationPoint(-6.7F, 0.0F, 0.0F);
        this.rBackTenticle3.addBox(-6.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(rBackTenticle3, 0.0F, 0.0F, -0.2617993877991494F);
        this.rBackTenticle4 = new Part(this, 27, 28);
        this.rBackTenticle4.mirror = true;
        this.rBackTenticle4.setRotationPoint(-5.8F, 0.0F, 0.0F);
        this.rBackTenticle4.addBox(-6.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(rBackTenticle4, 0.0F, 0.0F, 0.4886921905584123F);
        this.rBackSmallTube10 = new Part(this, 92, 6);
        this.rBackSmallTube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddlePetal = new Part(this, 81, 41);
        this.lMiddlePetal.setRotationPoint(2.8F, 1.1F, 1.0F);
        this.lMiddlePetal.addBox(0.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotation(lMiddlePetal, -0.03490658503988659F, 0.0F, 2.443460952792061F);
        this.lMiddleTenticle2 = new Part(this, 25, 14);
        this.lMiddleTenticle2.setRotationPoint(3.7F, 0.0F, 0.0F);
        this.lMiddleTenticle2.addBox(0.0F, -1.0F, -2.0F, 7, 2, 4, 0.0F);
        this.setRotation(lMiddleTenticle2, 0.0F, 0.0F, 0.22689280275926282F);
        this.lFrontSmallTube11 = new Part(this, 92, 6);
        this.lFrontSmallTube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackTenticle2 = new Part(this, 25, 14);
        this.lBackTenticle2.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.lBackTenticle2.addBox(0.0F, -1.0F, -2.0F, 7, 2, 4, 0.0F);
        this.setRotation(lBackTenticle2, 0.0F, 0.0F, 0.3141592653589793F);
        this.lBackSmallTube11 = new Part(this, 92, 6);
        this.lBackSmallTube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontTenticle2 = new Part(this, 0, 15);
        this.lFrontTenticle2.setRotationPoint(2.7F, -0.2F, 0.0F);
        this.lFrontTenticle2.addBox(0.0F, -1.0F, -2.0F, 7, 2, 4, 0.0F);
        this.setRotation(lFrontTenticle2, 0.0F, 0.0F, 0.45378560551852565F);
        this.lFrontClaw = new Part(this, 0, 39);
        this.lFrontClaw.setRotationPoint(7.0F, 0.1F, 0.0F);
        this.lFrontClaw.addBox(0.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.lMiddleSmallTube04 = new Part(this, 92, 6);
        this.lMiddleSmallTube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube05 = new Part(this, 92, 0);
        this.tube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube05 = new Part(this, 92, 6);
        this.rBackSmallTube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleTenticle5 = new Part(this, 27, 36);
        this.lMiddleTenticle5.setRotationPoint(5.8F, -0.5F, 0.0F);
        this.lMiddleTenticle5.addBox(0.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotation(lMiddleTenticle5, 0.0F, 0.0F, -0.4886921905584123F);
        this.tailSmallTube01 = new Part(this, 92, 6);
        this.tailSmallTube01.setRotationPoint(0.0F, 1.2F, 6.2F);
        this.tailSmallTube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontSmallTube05 = new Part(this, 92, 6);
        this.lFrontSmallTube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontTenticle5 = new Part(this, 0, 35);
        this.lFrontTenticle5.setRotationPoint(5.9F, 0.0F, 0.0F);
        this.lFrontTenticle5.addBox(0.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotation(lFrontTenticle5, 0.0F, 0.0F, -0.3665191429188092F);
        this.rBackPetal = new Part(this, 81, 45);
        this.rBackPetal.mirror = true;
        this.rBackPetal.setRotationPoint(-1.4F, 0.9F, 4.0F);
        this.rBackPetal.addBox(-3.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotation(rBackPetal, -0.5759586531581287F, 0.0F, -2.0943951023931953F);
        this.lBackTenticle4 = new Part(this, 27, 28);
        this.lBackTenticle4.setRotationPoint(5.8F, 0.5F, 0.0F);
        this.lBackTenticle4.addBox(0.0F, -1.5F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(lBackTenticle4, 0.0F, 0.0F, -0.4886921905584123F);
        this.lFrontSmallTube02 = new Part(this, 92, 6);
        this.lFrontSmallTube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube06 = new Part(this, 92, 6);
        this.tailSmallTube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleTenticle3 = new Part(this, 27, 21);
        this.lMiddleTenticle3.setRotationPoint(6.8F, 0.0F, 0.0F);
        this.lMiddleTenticle3.addBox(0.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(lMiddleTenticle3, 0.0F, 0.0F, 0.40142572795869574F);
        this.rBackSmallTube02 = new Part(this, 92, 6);
        this.rBackSmallTube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontTenticle4 = new Part(this, 0, 28);
        this.rFrontTenticle4.mirror = true;
        this.rFrontTenticle4.setRotationPoint(-6.0F, 0.0F, 0.0F);
        this.rFrontTenticle4.addBox(-6.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(rFrontTenticle4, 0.0F, 0.0F, 0.2617993877991494F);
        this.rBackSmallTube01 = new Part(this, 92, 6);
        this.rBackSmallTube01.setRotationPoint(2.6F, 1.0F, 4.6F);
        this.rBackSmallTube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube03 = new Part(this, 92, 6);
        this.lBackSmallTube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube07 = new Part(this, 92, 6);
        this.tailSmallTube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.smallToobBase = new Part(this, 0, 0);
        this.smallToobBase.setRotationPoint(0.0F, 11.4F, 0.0F);
        this.smallToobBase.addBox(-0.5F, -0.5F, -0.5F, 1, 1, 1, 0.0F);
        this.lJaw = new Part(this, 5, 48);
        this.lJaw.setRotationPoint(0.3F, 1.2F, -0.1F);
        this.lJaw.addBox(-0.2F, 0.0F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotation(lJaw, 0.032812189937493394F, -0.08098327729253688F, -0.3853686988403479F);
        this.tail3 = new Part(this, 56, 18);
        this.tail3.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.tail3.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 6, 0.0F);
        this.setRotation(tail3, 0.13962634015954636F, 0.0F, 0.0F);
        this.rFrontSmallTube09 = new Part(this, 92, 6);
        this.rFrontSmallTube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube09 = new Part(this, 92, 6);
        this.lMiddleSmallTube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontTenticle1 = new Part(this, 0, 53);
        this.rFrontTenticle1.mirror = true;
        this.rFrontTenticle1.setRotationPoint(-2.2F, 0.0F, -2.1F);
        this.rFrontTenticle1.addBox(-3.2F, -1.0F, -1.5F, 4, 2, 3, 0.0F);
        this.setRotation(rFrontTenticle1, 0.45378560551852565F, -0.7155849933176751F, -0.593411945678072F);
        this.lFrontTenticle3 = new Part(this, 0, 22);
        this.lFrontTenticle3.setRotationPoint(6.9F, 0.0F, 0.0F);
        this.lFrontTenticle3.addBox(0.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(lFrontTenticle3, 0.0F, 0.0F, -0.22689280275926282F);
        this.rMiddleTenticle3 = new Part(this, 27, 21);
        this.rMiddleTenticle3.mirror = true;
        this.rMiddleTenticle3.setRotationPoint(-6.8F, 0.0F, 0.0F);
        this.rMiddleTenticle3.addBox(-6.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(rMiddleTenticle3, 0.0F, 0.0F, -0.40142572795869574F);
        this.lBackSmallTube01 = new Part(this, 92, 6);
        this.lBackSmallTube01.setRotationPoint(-2.6F, 1.0F, 4.6F);
        this.lBackSmallTube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackTenticle5 = new Part(this, 27, 36);
        this.rBackTenticle5.mirror = true;
        this.rBackTenticle5.setRotationPoint(-5.7F, 0.0F, 0.0F);
        this.rBackTenticle5.addBox(-7.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotation(rBackTenticle5, 0.0F, 0.0F, 0.4886921905584123F);
        this.tube11 = new Part(this, 92, 0);
        this.tube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddlePetal = new Part(this, 81, 41);
        this.rMiddlePetal.mirror = true;
        this.rMiddlePetal.setRotationPoint(-2.8F, 1.1F, 1.0F);
        this.rMiddlePetal.addBox(-3.0F, -0.5F, -1.0F, 3, 1, 2, 0.0F);
        this.setRotation(rMiddlePetal, -0.03490658503988659F, 0.0F, -2.443460952792061F);
        this.lBackTenticle3 = new Part(this, 27, 21);
        this.lBackTenticle3.setRotationPoint(7.0F, 0.0F, 0.0F);
        this.lBackTenticle3.addBox(0.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(lBackTenticle3, 0.0F, 0.0F, 0.2617993877991494F);
        this.rFrontSmallTube10 = new Part(this, 92, 6);
        this.rFrontSmallTube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontSmallTube06 = new Part(this, 92, 6);
        this.lFrontSmallTube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lowerBody = new Part(this, 25, 0);
        this.lowerBody.setRotationPoint(0.0F, 0.0F, 2.2F);
        this.lowerBody.addBox(-2.5F, -1.0F, 0.0F, 5, 2, 4, 0.0F);
        this.setRotation(lowerBody, -0.33161255787892263F, -0.0F, 0.0F);
        this.body = new Part(this, 0, 0);
        this.body.setRotationPoint(0.0F, 11.4F, 0.0F);
        this.body.addBox(-3.0F, -1.5F, -3.0F, 6, 3, 6, 0.0F);
        this.tailSmallTube08 = new Part(this, 92, 6);
        this.tailSmallTube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontSmallTube07 = new Part(this, 92, 6);
        this.rFrontSmallTube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube05 = new Part(this, 92, 6);
        this.lBackSmallTube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackTenticle2 = new Part(this, 25, 14);
        this.rBackTenticle2.mirror = true;
        this.rBackTenticle2.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.rBackTenticle2.addBox(-7.0F, -1.0F, -2.0F, 7, 2, 4, 0.0F);
        this.setRotation(rBackTenticle2, 0.0F, 0.0F, -0.3141592653589793F);
        this.rMiddleSmallTube10 = new Part(this, 92, 6);
        this.rMiddleSmallTube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube09 = new Part(this, 92, 6);
        this.rBackSmallTube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube11 = new Part(this, 92, 6);
        this.tailSmallTube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontPetal = new Part(this, 81, 37);
        this.rFrontPetal.mirror = true;
        this.rFrontPetal.setRotationPoint(-2.6F, 1.0F, -1.5F);
        this.rFrontPetal.addBox(-4.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotation(rFrontPetal, 0.17453292519943295F, -0.3490658503988659F, -2.6179938779914944F);
        this.lMiddleSmallTube02 = new Part(this, 92, 6);
        this.lMiddleSmallTube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube07 = new Part(this, 92, 6);
        this.rBackSmallTube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube07 = new Part(this, 92, 6);
        this.lMiddleSmallTube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube10 = new Part(this, 92, 6);
        this.lMiddleSmallTube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube07 = new Part(this, 92, 6);
        this.lBackSmallTube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube04 = new Part(this, 92, 6);
        this.rBackSmallTube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube06 = new Part(this, 92, 6);
        this.lBackSmallTube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontTenticle1 = new Part(this, 0, 53);
        this.lFrontTenticle1.setRotationPoint(2.2F, 0.0F, -2.1F);
        this.lFrontTenticle1.addBox(-0.8F, -1.0F, -1.5F, 4, 2, 3, 0.0F);
        this.setRotation(lFrontTenticle1, 0.45378560551852565F, 0.7155849933176751F, 0.593411945678072F);
        this.rMiddleTenticle2 = new Part(this, 25, 14);
        this.rMiddleTenticle2.mirror = true;
        this.rMiddleTenticle2.setRotationPoint(-3.7F, 0.0F, 0.0F);
        this.rMiddleTenticle2.addBox(-7.0F, -1.0F, -2.0F, 7, 2, 4, 0.0F);
        this.setRotation(rMiddleTenticle2, 0.0F, 0.0F, -0.22689280275926282F);
        this.lMiddleSmallTube05 = new Part(this, 92, 6);
        this.lMiddleSmallTube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube03 = new Part(this, 92, 6);
        this.tailSmallTube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleClaw = new Part(this, 31, 41);
        this.lMiddleClaw.setRotationPoint(7.0F, 0.0F, 0.0F);
        this.lMiddleClaw.addBox(0.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.tailSmallTube05 = new Part(this, 92, 6);
        this.tailSmallTube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontTenticle2 = new Part(this, 0, 15);
        this.rFrontTenticle2.mirror = true;
        this.rFrontTenticle2.setRotationPoint(-2.7F, -0.2F, 0.0F);
        this.rFrontTenticle2.addBox(-7.0F, -1.0F, -2.0F, 7, 2, 4, 0.0F);
        this.setRotation(rFrontTenticle2, 0.0F, 0.0F, -0.45378560551852565F);
        this.rFrontTenticle5 = new Part(this, 0, 35);
        this.rFrontTenticle5.mirror = true;
        this.rFrontTenticle5.setRotationPoint(-5.9F, 0.0F, 0.0F);
        this.rFrontTenticle5.addBox(-7.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F);
        this.setRotation(rFrontTenticle5, 0.0F, 0.0F, 0.3665191429188092F);
        this.tube07 = new Part(this, 92, 0);
        this.tube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube04 = new Part(this, 92, 6);
        this.rMiddleSmallTube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube02 = new Part(this, 92, 6);
        this.lBackSmallTube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailClaw = new Part(this, 57, 49);
        this.tailClaw.setRotationPoint(0.0F, 0.0F, 7.0F);
        this.tailClaw.addBox(-1.5F, 0.0F, 0.0F, 3, 0, 5, 0.0F);
        this.lBackSmallTube08 = new Part(this, 92, 6);
        this.lBackSmallTube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube11 = new Part(this, 92, 6);
        this.rBackSmallTube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontSmallTube07 = new Part(this, 92, 6);
        this.lFrontSmallTube07.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube07.addBox(-0.5F, -7.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube11 = new Part(this, 92, 6);
        this.lMiddleSmallTube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube01 = new Part(this, 92, 0);
        this.tube01.setRotationPoint(0.0F, 1.2F, 0.4F);
        this.tube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rJaw = new Part(this, 5, 48);
        this.rJaw.mirror = true;
        this.rJaw.setRotationPoint(-0.3F, 1.2F, -0.1F);
        this.rJaw.addBox(-0.8F, 0.0F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotation(rJaw, 0.032812189937493394F, 0.08098327729253688F, 0.3853686988403479F);
        this.rFrontClaw = new Part(this, 0, 39);
        this.rFrontClaw.mirror = true;
        this.rFrontClaw.setRotationPoint(-7.0F, 0.0F, 0.0F);
        this.rFrontClaw.addBox(-5.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.tail = new Part(this, 60, 0);
        this.tail.setRotationPoint(0.0F, 0.0F, 4.0F);
        this.tail.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 3, 0.0F);
        this.rMiddleSmallTube08 = new Part(this, 92, 6);
        this.rMiddleSmallTube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube12 = new Part(this, 99, 6);
        this.rMiddleSmallTube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tail4 = new Part(this, 56, 28);
        this.tail4.setRotationPoint(0.0F, 0.0F, 5.6F);
        this.tail4.addBox(-1.5F, -1.0F, 0.0F, 3, 2, 6, 0.0F);
        this.setRotation(tail4, 0.3665191429188092F, 0.0F, 0.0F);
        this.rMiddleSmallTube09 = new Part(this, 92, 6);
        this.rMiddleSmallTube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontTenticle3 = new Part(this, 0, 22);
        this.rFrontTenticle3.mirror = true;
        this.rFrontTenticle3.setRotationPoint(-6.9F, 0.0F, 0.0F);
        this.rFrontTenticle3.addBox(-6.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(rFrontTenticle3, 0.0F, 0.0F, 0.22689280275926282F);
        this.tailPetal = new Part(this, 89, 50);
        this.tailPetal.setRotationPoint(0.0F, 0.6F, 4.0F);
        this.tailPetal.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotation(tailPetal, -2.443460952792061F, -0.0F, 0.0F);
        this.rBackClaw = new Part(this, 31, 41);
        this.rBackClaw.mirror = true;
        this.rBackClaw.setRotationPoint(-7.0F, 0.0F, 0.0F);
        this.rBackClaw.addBox(-5.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.tail2 = new Part(this, 54, 7);
        this.tail2.setRotationPoint(0.0F, 0.0F, 2.7F);
        this.tail2.addBox(-2.0F, -1.0F, 0.0F, 4, 2, 7, 0.0F);
        this.setRotation(tail2, -0.45378560551852565F, 0.0F, 0.0F);
        this.lFrontSmallTube10 = new Part(this, 92, 6);
        this.lFrontSmallTube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube12 = new Part(this, 99, 6);
        this.lMiddleSmallTube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube09 = new Part(this, 92, 6);
        this.lBackSmallTube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube02 = new Part(this, 92, 6);
        this.tailSmallTube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube02 = new Part(this, 92, 6);
        this.rMiddleSmallTube02.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube02.addBox(-0.5F, -2.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube06 = new Part(this, 92, 6);
        this.lMiddleSmallTube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontSmallTube12 = new Part(this, 99, 6);
        this.lFrontSmallTube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube12 = new Part(this, 92, 0);
        this.tube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontSmallTube04 = new Part(this, 92, 6);
        this.lFrontSmallTube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontTenticle4 = new Part(this, 0, 28);
        this.lFrontTenticle4.setRotationPoint(6.0F, 0.0F, 0.0F);
        this.lFrontTenticle4.addBox(0.0F, -1.0F, -1.5F, 6, 2, 3, 0.0F);
        this.setRotation(lFrontTenticle4, 0.0F, 0.0F, -0.2617993877991494F);
        this.rFrontSmallTube12 = new Part(this, 99, 6);
        this.rFrontSmallTube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackClaw = new Part(this, 31, 41);
        this.lBackClaw.setRotationPoint(7.0F, 0.0F, 0.0F);
        this.lBackClaw.addBox(0.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.lFrontPetal = new Part(this, 81, 37);
        this.lFrontPetal.setRotationPoint(2.6F, 1.0F, -1.5F);
        this.lFrontPetal.addBox(0.0F, -0.5F, -1.0F, 4, 1, 2, 0.0F);
        this.setRotation(lFrontPetal, 0.17453292519943295F, 0.3490658503988659F, 2.6179938779914944F);
        this.rMiddleClaw = new Part(this, 31, 41);
        this.rMiddleClaw.mirror = true;
        this.rMiddleClaw.setRotationPoint(-7.0F, 0.0F, 0.0F);
        this.rMiddleClaw.addBox(-5.0F, 0.0F, -1.5F, 5, 0, 3, 0.0F);
        this.tube08 = new Part(this, 92, 0);
        this.tube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube06 = new Part(this, 92, 0);
        this.tube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube09 = new Part(this, 92, 0);
        this.tube09.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube09.addBox(-0.5F, -9.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube10 = new Part(this, 92, 0);
        this.tube10.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube10.addBox(-0.5F, -10.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube11 = new Part(this, 92, 6);
        this.rMiddleSmallTube11.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube11.addBox(-0.5F, -11.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rMiddleSmallTube05 = new Part(this, 92, 6);
        this.rMiddleSmallTube05.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rMiddleSmallTube05.addBox(-0.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontSmallTube06 = new Part(this, 92, 6);
        this.rFrontSmallTube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rFrontSmallTube04 = new Part(this, 92, 6);
        this.rFrontSmallTube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rFrontSmallTube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lFrontSmallTube03 = new Part(this, 92, 6);
        this.lFrontSmallTube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lFrontSmallTube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lBackSmallTube04 = new Part(this, 92, 6);
        this.lBackSmallTube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lBackSmallTube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube03 = new Part(this, 92, 6);
        this.lMiddleSmallTube03.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.lMiddleSmallTube03.addBox(-0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube08 = new Part(this, 92, 6);
        this.rBackSmallTube08.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube08.addBox(-0.5F, -8.0F, -0.5F, 1, 1, 1, 0.0F);
        this.rBackSmallTube06 = new Part(this, 92, 6);
        this.rBackSmallTube06.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.rBackSmallTube06.addBox(-0.5F, -6.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tailSmallTube12 = new Part(this, 92, 0);
        this.tailSmallTube12.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tailSmallTube12.addBox(-0.5F, -12.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tube04 = new Part(this, 92, 0);
        this.tube04.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.tube04.addBox(-0.5F, -4.0F, -0.5F, 1, 1, 1, 0.0F);
        this.lMiddleSmallTube01 = new Part(this, 92, 6);
        this.lMiddleSmallTube01.setRotationPoint(-3.6F, 1.5F, 1.2F);
        this.lMiddleSmallTube01.addBox(-0.5F, -1.0F, -0.5F, 1, 1, 1, 0.0F);
        this.tail5 = new Part(this, 56, 38);
        this.tail5.setRotationPoint(0.0F, 0.0F, 5.7F);
        this.tail5.addBox(-1.0F, -0.5F, 0.0F, 2, 1, 7, 0.0F);
        this.setRotation(tail5, 0.3141592653589793F, 0.0F, 0.0F);
        this.rFrontSmallTube07.addChild(this.rFrontSmallTube08);
        this.smallToobBase.addChild(this.lFrontSmallTube01);
        this.lowerBody.addChild(this.rBackTenticle1);
        this.lBackSmallTube09.addChild(this.lBackSmallTube10);
        this.lBackSmallTube11.addChild(this.lBackSmallTube12);
        this.tube02.addChild(this.tube03);
        this.lFrontSmallTube07.addChild(this.lFrontSmallTube08);
        this.smallToobBase.addChild(this.rFrontSmallTube01);
        this.rMiddleTenticle3.addChild(this.rMiddleTenticle4);
        this.rFrontSmallTube02.addChild(this.rFrontSmallTube03);
        this.tailSmallTube08.addChild(this.tailSmallTube09);
        this.rBackSmallTube02.addChild(this.rBackSmallTube03);
        this.rMiddleSmallTube05.addChild(this.rMiddleSmallTube06);
        this.lowerBody.addChild(this.lBackTenticle1);
        this.body.addChild(this.rMiddleTenticle1);
        this.rBackSmallTube11.addChild(this.rBackSmallTube12);
        this.rFrontSmallTube01.addChild(this.rFrontSmallTube02);
        this.rFrontSmallTube10.addChild(this.rFrontSmallTube11);
        this.tailSmallTube03.addChild(this.tailSmallTube04);
        this.rMiddleSmallTube02.addChild(this.rMiddleSmallTube03);
        this.lMiddleTenticle3.addChild(this.lMiddleTenticle4);
        this.body.addChild(this.lBackPetal);
        this.lMiddleSmallTube07.addChild(this.lMiddleSmallTube08);
        this.smallToobBase.addChild(this.rMiddleSmallTube01);
        this.rMiddleTenticle4.addChild(this.rMiddleTenticle5);
        this.lBackTenticle4.addChild(this.lBackTenticle5);
        this.tube01.addChild(this.tube02);
        this.rFrontSmallTube04.addChild(this.rFrontSmallTube05);
        this.rMiddleSmallTube06.addChild(this.rMiddleSmallTube07);
        this.tailSmallTube09.addChild(this.tailSmallTube10);
        this.body.addChild(this.lMiddleTenticle1);
        this.lFrontSmallTube08.addChild(this.lFrontSmallTube09);
        this.rBackTenticle2.addChild(this.rBackTenticle3);
        this.rBackTenticle3.addChild(this.rBackTenticle4);
        this.rBackSmallTube09.addChild(this.rBackSmallTube10);
        this.body.addChild(this.lMiddlePetal);
        this.lMiddleTenticle1.addChild(this.lMiddleTenticle2);
        this.lFrontSmallTube10.addChild(this.lFrontSmallTube11);
        this.lBackTenticle1.addChild(this.lBackTenticle2);
        this.lBackSmallTube10.addChild(this.lBackSmallTube11);
        this.lFrontTenticle1.addChild(this.lFrontTenticle2);
        this.lFrontTenticle5.addChild(this.lFrontClaw);
        this.lMiddleSmallTube03.addChild(this.lMiddleSmallTube04);
        this.tube04.addChild(this.tube05);
        this.rBackSmallTube04.addChild(this.rBackSmallTube05);
        this.lMiddleTenticle4.addChild(this.lMiddleTenticle5);
        this.smallToobBase.addChild(this.tailSmallTube01);
        this.lFrontSmallTube04.addChild(this.lFrontSmallTube05);
        this.lFrontTenticle4.addChild(this.lFrontTenticle5);
        this.body.addChild(this.rBackPetal);
        this.lBackTenticle3.addChild(this.lBackTenticle4);
        this.lFrontSmallTube01.addChild(this.lFrontSmallTube02);
        this.tailSmallTube05.addChild(this.tailSmallTube06);
        this.lMiddleTenticle2.addChild(this.lMiddleTenticle3);
        this.rBackSmallTube01.addChild(this.rBackSmallTube02);
        this.rFrontTenticle3.addChild(this.rFrontTenticle4);
        this.smallToobBase.addChild(this.rBackSmallTube01);
        this.lBackSmallTube02.addChild(this.lBackSmallTube03);
        this.tailSmallTube06.addChild(this.tailSmallTube07);
        this.body.addChild(this.lJaw);
        this.tail2.addChild(this.tail3);
        this.rFrontSmallTube08.addChild(this.rFrontSmallTube09);
        this.lMiddleSmallTube08.addChild(this.lMiddleSmallTube09);
        this.body.addChild(this.rFrontTenticle1);
        this.lFrontTenticle2.addChild(this.lFrontTenticle3);
        this.rMiddleTenticle2.addChild(this.rMiddleTenticle3);
        this.smallToobBase.addChild(this.lBackSmallTube01);
        this.rBackTenticle4.addChild(this.rBackTenticle5);
        this.tube10.addChild(this.tube11);
        this.body.addChild(this.rMiddlePetal);
        this.lBackTenticle2.addChild(this.lBackTenticle3);
        this.rFrontSmallTube09.addChild(this.rFrontSmallTube10);
        this.lFrontSmallTube05.addChild(this.lFrontSmallTube06);
        this.body.addChild(this.lowerBody);
        this.tailSmallTube07.addChild(this.tailSmallTube08);
        this.rFrontSmallTube06.addChild(this.rFrontSmallTube07);
        this.lBackSmallTube04.addChild(this.lBackSmallTube05);
        this.rBackTenticle1.addChild(this.rBackTenticle2);
        this.rMiddleSmallTube09.addChild(this.rMiddleSmallTube10);
        this.rBackSmallTube08.addChild(this.rBackSmallTube09);
        this.tailSmallTube10.addChild(this.tailSmallTube11);
        this.body.addChild(this.rFrontPetal);
        this.lMiddleSmallTube01.addChild(this.lMiddleSmallTube02);
        this.rBackSmallTube06.addChild(this.rBackSmallTube07);
        this.lMiddleSmallTube06.addChild(this.lMiddleSmallTube07);
        this.lMiddleSmallTube09.addChild(this.lMiddleSmallTube10);
        this.lBackSmallTube06.addChild(this.lBackSmallTube07);
        this.rBackSmallTube03.addChild(this.rBackSmallTube04);
        this.lBackSmallTube05.addChild(this.lBackSmallTube06);
        this.body.addChild(this.lFrontTenticle1);
        this.rMiddleTenticle1.addChild(this.rMiddleTenticle2);
        this.lMiddleSmallTube04.addChild(this.lMiddleSmallTube05);
        this.tailSmallTube02.addChild(this.tailSmallTube03);
        this.lMiddleTenticle5.addChild(this.lMiddleClaw);
        this.tailSmallTube04.addChild(this.tailSmallTube05);
        this.rFrontTenticle1.addChild(this.rFrontTenticle2);
        this.rFrontTenticle4.addChild(this.rFrontTenticle5);
        this.tube06.addChild(this.tube07);
        this.rMiddleSmallTube03.addChild(this.rMiddleSmallTube04);
        this.lBackSmallTube01.addChild(this.lBackSmallTube02);
        this.tail5.addChild(this.tailClaw);
        this.lBackSmallTube07.addChild(this.lBackSmallTube08);
        this.rBackSmallTube10.addChild(this.rBackSmallTube11);
        this.lFrontSmallTube06.addChild(this.lFrontSmallTube07);
        this.lMiddleSmallTube10.addChild(this.lMiddleSmallTube11);
        this.body.addChild(this.tube01);
        this.body.addChild(this.rJaw);
        this.rFrontTenticle5.addChild(this.rFrontClaw);
        this.lowerBody.addChild(this.tail);
        this.rMiddleSmallTube07.addChild(this.rMiddleSmallTube08);
        this.rMiddleSmallTube11.addChild(this.rMiddleSmallTube12);
        this.tail3.addChild(this.tail4);
        this.rMiddleSmallTube08.addChild(this.rMiddleSmallTube09);
        this.rFrontTenticle2.addChild(this.rFrontTenticle3);
        this.lowerBody.addChild(this.tailPetal);
        this.rBackTenticle5.addChild(this.rBackClaw);
        this.tail.addChild(this.tail2);
        this.lFrontSmallTube09.addChild(this.lFrontSmallTube10);
        this.lMiddleSmallTube11.addChild(this.lMiddleSmallTube12);
        this.lBackSmallTube08.addChild(this.lBackSmallTube09);
        this.tailSmallTube01.addChild(this.tailSmallTube02);
        this.rMiddleSmallTube01.addChild(this.rMiddleSmallTube02);
        this.lMiddleSmallTube05.addChild(this.lMiddleSmallTube06);
        this.lFrontSmallTube11.addChild(this.lFrontSmallTube12);
        this.tube11.addChild(this.tube12);
        this.lFrontSmallTube03.addChild(this.lFrontSmallTube04);
        this.lFrontTenticle3.addChild(this.lFrontTenticle4);
        this.rFrontSmallTube11.addChild(this.rFrontSmallTube12);
        this.lBackTenticle5.addChild(this.lBackClaw);
        this.body.addChild(this.lFrontPetal);
        this.rMiddleTenticle5.addChild(this.rMiddleClaw);
        this.tube07.addChild(this.tube08);
        this.tube05.addChild(this.tube06);
        this.tube08.addChild(this.tube09);
        this.tube09.addChild(this.tube10);
        this.rMiddleSmallTube10.addChild(this.rMiddleSmallTube11);
        this.rMiddleSmallTube04.addChild(this.rMiddleSmallTube05);
        this.rFrontSmallTube05.addChild(this.rFrontSmallTube06);
        this.rFrontSmallTube03.addChild(this.rFrontSmallTube04);
        this.lFrontSmallTube02.addChild(this.lFrontSmallTube03);
        this.lBackSmallTube03.addChild(this.lBackSmallTube04);
        this.lMiddleSmallTube02.addChild(this.lMiddleSmallTube03);
        this.rBackSmallTube07.addChild(this.rBackSmallTube08);
        this.rBackSmallTube05.addChild(this.rBackSmallTube06);
        this.tailSmallTube11.addChild(this.tailSmallTube12);
        this.tube03.addChild(this.tube04);
        this.smallToobBase.addChild(this.lMiddleSmallTube01);
        this.tail4.addChild(this.tail5);

        updateDefaultPose();
    }

    public Model.Part getTentacleById(int i)
    {
        switch (i)
        {
            case 0:
                return this.tail;
            case 1:
                return this.lFrontTenticle1;
            case 2:
                return this.rFrontTenticle1;
            case 3:
                return this.lMiddleTenticle1;
            case 4:
                return this.rMiddleTenticle1;
            case 5:
                return this.lBackTenticle1;
            case 6:
                return this.rBackTenticle1;
            default:
                return null;
        }
    }

    @Override
    public void render(EntityTrilobite trilobite)
    {
        if (trilobite != null)
        {
            animate(trilobite);

            if (!trilobite.isFertile())
            {
                int[] tentacles = trilobite.getDetachedTentacles();

                for (int i = 0; i < trilobite.getAmountOfTentacles(); i++)
                {
                    Model.Part tentacle = getTentacleById(i);

                    if (tentacle != null)
                    {
                        boolean hidden = tentacles[i] == 1 ? true : false;
                        tentacle.isHidden = hidden;
                    }
                }
            }

            if (!trilobite.isFertile() && !this.isRiding)
            {
                dead(trilobite, true);
                OpenGL.translate(0F, 0.8F, 0F);
            }

            OpenGL.translate(0F, 0F, -0.3925F);

            if (this.isRiding)
            {
                OpenGL.rotate(180F, 0, 1, 0);
                OpenGL.translate(0F, 0F, 0.25F);

                if (trilobite.getRidingEntity() != null)
                {
                    EntityLivingBase riding = (EntityLivingBase) trilobite.getRidingEntity();

                    float maxRot = 100F;
                    float offset = maxRot + -Game.minecraft().player.eyeHeight;

                    offset = offset + -(maxRot * riding.getEyeHeight() / Game.minecraft().player.getEyeHeight());
                    offset = offset + 1.0F;

                    animator.rotateTo(tube01, offset, 0.0F, 0.0F, true);
                    animator.rotateTo(lFrontSmallTube01, offset, 0.0F, 0.0F, true);
                    animator.rotateTo(rFrontSmallTube01, offset, 0.0F, 0.0F, true);
                    animator.rotateTo(lMiddleSmallTube01, offset, 0.0F, 0.0F, true);
                    animator.rotateTo(rMiddleSmallTube01, offset, 0.0F, 0.0F, true);
                    animator.rotateTo(lBackSmallTube01, offset, 0.0F, 0.0F, true);
                    animator.rotateTo(rBackSmallTube01, offset, 0.0F, 0.0F, true);
                    animator.rotateTo(tailSmallTube01, offset, 0.0F, 0.0F, true);
                }
            }
        }

        OpenGL.translate(0F, -0.1F, 0F);

        GlStateManager.pushMatrix();
        GlStateManager.translate(this.smallToobBase.offsetX, this.smallToobBase.offsetY, this.smallToobBase.offsetZ);
        GlStateManager.translate(this.smallToobBase.rotationPointX * DEFAULT_SCALE, this.smallToobBase.rotationPointY * DEFAULT_SCALE, this.smallToobBase.rotationPointZ * DEFAULT_SCALE);
        GlStateManager.scale(0.6D, 0.9D, 0.6D);
        GlStateManager.translate(-this.smallToobBase.offsetX, -this.smallToobBase.offsetY, -this.smallToobBase.offsetZ);
        GlStateManager.translate(-this.smallToobBase.rotationPointX * DEFAULT_SCALE, -this.smallToobBase.rotationPointY * DEFAULT_SCALE, -this.smallToobBase.rotationPointZ * DEFAULT_SCALE);
        draw(smallToobBase);

        GlStateManager.popMatrix();
        draw(body);
    }

    public void setRotationAngles(EntityTrilobite trilobite)
    {
        updateAnimations(trilobite);

        float speed = (float) (Math.PI * 0.2F);
        float mult = 0.8F;

        float sp = swingProgress(trilobite);
        float spp = swingProgressPrev(trilobite);

        bob(body, speed, 1.5F, true, sp, spp);
        flap(body, 1F * speed, 0.1F * mult, false, 0.5F, 0F, sp - 10, spp);
        swing(body, 1F * speed, -0.5F * mult, false, -0.5F, 0F, sp - 10, spp);

        flap(rFrontTenticle1, 1F * speed, 0.8F * mult, false, 0.5F, 0F, sp - 10, spp);
        flap(rFrontTenticle2, 1F * speed, 0.6F * mult, false, -0.5F, 0F, sp - 10, spp);
        flap(rFrontTenticle3, 1F * speed, -0.7F * mult, false, -0.5F, 0F, sp - 10, spp);
        flap(rFrontTenticle4, 1F * speed, -0.8F * mult, false, -0.5F, 0F, sp - 10, spp);
        flap(rFrontTenticle5, 1F * speed, -0.5F * mult, false, -0.5F, 0F, sp - 10, spp);
        flap(rFrontClaw, 1F * speed, 0.9F * mult, false, -0.5F, 0F, sp - 10, spp);

        swing(rMiddleTenticle1, 1F * speed, 0.5F * mult, false, 0.5F, 0F, sp - 10, spp);
        flap(rMiddleTenticle1, 1F * speed, 0.1F * mult, false, 0.5F, 0F, sp, spp);
        flap(rMiddleTenticle2, 1F * speed, 0.4F * mult, false, -0.5F, 0F, sp, spp);
        flap(rMiddleTenticle3, 1F * speed, -0.3F * mult, false, -0.5F, 0F, sp, spp);
        swing(rMiddleTenticle3, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp, spp);
        flap(rMiddleTenticle4, 1F * speed, -0.3F * mult, false, -0.5F, 0F, sp, spp);
        swing(rMiddleTenticle4, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp, spp);
        flap(rMiddleTenticle5, 1F * speed, -0.2F * mult, false, -0.5F, 0F, sp, spp);
        swing(rMiddleTenticle5, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp, spp);

        swing(rBackTenticle1, 1F * speed, 0.3F * mult, false, 0.5F, 0F, sp + 5, spp);
        flap(rBackTenticle1, 1F * speed, 0.1F * mult, false, 0.5F, 0F, sp - 15, spp);
        flap(rBackTenticle2, 1F * speed, 0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        flap(rBackTenticle3, 1F * speed, -0.7F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(rBackTenticle3, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        flap(rBackTenticle4, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(rBackTenticle4, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        flap(rBackTenticle5, 1F * speed, 0.9F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(rBackTenticle5, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);

        flap(lFrontTenticle1, 1F * speed, 0.8F * mult, false, 0.5F, 0F, sp - 10, spp);
        flap(lFrontTenticle2, 1F * speed, 0.6F * mult, false, -0.5F, 0F, sp - 10, spp);
        flap(lFrontTenticle3, 1F * speed, -0.7F * mult, false, -0.5F, 0F, sp - 10, spp);
        flap(lFrontTenticle4, 1F * speed, -0.8F * mult, false, -0.5F, 0F, sp - 10, spp);
        flap(lFrontTenticle5, 1F * speed, -0.5F * mult, false, -0.5F, 0F, sp - 10, spp);

        swing(lMiddleTenticle1, 1F * speed, 0.5F * mult, false, 0.5F, 0F, sp - 10, spp);
        flap(lMiddleTenticle1, 1F * speed, 0.1F * mult, false, 0.5F, 0F, sp, spp);
        flap(lMiddleTenticle2, 1F * speed, 0.4F * mult, false, -0.5F, 0F, sp, spp);
        flap(lMiddleTenticle3, 1F * speed, -0.3F * mult, false, -0.5F, 0F, sp, spp);
        swing(lMiddleTenticle3, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp, spp);
        flap(lMiddleTenticle4, 1F * speed, -0.3F * mult, false, -0.5F, 0F, sp, spp);
        swing(lMiddleTenticle4, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp, spp);
        flap(lMiddleTenticle5, 1F * speed, -0.2F * mult, false, -0.5F, 0F, sp, spp);
        swing(lMiddleTenticle5, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp, spp);

        swing(lBackTenticle1, 1F * speed, 0.3F * mult, false, 0.5F, 0F, sp + 5, spp);
        flap(lBackTenticle1, 1F * speed, 0.1F * mult, false, 0.5F, 0F, sp - 15, spp);
        flap(lBackTenticle2, 1F * speed, 0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        flap(lBackTenticle3, 1F * speed, -0.7F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(lBackTenticle3, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        flap(lBackTenticle4, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(lBackTenticle4, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        flap(lBackTenticle5, 1F * speed, 0.9F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(lBackTenticle5, 1F * speed, -0.6F * mult, false, -0.5F, 0F, sp - 15, spp);

        swing(tail, 1F * speed, 0.8F * mult, false, 0.5F, 0F, sp - 15, spp);
        swing(tail2, 1F * speed, 0.6F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(tail3, 1F * speed, -0.7F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(tail4, 1F * speed, -0.8F * mult, false, -0.5F, 0F, sp - 15, spp);
        swing(tail5, 1F * speed, -0.5F * mult, false, -0.5F, 0F, sp - 15, spp);
    }

    public void standUp(EntityTrilobite trilobite)
    {
        /** Stand up **/
        animator.rotateTo(body, -44.35F, 0.0F, 0.0F);
        animator.rotateTo(lBackTenticle1, 68.0F, 24.0F, -30.0F);
        animator.rotateTo(lBackTenticle2, -13.0F, 26.0F, 13.0F);
        animator.rotateTo(lBackTenticle3, -23.0F, -33.0F, 0.0F);
        animator.rotateTo(lBackTenticle4, 0.0F, 62.0F, 2.0F);
        animator.rotateTo(lBackTenticle5, 26.0F, 41.0F, 34.0F);
        animator.rotateTo(rBackTenticle1, 57.0F, 0.0F, 0.0F);
        animator.rotateTo(rBackTenticle2, -10.0F, 41.0F, 7.0F);
        animator.rotateTo(rBackTenticle3, -39.0F, 21.0F, 0.0F);
        animator.rotateTo(rBackTenticle4, -20.0F, 39.0F, -21.0F);
        animator.rotateTo(rBackTenticle5, 10.0F, -44.0F, -23.0F);
        animator.rotateTo(tail, 41.0F, 0.0F, 0.0F);
        animator.rotateTo(tail2, 28.0F, -0.0F, 0.0F);
        animator.rotateTo(tail3, -21.0F, 44.0F, 10.0F);
        animator.rotateTo(tail4, 20.0F, -41.0F, -20.0F);
        animator.rotateTo(tail5, -16.0F, -33.0F, -13.0F);
        animator.rotateTo(tailPetal, 41.0F, 0.0F, 0.0F);
        animator.rotateTo(lFrontTenticle1, -6.0F, 0.740000000000002F, 0.0F);
        animator.rotateTo(lFrontTenticle2, 0.0F, 0.0F, -46.0F);
        animator.rotateTo(lFrontTenticle3, 0.0F, 0.0F, 33.0F);
        animator.rotateTo(lFrontTenticle4, 0.0F, 0.0F, 35.0F);
        animator.rotateTo(lFrontTenticle5, 0.0F, 0.0F, 41.0F);
        animator.rotateTo(rFrontTenticle1, -6.0F, -0.740000000000002F, 0.0F);
        animator.rotateTo(rFrontTenticle2, 0.0F, 0.0F, 46.0F);
        animator.rotateTo(rFrontTenticle3, 0.0F, 0.0F, -33.0F);
        animator.rotateTo(rFrontTenticle4, 0.0F, 0.0F, -35.0F);
        animator.rotateTo(rFrontTenticle5, 0.0F, 0.0F, -41.0F);
        animator.rotateTo(lMiddleTenticle1, -28.0F, 0.0F, 0.0F);
        animator.rotateTo(lMiddleTenticle3, 0.0F, 0.0F, -43.0F);
        animator.rotateTo(lMiddleTenticle4, 0.0F, 0.0F, 66.0F);
        animator.rotateTo(lMiddleTenticle5, 0.0F, 0.0F, 68.0F);
        animator.rotateTo(rMiddleTenticle1, -28.0F, 0.0F, 0.0F);
        animator.rotateTo(rMiddleTenticle3, 0.0F, 0.0F, 43.0F);
        animator.rotateTo(rMiddleTenticle4, 0.0F, 0.0F, -66.0F);
        animator.rotateTo(rMiddleTenticle5, 0.0F, 0.0F, -68.0F);
    }

    public void slap(EntityTrilobite trilobite)
    {
        animator.rotateTo(lFrontTenticle1, 0.0F, -1.0F, 16.0F);
        animator.rotateTo(lFrontTenticle3, 0.0F, 0.0F, 53.0F);
        animator.rotateTo(lFrontTenticle4, 0.0F, 0.0F, 38.0F);
        animator.rotateTo(lFrontTenticle5, 0.0F, 0.0F, 61.0F);
        animator.rotateTo(rFrontTenticle1, 0.0F, 1.0F, -16.0F);
        animator.rotateTo(rFrontTenticle3, 0.0F, 0.0F, -53.0F);
        animator.rotateTo(rFrontTenticle4, 0.0F, 0.0F, -59.0F);
        animator.rotateTo(rFrontTenticle5, 0.0F, 0.0F, -57.0F);
    }

    public void curlUp(EntityTrilobite trilobite)
    {
        animator.rotateTo(body, -44.35F, 0.0F, 0.0F);
        animator.rotateTo(lBackTenticle1, 68.0F, 24.0F, -30.0F);
        animator.rotateTo(lBackTenticle2, -13.0F, 26.0F, 13.0F);
        animator.rotateTo(lBackTenticle3, -23.0F, -33.0F, 0.0F);
        animator.rotateTo(lBackTenticle4, 0.0F, 62.0F, 2.0F);
        animator.rotateTo(lBackTenticle5, 26.0F, 41.0F, 34.0F);
        animator.rotateTo(rBackTenticle1, 57.0F, 0.0F, 0.0F);
        animator.rotateTo(rBackTenticle2, -10.0F, 41.0F, 7.0F);
        animator.rotateTo(rBackTenticle3, -39.0F, 21.0F, 0.0F);
        animator.rotateTo(rBackTenticle4, -20.0F, 39.0F, -21.0F);
        animator.rotateTo(rBackTenticle5, 10.0F, -44.0F, -23.0F);
        animator.rotateTo(tail, 41.0F, 0.0F, 0.0F);
        animator.rotateTo(tail2, 28.0F, -0.0F, 0.0F);
        animator.rotateTo(tail3, -21.0F, 44.0F, 10.0F);
        animator.rotateTo(tail4, 20.0F, -41.0F, -20.0F);
        animator.rotateTo(tail5, -16.0F, -33.0F, -13.0F);
        animator.rotateTo(tailPetal, 41.0F, 0.0F, 0.0F);
        animator.rotateTo(lFrontTenticle1, 0.0F, -1.0F, 16.0F);
        animator.rotateTo(lFrontTenticle3, 0.0F, 0.0F, 53.0F);
        animator.rotateTo(lFrontTenticle4, 0.0F, 0.0F, 38.0F);
        animator.rotateTo(lFrontTenticle5, 0.0F, 0.0F, 61.0F);
        animator.rotateTo(rFrontTenticle1, 0.0F, 1.0F, -16.0F);
        animator.rotateTo(rFrontTenticle3, 0.0F, 0.0F, -53.0F);
        animator.rotateTo(rFrontTenticle4, 0.0F, 0.0F, -59.0F);
        animator.rotateTo(rFrontTenticle5, 0.0F, 0.0F, -57.0F);
        animator.rotateTo(lMiddleTenticle1, 0.0F, 0.0F, 28.0F);
        animator.rotateTo(lMiddleTenticle3, -13.0F, 0.0F, 37.0F);
        animator.rotateTo(lMiddleTenticle4, 0.0F, 0.0F, 66.0F);
        animator.rotateTo(lMiddleTenticle5, 0.0F, 0.0F, 38.0F);
        animator.rotateTo(rMiddleTenticle1, 0.0F, 0.0F, -32.0F);
        animator.rotateTo(rMiddleTenticle3, 0.0F, 0.0F, -8.0F);
        animator.rotateTo(rMiddleTenticle4, 0.0F, 0.0F, -52.0F);
        animator.rotateTo(rMiddleTenticle5, 0.0F, 0.0F, -68.0F);
    }

    public void petalsOpenPartial(EntityTrilobite trilobite)
    {
        animator.rotateTo(lFrontPetal, 0.4299999999999997F, 0.870000000000001F, -60.0F);
        animator.rotateTo(rFrontPetal, 0.4299999999999997F, -0.870000000000001F, 60.0F);
        animator.rotateTo(lMiddlePetal, -0.6800000000000002F, 0.0F, -62.0F);
        animator.rotateTo(rMiddlePetal, -0.6800000000000002F, 0.0F, 62.0F);
        animator.rotateTo(lBackPetal, 0.0F, -26.0F, -30.0F);
        animator.rotateTo(rBackPetal, 0.0F, 0.0F, 30.0F);
    }

    public void petalsOpen(EntityTrilobite trilobite)
    {
        animator.rotateTo(lFrontPetal, 0.0F, 1.0F, -100.0F);
        animator.rotateTo(rFrontPetal, 0.0F, -1.0F, 100.0F);
        animator.rotateTo(lMiddlePetal, -1.0F, 0.0F, -74.0F);
        animator.rotateTo(rMiddlePetal, -1.0F, 0.0F, 74.0F);
        animator.rotateTo(lBackPetal, 0.0F, -26.0F, -80.0F);
        animator.rotateTo(rBackPetal, 0.0F, 0.0F, 80.0F);
    }

    public void extendGrabToobs(EntityTrilobite trilobite)
    {
        animator.rotateTo(smallToobBase, -44.35F, 0.0F, 0.0F);
        animator.moveTo(lFrontSmallTube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lFrontSmallTube12, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rFrontSmallTube12, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lMiddleSmallTube12, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rMiddleSmallTube12, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(lBackSmallTube12, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(rBackSmallTube12, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tailSmallTube12, 0.0F, 1.0F, 0.0F);
        animator.rotateTo(lFrontSmallTube01, -50.0F, 0.0F, 0.0F);
        animator.rotateTo(rFrontSmallTube01, -50.0F, 0.0F, 0.0F);
        animator.rotateTo(lMiddleSmallTube01, -40.0F, 0.0F, 0.0F);
        animator.rotateTo(rMiddleSmallTube01, -40.0F, 0.0F, 0.0F);
        animator.rotateTo(lBackSmallTube01, -30.0F, 0.0F, 0.0F);
        animator.rotateTo(rBackSmallTube01, -30.0F, 0.0F, 0.0F);
        animator.rotateTo(tailSmallTube01, -30.0F, 0.0F, 0.0F);
    }

    public void extendImpregnationToob(EntityTrilobite trilobite)
    {
        animator.rotateTo(tube01, -37.5F, 0.0F, 0.0F);
        animator.rotateTo(tube03, 7.83F, 0.0F, 0.0F);
        animator.moveTo(tube01, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube02, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube03, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube04, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube05, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube06, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube07, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube08, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube09, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube10, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube11, 0.0F, 1.0F, 0.0F);
        animator.moveTo(tube12, 0.0F, 1.0F, 0.0F);
    }

    public void dead(EntityTrilobite trilobite, boolean s)
    {
        animator.rotateTo(lowerBody, 19.0F, 0.0F, 0.0F, s);
        animator.rotateTo(lBackTenticle1, -10.0F, -15.0F, -7.0F, s);
        animator.rotateTo(lBackTenticle2, 0.0F, -50.0F, -18.0F, s);
        animator.rotateTo(lBackTenticle3, 0.0F, 70.0F, -15.0F, s);
        animator.rotateTo(lBackTenticle4, 0.0F, 39.13F, 28.0F, s);
        animator.rotateTo(lBackTenticle5, 0.0F, 20.0F, 30.0F, s);
        animator.rotateTo(rBackTenticle1, -10.0F, -1.0F, 7.0F, s);
        animator.rotateTo(rBackTenticle2, 0.0F, 13.0F, 18.0F, s);
        animator.rotateTo(rBackTenticle3, 0.0F, 30.0F, 15.0F, s);
        animator.rotateTo(rBackTenticle4, 0.0F, 30.0F, -28.0F, s);
        animator.rotateTo(rBackTenticle5, 0.0F, -40.0F, -28.0F, s);
        animator.rotateTo(rBackClaw, 0.0F, -25.0F, 0.0F, s);
        animator.rotateTo(tail2, 26.0F, -12.0F, 0.0F, s);
        animator.rotateTo(tail3, -8.0F, -13.0F, 0.0F, s);
        animator.rotateTo(tail4, -21.0F, 45.0F, 0.0F, s);
        animator.rotateTo(tail5, -24.0F, 30.0F, 0.0F, s);
        animator.rotateTo(tailPetal, 140.0F, 0.0F, 0.0F, s);
        animator.rotateTo(lFrontTenticle1, -18.0F, -5.0F, -26.0F, s);
        animator.rotateTo(lFrontTenticle2, 0.0F, 0.0F, -31.0F, s);
        animator.rotateTo(lFrontTenticle3, 0.0F, 30.0F, 13.0F, s);
        animator.rotateTo(lFrontTenticle4, 0.0F, -25.0F, 15.0F, s);
        animator.rotateTo(lFrontTenticle5, 0.0F, 60.0F, 21.0F, s);
        animator.rotateTo(rFrontTenticle1, -18.0F, -5.0F, 34.0F, s);
        animator.rotateTo(rFrontTenticle2, 0.0F, 0.0F, 18.0F, s);
        animator.rotateTo(rFrontTenticle3, 2.0F, -39.0F, 0.0F, s);
        animator.rotateTo(rFrontTenticle4, -7.0F, -49.0F, -2.0F, s);
        animator.rotateTo(rFrontTenticle5, -7.0F, -57.0F, -8.0F, s);
        animator.rotateTo(rFrontClaw, 0.0F, -33.0F, 0.0F, s);
        animator.rotateTo(lMiddleTenticle1, 0.0F, 30.0F, -20.0F, s);
        animator.rotateTo(lMiddleTenticle2, 0.0F, -30.0F, -6.0F, s);
        animator.rotateTo(lMiddleTenticle3, 0.0F, -40.0F, -29.0F, s);
        animator.rotateTo(lMiddleTenticle4, 0.0F, -60.0F, 26.0F, s);
        animator.rotateTo(lMiddleTenticle5, 0.0F, -60.0F, 28.0F, s);
        animator.rotateTo(lMiddleClaw, 0.0F, -60.0F, 0.0F, s);
        animator.rotateTo(rMiddleTenticle1, 0.0F, -18.0F, 18.0F, s);
        animator.rotateTo(rMiddleTenticle2, 0.0F, 25.0F, 13.0F, s);
        animator.rotateTo(rMiddleTenticle3, 0.0F, 15.0F, 23.0F, s);
        animator.rotateTo(rMiddleTenticle4, 0.0F, -45.0F, -26.0F, s);
        animator.rotateTo(rMiddleTenticle5, 0.0F, -50.0F, -28.0F, s);
        animator.rotateTo(rMiddleClaw, 0.0F, -30.0F, 0.0F, s);
        animator.rotateTo(lFrontPetal, 0.0F, 0.0F, -150.0F, s);
        animator.rotateTo(rFrontPetal, 0.0F, 0.0F, 150.0F, s);
        animator.rotateTo(lMiddlePetal, 0.0F, 0.0F, -140.0F, s);
        animator.rotateTo(rMiddlePetal, 0.0F, 0.0F, 140.0F, s);
        animator.rotateTo(lBackPetal, 0.0F, 0.0F, -120.0F, s);
        animator.rotateTo(rBackPetal, 0.0F, 0.0F, 120.0F, s);

    }

    public void hugWall(EntityTrilobite trilobite)
    {
        animator.rotateTo(body, -85.0F, 0.0F, 0.0F);
        animator.rotateTo(lowerBody, 32.0F, 0.0F, 0.0F);
        animator.rotateTo(lBackTenticle1, 68.0F, 24.0F, -30.0F);
        animator.rotateTo(lBackTenticle2, -13.0F, 26.0F, 13.0F);
        animator.rotateTo(lBackTenticle3, -23.0F, -33.0F, 0.0F);
        animator.rotateTo(lBackTenticle4, 8.0F, 20.0F, -20.0F);
        animator.rotateTo(lBackTenticle5, 0.0F, 0.0F, 24.0F);
        animator.rotateTo(rBackTenticle1, 68.0F, -16.0F, 30.0F);
        animator.rotateTo(rBackTenticle2, 0.0F, 0.0F, -10.0F);
        animator.rotateTo(rBackTenticle3, 0.0F, 30.0F, 15.0F);
        animator.rotateTo(rBackTenticle4, -30.0F, 26.0F, -21.0F);
        animator.rotateTo(rBackTenticle5, 0.0F, 0.0F, -18.0F);
        animator.rotateTo(tail, 54.0F, 0.0F, 0.0F);
        animator.rotateTo(tail2, 28.0F, -0.0F, 0.0F);
        animator.rotateTo(tail3, -21.0F, 44.0F, 10.0F);
        animator.rotateTo(tail4, 20.0F, -41.0F, -20.0F);
        animator.rotateTo(tail5, -16.0F, -33.0F, -13.0F);
        animator.rotateTo(tailPetal, 140.0F, 0.0F, 0.0F);
        animator.rotateTo(lFrontTenticle1, -26.0F, -1.0F, -34.0F);
        animator.rotateTo(lFrontTenticle2, 0.0F, 30.0F, -26.0F);
        animator.rotateTo(lFrontTenticle3, 0.0F, 20.0F, 13.0F);
        animator.rotateTo(lFrontTenticle4, 0.0F, 30.0F, 15.0F);
        animator.rotateTo(lFrontTenticle5, 0.0F, -20.0F, 21.0F);
        animator.rotateTo(rFrontTenticle1, -26.0F, 1.0F, 34.0F);
        animator.rotateTo(rFrontTenticle2, 0.0F, -30.0F, 26.0F);
        animator.rotateTo(rFrontTenticle3, 0.0F, 30.0F, -13.0F);
        animator.rotateTo(rFrontTenticle4, 0.0F, 40.0F, -15.0F);
        animator.rotateTo(rFrontTenticle5, 0.0F, -30.0F, -21.0F);
        animator.rotateTo(lMiddleTenticle1, 0.0F, 0.0F, -18.0F);
        animator.rotateTo(lMiddleTenticle2, 0.0F, 0.0F, -13.0F);
        animator.rotateTo(lMiddleTenticle3, 0.0F, 35.0F, -23.0F);
        animator.rotateTo(lMiddleTenticle4, 0.0F, 30.0F, 26.0F);
        animator.rotateTo(lMiddleTenticle5, 0.0F, 0.0F, 38.0F);
        animator.rotateTo(rMiddleTenticle1, 0.0F, 0.0F, 18.0F);
        animator.rotateTo(rMiddleTenticle2, 0.0F, -18.0F, 13.0F);
        animator.rotateTo(rMiddleTenticle3, 0.0F, -20.0F, 23.0F);
        animator.rotateTo(rMiddleTenticle4, 0.0F, 25.0F, -26.0F);
        animator.rotateTo(rMiddleTenticle5, 0.0F, 30.0F, -28.0F);
        animator.rotateTo(lFrontPetal, 0.0F, 1.0F, -150.0F);
        animator.rotateTo(rFrontPetal, 0.0F, -1.0F, 150.0F);
        animator.rotateTo(lMiddlePetal, -1.0F, 0.0F, -140.0F);
        animator.rotateTo(rMiddlePetal, -1.0F, 0.0F, 140.0F);
        animator.rotateTo(lBackPetal, 33.0F, -50.0F, -120.0F);
        animator.rotateTo(rBackPetal, 33.0F, 24.0F, 120.0F);
        animator.rotateTo(tube03, 7.83F, 0.0F, 0.0F);
        animator.rotateTo(smallToobBase, -85.0F, 0.0F, 0.0F);
    }

    public void animate(EntityTrilobite trilobite)
    {
        setRotationAngles(trilobite);

        animator.setAnimation(EntityTrilobite.ANIMATION_HUG_WALL);
        {
            animator.startKeyframe(5);
            {
                this.hugWall(trilobite);
            }
            animator.endKeyframe();
            animator.setStaticKeyframe(20 * 4);
        }
        animator.resetKeyframe(8);

        animator.setAnimation(EntityTrilobite.IMPREGNATION_ANIMATION);
        {
            animator.startKeyframe(5);
            {
                this.standUp(trilobite);
            }
            animator.endKeyframe();

            animator.setStaticKeyframe(10);

            animator.startKeyframe(3);
            {
                this.slap(trilobite);
            }
            animator.endKeyframe();

            animator.startKeyframe(10);
            {
                this.standUp(trilobite);
            }
            animator.endKeyframe();

            animator.setStaticKeyframe(3);

            animator.startKeyframe(10);
            {
                this.curlUp(trilobite);
            }
            animator.endKeyframe();

            animator.setStaticKeyframe(3);

            animator.startKeyframe(20);
            {
                this.curlUp(trilobite);
                this.petalsOpenPartial(trilobite);
            }
            animator.endKeyframe();

            animator.startKeyframe(7);
            {
                this.curlUp(trilobite);
                this.petalsOpen(trilobite);
            }
            animator.endKeyframe();

            animator.startKeyframe(2);
            {
                this.curlUp(trilobite);
                this.petalsOpen(trilobite);
                this.extendGrabToobs(trilobite);
            }
            animator.endKeyframe();

            animator.setStaticKeyframe(20);

            animator.startKeyframe(2);
            {
                this.curlUp(trilobite);
                this.petalsOpen(trilobite);
                this.extendGrabToobs(trilobite);
                this.extendImpregnationToob(trilobite);
            }
            animator.endKeyframe();

            animator.setStaticKeyframe(trilobite.getDetachTime() - 100);
        }
        animator.resetKeyframe(5);
    }
}
