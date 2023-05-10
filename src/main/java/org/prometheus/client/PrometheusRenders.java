package org.prometheus.client;

import com.asx.mdx.client.render.Renderers;
import com.asx.mdx.common.mods.IInitEvent;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.client.render.item.RenderItemSkull;
import org.avp.client.render.item.RenderItemSummoner;
import org.avp.common.block.BlockSkull;
import org.lib.client.render.ItemModelRegistryUtil;
import org.lib.common.registry.BlockRegistryUtil;
import org.prometheus.client.render.entity.living.*;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.block.init.PrometheusSkullBlocks;
import org.prometheus.common.entity.living.EntityYautjaMutant;
import org.prometheus.common.entity.living.engineer.EntityEngineer;
import org.prometheus.common.entity.living.engineer.EntitySpaceJockey;
import org.prometheus.common.entity.living.species223ode.EntityDeacon;
import org.prometheus.common.entity.living.species223ode.EntityDeaconAdult;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;
import org.prometheus.common.entity.living.vardic.*;
import org.prometheus.common.entity.living.xenomorph.EntityUltramorph;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class PrometheusRenders implements IInitEvent, IPreInitEvent
{
    public static final PrometheusRenders instance = new PrometheusRenders();

    private PrometheusRenders() {}

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
    }

    private void registerLivingEntityRenderers()
    {
        Renderers.registerRenderer(EntityEngineer.class, RenderEngineer.class);
        Renderers.registerRenderer(EntitySpaceJockey.class, RenderSpaceJockey.class);
        Renderers.registerRenderer(EntityTrilobite.class, RenderTrilobite.class);
        Renderers.registerRenderer(EntityHammerpede.class, RenderHammerpede.class);
        Renderers.registerRenderer(EntityDeacon.class, RenderDeacon.class);
        Renderers.registerRenderer(EntityDeaconAdult.class, RenderDeaconAdult.class);
        Renderers.registerRenderer(EntityDeaconShark.class, RenderDeaconShark.class);
        Renderers.registerRenderer(EntityUltramorph.class, RenderUltramorph.class);
        Renderers.registerRenderer(EntityGooMutant.class, RenderGooMutant.class);
        Renderers.registerRenderer(EntityOctohugger.class, RenderOctohugger.class);
        Renderers.registerRenderer(EntityBelugaburster.class, RenderBelugaburster.class);
        Renderers.registerRenderer(EntityBelugamorph.class, RenderBelugamorph.class);
        Renderers.registerRenderer(EntityBabyhead.class, RenderBabyhead.class);
        Renderers.registerRenderer(EntityUrsuidae.class, RenderUrsuidae.class);
        Renderers.registerRenderer(EntityScelemur.class, RenderScelemur.class);
        Renderers.registerRenderer(EntityYautjaMutant.class, RenderYautjaMutant.class);
    }

    private void registerStandardEntityRenderers()
    {
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
        PrometheusRenders.registerSkullRenderer(PrometheusSkullBlocks.SKULL_ENGINEER);
        PrometheusRenders.registerSkullRenderer(PrometheusSkullBlocks.SKULL_JOCKEY);
    }

    private void registerItemRenderers()
    {
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_DEACON, new RenderItemSummoner(PrometheusResources.Models.DEACON).setScale(7F).setY(7F), 0x6A8FA9, 0x354758);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_DEACON_ADULT, new RenderItemSummoner(PrometheusResources.Models.DEACON_ADULT).setScale(7F).setY(7F), 0x8896A5, 0x495256);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_HAMMERPEDE, new RenderItemSummoner(PrometheusResources.Models.HAMMERPEDE).setScale(10.5F).setX(3F), 0xD0CBC7, 0x867D83);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_TRILOBITE, new RenderItemSummoner(PrometheusResources.Models.TRILOBITE).setScale(8F).setY(4F), 0xCCC2A5, 0x987379);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_SPACE_JOCKEY, new RenderItemSummoner(PrometheusResources.Models.SPACE_JOCKEY).setScale(10F).setY(4F), 0x2B2B2B, 0x65645E);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_ENGINEER, new RenderItemSummoner(PrometheusResources.Models.ENGINEER).setScale(10F).setY(4F), 0xB8B1B6, 0x99AFBD);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_DEACON_SHARK, new RenderItemSummoner(PrometheusResources.Models.DEACON_SHARK).setScale(7.5F).setY(8F), 0x2F3741, 0x8F96A3);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_ULTRAMORPH, new RenderItemSummoner(PrometheusResources.Models.ULTRAMORPH).setScale(7.5F).setY(6F), 0x3E474E, 0x696E76);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_GOO_MUTANT, new RenderItemSummoner(PrometheusResources.Models.GOO_MUTANT).setScale(10F).setY(3F), 0xB2A8A9, 0xB7B7B7);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_OCTOHUGGER, new RenderItemSummoner(PrometheusResources.Models.OCTOHUGGER).setScale(24F).setY(-4F), 0xC2BCC8, 0xC09CAE);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_BELUGABURSTER, new RenderItemSummoner(PrometheusResources.Models.BELUGABURSTER).setScale(9F).setY(4F).setX(2F), 0xC2C1BD, 0x646857);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_BELUGAMORPH, new RenderItemSummoner(PrometheusResources.Models.BELUGAMORPH).setScale(7.5F).setY(8F), 0xBCC9C6, 0x646E65);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_BABYHEAD, new RenderItemSummoner(PrometheusResources.Models.BABYHEAD).setScale(9F).setY(1F), 0xCED7D9, 0x949AA2);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_URSUIDAE, new RenderItemSummoner(PrometheusResources.Models.URSUIDAE).setScale(14F).setY(-8F), 0x47645A, 0x38483E);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_VARDA_MONKEY, new RenderItemSummoner(PrometheusResources.Models.VARDA_MONKEY).setScale(16F).setY(-14F), 0xE5E7C4, 0x8D938F);
        ItemModelRegistryUtil.registerSummonerModel(PrometheusItems.SUMMONER_YAUTJA_MUTANT, new RenderItemSummoner(PrometheusResources.Models.MUTANT_YAUTJA).setScale(9F).setY(6F), 0x7B7B7B, 0xB3E1AD);
    }

    private void registerTileEntitySpecialRenderers()
    {
    }
}
