package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4decoBigTree;
import net.minecraft.src.BWG4decoGold1;
import net.minecraft.src.BWG4decoSurvival;
import net.minecraft.src.BWG4oldGenTrees;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.EntityBlaze;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenHugeTrees;
import net.minecraft.src.WorldGenShrub;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenVines;
import net.minecraft.src.WorldGenerator;

public class BWG4BiomesSurvival extends BiomeGenBase {

   int biomeID;


   public BWG4BiomesSurvival(int var1) {
      super(var1);
      this.biomeID = var1;
      if(this.biomeID == 107) {
         this.field_76760_I.usebwg4deco = true;
         this.field_76760_I.tl1amount = -20;
      } else if(this.biomeID == 108) {
         this.field_76760_I.usebwg4deco = true;
         this.field_76760_I.tl1amount = -20;
      } else if(this.biomeID == 109) {
         this.field_76760_I.usebwg4deco = true;
         this.field_76760_I.tl1amount = -20;
      } else if(this.biomeID == 110) {
         this.field_76760_I.usebwg4deco = true;
         this.field_76760_I.mayrandtrees = true;
         this.field_76760_I.tl1amount = 4;
         this.field_76760_I.usetl2 = true;
         this.field_76760_I.tl2miny = 0;
         this.field_76760_I.tl2maxy = 75;
         this.field_76760_I.tl2amount = 1;
         this.field_76760_I.redflowers = 3;
         this.field_76760_I.yellowflowers = 3;
         this.field_76760_I.grass = 4;
         this.field_76760_I.deadBush = 1;
         this.field_76760_I.sugarcane = 20;
         this.field_76760_I.cactus = 1;
         this.field_76760_I.melon = 25;
         this.field_76760_I.pumpkin = 25;
         this.field_76760_I.waterliquid = 50;
         this.field_76760_I.lavaliquid = 20;
      } else if(this.biomeID == 113) {
         this.field_76760_I.usebwg4deco = true;
         this.field_76760_I.mayrandtrees = true;
         this.field_76760_I.tl1amount = 4;
         this.field_76760_I.redflowers = 3;
         this.field_76760_I.yellowflowers = 3;
         this.field_76760_I.grass = 4;
         this.field_76760_I.melon = 8;
         this.field_76760_I.pumpkin = 8;
      } else if(this.biomeID == 115) {
         this.field_76760_I.usebwg4deco = true;
         this.field_76760_I.mayrandtrees = true;
         this.field_76760_I.tl1amount = 10;
         this.field_76760_I.yellowflowers = 1;
         this.field_76760_I.redflowers = 2;
         this.field_76760_I.grass = 4;
         this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
      } else if(this.biomeID == 116) {
         this.field_76760_I.usebwg4deco = true;
         this.field_76760_I.mayrandtrees = false;
         this.field_76760_I.redflowers = 4;
         this.field_76760_I.yellowflowers = 2;
         this.field_76760_I.waterlily = 5;
         this.field_76760_I.sugarcane = 20;
         this.field_76760_I.grass = 8;
         this.field_76760_I.melon = 8;
         this.field_76760_I.tl1amount = 14;
         this.field_76759_H = 10083127;
         this.field_76761_J.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
         this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
      } else if(this.biomeID == 119) {
         this.field_76761_J.clear();
         this.field_76762_K.clear();
         this.field_76755_L.clear();
         this.field_82914_M.clear();
         this.field_76761_J.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
         this.field_76761_J.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
         this.field_76761_J.add(new SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
         this.field_76761_J.add(new SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
         this.field_76761_J.add(new SpawnListEntry(EntityBlaze.class, 25, 4, 4));
      } else if(this.biomeID == 120) {
         ;
      }

   }

   public WorldGenerator func_76740_a(Random var1) {
      if(this.biomeID != 107 && this.biomeID != 108 && this.biomeID != 109) {
         if(this.biomeID == 110) {
            if(var1.nextInt(5) == 0) {
               return this.field_76764_P;
            }

            if(var1.nextInt(4) == 0) {
               return new BWG4decoBigTree(var1.nextInt(5) + 9, 0);
            }

            return new BWG4oldGenTrees(2);
         }

         if(this.biomeID == 113) {
            if(var1.nextInt(5) == 0) {
               return this.field_76764_P;
            }

            if(var1.nextInt(4) == 0) {
               return new BWG4decoBigTree(var1.nextInt(5) + 9, 0);
            }

            return new BWG4oldGenTrees(2);
         }

         if(this.biomeID == 115) {
            if(var1.nextInt(5) == 0) {
               return new BWG4decoGold1(3, 6, 16, 3);
            }

            if(var1.nextInt(2) == 0) {
               return new BWG4decoGold1(1, 6, 14, 0);
            }

            if(var1.nextInt(2) == 0) {
               return new BWG4decoGold1(2, 6, 12, 3);
            }

            return this.field_76757_N;
         }

         if(this.biomeID == 116) {
            if(var1.nextInt(8) == 0) {
               return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
            }

            if(var1.nextInt(4) == 0) {
               return new WorldGenShrub(3, 0);
            }

            if(var1.nextInt(3) != 0) {
               return new WorldGenHugeTrees(false, 15 + var1.nextInt(10), 3, 3);
            }

            return new WorldGenTrees(false, 4 + var1.nextInt(7), 3, 3, true);
         }
      }

      return new BWG4oldGenTrees(2);
   }

   public WorldGenerator getRandomWorldGenForTrees2(Random var1) {
      return (WorldGenerator)(this.biomeID == 110?new BWG4decoSurvival(4):new BWG4oldGenTrees(2));
   }

   public void func_76728_a(World var1, Random var2, int var3, int var4) {
      super.func_76728_a(var1, var2, var3, var4);
      if(this.biomeID == 116) {
         WorldGenVines var5 = new WorldGenVines();

         for(int var6 = 0; var6 < 50; ++var6) {
            int var7 = var3 + var2.nextInt(16) + 8;
            byte var8 = 64;
            int var9 = var4 + var2.nextInt(16) + 8;
            var5.func_76484_a(var1, var2, var7, var8, var9);
         }
      }

   }

   public int func_76737_k() {
      if(this.biomeID != 109 && this.biomeID != 115) {
         double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
         double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
         return ColorizerGrass.func_77480_a(var1, var3);
      } else {
         return ColorizerGrass.func_77480_a(0.6000000238418579D, 0.6000000238418579D);
      }
   }

   public int func_76726_l() {
      if(this.biomeID != 109 && this.biomeID != 115) {
         double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
         double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
         return ColorizerFoliage.func_77470_a(var1, var3);
      } else {
         return ColorizerFoliage.func_77470_a(0.6000000238418579D, 0.6000000238418579D);
      }
   }
}
