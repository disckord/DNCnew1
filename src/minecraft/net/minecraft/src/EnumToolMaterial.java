package net.minecraft.src;

public enum EnumToolMaterial
{//Harvest level, Durability, Efficiency, Damage, Quarts damage bonus, Enchantability
	//Sword damage is 4 plus damaveVSentity times by 2 (eg, EMERALD is 4 + 6 (3  x 2 ) = 10
	WOOD(0, 59, 2.0F, 0, 0),
    STONE(1, 131, 4.0F, 1, 0),
    IRON(2, 250, 6.0F, 2, 0),
    EMERALD(3, 1561, 8.0F,3, 0),
    GOLD(0, 32, 12.0F, 0, 0),
	HARDWOOD(0,59,3.0F,1, 0),
	HARDSTONE(2,131,5.0F,2, -1),
	HARDIRON(2,1875,7.0F,3, -1),
	HARDDIAMOND(3,8781,11.0F,8, -2),
	HARDGOLD(1,216,15.0F,1, 0),
	QEIRON(2,750,8.0F,3, -1),
	QEDIAMOND(3,2061,10.0F,8, -2),
	QEGOLD(0, 200, 14.0F, 1, 1),
	QEHARDIRON(3,2875,12.0F,3, 0),
	QEHARDDIAMOND(3,9781,16.0F,8, 0),
	QEHARDGOLD(2,1216,20.0F,1, 2);
	

    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    private final int harvestLevel;
    
 

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    private final int maxUses;

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    private final float efficiencyOnProperMaterial;

    /** Damage versus entities. */
    private final int damageVsEntity;
   
    private final int quartzdamagebonus;
    private final int enchantability;

    private EnumToolMaterial(int var3, int var4, float var5, int var6, int var7)
    {
        this.harvestLevel = var3;
        this.maxUses = var4;
        this.efficiencyOnProperMaterial = var5;
        this.damageVsEntity = var6;
        this.quartzdamagebonus = var7;
        this.enchantability = 0;
    }

    /**
     * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
     */
    public int getMaxUses()
    {
        return this.maxUses;
    }

    /**
     * The strength of this tool material against blocks which it is effective against.
     */
    public float getEfficiencyOnProperMaterial()
    {
        return this.efficiencyOnProperMaterial;
    }

    /**
     * Damage versus entities.
     */
    public int getDamageVsEntity()
    {
        return this.damageVsEntity;
    }

    public int getQuartzDamageBonus()
    {
    	return this.quartzdamagebonus;
    }
    /**
     * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
     */
    public int getHarvestLevel()
    {
        return this.harvestLevel;
    }

    /**
     * Return the natural enchantability factor of the material.
     */
    public int getEnchantability()
    {
        return 0;
    }
    
    public int getSpecial()
    {
    	return this.quartzdamagebonus;
    }

    /**
     * Return the crafting material for this tool material, used to determine the item that can be used to repair a tool
     * with an anvil
     */
    public int getToolCraftingMaterial()
    {
        return this == WOOD ? Block.planks.blockID : (this == STONE ? Block.cobblestone.blockID : (this == GOLD ? Item.ingotGold.itemID : (this == IRON ? Item.ingotIron.itemID : (this == EMERALD ? Item.diamond.itemID :
        	(this == HARDWOOD ? Block.wood.blockID : (this == HARDSTONE ? Block.stone.blockID : (this == HARDIRON ? Block.blockIron.blockID : (this == HARDDIAMOND ? Block.blockDiamond.blockID : ( this == HARDGOLD ? Block.blockGold.blockID : 0 )))))))));
    }
}
