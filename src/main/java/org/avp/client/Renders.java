package org.avp.client;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.core.mods.IPreInitEvent;
import com.asx.mdx.lib.client.Renderers;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.render.entity.RenderAcidPool;
import org.alien.client.render.entity.RenderAcidProjectile;
import org.alien.client.render.entity.RenderSporePod;
import org.alien.client.render.entity.living.*;
import org.alien.client.render.item.RenderItemGroundFern;
import org.alien.client.render.item.RenderItemSporePod;
import org.alien.client.render.item.RenderItemTreeFern;
import org.alien.client.render.tile.RenderHiveResin;
import org.alien.client.render.tile.plant.RenderGroundFern;
import org.alien.client.render.tile.plant.RenderTreeFern;
import org.alien.common.AlienBlocks;
import org.alien.common.AlienItems;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.EntityAcidProjectile;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.EntityDracoEgg;
import org.alien.common.entity.living.EntitySporePod;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.*;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.avp.AVP;
import org.avp.client.model.item.*;
import org.avp.client.model.loader.CustomBlockModelLoader;
import org.avp.client.model.loader.ReflectiveModelLoader;
import org.avp.client.render.entity.*;
import org.avp.client.render.entity.living.RenderCombatSynthetic;
import org.avp.client.render.entity.living.RenderMarine;
import org.avp.client.render.item.*;
import org.avp.client.render.item.firearm.*;
import org.avp.client.render.item.firearm.part.*;
import org.avp.client.render.tile.*;
import org.avp.client.render.transform.CryostasisTubeRenderers;
import org.avp.client.render.transform.FaceLocationTransforms;
import org.avp.client.render.transform.MedpodTransforms;
import org.avp.client.render.transform.VanillaFaceLocationTransforms;
import org.avp.common.AVPBlocks;
import org.avp.common.AVPItems;
import org.avp.common.block.BlockSkull;
import org.avp.common.entity.*;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.tile.*;
import org.avp.common.tile.plant.TileEntityGroundFern;
import org.avp.common.tile.plant.TileEntityTreeFern;
import org.lib.registry.BlockRegistryUtil;
import org.predator.client.render.entity.*;
import org.predator.client.render.entity.living.RenderPredatorHound;
import org.predator.client.render.entity.living.RenderYautjaBerserker;
import org.predator.client.render.entity.living.RenderYautjaWarrior;
import org.predator.client.render.item.*;
import org.predator.client.render.tile.RenderStasisMechanism;
import org.predator.common.PredatorBlocks;
import org.predator.common.PredatorItems;
import org.predator.common.entity.*;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaMutant;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

