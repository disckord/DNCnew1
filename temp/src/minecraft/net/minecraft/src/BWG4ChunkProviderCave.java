package net.minecraft.src;

import java.util.List;
import java.util.Random;
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
import net.minecraft.src.MapGenStronghold;
import net.minecraft.src.NoiseGeneratorOctaves;
import net.minecraft.src.World;

public class BWG4ChunkProviderCave implements IChunkProvider {

   private Random hellRNG;
   private NoiseGeneratorOctaves netherNoiseGen1;
   private NoiseGeneratorOctaves netherNoiseGen2;
   private NoiseGeneratorOctaves netherNoiseGen3;
   private NoiseGeneratorOctaves slowsandGravelNoiseGen;
   private NoiseGeneratorOctaves netherrackExculsivityNoiseGen;
   public NoiseGeneratorOctaves netherNoiseGen6;
   public NoiseGeneratorOctaves netherNoiseGen7;
   private World worldObj;
   private double[] noiseField;
   private double[] slowsandNoise = new double[256];
   private double[] gravelNoise = new double[256];
   private double[] netherrackExclusivityNoise = new double[256];
   private MapGenBase caveGenerator = new MapGenCaves();
   private MapGenStronghold strongholdGenerator = new MapGenStronghold();
   private MapGenMineshaft mineshaftGenerator = new MapGenMineshaft();
   double[] noiseData1;
   double[] noiseData2;
   double[] noiseData3;
   double[] noiseData4;
   double[] noiseData5;
   private final boolean mapFeaturesEnabled;
   boolean themeDEFAULT = false;
   boolean themeDESERT = false;
   boolean themeSTONE = false;
   boolean themeJUNGLE = false;


   public BWG4ChunkProviderCave(World var1, long var2, boolean var4, int var5) {
      this.worldObj = var1;
      this.hellRNG = new Random(var2);
      this.netherNoiseGen1 = new NoiseGeneratorOctaves(this.hellRNG, 16);
      this.netherNoiseGen2 = new NoiseGeneratorOctaves(this.hellRNG, 16);
      this.netherNoiseGen3 = new NoiseGeneratorOctaves(this.hellRNG, 8);
      this.slowsandGravelNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
      this.netherrackExculsivityNoiseGen = new NoiseGeneratorOctaves(this.hellRNG, 4);
      this.netherNoiseGen6 = new NoiseGeneratorOctaves(this.hellRNG, 10);
      this.netherNoiseGen7 = new NoiseGeneratorOctaves(this.hellRNG, 16);
      this.mapFeaturesEnabled = var4;
      if(var5 == 1) {
         this.themeDEFAULT = true;
      }

      if(var5 == 2) {
         this.themeDESERT = true;
      }

      if(var5 == 3) {
         this.themeSTONE = true;
      }

      if(var5 == 4) {
         this.themeJUNGLE = true;
      }

   }

