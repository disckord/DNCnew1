package net.minecraft.src;

public class RecipesFood
{
    /**
     * Adds the food recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
        par1CraftingManager.addShapelessRecipe(new ItemStack(Item.bowlSoup), new Object[] {Block.mushroomBrown, Block.mushroomRed, Item.bowlEmpty});
        par1CraftingManager.addRecipe(new ItemStack(Item.cookie, 8), new Object[] {"#X#", 'X', new ItemStack(Item.dyePowder, 1, 3), '#', Item.wheat});

    }
}
