package net.minecraft.src;

import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class BWG4LayerRegion extends GenLayer {

   public BWG4LayerRegion(long var1, GenLayer var3) {
      super(var1);
      this.field_75909_a = var3;
   }

   public int[] func_75904_a(int var1, int var2, int var3, int var4) {
      int var5 = var1 - 1;
      int var6 = var2 - 1;
      int var7 = var3 + 2;
      int var8 = var4 + 2;
      int[] var9 = this.field_75909_a.func_75904_a(var5, var6, var7, var8);
      int[] var10 = IntCache.func_76445_a(var3 * var4);

      for(int var11 = 0; var11 < var4; ++var11) {
         for(int var12 = 0; var12 < var3; ++var12) {
            int var10000 = var9[var12 + 1 + (var11 + 1) * var7];
            this.func_75903_a((long)(var12 + var1), (long)(var11 + var2));
            int var14 = var9[var12 + 1 + (var11 + 1 - 1) * (var3 + 2)];
            int var15 = var9[var12 + 1 + 1 + (var11 + 1) * (var3 + 2)];
            int var16 = var9[var12 + 1 - 1 + (var11 + 1) * (var3 + 2)];
            int var17 = var9[var12 + 1 + (var11 + 1 + 1) * (var3 + 2)];
            int var18 = this.func_75902_a(2);
            int var19;
            if(var18 == 0) {
               var19 = this.func_75902_a(2);
               if(var19 == 0 && var14 != 2 && var14 != 3 && var15 != 2 && var15 != 3 && var16 != 2 && var16 != 3 && var17 != 2 && var17 != 3) {
                  var10[var12 + var11 * var3] = 0;
               } else {
                  var10[var12 + var11 * var3] = 1;
               }
            } else {
               var19 = this.func_75902_a(2);
               if(var19 == 0 && var14 != 0 && var14 != 1 && var15 != 0 && var15 != 1 && var16 != 0 && var16 != 1 && var17 != 0 && var17 != 1) {
                  var10[var12 + var11 * var3] = 3;
               } else if(var14 != 0 && var15 != 0 && var16 != 0 && var17 != 0) {
                  var10[var12 + var11 * var3] = 2;
               } else {
                  var10[var12 + var11 * var3] = 1;
               }
            }
         }
      }

      return var10;
   }
}
