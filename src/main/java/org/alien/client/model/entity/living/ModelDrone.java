package org.alien.client.model.entity.living;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import org.alien.common.entity.living.xenomorph.EntityDrone;


public class ModelDrone extends Model<EntityDrone> {
    private final ModelRenderer ModelDrone;
    private final ModelRenderer torso;
    private final ModelRenderer back2_r1;
    private final ModelRenderer back1_r1;
    private final ModelRenderer body1_r1;
    private final ModelRenderer neck;
    private final ModelRenderer neck_r1;
    private final ModelRenderer bone2;
    private final ModelRenderer neck_r2;
    private final ModelRenderer bone3;
    private final ModelRenderer neck_r3;
    private final ModelRenderer head;
    private final ModelRenderer cube_r1;
    private final ModelRenderer head6_r1;
    private final ModelRenderer head4_r1;
    private final ModelRenderer head5_r1;
    private final ModelRenderer head2_r1;
    private final ModelRenderer head2_r2;
    private final ModelRenderer head2_r3;
    private final ModelRenderer head1_r1;
    private final ModelRenderer head6_r2;
    private final ModelRenderer lowerjaw;
    private final ModelRenderer chin_r1;
    private final ModelRenderer head6_r3;
    private final ModelRenderer head5_r2;
    private final ModelRenderer upperbody;
    private final ModelRenderer dorsaltubesr;
    private final ModelRenderer backhorn8_r1;
    private final ModelRenderer backhorn7_r1;
    private final ModelRenderer backhorn6_r1;
    private final ModelRenderer dorsaltubesl;
    private final ModelRenderer backhorn9_r1;
    private final ModelRenderer backhorn8_r2;
    private final ModelRenderer backhorn7_r2;
    private final ModelRenderer larm;
    private final ModelRenderer leftarm4_r1;
    private final ModelRenderer leftarm3_r1;
    private final ModelRenderer forearm;
    private final ModelRenderer leftarm5_r1;
    private final ModelRenderer backhorn7_r3;
    private final ModelRenderer wrist;
    private final ModelRenderer leftarm4_r2;
    private final ModelRenderer indexfinger;
    private final ModelRenderer cube_r2;
    private final ModelRenderer bone27;
    private final ModelRenderer cube_r3;
    private final ModelRenderer bone28;
    private final ModelRenderer cube_r4;
    private final ModelRenderer thumb;
    private final ModelRenderer cube_r5;
    private final ModelRenderer bone;
    private final ModelRenderer cube_r6;
    private final ModelRenderer bone4;
    private final ModelRenderer cube_r7;
    private final ModelRenderer thumbmini2;
    private final ModelRenderer cube_r8;
    private final ModelRenderer bone30;
    private final ModelRenderer cube_r9;
    private final ModelRenderer bone31;
    private final ModelRenderer cube_r10;
    private final ModelRenderer finger2;
    private final ModelRenderer cube_r11;
    private final ModelRenderer bone33;
    private final ModelRenderer cube_r12;
    private final ModelRenderer bone34;
    private final ModelRenderer cube_r13;
    private final ModelRenderer rarm;
    private final ModelRenderer leftarm5_r2;
    private final ModelRenderer leftarm4_r3;
    private final ModelRenderer forearm2;
    private final ModelRenderer leftarm6_r1;
    private final ModelRenderer backhorn8_r3;
    private final ModelRenderer wrist2;
    private final ModelRenderer leftarm5_r3;
    private final ModelRenderer indexfinger2;
    private final ModelRenderer cube_r14;
    private final ModelRenderer bone14;
    private final ModelRenderer cube_r15;
    private final ModelRenderer bone15;
    private final ModelRenderer cube_r16;
    private final ModelRenderer thumb2;
    private final ModelRenderer cube_r17;
    private final ModelRenderer bone16;
    private final ModelRenderer cube_r18;
    private final ModelRenderer bone19;
    private final ModelRenderer cube_r19;
    private final ModelRenderer thumbmini3;
    private final ModelRenderer cube_r20;
    private final ModelRenderer bone20;
    private final ModelRenderer cube_r21;
    private final ModelRenderer bone21;
    private final ModelRenderer cube_r22;
    private final ModelRenderer finger3;
    private final ModelRenderer cube_r23;
    private final ModelRenderer bone22;
    private final ModelRenderer cube_r24;
    private final ModelRenderer bone23;
    private final ModelRenderer cube_r25;
    private final ModelRenderer lowertorso;
    private final ModelRenderer body2_r1;
    private final ModelRenderer back2_r2;
    private final ModelRenderer tail;
    private final ModelRenderer tailSpikes1_r1;
    private final ModelRenderer tail1_r1;
    private final ModelRenderer bone6;
    private final ModelRenderer tailSpikes2_r1;
    private final ModelRenderer tail2_r1;
    private final ModelRenderer bone7;
    private final ModelRenderer tail3_r1;
    private final ModelRenderer tailSpikes3_r1;
    private final ModelRenderer bone9;
    private final ModelRenderer tailSpikes4_r1;
    private final ModelRenderer tail4_r1;
    private final ModelRenderer bone5;
    private final ModelRenderer tailSpikes5_r1;
    private final ModelRenderer tail5_r1;
    private final ModelRenderer bone8;
    private final ModelRenderer stabber_r1;
    private final ModelRenderer lleg;
    private final ModelRenderer leftleg3_r1;
    private final ModelRenderer leftleg2_r1;
    private final ModelRenderer bone13;
    private final ModelRenderer leftleg3_r2;
    private final ModelRenderer bone17;
    private final ModelRenderer leftleg5_r1;
    private final ModelRenderer leftleg4_r1;
    private final ModelRenderer bone18;
    private final ModelRenderer leftleg5_r2;
    private final ModelRenderer lleg2;
    private final ModelRenderer leftleg4_r2;
    private final ModelRenderer leftleg3_r3;
    private final ModelRenderer bone10;
    private final ModelRenderer leftleg4_r3;
    private final ModelRenderer bone11;
    private final ModelRenderer leftleg6_r1;
    private final ModelRenderer leftleg5_r3;
    private final ModelRenderer bone12;
    private final ModelRenderer leftleg6_r2;

