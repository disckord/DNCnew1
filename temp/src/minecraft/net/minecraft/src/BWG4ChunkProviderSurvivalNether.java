package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4decoDungeons;
import net.minecraft.src.BWG4decoSurvival;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.BlockSand;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.MapGenBase;
import net.minecraft.src.MapGenCaves;
import net.minecraft.src.MathHelper;
import net.minecraft.src.NoiseGeneratorOctaves;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenFire;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenHellLava;
import net.minecraft.src.WorldGenMinable;

public class BWG4ChunkProviderSurvivalNether implements IChunkProvider {

   private Random endRNG;
   private NoiseGeneratorOctaves noiseGen1;
   private NoiseGeneratorOctaves noiseGen2;
   private NoiseGeneratorOctaves noiseGen3;
   public NoiseGeneratorOctaves noiseGen4;
   public NoiseGeneratorOctaves noiseGen5;
   private World endWorld;
   private double[] densities;
   private BiomeGenBase[] biomesForGeneration;
   double[] noiseData1;
   double[] noiseData2;
   double[] noiseData3;
   double[] noiseData4;
   double[] noiseData5;
   int[][] field_73203_h = new int[32][32];
   private MapGenBase caveGenerator = new MapGenCaves();


   public BWG4ChunkProviderSurvivalNether(World var1, long var2) {
      this.endWorld = var1;
      this.endRNG = new Random(var2);
      this.noiseGen1 = new NoiseGeneratorOctaves(this.endRNG, 16);
      this.noiseGen2 = new NoiseGeneratorOctaves(this.endRNG, 16);
      this.noiseGen3 = new NoiseGeneratorOctaves(this.endRNG, 8);
      this.noiseGen4 = new NoiseGeneratorOctaves(this.endRNG, 10);
      this.noiseGen5 = new NoiseGeneratorOctaves(this.endRNG, 16);
   }

