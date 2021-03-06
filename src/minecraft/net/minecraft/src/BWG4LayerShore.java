package net.minecraft.src;

public class BWG4LayerShore extends GenLayer
{
    private int shoreID;
    private boolean beachdunes = false;
    private boolean beach = false;

    public BWG4LayerShore(long var1, GenLayer var3, int var4, String[] var5, boolean var6)
    {
        super(var1);
        this.parent = var3;
        this.shoreID = var4;

        if (var6)
        {
            for (int var7 = 0; var7 < var5.length; ++var7)
            {
                if (var5[var7].equals("Beach Dunes=true"))
                {
                    this.beachdunes = true;
                }
                else if (var5[var7].equals("Beach=true"))
                {
                    this.beach = true;
                }
            }
        }
    }

    /**
     * Returns a list of integer values generated by this layer. These may be interpreted as temperatures, rainfall
     * amounts, or biomeList[] indices based on the particular GenLayer subclass.
     */
    public int[] getInts(int var1, int var2, int var3, int var4)
    {
        int[] var5 = this.parent.getInts(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
        int[] var6 = IntCache.getIntCache(var3 * var4);

        for (int var7 = 0; var7 < var4; ++var7)
        {
            for (int var8 = 0; var8 < var3; ++var8)
            {
                this.initChunkSeed((long)(var8 + var1), (long)(var7 + var2));
                int var9 = var5[var8 + 1 + (var7 + 1) * (var3 + 2)];
                var6[var8 + var7 * var3] = var9;
                int var10;
                int var11;
                int var12;
                int var13;

                if (this.shoreID == 2 && this.beachdunes)
                {
                    if (var9 != BiomeGenBase.BDocean.biomeID && var9 != BiomeGenBase.BDbeach.biomeID && var9 != BiomeGenBase.BDsnowpines.biomeID && var9 != BiomeGenBase.BDsnowforest.biomeID && var9 != BiomeGenBase.BDsnowtaiga.biomeID && var9 != BiomeGenBase.BDsnowplains.biomeID && var9 != BiomeGenBase.BDsnowhills.biomeID)
                    {
                        var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                        var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                        var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                        var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];

                        if (var10 == BiomeGenBase.BDbeach.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.biomeID;
                        }
                        else if (var11 == BiomeGenBase.BDbeach.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.biomeID;
                        }
                        else if (var12 == BiomeGenBase.BDbeach.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.biomeID;
                        }
                        else if (var13 == BiomeGenBase.BDbeach.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.biomeID;
                        }
                    }
                }
                else if (this.shoreID == 1)
                {
                    if (var9 == BiomeGenBase.BDdesert.biomeID || var9 == BiomeGenBase.BDsavanna.biomeID || var9 == BiomeGenBase.BDsavannaforest.biomeID || var9 == BiomeGenBase.BDshrubland.biomeID || var9 == BiomeGenBase.BDswampland.biomeID || var9 == BiomeGenBase.BDjungle.biomeID || var9 == BiomeGenBase.BDrainforest.biomeID || var9 == BiomeGenBase.BDshrublandHill.biomeID)
                    {
                        var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                        var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                        var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                        var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];

                        if (var10 != BiomeGenBase.BDsnowpines.biomeID && var10 != BiomeGenBase.BDsnowforest.biomeID && var10 != BiomeGenBase.BDsnowtaiga.biomeID && var10 != BiomeGenBase.BDsnowplains.biomeID && var10 != BiomeGenBase.BDsnowhills.biomeID)
                        {
                            if (var11 != BiomeGenBase.BDsnowpines.biomeID && var11 != BiomeGenBase.BDsnowforest.biomeID && var11 != BiomeGenBase.BDsnowtaiga.biomeID && var11 != BiomeGenBase.BDsnowplains.biomeID && var11 != BiomeGenBase.BDsnowhills.biomeID)
                            {
                                if (var12 != BiomeGenBase.BDsnowpines.biomeID && var12 != BiomeGenBase.BDsnowforest.biomeID && var12 != BiomeGenBase.BDsnowtaiga.biomeID && var12 != BiomeGenBase.BDsnowplains.biomeID && var12 != BiomeGenBase.BDsnowhills.biomeID)
                                {
                                    if (var13 == BiomeGenBase.BDsnowpines.biomeID || var13 == BiomeGenBase.BDsnowforest.biomeID || var13 == BiomeGenBase.BDsnowtaiga.biomeID || var13 == BiomeGenBase.BDsnowplains.biomeID || var13 == BiomeGenBase.BDsnowhills.biomeID)
                                    {
                                        var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                                    }
                                }
                                else
                                {
                                    var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                                }
                            }
                            else
                            {
                                var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                            }
                        }
                        else
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                        }
                    }

                    if (var9 == BiomeGenBase.BDsnowpines.biomeID || var9 == BiomeGenBase.BDsnowforest.biomeID || var9 == BiomeGenBase.BDsnowtaiga.biomeID || var9 == BiomeGenBase.BDsnowplains.biomeID || var9 == BiomeGenBase.BDsnowhills.biomeID)
                    {
                        var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                        var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                        var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                        var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];

                        if (var10 != BiomeGenBase.BDdesert.biomeID && var10 != BiomeGenBase.BDsavanna.biomeID && var10 != BiomeGenBase.BDsavannaforest.biomeID && var10 != BiomeGenBase.BDshrubland.biomeID && var10 != BiomeGenBase.BDswampland.biomeID && var10 != BiomeGenBase.BDjungle.biomeID && var10 != BiomeGenBase.BDrainforest.biomeID && var10 != BiomeGenBase.BDshrublandHill.biomeID)
                        {
                            if (var11 != BiomeGenBase.BDdesert.biomeID && var11 != BiomeGenBase.BDsavanna.biomeID && var11 != BiomeGenBase.BDsavannaforest.biomeID && var11 != BiomeGenBase.BDshrubland.biomeID && var11 != BiomeGenBase.BDswampland.biomeID && var11 != BiomeGenBase.BDjungle.biomeID && var11 != BiomeGenBase.BDrainforest.biomeID && var11 != BiomeGenBase.BDshrublandHill.biomeID)
                            {
                                if (var12 != BiomeGenBase.BDdesert.biomeID && var12 != BiomeGenBase.BDsavanna.biomeID && var12 != BiomeGenBase.BDsavannaforest.biomeID && var12 != BiomeGenBase.BDshrubland.biomeID && var12 != BiomeGenBase.BDswampland.biomeID && var12 != BiomeGenBase.BDjungle.biomeID && var12 != BiomeGenBase.BDrainforest.biomeID && var12 != BiomeGenBase.BDshrublandHill.biomeID)
                                {
                                    if (var13 == BiomeGenBase.BDdesert.biomeID || var13 == BiomeGenBase.BDsavanna.biomeID || var13 == BiomeGenBase.BDsavannaforest.biomeID || var13 == BiomeGenBase.BDshrubland.biomeID || var13 == BiomeGenBase.BDswampland.biomeID || var13 == BiomeGenBase.BDjungle.biomeID || var13 == BiomeGenBase.BDrainforest.biomeID || var13 == BiomeGenBase.BDshrublandHill.biomeID)
                                    {
                                        var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                                    }
                                }
                                else
                                {
                                    var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                                }
                            }
                            else
                            {
                                var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                            }
                        }
                        else
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDforest.biomeID;
                        }
                    }

                    if (this.beach && var9 != BiomeGenBase.BDmushroomisland.biomeID && var9 != BiomeGenBase.BDjungleisland.biomeID && var9 != BiomeGenBase.BDtropicalisland.biomeID && var9 != BiomeGenBase.BDocean.biomeID && var9 != BiomeGenBase.BDsnowpines.biomeID && var9 != BiomeGenBase.BDsnowforest.biomeID && var9 != BiomeGenBase.BDsnowtaiga.biomeID && var9 != BiomeGenBase.BDsnowplains.biomeID && var9 != BiomeGenBase.BDsnowhills.biomeID)
                    {
                        var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                        var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                        var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                        var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];

                        if (var10 == BiomeGenBase.BDocean.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.biomeID;
                        }
                        else if (var11 == BiomeGenBase.BDocean.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.biomeID;
                        }
                        else if (var12 == BiomeGenBase.BDocean.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.biomeID;
                        }
                        else if (var13 == BiomeGenBase.BDocean.biomeID)
                        {
                            var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.biomeID;
                        }
                    }
                }
                else
                {
                    var6[var8 + var7 * var3] = var9;
                }
            }
        }

        return var6;
    }
}
