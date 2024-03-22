package org.avp.common.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;

import org.avp.common.legacy.schematic.LegacySchematics;

/**
 * @author Boston Vanseghi
 */
public class AVPLegacySchematicCommand {

    public static void register(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(
            Commands.literal("schematic")
                .then(
                    Commands.literal("generate")
                        .executes(AVPLegacySchematicCommand::execute)
                )
        );
    }

    private static int execute(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        var commandSourceStack = context.getSource();

        if (!commandSourceStack.isPlayer()) {
            context.getSource()
                .sendFailure(Component.literal("Command must be ran by a player!"));
            return 0;
        }

        var player = commandSourceStack.getPlayerOrException();
        var playerBlockPos = player.getOnPos();
        var serverLevel = commandSourceStack.getLevel();
        var schematicOptional = LegacySchematics.DERELICT_SCHEMATIC.getOptional();

        if (schematicOptional.isEmpty()) {
            context.getSource().sendFailure(Component.literal("Could not retrieve schematic file."));
            return 0;
        }

        var legacySchematic = schematicOptional.get();
        legacySchematic.generateInLevel(serverLevel, playerBlockPos, true);
        context.getSource().sendSuccess(() -> Component.literal("Successfully generated."), false);
        return 1;
    }

    private AVPLegacySchematicCommand() {
        throw new UnsupportedOperationException();
    }
}
