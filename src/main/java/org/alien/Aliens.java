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
import org.alien.client.render.BiomeColorHandler;
import org.alien.common.*;
import org.alien.common.block.init.AlienBlocks;

/**
 * @author Boston Vanseghi
 */
public class Aliens implements IPreInitEvent, IInitEvent, IPostInitEvent {
    public static final Aliens instance = new Aliens();

    private Aliens() {}

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AlienBlocks.instance.pre(event);
        AlienItems.instance.pre(event);
        AlienSounds.instance.pre(event);
    }

    @Override
    public void init(FMLInitializationEvent event) {
        AlienDimensions.instance.init(event);
        WorldHandler.instance.init(event);

        AlienEntities.instance.init(event);
        AlienEntitySpawns.instance.init(event);
        AlienTileEntities.instance.init(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            BiomeColorHandler.instance.init(event);
        }
    }

    @Override
    public void post(FMLPostInitializationEvent event) {

    }
}