import static net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class Renders implements IInitEvent, IPreInitEvent
{
    public static final Renders instance = new Renders();

    private Renders() {}

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        registerModelLoaders(event);
        registerBlockItemRenderers();
        registerItemRenderers();
        registerStandardEntityRenderers();
        registerLivingEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        registerTileEntitySpecialRenderers();
        CryostasisTubeRenderers.register();
        MedpodTransforms.register();
        FaceLocationTransforms.register();
        VanillaFaceLocationTransforms.register();
    }

    @SubscribeEvent
    public static void registerAllModels(ModelRegistryEvent event)
    {
        registerFluidModels();
    }

    private static void registerFluidModels()
    {
        for (BlockFluidBase block : BlockRegistryUtil.getFluids())
        {
            final Item item = Item.getItemFromBlock(block);
            final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(AVP.Properties.DOMAIN + block.getFluid().getName(), "fluid");

            ModelLoader.setCustomMeshDefinition(item, stack -> modelResourceLocation);

            ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
                @Override
                protected ModelResourceLocation getModelResourceLocation(IBlockState state)
                {
                    return modelResourceLocation;
                }
            });
        }
    }

    private void registerModelLoaders(FMLPreInitializationEvent event)
    {
        OBJLoader.INSTANCE.addDomain(AVP.Properties.ID);
        ModelLoaderRegistry.registerLoader(ReflectiveModelLoader.INSTANCE);
        ModelLoaderRegistry.registerLoader(CustomBlockModelLoader.INSTANCE);
    }

    private void registerLivingEntityRenderers()
    {
        Renderers.registerRenderer(EntityEngineer.class, RenderEngineer.class);
        Renderers.registerRenderer(EntitySpaceJockey.class, RenderSpaceJockey.class);
        Renderers.registerRenderer(EntityYautjaBerserker.class, RenderYautjaBerserker.class);
        Renderers.registerRenderer(EntityTrilobite.class, RenderTrilobite.class);
        Renderers.registerRenderer(EntityHammerpede.class, RenderHammerpede.class);
        Renderers.registerRenderer(EntityDeacon.class, RenderDeacon.class);
        Renderers.registerRenderer(EntityDeaconAdult.class, RenderDeaconAdult.class);
        Renderers.registerRenderer(EntityDrone.class, RenderDrone.class);
        Renderers.registerRenderer(EntityWarrior.class, RenderWarrior.class);
        Renderers.registerRenderer(EntityPraetorian.class, RenderPraetorian.class);
        Renderers.registerRenderer(EntityRunnerDrone.class, RenderRunnerDrone.class);
        Renderers.registerRenderer(EntityRunnerWarrior.class, RenderRunnerWarrior.class);
        Renderers.registerRenderer(EntityCrusher.class, RenderCrusher.class);
        Renderers.registerRenderer(EntityNauticomorph.class, RenderNauticomorph.class);
        Renderers.registerRenderer(EntityPredalien.class, RenderPredalien.class);
        Renderers.registerRenderer(EntitySpitter.class, RenderSpitter.class);
        Renderers.registerRenderer(EntityMarine.class, RenderMarine.class);
        Renderers.registerRenderer(EntityCombatSynthetic.class, RenderCombatSynthetic.class);
        Renderers.registerRenderer(EntityYautjaWarrior.class, RenderYautjaWarrior.class);
        Renderers.registerRenderer(EntityMatriarch.class, RenderMatriarch.class);
        Renderers.registerRenderer(EntityFacehugger.class, RenderFacehugger.class);
        Renderers.registerRenderer(EntityRoyalFacehugger.class, RenderRoyalFacehugger.class);
        Renderers.registerRenderer(EntityChestburster.class, RenderChestburster.class);
        Renderers.registerRenderer(EntityOvamorph.class, RenderOvamorph.class);
        Renderers.registerRenderer(EntityOvamorphGiger.class, RenderOvamorphGiger.class);
        Renderers.registerRenderer(EntityDeaconShark.class, RenderDeaconShark.class);
        Renderers.registerRenderer(EntityUltramorph.class, RenderUltramorph.class);
        Renderers.registerRenderer(EntityGooMutant.class, RenderGooMutant.class);
        Renderers.registerRenderer(EntityAethon.class, RenderAethon.class);
        Renderers.registerRenderer(EntityOctohugger.class, RenderOctohugger.class);
        Renderers.registerRenderer(EntityBelugaburster.class, RenderBelugaburster.class);
        Renderers.registerRenderer(EntityBelugamorph.class, RenderBelugamorph.class);
        Renderers.registerRenderer(EntityPredalienChestburster.class, RenderPredalienChestburster.class);
        Renderers.registerRenderer(EntityQueenChestburster.class, RenderQueenChestburster.class);
        Renderers.registerRenderer(EntityRunnerChestburster.class, RenderRunnerChestburster.class);
        Renderers.registerRenderer(EntityBabyhead.class, RenderBabyhead.class);
        Renderers.registerRenderer(EntityBatXeno.class, RenderBatXenomorph.class);
        Renderers.registerRenderer(EntityBoiler.class, RenderBoiler.class);
        Renderers.registerRenderer(EntityDracoburster.class, RenderDracoburster.class);
        Renderers.registerRenderer(EntityDracoEgg.class, RenderDracoEgg.class);
        Renderers.registerRenderer(EntityDracomorph.class, RenderDracomorph.class);
        Renderers.registerRenderer(EntityMyceliomorph.class, RenderMyceliomorph.class);
        Renderers.registerRenderer(EntityPantheramorph.class, RenderPantheramorph.class);
        Renderers.registerRenderer(EntityPredatorHound.class, RenderPredatorHound.class);
        Renderers.registerRenderer(EntityUrsuidae.class, RenderUrsuidae.class);
        Renderers.registerRenderer(EntityScelemur.class, RenderScelemur.class);
        Renderers.registerRenderer(EntityYautjaMutant.class, RenderYautjaMutant.class);
    }

    private void registerStandardEntityRenderers()
    {
        Renderers.registerRenderer(EntityAcidPool.class, RenderAcidPool.class);
        Renderers.registerRenderer(EntitySpear.class, RenderSpear.class);
        Renderers.registerRenderer(EntityLaserMine.class, RenderLaserMine.class);
        Renderers.registerRenderer(EntityGrenade.class, RenderGrenade.class);
        Renderers.registerRenderer(EntityFlame.class, RenderFlame.class);
        Renderers.registerRenderer(EntityLiquidLatexPool.class, RenderLiquidLatexPool.class);
        Renderers.registerRenderer(EntityPlasma.class, RenderPlasmaBlast.class);
        Renderers.registerRenderer(EntityAcidProjectile.class, RenderAcidProjectile.class);
        Renderers.registerRenderer(EntitySmartDisc.class, RenderDisc.class);
        Renderers.registerRenderer(EntityShuriken.class, RenderShuriken.class);
        Renderers.registerRenderer(EntityBullet.class, RenderBullet.class);
        Renderers.registerRenderer(EntityWristbracer.class, RenderWristbracer.class);
        Renderers.registerRenderer(EntityAPC.class, RenderAPC.class);
        Renderers.registerRenderer(EntityMechanism.class, RenderMechanism.class);
        Renderers.registerRenderer(EntityMedpod.class, RenderMedpodEntity.class);
        Renderers.registerRenderer(EntitySupplyChute.class, RenderSupplyChute.class);
        Renderers.registerRenderer(EntitySupplyChuteMarines.class, RenderSupplyChute.class);
        Renderers.registerRenderer(EntitySupplyChuteSeegson.class, RenderSupplyChute.class);
        Renderers.registerRenderer(EntitySporePod.class, RenderSporePod.class);
    }
    
    private static void registerSkullRenderer(Block block)
    {
        if (block instanceof BlockSkull)
        {
            BlockSkull skull = (BlockSkull) block;
            RenderItemSkull render =  new RenderItemSkull(skull);
            
            Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(skull), render);
        } 
        else
        {
            AVP.log().error("Error registering skull block renderer. Type mismatch: {}", block.getTranslationKey());
        }
    }
    
    private void registerBlockItemRenderers()
    {
        Renders.registerSkullRenderer(AlienBlocks.SKULL_ENGINEER);
        Renders.registerSkullRenderer(AlienBlocks.SKULL_JOCKEY);
        Renders.registerSkullRenderer(AlienBlocks.SKULL_XENO);
        Renders.registerSkullRenderer(AlienBlocks.SKULL_XENO_WARRIOR);
        Renders.registerSkullRenderer(PredatorBlocks.SKULL_YAUTJA);
        Renders.registerSkullRenderer(AlienBlocks.SKULL_MATRIARCH);
        Renders.registerSkullRenderer(AlienBlocks.SKULL_PROTOMORPH);
        Renders.registerSkullRenderer(AlienBlocks.SKULL_NEOMORPH);
        Renders.registerSkullRenderer(PredatorBlocks.BIOMASK_CLASSIC);
        Renders.registerSkullRenderer(PredatorBlocks.BIOMASK_BERSERKER);
        Renders.registerSkullRenderer(PredatorBlocks.BIOMASK_FALCONER);
        Renders.registerSkullRenderer(PredatorBlocks.BIOMASK_TRACKER);
        Renders.registerSkullRenderer(AlienBlocks.HEAD_AETHON);
        Renders.registerSkullRenderer(AlienBlocks.HEAD_GIGER_ALIEN);
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.TURRET), new RenderItemTurret());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.TERMINAL), new RenderItemWorkstation());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(PredatorBlocks.STASIS_MECHANISM), new RenderItemStasisMechanism());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.CRYO_TUBE), new RenderItemCryostasisTube());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.REPULSION_GENERATOR), new RenderItemRepulsionGenerator());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.BLAST_DOOR), new RenderItemBlastDoor());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.LIGHT_PANEL), new RenderItemLightPanel());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.CCFL_TUBE), new RenderItemCCFLTube());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.TESLA_COIL), new RenderItemTeslaCoil());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.POWERLINE), new RenderItemPowerline());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.SOLAR_PANEL), new RenderItemSolarPanel());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.POWERCELL), new RenderItemPowercell());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.TRANSFORMER), new RenderItemTransformer());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.STEPDOWN_TRANSFORMER), new RenderItemTransformer());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.UNIVERSAL_GENERATOR), new RenderItemRedstoneFluxGenerator());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.AMPULE), new RenderItemAmpule());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.LOCKER), new RenderItemLocker());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.GUN_LOCKER), new RenderItemGunLocker());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.MEDPOD), new RenderItemMedpod());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.SATELLITE_DISH), new RenderItemSatelliteDish());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.SEVASTOPOL_BLAST_DOOR), new RenderItemSevastopolBlastdoor());

        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.SUPPLY_CRATE), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.CRATE_MARINES), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.CRATE_SEEGSON), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPBlocks.NETWORK_RACK), new RenderItemNetworkRack());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AlienBlocks.GROUND_FERN), new RenderItemGroundFern());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AlienBlocks.TREE_FERN), new RenderItemTreeFern());
    }

    private void registerItemRenderers()
    {
        Renderers.registerItemRenderer(PredatorItems.ITEM_WRISTBRACER, new RenderItemWristbracer());
        Renderers.registerItemRenderer(AVPItems.ITEM_STUN_BATON, new RenderItemStunBaton());
        Renderers.registerItemRenderer(PredatorItems.ITEM_WRISTBRACER_BLADES, new RenderItemWristbracerBlades());
        Renderers.registerItemRenderer(PredatorItems.ITEM_PLASMA_CANNON, new RenderItemPlasmaCannon());
        Renderers.registerItemRenderer(PredatorItems.ITEM_SPEAR, new RenderItemSpear());
        Renderers.registerItemRenderer(AVPItems.ITEM_M_240_ICU, new RenderItemM240ICU());
        Renderers.registerItemRenderer(AVPItems.ITEM_SEVASTOPOL_FLAMETHROWER, new RenderItemNostromoFlamethrower());
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A, new RenderItemM41A());
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG, new RenderItemM56SG());
        Renderers.registerItemRenderer(AVPItems.ITEM_AK47, new RenderItemAK47());
        Renderers.registerItemRenderer(AVPItems.ITEM_M4, new RenderItemM4());
        Renderers.registerItemRenderer(AVPItems.ITEM_PISTOL, new RenderItem88MOD4());
        Renderers.registerItemRenderer(AVPItems.ITEM_SNIPER, new RenderItemSniper());
        Renderers.registerItemRenderer(AVPItems.ITEM_MOTION_TRACKER, new RenderItemMotionTracker());
        Renderers.registerItemRenderer(AVPItems.ITEM_APC, new RenderItemAPC());
        Renderers.registerItemRenderer(AVPItems.ITEM_GRENADE, new RenderItemM40(AVP.resources().models().M40GRENADE));
        Renderers.registerItemRenderer(AVPItems.ITEM_INCENDIARY_GRENADE, new RenderItemM40(AVP.resources().models().M40GRENADE_INCENDIARY));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_SPORE_POD, new RenderItemSporePod());
        
        Renderers.registerItemRenderer(AVPItems.ITEM_SUPPLY_CHUTE, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(AVPItems.ITEM_SUPPLY_CHUTE_MARINES, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(AVPItems.ITEM_SUPPLY_CHUTE_SEEGSON, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_1, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_2, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_3, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_4, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_5, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_6, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_7, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_8, new RenderItemNetworkRackModule());

        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRONE, (new RenderItemSummoner(AVP.resources().models().DRONE_ADVANCED)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DEACON, (new RenderItemSummoner(AVP.resources().models().DEACON)).setScale(7F).setY(4F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DEACON_ADULT, (new RenderItemSummoner(AVP.resources().models().DEACON_ADULT)).setScale(7F).setY(4F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_WARRIOR, (new RenderItemSummoner(AVP.resources().models().WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_RUNNER_DRONE, (new RenderItemSummoner(AVP.resources().models().RUNNER_DRONE)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_RUNNER_WARRIOR, (new RenderItemSummoner(AVP.resources().models().RUNNER_WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PRAETORIAN, (new RenderItemSummoner(AVP.resources().models().PRAETORIAN)).setScale(7.5F).setY(7.5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_SPITTER, (new RenderItemSummoner(AVP.resources().models().SPITTER)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_CRUSHER, (new RenderItemSummoner(AVP.resources().models().CRUSHER)).setScale(7.5F).setY(9.5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_QUEEN, (new RenderItemSummoner(AVP.resources().models().MATRIARCH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_OVAMORPH, (new RenderItemSummoner(AVP.resources().models().OVAMORPH)).setScale(20F).setY(-16F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_OVAMORPH_GIGER, (new RenderItemSummoner(AVP.resources().models().OVAMORPH_GIGER)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_CHESTBURSTER, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_FACEHUGGER, (new RenderItemSummoner(AVP.resources().models().FACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_ROYAL_FACEHUGGER, (new RenderItemSummoner(AVP.resources().models().ROYALFACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(AVPItems.SUMMONER_MARINE, (new RenderItemSummoner(AVP.resources().models().MARINE)).setScale(16F).setY(-8F));
        Renderers.registerItemRenderer(PredatorItems.SUMMONER_YAUTJA_WARRIOR, (new RenderItemSummoner(AVP.resources().models().YAUTJA_WARRIOR)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PREDALIEN, (new RenderItemSummoner(AVP.resources().models().PREDALIEN)).setScale(8F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_AQUA, (new RenderItemSummoner(AVP.resources().models().NAUTICOMORPH_XENOMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AVPItems.SUMMONER_COMBAT_SYNTHETIC, (new RenderItemSummoner(AVP.resources().models().COMBAT_SYNTHETIC)).setScale(16F).setY(-8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_HAMMERPEDE, (new RenderItemSummoner(AVP.resources().models().HAMMERPEDE)).setScale(10.5F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_TRILOBITE, (new RenderItemSummoner(AVP.resources().models().TRILOBITE)).setScale(8F).setY(4F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_SPACE_JOCKEY, (new RenderItemSummoner(AVP.resources().models().SPACE_JOCKEY)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_ENGINEER, (new RenderItemSummoner(AVP.resources().models().ENGINEER)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(PredatorItems.SUMMONER_YAUTJA_BERSERKER, (new RenderItemSummoner(AVP.resources().models().YAUTJA_BERSERKER)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DEACON_SHARK, (new RenderItemSummoner(AVP.resources().models().DEACON_SHARK)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_ULTRAMORPH, (new RenderItemSummoner(AVP.resources().models().ULTRAMORPH)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_GOO_MUTANT, (new RenderItemSummoner(AVP.resources().models().GOO_MUTANT)).setScale(10F).setY(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_AETHON, (new RenderItemSummoner(AVP.resources().models().AETHON)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_OCTOHUGGER, (new RenderItemSummoner(AVP.resources().models().OCTOHUGGER)).setScale(24F).setY(-4F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BELUGABURSTER, (new RenderItemSummoner(AVP.resources().models().BELUGABURSTER)).setScale(9F).setY(0F).setX(2F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BELUGAMORPH, (new RenderItemSummoner(AVP.resources().models().BELUGAMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PREDALIEN_BURSTER, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER_PREDALIEN)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_QUEEN_BURSTER, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER_QUEEN)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_RUNNER_BURSTER, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER_RUNNER)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BABYHEAD, (new RenderItemSummoner(AVP.resources().models().BABYHEAD)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BAT_XENO, (new RenderItemSummoner(AVP.resources().models().BAT_XENO)).setScale(7.5F).setY(1F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BOILER, (new RenderItemSummoner(AVP.resources().models().BOILER)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRACOBURSTER, (new RenderItemSummoner(AVP.resources().models().DRACOBURSTER)).setScale(7.5F).setY(6F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRACO_EGG, (new RenderItemSummoner(AVP.resources().models().DRACO_OVAMORPH)).setScale(20F).setY(-18F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRACOMORPH, (new RenderItemSummoner(AVP.resources().models().DRACOMORPH)).setScale(6F).setY(10F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_MYCELIOMORPH, (new RenderItemSummoner(AVP.resources().models().MYCELIOMORPH)).setScale(9F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PANTHERAMORPH, (new RenderItemSummoner(AVP.resources().models().PANTHERAMORPH)).setScale(7.5F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(PredatorItems.SUMMONER_PREDATOR_HOUND, (new RenderItemSummoner(AVP.resources().models().PREDATOR_HOUND)).setScale(12F).setY(-3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_URSUIDAE, (new RenderItemSummoner(AVP.resources().models().URSUIDAE)).setScale(14F).setY(-8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_VARDA_MONKEY, (new RenderItemSummoner(AVP.resources().models().VARDA_MONKEY)).setScale(16F).setY(-14F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_YAUTJA_MUTANT, (new RenderItemSummoner(AVP.resources().models().MUTANT_YAUTJA)).setScale(9F).setY(6F));

        MapModelTexture<Model88MOD4> _88MOD4 = AVP.resources().models()._88MOD4;
        Renderers.registerItemRenderer(AVPItems.ITEM_PISTOL_BARREL, new RenderItem88Mod4Barrel(_88MOD4, _88MOD4.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_PISTOL_ACTION, new RenderItem88Mod4Action(_88MOD4, _88MOD4.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_PISTOL_STOCK, new RenderItem88Mod4Stock(_88MOD4, _88MOD4.getModel().getStock()));

        MapModelTexture<ModelAK47> AK47 = AVP.resources().models().AK47;
        Renderers.registerItemRenderer(AVPItems.ITEM_AK47_BARREL, new RenderItemAK47Barrel(AK47, AK47.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_AK47_ACTION, new RenderItemAK47Action(AK47, AK47.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_AK47_STOCK, new RenderItemAK47Stock(AK47, AK47.getModel().getStock()));

        MapModelTexture<ModelM4> M4 = AVP.resources().models().M4;
        Renderers.registerItemRenderer(AVPItems.ITEM_M4_BARREL, new RenderItemM4Barrel(M4, M4.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M4_ACTION, new RenderItemM4Action(M4, M4.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M4_STOCK, new RenderItemM4Stock(M4, M4.getModel().getStock()));

        MapModelTexture<ModelM56SG> M56SG = AVP.resources().models().M56SG;
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_ACTION, new RenderItemM56SGAction(M56SG, M56SG.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_AIMING_MODULE, new RenderItemM56SGAimingModule(M56SG, M56SG.getModel().getAccessories()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_BARREL, new RenderItemM56SGBarrel(M56SG, M56SG.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_STOCK, new RenderItemM56SGStock(M56SG, M56SG.getModel().getStock()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_SUPPORT_FRAME, new RenderItemM56SGSupportFrame(M56SG, M56SG.getModel().getPeripherals()));

        MapModelTexture<ModelM41A> M41A = AVP.resources().models().M41A;
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_ACTION, new RenderItemM41AAction(M41A, M41A.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_BARREL, new RenderItemM41ABarrel(M41A, M41A.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_STOCK, new RenderItemM41AStock(M41A, M41A.getModel().getStock()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_PERIPHERALS, new RenderItemM41APeripherals(M41A, M41A.getModel().getPeripherals()));

        MapModelTexture<ModelSniper> SNIPER = AVP.resources().models().SNIPER;
        Renderers.registerItemRenderer(AVPItems.ITEM_SNIPER_BARREL, new RenderItemSniperBarrel(SNIPER, SNIPER.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_SNIPER_ACTION, new RenderItemSniperAction(SNIPER, SNIPER.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_SNIPER_SCOPE, new RenderItemSniperScope(SNIPER, SNIPER.getModel().getScope()));
        Renderers.registerItemRenderer(AVPItems.ITEM_SNIPER_STOCK, new RenderItemSniperStock(SNIPER, SNIPER.getModel().getStock()));
        Renderers.registerItemRenderer(AVPItems.ITEM_SNIPER_PERIPHERALS, new RenderItemSniperPeripherals(SNIPER, SNIPER.getModel().getPeripherals()));
    }

    private void registerTileEntitySpecialRenderers()
    {
        bindTileEntitySpecialRenderer(TileEntityTurret.class, new RenderTurret());
        bindTileEntitySpecialRenderer(TileEntityWorkstation.class, new RenderWorkstation());
        bindTileEntitySpecialRenderer(TileEntityStasisMechanism.class, new RenderStasisMechanism());
        bindTileEntitySpecialRenderer(TileEntityPowerline.class, new RenderPowerline());
        bindTileEntitySpecialRenderer(TileEntityBlastdoor.class, new RenderBlastdoor());
        bindTileEntitySpecialRenderer(TileEntitySevastopolBlastDoor.class, new RenderSevastopolBlastdoor());
        bindTileEntitySpecialRenderer(TileEntityCryostasisTube.class, new RenderCryostasisTube());
        bindTileEntitySpecialRenderer(TileEntityRepulsionGenerator.class, new RenderRepulsionGenerator());
        bindTileEntitySpecialRenderer(TileEntityAssembler.class, new RenderAssembler());
        bindTileEntitySpecialRenderer(TileEntityLightPanel.class, new RenderLightPanel());
        bindTileEntitySpecialRenderer(TileEntityCCFLTube.class, new RenderCCFLTube());
        bindTileEntitySpecialRenderer(TileEntitySolarPanel.class, new RenderSolarPanel());
        bindTileEntitySpecialRenderer(TileEntityNetworkRack.class, new RenderNetworkRack());
        bindTileEntitySpecialRenderer(TileEntityTransformer.class, new RenderTransformer());
        bindTileEntitySpecialRenderer(TileEntityNegativeTransformer.class, new RenderTransformer());
        bindTileEntitySpecialRenderer(TileEntityRedstoneSensor.class, new RenderRedstoneSensor());
        bindTileEntitySpecialRenderer(TileEntityRedstoneEmitter.class, new RenderRedstoneEmitter());
        bindTileEntitySpecialRenderer(TileEntityRedstoneFluxGenerator.class, new RenderRedstoneFluxGenerator());
        bindTileEntitySpecialRenderer(TileEntityPowercell.class, new RenderPowercell());
        bindTileEntitySpecialRenderer(TileEntityAmpule.class, new RenderAmpule());
        bindTileEntitySpecialRenderer(TileEntityLocker.class, new RenderLocker());
        bindTileEntitySpecialRenderer(TileEntityGunLocker.class, new RenderGunLocker());
        bindTileEntitySpecialRenderer(TileEntityMedpod.class, new RenderMedpod());
        bindTileEntitySpecialRenderer(TileEntitySatelliteDish.class, new RenderSatelliteDish());
        bindTileEntitySpecialRenderer(TileEntitySupplyCrate.class, new RenderSupplyCrate());
        bindTileEntitySpecialRenderer(TileEntityHiveResin.class, new RenderHiveResin());
        bindTileEntitySpecialRenderer(TileEntitySkull.class, new RenderSkull());
        bindTileEntitySpecialRenderer(TileEntityGroundFern.class, new RenderGroundFern());
        bindTileEntitySpecialRenderer(TileEntityTreeFern.class, new RenderTreeFern());
        bindTileEntitySpecialRenderer(TileEntityTeslaCoil.class, new RenderTeslaCoil());
    }
}
