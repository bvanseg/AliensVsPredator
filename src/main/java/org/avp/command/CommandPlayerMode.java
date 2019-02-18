package org.avp.command;

import org.avp.AliensVsPredator;
import org.avp.packets.client.PacketPlayerModeUpdate;
import org.avp.world.capabilities.ISpecialPlayer.SpecialPlayer;
import org.avp.world.playermode.PlayerMode;

import com.asx.mdx.lib.world.entity.player.Players;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.TextComponentString;

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
        SpecialPlayer specialPlayer = (SpecialPlayer) player.getCapability(SpecialPlayer.Provider.CAPABILITY, null);
        PlayerMode playerMode = PlayerMode.get(Integer.valueOf(args[0]));

        specialPlayer.setPlayerMode(playerMode);
        AliensVsPredator.network().sendTo(new PacketPlayerModeUpdate(playerMode.id), (EntityPlayerMP) Players.getPlayerForCommandSender(sender));
        sender.sendMessage(new TextComponentString("You have changed to the " + playerMode.toString().toLowerCase() + " player mode."));
    }
}
