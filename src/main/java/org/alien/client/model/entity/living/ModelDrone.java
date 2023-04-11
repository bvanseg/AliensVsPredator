package org.alien.client.model.entity.living;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import org.alien.common.entity.living.xenomorph.EntityDrone;


public class ModelDrone extends Model<EntityDrone> {
    private final ModelRenderer ModelDrone;
    private final ModelRenderer torso;
    private final ModelRenderer body1_r1;
    private final ModelRenderer neck;
    private final ModelRenderer neck_r1;
    private final ModelRenderer bone2;
    private final ModelRenderer neck_r2;
    private final ModelRenderer bone3;
    private final ModelRenderer head;
    private final ModelRenderer head6_r1;
    private final ModelRenderer head4_r1;
    private final ModelRenderer head6_r2;
    private final ModelRenderer head2_r1;
    private final ModelRenderer head2_r2;
    private final ModelRenderer head2_r3;
    private final ModelRenderer head1_r1;
    private final ModelRenderer head6_r3;
    private final ModelRenderer lowerjaw;
    private final ModelRenderer head8_r1;
    private final ModelRenderer upperbody;
    private final ModelRenderer back2_r1;
    private final ModelRenderer back1_r1;
    private final ModelRenderer ub3ddetails2;
    private final ModelRenderer backhorn10_r1;
    private final ModelRenderer backhorn9_r1;
    private final ModelRenderer backhorn9_r2;
    private final ModelRenderer backhorn9_r3;
    private final ModelRenderer backhorn8_r1;
    private final ModelRenderer bone4;
    private final ModelRenderer backhorn8_r2;
    private final ModelRenderer backhorn7_r1;
    private final ModelRenderer backhorn8_r3;
    private final ModelRenderer lowerdorsaltube2;
    private final ModelRenderer backhorn10_r2;
    private final ModelRenderer backhorn10_r3;
    private final ModelRenderer backhorn9_r4;
    private final ModelRenderer ub3ddetails3;
    private final ModelRenderer backhorn11_r1;
    private final ModelRenderer backhorn10_r4;
    private final ModelRenderer backhorn10_r5;
    private final ModelRenderer backhorn10_r6;
    private final ModelRenderer backhorn9_r5;
    private final ModelRenderer bone13;
    private final ModelRenderer backhorn9_r6;
    private final ModelRenderer backhorn8_r4;
    private final ModelRenderer backhorn9_r7;
    private final ModelRenderer lowerdorsaltube3;
    private final ModelRenderer backhorn11_r2;
    private final ModelRenderer backhorn11_r3;
    private final ModelRenderer backhorn10_r7;
    private final ModelRenderer rarm3;
    private final ModelRenderer leftarm8_r1;
    private final ModelRenderer leftarm7_r1;
    private final ModelRenderer forearm2;
    private final ModelRenderer leftarm8_r2;
    private final ModelRenderer backhorn10_r8;
    private final ModelRenderer wrist2;
    private final ModelRenderer leftarm7_r2;
    private final ModelRenderer indexfinger2;
    private final ModelRenderer cube_r1;
    private final ModelRenderer bone16;
    private final ModelRenderer cube_r2;
    private final ModelRenderer bone19;
    private final ModelRenderer cube_r3;
    private final ModelRenderer thumb2;
    private final ModelRenderer cube_r4;
    private final ModelRenderer bone20;
    private final ModelRenderer cube_r5;
    private final ModelRenderer bone21;
    private final ModelRenderer cube_r6;
    private final ModelRenderer thumbmini3;
    private final ModelRenderer cube_r7;
    private final ModelRenderer bone22;
    private final ModelRenderer cube_r8;
    private final ModelRenderer bone23;
    private final ModelRenderer cube_r9;
    private final ModelRenderer finger3;
    private final ModelRenderer cube_r10;
    private final ModelRenderer bone24;
    private final ModelRenderer cube_r11;
    private final ModelRenderer bone25;
    private final ModelRenderer cube_r12;
    private final ModelRenderer rarm2;
    private final ModelRenderer leftarm9_r1;
    private final ModelRenderer leftarm8_r3;
    private final ModelRenderer forearm3;
    private final ModelRenderer leftarm9_r2;
    private final ModelRenderer backhorn11_r4;
    private final ModelRenderer wrist3;
    private final ModelRenderer leftarm8_r4;
    private final ModelRenderer indexfinger3;
    private final ModelRenderer cube_r13;
    private final ModelRenderer bone14;
    private final ModelRenderer cube_r14;
    private final ModelRenderer bone15;
    private final ModelRenderer cube_r15;
    private final ModelRenderer thumb3;
    private final ModelRenderer cube_r16;
    private final ModelRenderer bone17;
    private final ModelRenderer cube_r17;
    private final ModelRenderer bone18;
    private final ModelRenderer cube_r18;
    private final ModelRenderer thumbmini2;
    private final ModelRenderer cube_r19;
    private final ModelRenderer bone26;
    private final ModelRenderer cube_r20;
    private final ModelRenderer bone27;
    private final ModelRenderer cube_r21;
    private final ModelRenderer finger2;
    private final ModelRenderer cube_r22;
    private final ModelRenderer bone28;
    private final ModelRenderer cube_r23;
    private final ModelRenderer bone29;
    private final ModelRenderer cube_r24;
    private final ModelRenderer lowertorso;
    private final ModelRenderer body2_r1;
    private final ModelRenderer back2_r2;
    private final ModelRenderer tail;
    private final ModelRenderer tail1_r1;
    private final ModelRenderer back3_r1;
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
    private final ModelRenderer leftleg5_r1;
    private final ModelRenderer leftleg4_r1;
    private final ModelRenderer bone30;
    private final ModelRenderer leftleg5_r2;
    private final ModelRenderer bone31;
    private final ModelRenderer leftleg7_r1;
    private final ModelRenderer leftleg6_r1;
    private final ModelRenderer bone32;
    private final ModelRenderer leftleg7_r2;
    private final ModelRenderer rleg;
    private final ModelRenderer leftleg6_r2;
    private final ModelRenderer leftleg5_r3;
    private final ModelRenderer bone10;
    private final ModelRenderer leftleg6_r3;
    private final ModelRenderer bone11;
    private final ModelRenderer leftleg8_r1;
    private final ModelRenderer leftleg7_r3;
    private final ModelRenderer bone12;
    private final ModelRenderer leftleg8_r2;