    public ModelDrone() {
        textureWidth = 256;
        textureHeight = 256;

        ModelDrone = new ModelRenderer(this);
        ModelDrone.setRotationPoint(0.0F, -9.0F, 0.0F);
        setRotationAngle(ModelDrone, -0.6545F, 0.0F, 0.0F);


        torso = new ModelRenderer(this);
        torso.setRotationPoint(0.0F, 0.0F, 0.0F);
        ModelDrone.addChild(torso);


        back2_r1 = new ModelRenderer(this);
        back2_r1.setRotationPoint(0.0F, -2.5F, -8.0F);
        torso.addChild(back2_r1);
        setRotationAngle(back2_r1, -0.192F, 0.0F, 0.0F);
        back2_r1.cubeList.add(new ModelBox(back2_r1, 25, 66, 0.0F, -8.046F, -4.9081F, 0, 8, 10, 0.0F, false));

        back1_r1 = new ModelRenderer(this);
        back1_r1.setRotationPoint(0.0F, -7.4357F, -6.947F);
        torso.addChild(back1_r1);
        setRotationAngle(back1_r1, 0.6807F, 0.0F, 0.0F);
        back1_r1.cubeList.add(new ModelBox(back1_r1, 0, 65, 0.0F, -8.0F, -10.0F, 0, 8, 10, 0.0F, false));

        body1_r1 = new ModelRenderer(this);
        body1_r1.setRotationPoint(0.0F, -2.5F, -13.0F);
        torso.addChild(body1_r1);
        setRotationAngle(body1_r1, -0.192F, 0.0F, 0.0F);
        body1_r1.cubeList.add(new ModelBox(body1_r1, 0, 46, -4.5F, -2.0F, 0.0F, 9, 8, 10, 0.0F, false));

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, 0.0F, -14.0F);
        torso.addChild(neck);


        neck_r1 = new ModelRenderer(this);
        neck_r1.setRotationPoint(0.0F, -0.3682F, 0.3252F);
        neck.addChild(neck_r1);
        setRotationAngle(neck_r1, 0.3752F, 0.0F, 0.0F);
        neck_r1.cubeList.add(new ModelBox(neck_r1, 22, 85, -2.0F, -3.0F, -3.0F, 4, 6, 6, 0.0F, false));

        bone2 = new ModelRenderer(this);
        bone2.setRotationPoint(0.0F, 0.0F, -2.0F);
        neck.addChild(bone2);


        neck_r2 = new ModelRenderer(this);
        neck_r2.setRotationPoint(0.0F, -0.6462F, -1.5286F);
        bone2.addChild(neck_r2);
        setRotationAngle(neck_r2, 0.8116F, 0.0F, 0.0F);
        neck_r2.cubeList.add(new ModelBox(neck_r2, 23, 87, -2.0F, -1.0F, -4.0F, 4, 5, 5, 0.0F, false));

        bone3 = new ModelRenderer(this);
        bone3.setRotationPoint(0.0F, 3.0F, -1.5F);
        bone2.addChild(bone3);


        neck_r3 = new ModelRenderer(this);
        neck_r3.setRotationPoint(0.0F, 0.492F, 1.6344F);
        bone3.addChild(neck_r3);
        setRotationAngle(neck_r3, 1.5097F, 0.0F, 0.0F);
        neck_r3.cubeList.add(new ModelBox(neck_r3, 26, 89, -2.0F, -1.0F, -2.0F, 4, 1, 2, 0.0F, false));

        head = new ModelRenderer(this);
        head.setRotationPoint(-0.2168F, 0.6952F, -0.6068F);
        bone3.addChild(head);
        setRotationAngle(head, 0.9599F, 0.0F, 0.0F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(-4.2832F, 3.0202F, -3.78F);
        head.addChild(cube_r1);
        setRotationAngle(cube_r1, -0.0436F, 0.0F, 0.0F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 124, 9, 3.0F, -2.0F, -1.0F, 3, 1, 3, 0.0F, false));

        head6_r1 = new ModelRenderer(this);
        head6_r1.setRotationPoint(0.7168F, 0.2677F, 0.853F);
        head.addChild(head6_r1);
        setRotationAngle(head6_r1, 0.384F, 0.0F, 0.0F);
        head6_r1.cubeList.add(new ModelBox(head6_r1, 166, 44, -1.5F, -1.0F, -4.5F, 2, 2, 5, 0.0F, false));

        head4_r1 = new ModelRenderer(this);
        head4_r1.setRotationPoint(0.2168F, 0.2677F, -2.147F);
        head.addChild(head4_r1);
        setRotationAngle(head4_r1, -0.0524F, 0.0F, 0.0F);
        head4_r1.cubeList.add(new ModelBox(head4_r1, 52, 19, -1.5F, -1.157F, -2.5041F, 3, 2, 5, 0.0F, false));

        head5_r1 = new ModelRenderer(this);
        head5_r1.setRotationPoint(0.2268F, -7.3901F, -4.5796F);
        head.addChild(head5_r1);
        setRotationAngle(head5_r1, -1.6057F, 0.0F, 0.0F);
        head5_r1.cubeList.add(new ModelBox(head5_r1, 28, 10, -2.5F, -19.0F, -2.5F, 5, 6, 5, 0.0F, false));

        head2_r1 = new ModelRenderer(this);
        head2_r1.setRotationPoint(0.2168F, -0.2331F, 0.8046F);
        head.addChild(head2_r1);
        setRotationAngle(head2_r1, -0.1222F, 0.0F, 0.0F);
        head2_r1.cubeList.add(new ModelBox(head2_r1, 53, 0, -0.49F, -1.9627F, -5.6093F, 3, 3, 5, 0.0F, false));

        head2_r2 = new ModelRenderer(this);
        head2_r2.setRotationPoint(0.2268F, -6.6211F, -6.5585F);
        head.addChild(head2_r2);
        setRotationAngle(head2_r2, -0.7156F, 0.0F, 0.0F);
        head2_r2.cubeList.add(new ModelBox(head2_r2, 1, 8, -2.5F, -1.5F, 4.0F, 5, 3, 4, 0.0F, false));

        head2_r3 = new ModelRenderer(this);
        head2_r3.setRotationPoint(0.2268F, -3.9851F, -3.0242F);
        head.addChild(head2_r3);
        setRotationAngle(head2_r3, -1.3265F, 0.0F, 0.0F);
        head2_r3.cubeList.add(new ModelBox(head2_r3, 0, 0, -2.5F, -12.5F, -2.5F, 5, 7, 5, 0.0F, false));

