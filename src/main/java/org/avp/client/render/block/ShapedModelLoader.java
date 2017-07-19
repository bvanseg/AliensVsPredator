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
    
    public static final ResourceLocation REFLECTION        = new ResourceLocation(AliensVsPredator.Properties.ID, "blocks/reflection");

    public ShapedModelLoader()
    {
        this.register();
    }
    
    public void register()
    {
        REGISTRY.put("slope", new ModelShapeNew(new ResourceLocation(AliensVsPredator.Properties.ID, "block/slope.obj"), REFLECTION));
        REGISTRY.put("corner", new ModelShapeNew(new ResourceLocation(AliensVsPredator.Properties.ID, "block/corner.obj"), REFLECTION));
        REGISTRY.put("ridge", new ModelShapeNew(new ResourceLocation(AliensVsPredator.Properties.ID, "block/ridge.obj"), REFLECTION));
        REGISTRY.put("pyramid", new ModelShapeNew(new ResourceLocation(AliensVsPredator.Properties.ID, "block/pyramid.obj"), REFLECTION));
        REGISTRY.put("invertedcorner", new ModelShapeNew(new ResourceLocation(AliensVsPredator.Properties.ID, "block/invertedcorner.obj"), REFLECTION));
        REGISTRY.put("invertedridge", new ModelShapeNew(new ResourceLocation(AliensVsPredator.Properties.ID, "block/invertedridge.obj"), REFLECTION));
        REGISTRY.put("invertedpyramid", new ModelShapeNew(new ResourceLocation(AliensVsPredator.Properties.ID, "block/invertedpyramid.obj"), REFLECTION));
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
