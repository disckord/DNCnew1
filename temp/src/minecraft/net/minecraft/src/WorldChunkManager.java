package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4oldNoiseGeneratorOctaves2;
import net.minecraft.src.BiomeCache;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;
import net.minecraft.src.World;
import net.minecraft.src.WorldType;

public class WorldChunkManager {

   private GenLayer field_76944_d;
   private GenLayer field_76945_e;
   private BiomeCache field_76942_f;
   private List field_76943_g;
   public WorldType terrainType;
   private BWG4oldNoiseGeneratorOctaves2 field_4194_e;
   private BWG4oldNoiseGeneratorOctaves2 field_4193_f;
   private BWG4oldNoiseGeneratorOctaves2 field_4192_g;
   public double[] temperature;
   public double[] humidity;
   public double[] field_4196_c;
   private int[] biomeLookupTable;


   protected WorldChunkManager() {
      this.biomeLookupTable = new int[4096];
      this.field_76942_f = new BiomeCache(this);
      this.field_76943_g = new ArrayList();
      this.field_76943_g.add(BiomeGenBase.field_76767_f);
      this.field_76943_g.add(BiomeGenBase.field_76772_c);
      this.field_76943_g.add(BiomeGenBase.field_76787_r);
      this.field_76943_g.add(BiomeGenBase.BDtropicalisland);
      this.field_76943_g.add(BiomeGenBase.BDjungleisland);
      this.field_76943_g.add(BiomeGenBase.BDmushroomisland);
      this.field_76943_g.add(BiomeGenBase.BDbeach);
      this.field_76943_g.add(BiomeGenBase.BDbeachDunes);
      this.field_76943_g.add(BiomeGenBase.BDsnowpines);
      this.field_76943_g.add(BiomeGenBase.BDsnowforest);
      this.field_76943_g.add(BiomeGenBase.BDsnowtaiga);
      this.field_76943_g.add(BiomeGenBase.BDsnowplains);
      this.field_76943_g.add(BiomeGenBase.BDsnowhills);
      this.field_76943_g.add(BiomeGenBase.BDplains);
      this.field_76943_g.add(BiomeGenBase.BDforest);
      this.field_76943_g.add(BiomeGenBase.BDforesthills);
      this.field_76943_g.add(BiomeGenBase.BDforestlakes);
      this.field_76943_g.add(BiomeGenBase.BDpines);
      this.field_76943_g.add(BiomeGenBase.BDtaiga);
      this.field_76943_g.add(BiomeGenBase.BDgrassland);
      this.field_76943_g.add(BiomeGenBase.BDrainforest);
      this.field_76943_g.add(BiomeGenBase.BDjungle);
      this.field_76943_g.add(BiomeGenBase.BDswampland);
      this.field_76943_g.add(BiomeGenBase.BDdesert);
      this.field_76943_g.add(BiomeGenBase.BDsavanna);
      this.field_76943_g.add(BiomeGenBase.BDsavannaforest);
      this.field_76943_g.add(BiomeGenBase.BDshrubland);
      this.field_76943_g.add(BiomeGenBase.BDshrublandHill);
   }

   public WorldChunkManager(long var1, WorldType var3, String var4) {
      this();
      this.terrainType = var3;
      this.generateBiomeLookup(var3);
      this.field_4194_e = new BWG4oldNoiseGeneratorOctaves2(new Random(var1 * 9871L), 4);
      this.field_4193_f = new BWG4oldNoiseGeneratorOctaves2(new Random(var1 * 39811L), 4);
      this.field_4192_g = new BWG4oldNoiseGeneratorOctaves2(new Random(var1 * 543321L), 2);
      boolean var5 = false;
      if(var4.length() > 3) {
         var5 = true;
      }

      GenLayer[] var6 = GenLayer.initializeAllBiomeGenerators(var1, var3, var4, var5);
      this.field_76944_d = var6[0];
      this.field_76945_e = var6[1];
   }

   public WorldChunkManager(long p_i3751_1_, WorldType p_i3751_3_) {
      this(p_i3751_1_, p_i3751_3_, "");
   }

   public WorldChunkManager(World p_i3752_1_) {
      this(p_i3752_1_.func_72905_C(), p_i3752_1_.func_72912_H().func_76067_t(), p_i3752_1_.func_72912_H().func_82571_y());
   }

