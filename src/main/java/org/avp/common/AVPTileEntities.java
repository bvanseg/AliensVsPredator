package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.avp.AVP;
import org.avp.common.tile.*;

public class AVPTileEntities implements IInitEvent {
    public static final AVPTileEntities instance = new AVPTileEntities();

    private AVPTileEntities() {}

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerTileEntities();
    }

    private void registerTileEntities()
    {
        GameRegistry.registerTileEntity(TileEntityTurret.class, new ResourceLocation(AVP.Properties.ID, "tileEntityTurret"));
        GameRegistry.registerTileEntity(TileEntityWorkstation.class, new ResourceLocation(AVP.Properties.ID, "tileEntityWorkstation"));
        GameRegistry.registerTileEntity(TileEntityAssembler.class, new ResourceLocation(AVP.Properties.ID, "tileEntityAssembler"));
        GameRegistry.registerTileEntity(TileEntityRepulsionGenerator.class, new ResourceLocation(AVP.Properties.ID, "tileEntityGenerator"));
        GameRegistry.registerTileEntity(TileEntityPowerline.class, new ResourceLocation(AVP.Properties.ID, "tileEntityPowerline"));
        GameRegistry.registerTileEntity(TileEntityBlastdoor.class, new ResourceLocation(AVP.Properties.ID, "tileEntityBlastdoor"));
        GameRegistry.registerTileEntity(TileEntitySevastopolBlastDoor.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySevastopolBlastdoor"));
        GameRegistry.registerTileEntity(TileEntityCryostasisTube.class, new ResourceLocation(AVP.Properties.ID, "tileEntityCryostasisTube"));
        GameRegistry.registerTileEntity(TileEntityLightPanel.class, new ResourceLocation(AVP.Properties.ID, "tileEntityLightPanel"));
        GameRegistry.registerTileEntity(TileEntityCCFLTube.class, new ResourceLocation(AVP.Properties.ID, "tileEntityCCFLTube"));
        GameRegistry.registerTileEntity(TileEntityNetworkRack.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySatelliteModem"));
        GameRegistry.registerTileEntity(TileEntitySatelliteDish.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySatelliteDish"));
        GameRegistry.registerTileEntity(TileEntityTransformer.class, new ResourceLocation(AVP.Properties.ID, "tileEntityTransformer"));
        GameRegistry.registerTileEntity(TileEntityNegativeTransformer.class, new ResourceLocation(AVP.Properties.ID, "tileEntityNegativeTransformer"));
        GameRegistry.registerTileEntity(TileEntityRedstoneSensor.class, new ResourceLocation(AVP.Properties.ID, "tileEntityR2PConverter"));
        GameRegistry.registerTileEntity(TileEntityRedstoneEmitter.class, new ResourceLocation(AVP.Properties.ID, "tileEntityP2RConverter"));
        GameRegistry.registerTileEntity(TileEntityPowercell.class, new ResourceLocation(AVP.Properties.ID, "tileEntityPowercell"));
        GameRegistry.registerTileEntity(TileEntityAmpule.class, new ResourceLocation(AVP.Properties.ID, "tileEntityAmpule"));
        GameRegistry.registerTileEntity(TileEntityLocker.class, new ResourceLocation(AVP.Properties.ID, "tileEntityLocker"));
        GameRegistry.registerTileEntity(TileEntityGunLocker.class, new ResourceLocation(AVP.Properties.ID, "tileEntityGunLocker"));
        GameRegistry.registerTileEntity(TileEntityMedpod.class, new ResourceLocation(AVP.Properties.ID, "tileEntityMedpod"));
        GameRegistry.registerTileEntity(TileEntitySupplyCrate.class, new ResourceLocation(AVP.Properties.ID, "tileEntitySupplyCrate"));
        GameRegistry.registerTileEntity(TileEntitySolarPanel.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.solarpanel"));
        GameRegistry.registerTileEntity(TileEntitySkull.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.skull"));
        GameRegistry.registerTileEntity(TileEntityRedstoneFluxGenerator.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.redstonefluxgenerator"));
        GameRegistry.registerTileEntity(TileEntityReflective.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.reflective"));
        GameRegistry.registerTileEntity(TileEntityTeslaCoil.class, new ResourceLocation(AVP.Properties.ID, "tile.avp.tesacoil"));
    }
}
