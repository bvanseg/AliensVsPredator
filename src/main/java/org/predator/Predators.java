package org.predator;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.core.mods.IPostInitEvent;
import com.asx.mdx.core.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.predator.client.PredatorSounds;
import org.predator.common.*;

/**
 * @author Boston Vanseghi
 */
public class Predators implements IPreInitEvent, IInitEvent, IPostInitEvent {
    public static final Predators instance = new Predators();

    private Predators() {}

    @Override
    public void pre(FMLPreInitializationEvent event) {
        PredatorBlocks.instance.pre(event);
        PredatorItems.instance.pre(event);
        PredatorSounds.instance.pre(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        PredatorEntities.instance.init(event);
        PredatorEntitySpawns.instance.init(event);
        PredatorTileEntities.instance.init(event);
    }

    @Override
    public void post(FMLPostInitializationEvent event) {

    }
}