package net.minecraft.src;

import java.util.Random;

public class BWG4decoDefault extends WorldGenerator
{
    private int objectID;

    public BWG4decoDefault(int var1)
    {
        this.objectID = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        if (this.objectID != 1)
        {
            return true;
        }
        else
        {
            int var6;

            for (boolean var7 = false; ((var6 = var1.getBlockId(var3, var4, var5)) == 0 || var6 == Block.leaves.blockID) && var4 > 0; --var4)
            {
                ;
            }

            for (int var12 = 0; var12 < 128; ++var12)
            {
                int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
                int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
                int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);
                int var11 = var1.getBlockId(var8, var9 - 1, var10);

                if (var1.isAirBlock(var8, var9, var10) && var11 == Block.sand.blockID && var9 > 66)
                {
                    if (var2.nextInt(8) != 0)
                    {
                        var1.setBlock(var8, var9, var10, Block.tallGrass.blockID, 1, 0);
                    }
                    else
                    {
                        var1.setBlock(var8, var9, var10, Block.leaves.blockID, 4, 0);
                    }

                    var1.setBlock(var8, var9 - 1, var10, Block.grass.blockID);
                }
            }

            return true;
        }
    }
}
