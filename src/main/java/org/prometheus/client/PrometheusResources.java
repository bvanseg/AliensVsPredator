package org.prometheus.client;


import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.prometheus.client.model.entity.living.*;

@SideOnly(Side.CLIENT)
public class PrometheusResources {

    private PrometheusResources() {}

    @SideOnly(Side.CLIENT)
    public static class Models {

        private Models() {}

        public static final MapModelTexture<ModelEngineer> ENGINEER = new MapModelTexture<>(new ModelEngineer(), new Texture(AVP.Properties.ID, "textures/mob/engineer_bio.png"));
        public static final MapModelTexture<ModelEngineer> SPACE_JOCKEY = new MapModelTexture<>(new ModelEngineer(), new Texture(AVP.Properties.ID, "textures/mob/engineer.png"));
        public static final MapModelTexture<ModelHammerpede> HAMMERPEDE = new MapModelTexture<>(new ModelHammerpede(), new Texture(AVP.Properties.ID, "textures/mob/hammerpede.png"));
        public static final MapModelTexture<ModelTrilobite> TRILOBITE = new MapModelTexture<>(new ModelTrilobite(), new Texture(AVP.Properties.ID, "textures/mob/trilobite.png"));
        public static final MapModelTexture<ModelDeaconShark> DEACON_SHARK = new MapModelTexture<>(new ModelDeaconShark(), new Texture(AVP.Properties.ID, "textures/mob/deacon_shark.png"));
        public static final MapModelTexture<ModelDeacon> DEACON = new MapModelTexture<>(new ModelDeacon(), new Texture(AVP.Properties.ID, "textures/mob/deacon.png"));
        public static final MapModelTexture<ModelDeaconAdult> DEACON_ADULT = new MapModelTexture<>(new ModelDeaconAdult(), new Texture(AVP.Properties.ID, "textures/mob/deacon_adult.png"));
        public static final MapModelTexture<ModelGooMutant> GOO_MUTANT = new MapModelTexture<>(new ModelGooMutant(), new Texture(AVP.Properties.ID, "textures/mob/goomutant.png"));
        public static final MapModelTexture<ModelOctohugger> OCTOHUGGER = new MapModelTexture<>(new ModelOctohugger(), new Texture(AVP.Properties.ID, "textures/mob/octohugger.png"));
        public static final MapModelTexture<ModelBelugaburster> BELUGABURSTER = new MapModelTexture<>(new ModelBelugaburster(), new Texture(AVP.Properties.ID, "textures/mob/belugaburster.png"));
        public static final MapModelTexture<ModelBelugamorph> BELUGAMORPH = new MapModelTexture<>(new ModelBelugamorph(), new Texture(AVP.Properties.ID, "textures/mob/belugamorph.png"));
        public static final MapModelTexture<ModelBabyhead> BABYHEAD = new MapModelTexture<>(new ModelBabyhead(), new Texture(AVP.Properties.ID, "textures/mob/babyhead.png"));
        public static final MapModelTexture<ModelMutantYautja> MUTANT_YAUTJA = new MapModelTexture<>(new ModelMutantYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautjamutant.png"));
        public static final MapModelTexture<ModelUrsuidae> URSUIDAE = new MapModelTexture<>(new ModelUrsuidae(), new Texture(AVP.Properties.ID, "textures/mob/vardaboar.png"));
        public static final MapModelTexture<ModelVardaMonkey> VARDA_MONKEY = new MapModelTexture<>(new ModelVardaMonkey(), new Texture(AVP.Properties.ID, "textures/mob/vardamonkey.png"));
        public static final MapModelTexture<ModelUltramorph> ULTRAMORPH = new MapModelTexture<>(new ModelUltramorph(), new Texture(AVP.Properties.ID, "textures/mob/ultramorph.png"));
    }

    public static final Texture SKY_VARDA_CLOUDS = new Texture(AVP.Properties.ID, "textures/misc/varda-clouds.png");
    public static final Texture SKY_SILICA = new Texture(AVP.Properties.ID, "textures/misc/silica.png");
    public static final Texture SKY_CALPAMOS = new Texture(AVP.Properties.ID, "textures/misc/calpamos.png");
    public static final Texture SKY_VARDA = new Texture(AVP.Properties.ID, "textures/misc/varda.png");
    public static final Texture BLACKGOO = new Texture(AVP.Properties.ID, "textures/blocks/blackgoo.png");
}
