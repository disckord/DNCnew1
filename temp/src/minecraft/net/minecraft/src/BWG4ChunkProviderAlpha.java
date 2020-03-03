package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4NoiseOctavesAlpha;
import net.minecraft.src.BWG4decoDungeons;
import net.minecraft.src.BWG4oldGenBigTree;
import net.minecraft.src.BWG4oldGenClay;
import net.minecraft.src.BWG4oldGenLakes;
import net.minecraft.src.BWG4oldGenMinable;
import net.minecraft.src.BWG4oldGenReed;
import net.minecraft.src.BWG4oldGenTrees;
import net.minecraft.src.BWG4oldMapGenCaves;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MapGenStronghold;
import net.minecraft.src.Material;
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenCactus;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenLiquids;
import net.minecraft.src.WorldGenPumpkin;
import net.minecraft.src.WorldGenerator;

public class BWG4ChunkProviderAlpha implements IChunkProvider {

   private Random field_913_j;
   private BWG4NoiseOctavesAlpha field_912_k;
   private BWG4NoiseOctavesAlpha field_911_l;
   private BWG4NoiseOctavesAlpha field_910_m;
   private BWG4NoiseOctavesAlpha field_909_n;
   private BWG4NoiseOctavesAlpha field_908_o;
   public BWG4NoiseOctavesAlpha field_922_a;
   public BWG4NoiseOctavesAlpha field_921_b;
   public BWG4NoiseOctavesAlpha field_920_c;
   private World worldObj_16;
   private final boolean mapFeaturesEnabled;
   private double[] field_4180_q;
   private double[] field_905_r = new double[256];
   private double[] field_904_s = new double[256];
   private double[] field_903_t = new double[256];
   private MapGenBase field_902_u = new BWG4oldMapGenCaves();
   private MapGenStronghold strongholdGenerator = new MapGenStronghold();
   private BiomeGenBase[] field_4179_v;
   double[] field_4185_d;
   double[] field_4184_e;
   double[] field_4183_f;
   double[] field_4182_g;
   double[] field_4181_h;
   int[][] field_914_i = new int[32][32];
   private double[] field_4178_w;


   public BWG4ChunkProviderAlpha(World var1, long var2, boolean var4) {
      this.worldObj_16 = var1;
      this.mapFeaturesEnabled = var4;
      this.field_913_j = new Random(var2);
      this.field_912_k = new BWG4NoiseOctavesAlpha(this.field_913_j, 16);
      this.field_911_l = new BWG4NoiseOctavesAlpha(this.field_913_j, 16);
      this.field_910_m = new BWG4NoiseOctavesAlpha(this.field_913_j, 8);
      this.field_909_n = new BWG4NoiseOctavesAlpha(this.field_913_j, 4);
      this.field_908_o = new BWG4NoiseOctavesAlpha(this.field_913_j, 4);
      this.field_922_a = new BWG4NoiseOctavesAlpha(this.field_913_j, 10);
      this.field_921_b = new BWG4NoiseOctavesAlpha(this.field_913_j, 16);
      this.field_920_c = new BWG4NoiseOctavesAlpha(this.field_913_j, 8);
   }

