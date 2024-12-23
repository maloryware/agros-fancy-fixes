package io.github.maloryware.agros_fancy_fixes.util;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.*;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.World;

public class Utils {


    public static ItemStack getEnchantedBook(RegistryKey<Enchantment> enchantmentKey, World world){
        return getEnchantedBook(enchantmentKey, world,1);
    }

    public static ItemStack getEnchantedBook(RegistryKey<Enchantment> enchantmentKey, World world, int level){
        return getEnchantedBook(enchantmentKey, world.getRegistryManager(), level);

    }

    public static ItemStack getEnchantedBook(RegistryKey<Enchantment> enchantmentKey,RegistryWrapper.WrapperLookup lookup){
        return getEnchantedBook(enchantmentKey, lookup, 1);

    }


    public static ItemStack getEnchantedBook(RegistryKey<Enchantment> enchantmentKey, RegistryWrapper.WrapperLookup lookup, int level){
        RegistryEntryLookup<Enchantment> regentrylookup = lookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        RegistryEntry<Enchantment> enchantment = regentrylookup.getOrThrow(enchantmentKey);
        ItemStack stack = Items.ENCHANTED_BOOK.getDefaultStack();
        EnchantmentHelper.apply(stack,builder -> builder.set(enchantment, level));

        return stack;

    }

}
