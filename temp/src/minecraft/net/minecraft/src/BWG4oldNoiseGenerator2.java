package net.minecraft.src;

import java.util.Random;

public class BWG4oldNoiseGenerator2 {

   private static int[][] field_4296_d = new int[][]{{1, 1, 0}, {-1, 1, 0}, {1, -1, 0}, {-1, -1, 0}, {1, 0, 1}, {-1, 0, 1}, {1, 0, -1}, {-1, 0, -1}, {0, 1, 1}, {0, -1, 1}, {0, 1, -1}, {0, -1, -1}};
   private int[] field_4295_e;
   public double field_4292_a;
   public double field_4291_b;
   public double field_4297_c;
   private static final double field_4294_f = 0.5D * (Math.sqrt(3.0D) - 1.0D);
   private static final double field_4293_g = (3.0D - Math.sqrt(3.0D)) / 6.0D;


   public BWG4oldNoiseGenerator2() {
      this(new Random());
   }

   public BWG4oldNoiseGenerator2(Random var1) {
      this.field_4295_e = new int[512];
      this.field_4292_a = var1.nextDouble() * 256.0D;
      this.field_4291_b = var1.nextDouble() * 256.0D;
      this.field_4297_c = var1.nextDouble() * 256.0D;

      int var2;
      for(var2 = 0; var2 < 256; this.field_4295_e[var2] = var2++) {
         ;
      }

      for(var2 = 0; var2 < 256; ++var2) {
         int var3 = var1.nextInt(256 - var2) + var2;
         int var4 = this.field_4295_e[var2];
         this.field_4295_e[var2] = this.field_4295_e[var3];
         this.field_4295_e[var3] = var4;
         this.field_4295_e[var2 + 256] = this.field_4295_e[var2];
      }

   }

   private static int wrap(double var0) {
      return var0 <= 0.0D?(int)var0 - 1:(int)var0;
   }

   private static double func_4156_a(int[] var0, double var1, double var3) {
      return (double)var0[0] * var1 + (double)var0[1] * var3;
   }

   public void func_4157_a(double[] var1, double var2, double var4, int var6, int var7, double var8, double var10, double var12) {
      int var14 = 0;

      for(int var15 = 0; var15 < var6; ++var15) {
         double var16 = (var2 + (double)var15) * var8 + this.field_4292_a;

         for(int var18 = 0; var18 < var7; ++var18) {
            double var19 = (var4 + (double)var18) * var10 + this.field_4291_b;
            double var21 = (var16 + var19) * field_4294_f;
            int var23 = wrap(var16 + var21);
            int var24 = wrap(var19 + var21);
            double var25 = (double)(var23 + var24) * field_4293_g;
            double var27 = (double)var23 - var25;
            double var29 = (double)var24 - var25;
            double var31 = var16 - var27;
            double var33 = var19 - var29;
            byte var35;
            byte var36;
            if(var31 > var33) {
               var35 = 1;
               var36 = 0;
            } else {
               var35 = 0;
               var36 = 1;
            }

            double var37 = var31 - (double)var35 + field_4293_g;
            double var39 = var33 - (double)var36 + field_4293_g;
            double var41 = var31 - 1.0D + 2.0D * field_4293_g;
            double var43 = var33 - 1.0D + 2.0D * field_4293_g;
            int var45 = var23 & 255;
            int var46 = var24 & 255;
            int var47 = this.field_4295_e[var45 + this.field_4295_e[var46]] % 12;
            int var48 = this.field_4295_e[var45 + var35 + this.field_4295_e[var46 + var36]] % 12;
            int var49 = this.field_4295_e[var45 + 1 + this.field_4295_e[var46 + 1]] % 12;
            double var50 = 0.5D - var31 * var31 - var33 * var33;
            double var52;
            if(var50 < 0.0D) {
               var52 = 0.0D;
            } else {
               var50 *= var50;
               var52 = var50 * var50 * func_4156_a(field_4296_d[var47], var31, var33);
            }

            double var54 = 0.5D - var37 * var37 - var39 * var39;
            double var56;
            if(var54 < 0.0D) {
               var56 = 0.0D;
            } else {
               var54 *= var54;
               var56 = var54 * var54 * func_4156_a(field_4296_d[var48], var37, var39);
            }

            double var58 = 0.5D - var41 * var41 - var43 * var43;
            double var60;
            if(var58 < 0.0D) {
               var60 = 0.0D;
            } else {
               var58 *= var58;
               var60 = var58 * var58 * func_4156_a(field_4296_d[var49], var41, var43);
            }

            int var10001 = var14++;
            var1[var10001] += 70.0D * (var52 + var56 + var60) * var12;
         }
      }

   }

}
