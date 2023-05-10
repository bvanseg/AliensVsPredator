package org.alien;

import com.asx.mdx.common.mods.IInitEvent;
import com.asx.mdx.common.mods.IPostInitEvent;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.alien.client.AlienSounds;
import org.covenant.client.render.BiomeColorHandler;
import org.alien.common.*;
import org.alien.common.block.init.AlienBlocks;
import org.alien.common.potion.AlienPotions;
import org.covenant.common.CovenantDimensions;
import org.covenant.common.CovenantEntities;
import org.covenant.common.CovenantItems;
import org.covenant.common.CovenantTileEntities;
import org.covenant.common.block.init.CovenantBlocks;
import org.prometheus.common.PrometheusDimensions;
import org.prometheus.common.PrometheusEntities;
import org.prometheus.common.PrometheusEntitySpawns;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.block.init.PrometheusBlocks;

/**
 * @author Boston Vanseghi
 */
public class Aliens implements IPreInitEvent, IInitEvent, IPostInitEvent {
    public static final Aliens instance = new Aliens();

    private Aliens() {}

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AlienBlocks.instance.pre(event);
        PrometheusBlocks.instance.pre(event);
        CovenantBlocks.instance.pre(event);

        AlienItems.instance.pre(event);
        PrometheusItems.instance.pre(event);
        CovenantItems.instance.pre(event);

        AlienPotions.instance.pre(event);
        AlienSounds.instance.pre(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        AlienDimensions.instance.init(event);
        PrometheusDimensions.instance.init(event);
        CovenantDimensions.instance.init(event);

        WorldHandler.instance.init(event);

        AlienEntities.instance.init(event);
        PrometheusEntities.instance.init(event);
        CovenantEntities.instance.init(event);

        AlienEntitySpawns.instance.init(event);
        PrometheusEntitySpawns.instance.init(event);

        AlienTileEntities.instance.init(event);
        CovenantTileEntities.instance.init(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            BiomeColorHandler.instance.init(event);
        }
    }

    @Override
    public void post(FMLPostInitializationEvent event) {

    }
}
