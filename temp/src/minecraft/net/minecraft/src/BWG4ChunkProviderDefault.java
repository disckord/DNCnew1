package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4NoiseOctavesBeta;
import net.minecraft.src.BWG4decoDungeons;
import net.minecraft.src.BWG4oldGenClay;
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
import net.minecraft.src.MapGenMineshaft;
import net.minecraft.src.MapGenRavine;
import net.minecraft.src.MapGenScatteredFeature;
import net.minecraft.src.MapGenStronghold;
import net.minecraft.src.MapGenVillage;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnerAnimals;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenLakes;

public class BWG4ChunkProviderDefault implements IChunkProvider {

   private Random rand;
   private BWG4NoiseOctavesBeta noiseGen1;
   private BWG4NoiseOctavesBeta noiseGen2;
   private BWG4NoiseOctavesBeta noiseGen3;
   private BWG4NoiseOctavesBeta noiseGen4;
   public BWG4NoiseOctavesBeta noiseGen5;
   public BWG4NoiseOctavesBeta noiseGen6;
   public BWG4NoiseOctavesBeta mobSpawnerNoise;
   private World worldObj;
   private final boolean mapFeaturesEnabled;
   private double[] noiseArray;
   private double[] stoneNoise = new double[256];
   private double[] sandNoise = new double[256];
   private double[] gravelNoise = new double[256];
   private MapGenBase caveGenerator = new MapGenCaves();
   private MapGenStronghold strongholdGenerator = new MapGenStronghold();
   private MapGenVillage villageGenerator = new MapGenVillage();
   private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
   private MapGenBase ravineGenerator = new MapGenRavine();
   private BiomeGenBase[] biomesForGeneration;
   double[] noise3;
   double[] noise1;
   double[] noise2;
   double[] noise5;
   double[] noise6;
   float[] parabolicField;
   int[][] field_73219_j = new int[32][32];


   public BWG4ChunkProviderDefault(World var1, long var2, boolean var4) {
      this.worldObj = var1;
      this.mapFeaturesEnabled = var4;
      this.rand = new Random(var2);
      this.noiseGen1 = new BWG4NoiseOctavesBeta(this.rand, 16);
      this.noiseGen2 = new BWG4NoiseOctavesBeta(this.rand, 16);
      this.noiseGen3 = new BWG4NoiseOctavesBeta(this.rand, 8);
      this.noiseGen4 = new BWG4NoiseOctavesBeta(this.rand, 4);
      this.noiseGen5 = new BWG4NoiseOctavesBeta(this.rand, 10);
      this.noiseGen6 = new BWG4NoiseOctavesBeta(this.rand, 16);
      this.mobSpawnerNoise = new BWG4NoiseOctavesBeta(this.rand, 8);
   }

   public void generateTerrain(int var1, int var2, byte[] var3) {
      byte var4 = 4;
      byte var5 = 16;
      byte var6 = 63;
      int var7 = var4 + 1;
      byte var8 = 17;
      int var9 = var4 + 1;
      this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, var1 * 4 - 2, var2 * 4 - 2, var7 + 5, var9 + 5);
      this.noiseArray = this.initializeNoiseField(this.noiseArray, var1 * var4, 0, var2 * var4, var7, var8, var9);

