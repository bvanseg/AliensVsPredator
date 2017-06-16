package org.avp.command;

import com.arisux.mdx.lib.game.Chat;
import com.arisux.mdx.lib.game.SchematicLoader;
import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.Structure;
import com.arisux.mdx.lib.world.StructureGenerationHandler;
import com.arisux.mdx.lib.world.entity.player.Players;
import com.arisux.mdx.lib.world.storage.Schematic;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.WorldServer;

public class CommandGenerate extends CommandBase
{
    @Override
    public String getName()
    {
        return "genschematic";
    }

    @Override
    public String getUsage(ICommandSender commandSender)
    {
        return "Generates a schematic that is currently loaded.";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException
    {
        final EntityPlayer player = Players.getPlayerForCommandSender(sender);

        if (args.length == 1 || args.length == 4)
        {
            String schematicTargetName = args[0];

            for (Schematic schematic : SchematicLoader.getSchematicRegistry())
            {
                String schematicFileName = schematic.getFile().getName();
                final String schematicName = schematicFileName.replace(".schematic", "");

                if (schematicTargetName.equals(schematicName))
                {
                    Pos data = null;

                    if (args.length == 1)
                    {
                        data = new Pos(player.posX, player.posY, player.posZ);
                    }
                    else if (args.length == 4)
                    {
                        double posX = Double.parseDouble(args[1]);
                        double posY = Double.parseDouble(args[2]);
                        double posZ = Double.parseDouble(args[3]);
                        data = new Pos(posX, posY, posZ);
                    }

                    WorldServer worldServer = server.worldServerForDimension(player.dimension);
                    Structure structure = new Structure(schematic, worldServer, data)
                    {
                        @Override
                        public String getName()
                        {
                            return schematicName;
                        }

                        @Override
                        public void onProcessing()
                        {
                            ;
                        }

                        @Override
                        public void onProcessingComplete()
                        {
                            player.sendMessage(Chat.component("Generation of " + this.getName() + " completed."));
                        }
                    };

                    StructureGenerationHandler.addStructureToQueue(structure);
                    sender.sendMessage(Chat.component("Started generation of " + schematicName));
                }
            }
        }
    }
}
