package org.predator.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.avp.AVP;
import org.avp.common.tile.TileEntityStasisMechanism;

public class PredatorTileEntities implements IInitEvent {
    public static final PredatorTileEntities instance = new PredatorTileEntities();

    private PredatorTileEntities() {}

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerTileEntities();
    }

    private void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityStasisMechanism.class, new ResourceLocation(AVP.Properties.ID, "tileStasisMechanism"));
    }
}
