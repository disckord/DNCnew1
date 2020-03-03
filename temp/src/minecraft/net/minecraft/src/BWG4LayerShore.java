package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class BWG4LayerShore extends GenLayer {

   private int shoreID;
   private boolean beachdunes = false;
   private boolean beach = false;


   public BWG4LayerShore(long var1, GenLayer var3, int var4, String[] var5, boolean var6) {
      super(var1);
      this.field_75909_a = var3;
      this.shoreID = var4;
      if(var6) {
         for(int var7 = 0; var7 < var5.length; ++var7) {
            if(var5[var7].equals("Beach Dunes=true")) {
               this.beachdunes = true;
            } else if(var5[var7].equals("Beach=true")) {
               this.beach = true;
            }
         }
      }

   }

   public int[] func_75904_a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.field_75909_a.func_75904_a(var1 - 1, var2 - 1, var3 + 2, var4 + 2);
      int[] var6 = IntCache.func_76445_a(var3 * var4);

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var3; ++var8) {
            this.func_75903_a((long)(var8 + var1), (long)(var7 + var2));
            int var9 = var5[var8 + 1 + (var7 + 1) * (var3 + 2)];
            var6[var8 + var7 * var3] = var9;
            int var10;
            int var11;
            int var12;
            int var13;
            if(this.shoreID == 2 && this.beachdunes) {
               if(var9 != BiomeGenBase.BDocean.field_76756_M && var9 != BiomeGenBase.BDbeach.field_76756_M && var9 != BiomeGenBase.BDsnowpines.field_76756_M && var9 != BiomeGenBase.BDsnowforest.field_76756_M && var9 != BiomeGenBase.BDsnowtaiga.field_76756_M && var9 != BiomeGenBase.BDsnowplains.field_76756_M && var9 != BiomeGenBase.BDsnowhills.field_76756_M) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 == BiomeGenBase.BDbeach.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.field_76756_M;
                  } else if(var11 == BiomeGenBase.BDbeach.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.field_76756_M;
                  } else if(var12 == BiomeGenBase.BDbeach.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.field_76756_M;
                  } else if(var13 == BiomeGenBase.BDbeach.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeachDunes.field_76756_M;
                  }
               }
            } else if(this.shoreID == 1) {
               if(var9 == BiomeGenBase.BDdesert.field_76756_M || var9 == BiomeGenBase.BDsavanna.field_76756_M || var9 == BiomeGenBase.BDsavannaforest.field_76756_M || var9 == BiomeGenBase.BDshrubland.field_76756_M || var9 == BiomeGenBase.BDswampland.field_76756_M || var9 == BiomeGenBase.BDjungle.field_76756_M || var9 == BiomeGenBase.BDrainforest.field_76756_M || var9 == BiomeGenBase.BDshrublandHill.field_76756_M) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != BiomeGenBase.BDsnowpines.field_76756_M && var10 != BiomeGenBase.BDsnowforest.field_76756_M && var10 != BiomeGenBase.BDsnowtaiga.field_76756_M && var10 != BiomeGenBase.BDsnowplains.field_76756_M && var10 != BiomeGenBase.BDsnowhills.field_76756_M) {
                     if(var11 != BiomeGenBase.BDsnowpines.field_76756_M && var11 != BiomeGenBase.BDsnowforest.field_76756_M && var11 != BiomeGenBase.BDsnowtaiga.field_76756_M && var11 != BiomeGenBase.BDsnowplains.field_76756_M && var11 != BiomeGenBase.BDsnowhills.field_76756_M) {
                        if(var12 != BiomeGenBase.BDsnowpines.field_76756_M && var12 != BiomeGenBase.BDsnowforest.field_76756_M && var12 != BiomeGenBase.BDsnowtaiga.field_76756_M && var12 != BiomeGenBase.BDsnowplains.field_76756_M && var12 != BiomeGenBase.BDsnowhills.field_76756_M) {
                           if(var13 == BiomeGenBase.BDsnowpines.field_76756_M || var13 == BiomeGenBase.BDsnowforest.field_76756_M || var13 == BiomeGenBase.BDsnowtaiga.field_76756_M || var13 == BiomeGenBase.BDsnowplains.field_76756_M || var13 == BiomeGenBase.BDsnowhills.field_76756_M) {
                              var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                           }
                        } else {
                           var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                        }
                     } else {
                        var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                     }
                  } else {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                  }
               }

               if(var9 == BiomeGenBase.BDsnowpines.field_76756_M || var9 == BiomeGenBase.BDsnowforest.field_76756_M || var9 == BiomeGenBase.BDsnowtaiga.field_76756_M || var9 == BiomeGenBase.BDsnowplains.field_76756_M || var9 == BiomeGenBase.BDsnowhills.field_76756_M) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 != BiomeGenBase.BDdesert.field_76756_M && var10 != BiomeGenBase.BDsavanna.field_76756_M && var10 != BiomeGenBase.BDsavannaforest.field_76756_M && var10 != BiomeGenBase.BDshrubland.field_76756_M && var10 != BiomeGenBase.BDswampland.field_76756_M && var10 != BiomeGenBase.BDjungle.field_76756_M && var10 != BiomeGenBase.BDrainforest.field_76756_M && var10 != BiomeGenBase.BDshrublandHill.field_76756_M) {
                     if(var11 != BiomeGenBase.BDdesert.field_76756_M && var11 != BiomeGenBase.BDsavanna.field_76756_M && var11 != BiomeGenBase.BDsavannaforest.field_76756_M && var11 != BiomeGenBase.BDshrubland.field_76756_M && var11 != BiomeGenBase.BDswampland.field_76756_M && var11 != BiomeGenBase.BDjungle.field_76756_M && var11 != BiomeGenBase.BDrainforest.field_76756_M && var11 != BiomeGenBase.BDshrublandHill.field_76756_M) {
                        if(var12 != BiomeGenBase.BDdesert.field_76756_M && var12 != BiomeGenBase.BDsavanna.field_76756_M && var12 != BiomeGenBase.BDsavannaforest.field_76756_M && var12 != BiomeGenBase.BDshrubland.field_76756_M && var12 != BiomeGenBase.BDswampland.field_76756_M && var12 != BiomeGenBase.BDjungle.field_76756_M && var12 != BiomeGenBase.BDrainforest.field_76756_M && var12 != BiomeGenBase.BDshrublandHill.field_76756_M) {
                           if(var13 == BiomeGenBase.BDdesert.field_76756_M || var13 == BiomeGenBase.BDsavanna.field_76756_M || var13 == BiomeGenBase.BDsavannaforest.field_76756_M || var13 == BiomeGenBase.BDshrubland.field_76756_M || var13 == BiomeGenBase.BDswampland.field_76756_M || var13 == BiomeGenBase.BDjungle.field_76756_M || var13 == BiomeGenBase.BDrainforest.field_76756_M || var13 == BiomeGenBase.BDshrublandHill.field_76756_M) {
                              var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                           }
                        } else {
                           var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                        }
                     } else {
                        var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                     }
                  } else {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDforest.field_76756_M;
                  }
               }

               if(this.beach && var9 != BiomeGenBase.BDmushroomisland.field_76756_M && var9 != BiomeGenBase.BDjungleisland.field_76756_M && var9 != BiomeGenBase.BDtropicalisland.field_76756_M && var9 != BiomeGenBase.BDocean.field_76756_M && var9 != BiomeGenBase.BDsnowpines.field_76756_M && var9 != BiomeGenBase.BDsnowforest.field_76756_M && var9 != BiomeGenBase.BDsnowtaiga.field_76756_M && var9 != BiomeGenBase.BDsnowplains.field_76756_M && var9 != BiomeGenBase.BDsnowhills.field_76756_M) {
                  var10 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  var11 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  var12 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  var13 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var10 == BiomeGenBase.BDocean.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.field_76756_M;
                  } else if(var11 == BiomeGenBase.BDocean.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.field_76756_M;
                  } else if(var12 == BiomeGenBase.BDocean.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.field_76756_M;
                  } else if(var13 == BiomeGenBase.BDocean.field_76756_M) {
                     var6[var8 + var7 * var3] = BiomeGenBase.BDbeach.field_76756_M;
                  }
               }
            } else {
               var6[var8 + var7 * var3] = var9;
            }
         }
      }

      return var6;
   }
}
