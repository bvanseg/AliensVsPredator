package org.alien.client.model.entity.living;

import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;
import org.alien.common.entity.living.xenomorph.EntityPredalien;


public class ModelPredalien extends Model<EntityPredalien>
{
    public ModelRenderer RightThigh;
    public ModelRenderer leftThigh;
    public ModelRenderer leftLowerSpike;
    public ModelRenderer rightLowerSpike;
    public ModelRenderer rightTopSpike;
    public ModelRenderer tailBase;
    public ModelRenderer leftShoulder;
    public ModelRenderer topTorso;
    public ModelRenderer leftTopSpike;
    public ModelRenderer faceTop;
    public ModelRenderer rightShoulder;
    public ModelRenderer rightShin;
    public ModelRenderer rightFoot;
    public ModelRenderer rightFootToe1;
    public ModelRenderer rightFootToe2;
    public ModelRenderer rightFootToe3;
    public ModelRenderer rightFootBackToe;
    public ModelRenderer leftShin;
    public ModelRenderer leftFoot;
    public ModelRenderer leftFootToe1;
    public ModelRenderer leftFootToe2;
    public ModelRenderer leftFootToe3;
    public ModelRenderer leftFootBackToe;
    public ModelRenderer tail1;
    public ModelRenderer tailSpines0;
    public ModelRenderer tail2;
    public ModelRenderer tailSpines1;
    public ModelRenderer tail3;
    public ModelRenderer tailSpines2;
    public ModelRenderer tail4;
    public ModelRenderer tailSpines3;
    public ModelRenderer tailStabber;
    public ModelRenderer tailSpines4;
    public ModelRenderer leftBicep;
    public ModelRenderer leftForearm;
    public ModelRenderer leftFinger1;
    public ModelRenderer leftFinger3;
    public ModelRenderer leftFinger2;
    public ModelRenderer leftFinger4;
    public ModelRenderer abdomin;
    public ModelRenderer neck;
    public ModelRenderer backSpikes;
    public ModelRenderer faceMid;
    public ModelRenderer headTop;
    public ModelRenderer headTopRidge;
    public ModelRenderer topTeeth;
    public ModelRenderer bottomTeeth;
    public ModelRenderer midJaw;
    public ModelRenderer dread1;
    public ModelRenderer dread2;
    public ModelRenderer dread3;
    public ModelRenderer dread4;
    public ModelRenderer dread5;
    public ModelRenderer dread6;
    public ModelRenderer dread7;
    public ModelRenderer dread8;
    public ModelRenderer midHeadSpike;
    public ModelRenderer leftInnerJawWebbing;
    public ModelRenderer rightInnerJawWebbing;
    public ModelRenderer leftUpperMandible;
    public ModelRenderer rightUpperMandible;
    public ModelRenderer leftLowerMandible;
    public ModelRenderer rightLowerMandible;
    public ModelRenderer leftLowerMandible2;
    public ModelRenderer rightLowerMandible2;
    public ModelRenderer leftLowerTooth;
    public ModelRenderer rightLowerTooth;
    public ModelRenderer leftUpperTooth;
    public ModelRenderer rightUpperTooth;
    public ModelRenderer rightJawWebbing;
    public ModelRenderer leftJawWebbing;
    public ModelRenderer rightBicep;
    public ModelRenderer rightForearm;
    public ModelRenderer rightFinger1;
    public ModelRenderer rightFinger2;
    public ModelRenderer rightFinger3;
    public ModelRenderer rightFinger4;