   public void generateTerrain(int var1, int var2, byte[] var3, BiomeGenBase[] var4, double[] var5) {
      byte var6 = 4;
      byte var7 = 64;
      int var8 = var6 + 1;
      byte var9 = 17;
      int var10 = var6 + 1;
      this.field_4180_q = this.initializeNoiseField(this.field_4180_q, var1 * var6, 0, var2 * var6, var8, var9, var10);

      for(int var11 = 0; var11 < var6; ++var11) {
         for(int var12 = 0; var12 < var6; ++var12) {
            for(int var13 = 0; var13 < 16; ++var13) {
               double var14 = 0.125D;
               double var16 = this.field_4180_q[((var11 + 0) * var10 + var12 + 0) * var9 + var13 + 0];
               double var18 = this.field_4180_q[((var11 + 0) * var10 + var12 + 1) * var9 + var13 + 0];
               double var20 = this.field_4180_q[((var11 + 1) * var10 + var12 + 0) * var9 + var13 + 0];
               double var22 = this.field_4180_q[((var11 + 1) * var10 + var12 + 1) * var9 + var13 + 0];
               double var24 = (this.field_4180_q[((var11 + 0) * var10 + var12 + 0) * var9 + var13 + 1] - var16) * var14;
               double var26 = (this.field_4180_q[((var11 + 0) * var10 + var12 + 1) * var9 + var13 + 1] - var18) * var14;
               double var28 = (this.field_4180_q[((var11 + 1) * var10 + var12 + 0) * var9 + var13 + 1] - var20) * var14;
               double var30 = (this.field_4180_q[((var11 + 1) * var10 + var12 + 1) * var9 + var13 + 1] - var22) * var14;

               for(int var32 = 0; var32 < 8; ++var32) {
                  double var33 = 0.25D;
                  double var35 = var16;
                  double var37 = var18;
                  double var39 = (var20 - var16) * var33;
                  double var41 = (var22 - var18) * var33;

                  for(int var43 = 0; var43 < 4; ++var43) {
                     int var44 = var43 + var11 * 4 << 11 | 0 + var12 * 4 << 7 | var13 * 8 + var32;
                     short var45 = 128;
                     double var46 = 0.25D;
                     double var48 = var35;
                     double var50 = (var37 - var35) * var46;

                     for(int var52 = 0; var52 < 4; ++var52) {
                        double var10000 = var5[(var11 * 4 + var43) * 16 + var12 * 4 + var52];
                        int var55 = 0;
                        if(var13 * 8 + var32 < var7) {
                           var55 = Block.field_71943_B.field_71990_ca;
                        }

                        if(var48 > 0.0D) {
                           var55 = Block.field_71981_t.field_71990_ca;
                        }

                        var3[var44] = (byte)var55;
                        var44 += var45;
                        var48 += var50;
                     }

                     var35 += var39;
                     var37 += var41;
                  }

                  var16 += var24;
                  var18 += var26;
                  var20 += var28;
                  var22 += var30;
               }
            }
         }
      }

   }

   public void replaceBlocksForBiome(int var1, int var2, byte[] var3, BiomeGenBase[] var4) {
      byte var5 = 64;
      double var6 = 0.03125D;
      this.field_905_r = this.field_909_n.func_807_a(this.field_905_r, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6, var6, 1.0D);
      this.field_904_s = this.field_909_n.func_807_a(this.field_904_s, (double)(var2 * 16), 109.0134D, (double)(var1 * 16), 16, 1, 16, var6, 1.0D, var6);
      this.field_903_t = this.field_908_o.func_807_a(this.field_903_t, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

      for(int var8 = 0; var8 < 16; ++var8) {
         for(int var9 = 0; var9 < 16; ++var9) {
            BiomeGenBase var10 = var4[var8 * 16 + var9];
            boolean var11 = this.field_905_r[var8 + var9 * 16] + this.field_913_j.nextDouble() * 0.2D > 0.0D;
            boolean var12 = this.field_904_s[var8 + var9 * 16] + this.field_913_j.nextDouble() * 0.2D > 3.0D;
            int var13 = (int)(this.field_903_t[var8 + var9 * 16] / 3.0D + 3.0D + this.field_913_j.nextDouble() * 0.25D);
            int var14 = -1;
            byte var15 = var10.field_76752_A;
            byte var16 = var10.field_76753_B;

            for(int var17 = 127; var17 >= 0; --var17) {
               int var18 = (var8 * 16 + var9) * 128 + var17;
               if(var17 <= 0 + this.field_913_j.nextInt(5)) {
                  var3[var18] = (byte)Block.field_71986_z.field_71990_ca;
               } else {
                  byte var19 = var3[var18];
                  if(var19 == 0) {
                     var14 = -1;
                  } else if(var19 == Block.field_71981_t.field_71990_ca) {
                     if(var14 == -1) {
                        if(var13 <= 0) {
                           var15 = 0;
                           var16 = (byte)Block.field_71981_t.field_71990_ca;
                        } else if(var17 >= var5 - 4 && var17 <= var5 + 1) {
                           var15 = var10.field_76752_A;
                           var16 = var10.field_76753_B;
                           if(var12) {
                              var15 = 0;
                           }

                           if(var12) {
                              var16 = (byte)Block.field_71940_F.field_71990_ca;
                           }

                           if(var11) {
                              var15 = (byte)Block.field_71939_E.field_71990_ca;
                           }

                           if(var11) {
                              var16 = (byte)Block.field_71939_E.field_71990_ca;
                           }
                        }

                        if(var17 < var5 && var15 == 0) {
                           var15 = (byte)Block.field_71942_A.field_71990_ca;
                        }

                        var14 = var13;
                        if(var17 >= var5 - 1) {
                           var3[var18] = var15;
                        } else {
                           var3[var18] = var16;
                        }
                     } else if(var14 > 0) {
                        --var14;
                        var3[var18] = var16;
                     }
                  }
               }
            }
         }
      }

   }

   public Chunk func_73158_c(int var1, int var2) {
      return this.func_73154_d(var1, var2);
   }

   public Chunk func_73154_d(int var1, int var2) {
      this.field_913_j.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.field_4179_v = this.worldObj_16.func_72959_q().func_76933_b(this.field_4179_v, var1 * 16, var2 * 16, 16, 16);
      double[] var4 = this.worldObj_16.func_72959_q().temperature;
      this.generateTerrain(var1, var2, var3, this.field_4179_v, var4);
      this.replaceBlocksForBiome(var1, var2, var3, this.field_4179_v);
      this.field_902_u.func_75036_a(this, this.worldObj_16, var1, var2, var3);
      if(this.mapFeaturesEnabled) {
         this.strongholdGenerator.func_75036_a(this, this.worldObj_16, var1, var2, var3);
      }

      Chunk var5 = new Chunk(this.worldObj_16, var3, var1, var2);
      byte[] var6 = var5.func_76605_m();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)this.field_4179_v[var7].field_76756_M;
      }

