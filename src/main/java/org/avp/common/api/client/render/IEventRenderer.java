package org.avp.common.api.client.render;



import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.Event;

public interface IEventRenderer
{
    void update(Event event, Minecraft game, World world);
    
    void render(Event event, float partialTicks);
}