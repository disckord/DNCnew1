package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.GenLayer;
import net.minecraft.src.IntCache;

public class BWG4LayerRiverMix extends GenLayer {

   private GenLayer biomePatternGeneratorChain;
   private GenLayer riverPatternGeneratorChain;


   public BWG4LayerRiverMix(long var1, GenLayer var3, GenLayer var4) {
      super(var1);
      this.biomePatternGeneratorChain = var3;
      this.riverPatternGeneratorChain = var4;
   }

   public void func_75905_a(long var1) {
      this.biomePatternGeneratorChain.func_75905_a(var1);
      this.riverPatternGeneratorChain.func_75905_a(var1);
      super.func_75905_a(var1);
   }

   public int[] func_75904_a(int var1, int var2, int var3, int var4) {
      int[] var5 = this.biomePatternGeneratorChain.func_75904_a(var1, var2, var3, var4);
      int[] var6 = this.riverPatternGeneratorChain.func_75904_a(var1, var2, var3, var4);
      int[] var7 = IntCache.func_76445_a(var3 * var4);

      for(int var8 = 0; var8 < var3 * var4; ++var8) {
         if(var5[var8] != BiomeGenBase.BDocean.field_76756_M && var5[var8] != BiomeGenBase.BDtropicalisland.field_76756_M && var5[var8] != BiomeGenBase.BDjungleisland.field_76756_M && var5[var8] != BiomeGenBase.BDmushroomisland.field_76756_M) {
            if(var6[var8] >= 0) {
               if(var5[var8] != BiomeGenBase.BDsnowpines.field_76756_M && var5[var8] != BiomeGenBase.BDsnowforest.field_76756_M && var5[var8] != BiomeGenBase.BDsnowtaiga.field_76756_M && var5[var8] != BiomeGenBase.BDsnowplains.field_76756_M && var5[var8] != BiomeGenBase.BDsnowhills.field_76756_M) {
                  if(var5[var8] != BiomeGenBase.BDjungle.field_76756_M && var5[var8] != BiomeGenBase.BDswampland.field_76756_M) {
                     if(var5[var8] != BiomeGenBase.BDdesert.field_76756_M && var5[var8] != BiomeGenBase.BDocean.field_76756_M && var5[var8] != BiomeGenBase.BDbeach.field_76756_M && var5[var8] != BiomeGenBase.BDbeachDunes.field_76756_M) {
                        var7[var8] = BiomeGenBase.BDriver.field_76756_M;
                     } else {
                        var7[var8] = BiomeGenBase.BDsandriver.field_76756_M;
                     }
                  } else {
                     var7[var8] = BiomeGenBase.BDgreenriver.field_76756_M;
                  }
               } else {
                  var7[var8] = BiomeGenBase.BDiceriver.field_76756_M;
               }
            } else {
               var7[var8] = var5[var8];
            }
         } else {
            var7[var8] = var5[var8];
         }
      }

      return var7;
   }
}
