package net.minecraft.src;

import java.util.Random;

public class BWG4decoDungeons extends WorldGenerator
{
    public int chestID = 0;
    public boolean checkpos = true;
    public boolean isSkyDungeon = false;
    public boolean isEndDungeon = false;
    public boolean specialChest = false;

    public BWG4decoDungeons(int var1, boolean var2, boolean var3, boolean var4)
    {
        this.chestID = var1;
        this.checkpos = var2;
        this.isSkyDungeon = var3;
        this.isEndDungeon = var4;

        if (var1 == 9 || var1 == 10)
        {
            this.specialChest = true;
        }
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var10;
        int var11;
        int var12;
        int var14;

        if (!this.isSkyDungeon && !this.isEndDungeon)
        {
            byte var18 = 3;
            int var19 = var2.nextInt(2) + 2;
            int var20 = var2.nextInt(2) + 2;
            int var21 = 0;

            if (this.checkpos)
            {
                for (var10 = var3 - var19 - 1; var10 <= var3 + var19 + 1; ++var10)
                {
                    for (var11 = var4 - 1; var11 <= var4 + var18 + 1; ++var11)
                    {
                        for (var12 = var5 - var20 - 1; var12 <= var5 + var20 + 1; ++var12)
                        {
                            Material var23 = var1.getBlockMaterial(var10, var11, var12);

                            if (var11 == var4 - 1 && !var23.isSolid())
                            {
                                return false;
                            }

                            if (var11 == var4 + var18 + 1 && !var23.isSolid())
                            {
                                return false;
                            }

                            if ((var10 == var3 - var19 - 1 || var10 == var3 + var19 + 1 || var12 == var5 - var20 - 1 || var12 == var5 + var20 + 1) && var11 == var4 && var1.isAirBlock(var10, var11, var12) && var1.isAirBlock(var10, var11 + 1, var12))
                            {
                                ++var21;
                            }
                        }
                    }
                }
            }

            if ((var21 < 1 || var21 > 5) && this.checkpos)
            {
                return false;
            }
            else
            {
                for (var10 = var3 - var19 - 1; var10 <= var3 + var19 + 1; ++var10)
                {
                    for (var11 = var4 + var18; var11 >= var4 - 1; --var11)
                    {
                        for (var12 = var5 - var20 - 1; var12 <= var5 + var20 + 1; ++var12)
                        {
                            if (var10 != var3 - var19 - 1 && var11 != var4 - 1 && var12 != var5 - var20 - 1 && var10 != var3 + var19 + 1 && var11 != var4 + var18 + 1 && var12 != var5 + var20 + 1)
                            {
                                var1.setBlock(var10, var11, var12, 0);
                            }
                            else if (var11 >= 0 && !var1.getBlockMaterial(var10, var11 - 1, var12).isSolid())
                            {
                                var1.setBlock(var10, var11, var12, 0);
                            }
                            else if (var1.getBlockMaterial(var10, var11, var12).isSolid())
                            {
                                if (var11 == var4 - 1 && var2.nextInt(4) != 0)
                                {
                                    var1.setBlock(var10, var11, var12, Block.cobblestoneMossy.blockID);
                                }
                                else
                                {
                                    var1.setBlock(var10, var11, var12, Block.cobblestone.blockID);
                                }
                            }
                        }
                    }
                }

                var10 = 0;

                if (this.specialChest)
                {
                    var10 = 1;
                }

                while (var10 < 2)
                {
                    var11 = 0;

                    while (true)
                    {
                        if (var11 < 3)
                        {
                            label308:
                            {
                                var12 = var3 + var2.nextInt(var19 * 2 + 1) - var19;
                                int var25 = var5 + var2.nextInt(var20 * 2 + 1) - var20;

                                if (var1.isAirBlock(var12, var4, var25))
                                {
                                    var14 = 0;

                                    if (var1.getBlockMaterial(var12 - 1, var4, var25).isSolid())
                                    {
                                        ++var14;
                                    }

                                    if (var1.getBlockMaterial(var12 + 1, var4, var25).isSolid())
                                    {
                                        ++var14;
                                    }

                                    if (var1.getBlockMaterial(var12, var4, var25 - 1).isSolid())
                                    {
                                        ++var14;
                                    }

                                    if (var1.getBlockMaterial(var12, var4, var25 + 1).isSolid())
                                    {
                                        ++var14;
                                    }

                                    if (this.specialChest)
                                    {
                                        var14 = 1;
                                    }

                                    if (var14 == 1)
                                    {
                                        var1.setBlock(var12, var4, var25, Block.chest.blockID);
                                        TileEntityChest var27 = (TileEntityChest)var1.getBlockTileEntity(var12, var4, var25);

                                        if (var27 != null)
                                        {
                                            int var16;
                                            ItemStack var17;

                                            if (!this.specialChest)
                                            {
                                                var16 = 0;

                                                while (true)
                                                {
                                                    if (var16 >= 14)
                                                    {
                                                        break label308;
                                                    }

                                                    var17 = this.pickCheckLootItem(var2, 0);

                                                    if (var17 != null)
                                                    {
                                                        var27.setInventorySlotContents(var2.nextInt(var27.getSizeInventory()), var17);
                                                    }

                                                    ++var16;
                                                }
                                            }

                                            for (var16 = 0; var16 < 20; ++var16)
                                            {
                                                var17 = this.pickCheckLootItem(var2, var16);

                                                if (var17 != null)
                                                {
                                                    var27.setInventorySlotContents(var16, var17);
                                                }
                                            }
                                        }

                                        break label308;
                                    }
                                }

                                ++var11;
                                continue;
                            }
                        }

                        ++var10;
                        break;
                    }
                }

                var1.setBlock(var3, var4, var5, Block.mobSpawner.blockID);
                TileEntityMobSpawner var26 = (TileEntityMobSpawner)var1.getBlockTileEntity(var3, var4, var5);

                if (var26 != null)
                {
                    var26.func_98049_a().setMobID(this.pickMobSpawner(var2));
                }
                else
                {
                    System.err.println("Failed to fetch mob spawner entity at (" + var3 + ", " + var4 + ", " + var5 + ")");
                }

                return true;
            }
        }
        else
        {
            boolean var6 = false;
            boolean var7 = false;
            boolean var8 = false;
            boolean var9 = false;

            for (var10 = var4; var10 < 60; ++var10)
            {
                if (!var1.isAirBlock(var3 + 4, var10 + 5, var5 + 4))
                {
                    var6 = true;
                    break;
                }
            }

            for (var10 = var4; var10 < 60; ++var10)
            {
                if (!var1.isAirBlock(var3 + 4, var10 + 5, var5 - 4))
                {
                    var7 = true;
                    break;
                }
            }

            for (var10 = var4; var10 < 60; ++var10)
            {
                if (!var1.isAirBlock(var3 - 4, var10 + 5, var5 + 4))
                {
                    var8 = true;
                    break;
                }
            }

            for (var10 = var4; var10 < 60; ++var10)
            {
                if (!var1.isAirBlock(var3 - 4, var10 + 5, var5 - 4))
                {
                    var9 = true;
                    break;
                }
            }

            if (var6 && var7 && var8 && var9)
            {
                for (var10 = var4 + 5; var10 < 70 && var1.isAirBlock(var3 + 4, var10, var5 + 4); ++var10)
                {
                    var1.setBlock(var3 + 4, var10, var5 + 4, Block.fenceIron.blockID);
                }

                for (var10 = var4 + 5; var10 < 70 && var1.isAirBlock(var3 + 4, var10, var5 - 4); ++var10)
                {
                    var1.setBlock(var3 + 4, var10, var5 - 4, Block.fenceIron.blockID);
                }

                for (var10 = var4 + 5; var10 < 70 && var1.isAirBlock(var3 - 4, var10, var5 + 4); ++var10)
                {
                    var1.setBlock(var3 - 4, var10, var5 + 4, Block.fenceIron.blockID);
                }

                for (var10 = var4 + 5; var10 < 70 && var1.isAirBlock(var3 - 4, var10, var5 - 4); ++var10)
                {
                    var1.setBlock(var3 - 4, var10, var5 - 4, Block.fenceIron.blockID);
                }

                if (this.checkpos)
                {
                    var1.setBlock(var3 + 4, var4 + 6, var5 + 4, Block.netherBrick.blockID);
                    var1.setBlock(var3 + 4, var4 + 6, var5 - 4, Block.netherBrick.blockID);
                    var1.setBlock(var3 - 4, var4 + 6, var5 + 4, Block.netherBrick.blockID);
                    var1.setBlock(var3 - 4, var4 + 6, var5 - 4, Block.netherBrick.blockID);
                }
                else
                {
                    var1.setBlock(var3 + 4, var4 + 6, var5 + 4, Block.cobblestoneMossy.blockID);
                    var1.setBlock(var3 + 4, var4 + 6, var5 - 4, Block.cobblestoneMossy.blockID);
                    var1.setBlock(var3 - 4, var4 + 6, var5 + 4, Block.cobblestoneMossy.blockID);
                    var1.setBlock(var3 - 4, var4 + 6, var5 - 4, Block.cobblestoneMossy.blockID);
                }

                for (var10 = var3 - 4; var10 < var3 + 5; ++var10)
                {
                    for (var11 = var4; var11 < var4 + 6; ++var11)
                    {
                        for (var12 = var5 - 4; var12 < var5 + 5; ++var12)
                        {
                            if (var2.nextInt(10) == 0)
                            {
                                var1.setBlock(var10, var11, var12, 0);
                            }
                            else if (this.checkpos)
                            {
                                var1.setBlock(var10, var11, var12, Block.netherBrick.blockID);
                            }
                            else if (var2.nextInt(2) != 0)
                            {
                                var1.setBlock(var10, var11, var12, Block.cobblestoneMossy.blockID);
                            }
                            else
                            {
                                var1.setBlock(var10, var11, var12, Block.cobblestone.blockID);
                            }
                        }
                    }
                }

                for (var10 = var3 - 3; var10 < var3 + 4; ++var10)
                {
                    for (var11 = var4 + 1; var11 < var4 + 5; ++var11)
                    {
                        for (var12 = var5 - 3; var12 < var5 + 4; ++var12)
                        {
                            var1.setBlock(var10, var11, var12, 0);
                        }
                    }
                }

                TileEntityMobSpawner var28;

                if (this.isEndDungeon)
                {
                    var1.setBlock(var3 + 2, var4 + 1, var5 - 1, Block.endPortalFrame.blockID, 1 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 + 2, var4 + 1, var5 + 0, Block.endPortalFrame.blockID, 1 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 + 2, var4 + 1, var5 + 1, Block.endPortalFrame.blockID, 1 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 - 1, var4 + 1, var5 + 2, Block.endPortalFrame.blockID, 2 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 + 0, var4 + 1, var5 + 2, Block.endPortalFrame.blockID, 2 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 + 1, var4 + 1, var5 + 2, Block.endPortalFrame.blockID, 2 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 - 2, var4 + 1, var5 - 1, Block.endPortalFrame.blockID, 3 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 - 2, var4 + 1, var5 + 0, Block.endPortalFrame.blockID, 3 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 - 2, var4 + 1, var5 + 1, Block.endPortalFrame.blockID, 3 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 - 1, var4 + 1, var5 - 2, Block.endPortalFrame.blockID, 0 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 + 0, var4 + 1, var5 - 2, Block.endPortalFrame.blockID, 0 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3 + 1, var4 + 1, var5 - 2, Block.endPortalFrame.blockID, 0 + (var2.nextFloat() > 0.9F ? 4 : 0), 0);
                    var1.setBlock(var3, var4 + 6, var5, Block.mobSpawner.blockID);
                    var28 = (TileEntityMobSpawner)var1.getBlockTileEntity(var3, var4 + 6, var5);

                    if (var28 != null)
                    {
                        var28.func_98049_a().setMobID(this.pickMobSpawner(var2));
                    }
                }
                else
                {
                    var1.setBlock(var3, var4 + 1, var5, Block.mobSpawner.blockID);
                    var1.setBlock(var3, var4 + 3, var5, Block.mobSpawner.blockID);
                    var1.setBlock(var3, var4 + 6, var5, Block.mobSpawner.blockID);
                    var28 = (TileEntityMobSpawner)var1.getBlockTileEntity(var3, var4 + 1, var5);
                    TileEntityMobSpawner var22 = (TileEntityMobSpawner)var1.getBlockTileEntity(var3, var4 + 3, var5);
                    TileEntityMobSpawner var24 = (TileEntityMobSpawner)var1.getBlockTileEntity(var3, var4 + 6, var5);

                    if (var28 != null)
                    {
                        var28.func_98049_a().setMobID(this.pickMobSpawner(var2));
                    }

                    if (var22 != null)
                    {
                        var22.func_98049_a().setMobID(this.pickMobSpawner(var2));
                    }

                    if (var24 != null)
                    {
                        var24.func_98049_a().setMobID(this.pickMobSpawner(var2));
                    }

                    var1.setBlock(var3, var4 + 2, var5, Block.chest.blockID);
                    TileEntityChest var13 = (TileEntityChest)var1.getBlockTileEntity(var3, var4 + 2, var5);
                    ItemStack var15;

                    if (this.specialChest)
                    {
                        for (var14 = 0; var14 < 20; ++var14)
                        {
                            var15 = this.pickCheckLootItem(var2, var14);

                            if (var15 != null)
                            {
                                var13.setInventorySlotContents(var14, var15);
                            }
                        }
                    }
                    else
                    {
                        for (var14 = 0; var14 < 14; ++var14)
                        {
                            var15 = this.pickCheckLootItem(var2, 0);

                            if (var15 != null)
                            {
                                var13.setInventorySlotContents(var2.nextInt(var13.getSizeInventory()), var15);
                            }
                        }
                    }
                }

                return false;
            }
            else
            {
                return false;
            }
        }
    }

