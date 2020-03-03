package net.minecraft.src;

public abstract class GenLayer
{
    /** seed from World#getWorldSeed that is used in the LCG prng */
    private long worldGenSeed;

    /** parent GenLayer that was provided via the constructor */
    protected GenLayer parent;

    /**
     * final part of the LCG prng that uses the chunk X, Z coords along with the other two seeds to generate
     * pseudorandom numbers
     */
    private long chunkSeed;

    /** base seed to the LCG prng provided via the constructor */
    private long baseSeed;
    private static String[] generatorSettings;
    private static boolean isRemote = false;

    public static GenLayer[] initializeAllBiomeGenerators(long var0, WorldType var2, String var3, boolean var4)
    {
        if (!isRemote)
        {
            isRemote = var4;
        }

        GenLayerZoom var34;

        if (var2 != WorldType.BWG4DEFAULT && var2 != WorldType.BWG4LARGE)
        {
            GenLayerIsland var29 = new GenLayerIsland(1L);
            GenLayerFuzzyZoom var26 = new GenLayerFuzzyZoom(2000L, var29);
            GenLayerAddIsland var32 = new GenLayerAddIsland(1L, var26);
            var34 = new GenLayerZoom(2001L, var32);
            var32 = new GenLayerAddIsland(2L, var34);
            GenLayerAddSnow var37 = new GenLayerAddSnow(2L, var32);
            var34 = new GenLayerZoom(2002L, var37);
            var32 = new GenLayerAddIsland(3L, var34);
            var34 = new GenLayerZoom(2003L, var32);
            var32 = new GenLayerAddIsland(4L, var34);
            GenLayerAddMushroomIsland var39 = new GenLayerAddMushroomIsland(5L, var32);
            byte var11 = 4;

            if (var2 == WorldType.LARGE_BIOMES)
            {
                var11 = 6;
            }

            GenLayer var12 = GenLayerZoom.magnify(1000L, var39, 0);
            GenLayerRiverInit var13 = new GenLayerRiverInit(100L, var12);
            var12 = GenLayerZoom.magnify(1000L, var13, var11 + 2);
            GenLayerRiver var14 = new GenLayerRiver(1L, var12);
            GenLayerSmooth var15 = new GenLayerSmooth(1000L, var14);
            GenLayer var16 = GenLayerZoom.magnify(1000L, var39, 0);
            GenLayerBiome var17 = new GenLayerBiome(200L, var16, var2);
            var16 = GenLayerZoom.magnify(1000L, var17, 2);
            Object var18 = new GenLayerHills(1000L, var16);

            for (int var19 = 0; var19 < var11; ++var19)
            {
                var18 = new GenLayerZoom((long)(1000 + var19), (GenLayer)var18);

                if (var19 == 0)
                {
                    var18 = new GenLayerAddIsland(3L, (GenLayer)var18);
                }

                if (var19 == 1)
                {
                    var18 = new GenLayerShore(1000L, (GenLayer)var18);
                }

                if (var19 == 1)
                {
                    var18 = new GenLayerSwampRivers(1000L, (GenLayer)var18);
                }
            }

            GenLayerSmooth var42 = new GenLayerSmooth(1000L, (GenLayer)var18);
            GenLayerRiverMix var20 = new GenLayerRiverMix(100L, var42, var15);
            GenLayerVoronoiZoom var21 = new GenLayerVoronoiZoom(10L, var20);
            var20.initWorldGenSeed(var0);
            var21.initWorldGenSeed(var0);
            return new GenLayer[] {var20, var21, var20};
        }
        else
        {
            if (var3.length() > 3)
            {
                String[] var5 = var3.split("&");
                generatorSettings = var5[1].split(";");
            }

            BWG4LayerCreate var22 = new BWG4LayerCreate(1L, generatorSettings, isRemote);
            GenLayerFuzzyZoom var23 = new GenLayerFuzzyZoom(2000L, var22);
            GenLayerAddIsland var24 = new GenLayerAddIsland(1L, var23);
            GenLayerZoom var25 = new GenLayerZoom(2001L, var24);
            var24 = new GenLayerAddIsland(2L, var25);
            var25 = new GenLayerZoom(2002L, var24);
            var24 = new GenLayerAddIsland(3L, var25);
            var25 = new GenLayerZoom(2003L, var24);
            var24 = new GenLayerAddIsland(4L, var25);
            byte var6 = 4;

            if (var2 == WorldType.BWG4LARGE)
            {
                var6 = 6;
            }

            GenLayer var7 = GenLayerZoom.magnify(1000L, var24, 0);
            GenLayerRiverInit var27 = new GenLayerRiverInit(100L, var7);
            var7 = GenLayerZoom.magnify(1000L, var27, var6 + 2);
            GenLayerRiver var28 = new GenLayerRiver(1L, var7);
            GenLayerSmooth var30 = new GenLayerSmooth(1000L, var28);
            GenLayer var8 = GenLayerZoom.magnify(1000L, var24, 0);
            BWG4LayerBiome var31 = new BWG4LayerBiome(200L, var8, var2, generatorSettings, 0, isRemote);
            var8 = GenLayerZoom.magnify(1000L, var31, 2);
            BWG4LayerHills var33 = new BWG4LayerHills(1000L, var8, generatorSettings, isRemote);
            var34 = new GenLayerZoom(1000L, var33);
            BWG4LayerShore var35 = new BWG4LayerShore(1000L, var34, 1, generatorSettings, isRemote);
            Object var38 = new BWG4LayerShore(1000L, var35, 2, generatorSettings, isRemote);

            for (int var9 = 1; var9 < var6; ++var9)
            {
                var38 = new GenLayerZoom((long)(1000 + var9), (GenLayer)var38);
            }

            GenLayerSmooth var40 = new GenLayerSmooth(1000L, (GenLayer)var38);
            BWG4LayerRiverMix var41 = new BWG4LayerRiverMix(100L, var40, var30);
            BWG4LayerRiverMix var36 = (BWG4LayerRiverMix)((BWG4LayerRiverMix)var41);
            GenLayerVoronoiZoom var10 = new GenLayerVoronoiZoom(10L, var41);
            var41.initWorldGenSeed(var0);
            var10.initWorldGenSeed(var0);
            return new GenLayer[] {var41, var10, var36};
        }
    }

