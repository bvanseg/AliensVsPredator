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
import org.alien.common.entity.living.EntityYautjaMutant;
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
import org.avp.client.Resources;
import org.avp.client.render.item.RenderItemSkull;
import org.avp.client.render.item.RenderItemSummoner;
import org.avp.client.render.transform.FaceLocationTransforms;
import org.avp.client.render.transform.VanillaFaceLocationTransforms;
import org.avp.common.block.BlockSkull;
import org.avp.common.tile.TileEntityHiveResin;
import org.avp.common.tile.plant.TileEntityGroundFern;
import org.avp.common.tile.plant.TileEntityTreeFern;
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
        Renderers.registerRenderer(EntityEngineer.class, RenderEngineer.class);
        Renderers.registerRenderer(EntitySpaceJockey.class, RenderSpaceJockey.class);
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
        Renderers.registerRenderer(EntityUrsuidae.class, RenderUrsuidae.class);
        Renderers.registerRenderer(EntityScelemur.class, RenderScelemur.class);
        Renderers.registerRenderer(EntityYautjaMutant.class, RenderYautjaMutant.class);
    }

    private void registerStandardEntityRenderers()
    {
        Renderers.registerRenderer(EntityAcidPool.class, RenderAcidPool.class);
        Renderers.registerRenderer(EntityAcidProjectile.class, RenderAcidProjectile.class);
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
        AlienRenders.registerSkullRenderer(AlienBlocks.SKULL_ENGINEER);
        AlienRenders.registerSkullRenderer(AlienBlocks.SKULL_JOCKEY);

        AlienRenders.registerSkullRenderer(AlienBlocks.SKULL_XENO);
        AlienRenders.registerSkullRenderer(AlienBlocks.SKULL_XENO_WARRIOR);
        AlienRenders.registerSkullRenderer(AlienBlocks.SKULL_MATRIARCH);

        AlienRenders.registerSkullRenderer(AlienBlocks.SKULL_PROTOMORPH);
        AlienRenders.registerSkullRenderer(AlienBlocks.SKULL_NEOMORPH);

        AlienRenders.registerSkullRenderer(AlienBlocks.HEAD_AETHON);
        AlienRenders.registerSkullRenderer(AlienBlocks.HEAD_GIGER_ALIEN);

        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AlienBlocks.GROUND_FERN), new RenderItemGroundFern());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(AlienBlocks.TREE_FERN), new RenderItemTreeFern());
    }

    private void registerItemRenderers()
    {
        Renderers.registerItemRenderer(AlienItems.SUMMONER_SPORE_POD, new RenderItemSporePod());

        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRONE, (new RenderItemSummoner(Resources.instance.models().DRONE_ADVANCED)).setScale(7.5F).setY(6F));

        Renderers.registerItemRenderer(AlienItems.SUMMONER_DEACON, (new RenderItemSummoner(Resources.instance.models().DEACON)).setScale(7F).setY(7F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DEACON_ADULT, (new RenderItemSummoner(Resources.instance.models().DEACON_ADULT)).setScale(7F).setY(7F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_WARRIOR, (new RenderItemSummoner(Resources.instance.models().WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_RUNNER_DRONE, (new RenderItemSummoner(Resources.instance.models().RUNNER_DRONE)).setScale(7.5F).setX(4F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_RUNNER_WARRIOR, (new RenderItemSummoner(Resources.instance.models().RUNNER_WARRIOR)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PRAETORIAN, (new RenderItemSummoner(Resources.instance.models().PRAETORIAN)).setScale(7.5F).setY(7.5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_SPITTER, (new RenderItemSummoner(Resources.instance.models().SPITTER)).setScale(7.5F).setY(9F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_CRUSHER, (new RenderItemSummoner(Resources.instance.models().CRUSHER)).setScale(7.5F).setX(2F).setY(9.5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_QUEEN, (new RenderItemSummoner(Resources.instance.models().MATRIARCH)).setScale(7.5F).setY(8F));

        Renderers.registerItemRenderer(AlienItems.SUMMONER_OVAMORPH, (new RenderItemSummoner(Resources.instance.models().OVAMORPH)).setScale(20F).setY(-16F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_OVAMORPH_GIGER, (new RenderItemSummoner(Resources.instance.models().OVAMORPH_GIGER)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_CHESTBURSTER, (new RenderItemSummoner(Resources.instance.models().CHESTBUSTER)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_FACEHUGGER, (new RenderItemSummoner(Resources.instance.models().FACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_ROYAL_FACEHUGGER, (new RenderItemSummoner(Resources.instance.models().ROYALFACEHUGGER)).setScale(15F).setY(-8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PREDALIEN, (new RenderItemSummoner(Resources.instance.models().PREDALIEN)).setScale(8F).setX(3F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_AQUA, (new RenderItemSummoner(Resources.instance.models().NAUTICOMORPH_XENOMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_HAMMERPEDE, (new RenderItemSummoner(Resources.instance.models().HAMMERPEDE)).setScale(10.5F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_TRILOBITE, (new RenderItemSummoner(Resources.instance.models().TRILOBITE)).setScale(8F).setY(4F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_SPACE_JOCKEY, (new RenderItemSummoner(Resources.instance.models().SPACE_JOCKEY)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_ENGINEER, (new RenderItemSummoner(Resources.instance.models().ENGINEER)).setScale(10F).setY(0F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DEACON_SHARK, (new RenderItemSummoner(Resources.instance.models().DEACON_SHARK)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_ULTRAMORPH, (new RenderItemSummoner(Resources.instance.models().ULTRAMORPH)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_GOO_MUTANT, (new RenderItemSummoner(Resources.instance.models().GOO_MUTANT)).setScale(10F).setY(3F));

        Renderers.registerItemRenderer(AlienItems.SUMMONER_AETHON, (new RenderItemSummoner(Resources.instance.models().AETHON)).setScale(7.5F).setY(6F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_OCTOHUGGER, (new RenderItemSummoner(Resources.instance.models().OCTOHUGGER)).setScale(24F).setY(-4F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BELUGABURSTER, (new RenderItemSummoner(Resources.instance.models().BELUGABURSTER)).setScale(9F).setY(0F).setX(2F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BELUGAMORPH, (new RenderItemSummoner(Resources.instance.models().BELUGAMORPH)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PREDALIEN_BURSTER, (new RenderItemSummoner(Resources.instance.models().CHESTBUSTER_PREDALIEN)).setScale(9F).setY(3F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_QUEEN_BURSTER, (new RenderItemSummoner(Resources.instance.models().CHESTBUSTER_QUEEN)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_RUNNER_BURSTER, (new RenderItemSummoner(Resources.instance.models().CHESTBUSTER_RUNNER)).setScale(9F).setY(5F).setX(5F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BABYHEAD, (new RenderItemSummoner(Resources.instance.models().BABYHEAD)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BAT_XENO, (new RenderItemSummoner(Resources.instance.models().BAT_XENO)).setScale(7.5F).setY(1F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_BOILER, (new RenderItemSummoner(Resources.instance.models().BOILER)).setScale(9F).setY(1F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRACOBURSTER, (new RenderItemSummoner(Resources.instance.models().DRACOBURSTER)).setScale(7.5F).setY(6F).setX(3F));

        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRACO_EGG, (new RenderItemSummoner(Resources.instance.models().DRACO_OVAMORPH)).setScale(20F).setY(-18F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_DRACOMORPH, (new RenderItemSummoner(Resources.instance.models().DRACOMORPH)).setScale(6F).setY(10F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_MYCELIOMORPH, (new RenderItemSummoner(Resources.instance.models().MYCELIOMORPH)).setScale(9F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_PANTHERAMORPH, (new RenderItemSummoner(Resources.instance.models().PANTHERAMORPH)).setScale(7.5F).setY(4F).setX(3F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_URSUIDAE, (new RenderItemSummoner(Resources.instance.models().URSUIDAE)).setScale(14F).setY(-8F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_VARDA_MONKEY, (new RenderItemSummoner(Resources.instance.models().VARDA_MONKEY)).setScale(16F).setY(-14F));
        Renderers.registerItemRenderer(AlienItems.SUMMONER_YAUTJA_MUTANT, (new RenderItemSummoner(Resources.instance.models().MUTANT_YAUTJA)).setScale(9F).setY(6F));
    }

    private void registerTileEntitySpecialRenderers()
    {
        bindTileEntitySpecialRenderer(TileEntityHiveResin.class, new RenderHiveResin());
        bindTileEntitySpecialRenderer(TileEntityGroundFern.class, new RenderGroundFern());
        bindTileEntitySpecialRenderer(TileEntityTreeFern.class, new RenderTreeFern());
    }
}
