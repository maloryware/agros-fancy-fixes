package io.github.maloryware.agros_fancy_fixes.util.events;

import com.mojang.brigadier.context.CommandContext;
import io.github.maloryware.agros_fancy_fixes.AgrosFancyFixes;
import io.github.maloryware.agros_fancy_fixes.config.AFFConfig;
import io.github.maloryware.agros_fancy_fixes.util.events.persistent_states.WorldSpawnLocation;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import static net.minecraft.server.command.CommandManager.literal;

// this feels. really gross, honestly?
// idrk of a better way to do half of these things though, so... yea

public class CustomCommands {

    private static Identifier SPAWN_LOCATION = AgrosFancyFixes.id("world_spawn");

    private static int listCommands(CommandContext<ServerCommandSource> context){

        context.getSource().sendFeedback(() -> Text.literal("Unimplemented..."), false);
        return 1;
    }

    @SuppressWarnings("DataFlowIssue")
    private static int setSpawn(CommandContext<ServerCommandSource> context){

        MinecraftServer server = context.getSource().getWorld().getServer();
        ServerWorld sourceWorld = context.getSource().getWorld();
        ServerPlayerEntity player = context.getSource().getPlayer();
        WorldSpawnLocation state;

        for (ServerWorld world : server.getWorlds()) {
            state = WorldSpawnLocation.getState(world);
            if(!sourceWorld.equals(world)) state.active = false;

            else {
                state.active = true;
                state.pos = player.getBlockPos();
            }

            world.getPersistentStateManager().set(AgrosFancyFixes.ID, state);
        }

        return 1;
    }

    @SuppressWarnings("DataFlowIssue")
    private static int goToSpawn(CommandContext<ServerCommandSource> context){

        MinecraftServer server = context.getSource().getWorld().getServer();
        ServerPlayerEntity player = context.getSource().getPlayer();
        ServerWorld targetWorld = null;
        BlockPos targetPos = null;

        for (ServerWorld world : server.getWorlds()) {
            WorldSpawnLocation state = WorldSpawnLocation.getState(world);
            if(state.active) {
                targetWorld = world;
                targetPos = state.pos;
                break;
            }

        }
        if(targetPos == null) {
            context.getSource().sendFeedback(() -> Text.literal("Something went wrong."), false);
            return 0;
        }

        player.teleport(targetWorld, targetPos.getX(), targetPos.getY(), targetPos.getZ(), 0, 0);
        return 1;
    }


    public static void init(){

        if(AFFConfig.should_prefix_commands)

            CommandRegistrationCallback.EVENT.register(
                    (dispatcher, registryAccess, environment) -> dispatcher.register(
                            literal("aff")
                                    .executes(CustomCommands::listCommands)

                            .then(
                                    literal("setspawn")
                                            .requires(source -> source.hasPermissionLevel(2))
                                            .executes(CustomCommands::setSpawn)
                            )

                            .then(
                                    literal("spawn")
                                            .executes(CustomCommands::goToSpawn)
                            )

                    ));

        else {

                CommandRegistrationCallback.EVENT.register(
                        (dispatcher, registryAccess, environment) -> dispatcher.register(
                                literal("setspawn")
                                        .requires(source -> source.hasPermissionLevel(2))
                                        .executes(CustomCommands::setSpawn)
                        )
                );

                CommandRegistrationCallback.EVENT.register(
                        (dispatcher, registryAccess, environment) -> dispatcher.register(
                                literal("spawn")
                                        .executes(CustomCommands::goToSpawn)
                        )
                );


            }


    }
}