      var5.func_76603_b();
      return var5;
   }

   private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      double[] var12 = this.worldObj_16.func_72959_q().temperature;
      double[] var13 = this.worldObj_16.func_72959_q().humidity;
      this.field_4182_g = this.field_922_a.func_4109_a(this.field_4182_g, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
      this.field_4181_h = this.field_921_b.func_4109_a(this.field_4181_h, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
      this.field_4185_d = this.field_910_m.func_807_a(this.field_4185_d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.field_4184_e = this.field_912_k.func_807_a(this.field_4184_e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
      this.field_4183_f = this.field_911_l.func_807_a(this.field_4183_f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
      int var14 = 0;
      int var15 = 0;
      int var16 = 16 / var5;

      for(int var17 = 0; var17 < var5; ++var17) {
         int var18 = var17 * var16 + var16 / 2;

         for(int var19 = 0; var19 < var7; ++var19) {
            int var20 = var19 * var16 + var16 / 2;
            double var21 = var12[var18 * 16 + var20];
            double var23 = var13[var18 * 16 + var20] * var21;
            double var25 = 1.0D - var23;
            var25 *= var25;
            var25 *= var25;
            var25 = 1.0D - var25;
            double var27 = (this.field_4182_g[var15] + 256.0D) / 512.0D;
            var27 *= var25;
            if(var27 > 1.0D) {
               var27 = 1.0D;
            }

            double var29 = this.field_4181_h[var15] / 8000.0D;
            if(var29 < 0.0D) {
               var29 = -var29 * 0.3D;
            }

            var29 = var29 * 3.0D - 2.0D;
            if(var29 < 0.0D) {
               var29 /= 2.0D;
               if(var29 < -1.0D) {
                  var29 = -1.0D;
               }

               var29 /= 1.4D;
               var29 /= 2.0D;
               var27 = 0.0D;
            } else {
               if(var29 > 1.0D) {
                  var29 = 1.0D;
               }

               var29 /= 8.0D;
            }

            if(var27 < 0.0D) {
               var27 = 0.0D;
            }

            var27 += 0.5D;
            var29 = var29 * (double)var6 / 16.0D;
            double var31 = (double)var6 / 2.0D + var29 * 4.0D;
            ++var15;

            for(int var33 = 0; var33 < var6; ++var33) {
               double var34 = 0.0D;
               double var36 = ((double)var33 - var31) * 12.0D / var27;
               if(var36 < 0.0D) {
                  var36 *= 4.0D;
               }

               double var38 = this.field_4184_e[var14] / 512.0D;
               double var40 = this.field_4183_f[var14] / 512.0D;
               double var42 = (this.field_4185_d[var14] / 10.0D + 1.0D) / 2.0D;
               if(var42 < 0.0D) {
                  var34 = var38;
               } else if(var42 > 1.0D) {
                  var34 = var40;
               } else {
                  var34 = var38 + (var40 - var38) * var42;
               }

               var34 -= var36;
               if(var33 > var6 - 4) {
                  double var44 = (double)((float)(var33 - (var6 - 4)) / 3.0F);
                  var34 = var34 * (1.0D - var44) + -10.0D * var44;
               }

               var1[var14] = var34;
               ++var14;
            }
         }
      }

      return var1;
   }

   public boolean func_73149_a(int var1, int var2) {
      return true;
   }

   public void func_73153_a(IChunkProvider var1, int var2, int var3) {
      BlockSand.field_72192_a = true;
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      BiomeGenBase var6 = this.worldObj_16.func_72959_q().func_76935_a(var4 + 16, var5 + 16);
      this.field_913_j.setSeed(this.worldObj_16.func_72905_C());
      long var7 = this.field_913_j.nextLong() / 2L * 2L + 1L;
      long var9 = this.field_913_j.nextLong() / 2L * 2L + 1L;
      this.field_913_j.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj_16.func_72905_C());
      double var11 = 0.25D;
      if(this.mapFeaturesEnabled) {
         this.strongholdGenerator.func_75051_a(this.worldObj_16, this.field_913_j, var2, var3);
      }

      int var13;
      int var14;
      int var15;
      if(this.field_913_j.nextInt(4) == 0) {
         var13 = var4 + this.field_913_j.nextInt(16) + 8;
         var14 = this.field_913_j.nextInt(128);
         var15 = var5 + this.field_913_j.nextInt(16) + 8;
         (new BWG4oldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var13, var14, var15);
      }

      if(this.field_913_j.nextInt(8) == 0) {
         var13 = var4 + this.field_913_j.nextInt(16) + 8;
         var14 = this.field_913_j.nextInt(this.field_913_j.nextInt(120) + 8);
         var15 = var5 + this.field_913_j.nextInt(16) + 8;
         if(var14 < 64 || this.field_913_j.nextInt(10) == 0) {
            (new BWG4oldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var13, var14, var15);
         }
      }

      int var16;
      for(var13 = 0; var13 < 8; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16) + 8;
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16) + 8;
         (new BWG4decoDungeons(3, true, false, false)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 10; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenClay(32, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 20; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71979_v.field_71990_ca, 32, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 10; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71940_F.field_71990_ca, 32, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 20; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71950_I.field_71990_ca, 16, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 20; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(64);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71949_H.field_71990_ca, 8, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 2; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(32);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71941_G.field_71990_ca, 8, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 8; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(16);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_72047_aN.field_71990_ca, 7, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 1; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(16);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_72073_aw.field_71990_ca, 7, 1)).func_76484_a(this.worldObj_16, this.field_913_j, var14, var15, var16);
      }

      var11 = 0.5D;
      var13 = (int)((this.field_920_c.func_806_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.field_913_j.nextDouble() * 4.0D + 4.0D) / 3.0D);
      var14 = 0;
      if(this.field_913_j.nextInt(10) == 0) {
         ++var14;
      }

      if(var6 == BiomeGenBase.ALPHAforest) {
         var14 += var13 + 5;
      }

      if(var6 == BiomeGenBase.ALPHArainforest) {
         var14 += var13 + 5;
      }

      if(var6 == BiomeGenBase.ALPHAseasonalForest) {
         var14 += var13 + 2;
      }

      if(var6 == BiomeGenBase.ALPHAtaiga) {
         var14 += var13 + 5;
      }

      if(var6 == BiomeGenBase.ALPHAdesert) {
         var14 -= 20;
      }

      if(var6 == BiomeGenBase.ALPHAtundra) {
         var14 -= 20;
      }

      if(var6 == BiomeGenBase.ALPHAplains) {
         var14 -= 20;
      }

      Object var24 = new BWG4oldGenTrees(1);
      if(this.field_913_j.nextInt(10) == 0) {
         var24 = new BWG4oldGenBigTree(1);
      }

      if(var6 == BiomeGenBase.ALPHArainforest && this.field_913_j.nextInt(3) == 0) {
         var24 = new BWG4oldGenBigTree(1);
      }

      int var17;
      int var18;
      for(var16 = 0; var16 < var14; ++var16) {
         var17 = var4 + this.field_913_j.nextInt(16) + 8;
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         ((WorldGenerator)((WorldGenerator)var24)).func_76487_a(1.0D, 1.0D, 1.0D);
         ((WorldGenerator)((WorldGenerator)var24)).func_76484_a(this.worldObj_16, this.field_913_j, var17, this.worldObj_16.func_72976_f(var17, var18), var18);
      }

      int var19;
      for(var16 = 0; var16 < 2; ++var16) {
         var17 = var4 + this.field_913_j.nextInt(16) + 8;
         var18 = this.field_913_j.nextInt(128);
         var19 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72097_ad.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var17, var18, var19);
      }

      if(this.field_913_j.nextInt(2) == 0) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(128);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72107_ae.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var16, var17, var18);
      }

      if(this.field_913_j.nextInt(4) == 0) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(128);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72109_af.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var16, var17, var18);
      }

      if(this.field_913_j.nextInt(8) == 0) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(128);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72103_ag.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var16, var17, var18);
      }

      for(var16 = 0; var16 < 10; ++var16) {
         var17 = var4 + this.field_913_j.nextInt(16) + 8;
         var18 = this.field_913_j.nextInt(128);
         var19 = var5 + this.field_913_j.nextInt(16) + 8;
         (new BWG4oldGenReed()).func_76484_a(this.worldObj_16, this.field_913_j, var17, var18, var19);
      }

      if(this.field_913_j.nextInt(32) == 0) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(128);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenPumpkin()).func_76484_a(this.worldObj_16, this.field_913_j, var16, var17, var18);
      }

      var16 = 0;
      if(var6 == BiomeGenBase.ALPHAdesert) {
         var16 += 10;
      }

      int var20;
      for(var17 = 0; var17 < var16; ++var17) {
         var18 = var4 + this.field_913_j.nextInt(16) + 8;
         var19 = this.field_913_j.nextInt(128);
         var20 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenCactus()).func_76484_a(this.worldObj_16, this.field_913_j, var18, var19, var20);
      }

      for(var17 = 0; var17 < 50; ++var17) {
         var18 = var4 + this.field_913_j.nextInt(16) + 8;
         var19 = this.field_913_j.nextInt(this.field_913_j.nextInt(120) + 8);
         var20 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenLiquids(Block.field_71942_A.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var18, var19, var20);
      }

      for(var17 = 0; var17 < 20; ++var17) {
         var18 = var4 + this.field_913_j.nextInt(16) + 8;
         var19 = this.field_913_j.nextInt(this.field_913_j.nextInt(this.field_913_j.nextInt(112) + 8) + 8);
         var20 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenLiquids(Block.field_71944_C.field_71990_ca)).func_76484_a(this.worldObj_16, this.field_913_j, var18, var19, var20);
      }

      SpawnerAnimals.func_77191_a(this.worldObj_16, var6, var4 + 8, var5 + 8, 16, 16, this.field_913_j);
      this.field_4178_w = this.worldObj_16.func_72959_q().getColdTemperatures(this.field_4178_w, var4 + 8, var5 + 8, 16, 16);

      for(var17 = var4 + 8; var17 < var4 + 8 + 16; ++var17) {
         for(var18 = var5 + 8; var18 < var5 + 8 + 16; ++var18) {
            var19 = var17 - (var4 + 8);
            var20 = var18 - (var5 + 8);
            int var21 = this.worldObj_16.func_72874_g(var17, var18);
            double var22 = this.field_4178_w[var19 * 16 + var20] - (double)(var21 - 64) / 64.0D * 0.3D;
            if(var22 < 0.5D && var21 > 0 && var21 < 128 && this.worldObj_16.func_72799_c(var17, var21, var18)) {
               if(this.worldObj_16.func_72803_f(var17, var21 - 1, var18).func_76230_c() && this.worldObj_16.func_72803_f(var17, var21 - 1, var18) != Material.field_76260_u) {
                  this.worldObj_16.func_72832_d(var17, var21, var18, Block.field_72037_aS.field_71990_ca, 0, 2);
               } else if(this.worldObj_16.func_72803_f(var17, var21 - 1, var18) == Material.field_76244_g) {
                  this.worldObj_16.func_72832_d(var17, var21 - 1, var18, Block.field_72036_aT.field_71990_ca, 0, 2);
               }
            }
         }
      }

      BlockSand.field_72192_a = false;
   }

   public boolean func_73151_a(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public boolean func_73156_b() {
      return false;
   }

   public boolean unload100OldestChunks() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public String func_73148_d() {
      return "RandomLevelSource";
   }

   public List func_73155_a(EnumCreatureType var1, int var2, int var3, int var4) {
      BiomeGenBase var5 = this.worldObj_16.func_72807_a(var2, var4);
      return var5 == null?null:var5.func_76747_a(var1);
   }

   public ChunkPosition func_73150_a(World var1, String var2, int var3, int var4, int var5) {
      return "Stronghold".equals(var2) && this.strongholdGenerator != null?this.strongholdGenerator.func_75050_a(var1, var3, var4, var5):null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int var1, int var2) {
      if(this.mapFeaturesEnabled) {
         this.strongholdGenerator.func_75036_a(this, this.worldObj_16, var1, var2, (byte[])null);
      }

   }

   public void func_104112_b() {}
}
