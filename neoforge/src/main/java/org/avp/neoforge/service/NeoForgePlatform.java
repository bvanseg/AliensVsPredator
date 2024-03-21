package org.avp.neoforge.service;

import net.neoforged.fml.ModList;
import net.neoforged.fml.loading.FMLLoader;

import org.avp.common.service.Platform;

import java.nio.file.Path;

public class NeoForgePlatform implements Platform {

    @Override
    public String getPlatformName() {
        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return !FMLLoader.isProduction();
    }

    @Override
    public Path getGameDirectory() {
        return FMLLoader.getGamePath();
    }
}
