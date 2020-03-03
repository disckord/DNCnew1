package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4NoisePerlinInfdev;
import net.minecraft.src.NoiseGenerator;

public class BWG4NoiseOctavesInfdev extends NoiseGenerator {

   private BWG4NoisePerlinInfdev[] field_1192_a;
   private int field_1191_b;


   public BWG4NoiseOctavesInfdev(Random var1, int var2) {
      this.field_1191_b = var2;
      this.field_1192_a = new BWG4NoisePerlinInfdev[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_1192_a[var3] = new BWG4NoisePerlinInfdev(var1);
      }

   }

   public double func_806_a(double var1, double var3) {
      double var5 = 0.0D;
      double var7 = 1.0D;

      for(int var9 = 0; var9 < this.field_1191_b; ++var9) {
         var5 += this.field_1192_a[var9].func_801_a(var1 * var7, var3 * var7) / var7;
         var7 /= 2.0D;
      }

      return var5;
   }

   public double[] func_807_a(double[] var1, double var2, double var4, double var6, int var8, int var9, int var10, double var11, double var13, double var15) {
      if(var1 == null) {
         var1 = new double[var8 * var9 * var10];
      } else {
         for(int var17 = 0; var17 < var1.length; ++var17) {
            var1[var17] = 0.0D;
         }
      }

      double var20 = 1.0D;

      for(int var19 = 0; var19 < this.field_1191_b; ++var19) {
         this.field_1192_a[var19].func_805_a(var1, var2, var4, var6, var8, var9, var10, var11 * var20, var13 * var20, var15 * var20, var20);
         var20 /= 2.0D;
      }

      return var1;
   }
}
