package org.alien.client;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.model.entity.ModelSporePod;
import org.alien.client.model.entity.living.*;
import org.alien.client.model.tile.ModelHiveResin;
import org.alien.client.model.tile.plant.ModelGroundFern;
import org.alien.client.model.tile.plant.ModelTreeFern;
import org.alien.client.model.tile.skull.*;
import org.avp.AVP;

@SideOnly(Side.CLIENT)
public class AlienResources
{
    public static final AlienResources instance = new AlienResources();
    private static final Models   models   = new Models();

    public Models models()
    {
        return models;
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("all")
    public static class Models
    {
        public final MapModelTexture<ModelAethon>                 AETHON                         = new MapModelTexture(new ModelAethon(), new Texture(AVP.Properties.ID, "textures/mob/aethon.png"));
        public final MapModelTexture<ModelRunnerDrone>            RUNNER_DRONE                   = new MapModelTexture(new ModelRunnerDrone(), new Texture(AVP.Properties.ID, "textures/mob/runner_drone.png"));
        public final MapModelTexture<ModelRunnerWarrior>          RUNNER_WARRIOR                 = new MapModelTexture(new ModelRunnerWarrior(), new Texture(AVP.Properties.ID, "textures/mob/runner_warrior.png"));
        public final MapModelTexture<ModelEngineer>               ENGINEER                       = new MapModelTexture(new ModelEngineer(), new Texture(AVP.Properties.ID, "textures/mob/engineer_bio.png"));
        public final MapModelTexture<ModelEngineer>               SPACE_JOCKEY                   = new MapModelTexture(new ModelEngineer(), new Texture(AVP.Properties.ID, "textures/mob/engineer.png"));
        public final MapModelTexture<ModelDrone>                  DRONE_BASIC                    = new MapModelTexture(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_basic.png"));
        public final MapModelTexture<ModelDrone>                  DRONE_ADVANCED                 = new MapModelTexture(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_advanced.png"));
        public final MapModelTexture<ModelChestburster>           CHESTBUSTER                    = new MapModelTexture(new ModelChestburster(), new Texture(AVP.Properties.ID, "textures/mob/chestburster.png"));
        public final MapModelTexture<ModelChestbursterPredalien>  CHESTBUSTER_PREDALIEN          = new MapModelTexture(new ModelChestbursterPredalien(), new Texture(AVP.Properties.ID, "textures/mob/chestburster_predalien.png"));
        public final MapModelTexture<ModelChestbursterQueen>      CHESTBUSTER_QUEEN              = new MapModelTexture(new ModelChestbursterQueen(), new Texture(AVP.Properties.ID, "textures/mob/chestburster_queen.png"));
        public final MapModelTexture<ModelChestbursterRunner>     CHESTBUSTER_RUNNER             = new MapModelTexture(new ModelChestbursterRunner(), new Texture(AVP.Properties.ID, "textures/mob/chestburster_runner.png"));
        public final MapModelTexture<ModelFacehugger>             FACEHUGGER                     = new MapModelTexture(new ModelFacehugger(), new Texture(AVP.Properties.ID, "textures/mob/facehugger.png"));
        public final MapModelTexture<ModelRoyalFacehugger>        ROYALFACEHUGGER                = new MapModelTexture(new ModelRoyalFacehugger(), new Texture(AVP.Properties.ID, "textures/mob/royalfacehugger.png"));
        public final MapModelTexture<ModelOvamorph>               OVAMORPH                       = new MapModelTexture(new ModelOvamorph(), new Texture(AVP.Properties.ID, "textures/mob/alienegg.png"));
        public final MapModelTexture<ModelOvamorph>               OVAMORPH_JACKO                 = new MapModelTexture(new ModelOvamorph(), new Texture(AVP.Properties.ID, "textures/mob/alienegg_jack.png"));
        public final MapModelTexture<ModelOvamorphGiger>          OVAMORPH_GIGER                 = new MapModelTexture(new ModelOvamorphGiger(), new Texture(AVP.Properties.ID, "textures/mob/gigeregg.png"));
        public final MapModelTexture<ModelPredalien>              PREDALIEN                      = new MapModelTexture(new ModelPredalien(), new Texture(AVP.Properties.ID, "textures/mob/predalien.png"));
        public final MapModelTexture<ModelPraetorian>             PRAETORIAN                     = new MapModelTexture(new ModelPraetorian(), new Texture(AVP.Properties.ID, "textures/mob/praetorian.png"));
        public final MapModelTexture<ModelWarrior>                WARRIOR                        = new MapModelTexture(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/warrior.png"));
        public final MapModelTexture<ModelWarrior>                WARRIOR_BLOOD                  = new MapModelTexture(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/warrior_blood.png"));
        public final MapModelTexture<ModelDrone>                  DRONE_BASIC_BLOOD              = new MapModelTexture(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_basic_blood.png"));
        public final MapModelTexture<ModelDrone>                  DRONE_ADVANCED_BLOOD           = new MapModelTexture(new ModelDrone(), new Texture(AVP.Properties.ID, "textures/mob/drone_advanced_blood.png"));
        public final MapModelTexture<ModelHammerpede>             HAMMERPEDE                     = new MapModelTexture(new ModelHammerpede(), new Texture(AVP.Properties.ID, "textures/mob/hammerpede.png"));
        public final MapModelTexture<ModelTrilobite>              TRILOBITE                      = new MapModelTexture(new ModelTrilobite(), new Texture(AVP.Properties.ID, "textures/mob/trilobite.png"));
        public final MapModelTexture<ModelDeaconShark>            DEACON_SHARK                   = new MapModelTexture(new ModelDeaconShark(), new Texture(AVP.Properties.ID, "textures/mob/deacon_shark.png"));
        public final MapModelTexture<ModelDeacon>                 DEACON                         = new MapModelTexture(new ModelDeacon(), new Texture(AVP.Properties.ID, "textures/mob/deacon.png"));
        public final MapModelTexture<ModelDeaconAdult>            DEACON_ADULT                   = new MapModelTexture(new ModelDeaconAdult(), new Texture(AVP.Properties.ID, "textures/mob/deacon_adult.png"));
        public final MapModelTexture<ModelNauticomorph>           NAUTICOMORPH_XENOMORPH         = new MapModelTexture(new ModelNauticomorph(), new Texture(AVP.Properties.ID, "textures/mob/nauticomorph.png"));
        public final MapModelTexture<ModelNauticomorph>           NAUTICOMORPH_XENOMORPH_MASK    = new MapModelTexture(new ModelNauticomorph(), new Texture(AVP.Properties.ID, "textures/mob/nauticomorph_glow.png"));
        public final MapModelTexture<ModelMatriarch>              MATRIARCH                      = new MapModelTexture(new ModelMatriarch(), new Texture(AVP.Properties.ID, "textures/mob/matriarch.png"));
        public final MapModelTexture<ModelMatriarch>              MATRIARCH_MASK                 = new MapModelTexture(new ModelMatriarch(), new Texture(AVP.Properties.ID, "textures/mob/matriarch_mask.png"));
        public final MapModelTexture<ModelSpitter>                SPITTER                        = new MapModelTexture(new ModelSpitter(), new Texture(AVP.Properties.ID, "textures/mob/spitter.png"));
        public final MapModelTexture<ModelSpitter>                SPITTER_MASK                   = new MapModelTexture(new ModelSpitter(), new Texture(AVP.Properties.ID, "textures/mob/spitter_glow.png"));
        public final MapModelTexture<ModelCrusher>                CRUSHER                        = new MapModelTexture(new ModelCrusher(), new Texture(AVP.Properties.ID, "textures/mob/crusher.png"));
        public final MapModelTexture<ModelCrusherQuad>            CRUSHER_QUAD                   = new MapModelTexture(new ModelCrusherQuad(), new Texture(AVP.Properties.ID, "textures/mob/crusher_quad.png"));
        public final MapModelTexture<ModelHiveResin>              HIVE_RESIN                     = new MapModelTexture(new ModelHiveResin(), new Texture(AVP.Properties.ID, "textures/tile/hive-resin.png"));
        public final MapModelTexture<ModelGooMutant>              GOO_MUTANT                     = new MapModelTexture(new ModelGooMutant(), new Texture(AVP.Properties.ID, "textures/mob/goomutant.png"));
        public final MapModelTexture<ModelWarrior>                DRONE_SKULL                    = new MapModelTexture(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/xenomorphskullgiger.png"));
        public final MapModelTexture<ModelWarrior>                WARRIOR_SKULL                  = new MapModelTexture(new ModelWarrior(), new Texture(AVP.Properties.ID, "textures/mob/xenomorphskullwarrior.png"));
        public final MapModelTexture<ModelQueenSkull>             MATRIARCH_SKULL                = new MapModelTexture(new ModelQueenSkull(), new Texture(AVP.Properties.ID, "textures/tile/skulls/queenskull.png"));
        public final MapModelTexture<ModelAethonHead>             HEAD_AETHON                    = new MapModelTexture(new ModelAethonHead(), new Texture(AVP.Properties.ID, "textures/mob/aethon/aethon.png"));
        public final MapModelTexture<ModelProtomorphSkull>        PROTOMORPH_SKULL               = new MapModelTexture(new ModelProtomorphSkull(), new Texture(AVP.Properties.ID, "textures/tile/skulls/protomorph_skull.png"));
        public final MapModelTexture<ModelNeomorphSkull>          NEOMORPH_SKULL                 = new MapModelTexture(new ModelNeomorphSkull(), new Texture(AVP.Properties.ID, "textures/tile/skulls/neomorph_skull.png"));
        public final MapModelTexture<ModelGigerAlienHead>         GIGER_ALIEN_HEAD               = new MapModelTexture(new ModelGigerAlienHead(), new Texture(AVP.Properties.ID, "textures/mob/gigeralien.png"));
        public final MapModelTexture<ModelOctohugger>             OCTOHUGGER                     = new MapModelTexture(new ModelOctohugger(), new Texture(AVP.Properties.ID, "textures/mob/octohugger.png"));
        public final MapModelTexture<ModelBelugaburster>          BELUGABURSTER                  = new MapModelTexture(new ModelBelugaburster(), new Texture(AVP.Properties.ID, "textures/mob/belugaburster.png"));
        public final MapModelTexture<ModelBelugamorph>            BELUGAMORPH                    = new MapModelTexture(new ModelBelugamorph(), new Texture(AVP.Properties.ID, "textures/mob/belugamorph.png"));
        public final MapModelTexture<ModelBabyhead>               BABYHEAD                       = new MapModelTexture(new ModelBabyhead(), new Texture(AVP.Properties.ID, "textures/mob/babyhead.png"));
        public final MapModelTexture<ModelBatXenomorph>           BAT_XENO                       = new MapModelTexture(new ModelBatXenomorph(), new Texture(AVP.Properties.ID, "textures/mob/batxeno.png"));
        public final MapModelTexture<ModelBoiler>                 BOILER                         = new MapModelTexture(new ModelBoiler(), new Texture(AVP.Properties.ID, "textures/mob/boiler.png"));
        public final MapModelTexture<ModelBoiler>                 BOILER_MASK                    = new MapModelTexture(new ModelBoiler(), new Texture(AVP.Properties.ID, "textures/mob/boiler_glow.png"));
        public final MapModelTexture<ModelDracoburster>           DRACOBURSTER                   = new MapModelTexture(new ModelDracoburster(), new Texture(AVP.Properties.ID, "textures/mob/dracoburster.png"));
        public final MapModelTexture<ModelDracomorph>             DRACOMORPH                     = new MapModelTexture(new ModelDracomorph(), new Texture(AVP.Properties.ID, "textures/mob/dracomorph.png"));
        public final MapModelTexture<ModelDracoOvamorph>          DRACO_OVAMORPH                 = new MapModelTexture(new ModelDracoOvamorph(), new Texture(AVP.Properties.ID, "textures/mob/dracomorphegg.png"));
        public final MapModelTexture<ModelMutantYautja>           MUTANT_YAUTJA                  = new MapModelTexture(new ModelMutantYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautjamutant.png"));
        public final MapModelTexture<ModelMyceliomorph>           MYCELIOMORPH                   = new MapModelTexture(new ModelMyceliomorph(), new Texture(AVP.Properties.ID, "textures/mob/myceliomorph.png"));
        public final MapModelTexture<ModelMyceliomorph>           MYCELIOMORPH_MASK              = new MapModelTexture(new ModelMyceliomorph(), new Texture(AVP.Properties.ID, "textures/mob/myceliomorph_glow.png"));
        public final MapModelTexture<ModelPantheramorph>          PANTHERAMORPH                  = new MapModelTexture(new ModelPantheramorph(), new Texture(AVP.Properties.ID, "textures/mob/pantheramorph.png"));
        public final MapModelTexture<ModelUrsuidae>               URSUIDAE                       = new MapModelTexture(new ModelUrsuidae(), new Texture(AVP.Properties.ID, "textures/mob/vardaboar.png"));
        public final MapModelTexture<ModelVardaMonkey>            VARDA_MONKEY                   = new MapModelTexture(new ModelVardaMonkey(), new Texture(AVP.Properties.ID, "textures/mob/vardamonkey.png"));

        public final MapModelTexture<ModelGroundFern>             GROUND_FERN                    = new MapModelTexture(new ModelGroundFern(), new Texture(AVP.Properties.ID, "textures/tile/plants/paradisiangroundfern.png"));
        public final MapModelTexture<ModelTreeFern>               TREE_FERN                      = new MapModelTexture(new ModelTreeFern(), new Texture(AVP.Properties.ID, "textures/tile/plants/paradisiantreefern.png"));
        public final MapModelTexture<ModelSporePod>               SPORE_POD                      = new MapModelTexture(new ModelSporePod(), new Texture(AVP.Properties.ID, "textures/mob/sporepods.png"));

        /** New xenomorph model format **/
        public final MapModelTexture<ModelUltramorph>             ULTRAMORPH                     = new MapModelTexture(new ModelUltramorph(), new Texture(AVP.Properties.ID, "textures/mob/ultramorph.png"));
    }

    public final Texture SKY_VARDA_CLOUDS         = new Texture(AVP.Properties.ID, "textures/misc/varda-clouds.png");
    public final Texture SKY_SILICA               = new Texture(AVP.Properties.ID, "textures/misc/silica.png");
    public final Texture SKY_CALPAMOS             = new Texture(AVP.Properties.ID, "textures/misc/calpamos.png");
    public final Texture SKY_VARDA                = new Texture(AVP.Properties.ID, "textures/misc/varda.png");
    public final Texture SKY_ACHERON              = new Texture(AVP.Properties.ID, "textures/misc/acheron.png");
    public final Texture XENO1                    = new Texture(AVP.Properties.ID, "textures/armor/xeno_1.png");
    public final Texture XENO2                    = new Texture(AVP.Properties.ID, "textures/armor/xeno_2.png");
    public final Texture ACID_POOL                = new Texture(AVP.Properties.ID, "textures/misc/acidpool.png");
    public final Texture BLUR_FACEHUGGER          = new Texture(AVP.Properties.ID, "textures/misc/facehugger.png");
    public final Texture BLUR_CHESTBURSTER_EMERGE = new Texture(AVP.Properties.ID, "textures/misc/chestburster-emerge-overlay.png");
    public final Texture QUEEN_BOSS_BAR           = new Texture(AVP.Properties.ID, "textures/misc/queenbossbar.png");
    public final Texture MIST                     = new Texture(AVP.Properties.ID, "textures/blocks/mist.still.png");
    public final Texture BLACKGOO                 = new Texture(AVP.Properties.ID, "textures/blocks/blackgoo.png");
}
