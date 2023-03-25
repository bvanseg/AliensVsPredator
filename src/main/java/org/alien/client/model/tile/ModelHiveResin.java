package org.alien.client.model.tile;

import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.model.ModelRenderer;
import org.alien.common.tile.TileEntityHiveResin;

public class ModelHiveResin extends Model<TileEntityHiveResin>
{
    public final ModelRenderer nResinRipCenter;
    public final ModelRenderer sResinRipCenter;
    public final ModelRenderer eResinRipCenter;
    public final ModelRenderer wResinRipCenter;
    public final ModelRenderer bResinRibCenter;
    public final ModelRenderer webbing01;
    public final ModelRenderer webbing02;
    public final ModelRenderer webbing03;
    public final ModelRenderer webbing04;
    public final ModelRenderer webbing05;
    public final ModelRenderer webbing06;
    public final ModelRenderer webbing07;
    public final ModelRenderer webbing08;
    public final ModelRenderer webbing09;
    public final ModelRenderer webbing10;
    public final ModelRenderer webbing11;
    public final ModelRenderer webbing12;
    public final ModelRenderer webbing13;
    public final ModelRenderer webbing14;
    public final ModelRenderer webbing15;
    public final ModelRenderer nResinRibTop02;
    public final ModelRenderer nResinRibTop01;
    public final ModelRenderer nResinRibBottom01;
    public final ModelRenderer nResinRibBottom02;
    public final ModelRenderer nBottomRoot01;
    public final ModelRenderer nTopRoot01;
    public final ModelRenderer nBottomRoot02;
    public final ModelRenderer nTopRoot02;
    public final ModelRenderer nTopRoot03;
    public final ModelRenderer sResinRibTop01;
    public final ModelRenderer sResinRibTop02;
    public final ModelRenderer sResinRibBottom01;
    public final ModelRenderer sResinRibBottom02;
    public final ModelRenderer sBottomRoot01;
    public final ModelRenderer sTopRoot01;
    public final ModelRenderer sBottomRoot02;
    public final ModelRenderer sBottomRoot03;
    public final ModelRenderer sTopRoot02;
    public final ModelRenderer sTopRoot03;
    public final ModelRenderer eResinRibTop01;
    public final ModelRenderer eResinRibTop02;
    public final ModelRenderer eResinRibBottom01;
    public final ModelRenderer eResinRibBottom02;
    public final ModelRenderer eBottomRoot01;
    public final ModelRenderer eTopRoot01;
    public final ModelRenderer eBottomRoot02;
    public final ModelRenderer eTopRoot02;
    public final ModelRenderer eTopRoot03;
    public final ModelRenderer wResinRibTop01;
    public final ModelRenderer wResinRibTop02;
    public final ModelRenderer wResinRibBottom01;
    public final ModelRenderer wResinRibBottom02;
    public final ModelRenderer wBottomRoot01;
    public final ModelRenderer wTopRoot01;
    public final ModelRenderer wBottomRoot02;
    public final ModelRenderer wBottomRoot03;
    public final ModelRenderer wTopRoot02;
    public final ModelRenderer wTopRoot03;
    public final ModelRenderer wTopRoot04;
    public final ModelRenderer bResinRib02;
    public final ModelRenderer bResinRib03;
    public final ModelRenderer bResinRib02_1;
    public final ModelRenderer bResinRib02_2;
    
    public final ModelRenderer blockFaceTop;
    public final ModelRenderer blockFaceBottom;
    public final ModelRenderer blockFaceNorth;
    public final ModelRenderer blockFaceSouth;
    public final ModelRenderer blockFaceWest;
    public final ModelRenderer blockFaceEast;

