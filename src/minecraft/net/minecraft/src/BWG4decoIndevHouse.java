package net.minecraft.src;

import java.util.Random;

public class BWG4decoIndevHouse extends WorldGenerator
{
    private int typeID;

    public BWG4decoIndevHouse(int var1)
    {
        this.typeID = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        int var6;
        int var7;

        for (var6 = -3 + var3; var6 < 4 + var3; ++var6)
        {
            for (var7 = -3 + var5; var7 < 4 + var5; ++var7)
            {
                this.setBlock(var1, var6, var4 - 1, var7, Block.stone.blockID);
            }
        }

        for (var6 = -3 + var3; var6 < 4 + var3; ++var6)
        {
            for (var7 = -3 + var5; var7 < 4 + var5; ++var7)
            {
                this.setBlock(var1, var6, var4 - 2, var7, Block.stone.blockID);
            }
        }

        for (var6 = -3 + var3; var6 < 4 + var3; ++var6)
        {
            for (var7 = -3 + var5; var7 < 4 + var5; ++var7)
            {
                this.setBlock(var1, var6, var4 - 3, var7, Block.stone.blockID);
            }
        }

        int var8;

        if (this.typeID == 2)
        {
            for (var6 = -3 + var3; var6 < 4 + var3; ++var6)
            {
                for (var7 = 0 + var4; var7 < 4 + var4; ++var7)
                {
                    for (var8 = -3 + var5; var8 < 4 + var5; ++var8)
                    {
                        this.setBlock(var1, var6, var7, var8, Block.cobblestoneMossy.blockID);
                    }
                }
            }
        }
        else
        {
            for (var6 = -3 + var3; var6 < 4 + var3; ++var6)
            {
                for (var7 = 0 + var4; var7 < 4 + var4; ++var7)
                {
                    for (var8 = -3 + var5; var8 < 4 + var5; ++var8)
                    {
                        this.setBlock(var1, var6, var7, var8, Block.planks.blockID);
                    }
                }
            }
        }

        for (var6 = -2 + var3; var6 < 3 + var3; ++var6)
        {
            for (var7 = 0 + var4; var7 < 3 + var4; ++var7)
            {
                for (var8 = -2 + var5; var8 < 3 + var5; ++var8)
                {
                    this.setBlock(var1, var6, var7, var8, 0);
                }
            }
        }

        if ((!var1.isAirBlock(var3 - 4, var4 + 1, var5) || var1.isAirBlock(var3 - 4, var4 - 1, var5)) && var1.isAirBlock(var3 - 4, var4 - 2, var5))
        {
            if ((!var1.isAirBlock(var3 + 4, var4 + 1, var5) || var1.isAirBlock(var3 + 4, var4 - 1, var5)) && var1.isAirBlock(var3 + 4, var4 - 2, var5))
            {
                if ((!var1.isAirBlock(var3, var4 + 1, var5 - 4) || var1.isAirBlock(var3, var4 - 1, var5 - 4)) && var1.isAirBlock(var3, var4 - 2, var5 - 4))
                {
                    if ((!var1.isAirBlock(var3, var4 + 1, var5 + 4) || var1.isAirBlock(var3, var4 - 1, var5 + 4)) && var1.isAirBlock(var3, var4 - 2, var5 + 4))
                    {
                        this.setBlock(var1, var3 - 3, var4, var5, 0);
                        this.setBlock(var1, var3 - 3, var4 + 1, var5, 0);
                        this.setBlock(var1, var3 - 4, var4, var5, 0);
                        this.setBlock(var1, var3 - 4, var4 + 1, var5, 0);
                        var1.setBlock(var3, var4 + 1, var5 + 2, Block.torchWood.blockID);
                        var1.setBlock(var3, var4 + 1, var5 - 2, Block.torchWood.blockID);
                    }
                    else
                    {
                        this.setBlock(var1, var3, var4, var5 + 3, 0);
                        this.setBlock(var1, var3, var4 + 1, var5 + 3, 0);
                        this.setBlock(var1, var3, var4, var5 + 4, 0);
                        this.setBlock(var1, var3, var4 + 1, var5 + 4, 0);
                        var1.setBlock(var3 + 2, var4 + 1, var5, Block.torchWood.blockID);
                        var1.setBlock(var3 - 2, var4 + 1, var5, Block.torchWood.blockID);
                    }
                }
                else
                {
                    this.setBlock(var1, var3, var4, var5 - 3, 0);
                    this.setBlock(var1, var3, var4 + 1, var5 - 3, 0);
                    this.setBlock(var1, var3, var4, var5 - 4, 0);
                    this.setBlock(var1, var3, var4 + 1, var5 - 4, 0);
                    var1.setBlock(var3 + 2, var4 + 1, var5, Block.torchWood.blockID);
                    var1.setBlock(var3 - 2, var4 + 1, var5, Block.torchWood.blockID);
                }
            }
            else
            {
                this.setBlock(var1, var3 + 3, var4, var5, 0);
                this.setBlock(var1, var3 + 3, var4 + 1, var5, 0);
                this.setBlock(var1, var3 + 4, var4, var5, 0);
                this.setBlock(var1, var3 + 4, var4 + 1, var5, 0);
                var1.setBlock(var3, var4 + 1, var5 + 2, Block.torchWood.blockID);
                var1.setBlock(var3, var4 + 1, var5 - 2, Block.torchWood.blockID);
            }
        }
        else
        {
            this.setBlock(var1, var3 - 3, var4, var5, 0);
            this.setBlock(var1, var3 - 3, var4 + 1, var5, 0);
            this.setBlock(var1, var3 - 4, var4, var5, 0);
            this.setBlock(var1, var3 - 4, var4 + 1, var5, 0);
            var1.setBlock(var3, var4 + 1, var5 + 2, Block.torchWood.blockID);
            var1.setBlock(var3, var4 + 1, var5 - 2, Block.torchWood.blockID);
        }

        return true;
    }
}
