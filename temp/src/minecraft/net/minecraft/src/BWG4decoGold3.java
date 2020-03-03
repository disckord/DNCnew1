package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoGold3 extends WorldGenerator {

   private int objectID;


   public BWG4decoGold3(int var1) {
      this.objectID = var1;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      int var7;
      int var8;
      if(this.objectID == 1) {
         for(var6 = var3 - 1; var6 < var3 + 2; ++var6) {
            for(var7 = var5 - 1; var7 < var5 + 2; ++var7) {
               for(var8 = var4 - 5; var8 < var4 + 10; ++var8) {
                  if(var2.nextInt(2) != 0) {
                     var1.func_94575_c(var6, var8, var7, Block.field_72087_ao.field_71990_ca);
                  } else {
                     var1.func_94575_c(var6, var8, var7, Block.field_71978_w.field_71990_ca);
                  }
               }
            }
         }

         var1.func_94575_c(var3 + 2, var4 + 6, var5, Block.field_72087_ao.field_71990_ca);
         var1.func_94575_c(var3 + 3, var4 + 6, var5, Block.field_72087_ao.field_71990_ca);
         var1.func_94575_c(var3 + 3, var4 + 5, var5, Block.field_72087_ao.field_71990_ca);
         var1.func_94575_c(var3 + 3, var4 + 4, var5, Block.field_72087_ao.field_71990_ca);

         for(var6 = var5 - 2; var6 < var5 + 3; ++var6) {
            for(var7 = var4 + 2; var7 < var4 + 8; ++var7) {
               if(var2.nextInt(2) != 0) {
                  var1.func_94575_c(var3, var7, var6, Block.field_72087_ao.field_71990_ca);
               } else {
                  var1.func_94575_c(var3, var7, var6, Block.field_71978_w.field_71990_ca);
               }
            }
         }

         for(var6 = var5 - 1; var6 < var5 + 2; ++var6) {
            for(var7 = var4 + 2; var7 < var4 + 10; ++var7) {
               if(var7 > var4 + 7 || var7 < var4 + 5) {
                  if(var2.nextInt(2) != 0) {
                     var1.func_94575_c(var3 + 2, var7, var6, Block.field_72087_ao.field_71990_ca);
                  } else {
                     var1.func_94575_c(var3 + 2, var7, var6, Block.field_71978_w.field_71990_ca);
                  }
               }
            }
         }
      } else if(this.objectID == 2) {
         var6 = var1.func_72798_a(var3, var4 - 1, var5);
         if(var6 != Block.field_71980_u.field_71990_ca) {
            return false;
         }

         var7 = 14 + var2.nextInt(5);

         for(var8 = 0; var8 < var7; ++var8) {
            var1.func_94575_c(var3, var4 + var8, var5, Block.field_71951_J.field_71990_ca);
         }

         this.createRainForestBranch(var1, var2, var3, var4 + var7 - 5, var5);
         this.createRainForestLeaves(var1, var2, var3, var4 + var7, var5, 2);
         this.createRainForestLeaves(var1, var2, var3, var4 + var7 + 1, var5, 3);
         this.createRainForestLeaves(var1, var2, var3, var4 + var7 + 2, var5, 2);
         var1.func_94575_c(var3, var4 + var7, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + var7 + 1, var5, Block.field_71951_J.field_71990_ca);
      } else if(this.objectID == 3) {
         var6 = var1.func_72798_a(var3, var4 - 1, var5);
         if(var6 != Block.field_71980_u.field_71990_ca && var6 != Block.field_71942_A.field_71990_ca && var6 != Block.field_71943_B.field_71990_ca) {
            return false;
         }

         var7 = 11 + var2.nextInt(3);

         for(var8 = 6; var8 < var7; ++var8) {
            var1.func_94575_c(var3, var4 + var8, var5, Block.field_71951_J.field_71990_ca);
         }

         this.createSwampRoots(var1, var2, var3, var4, var5);
         this.createRainForestBranch(var1, var2, var3, var4 + var7 - 5, var5);
         this.createRainForestLeaves(var1, var2, var3, var4 + var7, var5, 2);
         this.createRainForestLeaves(var1, var2, var3, var4 + var7 + 1, var5, 3);
         this.createRainForestLeaves(var1, var2, var3, var4 + var7 + 2, var5, 2);
         var1.func_94575_c(var3, var4 + var7, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + var7 + 1, var5, Block.field_71951_J.field_71990_ca);
      }

      return true;
   }

   private void createSwampRoots(World var1, Random var2, int var3, int var4, int var5) {
      int var6 = 0 + var2.nextInt(5);

      int var7;
      for(var7 = var6; var7 < 8; ++var7) {
         var1.func_94575_c(var3, var4 + var7, var5, Block.field_71951_J.field_71990_ca);
      }

      var1.func_94575_c(var3 - 1, var4 + var6, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 - 1, var4 + var6 - 1, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 - 2, var4 + var6 - 1, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 - 2, var4 + var6 - 2, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 - 2, var4 + var6 - 3, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 - 3, var4 + var6 - 3, var5, Block.field_71951_J.field_71990_ca);

      int var8;
      for(var7 = var4 + var6 - 3; var7 > 50; --var7) {
         var8 = var1.func_72798_a(var3 - 3, var7, var5);
         if(var8 != 0 && var8 != Block.field_71980_u.field_71990_ca && var8 != Block.field_71942_A.field_71990_ca && var8 != Block.field_71943_B.field_71990_ca && var8 != Block.field_71952_K.field_71990_ca && var8 != Block.field_71951_J.field_71990_ca && var8 != Block.field_71998_bu.field_71990_ca && var8 != Block.field_71962_X.field_71990_ca) {
            break;
         }

         var1.func_94575_c(var3 - 3, var7, var5, Block.field_71951_J.field_71990_ca);
      }

      var7 = 2 + var2.nextInt(5);

      for(var8 = var7; var8 < 8; ++var8) {
         var1.func_94575_c(var3, var4 + var8, var5, Block.field_71951_J.field_71990_ca);
      }

      var1.func_94575_c(var3 + 1, var4 + var7, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 + 1, var4 + var7 - 1, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 + 2, var4 + var7 - 1, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 + 2, var4 + var7 - 2, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 + 2, var4 + var7 - 3, var5, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3 + 3, var4 + var7 - 3, var5, Block.field_71951_J.field_71990_ca);

      int var9;
      for(var8 = var4 + var7 - 3; var8 > 50; --var8) {
         var9 = var1.func_72798_a(var3 + 3, var8, var5);
         if(var9 != 0 && var9 != Block.field_71980_u.field_71990_ca && var9 != Block.field_71942_A.field_71990_ca && var9 != Block.field_71943_B.field_71990_ca && var9 != Block.field_71952_K.field_71990_ca && var9 != Block.field_71951_J.field_71990_ca && var9 != Block.field_71998_bu.field_71990_ca && var9 != Block.field_71962_X.field_71990_ca) {
            break;
         }

         var1.func_94575_c(var3 + 3, var8, var5, Block.field_71951_J.field_71990_ca);
      }

      var8 = 2 + var2.nextInt(5);

      for(var9 = var8; var9 < 8; ++var9) {
         var1.func_94575_c(var3, var4 + var9, var5, Block.field_71951_J.field_71990_ca);
      }

      var1.func_94575_c(var3, var4 + var8, var5 - 1, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var8 - 1, var5 - 1, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var8 - 1, var5 - 2, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var8 - 2, var5 - 2, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var8 - 3, var5 - 2, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var8 - 3, var5 - 3, Block.field_71951_J.field_71990_ca);

      int var10;
      for(var9 = var4 + var8 - 3; var9 > 50; --var9) {
         var10 = var1.func_72798_a(var3, var9, var5 - 3);
         if(var10 != 0 && var10 != Block.field_71980_u.field_71990_ca && var10 != Block.field_71942_A.field_71990_ca && var10 != Block.field_71943_B.field_71990_ca && var10 != Block.field_71952_K.field_71990_ca && var10 != Block.field_71951_J.field_71990_ca && var10 != Block.field_71998_bu.field_71990_ca && var10 != Block.field_71962_X.field_71990_ca) {
            break;
         }

         var1.func_94575_c(var3, var9, var5 - 3, Block.field_71951_J.field_71990_ca);
      }

      var9 = 2 + var2.nextInt(5);

      for(var10 = var9; var10 < 8; ++var10) {
         var1.func_94575_c(var3, var4 + var10, var5, Block.field_71951_J.field_71990_ca);
      }

      var1.func_94575_c(var3, var4 + var9, var5 + 1, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var9 - 1, var5 + 1, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var9 - 1, var5 + 2, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var9 - 2, var5 + 2, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var9 - 3, var5 + 2, Block.field_71951_J.field_71990_ca);
      var1.func_94575_c(var3, var4 + var9 - 3, var5 + 3, Block.field_71951_J.field_71990_ca);

      for(var10 = var4 + var9 - 3; var10 > 50; --var10) {
         int var11 = var1.func_72798_a(var3, var10, var5 + 3);
         if(var11 != 0 && var11 != Block.field_71980_u.field_71990_ca && var11 != Block.field_71942_A.field_71990_ca && var11 != Block.field_71943_B.field_71990_ca && var11 != Block.field_71952_K.field_71990_ca && var11 != Block.field_71951_J.field_71990_ca && var11 != Block.field_71998_bu.field_71990_ca && var11 != Block.field_71962_X.field_71990_ca) {
            break;
         }

         var1.func_94575_c(var3, var10, var5 + 3, Block.field_71951_J.field_71990_ca);
      }

   }

   private void createRainForestBranch(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      int var7;
      if(var2.nextInt(4) == 0) {
         var1.func_94575_c(var3 + 1, var4, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 + 2, var4 + 1, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 + 3, var4 + 2, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 + 4, var4 + 3, var5, Block.field_71951_J.field_71990_ca);
         var6 = 1 + var2.nextInt(5);
         this.createRainForestLeaves(var1, var2, var3 + 4, var4 + 4 + var6, var5, 2);
         this.createRainForestLeaves(var1, var2, var3 + 4, var4 + 5 + var6, var5, 3);
         this.createRainForestLeaves(var1, var2, var3 + 4, var4 + 6 + var6, var5, 2);

         for(var7 = 0; var7 <= var6; ++var7) {
            var1.func_94575_c(var3 + 4, var4 + 4 + var7, var5, Block.field_71951_J.field_71990_ca);
         }
      }

      if(var2.nextInt(4) == 0) {
         var1.func_94575_c(var3 - 1, var4, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 - 2, var4 + 1, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 - 3, var4 + 2, var5, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 - 4, var4 + 3, var5, Block.field_71951_J.field_71990_ca);
         var6 = 1 + var2.nextInt(5);
         this.createRainForestLeaves(var1, var2, var3 - 4, var4 + 4 + var6, var5, 2);
         this.createRainForestLeaves(var1, var2, var3 - 4, var4 + 5 + var6, var5, 3);
         this.createRainForestLeaves(var1, var2, var3 - 4, var4 + 6 + var6, var5, 2);

         for(var7 = 0; var7 <= var6; ++var7) {
            var1.func_94575_c(var3 - 4, var4 + 4 + var7, var5, Block.field_71951_J.field_71990_ca);
         }
      }

      if(var2.nextInt(4) == 0) {
         var1.func_94575_c(var3, var4, var5 + 1, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + 1, var5 + 2, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + 2, var5 + 3, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + 3, var5 + 4, Block.field_71951_J.field_71990_ca);
         var6 = 1 + var2.nextInt(5);
         this.createRainForestLeaves(var1, var2, var3, var4 + 4 + var6, var5 + 4, 2);
         this.createRainForestLeaves(var1, var2, var3, var4 + 5 + var6, var5 + 4, 3);
         this.createRainForestLeaves(var1, var2, var3, var4 + 6 + var6, var5 + 4, 2);

         for(var7 = 0; var7 <= var6; ++var7) {
            var1.func_94575_c(var3, var4 + 4 + var7, var5 + 4, Block.field_71951_J.field_71990_ca);
         }
      }

      if(var2.nextInt(4) == 0) {
         var1.func_94575_c(var3, var4, var5 - 1, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + 1, var5 - 2, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + 2, var5 - 3, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3, var4 + 3, var5 - 4, Block.field_71951_J.field_71990_ca);
         var6 = 1 + var2.nextInt(5);
         this.createRainForestLeaves(var1, var2, var3, var4 + 4 + var6, var5 - 4, 2);
         this.createRainForestLeaves(var1, var2, var3, var4 + 5 + var6, var5 - 4, 3);
         this.createRainForestLeaves(var1, var2, var3, var4 + 6 + var6, var5 - 4, 2);

         for(var7 = 0; var7 <= var6; ++var7) {
            var1.func_94575_c(var3, var4 + 4 + var7, var5 - 4, Block.field_71951_J.field_71990_ca);
         }
      }

   }

   private void createRainForestLeaves(World var1, Random var2, int var3, int var4, int var5, int var6) {
      for(int var7 = -var6 + var3; var7 < var6 + 1 + var3; ++var7) {
         for(int var8 = -var6 + var5; var8 < var6 + 1 + var5; ++var8) {
            int var9 = var1.func_72798_a(var7, var4, var8);
            if(var9 == 0 && (var7 != -var6 + var3 || var8 != -var6 + var5) && (var7 != -var6 + var3 || var8 != var6 + var5) && (var7 != var6 + var3 || var8 != -var6 + var5) && (var7 != var6 + var3 || var8 != var6 + var5)) {
               var1.func_94575_c(var7, var4, var8, Block.field_71952_K.field_71990_ca);
            }
         }
      }

   }

   private ItemStack getChestList(int var1, Random var2, World var3) {
      return null;
   }
}