   public void generateNetherTerrain(int var1, int var2, byte[] var3) {
      byte var4 = 4;
      byte var5 = 32;
      int var6 = var4 + 1;
      byte var7 = 17;
      int var8 = var4 + 1;
      this.noiseField = this.initializeNoiseField(this.noiseField, var1 * var4, 0, var2 * var4, var6, var7, var8);

      for(int var9 = 0; var9 < var4; ++var9) {
         for(int var10 = 0; var10 < var4; ++var10) {
            for(int var11 = 0; var11 < 16; ++var11) {
               double var12 = 0.125D;
               double var14 = this.noiseField[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
               double var16 = this.noiseField[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
               double var18 = this.noiseField[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
               double var20 = this.noiseField[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
               double var22 = (this.noiseField[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
               double var24 = (this.noiseField[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
               double var26 = (this.noiseField[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
               double var28 = (this.noiseField[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

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
                           var51 = Block.field_71938_D.field_71990_ca;
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
      this.slowsandNoise = this.slowsandGravelNoiseGen.func_76304_a(this.slowsandNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var5, var5, 1.0D);
      this.gravelNoise = this.slowsandGravelNoiseGen.func_76304_a(this.gravelNoise, var1 * 16, 109, var2 * 16, 16, 1, 16, var5, 1.0D, var5);
      this.netherrackExclusivityNoise = this.netherrackExculsivityNoiseGen.func_76304_a(this.netherrackExclusivityNoise, var1 * 16, var2 * 16, 0, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

      for(int var7 = 0; var7 < 16; ++var7) {
         for(int var8 = 0; var8 < 16; ++var8) {
            boolean var9 = this.slowsandNoise[var7 + var8 * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D;
            boolean var10 = this.gravelNoise[var7 + var8 * 16] + this.hellRNG.nextDouble() * 0.2D > 0.0D;
            int var11 = (int)(this.netherrackExclusivityNoise[var7 + var8 * 16] / 3.0D + 3.0D + this.hellRNG.nextDouble() * 0.25D);
            int var12 = -1;
            byte var13 = (byte)Block.field_71980_u.field_71990_ca;
            byte var14 = (byte)Block.field_71979_v.field_71990_ca;
            if(this.themeDEFAULT) {
               var13 = (byte)Block.field_71980_u.field_71990_ca;
               var14 = (byte)Block.field_71979_v.field_71990_ca;
            }

            if(this.themeDESERT) {
               var13 = (byte)Block.field_71939_E.field_71990_ca;
               var14 = (byte)Block.field_71939_E.field_71990_ca;
            }

            if(this.themeSTONE) {
               var13 = (byte)Block.field_71981_t.field_71990_ca;
               var14 = (byte)Block.field_71981_t.field_71990_ca;
            }

            if(this.themeJUNGLE) {
               var13 = (byte)Block.field_71980_u.field_71990_ca;
               var14 = (byte)Block.field_71979_v.field_71990_ca;
            }

            for(int var15 = 127; var15 >= 0; --var15) {
               int var16 = (var8 * 16 + var7) * 128 + var15;
               if(var15 < 127 - this.hellRNG.nextInt(5) && var15 > 0 + this.hellRNG.nextInt(5)) {
                  byte var17 = var3[var16];
                  if(var17 == 0) {
                     var12 = -1;
                  } else if(var17 == Block.field_71981_t.field_71990_ca) {
                     if(var12 == -1) {
                        if(var15 < var4 && var13 == 0) {
                           var13 = (byte)Block.field_71938_D.field_71990_ca;
                        }

                        var12 = var11;
                        if(var15 >= var4 - 1) {
                           var3[var16] = var13;
                        } else {
                           var3[var16] = var14;
                        }
                     } else if(var12 > 0) {
                        --var12;
                        var3[var16] = var14;
                     }
                  }
               } else {
                  var3[var16] = (byte)Block.field_71986_z.field_71990_ca;
               }
            }
         }
      }

   }

   public Chunk func_73158_c(int var1, int var2) {
      return this.func_73154_d(var1, var2);
   }

   public Chunk func_73154_d(int var1, int var2) {
      this.hellRNG.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      this.generateNetherTerrain(var1, var2, var3);
      this.replaceBlocksForBiome(var1, var2, var3);
      this.caveGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
      if(this.mapFeaturesEnabled) {
         this.mineshaftGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
         this.strongholdGenerator.func_75036_a(this, this.worldObj, var1, var2, var3);
      }

      Chunk var4 = new Chunk(this.worldObj, var3, var1, var2);
      BiomeGenBase[] var5 = this.worldObj.func_72959_q().func_76933_b((BiomeGenBase[])null, var1 * 16, var2 * 16, 16, 16);
      byte[] var6 = var4.func_76605_m();

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = (byte)var5[var7].field_76756_M;
      }

      var4.func_76613_n();
      return var4;
   }

   private double[] initializeNoiseField(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if(var1 == null) {
         var1 = new double[var5 * var6 * var7];
      }

      double var8 = 684.412D;
      double var10 = 2053.236D;
      this.noiseData4 = this.netherNoiseGen6.func_76304_a(this.noiseData4, var2, var3, var4, var5, 1, var7, 1.0D, 0.0D, 1.0D);
      this.noiseData5 = this.netherNoiseGen7.func_76304_a(this.noiseData5, var2, var3, var4, var5, 1, var7, 100.0D, 0.0D, 100.0D);
      this.noiseData1 = this.netherNoiseGen3.func_76304_a(this.noiseData1, var2, var3, var4, var5, var6, var7, var8 / 80.0D, var10 / 60.0D, var8 / 80.0D);
      this.noiseData2 = this.netherNoiseGen1.func_76304_a(this.noiseData2, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      this.noiseData3 = this.netherNoiseGen2.func_76304_a(this.noiseData3, var2, var3, var4, var5, var6, var7, var8, var10, var8);
      int var12 = 0;
      int var13 = 0;
      double[] var14 = new double[var6];

      int var15;
      for(var15 = 0; var15 < var6; ++var15) {
         var14[var15] = Math.cos((double)var15 * 3.141592653589793D * 6.0D / (double)var6) * 2.0D;
         double var16 = (double)var15;
         if(var15 > var6 / 2) {
            var16 = (double)(var6 - 1 - var15);
         }

         if(var16 < 4.0D) {
            var16 = 4.0D - var16;
            var14[var15] -= var16 * var16 * var16 * 10.0D;
         }
      }

      for(var15 = 0; var15 < var5; ++var15) {
         for(int var36 = 0; var36 < var7; ++var36) {
            double var17 = (this.noiseData4[var13] + 256.0D) / 512.0D;
            if(var17 > 1.0D) {
               var17 = 1.0D;
            }

            double var19 = 0.0D;
            double var21 = this.noiseData5[var13] / 8000.0D;
            if(var21 < 0.0D) {
               var21 = -var21;
            }

            var21 = var21 * 3.0D - 3.0D;
            if(var21 < 0.0D) {
               var21 /= 2.0D;
               if(var21 < -1.0D) {
                  var21 = -1.0D;
               }

               var21 /= 1.4D;
               var21 /= 2.0D;
               var17 = 0.0D;
            } else {
               if(var21 > 1.0D) {
                  var21 = 1.0D;
               }

               var21 /= 6.0D;
            }

            var17 += 0.5D;
            var21 = var21 * (double)var6 / 16.0D;
            ++var13;

            for(int var23 = 0; var23 < var6; ++var23) {
               double var24 = 0.0D;
               double var26 = var14[var23];
               double var28 = this.noiseData2[var12] / 512.0D;
               double var30 = this.noiseData3[var12] / 512.0D;
               double var32 = (this.noiseData1[var12] / 10.0D + 1.0D) / 2.0D;
               if(var32 < 0.0D) {
                  var24 = var28;
               } else if(var32 > 1.0D) {
                  var24 = var30;
               } else {
                  var24 = var28 + (var30 - var28) * var32;
               }

               var24 -= var26;
               double var34;
               if(var23 > var6 - 4) {
                  var34 = (double)((float)(var23 - (var6 - 4)) / 3.0F);
                  var24 = var24 * (1.0D - var34) + -10.0D * var34;
               }

               if((double)var23 < var19) {
                  var34 = (var19 - (double)var23) / 4.0D;
                  if(var34 < 0.0D) {
                     var34 = 0.0D;
                  }

                  if(var34 > 1.0D) {
                     var34 = 1.0D;
                  }

                  var24 = var24 * (1.0D - var34) + -10.0D * var34;
               }

               var1[var12] = var24;
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
      this.worldObj.func_72807_a(var4 + 16, var5 + 16);
      this.hellRNG.setSeed(this.worldObj.func_72905_C());
      long var7 = this.hellRNG.nextLong() / 2L * 2L + 1L;
      long var9 = this.hellRNG.nextLong() / 2L * 2L + 1L;
      this.hellRNG.setSeed((long)var2 * var7 + (long)var3 * var9 ^ this.worldObj.func_72905_C());
      double var11 = 0.25D;
      if(this.mapFeaturesEnabled) {
         this.mineshaftGenerator.func_75051_a(this.worldObj, this.hellRNG, var2, var3);
         this.strongholdGenerator.func_75051_a(this.worldObj, this.hellRNG, var2, var3);
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
      return "HellRandomLevelSource";
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
         this.mineshaftGenerator.func_75036_a(this, this.worldObj, var1, var2, (byte[])null);
         this.strongholdGenerator.func_75036_a(this, this.worldObj, var1, var2, (byte[])null);
      }

   }

   public void func_104112_b() {}
}
