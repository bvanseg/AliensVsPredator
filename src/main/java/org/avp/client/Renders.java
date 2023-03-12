package org.avp.client;

import static net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;

import org.alien.AlienBlocks;
import org.avp.AVP;
import org.avp.common.AVPBlocks;
import org.avp.common.ItemHandler;
import org.avp.common.block.BlockSkull;
import org.avp.client.model.items.Model88MOD4;
import org.avp.client.model.items.ModelAK47;
import org.avp.client.model.items.ModelM4;
import org.avp.client.model.items.ModelM41A;
import org.avp.client.model.items.ModelM56SG;
import org.avp.client.model.items.ModelSniper;
import org.avp.client.model.loaders.CustomBlockModelLoader;
import org.avp.client.model.loaders.ReflectiveModelLoader;
import org.avp.client.render.entities.RenderAPC;
import org.avp.client.render.entities.RenderAcidPool;
import org.avp.client.render.entities.RenderAcidProjectile;
import org.avp.client.render.entities.RenderBullet;
import org.avp.client.render.entities.RenderDisc;
import org.avp.client.render.entities.RenderFlame;
import org.avp.client.render.entities.RenderGrenade;
import org.avp.client.render.entities.RenderLaserMine;
import org.avp.client.render.entities.RenderLiquidLatexPool;
import org.avp.client.render.entities.RenderMechanism;
import org.avp.client.render.entities.RenderMedpodEntity;
import org.avp.client.render.entities.RenderPlasmaBlast;
import org.avp.client.render.entities.RenderShuriken;
import org.avp.client.render.entities.RenderSpear;
import org.avp.client.render.entities.RenderSporePod;
import org.avp.client.render.entities.RenderSupplyChute;
import org.avp.client.render.entities.RenderWristbracer;
import org.avp.client.render.entities.living.RenderAethon;
import org.avp.client.render.entities.living.RenderBabyhead;
import org.avp.client.render.entities.living.RenderBatXenomorph;
import org.avp.client.render.entities.living.RenderBelugaburster;
import org.avp.client.render.entities.living.RenderBelugamorph;
import org.avp.client.render.entities.living.RenderBoiler;
import org.avp.client.render.entities.living.RenderChestburster;
import org.avp.client.render.entities.living.RenderCombatSynthetic;
import org.avp.client.render.entities.living.RenderCrusher;
import org.avp.client.render.entities.living.RenderDeacon;
import org.avp.client.render.entities.living.RenderDeaconAdult;
import org.avp.client.render.entities.living.RenderDeaconShark;
import org.avp.client.render.entities.living.RenderDracoEgg;
import org.avp.client.render.entities.living.RenderDracoburster;
import org.avp.client.render.entities.living.RenderDracomorph;
import org.avp.client.render.entities.living.RenderDrone;
import org.avp.client.render.entities.living.RenderEngineer;
import org.avp.client.render.entities.living.RenderFacehugger;
import org.avp.client.render.entities.living.RenderGooMutant;
import org.avp.client.render.entities.living.RenderHammerpede;
import org.avp.client.render.entities.living.RenderMarine;
import org.avp.client.render.entities.living.RenderMatriarch;
import org.avp.client.render.entities.living.RenderMyceliomorph;
import org.avp.client.render.entities.living.RenderNauticomorph;
import org.avp.client.render.entities.living.RenderOctohugger;
import org.avp.client.render.entities.living.RenderOvamorph;
import org.avp.client.render.entities.living.RenderOvamorphGiger;
import org.avp.client.render.entities.living.RenderPantheramorph;
import org.avp.client.render.entities.living.RenderPraetorian;
import org.avp.client.render.entities.living.RenderPredalien;
import org.avp.client.render.entities.living.RenderPredalienChestburster;
import org.avp.client.render.entities.living.RenderPredatorHound;
import org.avp.client.render.entities.living.RenderQueenChestburster;
import org.avp.client.render.entities.living.RenderRoyalFacehugger;
import org.avp.client.render.entities.living.RenderRunnerChestburster;
import org.avp.client.render.entities.living.RenderRunnerDrone;
import org.avp.client.render.entities.living.RenderRunnerWarrior;
import org.avp.client.render.entities.living.RenderScelemur;
import org.avp.client.render.entities.living.RenderSpaceJockey;
import org.avp.client.render.entities.living.RenderSpitter;
import org.avp.client.render.entities.living.RenderTrilobite;
import org.avp.client.render.entities.living.RenderUltramorph;
import org.avp.client.render.entities.living.RenderUrsuidae;
import org.avp.client.render.entities.living.RenderWarrior;
import org.avp.client.render.entities.living.RenderYautjaBerserker;
import org.avp.client.render.entities.living.RenderYautjaMutant;
import org.avp.client.render.entities.living.RenderYautjaWarrior;
import org.avp.client.render.items.RenderItem88MOD4;
import org.avp.client.render.items.RenderItemAK47;
import org.avp.client.render.items.RenderItemAPC;
import org.avp.client.render.items.RenderItemAmpule;
import org.avp.client.render.items.RenderItemBlastDoor;
import org.avp.client.render.items.RenderItemCCFLTube;
import org.avp.client.render.items.RenderItemCryostasisTube;
import org.avp.client.render.items.RenderItemGroundFern;
import org.avp.client.render.items.RenderItemGunLocker;
import org.avp.client.render.items.RenderItemLightPanel;
import org.avp.client.render.items.RenderItemLocker;
import org.avp.client.render.items.RenderItemM240ICU;
import org.avp.client.render.items.RenderItemM4;
import org.avp.client.render.items.RenderItemM40;
import org.avp.client.render.items.RenderItemM41A;
import org.avp.client.render.items.RenderItemM56SG;
import org.avp.client.render.items.RenderItemMedpod;
import org.avp.client.render.items.RenderItemMotionTracker;
import org.avp.client.render.items.RenderItemNetworkRack;
import org.avp.client.render.items.RenderItemNetworkRackModule;
import org.avp.client.render.items.RenderItemNostromoFlamethrower;
import org.avp.client.render.items.RenderItemPlasmaCannon;
import org.avp.client.render.items.RenderItemPowercell;
import org.avp.client.render.items.RenderItemPowerline;
import org.avp.client.render.items.RenderItemRedstoneFluxGenerator;
import org.avp.client.render.items.RenderItemRepulsionGenerator;
import org.avp.client.render.items.RenderItemSatelliteDish;
import org.avp.client.render.items.RenderItemSevastopolBlastdoor;
import org.avp.client.render.items.RenderItemSkull;
import org.avp.client.render.items.RenderItemSniper;
import org.avp.client.render.items.RenderItemSolarPanel;
import org.avp.client.render.items.RenderItemSpear;
import org.avp.client.render.items.RenderItemSporePod;
import org.avp.client.render.items.RenderItemStasisMechanism;
import org.avp.client.render.items.RenderItemStunBaton;
import org.avp.client.render.items.RenderItemSummoner;
import org.avp.client.render.items.RenderItemSupplyChute;
import org.avp.client.render.items.RenderItemSupplyCrate;
import org.avp.client.render.items.RenderItemTeslaCoil;
import org.avp.client.render.items.RenderItemTransformer;
import org.avp.client.render.items.RenderItemTreeFern;
import org.avp.client.render.items.RenderItemTurret;
import org.avp.client.render.items.RenderItemWorkstation;
import org.avp.client.render.items.RenderItemWristbracer;
import org.avp.client.render.items.RenderItemWristbracerBlades;
import org.avp.client.render.items.firearms.parts.RenderItem88Mod4Action;
import org.avp.client.render.items.firearms.parts.RenderItem88Mod4Barrel;
import org.avp.client.render.items.firearms.parts.RenderItem88Mod4Stock;
import org.avp.client.render.items.firearms.parts.RenderItemAK47Action;
import org.avp.client.render.items.firearms.parts.RenderItemAK47Barrel;
import org.avp.client.render.items.firearms.parts.RenderItemAK47Stock;
import org.avp.client.render.items.firearms.parts.RenderItemM41AAction;
import org.avp.client.render.items.firearms.parts.RenderItemM41ABarrel;
import org.avp.client.render.items.firearms.parts.RenderItemM41APeripherals;
import org.avp.client.render.items.firearms.parts.RenderItemM41AStock;
import org.avp.client.render.items.firearms.parts.RenderItemM4Action;
import org.avp.client.render.items.firearms.parts.RenderItemM4Barrel;
import org.avp.client.render.items.firearms.parts.RenderItemM4Stock;
import org.avp.client.render.items.firearms.parts.RenderItemM56SGAction;
import org.avp.client.render.items.firearms.parts.RenderItemM56SGAimingModule;
import org.avp.client.render.items.firearms.parts.RenderItemM56SGBarrel;
import org.avp.client.render.items.firearms.parts.RenderItemM56SGStock;
import org.avp.client.render.items.firearms.parts.RenderItemM56SGSupportFrame;
import org.avp.client.render.items.firearms.parts.RenderItemSniperAction;
import org.avp.client.render.items.firearms.parts.RenderItemSniperBarrel;
import org.avp.client.render.items.firearms.parts.RenderItemSniperPeripherals;
import org.avp.client.render.items.firearms.parts.RenderItemSniperScope;
import org.avp.client.render.items.firearms.parts.RenderItemSniperStock;
import org.avp.client.render.tile.RenderAmpule;
import org.avp.client.render.tile.RenderAssembler;
import org.avp.client.render.tile.RenderBlastdoor;
import org.avp.client.render.tile.RenderCCFLTube;
import org.avp.client.render.tile.RenderCryostasisTube;
import org.avp.client.render.tile.RenderGunLocker;
import org.avp.client.render.tile.RenderHiveResin;
import org.avp.client.render.tile.RenderLightPanel;
import org.avp.client.render.tile.RenderLocker;
import org.avp.client.render.tile.RenderMedpod;
import org.avp.client.render.tile.RenderNetworkRack;
import org.avp.client.render.tile.RenderPowercell;
import org.avp.client.render.tile.RenderPowerline;
import org.avp.client.render.tile.RenderRedstoneEmitter;
import org.avp.client.render.tile.RenderRedstoneFluxGenerator;
import org.avp.client.render.tile.RenderRedstoneSensor;
import org.avp.client.render.tile.RenderRepulsionGenerator;
import org.avp.client.render.tile.RenderSatelliteDish;
import org.avp.client.render.tile.RenderSevastopolBlastdoor;
import org.avp.client.render.tile.RenderSkull;
import org.avp.client.render.tile.RenderSolarPanel;
import org.avp.client.render.tile.RenderStasisMechanism;
import org.avp.client.render.tile.RenderSupplyCrate;
import org.avp.client.render.tile.RenderTeslaCoil;
import org.avp.client.render.tile.RenderTransformer;
import org.avp.client.render.tile.RenderTurret;
import org.avp.client.render.tile.RenderWorkstation;
import org.avp.client.render.tile.plants.RenderGroundFern;
import org.avp.client.render.tile.plants.RenderTreeFern;
import org.avp.client.render.transforms.CryostasisTubeRenderers;
import org.avp.client.render.transforms.FaceLocationTransforms;
import org.avp.client.render.transforms.MedpodTransforms;
import org.avp.client.render.transforms.VanillaFaceLocationTransforms;
import org.avp.common.entities.EntityAPC;
import org.avp.common.entities.EntityAcidPool;
import org.avp.common.entities.EntityAcidProjectile;
import org.avp.common.entities.EntityBullet;
import org.avp.common.entities.EntityFlame;
import org.avp.common.entities.EntityGrenade;
import org.avp.common.entities.EntityLaserMine;
import org.avp.common.entities.EntityLiquidLatexPool;
import org.avp.common.entities.EntityMechanism;
import org.avp.common.entities.EntityMedpod;
import org.avp.common.entities.EntityPlasma;
import org.avp.common.entities.EntityShuriken;
import org.avp.common.entities.EntitySmartDisc;
import org.avp.common.entities.EntitySpear;
import org.avp.common.entities.EntitySporePod;
import org.avp.common.entities.EntitySupplyChute;
import org.avp.common.entities.EntitySupplyChuteMarines;
import org.avp.common.entities.EntitySupplyChuteSeegson;
import org.avp.common.entities.EntityWristbracer;
import org.avp.common.entities.living.EntityAethon;
import org.avp.common.entities.living.EntityCombatSynthetic;
import org.avp.common.entities.living.EntityDracoEgg;
import org.avp.common.entities.living.EntityMarine;
import org.avp.common.entities.living.EntityPredatorHound;
import org.avp.common.entities.living.species.engineer.EntityEngineer;
import org.avp.common.entities.living.species.engineer.EntitySpaceJockey;
import org.avp.common.entities.living.species.species223ode.EntityDeacon;
import org.avp.common.entities.living.species.species223ode.EntityDeaconAdult;
import org.avp.common.entities.living.species.species223ode.EntityTrilobite;
import org.avp.common.entities.living.species.xenomorphs.EntityBatXeno;
import org.avp.common.entities.living.species.xenomorphs.EntityBoiler;
import org.avp.common.entities.living.species.xenomorphs.EntityChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityCrusher;
import org.avp.common.entities.living.species.xenomorphs.EntityDracoburster;
import org.avp.common.entities.living.species.xenomorphs.EntityDracomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityMatriarch;
import org.avp.common.entities.living.species.xenomorphs.EntityMyceliomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityNauticomorph;
import org.avp.common.entities.living.species.xenomorphs.EntityOvamorph;
import org.avp.common.entities.living.species.xenomorphs.EntityOvamorphGiger;
import org.avp.common.entities.living.species.xenomorphs.EntityPantheramorph;
import org.avp.common.entities.living.species.xenomorphs.EntityPraetorian;
import org.avp.common.entities.living.species.xenomorphs.EntityPredalien;
import org.avp.common.entities.living.species.xenomorphs.EntityPredalienChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityQueenChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerChestburster;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerDrone;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerWarrior;
import org.avp.common.entities.living.species.xenomorphs.EntitySpitter;
import org.avp.common.entities.living.species.xenomorphs.EntityUltramorph;
import org.avp.common.entities.living.species.xenomorphs.EntityWarrior;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityFacehugger;
import org.avp.common.entities.living.species.xenomorphs.parasites.EntityRoyalFacehugger;
import org.avp.common.entities.living.species.yautja.EntityYautjaBerserker;
import org.avp.common.entities.living.species.yautja.EntityYautjaMutant;
import org.avp.common.entities.living.species.yautja.EntityYautjaWarrior;
import org.avp.common.entities.living.vardic.EntityBabyhead;
import org.avp.common.entities.living.vardic.EntityBelugaburster;
import org.avp.common.entities.living.vardic.EntityBelugamorph;
import org.avp.common.entities.living.vardic.EntityDeaconShark;
import org.avp.common.entities.living.vardic.EntityGooMutant;
import org.avp.common.entities.living.vardic.EntityHammerpede;
import org.avp.common.entities.living.vardic.EntityOctohugger;
import org.avp.common.entities.living.vardic.EntityScelemur;
import org.avp.common.entities.living.vardic.EntityUrsuidae;
import org.avp.common.tile.TileEntityAmpule;
import org.avp.common.tile.TileEntityAssembler;
import org.avp.common.tile.TileEntityBlastdoor;
import org.avp.common.tile.TileEntityCCFLTube;
import org.avp.common.tile.TileEntityCryostasisTube;
import org.avp.common.tile.TileEntityGunLocker;
import org.avp.common.tile.TileEntityHiveResin;
import org.avp.common.tile.TileEntityLightPanel;
import org.avp.common.tile.TileEntityLocker;
import org.avp.common.tile.TileEntityMedpod;
import org.avp.common.tile.TileEntityNegativeTransformer;
import org.avp.common.tile.TileEntityNetworkRack;
import org.avp.common.tile.TileEntityPowercell;
import org.avp.common.tile.TileEntityPowerline;
import org.avp.common.tile.TileEntityRedstoneEmitter;
import org.avp.common.tile.TileEntityRedstoneFluxGenerator;
import org.avp.common.tile.TileEntityRedstoneSensor;
import org.avp.common.tile.TileEntityRepulsionGenerator;
import org.avp.common.tile.TileEntitySatelliteDish;
import org.avp.common.tile.TileEntitySevastopolBlastDoor;
import org.avp.common.tile.TileEntitySkull;
import org.avp.common.tile.TileEntitySolarPanel;
import org.avp.common.tile.TileEntityStasisMechanism;
import org.avp.common.tile.TileEntitySupplyCrate;
import org.avp.common.tile.TileEntityTeslaCoil;
import org.avp.common.tile.TileEntityTransformer;
import org.avp.common.tile.TileEntityTurret;
import org.avp.common.tile.TileEntityWorkstation;
import org.avp.common.tile.plants.TileEntityGroundFern;
import org.avp.common.tile.plants.TileEntityTreeFern;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.core.mods.IPreInitEvent;
import com.asx.mdx.lib.client.Renderers;
import com.asx.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
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
import org.lib.BlockRegistryUtil;
import org.predator.PredatorBlocks;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class Renders implements IInitEvent, IPreInitEvent
{
    public static Renders instance = new Renders();

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

            ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
                @Override
                public ModelResourceLocation getModelLocation(ItemStack stack)
                {
                    return modelResourceLocation;
                }
            });

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
            AVP.log().error("Error registerring skull block renderer. Type mismatch: " + block.getTranslationKey());
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
        Renderers.registerItemRenderer(ItemHandler.itemWristbracer, new RenderItemWristbracer());
        Renderers.registerItemRenderer(ItemHandler.itemStunBaton, new RenderItemStunBaton());
        Renderers.registerItemRenderer(ItemHandler.itemWristbracerBlades, new RenderItemWristbracerBlades());
        Renderers.registerItemRenderer(ItemHandler.itemPlasmaCannon, new RenderItemPlasmaCannon());
        Renderers.registerItemRenderer(ItemHandler.itemSpear, new RenderItemSpear());
        Renderers.registerItemRenderer(ItemHandler.itemM240ICU, new RenderItemM240ICU());
        Renderers.registerItemRenderer(ItemHandler.itemSevastopolFlamethrower, new RenderItemNostromoFlamethrower());
        Renderers.registerItemRenderer(ItemHandler.itemM41A, new RenderItemM41A());
        Renderers.registerItemRenderer(ItemHandler.itemM56SG, new RenderItemM56SG());
        Renderers.registerItemRenderer(ItemHandler.itemAK47, new RenderItemAK47());
        Renderers.registerItemRenderer(ItemHandler.itemM4, new RenderItemM4());
        Renderers.registerItemRenderer(ItemHandler.itemPistol, new RenderItem88MOD4());
        Renderers.registerItemRenderer(ItemHandler.itemSniper, new RenderItemSniper());
        Renderers.registerItemRenderer(ItemHandler.itemMotionTracker, new RenderItemMotionTracker());
        Renderers.registerItemRenderer(ItemHandler.itemAPC, new RenderItemAPC());
        Renderers.registerItemRenderer(ItemHandler.itemGrenade, new RenderItemM40(AVP.resources().models().M40GRENADE));
        Renderers.registerItemRenderer(ItemHandler.itemIncendiaryGrenade, new RenderItemM40(AVP.resources().models().M40GRENADE_INCENDIARY));
        Renderers.registerItemRenderer(ItemHandler.summonerSporePod, new RenderItemSporePod());
        
        Renderers.registerItemRenderer(ItemHandler.itemSupplyChute, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(ItemHandler.itemSupplyChuteMarines, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(ItemHandler.itemSupplyChuteSeegson, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(ItemHandler.rackModule1, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(ItemHandler.rackModule2, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(ItemHandler.rackModule3, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(ItemHandler.rackModule4, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(ItemHandler.rackModule5, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(ItemHandler.rackModule6, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(ItemHandler.rackModule7, new RenderItemNetworkRackModule());
        Renderers.registerItemRenderer(ItemHandler.rackModule8, new RenderItemNetworkRackModule());

        Renderers.registerItemRenderer(ItemHandler.summonerDrone, (new RenderItemSummoner(AVP.resources().models().DRONE_ADVANCED)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerDeacon, (new RenderItemSummoner(AVP.resources().models().DEACON)).setScale(7F).setY(4F));
        Renderers.registerItemRenderer(ItemHandler.summonerDeaconAdult, (new RenderItemSummoner(AVP.resources().models().DEACON_ADULT)).setScale(7F).setY(4F));
        Renderers.registerItemRenderer(ItemHandler.summonerWarrior, (new RenderItemSummoner(AVP.resources().models().WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(ItemHandler.summonerRunnerDrone, (new RenderItemSummoner(AVP.resources().models().RUNNER_DRONE)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerRunnerWarrior, (new RenderItemSummoner(AVP.resources().models().RUNNER_WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(ItemHandler.summonerPraetorian, (new RenderItemSummoner(AVP.resources().models().PRAETORIAN)).setScale(7.5F).setY(7.5F));
        Renderers.registerItemRenderer(ItemHandler.summonerSpitter, (new RenderItemSummoner(AVP.resources().models().SPITTER)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(ItemHandler.summonerCrusher, (new RenderItemSummoner(AVP.resources().models().CRUSHER)).setScale(7.5F).setY(9.5F));
        Renderers.registerItemRenderer(ItemHandler.summonerQueen, (new RenderItemSummoner(AVP.resources().models().MATRIARCH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerOvamorph, (new RenderItemSummoner(AVP.resources().models().OVAMORPH)).setScale(20F).setY(-16F));
        Renderers.registerItemRenderer(ItemHandler.summonerOvamorphGiger, (new RenderItemSummoner(AVP.resources().models().OVAMORPH_GIGER)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(ItemHandler.summonerChestburster, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.summonerFacehugger, (new RenderItemSummoner(AVP.resources().models().FACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.summonerRoyalFacehugger, (new RenderItemSummoner(AVP.resources().models().ROYALFACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.summonerMarine, (new RenderItemSummoner(AVP.resources().models().MARINE)).setScale(16F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.summonerYautjaWarrior, (new RenderItemSummoner(AVP.resources().models().YAUTJA_WARRIOR)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerPredalien, (new RenderItemSummoner(AVP.resources().models().PREDALIEN)).setScale(8F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerAqua, (new RenderItemSummoner(AVP.resources().models().NAUTICOMORPH_XENOMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerCombatSynthetic, (new RenderItemSummoner(AVP.resources().models().COMBAT_SYNTHETIC)).setScale(16F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.summonerHammerpede, (new RenderItemSummoner(AVP.resources().models().HAMMERPEDE)).setScale(10.5F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerTrilobite, (new RenderItemSummoner(AVP.resources().models().TRILOBITE)).setScale(8F).setY(4F));
        Renderers.registerItemRenderer(ItemHandler.summonerSpaceJockey, (new RenderItemSummoner(AVP.resources().models().SPACE_JOCKEY)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(ItemHandler.summonerEngineer, (new RenderItemSummoner(AVP.resources().models().ENGINEER)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(ItemHandler.summonerYautjaBerserker, (new RenderItemSummoner(AVP.resources().models().YAUTJA_BERSERKER)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerDeaconShark, (new RenderItemSummoner(AVP.resources().models().DEACON_SHARK)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerUltramorph, (new RenderItemSummoner(AVP.resources().models().ULTRAMORPH)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerGooMutant, (new RenderItemSummoner(AVP.resources().models().GOO_MUTANT)).setScale(10F).setY(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerAethon, (new RenderItemSummoner(AVP.resources().models().AETHON)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerOctohugger, (new RenderItemSummoner(AVP.resources().models().OCTOHUGGER)).setScale(24F).setY(-4F));
        Renderers.registerItemRenderer(ItemHandler.summonerBelugaburster, (new RenderItemSummoner(AVP.resources().models().BELUGABURSTER)).setScale(9F).setY(0F).setX(2F));
        Renderers.registerItemRenderer(ItemHandler.summonerBelugamorph, (new RenderItemSummoner(AVP.resources().models().BELUGAMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerPredalienBurster, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER_PREDALIEN)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.summonerQueenBurster, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER_QUEEN)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.summonerRunnerBurster, (new RenderItemSummoner(AVP.resources().models().CHESTBUSTER_RUNNER)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerBabyhead, (new RenderItemSummoner(AVP.resources().models().BABYHEAD)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerBatXeno, (new RenderItemSummoner(AVP.resources().models().BAT_XENO)).setScale(7.5F).setY(1F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerBoiler, (new RenderItemSummoner(AVP.resources().models().BOILER)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerDracoburster, (new RenderItemSummoner(AVP.resources().models().DRACOBURSTER)).setScale(7.5F).setY(6F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerDracoEgg, (new RenderItemSummoner(AVP.resources().models().DRACO_OVAMORPH)).setScale(20F).setY(-18F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerDracomorph, (new RenderItemSummoner(AVP.resources().models().DRACOMORPH)).setScale(6F).setY(10F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerMyceliomorph, (new RenderItemSummoner(AVP.resources().models().MYCELIOMORPH)).setScale(9F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerPantheramorph, (new RenderItemSummoner(AVP.resources().models().PANTHERAMORPH)).setScale(7.5F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerPredatorHound, (new RenderItemSummoner(AVP.resources().models().PREDATOR_HOUND)).setScale(12F).setY(-3F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerUrsuidae, (new RenderItemSummoner(AVP.resources().models().URSUIDAE)).setScale(14F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerVardaMonkey, (new RenderItemSummoner(AVP.resources().models().VARDA_MONKEY)).setScale(16F).setY(-14F));
        Renderers.registerItemRenderer(ItemHandler.Experimental.summonerYautjaMutant, (new RenderItemSummoner(AVP.resources().models().MUTANT_YAUTJA)).setScale(9F).setY(6F));

        MapModelTexture<Model88MOD4> _88MOD4 = AVP.resources().models()._88MOD4;
        Renderers.registerItemRenderer(ItemHandler.itemPistolBarrel, new RenderItem88Mod4Barrel(_88MOD4, _88MOD4.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemPistolAction, new RenderItem88Mod4Action(_88MOD4, _88MOD4.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemPistolStock, new RenderItem88Mod4Stock(_88MOD4, _88MOD4.getModel().getStock()));

        MapModelTexture<ModelAK47> AK47 = AVP.resources().models().AK47;
        Renderers.registerItemRenderer(ItemHandler.itemAK47Barrel, new RenderItemAK47Barrel(AK47, AK47.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemAK47Action, new RenderItemAK47Action(AK47, AK47.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemAK47Stock, new RenderItemAK47Stock(AK47, AK47.getModel().getStock()));

        MapModelTexture<ModelM4> M4 = AVP.resources().models().M4;
        Renderers.registerItemRenderer(ItemHandler.itemM4Barrel, new RenderItemM4Barrel(M4, M4.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemM4Action, new RenderItemM4Action(M4, M4.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemM4Stock, new RenderItemM4Stock(M4, M4.getModel().getStock()));

        MapModelTexture<ModelM56SG> M56SG = AVP.resources().models().M56SG;
        Renderers.registerItemRenderer(ItemHandler.itemM56SGAction, new RenderItemM56SGAction(M56SG, M56SG.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGAimingModule, new RenderItemM56SGAimingModule(M56SG, M56SG.getModel().getAccessories()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGBarrel, new RenderItemM56SGBarrel(M56SG, M56SG.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGStock, new RenderItemM56SGStock(M56SG, M56SG.getModel().getStock()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGSupportFrame, new RenderItemM56SGSupportFrame(M56SG, M56SG.getModel().getPeripherals()));

        MapModelTexture<ModelM41A> M41A = AVP.resources().models().M41A;
        Renderers.registerItemRenderer(ItemHandler.itemM41AAction, new RenderItemM41AAction(M41A, M41A.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemM41ABarrel, new RenderItemM41ABarrel(M41A, M41A.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemM41AStock, new RenderItemM41AStock(M41A, M41A.getModel().getStock()));
        Renderers.registerItemRenderer(ItemHandler.itemM41APeripherals, new RenderItemM41APeripherals(M41A, M41A.getModel().getPeripherals()));

        MapModelTexture<ModelSniper> SNIPER = AVP.resources().models().SNIPER;
        Renderers.registerItemRenderer(ItemHandler.itemSniperBarrel, new RenderItemSniperBarrel(SNIPER, SNIPER.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemSniperAction, new RenderItemSniperAction(SNIPER, SNIPER.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemSniperScope, new RenderItemSniperScope(SNIPER, SNIPER.getModel().getScope()));
        Renderers.registerItemRenderer(ItemHandler.itemSniperStock, new RenderItemSniperStock(SNIPER, SNIPER.getModel().getStock()));
        Renderers.registerItemRenderer(ItemHandler.itemSniperPeripherals, new RenderItemSniperPeripherals(SNIPER, SNIPER.getModel().getPeripherals()));
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
