package org.avp.client;

import com.asx.mdx.client.render.Renderers;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.common.mods.IInitEvent;
import com.asx.mdx.common.mods.IPreInitEvent;
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
import org.avp.AVP;
import org.avp.client.render.entity.RenderAPC;
import org.avp.client.render.entity.RenderLiquidLatexPool;
import org.avp.client.render.entity.RenderMedpodEntity;
import org.avp.client.render.entity.RenderSupplyChute;
import org.avp.client.render.entity.living.RenderCombatSynthetic;
import org.avp.client.render.entity.living.RenderMarine;
import org.avp.client.render.item.*;
import org.avp.client.render.tile.*;
import org.avp.client.render.transform.CryostasisTubeRenderers;
import org.avp.client.render.transform.MedpodTransforms;
import org.avp.common.AVPItems;
import org.avp.common.block.init.AVPTileEntityBlocks;
import org.avp.common.entity.EntityAPC;
import org.avp.common.entity.EntityLiquidLatexPool;
import org.avp.common.entity.EntityMedpod;
import org.avp.common.entity.EntitySupplyChute;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.tile.*;
import org.lib.client.render.model.loader.ReflectiveModelLoader;
import org.lib.common.registry.BlockRegistryUtil;
import org.weapon.client.model.item.*;
import org.weapon.client.render.entity.RenderBullet;
import org.weapon.client.render.entity.RenderFlame;
import org.weapon.client.render.entity.RenderGrenade;
import org.weapon.client.render.item.RenderItemNostromoFlamethrower;
import org.weapon.client.render.item.firearm.*;
import org.weapon.client.render.item.firearm.part.*;
import org.weapon.common.entity.EntityBullet;
import org.weapon.common.entity.EntityFlame;
import org.weapon.common.entity.EntityGrenade;

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
    }

    private void registerLivingEntityRenderers()
    {
        Renderers.registerRenderer(EntityMarine.class, RenderMarine.class);
        Renderers.registerRenderer(EntityCombatSynthetic.class, RenderCombatSynthetic.class);
    }

    private void registerStandardEntityRenderers()
    {
        Renderers.registerRenderer(EntityGrenade.class, RenderGrenade.class);
        Renderers.registerRenderer(EntityFlame.class, RenderFlame.class);
        Renderers.registerRenderer(EntityLiquidLatexPool.class, RenderLiquidLatexPool.class);
        Renderers.registerRenderer(EntityBullet.class, RenderBullet.class);
        Renderers.registerRenderer(EntityAPC.class, RenderAPC.class);
        Renderers.registerRenderer(EntityMedpod.class, RenderMedpodEntity.class);
        Renderers.registerRenderer(EntitySupplyChute.class, RenderSupplyChute.class);
    }
    
    private void registerBlockItemRenderers()
    {
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.TURRET), new RenderItemTurret());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.TERMINAL), new RenderItemWorkstation());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.CRYO_TUBE), new RenderItemCryostasisTube());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.REPULSION_GENERATOR), new RenderItemRepulsionGenerator());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.BLAST_DOOR), new RenderItemBlastDoor());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.LIGHT_PANEL), new RenderItemLightPanel());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.CCFL_TUBE), new RenderItemCCFLTube());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.TESLA_COIL), new RenderItemTeslaCoil());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.POWERLINE), new RenderItemPowerline());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.SOLAR_PANEL), new RenderItemSolarPanel());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.POWERCELL), new RenderItemPowercell());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.TRANSFORMER), new RenderItemTransformer());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.STEPDOWN_TRANSFORMER), new RenderItemTransformer());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.UNIVERSAL_GENERATOR), new RenderItemRedstoneFluxGenerator());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.AMPULE), new RenderItemAmpule());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.LOCKER), new RenderItemLocker());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.GUN_LOCKER), new RenderItemGunLocker());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.MEDPOD), new RenderItemMedpod());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.SATELLITE_DISH), new RenderItemSatelliteDish());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.SEVASTOPOL_BLAST_DOOR), new RenderItemSevastopolBlastdoor());

        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.SUPPLY_CRATE), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.CRATE_MARINES), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.CRATE_SEEGSON), new RenderItemSupplyCrate());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AVPTileEntityBlocks.NETWORK_RACK), new RenderItemNetworkRack());
    }

    private void registerItemRenderers()
    {
        Renderers.registerItemRenderer(AVPItems.ITEM_STUN_BATON, new RenderItemStunBaton());
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
        Renderers.registerItemRenderer(AVPItems.ITEM_GRENADE, new RenderItemM40(Resources.instance.models().M40GRENADE));
        Renderers.registerItemRenderer(AVPItems.ITEM_INCENDIARY_GRENADE, new RenderItemM40(Resources.instance.models().M40GRENADE_INCENDIARY));
        
        Renderers.registerItemRenderer(AVPItems.ITEM_SUPPLY_CHUTE, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(AVPItems.ITEM_SUPPLY_CHUTE_MARINES, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(AVPItems.ITEM_SUPPLY_CHUTE_SEEGSON, new RenderItemSupplyChute());
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_1, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE1));
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_2, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE2));
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_3, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE3));
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_4, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE4));
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_5, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE5));
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_6, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE6));
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_7, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE7));
        Renderers.registerItemRenderer(AVPItems.RACK_MODULE_8, new RenderItemNetworkRackModule(Resources.instance.models().RACKMODULE8));

        Renderers.registerItemRenderer(AVPItems.SUMMONER_MARINE, (new RenderItemSummoner(Resources.instance.models().MARINE)).setScale(16F).setY(-8F));
        Renderers.registerItemRenderer(AVPItems.SUMMONER_COMBAT_SYNTHETIC, (new RenderItemSummoner(Resources.instance.models().COMBAT_SYNTHETIC)).setScale(16F).setY(-8F));

        MapModelTexture<Model88MOD4> _88MOD4 = Resources.instance.models()._88MOD4;
        Renderers.registerItemRenderer(AVPItems.ITEM_PISTOL_BARREL, new RenderItem88Mod4Barrel(_88MOD4, _88MOD4.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_PISTOL_ACTION, new RenderItem88Mod4Action(_88MOD4, _88MOD4.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_PISTOL_STOCK, new RenderItem88Mod4Stock(_88MOD4, _88MOD4.getModel().getStock()));

        MapModelTexture<ModelAK47> AK47 = Resources.instance.models().AK47;
        Renderers.registerItemRenderer(AVPItems.ITEM_AK47_BARREL, new RenderItemAK47Barrel(AK47, AK47.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_AK47_ACTION, new RenderItemAK47Action(AK47, AK47.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_AK47_STOCK, new RenderItemAK47Stock(AK47, AK47.getModel().getStock()));

        MapModelTexture<ModelM4> M4 = Resources.instance.models().M4;
        Renderers.registerItemRenderer(AVPItems.ITEM_M4_BARREL, new RenderItemM4Barrel(M4, M4.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M4_ACTION, new RenderItemM4Action(M4, M4.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M4_STOCK, new RenderItemM4Stock(M4, M4.getModel().getStock()));

        MapModelTexture<ModelM56SG> M56SG = Resources.instance.models().M56SG;
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_ACTION, new RenderItemM56SGAction(M56SG, M56SG.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_AIMING_MODULE, new RenderItemM56SGAimingModule(M56SG, M56SG.getModel().getAccessories()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_BARREL, new RenderItemM56SGBarrel(M56SG, M56SG.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_STOCK, new RenderItemM56SGStock(M56SG, M56SG.getModel().getStock()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M56SG_SUPPORT_FRAME, new RenderItemM56SGSupportFrame(M56SG, M56SG.getModel().getPeripherals()));

        MapModelTexture<ModelM41A> M41A = Resources.instance.models().M41A;
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_ACTION, new RenderItemM41AAction(M41A, M41A.getModel().getAction()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_BARREL, new RenderItemM41ABarrel(M41A, M41A.getModel().getBarrel()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_STOCK, new RenderItemM41AStock(M41A, M41A.getModel().getStock()));
        Renderers.registerItemRenderer(AVPItems.ITEM_M41A_PERIPHERALS, new RenderItemM41APeripherals(M41A, M41A.getModel().getPeripherals()));

        MapModelTexture<ModelSniper> SNIPER = Resources.instance.models().SNIPER;
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
        bindTileEntitySpecialRenderer(TileEntitySkull.class, new RenderSkull());
        bindTileEntitySpecialRenderer(TileEntityTeslaCoil.class, new RenderTeslaCoil());
    }
}
