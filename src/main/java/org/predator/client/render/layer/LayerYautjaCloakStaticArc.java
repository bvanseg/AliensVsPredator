package org.predator.client.render.layer;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.entity.fx.EntityFXElectricArc;
import com.asx.mdx.common.minecraft.Pos;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.predator.common.entity.living.SpeciesYautja;
import org.predator.common.entity.state.CloakState;

import java.util.Random;

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
    	if (entitylivingbaseIn.cloakState.get() != CloakState.DECLOAKING_FORCED) return;
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
        
        ClientGame.instance.minecraft().effectRenderer.addEffect(arc);
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}