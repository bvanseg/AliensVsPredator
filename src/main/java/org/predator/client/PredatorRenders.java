package org.predator.client;

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
import org.avp.client.Resources;
import org.avp.client.render.item.RenderItemSkull;
import org.avp.client.render.item.RenderItemSummoner;
import org.avp.common.block.BlockSkull;
import org.lib.common.registry.BlockRegistryUtil;
import org.predator.client.render.entity.*;
import org.predator.client.render.entity.living.RenderPredatorHound;
import org.predator.client.render.entity.living.RenderYautjaBerserker;
import org.predator.client.render.entity.living.RenderYautjaWarrior;
import org.predator.client.render.item.*;
import org.predator.client.render.tile.RenderStasisMechanism;
import org.predator.common.PredatorItems;
import org.predator.common.block.init.PredatorBlocks;
import org.predator.common.entity.*;
import org.predator.common.entity.living.EntityPredatorHound;
import org.predator.common.entity.living.yautja.EntityYautjaBerserker;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;
import org.predator.common.tile.TileEntityStasisMechanism;

import static net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class PredatorRenders implements IInitEvent, IPreInitEvent
{
    public static final PredatorRenders instance = new PredatorRenders();

    private PredatorRenders() {}

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
        Renderers.registerRenderer(EntityYautjaBerserker.class, RenderYautjaBerserker.class);
        Renderers.registerRenderer(EntityYautjaWarrior.class, RenderYautjaWarrior.class);
        Renderers.registerRenderer(EntityPredatorHound.class, RenderPredatorHound.class);
    }

    private void registerStandardEntityRenderers()
    {
        Renderers.registerRenderer(EntitySpear.class, RenderSpear.class);
        Renderers.registerRenderer(EntityLaserMine.class, RenderLaserMine.class);
        Renderers.registerRenderer(EntityPlasma.class, RenderPlasmaBlast.class);
        Renderers.registerRenderer(EntitySmartDisc.class, RenderDisc.class);
        Renderers.registerRenderer(EntityShuriken.class, RenderShuriken.class);
        Renderers.registerRenderer(EntityWristbracer.class, RenderWristbracer.class);
        Renderers.registerRenderer(EntityMechanism.class, RenderMechanism.class);
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
        PredatorRenders.registerSkullRenderer(PredatorBlocks.SKULL_YAUTJA);
        PredatorRenders.registerSkullRenderer(PredatorBlocks.BIOMASK_CLASSIC);
        PredatorRenders.registerSkullRenderer(PredatorBlocks.BIOMASK_BERSERKER);
        PredatorRenders.registerSkullRenderer(PredatorBlocks.BIOMASK_FALCONER);
        PredatorRenders.registerSkullRenderer(PredatorBlocks.BIOMASK_TRACKER);

        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(PredatorBlocks.STASIS_MECHANISM), new RenderItemStasisMechanism());
    }

    private void registerItemRenderers()
    {
        Renderers.registerItemRenderer(PredatorItems.ITEM_WRISTBRACER, new RenderItemWristbracer());
        Renderers.registerItemRenderer(PredatorItems.ITEM_WRISTBRACER_BLADES, new RenderItemWristbracerBlades());
        Renderers.registerItemRenderer(PredatorItems.ITEM_PLASMA_CANNON, new RenderItemPlasmaCannon());
        Renderers.registerItemRenderer(PredatorItems.ITEM_SPEAR, new RenderItemSpear());

        Renderers.registerItemRenderer(PredatorItems.SUMMONER_YAUTJA_WARRIOR, (new RenderItemSummoner(Resources.instance.models().YAUTJA_WARRIOR)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(PredatorItems.SUMMONER_YAUTJA_BERSERKER, (new RenderItemSummoner(Resources.instance.models().YAUTJA_BERSERKER)).setScale(7.5F).setY(8F));
        Renderers.registerItemRenderer(PredatorItems.SUMMONER_PREDATOR_HOUND, (new RenderItemSummoner(Resources.instance.models().PREDATOR_HOUND)).setScale(12F).setY(-3F));
    }

    private void registerTileEntitySpecialRenderers()
    {
        bindTileEntitySpecialRenderer(TileEntityStasisMechanism.class, new RenderStasisMechanism());
    }
}
