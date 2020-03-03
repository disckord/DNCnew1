package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoGold1 extends WorldGenerator {

   private int objectID;
   private int input1;
   private int input2;
   private int input3;


   public BWG4decoGold1(int var1) {
      this.objectID = var1;
   }

   public BWG4decoGold1(int var1, int var2, int var3, int var4) {
      this.objectID = var1;
      this.input1 = var2;
      this.input2 = var3;
      this.input3 = var4;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      int var7;
      int var8;
      int var9;
      int var11;
      int var12;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      boolean var21;
      boolean var22;
      if(this.objectID == 1) {
         var6 = var2.nextInt(this.input1) + this.input2;
         var7 = var6 - var2.nextInt(2) - 3;
         var8 = var6 - var7;
         var9 = 1 + var2.nextInt(var8 + 1);
         var21 = true;
         if(var4 >= 1 && var4 + var6 + 1 <= 128) {
            for(var11 = var4; var11 <= var4 + 1 + var6 && var21; ++var11) {
               var22 = true;
               if(var11 - var4 < var7) {
                  var12 = 0;
               } else {
                  var12 = var9;
               }

               for(var13 = var3 - var12; var13 <= var3 + var12 && var21; ++var13) {
                  for(var14 = var5 - var12; var14 <= var5 + var12 && var21; ++var14) {
                     if(var11 >= 0 && var11 < 128) {
                        var15 = var1.func_72798_a(var13, var11, var14);
                        if(var15 != 0 && var15 != Block.field_71952_K.field_71990_ca) {
                           var21 = false;
                        }
                     } else {
                        var21 = false;
                     }
                  }
               }
            }

            if(!var21) {
               return false;
            } else {
               var11 = var1.func_72798_a(var3, var4 - 1, var5);
               if((var11 == Block.field_71980_u.field_71990_ca || var11 == Block.field_71979_v.field_71990_ca) && var4 < 128 - var6 - 1) {
                  this.func_76486_a(var1, var3, var4 - 1, var5, Block.field_71979_v.field_71990_ca);
                  var12 = 0;

                  for(var13 = var4 + var6; var13 >= var4 + var7; --var13) {
                     for(var14 = var3 - var12; var14 <= var3 + var12; ++var14) {
                        var15 = var14 - var3;

                        for(var16 = var5 - var12; var16 <= var5 + var12; ++var16) {
                           var17 = var16 - var5;
                           if((Math.abs(var15) != var12 || Math.abs(var17) != var12 || var12 <= 0) && !Block.field_71970_n[var1.func_72798_a(var14, var13, var16)]) {
                              this.func_76485_a(var1, var14, var13, var16, Block.field_71952_K.field_71990_ca, 0);
                           }
                        }
                     }

                     if(var12 >= 1 && var13 == var4 + var7 + 1) {
                        --var12;
                     } else if(var12 < var9) {
                        ++var12;
                     }
                  }

                  for(var13 = 0; var13 < var6 - 1; ++var13) {
                     var14 = var1.func_72798_a(var3, var4 + var13, var5);
                     if(var14 == 0 || var14 == Block.field_71952_K.field_71990_ca) {
                        this.func_76485_a(var1, var3, var4 + var13, var5, Block.field_71951_J.field_71990_ca, 0);
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
         int var18;
         int var19;
         int var20;
         boolean var23;
         if(this.objectID == 2) {
            var6 = var2.nextInt(this.input1) + this.input2;
            var7 = this.input3 + var2.nextInt(2);
            var8 = var6 - var7;
            var9 = 2 + var2.nextInt(2);
            var21 = true;
            if(var4 >= 1 && var4 + var6 + 1 <= 256) {
               for(var11 = var4; var11 <= var4 + 1 + var6 && var21; ++var11) {
                  var22 = true;
                  if(var11 - var4 < var7) {
                     var12 = 0;
                  } else {
                     var12 = var9;
                  }

                  for(var13 = var3 - var12; var13 <= var3 + var12 && var21; ++var13) {
                     for(var14 = var5 - var12; var14 <= var5 + var12 && var21; ++var14) {
                        if(var11 >= 0 && var11 < 256) {
                           var15 = var1.func_72798_a(var13, var11, var14);
                           if(var15 != 0 && var15 != Block.field_71952_K.field_71990_ca) {
                              var21 = false;
                           }
                        } else {
                           var21 = false;
                        }
                     }
                  }
               }

               if(!var21) {
                  return false;
               } else {
                  var11 = var1.func_72798_a(var3, var4 - 1, var5);
                  if((var11 == Block.field_71980_u.field_71990_ca || var11 == Block.field_71979_v.field_71990_ca) && var4 < 256 - var6 - 1) {
                     this.func_76486_a(var1, var3, var4 - 1, var5, Block.field_71979_v.field_71990_ca);
                     var12 = var2.nextInt(2);
                     var13 = 1;
                     var23 = true;

                     for(var15 = 0; var15 <= var8; ++var15) {
                        var16 = var4 + var6 - var15;

                        for(var17 = var3 - var12; var17 <= var3 + var12; ++var17) {
                           var18 = var17 - var3;

                           for(var19 = var5 - var12; var19 <= var5 + var12; ++var19) {
                              var20 = var19 - var5;
                              if((Math.abs(var18) != var12 || Math.abs(var20) != var12 || var12 <= 0) && !Block.field_71970_n[var1.func_72798_a(var17, var16, var19)]) {
                                 this.func_76485_a(var1, var17, var16, var19, Block.field_71952_K.field_71990_ca, 0);
                              }
                           }
                        }

                        if(var12 >= var13) {
                           var12 = var23?1:0;
                           var23 = true;
                           ++var13;
                           if(var13 > var9) {
                              var13 = var9;
                           }
                        } else {
                           ++var12;
                        }
                     }

                     var15 = var2.nextInt(3);

                     for(var16 = 0; var16 < var6 - var15; ++var16) {
                        var17 = var1.func_72798_a(var3, var4 + var16, var5);
                        if(var17 == 0 || var17 == Block.field_71952_K.field_71990_ca) {
                           this.func_76485_a(var1, var3, var4 + var16, var5, Block.field_71951_J.field_71990_ca, 0);
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
         } else if(this.objectID == 3) {
            var6 = var2.nextInt(this.input1) + this.input2;
            var7 = this.input3 + var2.nextInt(2);
            var8 = var6 - var7;
            var9 = 4 + var2.nextInt(2);
            var21 = true;
            if(var4 >= 1 && var4 + var6 + 1 <= 256) {
               for(var11 = var4; var11 <= var4 + 1 + var6 && var21; ++var11) {
                  var22 = true;
                  if(var11 - var4 < var7) {
                     var12 = 0;
                  } else {
                     var12 = var9;
                  }

                  for(var13 = var3 - var12; var13 <= var3 + var12 && var21; ++var13) {
                     for(var14 = var5 - var12; var14 <= var5 + var12 && var21; ++var14) {
                        if(var11 >= 0 && var11 < 256) {
                           var15 = var1.func_72798_a(var13, var11, var14);
                           if(var15 != 0 && var15 != Block.field_71952_K.field_71990_ca) {
                              var21 = false;
                           }
                        } else {
                           var21 = false;
                        }
                     }
                  }
               }

               if(!var21) {
                  return false;
               } else {
                  var11 = var1.func_72798_a(var3, var4 - 1, var5);
                  if((var11 == Block.field_71980_u.field_71990_ca || var11 == Block.field_71979_v.field_71990_ca) && var4 < 256 - var6 - 1) {
                     this.func_76486_a(var1, var3, var4 - 1, var5, Block.field_71979_v.field_71990_ca);
                     var12 = var2.nextInt(2);
                     var13 = 1;
                     var23 = true;

                     for(var15 = 0; var15 <= var8; ++var15) {
                        var16 = var4 + var6 - var15;

                        for(var17 = var3 - var12; var17 <= var3 + var12; ++var17) {
                           var18 = var17 - var3;

                           for(var19 = var5 - var12; var19 <= var5 + var12; ++var19) {
                              var20 = var19 - var5;
                              if((Math.abs(var18) != var12 || Math.abs(var20) != var12 || var12 <= 0) && !Block.field_71970_n[var1.func_72798_a(var17, var16, var19)]) {
                                 this.func_76485_a(var1, var17, var16, var19, Block.field_71952_K.field_71990_ca, 0);
                              }
                           }
                        }

                        if(var12 >= var13) {
                           var12 = var23?1:0;
                           var23 = true;
                           ++var13;
                           if(var13 > var9) {
                              var13 = var9;
                           }
                        } else {
                           ++var12;
                        }
                     }

                     var15 = var2.nextInt(3);

                     for(var16 = 0; var16 < var6 - var15; ++var16) {
                        var17 = var1.func_72798_a(var3, var4 + var16, var5);
                        if(var17 == 0 || var17 == Block.field_71952_K.field_71990_ca) {
                           this.func_76485_a(var1, var3, var4 + var16, var5, Block.field_71951_J.field_71990_ca, 0);
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
         } else if(this.objectID == 4) {
            for(var6 = 0; var6 < 32; ++var6) {
               var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
               var8 = var5 + var2.nextInt(8) - var2.nextInt(8);
               var9 = var1.func_72798_a(var7, 62, var8);
               double var10 = 0.01D;
               if(var9 == Block.field_71943_B.field_71990_ca) {
                  for(var12 = 1; var12 < 8; ++var12) {
                     var13 = var1.func_72798_a(var7, 62 - var12, var8);
                     if(var13 != Block.field_71943_B.field_71990_ca) {
                        break;
                     }

                     if(var12 < 3) {
                        var10 += 0.22D;
                     } else if(var12 < 5) {
                        var10 += 0.65D;
                     } else {
                        var10 += 0.95D;
                     }
                  }

                  if(var10 < 4.0D) {
                     var10 = Math.ceil(var10);
                     if(var2.nextInt((int)var10) == 0) {
                        var1.func_72832_d(var7, 62, var8, Block.field_72036_aT.field_71990_ca, 0, 0);
                     }
                  }
               }
            }

            return true;
         } else if(this.objectID != 5) {
            return true;
         } else {
            var6 = var1.func_72798_a(var3, var4 - 1, var5);
            if(var6 != Block.field_71980_u.field_71990_ca && var6 != Block.field_71979_v.field_71990_ca) {
               return true;
            } else {
               var7 = this.input1 - 5 + var2.nextInt(5);

               for(var8 = var4 - 3; var8 < var7 + var4; ++var8) {
                  var9 = var1.func_72798_a(var3, var8, var5);
                  if(var9 == 0) {
                     var1.func_72832_d(var3, var8, var5, Block.field_71951_J.field_71990_ca, 12, 0);
                  }
               }

               for(var8 = var4 - 3; var8 < var4 + 5; ++var8) {
                  var9 = var1.func_72798_a(var3 + 1, var8, var5);
                  if(var9 == 0) {
                     var1.func_72832_d(var3 + 1, var8, var5, Block.field_71951_J.field_71990_ca, 12, 0);
                     if(var8 > var4 + 0 && var2.nextInt(3) == 0) {
                        break;
                     }
                  }
               }

               for(var8 = var4 - 3; var8 < var4 + 5; ++var8) {
                  var9 = var1.func_72798_a(var3 - 1, var8, var5);
                  if(var9 == 0) {
                     var1.func_72832_d(var3 - 1, var8, var5, Block.field_71951_J.field_71990_ca, 12, 0);
                     if(var8 > var4 + 0 && var2.nextInt(3) == 0) {
                        break;
                     }
                  }
               }

               for(var8 = var4 - 3; var8 < var4 + 5; ++var8) {
                  var9 = var1.func_72798_a(var3, var8, var5 - 1);
                  if(var9 == 0) {
                     var1.func_72832_d(var3, var8, var5 - 1, Block.field_71951_J.field_71990_ca, 12, 0);
                     if(var8 > var4 + 0 && var2.nextInt(3) == 0) {
                        break;
                     }
                  }
               }

               for(var8 = var4 - 3; var8 < var4 + 5; ++var8) {
                  var9 = var1.func_72798_a(var3, var8, var5 + 1);
                  if(var9 == 0) {
                     var1.func_72832_d(var3, var8, var5 + 1, Block.field_71951_J.field_71990_ca, 12, 0);
                     if(var8 > var4 + 0 && var2.nextInt(3) == 0) {
                        break;
                     }
                  }
               }

               return true;
            }
         }
      }
   }

   private ItemStack getChestList(int var1, Random var2, World var3) {
      return null;
   }
}