    public ModelPredalien()
    {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.faceTop = new ModelRenderer(this, 130, 101);
        this.faceTop.setRotationPoint(0.0F, -18.3F, 0.0F);
        this.faceTop.addBox(-3.5F, -7.3F, -9.2F, 7, 8, 5, 0.0F);
        this.setRotation(faceTop, -1.0122909661567112F, 0.0F, 0.0F);
        this.rightFinger3 = new ModelRenderer(this, 112, 54);
        this.rightFinger3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFinger3.addBox(1.4F, 16.9F, 1.7F, 0, 10, 3, 0.0F);
        this.setRotation(rightFinger3, -0.5462880558742251F, -0.15707963267948966F, 0.091106186954104F);
        this.midJaw = new ModelRenderer(this, 95, 136);
        this.midJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.midJaw.addBox(-1.5F, -2.0F, -5.5F, 3, 1, 8, 0.0F);
        this.setRotation(midJaw, 1.2042771838760875F, 0.0F, 0.0F);
        this.leftFoot = new ModelRenderer(this, 122, 91);
        this.leftFoot.setRotationPoint(-2.7F, 22.9F, 10.6F);
        this.leftFoot.addBox(-0.6F, -0.7F, -5.2F, 4, 2, 7, 0.0F);
        this.setRotation(leftFoot, 0.5462880558742251F, 0.045553093477052F, 0.27314402793711257F);
        this.leftUpperMandible = new ModelRenderer(this, 103, 113);
        this.leftUpperMandible.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftUpperMandible.addBox(2.5F, -4.0F, -7.5F, 1, 1, 8, 0.0F);
        this.setRotation(leftUpperMandible, 1.0016444577195458F, -0.091106186954104F, -0.22759093446006054F);
        this.neck = new ModelRenderer(this, 0, 34);
        this.neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.neck.addBox(-2.5F, -8.0F, -2.3F, 5, 9, 6, 0.0F);
        this.setRotation(neck, 0.3141592653589793F, 0.0F, 0.0F);
        this.leftThigh = new ModelRenderer(this, 122, 69);
        this.leftThigh.setRotationPoint(1.0F, -2.3F, 7.0F);
        this.leftThigh.addBox(-1.5F, -2.0F, -2.0F, 5, 16, 5, 0.0F);
        this.setRotation(leftThigh, -0.47123889803846897F, -0.3490658503988659F, -0.24434609527920614F);
        this.headTop = new ModelRenderer(this, 57, 51);
        this.headTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headTop.addBox(-3.5F, -19.6F, -11.5F, 7, 17, 7, 0.0F);
        this.setRotation(headTop, -0.45378560551852565F, 0.0F, 0.0F);
        this.rightLowerMandible2 = new ModelRenderer(this, 99, 85);
        this.rightLowerMandible2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightLowerMandible2.addBox(-3.7F, -1.8F, -7.5F, 1, 2, 1, 0.0F);
        this.setRotation(rightLowerMandible2, 1.2042771838760875F, -0.18203784098300857F, 0.22759093446006054F);
        this.leftForearm = new ModelRenderer(this, 133, 52);
        this.leftForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftForearm.addBox(-3.3F, 7.4F, 3.6F, 3, 13, 2, 0.0F);
        this.setRotation(leftForearm, -0.5462880558742251F, 0.0F, -0.03717551306747922F);
        this.leftLowerTooth = new ModelRenderer(this, 145, 93);
        this.leftLowerTooth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftLowerTooth.addBox(3.1F, -3.7F, -7.4F, 0, 2, 1, 0.0F);
        this.setRotation(leftLowerTooth, 1.2042771838760875F, 0.18203784098300857F, -0.22759093446006054F);
        this.rightFootBackToe = new ModelRenderer(this, 143, 82);
        this.rightFootBackToe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFootBackToe.addBox(1.6F, -2.9F, 0.5F, 0, 3, 5, 0.0F);
        this.setRotation(rightFootBackToe, -0.40980330836826856F, -0.045553093477052F, 0.0F);
        this.dread3 = new ModelRenderer(this, 0, 111);
        this.dread3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread3.addBox(-8.5F, -8.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread3, -0.45378560551852565F, 0.0F, 0.0F);
        this.topTorso = new ModelRenderer(this, 0, 0);
        this.topTorso.setRotationPoint(0.0F, -16.3F, 5.0F);
        this.topTorso.addBox(-6.0F, -1.6F, -4.0F, 12, 8, 8, 0.0F);
        this.setRotation(topTorso, 0.17453292519943295F, 0.0F, 0.0F);
        this.rightLowerTooth = new ModelRenderer(this, 145, 97);
        this.rightLowerTooth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightLowerTooth.addBox(-3.2F, -3.7F, -7.4F, 0, 2, 1, 0.0F);
        this.setRotation(rightLowerTooth, 1.2042771838760875F, -0.18203784098300857F, 0.22759093446006054F);
        this.tailSpines2 = new ModelRenderer(this, 122, 23);
        this.tailSpines2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines2.addBox(0.0F, 0.0F, 0.8F, 0, 8, 3, 0.0F);
        this.leftBicep = new ModelRenderer(this, 144, 51);
        this.leftBicep.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftBicep.addBox(-3.5F, -1.6F, -2.5F, 4, 12, 4, 0.0F);
        this.dread2 = new ModelRenderer(this, 0, 123);
        this.dread2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread2.addBox(-8.5F, -6.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread2, -0.45378560551852565F, 0.0F, 0.0F);
        this.rightTopSpike = new ModelRenderer(this, 41, 0);
        this.rightTopSpike.mirror = true;
        this.rightTopSpike.setRotationPoint(-4.0F, -16.3F, 5.0F);
        this.rightTopSpike.addBox(0.5F, 0.27F, 2.0F, 2, 2, 14, -0.0F);
        this.setRotation(rightTopSpike, 0.20943951023931953F, -0.47123889803846897F, -0.40142572795869574F);
        this.rightFinger4 = new ModelRenderer(this, 105, 55);
        this.rightFinger4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFinger4.addBox(2.6F, 16.8F, 2.6F, 0, 9, 3, 0.0F);
        this.setRotation(rightFinger4, -0.5462880558742251F, 0.0F, 0.14189526818713902F);
        this.RightThigh = new ModelRenderer(this, 122, 69);
        this.RightThigh.mirror = true;
        this.RightThigh.setRotationPoint(-1.0F, -2.3F, 7.0F);
        this.RightThigh.addBox(-3.5F, -2.0F, -2.0F, 5, 16, 5, 0.0F);
        this.setRotation(RightThigh, -0.47123889803846897F, 0.3490658503988659F, 0.24434609527920614F);
        this.leftShin = new ModelRenderer(this, 105, 69);
        this.leftShin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftShin.addBox(2.5F, 9.0F, -9.3F, 4, 15, 4, 0.0F);
        this.setRotation(leftShin, 0.7285004297824331F, 0.045553093477052F, 0.27314402793711257F);
        this.leftFinger1 = new ModelRenderer(this, 126, 55);
        this.leftFinger1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftFinger1.addBox(2.4F, 16.7F, 0.4F, 0, 9, 3, 0.0F);
        this.setRotation(leftFinger1, -0.3968878719035105F, 0.2617993877991494F, 0.18203784098300857F);
        this.leftUpperTooth = new ModelRenderer(this, 99, 77);
        this.leftUpperTooth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftUpperTooth.addBox(2.0F, -4.2F, -6.6F, 2, 1, 0, 0.0F);
        this.setRotation(leftUpperTooth, 1.0122909661567112F, 0.0F, -0.05235987755982988F);
        this.rightForearm = new ModelRenderer(this, 133, 52);
        this.rightForearm.mirror = true;
        this.rightForearm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightForearm.addBox(0.5F, 7.4F, 3.6F, 3, 13, 2, 0.0F);
        this.setRotation(rightForearm, -0.5462880558742251F, 0.0F, 0.03717551306747922F);
        this.leftLowerMandible2 = new ModelRenderer(this, 99, 81);
        this.leftLowerMandible2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftLowerMandible2.addBox(2.6F, -1.8F, -7.5F, 1, 2, 1, 0.0F);
        this.setRotation(leftLowerMandible2, 1.2042771838760875F, 0.18203784098300857F, -0.22759093446006054F);
        this.leftFinger4 = new ModelRenderer(this, 105, 55);
        this.leftFinger4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftFinger4.addBox(-2.4F, 16.8F, 2.6F, 0, 9, 3, 0.0F);
        this.setRotation(leftFinger4, -0.5462880558742251F, 0.0F, -0.14189526818713902F);
        this.tailStabber = new ModelRenderer(this, 97, 0);
        this.tailStabber.setRotationPoint(0.0F, 9.2F, 0.0F);
        this.tailStabber.addBox(0.0F, -0.4F, -1.5F, 0, 10, 5, 0.0F);
        this.leftFootToe3 = new ModelRenderer(this, 181, 69);
        this.leftFootToe3.setRotationPoint(0.0F, -0.0F, 0.0F);
        this.leftFootToe3.addBox(2.2F, -1.7F, -11.5F, 0, 3, 9, 0.0F);
        this.setRotation(leftFootToe3, 0.0F, -0.136659280431156F, 0.0F);
        this.midHeadSpike = new ModelRenderer(this, 57, 113);
        this.midHeadSpike.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.midHeadSpike.addBox(0.0F, -19.6F, -15.5F, 0, 26, 10, 0.0F);
        this.setRotation(midHeadSpike, -0.45378560551852565F, 0.0F, 0.0F);
        this.rightLowerSpike = new ModelRenderer(this, 46, 17);
        this.rightLowerSpike.mirror = true;
        this.rightLowerSpike.setRotationPoint(-4.0F, -16.3F, 5.0F);
        this.rightLowerSpike.addBox(0.23F, 2.27F, 3.0F, 2, 2, 11, 0.0F);
        this.setRotation(rightLowerSpike, -0.20943951023931953F, -0.47123889803846897F, -0.40142572795869574F);
        this.leftTopSpike = new ModelRenderer(this, 41, 0);
        this.leftTopSpike.setRotationPoint(1.5F, -16.3F, 5.0F);
        this.leftTopSpike.addBox(-0.5F, -0.3F, 3.0F, 2, 2, 14, 0.0F);
        this.setRotation(leftTopSpike, 0.20943951023931953F, 0.47123889803846897F, 0.40142572795869574F);
        this.rightFootToe2 = new ModelRenderer(this, 143, 69);
        this.rightFootToe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFootToe2.addBox(1.1F, -1.3F, -11.5F, 0, 3, 9, 0.0F);
        this.rightFootToe1 = new ModelRenderer(this, 162, 69);
        this.rightFootToe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFootToe1.addBox(2.0F, -1.3F, -11.5F, 0, 3, 9, 0.0F);
        this.setRotation(rightFootToe1, 0.0F, -0.136659280431156F, 0.0F);
        this.leftShoulder = new ModelRenderer(this, 161, 55);
        this.leftShoulder.setRotationPoint(6.0F, -15.3F, 6.0F);
        this.leftShoulder.addBox(-4.5F, -3.6F, -3.5F, 6, 6, 6, 0.0F);
        this.setRotation(leftShoulder, 0.13962634015954636F, 0.0F, -0.5235987755982988F);
        this.leftFinger3 = new ModelRenderer(this, 112, 54);
        this.leftFinger3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftFinger3.addBox(-1.1F, 16.9F, 1.7F, 0, 10, 3, 0.0F);
        this.setRotation(leftFinger3, -0.5462880558742251F, 0.15707963267948966F, -0.091106186954104F);
        this.rightShoulder = new ModelRenderer(this, 161, 55);
        this.rightShoulder.mirror = true;
        this.rightShoulder.setRotationPoint(-6.0F, -15.3F, 6.0F);
        this.rightShoulder.addBox(-1.5F, -3.6F, -3.5F, 6, 6, 6, 0.0F);
        this.setRotation(rightShoulder, 0.13962634015954636F, 0.0F, 0.5235987755982988F);
        this.leftFootToe2 = new ModelRenderer(this, 143, 69);
        this.leftFootToe2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftFootToe2.addBox(1.7F, -1.7F, -11.5F, 0, 3, 9, 0.0F);
        this.dread4 = new ModelRenderer(this, 0, 99);
        this.dread4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread4.addBox(-8.5F, -10.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread4, -0.45378560551852565F, 0.0F, 0.0F);
        this.leftFootBackToe = new ModelRenderer(this, 143, 82);
        this.leftFootBackToe.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftFootBackToe.addBox(1.3F, -2.9F, 0.5F, 0, 3, 5, 0.0F);
        this.setRotation(leftFootBackToe, -0.40980330836826856F, 0.045553093477052F, 0.0F);
        this.headTopRidge = new ModelRenderer(this, 78, 113);
        this.headTopRidge.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headTopRidge.addBox(-4.5F, -20.6F, -10.5F, 9, 18, 3, 0.0F);
        this.setRotation(headTopRidge, -0.45378560551852565F, 0.0F, 0.0F);
        this.leftLowerMandible = new ModelRenderer(this, 99, 90);
        this.leftLowerMandible.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftLowerMandible.addBox(1.9F, -0.5F, -7.4F, 1, 1, 9, 0.0F);
        this.setRotation(leftLowerMandible, 1.1383037381507017F, 0.136659280431156F, -0.31869712141416456F);
        this.tailSpines1 = new ModelRenderer(this, 122, 12);
        this.tailSpines1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines1.addBox(0.0F, 0.1F, 1.3F, 0, 8, 3, 0.0F);
        this.faceMid = new ModelRenderer(this, 99, 101);
        this.faceMid.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.faceMid.addBox(-3.5F, -6.5F, -6.6F, 7, 3, 8, 0.0F);
        this.setRotation(faceMid, 0.8552113334772213F, 0.0F, 0.0F);
        this.rightUpperMandible = new ModelRenderer(this, 122, 115);
        this.rightUpperMandible.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightUpperMandible.addBox(-3.5F, -4.0F, -7.5F, 1, 1, 8, 0.0F);
        this.setRotation(rightUpperMandible, 1.0016444577195458F, 0.091106186954104F, 0.22759093446006054F);
        this.rightFinger1 = new ModelRenderer(this, 126, 55);
        this.rightFinger1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFinger1.addBox(-2.4F, 16.7F, 0.7F, 0, 9, 3, 0.0F);
        this.setRotation(rightFinger1, -0.3968878719035105F, -0.2617993877991494F, -0.18291050560900574F);
        this.rightFoot = new ModelRenderer(this, 122, 91);
        this.rightFoot.mirror = true;
        this.rightFoot.setRotationPoint(0.0F, 23.3F, 10.3F);
        this.rightFoot.addBox(-0.6F, -0.3F, -5.2F, 4, 2, 7, 0.0F);
        this.setRotation(rightFoot, 0.5462880558742251F, -0.045553093477052F, -0.27314402793711257F);
        this.leftFinger2 = new ModelRenderer(this, 119, 54);
        this.leftFinger2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftFinger2.addBox(0.7F, 16.9F, 2.0F, 0, 10, 3, 0.0F);
        this.setRotation(leftFinger2, -0.5462880558742251F, 0.17453292519943295F, 0.045553093477052F);
        this.tailSpines4 = new ModelRenderer(this, 135, 36);
        this.tailSpines4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines4.addBox(0.0F, 0.5F, -0.3F, 0, 8, 3, 0.0F);
        this.dread8 = new ModelRenderer(this, 0, 63);
        this.dread8.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread8.addBox(-8.5F, -18.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread8, -0.45378560551852565F, 0.0F, 0.0F);
        this.leftLowerSpike = new ModelRenderer(this, 46, 17);
        this.leftLowerSpike.setRotationPoint(1.5F, -16.3F, 5.0F);
        this.leftLowerSpike.addBox(-0.2F, 1.0F, 3.0F, 2, 2, 11, 0.0F);
        this.setRotation(leftLowerSpike, -0.20943951023931953F, 0.47123889803846897F, 0.40142572795869574F);
        this.rightUpperTooth = new ModelRenderer(this, 99, 79);
        this.rightUpperTooth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightUpperTooth.addBox(-4.0F, -4.2F, -6.6F, 2, 1, 0, 0.0F);
        this.setRotation(rightUpperTooth, 1.0122909661567112F, 0.0F, 0.05235987755982988F);
        this.tailSpines3 = new ModelRenderer(this, 122, 36);
        this.tailSpines3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines3.addBox(0.0F, -1.7F, 0.9F, 0, 8, 3, 0.0F);
        this.topTeeth = new ModelRenderer(this, 148, 95);
        this.topTeeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.topTeeth.addBox(-2.0F, -4.0F, -6.5F, 4, 2, 0, 0.0F);
        this.setRotation(topTeeth, 0.8552113334772213F, 0.0F, 0.0F);
        this.rightJawWebbing = new ModelRenderer(this, 86, 51);
        this.rightJawWebbing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightJawWebbing.addBox(-2.4F, -3.9F, -6.3F, 0, 3, 8, 0.0F);
        this.setRotation(rightJawWebbing, 1.1383037381507017F, 0.091106186954104F, 0.22759093446006054F);
        this.tailSpines0 = new ModelRenderer(this, 122, 0);
        this.tailSpines0.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.tailSpines0.addBox(0.0F, 0.4F, 1.7F, 0, 9, 3, 0.0F);
        this.tail3 = new ModelRenderer(this, 76, 29);
        this.tail3.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.tail3.addBox(-1.5F, -2.6F, -1.0F, 3, 9, 3, 0.0F);
        this.setRotation(tail3, 0.2617993877991494F, 0.0F, 0.0F);
        this.dread6 = new ModelRenderer(this, 0, 75);
        this.dread6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread6.addBox(-8.5F, -14.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread6, -0.45378560551852565F, 0.0F, 0.0F);
        this.leftJawWebbing = new ModelRenderer(this, 78, 135);
        this.leftJawWebbing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftJawWebbing.addBox(2.4F, -3.9F, -6.3F, 0, 3, 8, 0.0F);
        this.setRotation(leftJawWebbing, 1.1383037381507017F, -0.091106186954104F, -0.22759093446006054F);
        this.leftFootToe1 = new ModelRenderer(this, 162, 69);
        this.leftFootToe1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftFootToe1.addBox(0.8F, -1.7F, -11.5F, 0, 3, 9, 0.0F);
        this.setRotation(leftFootToe1, 0.0F, 0.136659280431156F, 0.0F);
        this.bottomTeeth = new ModelRenderer(this, 148, 98);
        this.bottomTeeth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bottomTeeth.addBox(-1.4F, -2.5F, -5.5F, 3, 2, 0, 0.0F);
        this.setRotation(bottomTeeth, 1.0122909661567112F, 0.0F, 0.0F);
        this.dread5 = new ModelRenderer(this, 0, 87);
        this.dread5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread5.addBox(-8.5F, -12.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread5, -0.45378560551852565F, 0.0F, 0.0F);
        this.rightInnerJawWebbing = new ModelRenderer(this, 86, 63);
        this.rightInnerJawWebbing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightInnerJawWebbing.addBox(-1.2F, -6.1F, -4.0F, 0, 4, 8, 0.0F);
        this.setRotation(rightInnerJawWebbing, 1.2042771838760875F, 0.136659280431156F, -0.091106186954104F);
        this.tail4 = new ModelRenderer(this, 89, 29);
        this.tail4.setRotationPoint(0.0F, 6.3F, 0.5F);
        this.tail4.addBox(-1.0F, -0.1F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotation(tail4, 0.17453292519943295F, 0.0F, 0.0F);
        this.rightLowerMandible = new ModelRenderer(this, 99, 90);
        this.rightLowerMandible.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightLowerMandible.addBox(-2.9F, -0.5F, -7.5F, 1, 1, 9, 0.0F);
        this.setRotation(rightLowerMandible, 1.1383037381507017F, -0.136659280431156F, 0.31869712141416456F);
        this.tail2 = new ModelRenderer(this, 76, 15);
        this.tail2.setRotationPoint(0.0F, 8.5F, -0.7F);
        this.tail2.addBox(-2.0F, -1.0F, -2.0F, 4, 9, 4, 0.0F);
        this.setRotation(tail2, 0.17453292519943295F, 0.0F, 0.0F);
        this.dread1 = new ModelRenderer(this, 0, 135);
        this.dread1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread1.addBox(-8.5F, -4.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread1, -0.45378560551852565F, 0.0F, 0.0F);
        this.dread7 = new ModelRenderer(this, 0, 51);
        this.dread7.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.dread7.addBox(-8.5F, -16.6F, -10.5F, 17, 0, 11, 0.0F);
        this.setRotation(dread7, -0.45378560551852565F, 0.0F, 0.0F);
        this.abdomin = new ModelRenderer(this, 0, 17);
        this.abdomin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.abdomin.addBox(-4.0F, 4.4F, -3.5F, 8, 10, 6, 0.0F);
        this.setRotation(abdomin, 0.10471975511965977F, 0.0F, 0.0F);
        this.tailBase = new ModelRenderer(this, 49, 33);
        this.tailBase.setRotationPoint(0.0F, -3.3F, 8.0F);
        this.tailBase.addBox(-3.0F, 0.07F, -3.0F, 6, 9, 6, -0.0F);
        this.setRotation(tailBase, 0.6981317007977318F, 0.0F, 0.0F);
        this.rightBicep = new ModelRenderer(this, 144, 51);
        this.rightBicep.mirror = true;
        this.rightBicep.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightBicep.addBox(-0.5F, -1.6F, -2.5F, 4, 12, 4, 0.0F);
        this.rightFinger2 = new ModelRenderer(this, 119, 54);
        this.rightFinger2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFinger2.addBox(-0.5F, 16.9F, 2.0F, 0, 10, 3, 0.0F);
        this.setRotation(rightFinger2, -0.5462880558742251F, -0.17453292519943295F, -0.045553093477052F);
        this.rightShin = new ModelRenderer(this, 105, 69);
        this.rightShin.mirror = true;
        this.rightShin.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightShin.addBox(-6.4F, 9.0F, -9.3F, 4, 15, 4, 0.0F);
        this.setRotation(rightShin, 0.7285004297824331F, -0.045553093477052F, -0.27314402793711257F);
        this.tail1 = new ModelRenderer(this, 76, 0);
        this.tail1.setRotationPoint(0.0F, 9.4F, 0.5F);
        this.tail1.addBox(-2.5F, -0.93F, -3.0F, 5, 9, 5, 0.0F);
        this.setRotation(tail1, 0.17453292519943295F, 0.0F, 0.0F);
        this.backSpikes = new ModelRenderer(this, 29, 17);
        this.backSpikes.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.backSpikes.addBox(0.0F, -1.6F, 3.0F, 0, 15, 8, 0.0F);
        this.rightFootToe3 = new ModelRenderer(this, 181, 69);
        this.rightFootToe3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.rightFootToe3.addBox(0.6F, -1.3F, -11.5F, 0, 3, 9, 0.0F);
        this.setRotation(rightFootToe3, 0.0F, 0.136659280431156F, 0.0F);
        this.leftInnerJawWebbing = new ModelRenderer(this, 103, 123);
        this.leftInnerJawWebbing.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.leftInnerJawWebbing.addBox(1.2F, -6.1F, -4.0F, 0, 4, 8, 0.0F);
        this.setRotation(leftInnerJawWebbing, 1.2042771838760875F, -0.136659280431156F, 0.091106186954104F);
        this.rightShoulder.addChild(this.rightFinger3);
        this.faceTop.addChild(this.midJaw);
        this.leftThigh.addChild(this.leftFoot);
        this.faceTop.addChild(this.leftUpperMandible);
        this.topTorso.addChild(this.neck);
        this.faceTop.addChild(this.headTop);
        this.faceTop.addChild(this.rightLowerMandible2);
        this.leftShoulder.addChild(this.leftForearm);
        this.faceTop.addChild(this.leftLowerTooth);
        this.rightFoot.addChild(this.rightFootBackToe);
        this.faceTop.addChild(this.dread3);
        this.faceTop.addChild(this.rightLowerTooth);
        this.tail2.addChild(this.tailSpines2);
        this.leftShoulder.addChild(this.leftBicep);
        this.faceTop.addChild(this.dread2);
        this.rightShoulder.addChild(this.rightFinger4);
        this.leftThigh.addChild(this.leftShin);
        this.leftShoulder.addChild(this.leftFinger1);
        this.faceTop.addChild(this.leftUpperTooth);
        this.rightShoulder.addChild(this.rightForearm);
        this.faceTop.addChild(this.leftLowerMandible2);
        this.leftShoulder.addChild(this.leftFinger4);
        this.tail4.addChild(this.tailStabber);
        this.leftFoot.addChild(this.leftFootToe3);
        this.faceTop.addChild(this.midHeadSpike);
        this.rightFoot.addChild(this.rightFootToe2);
        this.rightFoot.addChild(this.rightFootToe1);
        this.leftShoulder.addChild(this.leftFinger3);
        this.leftFoot.addChild(this.leftFootToe2);
        this.faceTop.addChild(this.dread4);
        this.leftFoot.addChild(this.leftFootBackToe);
        this.faceTop.addChild(this.headTopRidge);
        this.faceTop.addChild(this.leftLowerMandible);
        this.tail1.addChild(this.tailSpines1);
        this.faceTop.addChild(this.faceMid);
        this.faceTop.addChild(this.rightUpperMandible);
        this.rightShoulder.addChild(this.rightFinger1);
        this.RightThigh.addChild(this.rightFoot);
        this.leftShoulder.addChild(this.leftFinger2);
        this.tail4.addChild(this.tailSpines4);
        this.faceTop.addChild(this.dread8);
        this.faceTop.addChild(this.rightUpperTooth);
        this.tail3.addChild(this.tailSpines3);
        this.faceTop.addChild(this.topTeeth);
        this.faceTop.addChild(this.rightJawWebbing);
        this.tailBase.addChild(this.tailSpines0);
        this.tail2.addChild(this.tail3);
        this.faceTop.addChild(this.dread6);
        this.faceTop.addChild(this.leftJawWebbing);
        this.leftFoot.addChild(this.leftFootToe1);
        this.faceTop.addChild(this.bottomTeeth);
        this.faceTop.addChild(this.dread5);
        this.faceTop.addChild(this.rightInnerJawWebbing);
        this.tail3.addChild(this.tail4);
        this.faceTop.addChild(this.rightLowerMandible);
        this.tail1.addChild(this.tail2);
        this.faceTop.addChild(this.dread1);
        this.faceTop.addChild(this.dread7);
        this.topTorso.addChild(this.abdomin);
        this.rightShoulder.addChild(this.rightBicep);
        this.rightShoulder.addChild(this.rightFinger2);
        this.RightThigh.addChild(this.rightShin);
        this.tailBase.addChild(this.tail1);
        this.topTorso.addChild(this.backSpikes);
        this.rightFoot.addChild(this.rightFootToe3);
        this.faceTop.addChild(this.leftInnerJawWebbing);
    }
    
    @Override
    public void render(EntityPredalien obj)
    {
        EntityLivingBase base = (EntityLivingBase) obj;;

        float newangle = MathHelper.cos(idleProgress(obj) * 4.0F * 0.1F) * (float) Math.PI * 0.5F * swingProgressPrev(obj);
        float distMult = 0.25F;

        if (base != null && base.prevPosX == base.posX && base.prevPosY == base.posY && base.prevPosZ == base.posZ)
        {
            newangle = MathHelper.cos(idleProgress(obj) * 0.07F);
            distMult = 0.95F;
        }

        this.doTail(newangle, distMult);
        
        this.faceTop.rotateAngleY = (float) Math.toRadians(headYaw(obj)) * 0.75F;
        this.leftShoulder.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 0.6F * swingProgressPrev(obj) + 0.1665191F + (MathHelper.sin(idleProgress(obj) * 0.025F) * 0.2F);
        this.rightShoulder.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 0.6F * swingProgressPrev(obj) + 0.1665191F - (MathHelper.sin(idleProgress(obj) * 0.025F) * 0.2F);
        this.leftThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F) * 0.8F * swingProgressPrev(obj) - 0.4014257F;
        this.RightThigh.rotateAngleX = MathHelper.cos(swingProgress(obj) * 0.6662F + (float) Math.PI) * 0.8F * swingProgressPrev(obj) - 0.4028515F;
        
        draw(faceTop);
        draw(leftThigh);
        draw(topTorso);
        draw(rightTopSpike);
        draw(RightThigh);
        draw(rightLowerSpike);
        draw(leftTopSpike);
        draw(leftShoulder);
        draw(rightShoulder);
        draw(leftLowerSpike);
        draw(tailBase);
    }
    
