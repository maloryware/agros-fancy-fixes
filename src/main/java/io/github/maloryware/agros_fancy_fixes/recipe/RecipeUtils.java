package io.github.maloryware.agros_fancy_fixes.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;


public class RecipeUtils {

    public static class Serializers {
        public static void register(){

            Registry.register(Registries.RECIPE_SERIALIZER, ConversionRecipe.CONVERSION_RECIPE, ConversionRecipe.SERIALIZER);
        }
    }

}
