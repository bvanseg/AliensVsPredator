package org.avp.client.model.tile;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityWorkstation;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;

public class ModelWorkstation extends Model
{
    ModelRenderer stand;
    ModelRenderer standBase;
    ModelRenderer desk;
    ModelRenderer mainArm;
    ModelRenderer leftArm;
    ModelRenderer supportLeft;
    ModelRenderer supportCenter;
    ModelRenderer supportRight;
    ModelRenderer rightArm;
    ModelRenderer screenLeft;
    ModelRenderer screenCenter;
    ModelRenderer screenRight;

    public ModelWorkstation()
    {
        textureWidth = 128;
        textureHeight = 64;

        stand = new ModelRenderer(this, 42, 21);
        stand.addBox(0F, 0F, 0F, 10, 18, 4);
        stand.setRotationPoint(-5F, 4F, 2F);
        stand.setTextureSize(128, 64);
        stand.mirror = true;
        setRotation(stand, 0F, 0F, 0F);
        standBase = new ModelRenderer(this, 1, 17);
        standBase.addBox(0F, 0F, 0F, 16, 2, 4);
        standBase.setRotationPoint(-8F, 22F, 2F);
        standBase.setTextureSize(128, 64);
        standBase.mirror = true;
        setRotation(standBase, 0F, 0F, 0F);
        desk = new ModelRenderer(this, 42, 1);
        desk.addBox(0F, 0F, 0F, 16, 2, 16);
        desk.setRotationPoint(-8F, 6F, -10.6F);
        desk.setTextureSize(128, 64);
        desk.mirror = true;
        setRotation(desk, 0.1115358F, 0F, 0F);
        mainArm = new ModelRenderer(this, 1, 7);
        mainArm.addBox(0F, 0F, 0F, 4, 8, 1);
        mainArm.setRotationPoint(-2F, -4F, 5F);
        mainArm.setTextureSize(128, 64);
        mainArm.mirror = true;
        setRotation(mainArm, 0F, 0F, 0F);
        leftArm = new ModelRenderer(this, 1, 1);
        leftArm.addBox(-6F, 0F, 0F, 6, 4, 1);
        leftArm.setRotationPoint(-8F, -4F, 6F);
        leftArm.setTextureSize(128, 64);
        leftArm.mirror = true;
        setRotation(leftArm, 3.141593F, -0.3346145F, 0F);
        supportLeft = new ModelRenderer(this, 1, 1);
        supportLeft.addBox(0F, 0F, 0F, 6, 4, 1);
        supportLeft.setRotationPoint(-8F, -4F, 6F);
        supportLeft.setTextureSize(128, 64);
        supportLeft.mirror = true;
        setRotation(supportLeft, 3.141593F, 0F, 0F);
        supportCenter = new ModelRenderer(this, 16, 1);
        supportCenter.addBox(0F, 0F, 0F, 4, 4, 1);
        supportCenter.setRotationPoint(-2F, -4F, 6F);
        supportCenter.setTextureSize(128, 64);
        supportCenter.mirror = true;
        setRotation(supportCenter, 3.141593F, 0F, 0F);
        supportRight = new ModelRenderer(this, 1, 1);
        supportRight.addBox(0F, 0F, 0F, 6, 4, 1);
        supportRight.setRotationPoint(2F, -4F, 6F);
        supportRight.setTextureSize(128, 64);
        supportRight.mirror = true;
        setRotation(supportRight, 3.141593F, 0F, 0F);
        rightArm = new ModelRenderer(this, 1, 1);
        rightArm.addBox(0F, 0F, 0F, 6, 4, 1);
        rightArm.setRotationPoint(8F, -4F, 6F);
        rightArm.setTextureSize(128, 64);
        rightArm.mirror = true;
        setRotation(rightArm, 3.141593F, 0.3346075F, 0F);
        screenLeft = new ModelRenderer(this, 1, 24);
        screenLeft.addBox(-16F, 0F, 0F, 16, 9, 1);
        screenLeft.setRotationPoint(-8F, -10F, 4F);
        screenLeft.setTextureSize(128, 64);
        screenLeft.mirror = true;
        setRotation(screenLeft, 0.1115358F, -0.3346075F, 0F);
        screenCenter = new ModelRenderer(this, 1, 24);
        screenCenter.addBox(0F, 0F, 0F, 16, 9, 1);
        screenCenter.setRotationPoint(-8F, -10F, 4F);
        screenCenter.setTextureSize(128, 64);
        screenCenter.mirror = true;
        setRotation(screenCenter, 0.1115358F, 0F, 0F);
        screenRight = new ModelRenderer(this, 1, 24);
        screenRight.addBox(0F, 0F, 0F, 16, 9, 1);
        screenRight.setRotationPoint(8F, -10F, 4F);
        screenRight.setTextureSize(128, 64);
        screenRight.mirror = true;
        setRotation(screenRight, 0.111544F, 0.3346145F, 0F);
    }

