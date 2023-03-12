package org.avp.client.model.loaders;

import java.util.HashMap;

import org.avp.AliensVsPredator;
import org.avp.client.render.block.model.ModelResin;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class CustomBlockModelLoader implements ICustomModelLoader
{
    public static final CustomBlockModelLoader INSTANCE = new CustomBlockModelLoader();
    private HashMap<String, IModel> models = new HashMap<String, IModel>();

    public CustomBlockModelLoader()
    {
        this.register();
    }

    public void register()
    {
        //Item Model Key: domain:models/item/ID
        models.put("hiveresin", new ModelResin(new ResourceLocation(AliensVsPredator.Properties.ID, "block/cube.obj"), new ResourceLocation(AliensVsPredator.Properties.ID, "blocks/hiveresin")));
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
        if (modelLocation.getNamespace().equals(AliensVsPredator.Properties.ID))
        {
            if (models.containsKey(modelLocation.getPath()))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception
    {
        if (models.containsKey(modelLocation.getPath()))
        {
            return models.get(modelLocation.getPath());
        }

        return null;
    }

    public HashMap<String, IModel> getModels()
    {
        return models;
    }
}
