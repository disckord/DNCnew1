package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4oldGenBigTree;
import net.minecraft.src.BWG4oldGenTrees;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.WorldGenHugeTrees;
import net.minecraft.src.WorldGenShrub;
import net.minecraft.src.WorldGenTaiga1;
import net.minecraft.src.WorldGenTaiga2;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;

public class BWG4BiomesBeta extends BiomeGenBase {

   private int biomeid;


   public BWG4BiomesBeta(int var1) {
      super(var1);
      this.biomeid = var1;
      if(var1 == 80 || var1 == 90) {
         this.field_76761_J.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
      }

      if(var1 == 81 || var1 == 82 || var1 == 83 || var1 == 86) {
         this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
      }

      if(var1 == 87) {
         this.field_76762_K.clear();
         this.field_76752_A = (byte)Block.field_71939_E.field_71990_ca;
         this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
      }

   }

   public WorldGenerator func_76740_a(Random var1) {
      return (WorldGenerator)(this.biomeid == 80?(var1.nextInt(3) == 0?new BWG4oldGenBigTree(2):new BWG4oldGenTrees(2)):(this.biomeid == 83?(var1.nextInt(5) == 0?this.field_76764_P:(var1.nextInt(3) == 0?new BWG4oldGenBigTree(2):new BWG4oldGenTrees(2))):(this.biomeid == 86?(var1.nextInt(3) == 0?new WorldGenTaiga1():new WorldGenTaiga2(false)):(this.biomeid == 90?(var1.nextInt(10) == 0?new BWG4oldGenBigTree(2):(var1.nextInt(3) == 0?new WorldGenShrub(3, 0):(var1.nextInt(2) == 0?(var1.nextInt(40) == 0?new WorldGenHugeTrees(false, 60 + var1.nextInt(5), 3, 3):new WorldGenHugeTrees(false, 20 + var1.nextInt(15), 3, 3)):new WorldGenTrees(false, 4 + var1.nextInt(7), 3, 3, true)))):(var1.nextInt(10) == 0?new BWG4oldGenBigTree(2):new BWG4oldGenTrees(2))))));
   }

   public int func_76737_k() {
      if(this.biomeid != 86 && this.biomeid != 89) {
         if(this.biomeid == 87) {
            return ColorizerFoliage.func_77470_a(0.800000011920929D, 0.20000000298023224D);
         } else {
            double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
            return ColorizerGrass.func_77480_a(var1, var3);
         }
      } else {
         return ColorizerGrass.func_77480_a(0.6000000238418579D, 0.6000000238418579D);
      }
   }

   public int func_76726_l() {
      if(this.biomeid != 86 && this.biomeid != 89) {
         if(this.biomeid == 87) {
            return ColorizerFoliage.func_77470_a(0.800000011920929D, 0.20000000298023224D);
         } else {
            double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
            return ColorizerFoliage.func_77470_a(var1, var3);
         }
      } else {
         return ColorizerFoliage.func_77470_a(0.6000000238418579D, 0.6000000238418579D);
      }
   }
}
