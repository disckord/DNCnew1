package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4oldNoiseGenerator2;
import net.minecraft.src.MathHelper;

public class BWG4NoisePerlinIndev extends BWG4oldNoiseGenerator2 {

   private int[] a;
   private double b;
   private double c;
   private double d;


   public BWG4NoisePerlinIndev() {
      this(new Random());
   }

   public BWG4NoisePerlinIndev(Random var1) {
      this.a = new int[512];
      this.b = var1.nextDouble() * 256.0D;
      this.c = var1.nextDouble() * 256.0D;
      this.d = var1.nextDouble() * 256.0D;

      int var2;
      for(var2 = 0; var2 < 256; this.a[var2] = var2++) {
         ;
      }

      for(var2 = 0; var2 < 256; ++var2) {
         int var3 = var1.nextInt(256 - var2) + var2;
         int var4 = this.a[var2];
         this.a[var2] = this.a[var3];
         this.a[var3] = var4;
         this.a[var2 + 256] = this.a[var2];
      }

   }

   private double b(double var1, double var3, double var5) {
      double var7 = var1 + this.b;
      double var9 = var3 + this.c;
      double var11 = var5 + this.d;
      var1 = (double)(MathHelper.func_76128_c(var7) & 255);
      double var13 = (double)(MathHelper.func_76128_c(var9) & 255);
      var3 = (double)(MathHelper.func_76128_c(var11) & 255);
      var7 -= (double)MathHelper.func_76128_c(var7);
      var9 -= (double)MathHelper.func_76128_c(var9);
      var11 -= (double)MathHelper.func_76128_c(var11);
      double var15 = a(var7);
      double var17 = a(var9);
      double var19 = a(var11);
      double var21 = (double)this.a[(int)var1] + var13;
      var5 = (double)this.a[(int)var21] + var3;
      var21 = (double)this.a[(int)var21 + 1] + var3;
      var1 = (double)this.a[(int)var1 + 1] + var13;
      var13 = (double)this.a[(int)var1] + var3;
      var1 = (double)this.a[(int)var1 + 1] + var3;
      return c(var19, c(var17, c(var15, a(this.a[(int)var5], var7, var9, var11), a(this.a[(int)var13], var7 - 1.0D, var9, var11)), c(var15, a(this.a[(int)var21], var7, var9 - 1.0D, var11), a(this.a[(int)var1], var7 - 1.0D, var9 - 1.0D, var11))), c(var17, c(var15, a(this.a[(int)var5 + 1], var7, var9, var11 - 1.0D), a(this.a[(int)var13 + 1], var7 - 1.0D, var9, var11 - 1.0D)), c(var15, a(this.a[(int)var21 + 1], var7, var9 - 1.0D, var11 - 1.0D), a(this.a[(int)var1 + 1], var7 - 1.0D, var9 - 1.0D, var11 - 1.0D))));
   }

   private static double a(double var0) {
      return var0 * var0 * var0 * (var0 * (var0 * 6.0D - 15.0D) + 10.0D);
   }

   private static double c(double var0, double var2, double var4) {
      return var2 + var0 * (var4 - var2);
   }

   private static double a(int var0, double var1, double var3, double var5) {
      double var7 = (var0 &= 15) < 8?var1:var3;
      double var9 = var0 != 12 && var0 != 14?(var0 < 4?var3:var5):var1;
      return ((var0 & 1) == 0?var7:-var7) + ((var0 & 2) == 0?var9:-var9);
   }

   public final double a(double var1, double var3) {
      return this.b(var1, var3, 0.0D);
   }

   public final double a(double var1, double var3, double var5) {
      return this.b(var1, var3, var5);
   }
}
