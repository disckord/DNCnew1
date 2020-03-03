package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4NoisePerlinIndev;
import net.minecraft.src.BWG4oldNoiseGenerator2;

public class BWG4NoiseOctavesIndev extends BWG4oldNoiseGenerator2 {

   private BWG4NoisePerlinIndev[] field_1192_a;
   private int field_1191_b;


   public BWG4NoiseOctavesIndev(Random var1, int var2) {
      this.field_1191_b = var2;
      this.field_1192_a = new BWG4NoisePerlinIndev[var2];

      for(int var3 = 0; var3 < var2; ++var3) {
         this.field_1192_a[var3] = new BWG4NoisePerlinIndev(var1);
      }

   }

   public final double a(double var1, double var3) {
      double var5 = 0.0D;
      double var7 = 1.0D;

      for(int var9 = 0; var9 < this.field_1191_b; ++var9) {
         var5 += this.field_1192_a[var9].a(var1 / var7, var3 / var7) * var7;
         var7 *= 2.0D;
      }

      return var5;
   }

   public final double a(double var1, double var3, double var5) {
      double var7 = 0.0D;
      double var9 = 1.0D;

      for(int var11 = 0; var11 < this.field_1191_b; ++var11) {
         var7 += this.field_1192_a[var11].a(var1 / var9, 0.0D / var9, var5 / var9) * var9;
         var9 *= 2.0D;
      }

      return var7;
   }
}