    /**
     * the first array item is a linked list of the bioms, the second is the zoom function, the third is the same as the
     * first.
     */
    public static GenLayer[] initializeAllBiomeGenerators(long par0, WorldType par2WorldType)
    {
        GenLayerIsland var3 = new GenLayerIsland(1L);
        GenLayerFuzzyZoom var4 = new GenLayerFuzzyZoom(2000L, var3);
        GenLayerAddIsland var5 = new GenLayerAddIsland(1L, var4);
        GenLayerZoom var6 = new GenLayerZoom(2001L, var5);
        var5 = new GenLayerAddIsland(2L, var6);
        GenLayerAddSnow var7 = new GenLayerAddSnow(2L, var5);
        var6 = new GenLayerZoom(2002L, var7);
        var5 = new GenLayerAddIsland(3L, var6);
        var6 = new GenLayerZoom(2003L, var5);
        var5 = new GenLayerAddIsland(4L, var6);
        GenLayerAddMushroomIsland var8 = new GenLayerAddMushroomIsland(5L, var5);
        byte var9 = 4;

        if (par2WorldType == WorldType.LARGE_BIOMES)
        {
            var9 = 6;
        }

        GenLayer var10 = GenLayerZoom.magnify(1000L, var8, 0);
        GenLayerRiverInit var11 = new GenLayerRiverInit(100L, var10);
        var10 = GenLayerZoom.magnify(1000L, var11, var9 + 2);
        GenLayerRiver var12 = new GenLayerRiver(1L, var10);
        GenLayerSmooth var13 = new GenLayerSmooth(1000L, var12);
        GenLayer var14 = GenLayerZoom.magnify(1000L, var8, 0);
        GenLayerBiome var15 = new GenLayerBiome(200L, var14, par2WorldType);
        var14 = GenLayerZoom.magnify(1000L, var15, 2);
        Object var16 = new GenLayerHills(1000L, var14);

        for (int var17 = 0; var17 < var9; ++var17)
        {
            var16 = new GenLayerZoom((long)(1000 + var17), (GenLayer)var16);

            if (var17 == 0)
            {
                var16 = new GenLayerAddIsland(3L, (GenLayer)var16);
            }

            if (var17 == 1)
            {
                var16 = new GenLayerShore(1000L, (GenLayer)var16);
            }

            if (var17 == 1)
            {
                var16 = new GenLayerSwampRivers(1000L, (GenLayer)var16);
            }
        }

        GenLayerSmooth var20 = new GenLayerSmooth(1000L, (GenLayer)var16);
        GenLayerRiverMix var18 = new GenLayerRiverMix(100L, var20, var13);
        GenLayerVoronoiZoom var19 = new GenLayerVoronoiZoom(10L, var18);
        var18.initWorldGenSeed(par0);
        var19.initWorldGenSeed(par0);
        return new GenLayer[] {var18, var19, var18};
    }

    public GenLayer(long par1)
    {
        this.baseSeed = par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
        this.baseSeed *= this.baseSeed * 6364136223846793005L + 1442695040888963407L;
        this.baseSeed += par1;
    }

    /**
     * Initialize layer's local worldGenSeed based on its own baseSeed and the world's global seed (passed in as an
     * argument).
     */
    public void initWorldGenSeed(long par1)
    {
        this.worldGenSeed = par1;

        if (this.parent != null)
        {
            this.parent.initWorldGenSeed(par1);
        }

        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
        this.worldGenSeed *= this.worldGenSeed * 6364136223846793005L + 1442695040888963407L;
        this.worldGenSeed += this.baseSeed;
    }

    /**
     * Initialize layer's current chunkSeed based on the local worldGenSeed and the (x,z) chunk coordinates.
     */
    public void initChunkSeed(long par1, long par3)
    {
        this.chunkSeed = this.worldGenSeed;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par3;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par1;
        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += par3;
    }

    /**
     * returns a LCG pseudo random number from [0, x). Args: int x
     */
    protected int nextInt(int par1)
    {
        int var2 = (int)((this.chunkSeed >> 24) % (long)par1);

        if (var2 < 0)
        {
            var2 += par1;
        }

        this.chunkSeed *= this.chunkSeed * 6364136223846793005L + 1442695040888963407L;
        this.chunkSeed += this.worldGenSeed;
        return var2;
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public abstract int[] getInts(int var1, int var2, int var3, int var4);
}
