package org.avp.client.render;

import java.util.Random;

import org.avp.common.entities.living.species.SpeciesYautja;
import org.avp.common.entities.state.CloakState;

import com.asx.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.Pos;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerYautjaCloakStaticArc implements LayerRenderer<SpeciesYautja> {

    @Override
    public void doRenderLayer(
		SpeciesYautja entitylivingbaseIn,
		float limbSwing,
		float limbSwingAmount,
		float partialTicks,
		float ageInTicks,
		float netHeadYaw,
		float headPitch,
		float scale
	) {
    	if (entitylivingbaseIn.getCloakState() != CloakState.DECLOAKING_FORCED) return;
        this.spawnArc(entitylivingbaseIn);
    }

    private void spawnArc(SpeciesYautja yautja) {
        Pos entityPos = new Pos(yautja.posX, yautja.posY, yautja.posZ);
        Random random = yautja.getRNG();
        
        float originX = (float) (entityPos.x + ((random.nextFloat() - 0.5f) / 2f));
        float originY = (float) (entityPos.y);
        float originZ = (float) (entityPos.z + ((random.nextFloat() - 0.5f) / 2f));
        
        float targetX = (float) (entityPos.x + ((random.nextFloat() - 0.5f) / 2f));
        float targetY = (float) (entityPos.y + yautja.height - (yautja.height / 16f));
        float targetZ = (float) (entityPos.z + ((random.nextFloat() - 0.5f) / 2f));
        
        int color = 0x888888FF;

        EntityFXElectricArc arc = new EntityFXElectricArc(
        		yautja.world,
        		originX, originY, originZ,
        		targetX, targetY, targetZ,
        		1,
        		0.3F + random.nextInt(2),
        		0.05F,
        		(float) (random.nextFloat() * 0.025F),
        		color
		);
        
        Game.minecraft().effectRenderer.addEffect(arc);
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}