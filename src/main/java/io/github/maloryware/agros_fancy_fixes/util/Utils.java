package io.github.maloryware.agros_fancy_fixes.util;

import io.github.maloryware.agros_fancy_fixes.recipe.ConversionRecipe;
import io.github.maloryware.agros_fancy_fixes.util.events.LootTableModifications;
import io.github.maloryware.agros_fancy_fixes.util.events.RecipeModifications;
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

        }

    }
    /*

    public static class Datapacks {
        static ModContainer mod = FabricLoader.getInstance().getModContainer(ID).get();

        public static void init() {
            ResourceManagerHelper.registerBuiltinResourcePack(AgrosFancyFixes.id("builtin"), mod, ResourcePackActivationType.DEFAULT_ENABLED);
        }
    }

     */



}
