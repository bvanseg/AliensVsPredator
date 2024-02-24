package org.avp.client.render.entity;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import org.avp.AVPRegistry;
import org.avp.common.entity.*;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityRenderers implements AVPRegistry {
    private static final AVPEntityRenderers INSTANCE = new AVPEntityRenderers();

    public static AVPEntityRenderers getInstance() {
        return INSTANCE;
    }

    @Override
    public void register() {
        RenderingRegistry.registerEntityRenderingHandler(BelugabursterEntity.class, BelugabursterRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(BelugamorphEntity.class, BelugamorphRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(OctohuggerEntity.class, OctohuggerRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(OvamorphEntity.class, OvamorphRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(UltramorphEntity.class, UltramorphRenderer::new);
    }
}