    public ModelDrone() {
        textureWidth = 256;
        textureHeight = 256;

        ModelDrone = new ModelRenderer(this);
        ModelDrone.setRotationPoint(-0.0157F, -9.0F, 0.0F);
        setRotationAngle(ModelDrone, -0.6545F, 0.0F, 0.0F);


        torso = new ModelRenderer(this);
        torso.setRotationPoint(0.0F, 1.25F, -3.75F);
        ModelDrone.addChild(torso);


        body1_r1 = new ModelRenderer(this);
        body1_r1.setRotationPoint(0.0F, -3.75F, -9.25F);
        torso.addChild(body1_r1);
        setRotationAngle(body1_r1, -0.192F, 0.0F, 0.0F);
        body1_r1.cubeList.add(new ModelBox(body1_r1, 0, 46, -4.5F, -2.0F, 0.0F, 9, 8, 10, 0.0F, false));

        neck = new ModelRenderer(this);
        neck.setRotationPoint(0.0F, -1.25F, -10.25F);
        torso.addChild(neck);


        neck_r1 = new ModelRenderer(this);
        neck_r1.setRotationPoint(0.0F, -0.3682F, 0.3252F);
        neck.addChild(neck_r1);
        setRotationAngle(neck_r1, 0.3752F, 0.0F, 0.0F);
        neck_r1.cubeList.add(new ModelBox(neck_r1, 22, 86, -2.0F, -3.0F, -3.0F, 4, 6, 6, 0.0F, false));

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


        head = new ModelRenderer(this);
        head.setRotationPoint(-0.2168F, 0.6952F, -0.6068F);
        bone3.addChild(head);
        setRotationAngle(head, 0.9599F, 0.0F, 0.0F);


        head6_r1 = new ModelRenderer(this);
        head6_r1.setRotationPoint(0.7168F, 0.2677F, 0.853F);
        head.addChild(head6_r1);
        setRotationAngle(head6_r1, 0.384F, 0.0F, 0.0F);
        head6_r1.cubeList.add(new ModelBox(head6_r1, 166, 44, -1.5F, -1.5F, -3.5F, 2, 2, 5, 0.0F, false));

        head4_r1 = new ModelRenderer(this);
        head4_r1.setRotationPoint(0.2168F, 0.2677F, -2.147F);
        head.addChild(head4_r1);
        setRotationAngle(head4_r1, -0.0524F, 0.0F, 0.0F);
        head4_r1.cubeList.add(new ModelBox(head4_r1, 52, 20, -1.5F, -0.157F, -2.5041F, 3, 1, 5, 0.0F, false));

        head6_r2 = new ModelRenderer(this);
        head6_r2.setRotationPoint(0.2268F, -6.8317F, 11.4107F);
        head.addChild(head6_r2);
        setRotationAngle(head6_r2, -1.6057F, 0.0F, 0.0F);
        head6_r2.cubeList.add(new ModelBox(head6_r2, 28, 13, -2.5F, -3.0F, -2.5F, 5, 6, 5, 0.0F, false));

        head2_r1 = new ModelRenderer(this);
        head2_r1.setRotationPoint(0.2168F, -0.2331F, 0.8046F);
        head.addChild(head2_r1);
        setRotationAngle(head2_r1, -0.1222F, 0.0F, 0.0F);
        head2_r1.cubeList.add(new ModelBox(head2_r1, 53, 0, -0.49F, -1.9627F, -5.6093F, 3, 3, 5, 0.0F, false));

        head2_r2 = new ModelRenderer(this);
        head2_r2.setRotationPoint(0.2268F, -6.6211F, -6.5585F);
        head.addChild(head2_r2);
        setRotationAngle(head2_r2, -0.7156F, 0.0F, 0.0F);
        head2_r2.cubeList.add(new ModelBox(head2_r2, 1, 8, -2.51F, -1.5F, 4.0F, 5, 3, 4, 0.0F, false));

        head2_r3 = new ModelRenderer(this);
        head2_r3.setRotationPoint(0.2268F, -3.9851F, -3.0242F);
        head.addChild(head2_r3);
        setRotationAngle(head2_r3, -1.3265F, 0.0F, 0.0F);
        head2_r3.cubeList.add(new ModelBox(head2_r3, 28, 13, -2.51F, -12.5F, -2.5F, 5, 7, 5, 0.0F, false));

        head1_r1 = new ModelRenderer(this);
        head1_r1.setRotationPoint(0.2268F, -2.571F, -0.988F);
        head.addChild(head1_r1);
        setRotationAngle(head1_r1, -1.021F, 0.0F, 0.0F);
        head1_r1.cubeList.add(new ModelBox(head1_r1, 0, 2, -2.52F, -5.0F, -3.0F, 5, 5, 5, 0.0F, false));

        head6_r3 = new ModelRenderer(this);
        head6_r3.setRotationPoint(0.2168F, -5.2331F, 0.8046F);
        head.addChild(head6_r3);
        setRotationAngle(head6_r3, -0.1222F, 0.0F, 0.0F);
        head6_r3.cubeList.add(new ModelBox(head6_r3, 34, 0, -2.501F, 3.0F, -5.0009F, 3, 3, 5, 0.0F, false));

        lowerjaw = new ModelRenderer(this);
        lowerjaw.setRotationPoint(0.2168F, 1.4275F, 0.5228F);
        head.addChild(lowerjaw);
        setRotationAngle(lowerjaw, -0.3935F, 0.0109F, -0.0044F);


        head8_r1 = new ModelRenderer(this);
        head8_r1.setRotationPoint(-0.0182F, 0.5705F, -0.5834F);
        lowerjaw.addChild(head8_r1);
        setRotationAngle(head8_r1, 0.3578F, -0.0175F, 0.0F);
        head8_r1.cubeList.add(new ModelBox(head8_r1, 145, 34, -1.5F, -0.5897F, -4.4734F, 3, 1, 5, 0.0F, false));

        upperbody = new ModelRenderer(this);
        upperbody.setRotationPoint(0.0F, -0.25F, 0.75F);
        torso.addChild(upperbody);


        back2_r1 = new ModelRenderer(this);
        back2_r1.setRotationPoint(0.0F, -3.5F, -5.0F);
        upperbody.addChild(back2_r1);
        setRotationAngle(back2_r1, -0.192F, 0.0F, 0.0F);
        back2_r1.cubeList.add(new ModelBox(back2_r1, 58, 93, 0.0F, -5.546F, -4.9081F, 0, 6, 10, 0.0F, false));

        back1_r1 = new ModelRenderer(this);
        back1_r1.setRotationPoint(-0.01F, -7.6945F, -10.4239F);
        upperbody.addChild(back1_r1);
        setRotationAngle(back1_r1, 0.5061F, 0.0F, 0.0F);
        back1_r1.cubeList.add(new ModelBox(back1_r1, 1, 67, 0.0F, -3.5F, -3.0F, 0, 7, 9, 0.0F, false));

        ub3ddetails2 = new ModelRenderer(this);
        ub3ddetails2.setRotationPoint(0.0313F, -3.5F, -8.0F);
        upperbody.addChild(ub3ddetails2);
        setRotationAngle(ub3ddetails2, 0.0F, 0.0873F, 0.0F);


        backhorn10_r1 = new ModelRenderer(this);
        backhorn10_r1.setRotationPoint(-3.6842F, -0.4298F, 0.4874F);
        ub3ddetails2.addChild(backhorn10_r1);
        setRotationAngle(backhorn10_r1, -1.6733F, 0.229F, -0.1558F);
        backhorn10_r1.cubeList.add(new ModelBox(backhorn10_r1, 59, 67, -0.99F, -2.0F, -2.0F, 2, 4, 4, 0.0F, true));

        backhorn9_r1 = new ModelRenderer(this);
        backhorn9_r1.setRotationPoint(-4.7645F, 7.6555F, -9.4732F);
        ub3ddetails2.addChild(backhorn9_r1);
        setRotationAngle(backhorn9_r1, -0.9316F, 0.229F, -0.1558F);
        backhorn9_r1.cubeList.add(new ModelBox(backhorn9_r1, 59, 67, -1.0F, -12.75F, -3.0F, 2, 4, 4, 0.0F, true));

        backhorn9_r2 = new ModelRenderer(this);
        backhorn9_r2.setRotationPoint(-3.896F, 2.4582F, -2.333F);
        ub3ddetails2.addChild(backhorn9_r2);
        setRotationAngle(backhorn9_r2, -0.0589F, 0.229F, -0.1558F);
        backhorn9_r2.cubeList.add(new ModelBox(backhorn9_r2, 59, 67, -1.01F, -2.5F, -2.25F, 2, 5, 4, 0.0F, true));

        backhorn9_r3 = new ModelRenderer(this);
        backhorn9_r3.setRotationPoint(-4.0486F, 3.5806F, -3.7268F);
        ub3ddetails2.addChild(backhorn9_r3);
        setRotationAngle(backhorn9_r3, 1.4683F, 0.229F, -0.1558F);
        backhorn9_r3.cubeList.add(new ModelBox(backhorn9_r3, 59, 67, -1.0F, 1.0F, -3.75F, 2, 4, 4, 0.0F, true));

        backhorn8_r1 = new ModelRenderer(this);
        backhorn8_r1.setRotationPoint(-3.1555F, 4.4675F, -0.5328F);
        ub3ddetails2.addChild(backhorn8_r1);
        setRotationAngle(backhorn8_r1, 0.552F, 0.229F, -0.1558F);
        backhorn8_r1.cubeList.add(new ModelBox(backhorn8_r1, 59, 67, -1.02F, -2.0F, -3.75F, 2, 3, 4, 0.0F, true));

        bone4 = new ModelRenderer(this);
        bone4.setRotationPoint(-1.75F, 0.0F, 0.5F);
        ub3ddetails2.addChild(bone4);
        setRotationAngle(bone4, 0.0F, 0.0F, 0.1309F);


        backhorn8_r2 = new ModelRenderer(this);
        backhorn8_r2.setRotationPoint(4.4929F, -1.9151F, -2.5908F);
        bone4.addChild(backhorn8_r2);
        setRotationAngle(backhorn8_r2, -0.1949F, -0.1713F, 0.2082F);
        backhorn8_r2.cubeList.add(new ModelBox(backhorn8_r2, 9, 86, -1.0909F, -13.2448F, -0.5978F, 2, 5, 2, 0.0F, true));

        backhorn7_r1 = new ModelRenderer(this);
        backhorn7_r1.setRotationPoint(4.0F, -1.75F, 0.0F);
        bone4.addChild(backhorn7_r1);
        setRotationAngle(backhorn7_r1, -0.1949F, -0.1713F, 0.2082F);
        backhorn7_r1.cubeList.add(new ModelBox(backhorn7_r1, 9, 87, -1.0909F, -5.2448F, -0.5978F, 2, 6, 2, 0.0F, true));

        backhorn8_r3 = new ModelRenderer(this);
        backhorn8_r3.setRotationPoint(3.0708F, -0.5718F, 3.8477F);
        bone4.addChild(backhorn8_r3);
        setRotationAngle(backhorn8_r3, 0.4596F, -0.1713F, 0.2082F);
        backhorn8_r3.cubeList.add(new ModelBox(backhorn8_r3, 9, 87, -1.0905F, -11.2448F, -0.5978F, 2, 5, 2, 0.0F, true));

        lowerdorsaltube2 = new ModelRenderer(this);
        lowerdorsaltube2.setRotationPoint(0.0F, 1.25F, -0.5F);
        ub3ddetails2.addChild(lowerdorsaltube2);
        setRotationAngle(lowerdorsaltube2, 0.0F, -0.2182F, 0.0873F);


        backhorn10_r2 = new ModelRenderer(this);
        backhorn10_r2.setRotationPoint(1.7014F, 2.1329F, 4.5566F);
        lowerdorsaltube2.addChild(backhorn10_r2);
        setRotationAngle(backhorn10_r2, -0.1222F, 0.0F, 0.1745F);
        backhorn10_r2.cubeList.add(new ModelBox(backhorn10_r2, 9, 87, -1.0451F, -11.3532F, -1.0723F, 2, 4, 2, 0.0F, true));

        backhorn10_r3 = new ModelRenderer(this);
        backhorn10_r3.setRotationPoint(1.9103F, 0.9482F, -0.231F);
        lowerdorsaltube2.addChild(backhorn10_r3);
        setRotationAngle(backhorn10_r3, -0.5585F, 0.0F, 0.1745F);
        backhorn10_r3.cubeList.add(new ModelBox(backhorn10_r3, 9, 86, -1.046F, -15.3532F, -1.0723F, 2, 4, 2, 0.0F, true));

        backhorn9_r4 = new ModelRenderer(this);
        backhorn9_r4.setRotationPoint(2.0F, -1.0F, 2.75F);
        lowerdorsaltube2.addChild(backhorn9_r4);
        setRotationAngle(backhorn9_r4, -0.5585F, 0.0F, 0.1745F);
        backhorn9_r4.cubeList.add(new ModelBox(backhorn9_r4, 9, 87, -0.796F, -5.3532F, -1.0723F, 2, 5, 2, 0.0F, true));

        ub3ddetails3 = new ModelRenderer(this);
        ub3ddetails3.setRotationPoint(0.0F, -3.5F, -8.0F);
        upperbody.addChild(ub3ddetails3);
        setRotationAngle(ub3ddetails3, 0.0F, -0.0873F, 0.0F);


        backhorn11_r1 = new ModelRenderer(this);
        backhorn11_r1.setRotationPoint(3.6842F, -0.4298F, 0.4874F);
        ub3ddetails3.addChild(backhorn11_r1);
        setRotationAngle(backhorn11_r1, -1.6733F, -0.229F, 0.1558F);
        backhorn11_r1.cubeList.add(new ModelBox(backhorn11_r1, 59, 67, -1.01F, -2.0F, -2.0F, 2, 4, 4, 0.0F, false));

        backhorn10_r4 = new ModelRenderer(this);
        backhorn10_r4.setRotationPoint(4.7645F, 7.6555F, -9.4732F);
        ub3ddetails3.addChild(backhorn10_r4);
        setRotationAngle(backhorn10_r4, -0.9316F, -0.229F, 0.1558F);
        backhorn10_r4.cubeList.add(new ModelBox(backhorn10_r4, 59, 67, -1.0F, -12.75F, -3.0F, 2, 4, 4, 0.0F, false));

        backhorn10_r5 = new ModelRenderer(this);
        backhorn10_r5.setRotationPoint(3.896F, 2.4582F, -2.333F);
        ub3ddetails3.addChild(backhorn10_r5);
        setRotationAngle(backhorn10_r5, -0.0589F, -0.229F, 0.1558F);
        backhorn10_r5.cubeList.add(new ModelBox(backhorn10_r5, 59, 67, -0.99F, -2.5F, -2.25F, 2, 5, 4, 0.0F, false));

        backhorn10_r6 = new ModelRenderer(this);
        backhorn10_r6.setRotationPoint(4.0486F, 3.5806F, -3.7268F);
        ub3ddetails3.addChild(backhorn10_r6);
        setRotationAngle(backhorn10_r6, 1.4683F, -0.229F, 0.1558F);
        backhorn10_r6.cubeList.add(new ModelBox(backhorn10_r6, 59, 67, -1.0F, 1.0F, -3.75F, 2, 4, 4, 0.0F, false));

        backhorn9_r5 = new ModelRenderer(this);
        backhorn9_r5.setRotationPoint(3.1555F, 4.4675F, -0.5328F);
        ub3ddetails3.addChild(backhorn9_r5);
        setRotationAngle(backhorn9_r5, 0.552F, -0.229F, 0.1558F);
        backhorn9_r5.cubeList.add(new ModelBox(backhorn9_r5, 59, 67, -0.98F, -2.0F, -3.75F, 2, 3, 4, 0.0F, false));

        bone13 = new ModelRenderer(this);
        bone13.setRotationPoint(1.75F, 0.0F, 0.5F);
        ub3ddetails3.addChild(bone13);
        setRotationAngle(bone13, 0.0F, 0.0F, -0.1309F);


        backhorn9_r6 = new ModelRenderer(this);
        backhorn9_r6.setRotationPoint(-4.4929F, -1.9151F, -2.5908F);
        bone13.addChild(backhorn9_r6);
        setRotationAngle(backhorn9_r6, -0.1949F, 0.1713F, -0.2082F);
        backhorn9_r6.cubeList.add(new ModelBox(backhorn9_r6, 9, 86, -0.9091F, -13.2448F, -0.5978F, 2, 5, 2, 0.0F, false));

        backhorn8_r4 = new ModelRenderer(this);
        backhorn8_r4.setRotationPoint(-4.0F, -1.75F, 0.0F);
        bone13.addChild(backhorn8_r4);
        setRotationAngle(backhorn8_r4, -0.1949F, 0.1713F, -0.2082F);
        backhorn8_r4.cubeList.add(new ModelBox(backhorn8_r4, 9, 87, -0.9091F, -5.2448F, -0.5978F, 2, 6, 2, 0.0F, false));

        backhorn9_r7 = new ModelRenderer(this);
        backhorn9_r7.setRotationPoint(-3.0708F, -0.5718F, 3.8477F);
        bone13.addChild(backhorn9_r7);
        setRotationAngle(backhorn9_r7, 0.4596F, 0.1713F, -0.2082F);
        backhorn9_r7.cubeList.add(new ModelBox(backhorn9_r7, 9, 87, -0.9095F, -11.2448F, -0.5978F, 2, 5, 2, 0.0F, false));

        lowerdorsaltube3 = new ModelRenderer(this);
        lowerdorsaltube3.setRotationPoint(0.0F, 1.25F, -0.5F);
        ub3ddetails3.addChild(lowerdorsaltube3);
        setRotationAngle(lowerdorsaltube3, 0.0F, 0.2182F, -0.0873F);


        backhorn11_r2 = new ModelRenderer(this);
        backhorn11_r2.setRotationPoint(-1.7014F, 2.1329F, 4.5566F);
        lowerdorsaltube3.addChild(backhorn11_r2);
        setRotationAngle(backhorn11_r2, -0.1222F, 0.0F, -0.1745F);
        backhorn11_r2.cubeList.add(new ModelBox(backhorn11_r2, 9, 87, -0.9549F, -11.3532F, -1.0723F, 2, 4, 2, 0.0F, false));

        backhorn11_r3 = new ModelRenderer(this);
        backhorn11_r3.setRotationPoint(-1.9103F, 0.9482F, -0.231F);
        lowerdorsaltube3.addChild(backhorn11_r3);
        setRotationAngle(backhorn11_r3, -0.5585F, 0.0F, -0.1745F);
        backhorn11_r3.cubeList.add(new ModelBox(backhorn11_r3, 9, 86, -0.954F, -15.3532F, -1.0723F, 2, 4, 2, 0.0F, false));

        backhorn10_r7 = new ModelRenderer(this);
        backhorn10_r7.setRotationPoint(-2.0F, -1.0F, 2.75F);
        lowerdorsaltube3.addChild(backhorn10_r7);
        setRotationAngle(backhorn10_r7, -0.5585F, 0.0F, -0.1745F);
        backhorn10_r7.cubeList.add(new ModelBox(backhorn10_r7, 9, 87, -1.204F, -5.3532F, -1.0723F, 2, 5, 2, 0.0F, false));

        rarm3 = new ModelRenderer(this);
        rarm3.setRotationPoint(-4.4687F, -1.0F, -8.0F);
        upperbody.addChild(rarm3);
        setRotationAngle(rarm3, 0.9536F, 0.0803F, -0.2535F);


        leftarm8_r1 = new ModelRenderer(this);
        leftarm8_r1.setRotationPoint(-2.5882F, 4.3865F, 2.4722F);
        rarm3.addChild(leftarm8_r1);
        setRotationAngle(leftarm8_r1, 1.3475F, -1.1945F, -0.7379F);
        leftarm8_r1.cubeList.add(new ModelBox(leftarm8_r1, 50, 29, -1.0F, -6.5F, -1.25F, 2, 13, 2, 0.0F, true));

        leftarm7_r1 = new ModelRenderer(this);
        leftarm7_r1.setRotationPoint(-0.0882F, 0.6365F, -0.2778F);
        rarm3.addChild(leftarm7_r1);
        setRotationAngle(leftarm7_r1, 1.3475F, -1.1945F, -0.7379F);
        leftarm7_r1.cubeList.add(new ModelBox(leftarm7_r1, 50, 29, -1.0493F, -1.307F, -0.9413F, 2, 13, 2, 0.0F, true));

        forearm2 = new ModelRenderer(this);
        forearm2.setRotationPoint(-5.5334F, 8.7378F, 4.5177F);
        rarm3.addChild(forearm2);
        setRotationAngle(forearm2, 0.0077F, 0.233F, 0.0265F);


        leftarm8_r2 = new ModelRenderer(this);
        leftarm8_r2.setRotationPoint(5.6925F, -8.449F, -5.1238F);
        forearm2.addChild(leftarm8_r2);
        setRotationAngle(leftarm8_r2, 0.3665F, 0.0F, 0.5934F);
        leftarm8_r2.cubeList.add(new ModelBox(leftarm8_r2, 71, 9, -1.0F, 10.5F, -10.5F, 2, 2, 11, 0.0F, true));

        backhorn10_r8 = new ModelRenderer(this);
        backhorn10_r8.setRotationPoint(0.0521F, -0.0535F, -0.3697F);
        forearm2.addChild(backhorn10_r8);
        setRotationAngle(backhorn10_r8, -1.4008F, -0.0474F, 0.7092F);
        backhorn10_r8.cubeList.add(new ModelBox(backhorn10_r8, 11, 86, -0.4038F, -4.6834F, 0.5525F, 1, 10, 1, 0.0F, true));

        wrist2 = new ModelRenderer(this);
        wrist2.setRotationPoint(-2.7159F, 3.5169F, -10.9556F);
        forearm2.addChild(wrist2);
        setRotationAngle(wrist2, -0.1325F, 0.276F, -1.2402F);


        leftarm7_r2 = new ModelRenderer(this);
        leftarm7_r2.setRotationPoint(8.2259F, -12.1609F, 6.0217F);
        wrist2.addChild(leftarm7_r2);
        setRotationAngle(leftarm7_r2, 0.3665F, 0.0F, 0.5934F);
        leftarm7_r2.cubeList.add(new ModelBox(leftarm7_r2, 83, 24, -1.0F, 11.0F, -13.5F, 2, 1, 3, 0.0F, true));

        indexfinger2 = new ModelRenderer(this);
        indexfinger2.setRotationPoint(-0.1825F, 0.805F, -1.81F);
        wrist2.addChild(indexfinger2);
        setRotationAngle(indexfinger2, 0.0363F, -0.3057F, 0.0156F);


        cube_r1 = new ModelRenderer(this);
        cube_r1.setRotationPoint(1.1431F, -5.2379F, 0.378F);
        indexfinger2.addChild(cube_r1);
        setRotationAngle(cube_r1, 0.7418F, 0.2182F, 0.5236F);
        cube_r1.cubeList.add(new ModelBox(cube_r1, 21, 10, 1.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, true));

        bone16 = new ModelRenderer(this);
        bone16.setRotationPoint(-1.3133F, 1.7489F, -2.6059F);
        indexfinger2.addChild(bone16);


        cube_r2 = new ModelRenderer(this);
        cube_r2.setRotationPoint(-0.3099F, 1.2066F, -0.2272F);
        bone16.addChild(cube_r2);
        setRotationAngle(cube_r2, 1.4835F, 0.2182F, 0.5236F);
        cube_r2.cubeList.add(new ModelBox(cube_r2, 21, 10, -1.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, true));

        bone19 = new ModelRenderer(this);
        bone19.setRotationPoint(-1.4335F, 2.0024F, -0.2967F);
        bone16.addChild(bone19);


        cube_r3 = new ModelRenderer(this);
        cube_r3.setRotationPoint(0.1767F, 0.376F, 1.3234F);
        bone19.addChild(cube_r3);
        setRotationAngle(cube_r3, 2.138F, 0.2182F, 0.5236F);
        cube_r3.cubeList.add(new ModelBox(cube_r3, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        thumb2 = new ModelRenderer(this);
        thumb2.setRotationPoint(0.5838F, 0.8334F, -0.4581F);
        wrist2.addChild(thumb2);
        setRotationAngle(thumb2, -2.5077F, -0.4352F, -2.3956F);


        cube_r4 = new ModelRenderer(this);
        cube_r4.setRotationPoint(0.1268F, -0.0263F, 0.1429F);
        thumb2.addChild(cube_r4);
        setRotationAngle(cube_r4, 0.7418F, 0.2182F, 0.5236F);
        cube_r4.cubeList.add(new ModelBox(cube_r4, 21, 10, -0.3314F, -0.4524F, -2.6072F, 1, 1, 3, 0.0F, true));

        bone20 = new ModelRenderer(this);
        bone20.setRotationPoint(-1.0635F, 1.3507F, -1.6678F);
        thumb2.addChild(bone20);


        cube_r5 = new ModelRenderer(this);
        cube_r5.setRotationPoint(-0.0759F, 0.0665F, -0.1504F);
        bone20.addChild(cube_r5);
        setRotationAngle(cube_r5, 1.4835F, 0.2182F, 0.5236F);
        cube_r5.cubeList.add(new ModelBox(cube_r5, 21, 10, -0.3898F, -0.2709F, -2.5666F, 1, 1, 3, 0.0F, true));

        bone21 = new ModelRenderer(this);
        bone21.setRotationPoint(-1.25F, 2.25F, -0.25F);
        bone20.addChild(bone21);


        cube_r6 = new ModelRenderer(this);
        cube_r6.setRotationPoint(0.2272F, 0.2382F, 1.3536F);
        bone21.addChild(cube_r6);
        setRotationAngle(cube_r6, 2.138F, 0.2182F, 0.5236F);
        cube_r6.cubeList.add(new ModelBox(cube_r6, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        thumbmini3 = new ModelRenderer(this);
        thumbmini3.setRotationPoint(-0.9162F, 0.0834F, -0.4581F);
        wrist2.addChild(thumbmini3);
        setRotationAngle(thumbmini3, -2.3706F, -0.348F, -1.6632F);


        cube_r7 = new ModelRenderer(this);
        cube_r7.setRotationPoint(1.5467F, -5.715F, 1.1794F);
        thumbmini3.addChild(cube_r7);
        setRotationAngle(cube_r7, 0.7418F, 0.2182F, 0.5236F);
        cube_r7.cubeList.add(new ModelBox(cube_r7, 22, 7, 1.3558F, 3.0F, -6.0F, 1, 1, 2, 0.0F, true));

        bone22 = new ModelRenderer(this);
        bone22.setRotationPoint(-0.659F, 0.8024F, -1.1611F);
        thumbmini3.addChild(bone22);


        cube_r8 = new ModelRenderer(this);
        cube_r8.setRotationPoint(-0.0845F, 1.1707F, -0.1508F);
        bone22.addChild(cube_r8);
        setRotationAngle(cube_r8, 1.4835F, 0.2182F, 0.5236F);
        cube_r8.cubeList.add(new ModelBox(cube_r8, 21, 15, -1.0F, -0.5F, -0.5F, 1, 1, 2, 0.0F, true));

        bone23 = new ModelRenderer(this);
        bone23.setRotationPoint(-0.8691F, 1.4373F, -0.0546F);
        bone22.addChild(bone23);


        cube_r9 = new ModelRenderer(this);
        cube_r9.setRotationPoint(0.3522F, 0.0518F, 1.2429F);
        bone23.addChild(cube_r9);
        setRotationAngle(cube_r9, 2.138F, 0.2182F, 0.5236F);
        cube_r9.cubeList.add(new ModelBox(cube_r9, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        finger3 = new ModelRenderer(this);
        finger3.setRotationPoint(-0.8154F, 0.3836F, -2.3413F);
        wrist2.addChild(finger3);
        setRotationAngle(finger3, -0.1387F, 0.1105F, 0.1508F);


        cube_r10 = new ModelRenderer(this);
        cube_r10.setRotationPoint(1.2371F, -5.319F, 1.1065F);
        finger3.addChild(cube_r10);
        setRotationAngle(cube_r10, 0.7418F, 0.2182F, 0.5236F);
        cube_r10.cubeList.add(new ModelBox(cube_r10, 21, 10, 1.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, true));

        bone24 = new ModelRenderer(this);
        bone24.setRotationPoint(-1.4417F, 1.5973F, -2.1087F);
        finger3.addChild(bone24);


        cube_r11 = new ModelRenderer(this);
        cube_r11.setRotationPoint(-0.0875F, 1.2771F, 0.004F);
        bone24.addChild(cube_r11);
        setRotationAngle(cube_r11, 1.4835F, 0.2182F, 0.5236F);
        cube_r11.cubeList.add(new ModelBox(cube_r11, 21, 10, -1.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, true));

        bone25 = new ModelRenderer(this);
        bone25.setRotationPoint(-1.211F, 2.3229F, -0.0654F);
        bone24.addChild(bone25);


        cube_r12 = new ModelRenderer(this);
        cube_r12.setRotationPoint(0.1767F, 0.126F, 1.3234F);
        bone25.addChild(cube_r12);
        setRotationAngle(cube_r12, 2.138F, 0.2182F, 0.5236F);
        cube_r12.cubeList.add(new ModelBox(cube_r12, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, true));

        rarm2 = new ModelRenderer(this);
        rarm2.setRotationPoint(4.5F, -1.0F, -8.0F);
        upperbody.addChild(rarm2);
        setRotationAngle(rarm2, 0.9536F, -0.0803F, 0.2535F);


        leftarm9_r1 = new ModelRenderer(this);
        leftarm9_r1.setRotationPoint(2.5882F, 4.3865F, 2.4722F);
        rarm2.addChild(leftarm9_r1);
        setRotationAngle(leftarm9_r1, 1.3475F, 1.1945F, 0.7379F);
        leftarm9_r1.cubeList.add(new ModelBox(leftarm9_r1, 50, 29, -1.0F, -6.5F, -1.25F, 2, 13, 2, 0.0F, false));

        leftarm8_r3 = new ModelRenderer(this);
        leftarm8_r3.setRotationPoint(0.0882F, 0.6365F, -0.2778F);
        rarm2.addChild(leftarm8_r3);
        setRotationAngle(leftarm8_r3, 1.3475F, 1.1945F, 0.7379F);
        leftarm8_r3.cubeList.add(new ModelBox(leftarm8_r3, 50, 29, -0.9507F, -1.307F, -0.9413F, 2, 13, 2, 0.0F, false));

        forearm3 = new ModelRenderer(this);
        forearm3.setRotationPoint(5.5334F, 8.7378F, 4.5177F);
        rarm2.addChild(forearm3);
        setRotationAngle(forearm3, 0.0077F, -0.233F, -0.0265F);


        leftarm9_r2 = new ModelRenderer(this);
        leftarm9_r2.setRotationPoint(-5.6925F, -8.449F, -5.1238F);
        forearm3.addChild(leftarm9_r2);
        setRotationAngle(leftarm9_r2, 0.3665F, 0.0F, -0.5934F);
        leftarm9_r2.cubeList.add(new ModelBox(leftarm9_r2, 71, 9, -1.0F, 10.5F, -10.5F, 2, 2, 11, 0.0F, false));

        backhorn11_r4 = new ModelRenderer(this);
        backhorn11_r4.setRotationPoint(-0.0521F, -0.0535F, -0.3697F);
        forearm3.addChild(backhorn11_r4);
        setRotationAngle(backhorn11_r4, -1.4008F, 0.0474F, -0.7092F);
        backhorn11_r4.cubeList.add(new ModelBox(backhorn11_r4, 11, 86, -0.5962F, -4.6834F, 0.5525F, 1, 10, 1, 0.0F, false));

        wrist3 = new ModelRenderer(this);
        wrist3.setRotationPoint(2.7159F, 3.5169F, -10.9556F);
        forearm3.addChild(wrist3);
        setRotationAngle(wrist3, -0.1325F, -0.276F, 1.2402F);


        leftarm8_r4 = new ModelRenderer(this);
        leftarm8_r4.setRotationPoint(-8.2259F, -12.1609F, 6.0217F);
        wrist3.addChild(leftarm8_r4);
        setRotationAngle(leftarm8_r4, 0.3665F, 0.0F, -0.5934F);
        leftarm8_r4.cubeList.add(new ModelBox(leftarm8_r4, 83, 24, -1.0F, 11.0F, -13.5F, 2, 1, 3, 0.0F, false));

        indexfinger3 = new ModelRenderer(this);
        indexfinger3.setRotationPoint(0.1825F, 0.805F, -1.81F);
        wrist3.addChild(indexfinger3);
        setRotationAngle(indexfinger3, 0.0363F, 0.3057F, -0.0156F);


        cube_r13 = new ModelRenderer(this);
        cube_r13.setRotationPoint(-1.1431F, -5.2379F, 0.378F);
        indexfinger3.addChild(cube_r13);
        setRotationAngle(cube_r13, 0.7418F, -0.2182F, -0.5236F);
        cube_r13.cubeList.add(new ModelBox(cube_r13, 21, 10, -2.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, false));

        bone14 = new ModelRenderer(this);
        bone14.setRotationPoint(1.3133F, 1.7489F, -2.6059F);
        indexfinger3.addChild(bone14);


        cube_r14 = new ModelRenderer(this);
        cube_r14.setRotationPoint(0.3099F, 1.2066F, -0.2272F);
        bone14.addChild(cube_r14);
        setRotationAngle(cube_r14, 1.4835F, -0.2182F, -0.5236F);
        cube_r14.cubeList.add(new ModelBox(cube_r14, 21, 10, 0.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, false));

        bone15 = new ModelRenderer(this);
        bone15.setRotationPoint(1.4335F, 2.0024F, -0.2967F);
        bone14.addChild(bone15);


        cube_r15 = new ModelRenderer(this);
        cube_r15.setRotationPoint(-0.1767F, 0.376F, 1.3234F);
        bone15.addChild(cube_r15);
        setRotationAngle(cube_r15, 2.138F, -0.2182F, -0.5236F);
        cube_r15.cubeList.add(new ModelBox(cube_r15, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        thumb3 = new ModelRenderer(this);
        thumb3.setRotationPoint(-0.5838F, 0.8334F, -0.4581F);
        wrist3.addChild(thumb3);
        setRotationAngle(thumb3, -2.5077F, 0.4352F, 2.3956F);


        cube_r16 = new ModelRenderer(this);
        cube_r16.setRotationPoint(-0.1268F, -0.0263F, 0.1429F);
        thumb3.addChild(cube_r16);
        setRotationAngle(cube_r16, 0.7418F, -0.2182F, -0.5236F);
        cube_r16.cubeList.add(new ModelBox(cube_r16, 21, 10, -0.6686F, -0.4524F, -2.6072F, 1, 1, 3, 0.0F, false));

        bone17 = new ModelRenderer(this);
        bone17.setRotationPoint(1.0635F, 1.3507F, -1.6678F);
        thumb3.addChild(bone17);


        cube_r17 = new ModelRenderer(this);
        cube_r17.setRotationPoint(0.0759F, 0.0665F, -0.1504F);
        bone17.addChild(cube_r17);
        setRotationAngle(cube_r17, 1.4835F, -0.2182F, -0.5236F);
        cube_r17.cubeList.add(new ModelBox(cube_r17, 21, 10, -0.6102F, -0.2709F, -2.5666F, 1, 1, 3, 0.0F, false));

        bone18 = new ModelRenderer(this);
        bone18.setRotationPoint(1.25F, 2.25F, -0.25F);
        bone17.addChild(bone18);


        cube_r18 = new ModelRenderer(this);
        cube_r18.setRotationPoint(-0.2272F, 0.2382F, 1.3536F);
        bone18.addChild(cube_r18);
        setRotationAngle(cube_r18, 2.138F, -0.2182F, -0.5236F);
        cube_r18.cubeList.add(new ModelBox(cube_r18, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        thumbmini2 = new ModelRenderer(this);
        thumbmini2.setRotationPoint(0.9162F, 0.0834F, -0.4581F);
        wrist3.addChild(thumbmini2);
        setRotationAngle(thumbmini2, -2.3706F, 0.348F, 1.6632F);


        cube_r19 = new ModelRenderer(this);
        cube_r19.setRotationPoint(-1.5467F, -5.715F, 1.1794F);
        thumbmini2.addChild(cube_r19);
        setRotationAngle(cube_r19, 0.7418F, -0.2182F, -0.5236F);
        cube_r19.cubeList.add(new ModelBox(cube_r19, 22, 7, -2.3558F, 3.0F, -6.0F, 1, 1, 2, 0.0F, false));

        bone26 = new ModelRenderer(this);
        bone26.setRotationPoint(0.659F, 0.8024F, -1.1611F);
        thumbmini2.addChild(bone26);


        cube_r20 = new ModelRenderer(this);
        cube_r20.setRotationPoint(0.0845F, 1.1707F, -0.1508F);
        bone26.addChild(cube_r20);
        setRotationAngle(cube_r20, 1.4835F, -0.2182F, -0.5236F);
        cube_r20.cubeList.add(new ModelBox(cube_r20, 21, 15, 0.0F, -0.5F, -0.5F, 1, 1, 2, 0.0F, false));

        bone27 = new ModelRenderer(this);
        bone27.setRotationPoint(0.8691F, 1.4373F, -0.0546F);
        bone26.addChild(bone27);


        cube_r21 = new ModelRenderer(this);
        cube_r21.setRotationPoint(-0.3522F, 0.0518F, 1.2429F);
        bone27.addChild(cube_r21);
        setRotationAngle(cube_r21, 2.138F, -0.2182F, -0.5236F);
        cube_r21.cubeList.add(new ModelBox(cube_r21, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        finger2 = new ModelRenderer(this);
        finger2.setRotationPoint(0.8154F, 0.3836F, -2.3413F);
        wrist3.addChild(finger2);
        setRotationAngle(finger2, -0.1387F, -0.1105F, -0.1508F);


        cube_r22 = new ModelRenderer(this);
        cube_r22.setRotationPoint(-1.2371F, -5.319F, 1.1065F);
        finger2.addChild(cube_r22);
        setRotationAngle(cube_r22, 0.7418F, -0.2182F, -0.5236F);
        cube_r22.cubeList.add(new ModelBox(cube_r22, 21, 10, -2.3558F, 3.0F, -7.0F, 1, 1, 3, 0.0F, false));

        bone28 = new ModelRenderer(this);
        bone28.setRotationPoint(1.4417F, 1.5973F, -2.1087F);
        finger2.addChild(bone28);


        cube_r23 = new ModelRenderer(this);
        cube_r23.setRotationPoint(0.0875F, 1.2771F, 0.004F);
        bone28.addChild(cube_r23);
        setRotationAngle(cube_r23, 1.4835F, -0.2182F, -0.5236F);
        cube_r23.cubeList.add(new ModelBox(cube_r23, 21, 10, 0.0F, -0.5F, -1.5F, 1, 1, 3, 0.0F, false));

        bone29 = new ModelRenderer(this);
        bone29.setRotationPoint(1.211F, 2.3229F, -0.0654F);
        bone28.addChild(bone29);


        cube_r24 = new ModelRenderer(this);
        cube_r24.setRotationPoint(-0.1767F, 0.126F, 1.3234F);
        bone29.addChild(cube_r24);
        setRotationAngle(cube_r24, 2.138F, -0.2182F, -0.5236F);
        cube_r24.cubeList.add(new ModelBox(cube_r24, 18, 1, -0.5F, -1.5F, -1.0F, 1, 1, 2, 0.0F, false));

        lowertorso = new ModelRenderer(this);
        lowertorso.setRotationPoint(0.0F, -0.25F, -0.25F);
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
        back2_r2.cubeList.add(new ModelBox(back2_r2, 56, 92, 0.0F, -8.0F, 8.0F, 0, 4, 12, 0.0F, false));

        tail = new ModelRenderer(this);
        tail.setRotationPoint(-0.1458F, 2.8648F, 7.9612F);
        lowertorso.addChild(tail);
        setRotationAngle(tail, 0.3797F, 0.6194F, 0.2268F);


        tail1_r1 = new ModelRenderer(this);
        tail1_r1.setRotationPoint(-0.667F, 0.8963F, -0.5648F);
        tail.addChild(tail1_r1);
        setRotationAngle(tail1_r1, -0.4014F, -0.6667F, 0.0F);
        tail1_r1.cubeList.add(new ModelBox(tail1_r1, 50, 66, -1.0005F, -2.5123F, 0.029F, 4, 4, 11, 0.0F, false));

        back3_r1 = new ModelRenderer(this);
        back3_r1.setRotationPoint(-1.8607F, 1.865F, 1.9298F);
        tail.addChild(back3_r1);
        setRotationAngle(back3_r1, -0.462F, -0.634F, 0.0197F);
        back3_r1.cubeList.add(new ModelBox(back3_r1, 55, 92, 0.2486F, -5.4376F, -2.4172F, 0, 4, 12, 0.0F, false));

        bone6 = new ModelRenderer(this);
        bone6.setRotationPoint(-6.7195F, 5.5069F, 8.656F);
        tail.addChild(bone6);
        setRotationAngle(bone6, -0.2894F, -0.4078F, -0.1123F);


        tailSpikes2_r1 = new ModelRenderer(this);
        tailSpikes2_r1.setRotationPoint(-1.7038F, 1.0847F, 3.2939F);
        bone6.addChild(tailSpikes2_r1);
        setRotationAngle(tailSpikes2_r1, -0.3179F, -0.2915F, 0.0141F);
        tailSpikes2_r1.cubeList.add(new ModelBox(tailSpikes2_r1, 147, 95, 0.7498F, -3.5171F, -4.2409F, 0, 4, 11, 0.0F, false));

        tail2_r1 = new ModelRenderer(this);
        tail2_r1.setRotationPoint(-0.5458F, -1.0839F, -1.4867F);
        bone6.addChild(tail2_r1);
        setRotationAngle(tail2_r1, -0.3179F, -0.2915F, 0.0141F);
        tail2_r1.cubeList.add(new ModelBox(tail2_r1, 85, 66, -1.0002F, -1.5171F, 0.0091F, 4, 4, 11, 0.0F, false));

        bone7 = new ModelRenderer(this);
        bone7.setRotationPoint(-2.4541F, 2.8062F, 8.9563F);
        bone6.addChild(bone7);
        setRotationAngle(bone7, 0.4367F, 0.9476F, 0.4426F);


        tail3_r1 = new ModelRenderer(this);
        tail3_r1.setRotationPoint(0.5509F, -0.0024F, -1.5027F);
        bone7.addChild(tail3_r1);
        setRotationAngle(tail3_r1, -0.2703F, -1.2848F, 0.0643F);
        tail3_r1.cubeList.add(new ModelBox(tail3_r1, 117, 66, -0.5004F, -1.5226F, 0.0194F, 3, 3, 11, 0.0F, false));

        tailSpikes3_r1 = new ModelRenderer(this);
        tailSpikes3_r1.setRotationPoint(1.1022F, -0.0024F, -1.5027F);
        bone7.addChild(tailSpikes3_r1);
        setRotationAngle(tailSpikes3_r1, -0.2703F, -1.2848F, 0.0643F);
        tailSpikes3_r1.cubeList.add(new ModelBox(tailSpikes3_r1, 91, 93, 0.7496F, -4.7726F, 1.0194F, 0, 4, 10, 0.0F, false));

        bone9 = new ModelRenderer(this);
        bone9.setRotationPoint(-9.3806F, 2.0146F, 2.5993F);
        bone7.addChild(bone9);
        setRotationAngle(bone9, 0.1871F, 0.8763F, 0.6104F);


        tailSpikes4_r1 = new ModelRenderer(this);
        tailSpikes4_r1.setRotationPoint(0.1727F, -0.0935F, 0.9746F);
        bone9.addChild(tailSpikes4_r1);
        setRotationAngle(tailSpikes4_r1, 2.9491F, -0.9413F, -3.0786F);
        tailSpikes4_r1.cubeList.add(new ModelBox(tailSpikes4_r1, 148, 96, -1.0028F, -2.0105F, 0.0745F, 0, 4, 10, 0.0F, false));

        tail4_r1 = new ModelRenderer(this);
        tail4_r1.setRotationPoint(-0.0445F, -0.0935F, 0.9746F);
        bone9.addChild(tail4_r1);
        setRotationAngle(tail4_r1, 2.951F, -0.9414F, -3.0785F);
        tail4_r1.cubeList.add(new ModelBox(tail4_r1, 148, 66, -2.0028F, -1.0105F, 0.0745F, 2, 2, 11, 0.0F, false));

        bone5 = new ModelRenderer(this);
        bone5.setRotationPoint(-8.0516F, 1.1245F, -5.7911F);
        bone9.addChild(bone5);


        tailSpikes5_r1 = new ModelRenderer(this);
        tailSpikes5_r1.setRotationPoint(-3.6607F, -2.8916F, -3.2042F);
        bone5.addChild(tailSpikes5_r1);
        setRotationAngle(tailSpikes5_r1, 3.0917F, -0.9559F, -3.0663F);
        tailSpikes5_r1.cubeList.add(new ModelBox(tailSpikes5_r1, 176, 91, 0.2505F, -3.5217F, -5.4984F, 0, 7, 11, 0.0F, false));

        tail5_r1 = new ModelRenderer(this);
        tail5_r1.setRotationPoint(-3.7874F, 0.6211F, -3.5307F);
        bone5.addChild(tail5_r1);
        setRotationAngle(tail5_r1, 3.0917F, -0.9559F, -3.0663F);
        tail5_r1.cubeList.add(new ModelBox(tail5_r1, 177, 66, 0.07F, -1.0F, -5.5F, 1, 1, 11, 0.0F, false));

        bone8 = new ModelRenderer(this);
        bone8.setRotationPoint(-8.25F, 0.0F, -6.0F);
        bone5.addChild(bone8);
        setRotationAngle(bone8, -0.1248F, 0.0076F, 0.1784F);


        stabber_r1 = new ModelRenderer(this);
        stabber_r1.setRotationPoint(-4.1376F, -0.4596F, -3.0048F);
        bone8.addChild(stabber_r1);
        setRotationAngle(stabber_r1, -2.174F, 0.0033F, 1.5858F);
        stabber_r1.cubeList.add(new ModelBox(stabber_r1, 205, 66, -0.75F, 0.0F, -5.5F, 3, 0, 11, 0.0F, false));

        lleg = new ModelRenderer(this);
        lleg.setRotationPoint(2.5F, 4.0F, 7.0F);
        lowertorso.addChild(lleg);
        setRotationAngle(lleg, 0.9641F, 0.1037F, 0.08F);


        leftleg5_r1 = new ModelRenderer(this);
        leftleg5_r1.setRotationPoint(1.1387F, -0.3439F, 0.1678F);
        lleg.addChild(leftleg5_r1);
        setRotationAngle(leftleg5_r1, -2.3533F, 0.2693F, 0.393F);
        leftleg5_r1.cubeList.add(new ModelBox(leftleg5_r1, 61, 53, -0.807F, -3.2464F, -3.7573F, 1, 6, 5, 0.0F, false));

        leftleg4_r1 = new ModelRenderer(this);
        leftleg4_r1.setRotationPoint(2.1418F, 1.2288F, -1.3794F);
        lleg.addChild(leftleg4_r1);
        setRotationAngle(leftleg4_r1, -0.8952F, -0.3271F, -0.1919F);
        leftleg4_r1.cubeList.add(new ModelBox(leftleg4_r1, 59, 45, -2.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F, false));

        bone30 = new ModelRenderer(this);
        bone30.setRotationPoint(5.3035F, 7.2734F, -8.1555F);
        lleg.addChild(bone30);
        setRotationAngle(bone30, -0.8365F, 0.1765F, -0.0915F);


        leftleg5_r2 = new ModelRenderer(this);
        leftleg5_r2.setRotationPoint(-0.6174F, 1.9864F, 4.5186F);
        bone30.addChild(leftleg5_r2);
        setRotationAngle(leftleg5_r2, -0.4014F, -0.2443F, -0.4189F);
        leftleg5_r2.cubeList.add(new ModelBox(leftleg5_r2, 78, 32, -1.5F, -1.5F, -6.5F, 3, 3, 13, 0.0F, false));

        bone31 = new ModelRenderer(this);
        bone31.setRotationPoint(-0.5838F, 4.8821F, 9.7711F);
        bone30.addChild(bone31);
        setRotationAngle(bone31, 1.0853F, -0.5125F, 0.1355F);


        leftleg7_r1 = new ModelRenderer(this);
        leftleg7_r1.setRotationPoint(0.3053F, 0.2816F, -0.8537F);
        bone31.addChild(leftleg7_r1);
        setRotationAngle(leftleg7_r1, -1.1956F, -0.2443F, -0.4189F);
        leftleg7_r1.cubeList.add(new ModelBox(leftleg7_r1, 0, 86, -0.9594F, -6.9829F, -0.4375F, 2, 8, 2, 0.0F, false));

        leftleg6_r1 = new ModelRenderer(this);
        leftleg6_r1.setRotationPoint(-3.5439F, -10.8928F, -2.7445F);
        bone31.addChild(leftleg6_r1);
        setRotationAngle(leftleg6_r1, -0.8029F, -0.2443F, -0.4189F);
        leftleg6_r1.cubeList.add(new ModelBox(leftleg6_r1, 9, 86, -1.5F, 4.5F, 9.0F, 2, 10, 2, 0.0F, false));

        bone32 = new ModelRenderer(this);
        bone32.setRotationPoint(3.4565F, 4.3097F, -5.6485F);
        bone31.addChild(bone32);
        setRotationAngle(bone32, -0.7142F, 0.0842F, -0.2207F);


        leftleg7_r2 = new ModelRenderer(this);
        leftleg7_r2.setRotationPoint(0.4783F, 0.6323F, -1.3906F);
        bone32.addChild(leftleg7_r2);
        setRotationAngle(leftleg7_r2, 0.1014F, -0.138F, -0.2159F);
        leftleg7_r2.cubeList.add(new ModelBox(leftleg7_r2, 93, 23, -1.75F, -1.25F, -3.5F, 3, 2, 6, 0.0F, false));

        rleg = new ModelRenderer(this);
        rleg.setRotationPoint(-2.4687F, 4.0F, 7.0F);
        lowertorso.addChild(rleg);
        setRotationAngle(rleg, 0.9641F, -0.1037F, -0.08F);


        leftleg6_r2 = new ModelRenderer(this);
        leftleg6_r2.setRotationPoint(-1.1387F, -0.3439F, 0.1678F);
        rleg.addChild(leftleg6_r2);
        setRotationAngle(leftleg6_r2, -2.3533F, -0.2693F, -0.393F);
        leftleg6_r2.cubeList.add(new ModelBox(leftleg6_r2, 61, 53, -0.193F, -3.2464F, -3.7573F, 1, 6, 5, 0.0F, true));

        leftleg5_r3 = new ModelRenderer(this);
        leftleg5_r3.setRotationPoint(-2.1418F, 1.2288F, -1.3794F);
        rleg.addChild(leftleg5_r3);
        setRotationAngle(leftleg5_r3, -0.8952F, 0.3271F, 0.1919F);
        leftleg5_r3.cubeList.add(new ModelBox(leftleg5_r3, 59, 45, -1.5F, -4.0F, -2.5F, 4, 14, 5, 0.0F, true));

        bone10 = new ModelRenderer(this);
        bone10.setRotationPoint(-5.3035F, 7.2734F, -8.1555F);
        rleg.addChild(bone10);
        setRotationAngle(bone10, -0.8365F, -0.1765F, 0.0915F);


        leftleg6_r3 = new ModelRenderer(this);
        leftleg6_r3.setRotationPoint(0.6174F, 1.9864F, 4.5186F);
        bone10.addChild(leftleg6_r3);
        setRotationAngle(leftleg6_r3, -0.4014F, 0.2443F, 0.4189F);
        leftleg6_r3.cubeList.add(new ModelBox(leftleg6_r3, 78, 32, -1.5F, -1.5F, -6.5F, 3, 3, 13, 0.0F, true));

        bone11 = new ModelRenderer(this);
        bone11.setRotationPoint(0.5838F, 4.8821F, 9.7711F);
        bone10.addChild(bone11);
        setRotationAngle(bone11, 1.0853F, 0.5125F, -0.1355F);


        leftleg8_r1 = new ModelRenderer(this);
        leftleg8_r1.setRotationPoint(-0.3053F, 0.2816F, -0.8537F);
        bone11.addChild(leftleg8_r1);
        setRotationAngle(leftleg8_r1, -1.1956F, 0.2443F, 0.4189F);
        leftleg8_r1.cubeList.add(new ModelBox(leftleg8_r1, 0, 86, -1.0406F, -6.9829F, -0.4375F, 2, 8, 2, 0.0F, true));

        leftleg7_r3 = new ModelRenderer(this);
        leftleg7_r3.setRotationPoint(3.5439F, -10.8928F, -2.7445F);
        bone11.addChild(leftleg7_r3);
        setRotationAngle(leftleg7_r3, -0.8029F, 0.2443F, 0.4189F);
        leftleg7_r3.cubeList.add(new ModelBox(leftleg7_r3, 9, 86, -0.5F, 4.5F, 9.0F, 2, 10, 2, 0.0F, true));

        bone12 = new ModelRenderer(this);
        bone12.setRotationPoint(-3.4565F, 4.3097F, -5.6485F);
        bone11.addChild(bone12);
        setRotationAngle(bone12, -0.7142F, -0.0842F, 0.2207F);


        leftleg8_r2 = new ModelRenderer(this);
        leftleg8_r2.setRotationPoint(-0.4783F, 0.6323F, -1.3906F);
        bone12.addChild(leftleg8_r2);
        setRotationAngle(leftleg8_r2, 0.1014F, 0.138F, 0.2159F);
        leftleg8_r2.cubeList.add(new ModelBox(leftleg8_r2, 93, 23, -1.25F, -1.25F, -3.5F, 3, 2, 6, 0.0F, true));
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
