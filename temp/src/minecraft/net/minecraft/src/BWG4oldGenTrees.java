package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4oldGenTrees extends WorldGenerator {

   private int generatortype;


   public BWG4oldGenTrees(int var1) {
      this.generatortype = var1;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      boolean var7;
      int var8;
      byte var9;
      int var10;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      if(this.generatortype != 0 && this.generatortype != 1) {
         var6 = var2.nextInt(3) + 4;
         var7 = true;
         if(var4 >= 1 && var4 + var6 + 1 <= 128) {
            for(var8 = var4; var8 <= var4 + 1 + var6; ++var8) {
               var9 = 1;
               if(var8 == var4) {
                  var9 = 0;
               }

               if(var8 >= var4 + 1 + var6 - 2) {
                  var9 = 2;
               }

               for(var10 = var3 - var9; var10 <= var3 + var9 && var7; ++var10) {
                  for(var11 = var5 - var9; var11 <= var5 + var9 && var7; ++var11) {
                     if(var8 >= 0 && var8 < 128) {
                        var12 = var1.func_72798_a(var10, var8, var11);
                        if(var12 != 0 && var12 != Block.field_71952_K.field_71990_ca) {
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
                  var1.func_94575_c(var3, var4 - 1, var5, Block.field_71979_v.field_71990_ca);

                  for(var16 = var4 - 3 + var6; var16 <= var4 + var6; ++var16) {
                     var10 = var16 - (var4 + var6);
                     var11 = 1 - var10 / 2;

                     for(var12 = var3 - var11; var12 <= var3 + var11; ++var12) {
                        var13 = var12 - var3;

                        for(var14 = var5 - var11; var14 <= var5 + var11; ++var14) {
                           var15 = var14 - var5;
                           if((Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) && !Block.field_71970_n[var1.func_72798_a(var12, var16, var14)]) {
                              var1.func_94575_c(var12, var16, var14, Block.field_71952_K.field_71990_ca);
                           }
                        }
                     }
                  }

                  for(var16 = 0; var16 < var6; ++var16) {
                     var10 = var1.func_72798_a(var3, var4 + var16, var5);
                     if(var10 == 0 || var10 == Block.field_71952_K.field_71990_ca) {
                        var1.func_94575_c(var3, var4 + var16, var5, Block.field_71951_J.field_71990_ca);
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
      } else {
         var6 = var2.nextInt(3) + 4;
         var7 = true;
         if(var4 >= 1 && var4 + var6 + 1 <= 128) {
            for(var8 = var4; var8 <= var4 + 1 + var6; ++var8) {
               var9 = 1;
               if(var8 == var4) {
                  var9 = 0;
               }

               if(var8 >= var4 + 1 + var6 - 2) {
                  var9 = 2;
               }

               for(var10 = var3 - var9; var10 <= var3 + var9 && var7; ++var10) {
                  for(var11 = var5 - var9; var11 <= var5 + var9 && var7; ++var11) {
                     if(var8 >= 0 && var8 < 128) {
                        var12 = var1.func_72798_a(var10, var8, var11);
                        if(var12 != 0 && var12 != Block.field_71952_K.field_71990_ca) {
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
                  var1.func_94575_c(var3, var4 - 1, var5, Block.field_71979_v.field_71990_ca);

                  for(var16 = var4 - 3 + var6; var16 <= var4 + var6; ++var16) {
                     var10 = var16 - (var4 + var6);
                     var11 = 1 - var10 / 2;

                     for(var12 = var3 - var11; var12 <= var3 + var11; ++var12) {
                        var13 = var12 - var3;

                        for(var14 = var5 - var11; var14 <= var5 + var11; ++var14) {
                           var15 = var14 - var5;
                           if((Math.abs(var13) != var11 || Math.abs(var15) != var11 || var2.nextInt(2) != 0 && var10 != 0) && !Block.field_71970_n[var1.func_72798_a(var12, var16, var14)]) {
                              var1.func_94575_c(var12, var16, var14, Block.field_71952_K.field_71990_ca);
                           }
                        }
                     }
                  }

                  for(var16 = 0; var16 < var6; ++var16) {
                     var10 = var1.func_72798_a(var3, var4 + var16, var5);
                     if(var10 == 0 || var10 == Block.field_71952_K.field_71990_ca) {
                        var1.func_94575_c(var3, var4 + var16, var5, Block.field_71951_J.field_71990_ca);
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
   }
}
