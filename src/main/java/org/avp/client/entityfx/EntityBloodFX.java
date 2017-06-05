package org.avp.client.entityfx;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityBloodFX extends Particle
{
    private int bobTimer;
    private int color;
    private boolean glow;

    public EntityBloodFX(World worldIn, double posX, double posY, double posZ, int color, boolean glow)
    {
        super(worldIn, posX, posY, posZ);
        this.particleMaxAge = ((60 * 20) * 3) + ((this.rand.nextInt(30 * 20)));
        this.color = color;
        this.glow = glow;
        this.motionX *= 0.800000011920929D;
        this.motionY *= 0.800000011920929D;
        this.motionZ *= 0.800000011920929D;
        float particleSpread = 0.15F;
        this.motionY = (double)(this.rand.nextFloat() * 0.4F + 0.05F);
        this.motionZ = (double)(this.rand.nextFloat() * particleSpread) - (this.rand.nextFloat() * particleSpread);
        this.motionX = (double)(this.rand.nextFloat() * particleSpread) - (this.rand.nextFloat() * particleSpread);
    }


    @Override
    public void onUpdate()
    {
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;

        this.particleAlpha = 1F;
        this.particleRed = 1F;
        this.particleGreen = 0F;
        this.particleBlue = 0F;

        this.motionY -= (double) this.particleGravity;

        if (this.bobTimer-- > 0)
        {
            this.motionX *= 0.02D;
            this.motionY *= 0.02D;
            this.motionZ *= 0.02D;
            this.setParticleTextureIndex(113);
        }
        else
        {
            this.setParticleTextureIndex(112);
        }

        this.move(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;

        if (this.particleMaxAge-- <= 0)
        {
            this.setExpired();
        }

        if (this.isCollided)
        {
            this.setParticleTextureIndex(114);
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
        }

        BlockPos pos = new BlockPos(MathHelper.floor(this.posX), MathHelper.floor(this.posY), MathHelper.floor(this.posZ));
        IBlockState blockstate = this.world.getBlockState(pos);
        Material material = blockstate.getMaterial();

        if (material.isLiquid() || material.isSolid())
        {
            double d0 = (double) ((float) (MathHelper.floor(this.posY) + 1) - BlockLiquid.getLiquidHeightPercent(blockstate.getBlock().getMetaFromState(blockstate)));

            if (this.posY < d0)
            {
                this.setExpired();
            }
        }
    }
    
    @Override
    public void renderParticle(VertexBuffer buffer, Entity entity, float partialTicks, float rX, float rZ, float rYZ, float rXY, float rXZ)
    {
        float minU = (float) this.particleTextureIndexX / 16.0F;
        float maxU = minU + 0.0624375F;
        float minV = (float) this.particleTextureIndexY / 16.0F;
        float maxV = minV + 0.0624375F;
        float scale = 0.1F * this.particleScale;

        if (this.particleTexture != null)
        {
            minU = this.particleTexture.getMinU();
            maxU = this.particleTexture.getMaxU();
            minV = this.particleTexture.getMinV();
            maxV = this.particleTexture.getMaxV();
        }

        float x = (float) (this.prevPosX + (this.posX - this.prevPosX) * (double) partialTicks - interpPosX);
        float y = (float) (this.prevPosY + (this.posY - this.prevPosY) * (double) partialTicks - interpPosY);
        float z = (float) (this.prevPosZ + (this.posZ - this.prevPosZ) * (double) partialTicks - interpPosZ);

        float r = ((float)((color & 0xFF0000) >> 16)) / 255F;
        float g = ((float)((color & 0xFF00) >> 8)) / 255F;
        float b = ((float)(color & 0xFF)) / 255F;
        
        if (glow)
        {
            OpenGL.disableLightMapping();
        }
        
//        Draw.startQuads();
        Draw.vertex((double) (x - rX * scale - rXY * scale), (double) (y - rZ * scale), (double) (z - rYZ * scale - rXZ * scale), maxU, maxV).color(r, g, b, 1F).endVertex();
        Draw.vertex((double) (x - rX * scale + rXY * scale), (double) (y + rZ * scale), (double) (z - rYZ * scale + rXZ * scale), maxU, minV).color(r, g, b, 1F).endVertex();
        Draw.vertex((double) (x + rX * scale + rXY * scale), (double) (y + rZ * scale), (double) (z + rYZ * scale + rXZ * scale), minU, minV).color(r, g, b, 1F).endVertex();
        Draw.vertex((double) (x + rX * scale - rXY * scale), (double) (y - rZ * scale), (double) (z + rYZ * scale - rXZ * scale), minU, maxV).color(r, g, b, 1F).endVertex();
        Draw.tessellate();
        Draw.startQuads();
        
        if (glow)
        {
            OpenGL.enableLightMapping();
        }
    }
}
