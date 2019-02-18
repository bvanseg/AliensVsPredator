package org.avp.client;

import static net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;

import org.avp.AliensVsPredator;
import org.avp.BlockHandler;
import org.avp.ItemHandler;
import org.avp.client.model.items.Model88MOD4;
import org.avp.client.model.items.ModelAK47;
import org.avp.client.model.items.ModelM4;
import org.avp.client.model.items.ModelM41A;
import org.avp.client.model.items.ModelM56SG;
import org.avp.client.model.items.ModelSniper;
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
import org.avp.client.render.entities.living.RenderAqua;
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
import org.avp.client.render.entities.living.RenderOctohugger;
import org.avp.client.render.entities.living.RenderOvamorph;
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
import org.avp.client.render.items.RenderItemSporepod;
import org.avp.client.render.items.RenderItemStasisMechanism;
import org.avp.client.render.items.RenderItemStunBaton;
import org.avp.client.render.items.RenderItemSummoner;
import org.avp.client.render.items.RenderItemSupplyChute;
import org.avp.client.render.items.RenderItemSupplyCrate;
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
import org.avp.client.render.tile.RenderTransformer;
import org.avp.client.render.tile.RenderTurret;
import org.avp.client.render.tile.RenderWorkstation;
import org.avp.client.render.tile.plants.RenderGroundFern;
import org.avp.client.render.tile.plants.RenderTreeFern;
import org.avp.client.render.transforms.CryostasisTubeRenderers;
import org.avp.client.render.transforms.FaceLocationTransforms;
import org.avp.client.render.transforms.MedpodTransforms;
import org.avp.client.render.transforms.VanillaFaceLocationTransforms;
import org.avp.entities.EntityAPC;
import org.avp.entities.EntityAcidPool;
import org.avp.entities.EntityAcidProjectile;
import org.avp.entities.EntityBullet;
import org.avp.entities.EntityFlame;
import org.avp.entities.EntityGrenade;
import org.avp.entities.EntityLaserMine;
import org.avp.entities.EntityLiquidLatexPool;
import org.avp.entities.EntityMechanism;
import org.avp.entities.EntityMedpod;
import org.avp.entities.EntityPlasma;
import org.avp.entities.EntityShuriken;
import org.avp.entities.EntitySmartDisc;
import org.avp.entities.EntitySpear;
import org.avp.entities.EntitySporePod;
import org.avp.entities.EntitySupplyChute;
import org.avp.entities.EntitySupplyChuteMarines;
import org.avp.entities.EntitySupplyChuteSeegson;
import org.avp.entities.EntityWristbracer;
import org.avp.entities.living.EntityAethon;
import org.avp.entities.living.EntityAqua;
import org.avp.entities.living.EntityBabyhead;
import org.avp.entities.living.EntityBatXeno;
import org.avp.entities.living.EntityBelugaburster;
import org.avp.entities.living.EntityBelugamorph;
import org.avp.entities.living.EntityBoiler;
import org.avp.entities.living.EntityChestburster;
import org.avp.entities.living.EntityCombatSynthetic;
import org.avp.entities.living.EntityCrusher;
import org.avp.entities.living.EntityDeacon;
import org.avp.entities.living.EntityDeaconAdult;
import org.avp.entities.living.EntityDeaconShark;
import org.avp.entities.living.EntityDracoEgg;
import org.avp.entities.living.EntityDracoburster;
import org.avp.entities.living.EntityDracomorph;
import org.avp.entities.living.EntityDrone;
import org.avp.entities.living.EntityEngineer;
import org.avp.entities.living.EntityFacehugger;
import org.avp.entities.living.EntityGooMutant;
import org.avp.entities.living.EntityHammerpede;
import org.avp.entities.living.EntityMarine;
import org.avp.entities.living.EntityMatriarch;
import org.avp.entities.living.EntityMyceliomorph;
import org.avp.entities.living.EntityOctohugger;
import org.avp.entities.living.EntityOvamorph;
import org.avp.entities.living.EntityPantheramorph;
import org.avp.entities.living.EntityPraetorian;
import org.avp.entities.living.EntityPredalien;
import org.avp.entities.living.EntityPredalienChestburster;
import org.avp.entities.living.EntityPredatorHound;
import org.avp.entities.living.EntityQueenChestburster;
import org.avp.entities.living.EntityRoyalFacehugger;
import org.avp.entities.living.EntityRunnerChestburster;
import org.avp.entities.living.EntityRunnerDrone;
import org.avp.entities.living.EntityRunnerWarrior;
import org.avp.entities.living.EntityScelemur;
import org.avp.entities.living.EntitySpaceJockey;
import org.avp.entities.living.EntitySpitter;
import org.avp.entities.living.EntityTrilobite;
import org.avp.entities.living.EntityUltramorph;
import org.avp.entities.living.EntityUrsuidae;
import org.avp.entities.living.EntityWarrior;
import org.avp.entities.living.EntityYautjaBerserker;
import org.avp.entities.living.EntityYautjaMutant;
import org.avp.entities.living.EntityYautjaWarrior;
import org.avp.tile.TileEntityAmpule;
import org.avp.tile.TileEntityAssembler;
import org.avp.tile.TileEntityBlastdoor;
import org.avp.tile.TileEntityCCFLTube;
import org.avp.tile.TileEntityCryostasisTube;
import org.avp.tile.TileEntityGunLocker;
import org.avp.tile.TileEntityHiveResin;
import org.avp.tile.TileEntityLightPanel;
import org.avp.tile.TileEntityLocker;
import org.avp.tile.TileEntityMedpod;
import org.avp.tile.TileEntityNegativeTransformer;
import org.avp.tile.TileEntityNetworkRack;
import org.avp.tile.TileEntityPowercell;
import org.avp.tile.TileEntityPowerline;
import org.avp.tile.TileEntityRedstoneEmitter;
import org.avp.tile.TileEntityRedstoneFluxGenerator;
import org.avp.tile.TileEntityRedstoneSensor;
import org.avp.tile.TileEntityRepulsionGenerator;
import org.avp.tile.TileEntitySatelliteDish;
import org.avp.tile.TileEntitySevastopolBlastDoor;
import org.avp.tile.TileEntitySkull;
import org.avp.tile.TileEntitySolarPanel;
import org.avp.tile.TileEntityStasisMechanism;
import org.avp.tile.TileEntitySupplyCrate;
import org.avp.tile.TileEntityTransformer;
import org.avp.tile.TileEntityTurret;
import org.avp.tile.TileEntityWorkstation;
import org.avp.tile.plants.TileEntityGroundFern;
import org.avp.tile.plants.TileEntityTreeFern;