   public double[] getColdTemperatures(double[] var1, int var2, int var3, int var4, int var5) {
      if(var1 == null || var1.length < var4 * var5) {
         var1 = new double[var4 * var5];
      }

      var1 = this.field_4194_e.func_4112_a(var1, (double)var2, (double)var3, var4, var5, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
      this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, (double)var2, (double)var3, var4, var5, 0.25D, 0.25D, 0.5882352941176471D);
      int var6 = 0;

      for(int var7 = 0; var7 < var4; ++var7) {
         for(int var8 = 0; var8 < var5; ++var8) {
            double var9 = this.field_4196_c[var6] * 1.1D + 0.5D;
            double var11 = 0.01D;
            double var13 = 1.0D - var11;
            double var15 = (var1[var6] * 0.15D + 0.7D) * var13 + var9 * var11;
            var15 = 1.0D - (1.0D - var15) * (1.0D - var15);
            if(var15 < 0.0D) {
               var15 = 0.0D;
            }

            if(var15 > 1.0D) {
               var15 = 1.0D;
            }

            var1[var6] = var15;
            ++var6;
         }
      }

      return var1;
   }

   public int[] getBiomesGens(int var1, int var2, int var3, int var4) {
      int[] var5 = new int[var3 * var4];
      this.temperature = this.field_4194_e.func_4112_a(this.temperature, (double)var1, (double)var2, var3, var3, 0.02500000037252903D, 0.02500000037252903D, 0.25D);
      this.humidity = this.field_4193_f.func_4112_a(this.humidity, (double)var1, (double)var2, var3, var3, 0.05000000074505806D, 0.05000000074505806D, 0.3333333333333333D);
      this.field_4196_c = this.field_4192_g.func_4112_a(this.field_4196_c, (double)var1, (double)var2, var3, var3, 0.25D, 0.25D, 0.5882352941176471D);
      int var6 = 0;

      for(int var7 = 0; var7 < var3; ++var7) {
         for(int var8 = 0; var8 < var4; ++var8) {
            double var9 = this.field_4196_c[var6] * 1.1D + 0.5D;
            double var11 = 0.01D;
            double var13 = 1.0D - var11;
            double var15 = (this.temperature[var6] * 0.15D + 0.7D) * var13 + var9 * var11;
            var11 = 0.002D;
            var13 = 1.0D - var11;
            double var17 = (this.humidity[var6] * 0.15D + 0.5D) * var13 + var9 * var11;
            var15 = 1.0D - (1.0D - var15) * (1.0D - var15);
            if(var15 < 0.0D) {
               var15 = 0.0D;
            }

            if(var17 < 0.0D) {
               var17 = 0.0D;
            }

            if(var15 > 1.0D) {
               var15 = 1.0D;
            }

            if(var17 > 1.0D) {
               var17 = 1.0D;
            }

            this.temperature[var6] = var15;
            this.humidity[var6] = var17;
            var5[var6++] = this.getBiomeFromLookup(var15, var17);
         }
      }

      return var5;
   }

   public int getBiomeFromLookup(double var1, double var3) {
      int var5 = (int)(var1 * 63.0D);
      int var6 = (int)(var3 * 63.0D);
      return this.biomeLookupTable[var5 + var6 * 64];
   }

   public void generateBiomeLookup(WorldType var1) {
      int var2;
      int var3;
      if(var1 == WorldType.BWG4SKY1) {
         for(var2 = 0; var2 < 64; ++var2) {
            for(var3 = 0; var3 < 64; ++var3) {
               this.biomeLookupTable[var2 + var3 * 64] = this.getDefaultBiomes((float)var2 / 63.0F, (float)var3 / 63.0F);
            }
         }
      } else if(var1 == WorldType.BWG4SKY2) {
         for(var2 = 0; var2 < 64; ++var2) {
            for(var3 = 0; var3 < 64; ++var3) {
               this.biomeLookupTable[var2 + var3 * 64] = this.getBetaBiomes((float)var2 / 63.0F, (float)var3 / 63.0F);
            }
         }
      } else if(var1 == WorldType.BWG4BETA1) {
         for(var2 = 0; var2 < 64; ++var2) {
            for(var3 = 0; var3 < 64; ++var3) {
               this.biomeLookupTable[var2 + var3 * 64] = this.getBetaBiomes((float)var2 / 63.0F, (float)var3 / 63.0F);
            }
         }
      } else if(var1 == WorldType.BWG4BETA2) {
         for(var2 = 0; var2 < 64; ++var2) {
            for(var3 = 0; var3 < 64; ++var3) {
               this.biomeLookupTable[var2 + var3 * 64] = this.getDefaultBiomes((float)var2 / 63.0F, (float)var3 / 63.0F);
            }
         }
      } else {
         for(var2 = 0; var2 < 64; ++var2) {
            for(var3 = 0; var3 < 64; ++var3) {
               this.biomeLookupTable[var2 + var3 * 64] = this.getAlphaBiomes((float)var2 / 63.0F, (float)var3 / 63.0F);
            }
         }
      }

   }

