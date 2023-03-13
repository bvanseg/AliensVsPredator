package org.alien.client.model.loader;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import org.alien.client.model.tile.ModelResin;
import org.avp.AVP;

import java.util.HashMap;
import java.util.Map;

public class CustomBlockModelLoader implements ICustomModelLoader
{
    public static final CustomBlockModelLoader instance = new CustomBlockModelLoader();
    private final HashMap<String, IModel> models = new HashMap<>();

    private CustomBlockModelLoader()
    {
        this.register();
    }

    public void register()
    {
        //Item Model Key: domain:models/item/ID
        models.put("hiveresin", new ModelResin(new ResourceLocation(AVP.Properties.ID, "block/cube.obj"), new ResourceLocation(AVP.Properties.ID, "blocks/hiveresin")));
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        models.clear();
        this.register();
    }

    @Override
    public boolean accepts(ResourceLocation modelLocation)
    {
        return modelLocation.getNamespace().equals(AVP.Properties.ID) && models.containsKey(modelLocation.getPath());
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) {
        return models.get(modelLocation.getPath());
    }

    public Map<String, IModel> getModels()
    {
        return models;
    }
}
