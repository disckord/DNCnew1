package net.minecraft.src;

import java.util.ArrayList;

public class BWG4LayerBiome extends GenLayer
{
    public static BiomeGenBase[] Biomes;
    public static ArrayList allowedBiomes = new ArrayList();
    public int worldID;

    public BWG4LayerBiome(long var1, GenLayer var3, WorldType var4, String[] var5, int var6, boolean var7)
    {
        super(var1);
        this.worldID = var6;
        this.parent = var3;
        Biomes = new BiomeGenBase[0];
        boolean var8 = false;

        if (var6 == 0)
        {
            if (var7)
            {
                int var9 = 0;
                allowedBiomes.clear();

                for (int var10 = 0; var10 < var5.length; ++var10)
                {
                    if (var5[var10].equals("Shrubland=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDshrubland);
                        ++var9;
                    }
                    else if (var5[var10].equals("Savanna=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDsavanna);
                        ++var9;
                    }
                    else if (var5[var10].equals("Desert=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDdesert);
                        ++var9;
                    }
                    else if (var5[var10].equals("Swampland=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDswampland);
                        ++var9;
                    }
                    else if (var5[var10].equals("Jungle=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDjungle);
                        ++var9;
                    }
                    else if (var5[var10].equals("RainForest=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDrainforest);
                        ++var9;
                    }
                    else if (var5[var10].equals("Grassland=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDgrassland);
                        ++var9;
                    }
                    else if (var5[var10].equals("Taiga=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDtaiga);
                        ++var9;
                    }
                    else if (var5[var10].equals("Pines=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDpines);
                        ++var9;
                    }
                    else if (var5[var10].equals("Forest Lakes=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDforestlakes);
                        ++var9;
                    }
                    else if (var5[var10].equals("Forest Hills=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDforesthills);
                        ++var9;
                    }
                    else if (var5[var10].equals("Forest=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDforest);
                        ++var9;
                    }
                    else if (var5[var10].equals("Plains=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDplains);
                        ++var9;
                    }
                    else if (var5[var10].equals("Snow Hills=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDsnowhills);
                        ++var9;
                    }
                    else if (var5[var10].equals("Snow Plains=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDsnowplains);
                        ++var9;
                    }
                    else if (var5[var10].equals("Snow Taiga=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDsnowtaiga);
                        ++var9;
                    }
                    else if (var5[var10].equals("Snow Forest=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDsnowforest);
                        ++var9;
                    }
                    else if (var5[var10].equals("Snow Pines=true"))
                    {
                        allowedBiomes.add(BiomeGenBase.BDsnowpines);
                        ++var9;
                    }
                    else if (var5[var10].equals("Ocean=true"))
                    {
                        var8 = true;
                    }
                }

                if (var9 == 0)
                {
                    if (var8)
                    {
                        allowedBiomes.add(BiomeGenBase.BDocean);
                    }
                    else
                    {
                        allowedBiomes.add(BiomeGenBase.BDplains);
                    }
                }

                Biomes = (BiomeGenBase[])allowedBiomes.toArray(new BiomeGenBase[0]);
            }
            else
            {
                allowedBiomes.clear();
                allowedBiomes.add(BiomeGenBase.plains);
                Biomes = (BiomeGenBase[])allowedBiomes.toArray(new BiomeGenBase[0]);
            }
        }
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int var1, int var2, int var3, int var4)
    {
        int[] var5 = this.parent.getInts(var1, var2, var3, var4);
        int[] var6 = IntCache.getIntCache(var3 * var4);

        for (int var7 = 0; var7 < var4; ++var7)
        {
            for (int var8 = 0; var8 < var3; ++var8)
            {
                this.initChunkSeed((long)(var8 + var1), (long)(var7 + var2));
                int var9 = var5[var8 + var7 * var3];

                if (var9 == 0)
                {
                    var6[var8 + var7 * var3] = BiomeGenBase.BDocean.biomeID;
                }
                else if (var9 == BiomeGenBase.mushroomIsland.biomeID)
                {
                    var6[var8 + var7 * var3] = BiomeGenBase.mushroomIsland.biomeID;
                }
                else
                {
                    var6[var8 + var7 * var3] = Biomes[this.nextInt(Biomes.length)].biomeID;
                }
            }
        }

        return var6;
    }
}