   public int getBetaBiomes(float var1, float var2) {
      var2 *= var1;
      return var1 < 0.1F?BiomeGenBase.BETAtundra.field_76756_M:(var2 < 0.2F?(var1 < 0.5F?BiomeGenBase.BETAtundra.field_76756_M:(var1 < 0.95F?BiomeGenBase.BETAsavanna.field_76756_M:BiomeGenBase.BETAdesert.field_76756_M)):(var2 > 0.5F && var1 < 0.7F?BiomeGenBase.BETAswampland.field_76756_M:(var1 < 0.5F?BiomeGenBase.BETAtaiga.field_76756_M:(var1 < 0.97F?(var2 < 0.35F?BiomeGenBase.BETAshrubland.field_76756_M:BiomeGenBase.BETAforest.field_76756_M):(var2 < 0.45F?BiomeGenBase.BETAplains.field_76756_M:(var2 < 0.9F?BiomeGenBase.BETAseasonalForest.field_76756_M:BiomeGenBase.BETArainforest.field_76756_M))))));
   }

   public int getDefaultBiomes(float var1, float var2) {
      var2 *= var1;
      return var1 < 0.2F?(var2 < 0.1F?BiomeGenBase.BDsnowplains.field_76756_M:BiomeGenBase.BDsnowpines.field_76756_M):(var1 < 0.4F?(var2 < 0.1F?BiomeGenBase.BDsnowtaiga.field_76756_M:(var2 < 0.2F?BiomeGenBase.BDsnowforest.field_76756_M:BiomeGenBase.BDsnowpines.field_76756_M)):(var1 < 0.5F?(var2 < 0.1F?BiomeGenBase.BDtaiga.field_76756_M:(var2 < 0.2F?BiomeGenBase.BDforest.field_76756_M:BiomeGenBase.BDpines.field_76756_M)):(var1 < 0.7F?(var2 < 0.3F?BiomeGenBase.BDforest.field_76756_M:(var2 < 0.5F?BiomeGenBase.BDforesthills.field_76756_M:(var2 < 0.7F?BiomeGenBase.BDgrassland.field_76756_M:BiomeGenBase.BDswampland_nocolor.field_76756_M))):(var1 < 0.8F?(var2 < 0.2F?BiomeGenBase.BDplains.field_76756_M:(var2 < 0.5F?BiomeGenBase.BDforest.field_76756_M:(var2 < 0.7F?BiomeGenBase.BDforestlakes.field_76756_M:BiomeGenBase.BDswampland_nocolor.field_76756_M))):(var2 < 0.2F?(var1 < 0.9F?BiomeGenBase.BDshrubland.field_76756_M:BiomeGenBase.BDdesert.field_76756_M):(var2 < 0.3F?BiomeGenBase.BDsavanna.field_76756_M:(var2 < 0.4F?BiomeGenBase.BDplains.field_76756_M:(var2 < 0.7F?BiomeGenBase.BDforestlakes.field_76756_M:(var2 < 0.8F?BiomeGenBase.BDrainforest.field_76756_M:BiomeGenBase.BDjungle_nocolor.field_76756_M)))))))));
   }

