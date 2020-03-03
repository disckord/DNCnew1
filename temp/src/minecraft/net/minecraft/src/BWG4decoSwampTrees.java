package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoSwampTrees extends WorldGenerator {

   private int treelength;


   public BWG4decoSwampTrees(int var1) {
      this.treelength = var1;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      for(var6 = var2.nextInt(6) + this.treelength; var1.func_72803_f(var3, var4 - 1, var5) == Material.field_76244_g; --var4) {
         ++var6;
      }

      boolean var7 = true;
      if(var4 >= 1 && var4 + var6 + 1 <= 128) {
         int var8;
         int var10;
         int var11;
         int var12;
         for(var8 = var4; var8 <= var4 + 1 + var6; ++var8) {
            byte var9 = 1;
            if(var8 == var4) {
               var9 = 0;
            }

            if(var8 >= var4 + 1 + var6 - 2) {
               var9 = 3;
            }

            for(var10 = var3 - var9; var10 <= var3 + var9 && var7; ++var10) {
               for(var11 = var5 - var9; var11 <= var5 + var9 && var7; ++var11) {
                  if(var8 >= 0 && var8 < 128) {
                     var12 = var1.func_72798_a(var10, var8, var11);
                     if(var12 != 0 && var12 != Block.field_71952_K.field_71990_ca && var12 != Block.field_71943_B.field_71990_ca && var12 != Block.field_71942_A.field_71990_ca) {
                        var7 = false;
                     }
                  } else {
                     var7 = false;
                  }
               }
            }
         }

         if(!var7) {
            return false;
         } else {
            var8 = var1.func_72798_a(var3, var4 - 1, var5);
            if((var8 == Block.field_71980_u.field_71990_ca || var8 == Block.field_71979_v.field_71990_ca) && var4 < 128 - var6 - 1) {
               this.func_76486_a(var1, var3, var4 - 1, var5, Block.field_71979_v.field_71990_ca);

               int var13;
               int var16;
               for(var16 = var4 - 3 + var6; var16 <= var4 + var6; ++var16) {
                  var10 = var16 - (var4 + var6);
                  var11 = 2 - var10 / 2;

                  for(var12 = var3 - var11; var12 <= var3 + var11; ++var12) {
                     var13 = var12 - var3;

                     for(int var14 = var5 - var11; var14 <= var5 + var11; ++var14) {
                        int var15 = var14 - var5;
                        if((Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) && !Block.field_71970_n[var1.func_72798_a(var12, var16, var14)]) {
                           this.func_76486_a(var1, var12, var16, var14, Block.field_71952_K.field_71990_ca);
                        }
                     }
                  }
               }

               for(var16 = 0; var16 < var6; ++var16) {
                  var10 = var1.func_72798_a(var3, var4 + var16, var5);
                  if(var10 == 0 || var10 == Block.field_71952_K.field_71990_ca || var10 == Block.field_71942_A.field_71990_ca || var10 == Block.field_71943_B.field_71990_ca) {
                     this.func_76486_a(var1, var3, var4 + var16, var5, Block.field_71951_J.field_71990_ca);
                  }
               }

               for(var16 = var4 - 3 + var6; var16 <= var4 + var6; ++var16) {
                  var10 = var16 - (var4 + var6);
                  var11 = 2 - var10 / 2;

                  for(var12 = var3 - var11; var12 <= var3 + var11; ++var12) {
                     for(var13 = var5 - var11; var13 <= var5 + var11; ++var13) {
                        if(var1.func_72798_a(var12, var16, var13) == Block.field_71952_K.field_71990_ca) {
                           if(var2.nextInt(4) == 0 && var1.func_72798_a(var12 - 1, var16, var13) == 0) {
                              this.generateVines(var1, var12 - 1, var16, var13, 8);
                           }

                           if(var2.nextInt(4) == 0 && var1.func_72798_a(var12 + 1, var16, var13) == 0) {
                              this.generateVines(var1, var12 + 1, var16, var13, 2);
                           }

                           if(var2.nextInt(4) == 0 && var1.func_72798_a(var12, var16, var13 - 1) == 0) {
                              this.generateVines(var1, var12, var16, var13 - 1, 1);
                           }

                           if(var2.nextInt(4) == 0 && var1.func_72798_a(var12, var16, var13 + 1) == 0) {
                              this.generateVines(var1, var12, var16, var13 + 1, 4);
                           }
                        }
                     }
                  }
               }

               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   private void generateVines(World var1, int var2, int var3, int var4, int var5) {
      this.func_76485_a(var1, var2, var3, var4, Block.field_71998_bu.field_71990_ca, var5);
      int var6 = 4;

      while(true) {
         --var3;
         if(var1.func_72798_a(var2, var3, var4) != 0 || var6 <= 0) {
            return;
         }

         this.func_76485_a(var1, var2, var3, var4, Block.field_71998_bu.field_71990_ca, var5);
         --var6;
      }
   }
}
