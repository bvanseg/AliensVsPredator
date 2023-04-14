package org.avp.common.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Boston Vanseghi
 */
public class ModelConfig {

    private static ModelConfig instance;

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
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
        File configDir = Loader.instance().getConfigDir();
        File configDirectory = new File(configDir, "avp/");
        if (!configDirectory.exists() && !configDirectory.mkdirs()) {
            throw new IOException("Failed to create path to config file!");
        }
        File configFile = new File(configDirectory, "config.json");

        if (!configFile.exists() && !configFile.createNewFile()) {
            throw new IOException("Failed to create config file!");
        }
        String lines = StringUtils.join(Files.readAllLines(configFile.toPath(), StandardCharsets.UTF_8), "\n");

        ModelConfig config = gson.fromJson(lines, ModelConfig.class);

        if (config == null) {
            config = new ModelConfig();
            config.write();
        }

        ModelConfigProxyGenerator.recurseModelConfig(config, config);

        return config;
    }

    public void write() {
        File configDir = Loader.instance().getConfigDir();
        File configFile = new File(configDir, "avp/config.json");
        try {
            com.google.common.io.Files.write(gson.toJson(this), configFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public final transient ArrayList<ConfigSettingProxy<?>> configSettingProxies = new ArrayList<>();

    @ConfigValue.Category
    private final ModelConfigGeneral general = new ModelConfigGeneral();

    @ConfigValue.Category
    private final ModelConfigGraphics graphics = new ModelConfigGraphics();

    @ConfigValue.Category
    private final ModelConfigDimensions dimensions = new ModelConfigDimensions();

    @ConfigValue.Category
    private final ModelConfigBiomes biomes = new ModelConfigBiomes();

    @ConfigValue.Category
    private final ModelConfigSpawning spawning = new ModelConfigSpawning();

    @ConfigValue.Category
    private final ModelConfigEmbryos embryos = new ModelConfigEmbryos();

    @ConfigValue.Category
    private final ModelConfigParasites parasites = new ModelConfigParasites();

    public ModelConfig() { /* Do Nothing */ }

    public ModelConfigGeneral getGeneral() {
        return general;
    }

    public ModelConfigGraphics getGraphics() {
        return graphics;
    }

    public ModelConfigDimensions getDimensions() {
        return dimensions;
    }

    public ModelConfigBiomes getBiomes() {
        return biomes;
    }

    public ModelConfigSpawning getSpawning() {
        return spawning;
    }

    public ModelConfigEmbryos getEmbryos() {
        return this.embryos;
    }

    public ModelConfigParasites getParasites() {
        return parasites;
    }

    public boolean isHalloweenEventEnabled()
    {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return (localDate.getMonthValue() == 10 && localDate.getDayOfMonth() >= 27 || localDate.getMonthValue() == 11 && localDate.getDayOfMonth() <= 3);
    }
}
