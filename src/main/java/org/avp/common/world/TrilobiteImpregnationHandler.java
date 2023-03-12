package org.avp.common.world;

import com.asx.mdx.lib.util.Game;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.common.entities.living.species.species223ode.EntityTrilobite;

/**
 * 
 * @author Ri5ux
 *
 */
public class TrilobiteImpregnationHandler {
    public static final TrilobiteImpregnationHandler instance          = new TrilobiteImpregnationHandler();

    private TrilobiteImpregnationHandler() {}
    
    private static float                             rotationYawLock   = 0F;
    private static boolean                           rotationLocked    = false;
    
    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public void handlePlayerInput(InputUpdateEvent event)
    {
        if (Game.minecraft().player != null && Game.minecraft().player.getPassengers() != null && Game.minecraft().player.getPassengers().size() >= 1 && Game.minecraft().player.getPassengers().get(0) instanceof EntityTrilobite)
        {
            EntityTrilobite trilobite = (EntityTrilobite) Game.minecraft().player.getPassengers().get(0);

            if (!rotationLocked)
            {
                rotationYawLock = Game.minecraft().player.rotationYaw;
                Game.minecraft().player.moveRelative(0F, 0F, 2F, 1.0F);
                rotationLocked = true;
            }

            trilobite.rotationYawHead = rotationYawLock;
            trilobite.rotationYaw = rotationYawLock;
            trilobite.prevRotationYawHead = rotationYawLock;
            trilobite.prevRotationYaw = rotationYawLock;
            Game.minecraft().player.rotationPitch = -10F;
            Game.minecraft().player.rotationYaw = rotationYawLock;
            Game.minecraft().player.rotationYawHead = rotationYawLock;
            Game.minecraft().player.moveStrafing = 0F;
            event.getMovementInput().jump = false;
            event.getMovementInput().moveForward = event.getMovementInput().moveForward - event.getMovementInput().moveForward;
            event.getMovementInput().moveStrafe = event.getMovementInput().moveStrafe - event.getMovementInput().moveStrafe;
        }
        else
        {
            rotationLocked = false;
        }
    }
}
