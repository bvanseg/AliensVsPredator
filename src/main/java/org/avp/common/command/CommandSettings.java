package org.avp.common.command;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.AVP;
import org.avp.common.network.packet.server.PacketOpenGui;

public class CommandSettings extends CommandBase
{
    @Override
    public String getName()
    {
        return "avpsettings";
    }

    @Override
    public String getUsage(ICommandSender commandSender)
    {
        return "Opens an interface for adjusting advanced avp graphics settings.";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        if (FMLCommonHandler.instance().getSide() == Side.SERVER)
        {
            AVP.network().sendTo(new PacketOpenGui(AVP.interfaces().GUI_GRAPHICSSETTINGS), (EntityPlayerMP) sender);
            return;
        }

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            EntityPlayerMP player = (EntityPlayerMP) sender;
            GuiScreen gui = (GuiScreen) AVP.interfaces().getClientGuiElement(AVP.interfaces().GUI_GRAPHICSSETTINGS, player, player.world, (int) player.posX, (int) player.posY, (int) player.posZ);
            FMLCommonHandler.instance().showGuiScreen(gui);
        }
    }
    
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender)
    {
        return true;
    }
}
