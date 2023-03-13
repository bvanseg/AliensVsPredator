package org.avp.common.api.client.render;

import net.minecraftforge.fml.common.eventhandler.Event;

public interface FirstPersonRenderer
{
    void renderFirstPerson(Event event, float partialTicks);
}