   public int getAlphaBiomes(float var1, float var2) {
      var2 *= var1;
      return var1 < 0.1F?BiomeGenBase.ALPHAtundra.field_76756_M:(var2 < 0.2F?(var1 < 0.5F?BiomeGenBase.ALPHAtundra.field_76756_M:(var1 < 0.95F?BiomeGenBase.ALPHAsavanna.field_76756_M:BiomeGenBase.ALPHAdesert.field_76756_M)):(var2 > 0.5F && var1 < 0.7F?BiomeGenBase.ALPHAswampland.field_76756_M:(var1 < 0.5F?BiomeGenBase.ALPHAtaiga.field_76756_M:(var1 < 0.97F?(var2 < 0.35F?BiomeGenBase.ALPHAshrubland.field_76756_M:BiomeGenBase.ALPHAforest.field_76756_M):(var2 < 0.45F?BiomeGenBase.ALPHAplains.field_76756_M:(var2 < 0.9F?BiomeGenBase.ALPHAseasonalForest.field_76756_M:BiomeGenBase.ALPHArainforest.field_76756_M))))));
   }

   public List func_76932_a() {
      return this.field_76943_g;
   }

   public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_) {
      return this.field_76942_f.func_76837_b(p_76935_1_, p_76935_2_);
   }

   public float[] func_76936_a(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_) {
      IntCache.func_76446_a();
      if(p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_) {
         p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
      }

      int[] var6;
      if(this.terrainType != WorldType.BWG4BETA1 && this.terrainType != WorldType.BWG4BETA2 && this.terrainType != WorldType.BWG4SKY1 && this.terrainType != WorldType.BWG4SKY2 && this.terrainType != WorldType.BWG4ALPHA) {
         var6 = this.field_76945_e.func_75904_a(p_76936_2_, p_76936_3_, p_76936_4_, p_76936_5_);
      } else {
         var6 = this.getBiomesGens(p_76936_2_, p_76936_3_, p_76936_4_, p_76936_5_);
      }

      for(int var7 = 0; var7 < p_76936_4_ * p_76936_5_; ++var7) {
         float var8 = (float)BiomeGenBase.field_76773_a[var6[var7]].func_76744_g() / 65536.0F;
         if(var8 > 1.0F) {
            var8 = 1.0F;
         }

         p_76936_1_[var7] = var8;
      }

      return p_76936_1_;
   }

   public float func_76939_a(float p_76939_1_, int p_76939_2_) {
      return p_76939_1_;
   }

   public float[] func_76934_b(float[] p_76934_1_, int p_76934_2_, int p_76934_3_, int p_76934_4_, int p_76934_5_) {
      IntCache.func_76446_a();
      if(p_76934_1_ == null || p_76934_1_.length < p_76934_4_ * p_76934_5_) {
         p_76934_1_ = new float[p_76934_4_ * p_76934_5_];
      }

      int[] var6;
      if(this.terrainType != WorldType.BWG4BETA1 && this.terrainType != WorldType.BWG4BETA2 && this.terrainType != WorldType.BWG4SKY1 && this.terrainType != WorldType.BWG4SKY2 && this.terrainType != WorldType.BWG4ALPHA) {
         var6 = this.field_76945_e.func_75904_a(p_76934_2_, p_76934_3_, p_76934_4_, p_76934_5_);
      } else {
         var6 = this.getBiomesGens(p_76934_2_, p_76934_3_, p_76934_4_, p_76934_5_);
      }

      for(int var7 = 0; var7 < p_76934_4_ * p_76934_5_; ++var7) {
         float var8 = (float)BiomeGenBase.field_76773_a[var6[var7]].func_76734_h() / 65536.0F;
         if(var8 > 1.0F) {
            var8 = 1.0F;
         }

         p_76934_1_[var7] = var8;
      }

      return p_76934_1_;
   }

   public BiomeGenBase[] func_76937_a(BiomeGenBase[] p_76937_1_, int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_) {
      IntCache.func_76446_a();
      if(p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_) {
         p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
      }

      int[] var6;
      if(this.terrainType != WorldType.BWG4BETA1 && this.terrainType != WorldType.BWG4BETA2 && this.terrainType != WorldType.BWG4SKY1 && this.terrainType != WorldType.BWG4SKY2 && this.terrainType != WorldType.BWG4ALPHA) {
         var6 = this.field_76944_d.func_75904_a(p_76937_2_, p_76937_3_, p_76937_4_, p_76937_5_);
      } else {
         var6 = this.getBiomesGens(p_76937_2_, p_76937_3_, p_76937_4_, p_76937_5_);
      }

      for(int var7 = 0; var7 < p_76937_4_ * p_76937_5_; ++var7) {
         p_76937_1_[var7] = BiomeGenBase.field_76773_a[var6[var7]];
      }

      return p_76937_1_;
   }

   public BiomeGenBase[] func_76933_b(BiomeGenBase[] p_76933_1_, int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_) {
      return this.func_76931_a(p_76933_1_, p_76933_2_, p_76933_3_, p_76933_4_, p_76933_5_, true);
   }

   public BiomeGenBase[] func_76931_a(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_) {
      IntCache.func_76446_a();
      if(p_76931_1_ == null || p_76931_1_.length < p_76931_4_ * p_76931_5_) {
         p_76931_1_ = new BiomeGenBase[p_76931_4_ * p_76931_5_];
      }

      if(p_76931_6_ && p_76931_4_ == 16 && p_76931_5_ == 16 && (p_76931_2_ & 15) == 0 && (p_76931_3_ & 15) == 0) {
         BiomeGenBase[] var9 = this.field_76942_f.func_76839_e(p_76931_2_, p_76931_3_);
         System.arraycopy(var9, 0, p_76931_1_, 0, p_76931_4_ * p_76931_5_);
         return p_76931_1_;
      } else {
         int[] var7;
         if(this.terrainType != WorldType.BWG4BETA1 && this.terrainType != WorldType.BWG4BETA2 && this.terrainType != WorldType.BWG4SKY1 && this.terrainType != WorldType.BWG4SKY2 && this.terrainType != WorldType.BWG4ALPHA) {
            var7 = this.field_76945_e.func_75904_a(p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);
         } else {
            var7 = this.getBiomesGens(p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);
         }

         for(int var8 = 0; var8 < p_76931_4_ * p_76931_5_; ++var8) {
            p_76931_1_[var8] = BiomeGenBase.field_76773_a[var7[var8]];
         }

         return p_76931_1_;
      }
   }

   public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_) {
      IntCache.func_76446_a();
      int var5 = p_76940_1_ - p_76940_3_ >> 2;
      int var6 = p_76940_2_ - p_76940_3_ >> 2;
      int var7 = p_76940_1_ + p_76940_3_ >> 2;
      int var8 = p_76940_2_ + p_76940_3_ >> 2;
      int var9 = var7 - var5 + 1;
      int var10 = var8 - var6 + 1;
      if(this.terrainType != WorldType.BWG4BETA1 && this.terrainType != WorldType.BWG4BETA2 && this.terrainType != WorldType.BWG4SKY1 && this.terrainType != WorldType.BWG4SKY2 && this.terrainType != WorldType.BWG4ALPHA) {
         int[] var11 = this.field_76944_d.func_75904_a(var5, var6, var9, var10);

         for(int var12 = 0; var12 < var9 * var10; ++var12) {
            BiomeGenBase var13 = BiomeGenBase.field_76773_a[var11[var12]];
            if(!p_76940_4_.contains(var13)) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public ChunkPosition func_76941_a(int p_76941_1_, int p_76941_2_, int p_76941_3_, List p_76941_4_, Random p_76941_5_) {
      IntCache.func_76446_a();
      int var6 = p_76941_1_ - p_76941_3_ >> 2;
      int var7 = p_76941_2_ - p_76941_3_ >> 2;
      int var8 = p_76941_1_ + p_76941_3_ >> 2;
      int var9 = p_76941_2_ + p_76941_3_ >> 2;
      int var10 = var8 - var6 + 1;
      int var11 = var9 - var7 + 1;
      if(this.terrainType != WorldType.BWG4BETA1 && this.terrainType != WorldType.BWG4BETA2 && this.terrainType != WorldType.BWG4SKY1 && this.terrainType != WorldType.BWG4SKY2 && this.terrainType != WorldType.BWG4ALPHA) {
         int[] var12 = this.field_76944_d.func_75904_a(var6, var7, var10, var11);
         ChunkPosition var13 = null;
         int var14 = 0;

         for(int var15 = 0; var15 < var10 * var11; ++var15) {
            int var16 = var6 + var15 % var10 << 2;
            int var17 = var7 + var15 / var10 << 2;
            BiomeGenBase var18 = BiomeGenBase.field_76773_a[var12[var15]];
            if(p_76941_4_.contains(var18) && (var13 == null || p_76941_5_.nextInt(var14 + 1) == 0)) {
               var13 = new ChunkPosition(var16, 0, var17);
               ++var14;
            }
         }

         return var13;
      } else {
         return null;
      }
   }

   public void func_76938_b() {
      this.field_76942_f.func_76838_a();
   }
}
