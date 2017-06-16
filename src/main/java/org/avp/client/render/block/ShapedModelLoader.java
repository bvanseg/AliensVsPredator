package org.avp.client.render.block;

import java.util.HashMap;

import org.avp.AliensVsPredator;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;

public class ShapedModelLoader implements ICustomModelLoader
{
    public static final ShapedModelLoader INSTANCE = new ShapedModelLoader();
    private final HashMap<String, IModel> REGISTRY = new HashMap<String, IModel>();

    public ShapedModelLoader()
    {
        this.register();
    }
    
    public void register()
    {
        REGISTRY.put("slope", new ModelSlope());
    }

    @Override
    public void onResourceManagerReload(IResourceManager resourceManager)
    {
        REGISTRY.clear();
        this.register();
    }

    @Override
    public boolean accepts(ResourceLocation modelLocation)
    {
        if (modelLocation.getResourceDomain().equals(AliensVsPredator.Properties.ID))
        {
            if (REGISTRY.containsKey(modelLocation.getResourcePath()))
            {
                return true;
            }
        }

        return false;
    }

    @Override
    public IModel loadModel(ResourceLocation modelLocation) throws Exception
    {
        return REGISTRY.get(modelLocation.getResourcePath());
    }
}
