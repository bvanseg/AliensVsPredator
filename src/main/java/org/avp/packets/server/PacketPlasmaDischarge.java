package org.avp.packets.server;

import org.avp.Sounds;
import org.avp.entities.EntityPlasma;

import com.arisux.mdxlib.lib.util.MDXMath;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;

public class PacketPlasmaDischarge implements IMessage, IMessageHandler<PacketPlasmaDischarge, PacketPlasmaDischarge>
{
    public float size;
    
    public PacketPlasmaDischarge()
    {
        ;
    }
    public PacketPlasmaDischarge(float size)
    {
        this.size = size;
    }

    @Override
    public void toBytes(ByteBuf buffer)
    {
        buffer.writeFloat(this.size);
    }

    @Override
    public void fromBytes(ByteBuf buffer)
    {
        this.size = buffer.readFloat();
    }

    @Override
    public PacketPlasmaDischarge onMessage(PacketPlasmaDischarge packet, MessageContext ctx)
    {
        EntityPlayer player = ctx.getServerHandler().playerEntity;

        if (player != null)
        {
            EntityPlasma plasma = new EntityPlasma(player.worldObj, player, packet.size);

            if (plasma != null)
            {
                double dist = 0.6F;
                float rotationYaw = MDXMath.interpolateRotation(player.prevRenderYawOffset, player.renderYawOffset, 0F);
                float rotationYawHead = MDXMath.interpolateRotation(player.prevRotationYawHead, player.rotationYawHead, 0F);
                double rotationYawRadians = Math.toRadians((rotationYawHead - (rotationYaw - rotationYawHead)) + 180);
                double plasmaX = (player.posX + (dist * (Math.cos(rotationYawRadians))));
                double plasmaZ = (player.posZ + (dist * (Math.sin(rotationYawRadians))));
                
                float speed = 2F;
                plasma.setLocationAndAngles(plasmaX, player.posY + player.getEyeHeight() + 0.025F, plasmaZ, player.rotationYaw, player.rotationPitch);
                plasma.motionX = -MathHelper.sin(plasma.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(plasma.rotationPitch / 180.0F * (float) Math.PI) * speed;
                plasma.motionZ = MathHelper.cos(plasma.rotationYaw / 180.0F * (float) Math.PI) * MathHelper.cos(plasma.rotationPitch / 180.0F * (float) Math.PI) * speed;
                plasma.motionY = -MathHelper.sin((plasma.rotationPitch) / 180.0F * (float) Math.PI) * speed;
                player.worldObj.spawnEntityInWorld(plasma);
                Sounds.SOUND_WEAPON_PLASMACASTER.playSound(plasma, 0.1F, 1.0F);
            }
        }

        return null;
    }
}