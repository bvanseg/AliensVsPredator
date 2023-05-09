package org.alien.client.model.entity.living;

import com.asx.mdx.client.render.model.Model;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorphGiger;

public class ModelOvamorphGiger extends Model<EntityOvamorphGiger>
{
    public final Part section1;
    public final Part fleshyBase01;
    public final Part section2;
    public final Part section3;
    public final Part section4;
    public final Part lobeF1;
    public final Part lobeB1;
    public final Part lobeL1;
    public final Part lobeR1;
    public final Part lobeF2;
    public final Part lobeF3;
    public final Part lobeB2;
    public final Part lobeB3;
    public final Part lobeL2;
    public final Part lobeL3;
    public final Part lobeR2;
    public final Part lobeR3;
    public final Part fleshyBase02;
    public final Part root1a;
    public final Part root2a;
    public final Part root3a;
    public final Part root4a;
    public final Part root5a;
    public final Part root1ba;
    public final Part root1bb;
    public final Part root1bc;
    public final Part root1bd;
    public final Part root1c;
    public final Part root1d;
    public final Part root1e;
    public final Part root2ba;
    public final Part root2bb;
    public final Part root2bc;
    public final Part root2bd;
    public final Part root2c;
    public final Part root2d;
    public final Part root2e;
    public final Part root3ba;
    public final Part root3bb;
    public final Part root3bc;
    public final Part root3bd;
    public final Part root3c;
    public final Part root3d;
    public final Part root3e;
    public final Part root4ba;
    public final Part root4bb;
    public final Part root4bc;
    public final Part root4bd;
    public final Part root4c;
    public final Part root4d;
    public final Part root4e;
    public final Part root5ba;
    public final Part root5bb;
    public final Part root5bc;
    public final Part root5bd;
    public final Part root5c;
    public final Part root5d;
    public final Part root5e;

