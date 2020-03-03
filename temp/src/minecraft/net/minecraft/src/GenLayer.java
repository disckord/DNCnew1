package net.minecraft.src;

import net.minecraft.src.BWG4LayerBiome;
import net.minecraft.src.BWG4LayerCreate;
import net.minecraft.src.BWG4LayerHills;
import net.minecraft.src.BWG4LayerRiverMix;
import net.minecraft.src.BWG4LayerShore;
import net.minecraft.src.GenLayerAddIsland;
import net.minecraft.src.GenLayerAddMushroomIsland;
import net.minecraft.src.GenLayerAddSnow;
import net.minecraft.src.GenLayerBiome;
import net.minecraft.src.GenLayerFuzzyZoom;
import net.minecraft.src.GenLayerHills;
import net.minecraft.src.GenLayerIsland;
import net.minecraft.src.GenLayerRiver;
import net.minecraft.src.GenLayerRiverInit;
import net.minecraft.src.GenLayerRiverMix;
import net.minecraft.src.GenLayerShore;
import net.minecraft.src.GenLayerSmooth;
import net.minecraft.src.GenLayerSwampRivers;
import net.minecraft.src.GenLayerVoronoiZoom;
import net.minecraft.src.GenLayerZoom;
import net.minecraft.src.WorldType;

public abstract class GenLayer {

   private long field_75907_b;
   protected GenLayer field_75909_a;
   private long field_75908_c;
   private long field_75906_d;
   private static String[] generatorSettings;
   private static boolean isRemote = false;


   public static GenLayer[] initializeAllBiomeGenerators(long var0, WorldType var2, String var3, boolean var4) {
      if(!isRemote) {
         isRemote = var4;
      }

      GenLayerZoom var34;
      if(var2 != WorldType.BWG4DEFAULT && var2 != WorldType.BWG4LARGE) {
         GenLayerIsland var29 = new GenLayerIsland(1L);
         GenLayerFuzzyZoom var26 = new GenLayerFuzzyZoom(2000L, var29);
         GenLayerAddIsland var32 = new GenLayerAddIsland(1L, var26);
         var34 = new GenLayerZoom(2001L, var32);
         var32 = new GenLayerAddIsland(2L, var34);
         GenLayerAddSnow var37 = new GenLayerAddSnow(2L, var32);
         var34 = new GenLayerZoom(2002L, var37);
         var32 = new GenLayerAddIsland(3L, var34);
         var34 = new GenLayerZoom(2003L, var32);
         var32 = new GenLayerAddIsland(4L, var34);
         GenLayerAddMushroomIsland var39 = new GenLayerAddMushroomIsland(5L, var32);
         byte var11 = 4;
         if(var2 == WorldType.field_77135_d) {
            var11 = 6;
         }

         GenLayer var12 = GenLayerZoom.func_75915_a(1000L, var39, 0);
         GenLayerRiverInit var13 = new GenLayerRiverInit(100L, var12);
         var12 = GenLayerZoom.func_75915_a(1000L, var13, var11 + 2);
         GenLayerRiver var14 = new GenLayerRiver(1L, var12);
         GenLayerSmooth var15 = new GenLayerSmooth(1000L, var14);
         GenLayer var16 = GenLayerZoom.func_75915_a(1000L, var39, 0);
         GenLayerBiome var17 = new GenLayerBiome(200L, var16, var2);
         var16 = GenLayerZoom.func_75915_a(1000L, var17, 2);
         Object var18 = new GenLayerHills(1000L, var16);

         for(int var19 = 0; var19 < var11; ++var19) {
            var18 = new GenLayerZoom((long)(1000 + var19), (GenLayer)var18);
            if(var19 == 0) {
               var18 = new GenLayerAddIsland(3L, (GenLayer)var18);
            }

            if(var19 == 1) {
               var18 = new GenLayerShore(1000L, (GenLayer)var18);
            }

            if(var19 == 1) {
               var18 = new GenLayerSwampRivers(1000L, (GenLayer)var18);
            }
         }

         GenLayerSmooth var42 = new GenLayerSmooth(1000L, (GenLayer)var18);
         GenLayerRiverMix var20 = new GenLayerRiverMix(100L, var42, var15);
         GenLayerVoronoiZoom var21 = new GenLayerVoronoiZoom(10L, var20);
         var20.func_75905_a(var0);
         var21.func_75905_a(var0);
         return new GenLayer[]{var20, var21, var20};
      } else {
         if(var3.length() > 3) {
            String[] var5 = var3.split("&");
            generatorSettings = var5[1].split(";");
         }

         BWG4LayerCreate var22 = new BWG4LayerCreate(1L, generatorSettings, isRemote);
         GenLayerFuzzyZoom var23 = new GenLayerFuzzyZoom(2000L, var22);
         GenLayerAddIsland var24 = new GenLayerAddIsland(1L, var23);
         GenLayerZoom var25 = new GenLayerZoom(2001L, var24);
         var24 = new GenLayerAddIsland(2L, var25);
         var25 = new GenLayerZoom(2002L, var24);
         var24 = new GenLayerAddIsland(3L, var25);
         var25 = new GenLayerZoom(2003L, var24);
         var24 = new GenLayerAddIsland(4L, var25);
         byte var6 = 4;
         if(var2 == WorldType.BWG4LARGE) {
            var6 = 6;
         }

         GenLayer var7 = GenLayerZoom.func_75915_a(1000L, var24, 0);
         GenLayerRiverInit var27 = new GenLayerRiverInit(100L, var7);
         var7 = GenLayerZoom.func_75915_a(1000L, var27, var6 + 2);
         GenLayerRiver var28 = new GenLayerRiver(1L, var7);
         GenLayerSmooth var30 = new GenLayerSmooth(1000L, var28);
         GenLayer var8 = GenLayerZoom.func_75915_a(1000L, var24, 0);
         BWG4LayerBiome var31 = new BWG4LayerBiome(200L, var8, var2, generatorSettings, 0, isRemote);
         var8 = GenLayerZoom.func_75915_a(1000L, var31, 2);
         BWG4LayerHills var33 = new BWG4LayerHills(1000L, var8, generatorSettings, isRemote);
         var34 = new GenLayerZoom(1000L, var33);
         BWG4LayerShore var35 = new BWG4LayerShore(1000L, var34, 1, generatorSettings, isRemote);
         Object var38 = new BWG4LayerShore(1000L, var35, 2, generatorSettings, isRemote);

         for(int var9 = 1; var9 < var6; ++var9) {
            var38 = new GenLayerZoom((long)(1000 + var9), (GenLayer)var38);
         }

         GenLayerSmooth var40 = new GenLayerSmooth(1000L, (GenLayer)var38);
         BWG4LayerRiverMix var41 = new BWG4LayerRiverMix(100L, var40, var30);
         BWG4LayerRiverMix var36 = (BWG4LayerRiverMix)((BWG4LayerRiverMix)var41);
         GenLayerVoronoiZoom var10 = new GenLayerVoronoiZoom(10L, var41);
         var41.func_75905_a(var0);
         var10.func_75905_a(var0);
         return new GenLayer[]{var41, var10, var36};
      }
   }