import com.arisux.mdx.lib.client.util.models.MapModelTexture;
import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.game.IPreInitEvent;
import com.arisux.mdx.lib.game.Renderers;

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
        for (BlockFluidBase block : BlockHandler.getFluids())
        {
            final Item item = Item.getItemFromBlock(block);
            final ModelResourceLocation modelResourceLocation = new ModelResourceLocation(AliensVsPredator.Properties.DOMAIN + block.getFluid().getName(), "fluid");

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
        OBJLoader.INSTANCE.addDomain(AliensVsPredator.Properties.ID);
        ModelLoaderRegistry.registerLoader(ReflectiveModelLoader.INSTANCE);
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
        Renderers.registerRenderer(EntityAqua.class, RenderAqua.class);
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
    
    private void registerBlockItemRenderers()
    {
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullEngineer), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullJockey), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullXeno), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullXenoWarrior), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullYautja), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullMatriarch), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullProtomorph), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.skullNeomorph), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.biomaskClassic), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.biomaskBerserker), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.biomaskFalconer), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.biomaskTracker), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.headAethon), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.headGigerAlien), new RenderItemSkull());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.turret), new RenderItemTurret());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.terminal), new RenderItemWorkstation());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.stasisMechanism), new RenderItemStasisMechanism());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.cryoTube), new RenderItemCryostasisTube());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.repulsionGenerator), new RenderItemRepulsionGenerator());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.blastDoor), new RenderItemBlastDoor());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.lightPanel), new RenderItemLightPanel());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.ccflTube), new RenderItemCCFLTube());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.powerline), new RenderItemPowerline());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.solarPanel), new RenderItemSolarPanel());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.powercell), new RenderItemPowercell());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.transformer), new RenderItemTransformer());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.stepdownTransformer), new RenderItemTransformer());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.universalGenerator), new RenderItemRedstoneFluxGenerator());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.ampule), new RenderItemAmpule());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.locker), new RenderItemLocker());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.gunLocker), new RenderItemGunLocker());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.medpod), new RenderItemMedpod());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.satelliteDish), new RenderItemSatelliteDish());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.sevastopolBlastDoor), new RenderItemSevastopolBlastdoor());

        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.supplyCrate), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.crateMarines), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.crateSeegson), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.networkRack), new RenderItemNetworkRack());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.groundFern), new RenderItemGroundFern());
        Renderers.registerBlockItemRenderer(BlockHandler.getItemFromBlock(BlockHandler.treeFern), new RenderItemTreeFern());
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
        Renderers.registerItemRenderer(ItemHandler.itemGrenade, new RenderItemM40(AliensVsPredator.resources().models().M40GRENADE));
        Renderers.registerItemRenderer(ItemHandler.itemIncendiaryGrenade, new RenderItemM40(AliensVsPredator.resources().models().M40GRENADE_INCENDIARY));
        Renderers.registerItemRenderer(ItemHandler.sporepod, new RenderItemSporepod());
        
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

        Renderers.registerItemRenderer(ItemHandler.summonerDrone, (new RenderItemSummoner(AliensVsPredator.resources().models().DRONE_ADVANCED)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerDeacon, (new RenderItemSummoner(AliensVsPredator.resources().models().DEACON)).setScale(7F).setY(4F));
        Renderers.registerItemRenderer(ItemHandler.summonerDeaconAdult, (new RenderItemSummoner(AliensVsPredator.resources().models().DEACON_ADULT)).setScale(7F).setY(4F));
        Renderers.registerItemRenderer(ItemHandler.summonerWarrior, (new RenderItemSummoner(AliensVsPredator.resources().models().WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(ItemHandler.summonerRunnerDrone, (new RenderItemSummoner(AliensVsPredator.resources().models().RUNNER_DRONE)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerRunnerWarrior, (new RenderItemSummoner(AliensVsPredator.resources().models().RUNNER_WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(ItemHandler.summonerPraetorian, (new RenderItemSummoner(AliensVsPredator.resources().models().PRAETORIAN)).setScale(7.5F).setY(7.5F));
        Renderers.registerItemRenderer(ItemHandler.summonerSpitter, (new RenderItemSummoner(AliensVsPredator.resources().models().SPITTER)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(ItemHandler.summonerCrusher, (new RenderItemSummoner(AliensVsPredator.resources().models().CRUSHER)).setScale(7.5F).setY(9.5F));
        Renderers.registerItemRenderer(ItemHandler.summonerQueen, (new RenderItemSummoner(AliensVsPredator.resources().models().MATRIARCH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerOvamorph, (new RenderItemSummoner(AliensVsPredator.resources().models().OVAMORPH)).setScale(20F).setY(-16F));
        Renderers.registerItemRenderer(ItemHandler.summonerChestburster, (new RenderItemSummoner(AliensVsPredator.resources().models().CHESTBUSTER)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.summonerFacehugger, (new RenderItemSummoner(AliensVsPredator.resources().models().FACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.summonerRoyalFacehugger, (new RenderItemSummoner(AliensVsPredator.resources().models().ROYALFACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.summonerMarine, (new RenderItemSummoner(AliensVsPredator.resources().models().MARINE)).setScale(10F).setY(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerYautjaWarrior, (new RenderItemSummoner(AliensVsPredator.resources().models().YAUTJA_WARRIOR)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerPredalien, (new RenderItemSummoner(AliensVsPredator.resources().models().PREDALIEN)).setScale(8F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerAqua, (new RenderItemSummoner(AliensVsPredator.resources().models().AQUA_XENOMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerCombatSynthetic, (new RenderItemSummoner(AliensVsPredator.resources().models().COMBAT_SYNTHETIC)).setScale(16F).setY(-12F));
        Renderers.registerItemRenderer(ItemHandler.summonerHammerpede, (new RenderItemSummoner(AliensVsPredator.resources().models().HAMMERPEDE)).setScale(10.5F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerTrilobite, (new RenderItemSummoner(AliensVsPredator.resources().models().TRILOBITE)).setScale(8F).setY(4F));
        Renderers.registerItemRenderer(ItemHandler.summonerSpaceJockey, (new RenderItemSummoner(AliensVsPredator.resources().models().SPACE_JOCKEY)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(ItemHandler.summonerEngineer, (new RenderItemSummoner(AliensVsPredator.resources().models().ENGINEER)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(ItemHandler.summonerYautjaBerserker, (new RenderItemSummoner(AliensVsPredator.resources().models().YAUTJA_BERSERKER)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerDeaconShark, (new RenderItemSummoner(AliensVsPredator.resources().models().DEACON_SHARK)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerUltramorph, (new RenderItemSummoner(AliensVsPredator.resources().models().ULTRAMORPH)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerGooMutant, (new RenderItemSummoner(AliensVsPredator.resources().models().GOO_MUTANT)).setScale(10F).setY(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerAethon, (new RenderItemSummoner(AliensVsPredator.resources().models().AETHON)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(ItemHandler.summonerOctohugger, (new RenderItemSummoner(AliensVsPredator.resources().models().OCTOHUGGER)).setScale(24F).setY(-4F));
        Renderers.registerItemRenderer(ItemHandler.summonerBelugaburster, (new RenderItemSummoner(AliensVsPredator.resources().models().BELUGABURSTER)).setScale(9F).setY(0F).setX(2F));
        Renderers.registerItemRenderer(ItemHandler.summonerBelugamorph, (new RenderItemSummoner(AliensVsPredator.resources().models().BELUGAMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(ItemHandler.summonerPredalienBurster, (new RenderItemSummoner(AliensVsPredator.resources().models().CHESTBUSTER_PREDALIEN)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.summonerQueenBurster, (new RenderItemSummoner(AliensVsPredator.resources().models().CHESTBUSTER_QUEEN)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.summonerRunnerBurster, (new RenderItemSummoner(AliensVsPredator.resources().models().CHESTBUSTER_RUNNER)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(ItemHandler.summonerBabyhead, (new RenderItemSummoner(AliensVsPredator.resources().models().BABYHEAD)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(ItemHandler.summonerBatXeno, (new RenderItemSummoner(AliensVsPredator.resources().models().BAT_XENO)).setScale(7.5F).setY(1F));
        Renderers.registerItemRenderer(ItemHandler.summonerBoiler, (new RenderItemSummoner(AliensVsPredator.resources().models().BOILER)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(ItemHandler.summonerDracoburster, (new RenderItemSummoner(AliensVsPredator.resources().models().DRACOBURSTER)).setScale(7.5F).setY(6F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerDracoEgg, (new RenderItemSummoner(AliensVsPredator.resources().models().DRACO_OVAMORPH)).setScale(20F).setY(-18F));
        Renderers.registerItemRenderer(ItemHandler.summonerDracomorph, (new RenderItemSummoner(AliensVsPredator.resources().models().DRACOMORPH)).setScale(6F).setY(10F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerMyceliomorph, (new RenderItemSummoner(AliensVsPredator.resources().models().MYCELIOMORPH)).setScale(9F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerPantheramorph, (new RenderItemSummoner(AliensVsPredator.resources().models().PANTHERAMORPH)).setScale(7.5F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(ItemHandler.summonerPredatorHound, (new RenderItemSummoner(AliensVsPredator.resources().models().PREDATOR_HOUND)).setScale(12F).setY(-3F));
        Renderers.registerItemRenderer(ItemHandler.summonerUrsuidae, (new RenderItemSummoner(AliensVsPredator.resources().models().URSUIDAE)).setScale(14F).setY(-8F));
        Renderers.registerItemRenderer(ItemHandler.summonerVardaMonkey, (new RenderItemSummoner(AliensVsPredator.resources().models().VARDA_MONKEY)).setScale(16F).setY(-14F));
        Renderers.registerItemRenderer(ItemHandler.summonerYautjaMutant, (new RenderItemSummoner(AliensVsPredator.resources().models().MUTANT_YAUTJA)).setScale(9F).setY(6F));

        MapModelTexture<Model88MOD4> _88MOD4 = AliensVsPredator.resources().models()._88MOD4;
        Renderers.registerItemRenderer(ItemHandler.itemPistolBarrel, new RenderItem88Mod4Barrel(_88MOD4, _88MOD4.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemPistolAction, new RenderItem88Mod4Action(_88MOD4, _88MOD4.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemPistolStock, new RenderItem88Mod4Stock(_88MOD4, _88MOD4.getModel().getStock()));

        MapModelTexture<ModelAK47> AK47 = AliensVsPredator.resources().models().AK47;
        Renderers.registerItemRenderer(ItemHandler.itemAK47Barrel, new RenderItemAK47Barrel(AK47, AK47.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemAK47Action, new RenderItemAK47Action(AK47, AK47.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemAK47Stock, new RenderItemAK47Stock(AK47, AK47.getModel().getStock()));

        MapModelTexture<ModelM4> M4 = AliensVsPredator.resources().models().M4;
        Renderers.registerItemRenderer(ItemHandler.itemM4Barrel, new RenderItemM4Barrel(M4, M4.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemM4Action, new RenderItemM4Action(M4, M4.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemM4Stock, new RenderItemM4Stock(M4, M4.getModel().getStock()));

        MapModelTexture<ModelM56SG> M56SG = AliensVsPredator.resources().models().M56SG;
        Renderers.registerItemRenderer(ItemHandler.itemM56SGAction, new RenderItemM56SGAction(M56SG, M56SG.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGAimingModule, new RenderItemM56SGAimingModule(M56SG, M56SG.getModel().getAccessories()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGBarrel, new RenderItemM56SGBarrel(M56SG, M56SG.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGStock, new RenderItemM56SGStock(M56SG, M56SG.getModel().getStock()));
        Renderers.registerItemRenderer(ItemHandler.itemM56SGSupportFrame, new RenderItemM56SGSupportFrame(M56SG, M56SG.getModel().getPeripherals()));

        MapModelTexture<ModelM41A> M41A = AliensVsPredator.resources().models().M41A;
        Renderers.registerItemRenderer(ItemHandler.itemM41AAction, new RenderItemM41AAction(M41A, M41A.getModel().getAction()));
        Renderers.registerItemRenderer(ItemHandler.itemM41ABarrel, new RenderItemM41ABarrel(M41A, M41A.getModel().getBarrel()));
        Renderers.registerItemRenderer(ItemHandler.itemM41AStock, new RenderItemM41AStock(M41A, M41A.getModel().getStock()));
        Renderers.registerItemRenderer(ItemHandler.itemM41APeripherals, new RenderItemM41APeripherals(M41A, M41A.getModel().getPeripherals()));

        MapModelTexture<ModelSniper> SNIPER = AliensVsPredator.resources().models().SNIPER;
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
    }
}
