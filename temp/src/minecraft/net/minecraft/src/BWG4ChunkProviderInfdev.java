package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4NoiseOctavesInfdev;
import net.minecraft.src.BWG4decoDungeons;
import net.minecraft.src.BWG4oldGenBigTree;
import net.minecraft.src.BWG4oldGenClay;
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
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenCactus;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenLiquids;
import net.minecraft.src.WorldGenerator;

public class BWG4ChunkProviderInfdev implements IChunkProvider {

   private Random field_913_j;
   private BWG4NoiseOctavesInfdev field_912_k;
   private BWG4NoiseOctavesInfdev field_911_l;
   private BWG4NoiseOctavesInfdev field_910_m;
   private BWG4NoiseOctavesInfdev field_909_n;
   private BWG4NoiseOctavesInfdev field_908_o;
   public BWG4NoiseOctavesInfdev field_922_a;
   public BWG4NoiseOctavesInfdev field_921_b;
   public BWG4NoiseOctavesInfdev field_920_c;
   private World field_907_p;
   private final boolean mapFeaturesEnabled;
   private double[] field_906_q;
   private double[] field_905_r = new double[256];
   private double[] field_904_s = new double[256];
   private double[] field_903_t = new double[256];
   private MapGenBase field_902_u = new BWG4oldMapGenCaves();
   private MapGenStronghold strongholdGenerator = new MapGenStronghold();
   double[] field_919_d;
   double[] field_918_e;
   double[] field_917_f;
   double[] field_916_g;
   double[] field_915_h;
   int[][] field_914_i = new int[32][32];


   public BWG4ChunkProviderInfdev(World var1, long var2, boolean var4) {
      this.field_907_p = var1;
      this.mapFeaturesEnabled = var4;
      this.field_913_j = new Random(var2);
      this.field_912_k = new BWG4NoiseOctavesInfdev(this.field_913_j, 16);
      this.field_911_l = new BWG4NoiseOctavesInfdev(this.field_913_j, 16);
      this.field_910_m = new BWG4NoiseOctavesInfdev(this.field_913_j, 8);
      this.field_909_n = new BWG4NoiseOctavesInfdev(this.field_913_j, 4);
      this.field_908_o = new BWG4NoiseOctavesInfdev(this.field_913_j, 4);
      this.field_922_a = new BWG4NoiseOctavesInfdev(this.field_913_j, 10);
      this.field_921_b = new BWG4NoiseOctavesInfdev(this.field_913_j, 16);
      this.field_920_c = new BWG4NoiseOctavesInfdev(this.field_913_j, 8);
   }

