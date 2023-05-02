package org.predator.client;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.predator.client.model.entity.ModelLaserMine;
import org.predator.client.model.entity.ModelSpear;
import org.predator.client.model.entity.living.ModelPredatorHound;
import org.predator.client.model.entity.living.ModelYautja;
import org.predator.client.model.item.ModelPlasmaCannon;
import org.predator.client.model.item.ModelWristBlade;
import org.predator.client.model.tile.ModelStasisMechanism;
import org.predator.client.model.tile.skull.ModelBiomaskBerserker;
import org.predator.client.model.tile.skull.ModelBiomaskClassic;
import org.predator.client.model.tile.skull.ModelBiomaskFalconer;
import org.predator.client.model.tile.skull.ModelBiomaskTracker;

@SideOnly(Side.CLIENT)
public class PredatorResources
{
    public static final PredatorResources instance = new PredatorResources();
    private static final Models   models   = new Models();

    public Models models()
    {
        return models;
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("all")
    public static class Models
    {
        public final MapModelTexture<ModelSpear>                  SPEAR                          = new MapModelTexture(new ModelSpear(), new Texture(AVP.Properties.ID, "textures/misc/renderspear.png"));
        public final MapModelTexture<ModelWristBlade>             WRISTBLADES                    = new MapModelTexture(new ModelWristBlade(), new Texture(AVP.Properties.ID, "textures/items/models/wristblade.png"));
        public final MapModelTexture<ModelPlasmaCannon>           PLASMACANNON                   = new MapModelTexture(new ModelPlasmaCannon(), new Texture(AVP.Properties.ID, "textures/items/models/plasmacannon.png"));
        public final MapModelTexture<ModelStasisMechanism>        STASIS_MECHANISM               = new MapModelTexture(new ModelStasisMechanism(), new Texture(AVP.Properties.ID, "textures/tile/stasis-mechanism.png"));
        public final MapModelTexture<ModelStasisMechanism>        STASIS_MECHANISM_MASK          = new MapModelTexture(new ModelStasisMechanism(), new Texture(AVP.Properties.ID, "textures/tile/stasis-mechanism-mask.png"));
        public final MapModelTexture<ModelYautja>                 YAUTJA_WARRIOR                 = new MapModelTexture(new ModelYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautja.png"));
        public final MapModelTexture<ModelYautja>                 YAUTJA_BERSERKER               = new MapModelTexture(new ModelYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautja_berserker.png"));
        public final MapModelTexture<ModelLaserMine>              LASER_MINE                     = new MapModelTexture(new ModelLaserMine(), new Texture(AVP.Properties.ID, "textures/misc/proximity-mine.png"));
        public final MapModelTexture<ModelYautja>                 YAUTJA_SKULL                   = new MapModelTexture(new ModelYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautjaskull.png"));
        public final MapModelTexture<ModelBiomaskClassic>         BIOMASK_CLASSIC                = new MapModelTexture(new ModelBiomaskClassic(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja.png"));
        public final MapModelTexture<ModelBiomaskBerserker>       BIOMASK_BERSERKER              = new MapModelTexture(new ModelBiomaskBerserker(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja_berserker.png"));
        public final MapModelTexture<ModelBiomaskFalconer>        BIOMASK_FALCONER               = new MapModelTexture(new ModelBiomaskFalconer(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja_falconer.png"));
        public final MapModelTexture<ModelBiomaskTracker>         BIOMASK_TRACKER                = new MapModelTexture(new ModelBiomaskTracker(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja_tracker.png"));
        public final MapModelTexture<ModelPredatorHound>          PREDATOR_HOUND                 = new MapModelTexture(new ModelPredatorHound(), new Texture(AVP.Properties.ID, "textures/mob/predatorhound.png"));
    }

    public final Texture CELTIC1                  = new Texture(AVP.Properties.ID, "textures/armor/celtic_1.png");
    public final Texture CELTIC2                  = new Texture(AVP.Properties.ID, "textures/armor/celtic_2.png");
    public final Texture COPPER1                  = new Texture(AVP.Properties.ID, "textures/armor/copper_1.png");
    public final Texture COPPER2                  = new Texture(AVP.Properties.ID, "textures/armor/copper_2.png");
    public final Texture ALUMINUM1                = new Texture(AVP.Properties.ID, "textures/armor/aluminum_1.png");
    public final Texture ALUMINUM2                = new Texture(AVP.Properties.ID, "textures/armor/aluminum_2.png");
    public final Texture DISC                     = new Texture(AVP.Properties.ID, "textures/misc/disc.png");
    public final Texture SHURIKEN                 = new Texture(AVP.Properties.ID, "textures/misc/shuriken.png");
    public final Texture BLUR_CELTIC_HUD          = new Texture(AVP.Properties.ID, "textures/misc/celtic-helm-overlay.png");
    public final Texture GUI_WRISTBRACER          = new Texture(AVP.Properties.ID, "textures/gui/wristbracer.png");
}
