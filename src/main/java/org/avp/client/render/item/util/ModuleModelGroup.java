package org.avp.client.render.item.util;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import org.avp.client.Resources;

public class ModuleModelGroup {
    private final MapModelTexture<Model<?>> base;
    private final MapModelTexture<Model<?>> on;
    private final MapModelTexture<Model<?>> off;

    public ModuleModelGroup(MapModelTexture<Model<?>> base, MapModelTexture<Model<?>> on, MapModelTexture<Model<?>> off) {
        this.base = base;
        this.on = on;
        this.off = off;
    }

    public MapModelTexture<Model<?>> getBaseModel() {
        return base;
    }

    public MapModelTexture<Model<?>> getOnModel() {
        return on;
    }

    public MapModelTexture<Model<?>> getOffModel() {
        return off;
    }

    private static final ModuleModelGroup[] MODULE_MODEL_GROUPS = new ModuleModelGroup[] {
        new ModuleModelGroup(Resources.instance.models().RACKMODULE1, Resources.instance.models().RACKMODULE1_ON, Resources.instance.models().RACKMODULE1_OFF),
        new ModuleModelGroup(Resources.instance.models().RACKMODULE2, Resources.instance.models().RACKMODULE2_ON, Resources.instance.models().RACKMODULE2_OFF),
        new ModuleModelGroup(Resources.instance.models().RACKMODULE3, Resources.instance.models().RACKMODULE3_ON, Resources.instance.models().RACKMODULE3_OFF),
        new ModuleModelGroup(Resources.instance.models().RACKMODULE4, Resources.instance.models().RACKMODULE4_ON, Resources.instance.models().RACKMODULE4_OFF),
        new ModuleModelGroup(Resources.instance.models().RACKMODULE5, Resources.instance.models().RACKMODULE5_ON, Resources.instance.models().RACKMODULE5_OFF),
        new ModuleModelGroup(Resources.instance.models().RACKMODULE6, Resources.instance.models().RACKMODULE6_ON, Resources.instance.models().RACKMODULE6_OFF),
        new ModuleModelGroup(Resources.instance.models().RACKMODULE7, Resources.instance.models().RACKMODULE7_ON, Resources.instance.models().RACKMODULE7_OFF),
        new ModuleModelGroup(Resources.instance.models().RACKMODULE8, Resources.instance.models().RACKMODULE8_ON, Resources.instance.models().RACKMODULE8_OFF)
    };

    public static ModuleModelGroup getModelsForVariant(int variant) {
        return MODULE_MODEL_GROUPS[variant % MODULE_MODEL_GROUPS.length];
    }
}