    public ModelOvamorphGiger()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.lobeB2 = new Part(this, 63, 6);
        this.lobeB2.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.lobeB2.addBox(-2.5F, -2.2F, -0.5F, 5, 2, 1, 0.0F);
        this.setRotation(lobeB2, 0.5918411493512771F, 0.0F, 0.0F);
        this.root3d = new Part(this, 106, 51);
        this.root3d.setRotationPoint(-0.3F, 0.1F, -3.5F);
        this.root3d.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 3, 0.0F);
        this.setRotation(root3d, 0.0F, -0.6373942428283291F, 0.0F);
        this.lobeF3 = new Part(this, 41, 10);
        this.lobeF3.setRotationPoint(0.0F, -1.8F, 0.1F);
        this.lobeF3.addBox(-1.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotation(lobeF3, -0.31869712141416456F, 0.0F, 0.0F);
        this.root3c = new Part(this, 106, 44);
        this.root3c.setRotationPoint(0.3F, 0.1F, -3.5F);
        this.root3c.addBox(-0.5F, -0.5F, -4.2F, 1, 1, 4, 0.0F);
        this.setRotation(root3c, 0.0F, 0.36425021489121656F, 0.0F);
        this.root5a = new Part(this, 89, 34);
        this.root5a.setRotationPoint(3.2F, 0.6F, 0.7F);
        this.root5a.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotation(root5a, 0.0F, -1.2292353921796064F, 0.0F);
        this.lobeB1 = new Part(this, 60, 0);
        this.lobeB1.setRotationPoint(0.0F, -2.0F, 4.3F);
        this.lobeB1.addBox(-3.5F, -3.0F, -0.5F, 7, 3, 1, 0.0F);
        this.setRotation(lobeB1, 0.5918411493512771F, 0.0F, 0.0F);
        this.root3bb = new Part(this, 117, 27);
        this.root3bb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root3bb.addBox(-0.5F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root4bd = new Part(this, 106, 34);
        this.root4bd.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root4bd.addBox(-0.2F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root3ba = new Part(this, 106, 34);
        this.root3ba.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.root3ba.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotation(root3ba, 0.0F, 0.27314402793711257F, 0.0F);
        this.lobeL2 = new Part(this, 84, 13);
        this.lobeL2.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.lobeL2.addBox(-0.5F, -2.0F, -2.5F, 1, 2, 5, 0.0F);
        this.setRotation(lobeL2, 0.0F, 0.0F, -0.5918411493512771F);
        this.root4d = new Part(this, 106, 51);
        this.root4d.setRotationPoint(-0.4F, 0.1F, -3.6F);
        this.root4d.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 3, 0.0F);
        this.setRotation(root4d, 0.0F, -0.8196066167365371F, 0.0F);
        this.fleshyBase02 = new Part(this, 34, 34);
        this.fleshyBase02.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.fleshyBase02.addBox(-9.0F, 0.0F, -9.0F, 18, 1, 18, 0.0F);
        this.lobeR1 = new Part(this, 104, 0);
        this.lobeR1.setRotationPoint(-4.3F, -2.0F, 0.0F);
        this.lobeR1.addBox(-0.5F, -3.0F, -3.5F, 1, 3, 7, 0.0F);
        this.setRotation(lobeR1, 0.0F, 0.0F, 0.5918411493512771F);
        this.lobeL3 = new Part(this, 87, 23);
        this.lobeL3.setRotationPoint(-0.1F, -1.8F, 0.0F);
        this.lobeL3.addBox(-0.5F, -1.0F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotation(lobeL3, 0.0F, 0.0F, -0.31869712141416456F);
        this.root3bc = new Part(this, 117, 34);
        this.root3bc.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root3bc.addBox(-0.2F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.root4bc = new Part(this, 117, 34);
        this.root4bc.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root4bc.addBox(-0.2F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.root1a = new Part(this, 89, 34);
        this.root1a.setRotationPoint(-2.4F, 0.6F, -4.5F);
        this.root1a.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotation(root1a, 0.0F, 0.6829473363053812F, 0.0F);
        this.root2c = new Part(this, 106, 44);
        this.root2c.setRotationPoint(0.2F, 0.1F, -3.5F);
        this.root2c.addBox(-0.5F, -0.5F, -4.2F, 1, 1, 4, 0.0F);
        this.setRotation(root2c, 0.0F, 0.8196066167365371F, 0.0F);
        this.root1bb = new Part(this, 117, 27);
        this.root1bb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root1bb.addBox(-0.5F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root2bc = new Part(this, 117, 34);
        this.root2bc.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root2bc.addBox(-0.2F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.root4ba = new Part(this, 106, 34);
        this.root4ba.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.root4ba.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotation(root4ba, 0.0F, 0.7285004297824331F, 0.0F);
        this.lobeR3 = new Part(this, 108, 23);
        this.lobeR3.setRotationPoint(0.1F, -1.8F, 0.0F);
        this.lobeR3.addBox(-0.5F, -1.0F, -1.0F, 1, 1, 2, 0.0F);
        this.setRotation(lobeR3, 0.0F, 0.0F, 0.31869712141416456F);
        this.root5bc = new Part(this, 117, 34);
        this.root5bc.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root5bc.addBox(-0.2F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.root2a = new Part(this, 89, 34);
        this.root2a.setRotationPoint(3.5F, 0.6F, -4.5F);
        this.root2a.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotation(root2a, 0.0F, -0.7740535232594852F, 0.0F);
        this.root4a = new Part(this, 89, 34);
        this.root4a.setRotationPoint(-0.2F, 0.6F, 3.8F);
        this.root4a.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotation(root4a, 0.0F, 3.141592653589793F, 0.0F);
        this.root1bd = new Part(this, 117, 41);
        this.root1bd.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root1bd.addBox(-0.2F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root4e = new Part(this, 106, 51);
        this.root4e.setRotationPoint(-0.3F, 0.0F, -3.0F);
        this.root4e.addBox(-0.5F, -0.5F, -3.1F, 1, 1, 3, 0.0F);
        this.setRotation(root4e, 0.0F, -1.2747884856566583F, 0.0F);
        this.root1bc = new Part(this, 117, 34);
        this.root1bc.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root1bc.addBox(-0.2F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.section3 = new Part(this, 0, 24);
        this.section3.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.section3.addBox(-5.5F, -8.0F, -5.5F, 11, 8, 11, 0.0F);
        this.lobeB3 = new Part(this, 65, 10);
        this.lobeB3.setRotationPoint(0.0F, -1.8F, -0.1F);
        this.lobeB3.addBox(-1.0F, -1.0F, -0.5F, 2, 1, 1, 0.0F);
        this.setRotation(lobeB3, 0.31869712141416456F, 0.0F, 0.0F);
        this.lobeF2 = new Part(this, 38, 6);
        this.lobeF2.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.lobeF2.addBox(-2.5F, -2.2F, -0.5F, 5, 2, 1, 0.0F);
        this.setRotation(lobeF2, -0.5918411493512771F, 0.0F, 0.0F);
        this.lobeL1 = new Part(this, 83, 0);
        this.lobeL1.setRotationPoint(4.3F, -2.0F, 0.0F);
        this.lobeL1.addBox(-0.5F, -3.0F, -3.5F, 1, 3, 7, 0.0F);
        this.setRotation(lobeL1, 0.0F, 0.0F, -0.5918411493512771F);
        this.root5d = new Part(this, 106, 51);
        this.root5d.setRotationPoint(0.5F, 0.1F, -3.6F);
        this.root5d.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 3, 0.0F);
        this.setRotation(root5d, 0.0F, 0.8196066167365371F, 0.0F);
        this.root5c = new Part(this, 106, 44);
        this.root5c.setRotationPoint(0.1F, 0.1F, -3.6F);
        this.root5c.addBox(-0.5F, -0.5F, -4.2F, 1, 1, 4, 0.0F);
        this.setRotation(root5c, 0.0F, -0.7740535232594852F, 0.0F);
        this.root3e = new Part(this, 106, 51);
        this.root3e.setRotationPoint(0.0F, 0.1F, -3.3F);
        this.root3e.addBox(-0.5F, -0.5F, -3.0F, 1, 1, 3, 0.0F);
        this.setRotation(root3e, 0.0F, -0.5918411493512771F, 0.0F);
        this.root2bb = new Part(this, 117, 27);
        this.root2bb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root2bb.addBox(-0.5F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root5e = new Part(this, 106, 44);
        this.root5e.setRotationPoint(0.2F, 0.1F, -3.1F);
        this.root5e.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotation(root5e, 0.0F, 0.9105382707654417F, 0.0F);
        this.root2bd = new Part(this, 117, 41);
        this.root2bd.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root2bd.addBox(-0.2F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.lobeR2 = new Part(this, 105, 13);
        this.lobeR2.setRotationPoint(0.0F, -2.6F, 0.0F);
        this.lobeR2.addBox(-0.5F, -2.0F, -2.5F, 1, 2, 5, 0.0F);
        this.setRotation(lobeR2, 0.0F, 0.0F, 0.5918411493512771F);
        this.root5ba = new Part(this, 106, 34);
        this.root5ba.setRotationPoint(-0.3F, 0.0F, -4.5F);
        this.root5ba.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotation(root5ba, 0.0F, -0.7740535232594852F, 0.0F);
        this.fleshyBase01 = new Part(this, 34, 15);
        this.fleshyBase01.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.fleshyBase01.addBox(-6.5F, 0.0F, -6.5F, 13, 1, 13, 0.0F);
        this.root1d = new Part(this, 106, 51);
        this.root1d.setRotationPoint(-0.4F, 0.1F, -3.6F);
        this.root1d.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 3, 0.0F);
        this.setRotation(root1d, 0.0F, -1.1838568316277536F, 0.0F);
        this.root3a = new Part(this, 89, 34);
        this.root3a.setRotationPoint(-4.2F, 0.6F, 1.0F);
        this.root3a.addBox(-1.0F, -1.0F, -5.0F, 2, 2, 5, 0.0F);
        this.setRotation(root3a, 0.0F, 1.2747884856566583F, 0.0F);
        this.root1c = new Part(this, 106, 44);
        this.root1c.setRotationPoint(0.0F, 0.1F, -3.5F);
        this.root1c.addBox(-0.5F, -0.5F, -4.2F, 1, 1, 4, 0.0F);
        this.setRotation(root1c, 0.0F, -0.9105382707654417F, 0.0F);
        this.root5bd = new Part(this, 106, 34);
        this.root5bd.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root5bd.addBox(-0.2F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root2e = new Part(this, 106, 58);
        this.root2e.setRotationPoint(0.0F, 0.1F, -3.4F);
        this.root2e.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotation(root2e, 0.0F, 0.36425021489121656F, 0.0F);
        this.root4bb = new Part(this, 117, 27);
        this.root4bb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root4bb.addBox(-0.5F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root2d = new Part(this, 106, 51);
        this.root2d.setRotationPoint(0.6F, 0.1F, -3.6F);
        this.root2d.addBox(-0.5F, -0.5F, -3.5F, 1, 1, 3, 0.0F);
        this.setRotation(root2d, 0.0F, 1.1383037381507017F, 0.0F);
        this.section2 = new Part(this, 0, 11);
        this.section2.setRotationPoint(0.0F, 1.0F, 0.0F);
        this.section2.addBox(-4.5F, -2.0F, -4.5F, 9, 1, 9, 0.0F);
        this.root2ba = new Part(this, 106, 34);
        this.root2ba.setRotationPoint(-0.3F, 0.0F, -4.5F);
        this.root2ba.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotation(root2ba, 0.0F, -0.40980330836826856F, 0.0F);
        this.root3bd = new Part(this, 117, 41);
        this.root3bd.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root3bd.addBox(-0.2F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root5bb = new Part(this, 117, 27);
        this.root5bb.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.root5bb.addBox(-0.5F, -0.2F, -4.0F, 1, 1, 4, 0.0F);
        this.root1ba = new Part(this, 106, 34);
        this.root1ba.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.root1ba.addBox(-0.5F, -0.5F, -4.0F, 1, 1, 4, 0.0F);
        this.setRotation(root1ba, 0.0F, 0.5918411493512771F, 0.0F);
        this.root4c = new Part(this, 106, 44);
        this.root4c.setRotationPoint(0.2F, 0.1F, -3.5F);
        this.root4c.addBox(-0.5F, -0.5F, -4.2F, 1, 1, 4, 0.0F);
        this.setRotation(root4c, 0.0F, -0.40980330836826856F, 0.0F);
        this.section4 = new Part(this, 0, 46);
        this.section4.setRotationPoint(0.0F, -7.4F, 0.0F);
        this.section4.addBox(-5.0F, -2.5F, -5.0F, 10, 2, 10, 0.0F);
        this.section1 = new Part(this, 0, 0);
        this.section1.setRotationPoint(0.0F, 22.4F, 0.0F);
        this.section1.addBox(-4.0F, 0.0F, -4.0F, 8, 1, 8, 0.0F);
        this.lobeF1 = new Part(this, 36, 0);
        this.lobeF1.setRotationPoint(0.0F, -2.0F, -4.3F);
        this.lobeF1.addBox(-3.5F, -3.0F, -0.5F, 7, 3, 1, 0.0F);
        this.setRotation(lobeF1, -0.5918411493512771F, 0.0F, 0.0F);
        this.root1e = new Part(this, 106, 58);
        this.root1e.setRotationPoint(-0.1F, 0.1F, -3.1F);
        this.root1e.addBox(-0.5F, -0.5F, -2.0F, 1, 1, 2, 0.0F);
        this.setRotation(root1e, 0.0F, -1.1383037381507017F, 0.0F);
        this.lobeB1.addChild(this.lobeB2);
        this.root3c.addChild(this.root3d);
        this.lobeF2.addChild(this.lobeF3);
        this.root3ba.addChild(this.root3c);
        this.fleshyBase01.addChild(this.root5a);
        this.section4.addChild(this.lobeB1);
        this.root3ba.addChild(this.root3bb);
        this.root4ba.addChild(this.root4bd);
        this.root3a.addChild(this.root3ba);
        this.lobeL1.addChild(this.lobeL2);
        this.root4c.addChild(this.root4d);
        this.fleshyBase01.addChild(this.fleshyBase02);
        this.section4.addChild(this.lobeR1);
        this.lobeL2.addChild(this.lobeL3);
        this.root3ba.addChild(this.root3bc);
        this.root4ba.addChild(this.root4bc);
        this.fleshyBase01.addChild(this.root1a);
        this.root2ba.addChild(this.root2c);
        this.root1ba.addChild(this.root1bb);
        this.root2ba.addChild(this.root2bc);
        this.root4a.addChild(this.root4ba);
        this.lobeR2.addChild(this.lobeR3);
        this.root5ba.addChild(this.root5bc);
        this.fleshyBase01.addChild(this.root2a);
        this.fleshyBase01.addChild(this.root4a);
        this.root1ba.addChild(this.root1bd);
        this.root4d.addChild(this.root4e);
        this.root1ba.addChild(this.root1bc);
        this.section2.addChild(this.section3);
        this.lobeB2.addChild(this.lobeB3);
        this.lobeF1.addChild(this.lobeF2);
        this.section4.addChild(this.lobeL1);
        this.root5c.addChild(this.root5d);
        this.root5ba.addChild(this.root5c);
        this.root3d.addChild(this.root3e);
        this.root2ba.addChild(this.root2bb);
        this.root5d.addChild(this.root5e);
        this.root2ba.addChild(this.root2bd);
        this.lobeR1.addChild(this.lobeR2);
        this.root5a.addChild(this.root5ba);
        this.root1c.addChild(this.root1d);
        this.fleshyBase01.addChild(this.root3a);
        this.root1ba.addChild(this.root1c);
        this.root5ba.addChild(this.root5bd);
        this.root2d.addChild(this.root2e);
        this.root4ba.addChild(this.root4bb);
        this.root2c.addChild(this.root2d);
        this.section1.addChild(this.section2);
        this.root2a.addChild(this.root2ba);
        this.root3ba.addChild(this.root3bd);
        this.root5ba.addChild(this.root5bb);
        this.root1a.addChild(this.root1ba);
        this.root4ba.addChild(this.root4c);
        this.section3.addChild(this.section4);
        this.section4.addChild(this.lobeF1);
        this.root1d.addChild(this.root1e);
        updateDefaultPose();
    }

    @Override
    public void render(EntityOvamorphGiger ovamorph)
    {
        if (ovamorph != null)
        {
            animate(ovamorph);
        }

        draw(fleshyBase01);
        draw(section1);
    }

    public void animate(EntityOvamorphGiger ovamorph)
    {
        updateAnimations(ovamorph);
        
        animator.setAnimation(EntityOvamorphGiger.HATCH_ANIMATION);
        {
            animator.startKeyframe(20 * 3);
            {
                this.openLobes(ovamorph);
            }
            animator.endKeyframe();
        }
        animator.resetKeyframe(0);
    }

    public void openLobes(EntityOvamorphGiger ovamorph)
    {
        animator.moveTo(lobeF1, 0.0F, 0.0F, 0.09999999999999998F);
        animator.rotateTo(lobeF1, 133.91F, 0.0F, 0.0F);
        animator.rotateTo(lobeF2, 51.91F, 0.0F, 0.0F);
        animator.rotateTo(lobeF3, 28.26F, 0.0F, 0.0F);
        animator.moveTo(lobeB1, 0.0F, 0.0F, -0.09999999999999998F);
        animator.rotateTo(lobeB1, -133.91F, 0.0F, 0.0F);
        animator.rotateTo(lobeB2, -51.91F, 0.0F, 0.0F);
        animator.rotateTo(lobeB3, -28.26F, 0.0F, 0.0F);
        animator.moveTo(lobeL1, -0.09999999999999998F, 0.0F, 0.0F);
        animator.rotateTo(lobeL1, 0.0F, 0.0F, 133.91F);
        animator.rotateTo(lobeL2, 0.0F, 0.0F, 51.91F);
        animator.rotateTo(lobeL3, 0.0F, 0.0F, 28.26F);
        animator.moveTo(lobeR1, 0.09999999999999998F, 0.0F, 0.0F);
        animator.rotateTo(lobeR1, 0.0F, 0.0F, -133.91F);
        animator.rotateTo(lobeR2, 0.0F, 0.0F, -51.91F);
        animator.rotateTo(lobeR3, 0.0F, 0.0F, -28.26F);
    }
}
