package io.github.maloryware.agros_fancy_fixes.util.events.persistent_states;

import io.github.maloryware.agros_fancy_fixes.AgrosFancyFixes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.PersistentState;
import net.minecraft.world.PersistentStateManager;

// i'm twenty, and writing code worse than shedaniel did when he was 16. sigh

public class WorldSpawnLocation extends PersistentState {

    public BlockPos pos = BlockPos.fromLong(0);
    public boolean active = true;

    @Override
    public NbtCompound writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        nbt.putLong("spawn_pos", pos.asLong());
        nbt.putBoolean("is_active", active);
        return nbt;
    }

    public static WorldSpawnLocation createFromNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup){
        WorldSpawnLocation state = new WorldSpawnLocation();
        state.pos = BlockPos.fromLong(nbt.getLong("spawn_pos"));
        state.active = nbt.getBoolean("is_active");
        return state;

    }

    private static final Type<WorldSpawnLocation> type = new Type<>(
            WorldSpawnLocation::new,
            WorldSpawnLocation::createFromNbt,
            null
    );

    public static WorldSpawnLocation getState(ServerWorld world){

        PersistentStateManager stateManager = world.getPersistentStateManager();

        WorldSpawnLocation state = stateManager.getOrCreate(type, AgrosFancyFixes.ID);
        state.markDirty();

        return state;
    }

}
