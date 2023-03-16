package org.alien.common.world;

import com.asx.mdx.client.ClientGame;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.common.entity.living.species223ode.EntityTrilobite;

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
        if (ClientGame.instance.minecraft().player != null && ClientGame.instance.minecraft().player.getPassengers() != null && ClientGame.instance.minecraft().player.getPassengers().size() >= 1 && ClientGame.instance.minecraft().player.getPassengers().get(0) instanceof EntityTrilobite)
        {
            EntityTrilobite trilobite = (EntityTrilobite) ClientGame.instance.minecraft().player.getPassengers().get(0);

            if (!rotationLocked)
            {
                rotationYawLock = ClientGame.instance.minecraft().player.rotationYaw;
                ClientGame.instance.minecraft().player.moveRelative(0F, 0F, 2F, 1.0F);
                rotationLocked = true;
            }

            trilobite.rotationYawHead = rotationYawLock;
            trilobite.rotationYaw = rotationYawLock;
            trilobite.prevRotationYawHead = rotationYawLock;
            trilobite.prevRotationYaw = rotationYawLock;
            ClientGame.instance.minecraft().player.rotationPitch = -10F;
            ClientGame.instance.minecraft().player.rotationYaw = rotationYawLock;
            ClientGame.instance.minecraft().player.rotationYawHead = rotationYawLock;
            ClientGame.instance.minecraft().player.moveStrafing = 0F;
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
