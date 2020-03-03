package net.minecraft.src;

import java.util.HashMap;
import java.util.Map;

public class FurnaceRecipes
{
    private static final FurnaceRecipes smeltingBase = new FurnaceRecipes();

    /** The list of smelting results. */
    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();

    /**
     * Used to call methods addSmelting and getSmeltingResult.
     */
    public static final FurnaceRecipes smelting()
    {
        return smeltingBase;
    }

    private FurnaceRecipes()
    {
    	 this.addSmelting(Block.gravel.blockID, new ItemStack(Item.flint), 0.7F);
        this.addSmelting(Block.oreIron.blockID, new ItemStack(Item.ingotIron), 0.7F);
        this.addSmelting(Block.oreGold.blockID, new ItemStack(Item.ingotGold), 1.0F);
        this.addSmelting(Block.oreDiamond.blockID, new ItemStack(Item.diamond), 1.0F);
        this.addSmelting(Block.sand.blockID, new ItemStack(Block.glass), 0.1F);
        this.addSmelting(Item.porkRaw.itemID, new ItemStack(Item.porkCooked), 0.35F);
        this.addSmelting(Item.beefRaw.itemID, new ItemStack(Item.beefCooked), 0.35F);
        this.addSmelting(Item.chickenRaw.itemID, new ItemStack(Item.chickenCooked), 0.35F);
        this.addSmelting(Item.fishRaw.itemID, new ItemStack(Item.fishCooked), 0.35F);
        this.addSmelting(Block.cobblestone.blockID, new ItemStack(Block.stone), 0.1F);
        this.addSmelting(Item.clay.itemID, new ItemStack(Item.brick), 0.3F);
        this.addSmelting(Block.cactus.blockID, new ItemStack(Item.dyePowder, 1, 2), 0.2F);
        this.addSmelting(Block.wood.blockID, new ItemStack(Item.coal, 1, 1), 0.15F);
        this.addSmelting(Block.oreEmerald.blockID, new ItemStack(Item.emerald), 1.0F);
        this.addSmelting(Item.potato.itemID, new ItemStack(Item.bakedPotato), 0.35F);
        this.addSmelting(Block.netherrack.blockID, new ItemStack(Item.netherrackBrick), 0.1F);
        this.addSmelting(Block.oreCoal.blockID, new ItemStack(Item.coal), 0.1F);
        this.addSmelting(Block.oreRedstone.blockID, new ItemStack(Item.redstone), 0.7F);
        this.addSmelting(Block.oreLapis.blockID, new ItemStack(Item.dyePowder, 1, 4), 0.2F);
        this.addSmelting(Block.oreNetherQuartz.blockID, new ItemStack(Item.netherQuartz), 0.2F);
        
        this.addSmelting(Item.pickaxeStone.itemID, new ItemStack(Block.cobblestone, 3));
        this.addSmelting(Item.pickaxeIron.itemID, new ItemStack(Item.ingotIron, 3));
        this.addSmelting(Item.pickaxeDiamond.itemID, new ItemStack(Item.diamond, 3));
        this.addSmelting(Item.pickaxeGold.itemID, new ItemStack(Item.ingotGold, 3));
        this.addSmelting(Item.pickaxeHARDSTONE.itemID, new ItemStack(Block.stone, 3));
        this.addSmelting(Item.pickaxeHARDIRON.itemID, new ItemStack(Block.blockIron, 3));
        this.addSmelting(Item.pickaxeHARDDIAMOND.itemID, new ItemStack(Block.blockDiamond, 3));
        this.addSmelting(Item.pickaxeHARDGOLD.itemID, new ItemStack(Block.blockGold, 3));
        
        this.addSmelting(Item.shovelStone.itemID, new ItemStack(Block.cobblestone, 1));
        this.addSmelting(Item.shovelIron.itemID, new ItemStack(Item.ingotIron, 1));
        this.addSmelting(Item.shovelDiamond.itemID, new ItemStack(Item.diamond, 1));
        this.addSmelting(Item.shovelGold.itemID, new ItemStack(Item.ingotGold, 1));
        this.addSmelting(Item.shovelHARDSTONE.itemID, new ItemStack(Block.stone, 1));
        this.addSmelting(Item.shovelHARDIRON.itemID, new ItemStack(Block.blockIron, 1));
        this.addSmelting(Item.shovelHARDDIAMOND.itemID, new ItemStack(Block.blockDiamond, 1));
        this.addSmelting(Item.shovelHARDGOLD.itemID, new ItemStack(Block.blockGold, 1));
        
        this.addSmelting(Item.axeStone.itemID, new ItemStack(Block.cobblestone, 3));
        this.addSmelting(Item.axeIron.itemID, new ItemStack(Item.ingotIron, 3));
        this.addSmelting(Item.axeDiamond.itemID, new ItemStack(Item.diamond, 3));
        this.addSmelting(Item.axeGold.itemID, new ItemStack(Item.ingotGold, 3));
        this.addSmelting(Item.axeHARDSTONE.itemID, new ItemStack(Block.stone, 3));
        this.addSmelting(Item.axeHARDIRON.itemID, new ItemStack(Block.blockIron, 3));
        this.addSmelting(Item.axeHARDDIAMOND.itemID, new ItemStack(Block.blockDiamond, 3));
        this.addSmelting(Item.axeHARDGOLD.itemID, new ItemStack(Block.blockGold, 3));
        
        this.addSmelting(Item.hoeStone.itemID, new ItemStack(Block.cobblestone, 2));
        this.addSmelting(Item.hoeIron.itemID, new ItemStack(Item.ingotIron, 2));
        this.addSmelting(Item.hoeDiamond.itemID, new ItemStack(Item.diamond, 2));
        this.addSmelting(Item.hoeGold.itemID, new ItemStack(Item.ingotGold, 2));
        this.addSmelting(Item.hoeHARDSTONE.itemID, new ItemStack(Block.stone, 2));
        this.addSmelting(Item.hoeHARDIRON.itemID, new ItemStack(Block.blockIron, 2));
        this.addSmelting(Item.hoeHARDDIAMOND.itemID, new ItemStack(Block.blockDiamond, 2));
        this.addSmelting(Item.hoeHARDGOLD.itemID, new ItemStack(Block.blockGold, 2));
        
        this.addSmelting(Item.swordStone.itemID, new ItemStack(Block.cobblestone, 2));
        this.addSmelting(Item.swordIron.itemID, new ItemStack(Item.ingotIron, 2));
        this.addSmelting(Item.swordDiamond.itemID, new ItemStack(Item.diamond, 2));
        this.addSmelting(Item.swordGold.itemID, new ItemStack(Item.ingotGold, 2));
        this.addSmelting(Item.swordHARDSTONE.itemID, new ItemStack(Block.stone, 2));
        this.addSmelting(Item.swordHARDIRON.itemID, new ItemStack(Block.blockIron, 2));
        this.addSmelting(Item.swordHARDDIAMOND.itemID, new ItemStack(Block.blockDiamond, 2));
        this.addSmelting(Item.swordHARDGOLD.itemID, new ItemStack(Block.blockGold, 2));
        
    }

    /**
     * Adds a smelting recipe.
     */
    public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }
    
    public void addSmelting(int par1, ItemStack par2ItemStack)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
    }

    /**
     * Returns the smelting result of an item.
     */
    public ItemStack getSmeltingResult(int par1)
    {
        return (ItemStack)this.smeltingList.get(Integer.valueOf(par1));
    }

    public Map getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getExperience(int par1)
    {
        return this.experienceList.containsKey(Integer.valueOf(par1)) ? ((Float)this.experienceList.get(Integer.valueOf(par1))).floatValue() : 0.0F;
    }
}
