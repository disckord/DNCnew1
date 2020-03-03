package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BWG4ChunkProviderSkyIsland implements IChunkProvider
{
    private Random endRNG;
    private NoiseGeneratorOctaves noiseGen1;
    private NoiseGeneratorOctaves noiseGen2;
    private NoiseGeneratorOctaves noiseGen3;
    public NoiseGeneratorOctaves noiseGen4;
    public NoiseGeneratorOctaves noiseGen5;
    private World endWorld;
    private double[] densities;
    private BiomeGenBase[] biomesForGeneration;
    double[] noiseData1;
    double[] noiseData2;
    double[] noiseData3;
    double[] noiseData4;
    double[] noiseData5;
    int[][] field_73203_h = new int[32][32];
    private MapGenBase caveGenerator = new MapGenCaves();
    int THEMEID = 1;

    public BWG4ChunkProviderSkyIsland(World var1, long var2, int var4)
    {
        this.endWorld = var1;
        this.endRNG = new Random(var2);
        this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
        this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
        this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);
        this.THEMEID = var4;
    }

    public void generateTerrain(int var1, int var2, byte[] var3, BiomeGenBase[] var4)
    {
        byte var5 = 2;
        int var6 = var5 + 1;
        byte var7 = 33;
        int var8 = var5 + 1;
        this.densities = this.initializeNoiseField(this.densities, var1 * var5, 0, var2 * var5, var6, var7, var8);

        for (int var9 = 0; var9 < var5; ++var9)
        {
            for (int var10 = 0; var10 < var5; ++var10)
            {
                for (int var11 = 0; var11 < 32; ++var11)
                {
                    double var12 = 0.25D;
                    double var14 = this.densities[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
                    double var16 = this.densities[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
                    double var18 = this.densities[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
                    double var20 = this.densities[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
                    double var22 = (this.densities[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
                    double var24 = (this.densities[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
                    double var26 = (this.densities[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
                    double var28 = (this.densities[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

                    for (int var30 = 0; var30 < 4; ++var30)
                    {
                        double var31 = 0.125D;
                        double var33 = var14;
                        double var35 = var16;
                        double var37 = (var18 - var14) * var31;
                        double var39 = (var20 - var16) * var31;

                        for (int var41 = 0; var41 < 8; ++var41)
                        {
                            int var42 = var41 + var9 * 8 << 11 | 0 + var10 * 8 << 7 | var11 * 4 + var30;
                            short var43 = 128;
                            double var44 = 0.125D;
                            double var46 = var33;
                            double var48 = (var35 - var33) * var44;

                            for (int var50 = 0; var50 < 8; ++var50)
                            {
                                int var51 = 0;

                                if (var46 > 0.0D)
                                {
                                    var51 = Block.stone.blockID;
                                }

                                var3[var42] = (byte)var51;
                                var42 += var43;
                                var46 += var48;
                            }

                            var33 += var37;
                            var35 += var39;
                        }

                        var14 += var22;
                        var16 += var24;
                        var18 += var26;
                        var20 += var28;
                    }
                }
            }
        }
    }

    public void replaceBlocksForBiome(int var1, int var2, byte[] var3, BiomeGenBase[] var4)
    {
        for (int var5 = 0; var5 < 16; ++var5)
        {
            for (int var6 = 0; var6 < 16; ++var6)
            {
                byte var7 = 1;
                int var8 = -1;
                byte var9 = (byte)Block.grass.blockID;
                byte var10 = (byte)Block.dirt.blockID;

                for (int var11 = 127; var11 >= 0; --var11)
                {
                    int var12 = (var6 * 16 + var5) * 128 + var11;
                    byte var13 = var3[var12];

                    if (var13 == 0)
                    {
                        var8 = -1;
                    }
                    else if (var13 == Block.stone.blockID)
                    {
                        if (var8 == -1)
                        {
                            var8 = var7;

                            if (var11 >= 0)
                            {
                                var3[var12] = var9;
                            }
                            else
                            {
                                var3[var12] = var10;
                            }
                        }
                        else if (var8 > 0)
                        {
                            --var8;
                            var3[var12] = var10;
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
        this.endRNG.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
        byte[] var3 = new byte[32768];
        this.biomesForGeneration = this.endWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
        this.generateTerrain(var1, var2, var3, this.biomesForGeneration);
        this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
        this.caveGenerator.generate(this, this.endWorld, var1, var2, var3);
        Chunk var4 = new Chunk(this.endWorld, var3, var1, var2);
        byte[] var5 = var4.getBiomeArray();

        for (int var6 = 0; var6 < var5.length; ++var6)
        {
            var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
        }

        var4.generateSkylightMap();
        return var4;
    }

    private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7)
    {
        if (var1 == null)
        {
            var1 = new double[var5 * var6 * var7];
        }

        float var8 = 64.0F;
        double var9 = -270.0D;
        double var11 = 684.412D;
        double var13 = 684.412D;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        var11 *= 2.0D;
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, var2, var3, var4, var5, var6, var7, var11 / 80.0D, var13 / 160.0D, var11 / 80.0D);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, var2, var3, var4, var5, var6, var7, var11, var13, var11);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, var2, var3, var4, var5, var6, var7, var11, var13, var11);
        int var15 = 0;
        int var16 = 0;

        for (int var17 = 0; var17 < var5; ++var17)
        {
            for (int var18 = 0; var18 < var7; ++var18)
            {
                double var19 = (this.noiseData4[var16] + 256.0D) / 512.0D;

                if (var19 > 1.0D)
                {
                    var19 = 1.0D;
                }

                double var21 = this.noiseData5[var16] / 8000.0D;

                if (var21 < 0.0D)
                {
                    var21 = -var21 * 0.3D;
                }

                var21 = var21 * 3.0D - 2.0D;
                float var23 = (float)(var17 + var2 - 0) / 1.0F;
                float var24 = (float)(var18 + var4 - 0) / 1.0F;
                float var25 = 100.0F - MathHelper.sqrt_float(var23 * var23 + var24 * var24) * 8.0F;

                if (var25 > 80.0F)
                {
                    var25 = 80.0F;
                }

                if (var25 < -100.0F)
                {
                    var25 = -100.0F;
                }

                if (var21 > 1.0D)
                {
                    var21 = 1.0D;
                }

                var21 /= 8.0D;
                var21 = 0.0D;

                if (var19 < 0.0D)
                {
                    var19 = 0.0D;
                }

                var19 += 0.5D;
                var21 = var21 * (double)var6 / 16.0D;
                ++var16;
                double var26 = (double)var6 / 2.0D;

                for (int var28 = 0; var28 < var6; ++var28)
                {
                    double var29 = 0.0D;
                    double var31 = ((double)var28 - var26) * 8.0D / var19;

                    if (var31 < 0.0D)
                    {
                        var31 *= -1.0D;
                    }

                    double var33 = this.noiseData2[var15] / 512.0D;
                    double var35 = this.noiseData3[var15] / 512.0D;
                    double var37 = (this.noiseData1[var15] / 10.0D + 1.0D) / 2.0D;

                    if (var37 < 0.0D)
                    {
                        var29 = var33;
                    }
                    else if (var37 > 1.0D)
                    {
                        var29 = var35;
                    }
                    else
                    {
                        var29 = var33 + (var35 - var33) * var37;
                    }

                    var29 -= 8.0D;
                    var29 += (double)var25;
                    byte var39 = 2;
                    double var40;

                    if (var28 > var6 / 2 - var39)
                    {
                        var40 = (double)((float)(var28 - (var6 / 2 - var39)) / var8);

                        if (var40 < 0.0D)
                        {
                            var40 = 0.0D;
                        }

                        if (var40 > 1.0D)
                        {
                            var40 = 1.0D;
                        }

                        var29 = var29 * (1.0D - var40) + var9 * var40;
                    }

                    var39 = 8;

                    if (var28 < var39)
                    {
                        var40 = (double)((float)(var39 - var28) / ((float)var39 - 1.0F));
                        var29 = var29 * (1.0D - var40) + -30.0D * var40;
                    }

                    var1[var15] = var29;
                    ++var15;
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
        BlockSand.fallInstantly = true;
        int var4 = var2 * 16;
        int var5 = var3 * 16;
        BiomeGenBase var6 = this.endWorld.getBiomeGenForCoords(var4 + 16, var5 + 16);
        var6.decorate(this.endWorld, this.endRNG, var4, var5);
        int var7;
        int var8;
        int var9;

        if (var2 == 0 && var3 == 0)
        {
            (new BWG4decoDungeons(11, false, false, true)).generate(this.endWorld, this.endRNG, 0, 2, 0);
        }
        else if (this.endRNG.nextInt(12) == 0)
        {
            var7 = var4 + this.endRNG.nextInt(16) + 8;
            var8 = this.endRNG.nextInt(10);
            var9 = var5 + this.endRNG.nextInt(16) + 8;
            (new BWG4decoDungeons(11, false, true, false)).generate(this.endWorld, this.endRNG, var7, var8, var9);
        }

        int var10;

        if (this.THEMEID == 3)
        {
            for (var7 = 0; var7 < 80; ++var7)
            {
                var8 = var4 + this.endRNG.nextInt(16) + 8;
                var9 = this.endRNG.nextInt(128);
                var10 = var5 + this.endRNG.nextInt(16) + 8;
                (new BWG4decoSurvival(5)).generate(this.endWorld, this.endRNG, var8, var9, var10);
            }
        }

        var7 = var4 + 8;
        var8 = var5 + 8;

        for (var9 = 0; var9 < 16; ++var9)
        {
            for (var10 = 0; var10 < 16; ++var10)
            {
                int var11 = this.endWorld.getPrecipitationHeight(var7 + var9, var8 + var10);

                if (this.endWorld.isBlockFreezable(var9 + var7, var11 - 1, var10 + var8))
                {
                    this.endWorld.setBlock(var9 + var7, var11 - 1, var10 + var8, Block.ice.blockID, 0, 2);
                }

                if (this.endWorld.canSnowAt(var9 + var7, var11, var10 + var8))
                {
                    this.endWorld.setBlock(var9 + var7, var11, var10 + var8, Block.snow.blockID, 0, 2);
                }
            }
        }

        BlockSand.fallInstantly = false;
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
        BiomeGenBase var5 = this.endWorld.getBiomeGenForCoords(var2, var4);
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

    public void recreateStructures(int var1, int var2) {}

    public void func_104112_b() {}
}
