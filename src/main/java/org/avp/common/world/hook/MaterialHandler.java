package org.avp.common.world.hook;

import com.asx.mdx.client.ClientGame;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.EntityViewRenderEvent.FogColors;
import net.minecraftforge.client.event.EntityViewRenderEvent.RenderFogEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.common.api.blocks.material.MaterialPhysics;
import org.avp.common.api.blocks.material.MaterialRenderer;

public class MaterialHandler
{
    public static final MaterialHandler instance = new MaterialHandler();

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void render(RenderGameOverlayEvent event)
    {
        if (ClientGame.instance.minecraft().world == null) return;

        Material materialInside = getMaterialInside(ClientGame.instance.minecraft().player);

        if (materialInside == null) return;
        if (!(materialInside instanceof MaterialPhysics)) return;

        MaterialPhysics physics = (MaterialPhysics) materialInside;
        MaterialRenderer renderer = physics.getMaterialRenderer();

        if (renderer == null) return;
        if (event.getType() != ElementType.HELMET) return;
        if (!ClientGame.instance.minecraft().player.isInsideOfMaterial(materialInside)) return;

        renderer.renderMaterialOverlay(materialInside);
    }
    
    @SubscribeEvent
    public void update(LivingUpdateEvent event)
    {
        Entity entity = event.getEntity();

        if (entity.isDead) return;

        try
        {
            Material material = getMaterialInside(entity);

            if (!(material instanceof MaterialPhysics)) return;

            MaterialPhysics physics = (MaterialPhysics) material;
            Vec3d motion = MaterialHandler.instance.handleMaterialAcceleration(entity, material);

            if (motion == null) return;

            physics.onCollision(entity);

            if (entity.isPushedByWater() || physics.ignoresPushableCheck())
            {
                motion = motion.normalize();
                physics.handleMovement(entity);
                physics.handleForce(entity, motion);
            }
        }
        catch (Exception e)
        {
            AVP.log().warn("Error handling fluid physics update for entity: " + e);
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void fogRenderEvent(RenderFogEvent event)
    {
        if (ClientGame.instance.minecraft().world == null) return;
        if (ClientGame.instance.minecraft().isGamePaused()) return;

        Material material = getMaterialInside(ClientGame.instance.minecraft().player);

        if (!(material instanceof MaterialPhysics)) return;
        if (!ClientGame.instance.minecraft().player.isInsideOfMaterial(material)) return;

        MaterialPhysics physics = (MaterialPhysics) material;
        MaterialRenderer renderer = physics.getMaterialRenderer();

        if (renderer == null) return;

        renderer.renderFog(material);
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void fogColorUpdate(FogColors event)
    {
        if (ClientGame.instance.minecraft().world == null) return;
        if (ClientGame.instance.minecraft().isGamePaused()) return;

        Material material = getMaterialInside(ClientGame.instance.minecraft().player);

        if (!(material instanceof MaterialPhysics)) return;
        if (!ClientGame.instance.minecraft().player.isInsideOfMaterial(material)) return;

        MaterialPhysics physics = (MaterialPhysics) material;
        MaterialRenderer renderer = physics.getMaterialRenderer();

        if (renderer == null) return;

        Vec3d fogColor = renderer.getFogColor();

        event.setRed((float) fogColor.x);
        event.setGreen((float) fogColor.y);
        event.setBlue((float) fogColor.z);
    }
    
    private Material getMaterialInside(Entity entity)
    {
        AxisAlignedBB box = entity.getEntityBoundingBox();
        int minX = MathHelper.floor(box.minX);
        int maxX = MathHelper.floor(box.maxX + 1.0D);
        int minY = MathHelper.floor(box.minY);
        int maxY = MathHelper.floor(box.maxY + 1.0D);
        int minZ = MathHelper.floor(box.minZ);
        int maxZ = MathHelper.floor(box.maxZ + 1.0D);

        if (!entity.world.isBlockLoaded(entity.getPosition())) return null;

        for (int x = minX; x < maxX; ++x)
        {
            for (int y = minY; y < maxY; ++y)
            {
                for (int z = minZ; z < maxZ; ++z)
                {
                    IBlockState block = entity.world.getBlockState(new BlockPos(x, y, z));

                    if (block != null)
                    {
                        return block.getMaterial();
                    }
                }
            }
        }

        return null;
    }

    private Vec3d handleMaterialAcceleration(Entity entity, Material material)
    {
        AxisAlignedBB box = entity.getEntityBoundingBox().expand(0.0D, -0.4D, 0.0D).contract(0.001D, 0.001D, 0.001D);

        int minX = MathHelper.floor(box.minX);
        int maxX = MathHelper.floor(box.maxX + 1.0D);
        int minY = MathHelper.floor(box.minY);
        int maxY = MathHelper.floor(box.maxY + 1.0D);
        int minZ = MathHelper.floor(box.minZ);
        int maxZ = MathHelper.floor(box.maxZ + 1.0D);

        if (!entity.world.isBlockLoaded(entity.getPosition())) return null;

        Vec3d motion = null;

        for (int x = minX; x < maxX; ++x)
        {
            for (int y = minY; y < maxY; ++y)
            {
                for (int z = minZ; z < maxZ; ++z)
                {
                    BlockPos pos = new BlockPos(x, y, z);
                    IBlockState block = entity.world.getBlockState(pos);

                    if (block.getMaterial() != material) continue;

                    double lhp = y + 1 - BlockLiquid.getLiquidHeightPercent(block.getBlock().getMetaFromState(block));

                    if (maxY >= lhp)
                    {
                        motion = Vec3d.ZERO;
                        block.getBlock().modifyAcceleration(entity.world, pos, entity, motion);
                    }
                }
            }
        }

        return motion;
    }
}