        head1_r1 = new ModelRenderer(this);
        head1_r1.setRotationPoint(0.2268F, -2.571F, -0.988F);
        head.addChild(head1_r1);
        setRotationAngle(head1_r1, -1.021F, 0.0F, 0.0F);
        head1_r1.cubeList.add(new ModelBox(head1_r1, 0, 0, -2.5F, -5.0F, -3.0F, 5, 5, 5, 0.0F, false));

        head6_r2 = new ModelRenderer(this);
        head6_r2.setRotationPoint(0.2168F, -5.2331F, 0.8046F);
        head.addChild(head6_r2);
        setRotationAngle(head6_r2, -0.1222F, 0.0F, 0.0F);
        head6_r2.cubeList.add(new ModelBox(head6_r2, 34, 0, -2.501F, 3.0F, -5.0F, 3, 3, 5, 0.0F, false));

        lowerjaw = new ModelRenderer(this);
        lowerjaw.setRotationPoint(0.2168F, 1.9275F, 0.5228F);
        head.addChild(lowerjaw);
        setRotationAngle(lowerjaw, -0.3935F, 0.0109F, -0.0044F);


        chin_r1 = new ModelRenderer(this);
        chin_r1.setRotationPoint(0.0044F, 1.8301F, -2.0789F);
        lowerjaw.addChild(chin_r1);
        setRotationAngle(chin_r1, 0.4276F, 0.0F, 0.0F);
        chin_r1.cubeList.add(new ModelBox(chin_r1, 145, 33, -1.5F, -0.5F, -2.5F, 3, 1, 5, 0.0F, false));

        head6_r3 = new ModelRenderer(this);
        head6_r3.setRotationPoint(0.0044F, -1.3673F, -2.2972F);
        lowerjaw.addChild(head6_r3);
        setRotationAngle(head6_r3, -0.4276F, 0.0F, -3.1416F);
        head6_r3.cubeList.add(new ModelBox(head6_r3, 167, 12, -1.5F, -1.5F, -3.6273F, 3, 3, 5, 0.0F, false));

        head5_r2 = new ModelRenderer(this);
        head5_r2.setRotationPoint(0.0044F, -0.0049F, -0.4638F);
        lowerjaw.addChild(head5_r2);
        setRotationAngle(head5_r2, -0.4276F, 0.0F, -3.1416F);
        head5_r2.cubeList.add(new ModelBox(head5_r2, 52, 20, -1.5F, -0.5F, -4.7307F, 3, 1, 5, 0.0F, false));

        upperbody = new ModelRenderer(this);
        upperbody.setRotationPoint(0.0F, 1.0F, -3.0F);
        torso.addChild(upperbody);


        dorsaltubesr = new ModelRenderer(this);
        dorsaltubesr.setRotationPoint(0.0F, -3.5F, -8.0F);
        upperbody.addChild(dorsaltubesr);


        backhorn8_r1 = new ModelRenderer(this);
        backhorn8_r1.setRotationPoint(-2.0F, -1.0F, 2.75F);
        dorsaltubesr.addChild(backhorn8_r1);
        setRotationAngle(backhorn8_r1, -0.5585F, 0.0F, -0.1745F);
        backhorn8_r1.cubeList.add(new ModelBox(backhorn8_r1, 50, 29, -1.204F, -10.3532F, -1.0723F, 2, 10, 2, 0.0F, false));

        backhorn7_r1 = new ModelRenderer(this);
        backhorn7_r1.setRotationPoint(3.57F, 1.8979F, -1.1389F);
        dorsaltubesr.addChild(backhorn7_r1);
        setRotationAngle(backhorn7_r1, -0.1025F, -0.229F, 0.1558F);
        backhorn7_r1.cubeList.add(new ModelBox(backhorn7_r1, 92, 64, -0.8727F, -4.3877F, -1.8868F, 2, 9, 4, 0.0F, false));

        backhorn6_r1 = new ModelRenderer(this);
        backhorn6_r1.setRotationPoint(-4.0F, -1.75F, 0.0F);
        dorsaltubesr.addChild(backhorn6_r1);
        setRotationAngle(backhorn6_r1, -0.1949F, 0.1713F, -0.2082F);
        backhorn6_r1.cubeList.add(new ModelBox(backhorn6_r1, 40, 29, -0.9091F, -11.2448F, -0.5978F, 2, 12, 2, 0.0F, false));

        dorsaltubesl = new ModelRenderer(this);
        dorsaltubesl.setRotationPoint(0.0F, -3.5F, -8.0F);
        upperbody.addChild(dorsaltubesl);


        backhorn9_r1 = new ModelRenderer(this);
        backhorn9_r1.setRotationPoint(2.0F, -1.0F, 2.75F);
        dorsaltubesl.addChild(backhorn9_r1);
        setRotationAngle(backhorn9_r1, -0.5585F, 0.0F, 0.1745F);
        backhorn9_r1.cubeList.add(new ModelBox(backhorn9_r1, 50, 29, -0.796F, -10.3532F, -1.0723F, 2, 10, 2, 0.0F, true));

        backhorn8_r2 = new ModelRenderer(this);
        backhorn8_r2.setRotationPoint(-3.57F, 1.8979F, -1.1389F);
        dorsaltubesl.addChild(backhorn8_r2);
        setRotationAngle(backhorn8_r2, -0.1025F, 0.229F, -0.1558F);
        backhorn8_r2.cubeList.add(new ModelBox(backhorn8_r2, 92, 64, -1.1273F, -4.3877F, -1.8868F, 2, 9, 4, 0.0F, true));

        backhorn7_r2 = new ModelRenderer(this);
        backhorn7_r2.setRotationPoint(4.0F, -1.75F, 0.0F);
        dorsaltubesl.addChild(backhorn7_r2);
        setRotationAngle(backhorn7_r2, -0.1949F, -0.1713F, 0.2082F);
        backhorn7_r2.cubeList.add(new ModelBox(backhorn7_r2, 40, 29, -1.0909F, -11.2448F, -0.5978F, 2, 12, 2, 0.0F, true));

        larm = new ModelRenderer(this);
        larm.setRotationPoint(4.5F, -1.5F, -7.0F);
        upperbody.addChild(larm);
        setRotationAngle(larm, 0.9536F, -0.0803F, 0.2535F);


