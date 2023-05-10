package org.alien.client;

import com.asx.mdx.client.render.Renderers;
import com.asx.mdx.common.mods.IInitEvent;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.render.entity.RenderAcidPool;
import org.alien.client.render.entity.RenderAcidProjectile;
import org.alien.client.render.entity.living.*;
import org.alien.client.render.entity.living.paradise.RenderKetterBird;
import org.alien.client.render.entity.living.paradise.RenderPaintedMink;
import org.alien.client.render.entity.living.paradise.RenderStripedDevil;
import org.alien.client.render.item.RenderItemGroundFern;
import org.alien.client.render.item.RenderItemSporePod;
import org.alien.client.render.item.RenderItemTreeFern;
import org.alien.client.render.tile.RenderHiveResin;
import org.alien.common.AlienItems;
import org.alien.common.block.init.AlienSkullBlocks;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.EntityAcidProjectile;
import org.alien.common.entity.living.EntityAethon;
import org.alien.common.entity.living.paradise.EntityKetterBird;
import org.alien.common.entity.living.paradise.EntityPaintedMink;
import org.alien.common.entity.living.paradise.EntityStripedDevil;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityDracoEgg;
import org.alien.common.entity.living.EntitySporePod;
import org.alien.common.entity.living.EntityYautjaMutant;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.alien.common.entity.living.engineer.EntitySpaceJockey;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.alien.common.entity.living.vardic.*;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.burster.*;
import org.alien.common.entity.living.xenomorph.exotic.*;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityDracoEgg;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorph;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityOvamorphGiger;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.alien.common.tile.TileEntityHiveResin;
import org.avp.AVP;
import org.avp.client.render.item.RenderItemSkull;
import org.avp.client.render.item.RenderItemSummoner;
import org.avp.client.render.transform.FaceLocationTransforms;
import org.avp.client.render.transform.VanillaFaceLocationTransforms;
import org.avp.common.block.BlockSkull;
import org.lib.client.render.ItemModelRegistryUtil;
import org.lib.common.registry.BlockRegistryUtil;

