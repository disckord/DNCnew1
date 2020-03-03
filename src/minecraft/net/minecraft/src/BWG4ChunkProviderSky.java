package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BWG4ChunkProviderSky implements IChunkProvider
{
    private Random rand;
    private BWG4NoiseOctavesBeta field_912_k;
    private BWG4NoiseOctavesBeta field_911_l;
    private BWG4NoiseOctavesBeta field_910_m;
    private BWG4NoiseOctavesBeta field_909_n;
    private BWG4NoiseOctavesBeta field_908_o;
    public BWG4NoiseOctavesBeta field_922_a;
    public BWG4NoiseOctavesBeta field_921_b;
    public BWG4NoiseOctavesBeta mobSpawnerNoise;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] field_4180_q;
    private double[] sandNoise = new double[256];
    private double[] gravelNoise = new double[256];
    private double[] stoneNoise = new double[256];
    private MapGenBase field_902_u = new BWG4oldMapGenCaves();
    private BiomeGenBase[] biomesForGeneration;
    private int worldtype;
    double[] field_4185_d;
    double[] field_4184_e;
    double[] field_4183_f;
    double[] field_4182_g;
    double[] field_4181_h;
    int[][] field_914_i = new int[32][32];
    private double[] generatedTemperatures;
    private boolean nether;

    public BWG4ChunkProviderSky(World var1, long var2, boolean var4, int var5)
    {
        this.worldObj = var1;
        this.rand = new Random(var2);
        this.mapFeaturesEnabled = var4;
        this.worldtype = var5;

        if (var5 == 4)
        {
            this.nether = true;
        }

        this.field_912_k = new BWG4NoiseOctavesBeta(this.rand, 16);
        this.field_911_l = new BWG4NoiseOctavesBeta(this.rand, 16);
        this.field_910_m = new BWG4NoiseOctavesBeta(this.rand, 8);
        this.field_909_n = new BWG4NoiseOctavesBeta(this.rand, 4);
        this.field_908_o = new BWG4NoiseOctavesBeta(this.rand, 4);
        this.field_922_a = new BWG4NoiseOctavesBeta(this.rand, 10);
        this.field_921_b = new BWG4NoiseOctavesBeta(this.rand, 16);
        this.mobSpawnerNoise = new BWG4NoiseOctavesBeta(this.rand, 8);
    }

    public void generateTerrain(int var1, int var2, byte[] var3, BiomeGenBase[] var4, double[] var5)
    {
        byte var6 = 2;
        int var7 = var6 + 1;
        byte var8 = 33;
        int var9 = var6 + 1;
        this.field_4180_q = this.func_4061_a(this.field_4180_q, var1 * var6, 0, var2 * var6, var7, var8, var9);

        for (int var10 = 0; var10 < var6; ++var10)
        {
            for (int var11 = 0; var11 < var6; ++var11)
            {
                for (int var12 = 0; var12 < 32; ++var12)
                {
                    double var13 = 0.25D;
                    double var15 = this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var17 = this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
                    double var19 = this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
                    double var21 = this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
                    double var23 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
                    double var25 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
                    double var27 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
                    double var29 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

                    for (int var31 = 0; var31 < 4; ++var31)
                    {
                        double var32 = 0.125D;
                        double var34 = var15;
                        double var36 = var17;
                        double var38 = (var19 - var15) * var32;
                        double var40 = (var21 - var17) * var32;

                        for (int var42 = 0; var42 < 8; ++var42)
                        {
                            int var43 = var42 + var10 * 8 << 11 | 0 + var11 * 8 << 7 | var12 * 4 + var31;
                            short var44 = 128;
                            double var45 = 0.125D;
                            double var47 = var34;
                            double var49 = (var36 - var34) * var45;

                            for (int var51 = 0; var51 < 8; ++var51)
                            {
                                int var52 = 0;

                                if (var47 > 0.0D)
                                {
                                    if (this.nether)
                                    {
                                        var52 = Block.netherrack.blockID;
                                    }
                                    else
                                    {
                                        var52 = Block.stone.blockID;
                                    }
                                }

                                var3[var43] = (byte)var52;
                                var43 += var44;
                                var47 += var49;
                            }

                            var34 += var38;
                            var36 += var40;
                        }

                        var15 += var23;
                        var17 += var25;
                        var19 += var27;
                        var21 += var29;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int var1, int var2, byte[] var3, BiomeGenBase[] var4)
    {
        byte var5 = 64;
        double var6 = 0.03125D;
        this.sandNoise = this.field_909_n.generateNoiseOctaves(this.sandNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6, var6, 1.0D);
        this.gravelNoise = this.field_909_n.generateNoiseOctaves(this.gravelNoise, (double)(var1 * 16), 109.0134D, (double)(var2 * 16), 16, 1, 16, var6, 1.0D, var6);
        this.stoneNoise = this.field_908_o.generateNoiseOctaves(this.stoneNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

        for (int var8 = 0; var8 < 16; ++var8)
        {
            for (int var9 = 0; var9 < 16; ++var9)
            {
                BiomeGenBase var10 = var4[var8 + var9 * 16];
                boolean var11 = this.sandNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 0.0D;
                boolean var12 = this.gravelNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 3.0D;
                int var13 = (int)(this.stoneNoise[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
                int var14 = -1;
                byte var15 = var10.topBlock;
                byte var16 = var10.fillerBlock;

                for (int var17 = 127; var17 >= 0; --var17)
                {
                    int var18 = (var9 * 16 + var8) * 128 + var17;
                    byte var19 = var3[var18];

                    if (var19 == 0)
                    {
                        var14 = -1;
                    }
                    else if (var19 == Block.stone.blockID)
                    {
                        if (var14 == -1)
                        {
                            if (var13 <= 0)
                            {
                                var15 = var10.topBlock;
                                var16 = var10.fillerBlock;
                            }
                            else if (var17 >= var5 - 4 && var17 <= var5 + 1)
                            {
                                var15 = var10.topBlock;
                                var16 = var10.fillerBlock;
                            }

                            var3[var18] = var15;
                            var14 = var13;
                        }
                        else if (var14 > 0)
                        {
                            --var14;
                            var3[var18] = var16;

                            if (var14 == 0 && var16 == Block.sand.blockID)
                            {
                                var14 = this.rand.nextInt(4);
                                var16 = (byte)Block.sandStone.blockID;
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * loads or generates the chunk at the chunk location specified
     */
    public Chunk loadChunk(int var1, int var2)
    {
        return this.provideChunk(var1, var2);
    }

    /**
     * Will return back a chunk, if it doesn't exist and its not a MP client it will generates all the blocks for the
     * specified chunk from the map seed and chunk seed
     */
    public Chunk provideChunk(int var1, int var2)
    {
        this.rand.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
        byte[] var3 = new byte[32768];
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
        double[] var4 = this.worldObj.getWorldChunkManager().temperature;
        this.generateTerrain(var1, var2, var3, this.biomesForGeneration, var4);
        this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
        this.field_902_u.generate(this, this.worldObj, var1, var2, var3);
        Chunk var5 = new Chunk(this.worldObj, var3, var1, var2);
        byte[] var6 = var5.getBiomeArray();

        for (int var7 = 0; var7 < var6.length; ++var7)
        {
            var6[var7] = (byte)this.biomesForGeneration[var7].biomeID;
        }

        var5.generateSkylightMap();
        return var5;
    }

    private double[] func_4061_a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7)
    {
        if (var1 == null)
        {
            var1 = new double[var5 * var6 * var7];
        }

        double var8 = 684.412D;
        double var10 = 684.412D;
        double[] var12 = this.worldObj.getWorldChunkManager().temperature;
        double[] var13 = this.worldObj.getWorldChunkManager().humidity;
        this.field_4182_g = this.field_922_a.generateNoiseOctaves(this.field_4182_g, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.field_4181_h = this.field_921_b.generateNoiseOctaves(this.field_4181_h, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        var8 *= 2.0D;
        this.field_4185_d = this.field_910_m.generateNoiseOctaves(this.field_4185_d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
        this.field_4184_e = this.field_912_k.generateNoiseOctaves(this.field_4184_e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
        this.field_4183_f = this.field_911_l.generateNoiseOctaves(this.field_4183_f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
        int var14 = 0;
        int var15 = 0;
        int var16 = 16 / var5;

        for (int var17 = 0; var17 < var5; ++var17)
        {
            int var18 = var17 * var16 + var16 / 2;

            for (int var19 = 0; var19 < var7; ++var19)
            {
                int var20 = var19 * var16 + var16 / 2;
                double var21;
                double var23;

                if (!this.nether)
                {
                    var23 = var12[var18 * 16 + var20];
                    var21 = var13[var18 * 16 + var20] * var23;
                }
                else
                {
                    var21 = 0.5D;
                }

                var23 = 1.0D - var21;
                var23 *= var23;
                var23 *= var23;
                var23 = 1.0D - var23;
                double var25 = (this.field_4182_g[var15] + 256.0D) / 512.0D;
                var25 *= var23;

                if (var25 > 1.0D)
                {
                    var25 = 1.0D;
                }

                double var27 = this.field_4181_h[var15] / 8000.0D;

                if (var27 < 0.0D)
                {
                    var27 = -var27 * 0.3D;
                }

                var27 = var27 * 3.0D - 2.0D;

                if (var27 > 1.0D)
                {
                    var27 = 1.0D;
                }

                var27 /= 8.0D;
                var27 = 0.0D;

                if (var25 < 0.0D)
                {
                    var25 = 0.0D;
                }

                var25 += 0.5D;
                var27 = var27 * (double)var6 / 16.0D;
                ++var15;
                double var29 = (double)var6 / 2.0D;

                for (int var31 = 0; var31 < var6; ++var31)
                {
                    double var32 = 0.0D;
                    double var34 = ((double)var31 - var29) * 8.0D / var25;

                    if (var34 < 0.0D)
                    {
                        var34 *= -1.0D;
                    }

                    double var36 = this.field_4184_e[var14] / 512.0D;
                    double var38 = this.field_4183_f[var14] / 512.0D;
                    double var40 = (this.field_4185_d[var14] / 10.0D + 1.0D) / 2.0D;

                    if (var40 < 0.0D)
                    {
                        var32 = var36;
                    }
                    else if (var40 > 1.0D)
                    {
                        var32 = var38;
                    }
                    else
                    {
                        var32 = var36 + (var38 - var36) * var40;
                    }

                    var32 -= 8.0D;
                    byte var42 = 32;
                    double var43;

                    if (var31 > var6 - var42)
                    {
                        var43 = (double)((float)(var31 - (var6 - var42)) / ((float)var42 - 1.0F));
                        var32 = var32 * (1.0D - var43) + -30.0D * var43;
                    }

                    var42 = 8;

                    if (var31 < var42)
                    {
                        var43 = (double)((float)(var42 - var31) / ((float)var42 - 1.0F));
                        var32 = var32 * (1.0D - var43) + -30.0D * var43;
                    }

                    var1[var14] = var32;
                    ++var14;
                }
            }
        }

        return var1;
    }

    /**
     * Checks to see if a chunk exists at x, y
     */
    public boolean chunkExists(int var1, int var2)
    {
        return true;
    }

    /**
     * Populates chunk with ores etc etc
     */
    public void populate(IChunkProvider var1, int var2, int var3)
    {
        int var4;
        int var5;
        BiomeGenBase var6;
        long var7;
        long var9;
        double var11;
        int var13;
        int var14;
        int var15;
        int var16;
        int var17;

        if (this.worldtype == 2)
        {
            BlockSand.fallInstantly = true;
            var4 = var2 * 16;
            var5 = var3 * 16;
            var6 = this.worldObj.getWorldChunkManager().getBiomeGenAt(var4 + 16, var5 + 16);
            this.rand.setSeed(this.worldObj.getSeed());
            var7 = this.rand.nextLong() / 2L * 2L + 1L;
            var9 = this.rand.nextLong() / 2L * 2L + 1L;
            this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.getSeed());
            var11 = 0.25D;

            if (this.rand.nextInt(4) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(128);
                var15 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4oldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
            }

            if (this.rand.nextInt(8) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(this.rand.nextInt(120) + 8);
                var15 = var5 + this.rand.nextInt(16) + 8;

                if (var14 < 64 || this.rand.nextInt(10) == 0)
                {
                    (new BWG4oldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
            }

            if (this.rand.nextInt(30) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(15);
                var15 = var5 + this.rand.nextInt(16) + 8;

                if (this.rand.nextInt(8) == 0)
                {
                    (new BWG4decoDungeons(12, false, false, true)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
                else
                {
                    (new BWG4decoDungeons(12, false, true, false)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
            }

            for (var13 = 0; var13 < 10; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(128);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenClay(32, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 20; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(128);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.dirt.blockID, 32, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 10; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(128);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.gravel.blockID, 32, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 20; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(128);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.oreCoal.blockID, 16, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 20; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(64);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.oreIron.blockID, 8, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 2; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(32);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.oreGold.blockID, 8, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 8; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(16);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.oreRedstone.blockID, 7, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 1; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(16);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.oreDiamond.blockID, 7, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            for (var13 = 0; var13 < 1; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16);
                var15 = this.rand.nextInt(16) + this.rand.nextInt(16);
                var16 = var5 + this.rand.nextInt(16);
                (new BWG4oldGenMinable(Block.oreLapis.blockID, 6, 2)).generate(this.worldObj, this.rand, var14, var15, var16);
            }

            var11 = 0.5D;
            var13 = (int)((this.mobSpawnerNoise.func_806_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.rand.nextDouble() * 4.0D + 4.0D) / 3.0D);
            var14 = 0;

            if (this.rand.nextInt(10) == 0)
            {
                ++var14;
            }

            if (var6 == BiomeGenBase.BETAforest)
            {
                var14 += var13 + 5;
            }

            if (var6 == BiomeGenBase.BETArainforest)
            {
                var14 += var13 + 5;
            }

            if (var6 == BiomeGenBase.BETAseasonalForest)
            {
                var14 += var13 + 2;
            }

            if (var6 == BiomeGenBase.BETAtaiga)
            {
                var14 += var13 + 5;
            }

            if (var6 == BiomeGenBase.BETAdesert)
            {
                var14 -= 20;
            }

            if (var6 == BiomeGenBase.BETAtundra)
            {
                var14 -= 20;
            }

            if (var6 == BiomeGenBase.BETAplains)
            {
                var14 -= 20;
            }

            for (var15 = 0; var15 < var14; ++var15)
            {
                var16 = var4 + this.rand.nextInt(16) + 8;
                var17 = var5 + this.rand.nextInt(16) + 8;
                WorldGenerator var18 = var6.getRandomWorldGenForTrees(this.rand);
                var18.setScale(1.0D, 1.0D, 1.0D);
                var18.generate(this.worldObj, this.rand, var16, this.worldObj.getHeightValue(var16, var17), var17);
            }

            byte var30 = 0;

            if (var6 == BiomeGenBase.BETAforest)
            {
                var30 = 2;
            }

            if (var6 == BiomeGenBase.BETAseasonalForest)
            {
                var30 = 4;
            }

            if (var6 == BiomeGenBase.BETAtaiga)
            {
                var30 = 2;
            }

            if (var6 == BiomeGenBase.BETAplains)
            {
                var30 = 3;
            }

            int var19;
            int var28;

            for (var16 = 0; var16 < var30; ++var16)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var28 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantYellow.blockID)).generate(this.worldObj, this.rand, var17, var28, var19);
            }

            byte var31 = 0;

            if (var6 == BiomeGenBase.BETAforest)
            {
                var31 = 2;
            }

            if (var6 == BiomeGenBase.BETArainforest)
            {
                var31 = 10;
            }

            if (var6 == BiomeGenBase.BETAseasonalForest)
            {
                var31 = 2;
            }

            if (var6 == BiomeGenBase.BETAtaiga)
            {
                var31 = 1;
            }

            if (var6 == BiomeGenBase.BETAplains)
            {
                var31 = 10;
            }

            int var20;
            int var21;

            for (var17 = 0; var17 < var31; ++var17)
            {
                byte var29 = 1;

                if (var6 == BiomeGenBase.BETArainforest && this.rand.nextInt(3) != 0)
                {
                    var29 = 2;
                }

                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(128);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenTallGrass(Block.tallGrass.blockID, var29)).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            var31 = 0;

            if (var6 == BiomeGenBase.BETAdesert)
            {
                var31 = 2;
            }

            for (var17 = 0; var17 < var31; ++var17)
            {
                var28 = var4 + this.rand.nextInt(16) + 8;
                var19 = this.rand.nextInt(128);
                var20 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenDeadBush(Block.deadBush.blockID)).generate(this.worldObj, this.rand, var28, var19, var20);
            }

            if (this.rand.nextInt(2) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var28 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantRed.blockID)).generate(this.worldObj, this.rand, var17, var28, var19);
            }

            if (this.rand.nextInt(4) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var28 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomBrown.blockID)).generate(this.worldObj, this.rand, var17, var28, var19);
            }

            if (this.rand.nextInt(8) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var28 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomRed.blockID)).generate(this.worldObj, this.rand, var17, var28, var19);
            }

            for (var17 = 0; var17 < 10; ++var17)
            {
                var28 = var4 + this.rand.nextInt(16) + 8;
                var19 = this.rand.nextInt(128);
                var20 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4oldGenReed()).generate(this.worldObj, this.rand, var28, var19, var20);
            }

            if (this.rand.nextInt(32) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var28 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenPumpkin()).generate(this.worldObj, this.rand, var17, var28, var19);
            }

            var17 = 0;

            if (var6 == BiomeGenBase.BETAdesert)
            {
                var17 += 10;
            }

            for (var28 = 0; var28 < var17; ++var28)
            {
                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(128);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenCactus()).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            for (var28 = 0; var28 < 50; ++var28)
            {
                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(this.rand.nextInt(120) + 8);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenLiquids(Block.waterMoving.blockID)).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            for (var28 = 0; var28 < 20; ++var28)
            {
                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
            this.generatedTemperatures = this.worldObj.getWorldChunkManager().getColdTemperatures(this.generatedTemperatures, var4 + 8, var5 + 8, 16, 16);

            for (var28 = var4 + 8; var28 < var4 + 8 + 16; ++var28)
            {
                for (var19 = var5 + 8; var19 < var5 + 8 + 16; ++var19)
                {
                    var20 = var28 - (var4 + 8);
                    var21 = var19 - (var5 + 8);
                    int var22 = this.worldObj.getPrecipitationHeight(var28, var19);
                    double var23 = this.generatedTemperatures[var20 * 16 + var21] - (double)(var22 - 64) / 64.0D * 0.3D;

                    if (var23 < 0.5D && var22 > 0 && var22 < 128 && this.worldObj.isAirBlock(var28, var22, var19))
                    {
                        if (this.worldObj.getBlockMaterial(var28, var22 - 1, var19).blocksMovement() && this.worldObj.getBlockMaterial(var28, var22 - 1, var19) != Material.ice)
                        {
                            this.worldObj.setBlock(var28, var22, var19, Block.snow.blockID, 0, 2);
                        }
                        else if (this.worldObj.getBlockMaterial(var28, 63, var19) == Material.water)
                        {
                            this.worldObj.setBlock(var28, 63, var19, Block.ice.blockID, 0, 2);
                        }
                    }
                }
            }

            BlockSand.fallInstantly = false;
        }
        else if (this.worldtype == 1)
        {
            BlockSand.fallInstantly = true;
            var4 = var2 * 16;
            var5 = var3 * 16;
            var6 = this.worldObj.getWorldChunkManager().getBiomeGenAt(var4 + 16, var5 + 16);
            this.rand.setSeed(this.worldObj.getSeed());
            var7 = this.rand.nextLong() / 2L * 2L + 1L;
            var9 = this.rand.nextLong() / 2L * 2L + 1L;
            this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.getSeed());
            var11 = 0.25D;

            if (this.rand.nextInt(4) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(128);
                var15 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4oldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
            }

            if (this.rand.nextInt(8) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(this.rand.nextInt(120) + 8);
                var15 = var5 + this.rand.nextInt(16) + 8;

                if (var14 < 64 || this.rand.nextInt(10) == 0)
                {
                    (new BWG4oldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
            }

            if (this.rand.nextInt(30) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(15);
                var15 = var5 + this.rand.nextInt(16) + 8;

                if (this.rand.nextInt(8) == 0)
                {
                    (new BWG4decoDungeons(13, false, false, true)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
                else
                {
                    (new BWG4decoDungeons(13, false, true, false)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
            }

            var6.decorate(this.worldObj, this.rand, var4, var5);
            SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
            this.generatedTemperatures = this.worldObj.getWorldChunkManager().getColdTemperatures(this.generatedTemperatures, var4 + 8, var5 + 8, 16, 16);

            for (var13 = var4 + 8; var13 < var4 + 8 + 16; ++var13)
            {
                for (var14 = var5 + 8; var14 < var5 + 8 + 16; ++var14)
                {
                    var15 = var13 - (var4 + 8);
                    var16 = var14 - (var5 + 8);
                    var17 = this.worldObj.getPrecipitationHeight(var13, var14);
                    double var32 = this.generatedTemperatures[var15 * 16 + var16] - (double)(var17 - 64) / 64.0D * 0.3D;

                    if (var32 < 0.5D && var17 > 0 && var17 < 128 && this.worldObj.isAirBlock(var13, var17, var14))
                    {
                        if (this.worldObj.getBlockMaterial(var13, var17 - 1, var14).blocksMovement() && this.worldObj.getBlockMaterial(var13, var17 - 1, var14) != Material.ice)
                        {
                            this.worldObj.setBlock(var13, var17, var14, Block.snow.blockID, 0, 2);
                        }
                        else if (this.worldObj.getBlockMaterial(var13, 63, var14) == Material.water)
                        {
                            this.worldObj.setBlock(var13, 63, var14, Block.ice.blockID, 0, 2);
                        }
                    }
                }
            }

            BlockSand.fallInstantly = false;
        }
        else
        {
            BlockSand.fallInstantly = true;
            var4 = var2 * 16;
            var5 = var3 * 16;
            int var8;
            int var25;
            int var26;

            if (this.rand.nextInt(20) == 0)
            {
                var25 = var4 + this.rand.nextInt(16) + 8;
                var26 = this.rand.nextInt(15);
                var8 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4decoDungeons(17, true, true, false)).generate(this.worldObj, this.rand, var25, var26, var8);
            }

            int var27;

            for (var25 = 0; var25 < 15; ++var25)
            {
                var26 = var4 + this.rand.nextInt(16) + 8;
                var8 = this.rand.nextInt(80) + 4;
                var27 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenHellLava(Block.lavaMoving.blockID, false)).generate(this.worldObj, this.rand, var26, var8, var27);
            }

            if (this.rand.nextInt(4) == 0)
            {
                var25 = var4 + this.rand.nextInt(16) + 8;
                var26 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4decoSurvival(2)).generate(this.worldObj, this.rand, var25, this.worldObj.getHeightValue(var25, var26), var26);
            }

            if (this.rand.nextInt(3) == 0)
            {
                var25 = var4 + this.rand.nextInt(16) + 8;
                var26 = this.rand.nextInt(128);
                var8 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4decoSurvival(3)).generate(this.worldObj, this.rand, var25, var26, var8);
            }

            for (var25 = 0; var25 < 4; ++var25)
            {
                var26 = var4 + this.rand.nextInt(16) + 8;
                var8 = this.rand.nextInt(120) + 4;
                var27 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFire()).generate(this.worldObj, this.rand, var26, var8, var27);
            }

            if (this.rand.nextInt(1) == 0)
            {
                var25 = var4 + this.rand.nextInt(16) + 8;
                var26 = this.rand.nextInt(128);
                var8 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomBrown.blockID)).generate(this.worldObj, this.rand, var25, var26, var8);
            }

            if (this.rand.nextInt(1) == 0)
            {
                var25 = var4 + this.rand.nextInt(16) + 8;
                var26 = this.rand.nextInt(128);
                var8 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomRed.blockID)).generate(this.worldObj, this.rand, var25, var26, var8);
            }

            for (var25 = 0; var25 < 16; ++var25)
            {
                var26 = var4 + this.rand.nextInt(16);
                var8 = this.rand.nextInt(108) + 10;
                var27 = var5 + this.rand.nextInt(16);
                (new WorldGenMinable(Block.oreNetherQuartz.blockID, 13, Block.netherrack.blockID)).generate(this.worldObj, this.rand, var26, var8, var27);
            }

            var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
            var6.decorate(this.worldObj, this.worldObj.rand, var4, var5);
            BlockSand.fallInstantly = false;
        }
    }

    /**
     * Two modes of operation: if passed true, save all Chunks in one go.  If passed false, save up to two chunks.
     * Return true if all chunks have been saved.
     */
    public boolean saveChunks(boolean var1, IProgressUpdate var2)
    {
        return true;
    }

    /**
     * Unloads chunks that are marked to be unloaded. This is not guaranteed to unload every such chunk.
     */
    public boolean unloadQueuedChunks()
    {
        return false;
    }

    public boolean unload100OldestChunks()
    {
        return false;
    }

    /**
     * Returns if the IChunkProvider supports saving.
     */
    public boolean canSave()
    {
        return true;
    }

    /**
     * Converts the instance data to a readable string.
     */
    public String makeString()
    {
        return "RandomLevelSource";
    }

    /**
     * Returns a list of creatures of the specified type that can spawn at the given location.
     */
    public List getPossibleCreatures(EnumCreatureType var1, int var2, int var3, int var4)
    {
        BiomeGenBase var5 = this.worldObj.getBiomeGenForCoords(var2, var4);
        return var5 == null ? null : var5.getSpawnableList(var1);
    }

    /**
     * Returns the location of the closest structure of the specified type. If not found returns null.
     */
    public ChunkPosition findClosestStructure(World var1, String var2, int var3, int var4, int var5)
    {
        return null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void recreateStructures(int var1, int var2)
    {
        if (this.mapFeaturesEnabled)
        {
            ;
        }
    }

    public void func_104112_b() {}
}
