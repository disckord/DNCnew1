package net.minecraft.src;

import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class BWG4LayerPack extends GenLayer {

   private int theworldID;


   public BWG4LayerPack(long var1, GenLayer var3, int var4) {
      super(var1);
      this.field_75909_a = var3;
      this.theworldID = var4;
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
            int var13 = var9[var12 + 1 + (var11 + 1) * var7];
            this.func_75903_a((long)(var12 + var1), (long)(var11 + var2));
            if(this.theworldID == 1) {
               if(var13 == 0) {
                  var10[var12 + var11 * var3] = this.func_75902_a(2) + 0;
               } else if(var13 == 1) {
                  var10[var12 + var11 * var3] = this.func_75902_a(2) + 10;
               } else if(var13 == 2) {
                  var10[var12 + var11 * var3] = this.func_75902_a(3) + 20;
               } else {
                  var10[var12 + var11 * var3] = this.func_75902_a(3) + 30;
               }
            } else {
               int var14 = this.func_75902_a(3);
               byte var15;
               if(var14 == 0) {
                  var15 = 33;
               } else {
                  var15 = 32;
               }

               var10[var12 + var11 * var3] = var15;
            }
         }
      }

      return var10;
   }
}