import static net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class AlienRenders implements IInitEvent, IPreInitEvent
{
    public static final AlienRenders instance = new AlienRenders();

    private AlienRenders() {}

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        registerBlockItemRenderers();
        registerItemRenderers();
        registerStandardEntityRenderers();
        registerLivingEntityRenderers();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        registerTileEntitySpecialRenderers();
        FaceLocationTransforms.register();
        VanillaFaceLocationTransforms.register();
    }

    private void registerLivingEntityRenderers()
    {
        Renderers.registerRenderer(EntityDrone.class, RenderDrone.class);
        Renderers.registerRenderer(EntityWarrior.class, RenderWarrior.class);
        Renderers.registerRenderer(EntityPraetorian.class, RenderPraetorian.class);
        Renderers.registerRenderer(EntityRunnerDrone.class, RenderRunnerDrone.class);
        Renderers.registerRenderer(EntityRunnerWarrior.class, RenderRunnerWarrior.class);
        Renderers.registerRenderer(EntityCrusher.class, RenderCrusher.class);

        Renderers.registerRenderer(EntityNauticomorph.class, RenderNauticomorph.class);
        Renderers.registerRenderer(EntityPredalien.class, RenderPredalien.class);

        Renderers.registerRenderer(EntitySpitter.class, RenderSpitter.class);
        Renderers.registerRenderer(EntityMatriarch.class, RenderMatriarch.class);
        Renderers.registerRenderer(EntityFacehugger.class, RenderFacehugger.class);
        Renderers.registerRenderer(EntityRoyalFacehugger.class, RenderRoyalFacehugger.class);
        Renderers.registerRenderer(EntityChestburster.class, RenderChestburster.class);

        Renderers.registerRenderer(EntityOvamorph.class, RenderOvamorph.class);
        Renderers.registerRenderer(EntityOvamorphGiger.class, RenderOvamorphGiger.class);
        Renderers.registerRenderer(EntityAethon.class, RenderAethon.class);

        Renderers.registerRenderer(EntityPredalienChestburster.class, RenderPredalienChestburster.class);
        Renderers.registerRenderer(EntityQueenChestburster.class, RenderQueenChestburster.class);
        Renderers.registerRenderer(EntityRunnerChestburster.class, RenderRunnerChestburster.class);

        Renderers.registerRenderer(EntityBatXeno.class, RenderBatXenomorph.class);
        Renderers.registerRenderer(EntityBoiler.class, RenderBoiler.class);
        Renderers.registerRenderer(EntityDracoburster.class, RenderDracoburster.class);
        Renderers.registerRenderer(EntityDracoEgg.class, RenderDracoEgg.class);
        Renderers.registerRenderer(EntityDracomorph.class, RenderDracomorph.class);
        Renderers.registerRenderer(EntityMyceliomorph.class, RenderMyceliomorph.class);
        Renderers.registerRenderer(EntityPantheramorph.class, RenderPantheramorph.class);
        Renderers.registerRenderer(EntityUrsuidae.class, RenderUrsuidae.class);
        Renderers.registerRenderer(EntityScelemur.class, RenderScelemur.class);
        Renderers.registerRenderer(EntityYautjaMutant.class, RenderYautjaMutant.class);

        Renderers.registerRenderer(EntityKetterBird.class, RenderKetterBird.class);
        Renderers.registerRenderer(EntityPaintedMink.class, RenderPaintedMink.class);
        Renderers.registerRenderer(EntityStripedDevil.class, RenderStripedDevil.class);
    }

    private void registerStandardEntityRenderers()
    {
        Renderers.registerRenderer(EntityAcidPool.class, RenderAcidPool.class);
        Renderers.registerRenderer(EntityAcidProjectile.class, RenderAcidProjectile.class);
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
            AVP.instance.getLogger().error("Error registering skull block renderer. Type mismatch: {}", block.getTranslationKey());
        }
    }
    
    private void registerBlockItemRenderers()
    {
        AlienRenders.registerSkullRenderer(AlienSkullBlocks.SKULL_XENO);
        AlienRenders.registerSkullRenderer(AlienSkullBlocks.SKULL_XENO_WARRIOR);
        AlienRenders.registerSkullRenderer(AlienSkullBlocks.SKULL_MATRIARCH);

        AlienRenders.registerSkullRenderer(AlienSkullBlocks.HEAD_AETHON);
        AlienRenders.registerSkullRenderer(AlienSkullBlocks.HEAD_GIGER_ALIEN);
    }

    private void registerItemRenderers()
    {
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_DRONE, new RenderItemSummoner(AlienResources.Models.DRONE_ADVANCED).setScale(7.5F).setY(6F), 0x010202, 0xDFE2E4);

        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_WARRIOR, new RenderItemSummoner(AlienResources.Models.WARRIOR).setScale(7.5F).setX(2F).setY(9F), 0x010202, 0x4A4E55);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_RUNNER_DRONE, new RenderItemSummoner(AlienResources.Models.RUNNER_DRONE).setScale(7.5F).setX(4F).setY(6F), 0x503D34, 0xA69E85);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_RUNNER_WARRIOR, new RenderItemSummoner(AlienResources.Models.RUNNER_WARRIOR).setScale(7.5F).setX(4F).setY(9F), 0x1A1917, 0x61615E);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_PRAETORIAN, new RenderItemSummoner(AlienResources.Models.PRAETORIAN).setScale(7.5F).setY(7.5F), 0x010202, 0x363534);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_SPITTER, new RenderItemSummoner(AlienResources.Models.SPITTER).setScale(7.5F).setX(2F).setY(9F), 0x010202, 0x3CDC09);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_CRUSHER, new RenderItemSummoner(AlienResources.Models.CRUSHER).setScale(7.5F).setX(2F).setY(9.5F), 0x2E2921, 0x534A3B);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_QUEEN, new RenderItemSummoner(AlienResources.Models.MATRIARCH).setScale(7.5F).setY(8F), 0x010202, 0x363534);

        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_OVAMORPH, new RenderItemSummoner(AlienResources.Models.OVAMORPH).setScale(20F).setY(-16F), 0x615B45, 0xBF7872);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_OVAMORPH_GIGER, new RenderItemSummoner(AlienResources.Models.OVAMORPH_GIGER).setScale(10F).setY(0F), 0xA09281, 0xB68B93);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_CHESTBURSTER, new RenderItemSummoner(AlienResources.Models.CHESTBUSTER).setScale(9F).setY(3F).setX(5F), 0xD8B877, 0xF7E2B4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_FACEHUGGER, new RenderItemSummoner(AlienResources.Models.FACEHUGGER).setScale(15F).setY(-8F), 0xE4D597, 0xA55863);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_ROYAL_FACEHUGGER, new RenderItemSummoner(AlienResources.Models.ROYALFACEHUGGER).setScale(15F).setY(-8F), 0x81785E, 0x583A3A);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_PREDALIEN, new RenderItemSummoner(AlienResources.Models.PREDALIEN).setScale(8F).setX(3F).setY(6F), 0x3F3C35, 0xC0BF9A);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_AQUA, new RenderItemSummoner(AlienResources.Models.NAUTICOMORPH_XENOMORPH).setScale(7.5F).setY(6F), 0x010202, 0x5D7667);

        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_AETHON, new RenderItemSummoner(AlienResources.Models.AETHON).setScale(7.5F).setY(6F), 0x474B45, 0x979C9F);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_PREDALIEN_BURSTER, new RenderItemSummoner(AlienResources.Models.CHESTBUSTER_PREDALIEN).setScale(9F).setY(3F).setX(5F), 0xD8B877, 0xF7E2B4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_QUEEN_BURSTER, new RenderItemSummoner(AlienResources.Models.CHESTBUSTER_QUEEN).setScale(9F).setY(5F).setX(5F), 0xD8B877, 0xF7E2B4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_RUNNER_BURSTER, new RenderItemSummoner(AlienResources.Models.CHESTBUSTER_RUNNER).setScale(9F).setY(5F).setX(5F), 0xD8B877, 0xF7E2B4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_BAT_XENO, new RenderItemSummoner(AlienResources.Models.BAT_XENO).setScale(7.5F).setY(1F), 0x010202, 0xDFE2E4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_BOILER, new RenderItemSummoner(AlienResources.Models.BOILER).setScale(9F).setY(1F), 0x010202, 0x9DA930);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_DRACOBURSTER, new RenderItemSummoner(AlienResources.Models.DRACOBURSTER).setScale(7.5F).setY(6F).setX(3F), 0xD8B877, 0xF7E2B4);

        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_AETHON, new RenderItemSummoner(AlienResources.instance.models().AETHON).setScale(7.5F).setY(6F), 0x474B45, 0x979C9F);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_OCTOHUGGER, new RenderItemSummoner(AlienResources.instance.models().OCTOHUGGER).setScale(24F).setY(-4F), 0xC2BCC8, 0xC09CAE);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_BELUGABURSTER, new RenderItemSummoner(AlienResources.instance.models().BELUGABURSTER).setScale(9F).setY(4F).setX(2F), 0xC2C1BD, 0x646857);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_BELUGAMORPH, new RenderItemSummoner(AlienResources.instance.models().BELUGAMORPH).setScale(7.5F).setY(8F), 0xBCC9C6, 0x646E65);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_PREDALIEN_BURSTER, new RenderItemSummoner(AlienResources.instance.models().CHESTBUSTER_PREDALIEN).setScale(9F).setY(3F).setX(5F), 0xD8B877, 0xF7E2B4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_QUEEN_BURSTER, new RenderItemSummoner(AlienResources.instance.models().CHESTBUSTER_QUEEN).setScale(9F).setY(5F).setX(5F), 0xD8B877, 0xF7E2B4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_RUNNER_BURSTER, new RenderItemSummoner(AlienResources.instance.models().CHESTBUSTER_RUNNER).setScale(9F).setY(5F).setX(5F), 0xD8B877, 0xF7E2B4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_BABYHEAD, new RenderItemSummoner(AlienResources.instance.models().BABYHEAD).setScale(9F).setY(1F), 0xCED7D9, 0x949AA2);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_BAT_XENO, new RenderItemSummoner(AlienResources.instance.models().BAT_XENO).setScale(7.5F).setY(1F), 0x010202, 0xDFE2E4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_BOILER, new RenderItemSummoner(AlienResources.instance.models().BOILER).setScale(9F).setY(1F), 0x010202, 0x9DA930);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_DRACOBURSTER, new RenderItemSummoner(AlienResources.instance.models().DRACOBURSTER).setScale(7.5F).setY(6F).setX(3F), 0xD8B877, 0xF7E2B4);

        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_DRACO_EGG, new RenderItemSummoner(AlienResources.instance.models().DRACO_OVAMORPH).setScale(20F).setY(-18F), 0x2F2F2F, 0xA36762);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_DRACOMORPH, new RenderItemSummoner(AlienResources.instance.models().DRACOMORPH).setScale(6F).setY(10F).setX(3F), 0x212121, 0x535353);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_MYCELIOMORPH, new RenderItemSummoner(AlienResources.instance.models().MYCELIOMORPH).setScale(9F).setY(4F).setX(3F), 0x010202, 0xDFE2E4);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_PANTHERAMORPH, new RenderItemSummoner(AlienResources.instance.models().PANTHERAMORPH).setScale(7.5F).setY(4F).setX(3F), 0x010202, 0x7C703F);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_URSUIDAE, new RenderItemSummoner(AlienResources.instance.models().URSUIDAE).setScale(14F).setY(-8F), 0x47645A, 0x38483E);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_VARDA_MONKEY, new RenderItemSummoner(AlienResources.instance.models().VARDA_MONKEY).setScale(16F).setY(-14F), 0xE5E7C4, 0x8D938F);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_YAUTJA_MUTANT, new RenderItemSummoner(AlienResources.instance.models().MUTANT_YAUTJA).setScale(9F).setY(6F), 0x7B7B7B, 0xB3E1AD);

        /* Paradise Summoner Models */
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_KETTER_BIRD, new RenderItemSummoner(AlienResources.instance.models().KETTER_BIRD).setScale(9F).setY(3F), 0x381B0C, 0x936951);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_PAINTED_MINK, new RenderItemSummoner(AlienResources.instance.models().PAINTED_MINK).setScale(9F).setY(2F), 0x484541, 0x56381E);
        ItemModelRegistryUtil.registerSummonerModel(AlienItems.SUMMONER_STRIPED_DEVIL, new RenderItemSummoner(AlienResources.instance.models().STRIPED_DEVIL).setScale(9F).setY(2F), 0x2E2C2F, 0x534233);
    }

    private void registerTileEntitySpecialRenderers()
    {
        bindTileEntitySpecialRenderer(TileEntityHiveResin.class, new RenderHiveResin());
    }
}
