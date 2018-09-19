package org.avp.entities;

import java.util.ArrayList;
import java.util.Random;

import org.avp.AliensVsPredator;
import org.avp.client.Sounds;

import com.arisux.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.LargeExplosion;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityWristbracer extends EntityThrowable
{
    private int preInitTicks;
    private int initTicks;
    private int postInitTicks;

    public EntityWristbracer(World world)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.ignoreFrustumCheck = true;
        this.preInitTicks = 1;
        this.initTicks = 1;
        this.postInitTicks = 1;
    }

    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.preInitTicks < this.getPreInitTicksMax())
        {
            this.preInitTicks++;
        }
        else
        {
            if (this.initTicks <= this.getInitTicksMax())
            {
                this.initTicks++;
            }
            else
            {
                this.postInitTicks++;
            }
        }

        if (this.onGround)
        {
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.world.getWorldTime() % 20 == 0)
        {
            Sounds.fxWristbracerAlarm.playSound(this, 15F, 1F);
        }

        if (this.preInitTicks >= this.getPreInitTicksMax())
        {
            float explosionWidthMax = 80F;
            float explosionHeightMax = explosionWidthMax / 2;
            float explosionWidth = (float) (this.getInitTicks() * explosionWidthMax / this.getInitTicksMax());

            double pX = this.posX + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
            double pY = this.posY + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
            double pZ = this.posZ + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);

            if (this.world.isRemote)
            {
                this.spawnElectricArc(explosionWidthMax, explosionHeightMax, explosionWidth);
            }

            if (!this.world.isRemote)
            {
                this.world.setBlockToAir(new BlockPos((int) Math.round(pX), (int) Math.round(pY), (int) Math.round(pZ)));
            }

            if (!this.world.isRemote)
            {
                if (this.getPostInitTicks() >= this.getPostInitTicksMax() * 2)
                {
                    if (AliensVsPredator.settings().areExplosionsEnabled())
                    {
                        ArrayList<Block> excludedBlocks = new ArrayList<Block>();
                        excludedBlocks.add(Blocks.BEDROCK);
                        ArrayList<Material> excludedMaterials = new ArrayList<Material>();
                        excludedMaterials.add(Material.ROCK);
                        LargeExplosion explosion = new LargeExplosion(world, explosionWidthMax, explosionHeightMax, explosionWidthMax, (int) this.posX, (int) this.posY, (int) this.posZ, 1000F, new Random().nextLong(), excludedBlocks, excludedMaterials, 0, 2);
                        explosion.start();
                    }

                    this.setDead();
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    private void spawnElectricArc(float explosionWidthMax, float explosionHeightMax, float explosionWidth2)
    {
        float explosionWidth = 10F;

        float iS = 1F;
        double sX = this.posX + (this.rand.nextDouble() * iS) - (this.rand.nextDouble() * iS);
        double sY = this.posY + (this.rand.nextDouble() * iS) - (this.rand.nextDouble() * iS);
        double sZ = this.posZ + (this.rand.nextDouble() * iS) - (this.rand.nextDouble() * iS);
        double pX = this.posX + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double pY = this.posY + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double pZ = this.posZ + (this.rand.nextDouble() * explosionWidth) - (this.rand.nextDouble() * explosionWidth);
        double arcFluctuation = 1 + (this.getInitTicks() * 40 / this.getInitTicksMax());
        double arcComplexity = (explosionWidth * 0.5 / explosionWidth);
        float arcDensity = (float) (0.01F) + (explosionWidth * 1F / explosionWidth);

        Game.minecraft().effectRenderer.addEffect(new EntityFXElectricArc(this.world, sX, sY, sZ, pX, pY, pZ, 1, arcFluctuation, arcComplexity, arcDensity, 0xFF00CCFF));
    }

    public int getInitTicksMax()
    {
        return 20 * 30;
    }

    public int getInitTicks()
    {
        return initTicks;
    }

    public int getPreInitTicksMax()
    {
        return 20 * 15;
    }

    public int getPreInitTicks()
    {
        return preInitTicks;
    }

    public int getPostInitTicksMax()
    {
        return 10;
    }

    public int getPostInitTicks()
    {
        return postInitTicks;
    }

    @Override
    protected void onImpact(RayTraceResult RayTraceResult)
    {
        ;
    }
}
