package org.avp.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.client.Minecraft;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author Boston Vanseghi
 */
public class ModelConfig {

    public static ModelConfig instance;

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapterFactory(new ConfigTypeAdapterFactory())
            .create();

    public static ModelConfig getInstance() {
        if (instance == null) {
            try {
                instance = ModelConfig.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }

    public static ModelConfig read() throws IOException {
        File gameDirectory = Minecraft.getMinecraft().gameDir;
        File configDirectory = new File(gameDirectory, "config/avp/");
        if (!configDirectory.exists() && !configDirectory.mkdirs()) {
            throw new IOException("Failed to create path to config file!");
        }
        File configFile = new File(configDirectory, "config.json");

        if (!configFile.exists() && !configFile.createNewFile()) {
            throw new IOException("Failed to create config file!");
        }
        String lines = StringUtils.join(Files.readAllLines(configFile.toPath(), StandardCharsets.UTF_8), "\n");

        ModelConfig readConfig = gson.fromJson(lines, ModelConfig.class);
        return readConfig == null ? new ModelConfig() : readConfig;
    }

    public void write() {
        File gameDirectory = Minecraft.getMinecraft().gameDir;
        File configFile = new File(gameDirectory, "config/avp/config.json");
        try {
            com.google.common.io.Files.write(gson.toJson(instance), configFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ConfigValue.Category
    private ModelConfigGeneral general = new ModelConfigGeneral();

    @ConfigValue.Category
    private ModelConfigGraphics graphics = new ModelConfigGraphics();

    @ConfigValue.Category
    private ModelConfigBiomes biomes = new ModelConfigBiomes();

    @ConfigValue.Category
    private ModelConfigSpawning spawning = new ModelConfigSpawning();

    public ModelConfig() {}


    public boolean isHalloweenEventEnabled()
    {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return (localDate.getMonthValue() == 10 && localDate.getDayOfMonth() >= 27 || localDate.getMonthValue() == 11 && localDate.getDayOfMonth() <= 3);
    }
}