    @Override
    public void render(Object obj)
    {
        TileEntityWorkstation tile = (TileEntityWorkstation) obj;

        stand.render(DEFAULT_SCALE);
        standBase.render(DEFAULT_SCALE);
        desk.render(DEFAULT_SCALE);
        mainArm.render(DEFAULT_SCALE);
        // supportLeft.render(DEFAULT_SCALE);
        supportCenter.render(DEFAULT_SCALE);
        // supportRight.render(DEFAULT_SCALE);

        screenCenter.render(DEFAULT_SCALE);

        if (tile != null)
        {
            IBlockState block = tile.getWorld().getBlockState(tile.getPos());
            IBlockState left, leftUp, right, rightUp;
            BlockPos posLeft = tile.getPos();
            BlockPos posRight = tile.getPos();

            switch (tile.rotation)
            {
                case 3:
                    /* Left is plus z, right is minus z */
                    leftUp = tile.getWorld().getBlockState(tile.getPos().add(0, 1, 1));
                    rightUp = tile.getWorld().getBlockState(tile.getPos().add(0, 1, -1));
                    left = tile.getWorld().getBlockState(posLeft = tile.getPos().add(0, 0, 1));
                    right = tile.getWorld().getBlockState(posRight = tile.getPos().add(0, 0, -1));
                    break;
                case 2:
                    /* Left is minus x, right is plus x */
                    leftUp = tile.getWorld().getBlockState(tile.getPos().add(1, 1, 0));
                    rightUp = tile.getWorld().getBlockState(tile.getPos().add(-1, 1, 0));
                    left = tile.getWorld().getBlockState(posLeft = tile.getPos().add(1, 0, 0));
                    right = tile.getWorld().getBlockState(posRight = tile.getPos().add(-1, 0, 0));
                    break;
                case 1:
                    /* Left is minus z, right is plus z */
                    leftUp = tile.getWorld().getBlockState(tile.getPos().add(0, 1, -1));
                    rightUp = tile.getWorld().getBlockState(tile.getPos().add(0, 1, 1));
                    left = tile.getWorld().getBlockState(posLeft = tile.getPos().add(0, 0, -1));
                    right = tile.getWorld().getBlockState(posRight = tile.getPos().add(0, 0, 1));
                    break;
                case 0:
                    /* Left is plus x, right is minus x, case 4 */
                    leftUp = tile.getWorld().getBlockState(tile.getPos().add(-1, 1, 0));
                    rightUp = tile.getWorld().getBlockState(tile.getPos().add(1, 1, 0));
                    left = tile.getWorld().getBlockState(posLeft = tile.getPos().add(-1, 0, 0));
                    right = tile.getWorld().getBlockState(posRight = tile.getPos().add(1, 0, 0));
                    break;
                default:
                    left = block;
                    right = block;
                    leftUp = block;
                    rightUp = block;
                    break;
            }

            if (left != AliensVsPredator.blocks().terminal && leftUp == Blocks.AIR && left.getCollisionBoundingBox(Game.minecraft().world, posLeft).maxY <= 1.5)
            {
                // leftArm.render(DEFAULT_SCALE);
                screenLeft.render(DEFAULT_SCALE);
            }

            if (right != AliensVsPredator.blocks().terminal && rightUp == Blocks.AIR && right.getCollisionBoundingBox(Game.minecraft().world, posRight).maxY <= 1.5)
            {
                // rightArm.render(DEFAULT_SCALE);
                screenRight.render(DEFAULT_SCALE);
            }
        }
        else
        {
            leftArm.render(DEFAULT_SCALE);
            screenLeft.render(DEFAULT_SCALE);
            rightArm.render(DEFAULT_SCALE);
            screenRight.render(DEFAULT_SCALE);
        }
    }
}