    public ModelHiveResin()
    {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.webbing05 = new ModelRenderer(this, 102, 45);
        this.webbing05.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing05.addBox(-10.4F, 11.0F, -3.3F, 0, 12, 6, 0.0F);
        this.setRotation(webbing05, 0.0F, -0.4553564018453205F, 0.0F);
        this.wResinRibBottom02 = new ModelRenderer(this, 66, 55);
        this.wResinRibBottom02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wResinRibBottom02.addBox(-3.8F, 4.3F, -3.0F, 4, 3, 6, 0.0F);
        this.setRotation(wResinRibBottom02, 0.0F, 0.0F, 0.045553093477052F);
        this.wBottomRoot02 = new ModelRenderer(this, 80, 0);
        this.wBottomRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wBottomRoot02.addBox(-0.7F, 1.2F, -10.1F, 1, 1, 5, 0.0F);
        this.setRotation(wBottomRoot02, 0.0F, 1.2292353921796064F, 0.0F);
        this.sTopRoot02 = new ModelRenderer(this, 82, 7);
        this.sTopRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sTopRoot02.addBox(-1.5F, -0.4F, 5.0F, 3, 2, 4, 0.0F);
        this.webbing09 = new ModelRenderer(this, 88, 48);
        this.webbing09.mirror = true;
        this.webbing09.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing09.addBox(10.3F, 14.5F, -1.2F, 0, 9, 6, 0.0F);
        this.setRotation(webbing09, 0.0F, 1.2292353921796064F, 0.0F);
        this.nTopRoot03 = new ModelRenderer(this, 80, 0);
        this.nTopRoot03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nTopRoot03.addBox(1.2F, -0.4F, -9.4F, 1, 1, 5, 0.0F);
        this.setRotation(nTopRoot03, 0.0F, 0.6829473363053812F, 0.0F);
        this.eTopRoot02 = new ModelRenderer(this, 99, 0);
        this.eTopRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eTopRoot02.addBox(5.3F, -0.8F, -3.1F, 4, 1, 3, 0.0F);
        this.setRotation(eTopRoot02, 0.0F, -0.31869712141416456F, 0.0F);
        this.webbing03 = new ModelRenderer(this, 0, 7);
        this.webbing03.mirror = true;
        this.webbing03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing03.addBox(-1.5F, 16.9F, 10.6F, 5, 7, 0, 0.0F);
        this.setRotation(webbing03, 0.0F, 0.40980330836826856F, 0.0F);
        this.webbing13 = new ModelRenderer(this, 88, 51);
        this.webbing13.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing13.addBox(-10.1F, 8.3F, -1.9F, 0, 7, 6, 0.0F);
        this.setRotation(webbing13, 0.0F, -1.1838568316277536F, 0.0F);
        this.nResinRipCenter = new ModelRenderer(this, 0, 36);
        this.nResinRipCenter.setRotationPoint(0.0F, 16.0F, -7.8F);
        this.nResinRipCenter.addBox(-2.0F, -2.5F, -2.3F, 4, 5, 3, 0.0F);
        this.wTopRoot03 = new ModelRenderer(this, 99, 0);
        this.wTopRoot03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wTopRoot03.addBox(-10.5F, -0.7F, 4.2F, 4, 1, 3, 0.0F);
        this.setRotation(wTopRoot03, 0.0F, -0.8196066167365371F, 0.0F);
        this.wTopRoot04 = new ModelRenderer(this, 80, 0);
        this.wTopRoot04.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wTopRoot04.addBox(-10.0F, -0.8F, -10.0F, 1, 1, 5, 0.0F);
        this.setRotation(wTopRoot04, 0.0F, 0.27314402793711257F, 0.0F);
        this.webbing10 = new ModelRenderer(this, 100, 30);
        this.webbing10.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing10.addBox(10.6F, 7.9F, -4.3F, 0, 9, 8, 0.0F);
        this.setRotation(webbing10, 0.0F, -1.1383037381507017F, 0.0F);
        this.eResinRibBottom01 = new ModelRenderer(this, 48, 44);
        this.eResinRibBottom01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eResinRibBottom01.addBox(-0.1F, 2.0F, -2.5F, 3, 3, 5, 0.0F);
        this.setRotation(eResinRibBottom01, 0.0F, 0.0F, -0.091106186954104F);
        this.webbing06 = new ModelRenderer(this, 102, 45);
        this.webbing06.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing06.addBox(-10.5F, 12.0F, -3.6F, 0, 12, 6, 0.0F);
        this.setRotation(webbing06, 0.0F, 1.1383037381507017F, 0.0F);
        this.nBottomRoot02 = new ModelRenderer(this, 55, 4);
        this.nBottomRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nBottomRoot02.addBox(-1.9F, 0.6F, -7.8F, 2, 1, 3, 0.0F);
        this.setRotation(nBottomRoot02, 0.0F, -0.22759093446006054F, 0.0F);
        this.wTopRoot02 = new ModelRenderer(this, 99, 0);
        this.wTopRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wTopRoot02.addBox(-9.0F, -0.7F, 0.6F, 4, 1, 3, 0.0F);
        this.setRotation(wTopRoot02, 0.0F, -0.36425021489121656F, 0.0F);
        this.webbing07 = new ModelRenderer(this, 100, 30);
        this.webbing07.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing07.addBox(10.2F, 13.1F, -6.1F, 0, 10, 8, 0.0F);
        this.setRotation(webbing07, 0.0F, 1.9123572614101867F, 0.0F);
        this.eResinRibTop01 = new ModelRenderer(this, 48, 44);
        this.eResinRibTop01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eResinRibTop01.addBox(-0.1F, -6.1F, -2.5F, 3, 3, 5, 0.0F);
        this.setRotation(eResinRibTop01, 0.0F, 0.0F, 0.091106186954104F);
        this.sBottomRoot03 = new ModelRenderer(this, 80, 0);
        this.sBottomRoot03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sBottomRoot03.addBox(-9.0F, 0.6F, 4.8F, 1, 1, 5, 0.0F);
        this.setRotation(sBottomRoot03, 0.0F, 1.2292353921796064F, 0.0F);
        this.bResinRibCenter = new ModelRenderer(this, 66, 17);
        this.bResinRibCenter.setRotationPoint(0.0F, 23.0F, 0.0F);
        this.bResinRibCenter.addBox(-2.0F, 0.0F, -2.0F, 4, 3, 5, 0.0F);
        this.wResinRipCenter = new ModelRenderer(this, 66, 33);
        this.wResinRipCenter.setRotationPoint(-7.2F, 16.8F, 0.0F);
        this.wResinRipCenter.addBox(-3.0F, -3.0F, -1.8F, 3, 5, 4, 0.0F);
        this.nResinRibBottom01 = new ModelRenderer(this, 0, 48);
        this.nResinRibBottom01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nResinRibBottom01.addBox(-2.5F, 2.3F, -2.3F, 5, 3, 3, 0.0F);
        this.setRotation(nResinRibBottom01, -0.091106186954104F, 0.0F, 0.0F);
        this.eBottomRoot01 = new ModelRenderer(this, 100, 7);
        this.eBottomRoot01.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.eBottomRoot01.addBox(4.0F, 0.2F, -2.0F, 2, 2, 4, 0.0F);
        this.sTopRoot01 = new ModelRenderer(this, 55, 0);
        this.sTopRoot01.setRotationPoint(0.0F, -7.2F, 0.0F);
        this.sTopRoot01.addBox(-2.0F, -0.4F, 3.8F, 4, 2, 2, 0.0F);
        this.setRotation(sTopRoot01, 0.091106186954104F, 0.0F, 0.0F);
        this.wResinRibTop02 = new ModelRenderer(this, 66, 55);
        this.wResinRibTop02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wResinRibTop02.addBox(-3.8F, -8.9F, -3.0F, 4, 3, 6, 0.0F);
        this.setRotation(wResinRibTop02, 0.0F, 0.0F, -0.045553093477052F);
        this.wBottomRoot03 = new ModelRenderer(this, 80, 0);
        this.wBottomRoot03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wBottomRoot03.addBox(-3.4F, 1.2F, -10.3F, 1, 1, 5, 0.0F);
        this.setRotation(wBottomRoot03, 0.0F, 1.3203415791337103F, 0.0F);
        this.nTopRoot01 = new ModelRenderer(this, 55, 0);
        this.nTopRoot01.setRotationPoint(0.0F, -7.2F, 0.0F);
        this.nTopRoot01.addBox(-2.0F, -0.4F, -5.1F, 4, 2, 2, 0.0F);
        this.setRotation(nTopRoot01, -0.091106186954104F, 0.0F, 0.0F);
        this.bResinRib02_2 = new ModelRenderer(this, 83, 26);
        this.bResinRib02_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bResinRib02_2.addBox(-3.0F, -0.3F, 5.5F, 6, 4, 3, 0.0F);
        this.setRotation(bResinRib02_2, -0.045553093477052F, 0.0F, 0.0F);
        this.wResinRibBottom01 = new ModelRenderer(this, 66, 44);
        this.wResinRibBottom01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wResinRibBottom01.addBox(-2.9F, 2.0F, -2.5F, 3, 3, 5, 0.0F);
        this.setRotation(wResinRibBottom01, 0.0F, 0.0F, 0.091106186954104F);
        this.nTopRoot02 = new ModelRenderer(this, 55, 4);
        this.nTopRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nTopRoot02.addBox(-1.2F, -0.4F, -8.0F, 2, 1, 3, 0.0F);
        this.setRotation(nTopRoot02, 0.0F, -0.22759093446006054F, 0.0F);
        this.webbing15 = new ModelRenderer(this, 0, 7);
        this.webbing15.mirror = true;
        this.webbing15.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing15.addBox(-2.9F, 14.5F, -10.9F, 5, 7, 0, 0.0F);
        this.sResinRibBottom01 = new ModelRenderer(this, 20, 48);
        this.sResinRibBottom01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sResinRibBottom01.addBox(-2.5F, 2.3F, -0.4F, 5, 3, 3, 0.0F);
        this.setRotation(sResinRibBottom01, 0.091106186954104F, 0.0F, 0.0F);
        this.nResinRibTop02 = new ModelRenderer(this, 0, 55);
        this.nResinRibTop02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nResinRibTop02.addBox(-3.0F, -8.1F, -3.0F, 6, 3, 4, 0.0F);
        this.setRotation(nResinRibTop02, 0.045553093477052F, 0.0F, 0.0F);
        this.sResinRibTop02 = new ModelRenderer(this, 22, 55);
        this.sResinRibTop02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sResinRibTop02.addBox(-3.0F, -8.1F, -0.4F, 6, 3, 4, 0.0F);
        this.setRotation(sResinRibTop02, -0.045553093477052F, 0.0F, 0.0F);
        this.webbing02 = new ModelRenderer(this, 99, 30);
        this.webbing02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing02.addBox(7.9F, 11.0F, -5.0F, 3, 10, 9, 0.0F);
        this.bResinRib02_1 = new ModelRenderer(this, 83, 26);
        this.bResinRib02_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bResinRib02_1.addBox(-3.0F, -0.3F, -7.8F, 6, 4, 3, 0.0F);
        this.setRotation(bResinRib02_1, 0.045553093477052F, 0.0F, 0.0F);
        this.sResinRibTop01 = new ModelRenderer(this, 20, 48);
        this.sResinRibTop01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sResinRibTop01.addBox(-2.5F, -5.3F, -0.3F, 5, 3, 3, 0.0F);
        this.setRotation(sResinRibTop01, -0.091106186954104F, 0.0F, 0.0F);
        this.webbing01 = new ModelRenderer(this, 0, 0);
        this.webbing01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing01.addBox(-1.0F, 10.0F, -10.1F, 6, 6, 0, 0.0F);
        this.setRotation(webbing01, 0.0F, -0.31869712141416456F, 0.0F);
        this.nResinRibBottom02 = new ModelRenderer(this, 0, 55);
        this.nResinRibBottom02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nResinRibBottom02.addBox(-3.0F, 5.1F, -3.2F, 6, 3, 4, 0.0F);
        this.setRotation(nResinRibBottom02, -0.045553093477052F, 0.0F, 0.0F);
        this.sTopRoot03 = new ModelRenderer(this, 55, 4);
        this.sTopRoot03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sTopRoot03.addBox(-1.0F, -0.2F, 9.0F, 2, 1, 3, 0.0F);
        this.sBottomRoot01 = new ModelRenderer(this, 55, 0);
        this.sBottomRoot01.setRotationPoint(0.0F, 6.1F, 0.0F);
        this.sBottomRoot01.addBox(-2.0F, -0.4F, 3.8F, 4, 2, 2, 0.0F);
        this.setRotation(sBottomRoot01, -0.091106186954104F, 0.0F, 0.0F);
        this.nResinRibTop01 = new ModelRenderer(this, 0, 48);
        this.nResinRibTop01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.nResinRibTop01.addBox(-2.5F, -5.2F, -2.3F, 5, 3, 3, 0.0F);
        this.setRotation(nResinRibTop01, 0.091106186954104F, 0.0F, 0.0F);
        this.bResinRib02 = new ModelRenderer(this, 66, 26);
        this.bResinRib02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bResinRib02.addBox(-2.5F, 0.0F, -4.9F, 5, 3, 3, 0.0F);
        this.setRotation(bResinRib02, 0.091106186954104F, 0.0F, 0.0F);
        this.webbing08 = new ModelRenderer(this, 96, 45);
        this.webbing08.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing08.addBox(10.4F, 11.5F, -1.3F, 0, 12, 6, 0.0F);
        this.setRotation(webbing08, 0.0F, -0.36425021489121656F, 0.0F);
        this.eTopRoot03 = new ModelRenderer(this, 80, 0);
        this.eTopRoot03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eTopRoot03.addBox(7.6F, -0.8F, 3.3F, 1, 1, 5, 0.0F);
        this.setRotation(eTopRoot03, 0.0F, 0.36425021489121656F, 0.0F);
        this.webbing04 = new ModelRenderer(this, 88, 48);
        this.webbing04.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing04.addBox(-10.9F, 8.6F, -2.8F, 0, 9, 6, 0.0F);
        this.setRotation(webbing04, 0.0F, 0.31869712141416456F, 0.0F);
        this.nBottomRoot01 = new ModelRenderer(this, 55, 0);
        this.nBottomRoot01.setRotationPoint(0.0F, 6.1F, 0.0F);
        this.nBottomRoot01.addBox(-2.0F, -0.4F, -5.3F, 4, 2, 2, 0.0F);
        this.setRotation(nBottomRoot01, 0.091106186954104F, -0.136659280431156F, 0.0F);
        this.wTopRoot01 = new ModelRenderer(this, 100, 7);
        this.wTopRoot01.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.wTopRoot01.addBox(-6.0F, -0.7F, -2.0F, 2, 2, 4, 0.0F);
        this.eResinRibBottom02 = new ModelRenderer(this, 45, 54);
        this.eResinRibBottom02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eResinRibBottom02.addBox(-0.2F, 4.3F, -3.0F, 4, 3, 6, 0.0F);
        this.setRotation(eResinRibBottom02, 0.0F, 0.0F, -0.045553093477052F);
        this.eBottomRoot02 = new ModelRenderer(this, 99, 0);
        this.eBottomRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eBottomRoot02.addBox(5.8F, 1.2F, -1.5F, 4, 1, 3, 0.0F);
        this.webbing14 = new ModelRenderer(this, 0, 0);
        this.webbing14.mirror = true;
        this.webbing14.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing14.addBox(-4.1F, 9.2F, 10.9F, 6, 6, 0, 0.0F);
        this.bResinRib03 = new ModelRenderer(this, 66, 26);
        this.bResinRib03.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bResinRib03.addBox(-2.5F, 0.0F, 2.7F, 5, 3, 3, 0.0F);
        this.setRotation(bResinRib03, -0.091106186954104F, 0.0F, 0.0F);
        this.wResinRibTop01 = new ModelRenderer(this, 66, 44);
        this.wResinRibTop01.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.wResinRibTop01.addBox(-2.9F, -6.1F, -2.5F, 3, 3, 5, 0.0F);
        this.setRotation(wResinRibTop01, 0.0F, 0.0F, -0.091106186954104F);
        this.wBottomRoot01 = new ModelRenderer(this, 100, 7);
        this.wBottomRoot01.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.wBottomRoot01.addBox(-6.0F, 0.2F, -2.0F, 2, 2, 4, 0.0F);
        this.eResinRibTop02 = new ModelRenderer(this, 45, 54);
        this.eResinRibTop02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.eResinRibTop02.addBox(-0.2F, -8.9F, -3.0F, 4, 3, 6, 0.0F);
        this.setRotation(eResinRibTop02, 0.0F, 0.0F, 0.045553093477052F);
        this.sResinRipCenter = new ModelRenderer(this, 20, 36);
        this.sResinRipCenter.setRotationPoint(0.0F, 16.0F, 7.5F);
        this.sResinRipCenter.addBox(-2.0F, -2.5F, -0.3F, 4, 5, 3, 0.0F);
        this.webbing11 = new ModelRenderer(this, 0, 7);
        this.webbing11.mirror = true;
        this.webbing11.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing11.addBox(-0.4F, 17.0F, 10.3F, 5, 7, 0, 0.0F);
        this.setRotation(webbing11, 0.0F, -1.2292353921796064F, 0.0F);
        this.webbing12 = new ModelRenderer(this, 88, 48);
        this.webbing12.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.webbing12.addBox(9.9F, 15.1F, -5.7F, 0, 9, 6, 0.0F);
        this.setRotation(webbing12, 0.0F, 0.27314402793711257F, 0.0F);
        this.sResinRibBottom02 = new ModelRenderer(this, 22, 55);
        this.sResinRibBottom02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sResinRibBottom02.addBox(-3.0F, 5.1F, -0.5F, 6, 3, 4, 0.0F);
        this.setRotation(sResinRibBottom02, 0.045553093477052F, 0.0F, 0.0F);
        this.eResinRipCenter = new ModelRenderer(this, 50, 33);
        this.eResinRipCenter.setRotationPoint(7.2F, 16.8F, 0.0F);
        this.eResinRipCenter.addBox(0.0F, -3.0F, -2.0F, 3, 5, 4, 0.0F);
        this.sBottomRoot02 = new ModelRenderer(this, 55, 9);
        this.sBottomRoot02.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sBottomRoot02.addBox(-3.0F, 0.6F, 4.9F, 2, 1, 5, 0.0F);
        this.setRotation(sBottomRoot02, 0.0F, 0.40980330836826856F, 0.0F);
        this.eTopRoot01 = new ModelRenderer(this, 100, 7);
        this.eTopRoot01.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.eTopRoot01.addBox(4.0F, -0.7F, -2.0F, 2, 2, 4, 0.0F);
        this.wResinRipCenter.addChild(this.wResinRibBottom02);
        this.wBottomRoot01.addChild(this.wBottomRoot02);
        this.sTopRoot01.addChild(this.sTopRoot02);
        this.nTopRoot01.addChild(this.nTopRoot03);
        this.eTopRoot01.addChild(this.eTopRoot02);
        this.wTopRoot01.addChild(this.wTopRoot03);
        this.wTopRoot01.addChild(this.wTopRoot04);
        this.eResinRipCenter.addChild(this.eResinRibBottom01);
        this.nBottomRoot01.addChild(this.nBottomRoot02);
        this.wTopRoot01.addChild(this.wTopRoot02);
        this.eResinRipCenter.addChild(this.eResinRibTop01);
        this.sBottomRoot01.addChild(this.sBottomRoot03);
        this.nResinRipCenter.addChild(this.nResinRibBottom01);
        this.eResinRipCenter.addChild(this.eBottomRoot01);
        this.sResinRipCenter.addChild(this.sTopRoot01);
        this.wResinRipCenter.addChild(this.wResinRibTop02);
        this.wBottomRoot01.addChild(this.wBottomRoot03);
        this.nResinRipCenter.addChild(this.nTopRoot01);
        this.bResinRibCenter.addChild(this.bResinRib02_2);
        this.wResinRipCenter.addChild(this.wResinRibBottom01);
        this.nTopRoot01.addChild(this.nTopRoot02);
        this.sResinRipCenter.addChild(this.sResinRibBottom01);
        this.nResinRipCenter.addChild(this.nResinRibTop02);
        this.sResinRipCenter.addChild(this.sResinRibTop02);
        this.bResinRibCenter.addChild(this.bResinRib02_1);
        this.sResinRipCenter.addChild(this.sResinRibTop01);
        this.nResinRipCenter.addChild(this.nResinRibBottom02);
        this.sTopRoot01.addChild(this.sTopRoot03);
        this.sResinRipCenter.addChild(this.sBottomRoot01);
        this.nResinRipCenter.addChild(this.nResinRibTop01);
        this.bResinRibCenter.addChild(this.bResinRib02);
        this.eTopRoot01.addChild(this.eTopRoot03);
        this.nResinRipCenter.addChild(this.nBottomRoot01);
        this.wResinRipCenter.addChild(this.wTopRoot01);
        this.eResinRipCenter.addChild(this.eResinRibBottom02);
        this.eBottomRoot01.addChild(this.eBottomRoot02);
        this.bResinRibCenter.addChild(this.bResinRib03);
        this.wResinRipCenter.addChild(this.wResinRibTop01);
        this.wResinRipCenter.addChild(this.wBottomRoot01);
        this.eResinRipCenter.addChild(this.eResinRibTop02);
        this.sResinRipCenter.addChild(this.sResinRibBottom02);
        this.sBottomRoot01.addChild(this.sBottomRoot02);
        this.eResinRipCenter.addChild(this.eTopRoot01);

        this.blockFaceTop = new ModelRenderer(this, 0, 0);
        this.blockFaceTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.blockFaceTop.addBox(-8.0F, 8.0F, -8.0F, 16, 0, 16, 0.0F);
        this.blockFaceSouth = new ModelRenderer(this, 0, 17);
        this.blockFaceSouth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.blockFaceSouth.addBox(-8.0F, 8.0F, 8.0F, 16, 16, 0, 0.0F);
        this.blockFaceBottom = new ModelRenderer(this, 0, 0);
        this.blockFaceBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.blockFaceBottom.addBox(-8.0F, 24.0F, -8.0F, 16, 0, 16, 0.0F);
        this.blockFaceNorth = new ModelRenderer(this, 0, 17);
        this.blockFaceNorth.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.blockFaceNorth.addBox(-8.0F, 8.0F, -8.0F, 16, 16, 0, 0.0F);
        this.blockFaceEast = new ModelRenderer(this, 0, 1);
        this.blockFaceEast.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.blockFaceEast.addBox(8.0F, 8.0F, -8.0F, 0, 16, 16, 0.0F);
        this.blockFaceWest = new ModelRenderer(this, 0, 1);
        this.blockFaceWest.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.blockFaceWest.addBox(-8.0F, 8.0F, -8.0F, 0, 16, 16, 0.0F);
    }
    
    @Override
    public void render(TileEntityHiveResin obj)
    {
        //BOTTOM
        draw(bResinRibCenter);
        
        //NORTH
        draw(nResinRipCenter);
        draw(webbing01);
        draw(webbing15);
        draw(webbing07);
        draw(webbing13);
        draw(webbing09);

        //WEST
        draw(wResinRipCenter);
        draw(webbing11);
        draw(webbing04);
        draw(webbing05);

        //SOUTH
        draw(sResinRipCenter);
        draw(webbing14);
        draw(webbing06);
        draw(webbing10);
        draw(webbing03);
        
        //EAST
        draw(eResinRipCenter);
        draw(webbing12);
        draw(webbing08);
        draw(webbing02);
    }
}
