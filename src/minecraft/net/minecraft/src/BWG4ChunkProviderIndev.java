package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BWG4ChunkProviderIndev implements IChunkProvider
{
    private Random rand;
    private BWG4NoiseOctavesIndev noiseGen1;
    private BWG4NoiseOctavesIndev noiseGen2;
    private BWG4NoiseOctavesIndev noiseGen3;
    private BWG4NoiseOctavesIndev noiseGen4;
    public BWG4NoiseOctavesIndev noiseGen5;
    public BWG4NoiseOctavesIndev noiseGen6;
    public BWG4NoiseOctavesInfdev mobSpawnerNoise;
    public BWG4NoiseOctavesIndev noiseGen10;
    public BWG4NoiseOctavesIndev noiseGen11;
    public BWG4NoisePerlinIndev perlinGen1;
    private World worldObj;
    private final boolean mapFeaturesEnabled;
    private double[] noiseArray;
    private double[] stoneNoise = new double[256];
    private MapGenBase caveGenerator = new MapGenCaves();
    private MapGenStronghold strongholdGenerator = new MapGenStronghold();
    private MapGenVillage villageGenerator = new MapGenVillage();
    private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
    private BiomeGenBase[] biomesForGeneration;
    double[] noise1;
    double[] noise2;
    double[] noise3;
    double[] noise5;
    double[] noise6;
    float[] parabolicField;
    int[][] field_73219_j = new int[32][32];
    boolean themeHELL = false;
    boolean themePARADISE = false;
    boolean themeWOODS = false;
    boolean themeSNOW = false;
    boolean floating = false;

    public BWG4ChunkProviderIndev(World var1, long var2, boolean var4, int var5, int var6)
    {
        this.worldObj = var1;
        this.mapFeaturesEnabled = var4;
        this.rand = new Random(var2);
        this.noiseGen1 = new BWG4NoiseOctavesIndev(this.rand, 16);
        this.noiseGen2 = new BWG4NoiseOctavesIndev(this.rand, 16);
        this.noiseGen3 = new BWG4NoiseOctavesIndev(this.rand, 8);
        this.noiseGen4 = new BWG4NoiseOctavesIndev(this.rand, 4);
        this.noiseGen5 = new BWG4NoiseOctavesIndev(this.rand, 4);
        this.noiseGen6 = new BWG4NoiseOctavesIndev(this.rand, 5);
        this.mobSpawnerNoise = new BWG4NoiseOctavesInfdev(this.rand, 8);
        this.noiseGen10 = new BWG4NoiseOctavesIndev(this.rand, 6);
        this.noiseGen11 = new BWG4NoiseOctavesIndev(this.rand, 8);
        this.perlinGen1 = new BWG4NoisePerlinIndev(this.rand);

        if (var6 == 2)
        {
            this.themeHELL = true;
        }

        if (var6 == 3)
        {
            this.themePARADISE = true;
        }

        if (var6 == 4)
        {
            this.themeWOODS = true;
        }

        if (var6 == 5)
        {
            this.themeSNOW = true;
        }

        if (var5 == 2)
        {
            this.floating = true;
        }
    }

    public void generateTerrain(int var1, int var2, byte[] var3)
    {
        boolean var4 = true;
        boolean var5 = true;
        byte var6 = 64;
        byte[] var7 = new byte[32768];
        int var8 = var1 << 4;
        int var9 = var2 << 4;
        int var10 = 0;
        boolean var11 = false;
        boolean var12 = false;

        for (int var13 = var8; var13 < var8 + 16; ++var13)
        {
            for (int var14 = var9; var14 < var9 + 16; ++var14)
            {
                int var15 = var13 / 1024;
                int var16 = var14 / 1024;
                float var17 = (float)(this.noiseGen1.a((double)((float)var13 / 0.03125F), 0.0D, (double)((float)var14 / 0.03125F)) - this.noiseGen2.a((double)((float)var13 / 0.015625F), 0.0D, (double)((float)var14 / 0.015625F))) / 512.0F / 4.0F;
                float var18 = (float)this.noiseGen5.a((double)((float)var13 / 4.0F), (double)((float)var14 / 4.0F));
                float var19 = (float)this.noiseGen6.a((double)((float)var13 / 8.0F), (double)((float)var14 / 8.0F)) / 8.0F;
                var18 = var18 > 0.0F ? (float)(this.noiseGen3.a((double)((float)var13 * 0.2571428F * 2.0F), (double)((float)var14 * 0.2571428F * 2.0F)) * (double)var19 / 4.0D) : (float)(this.noiseGen4.a((double)((float)var13 * 0.2571428F), (double)((float)var14 * 0.2571428F)) * (double)var19);
                int var20 = (int)(var17 + 64.0F + var18);

                if ((float)this.noiseGen5.a((double)var13, (double)var14) < 0.0F)
                {
                    var20 = var20 / 2 << 1;

                    if ((float)this.noiseGen5.a((double)(var13 / 5), (double)(var14 / 5)) < 0.0F)
                    {
                        ++var20;
                    }
                }

                boolean var21 = this.noiseGen3.a((double)var13, (double)var14) > 8.0D;
                boolean var22 = this.noiseGen11.a((double)var13, (double)var14) > 18.0D;

                if (this.floating)
                {
                    var21 = this.noiseGen3.a((double)var13, (double)var14) > 25.0D;
                    var22 = this.noiseGen11.a((double)var13, (double)var14) > 50.0D;
                }
                else if (this.themePARADISE)
                {
                    var21 = this.noiseGen3.a((double)var13, (double)var14) > -32.0D;
                }
                else if (this.themeHELL || this.themeWOODS)
                {
                    var21 = this.noiseGen3.a((double)var13, (double)var14) > -8.0D;
                }

                double var23 = this.clamp(this.getNoise(8, var13, var14, 70.3D, 70.3D, 0.0D));
                int var25 = (int)(var23 * (double)(var6 / 2) * 2.0D) + var6;

                for (int var26 = 0; var26 < 128; ++var26)
                {
                    int var27 = 0;
                    int var28 = var6 + 1;

                    if (this.themePARADISE)
                    {
                        var28 = var6 + 3;
                    }

                    if (!this.floating && var26 == 0)
                    {
                        var27 = Block.bedrock.blockID;
                    }
                    else if (var26 == var20 && var20 >= var28)
                    {
                        if (this.themeHELL)
                        {
                            var27 = Block.dirt.blockID;
                        }
                        else
                        {
                            var27 = Block.grass.blockID;
                        }
                    }
                    else if (var26 == var20)
                    {
                        if (var22)
                        {
                            var27 = Block.gravel.blockID;

                            if (this.themeHELL)
                            {
                                var27 = Block.grass.blockID;
                            }
                        }
                        else if (var21)
                        {
                            var27 = Block.sand.blockID;

                            if (this.themeHELL)
                            {
                                var27 = Block.grass.blockID;
                            }
                        }
                        else if (var20 > var6 - 1)
                        {
                            var27 = Block.grass.blockID;
                        }
                        else if (this.floating)
                        {
                            var27 = Block.grass.blockID;
                        }
                        else
                        {
                            var27 = Block.dirt.blockID;
                        }
                    }
                    else if (var26 <= var20 - 2)
                    {
                        var27 = Block.stone.blockID;
                    }
                    else if (var26 < var20)
                    {
                        var27 = Block.dirt.blockID;
                    }
                    else if (var26 <= 64 && !this.floating)
                    {
                        if (this.themeHELL)
                        {
                            if (var26 == 64)
                            {
                                var27 = Block.lavaMoving.blockID;
                            }
                            else
                            {
                                var27 = Block.lavaStill.blockID;
                            }
                        }
                        else
                        {
                            var27 = Block.waterStill.blockID;
                        }
                    }

                    if (this.floating && var26 < var25 && var27 != 0 && (var26 <= 60 || var27 != Block.gravel.blockID) && (var26 <= 60 || var27 != Block.sand.blockID))
                    {
                        var27 = 0;
                    }

                    this.rand.setSeed((long)(var15 + var16 * 13871));
                    int var29 = (var15 << 10) + 128 + this.rand.nextInt(512);
                    int var30 = (var16 << 10) + 128 + this.rand.nextInt(512);
                    var29 = var13 - var29;
                    int var31 = var14 - var30;

                    if (var29 < 0)
                    {
                        var29 = -var29;
                    }

                    if (var31 < 0)
                    {
                        var31 = -var31;
                    }

                    if (var31 > var29)
                    {
                        var29 = var31;
                    }

                    if ((var29 = 127 - var29) == 255)
                    {
                        var29 = 1;
                    }

                    if (var29 < var20)
                    {
                        var29 = var20;
                    }

                    if (!this.floating && var26 <= var29 && (var27 == 0 || var27 == Block.waterStill.blockID || var27 == Block.lavaStill.blockID))
                    {
                        var27 = Block.brick.blockID;
                    }

                    if (var27 < 0)
                    {
                        var27 = 0;
                    }

                    var3[var10++] = (byte)var27;
                }
            }
        }
    }

    private double clamp(double var1)
    {
        return var1 > 1.0D ? 1.0D : (var1 < -1.0D ? -1.0D : var1);
    }

    private double getNoise(int var1, int var2, int var3, double var4, double var6, double var8)
    {
        double var10 = 0.0D;

        for (double var12 = 1.0D; var12 <= (double)(var1 * var1); var12 *= 2.0D)
        {
            var10 += this.perlinGen1.a((double)var2 / var4 * var12, (double)var3 / var6 * var12) / var12;
        }

        return var10;
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
        this.generateTerrain(var1, var2, var3);
        this.biomesForGeneration = this.worldObj.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
        this.caveGenerator.generate(this, this.worldObj, var1, var2, var3);

        if (this.mapFeaturesEnabled && !this.floating)
        {
        	this.villageGenerator.generate(this, this.worldObj, var1, var2, var3);
            this.mineshaftGenerator.generate(this, this.worldObj, var1, var2, var3);
            this.strongholdGenerator.generate(this, this.worldObj, var1, var2, var3);
        }

        Chunk var4 = new Chunk(this.worldObj, var3, var1, var2);
        byte[] var5 = var4.getBiomeArray();

        for (int var6 = 0; var6 < var5.length; ++var6)
        {
            var5[var6] = (byte)this.biomesForGeneration[var6].biomeID;
        }

        var4.generateSkylightMap();
        return var4;
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
        BiomeGenBase var6 = this.worldObj.getBiomeGenForCoords(var4 + 16, var5 + 16);
        this.rand.setSeed(this.worldObj.getSeed());
        long var7 = this.rand.nextLong() / 2L * 2L + 1L;
        long var9 = this.rand.nextLong() / 2L * 2L + 1L;
        this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.getSeed());
        double var11 = 0.25D;

        if (this.mapFeaturesEnabled && !this.floating)
        {
        	this.villageGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
            this.mineshaftGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
            this.strongholdGenerator.generateStructuresInChunk(this.worldObj, this.rand, var2, var3);
        }

        int var13;
        int var14;
        int var15;
        int var16;

        if (this.floating)
        {
            if (this.rand.nextInt(30) == 0)
            {
                var13 = var4 + this.rand.nextInt(16) + 8;
                var14 = this.rand.nextInt(15);
                var15 = var5 + this.rand.nextInt(16) + 8;

                if (this.rand.nextInt(8) == 0)
                {
                    (new BWG4decoDungeons(6, false, false, true)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
                else
                {
                    (new BWG4decoDungeons(6, false, true, false)).generate(this.worldObj, this.rand, var13, var14, var15);
                }
            }
        }
        else
        {
            for (var13 = 0; var13 < 12; ++var13)
            {
                var14 = var4 + this.rand.nextInt(16) + 8;
                var15 = this.rand.nextInt(128);
                var16 = var5 + this.rand.nextInt(16) + 8;
                (new BWG4decoDungeons(5, true, false, false)).generate(this.worldObj, this.rand, var14, var15, var16);
            }
        }

        for (var13 = 0; var13 < 5; ++var13)
        {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(64);
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

        byte var23 = 0;

        if (this.floating)
        {
            var23 = 16;
        }

        int var17;

        for (var14 = 0; var14 < 2; ++var14)
        {
            var15 = var4 + this.rand.nextInt(16);
            var16 = this.rand.nextInt(32) + var23;
            var17 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.oreGold.blockID, 8, 2)).generate(this.worldObj, this.rand, var15, var16, var17);
        }

        for (var14 = 0; var14 < 8; ++var14)
        {
            var15 = var4 + this.rand.nextInt(16);
            var16 = this.rand.nextInt(16) + var23;
            var17 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.oreRedstone.blockID, 7, 2)).generate(this.worldObj, this.rand, var15, var16, var17);
        }

        for (var14 = 0; var14 < 1; ++var14)
        {
            var15 = var4 + this.rand.nextInt(16);
            var16 = this.rand.nextInt(16) + var23;
            var17 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.oreDiamond.blockID, 7, 2)).generate(this.worldObj, this.rand, var15, var16, var17);
        }

        for (var14 = 0; var14 < 1; ++var14)
        {
            var15 = var4 + this.rand.nextInt(16);
            var16 = this.rand.nextInt(16) + var23;
            var17 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.oreLapis.blockID, 6, 2)).generate(this.worldObj, this.rand, var15, var16, var17);
        }

        var11 = 0.5D;
        var14 = (int)((this.mobSpawnerNoise.func_806_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.rand.nextDouble() * 4.0D + 4.0D) / 3.0D);

        if (var14 < 0)
        {
            var14 = 0;
        }

        if (this.rand.nextInt(10) == 0)
        {
            ++var14;
        }

        if (this.themeWOODS)
        {
            var14 += 8;
        }

        BWG4oldGenTrees var24 = new BWG4oldGenTrees(0);
        int var18;

        for (var16 = 0; var16 < var14; ++var16)
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var18 = var5 + this.rand.nextInt(16) + 8;
            ((WorldGenerator)((WorldGenerator)var24)).setScale(1.0D, 1.0D, 1.0D);
            ((WorldGenerator)((WorldGenerator)var24)).generate(this.worldObj, this.rand, var17, this.worldObj.getHeightValue(var17, var18), var18);
        }

        byte var25 = 1;

        if (this.themePARADISE)
        {
            var25 = 5;
        }

        int var19;
        int var20;
        int var21;

        for (var17 = 0; var17 < var25; ++var17)
        {
            for (var18 = 0; var18 < 2; ++var18)
            {
                var19 = var4 + this.rand.nextInt(16) + 8;
                var20 = this.rand.nextInt(128);
                var21 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantYellow.blockID)).generate(this.worldObj, this.rand, var19, var20, var21);
            }

            if (this.rand.nextInt(2) == 0)
            {
                var18 = var4 + this.rand.nextInt(16) + 8;
                var19 = this.rand.nextInt(128);
                var20 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantRed.blockID)).generate(this.worldObj, this.rand, var18, var19, var20);
            }
        }

        if (!this.themeHELL && !this.themeWOODS)
        {
            if (this.rand.nextInt(4) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var18 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomBrown.blockID)).generate(this.worldObj, this.rand, var17, var18, var19);
            }

            if (this.rand.nextInt(8) == 0)
            {
                var17 = var4 + this.rand.nextInt(16) + 8;
                var18 = this.rand.nextInt(128);
                var19 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomRed.blockID)).generate(this.worldObj, this.rand, var17, var18, var19);
            }
        }
        else
        {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var18 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.mushroomBrown.blockID)).generate(this.worldObj, this.rand, var17, var18, var19);

            if (this.rand.nextInt(2) == 0)
            {
                var20 = var4 + this.rand.nextInt(16) + 8;
                var21 = this.rand.nextInt(128);
                int var22 = var5 + this.rand.nextInt(16) + 8;
                (new WorldGenFlowers(Block.mushroomRed.blockID)).generate(this.worldObj, this.rand, var20, var21, var22);
            }
        }

        for (var17 = 0; var17 < 40; ++var17)
        {
            var18 = var4 + this.rand.nextInt(16) + 8;
            var19 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var20 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(Block.waterMoving.blockID)).generate(this.worldObj, this.rand, var18, var19, var20);
        }

        for (var17 = 0; var17 < 15; ++var17)
        {
            var18 = var4 + this.rand.nextInt(16) + 8;
            var19 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
            var20 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(this.worldObj, this.rand, var18, var19, var20);
        }

        SpawnerAnimals.performWorldGenSpawning(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
        BlockSand.fallInstantly = false;

        if (this.themeSNOW)
        {
            var4 += 8;
            var5 += 8;

            for (var17 = 0; var17 < 16; ++var17)
            {
                for (var18 = 0; var18 < 16; ++var18)
                {
                    var19 = this.worldObj.getPrecipitationHeight(var4 + var17, var5 + var18);

                    if (var19 > var6.snowLevel)
                    {
                        if (this.worldObj.isBlockFreezable(var17 + var4, var19 - 1, var18 + var5))
                        {
                            this.worldObj.setBlock(var17 + var4, var19 - 1, var18 + var5, Block.ice.blockID, 0, 2);
                        }

                        if (this.worldObj.canSnowAt(var17 + var4, var19, var18 + var5))
                        {
                            this.worldObj.setBlock(var17 + var4, var19, var18 + var5, Block.snow.blockID, 0, 2);
                        }
                    }
                }
            }
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
        if (this.mapFeaturesEnabled && !this.floating)
        {
        	this.villageGenerator.generate(this, this.worldObj, var1, var2, (byte[])null);
            this.mineshaftGenerator.generate(this, this.worldObj, var1, var2, (byte[])null);
            this.strongholdGenerator.generate(this, this.worldObj, var1, var2, (byte[])null);
        }
    }

    public void func_104112_b() {}
}