    private ItemStack pickCheckLootItem(Random var1, int var2)
    {
        int var3;

        if (this.chestID == 0)
        {
            var3 = var1.nextInt(17);
            return var3 == 0 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 1 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 2 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 3 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 4 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 5 ? new ItemStack(Item.saddle) : (var3 == 6 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.goldenCarrot) : (var3 == 8 && var1.nextInt(3) == 0 ? new ItemStack(Item.appleGold) : (var3 == 9 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 10 ? new ItemStack(Item.bread) : (var3 == 11 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var3 == 12 ? new ItemStack(Item.silk, var1.nextInt(4) + 1) : (var3 == 13 ? new ItemStack(Item.bucketEmpty) : (var3 == 14 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var3 == 15 ? new ItemStack(Item.dyePowder, 1, 3) : (var3 == 16 ? new ItemStack(Item.diamond) : null))))))))))))))));
        }
        else if (this.chestID == 1)
        {
            var3 = var1.nextInt(16);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 ? new ItemStack(Item.diamond, var1.nextInt(4) + 1) : (var3 == 3 ? new ItemStack(Item.pumpkinPie, var1.nextInt(4) + 1) : (var3 == 4 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 5 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 8 ? new ItemStack(Item.saddle) : (var3 == 9 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 10 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 11 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 12 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 13 ? new ItemStack(Block.sapling, 1, 3) : (var3 == 14 ? new ItemStack(Item.diamond) : (var3 == 15 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : null)))))))))))))));
        }
        else if (this.chestID == 2)
        {
            var3 = var1.nextInt(16);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 3 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 4 ? new ItemStack(Item.saddle) : (var3 == 5 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 8 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 9 ? new ItemStack(Item.diamond) : (var3 == 10 ? new ItemStack(Item.bucketEmpty) : (var3 == 11 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var3 == 12 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var3 == 13 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var3 == 14 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 15 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : null)))))))))))))));
        }
        else if (this.chestID == 3)
        {
            var3 = var1.nextInt(19);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 ? new ItemStack(Item.diamond, var1.nextInt(4) + 1) : (var3 == 3 ? new ItemStack(Item.pumpkinPie, var1.nextInt(4) + 1) : (var3 == 4 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 5 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 8 ? new ItemStack(Item.saddle) : (var3 == 9 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 10 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 11 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 12 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 13 ? new ItemStack(Block.sapling, 1, var1.nextInt(3) + 1) : (var3 == 14 ? new ItemStack(Item.diamond) : (var3 != 15 && var3 != 16 && var3 != 17 ? (var3 == 18 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : null) : new ItemStack(Item.seeds, var1.nextInt(12) + 1))))))))))))))));
        }
        else if (this.chestID == 4)
        {
            var3 = var1.nextInt(22);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 ? new ItemStack(Item.diamond, var1.nextInt(4) + 1) : (var3 == 3 ? new ItemStack(Item.pumpkinPie, var1.nextInt(4) + 1) : (var3 == 4 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 5 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 8 ? new ItemStack(Item.saddle) : (var3 == 9 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 10 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 11 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 12 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 13 ? new ItemStack(Block.sapling, 1, var1.nextInt(3) + 1) : (var3 == 14 ? new ItemStack(Item.diamond) : (var3 != 15 && var3 != 16 && var3 != 17 ? (var3 == 18 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : (var3 == 19 ? new ItemStack(Block.cactus, var1.nextInt(4) + 1) : (var3 == 20 ? new ItemStack(Item.reed, var1.nextInt(4) + 1) : (var3 == 21 ? new ItemStack(Block.blockSnow, var1.nextInt(12) + 1) : null)))) : new ItemStack(Item.seeds, var1.nextInt(12) + 1))))))))))))))));
        }
        else if (this.chestID == 5)
        {
            var3 = var1.nextInt(23);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 ? new ItemStack(Item.diamond, var1.nextInt(4) + 1) : (var3 == 3 ? new ItemStack(Item.pumpkinPie, var1.nextInt(4) + 1) : (var3 == 4 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 5 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 8 ? new ItemStack(Item.saddle) : (var3 == 9 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 10 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 11 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 12 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 13 ? new ItemStack(Block.sapling, 1, var1.nextInt(3) + 1) : (var3 == 14 ? new ItemStack(Item.diamond) : (var3 != 15 && var3 != 16 && var3 != 17 ? (var3 == 18 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : (var3 == 19 ? new ItemStack(Block.cactus, var1.nextInt(4) + 1) : (var3 == 20 ? new ItemStack(Item.reed, var1.nextInt(4) + 1) : (var3 == 21 ? new ItemStack(Item.brick, var1.nextInt(63) + 1) : (var3 == 22 ? new ItemStack(Block.blockSnow, var1.nextInt(12) + 1) : null))))) : new ItemStack(Item.seeds, var1.nextInt(12) + 1))))))))))))))));
        }
        else if (this.chestID == 6)
        {
            var3 = var1.nextInt(23);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 ? new ItemStack(Item.diamond, var1.nextInt(4) + 1) : (var3 == 3 ? new ItemStack(Item.pumpkinPie, var1.nextInt(4) + 1) : (var3 == 4 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 5 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 8 ? new ItemStack(Item.saddle) : (var3 == 9 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 10 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 11 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 12 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 13 ? new ItemStack(Block.sapling, 1, var1.nextInt(3) + 1) : (var3 == 14 ? new ItemStack(Item.diamond) : (var3 != 15 && var3 != 16 && var3 != 17 ? (var3 == 18 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : (var3 == 19 ? new ItemStack(Block.cactus, var1.nextInt(4) + 1) : (var3 == 20 ? new ItemStack(Item.reed, var1.nextInt(4) + 1) : (var3 == 21 ? new ItemStack(Item.brick, var1.nextInt(63) + 1) : (var3 == 22 ? new ItemStack(Block.blockSnow, var1.nextInt(12) + 1) : null))))) : new ItemStack(Item.seeds, var1.nextInt(12) + 1))))))))))))))));
        }
        else if (this.chestID == 7)
        {
            var3 = var1.nextInt(18);
            return var3 == 0 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 1 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 2 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 3 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 4 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 5 ? new ItemStack(Item.saddle) : (var3 == 6 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.goldenCarrot) : (var3 == 8 && var1.nextInt(3) == 0 ? new ItemStack(Item.appleGold) : (var3 == 9 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 10 ? new ItemStack(Item.bread) : (var3 == 11 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var3 == 12 ? new ItemStack(Item.silk, var1.nextInt(4) + 1) : (var3 == 13 ? new ItemStack(Item.bucketEmpty) : (var3 == 14 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var3 == 15 ? new ItemStack(Item.dyePowder, 1, 3) : (var3 == 16 ? new ItemStack(Item.diamond) : (var3 == 17 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : null)))))))))))))))));
        }
        else if (this.chestID == 8)
        {
            var3 = var1.nextInt(19);
            return var3 == 0 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 1 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 2 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 3 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 4 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 5 ? new ItemStack(Item.saddle) : (var3 == 6 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.goldenCarrot) : (var3 == 8 && var1.nextInt(3) == 0 ? new ItemStack(Item.appleGold) : (var3 == 9 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 10 ? new ItemStack(Item.bread) : (var3 == 11 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var3 == 12 ? new ItemStack(Item.silk, var1.nextInt(4) + 1) : (var3 == 13 ? new ItemStack(Item.bucketEmpty) : (var3 == 14 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var3 == 15 ? new ItemStack(Item.dyePowder, 1, 3) : (var3 == 16 ? new ItemStack(Item.diamond) : (var3 == 17 && var1.nextInt(3) == 0 ? new ItemStack(Item.monsterPlacer, 1, 95) : (var3 == 18 && var1.nextInt(3) == 0 ? new ItemStack(Item.monsterPlacer, 1, 98) : null))))))))))))))))));
        }
        else if (this.chestID == 9)
        {
            return var2 == 0 ? new ItemStack(Item.pumpkinPie, var1.nextInt(2) + 1) : (var2 == 1 ? new ItemStack(Item.ingotIron, var1.nextInt(2) + 1) : (var2 == 2 ? new ItemStack(Block.cactus, var1.nextInt(4) + 1) : (var2 == 3 ? new ItemStack(Item.reed, var1.nextInt(4) + 1) : (var2 == 4 ? new ItemStack(Item.seeds, 12) : (var2 == 5 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var2 == 6 ? new ItemStack(Item.monsterPlacer, 2, 93) : (var2 == 7 ? new ItemStack(Item.monsterPlacer, 2, 91) : null)))))));
        }
        else if (this.chestID == 10)
        {
            return var2 == 0 ? new ItemStack(Item.bread, var1.nextInt(2) + 1) : (var2 == 1 ? new ItemStack(Block.fenceIron) : (var2 == 2 ? new ItemStack(Block.blockSnow, var1.nextInt(12) + 1) : (var2 == 3 ? new ItemStack(Block.mycelium) : (var2 == 4 ? new ItemStack(Item.monsterPlacer, 2, 92) : (var2 == 5 ? new ItemStack(Item.monsterPlacer, 2, 90) : (var2 == 6 ? new ItemStack(Item.monsterPlacer, 2, 120) : null))))));
        }
        else if (this.chestID == 11)
        {
            var3 = var1.nextInt(15);
            return var3 == 0 ? new ItemStack(Block.cactus, var1.nextInt(4) + 1) : (var3 == 1 ? new ItemStack(Item.reed, var1.nextInt(4) + 1) : (var3 == 2 ? new ItemStack(Block.sapling, 1, var1.nextInt(3) + 1) : (var3 == 3 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 4 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 5 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 8 ? new ItemStack(Item.pumpkinPie, var1.nextInt(4) + 1) : (var3 == 9 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 10 ? new ItemStack(Item.bread) : (var3 == 11 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var3 == 12 ? new ItemStack(Item.silk, var1.nextInt(4) + 1) : (var3 == 13 ? new ItemStack(Item.bucketEmpty) : (var3 == 14 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var3 == 15 ? new ItemStack(Item.saddle) : null)))))))))))))));
        }
        else if (this.chestID == 12)
        {
            var3 = var1.nextInt(16);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 ? new ItemStack(Item.diamond, var1.nextInt(4) + 1) : (var3 == 3 ? new ItemStack(Item.pumpkinPie, var1.nextInt(4) + 1) : (var3 == 4 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 5 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 8 ? new ItemStack(Item.saddle) : (var3 == 9 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 10 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 11 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 12 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 13 ? new ItemStack(Block.sapling, 1, 3) : (var3 == 14 ? new ItemStack(Item.diamond) : (var3 == 15 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : null)))))))))))))));
        }
        else if (this.chestID == 13)
        {
            var3 = var1.nextInt(16);
            return var3 == 0 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 1 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 2 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 3 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 4 ? new ItemStack(Item.saddle) : (var3 == 5 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 8 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 9 ? new ItemStack(Item.diamond) : (var3 == 10 ? new ItemStack(Item.bucketEmpty) : (var3 == 11 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var3 == 12 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var3 == 13 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var3 == 14 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 15 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : null)))))))))))))));
        }
        else if (this.chestID == 17)
        {
            var3 = var1.nextInt(17);
            return var3 == 0 && var1.nextInt(3) == 0 ? new ItemStack(Item.helmetChain) : (var3 == 1 && var1.nextInt(3) == 0 ? new ItemStack(Item.plateChain) : (var3 == 2 && var1.nextInt(3) == 0 ? new ItemStack(Item.legsChain) : (var3 == 3 && var1.nextInt(3) == 0 ? new ItemStack(Item.bootsChain) : (var3 == 4 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 5 ? new ItemStack(Item.saddle) : (var3 == 6 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var3 == 7 && var1.nextInt(3) == 0 ? new ItemStack(Item.goldenCarrot) : (var3 == 8 && var1.nextInt(3) == 0 ? new ItemStack(Item.appleGold) : (var3 == 9 ? new ItemStack(Item.ingotIron, var1.nextInt(4) + 1) : (var3 == 10 ? new ItemStack(Item.bread) : (var3 == 11 ? new ItemStack(Item.wheat, var1.nextInt(4) + 1) : (var3 == 12 ? new ItemStack(Item.silk, var1.nextInt(4) + 1) : (var3 == 13 ? new ItemStack(Item.bucketEmpty) : (var3 == 14 ? new ItemStack(Item.redstone, var1.nextInt(4) + 1) : (var3 == 15 ? new ItemStack(Item.dyePowder, 1, 3) : (var3 == 16 ? new ItemStack(Item.diamond) : null))))))))))))))));
        }
        else if (this.chestID == 18)
        {
            var3 = var1.nextInt(17);
            return var3 == 1 ? new ItemStack(Item.brick, var1.nextInt(63) + 1) : (var3 == 2 ? new ItemStack(Block.blockSnow, var1.nextInt(12) + 1) : (var3 == 3 ? new ItemStack(Block.waterlily, var1.nextInt(4) + 1) : (var3 == 4 ? new ItemStack(Item.diamond) : (var3 == 5 && var1.nextInt(3) == 0 ? new ItemStack(Block.mycelium) : (var3 == 6 && var1.nextInt(3) == 0 ? new ItemStack(Item.itemsList[Item.record13.itemID + var1.nextInt(10)]) : (var3 == 7 ? new ItemStack(Block.vine, var1.nextInt(4) + 1) : (var3 == 8 ? new ItemStack(Block.sapling, 1,  3) : (var3 == 9 ? new ItemStack(Block.brick, var1.nextInt(30) + 30) : (var3 == 10 ? new ItemStack(Item.diamond, var1.nextInt(4) + 1) : (var3 == 11 ? new ItemStack(Item.gunpowder, var1.nextInt(4) + 1) : (var3 == 12 && var1.nextInt(3) == 0 ? new ItemStack(Item.goldenCarrot) : (var3 == 13 && var1.nextInt(3) == 0 ? new ItemStack(Item.appleGold) : null))))))))))));
        }
        else
        {
            return new ItemStack(Item.saddle);
        }
    }

    private String pickMobSpawner(Random var1)
    {
        int var2 = var1.nextInt(5);
        return var2 == 0 ? "Skeleton" : (var2 == 1 ? "Zombie" : (var2 == 2 ? "Zombie" : (var2 == 3 ? "Spider" : (var2 == 4 ? "Creeper" : ""))));
    }
}