        leftarm4_r1 = new ModelRenderer(this);
        leftarm4_r1.setRotationPoint(0.125F, 0.2719F, -0.4006F);
        larm.addChild(leftarm4_r1);
        setRotationAngle(leftarm4_r1, 0.9776F, 1.1238F, 0.3354F);
        leftarm4_r1.cubeList.add(new ModelBox(leftarm4_r1, 50, 29, -2.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, true));

        leftarm3_r1 = new ModelRenderer(this);
        leftarm3_r1.setRotationPoint(0.125F, 0.2719F, -0.4006F);
        larm.addChild(leftarm3_r1);
        setRotationAngle(leftarm3_r1, 0.3665F, 0.0F, -0.5934F);
        leftarm3_r1.cubeList.add(new ModelBox(leftarm3_r1, 50, 29, -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, true));

        forearm = new ModelRenderer(this);
        forearm.setRotationPoint(5.5334F, 8.7378F, 4.5177F);
        larm.addChild(forearm);
        setRotationAngle(forearm, 0.0077F, -0.233F, -0.0265F);


        leftarm5_r1 = new ModelRenderer(this);
        leftarm5_r1.setRotationPoint(-5.6925F, -8.449F, -5.1238F);
        forearm.addChild(leftarm5_r1);
        setRotationAngle(leftarm5_r1, 0.3665F, 0.0F, -0.5934F);
        leftarm5_r1.cubeList.add(new ModelBox(leftarm5_r1, 71, 9, -1.0F, 10.5F, -10.5F, 2, 2, 11, 0.0F, true));

        backhorn7_r3 = new ModelRenderer(this);
        backhorn7_r3.setRotationPoint(-0.0521F, -0.0535F, -0.3697F);
        forearm.addChild(backhorn7_r3);
        setRotationAngle(backhorn7_r3, -1.4464F, -0.025F, -0.5445F);
        backhorn7_r3.cubeList.add(new ModelBox(backhorn7_r3, 50, 29, -1.0962F, -4.6834F, 0.5525F, 2, 10, 2, 0.0F, true));

        wrist = new ModelRenderer(this);
        wrist.setRotationPoint(2.7159F, 3.5169F, -11.2056F);
        forearm.addChild(wrist);
        setRotationAngle(wrist, -0.1325F, -0.276F, 1.2402F);


        leftarm4_r2 = new ModelRenderer(this);
        leftarm4_r2.setRotationPoint(-8.2259F, -12.1609F, 6.0217F);
        wrist.addChild(leftarm4_r2);
        setRotationAngle(leftarm4_r2, 0.3665F, 0.0F, -0.5934F);
        leftarm4_r2.cubeList.add(new ModelBox(leftarm4_r2, 83, 24, -1.0F, 11.0F, -13.5F, 2, 1, 3, 0.0F, true));

