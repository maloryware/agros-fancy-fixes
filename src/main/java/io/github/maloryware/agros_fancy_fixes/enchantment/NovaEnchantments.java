package io.github.maloryware.agros_fancy_fixes.enchantment;


import cutefox.betterenchanting.registry.ModItems;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.util.Identifier;

import java.util.HashMap;

public class NovaEnchantments {

    public static final HashMap<RegistryKey<Enchantment>, Item> ENCHANTMENT_TO_ESSENCE = new HashMap<>();

    /**
     * enchants to map:
     <pre>
     {@code
     "nova_structures:gravity": "betterenchanting:essence_of_gravity",
     "nova_structures:outreach": "betterenchanting:essence_of_reach",
     "nova_structures:wax_wings": "betterenchanting:essence_of_wings",
     "nova_structures:multishot": "betterenchanting:essence_of_multishot",
     "nova_structures:antidote": "betterenchanting:essence_of_poison_protection",
     "nova_structures:traveler": "betterenchanting:essence_of_agility",
     "nova_structures:piercing": "betterenchanting:essence_of_piercing",
     "nova_structures:illagers_bane": "betterenchanting:essence_of_combat",
     "nova_structures:photosynthesis": "betterenchanting:essence_of_photosynthesis",
     "nova_structures:ghasted": "betterenchanting:essence_of_arrows",
     "nova_structures:wither_coated": "betterenchanting:essence_of_building",
     "nova_structures:power": "betterenchanting:essence_of_power"
     } </pre>
     */

    public static void init(){
        // uncommented = 1 level

        ENCHANTMENT_TO_ESSENCE.put(GRAVITY, ModItems.ESSENCE_OF_GRAVITY);               // 3 levels
        ENCHANTMENT_TO_ESSENCE.put(OUTREACH, ModItems.ESSENCE_OF_REACH);                // 4 levels
        ENCHANTMENT_TO_ESSENCE.put(WAX_WINGS, ModItems.ESSENCE_OF_WINGS);
        ENCHANTMENT_TO_ESSENCE.put(MULTISHOT, ModItems.ESSENCE_OF_MULTISHOT);
        ENCHANTMENT_TO_ESSENCE.put(ANTIDOTE, ModItems.ESSENCE_OF_POISON_PROTECTION);
        ENCHANTMENT_TO_ESSENCE.put(TRAVELLER, ModItems.ESSENCE_OF_AGILITY);             // 3 levels
        ENCHANTMENT_TO_ESSENCE.put(PIERCING, ModItems.ESSENCE_OF_PIERCING);             // 4 levels
        ENCHANTMENT_TO_ESSENCE.put(ILLAGERS_BANE, ModItems.ESSENCE_OF_COMBAT);          // 5 levels
        ENCHANTMENT_TO_ESSENCE.put(PHOTOSYNTHESIS, ModItems.ESSENCE_OF_PHOTOSYNTHESIS);
        ENCHANTMENT_TO_ESSENCE.put(GHASTED, ModItems.ESSENCE_OF_ARROWS);                // 3 levels
        ENCHANTMENT_TO_ESSENCE.put(WITHER_COATED, ModItems.ESSENCE_OF_BUILDING);
        ENCHANTMENT_TO_ESSENCE.put(POWER, ModItems.ESSENCE_OF_POWER);                   // doesn't... exist? wtf
    }

    public static final RegistryKey<Enchantment> GRAVITY = get("gravity");
    public static final RegistryKey<Enchantment> OUTREACH = get("outreach");
    public static final RegistryKey<Enchantment> WAX_WINGS = get("wax_wings");
    public static final RegistryKey<Enchantment> MULTISHOT = get("multishot");
    public static final RegistryKey<Enchantment> ANTIDOTE = get("antidote");
    public static final RegistryKey<Enchantment> TRAVELLER = get("traveler");
    public static final RegistryKey<Enchantment> PIERCING = get("piercing");
    public static final RegistryKey<Enchantment> ILLAGERS_BANE = get("illagers_bane");
    public static final RegistryKey<Enchantment> PHOTOSYNTHESIS = get("photosynthesis");
    public static final RegistryKey<Enchantment> GHASTED = get("ghasted");
    public static final RegistryKey<Enchantment> WITHER_COATED = get("wither_coated");
    public static final RegistryKey<Enchantment> POWER = get("power");

    private static RegistryKey<Enchantment> get(String name) {
        return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of("nova_structures", name));
    }








}
