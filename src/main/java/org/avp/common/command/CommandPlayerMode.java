package org.avp.common.command;

import com.asx.mdx.lib.world.entity.player.Players;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;
import org.avp.AVP;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.PacketPlayerModeUpdate;
import org.avp.common.world.capability.SpecialPlayer.SpecialPlayerImpl;
import org.avp.common.world.playermode.PlayerMode;

public class CommandPlayerMode extends CommandBase
{
    @Override
    public String getName()
    {
        return "playermode";
    }

    @Override
    public String getUsage(ICommandSender commandSender)
    {
        return "Change the current player mode.";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        EntityPlayer player = Players.getPlayerForCommandSender(sender);
        SpecialPlayerImpl specialPlayer = (SpecialPlayerImpl) player.getCapability(SpecialPlayerImpl.Provider.CAPABILITY, null);
        PlayerMode playerMode = PlayerMode.get(Integer.valueOf(args[0]));

        specialPlayer.setPlayerMode(playerMode);
        AVPNetworking.instance.sendTo(new PacketPlayerModeUpdate(playerMode.id), (EntityPlayerMP) Players.getPlayerForCommandSender(sender));
        sender.sendMessage(new TextComponentString("You have changed to the " + playerMode.toString().toLowerCase() + " player mode."));
    }
}
