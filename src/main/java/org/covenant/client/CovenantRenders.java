package org.covenant.client;

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
import org.avp.common.block.BlockSkull;
import org.covenant.client.render.entity.RenderSporePod;
import org.covenant.client.render.item.RenderItemGroundFern;
import org.covenant.client.render.item.RenderItemSporePod;
import org.covenant.client.render.item.RenderItemTreeFern;
import org.covenant.client.render.tile.plant.RenderGroundFern;
import org.covenant.client.render.tile.plant.RenderTreeFern;
import org.covenant.common.CovenantItems;
import org.covenant.common.block.init.CovenantParadiseBlocks;
import org.covenant.common.block.init.CovenantSkullBlocks;
import org.covenant.common.entity.EntitySporePod;
import org.covenant.common.tile.plant.TileEntityGroundFern;
import org.covenant.common.tile.plant.TileEntityTreeFern;
import org.lib.client.render.ItemModelRegistryUtil;
import org.lib.common.registry.BlockRegistryUtil;

import static net.minecraftforge.fml.client.registry.ClientRegistry.bindTileEntitySpecialRenderer;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(Side.CLIENT)
public class CovenantRenders implements IInitEvent, IPreInitEvent
{
    public static final CovenantRenders instance = new CovenantRenders();

    private CovenantRenders() {}

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
    }

    private void registerStandardEntityRenderers()
    {
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
            AVP.instance.getLogger().error("Error registering skull block renderer. Type mismatch: {}", block.getTranslationKey());
        }
    }
    
    private void registerBlockItemRenderers()
    {
        CovenantRenders.registerSkullRenderer(CovenantSkullBlocks.SKULL_PROTOMORPH);
        CovenantRenders.registerSkullRenderer(CovenantSkullBlocks.SKULL_NEOMORPH);

        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(CovenantParadiseBlocks.GROUND_FERN), new RenderItemGroundFern());
        Renderers.registerBlockItemRenderer(BlockRegistryUtil.getItemFromBlock(CovenantParadiseBlocks.TREE_FERN), new RenderItemTreeFern());
    }

    private void registerItemRenderers()
    {
        ItemModelRegistryUtil.registerSummonerModel(CovenantItems.SUMMONER_SPORE_POD, new RenderItemSporePod(), 0x0C1212, 0x222226);
    }

    private void registerTileEntitySpecialRenderers()
    {
        bindTileEntitySpecialRenderer(TileEntityGroundFern.class, new RenderGroundFern());
        bindTileEntitySpecialRenderer(TileEntityTreeFern.class, new RenderTreeFern());
    }
}
