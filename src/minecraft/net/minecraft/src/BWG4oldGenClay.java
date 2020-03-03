package net.minecraft.src;

import java.util.Random;

public class BWG4oldGenClay extends WorldGenerator
{
    private int clayBlockId;
    private int numberOfBlocks;
    private int generatortype;

    public BWG4oldGenClay(int var1, int var2)
    {
        this.clayBlockId = Block.blockClay.blockID;
        this.numberOfBlocks = var1;
        this.generatortype = var2;
    }

    public boolean generate(World var1, Random var2, int var3, int var4, int var5)
    {
        float var6;
        double var7;
        double var9;
        double var11;
        double var13;
        double var15;
        double var17;
        int var19;
        double var20;
        double var22;
        double var24;
        double var26;
        double var28;
        double var30;
        int var32;
        int var33;
        int var34;

        if (this.generatortype != 0 && this.generatortype != 1)
        {
            if (var1.getBlockMaterial(var3, var4, var5) != Material.water)
            {
                return false;
            }
            else
            {
                var6 = var2.nextFloat() * (float)Math.PI;
                var7 = (double)((float)(var3 + 8) + MathHelper.sin(var6) * (float)this.numberOfBlocks / 8.0F);
                var9 = (double)((float)(var3 + 8) - MathHelper.sin(var6) * (float)this.numberOfBlocks / 8.0F);
                var11 = (double)((float)(var5 + 8) + MathHelper.cos(var6) * (float)this.numberOfBlocks / 8.0F);
                var13 = (double)((float)(var5 + 8) - MathHelper.cos(var6) * (float)this.numberOfBlocks / 8.0F);
                var15 = (double)(var4 + var2.nextInt(3) + 2);
                var17 = (double)(var4 + var2.nextInt(3) + 2);

                for (var19 = 0; var19 <= this.numberOfBlocks; ++var19)
                {
                    var20 = var7 + (var9 - var7) * (double)var19 / (double)this.numberOfBlocks;
                    var22 = var15 + (var17 - var15) * (double)var19 / (double)this.numberOfBlocks;
                    var24 = var11 + (var13 - var11) * (double)var19 / (double)this.numberOfBlocks;
                    var26 = var2.nextDouble() * (double)this.numberOfBlocks / 16.0D;
                    var28 = (double)(MathHelper.sin((float)var19 * (float)Math.PI / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
                    var30 = (double)(MathHelper.sin((float)var19 * (float)Math.PI / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
                    var32 = MathHelper.floor_double(var20 - var28 / 2.0D);
                    var33 = MathHelper.floor_double(var20 + var28 / 2.0D);
                    var34 = MathHelper.floor_double(var22 - var30 / 2.0D);
                    int var48 = MathHelper.floor_double(var22 + var30 / 2.0D);
                    int var36 = MathHelper.floor_double(var24 - var28 / 2.0D);
                    int var49 = MathHelper.floor_double(var24 + var28 / 2.0D);

                    for (int var38 = var32; var38 <= var33; ++var38)
                    {
                        for (int var50 = var34; var50 <= var48; ++var50)
                        {
                            for (int var40 = var36; var40 <= var49; ++var40)
                            {
                                double var51 = ((double)var38 + 0.5D - var20) / (var28 / 2.0D);
                                double var43 = ((double)var50 + 0.5D - var22) / (var30 / 2.0D);
                                double var45 = ((double)var40 + 0.5D - var24) / (var28 / 2.0D);

                                if (var51 * var51 + var43 * var43 + var45 * var45 < 1.0D)
                                {
                                    int var47 = var1.getBlockId(var38, var50, var40);

                                    if (var47 == Block.sand.blockID)
                                    {
                                        var1.setBlock(var38, var50, var40, this.clayBlockId);
                                    }
                                }
                            }
                        }
                    }
                }

                return true;
            }
        }
        else if (var1.getBlockMaterial(var3, var4, var5) != Material.water)
        {
            return false;
        }
        else
        {
            var6 = var2.nextFloat() * (float)Math.PI;
            var7 = (double)((float)(var3 + 8) + MathHelper.sin(var6) * (float)this.numberOfBlocks / 8.0F);
            var9 = (double)((float)(var3 + 8) - MathHelper.sin(var6) * (float)this.numberOfBlocks / 8.0F);
            var11 = (double)((float)(var5 + 8) + MathHelper.cos(var6) * (float)this.numberOfBlocks / 8.0F);
            var13 = (double)((float)(var5 + 8) - MathHelper.cos(var6) * (float)this.numberOfBlocks / 8.0F);
            var15 = (double)(var4 + var2.nextInt(3) + 2);
            var17 = (double)(var4 + var2.nextInt(3) + 2);

            for (var19 = 0; var19 <= this.numberOfBlocks; ++var19)
            {
                var20 = var7 + (var9 - var7) * (double)var19 / (double)this.numberOfBlocks;
                var22 = var15 + (var17 - var15) * (double)var19 / (double)this.numberOfBlocks;
                var24 = var11 + (var13 - var11) * (double)var19 / (double)this.numberOfBlocks;
                var26 = var2.nextDouble() * (double)this.numberOfBlocks / 16.0D;
                var28 = (double)(MathHelper.sin((float)var19 * (float)Math.PI / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
                var30 = (double)(MathHelper.sin((float)var19 * (float)Math.PI / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;

                for (var32 = (int)(var20 - var28 / 2.0D); var32 <= (int)(var20 + var28 / 2.0D); ++var32)
                {
                    for (var33 = (int)(var22 - var30 / 2.0D); var33 <= (int)(var22 + var30 / 2.0D); ++var33)
                    {
                        for (var34 = (int)(var24 - var28 / 2.0D); var34 <= (int)(var24 + var28 / 2.0D); ++var34)
                        {
                            double var35 = ((double)var32 + 0.5D - var20) / (var28 / 2.0D);
                            double var37 = ((double)var33 + 0.5D - var22) / (var30 / 2.0D);
                            double var39 = ((double)var34 + 0.5D - var24) / (var28 / 2.0D);

                            if (var35 * var35 + var37 * var37 + var39 * var39 < 1.0D)
                            {
                                int var41 = var1.getBlockId(var32, var33, var34);

                                if (var41 == Block.sand.blockID)
                                {
                                    var1.setBlock(var32, var33, var34, this.clayBlockId);
                                }
                            }
                        }
                    }
                }
            }

            return true;
        }
    }
}