   public void generateTerrain(int var1, int var2, byte[] var3) {
      byte var4 = 4;
      byte var5 = 64;
      int var6 = var4 + 1;
      byte var7 = 17;
      int var8 = var4 + 1;
      this.field_906_q = this.initializeNoiseField(this.field_906_q, var1 * var4, 0, var2 * var4, var6, var7, var8);

      for(int var9 = 0; var9 < var4; ++var9) {
         for(int var10 = 0; var10 < var4; ++var10) {
            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = 0.125D;
               double var14 = this.field_906_q[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
               double var16 = this.field_906_q[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
               double var18 = this.field_906_q[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
               double var20 = this.field_906_q[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
               double var22 = (this.field_906_q[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.field_906_q[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.field_906_q[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.field_906_q[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 8; ++var30) {
                  double var31 = 0.25D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 4; ++var41) {
                     int var42 = var41 + var9 * 4 << 11 | 0 + var10 * 4 << 7 | var11 * 8 + var30;
                     short var43 = 128;
                     double var44 = 0.25D;
                     double var46 = var33;
                     double var48 = (var35 - var33) * var44;

                     for(int var50 = 0; var50 < 4; ++var50) {
                        int var51 = 0;
                        if(var11 * 8 + var30 < var5) {
                           var51 = Block.field_71943_B.field_71990_ca;
                        }

                        if(var46 > 0.0D) {
                           var51 = Block.field_71981_t.field_71990_ca;
                        }

                        var3[var42] = (byte)var51;
                        var42 += var43;
                        var46 += var48;
                     }

                     var33 += var37;
                     var35 += var39;
                  }

                  var14 += var22;
                  var16 += var24;
                  var18 += var26;
                  var20 += var28;
               }
            }
         }
      }

   }

   public void replaceBlocksForBiome(int var1, int var2, byte[] var3) {
      byte var4 = 64;
      double var5 = 0.03125D;
      this.field_905_r = this.field_909_n.func_807_a(this.field_905_r, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var5, var5, 1.0D);
      this.field_904_s = this.field_909_n.func_807_a(this.field_904_s, (double)(var2 * 16), 109.0134D, (double)(var1 * 16), 16, 1, 16, var5, 1.0D, var5);
      this.field_903_t = this.field_908_o.func_807_a(this.field_903_t, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            boolean var9 = this.field_905_r[var7 + var8 * 16] + this.field_913_j.nextDouble() * 0.2D > 0.0D;
            int var10 = (int)(this.field_903_t[var7 + var8 * 16] / 3.0D + 3.0D + this.field_913_j.nextDouble() * 0.25D);
            int var11 = -1;
            byte var12 = (byte)Block.field_71980_u.field_71990_ca;
            byte var13 = (byte)Block.field_71979_v.field_71990_ca;

            for(int var14 = 127; var14 >= 0; --var14) {
               int var15 = (var7 * 16 + var8) * 128 + var14;
               if(var14 <= 0 + this.field_913_j.nextInt(6) - 1) {
                  var3[var15] = (byte)Block.field_71986_z.field_71990_ca;
               } else {
                  byte var16 = var3[var15];
                  if(var16 == 0) {
                     var11 = -1;
                  } else if(var16 == Block.field_71981_t.field_71990_ca) {
                     if(var11 == -1) {
                        if(var10 <= 0) {
                           var12 = 0;
                           var13 = (byte)Block.field_71981_t.field_71990_ca;
                        } else if(var14 >= var4 - 4 && var14 <= var4 + 1) {
                           var12 = (byte)Block.field_71980_u.field_71990_ca;
                           var13 = (byte)Block.field_71979_v.field_71990_ca;
                           if(var9) {
                              var12 = (byte)Block.field_71939_E.field_71990_ca;
                           }

                           if(var9) {
                              var13 = (byte)Block.field_71939_E.field_71990_ca;
                           }
                        }

                        if(var14 < var4 && var12 == 0) {
                           var12 = (byte)Block.field_71942_A.field_71990_ca;
                        }

                        var11 = var10;
                        if(var14 >= var4 - 1) {
                           var3[var15] = var12;
                        } else {
                           var3[var15] = var13;
                        }
                     } else if(var11 > 0) {
                        --var11;
                        var3[var15] = var13;
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
      this.generateTerrain(var1, var2, var3);
      this.replaceBlocksForBiome(var1, var2, var3);
      this.field_902_u.func_75036_a(this, this.field_907_p, var1, var2, var3);
      if(this.mapFeaturesEnabled) {
         this.strongholdGenerator.func_75036_a(this, this.field_907_p, var1, var2, var3);
      }

      Chunk var4 = new Chunk(this.field_907_p, var3, var1, var2);
      var4.func_76603_b();
      return var4;
   }

   private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      this.field_916_g = this.field_922_a.func_807_a(this.field_916_g, (double)var2, (double)var3, (double)var4, var5, 1, var7, 1.0D, 0.0D, 1.0D);
      this.field_915_h = this.field_921_b.func_807_a(this.field_915_h, (double)var2, (double)var3, (double)var4, var5, 1, var7, 100.0D, 0.0D, 100.0D);
      this.field_919_d = this.field_910_m.func_807_a(this.field_919_d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.field_918_e = this.field_912_k.func_807_a(this.field_918_e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
      this.field_917_f = this.field_911_l.func_807_a(this.field_917_f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
      int var12 = 0;
      int var13 = 0;

      for(int var14 = 0; var14 < var5; ++var14) {
         for(int var15 = 0; var15 < var7; ++var15) {
            double var16 = (this.field_916_g[var13] + 256.0D) / 512.0D;
            if(var16 > 1.0D) {
               var16 = 1.0D;
            }

            double var18 = 0.0D;
            double var20 = this.field_915_h[var13] / 8000.0D;
            if(var20 < 0.0D) {
               var20 = -var20;
            }

            var20 = var20 * 3.0D - 3.0D;
            if(var20 < 0.0D) {
               var20 /= 2.0D;
               if(var20 < -1.0D) {
                  var20 = -1.0D;
               }

               var20 /= 1.4D;
               var20 /= 2.0D;
               var16 = 0.0D;
            } else {
               if(var20 > 1.0D) {
                  var20 = 1.0D;
               }

               var20 /= 6.0D;
            }

            var16 += 0.5D;
            var20 = var20 * (double)var6 / 16.0D;
            double var22 = (double)var6 / 2.0D + var20 * 4.0D;
            ++var13;

            for(int var24 = 0; var24 < var6; ++var24) {
               double var25 = 0.0D;
               double var27 = ((double)var24 - var22) * 12.0D / var16;
               if(var27 < 0.0D) {
                  var27 *= 4.0D;
               }

               double var29 = this.field_918_e[var12] / 512.0D;
               double var31 = this.field_917_f[var12] / 512.0D;
               double var33 = (this.field_919_d[var12] / 10.0D + 1.0D) / 2.0D;
               if(var33 < 0.0D) {
                  var25 = var29;
               } else if(var33 > 1.0D) {
                  var25 = var31;
               } else {
                  var25 = var29 + (var31 - var29) * var33;
               }

               var25 -= var27;
               double var35;
               if(var24 > var6 - 4) {
                  var35 = (double)((float)(var24 - (var6 - 4)) / 3.0F);
                  var25 = var25 * (1.0D - var35) + -10.0D * var35;
               }

               if((double)var24 < var18) {
                  var35 = (var18 - (double)var24) / 4.0D;
                  if(var35 < 0.0D) {
                     var35 = 0.0D;
                  }

                  if(var35 > 1.0D) {
                     var35 = 1.0D;
                  }

                  var25 = var25 * (1.0D - var35) + -10.0D * var35;
               }

               var1[var12] = var25;
               ++var12;
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
      BiomeGenBase var6 = this.field_907_p.func_72959_q().func_76935_a(var4 + 16, var5 + 16);
      this.field_913_j.setSeed(this.field_907_p.func_72905_C());
      long var7 = this.field_913_j.nextLong() / 2L * 2L + 1L;
      long var9 = this.field_913_j.nextLong() / 2L * 2L + 1L;
      this.field_913_j.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.field_907_p.func_72905_C());
      double var11 = 0.25D;
      if(this.mapFeaturesEnabled) {
         this.strongholdGenerator.func_75051_a(this.field_907_p, this.field_913_j, var2, var3);
      }

      int var13;
      int var14;
      int var15;
      int var16;
      for(var13 = 0; var13 < 8; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16) + 8;
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16) + 8;
         (new BWG4decoDungeons(4, true, false, false)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 10; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenClay(32, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 20; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71979_v.field_71990_ca, 32, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 10; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71940_F.field_71990_ca, 32, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 20; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(128);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71950_I.field_71990_ca, 16, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 20; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(64);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71949_H.field_71990_ca, 8, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 2; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(32);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_71941_G.field_71990_ca, 8, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 8; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(16);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_72047_aN.field_71990_ca, 7, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      for(var13 = 0; var13 < 1; ++var13) {
         var14 = var4 + this.field_913_j.nextInt(16);
         var15 = this.field_913_j.nextInt(16);
         var16 = var5 + this.field_913_j.nextInt(16);
         (new BWG4oldGenMinable(Block.field_72073_aw.field_71990_ca, 7, 0)).func_76484_a(this.field_907_p, this.field_913_j, var14, var15, var16);
      }

      var11 = 0.5D;
      var13 = (int)((this.field_920_c.func_806_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.field_913_j.nextDouble() * 4.0D + 4.0D) / 3.0D);
      if(var13 < 0) {
         var13 = 0;
      }

      if(this.field_913_j.nextInt(10) == 0) {
         ++var13;
      }

      Object var19 = new BWG4oldGenTrees(0);
      if(this.field_913_j.nextInt(10) == 0) {
         var19 = new BWG4oldGenBigTree(0);
      }

      int var17;
      for(var15 = 0; var15 < var13; ++var15) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = var5 + this.field_913_j.nextInt(16) + 8;
         ((WorldGenerator)((WorldGenerator)var19)).func_76487_a(1.0D, 1.0D, 1.0D);
         ((WorldGenerator)((WorldGenerator)var19)).func_76484_a(this.field_907_p, this.field_913_j, var16, this.field_907_p.func_72976_f(var16, var17), var17);
      }

      int var18;
      for(var15 = 0; var15 < 2; ++var15) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(128);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72097_ad.field_71990_ca)).func_76484_a(this.field_907_p, this.field_913_j, var16, var17, var18);
      }

      if(this.field_913_j.nextInt(2) == 0) {
         var15 = var4 + this.field_913_j.nextInt(16) + 8;
         var16 = this.field_913_j.nextInt(128);
         var17 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72107_ae.field_71990_ca)).func_76484_a(this.field_907_p, this.field_913_j, var15, var16, var17);
      }

      if(this.field_913_j.nextInt(4) == 0) {
         var15 = var4 + this.field_913_j.nextInt(16) + 8;
         var16 = this.field_913_j.nextInt(128);
         var17 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72109_af.field_71990_ca)).func_76484_a(this.field_907_p, this.field_913_j, var15, var16, var17);
      }

      if(this.field_913_j.nextInt(8) == 0) {
         var15 = var4 + this.field_913_j.nextInt(16) + 8;
         var16 = this.field_913_j.nextInt(128);
         var17 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72103_ag.field_71990_ca)).func_76484_a(this.field_907_p, this.field_913_j, var15, var16, var17);
      }

      for(var15 = 0; var15 < 10; ++var15) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(128);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new BWG4oldGenReed()).func_76484_a(this.field_907_p, this.field_913_j, var16, var17, var18);
      }

      for(var15 = 0; var15 < 1; ++var15) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(128);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenCactus()).func_76484_a(this.field_907_p, this.field_913_j, var16, var17, var18);
      }

      for(var15 = 0; var15 < 50; ++var15) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(this.field_913_j.nextInt(120) + 8);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenLiquids(Block.field_71942_A.field_71990_ca)).func_76484_a(this.field_907_p, this.field_913_j, var16, var17, var18);
      }

      for(var15 = 0; var15 < 20; ++var15) {
         var16 = var4 + this.field_913_j.nextInt(16) + 8;
         var17 = this.field_913_j.nextInt(this.field_913_j.nextInt(this.field_913_j.nextInt(112) + 8) + 8);
         var18 = var5 + this.field_913_j.nextInt(16) + 8;
         (new WorldGenLiquids(Block.field_71944_C.field_71990_ca)).func_76484_a(this.field_907_p, this.field_913_j, var16, var17, var18);
      }

      SpawnerAnimals.func_77191_a(this.field_907_p, var6, var4 + 8, var5 + 8, 16, 16, this.field_913_j);
      var4 += 8;
      var5 += 8;

      for(var15 = 0; var15 < 16; ++var15) {
         for(var16 = 0; var16 < 16; ++var16) {
            var17 = this.field_907_p.func_72874_g(var4 + var15, var5 + var16);
            if(this.field_907_p.func_72884_u(var15 + var4, var17 - 1, var16 + var5)) {
               this.field_907_p.func_72832_d(var15 + var4, var17 - 1, var16 + var5, Block.field_72036_aT.field_71990_ca, 0, 2);
            }

            if(this.field_907_p.func_72858_w(var15 + var4, var17, var16 + var5)) {
               this.field_907_p.func_72832_d(var15 + var4, var17, var16 + var5, Block.field_72037_aS.field_71990_ca, 0, 2);
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
      BiomeGenBase var5 = this.field_907_p.func_72807_a(var2, var4);
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
         this.strongholdGenerator.func_75036_a(this, this.field_907_p, var1, var2, (byte[])null);
      }

   }

   public void func_104112_b() {}
}