    private void doTail(float angle, float distMult)
    {
        float multiplier = 0.25F;
        this.tailBase.rotateAngleY = angle / 1.5F;
        this.tailSpines0.rotateAngleY = -(angle / 1.5F) / 4;
        this.tail1.rotateAngleY = angle * multiplier;
        this.tail2.rotateAngleY = angle * multiplier;
        this.tail2.rotateAngleZ = -angle * multiplier;
        this.tail3.rotateAngleY = angle * multiplier * 2;
        this.tail3.rotateAngleZ = -angle * multiplier * 2;
        this.tail4.rotateAngleY = angle * multiplier * 2;
        this.tail4.rotateAngleZ = -angle * multiplier * 2;
//        this.tail1.rotationPointZ = this.tailBase.rotationPointZ + (float) Math.cos(this.tailBase.rotateAngleY) * 10.0F;
//        this.tail1.rotationPointX = this.tailBase.rotationPointX + (float) Math.sin(this.tailBase.rotateAngleY) * 10.0F;
//        this.tailSpines1.rotateAngleY = angle * multiplier;
//        this.tailSpines1.rotationPointZ = this.tailBase.rotationPointZ + (float) Math.cos(this.tailBase.rotateAngleY) * 10.0F;
//        this.tailSpines1.rotationPointX = this.tailBase.rotationPointX + (float) Math.sin(this.tailBase.rotateAngleY) * 10.0F;
//        multiplier = multiplier + distMult;
//        this.tail2.rotateAngleY = angle * multiplier;
//        this.tail2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 10.0F;
//        this.tail2.rotationPointX = this.tail1.rotationPointX + (float) Math.sin(this.tail1.rotateAngleY) * 10.0F;
//        this.tailSpines2.rotateAngleY = angle * multiplier;
//        this.tailSpines2.rotationPointZ = this.tail1.rotationPointZ + (float) Math.cos(this.tail1.rotateAngleY) * 10.0F;
//        this.tailSpines2.rotationPointX = this.tail1.rotationPointX + (float) Math.sin(this.tail1.rotateAngleY) * 10.0F;
//        multiplier = multiplier + distMult;
//        this.tail3.rotateAngleY = angle * multiplier;
//        this.tail3.rotationPointZ = this.tail2.rotationPointZ + (float) Math.cos(this.tail2.rotateAngleY) * 10.0F;
//        this.tail3.rotationPointX = this.tail2.rotationPointX + (float) Math.sin(this.tail2.rotateAngleY) * 10.0F;
//        this.tailSpines3.rotateAngleY = angle * multiplier;
//        this.tailSpines3.rotationPointZ = this.tail2.rotationPointZ + (float) Math.cos(this.tail2.rotateAngleY) * 10.0F;
//        this.tailSpines3.rotationPointX = this.tail2.rotationPointX + (float) Math.sin(this.tail2.rotateAngleY) * 10.0F;
//        multiplier = multiplier + distMult;
//        this.tail4.rotateAngleY = angle * multiplier;
//        this.tail4.rotationPointZ = this.tail3.rotationPointZ + (float) Math.cos(this.tail3.rotateAngleY) * 10.0F;
//        this.tail4.rotationPointX = this.tail3.rotationPointX + (float) Math.sin(this.tail3.rotateAngleY) * 10.0F;
//        this.tailSpines4.rotateAngleY = angle * multiplier;
//        this.tailSpines4.rotationPointZ = this.tail3.rotationPointZ + (float) Math.cos(this.tail3.rotateAngleY) * 10.0F;
//        this.tailSpines4.rotationPointX = this.tail3.rotationPointX + (float) Math.sin(this.tail3.rotateAngleY) * 10.0F;
//        multiplier = multiplier + distMult;
//        this.tailStabber.rotateAngleY = angle * multiplier;
//        this.tailStabber.rotationPointZ = this.tail4.rotationPointZ + (float) Math.cos(this.tail4.rotateAngleY) * 10.0F;
//        this.tailStabber.rotationPointX = this.tail4.rotationPointX + (float) Math.sin(this.tail4.rotateAngleY) * 10.0F;
    }
}