   public void generateTerrain(int var1, int var2, byte[] var3, BiomeGenBase[] var4) {
      byte var5 = 2;
      int var6 = var5 + 1;
      byte var7 = 33;
      int var8 = var5 + 1;
      this.densities = this.initializeNoiseField(this.densities, var1 * var5, 0, var2 * var5, var6, var7, var8);

      for(int var9 = 0; var9 < var5; ++var9) {
         for(int var10 = 0; var10 < var5; ++var10) {
            for(int var11 = 0; var11 < 32; ++var11) {
               double var12 = 0.25D;
               double var14 = this.densities[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
               double var16 = this.densities[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
               double var18 = this.densities[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
               double var20 = this.densities[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
               double var22 = (this.densities[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.densities[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.densities[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.densities[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

               for(int var30 = 0; var30 < 4; ++var30) {
                  double var31 = 0.125D;
                  double var33 = var14;
                  double var35 = var16;
                  double var37 = (var18 - var14) * var31;
                  double var39 = (var20 - var16) * var31;

                  for(int var41 = 0; var41 < 8; ++var41) {
                     int var42 = var41 + var9 * 8 << 11 | 0 + var10 * 8 << 7 | var11 * 4 + var30;
                     short var43 = 128;
                     double var44 = 0.125D;
                     double var46 = var33;
                     double var48 = (var35 - var33) * var44;

                     for(int var50 = 0; var50 < 8; ++var50) {
                        int var51 = 0;
                        if(var46 > 0.0D) {
                           var51 = Block.field_72012_bb.field_71990_ca;
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

   public void replaceBlocksForBiome(int var1, int var2, byte[] var3, BiomeGenBase[] var4) {
      for(int var5 = 0; var5 < 16; ++var5) {
         for(int var6 = 0; var6 < 16; ++var6) {
            byte var7 = 1;
            int var8 = -1;
            byte var9 = (byte)Block.field_72012_bb.field_71990_ca;
            byte var10 = (byte)Block.field_72012_bb.field_71990_ca;

            for(int var11 = 127; var11 >= 0; --var11) {
               int var12 = (var6 * 16 + var5) * 128 + var11;
               byte var13 = var3[var12];
               if(var13 == 0) {
                  var8 = -1;
               } else if(var13 == Block.field_72012_bb.field_71990_ca) {
                  if(var8 == -1) {
                     if(var7 <= 0) {
                        var9 = (byte)Block.field_72012_bb.field_71990_ca;
                        var10 = (byte)Block.field_72012_bb.field_71990_ca;
                     }

                     var8 = var7;
                     if(var11 >= 0) {
                        var3[var12] = var9;
                     } else {
                        var3[var12] = var10;
                     }
                  } else if(var8 > 0) {
                     --var8;
                     var3[var12] = var10;
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
      this.endRNG.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.biomesForGeneration = this.endWorld.func_72959_q().func_76933_b(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
      this.generateTerrain(var1, var2, var3, this.biomesForGeneration);
      this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
      this.caveGenerator.func_75036_a(this, this.endWorld, var1, var2, var3);
      Chunk var4 = new Chunk(this.endWorld, var3, var1, var2);
      byte[] var5 = var4.func_76605_m();

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.biomesForGeneration[var6].field_76756_M;
      }

      var4.func_76603_b();
      return var4;
   }

   private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 684.412D;
      this.noiseData4 = this.noiseGen4.func_76305_a(this.noiseData4, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
      this.noiseData5 = this.noiseGen5.func_76305_a(this.noiseData5, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
      var8 *= 2.0D;
      this.noiseData1 = this.noiseGen3.func_76304_a(this.noiseData1, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
      this.noiseData2 = this.noiseGen1.func_76304_a(this.noiseData2, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      this.noiseData3 = this.noiseGen2.func_76304_a(this.noiseData3, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      int var12 = 0;
      int var13 = 0;

      for(int var14 = 0; var14 < var5; ++var14) {
         for(int var15 = 0; var15 < var7; ++var15) {
            double var16 = (this.noiseData4[var13] + 256.0D) / 512.0D;
            if(var16 > 1.0D) {
               var16 = 1.0D;
            }

            double var18 = this.noiseData5[var13] / 8000.0D;
            if(var18 < 0.0D) {
               var18 = -var18 * 0.3D;
            }

            var18 = var18 * 3.0D - 2.0D;
            float var20 = (float)(var14 + var2 - 0) / 1.0F;
            float var21 = (float)(var15 + var4 - 0) / 1.0F;
            float var22 = 100.0F - MathHelper.func_76129_c(var20 * var20 + var21 * var21) * 8.0F;
            if(var22 > 80.0F) {
               var22 = 80.0F;
            }

            if(var22 < -100.0F) {
               var22 = -100.0F;
            }

            if(var18 > 1.0D) {
               var18 = 1.0D;
            }

            var18 /= 8.0D;
            var18 = 0.0D;
            if(var16 < 0.0D) {
               var16 = 0.0D;
            }

            var16 += 0.5D;
            var18 = var18 * (double)var6 / 16.0D;
            ++var13;
            double var23 = (double)var6 / 2.0D;

            for(int var25 = 0; var25 < var6; ++var25) {
               double var26 = 0.0D;
               double var28 = ((double)var25 - var23) * 8.0D / var16;
               if(var28 < 0.0D) {
                  var28 *= -1.0D;
               }

               double var30 = this.noiseData2[var12] / 512.0D;
               double var32 = this.noiseData3[var12] / 512.0D;
               double var34 = (this.noiseData1[var12] / 10.0D + 1.0D) / 2.0D;
               if(var34 < 0.0D) {
                  var26 = var30;
               } else if(var34 > 1.0D) {
                  var26 = var32;
               } else {
                  var26 = var30 + (var32 - var30) * var34;
               }

               var26 -= 8.0D;
               var26 += (double)var22;
               byte var36 = 2;
               double var37;
               if(var25 > var6 / 2 - var36) {
                  var37 = (double)((float)(var25 - (var6 / 2 - var36)) / 64.0F);
                  if(var37 < 0.0D) {
                     var37 = 0.0D;
                  }

                  if(var37 > 1.0D) {
                     var37 = 1.0D;
                  }

                  var26 = var26 * (1.0D - var37) + -400.0D * var37;
               }

               var36 = 8;
               if(var25 < var36) {
                  var37 = (double)((float)(var36 - var25) / ((float)var36 - 1.0F));
                  var26 = var26 * (1.0D - var37) + -30.0D * var37;
               }

               var1[var12] = var26;
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
      int var6;
      int var7;
      int var8;
      if(this.endRNG.nextInt(10) == 0) {
         var6 = var4 + this.endRNG.nextInt(16) + 8;
         var7 = this.endRNG.nextInt(15);
         var8 = var5 + this.endRNG.nextInt(16) + 8;
         (new BWG4decoDungeons(18, true, true, false)).func_76484_a(this.endWorld, this.endRNG, var6, var7, var8);
      }

      int var9;
      for(var6 = 0; var6 < 15; ++var6) {
         var7 = var4 + this.endRNG.nextInt(16) + 8;
         var8 = this.endRNG.nextInt(80) + 4;
         var9 = var5 + this.endRNG.nextInt(16) + 8;
         (new WorldGenHellLava(Block.field_71944_C.field_71990_ca, false)).func_76484_a(this.endWorld, this.endRNG, var7, var8, var9);
      }

      if(this.endRNG.nextInt(2) == 0) {
         var6 = var4 + this.endRNG.nextInt(16) + 8;
         var7 = var5 + this.endRNG.nextInt(16) + 8;
         (new BWG4decoSurvival(2)).func_76484_a(this.endWorld, this.endRNG, var6, this.endWorld.func_72976_f(var6, var7), var7);
      }

      for(var6 = 0; var6 < 1; ++var6) {
         var7 = var4 + this.endRNG.nextInt(16) + 8;
         var8 = this.endRNG.nextInt(128);
         var9 = var5 + this.endRNG.nextInt(16) + 8;
         (new BWG4decoSurvival(3)).func_76484_a(this.endWorld, this.endRNG, var7, var8, var9);
      }

      for(var6 = 0; var6 < 4; ++var6) {
         var7 = var4 + this.endRNG.nextInt(16) + 8;
         var8 = this.endRNG.nextInt(120) + 4;
         var9 = var5 + this.endRNG.nextInt(16) + 8;
         (new WorldGenFire()).func_76484_a(this.endWorld, this.endRNG, var7, var8, var9);
      }

      if(this.endRNG.nextInt(1) == 0) {
         var6 = var4 + this.endRNG.nextInt(16) + 8;
         var7 = this.endRNG.nextInt(128);
         var8 = var5 + this.endRNG.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72109_af.field_71990_ca)).func_76484_a(this.endWorld, this.endRNG, var6, var7, var8);
      }

      if(this.endRNG.nextInt(1) == 0) {
         var6 = var4 + this.endRNG.nextInt(16) + 8;
         var7 = this.endRNG.nextInt(128);
         var8 = var5 + this.endRNG.nextInt(16) + 8;
         (new WorldGenFlowers(Block.field_72103_ag.field_71990_ca)).func_76484_a(this.endWorld, this.endRNG, var6, var7, var8);
      }

      for(var6 = 0; var6 < 16; ++var6) {
         var7 = var4 + this.endRNG.nextInt(16);
         var8 = this.endRNG.nextInt(108) + 10;
         var9 = var5 + this.endRNG.nextInt(16);
         (new WorldGenMinable(Block.field_94342_cr.field_71990_ca, 13, Block.field_72012_bb.field_71990_ca)).func_76484_a(this.endWorld, this.endRNG, var7, var8, var9);
      }

      BiomeGenBase var10 = this.endWorld.func_72807_a(var4 + 16, var5 + 16);
      var10.func_76728_a(this.endWorld, this.endWorld.field_73012_v, var4, var5);
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
      BiomeGenBase var5 = this.endWorld.func_72807_a(var2, var4);
      return var5 == null?null:var5.func_76747_a(var1);
   }

   public ChunkPosition func_73150_a(World var1, String var2, int var3, int var4, int var5) {
      return null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int var1, int var2) {}

   public void func_104112_b() {}
}
