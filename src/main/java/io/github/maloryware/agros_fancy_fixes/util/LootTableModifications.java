package io.github.maloryware.agros_fancy_fixes.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

import static io.github.maloryware.agros_fancy_fixes.AgrosFancyFixes.AGROLOGGER;

public class LootTableModifications {


    private static final Identifier IRON_GOLEM_LOOT_TABLE = Identifier.ofVanilla("entities/iron_golem");

    public static void init() {
        LootTableEvents.REPLACE.register((key, original, source, registries) -> {

            if(source.isBuiltin() && key.getValue().equals(IRON_GOLEM_LOOT_TABLE)) {
                LootPool.Builder ironGolemPool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(0.7f))
                        .with(ItemEntry.builder(Items.POPPY))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1, 2)).build());
                //AGROLOGGER.info("yippeee modified loot table and now you have this shit --> ${}", ironGolemPool.toString());
                return LootTable.builder().pool(ironGolemPool).build();
            }

            return original;
        });
    }

}