        indexfinger = new ModelRenderer(this);
        indexfinger.setRotationPoint(-0.8175F, 1.305F, -1.06F);
        wrist.addChild(indexfinger);
        setRotationAngle(indexfinger, 0.0363F, 0.3057F, -0.0156F);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(0.0436F, -5.7368F, -0.0161F);
        indexfinger.addChild(cube_r2);
        setRotationAngle(cube_r2, 0.7418F, -0.2182F, -0.5236F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 21, 10, -2.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, false));

        bone27 = new ModelRenderer(this);
        bone27.setRotationPoint(0.0F, 0.0F, 0.0F);
        indexfinger.addChild(bone27);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(2.8099F, 2.4566F, -3.2272F);
        bone27.addChild(cube_r3);
        setRotationAngle(cube_r3, 1.4835F, -0.2182F, -0.5236F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 0, 0, 0.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, false));

        bone28 = new ModelRenderer(this);
        bone28.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone27.addChild(bone28);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(3.7567F, 3.6283F, -1.9733F);
        bone28.addChild(cube_r4);
        setRotationAngle(cube_r4, 2.138F, -0.2182F, -0.5236F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        thumb = new ModelRenderer(this);
        thumb.setRotationPoint(-0.5838F, 0.8334F, -0.4581F);
        wrist.addChild(thumb);
        setRotationAngle(thumb, -2.5077F, 0.4352F, 2.3956F);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-0.1268F, -0.0263F, 0.1429F);
        thumb.addChild(cube_r5);
        setRotationAngle(cube_r5, 0.7418F, -0.2182F, -0.5236F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 21, 10, -0.6686F, -0.4524F, -2.6072F, 1, 1, 3, 0.0F, false));

        bone = new ModelRenderer(this);
        bone.setRotationPoint(2.0635F, 2.8507F, -1.9178F);
        thumb.addChild(bone);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(-0.9241F, -1.4335F, 0.0996F);
        bone.addChild(cube_r6);
        setRotationAngle(cube_r6, 1.4835F, -0.2182F, -0.5236F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 0, 0, -0.6102F, -0.2709F, -2.5666F, 1, 1, 3, 0.0F, false));

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone.addChild(bone4);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(0.0228F, 0.9882F, 1.3536F);
        bone4.addChild(cube_r7);
        setRotationAngle(cube_r7, 2.138F, -0.2182F, -0.5236F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        thumbmini2 = new ModelRenderer(this);
        thumbmini2.setRotationPoint(0.9162F, 0.0834F, -0.4581F);
        wrist.addChild(thumbmini2);
        setRotationAngle(thumbmini2, -2.3706F, 0.348F, 1.6632F);


        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-1.5467F, -5.715F, 1.1794F);
        thumbmini2.addChild(cube_r8);
        setRotationAngle(cube_r8, 0.7418F, -0.2182F, -0.5236F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 22, 7, -2.3558F, 3.0F, -6.0F, 1, 1, 2, 0.0F, false));

        bone30 = new ModelRenderer(this);
        bone30.setRotationPoint(0.909F, 1.3024F, -1.1611F);
        thumbmini2.addChild(bone30);


        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(-0.1655F, 0.6707F, -0.1508F);
        bone30.addChild(cube_r9);
        setRotationAngle(cube_r9, 1.4835F, -0.2182F, -0.5236F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 21, 15, 0.0F, -0.5F, -0.5F, 1, 1, 2, 0.0F, false));

        bone31 = new ModelRenderer(this);
        bone31.setRotationPoint(0.6191F, 0.9373F, -0.3046F);
        bone30.addChild(bone31);


        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(-0.3522F, 0.0518F, 1.4929F);
        bone31.addChild(cube_r10);
        setRotationAngle(cube_r10, 2.138F, -0.2182F, -0.5236F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        finger2 = new ModelRenderer(this);
        finger2.setRotationPoint(3.0654F, 2.3836F, -4.3413F);
        wrist.addChild(finger2);
        setRotationAngle(finger2, -0.1387F, -0.1105F, -0.1508F);


        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-2.9288F, -7.9163F, 2.9651F);
        finger2.addChild(cube_r11);
        setRotationAngle(cube_r11, 0.7418F, -0.2182F, -0.5236F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 21, 10, -2.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, false));

        bone33 = new ModelRenderer(this);
        bone33.setRotationPoint(0.0F, 0.0F, 0.0F);
        finger2.addChild(bone33);


        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(-0.1625F, 0.2771F, -0.246F);
        bone33.addChild(cube_r12);
        setRotationAngle(cube_r12, 1.4835F, -0.2182F, -0.5236F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 0, 0, 0.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, false));

        bone34 = new ModelRenderer(this);
        bone34.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone33.addChild(bone34);


        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(0.7843F, 1.4488F, 1.008F);
        bone34.addChild(cube_r13);
        setRotationAngle(cube_r13, 2.138F, -0.2182F, -0.5236F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        rarm = new ModelRenderer(this);
        rarm.setRotationPoint(-4.5F, -1.5F, -7.0F);
        upperbody.addChild(rarm);
        setRotationAngle(rarm, 0.9536F, 0.0803F, -0.2535F);


        leftarm5_r2 = new ModelRenderer(this);
        leftarm5_r2.setRotationPoint(-0.125F, 0.2719F, -0.4006F);
        rarm.addChild(leftarm5_r2);
        setRotationAngle(leftarm5_r2, 0.9776F, -1.1238F, -0.3354F);
        leftarm5_r2.cubeList.add(new ModelBox(leftarm5_r2, 50, 29, 0.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, false));

        leftarm4_r3 = new ModelRenderer(this);
        leftarm4_r3.setRotationPoint(-0.125F, 0.2719F, -0.4006F);
        rarm.addChild(leftarm4_r3);
        setRotationAngle(leftarm4_r3, 0.3665F, 0.0F, 0.5934F);
        leftarm4_r3.cubeList.add(new ModelBox(leftarm4_r3, 50, 29, -1.0F, -1.0F, -1.0F, 2, 13, 2, 0.0F, false));

        forearm2 = new ModelRenderer(this);
        forearm2.setRotationPoint(-5.5334F, 8.7378F, 4.5177F);
        rarm.addChild(forearm2);
        setRotationAngle(forearm2, 0.0077F, 0.233F, 0.0265F);


        leftarm6_r1 = new ModelRenderer(this);
        leftarm6_r1.setRotationPoint(5.6925F, -8.449F, -5.1238F);
        forearm2.addChild(leftarm6_r1);
        setRotationAngle(leftarm6_r1, 0.3665F, 0.0F, 0.5934F);
        leftarm6_r1.cubeList.add(new ModelBox(leftarm6_r1, 71, 9, -1.0F, 10.5F, -10.5F, 2, 2, 11, 0.0F, false));

        backhorn8_r3 = new ModelRenderer(this);
        backhorn8_r3.setRotationPoint(0.0521F, -0.0535F, -0.3697F);
        forearm2.addChild(backhorn8_r3);
        setRotationAngle(backhorn8_r3, -1.4464F, 0.025F, 0.5445F);
        backhorn8_r3.cubeList.add(new ModelBox(backhorn8_r3, 50, 29, -0.9038F, -4.6834F, 0.5525F, 2, 10, 2, 0.0F, false));

        wrist2 = new ModelRenderer(this);
        wrist2.setRotationPoint(-2.7159F, 3.5169F, -11.2056F);
        forearm2.addChild(wrist2);
        setRotationAngle(wrist2, -0.1325F, 0.276F, -1.2402F);


        leftarm5_r3 = new ModelRenderer(this);
        leftarm5_r3.setRotationPoint(8.2259F, -12.1609F, 6.0217F);
        wrist2.addChild(leftarm5_r3);
        setRotationAngle(leftarm5_r3, 0.3665F, 0.0F, 0.5934F);
        leftarm5_r3.cubeList.add(new ModelBox(leftarm5_r3, 83, 24, -1.0F, 11.0F, -13.5F, 2, 1, 3, 0.0F, false));

        indexfinger2 = new ModelRenderer(this);
        indexfinger2.setRotationPoint(0.8175F, 1.305F, -1.06F);
        wrist2.addChild(indexfinger2);
        setRotationAngle(indexfinger2, 0.0363F, -0.3057F, 0.0156F);


        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(-0.0436F, -5.7368F, -0.0161F);
        indexfinger2.addChild(cube_r14);
        setRotationAngle(cube_r14, 0.7418F, 0.2182F, 0.5236F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 21, 10, 1.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, true));

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(0.0F, 0.0F, 0.0F);
        indexfinger2.addChild(bone14);


        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(-2.8099F, 2.4566F, -3.2272F);
        bone14.addChild(cube_r15);
        setRotationAngle(cube_r15, 1.4835F, 0.2182F, 0.5236F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 0, 0, -1.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, true));

        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone14.addChild(bone15);


        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(-3.7567F, 3.6283F, -1.9733F);
        bone15.addChild(cube_r16);
        setRotationAngle(cube_r16, 2.138F, 0.2182F, 0.5236F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        thumb2 = new ModelRenderer(this);
        thumb2.setRotationPoint(0.5838F, 0.8334F, -0.4581F);
        wrist2.addChild(thumb2);
        setRotationAngle(thumb2, -2.5077F, -0.4352F, -2.3956F);


        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(0.1268F, -0.0263F, 0.1429F);
        thumb2.addChild(cube_r17);
        setRotationAngle(cube_r17, 0.7418F, 0.2182F, 0.5236F);
        cube_r17.cubeList.add(new ModelBox(cube_r17, 21, 10, -0.3314F, -0.4524F, -2.6072F, 1, 1, 3, 0.0F, true));

        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(-2.0635F, 2.8507F, -1.9178F);
        thumb2.addChild(bone16);


        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(0.9241F, -1.4335F, 0.0996F);
        bone16.addChild(cube_r18);
        setRotationAngle(cube_r18, 1.4835F, 0.2182F, 0.5236F);
        cube_r18.cubeList.add(new ModelBox(cube_r18, 0, 0, -0.3898F, -0.2709F, -2.5666F, 1, 1, 3, 0.0F, true));

        bone19 = new ModelRenderer(this);
        bone19.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone16.addChild(bone19);


        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(-0.0228F, 0.9882F, 1.3536F);
        bone19.addChild(cube_r19);
        setRotationAngle(cube_r19, 2.138F, 0.2182F, 0.5236F);
        cube_r19.cubeList.add(new ModelBox(cube_r19, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        thumbmini3 = new ModelRenderer(this);
        thumbmini3.setRotationPoint(-0.9162F, 0.0834F, -0.4581F);
        wrist2.addChild(thumbmini3);
        setRotationAngle(thumbmini3, -2.3706F, -0.348F, -1.6632F);


        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(1.5467F, -5.715F, 1.1794F);
        thumbmini3.addChild(cube_r20);
        setRotationAngle(cube_r20, 0.7418F, 0.2182F, 0.5236F);
        cube_r20.cubeList.add(new ModelBox(cube_r20, 22, 7, 1.3558F, 3.0F, -6.0F, 1, 1, 2, 0.0F, true));

        bone20 = new ModelRenderer(this);
        bone20.setRotationPoint(-0.909F, 1.3024F, -1.1611F);
        thumbmini3.addChild(bone20);


        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(0.1655F, 0.6707F, -0.1508F);
        bone20.addChild(cube_r21);
        setRotationAngle(cube_r21, 1.4835F, 0.2182F, 0.5236F);
        cube_r21.cubeList.add(new ModelBox(cube_r21, 21, 15, -1.0F, -0.5F, -0.5F, 1, 1, 2, 0.0F, true));

        bone21 = new ModelRenderer(this);
        bone21.setRotationPoint(-0.6191F, 0.9373F, -0.3046F);
        bone20.addChild(bone21);


        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(0.3522F, 0.0518F, 1.4929F);
        bone21.addChild(cube_r22);
        setRotationAngle(cube_r22, 2.138F, 0.2182F, 0.5236F);
        cube_r22.cubeList.add(new ModelBox(cube_r22, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        finger3 = new ModelRenderer(this);
        finger3.setRotationPoint(-3.0654F, 2.3836F, -4.3413F);
        wrist2.addChild(finger3);
        setRotationAngle(finger3, -0.1387F, 0.1105F, 0.1508F);


        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(2.9288F, -7.9163F, 2.9651F);
        finger3.addChild(cube_r23);
        setRotationAngle(cube_r23, 0.7418F, 0.2182F, 0.5236F);
        cube_r23.cubeList.add(new ModelBox(cube_r23, 21, 10, 1.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, true));

        bone22 = new ModelRenderer(this);
        bone22.setRotationPoint(0.0F, 0.0F, 0.0F);
        finger3.addChild(bone22);


        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(0.1625F, 0.2771F, -0.246F);
        bone22.addChild(cube_r24);
        setRotationAngle(cube_r24, 1.4835F, 0.2182F, 0.5236F);
        cube_r24.cubeList.add(new ModelBox(cube_r24, 0, 0, -1.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, true));

        bone23 = new ModelRenderer(this);
        bone23.setRotationPoint(0.0F, 0.0F, 0.0F);
        bone22.addChild(bone23);


        cube_r25 = new ModelRenderer(this);
        cube_r25.setRotationPoint(-0.7843F, 1.4488F, 1.008F);
        bone23.addChild(cube_r25);
        setRotationAngle(cube_r25, 2.138F, 0.2182F, 0.5236F);
        cube_r25.cubeList.add(new ModelBox(cube_r25, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        lowertorso = new ModelRenderer(this);
        lowertorso.setRotationPoint(0.0F, 1.0F, -4.0F);
        torso.addChild(lowertorso);


        body2_r1 = new ModelRenderer(this);
        body2_r1.setRotationPoint(0.0F, 0.5F, 0.0F);
        lowertorso.addChild(body2_r1);
        setRotationAngle(body2_r1, -0.5585F, 0.0F, 0.0F);
        body2_r1.cubeList.add(new ModelBox(body2_r1, 0, 27, -3.5F, -3.6229F, -1.7521F, 7, 6, 12, 0.0F, false));

        back2_r2 = new ModelRenderer(this);
        back2_r2.setRotationPoint(0.0F, -3.5F, -9.0F);
        lowertorso.addChild(back2_r2);
        setRotationAngle(back2_r2, -0.5585F, 0.0F, 0.0F);
        back2_r2.cubeList.add(new ModelBox(back2_r2, 23, 66, 0.0F, -10.0F, 8.0F, 0, 6, 12, 0.0F, false));

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-0.1458F, 2.8648F, 7.9612F);
        lowertorso.addChild(tail);
        setRotationAngle(tail, 0.3783F, 0.6194F, 0.2268F);


        tailSpikes1_r1 = new ModelRenderer(this);
        tailSpikes1_r1.setRotationPoint(-0.7713F, 0.8963F, -0.5648F);
        tail.addChild(tailSpikes1_r1);
        setRotationAngle(tailSpikes1_r1, -0.4014F, -0.6667F, 0.0F);
        tailSpikes1_r1.cubeList.add(new ModelBox(tailSpikes1_r1, 24, 65, 0.9995F, -9.5123F, 0.029F, 0, 8, 11, 0.0F, false));

        tail1_r1 = new ModelRenderer(this);
        tail1_r1.setRotationPoint(-0.667F, 0.8963F, -0.5648F);
        tail.addChild(tail1_r1);
        setRotationAngle(tail1_r1, -0.4014F, -0.6667F, 0.0F);
        tail1_r1.cubeList.add(new ModelBox(tail1_r1, 50, 66, -1.0005F, -2.5123F, 0.029F, 4, 4, 11, 0.0F, false));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(-6.2334F, 5.1147F, 8.578F);
        tail.addChild(bone6);
        setRotationAngle(bone6, -0.2894F, -0.4078F, -0.1123F);


        tailSpikes2_r1 = new ModelRenderer(this);
        tailSpikes2_r1.setRotationPoint(-2.3146F, 1.3369F, 3.7185F);
        bone6.addChild(tailSpikes2_r1);
        setRotationAngle(tailSpikes2_r1, -0.3179F, -0.2915F, 0.0141F);
        tailSpikes2_r1.cubeList.add(new ModelBox(tailSpikes2_r1, 24, 65, 0.9998F, -9.0171F, -5.4909F, 0, 8, 11, 0.0F, false));

        tail2_r1 = new ModelRenderer(this);
        tail2_r1.setRotationPoint(-1.0162F, -0.8318F, -1.0621F);
        bone6.addChild(tail2_r1);
        setRotationAngle(tail2_r1, -0.3179F, -0.2915F, 0.0141F);
        tail2_r1.cubeList.add(new ModelBox(tail2_r1, 84, 66, -1.0002F, -1.5171F, 0.0091F, 4, 4, 11, 0.0F, false));

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(-3.2561F, 3.113F, 9.601F);
        bone6.addChild(bone7);
        setRotationAngle(bone7, 0.4367F, 0.9476F, 0.4426F);


        tail3_r1 = new ModelRenderer(this);
        tail3_r1.setRotationPoint(0.3529F, 0.0076F, -1.282F);
        bone7.addChild(tail3_r1);
        setRotationAngle(tail3_r1, -0.2703F, -1.2848F, 0.0643F);
        tail3_r1.cubeList.add(new ModelBox(tail3_r1, 117, 66, -0.5004F, -1.5226F, 0.0194F, 3, 3, 11, 0.0F, false));

        tailSpikes3_r1 = new ModelRenderer(this);
        tailSpikes3_r1.setRotationPoint(0.9042F, 0.0076F, -1.282F);
        bone7.addChild(tailSpikes3_r1);
        setRotationAngle(tailSpikes3_r1, -0.2703F, -1.2848F, 0.0643F);
        tailSpikes3_r1.cubeList.add(new ModelBox(tailSpikes3_r1, 25, 68, 0.9996F, -7.0226F, 1.0194F, 0, 6, 10, 0.0F, false));

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(-9.6306F, 2.0146F, 2.8493F);
        bone7.addChild(bone9);
        setRotationAngle(bone9, 0.1871F, 0.8763F, 0.6104F);


        tailSpikes4_r1 = new ModelRenderer(this);
        tailSpikes4_r1.setRotationPoint(-0.097F, 0.03F, 0.9726F);
        bone9.addChild(tailSpikes4_r1);
        setRotationAngle(tailSpikes4_r1, 2.9491F, -0.9413F, -3.0786F);
        tailSpikes4_r1.cubeList.add(new ModelBox(tailSpikes4_r1, 26, 69, -1.0028F, -5.0105F, 0.0745F, 0, 4, 10, 0.0F, false));

        tail4_r1 = new ModelRenderer(this);
        tail4_r1.setRotationPoint(-0.3143F, 0.03F, 0.9726F);
        bone9.addChild(tail4_r1);
        setRotationAngle(tail4_r1, 2.951F, -0.9414F, -3.0785F);
        tail4_r1.cubeList.add(new ModelBox(tail4_r1, 148, 66, -2.0028F, -1.0105F, 0.0745F, 2, 2, 11, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(-8.0516F, 1.1245F, -5.7911F);
        bone9.addChild(bone5);
        setRotationAngle(bone5, 0.0F, 0.0436F, 0.0F);


        tailSpikes5_r1 = new ModelRenderer(this);
        tailSpikes5_r1.setRotationPoint(-3.9304F, -2.7681F, -3.2062F);
        bone5.addChild(tailSpikes5_r1);
        setRotationAngle(tailSpikes5_r1, 3.0917F, -0.9559F, -3.0663F);
        tailSpikes5_r1.cubeList.add(new ModelBox(tailSpikes5_r1, 24, 66, 0.2505F, -3.5217F, -5.4984F, 0, 7, 11, 0.0F, false));

        tail5_r1 = new ModelRenderer(this);
        tail5_r1.setRotationPoint(-4.0571F, 0.7446F, -3.5327F);
        bone5.addChild(tail5_r1);
        setRotationAngle(tail5_r1, 3.0917F, -0.9559F, -3.0663F);
        tail5_r1.cubeList.add(new ModelBox(tail5_r1, 149, 66, 0.07F, -1.0F, -5.5F, 1, 1, 11, 0.0F, false));

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(-8.25F, 0.0F, -6.0F);
        bone5.addChild(bone8);


        stabber_r1 = new ModelRenderer(this);
        stabber_r1.setRotationPoint(-4.2137F, -0.3095F, -2.6452F);
        bone8.addChild(stabber_r1);
        setRotationAngle(stabber_r1, 3.0841F, -0.9664F, -3.0545F);
        stabber_r1.cubeList.add(new ModelBox(stabber_r1, 205, 67, -1.0F, 0.0F, -5.5F, 3, 0, 11, 0.0F, false));

        lleg = new ModelRenderer(this);
        lleg.setRotationPoint(2.5F, 4.0F, 7.0F);
        lowertorso.addChild(lleg);
        setRotationAngle(lleg, 0.9641F, 0.1037F, 0.08F);


        leftleg3_r1 = new ModelRenderer(this);
        leftleg3_r1.setRotationPoint(1.1387F, -0.3439F, 0.1678F);
        lleg.addChild(leftleg3_r1);
        setRotationAngle(leftleg3_r1, -2.3533F, 0.2693F, 0.393F);
        leftleg3_r1.cubeList.add(new ModelBox(leftleg3_r1, 42, 52, -0.807F, -3.2464F, -3.7573F, 1, 6, 5, 0.0F, true));

        leftleg2_r1 = new ModelRenderer(this);
        leftleg2_r1.setRotationPoint(2.1418F, 1.2288F, -1.3794F);
        lleg.addChild(leftleg2_r1);
        setRotationAngle(leftleg2_r1, -0.8952F, -0.3271F, -0.1919F);
        leftleg2_r1.cubeList.add(new ModelBox(leftleg2_r1, 40, 45, -2.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F, true));

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(5.3035F, 7.2734F, -8.1555F);
        lleg.addChild(bone13);
        setRotationAngle(bone13, -0.8365F, 0.1765F, -0.0915F);


        leftleg3_r2 = new ModelRenderer(this);
        leftleg3_r2.setRotationPoint(-0.6174F, 1.9864F, 4.5186F);
        bone13.addChild(leftleg3_r2);
        setRotationAngle(leftleg3_r2, -0.4014F, -0.2443F, -0.4189F);
        leftleg3_r2.cubeList.add(new ModelBox(leftleg3_r2, 78, 48, -1.5F, -1.5F, -6.5F, 3, 3, 13, 0.0F, true));

        bone17 = new ModelRenderer(this);
        bone17.setRotationPoint(-0.8338F, 4.6321F, 10.0211F);
        bone13.addChild(bone17);
        setRotationAngle(bone17, 1.0853F, -0.5125F, 0.1355F);


        leftleg5_r1 = new ModelRenderer(this);
        leftleg5_r1.setRotationPoint(0.428F, 0.0667F, -1.209F);
        bone17.addChild(leftleg5_r1);
        setRotationAngle(leftleg5_r1, -1.1956F, -0.2443F, -0.4189F);
        leftleg5_r1.cubeList.add(new ModelBox(leftleg5_r1, 113, 53, -0.9594F, -6.9829F, -0.4375F, 2, 8, 2, 0.0F, true));

        leftleg4_r1 = new ModelRenderer(this);
        leftleg4_r1.setRotationPoint(-3.4212F, -11.1078F, -3.0998F);
        bone17.addChild(leftleg4_r1);
        setRotationAngle(leftleg4_r1, -0.8029F, -0.2443F, -0.4189F);
        leftleg4_r1.cubeList.add(new ModelBox(leftleg4_r1, 113, 53, -1.5F, 4.5F, 9.0F, 2, 10, 2, 0.0F, true));

        bone18 = new ModelRenderer(this);
        bone18.setRotationPoint(3.5792F, 4.0947F, -6.0037F);
        bone17.addChild(bone18);
        setRotationAngle(bone18, -0.7142F, 0.0842F, -0.2207F);


        leftleg5_r2 = new ModelRenderer(this);
        leftleg5_r2.setRotationPoint(0.4783F, 0.6323F, -1.3906F);
        bone18.addChild(leftleg5_r2);
        setRotationAngle(leftleg5_r2, 0.0644F, -0.1768F, -0.2644F);
        leftleg5_r2.cubeList.add(new ModelBox(leftleg5_r2, 93, 23, -2.0F, -1.0F, -3.5F, 3, 2, 6, 0.0F, true));

        lleg2 = new ModelRenderer(this);
        lleg2.setRotationPoint(-2.5F, 4.0F, 7.0F);
        lowertorso.addChild(lleg2);
        setRotationAngle(lleg2, 0.9641F, -0.1037F, -0.08F);


        leftleg4_r2 = new ModelRenderer(this);
        leftleg4_r2.setRotationPoint(-1.1387F, -0.3439F, 0.1678F);
        lleg2.addChild(leftleg4_r2);
        setRotationAngle(leftleg4_r2, -2.3533F, -0.2693F, -0.393F);
        leftleg4_r2.cubeList.add(new ModelBox(leftleg4_r2, 42, 52, -0.193F, -3.2464F, -3.7573F, 1, 6, 5, 0.0F, false));

        leftleg3_r3 = new ModelRenderer(this);
        leftleg3_r3.setRotationPoint(-2.1418F, 1.2288F, -1.3794F);
        lleg2.addChild(leftleg3_r3);
        setRotationAngle(leftleg3_r3, -0.8952F, 0.3271F, 0.1919F);
        leftleg3_r3.cubeList.add(new ModelBox(leftleg3_r3, 40, 45, -1.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F, false));

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(-5.3035F, 7.2734F, -8.1555F);
        lleg2.addChild(bone10);
        setRotationAngle(bone10, -0.8365F, -0.1765F, 0.0915F);


        leftleg4_r3 = new ModelRenderer(this);
        leftleg4_r3.setRotationPoint(0.6174F, 1.9864F, 4.5186F);
        bone10.addChild(leftleg4_r3);
        setRotationAngle(leftleg4_r3, -0.4014F, 0.2443F, 0.4189F);
        leftleg4_r3.cubeList.add(new ModelBox(leftleg4_r3, 78, 48, -1.5F, -1.5F, -6.5F, 3, 3, 13, 0.0F, false));

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.8338F, 4.6321F, 10.0211F);
        bone10.addChild(bone11);
        setRotationAngle(bone11, 1.0853F, 0.5125F, -0.1355F);


        leftleg6_r1 = new ModelRenderer(this);
        leftleg6_r1.setRotationPoint(-0.428F, 0.0667F, -1.209F);
        bone11.addChild(leftleg6_r1);
        setRotationAngle(leftleg6_r1, -1.1956F, 0.2443F, 0.4189F);
        leftleg6_r1.cubeList.add(new ModelBox(leftleg6_r1, 113, 53, -1.0406F, -6.9829F, -0.4375F, 2, 8, 2, 0.0F, false));

        leftleg5_r3 = new ModelRenderer(this);
        leftleg5_r3.setRotationPoint(3.4212F, -11.1078F, -3.0998F);
        bone11.addChild(leftleg5_r3);
        setRotationAngle(leftleg5_r3, -0.8029F, 0.2443F, 0.4189F);
        leftleg5_r3.cubeList.add(new ModelBox(leftleg5_r3, 113, 53, -0.5F, 4.5F, 9.0F, 2, 10, 2, 0.0F, false));

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(-3.5792F, 4.0947F, -6.0037F);
        bone11.addChild(bone12);
        setRotationAngle(bone12, -0.7142F, -0.0842F, 0.2207F);


        leftleg6_r2 = new ModelRenderer(this);
        leftleg6_r2.setRotationPoint(-0.4783F, 0.6323F, -1.3906F);
        bone12.addChild(leftleg6_r2);
        setRotationAngle(leftleg6_r2, 0.0644F, 0.1768F, 0.2644F);
        leftleg6_r2.cubeList.add(new ModelBox(leftleg6_r2, 93, 23, -1.0F, -1.0F, -3.5F, 3, 2, 6, 0.0F, false));
    }

    @Override
    public void render(EntityDrone entityDrone) {
        draw(ModelDrone);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
