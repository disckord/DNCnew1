package net.minecraft.src;

public class ItemBow extends Item
{
	public EnumBowType ebt;
    public static final String[] bowPullIconNameArray = new String[] {"bow_pull_0", "bow_pull_1", "bow_pull_2"};

    public ItemBow(int par1, EnumBowType ebt)
    {
        super(par1);
        this.ebt = ebt;
        this.maxStackSize = 1;
        this.setMaxDamage(ebt.durability);
        this.setCreativeTab(CreativeTabs.tabCombat);
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {
    	EntityArrow ea = new EntityArrow(world, entityplayer, EnumArrowType.DEFAULT, this.ebt);
    	 
    	boolean var5 = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, itemstack) > 0;
    
    	int i = Item.arrow.itemID;
    	if(var5 && this.ebt == EnumBowType.GOLDBOW)
    	{
    		i = Item.goldArrow.itemID;
    		ea.setArrowType(EnumArrowType.GOLDARROW);
    		ea.setOnFireFromLava();
    	}
    	else if(var5)
    	{
    		 i = Item.diamondArrow.itemID;
    		 ea.setArrowType(EnumArrowType.DIAMONDARROW);
    	}
    	else if(entityplayer.inventory.hasItem(Item.goldArrow.itemID))
    	{
    		i = Item.goldArrow.itemID;
    		ea.setArrowType(EnumArrowType.GOLDARROW);
    	}
    	else if(entityplayer.inventory.hasItem(Item.diamondArrow.itemID))
    	{
    		i = Item.diamondArrow.itemID;
    		ea.setArrowType(EnumArrowType.DIAMONDARROW);
    	}
    	else if(entityplayer.inventory.hasItem(Item.ironArrow.itemID))
    	{
    		i = Item.ironArrow.itemID;
    		ea.setArrowType(EnumArrowType.IRONARROW);
    	}
    	
    	
    	if(ebt == EnumBowType.GOLDBOW)
    	{
    		
    		if(ea.eat == EnumArrowType.GOLDARROW)
    		{
    			ea.setOnFireFromLava();
    			//ea.setNoDropFlightDrop();
    		}
    	}
    	
        if(  var5 || entityplayer.inventory.consumeInventoryItem(i))
        {
            world.playSoundAtEntity(entityplayer, "random.bow", 1.0F, (ebt.velocity + ea.eat.addedVel)* (itemRand.nextFloat() * 0.4F) + 0.8F);
            if(!world.isRemote)
            {
                world.spawnEntityInWorld(ea);
            }
            itemstack.damageItem(1, entityplayer);
        }
        
        return itemstack;
    }


    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.bow;
    }

  

    /**
     * Return the enchantability factor of the item, most of the time is based on material.
     */
    public int getItemEnchantability()
    {
        return 1;
    }
}
