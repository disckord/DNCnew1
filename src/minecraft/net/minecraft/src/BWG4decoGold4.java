package net.minecraft.src;

import java.util.Random;

public class BWG4decoGold4 extends WorldGenerator
{
    private int objectID;
    private int input1;

    public BWG4decoGold4(int var1)
    {
        this.objectID = var1;
    }

    public BWG4decoGold4(int var1, int var2)
    {
        this.objectID = var1;
        this.input1 = var2;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6;
        int var7;
        int var8;

        if (this.objectID == 1)
        {
            var6 = var1.getBlockId(var3, var4 - 1, var5);

            if (var6 != Block.grass.blockID)
            {
                return false;
            }

            if (var1.getBlockMaterial(var3 - 1, var4, var5).isSolid())
            {
                return false;
            }

            if (var1.getBlockMaterial(var3 + 1, var4, var5).isSolid())
            {
                return false;
            }

            if (var1.getBlockMaterial(var3, var4, var5 - 1).isSolid())
            {
                return false;
            }

            if (var1.getBlockMaterial(var3, var4, var5 + 1).isSolid())
            {
                return false;
            }

            var1.setBlock(var3, var4 - 1, var5, Block.sand.blockID);
            var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

            for (var8 = 0; var8 < var7; ++var8)
            {
                var1.setBlock(var3, var4 + var8, var5, Block.cactus.blockID);
            }
        }
        else if (this.objectID == 2)
        {
            var6 = var1.getBlockId(var3, var4 - 1, var5);

            if (var6 != Block.grass.blockID)
            {
                return false;
            }

            var7 = 4 + var2.nextInt(3);

            for (var8 = 0; var8 < var7; ++var8)
            {
                var1.setBlock(var3, var4 + var8, var5, Block.wood.blockID);
            }

            if (var2.nextInt(4) == 0)
            {
                var1.setBlock(var3 + 0, var4 + var7 + 1, var5 + 1, Block.wood.blockID);
                var1.setBlock(var3 + 1, var4 + var7 + 2, var5 + 2, Block.wood.blockID);
                this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 2, var5 + 2, 3);
                this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 3, var5 + 2, 2);
            }

            if (var2.nextInt(4) == 0)
            {
                var1.setBlock(var3 + 1, var4 + var7 + 0, var5 + 0, Block.wood.blockID);
                var1.setBlock(var3 + 2, var4 + var7 + 1, var5 + 0, Block.wood.blockID);
                var1.setBlock(var3 + 3, var4 + var7 + 2, var5 - 1, Block.wood.blockID);
                this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 3, var5 - 1, 3);
                this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 4, var5 - 1, 2);
            }

            if (var2.nextInt(4) == 0)
            {
                var1.setBlock(var3 - 1, var4 + var7 + 0, var5 + 0, Block.wood.blockID);
                var1.setBlock(var3 - 2, var4 + var7 + 1, var5 + 0, Block.wood.blockID);
                var1.setBlock(var3 - 3, var4 + var7 + 2, var5 - 1, Block.wood.blockID);
                var1.setBlock(var3 - 4, var4 + var7 + 3, var5 - 2, Block.wood.blockID);
                this.createSavannaLeaves(var1, var2, var3 - 4, var4 + var7 + 4, var5 - 2, 3);
                this.createSavannaLeaves(var1, var2, var3 - 4, var4 + var7 + 5, var5 - 2, 2);
            }

            if (var2.nextInt(4) == 0)
            {
                var1.setBlock(var3 + 0, var4 + var7 + 0, var5 - 1, Block.wood.blockID);
                var1.setBlock(var3 + 1, var4 + var7 + 1, var5 - 2, Block.wood.blockID);
                var1.setBlock(var3 + 2, var4 + var7 + 2, var5 - 2, Block.wood.blockID);
                var1.setBlock(var3 + 3, var4 + var7 + 3, var5 - 2, Block.wood.blockID);
                this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 3, var5 - 2, 3);
                this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 4, var5 - 2, 2);
            }

            if (var2.nextInt(4) == 0)
            {
                var1.setBlock(var3 + 0, var4 + var7 + 0, var5 - 1, Block.wood.blockID);
                var1.setBlock(var3 + 0, var4 + var7 + 0, var5 - 2, Block.wood.blockID);
                var1.setBlock(var3 + 1, var4 + var7 + 1, var5 - 3, Block.wood.blockID);
                this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 1, var5 - 3, 3);
                this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 2, var5 - 3, 2);
            }

            var1.setBlock(var3 - 0, var4 + var7 + 0, var5 + 0, Block.wood.blockID);
            var1.setBlock(var3 - 0, var4 + var7 + 1, var5 + 0, Block.wood.blockID);
            var1.setBlock(var3 - 0, var4 + var7 + 2, var5 - 0, Block.wood.blockID);
            this.createSavannaLeaves(var1, var2, var3 + 0, var4 + var7 + 3, var5 - 0, 3);
            this.createSavannaLeaves(var1, var2, var3 + 0, var4 + var7 + 4, var5 - 0, 2);
        }

        return true;
    }

    private void createSavannaLeaves(World var1, Random var2, int var3, int var4, int var5, int var6)
    {
        for (int var7 = -var6 + var3; var7 < var6 + 1 + var3; ++var7)
        {
            for (int var8 = -var6 + var5; var8 < var6 + 1 + var5; ++var8)
            {
                int var9 = var1.getBlockId(var7, var4, var8);

                if (var9 == 0 && (var7 != -var6 + var3 || var8 != -var6 + var5) && (var7 != -var6 + var3 || var8 != var6 + var5) && (var7 != var6 + var3 || var8 != -var6 + var5) && (var7 != var6 + var3 || var8 != var6 + var5))
                {
                    var1.setBlock(var7, var4, var8, Block.leaves.blockID);
                }
            }
        }

        if (var6 == 3)
        {
            var1.setBlock(var3, var4, var5, Block.wood.blockID);
        }
    }

    private ItemStack getChestList(int var1, Random var2, World var3)
    {
        return null;
    }
}
