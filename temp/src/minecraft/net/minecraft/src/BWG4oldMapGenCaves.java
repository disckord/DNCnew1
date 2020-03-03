package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;

public class BWG4oldMapGenCaves extends MapGenBase {

   protected void func_870_a(int var1, int var2, byte[] var3, double var4, double var6, double var8) {
      this.releaseEntitySkin(var1, var2, var3, var4, var6, var8, 1.0F + this.field_75038_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
   }

   protected void releaseEntitySkin(int var1, int var2, byte[] var3, double var4, double var6, double var8, float var10, float var11, float var12, int var13, int var14, double var15) {
      double var17 = (double)(var1 * 16 + 8);
      double var19 = (double)(var2 * 16 + 8);
      float var21 = 0.0F;
      float var22 = 0.0F;
      Random var23 = new Random(this.field_75038_b.nextLong());
      if(var14 <= 0) {
         int var24 = this.field_75040_a * 16 - 16;
         var14 = var24 - var23.nextInt(var24 / 4);
      }

      boolean var60 = false;
      if(var13 == -1) {
         var13 = var14 / 2;
         var60 = true;
      }

      int var25 = var23.nextInt(var14 / 2) + var14 / 4;

      for(boolean var26 = var23.nextInt(6) == 0; var13 < var14; ++var13) {
         double var27 = 1.5D + (double)(MathHelper.func_76126_a((float)var13 * 3.141593F / (float)var14) * var10 * 1.0F);
         double var29 = var27 * var15;
         float var31 = MathHelper.func_76134_b(var12);
         float var32 = MathHelper.func_76126_a(var12);
         var4 += (double)(MathHelper.func_76134_b(var11) * var31);
         var6 += (double)var32;
         var8 += (double)(MathHelper.func_76126_a(var11) * var31);
         if(var26) {
            var12 *= 0.92F;
         } else {
            var12 *= 0.7F;
         }

         var12 += var22 * 0.1F;
         var11 += var21 * 0.1F;
         var22 *= 0.9F;
         var21 *= 0.75F;
         var22 += (var23.nextFloat() - var23.nextFloat()) * var23.nextFloat() * 2.0F;
         var21 += (var23.nextFloat() - var23.nextFloat()) * var23.nextFloat() * 4.0F;
         if(!var60 && var13 == var25 && var10 > 1.0F) {
            this.releaseEntitySkin(var1, var2, var3, var4, var6, var8, var23.nextFloat() * 0.5F + 0.5F, var11 - 1.570796F, var12 / 3.0F, var13, var14, 1.0D);
            this.releaseEntitySkin(var1, var2, var3, var4, var6, var8, var23.nextFloat() * 0.5F + 0.5F, var11 + 1.570796F, var12 / 3.0F, var13, var14, 1.0D);
            return;
         }

         if(var60 || var23.nextInt(4) != 0) {
            double var33 = var4 - var17;
            double var35 = var8 - var19;
            double var37 = (double)(var14 - var13);
            double var39 = (double)(var10 + 2.0F + 16.0F);
            if(var33 * var33 + var35 * var35 - var37 * var37 > var39 * var39) {
               return;
            }

            if(var4 >= var17 - 16.0D - var27 * 2.0D && var8 >= var19 - 16.0D - var27 * 2.0D && var4 <= var17 + 16.0D + var27 * 2.0D && var8 <= var19 + 16.0D + var27 * 2.0D) {
               int var41 = MathHelper.func_76128_c(var4 - var27) - var1 * 16 - 1;
               int var42 = MathHelper.func_76128_c(var4 + var27) - var1 * 16 + 1;
               int var43 = MathHelper.func_76128_c(var6 - var29) - 1;
               int var44 = MathHelper.func_76128_c(var6 + var29) + 1;
               int var45 = MathHelper.func_76128_c(var8 - var27) - var2 * 16 - 1;
               int var46 = MathHelper.func_76128_c(var8 + var27) - var2 * 16 + 1;
               if(var41 < 0) {
                  var41 = 0;
               }

               if(var42 > 16) {
                  var42 = 16;
               }

               if(var43 < 1) {
                  var43 = 1;
               }

               if(var44 > 120) {
                  var44 = 120;
               }

               if(var45 < 0) {
                  var45 = 0;
               }

               if(var46 > 16) {
                  var46 = 16;
               }

               boolean var47 = false;

               int var48;
               int var51;
               for(var48 = var41; !var47 && var48 < var42; ++var48) {
                  for(int var49 = var45; !var47 && var49 < var46; ++var49) {
                     for(int var50 = var44 + 1; !var47 && var50 >= var43 - 1; --var50) {
                        var51 = (var48 * 16 + var49) * 128 + var50;
                        if(var50 >= 0 && var50 < 128) {
                           if(var3[var51] == Block.field_71942_A.field_71990_ca || var3[var51] == Block.field_71943_B.field_71990_ca) {
                              var47 = true;
                           }

                           if(var50 != var43 - 1 && var48 != var41 && var48 != var42 - 1 && var49 != var45 && var49 != var46 - 1) {
                              var50 = var43;
                           }
                        }
                     }
                  }
               }

               if(!var47) {
                  for(var48 = var41; var48 < var42; ++var48) {
                     double var61 = ((double)(var48 + var1 * 16) + 0.5D - var4) / var27;

                     for(var51 = var45; var51 < var46; ++var51) {
                        double var52 = ((double)(var51 + var2 * 16) + 0.5D - var8) / var27;
                        int var54 = (var48 * 16 + var51) * 128 + var44;
                        boolean var55 = false;
                        if(var61 * var61 + var52 * var52 < 1.0D) {
                           for(int var56 = var44 - 1; var56 >= var43; --var56) {
                              double var57 = ((double)var56 + 0.5D - var6) / var29;
                              if(var57 > -0.7D && var61 * var61 + var57 * var57 + var52 * var52 < 1.0D) {
                                 byte var59 = var3[var54];
                                 if(var59 == Block.field_71980_u.field_71990_ca) {
                                    var55 = true;
                                 }

                                 if(var59 == Block.field_71981_t.field_71990_ca || var59 == Block.field_71979_v.field_71990_ca || var59 == Block.field_71980_u.field_71990_ca) {
                                    if(var56 < 10) {
                                       var3[var54] = (byte)Block.field_71944_C.field_71990_ca;
                                    } else {
                                       var3[var54] = 0;
                                       if(var55 && var3[var54 - 1] == Block.field_71979_v.field_71990_ca) {
                                          var3[var54 - 1] = (byte)Block.field_71980_u.field_71990_ca;
                                       }
                                    }
                                 }
                              }

                              --var54;
                           }
                        }
                     }
                  }

                  if(var60) {
                     break;
                  }
               }
            }
         }
      }

   }

   protected void func_75037_a(World var1, int var2, int var3, int var4, int var5, byte[] var6) {
      int var7 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 1) + 1);
      if(this.field_75038_b.nextInt(15) != 0) {
         var7 = 0;
      }

      for(int var8 = 0; var8 < var7; ++var8) {
         double var9 = (double)(var2 * 16 + this.field_75038_b.nextInt(16));
         double var11 = (double)this.field_75038_b.nextInt(this.field_75038_b.nextInt(120) + 8);
         double var13 = (double)(var3 * 16 + this.field_75038_b.nextInt(16));
         int var15 = 1;
         if(this.field_75038_b.nextInt(4) == 0) {
            this.func_870_a(var4, var5, var6, var9, var11, var13);
            var15 += this.field_75038_b.nextInt(4);
         }

         for(int var16 = 0; var16 < var15; ++var16) {
            float var17 = this.field_75038_b.nextFloat() * 3.141593F * 2.0F;
            float var18 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
            float var19 = this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat();
            this.releaseEntitySkin(var4, var5, var6, var9, var11, var13, var19, var17, var18, 0, 0, 1.0D);
         }
      }

   }
}
