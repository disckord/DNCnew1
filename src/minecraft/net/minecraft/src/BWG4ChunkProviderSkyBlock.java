package net.minecraft.src;

import java.util.List;
import java.util.Random;

public class BWG4ChunkProviderSkyBlock implements IChunkProvider
{
    private Random endRNG;
    private World endWorld;
    private double[] densities;
    private BiomeGenBase[] biomesForGeneration;
    int[][] field_73203_h = new int[32][32];
    int getSize = 1;
    private boolean isNether = false;
    private boolean themeClassic = false;
    private boolean themeExtended = false;
    private boolean themeEndless = false;

    public BWG4ChunkProviderSkyBlock(World var1, long var2, boolean var4, int var5)
    {
        this.endWorld = var1;
        this.endRNG = new Random(var2);
        this.isNether = var4;

        if (var5 == 1)
        {
            this.themeClassic = true;
        }
        else if (var5 == 2)
        {
            this.themeExtended = true;
        }
        else if (var5 == 3)
        {
            this.themeEndless = true;
        }
        else
        {
            this.themeClassic = true;
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
        Chunk var4 = new Chunk(this.endWorld, var3, var1, var2);
        byte[] var5 = var4.getBiomeArray();
        this.biomesForGeneration = this.endWorld.getWorldChunkManager().loadBlockGeneratorData(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);

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
        int var4 = var2 * 16;
        int var5 = var3 * 16;
        BiomeGenBase var6 = this.endWorld.getBiomeGenForCoords(var4 + 16, var5 + 16);
        var6.decorate(this.endWorld, this.endWorld.rand, var4, var5);

        if (this.themeEndless)
        {
            if (var2 == 0 && var3 == 0)
            {
                (new BWG4decoSurvival(6)).generate(this.endWorld, this.endRNG, 0, 70, 0);
            }
            else
            {
                if (this.endRNG.nextInt(8) == 0)
                {
                    (new BWG4decoSurvival(20 + this.endRNG.nextInt(2))).generate(this.endWorld, this.endRNG, var4 + this.endRNG.nextInt(16), 5 + this.endRNG.nextInt(240), var5 + this.endRNG.nextInt(16));
                }

                if (this.endRNG.nextInt(15) == 0)
                {
                    (new BWG4decoSurvival(20 + this.endRNG.nextInt(4))).generate(this.endWorld, this.endRNG, var4 + this.endRNG.nextInt(16), 5 + this.endRNG.nextInt(60), var5 + this.endRNG.nextInt(16));
                }

                if (this.endRNG.nextInt(30) == 0)
                {
                    (new BWG4decoSurvival(24 + this.endRNG.nextInt(3))).generate(this.endWorld, this.endRNG, var4 + this.endRNG.nextInt(16), 5 + this.endRNG.nextInt(40), var5 + this.endRNG.nextInt(16));
                }
            }
        }
        else if (var2 == 0 && var3 == 0)
        {
            if (this.isNether)
            {
                if (this.themeClassic)
                {
                    (new BWG4decoSurvival(8)).generate(this.endWorld, this.endRNG, 10, 80, 0);
                }

                if (this.themeExtended)
                {
                    (new BWG4decoSurvival(8)).generate(this.endWorld, this.endRNG, 10, 80, 0);
                    (new BWG4decoSurvival(12)).generate(this.endWorld, this.endRNG, 30, 80, 20);
                }
            }
            else
            {
                if (this.themeClassic)
                {
                    (new BWG4decoSurvival(6)).generate(this.endWorld, this.endRNG, 0, 70, 0);
                    (new BWG4decoSurvival(7)).generate(this.endWorld, this.endRNG, 0, 80, 60);
                }

                if (this.themeExtended)
                {
                    (new BWG4decoSurvival(6)).generate(this.endWorld, this.endRNG, 0, 70, 0);
                    (new BWG4decoSurvival(7)).generate(this.endWorld, this.endRNG, 0, 80, 60);
                    (new BWG4decoSurvival(9)).generate(this.endWorld, this.endRNG, 0, 78, -80);
                    (new BWG4decoSurvival(10)).generate(this.endWorld, this.endRNG, 80, 78, 0);
                    (new BWG4decoSurvival(11)).generate(this.endWorld, this.endRNG, -80, 78, 0);
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

    public void func_104112_b() {}

    public void recreateStructures(int var1, int var2) {}
}
