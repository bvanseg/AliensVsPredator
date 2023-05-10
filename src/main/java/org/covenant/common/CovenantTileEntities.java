package org.covenant.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.avp.AVP;
import org.covenant.common.tile.plant.TileEntityGroundFern;
import org.covenant.common.tile.plant.TileEntityTreeFern;

public class CovenantTileEntities implements IInitEvent {
    public static final CovenantTileEntities instance = new CovenantTileEntities();

    private CovenantTileEntities() {}

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerTileEntities();
    }

    private void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityGroundFern.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.groundfern"));
        GameRegistry.registerTileEntity(TileEntityTreeFern.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.treefern"));
    }
}
