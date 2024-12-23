package io.github.maloryware.agros_fancy_fixes.enchantment;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;

public class NovaEnchantments {


    // TODO: sort this mess out. i don't know what to do anymore, honestly.

    /**
        enchants to map:

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
     }
     </pre>


     */

    public static final Map<RegistryEntry<Enchantment>, Item> ENCHANT_TO_ESSENCE =
            Map.of(

                    );

    public static List<RegistryKey<Enchantment>> ENCHANTMENTS = List.of();

    public static final RegistryKey<Enchantment> GRAVITY = registryRef("gravity");
    public static final RegistryKey<Enchantment> OUTREACH = registryRef("outreach");
    public static final RegistryKey<Enchantment> WAX_WINGS = registryRef("wax_wings");
    public static final RegistryKey<Enchantment> MULTISHOT = registryRef("multishot");
    public static final RegistryKey<Enchantment> ANTIDOTE = registryRef("antidote");
    public static final RegistryKey<Enchantment> TRAVELLER = registryRef("traveler");
    public static final RegistryKey<Enchantment> PIERCING = registryRef("piercing");
    public static final RegistryKey<Enchantment> ILLAGERS_BANE = registryRef("illagers_bane");
    public static final RegistryKey<Enchantment> PHOTOSYNTHESIS = registryRef("photosynthesis");
    public static final RegistryKey<Enchantment> GHASTED = registryRef("ghasted");
    public static final RegistryKey<Enchantment> WITHER_COATED = registryRef("wither_coated");
    public static final RegistryKey<Enchantment> POWER = registryRef("power");


    private static RegistryKey<Enchantment> registryRef(String name) {
        var temp = RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of("nova_structures", name));
        ENCHANTMENTS.add(temp);
        return temp;
    }

}
