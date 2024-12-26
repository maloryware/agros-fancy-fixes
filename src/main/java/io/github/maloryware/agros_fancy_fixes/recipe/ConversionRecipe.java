package io.github.maloryware.agros_fancy_fixes.recipe;

import io.github.maloryware.agros_fancy_fixes.AgrosFancyFixes;
import io.github.maloryware.agros_fancy_fixes.config.AFFConfig;
import io.github.maloryware.agros_fancy_fixes.enchantment.NovaEnchantments;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

@SuppressWarnings({"DataFlowIssue", "OptionalGetWithoutIsPresent"})
public class ConversionRecipe extends SpecialCraftingRecipe {

    public static final RecipeSerializer<ConversionRecipe> SERIALIZER = new SpecialRecipeSerializer<>(ConversionRecipe::new);
    public static final Identifier CONVERSION_RECIPE = AgrosFancyFixes.id("conversion_recipe");


    public ConversionRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {

        ItemStack stack = input.getStackInSlot(0);
        if(stack.get(DataComponentTypes.STORED_ENCHANTMENTS) == null) return false;
        var enchantlist = stack.get(DataComponentTypes.STORED_ENCHANTMENTS).getEnchantments();
        if(enchantlist.size() != 1) return false;

        var enchant = enchantlist.stream().findFirst().get().getKey();

        return input.getSize() == 1
                && stack.isOf(Items.ENCHANTED_BOOK)
                && enchantlist.size() == 1
                && NovaEnchantments.ENCHANTMENT_TO_ESSENCE.containsKey(enchant.get());

        // check for:A
        // - takes up only one slot
        // - any number of enchanted books of the same enchantment

        // hopefully this is good enough??? i don't fucking know. i couldn't get anyone to answer even if i
        // pointed a gun at their heads.

    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {

        ItemStack stack = input.getStackInSlot(0);

        if (!stack.isOf(Items.ENCHANTED_BOOK)) return ItemStack.EMPTY;
        // holy method train

        var enchant = stack.get(DataComponentTypes.STORED_ENCHANTMENTS).getEnchantments().stream().findFirst().get();
        int level = stack.get(DataComponentTypes.STORED_ENCHANTMENTS).getLevel(enchant);

        var enchantKey = enchant.getKey().get();
        ItemStack stackToReturn = NovaEnchantments.ENCHANTMENT_TO_ESSENCE.get(enchantKey).getDefaultStack();

        switch(AFFConfig.enchant_conversion){
            case DISABLED -> stackToReturn = ItemStack.EMPTY;

            case FIXED -> stackToReturn.setCount(1);
            case SCALING_STATIC -> stackToReturn.setCount(level);
            case SCALING_DYNAMIC -> {
                if (level > 2) {
                    stackToReturn.setCount(level % 2 == 0 ? (level / 2) : (level - 1) / 2 + 1);
                } else {
                    stackToReturn.setCount(1);
                }
            }
        }

        return stackToReturn;

    }

    @Override
    public boolean fits(int width, int height) {
        // one input, should always return true?
        return true;
    }


}
