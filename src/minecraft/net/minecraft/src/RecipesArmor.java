package net.minecraft.src;

public class RecipesArmor
{
    private String[][] recipePatterns = new String[][] {{"XXX", "X X"}, {"X X", "XXX", "XXX"}, {"XXX", "X X", "X X"}, {"X X", "X X"}};
    private Object[][] recipeItems;

    public RecipesArmor()
    {
        this.recipeItems = new Object[][] {{Item.leather, Block.fire, Item.ingotIron, Item.diamond, Item.ingotGold, Block.blockIron, Block.blockDiamond, Block.blockGold},
        	{Item.helmetLeather, Item.helmetChain, Item.helmetIron, Item.helmetDiamond, Item.helmetGold, Item.helmetHARDIRON, Item.helmetHARDDIAMOND, Item.helmetHARDGOLD},
        	{Item.plateLeather, Item.plateChain, Item.plateIron, Item.plateDiamond, Item.plateGold, Item.plateHARDIRON, Item.plateHARDDIAMOND, Item.plateHARDGOLD}, 
        	{Item.legsLeather, Item.legsChain, Item.legsIron, Item.legsDiamond, Item.legsGold, Item.legsHARDIRON, Item.legsHARDDIAMOND, Item.legsHARDGOLD},
        	{Item.bootsLeather, Item.bootsChain, Item.bootsIron, Item.bootsDiamond, Item.bootsGold, Item.bootsHARDIRON, Item.bootsHARDDIAMOND, Item.bootsHARDGOLD}};
    }

    /**
     * Adds the armor recipes to the CraftingManager.
     */
    public void addRecipes(CraftingManager par1CraftingManager)
    {
        for (int var2 = 0; var2 < this.recipeItems[0].length; ++var2)
        {
            Object var3 = this.recipeItems[0][var2];

            for (int var4 = 0; var4 < this.recipeItems.length - 1; ++var4)
            {
                Item var5 = (Item)this.recipeItems[var4 + 1][var2];
                par1CraftingManager.addRecipe(new ItemStack(var5), new Object[] {this.recipePatterns[var4], 'X', var3});
            }
        }
    }
}
