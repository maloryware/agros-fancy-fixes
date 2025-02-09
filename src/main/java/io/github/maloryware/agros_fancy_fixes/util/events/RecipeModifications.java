package io.github.maloryware.agros_fancy_fixes.util.events;

import io.github.maloryware.agros_fancy_fixes.AgrosFancyFixes;
import io.github.maloryware.agros_fancy_fixes.config.AFFConfig;
import net.minecraft.util.Identifier;
import net.ramixin.mixson.Mixson;

import java.util.List;

public class RecipeModifications {

    private static final List<Identifier> diamondRecipes = List.of(
            /* vanilla */
            Identifier.ofVanilla("recipe/diamond_axe"),
            Identifier.ofVanilla("recipe/diamond_boots"),
            Identifier.ofVanilla("recipe/diamond_chestplate"),
            Identifier.ofVanilla("recipe/diamond_helmet"),
            Identifier.ofVanilla("recipe/diamond_hoe"),
            Identifier.ofVanilla("recipe/diamond_leggings"),
            Identifier.ofVanilla("recipe/diamond_pickaxe"),
            Identifier.ofVanilla("recipe/diamond_shovel"),
            Identifier.ofVanilla("recipe/diamond_sword")
    );

    private static final List<Identifier> enchantmentRecipes = List.of(
            /* better enchanting */
            Identifier.of("betterenchanting", "recipe/essence_of_agility"),
            Identifier.of("betterenchanting", "recipe/essence_of_building"),
            Identifier.of("betterenchanting", "recipe/essence_of_gravity"),
            Identifier.of("betterenchanting", "recipe/essence_of_photosynthesis"),
            Identifier.of("betterenchanting", "recipe/essence_of_poison_protection"),
            Identifier.of("betterenchanting", "recipe/essence_of_reach"),
            Identifier.of("betterenchanting", "recipe/essence_of_wings")
    );


    public static void init(){

        for(Identifier recipe : diamondRecipes) {
            Identifier eventId = AgrosFancyFixes.id(String.format("disable_recipe.%s", recipe.getPath()));
            Mixson.registerDeletionEvent(10000, recipe, eventId, () -> !AFFConfig.enable_diamond_recipes, false);

        }

        for(Identifier recipe : enchantmentRecipes) {
            Identifier eventId = AgrosFancyFixes.id(String.format("disable_recipe.%s", recipe.getPath()));
            Mixson.registerDeletionEvent(10000, recipe, eventId, () -> !AFFConfig.enable_better_enchantment_recipes, false);

        }
    }


}