      for(int var10 = 0; var10 < var4; ++var10) {
         for(int var11 = 0; var11 < var4; ++var11) {
            for(int var12 = 0; var12 < var5; ++var12) {
               double var13 = 0.125D;
               double var15 = this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 0];
               double var17 = this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 0];
               double var19 = this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 0];
               double var21 = this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 0];
               double var23 = (this.noiseArray[((var10 + 0) * var9 + var11 + 0) * var8 + var12 + 1] - var15) * var13;
               double var25 = (this.noiseArray[((var10 + 0) * var9 + var11 + 1) * var8 + var12 + 1] - var17) * var13;
               double var27 = (this.noiseArray[((var10 + 1) * var9 + var11 + 0) * var8 + var12 + 1] - var19) * var13;
               double var29 = (this.noiseArray[((var10 + 1) * var9 + var11 + 1) * var8 + var12 + 1] - var21) * var13;

               for(int var31 = 0; var31 < 8; ++var31) {
                  double var32 = 0.25D;
                  double var34 = var15;
                  double var36 = var17;
                  double var38 = (var19 - var15) * var32;
                  double var40 = (var21 - var17) * var32;

                  for(int var42 = 0; var42 < 4; ++var42) {
                     int var43 = var42 + var10 * 4 << 11 | 0 + var11 * 4 << 7 | var12 * 8 + var31;
                     short var44 = 128;
                     var43 -= var44;
                     double var45 = 0.25D;
                     double var47 = (var36 - var34) * var45;
                     double var49 = var34 - var47;

                     for(int var51 = 0; var51 < 4; ++var51) {
                        if((var49 += var47) > 0.0D) {
                           var3[var43 += var44] = (byte)Block.field_71981_t.field_71990_ca;
                        } else if(var12 * 8 + var31 < var6) {
                           var3[var43 += var44] = (byte)Block.field_71943_B.field_71990_ca;
                        } else {
                           var3[var43 += var44] = 0;
                        }
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
      byte var5 = 63;
      double var6 = 0.03125D;
      this.stoneNoise = this.noiseGen4.generateNoiseOctaves(this.stoneNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6 * 2.0D, var6 * 2.0D, var6 * 2.0D);
      this.sandNoise = this.noiseGen4.generateNoiseOctaves(this.sandNoise, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var6, var6, 1.0D);
      this.gravelNoise = this.noiseGen4.generateNoiseOctaves(this.gravelNoise, (double)(var1 * 16), 109.0134D, (double)(var2 * 16), 16, 1, 16, var6, 1.0D, var6);

      for(int var8 = 0; var8 < 16; ++var8) {
         for(int var9 = 0; var9 < 16; ++var9) {
            BiomeGenBase var10 = var4[var9 + var8 * 16];
            boolean var11 = this.sandNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 0.0D;
            boolean var12 = this.gravelNoise[var8 + var9 * 16] + this.rand.nextDouble() * 0.2D > 3.0D;
            float var13 = var10.func_76743_j();
            int var14 = (int)(this.stoneNoise[var8 + var9 * 16] / 3.0D + 3.0D + this.rand.nextDouble() * 0.25D);
            int var15 = -1;
            byte var16 = var10.field_76752_A;
            byte var17 = var10.field_76753_B;

            for(int var18 = 127; var18 >= 0; --var18) {
               int var19 = (var9 * 16 + var8) * 128 + var18;
               if(var18 <= 0 + this.rand.nextInt(5)) {
                  var3[var19] = (byte)Block.field_71986_z.field_71990_ca;
               } else {
                  byte var20 = var3[var19];
                  if(var20 == 0) {
                     var15 = -1;
                  } else if(var20 == Block.field_71981_t.field_71990_ca) {
                     if(var15 == -1) {
                        if(var14 <= 0) {
                           var16 = 0;
                           var17 = (byte)Block.field_71981_t.field_71990_ca;
                        }

                        if(var10.isCanyon) {
                           if(var18 == 85) {
                              if(this.rand.nextInt(4) == 0) {
                                 var16 = (byte)Block.field_71939_E.field_71990_ca;
                                 var17 = (byte)Block.field_71939_E.field_71990_ca;
                              } else {
                                 var16 = var10.field_76752_A;
                                 var17 = var10.field_76753_B;
                              }
                           } else if(var18 == 86) {
                              if(this.rand.nextInt(3) == 0) {
                                 var16 = (byte)Block.field_71939_E.field_71990_ca;
                                 var17 = (byte)Block.field_71939_E.field_71990_ca;
                              } else {
                                 var16 = var10.field_76752_A;
                                 var17 = var10.field_76753_B;
                              }
                           } else if(var18 == 87) {
                              if(this.rand.nextInt(2) == 0) {
                                 var16 = (byte)Block.field_71939_E.field_71990_ca;
                                 var17 = (byte)Block.field_71939_E.field_71990_ca;
                              } else {
                                 var16 = var10.field_76752_A;
                                 var17 = var10.field_76753_B;
                              }
                           } else if(var18 == 88) {
                              if(this.rand.nextInt(3) != 0) {
                                 var16 = (byte)Block.field_71939_E.field_71990_ca;
                                 var17 = (byte)Block.field_71939_E.field_71990_ca;
                              } else {
                                 var16 = var10.field_76752_A;
                                 var17 = var10.field_76753_B;
                              }
                           } else if(var18 == 89) {
                              if(this.rand.nextInt(5) != 0) {
                                 var16 = (byte)Block.field_71939_E.field_71990_ca;
                                 var17 = (byte)Block.field_71939_E.field_71990_ca;
                              } else {
                                 var16 = var10.field_76752_A;
                                 var17 = var10.field_76753_B;
                              }
                           } else if(var18 > 89) {
                              var16 = (byte)Block.field_71939_E.field_71990_ca;
                              var17 = (byte)Block.field_71939_E.field_71990_ca;
                           }
                        }

                        if(var10.defaultbeach && var18 > 74) {
                           var16 = (byte)Block.field_71980_u.field_71990_ca;
                           var17 = (byte)Block.field_71979_v.field_71990_ca;
                        }

                        if(var10.beachID > 0 && var18 <= var5 + 1) {
                           if(var10.beachID == 1) {
                              if(var12) {
                                 var16 = 0;
                                 var17 = (byte)Block.field_71940_F.field_71990_ca;
                              }

                              if(var11) {
                                 var16 = (byte)Block.field_71939_E.field_71990_ca;
                                 var17 = (byte)Block.field_71939_E.field_71990_ca;
                              }
                           }

                           if(var10.beachID == 2) {
                              var16 = (byte)Block.field_71939_E.field_71990_ca;
                              var17 = (byte)Block.field_71939_E.field_71990_ca;
                           }

                           if(var10.beachID == 3) {
                              var16 = 0;
                              var17 = (byte)Block.field_71940_F.field_71990_ca;
                           }
                        }

                        if(var18 < var5 && var16 == 0) {
                           if(var13 < 0.15F) {
                              var16 = (byte)Block.field_72036_aT.field_71990_ca;
                           } else {
                              var16 = (byte)Block.field_71943_B.field_71990_ca;
                           }
                        }

                        var15 = var14;
                        if(var18 >= var5 - 1) {
                           var3[var19] = var16;
                        } else {
                           var3[var19] = var17;
                        }
                     } else if(var15 > 0) {
                        --var15;
                        var3[var19] = var17;
                        if(var15 == 0 && var17 == Block.field_71939_E.field_71990_ca) {
                           var15 = this.rand.nextInt(4);
                           var17 = (byte)Block.field_71957_Q.field_71990_ca;
                        }
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
      this.generateTerrain(var1, var2, var3);
      this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);
      this.replaceBlocksForBiome(var1, var2, var3, this.biomesForGeneration);
      this.caveGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
      this.ravineGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
      if(this.mapFeaturesEnabled) {
         this.mineshaftGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
         this.villageGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
         this.strongholdGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
         this.scatteredFeatureGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
      }

      Chunk var4 = new Chunk(this.worldObj, var3, var1, var2);
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

      if(this.parabolicField == null) {
         this.parabolicField = new float[25];

         for(int var8 = -2; var8 <= 2; ++var8) {
            for(int var9 = -2; var9 <= 2; ++var9) {
               float var10 = 10.0F / MathHelper.func_76129_c((float)(var8 * var8 + var9 * var9) + 0.2F);
               this.parabolicField[var8 + 2 + (var9 + 2) * 5] = var10;
            }
         }
      }

      double var44 = 684.412D;
      double var45 = 684.412D;
      this.noise5 = this.noiseGen5.generateNoiseOctaves(this.noise5, var2, var4, var5, var7, 1.121D, 1.121D, 0.5D);
      this.noise6 = this.noiseGen6.generateNoiseOctaves(this.noise6, var2, var4, var5, var7, 200.0D, 200.0D, 0.5D);
      this.noise3 = this.noiseGen3.generateNoiseOctaves(this.noise3, (double)var2, (double)var3, (double)var4, var5, var6, var7, var44 / 80.0D, var45 / 160.0D, var44 / 80.0D);
      this.noise1 = this.noiseGen1.generateNoiseOctaves(this.noise1, (double)var2, (double)var3, (double)var4, var5, var6, var7, var44, var45, var44);
      this.noise2 = this.noiseGen2.generateNoiseOctaves(this.noise2, (double)var2, (double)var3, (double)var4, var5, var6, var7, var44, var45, var44);
      boolean var12 = false;
      boolean var13 = false;
      int var14 = 0;
      int var15 = 0;

      for(int var16 = 0; var16 < var5; ++var16) {
         for(int var17 = 0; var17 < var7; ++var17) {
            float var18 = 0.0F;
            float var19 = 0.0F;
            float var20 = 0.0F;
            byte var21 = 2;
            BiomeGenBase var22 = this.biomesForGeneration[var16 + 2 + (var17 + 2) * (var5 + 5)];

            for(int var23 = -var21; var23 <= var21; ++var23) {
               for(int var24 = -var21; var24 <= var21; ++var24) {
                  BiomeGenBase var25 = this.biomesForGeneration[var16 + var23 + 2 + (var17 + var24 + 2) * (var5 + 5)];
                  float var26 = this.parabolicField[var23 + 2 + (var24 + 2) * 5] / (var25.field_76748_D + 2.0F);
                  if(var25.field_76748_D > var22.field_76748_D) {
                     var26 /= 2.0F;
                  }

                  var18 += var25.field_76749_E * var26;
                  var19 += var25.field_76748_D * var26;
                  var20 += var26;
               }
            }

            var18 /= var20;
            var19 /= var20;
            var18 = var18 * 0.9F + 0.1F;
            var19 = (var19 * 4.0F - 1.0F) / 8.0F;
            double var46 = this.noise6[var15] / 8000.0D;
            if(var46 < 0.0D) {
               var46 = -var46 * 0.3D;
            }

            var46 = var46 * 3.0D - 2.0D;
            if(var46 < 0.0D) {
               var46 /= 2.0D;
               if(var46 < -1.0D) {
                  var46 = -1.0D;
               }

               var46 /= 1.4D;
               var46 /= 2.0D;
            } else {
               if(var46 > 1.0D) {
                  var46 = 1.0D;
               }

               var46 /= 8.0D;
            }

            ++var15;

            for(int var47 = 0; var47 < var6; ++var47) {
               double var48 = (double)var19;
               double var28 = (double)var18;
               var48 += var46 * 0.2D;
               var48 = var48 * (double)var6 / 16.0D;
               double var30 = (double)var6 / 2.0D + var48 * 4.0D;
               double var32 = 0.0D;
               double var34 = ((double)var47 - var30) * 12.0D * 128.0D / 128.0D / var28;
               if(var34 < 0.0D) {
                  var34 *= 4.0D;
               }

               double var36 = this.noise1[var14] / 512.0D;
               double var38 = this.noise2[var14] / 512.0D;
               double var40 = (this.noise3[var14] / 10.0D + 1.0D) / 2.0D;
               if(var40 < 0.0D) {
                  var32 = var36;
               } else if(var40 > 1.0D) {
                  var32 = var38;
               } else {
                  var32 = var36 + (var38 - var36) * var40;
               }

               var32 -= var34;
               if(var47 > var6 - 4) {
                  double var42 = (double)((float)(var47 - (var6 - 4)) / 3.0F);
                  var32 = var32 * (1.0D - var42) + -10.0D * var42;
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
      BlockSand.field_72192_a = true;
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      BiomeGenBase var6 = this.worldObj.func_72807_a(var4 + 16, var5 + 16);
      this.rand.setSeed(this.worldObj.func_72905_C());
      long var7 = this.rand.nextLong() / 2L * 2L + 1L;
      long var9 = this.rand.nextLong() / 2L * 2L + 1L;
      this.rand.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.func_72905_C());
      boolean var11 = false;
      if(this.mapFeaturesEnabled) {
         this.mineshaftGenerator.func_75051_a(this.worldObj, this.rand, var2, var3);
         var11 = this.villageGenerator.func_75051_a(this.worldObj, this.rand, var2, var3);
         this.strongholdGenerator.func_75051_a(this.worldObj, this.rand, var2, var3);
         this.scatteredFeatureGenerator.func_75051_a(this.worldObj, this.rand, var2, var3);
      }

      int var12;
      int var13;
      int var14;
      if(var6.lakesDisabled) {
         if(!var11 && this.rand.nextInt(10) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = this.rand.nextInt(50);
            var14 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var12, var13, var14);
         }

         if(!var11 && this.rand.nextInt(8) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var14 = var5 + this.rand.nextInt(16) + 8;
            if(var13 < 50 || this.rand.nextInt(10) == 0) {
               (new WorldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var12, var13, var14);
            }
         }
      } else {
         if(!var11 && this.rand.nextInt(4) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = this.rand.nextInt(128);
            var14 = var5 + this.rand.nextInt(16) + 8;
            (new WorldGenLakes(Block.field_71943_B.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var12, var13, var14);
         }

         if(!var11 && this.rand.nextInt(8) == 0) {
            var12 = var4 + this.rand.nextInt(16) + 8;
            var13 = this.rand.nextInt(this.rand.nextInt(120) + 8);
            var14 = var5 + this.rand.nextInt(16) + 8;
            if(var13 < 63 || this.rand.nextInt(10) == 0) {
               (new WorldGenLakes(Block.field_71938_D.field_71990_ca)).func_76484_a(this.worldObj, this.rand, var12, var13, var14);
            }
         }
      }

      int var15;
      for(var15 = 0; var15 < 20; ++var15) {
         int var16 = var4 + this.rand.nextInt(16);
         int var17 = this.rand.nextInt(128);
         int var18 = var5 + this.rand.nextInt(16);
         (new BWG4oldGenClay(32, 2)).func_76484_a(this.worldObj, this.rand, var16, var17, var18);
      }

      for(var12 = 0; var12 < 8; ++var12) {
         var13 = var4 + this.rand.nextInt(16) + 8;
         var14 = this.rand.nextInt(128);
         var15 = var5 + this.rand.nextInt(16) + 8;
         if((new BWG4decoDungeons(0, true, false, false)).func_76484_a(this.worldObj, this.rand, var13, var14, var15)) {
            ;
         }
      }

      var6.func_76728_a(this.worldObj, this.rand, var4, var5);
      SpawnerAnimals.func_77191_a(this.worldObj, var6, var4 + 8, var5 + 8, 16, 16, this.rand);
      var4 += 8;
      var5 += 8;

      for(var12 = 0; var12 < 16; ++var12) {
         for(var13 = 0; var13 < 16; ++var13) {
            var14 = this.worldObj.func_72874_g(var4 + var12, var5 + var13);
            if(this.worldObj.func_72884_u(var12 + var4, var14 - 1, var13 + var5)) {
               this.worldObj.func_72832_d(var12 + var4, var14 - 1, var13 + var5, Block.field_72036_aT.field_71990_ca, 0, 2);
            }

            if(this.worldObj.func_72858_w(var12 + var4, var14, var13 + var5)) {
               this.worldObj.func_72832_d(var12 + var4, var14, var13 + var5, Block.field_72037_aS.field_71990_ca, 0, 2);
            }
         }
      }

      BlockSand.field_72192_a = false;
   }

   public boolean func_73151_a(boolean var1, IProgressUpdate var2) {
      return true;
   }

   public boolean unload100OldestChunks() {
      return false;
   }

   public boolean func_73157_c() {
      return true;
   }

   public boolean func_73156_b() {
      return false;
   }

   public String func_73148_d() {
      return "RandomLevelSource";
   }

   public List func_73155_a(EnumCreatureType var1, int var2, int var3, int var4) {
      BiomeGenBase var5 = this.worldObj.func_72807_a(var2, var4);
      return var5 == null?null:(var5 == BiomeGenBase.field_76780_h && var1 == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_75048_a(var2, var3, var4)?this.scatteredFeatureGenerator.func_82667_a():var5.func_76747_a(var1));
   }

   public ChunkPosition func_73150_a(World var1, String var2, int var3, int var4, int var5) {
      return "Stronghold".equals(var2) && this.strongholdGenerator != null?this.strongholdGenerator.func_75050_a(var1, var3, var4, var5):null;
   }

   public int func_73152_e() {
      return 0;
   }

   public void func_82695_e(int var1, int var2) {
      if(this.mapFeaturesEnabled) {
         this.mineshaftGenerator.func_75036_a(this, this.worldObj, var1, var2, (byte[])null);
         this.villageGenerator.func_75036_a(this, this.worldObj, var1, var2, (byte[])null);
         this.strongholdGenerator.func_75036_a(this, this.worldObj, var1, var2, (byte[])null);
         this.scatteredFeatureGenerator.func_75036_a(this, this.worldObj, var1, var2, (byte[])null);
      }

   }

   public void func_104112_b() {}
}
