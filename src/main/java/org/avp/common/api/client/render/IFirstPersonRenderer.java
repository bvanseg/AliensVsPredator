package org.avp.common.api.client.render;

import net.minecraftforge.fml.common.eventhandler.Event;

public interface IFirstPersonRenderer
{
    void renderFirstPerson(Event event, float partialTicks);
}
