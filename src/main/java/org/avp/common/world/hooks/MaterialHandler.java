package org.avp.common.world.hooks;

import org.avp.AVP;
import org.avp.common.api.blocks.material.IMaterialPhysics;
import org.avp.common.api.blocks.material.IMaterialRenderer;

import com.asx.mdx.lib.util.Game;

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

public class MaterialHandler
{
    public static final MaterialHandler instance = new MaterialHandler();

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void render(RenderGameOverlayEvent event)
    {
        if (Game.minecraft().world != null)
        {
            Material materialInside = getMaterialInside(Game.minecraft().player);

            if (materialInside != null && materialInside instanceof IMaterialPhysics)
            {
                IMaterialPhysics physics = (IMaterialPhysics) materialInside;
                IMaterialRenderer renderer = physics.getMaterialRenderer();

                if (renderer != null)
                {
                    if (event.getType() == ElementType.HELMET)
                    {
                        if (Game.minecraft().player.isInsideOfMaterial(materialInside))
                        {
                            renderer.renderMaterialOverlay(materialInside);
                        }
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public void update(LivingUpdateEvent event)
    {
        Entity entity = event.getEntity();

        if (!entity.isDead)
        {
            try
            {
                Material material = getMaterialInside(entity);

                if (material instanceof IMaterialPhysics)
                {
                    IMaterialPhysics physics = (IMaterialPhysics) material;
                    Vec3d motion = MaterialHandler.instance.handleMaterialAcceleration(entity, material, physics);

                    if (motion != null)
                    {
                        physics.onCollision(entity);

                        if (entity.isPushedByWater() || physics.ignoresPushableCheck())
                        {
                            motion = motion.normalize();
                            physics.handleMovement(entity);
                            physics.handleForce(entity, motion);
                        }
                    }
                }
            }
            catch (Exception e)
            {
            	AVP.log().warn("Error handling fluid physics update for entity: " + e);
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void fogRenderEvent(RenderFogEvent event)
    {
        if (Game.minecraft().world != null && !Game.minecraft().isGamePaused())
        {
            Material material = getMaterialInside(Game.minecraft().player);

            if (material instanceof IMaterialPhysics && Game.minecraft().player.isInsideOfMaterial(material))
            {
                IMaterialPhysics physics = (IMaterialPhysics) material;
                IMaterialRenderer renderer = physics.getMaterialRenderer();

                if (renderer != null)
                {
                    renderer.renderFog(material);
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void fogColorUpdate(FogColors event)
    {
        if (Game.minecraft().world != null && !Game.minecraft().isGamePaused())
        {
            Material material = getMaterialInside(Game.minecraft().player);

            if (material instanceof IMaterialPhysics)
            {
                if (Game.minecraft().player.isInsideOfMaterial(material))
                {
                    IMaterialPhysics physics = (IMaterialPhysics) material;
                    IMaterialRenderer renderer = physics.getMaterialRenderer();

                    if (renderer != null)
                    {
                        Vec3d fogColor = renderer.getFogColor();

                        event.setRed((float) fogColor.x);
                        event.setGreen((float) fogColor.y);
                        event.setBlue((float) fogColor.z);
                    }
                }
            }
        }
    }
    
    public static Material getMaterialInside(Entity entity)
    {
        AxisAlignedBB box = entity.getEntityBoundingBox();
        int minX = MathHelper.floor(box.minX);
        int maxX = MathHelper.floor(box.maxX + 1.0D);
        int minY = MathHelper.floor(box.minY);
        int maxY = MathHelper.floor(box.maxY + 1.0D);
        int minZ = MathHelper.floor(box.minZ);
        int maxZ = MathHelper.floor(box.maxZ + 1.0D);

        if (!entity.world.isBlockLoaded(entity.getPosition()))
        {
            return null;
        }
        else
        {
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
        }

        return null;
    }

    public Vec3d handleMaterialAcceleration(Entity entity, Material material, IMaterialPhysics physics)
    {
        AxisAlignedBB box = entity.getEntityBoundingBox().expand(0.0D, -0.4D, 0.0D).contract(0.001D, 0.001D, 0.001D);

        int minX = MathHelper.floor(box.minX);
        int maxX = MathHelper.floor(box.maxX + 1.0D);
        int minY = MathHelper.floor(box.minY);
        int maxY = MathHelper.floor(box.maxY + 1.0D);
        int minZ = MathHelper.floor(box.minZ);
        int maxZ = MathHelper.floor(box.maxZ + 1.0D);

        if (!entity.world.isBlockLoaded(entity.getPosition()))
        {
            return null;
        }
        else
        {
            Vec3d motion = null;

            for (int x = minX; x < maxX; ++x)
            {
                for (int y = minY; y < maxY; ++y)
                {
                    for (int z = minZ; z < maxZ; ++z)
                    {
                        BlockPos pos = new BlockPos(x, y, z);
                        IBlockState block = entity.world.getBlockState(pos);

                        if (block.getMaterial() == material)
                        {
                            double lhp = y + 1 - BlockLiquid.getLiquidHeightPercent(block.getBlock().getMetaFromState(block));

                            if (maxY >= lhp)
                            {
                                block.getBlock().modifyAcceleration(entity.world, pos, entity, motion = new Vec3d(0.0D, 0.0D, 0.0D));
                            }
                        }
                    }
                }
            }

            return motion;
        }
    }
}
