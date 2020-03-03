package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoSurvival extends WorldGenerator {

   private int survivalobject;


   public BWG4decoSurvival(int var1) {
      this.survivalobject = var1;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      int var7;
      int var8;
      int var9;
      int var10;
      int var11;
      if(this.survivalobject == 1) {
         for(var6 = 0 + var3; var6 <= 2 + var3; ++var6) {
            for(var7 = 0 + var5; var7 <= 2 + var5; ++var7) {
               for(var8 = -2 + var4; var8 <= 0 + var4; ++var8) {
                  if(var8 == 0 + var4) {
                     var1.func_94575_c(var6, var8, var7, Block.field_71980_u.field_71990_ca);
                  } else {
                     var1.func_94575_c(var6, var8, var7, Block.field_71979_v.field_71990_ca);
                  }
               }
            }
         }

         var6 = var3 + 1;
         var7 = var4 + 1;
         var8 = var5 + 1;

         for(var9 = var6 - 2; var9 <= var6 + 2; ++var9) {
            for(var10 = var8 - 2; var10 <= var8 + 2; ++var10) {
               for(var11 = var7 + 2; var11 <= var7 + 3; ++var11) {
                  var1.func_94575_c(var9, var11, var10, Block.field_71952_K.field_71990_ca);
               }
            }
         }

         for(var9 = var6 - 1; var9 <= var6 + 1; ++var9) {
            for(var10 = var8 - 1; var10 <= var8 + 1; ++var10) {
               var1.func_94575_c(var9, var7 + 4, var10, Block.field_71952_K.field_71990_ca);
            }
         }

         for(var9 = var7; var9 <= var7 + 4; ++var9) {
            var1.func_94575_c(var6, var9, var8, Block.field_71951_J.field_71990_ca);
         }

         var1.func_94575_c(var6 + 1, var7 + 5, var8, Block.field_71952_K.field_71990_ca);
         var1.func_94575_c(var6 - 1, var7 + 5, var8, Block.field_71952_K.field_71990_ca);
         var1.func_94575_c(var6, var7 + 5, var8 + 1, Block.field_71952_K.field_71990_ca);
         var1.func_94575_c(var6, var7 + 5, var8 - 1, Block.field_71952_K.field_71990_ca);
         var1.func_94575_c(var6, var7 + 5, var8, Block.field_71952_K.field_71990_ca);
         var1.func_94575_c(var6 - 1, var7, var8, Block.field_72077_au.field_71990_ca);
         TileEntityChest var23 = (TileEntityChest)var1.func_72796_p(var6 - 1, var7, var8);

         for(var10 = 0; var10 < 20; ++var10) {
            ItemStack var24 = this.getChestList(var10, 1, var2, var1);
            if(var23 != null && var24 != null) {
               var23.func_70299_a(var10, var24);
            }
         }
      } else {
         int var12;
         int var13;
         int var14;
         int var16;
         if(this.survivalobject == 2) {
            var6 = var2.nextInt(4) + 6;
            var7 = 1 + var2.nextInt(2);
            var8 = var6 - var7;
            var9 = 2 + var2.nextInt(2);
            boolean var26 = true;
            if(var4 >= 1 && var4 + var6 + 1 <= 256) {
               for(var11 = var4; var11 <= var4 + 1 + var6 && var26; ++var11) {
                  boolean var27 = true;
                  if(var11 - var4 < var7) {
                     var14 = 0;
                  } else {
                     var14 = var9;
                  }

                  for(var12 = var3 - var14; var12 <= var3 + var14 && var26; ++var12) {
                     for(var16 = var5 - var14; var16 <= var5 + var14 && var26; ++var16) {
                        if(var11 >= 0 && var11 < 256) {
                           var13 = var1.func_72798_a(var12, var11, var16);
                           if(var13 != 0 && var13 != Block.field_72014_bd.field_71990_ca) {
                              var26 = false;
                           }
                        } else {
                           var26 = false;
                        }
                     }
                  }
               }

               if(!var26) {
                  return false;
               }

               var11 = var1.func_72798_a(var3, var4 - 1, var5);
               if(var11 == Block.field_72012_bb.field_71990_ca && var4 < 256 - var6 - 1) {
                  this.func_76486_a(var1, var3, var4 - 1, var5, Block.field_72012_bb.field_71990_ca);
                  var14 = var2.nextInt(2);
                  var12 = 1;
                  byte var28 = 0;

                  int var29;
                  for(var13 = 0; var13 <= var8; ++var13) {
                     var29 = var4 + var6 - var13;

                     for(var16 = var3 - var14; var16 <= var3 + var14; ++var16) {
                        int var18 = var16 - var3;

                        for(int var19 = var5 - var14; var19 <= var5 + var14; ++var19) {
                           int var20 = var19 - var5;
                           if((Math.abs(var18) != var14 || Math.abs(var20) != var14 || var14 <= 0) && !Block.field_71970_n[var1.func_72798_a(var16, var29, var19)]) {
                              this.func_76485_a(var1, var16, var29, var19, Block.field_72014_bd.field_71990_ca, 0);
                           }
                        }
                     }

                     if(var14 >= var12) {
                        var14 = var28;
                        var28 = 1;
                        ++var12;
                        if(var12 > var9) {
                           var12 = var9;
                        }
                     } else {
                        ++var14;
                     }
                  }

                  var13 = var2.nextInt(3);

                  for(var29 = 0; var29 < var6 - var13; ++var29) {
                     var16 = var1.func_72798_a(var3, var4 + var29, var5);
                     if(var16 == 0 || var16 == Block.field_72014_bd.field_71990_ca) {
                        this.func_76485_a(var1, var3, var4 + var29, var5, Block.field_72013_bc.field_71990_ca, 0);
                     }
                  }

                  return true;
               }

               return false;
            }

            return false;
         }

         if(this.survivalobject == 3) {
            for(var6 = 0; var6 < 64; ++var6) {
               var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
               var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
               var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
               if(var1.func_72799_c(var7, var8, var9) && var1.func_72798_a(var7, var8 - 1, var9) == Block.field_72012_bb.field_71990_ca) {
                  var1.func_94575_c(var7, var8 - 1, var9, Block.field_72013_bc.field_71990_ca);
                  var1.func_72832_d(var7, var8, var9, Block.field_72094_bD.field_71990_ca, 1, 0);
               }
            }

            return true;
         }

         if(this.survivalobject == 4) {
            var6 = var1.func_72798_a(var3, var4 - 1, var5);
            if(var6 != Block.field_71980_u.field_71990_ca && var6 != Block.field_71939_E.field_71990_ca) {
               return false;
            }

            var7 = var2.nextInt(5) + 6;

            for(var8 = 0 + var4; var8 < var7 + var4; ++var8) {
               if(var1.func_72799_c(var3, var8, var5)) {
                  var1.func_72832_d(var3, var8, var5, Block.field_71951_J.field_71990_ca, 3, 0);
               }
            }

            if(var1.func_72799_c(var3, var4 + var7, var5)) {
               var1.func_72832_d(var3, var4 + var7, var5, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3, var4 + var7 - 1, var5 + 1)) {
               var1.func_72832_d(var3, var4 + var7 - 1, var5 + 1, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3, var4 + var7 - 1, var5 - 1)) {
               var1.func_72832_d(var3, var4 + var7 - 1, var5 - 1, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3 + 1, var4 + var7 - 1, var5)) {
               var1.func_72832_d(var3 + 1, var4 + var7 - 1, var5, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3 - 1, var4 + var7 - 1, var5)) {
               var1.func_72832_d(var3 - 1, var4 + var7 - 1, var5, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3, var4 + var7 - 1, var5 + 2)) {
               var1.func_72832_d(var3, var4 + var7 - 1, var5 + 2, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3, var4 + var7 - 1, var5 - 2)) {
               var1.func_72832_d(var3, var4 + var7 - 1, var5 - 2, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3 + 2, var4 + var7 - 1, var5)) {
               var1.func_72832_d(var3 + 2, var4 + var7 - 1, var5, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3 - 2, var4 + var7 - 1, var5)) {
               var1.func_72832_d(var3 - 2, var4 + var7 - 1, var5, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3, var4 + var7 - 2, var5 + 3)) {
               var1.func_72832_d(var3, var4 + var7 - 2, var5 + 3, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3, var4 + var7 - 2, var5 - 3)) {
               var1.func_72832_d(var3, var4 + var7 - 2, var5 - 3, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3 + 3, var4 + var7 - 2, var5)) {
               var1.func_72832_d(var3 + 3, var4 + var7 - 2, var5, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            if(var1.func_72799_c(var3 - 3, var4 + var7 - 2, var5)) {
               var1.func_72832_d(var3 - 3, var4 + var7 - 2, var5, Block.field_71952_K.field_71990_ca, 3, 0);
            }

            return true;
         }

         if(this.survivalobject == 5) {
            var6 = var1.func_72798_a(var3, var4 + 1, var5);
            if(var6 != Block.field_71981_t.field_71990_ca) {
               return false;
            }

            var7 = var2.nextInt(7) + 6;

            for(var8 = var4 - var7; var8 < 128; ++var8) {
               if(var8 >= 1) {
                  if(!var1.func_72799_c(var3, var8, var5)) {
                     break;
                  }

                  var1.func_94575_c(var3, var8, var5, Block.field_72036_aT.field_71990_ca);
               }
            }
         } else if(this.survivalobject == 6) {
            var6 = var3 + 5;
            var7 = var4 + 13;
            var8 = var5 + 1;

            for(var9 = var6 - 2; var9 <= var6 + 2; ++var9) {
               for(var10 = var8 - 2; var10 <= var8 + 2; ++var10) {
                  for(var11 = var7 + 2; var11 <= var7 + 3; ++var11) {
                     var1.func_94575_c(var9, var11, var10, Block.field_71952_K.field_71990_ca);
                  }
               }
            }

            for(var9 = var6 - 1; var9 <= var6 + 1; ++var9) {
               for(var10 = var8 - 1; var10 <= var8 + 1; ++var10) {
                  var1.func_94575_c(var9, var7 + 4, var10, Block.field_71952_K.field_71990_ca);
               }
            }

            for(var9 = var7; var9 <= var7 + 4; ++var9) {
               var1.func_94575_c(var6, var9, var8, Block.field_71951_J.field_71990_ca);
            }

            var1.func_94575_c(var6 + 1, var7 + 5, var8, Block.field_71952_K.field_71990_ca);
            var1.func_94575_c(var6 - 1, var7 + 5, var8, Block.field_71952_K.field_71990_ca);
            var1.func_94575_c(var6, var7 + 5, var8 + 1, Block.field_71952_K.field_71990_ca);
            var1.func_94575_c(var6, var7 + 5, var8 - 1, Block.field_71952_K.field_71990_ca);
            var1.func_94575_c(var6, var7 + 5, var8, Block.field_71952_K.field_71990_ca);
            var9 = var3 - 1;
            var10 = var4 + 10;
            var11 = var5 - 5;

            for(var12 = 0 + var9; var12 <= var9 + 6; ++var12) {
               for(var13 = 0 + var10; var13 <= var10 + 2; ++var13) {
                  for(var14 = 0 + var11; var14 <= var11 + 6; ++var14) {
                     if(var13 == 2 + var10) {
                        var1.func_94575_c(var12, var13, var14, Block.field_71980_u.field_71990_ca);
                     } else {
                        var1.func_94575_c(var12, var13, var14, Block.field_71979_v.field_71990_ca);
                     }
                  }
               }
            }

            for(var12 = 0 + var9 + 3; var12 <= var9 + 6; ++var12) {
               for(var13 = 0 + var10; var13 <= var10 + 2; ++var13) {
                  for(var14 = 0 + var11; var14 <= var11 + 3; ++var14) {
                     var1.func_94575_c(var12, var13, var14, 0);
                  }
               }
            }

            var1.func_94575_c(var9 + 1, var10, var11 + 5, Block.field_71986_z.field_71990_ca);
            var1.func_94575_c(var9 + 1, var10 + 3, var11, Block.field_72077_au.field_71990_ca);
            TileEntityChest var15 = (TileEntityChest)var1.func_72796_p(var9 + 1, var10 + 3, var11);

            for(var16 = 0; var16 < 20; ++var16) {
               ItemStack var17 = this.getChestList(var16, 2, var2, var1);
               if(var15 != null && var17 != null) {
                  var15.func_70299_a(var16, var17);
               }
            }
         } else {
            TileEntityChest var21;
            ItemStack var22;
            if(this.survivalobject == 7) {
               var1.func_94575_c(var3 + 1, var4 + 2, var5 + 1, Block.field_72038_aV.field_71990_ca);
               var1.func_94575_c(var3, var4 + 2, var5, Block.field_72077_au.field_71990_ca);
               var21 = (TileEntityChest)var1.func_72796_p(var3, var4 + 2, var5);

               for(var7 = 0; var7 < 20; ++var7) {
                  var22 = this.getChestList(var7, 3, var2, var1);
                  if(var21 != null && var22 != null) {
                     var21.func_70299_a(var7, var22);
                  }
               }

               for(var7 = -1 + var3; var7 <= 1 + var3; ++var7) {
                  for(var8 = -2 + var4; var8 <= 1 + var4; ++var8) {
                     for(var9 = -1 + var5; var9 <= 1 + var5; ++var9) {
                        if(var8 == -2 + var4) {
                           var1.func_94575_c(var7, var8, var9, Block.field_71957_Q.field_71990_ca);
                        } else {
                           var1.func_94575_c(var7, var8, var9, Block.field_71939_E.field_71990_ca);
                        }
                     }
                  }
               }
            } else if(this.survivalobject == 8) {
               for(var6 = -1 + var3; var6 <= 1 + var3; ++var6) {
                  for(var7 = -1 + var4; var7 <= 1 + var4; ++var7) {
                     for(var8 = -1 + var5; var8 <= 1 + var5; ++var8) {
                        var1.func_94575_c(var6, var7, var8, Block.field_72014_bd.field_71990_ca);
                     }
                  }
               }

               var1.func_94575_c(var3, var4 + 2, var5 + 1, Block.field_72109_af.field_71990_ca);
               var1.func_94575_c(var3 + 1, var4 + 2, var5, Block.field_72103_ag.field_71990_ca);
               var1.func_94575_c(var3 - 1, var4 + 2, var5 - 1, Block.field_72077_au.field_71990_ca);
               var21 = (TileEntityChest)var1.func_72796_p(var3 - 1, var4 + 2, var5 - 1);

               for(var7 = 0; var7 < 20; ++var7) {
                  var22 = this.getChestList(var7, 4, var2, var1);
                  if(var21 != null && var22 != null) {
                     var21.func_70299_a(var7, var22);
                  }
               }
            } else if(this.survivalobject > 8 && this.survivalobject < 12) {
               for(var6 = var3 - 1; var6 < 2 + var3; ++var6) {
                  for(var7 = var5 - 1; var7 < 2 + var5; ++var7) {
                     for(var8 = var4; var8 < 3 + var4; ++var8) {
                        if(var8 == 2 + var4) {
                           var1.func_94575_c(var6, var8, var7, Block.field_71980_u.field_71990_ca);
                        } else {
                           var1.func_94575_c(var6, var8, var7, Block.field_71979_v.field_71990_ca);
                        }
                     }
                  }
               }

               var1.func_94575_c(var3, var4 + 3, var5, Block.field_72077_au.field_71990_ca);
               var21 = (TileEntityChest)var1.func_72796_p(var3, var4 + 3, var5);

               for(var7 = 0; var7 < 20; ++var7) {
                  var22 = this.getChestList(var7, this.survivalobject - 4, var2, var1);
                  if(var21 != null && var22 != null) {
                     var21.func_70299_a(var7, var22);
                  }
               }
            } else if(this.survivalobject == 12) {
               for(var6 = var3 - 1; var6 < 2 + var3; ++var6) {
                  for(var7 = var5 - 1; var7 < 2 + var5; ++var7) {
                     for(var8 = var4; var8 < 4 + var4; ++var8) {
                        if(var8 == 3 + var4) {
                           var1.func_94575_c(var6, var8, var7, Block.field_72094_bD.field_71990_ca);
                        } else {
                           var1.func_94575_c(var6, var8, var7, Block.field_72013_bc.field_71990_ca);
                        }
                     }
                  }
               }
            } else if(this.survivalobject > 19 && this.survivalobject < 28) {
               var6 = 0;
               byte var25 = 1;
               if(this.survivalobject == 20) {
                  var6 = Block.field_71950_I.field_71990_ca;
                  var25 = 3;
               }

               if(this.survivalobject == 21) {
                  var6 = Block.field_71949_H.field_71990_ca;
                  var25 = 3;
               }

               if(this.survivalobject == 22) {
                  var6 = Block.field_71947_N.field_71990_ca;
                  var25 = 2;
               }

               if(this.survivalobject == 23) {
                  var6 = Block.field_71941_G.field_71990_ca;
                  var25 = 2;
               }

               if(this.survivalobject == 24) {
                  var6 = Block.field_72047_aN.field_71990_ca;
                  var25 = 3;
               }

               if(this.survivalobject == 26) {
                  var6 = Block.field_72073_aw.field_71990_ca;
                  var25 = 2;
               }

               if(this.survivalobject == 27) {
                  var6 = Block.field_72068_bR.field_71990_ca;
                  var25 = 2;
               }

               for(var8 = var3; var8 < var25 + var3; ++var8) {
                  for(var9 = var4; var9 < var25 + var4; ++var9) {
                     for(var10 = var5; var10 < var25 + var5; ++var10) {
                        if(var2.nextInt(3) != 0) {
                           var1.func_72832_d(var8, var9, var10, Block.field_71981_t.field_71990_ca, 0, 2);
                        } else {
                           var1.func_72832_d(var8, var9, var10, var6, 0, 2);
                        }
                     }
                  }
               }
            }
         }
      }

      return true;
   }

   private ItemStack getChestList(int var1, int var2, Random var3, World var4) {
      return var2 == 1?(var1 == 0?new ItemStack(Item.field_77690_S, 5):(var1 == 1?new ItemStack(Block.field_72038_aV):(var1 == 2?new ItemStack(Item.field_77683_K, 2):(var1 == 3?new ItemStack(Block.field_72109_af, 1):(var1 == 4?new ItemStack(Block.field_72103_ag, 1):null))))):(var2 == 2?(var1 == 0?new ItemStack(Block.field_72036_aT):(var1 == 1?new ItemStack(Item.field_77775_ay):null)):(var2 == 3?(var1 == 0?new ItemStack(Block.field_72089_ap, 10):(var1 == 1?new ItemStack(Item.field_77738_bf):(var1 == 2?new ItemStack(Item.field_77739_bg):null))):(var2 == 4?(var1 == 0?new ItemStack(Item.field_77690_S, 3):(var1 == 1?new ItemStack(Item.field_77758_aJ):(var1 == 2?new ItemStack(Block.field_72036_aT):(var1 == 3?new ItemStack(Block.field_71987_y, 1, 3):null)))):(var2 == 5?(var1 == 0?new ItemStack(Block.field_71987_y, 1, 1):(var1 == 1?new ItemStack(Block.field_72039_aU, 2):null)):(var2 == 6?(var1 == 0?new ItemStack(Block.field_71987_y, 1, 2):(var1 == 1?new ItemStack(Item.field_77758_aJ, 1):(var1 == 2?new ItemStack(Item.field_77815_bC, 2, 92):null))):(var2 == 7?(var1 == 0?new ItemStack(Item.field_82794_bL, 1):(var1 == 1?new ItemStack(Item.field_82797_bK, 1):(var1 == 2?new ItemStack(Item.field_77815_bC, 1, 93):null))):null))))));
   }
}
