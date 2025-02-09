package io.github.maloryware.agros_fancy_fixes.util;

import io.github.maloryware.agros_fancy_fixes.recipe.ConversionRecipe;
import io.github.maloryware.agros_fancy_fixes.util.events.CustomCommands;
import io.github.maloryware.agros_fancy_fixes.util.events.LootTableModifications;
import io.github.maloryware.agros_fancy_fixes.util.events.RecipeModifications;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class Utils {

    public static class Serializers {

        public static void register(){
            Registry.register(Registries.RECIPE_SERIALIZER, ConversionRecipe.CONVERSION_RECIPE, ConversionRecipe.SERIALIZER);
        }
    }

    public static class Events {

        public static void init(){
            LootTableModifications.init();
            RecipeModifications.init();
            CustomCommands.init();

        }

    }
    @Environment(EnvType.SERVER)
    public static class ServerLogic {

        public static void init(){




        }


    }



}