   public static GenLayer[] func_75901_a(long p_75901_0_, WorldType p_75901_2_) {
      GenLayerIsland var3 = new GenLayerIsland(1L);
      GenLayerFuzzyZoom var4 = new GenLayerFuzzyZoom(2000L, var3);
      GenLayerAddIsland var5 = new GenLayerAddIsland(1L, var4);
      GenLayerZoom var6 = new GenLayerZoom(2001L, var5);
      var5 = new GenLayerAddIsland(2L, var6);
      GenLayerAddSnow var7 = new GenLayerAddSnow(2L, var5);
      var6 = new GenLayerZoom(2002L, var7);
      var5 = new GenLayerAddIsland(3L, var6);
      var6 = new GenLayerZoom(2003L, var5);
      var5 = new GenLayerAddIsland(4L, var6);
      GenLayerAddMushroomIsland var8 = new GenLayerAddMushroomIsland(5L, var5);
      byte var9 = 4;
      if(p_75901_2_ == WorldType.field_77135_d) {
         var9 = 6;
      }

      GenLayer var10 = GenLayerZoom.func_75915_a(1000L, var8, 0);
      GenLayerRiverInit var11 = new GenLayerRiverInit(100L, var10);
      var10 = GenLayerZoom.func_75915_a(1000L, var11, var9 + 2);
      GenLayerRiver var12 = new GenLayerRiver(1L, var10);
      GenLayerSmooth var13 = new GenLayerSmooth(1000L, var12);
      GenLayer var14 = GenLayerZoom.func_75915_a(1000L, var8, 0);
      GenLayerBiome var15 = new GenLayerBiome(200L, var14, p_75901_2_);
      var14 = GenLayerZoom.func_75915_a(1000L, var15, 2);
      Object var16 = new GenLayerHills(1000L, var14);

      for(int var17 = 0; var17 < var9; ++var17) {
         var16 = new GenLayerZoom((long)(1000 + var17), (GenLayer)var16);
         if(var17 == 0) {
            var16 = new GenLayerAddIsland(3L, (GenLayer)var16);
         }

         if(var17 == 1) {
            var16 = new GenLayerShore(1000L, (GenLayer)var16);
         }

         if(var17 == 1) {
            var16 = new GenLayerSwampRivers(1000L, (GenLayer)var16);
         }
      }

      GenLayerSmooth var20 = new GenLayerSmooth(1000L, (GenLayer)var16);
      GenLayerRiverMix var18 = new GenLayerRiverMix(100L, var20, var13);
      GenLayerVoronoiZoom var19 = new GenLayerVoronoiZoom(10L, var18);
      var18.func_75905_a(p_75901_0_);
      var19.func_75905_a(p_75901_0_);
      return new GenLayer[]{var18, var19, var18};
   }

   public GenLayer(long p_i3891_1_) {
      this.field_75906_d = p_i3891_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i3891_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i3891_1_;
      this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
      this.field_75906_d += p_i3891_1_;
   }

   public void func_75905_a(long p_75905_1_) {
      this.field_75907_b = p_75905_1_;
      if(this.field_75909_a != null) {
         this.field_75909_a.func_75905_a(p_75905_1_);
      }

      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
      this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
      this.field_75907_b += this.field_75906_d;
   }

   public void func_75903_a(long p_75903_1_, long p_75903_3_) {
      this.field_75908_c = this.field_75907_b;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_1_;
      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += p_75903_3_;
   }

   protected int func_75902_a(int p_75902_1_) {
      int var2 = (int)((this.field_75908_c >> 24) % (long)p_75902_1_);
      if(var2 < 0) {
         var2 += p_75902_1_;
      }

      this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
      this.field_75908_c += this.field_75907_b;
      return var2;
   }

   public abstract int[] func_75904_a(int var1, int var2, int var3, int var4);

}
