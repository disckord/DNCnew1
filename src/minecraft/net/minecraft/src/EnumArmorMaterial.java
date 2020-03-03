package net.minecraft.src;

public enum EnumArmorMaterial
{
    CLOTH(5, new int[]{1, 3, 2, 1}, 0),
    CHAIN(15, new int[]{2, 5, 4, 1}, 0),
    IRON(15, new int[]{2, 6, 5, 2}, 0),
    GOLD(7, new int[]{2, 5, 3, 1}, 0),
    DIAMOND(33, new int[]{3, 8, 6, 3}, 0),
    HARDIRON(20, new int[]{3,8,6,3}, 0),
	HARDDIAMOND(53, new int[]{3,8,6,3}, 0),
	HARDGOLD(14, new int[]{2,5,4,1}, 0);
	
	

    /**
     * Holds the maximum damage factor (each piece multiply this by it's own value) of the material, this is the item
     * damage (how much can absorb before breaks)
     */
    private int maxDamageFactor;
    private int special;
    /**
     * Holds the damage reduction (each 1 points is half a shield on gui) of each piece of armor (helmet, plate, legs
     * and boots)
     */
    private int[] damageReductionAmountArray;

    /** Return the enchantability factor of the material */
    private int enchantability = 0;

    private EnumArmorMaterial(int par3, int[] par4ArrayOfInteger, int par4)
    {
        this.maxDamageFactor = par3;
        this.damageReductionAmountArray = par4ArrayOfInteger;
        this.special = par4;
       
    }

    /**
     * Returns the durability for a armor slot of for this type.
     */
    public int getDurability(int par1)
    {
        return ItemArmor.getMaxDamageArray()[par1] * this.maxDamageFactor;
    }

    /**
     * Return the damage reduction (each 1 point is a half a shield on gui) of the piece index passed (0 = helmet, 1 =
     * plate, 2 = legs and 3 = boots)
     */
    public int getDamageReductionAmount(int par1)
    {
        return this.damageReductionAmountArray[par1];
    }
    
    
    /**
     * Return the enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return this.enchantability;
    }
    
    public int getSpecial()
    {
    	return this.special;
    }

    /**
     * Return the crafting material for this armor material, used to determine the item that can be used to repair an
     * armor piece with an anvil
     */
    public int getArmorCraftingMaterial()
    {
        return this == CLOTH ? Item.leather.itemID : (this == CHAIN ? Item.ingotIron.itemID : (this == GOLD ? Item.ingotGold.itemID : (this == IRON ? Item.ingotIron.itemID : (this == DIAMOND ? Item.diamond.itemID :
        	(this == HARDIRON ? Block.blockIron.blockID : (this == HARDDIAMOND? Block.blockDiamond.blockID : (this == HARDGOLD ? Block.blockGold.blockID : 0)))))));
    }
}
