package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BWG4ChunkProviderIsland implements IChunkProvider
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
    private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    int THEMEID = 1;

    public BWG4ChunkProviderIsland(World var1, long var2, int var4)
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
                                else if (var11 * 4 + var30 < 63)
                                {
                                    if (var11 * 4 + var30 < 55)
                                    {
                                        var51 = Block.stone.blockID;
                                    }
                                    else
                                    {
                                        var51 = Block.waterStill.blockID;
                                    }
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
                byte var9 = (byte)Block.sand.blockID;
                byte var10 = (byte)Block.sand.blockID;

                for (int var11 = 127; var11 >= 0; --var11)
                {
                    int var12 = (var6 * 16 + var5) * 128 + var11;

                    if (var11 <= 0 + this.endRNG.nextInt(5))
                    {
                        var3[var12] = (byte)Block.bedrock.blockID;
                    }
                    else
                    {
                        byte var13 = var3[var12];

                        if (var13 == 0)
                        {
                            var8 = -1;
                        }
                        else if (var13 == Block.stone.blockID)
                        {
                            if (var8 == -1)
                            {
                                var9 = (byte)Block.sand.blockID;
                                var10 = (byte)Block.sand.blockID;

                                if (var11 > 67 && this.THEMEID == 4)
                                {
                                    var9 = (byte)Block.grass.blockID;
                                    var10 = (byte)Block.dirt.blockID;
                                }

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

                                if (var8 == 0 && var10 == Block.sand.blockID)
                                {
                                    var8 = this.endRNG.nextInt(4);
                                    var10 = (byte)Block.sandStone.blockID;
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
        this.endRNG.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
        byte[] var3 = new byte[32768];
        this.biomesForGeneration = this.endWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
        this.generateTerrain(var1, var2, var3, this.biomesForGeneration);
        this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
        this.caveGenerator.generate(this, this.endWorld, var1, var2, var3);
        this.strongholdGenerator.generate(this, this.endWorld, var1, var2, var3);
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
        double var9 = -3000.0D;
        double var11 = 8000.0D;

        if (this.THEMEID == 1)
        {
            var8 = 80.0F;
            var9 = -2500.0D;
        }

        if (this.THEMEID == 4)
        {
            var9 = -400.0D;
        }

        double var13 = 684.412D;
        double var15 = 684.412D;
        this.noiseData4 = this.noiseGen4.generateNoiseOctaves(this.noiseData4, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
        this.noiseData5 = this.noiseGen5.generateNoiseOctaves(this.noiseData5, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
        var13 *= 2.0D;
        this.noiseData1 = this.noiseGen3.generateNoiseOctaves(this.noiseData1, var2, var3, var4, var5, var6, var7, var13 / 80.0D, var15 / 160.0D, var13 / 80.0D);
        this.noiseData2 = this.noiseGen1.generateNoiseOctaves(this.noiseData2, var2, var3, var4, var5, var6, var7, var13, var15, var13);
        this.noiseData3 = this.noiseGen2.generateNoiseOctaves(this.noiseData3, var2, var3, var4, var5, var6, var7, var13, var15, var13);
        int var17 = 0;
        int var18 = 0;

        for (int var19 = 0; var19 < var5; ++var19)
        {
            for (int var20 = 0; var20 < var7; ++var20)
            {
                double var21 = (this.noiseData4[var18] + 256.0D) / 512.0D;

                if (var21 > 1.0D)
                {
                    var21 = 1.0D;
                }

                double var23 = this.noiseData5[var18] / var11;

                if (var23 < 0.0D)
                {
                    var23 = -var23 * 0.3D;
                }

                var23 = var23 * 3.0D - 2.0D;
                float var25 = (float)(var19 + var2 - 0) / 1.0F;
                float var26 = (float)(var20 + var4 - 0) / 1.0F;
                float var27 = 100.0F - MathHelper.sqrt_float(var25 * var25 + var26 * var26) * 8.0F;

                if (var27 > 80.0F)
                {
                    var27 = 80.0F;
                }

                if (var27 < -100.0F)
                {
                    var27 = -100.0F;
                }

                if (var23 > 1.0D)
                {
                    var23 = 1.0D;
                }

                var23 /= 8.0D;
                var23 = 0.0D;

                if (var21 < 0.0D)
                {
                    var21 = 0.0D;
                }

                var21 += 0.5D;
                var23 = var23 * (double)var6 / 16.0D;
                ++var18;
                double var28 = (double)var6 / 2.0D;

                for (int var30 = 0; var30 < var6; ++var30)
                {
                    double var31 = 0.0D;
                    double var33 = ((double)var30 - var28) * 8.0D / var21;

                    if (var33 < 0.0D)
                    {
                        var33 *= -1.0D;
                    }

                    double var35 = this.noiseData2[var17] / 512.0D;
                    double var37 = this.noiseData3[var17] / 512.0D;
                    double var39 = (this.noiseData1[var17] / 10.0D + 1.0D) / 2.0D;

                    if (var39 < 0.0D)
                    {
                        var31 = var35;
                    }
                    else if (var39 > 1.0D)
                    {
                        var31 = var37;
                    }
                    else
                    {
                        var31 = var35 + (var37 - var35) * var39;
                    }

                    var31 -= 8.0D;
                    var31 += (double)var27;
                    byte var41 = 2;
                    double var42;

                    if (var30 > var6 / 2 - var41)
                    {
                        var42 = (double)((float)(var30 - (var6 / 2 - var41)) / var8);

                        if (var42 < 0.0D)
                        {
                            var42 = 0.0D;
                        }

                        if (var42 > 1.0D)
                        {
                            var42 = 1.0D;
                        }

                        var31 = var31 * (1.0D - var42) + var9 * var42;
                    }

                    var41 = 8;

                    if (var30 < var41)
                    {
                        var42 = (double)((float)(var41 - var30) / ((float)var41 - 1.0F));
                        var31 = var31 * (1.0D - var42) + -30.0D * var42;
                    }

                    var1[var17] = var31;
                    ++var17;
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
        this.strongholdGenerator.generateStructuresInChunk(this.endWorld, this.endRNG, var2, var3);
        int var6;
        int var7;
        int var8;
        int var9;

        for (var6 = 0; var6 < 20; ++var6)
        {
            var7 = var4 + this.endRNG.nextInt(16);
            var8 = this.endRNG.nextInt(128);
            var9 = var5 + this.endRNG.nextInt(16);
            (new BWG4oldGenClay(32, 2)).generate(this.endWorld, this.endRNG, var7, var8, var9);
        }

        if (var2 == 0 && var3 == 0 && this.THEMEID != 4)
        {
            if (!(new BWG4decoDungeons(9, false, false, false)).generate(this.endWorld, this.endRNG, -15 + this.endRNG.nextInt(30), 40, -15 + this.endRNG.nextInt(30)))
            {
                ;
            }

            if (!(new BWG4decoDungeons(10, false, false, false)).generate(this.endWorld, this.endRNG, -15 + this.endRNG.nextInt(30), 20, -15 + this.endRNG.nextInt(30)))
            {
                ;
            }

            (new BWG4decoSurvival(1)).generate(this.endWorld, this.endRNG, 0, this.endWorld.getHeightValue(0, 0), 0);
        }

        for (var6 = 0; var6 < 20; ++var6)
        {
            var7 = var4 + this.endRNG.nextInt(16) + 8;
            var8 = this.endRNG.nextInt(128);
            var9 = var5 + this.endRNG.nextInt(16) + 8;

            if ((new BWG4decoDungeons(8, true, false, false)).generate(this.endWorld, this.endRNG, var7, var8, var9))
            {
                ;
            }
        }

        BiomeGenBase var12 = this.endWorld.getBiomeGenForCoords(var4 + 16, var5 + 16);
        var12.decorate(this.endWorld, this.endWorld.rand, var4, var5);

        if (this.THEMEID == 4)
        {
            SpawnerAnimals.performWorldGenSpawning(this.endWorld, var12, var4 + 8, var5 + 8, 16, 16, this.endWorld.rand);
        }

        var7 = var4 + 8;
        var8 = var5 + 8;

        for (var9 = 0; var9 < 16; ++var9)
        {
            for (int var10 = 0; var10 < 16; ++var10)
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
        return "Stronghold".equals(var2) && this.strongholdGenerator != null ? this.strongholdGenerator.getNearestInstance(var1, var3, var4, var5) : null;
    }

    public int getLoadedChunkCount()
    {
        return 0;
    }

    public void recreateStructures(int var1, int var2)
    {
        this.strongholdGenerator.generate(this, this.endWorld, var1, var2, (byte[])null);
    }

    public void func_104112_b() {}
}
