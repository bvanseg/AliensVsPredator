package org.avp.client;

import com.asx.mdx.client.io.loaders.WavefrontModelLoader;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import com.asx.mdx.client.render.model.SpecialModelBiped;
import com.asx.mdx.client.render.model.texture.Texture;
import com.asx.mdx.client.render.model.wavefront.TriangulatedWavefrontModel;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.client.model.entity.ModelBullet;
import org.avp.client.model.entity.ModelSupplyChute;
import org.avp.client.model.entity.living.ModelMarine;
import org.avp.client.model.item.ModelMotionTracker;
import org.avp.client.model.item.ModelStunBaton;
import org.avp.client.model.tile.ModelAmpule;
import org.avp.client.model.tile.ModelDNASynthesizer;
import org.avp.client.model.tile.ModelLocker;
import org.power.client.model.tile.*;
import org.power.client.model.tile.rackmodule.*;
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
import org.weapon.client.model.item.*;

@SideOnly(Side.CLIENT)
public class Resources
{
    public static final Resources instance = new Resources();
    private static final Models   models   = new Models();

    public Models models()
    {
        return models;
    }

    @SideOnly(Side.CLIENT)
    @SuppressWarnings("all")
    public static class Models
    {
        public final MapModelTexture<Model88MOD4>                 _88MOD4                        = new MapModelTexture(new Model88MOD4(), new Texture(AVP.Properties.ID, "textures/items/models/88mod4.png"));
        public final MapModelTexture<ModelSevastopolFlamethrower> SEVASTOPOL_FLAMETHROWER        = new MapModelTexture(new ModelSevastopolFlamethrower(), new Texture(AVP.Properties.ID, "textures/items/models/flamethrower.sevastopol.png"));
        public final MapModelTexture<ModelLocker>                 LOCKER                         = new MapModelTexture(new ModelLocker(), new Texture(AVP.Properties.ID, "textures/tile/locker.png"));
        public final MapModelTexture<ModelLocker>                 GUN_LOCKER                     = new MapModelTexture(new ModelLocker(), new Texture(AVP.Properties.ID, "textures/tile/gunlocker.png"));
        public final MapModelTexture<ModelAmpule>                 AMPULE                         = new MapModelTexture(new ModelAmpule(), new Texture(AVP.Properties.ID, "textures/tile/ampule.png"));
        public final MapModelTexture<ModelTransformer>            TRANSFORMER                    = new MapModelTexture(new ModelTransformer(), new Texture(AVP.Properties.ID, "textures/tile/transformer.png"));
        public final MapModelTexture<ModelSolarPanel>             SOLAR_PANEL                    = new MapModelTexture(new ModelSolarPanel(), new Texture(AVP.Properties.ID, "textures/tile/solarpanel.png"));
        public final MapModelTexture<ModelSatelliteDish>          SATELLITE_DISH                 = new MapModelTexture(new ModelSatelliteDish(), new Texture(AVP.Properties.ID, "textures/tile/satellite-dish.png"));
        public final MapModelTexture<ModelPowercell>              POWERCELL                      = new MapModelTexture(new ModelPowercell(), new Texture(AVP.Properties.ID, "textures/tile/powercell.png"));
        public final MapModelTexture<ModelPowercell>              POWERCELL_LIQUID               = new MapModelTexture(new ModelPowercell(), new Texture(AVP.Properties.ID, "textures/tile/powercellliquid.png"));
        public final MapModelTexture<ModelBullet>                 BULLET                         = new MapModelTexture(new ModelBullet(), new Texture(AVP.Properties.ID, "textures/misc/renderbullet.png"));
        public final MapModelTexture<ModelSpear>                  SPEAR                          = new MapModelTexture(new ModelSpear(), new Texture(AVP.Properties.ID, "textures/misc/renderspear.png"));
        public final MapModelTexture<ModelWristBlade>             WRISTBLADES                    = new MapModelTexture(new ModelWristBlade(), new Texture(AVP.Properties.ID, "textures/items/models/wristblade.png"));
        public final MapModelTexture<ModelStunBaton>              STUNBATON                      = new MapModelTexture(new ModelStunBaton(), new Texture(AVP.Properties.ID, "textures/items/models/stunbaton.png"));
        public final MapModelTexture<ModelPlasmaCannon>           PLASMACANNON                   = new MapModelTexture(new ModelPlasmaCannon(), new Texture(AVP.Properties.ID, "textures/items/models/plasmacannon.png"));
        public final MapModelTexture<ModelM240ICU>                M240ICU                        = new MapModelTexture(new ModelM240ICU(), new Texture(AVP.Properties.ID, "textures/items/models/m240icu.png"));
        public final MapModelTexture<ModelM41A>                   M41A                           = new MapModelTexture(new ModelM41A(), new Texture(AVP.Properties.ID, "textures/items/models/pulserifle.png"));
        public final MapModelTexture<ModelM56SG>                  M56SG                          = new MapModelTexture(new ModelM56SG(), new Texture(AVP.Properties.ID, "textures/items/models/m56sg.png"));
        public final MapModelTexture<ModelAK47>                   AK47                           = new MapModelTexture(new ModelAK47(), new Texture(AVP.Properties.ID, "textures/items/models/ak-47.png"));
        public final MapModelTexture<ModelM4>                     M4                             = new MapModelTexture(new ModelM4(), new Texture(AVP.Properties.ID, "textures/items/models/m4.png"));
        public final MapModelTexture<ModelSniper>                 SNIPER                         = new MapModelTexture(new ModelSniper(), new Texture(AVP.Properties.ID, "textures/items/models/sniper.png"));
        public final MapModelTexture<ModelM40>                    M40GRENADE                     = new MapModelTexture(new ModelM40(), new Texture(AVP.Properties.ID, "textures/items/models/m40.png"));
        public final MapModelTexture<ModelM40>                    M40GRENADE_INCENDIARY          = new MapModelTexture(new ModelM40(), new Texture(AVP.Properties.ID, "textures/items/models/m40incendiary.png"));
        public final MapModelTexture<ModelMotionTracker>          MOTIONTRACKER                  = new MapModelTexture(new ModelMotionTracker(), new Texture(AVP.Properties.ID, "textures/items/models/motiontracker.png"));
        public final MapModelTexture<ModelTurret>                 TURRET                         = new MapModelTexture(new ModelTurret(), new Texture(AVP.Properties.ID, "textures/tile/turret.png"));
        public final MapModelTexture<ModelTeslaCoil>              TESLA_COIL                     = new MapModelTexture(new ModelTeslaCoil(), new Texture(AVP.Properties.ID, "textures/tile/teslacoil.png"));
        public final MapModelTexture<ModelWorkstation>            WORKSTATION                    = new MapModelTexture(new ModelWorkstation(), new Texture(AVP.Properties.ID, "textures/tile/workstation.png"));
        public final MapModelTexture<ModelWorkstation>            WORKSTATION_MASK               = new MapModelTexture(new ModelWorkstation(), new Texture(AVP.Properties.ID, "textures/tile/workstation-on.png"));
        public final MapModelTexture<ModelLightPanel>             LIGHT_PANEL                    = new MapModelTexture(new ModelLightPanel(), new Texture(AVP.Properties.ID, "textures/tile/lightpanel.png"));
        public final MapModelTexture<ModelCryostasisTube>         CRYOSTASIS_TUBE                = new MapModelTexture(new ModelCryostasisTube(), new Texture(AVP.Properties.ID, "textures/tile/cryostasistube.png"));
        public final MapModelTexture<ModelCryostasisTube>         CRYOSTASIS_TUBE_MASK           = new MapModelTexture(new ModelCryostasisTube(), new Texture(AVP.Properties.ID, "textures/tile/cryostasistube-mask.png"));
        public final MapModelTexture<ModelCryostasisTube>         CRYOSTASIS_TUBE_MASK_CRACKED   = new MapModelTexture(new ModelCryostasisTube(), new Texture(AVP.Properties.ID, "textures/tile/cryostasistube-cracked-mask.png"));
        public final MapModelTexture<ModelCryostasisTube>         CRYOSTASIS_TUBE_MASK_SHATTERED = new MapModelTexture(new ModelCryostasisTube(), new Texture(AVP.Properties.ID, "textures/tile/cryostasistube-shattered-mask.png"));
        public final MapModelTexture<ModelStasisMechanism>        STASIS_MECHANISM               = new MapModelTexture(new ModelStasisMechanism(), new Texture(AVP.Properties.ID, "textures/tile/stasis-mechanism.png"));
        public final MapModelTexture<ModelStasisMechanism>        STASIS_MECHANISM_MASK          = new MapModelTexture(new ModelStasisMechanism(), new Texture(AVP.Properties.ID, "textures/tile/stasis-mechanism-mask.png"));
        public final MapModelTexture<ModelMedpod>                 MEDPOD                         = new MapModelTexture(new ModelMedpod(), new Texture(AVP.Properties.ID, "textures/tile/medpod.png"));
        public final MapModelTexture<ModelMedpod>                 MEDPOD_MASK                    = new MapModelTexture(new ModelMedpod(), new Texture(AVP.Properties.ID, "textures/tile/medpod-on.png"));
        public final MapModelTexture<ModelRepulsionGenerator>     REPULSION_GENERATOR            = new MapModelTexture(new ModelRepulsionGenerator(), new Texture(AVP.Properties.ID, "textures/tile/generator.png"));
        public final MapModelTexture<ModelCable>                  CABLE                          = new MapModelTexture(new ModelCable(), new Texture(AVP.Properties.ID, "textures/tile/cable.png"));
        public final MapModelTexture<ModelBlastdoor>              BLASTDOOR                      = new MapModelTexture(new ModelBlastdoor(), new Texture(AVP.Properties.ID, "textures/tile/blastdoor.png"));
        public final MapModelTexture<ModelSevastopolBlastdoor>    BLASTDOOR_SEVASTOPOL           = new MapModelTexture(new ModelSevastopolBlastdoor(), new Texture(AVP.Properties.ID, "textures/tile/sevastopolblastdoor.png"));
        public final MapModelTexture<ModelSevastopolBlastdoor>    BLASTDOOR_SEVASTOPOL_LOCKED    = new MapModelTexture(new ModelSevastopolBlastdoor(), new Texture(AVP.Properties.ID, "textures/tile/sevastopolblastdoor_locked.png"));
        public final MapModelTexture<ModelSevastopolBlastdoor>    BLASTDOOR_SEVASTOPOL_UNLOCKED  = new MapModelTexture(new ModelSevastopolBlastdoor(), new Texture(AVP.Properties.ID, "textures/tile/sevastopolblastdoor_unlocked.png"));
        public final MapModelTexture<ModelSevastopolBlastdoor>    BLASTDOOR_SEVASTOPOL_ENABLED   = new MapModelTexture(new ModelSevastopolBlastdoor(), new Texture(AVP.Properties.ID, "textures/tile/sevastopolblastdoor_power_on.png"));
        public final MapModelTexture<ModelSevastopolBlastdoor>    BLASTDOOR_SEVASTOPOL_DISABLED  = new MapModelTexture(new ModelSevastopolBlastdoor(), new Texture(AVP.Properties.ID, "textures/tile/sevastopolblastdoor_power_off.png"));
        public final MapModelTexture<ModelCCFL>                   CCFL_BALLAST                   = new MapModelTexture(new ModelCCFL(), new Texture(AVP.Properties.ID, "textures/tile/ccfl_ballast.png"));
        public final MapModelTexture<ModelCCFL>                   CCFL_TUBE_ON                   = new MapModelTexture(new ModelCCFL(), new Texture(AVP.Properties.ID, "textures/tile/ccfl_on.png"));
        public final MapModelTexture<ModelCCFL>                   CCFL_TUBE_OFF                  = new MapModelTexture(new ModelCCFL(), new Texture(AVP.Properties.ID, "textures/tile/ccfl_off.png"));
        public final MapModelTexture<ModelMarine>                 MARINE                         = new MapModelTexture(new ModelMarine(), new Texture(AVP.Properties.ID, "textures/mob/marine.png"));
        public final MapModelTexture<ModelMarine>                 MARINE_SKIN                    = new MapModelTexture(new ModelMarine(), new Texture(AVP.Properties.ID, "textures/mob/marine_skin.png"));
        public final MapModelTexture<ModelMarine>                 MARINE_CAMO                    = new MapModelTexture(new ModelMarine(), new Texture(AVP.Properties.ID, "textures/mob/marine_camo.png"));
        public final MapModelTexture<ModelMarine>                 MARINE_EYES                    = new MapModelTexture(new ModelMarine(), new Texture(AVP.Properties.ID, "textures/mob/marine_eyes.png"));
        public final MapModelTexture<ModelYautja>                 YAUTJA_WARRIOR                 = new MapModelTexture(new ModelYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautja.png"));
        public final MapModelTexture<ModelYautja>                 YAUTJA_BERSERKER               = new MapModelTexture(new ModelYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautja_berserker.png"));
        public final MapModelTexture<SpecialModelBiped>           COMBAT_SYNTHETIC               = new MapModelTexture(new SpecialModelBiped(), new Texture(AVP.Properties.ID, "textures/mob/combat_synthetic.png"));
        public final MapModelTexture<ModelSupplyChute>            SUPPLY_CHUTE                   = new MapModelTexture(new ModelSupplyChute(), new Texture(AVP.Properties.ID, "textures/tile/supplychute.png"));
        public final MapModelTexture<ModelSupplyChute>            SUPPLY_CHUTE_MARINES           = new MapModelTexture(new ModelSupplyChute(), new Texture(AVP.Properties.ID, "textures/tile/supplychute.marines.png"));
        public final MapModelTexture<ModelSupplyChute>            SUPPLY_CHUTE_SEEGSON           = new MapModelTexture(new ModelSupplyChute(), new Texture(AVP.Properties.ID, "textures/tile/supplychute.seegson.png"));
        public final MapModelTexture<SpecialModelBiped>           BIPED                          = new MapModelTexture(new SpecialModelBiped(), new Texture(""));
        public final MapModelTexture<ModelLaserMine>              LASER_MINE                     = new MapModelTexture(new ModelLaserMine(), new Texture(AVP.Properties.ID, "textures/misc/proximity-mine.png"));
        public final MapModelTexture<ModelDNASynthesizer>         DNA_SYNTHESIZER                = new MapModelTexture(new ModelDNASynthesizer(), new Texture(AVP.Properties.ID, "textures/tile/dna-synthesizer.png"));
        public final MapModelTexture<ModelYautja>                 YAUTJA_SKULL                   = new MapModelTexture(new ModelYautja(), new Texture(AVP.Properties.ID, "textures/mob/yautjaskull.png"));
        public final MapModelTexture<ModelBiomaskClassic>         BIOMASK_CLASSIC                = new MapModelTexture(new ModelBiomaskClassic(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja.png"));
        public final MapModelTexture<ModelBiomaskBerserker>       BIOMASK_BERSERKER              = new MapModelTexture(new ModelBiomaskBerserker(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja_berserker.png"));
        public final MapModelTexture<ModelBiomaskFalconer>        BIOMASK_FALCONER               = new MapModelTexture(new ModelBiomaskFalconer(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja_falconer.png"));
        public final MapModelTexture<ModelBiomaskTracker>         BIOMASK_TRACKER                = new MapModelTexture(new ModelBiomaskTracker(), new Texture(AVP.Properties.ID, "textures/mob/yautja/yautja_tracker.png"));
        public final MapModelTexture<ModelRedstoneFluxGenerator>  RFGENERATOR                    = new MapModelTexture(new ModelRedstoneFluxGenerator(), new Texture(AVP.Properties.ID, "textures/tile/redstonefluxgenerator.png"));
        public final MapModelTexture<ModelPredatorHound>          PREDATOR_HOUND                 = new MapModelTexture(new ModelPredatorHound(), new Texture(AVP.Properties.ID, "textures/mob/predatorhound.png"));

        /** Wavefront models **/
        public final TriangulatedWavefrontModel M577_APC                                         = WavefrontModelLoader.load(AVP.class, AVP.Properties.ID, "m577apc", "/assets/avp/models/m577apc");

        public final MapModelTexture<ModelNetworkModuleRack>      NETWORKMODULERACK              = new MapModelTexture(new ModelNetworkModuleRack(), new Texture(AVP.Properties.ID, "textures/tile/networkmodulerack.png"));
        public final MapModelTexture<ModelNetworkModuleRack>      NETWORKMODULERACK_ON           = new MapModelTexture(new ModelNetworkModuleRack(), new Texture(AVP.Properties.ID, "textures/tile/networkmodulerack_on.png"));
        public final MapModelTexture<ModelNetworkModuleRack>      NETWORKMODULERACK_OFF          = new MapModelTexture(new ModelNetworkModuleRack(), new Texture(AVP.Properties.ID, "textures/tile/networkmodulerack_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE1                    = new MapModelTexture(new ModelRackModule1(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent01.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE1_ON                 = new MapModelTexture(new ModelRackModule1(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent01_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE1_OFF                = new MapModelTexture(new ModelRackModule1(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent01_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE2                    = new MapModelTexture(new ModelRackModule2(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent02.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE2_ON                 = new MapModelTexture(new ModelRackModule2(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent02_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE2_OFF                = new MapModelTexture(new ModelRackModule2(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent02_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE3                    = new MapModelTexture(new ModelRackModule3(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent03.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE3_ON                 = new MapModelTexture(new ModelRackModule3(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent03_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE3_OFF                = new MapModelTexture(new ModelRackModule3(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent03_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE4                    = new MapModelTexture(new ModelRackModule4(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent04.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE4_ON                 = new MapModelTexture(new ModelRackModule4(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent04_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE4_OFF                = new MapModelTexture(new ModelRackModule4(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent04_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE5                    = new MapModelTexture(new ModelRackModule5(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent05.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE5_ON                 = new MapModelTexture(new ModelRackModule5(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent05_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE5_OFF                = new MapModelTexture(new ModelRackModule5(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent05_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE6                    = new MapModelTexture(new ModelRackModule6(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent06.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE6_ON                 = new MapModelTexture(new ModelRackModule6(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent06_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE6_OFF                = new MapModelTexture(new ModelRackModule6(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent06_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE7                    = new MapModelTexture(new ModelRackModule7(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent07.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE7_ON                 = new MapModelTexture(new ModelRackModule7(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent07_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE7_OFF                = new MapModelTexture(new ModelRackModule7(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent07_off.png"));

        public final MapModelTexture<Model<?>>                    RACKMODULE8                    = new MapModelTexture(new ModelRackModule8(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent08.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE8_ON                 = new MapModelTexture(new ModelRackModule8(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent08_on.png"));
        public final MapModelTexture<Model<?>>                    RACKMODULE8_OFF                = new MapModelTexture(new ModelRackModule8(), new Texture(AVP.Properties.ID, "textures/tile/rackmodules/servercomponent08_off.png"));
    }

    public final Texture PRESSURESUIT1            = new Texture(AVP.Properties.ID, "textures/armor/suit_1.png");
    public final Texture PRESSURESUIT2            = new Texture(AVP.Properties.ID, "textures/armor/suit_2.png");
    public final Texture MK501                    = new Texture(AVP.Properties.ID, "textures/armor/mk50_1.png");
    public final Texture MK502                    = new Texture(AVP.Properties.ID, "textures/armor/mk50_2.png");
    public final Texture MARINE1                  = new Texture(AVP.Properties.ID, "textures/armor/marine_1.png");
    public final Texture MARINE2                  = new Texture(AVP.Properties.ID, "textures/armor/marine_2.png");
    public final Texture LIQUID_POOL              = new Texture(AVP.Properties.ID, "textures/misc/liquidpool.png");
    public final Texture BLUR_TACTICAL_HUD        = new Texture(AVP.Properties.ID, "textures/misc/marine-helm-overlay.png");
    public final Texture BATTERY_INDICATOR        = new Texture(AVP.Properties.ID, "textures/misc/battery-indicator.png");
    public final Texture INFECTION_INDICATOR      = new Texture(AVP.Properties.ID, "textures/misc/infection-indicator.png");
    public final Texture BLUR_GUNSCOPE            = new Texture(AVP.Properties.ID, "textures/misc/scope.png");
    public final Texture GUI_BASIC                = new Texture(AVP.Properties.ID, "textures/gui/background.png");
    public final Texture GUI_TURRET               = new Texture(AVP.Properties.ID, "textures/gui/turret.png");
    public final Texture GUI_NETWORK_RACK         = new Texture(AVP.Properties.ID, "textures/gui/networkrack.png");
    public final Texture GUI_LOCKER               = new Texture(AVP.Properties.ID, "textures/gui/locker.png");
    public final Texture GUI_ASSEMBLER            = new Texture(AVP.Properties.ID, "textures/gui/assembler.png");
    public final Texture GUI_SUPPLYCRATE          = new Texture(AVP.Properties.ID, "textures/gui/supplycrate.png");
    public final Texture GUI_REPULSION_GENERATOR  = new Texture(AVP.Properties.ID, "textures/gui/repulsion_generator.png");
    public final Texture ICON_AMMO                = new Texture(AVP.Properties.ID, "textures/misc/icon-ammo.png");
    public final Texture MOTIONTRACKER_BG         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/background.png");
    public final Texture MOTIONTRACKER_FG         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/foreground.png");
    public final Texture MOTIONTRACKER_PING       = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/ping.png");
    public final Texture MOTIONTRACKER_S1         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/sweep1.png");
    public final Texture MOTIONTRACKER_S2         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/sweep2.png");
    public final Texture MOTIONTRACKER_S3         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/sweep3.png");
    public final Texture MOTIONTRACKER_S4         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/sweep4.png");
    public final Texture MOTIONTRACKER_S5         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/sweep5.png");
    public final Texture MOTIONTRACKER_S6         = new Texture(AVP.Properties.ID, "textures/misc/motiontracker/sweep6.png");
    public final Texture REFLECTION               = new Texture(AVP.Properties.ID, "textures/blocks/reflection.png");
    public final Texture RES_UNDERWATER_OVERLAY   = new Texture("textures/misc/underwater.png");
}
