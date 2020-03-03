package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4NoiseOctavesBeta;
import net.minecraft.src.BWG4decoDungeons;
import net.minecraft.src.BWG4decoSurvival;
import net.minecraft.src.BWG4oldGenClay;
import net.minecraft.src.BWG4oldGenLakes;
import net.minecraft.src.BWG4oldGenMinable;
import net.minecraft.src.BWG4oldGenReed;
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
import net.minecraft.src.Material;
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenCactus;
import net.minecraft.src.WorldGenDeadBush;
import net.minecraft.src.WorldGenFire;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenHellLava;
import net.minecraft.src.WorldGenLiquids;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.src.WorldGenPumpkin;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenerator;

public class BWG4ChunkProviderSky implements IChunkProvider {

   private Random rand;
   private BWG4NoiseOctavesBeta field_912_k;
   private BWG4NoiseOctavesBeta field_911_l;
   private BWG4NoiseOctavesBeta field_910_m;
   private BWG4NoiseOctavesBeta field_909_n;
   private BWG4NoiseOctavesBeta field_908_o;
   public BWG4NoiseOctavesBeta field_922_a;
   public BWG4NoiseOctavesBeta field_921_b;
   public BWG4NoiseOctavesBeta mobSpawnerNoise;
   private World worldObj;
   private final boolean mapFeaturesEnabled;
   private double[] field_4180_q;
   private double[] sandNoise = new double[256];
   private double[] gravelNoise = new double[256];
   private double[] stoneNoise = new double[256];
   private MapGenBase field_902_u = new BWG4oldMapGenCaves();
   private BiomeGenBase[] biomesForGeneration;
   private int worldtype;
   double[] field_4185_d;
   double[] field_4184_e;
   double[] field_4183_f;
   double[] field_4182_g;
   double[] field_4181_h;
   int[][] field_914_i = new int[32][32];
   private double[] generatedTemperatures;
   private boolean nether;


   public BWG4ChunkProviderSky(World var1, long var2, boolean var4, int var5) {
      this.worldObj = var1;
      this.rand = new Random(var2);
      this.mapFeaturesEnabled = var4;
      this.worldtype = var5;
      if(var5 == 4) {
         this.nether = true;
      }

      this.field_912_k = new BWG4NoiseOctavesBeta(this.rand, 16);
      this.field_911_l = new BWG4NoiseOctavesBeta(this.rand, 16);
      this.field_910_m = new BWG4NoiseOctavesBeta(this.rand, 8);
      this.field_909_n = new BWG4NoiseOctavesBeta(this.rand, 4);
      this.field_908_o = new BWG4NoiseOctavesBeta(this.rand, 4);
      this.field_922_a = new BWG4NoiseOctavesBeta(this.rand, 10);
      this.field_921_b = new BWG4NoiseOctavesBeta(this.rand, 16);
      this.mobSpawnerNoise = new BWG4NoiseOctavesBeta(this.rand, 8);
   }

