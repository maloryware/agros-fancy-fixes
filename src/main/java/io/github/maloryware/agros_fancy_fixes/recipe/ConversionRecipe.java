package io.github.maloryware.agros_fancy_fixes.recipe;

import io.github.maloryware.agros_fancy_fixes.AgrosFancyFixes;
import io.github.maloryware.agros_fancy_fixes.enchantment.NovaEnchantments;
import io.github.maloryware.agros_fancy_fixes.util.Utils;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.*;
import net.minecraft.recipe.book.CraftingRecipeCategory;
import net.minecraft.recipe.input.CraftingRecipeInput;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ConversionRecipe extends SpecialCraftingRecipe {

    // stupid bullshit. stupid. never let me mod again
    protected static final RecipeSerializer<ConversionRecipe> SERIALIZER = new SpecialRecipeSerializer<>(ConversionRecipe::new);
    protected static final Identifier CONVERSION_RECIPE = AgrosFancyFixes.id("conversion_recipe");


    public ConversionRecipe(CraftingRecipeCategory category) {
        super(category);
    }

    @Override
    public boolean matches(CraftingRecipeInput input, World world) {

        return input.getSize() == 1 && input.getStacks().contains(Items.ENCHANTED_BOOK.getDefaultStack());

        // check for:
        // - takes up only one slot
        // - any number of enchanted books of the same enchantment

        // hopefully this is good enough??? i don't fucking know. i couldn't get anyone to answer even if i
        // pointed a gun at their heads.

    }

    @Override
    public ItemStack craft(CraftingRecipeInput input, RegistryWrapper.WrapperLookup lookup) {

        ItemStack stack = input.getStackInSlot(0);

        if (stack.isOf(Items.ENCHANTED_BOOK)) return ItemStack.EMPTY;

        // TODO: figure this out. god.
        /*
        for(var entry : NovaEnchantments.ENCHANTMENTS){
            ItemStack stack2 = Utils.getEnchantedBook(entry, lookup);
            if(stack.equals(stack2)){
                return ItemStack.EMPTY
            }
        }

         */


        // should return a *copy* of the stack displayed in getResult()
        return null;
    }

    @Override
    public boolean fits(int width, int height) {
        // one input, should always return true?
        return true;
    }


    @Override
    public RecipeSerializer<?> getSerializer() {
        return SERIALIZER;
    }




}
