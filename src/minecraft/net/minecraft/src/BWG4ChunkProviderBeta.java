package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BWG4ChunkProviderBeta implements IChunkProvider
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
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    private MapGenVillage villageGenerator = new MapGenVillage();
    private BiomeGenBase[] biomesForGeneration;
    private int worldtype;
    double[] field_4185_d;
    double[] field_4184_e;
    double[] field_4183_f;
    double[] field_4182_g;
    double[] field_4181_h;
    int[][] field_914_i = new int[32][32];
    private double[] generatedTemperatures;

    public BWG4ChunkProviderBeta(World var1, long var2, boolean var4, int var5)
    {
        this.worldObj = var1;
        this.rand = new Random(var2);
        this.mapFeaturesEnabled = var4;
    
        this.worldtype = var5;
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
        byte var6 = 4;
        byte var7 = 64;
        int var8 = var6 + 1;
        byte var9 = 17;
        int var10 = var6 + 1;
        this.field_4180_q = this.func_4061_a(this.field_4180_q, var1 * var6, 0, var2 * var6, var8, var9, var10);

        for (int var11 = 0; var11 < var6; ++var11)
        {
            for (int var12 = 0; var12 < var6; ++var12)
            {
                for (int var13 = 0; var13 < 16; ++var13)
                {
                    double var14 = 0.125D;
                    double var16 = this.field_4180_q[((var11 + 0) * var10 + var12 + 0) * var9 + var13 + 0];
                    double var18 = this.field_4180_q[((var11 + 0) * var10 + var12 + 1) * var9 + var13 + 0];
                    double var20 = this.field_4180_q[((var11 + 1) * var10 + var12 + 0) * var9 + var13 + 0];
                    double var22 = this.field_4180_q[((var11 + 1) * var10 + var12 + 1) * var9 + var13 + 0];
                    double var24 = (this.field_4180_q[((var11 + 0) * var10 + var12 + 0) * var9 + var13 + 1] - var16) * var14;
                    double var26 = (this.field_4180_q[((var11 + 0) * var10 + var12 + 1) * var9 + var13 + 1] - var18) * var14;
                    double var28 = (this.field_4180_q[((var11 + 1) * var10 + var12 + 0) * var9 + var13 + 1] - var20) * var14;
                    double var30 = (this.field_4180_q[((var11 + 1) * var10 + var12 + 1) * var9 + var13 + 1] - var22) * var14;

                    for (int var32 = 0; var32 < 8; ++var32)
                    {
                        double var33 = 0.25D;
                        double var35 = var16;
                        double var37 = var18;
                        double var39 = (var20 - var16) * var33;
                        double var41 = (var22 - var18) * var33;

                        for (int var43 = 0; var43 < 4; ++var43)
                        {
                            int var44 = var43 + var11 * 4 << 11 | 0 + var12 * 4 << 7 | var13 * 8 + var32;
                            short var45 = 128;
                            double var46 = 0.25D;
                            double var48 = var35;
                            double var50 = (var37 - var35) * var46;

                            for (int var52 = 0; var52 < 4; ++var52)
                            {
                                double var53 = var5[(var11 * 4 + var43) * 16 + var12 * 4 + var52];
                                int var55 = 0;

                                if (var13 * 8 + var32 < var7)
                                {
                                    if (var53 < 0.5D && var13 * 8 + var32 >= var7 - 1)
                                    {
                                        var55 = Block.ice.blockID;
                                    }
                                    else
                                    {
                                        var55 = Block.waterStill.blockID;
                                    }
                                }

                                if (var48 > 0.0D)
                                {
                                    var55 = Block.stone.blockID;
                                }

                                var3[var44] = (byte)var55;
                                var44 += var45;
                                var48 += var50;
                            }

                            var35 += var39;
                            var37 += var41;
                        }

                        var16 += var24;
                        var18 += var26;
                        var20 += var28;
                        var22 += var30;
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

                    if (var17 <= 0 + this.rand.nextInt(5))
                    {
                        var3[var18] = (byte)Block.bedrock.blockID;
                    }
                    else
                    {
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
                                    var15 = 0;
                                    var16 = (byte)Block.stone.blockID;
                                }
                                else if (var17 >= var5 - 4 && var17 <= var5 + 1)
                                {
                                    var15 = var10.topBlock;
                                    var16 = var10.fillerBlock;

                                    if (var12)
                                    {
                                        var15 = 0;
                                    }

                                    if (var12)
                                    {
                                        var16 = (byte)Block.gravel.blockID;
                                    }

                                    if (var11)
                                    {
                                        var15 = (byte)Block.sand.blockID;
                                    }

                                    if (var11)
                                    {
                                        var16 = (byte)Block.sand.blockID;
                                    }
                                }

                                if (var17 < var5 && var15 == 0)
                                {
                                    var15 = (byte)Block.waterStill.blockID;
                                }

                                var14 = var13;

                                if (var17 >= var5 - 1)
                                {
                                    var3[var18] = var15;
                                }
                                else
                                {
                                    var3[var18] = var16;
                                }
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

        if (this.mapFeaturesEnabled)
        {
        	this.villageGenerator.generate(this, this.worldObj, var1, var2, var3);
        	this.mineshaftGenerator.generate(this, this.worldObj, var1, var2, var3);
            this.strongholdGenerator.generate(this, this.worldObj, var1, var2, var3);
        }

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
                double var21 = var12[var18 * 16 + var20];
                double var23 = var13[var18 * 16 + var20] * var21;
                double var25 = 1.0D - var23;
                var25 *= var25;
                var25 *= var25;
                var25 = 1.0D - var25;
                double var27 = (this.field_4182_g[var15] + 256.0D) / 512.0D;
                var27 *= var25;

                if (var27 > 1.0D)
                {
                    var27 = 1.0D;
                }

                double var29 = this.field_4181_h[var15] / 8000.0D;

                if (var29 < 0.0D)
                {
                    var29 = -var29 * 0.3D;
                }

                var29 = var29 * 3.0D - 2.0D;

                if (var29 < 0.0D)
                {
                    var29 /= 2.0D;

                    if (var29 < -1.0D)
                    {
                        var29 = -1.0D;
                    }

                    var29 /= 1.4D;
                    var29 /= 2.0D;
                    var27 = 0.0D;
                }
                else
                {
                    if (var29 > 1.0D)
                    {
                        var29 = 1.0D;
                    }

                    var29 /= 8.0D;
                }

                if (var27 < 0.0D)
                {
                    var27 = 0.0D;
                }

                var27 += 0.5D;
                var29 = var29 * (double)var6 / 16.0D;
                double var31 = (double)var6 / 2.0D + var29 * 4.0D;
                ++var15;

                for (int var33 = 0; var33 < var6; ++var33)
                {
                    double var34 = 0.0D;
                    double var36 = ((double)var33 - var31) * 12.0D / var27;

                    if (var36 < 0.0D)
                    {
                        var36 *= 4.0D;
                    }

                    double var38 = this.field_4184_e[var14] / 512.0D;
                    double var40 = this.field_4183_f[var14] / 512.0D;
                    double var42 = (this.field_4185_d[var14] / 10.0D + 1.0D) / 2.0D;

                    if (var42 < 0.0D)
                    {
                        var34 = var38;
                    }
                    else if (var42 > 1.0D)
                    {
                        var34 = var40;
                    }
                    else
                    {
                        var34 = var38 + (var40 - var38) * var42;
                    }

                    var34 -= var36;

                    if (var33 > var6 - 4)
                    {
                        double var44 = (double)((float)(var33 - (var6 - 4)) / 3.0F);
                        var34 = var34 * (1.0D - var44) + -10.0D * var44;
                    }

                    var1[var14] = var34;
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
        boolean a = false;

        if (this.worldtype == 1)
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

            if (this.mapFeaturesEnabled)
            {
            	a = this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
            	this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
                this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
            }

            if (!a && this.rand.nextInt(4) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(128);
                var15 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4oldGenLakes(Block.waterStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
            }

            if (!a &&this.rand.nextInt(8) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(this.rand.nextInt(120) + 8);
                var15 = var5 + this.rand.nextInt(16) + 8;

                if (var14 < 64 || this.rand.nextInt(10) == 0)
                {
                    (new BWG4oldGenLakes(Block.lavaStill.blockID)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
            }

            for (var13 = 0; var13 < 8; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16) + 8;
                var15 = this.rand.nextInt(128);
                var16 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4decoDungeons(1, true, false, false)).generate(this.worldObj, this.rand, var14, var15, var16);
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

            byte var27 = 0;

            if (var6 == BiomeGenBase.BETAforest)
            {
                var27 = 2;
            }

            if (var6 == BiomeGenBase.BETAseasonalForest)
            {
                var27 = 4;
            }

            if (var6 == BiomeGenBase.BETAtaiga)
            {
                var27 = 2;
            }

            if (var6 == BiomeGenBase.BETAplains)
            {
                var27 = 3;
            }

            int var19;
            int var25;

            for (var16 = 0; var16 < var27; ++var16)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var25 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantYellow.blockID)).generate(this.worldObj, this.rand, var17, var25, var19);
            }

            byte var28 = 0;

            if (var6 == BiomeGenBase.BETAforest)
            {
                var28 = 2;
            }

            if (var6 == BiomeGenBase.BETArainforest)
            {
                var28 = 10;
            }

            if (var6 == BiomeGenBase.BETAseasonalForest)
            {
                var28 = 2;
            }

            if (var6 == BiomeGenBase.BETAtaiga)
            {
                var28 = 1;
            }

            if (var6 == BiomeGenBase.BETAplains)
            {
                var28 = 10;
            }

            int var20;
            int var21;

            for (var17 = 0; var17 < var28; ++var17)
            {
                byte var26 = 1;

                if (var6 == BiomeGenBase.BETArainforest && this.rand.nextInt(3) != 0)
                {
                    var26 = 2;
                }

                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(128);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenTallGrass(Block.tallGrass.blockID, var26)).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            var28 = 0;

            if (var6 == BiomeGenBase.BETAdesert)
            {
                var28 = 2;
            }

            for (var17 = 0; var17 < var28; ++var17)
            {
                var25 = var4 + this.rand.nextInt(16) + 8;
                var19 = this.rand.nextInt(128);
                var20 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenDeadBush(Block.deadBush.blockID)).generate(this.worldObj, this.rand, var25, var19, var20);
            }

            if (this.rand.nextInt(2) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var25 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantRed.blockID)).generate(this.worldObj, this.rand, var17, var25, var19);
            }

            if (this.rand.nextInt(4) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var25 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomBrown.blockID)).generate(this.worldObj, this.rand, var17, var25, var19);
            }

            if (this.rand.nextInt(8) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var25 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomRed.blockID)).generate(this.worldObj, this.rand, var17, var25, var19);
            }

            for (var17 = 0; var17 < 10; ++var17)
            {
                var25 = var4 + this.rand.nextInt(16) + 8;
                var19 = this.rand.nextInt(128);
                var20 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4oldGenReed()).generate(this.worldObj, this.rand, var25, var19, var20);
            }

            if (this.rand.nextInt(32) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var25 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenPumpkin()).generate(this.worldObj, this.rand, var17, var25, var19);
            }

            var17 = 0;

            if (var6 == BiomeGenBase.BETAdesert)
            {
                var17 += 10;
            }

            for (var25 = 0; var25 < var17; ++var25)
            {
                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(128);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenCactus()).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            for (var25 = 0; var25 < 50; ++var25)
            {
                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(this.rand.nextInt(120) + 8);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenLiquids(Block.waterMoving.blockID)).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            for (var25 = 0; var25 < 20; ++var25)
            {
                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
            this.generatedTemperatures = this.worldObj.getWorldChunkManager().getColdTemperatures(this.generatedTemperatures, var4 + 8, var5 + 8, 16, 16);

            for (var25 = var4 + 8; var25 < var4 + 8 + 16; ++var25)
            {
                for (var19 = var5 + 8; var19 < var5 + 8 + 16; ++var19)
                {
                    var20 = var25 - (var4 + 8);
                    var21 = var19 - (var5 + 8);
                    int var22 = this.worldObj.getPrecipitationHeight(var25, var19);
                    double var23 = this.generatedTemperatures[var20 * 16 + var21] - (double)(var22 - 64) / 64.0D * 0.3D;

                    if (var23 < 0.5D && var22 > 0 && var22 < 128 && this.worldObj.isAirBlock(var25, var22, var19))
                    {
                        if (this.worldObj.getBlockMaterial(var25, var22 - 1, var19).blocksMovement() && this.worldObj.getBlockMaterial(var25, var22 - 1, var19) != Material.ice)
                        {
                            this.worldObj.setBlock(var25, var22, var19, Block.snow.blockID, 0, 2);
                        }
                        else if (this.worldObj.getBlockMaterial(var25, 63, var19) == Material.water)
                        {
                            this.worldObj.setBlock(var25, 63, var19, Block.ice.blockID, 0, 2);
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
            var6 = this.worldObj.getWorldChunkManager().getBiomeGenAt(var4 + 16, var5 + 16);
            this.rand.setSeed(this.worldObj.getSeed());
            var7 = this.rand.nextLong() / 2L * 2L + 1L;
            var9 = this.rand.nextLong() / 2L * 2L + 1L;
            this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.getSeed());
            var11 = 0.25D;
            this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);

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

            for (var13 = 0; var13 < 8; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16) + 8;
                var15 = this.rand.nextInt(128);
                var16 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4decoDungeons(2, true, false, false)).generate(this.worldObj, this.rand, var14, var15, var16);
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
                    double var29 = this.generatedTemperatures[var15 * 16 + var16] - (double)(var17 - 64) / 64.0D * 0.3D;

                    if (var29 < 0.5D && var17 > 0 && var17 < 128 && this.worldObj.isAirBlock(var13, var17, var14))
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
        return "Stronghold".equals(var2) && this.strongholdGenerator != null ? this.strongholdGenerator.getNearestInstance(var1, var3, var4, var5) : null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void recreateStructures(int var1, int var2)
    {
        if (this.mapFeaturesEnabled)
        {
        	this.villageGenerator.generate(this, this.worldObj, var1, var2, (byte[])null);
        	this.mineshaftGenerator.generate(this, this.worldObj, var1, var2, (byte[])null);
            this.strongholdGenerator.generate(this, this.worldObj, var1, var2, (byte[])null);
        }
    }

    public void func_104112_b() {}
}
