package org.alien.client;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.model.entity.living.*;
import org.alien.client.model.tile.ModelHiveResin;
import org.alien.client.model.tile.skull.ModelAethonHead;
import org.alien.client.model.tile.skull.ModelGigerAlienHead;
import org.alien.client.model.tile.skull.ModelQueenSkull;
import org.avp.AVP;

@SideOnly(Side.CLIENT)
public class AlienResources {

    private AlienResources() {}

    @SideOnly(Side.CLIENT)
    public static class Models {

        private Models() {}

        public static final MapModelTexture<ModelAethon> AETHON = new MapModelTexture<>(new ModelAethon(), new Texture(AVP.Properties.ID, "textures/mob/aethon.png"));
        public static final MapModelTexture<ModelRunnerDrone> RUNNER_DRONE = new MapModelTexture<>(new ModelRunnerDrone(), new Texture(AVP.Properties.ID, "textures/mob/runner_drone.png"));
        public static final MapModelTexture<ModelRunnerWarrior> RUNNER_WARRIOR = new MapModelTexture<>(new ModelRunnerWarrior(), new Texture(AVP.Properties.ID, "textures/mob/runner_warrior.png"));
        public static final MapModelTexture<ModelDrone> DRONE_BASIC = new MapModelTexture<>(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_basic.png"));
        public static final MapModelTexture<ModelDrone> DRONE_ADVANCED = new MapModelTexture<>(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_advanced.png"));
        public static final MapModelTexture<ModelChestburster> CHESTBUSTER = new MapModelTexture<>(new ModelChestburster(), new Texture(AVP.Properties.ID, "textures/mob/chestburster.png"));
        public static final MapModelTexture<ModelChestbursterPredalien> CHESTBUSTER_PREDALIEN = new MapModelTexture<>(new ModelChestbursterPredalien(), new Texture(AVP.Properties.ID, "textures/mob/chestburster_predalien.png"));
        public static final MapModelTexture<ModelChestbursterQueen> CHESTBUSTER_QUEEN = new MapModelTexture<>(new ModelChestbursterQueen(), new Texture(AVP.Properties.ID, "textures/mob/chestburster_queen.png"));
        public static final MapModelTexture<ModelChestbursterRunner> CHESTBUSTER_RUNNER = new MapModelTexture<>(new ModelChestbursterRunner(), new Texture(AVP.Properties.ID, "textures/mob/chestburster_runner.png"));
        public static final MapModelTexture<ModelFacehugger> FACEHUGGER = new MapModelTexture<>(new ModelFacehugger(), new Texture(AVP.Properties.ID, "textures/mob/facehugger.png"));
        public static final MapModelTexture<ModelRoyalFacehugger> ROYALFACEHUGGER = new MapModelTexture<>(new ModelRoyalFacehugger(), new Texture(AVP.Properties.ID, "textures/mob/royalfacehugger.png"));
        public static final MapModelTexture<ModelOvamorph> OVAMORPH = new MapModelTexture<>(new ModelOvamorph(), new Texture(AVP.Properties.ID, "textures/mob/alienegg.png"));
        public static final MapModelTexture<ModelOvamorph> OVAMORPH_JACKO = new MapModelTexture<>(new ModelOvamorph(), new Texture(AVP.Properties.ID, "textures/mob/alienegg_jack.png"));
        public static final MapModelTexture<ModelOvamorphGiger> OVAMORPH_GIGER = new MapModelTexture<>(new ModelOvamorphGiger(), new Texture(AVP.Properties.ID, "textures/mob/gigeregg.png"));
        public static final MapModelTexture<ModelPredalien> PREDALIEN = new MapModelTexture<>(new ModelPredalien(), new Texture(AVP.Properties.ID, "textures/mob/predalien.png"));
        public static final MapModelTexture<ModelPraetorian> PRAETORIAN = new MapModelTexture<>(new ModelPraetorian(), new Texture(AVP.Properties.ID, "textures/mob/praetorian.png"));
        public static final MapModelTexture<ModelWarrior> WARRIOR = new MapModelTexture<>(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/warrior.png"));
        public static final MapModelTexture<ModelWarrior> WARRIOR_BLOOD = new MapModelTexture<>(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/warrior_blood.png"));
        public static final MapModelTexture<ModelDrone> DRONE_BASIC_BLOOD = new MapModelTexture<>(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_basic_blood.png"));
        public static final MapModelTexture<ModelDrone> DRONE_ADVANCED_BLOOD = new MapModelTexture<>(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_advanced_blood.png"));
        public static final MapModelTexture<ModelNauticomorph> NAUTICOMORPH_XENOMORPH = new MapModelTexture<>(new ModelNauticomorph(), new Texture(AVP.Properties.ID, "textures/mob/nauticomorph.png"));
        public static final MapModelTexture<ModelNauticomorph> NAUTICOMORPH_XENOMORPH_MASK = new MapModelTexture<>(new ModelNauticomorph(), new Texture(AVP.Properties.ID, "textures/mob/nauticomorph_glow.png"));
        public static final MapModelTexture<ModelMatriarch> MATRIARCH = new MapModelTexture<>(new ModelMatriarch(), new Texture(AVP.Properties.ID, "textures/mob/matriarch.png"));
        public static final MapModelTexture<ModelMatriarch> MATRIARCH_MASK = new MapModelTexture<>(new ModelMatriarch(), new Texture(AVP.Properties.ID, "textures/mob/matriarch_mask.png"));
        public static final MapModelTexture<ModelSpitter> SPITTER = new MapModelTexture<>(new ModelSpitter(), new Texture(AVP.Properties.ID, "textures/mob/spitter.png"));
        public static final MapModelTexture<ModelSpitter> SPITTER_MASK = new MapModelTexture<>(new ModelSpitter(), new Texture(AVP.Properties.ID, "textures/mob/spitter_glow.png"));
        public static final MapModelTexture<ModelCrusher> CRUSHER = new MapModelTexture<>(new ModelCrusher(), new Texture(AVP.Properties.ID, "textures/mob/crusher.png"));
        public static final MapModelTexture<ModelCrusherQuad> CRUSHER_QUAD = new MapModelTexture<>(new ModelCrusherQuad(), new Texture(AVP.Properties.ID, "textures/mob/crusher_quad.png"));
        public static final MapModelTexture<ModelHiveResin> HIVE_RESIN = new MapModelTexture<>(new ModelHiveResin(), new Texture(AVP.Properties.ID, "textures/tile/hive-resin.png"));
        public static final MapModelTexture<ModelWarrior> DRONE_SKULL = new MapModelTexture<>(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/xenomorphskullgiger.png"));
        public static final MapModelTexture<ModelWarrior> WARRIOR_SKULL = new MapModelTexture<>(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/xenomorphskullwarrior.png"));
        public static final MapModelTexture<ModelQueenSkull> MATRIARCH_SKULL = new MapModelTexture<>(new ModelQueenSkull(), new Texture(AVP.Properties.ID, "textures/tile/skulls/queenskull.png"));
        public static final MapModelTexture<ModelAethonHead> HEAD_AETHON = new MapModelTexture<>(new ModelAethonHead(), new Texture(AVP.Properties.ID, "textures/mob/aethon/aethon.png"));
        public static final MapModelTexture<ModelGigerAlienHead> GIGER_ALIEN_HEAD = new MapModelTexture<>(new ModelGigerAlienHead(), new Texture(AVP.Properties.ID, "textures/mob/gigeralien.png"));
        public static final MapModelTexture<ModelBatXenomorph> BAT_XENO = new MapModelTexture<>(new ModelBatXenomorph(), new Texture(AVP.Properties.ID, "textures/mob/batxeno.png"));
        public static final MapModelTexture<ModelBoiler> BOILER = new MapModelTexture<>(new ModelBoiler(), new Texture(AVP.Properties.ID, "textures/mob/boiler.png"));
        public static final MapModelTexture<ModelBoiler> BOILER_MASK = new MapModelTexture<>(new ModelBoiler(), new Texture(AVP.Properties.ID, "textures/mob/boiler_glow.png"));
        public static final MapModelTexture<ModelDracoburster> DRACOBURSTER = new MapModelTexture<>(new ModelDracoburster(), new Texture(AVP.Properties.ID, "textures/mob/dracoburster.png"));
        public static final MapModelTexture<ModelDracomorph> DRACOMORPH = new MapModelTexture<>(new ModelDracomorph(), new Texture(AVP.Properties.ID, "textures/mob/dracomorph.png"));
        public static final MapModelTexture<ModelDracoOvamorph> DRACO_OVAMORPH = new MapModelTexture<>(new ModelDracoOvamorph(), new Texture(AVP.Properties.ID, "textures/mob/dracomorphegg.png"));
        public static final MapModelTexture<ModelMyceliomorph> MYCELIOMORPH = new MapModelTexture<>(new ModelMyceliomorph(), new Texture(AVP.Properties.ID, "textures/mob/myceliomorph.png"));
        public static final MapModelTexture<ModelMyceliomorph> MYCELIOMORPH_MASK = new MapModelTexture<>(new ModelMyceliomorph(), new Texture(AVP.Properties.ID, "textures/mob/myceliomorph_glow.png"));
        public static final MapModelTexture<ModelPantheramorph> PANTHERAMORPH = new MapModelTexture<>(new ModelPantheramorph(), new Texture(AVP.Properties.ID, "textures/mob/pantheramorph.png"));
    }

    public static final Texture SKY_SILICA = new Texture(AVP.Properties.ID, "textures/misc/silica.png");
    public static final Texture SKY_CALPAMOS = new Texture(AVP.Properties.ID, "textures/misc/calpamos.png");
    public static final Texture SKY_ACHERON = new Texture(AVP.Properties.ID, "textures/misc/acheron.png");
    public static final Texture XENO1 = new Texture(AVP.Properties.ID, "textures/armor/xeno_1.png");
    public static final Texture XENO2 = new Texture(AVP.Properties.ID, "textures/armor/xeno_2.png");
    public static final Texture ACID_POOL = new Texture(AVP.Properties.ID, "textures/misc/acidpool.png");
    public static final Texture BLUR_FACEHUGGER = new Texture(AVP.Properties.ID, "textures/misc/facehugger.png");
    public static final Texture BLUR_CHESTBURSTER_EMERGE = new Texture(AVP.Properties.ID, "textures/misc/chestburster-emerge-overlay.png");
    public static final Texture QUEEN_BOSS_BAR = new Texture(AVP.Properties.ID, "textures/misc/queenbossbar.png");
    public static final Texture MIST = new Texture(AVP.Properties.ID, "textures/blocks/mist.still.png");
}
