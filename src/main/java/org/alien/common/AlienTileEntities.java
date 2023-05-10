package org.alien.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.alien.common.tile.TileEntityHiveResin;
import org.avp.AVP;

public class AlienTileEntities implements IInitEvent {
    public static final AlienTileEntities instance = new AlienTileEntities();

    private AlienTileEntities() {}

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerTileEntities();
    }

    private void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityHiveResin.class, new ResourceLocation(AVP.Properties.ID, "tileEntityBlockHive"));
    }
}
