package net.minecraft.src;

import java.util.Random;

public class BWG4decoPumpkin extends WorldGenerator
{
    private int whatblock;

    public BWG4decoPumpkin(int var1)
    {
        this.whatblock = var1;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        for (int var6 = 0; var6 < 64; ++var6)
        {
            int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);

            if (var1.isAirBlock(var7, var8, var9) && var1.getBlockId(var7, var8 - 1, var9) == Block.grass.blockID && Block.pumpkin.canPlaceBlockAt(var1, var7, var8, var9))
            {
                if (this.whatblock == 0)
                {
                    var1.setBlock(var7, var8, var9, Block.pumpkin.blockID, var2.nextInt(4), 0);
                }
                else
                {
                    var1.setBlock(var7, var8, var9, Block.melon.blockID, 0, 0);
                }
            }
        }

        return true;
    }
}
