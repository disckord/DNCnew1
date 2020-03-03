package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class BWG4LayerHills extends GenLayer {

   private boolean IslandMushroom = false;
   private boolean IslandJungle = false;
   private boolean IslandTropic = false;


   public BWG4LayerHills(long var1, GenLayer var3, String[] var4, boolean var5) {
      super(var1);
      this.field_75909_a = var3;
      if(var5) {
         for(int var6 = 0; var6 < var4.length; ++var6) {
            if(var4[var6].equals("Mushroom Island=true")) {
               this.IslandMushroom = true;
            } else if(var4[var6].equals("Jungle Island=true")) {
               this.IslandJungle = true;
            } else if(var4[var6].equals("Tropical Island=true")) {
               this.IslandTropic = true;
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
            if(this.func_75902_a(5) == 0) {
               int var10 = var9;
               if(var9 == BiomeGenBase.BDsavanna.field_76756_M) {
                  var10 = BiomeGenBase.BDsavannaforest.field_76756_M;
               } else if(var9 == BiomeGenBase.BDshrubland.field_76756_M) {
                  var10 = BiomeGenBase.BDshrublandHill.field_76756_M;
               } else if(var9 == BiomeGenBase.BDocean.field_76756_M) {
                  if(this.func_75902_a(30) == 0 && this.IslandMushroom) {
                     var10 = BiomeGenBase.BDmushroomisland.field_76756_M;
                  } else if(this.func_75902_a(8) == 0 && this.IslandJungle) {
                     var10 = BiomeGenBase.BDjungleisland.field_76756_M;
                  } else if(this.func_75902_a(5) == 0 && this.IslandTropic) {
                     var10 = BiomeGenBase.BDtropicalisland.field_76756_M;
                  } else {
                     var10 = var9;
                  }
               }

               if(var10 == var9) {
                  var6[var8 + var7 * var3] = var9;
               } else {
                  int var11 = var5[var8 + 1 + (var7 + 1 - 1) * (var3 + 2)];
                  int var12 = var5[var8 + 1 + 1 + (var7 + 1) * (var3 + 2)];
                  int var13 = var5[var8 + 1 - 1 + (var7 + 1) * (var3 + 2)];
                  int var14 = var5[var8 + 1 + (var7 + 1 + 1) * (var3 + 2)];
                  if(var11 == var9 && var12 == var9 && var13 == var9 && var14 == var9) {
                     var6[var8 + var7 * var3] = var10;
                  } else {
                     var6[var8 + var7 * var3] = var9;
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
