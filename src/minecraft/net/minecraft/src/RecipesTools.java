package net.minecraft.src;

public class RecipesTools
{
    private String[][] recipePatterns = new String[][] {{"XXX", " # ", " # "}, {"X", "#", "#"}, {"XX", "X#", " #"}, {"XX", " #", " #"}};
    private Object[][] recipeItems;

    public RecipesTools()
    {
        this.recipeItems = new Object[][] {{Block.planks, Block.cobblestone, Item.ingotIron, Item.diamond, Item.ingotGold, Block.wood, Block.stone, Block.blockIron, Block.blockDiamond, Block.blockGold},
        	{Item.pickaxeWood, Item.pickaxeStone, Item.pickaxeIron, Item.pickaxeDiamond, Item.pickaxeGold, Item.pickaxeHARDWOOD, Item.pickaxeHARDSTONE, Item.pickaxeHARDIRON, Item.pickaxeHARDDIAMOND, Item.pickaxeHARDGOLD},
        	{Item.shovelWood, Item.shovelStone, Item.shovelIron, Item.shovelDiamond, Item.shovelGold, Item.shovelHARDWOOD, Item.shovelHARDSTONE, Item.shovelHARDIRON, Item.shovelHARDDIAMOND, Item.shovelHARDGOLD},
        	{Item.axeWood, Item.axeStone, Item.axeIron, Item.axeDiamond, Item.axeGold, Item.axeHARDWOOD, Item.axeHARDSTONE, Item.axeHARDIRON, Item.axeHARDDIAMOND, Item.axeHARDGOLD},
        	{Item.hoeWood, Item.hoeStone, Item.hoeIron, Item.hoeDiamond, Item.hoeGold, Item.hoeHARDWOOD, Item.hoeHARDSTONE, Item.hoeHARDIRON, Item.hoeHARDDIAMOND, Item.hoeHARDGOLD}};
    }

    /**
     * Adds the tool recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
    	
        for (int var2 = 0; var2 < this.recipeItems[0].length; ++var2)
        {
            Object var3 = this.recipeItems[0][var2];

            for (int var4 = 0; var4 < this.recipeItems.length - 1; ++var4)
            {
                Item var5 = (Item)this.recipeItems[var4 + 1][var2];
                par1CraftingManager.addRecipe(new ItemStack(var5), new Object[] {this.recipePatterns[var4], '#', Item.stick, 'X', var3});
            }
        }

        par1CraftingManager.addRecipe(new ItemStack(Item.shears), new Object[] {" #", "# ", '#', Item.ingotIron});
    }
}
