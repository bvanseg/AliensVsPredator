package org.lib.model.loader;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import org.avp.AVP;
import org.avp.client.model.tile.ModelReflectiveShape;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReflectiveModelLoader implements ICustomModelLoader
{
    public static final ReflectiveModelLoader INSTANCE = new ReflectiveModelLoader();
    private final HashMap<String, IModel> models = new HashMap<>();
    private final ArrayList<String> dummyIDs = new ArrayList<>();

    public static final ResourceLocation REFLECTION = new ResourceLocation(AVP.Properties.ID, "blocks/reflection");

    private ReflectiveModelLoader()
    {
        this.register();
    }

    public void register()
    {
        //Item Model Key: domain:models/item/ID
        models.put("slope", new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/slope.obj"), REFLECTION));
        models.put("corner", new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/corner.obj"), REFLECTION));
        models.put("ridge", new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/ridge.obj"), REFLECTION));
        models.put("pyramid", new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/pyramid.obj"), REFLECTION));
        models.put("invertedcorner", new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/invertedcorner.obj"), REFLECTION));
        models.put("invertedridge", new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/invertedridge.obj"), REFLECTION));
        models.put("invertedpyramid", new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/invertedpyramid.obj"), REFLECTION));

        for (String id : this.dummyIDs)
        {
            // DUMMY MODEL
            models.put(id, new ModelReflectiveShape(new ResourceLocation(AVP.Properties.ID, "block/slope.obj"), REFLECTION));
        }
    }

    public void registerDummy(String name)
    {
        dummyIDs.add(name);
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