   public void generateTerrain(int var1, int var2, byte[] var3, BiomeGenBase[] var4, double[] var5) {
      byte var6 = 2;
      int var7 = var6 + 1;
      byte var8 = 33;
      int var9 = var6 + 1;
      this.field_4180_q = this.func_4061_a(this.field_4180_q, var1 * var6, 0, var2 * var6, var7, var8, var9);

      for(int var10 = 0; var10 < var6; ++var10) {
         for(int var11 = 0; var11 < var6; ++var11) {
            for(int var12 = 0; var12 < 32; ++var12) {
               double var13 = 0.25D;
               double var15 = this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
               double var17 = this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
               double var19 = this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
               double var21 = this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
               double var23 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
               double var25 = (this.field_4180_q[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
               double var27 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
               double var29 = (this.field_4180_q[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

               for(int var31 = 0; var31 < 4; ++var31) {
                  double var32 = 0.125D;
                  double var34 = var15;
                  double var36 = var17;
                  double var38 = (var19 - var15) * var32;
                  double var40 = (var21 - var17) * var32;

                  for(int var42 = 0; var42 < 8; ++var42) {
                     int var43 = var42 + var10 * 8 << 11 | 0 + var11 * 8 << 7 | var12 * 4 + var31;
                     short var44 = 128;
                     double var45 = 0.125D;
                     double var47 = var34;
                     double var49 = (var36 - var34) * var45;

                     for(int var51 = 0; var51 < 8; ++var51) {
                        int var52 = 0;
                        if(var47 > 0.0D) {
                           if(this.nether) {
                              var52 = Block.field_72012_bb.field_71990_ca;
                           } else {
                              var52 = Block.field_71981_t.field_71990_ca;
                           }
                        }

                        var3[var43] = (byte)var52;
                        var43 += var44;
                        var47 += var49;
                     }

                     var34 += var38;
                     var36 += var40;
                  }

                  var15 += var23;
                  var17 += var25;
                  var19 += var27;
                  var21 += var29;
               }
            }
         }
      }

   }

   public void replaceBlocksForBiome(int var1, int var2, byte[] var3, BiomeGenBase[] var4) {
      byte var5 = 64;
      double var6 = 0.03125D;
      this.sandNoise = this.field_909_n.generateNoiseOctaves(this.sandNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6, var6, 1.0D);
      this.gravelNoise = this.field_909_n.generateNoiseOctaves(this.gravelNoise, (double)(var1 * 16), 109.0134D, (double)(var2 * 16), 16, 1, 16, var6, 1.0D, var6);
      this.stoneNoise = this.field_908_o.generateNoiseOctaves(this.stoneNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);

      for(int var8 = 0; var8 < 16; ++var8) {
         for(int var9 = 0; var9 < 16; ++var9) {
            BiomeGenBase var10 = var4[var8 + var9 * 16];
            boolean var11 = this.sandNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 0.0D;
            boolean var12 = this.gravelNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 3.0D;
            int var13 = (int)(this.stoneNoise[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
            int var14 = -1;
            byte var15 = var10.field_76752_A;
            byte var16 = var10.field_76753_B;

            for(int var17 = 127; var17 >= 0; --var17) {
               int var18 = (var9 * 16 + var8) * 128 + var17;
               byte var19 = var3[var18];
               if(var19 == 0) {
                  var14 = -1;
               } else if(var19 == Block.field_71981_t.field_71990_ca) {
                  if(var14 == -1) {
                     if(var13 <= 0) {
                        var15 = var10.field_76752_A;
                        var16 = var10.field_76753_B;
                     } else if(var17 >= var5 - 4 && var17 <= var5 + 1) {
                        var15 = var10.field_76752_A;
                        var16 = var10.field_76753_B;
                     }

                     var3[var18] = var15;
                     var14 = var13;
                  } else if(var14 > 0) {
                     --var14;
                     var3[var18] = var16;
                     if(var14 == 0 && var16 == Block.field_71939_E.field_71990_ca) {
                        var14 = this.rand.nextInt(4);
                        var16 = (byte)Block.field_71957_Q.field_71990_ca;
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
      this.rand.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
      double[] var4 = this.worldObj.func_72959_q().temperature;
      this.generateTerrain(var1, var2, var3, this.biomesForGeneration, var4);
      this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
      this.field_902_u.func_75036_a(this, this.worldObj, var1, var2, var3);
      Chunk var5 = new Chunk(this.worldObj, var3, var1, var2);
      byte[] var6 = var5.func_76605_m();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)this.biomesForGeneration[var7].field_76756_M;
      }

      var5.func_76603_b();
      return var5;
   }

   private double[] func_4061_a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      double[] var12 = this.worldObj.func_72959_q().temperature;
      double[] var13 = this.worldObj.func_72959_q().humidity;
      this.field_4182_g = this.field_922_a.generateNoiseOctaves(this.field_4182_g, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
      this.field_4181_h = this.field_921_b.generateNoiseOctaves(this.field_4181_h, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
      var8 *= 2.0D;
      this.field_4185_d = this.field_910_m.generateNoiseOctaves(this.field_4185_d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.field_4184_e = this.field_912_k.generateNoiseOctaves(this.field_4184_e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
      this.field_4183_f = this.field_911_l.generateNoiseOctaves(this.field_4183_f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
      int var14 = 0;
      int var15 = 0;
      int var16 = 16 / var5;

      for(int var17 = 0; var17 < var5; ++var17) {
         int var18 = var17 * var16 + var16 / 2;

         for(int var19 = 0; var19 < var7; ++var19) {
            int var20 = var19 * var16 + var16 / 2;
            double var21;
            double var23;
            if(!this.nether) {
               var23 = var12[var18 * 16 + var20];
               var21 = var13[var18 * 16 + var20] * var23;
            } else {
               var21 = 0.5D;
            }

            var23 = 1.0D - var21;
            var23 *= var23;
            var23 *= var23;
            var23 = 1.0D - var23;
            double var25 = (this.field_4182_g[var15] + 256.0D) / 512.0D;
            var25 *= var23;
            if(var25 > 1.0D) {
               var25 = 1.0D;
            }

            double var27 = this.field_4181_h[var15] / 8000.0D;
            if(var27 < 0.0D) {
               var27 = -var27 * 0.3D;
            }

            var27 = var27 * 3.0D - 2.0D;
            if(var27 > 1.0D) {
               var27 = 1.0D;
            }

            var27 /= 8.0D;
            var27 = 0.0D;
            if(var25 < 0.0D) {
               var25 = 0.0D;
            }

            var25 += 0.5D;
            var27 = var27 * (double)var6 / 16.0D;
            ++var15;
            double var29 = (double)var6 / 2.0D;

            for(int var31 = 0; var31 < var6; ++var31) {
               double var32 = 0.0D;
               double var34 = ((double)var31 - var29) * 8.0D / var25;
               if(var34 < 0.0D) {
                  var34 *= -1.0D;
               }

               double var36 = this.field_4184_e[var14] / 512.0D;
               double var38 = this.field_4183_f[var14] / 512.0D;
               double var40 = (this.field_4185_d[var14] / 10.0D + 1.0D) / 2.0D;
               if(var40 < 0.0D) {
                  var32 = var36;
               } else if(var40 > 1.0D) {
                  var32 = var38;
               } else {
                  var32 = var36 + (var38 - var36) * var40;
               }

               var32 -= 8.0D;
               byte var42 = 32;
               double var43;
               if(var31 > var6 - var42) {
                  var43 = (double)((float)(var31 - (var6 - var42)) / ((float)var42 - 1.0F));
                  var32 = var32 * (1.0D - var43) + -30.0D * var43;
               }

               var42 = 8;
               if(var31 < var42) {
                  var43 = (double)((float)(var42 - var31) / ((float)var42 - 1.0F));
                  var32 = var32 * (1.0D - var43) + -30.0D * var43;
               }

               var1[var14] = var32;
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
      int var4;
      int var5;
      BiomeGenBase var6;
      long var7;
      long var9;
      double var11;
      int var13;
      int var14;
      int var15;
      int var16;
      int var17;
      if(this.worldtype == 2) {
         BlockSand.field_72192_a = true;
         var4 = var2 * 16;
         var5 = var3 * 16;
         var6 = this.worldObj.func_72959_q().func_76935_a(var4 + 16, var5 + 16);
         this.rand.setSeed(this.worldObj.func_72905_C());
         var7 = this.rand.nextLong() / 2L * 2L + 1L;
         var9 = this.rand.nextLong() / 2L * 2L + 1L;
         this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.func_72905_C());
         var11 = 0.25D;
         if(this.rand.nextInt(4) == 0) {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(128);
            var15 = var5 + this.rand.nextInt(16) + 8;
            (new BWG4oldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
         }

         if(this.rand.nextInt(8) == 0) {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var15 = var5 + this.rand.nextInt(16) + 8;
            if(var14 < 64 || this.rand.nextInt(10) == 0) {
               (new BWG4oldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
            }
         }

         if(this.rand.nextInt(30) == 0) {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(15);
            var15 = var5 + this.rand.nextInt(16) + 8;
            if(this.rand.nextInt(8) == 0) {
               (new BWG4decoDungeons(12, false, false, true)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
            } else {
               (new BWG4decoDungeons(12, false, true, false)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
            }
         }

         for(var13 = 0; var13 < 10; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenClay(32, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_71979_v.field_71990_ca, 32, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 10; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_71940_F.field_71990_ca, 32, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(128);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_71950_I.field_71990_ca, 16, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 20; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(64);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_71949_H.field_71990_ca, 8, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 2; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(32);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_71941_G.field_71990_ca, 8, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 8; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(16);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_72047_aN.field_71990_ca, 7, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 1; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(16);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_72073_aw.field_71990_ca, 7, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         for(var13 = 0; var13 < 1; ++var13) {
            var14 = var4 + this.rand.nextInt(16);
            var15 = this.rand.nextInt(16) + this.rand.nextInt(16);
            var16 = var5 + this.rand.nextInt(16);
            (new BWG4oldGenMinable(Block.field_71947_N.field_71990_ca, 6, 2)).func_76484_a(this.worldObj, this.rand, var14, var15, var16);
         }

         var11 = 0.5D;
         var13 = (int)((this.mobSpawnerNoise.func_806_a((double)var4 * var11, (double)var5 * var11) / 8.0D + this.rand.nextDouble() * 4.0D + 4.0D) / 3.0D);
         var14 = 0;
         if(this.rand.nextInt(10) == 0) {
            ++var14;
         }

         if(var6 == BiomeGenBase.BETAforest) {
            var14 += var13 + 5;
         }

         if(var6 == BiomeGenBase.BETArainforest) {
            var14 += var13 + 5;
         }

         if(var6 == BiomeGenBase.BETAseasonalForest) {
            var14 += var13 + 2;
         }

         if(var6 == BiomeGenBase.BETAtaiga) {
            var14 += var13 + 5;
         }

         if(var6 == BiomeGenBase.BETAdesert) {
            var14 -= 20;
         }

         if(var6 == BiomeGenBase.BETAtundra) {
            var14 -= 20;
         }

         if(var6 == BiomeGenBase.BETAplains) {
            var14 -= 20;
         }

         for(var15 = 0; var15 < var14; ++var15) {
            var16 = var4 + this.rand.nextInt(16) + 8;
            var17 = var5 + this.rand.nextInt(16) + 8;
            WorldGenerator var18 = var6.func_76740_a(this.rand);
            var18.func_76487_a(1.0D, 1.0D, 1.0D);
            var18.func_76484_a(this.worldObj, this.rand, var16, this.worldObj.func_72976_f(var16, var17), var17);
         }

         byte var30 = 0;
         if(var6 == BiomeGenBase.BETAforest) {
            var30 = 2;
         }

         if(var6 == BiomeGenBase.BETAseasonalForest) {
            var30 = 4;
         }

         if(var6 == BiomeGenBase.BETAtaiga) {
            var30 = 2;
         }

         if(var6 == BiomeGenBase.BETAplains) {
            var30 = 3;
         }

         int var19;
         int var28;
         for(var16 = 0; var16 < var30; ++var16) {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var28 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72097_ad.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var17, var28, var19);
         }

         byte var31 = 0;
         if(var6 == BiomeGenBase.BETAforest) {
            var31 = 2;
         }

         if(var6 == BiomeGenBase.BETArainforest) {
            var31 = 10;
         }

         if(var6 == BiomeGenBase.BETAseasonalForest) {
            var31 = 2;
         }

         if(var6 == BiomeGenBase.BETAtaiga) {
            var31 = 1;
         }

         if(var6 == BiomeGenBase.BETAplains) {
            var31 = 10;
         }

         int var20;
         int var21;
         for(var17 = 0; var17 < var31; ++var17) {
            byte var29 = 1;
            if(var6 == BiomeGenBase.BETArainforest && this.rand.nextInt(3) != 0) {
               var29 = 2;
            }

            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(128);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, var29)).func_76484_a(this.worldObj, this.rand, var19, var20, var21);
         }

         var31 = 0;
         if(var6 == BiomeGenBase.BETAdesert) {
            var31 = 2;
         }

         for(var17 = 0; var17 < var31; ++var17) {
            var28 = var4 + this.rand.nextInt(16) + 8;
            var19 = this.rand.nextInt(128);
            var20 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.field_71961_Y.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var28, var19, var20);
         }

         if(this.rand.nextInt(2) == 0) {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var28 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72107_ae.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var17, var28, var19);
         }

         if(this.rand.nextInt(4) == 0) {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var28 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72109_af.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var17, var28, var19);
         }

         if(this.rand.nextInt(8) == 0) {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var28 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72103_ag.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var17, var28, var19);
         }

         for(var17 = 0; var17 < 10; ++var17) {
            var28 = var4 + this.rand.nextInt(16) + 8;
            var19 = this.rand.nextInt(128);
            var20 = var5 + this.rand.nextInt(16) + 8;
            (new BWG4oldGenReed()).func_76484_a(this.worldObj, this.rand, var28, var19, var20);
         }

         if(this.rand.nextInt(32) == 0) {
            var17 = var4 + this.rand.nextInt(16) + 8;
            var28 = this.rand.nextInt(128);
            var19 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenPumpkin()).func_76484_a(this.worldObj, this.rand, var17, var28, var19);
         }

         var17 = 0;
         if(var6 == BiomeGenBase.BETAdesert) {
            var17 += 10;
         }

         for(var28 = 0; var28 < var17; ++var28) {
            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(128);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenCactus()).func_76484_a(this.worldObj, this.rand, var19, var20, var21);
         }

         for(var28 = 0; var28 < 50; ++var28) {
            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_71942_A.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var19, var20, var21);
         }

         for(var28 = 0; var28 < 20; ++var28) {
            var19 = var4 + this.rand.nextInt(16) + 8;
            var20 = this.rand.nextInt(this.rand.nextInt(this.rand.nextInt(112) + 8) + 8);
            var21 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_71944_C.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var19, var20, var21);
         }

         SpawnerAnimals.func_77191_a(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
         this.generatedTemperatures = this.worldObj.func_72959_q().getColdTemperatures(this.generatedTemperatures, var4 + 8, var5 + 8, 16, 16);

         for(var28 = var4 + 8; var28 < var4 + 8 + 16; ++var28) {
            for(var19 = var5 + 8; var19 < var5 + 8 + 16; ++var19) {
               var20 = var28 - (var4 + 8);
               var21 = var19 - (var5 + 8);
               int var22 = this.worldObj.func_72874_g(var28, var19);
               double var23 = this.generatedTemperatures[var20 * 16 + var21] - (double)(var22 - 64) / 64.0D * 0.3D;
               if(var23 < 0.5D && var22 > 0 && var22 < 128 && this.worldObj.func_72799_c(var28, var22, var19)) {
                  if(this.worldObj.func_72803_f(var28, var22 - 1, var19).func_76230_c() && this.worldObj.func_72803_f(var28, var22 - 1, var19) != Material.field_76260_u) {
                     this.worldObj.func_72832_d(var28, var22, var19, Block.field_72037_aS.field_71990_ca, 0, 2);
                  } else if(this.worldObj.func_72803_f(var28, 63, var19) == Material.field_76244_g) {
                     this.worldObj.func_72832_d(var28, 63, var19, Block.field_72036_aT.field_71990_ca, 0, 2);
                  }
               }
            }
         }

         BlockSand.field_72192_a = false;
      } else if(this.worldtype == 1) {
         BlockSand.field_72192_a = true;
         var4 = var2 * 16;
         var5 = var3 * 16;
         var6 = this.worldObj.func_72959_q().func_76935_a(var4 + 16, var5 + 16);
         this.rand.setSeed(this.worldObj.func_72905_C());
         var7 = this.rand.nextLong() / 2L * 2L + 1L;
         var9 = this.rand.nextLong() / 2L * 2L + 1L;
         this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.func_72905_C());
         var11 = 0.25D;
         if(this.rand.nextInt(4) == 0) {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(128);
            var15 = var5 + this.rand.nextInt(16) + 8;
            (new BWG4oldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
         }

         if(this.rand.nextInt(8) == 0) {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var15 = var5 + this.rand.nextInt(16) + 8;
            if(var14 < 64 || this.rand.nextInt(10) == 0) {
               (new BWG4oldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
            }
         }

         if(this.rand.nextInt(30) == 0) {
            var13 = var4 + this.rand.nextInt(16) + 8;
            var14 = this.rand.nextInt(15);
            var15 = var5 + this.rand.nextInt(16) + 8;
            if(this.rand.nextInt(8) == 0) {
               (new BWG4decoDungeons(13, false, false, true)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
            } else {
               (new BWG4decoDungeons(13, false, true, false)).func_76484_a(this.worldObj, this.rand, var13, var14, var15);
            }
         }

         var6.func_76728_a(this.worldObj, this.rand, var4, var5);
         SpawnerAnimals.func_77191_a(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
         this.generatedTemperatures = this.worldObj.func_72959_q().getColdTemperatures(this.generatedTemperatures, var4 + 8, var5 + 8, 16, 16);

         for(var13 = var4 + 8; var13 < var4 + 8 + 16; ++var13) {
            for(var14 = var5 + 8; var14 < var5 + 8 + 16; ++var14) {
               var15 = var13 - (var4 + 8);
               var16 = var14 - (var5 + 8);
               var17 = this.worldObj.func_72874_g(var13, var14);
               double var32 = this.generatedTemperatures[var15 * 16 + var16] - (double)(var17 - 64) / 64.0D * 0.3D;
               if(var32 < 0.5D && var17 > 0 && var17 < 128 && this.worldObj.func_72799_c(var13, var17, var14)) {
                  if(this.worldObj.func_72803_f(var13, var17 - 1, var14).func_76230_c() && this.worldObj.func_72803_f(var13, var17 - 1, var14) != Material.field_76260_u) {
                     this.worldObj.func_72832_d(var13, var17, var14, Block.field_72037_aS.field_71990_ca, 0, 2);
                  } else if(this.worldObj.func_72803_f(var13, 63, var14) == Material.field_76244_g) {
                     this.worldObj.func_72832_d(var13, 63, var14, Block.field_72036_aT.field_71990_ca, 0, 2);
                  }
               }
            }
         }

         BlockSand.field_72192_a = false;
      } else {
         BlockSand.field_72192_a = true;
         var4 = var2 * 16;
         var5 = var3 * 16;
         int var8;
         int var25;
         int var26;
         if(this.rand.nextInt(20) == 0) {
            var25 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(15);
            var8 = var5 + this.rand.nextInt(16) + 8;
            (new BWG4decoDungeons(17, true, true, false)).func_76484_a(this.worldObj, this.rand, var25, var26, var8);
         }

         int var27;
         for(var25 = 0; var25 < 15; ++var25) {
            var26 = var4 + this.rand.nextInt(16) + 8;
            var8 = this.rand.nextInt(80) + 4;
            var27 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenHellLava(Block.field_71944_C.field_71990_ca, false)).func_76484_a(this.worldObj, this.rand, var26, var8, var27);
         }

         if(this.rand.nextInt(4) == 0) {
            var25 = var4 + this.rand.nextInt(16) + 8;
            var26 = var5 + this.rand.nextInt(16) + 8;
            (new BWG4decoSurvival(2)).func_76484_a(this.worldObj, this.rand, var25, this.worldObj.func_72976_f(var25, var26), var26);
         }

         if(this.rand.nextInt(3) == 0) {
            var25 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var8 = var5 + this.rand.nextInt(16) + 8;
            (new BWG4decoSurvival(3)).func_76484_a(this.worldObj, this.rand, var25, var26, var8);
         }

         for(var25 = 0; var25 < 4; ++var25) {
            var26 = var4 + this.rand.nextInt(16) + 8;
            var8 = this.rand.nextInt(120) + 4;
            var27 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFire()).func_76484_a(this.worldObj, this.rand, var26, var8, var27);
         }

         if(this.rand.nextInt(1) == 0) {
            var25 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var8 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72109_af.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var25, var26, var8);
         }

         if(this.rand.nextInt(1) == 0) {
            var25 = var4 + this.rand.nextInt(16) + 8;
            var26 = this.rand.nextInt(128);
            var8 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72103_ag.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var25, var26, var8);
         }

         for(var25 = 0; var25 < 16; ++var25) {
            var26 = var4 + this.rand.nextInt(16);
            var8 = this.rand.nextInt(108) + 10;
            var27 = var5 + this.rand.nextInt(16);
            (new WorldGenMinable(Block.field_94342_cr.field_71990_ca, 13, Block.field_72012_bb.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var26, var8, var27);
         }

         var6 = this.worldObj.func_72807_a(var4 + 16, var5 + 16);
         var6.func_76728_a(this.worldObj, this.worldObj.field_73012_v, var4, var5);
         BlockSand.field_72192_a = false;
      }

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
      BiomeGenBase var5 = this.worldObj.func_72807_a(var2, var4);
      return var5 == null?null:var5.func_76747_a(var1);
   }

   public ChunkPosition func_73150_a(World var1, String var2, int var3, int var4, int var5) {
      return null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int var1, int var2) {
      if(this.mapFeaturesEnabled) {
         ;
      }

   }

   public void func_104112_b() {}
}
