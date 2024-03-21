package org.avp.fabric.service;

import net.fabricmc.loader.api.FabricLoader;

import org.avp.common.service.Platform;

import java.nio.file.Path;

public class FabricPlatform implements Platform {

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return FabricLoader.getInstance().isDevelopmentEnvironment();
    }

    @Override
    public Path getGameDirectory() {
        return FabricLoader.getInstance().getGameDir();
    }
}
