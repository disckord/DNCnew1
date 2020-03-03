package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntityChest;
import net.minecraft.src.TileEntityMobSpawner;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoDungeons extends WorldGenerator {

   public int chestID = 0;
   public boolean checkpos = true;
   public boolean isSkyDungeon = false;
   public boolean isEndDungeon = false;
   public boolean specialChest = false;


   public BWG4decoDungeons(int var1, boolean var2, boolean var3, boolean var4) {
      this.chestID = var1;
      this.checkpos = var2;
      this.isSkyDungeon = var3;
      this.isEndDungeon = var4;
      if(var1 == 9 || var1 == 10) {
         this.specialChest = true;
      }

   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var10;
      int var11;
      int var12;
      int var14;
      if(!this.isSkyDungeon && !this.isEndDungeon) {
         byte var18 = 3;
         int var19 = var2.nextInt(2) + 2;
         int var20 = var2.nextInt(2) + 2;
         int var21 = 0;
         if(this.checkpos) {
            for(var10 = var3 - var19 - 1; var10 <= var3 + var19 + 1; ++var10) {
               for(var11 = var4 - 1; var11 <= var4 + var18 + 1; ++var11) {
                  for(var12 = var5 - var20 - 1; var12 <= var5 + var20 + 1; ++var12) {
                     Material var23 = var1.func_72803_f(var10, var11, var12);
                     if(var11 == var4 - 1 && !var23.func_76220_a()) {
                        return false;
                     }

                     if(var11 == var4 + var18 + 1 && !var23.func_76220_a()) {
                        return false;
                     }

                     if((var10 == var3 - var19 - 1 || var10 == var3 + var19 + 1 || var12 == var5 - var20 - 1 || var12 == var5 + var20 + 1) && var11 == var4 && var1.func_72799_c(var10, var11, var12) && var1.func_72799_c(var10, var11 + 1, var12)) {
                        ++var21;
                     }
                  }
               }
            }
         }

         if((var21 < 1 || var21 > 5) && this.checkpos) {
            return false;
         } else {
            for(var10 = var3 - var19 - 1; var10 <= var3 + var19 + 1; ++var10) {
               for(var11 = var4 + var18; var11 >= var4 - 1; --var11) {
                  for(var12 = var5 - var20 - 1; var12 <= var5 + var20 + 1; ++var12) {
                     if(var10 != var3 - var19 - 1 && var11 != var4 - 1 && var12 != var5 - var20 - 1 && var10 != var3 + var19 + 1 && var11 != var4 + var18 + 1 && var12 != var5 + var20 + 1) {
                        var1.func_94575_c(var10, var11, var12, 0);
                     } else if(var11 >= 0 && !var1.func_72803_f(var10, var11 - 1, var12).func_76220_a()) {
                        var1.func_94575_c(var10, var11, var12, 0);
                     } else if(var1.func_72803_f(var10, var11, var12).func_76220_a()) {
                        if(var11 == var4 - 1 && var2.nextInt(4) != 0) {
                           var1.func_94575_c(var10, var11, var12, Block.field_72087_ao.field_71990_ca);
                        } else {
                           var1.func_94575_c(var10, var11, var12, Block.field_71978_w.field_71990_ca);
                        }
                     }
                  }
               }
            }

            var10 = 0;
            if(this.specialChest) {
               var10 = 1;
            }

            while(var10 < 2) {
               var11 = 0;

               while(true) {
                  if(var11 < 3) {
                     label308: {
                        var12 = var3 + var2.nextInt(var19 * 2 + 1) - var19;
                        int var25 = var5 + var2.nextInt(var20 * 2 + 1) - var20;
                        if(var1.func_72799_c(var12, var4, var25)) {
                           var14 = 0;
                           if(var1.func_72803_f(var12 - 1, var4, var25).func_76220_a()) {
                              ++var14;
                           }

                           if(var1.func_72803_f(var12 + 1, var4, var25).func_76220_a()) {
                              ++var14;
                           }

                           if(var1.func_72803_f(var12, var4, var25 - 1).func_76220_a()) {
                              ++var14;
                           }

                           if(var1.func_72803_f(var12, var4, var25 + 1).func_76220_a()) {
                              ++var14;
                           }

                           if(this.specialChest) {
                              var14 = 1;
                           }

                           if(var14 == 1) {
                              var1.func_94575_c(var12, var4, var25, Block.field_72077_au.field_71990_ca);
                              TileEntityChest var27 = (TileEntityChest)var1.func_72796_p(var12, var4, var25);
                              if(var27 != null) {
                                 int var16;
                                 ItemStack var17;
                                 if(!this.specialChest) {
                                    var16 = 0;

                                    while(true) {
                                       if(var16 >= 14) {
                                          break label308;
                                       }

                                       var17 = this.pickCheckLootItem(var2, 0);
                                       if(var17 != null) {
                                          var27.func_70299_a(var2.nextInt(var27.func_70302_i_()), var17);
                                       }

                                       ++var16;
                                    }
                                 }

                                 for(var16 = 0; var16 < 20; ++var16) {
                                    var17 = this.pickCheckLootItem(var2, var16);
                                    if(var17 != null) {
                                       var27.func_70299_a(var16, var17);
                                    }
                                 }
                              }
                              break label308;
                           }
                        }

                        ++var11;
                        continue;
                     }
                  }

                  ++var10;
                  break;
               }
            }

            var1.func_94575_c(var3, var4, var5, Block.field_72065_as.field_71990_ca);
            TileEntityMobSpawner var26 = (TileEntityMobSpawner)var1.func_72796_p(var3, var4, var5);
            if(var26 != null) {
               var26.func_98049_a().func_98272_a(this.pickMobSpawner(var2));
            } else {
               System.err.println("Failed to fetch mob spawner entity at (" + var3 + ", " + var4 + ", " + var5 + ")");
            }

            return true;
         }
      } else {
         boolean var6 = false;
         boolean var7 = false;
         boolean var8 = false;
         boolean var9 = false;

         for(var10 = var4; var10 < 60; ++var10) {
            if(!var1.func_72799_c(var3 + 4, var10 + 5, var5 + 4)) {
               var6 = true;
               break;
            }
         }

         for(var10 = var4; var10 < 60; ++var10) {
            if(!var1.func_72799_c(var3 + 4, var10 + 5, var5 - 4)) {
               var7 = true;
               break;
            }
         }

         for(var10 = var4; var10 < 60; ++var10) {
            if(!var1.func_72799_c(var3 - 4, var10 + 5, var5 + 4)) {
               var8 = true;
               break;
            }
         }

         for(var10 = var4; var10 < 60; ++var10) {
            if(!var1.func_72799_c(var3 - 4, var10 + 5, var5 - 4)) {
               var9 = true;
               break;
            }
         }

         if(var6 && var7 && var8 && var9) {
            for(var10 = var4 + 5; var10 < 70 && var1.func_72799_c(var3 + 4, var10, var5 + 4); ++var10) {
               var1.func_94575_c(var3 + 4, var10, var5 + 4, Block.field_72002_bp.field_71990_ca);
            }

            for(var10 = var4 + 5; var10 < 70 && var1.func_72799_c(var3 + 4, var10, var5 - 4); ++var10) {
               var1.func_94575_c(var3 + 4, var10, var5 - 4, Block.field_72002_bp.field_71990_ca);
            }

            for(var10 = var4 + 5; var10 < 70 && var1.func_72799_c(var3 - 4, var10, var5 + 4); ++var10) {
               var1.func_94575_c(var3 - 4, var10, var5 + 4, Block.field_72002_bp.field_71990_ca);
            }

            for(var10 = var4 + 5; var10 < 70 && var1.func_72799_c(var3 - 4, var10, var5 - 4); ++var10) {
               var1.func_94575_c(var3 - 4, var10, var5 - 4, Block.field_72002_bp.field_71990_ca);
            }

            if(this.checkpos) {
               var1.func_94575_c(var3 + 4, var4 + 6, var5 + 4, Block.field_72033_bA.field_71990_ca);
               var1.func_94575_c(var3 + 4, var4 + 6, var5 - 4, Block.field_72033_bA.field_71990_ca);
               var1.func_94575_c(var3 - 4, var4 + 6, var5 + 4, Block.field_72033_bA.field_71990_ca);
               var1.func_94575_c(var3 - 4, var4 + 6, var5 - 4, Block.field_72033_bA.field_71990_ca);
            } else {
               var1.func_94575_c(var3 + 4, var4 + 6, var5 + 4, Block.field_72087_ao.field_71990_ca);
               var1.func_94575_c(var3 + 4, var4 + 6, var5 - 4, Block.field_72087_ao.field_71990_ca);
               var1.func_94575_c(var3 - 4, var4 + 6, var5 + 4, Block.field_72087_ao.field_71990_ca);
               var1.func_94575_c(var3 - 4, var4 + 6, var5 - 4, Block.field_72087_ao.field_71990_ca);
            }

            for(var10 = var3 - 4; var10 < var3 + 5; ++var10) {
               for(var11 = var4; var11 < var4 + 6; ++var11) {
                  for(var12 = var5 - 4; var12 < var5 + 5; ++var12) {
                     if(var2.nextInt(10) == 0) {
                        var1.func_94575_c(var10, var11, var12, 0);
                     } else if(this.checkpos) {
                        var1.func_94575_c(var10, var11, var12, Block.field_72033_bA.field_71990_ca);
                     } else if(var2.nextInt(2) != 0) {
                        var1.func_94575_c(var10, var11, var12, Block.field_72087_ao.field_71990_ca);
                     } else {
                        var1.func_94575_c(var10, var11, var12, Block.field_71978_w.field_71990_ca);
                     }
                  }
               }
            }

            for(var10 = var3 - 3; var10 < var3 + 4; ++var10) {
               for(var11 = var4 + 1; var11 < var4 + 5; ++var11) {
                  for(var12 = var5 - 3; var12 < var5 + 4; ++var12) {
                     var1.func_94575_c(var10, var11, var12, 0);
                  }
               }
            }

            TileEntityMobSpawner var28;
            if(this.isEndDungeon) {
               var1.func_72832_d(var3 + 2, var4 + 1, var5 - 1, Block.field_72104_bI.field_71990_ca, 1 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 + 2, var4 + 1, var5 + 0, Block.field_72104_bI.field_71990_ca, 1 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 + 2, var4 + 1, var5 + 1, Block.field_72104_bI.field_71990_ca, 1 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 - 1, var4 + 1, var5 + 2, Block.field_72104_bI.field_71990_ca, 2 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 + 0, var4 + 1, var5 + 2, Block.field_72104_bI.field_71990_ca, 2 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 + 1, var4 + 1, var5 + 2, Block.field_72104_bI.field_71990_ca, 2 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 - 2, var4 + 1, var5 - 1, Block.field_72104_bI.field_71990_ca, 3 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 - 2, var4 + 1, var5 + 0, Block.field_72104_bI.field_71990_ca, 3 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 - 2, var4 + 1, var5 + 1, Block.field_72104_bI.field_71990_ca, 3 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 - 1, var4 + 1, var5 - 2, Block.field_72104_bI.field_71990_ca, 0 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 + 0, var4 + 1, var5 - 2, Block.field_72104_bI.field_71990_ca, 0 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_72832_d(var3 + 1, var4 + 1, var5 - 2, Block.field_72104_bI.field_71990_ca, 0 + (var2.nextFloat() > 0.9F?4:0), 0);
               var1.func_94575_c(var3, var4 + 6, var5, Block.field_72065_as.field_71990_ca);
               var28 = (TileEntityMobSpawner)var1.func_72796_p(var3, var4 + 6, var5);
               if(var28 != null) {
                  var28.func_98049_a().func_98272_a(this.pickMobSpawner(var2));
               }
            } else {
               var1.func_94575_c(var3, var4 + 1, var5, Block.field_72065_as.field_71990_ca);
               var1.func_94575_c(var3, var4 + 3, var5, Block.field_72065_as.field_71990_ca);
               var1.func_94575_c(var3, var4 + 6, var5, Block.field_72065_as.field_71990_ca);
               var28 = (TileEntityMobSpawner)var1.func_72796_p(var3, var4 + 1, var5);
               TileEntityMobSpawner var22 = (TileEntityMobSpawner)var1.func_72796_p(var3, var4 + 3, var5);
               TileEntityMobSpawner var24 = (TileEntityMobSpawner)var1.func_72796_p(var3, var4 + 6, var5);
               if(var28 != null) {
                  var28.func_98049_a().func_98272_a(this.pickMobSpawner(var2));
               }

               if(var22 != null) {
                  var22.func_98049_a().func_98272_a(this.pickMobSpawner(var2));
               }

               if(var24 != null) {
                  var24.func_98049_a().func_98272_a(this.pickMobSpawner(var2));
               }

               var1.func_94575_c(var3, var4 + 2, var5, Block.field_72077_au.field_71990_ca);
               TileEntityChest var13 = (TileEntityChest)var1.func_72796_p(var3, var4 + 2, var5);
               ItemStack var15;
               if(this.specialChest) {
                  for(var14 = 0; var14 < 20; ++var14) {
                     var15 = this.pickCheckLootItem(var2, var14);
                     if(var15 != null) {
                        var13.func_70299_a(var14, var15);
                     }
                  }
               } else {
                  for(var14 = 0; var14 < 14; ++var14) {
                     var15 = this.pickCheckLootItem(var2, 0);
                     if(var15 != null) {
                        var13.func_70299_a(var2.nextInt(var13.func_70302_i_()), var15);
                     }
                  }
               }
            }

            return false;
         } else {
            return false;
         }
      }
   }

   private ItemStack pickCheckLootItem(Random var1, int var2) {
      int var3;
      if(this.chestID == 0) {
         var3 = var1.nextInt(17);
         return var3 == 0 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 1 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 2 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 3 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 4 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 5?new ItemStack(Item.field_77765_aA):(var3 == 6?new ItemStack(Item.field_77677_M, var1.nextInt(4) + 1):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_82798_bP):(var3 == 8 && var1.nextInt(3) == 0?new ItemStack(Item.field_77778_at):(var3 == 9?new ItemStack(Item.field_77703_o, var1.nextInt(4) + 1):(var3 == 10?new ItemStack(Item.field_77684_U):(var3 == 11?new ItemStack(Item.field_77685_T, var1.nextInt(4) + 1):(var3 == 12?new ItemStack(Item.field_77683_K, var1.nextInt(4) + 1):(var3 == 13?new ItemStack(Item.field_77788_aw):(var3 == 14?new ItemStack(Item.field_77767_aC, var1.nextInt(4) + 1):(var3 == 15?new ItemStack(Item.field_77756_aW, 1, 3):(var3 == 16?Item.field_92105_bW.func_92109_a(var1):null))))))))))))))));
      } else if(this.chestID == 1) {
         var3 = var1.nextInt(16);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2?new ItemStack(Item.field_77817_bH, var1.nextInt(4) + 1):(var3 == 3?new ItemStack(Item.field_77740_bh, var1.nextInt(4) + 1):(var3 == 4?new ItemStack(Item.field_77739_bg, var1.nextInt(4) + 1):(var3 == 5?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 8?new ItemStack(Item.field_77765_aA):(var3 == 9 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 10 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 11 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 12 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 13?new ItemStack(Block.field_71987_y, 1, 3):(var3 == 14?Item.field_92105_bW.func_92109_a(var1):(var3 == 15?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):null)))))))))))))));
      } else if(this.chestID == 2) {
         var3 = var1.nextInt(16);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 3 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 4?new ItemStack(Item.field_77765_aA):(var3 == 5 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 8 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 9?Item.field_92105_bW.func_92109_a(var1):(var3 == 10?new ItemStack(Item.field_77788_aw):(var3 == 11?new ItemStack(Item.field_77767_aC, var1.nextInt(4) + 1):(var3 == 12?new ItemStack(Item.field_77685_T, var1.nextInt(4) + 1):(var3 == 13?new ItemStack(Item.field_77677_M, var1.nextInt(4) + 1):(var3 == 14?new ItemStack(Item.field_77703_o, var1.nextInt(4) + 1):(var3 == 15?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):null)))))))))))))));
      } else if(this.chestID == 3) {
         var3 = var1.nextInt(19);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2?new ItemStack(Item.field_77817_bH, var1.nextInt(4) + 1):(var3 == 3?new ItemStack(Item.field_77740_bh, var1.nextInt(4) + 1):(var3 == 4?new ItemStack(Item.field_77739_bg, var1.nextInt(4) + 1):(var3 == 5?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 8?new ItemStack(Item.field_77765_aA):(var3 == 9 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 10 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 11 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 12 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 13?new ItemStack(Block.field_71987_y, 1, var1.nextInt(3) + 1):(var3 == 14?Item.field_92105_bW.func_92109_a(var1):(var3 != 15 && var3 != 16 && var3 != 17?(var3 == 18?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):null):new ItemStack(Item.field_77690_S, var1.nextInt(12) + 1))))))))))))))));
      } else if(this.chestID == 4) {
         var3 = var1.nextInt(22);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2?new ItemStack(Item.field_77817_bH, var1.nextInt(4) + 1):(var3 == 3?new ItemStack(Item.field_77740_bh, var1.nextInt(4) + 1):(var3 == 4?new ItemStack(Item.field_77739_bg, var1.nextInt(4) + 1):(var3 == 5?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 8?new ItemStack(Item.field_77765_aA):(var3 == 9 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 10 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 11 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 12 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 13?new ItemStack(Block.field_71987_y, 1, var1.nextInt(3) + 1):(var3 == 14?Item.field_92105_bW.func_92109_a(var1):(var3 != 15 && var3 != 16 && var3 != 17?(var3 == 18?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):(var3 == 19?new ItemStack(Block.field_72038_aV, var1.nextInt(4) + 1):(var3 == 20?new ItemStack(Item.field_77758_aJ, var1.nextInt(4) + 1):(var3 == 21?new ItemStack(Block.field_72039_aU, var1.nextInt(12) + 1):null)))):new ItemStack(Item.field_77690_S, var1.nextInt(12) + 1))))))))))))))));
      } else if(this.chestID == 5) {
         var3 = var1.nextInt(23);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2?new ItemStack(Item.field_77817_bH, var1.nextInt(4) + 1):(var3 == 3?new ItemStack(Item.field_77740_bh, var1.nextInt(4) + 1):(var3 == 4?new ItemStack(Item.field_77739_bg, var1.nextInt(4) + 1):(var3 == 5?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 8?new ItemStack(Item.field_77765_aA):(var3 == 9 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 10 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 11 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 12 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 13?new ItemStack(Block.field_71987_y, 1, var1.nextInt(3) + 1):(var3 == 14?Item.field_92105_bW.func_92109_a(var1):(var3 != 15 && var3 != 16 && var3 != 17?(var3 == 18?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):(var3 == 19?new ItemStack(Block.field_72038_aV, var1.nextInt(4) + 1):(var3 == 20?new ItemStack(Item.field_77758_aJ, var1.nextInt(4) + 1):(var3 == 21?new ItemStack(Item.field_77772_aH, var1.nextInt(63) + 1):(var3 == 22?new ItemStack(Block.field_72039_aU, var1.nextInt(12) + 1):null))))):new ItemStack(Item.field_77690_S, var1.nextInt(12) + 1))))))))))))))));
      } else if(this.chestID == 6) {
         var3 = var1.nextInt(23);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2?new ItemStack(Item.field_77817_bH, var1.nextInt(4) + 1):(var3 == 3?new ItemStack(Item.field_77740_bh, var1.nextInt(4) + 1):(var3 == 4?new ItemStack(Item.field_77739_bg, var1.nextInt(4) + 1):(var3 == 5?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 8?new ItemStack(Item.field_77765_aA):(var3 == 9 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 10 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 11 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 12 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 13?new ItemStack(Block.field_71987_y, 1, var1.nextInt(3) + 1):(var3 == 14?Item.field_92105_bW.func_92109_a(var1):(var3 != 15 && var3 != 16 && var3 != 17?(var3 == 18?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):(var3 == 19?new ItemStack(Block.field_72038_aV, var1.nextInt(4) + 1):(var3 == 20?new ItemStack(Item.field_77758_aJ, var1.nextInt(4) + 1):(var3 == 21?new ItemStack(Item.field_77772_aH, var1.nextInt(63) + 1):(var3 == 22?new ItemStack(Block.field_72039_aU, var1.nextInt(12) + 1):null))))):new ItemStack(Item.field_77690_S, var1.nextInt(12) + 1))))))))))))))));
      } else if(this.chestID == 7) {
         var3 = var1.nextInt(18);
         return var3 == 0 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 1 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 2 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 3 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 4 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 5?new ItemStack(Item.field_77765_aA):(var3 == 6?new ItemStack(Item.field_77677_M, var1.nextInt(4) + 1):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_82798_bP):(var3 == 8 && var1.nextInt(3) == 0?new ItemStack(Item.field_77778_at):(var3 == 9?new ItemStack(Item.field_77703_o, var1.nextInt(4) + 1):(var3 == 10?new ItemStack(Item.field_77684_U):(var3 == 11?new ItemStack(Item.field_77685_T, var1.nextInt(4) + 1):(var3 == 12?new ItemStack(Item.field_77683_K, var1.nextInt(4) + 1):(var3 == 13?new ItemStack(Item.field_77788_aw):(var3 == 14?new ItemStack(Item.field_77767_aC, var1.nextInt(4) + 1):(var3 == 15?new ItemStack(Item.field_77756_aW, 1, 3):(var3 == 16?Item.field_92105_bW.func_92109_a(var1):(var3 == 17 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):null)))))))))))))))));
      } else if(this.chestID == 8) {
         var3 = var1.nextInt(19);
         return var3 == 0 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 1 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 2 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 3 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 4 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 5?new ItemStack(Item.field_77765_aA):(var3 == 6?new ItemStack(Item.field_77677_M, var1.nextInt(4) + 1):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_82798_bP):(var3 == 8 && var1.nextInt(3) == 0?new ItemStack(Item.field_77778_at):(var3 == 9?new ItemStack(Item.field_77703_o, var1.nextInt(4) + 1):(var3 == 10?new ItemStack(Item.field_77684_U):(var3 == 11?new ItemStack(Item.field_77685_T, var1.nextInt(4) + 1):(var3 == 12?new ItemStack(Item.field_77683_K, var1.nextInt(4) + 1):(var3 == 13?new ItemStack(Item.field_77788_aw):(var3 == 14?new ItemStack(Item.field_77767_aC, var1.nextInt(4) + 1):(var3 == 15?new ItemStack(Item.field_77756_aW, 1, 3):(var3 == 16?Item.field_92105_bW.func_92109_a(var1):(var3 == 17 && var1.nextInt(3) == 0?new ItemStack(Item.field_77815_bC, 1, 95):(var3 == 18 && var1.nextInt(3) == 0?new ItemStack(Item.field_77815_bC, 1, 98):null))))))))))))))))));
      } else if(this.chestID == 9) {
         return var2 == 0?new ItemStack(Item.field_77740_bh, var1.nextInt(2) + 1):(var2 == 1?new ItemStack(Item.field_77739_bg, var1.nextInt(2) + 1):(var2 == 2?new ItemStack(Block.field_72038_aV, var1.nextInt(4) + 1):(var2 == 3?new ItemStack(Item.field_77758_aJ, var1.nextInt(4) + 1):(var2 == 4?new ItemStack(Item.field_77690_S, 12):(var2 == 5?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var2 == 6?new ItemStack(Item.field_77815_bC, 2, 93):(var2 == 7?new ItemStack(Item.field_77815_bC, 2, 91):null)))))));
      } else if(this.chestID == 10) {
         return var2 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(2) + 1):(var2 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(2) + 1):(var2 == 2?new ItemStack(Block.field_72039_aU, var1.nextInt(12) + 1):(var2 == 3?new ItemStack(Block.field_71994_by):(var2 == 4?new ItemStack(Item.field_77815_bC, 2, 92):(var2 == 5?new ItemStack(Item.field_77815_bC, 2, 90):(var2 == 6?new ItemStack(Item.field_77815_bC, 2, 120):null))))));
      } else if(this.chestID == 11) {
         var3 = var1.nextInt(15);
         return var3 == 0?new ItemStack(Block.field_72038_aV, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_77758_aJ, var1.nextInt(4) + 1):(var3 == 2?new ItemStack(Block.field_71987_y, 1, var1.nextInt(3) + 1):(var3 == 3 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 4 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 5 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 8?new ItemStack(Item.field_77740_bh, var1.nextInt(4) + 1):(var3 == 9?new ItemStack(Item.field_77739_bg, var1.nextInt(4) + 1):(var3 == 10?new ItemStack(Item.field_77684_U):(var3 == 11?new ItemStack(Item.field_77685_T, var1.nextInt(4) + 1):(var3 == 12?new ItemStack(Item.field_77683_K, var1.nextInt(4) + 1):(var3 == 13?new ItemStack(Item.field_77788_aw):(var3 == 14?new ItemStack(Item.field_77767_aC, var1.nextInt(4) + 1):(var3 == 15?new ItemStack(Item.field_77765_aA):null)))))))))))))));
      } else if(this.chestID == 12) {
         var3 = var1.nextInt(16);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2?new ItemStack(Item.field_77817_bH, var1.nextInt(4) + 1):(var3 == 3?new ItemStack(Item.field_77740_bh, var1.nextInt(4) + 1):(var3 == 4?new ItemStack(Item.field_77739_bg, var1.nextInt(4) + 1):(var3 == 5?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 8?new ItemStack(Item.field_77765_aA):(var3 == 9 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 10 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 11 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 12 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 13?new ItemStack(Block.field_71987_y, 1, 3):(var3 == 14?Item.field_92105_bW.func_92109_a(var1):(var3 == 15?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):null)))))))))))))));
      } else if(this.chestID == 13) {
         var3 = var1.nextInt(16);
         return var3 == 0?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 1?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 2 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 3 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 4?new ItemStack(Item.field_77765_aA):(var3 == 5 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 8 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 9?Item.field_92105_bW.func_92109_a(var1):(var3 == 10?new ItemStack(Item.field_77788_aw):(var3 == 11?new ItemStack(Item.field_77767_aC, var1.nextInt(4) + 1):(var3 == 12?new ItemStack(Item.field_77685_T, var1.nextInt(4) + 1):(var3 == 13?new ItemStack(Item.field_77677_M, var1.nextInt(4) + 1):(var3 == 14?new ItemStack(Item.field_77703_o, var1.nextInt(4) + 1):(var3 == 15?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):null)))))))))))))));
      } else if(this.chestID == 17) {
         var3 = var1.nextInt(17);
         return var3 == 0 && var1.nextInt(3) == 0?new ItemStack(Item.field_77694_Z):(var3 == 1 && var1.nextInt(3) == 0?new ItemStack(Item.field_77814_aa):(var3 == 2 && var1.nextInt(3) == 0?new ItemStack(Item.field_77816_ab):(var3 == 3 && var1.nextInt(3) == 0?new ItemStack(Item.field_77810_ac):(var3 == 4 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 5?new ItemStack(Item.field_77765_aA):(var3 == 6?new ItemStack(Item.field_77677_M, var1.nextInt(4) + 1):(var3 == 7 && var1.nextInt(3) == 0?new ItemStack(Item.field_82798_bP):(var3 == 8 && var1.nextInt(3) == 0?new ItemStack(Item.field_77778_at):(var3 == 9?new ItemStack(Item.field_77703_o, var1.nextInt(4) + 1):(var3 == 10?new ItemStack(Item.field_77684_U):(var3 == 11?new ItemStack(Item.field_77685_T, var1.nextInt(4) + 1):(var3 == 12?new ItemStack(Item.field_77683_K, var1.nextInt(4) + 1):(var3 == 13?new ItemStack(Item.field_77788_aw):(var3 == 14?new ItemStack(Item.field_77767_aC, var1.nextInt(4) + 1):(var3 == 15?new ItemStack(Item.field_77756_aW, 1, 3):(var3 == 16?Item.field_92105_bW.func_92109_a(var1):null))))))))))))))));
      } else if(this.chestID == 18) {
         var3 = var1.nextInt(17);
         return var3 == 1?new ItemStack(Item.field_77772_aH, var1.nextInt(63) + 1):(var3 == 2?new ItemStack(Block.field_72039_aU, var1.nextInt(12) + 1):(var3 == 3?new ItemStack(Block.field_71991_bz, var1.nextInt(4) + 1):(var3 == 4?Item.field_92105_bW.func_92109_a(var1):(var3 == 5 && var1.nextInt(3) == 0?new ItemStack(Block.field_71994_by):(var3 == 6 && var1.nextInt(3) == 0?new ItemStack(Item.field_77698_e[Item.field_77819_bI.field_77779_bT + var1.nextInt(10)]):(var3 == 7?new ItemStack(Block.field_71998_bu, var1.nextInt(4) + 1):(var3 == 8?new ItemStack(Item.field_82794_bL, var1.nextInt(4) + 1):(var3 == 9?new ItemStack(Item.field_82797_bK, var1.nextInt(4) + 1):(var3 == 10?new ItemStack(Item.field_77817_bH, var1.nextInt(4) + 1):(var3 == 11?new ItemStack(Item.field_77677_M, var1.nextInt(4) + 1):(var3 == 12 && var1.nextInt(3) == 0?new ItemStack(Item.field_82798_bP):(var3 == 13 && var1.nextInt(3) == 0?new ItemStack(Item.field_77778_at):null))))))))))));
      } else {
         return new ItemStack(Item.field_77765_aA);
      }
   }

   private String pickMobSpawner(Random var1) {
      int var2 = var1.nextInt(5);
      return var2 == 0?"Skeleton":(var2 == 1?"Zombie":(var2 == 2?"Zombie":(var2 == 3?"Spider":(var2 == 4?"Creeper":""))));
   }
}
