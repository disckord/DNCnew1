package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4decoBigTree;
import net.minecraft.src.BWG4decoDefault;
import net.minecraft.src.BWG4decoGold1;
import net.minecraft.src.BWG4decoGold4;
import net.minecraft.src.BWG4decoSurvival;
import net.minecraft.src.BWG4decoSwampTrees;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityMooshroom;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenHugeTrees;
import net.minecraft.src.WorldGenShrub;
import net.minecraft.src.WorldGenTaiga1;
import net.minecraft.src.WorldGenTaiga2;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;

public class BWG4BiomesDefault extends BiomeGenBase {

   private int biomeid;
   private int type;
   private int id;


   public BWG4BiomesDefault(int var1, int var2, int var3) {
      super(var1);
      this.biomeid = var1;
      this.type = var2;
      this.id = var3;
      this.field_76760_I.usebwg4deco = true;
      if(this.type == 1) {
         if(this.id == 1) {
            this.field_76762_K.clear();
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.grass = 4;
            this.field_76760_I.tl1amount = 1;
         }

         if(this.id == 2) {
            this.field_76760_I.mayrandtrees = false;
            this.field_76760_I.grass = 8;
            this.field_76760_I.redflowers = 4;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.sugarcane = 20;
            this.field_76760_I.melon = 8;
            this.field_76760_I.tl1amount = 5;
            this.field_76760_I.cactus = 1;
            this.field_76760_I.usetl2 = true;
            this.field_76760_I.tl2miny = 0;
            this.field_76760_I.tl2maxy = 75;
            this.field_76760_I.tl2amount = 4;
         }

         if(this.id == 3) {
            this.field_76760_I.mayrandtrees = false;
            this.field_76760_I.redflowers = 4;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.waterlily = 5;
            this.field_76760_I.sugarcane = 20;
            this.field_76760_I.grass = 8;
            this.field_76760_I.melon = 8;
            this.field_76761_J.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
            this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
            this.field_76760_I.tl1amount = 15;
         }

         if(this.id == 4) {
            this.field_76760_I.bigMushrooms = 1;
            this.field_76760_I.brownmush = 1;
            this.field_76760_I.redmush = 1;
            this.field_76760_I.tl1amount = -20;
            this.field_76760_I.redflowers = -20;
            this.field_76760_I.yellowflowers = -20;
            this.field_76752_A = (byte)Block.field_71994_by.field_71990_ca;
            this.field_76761_J.clear();
            this.field_76762_K.clear();
            this.field_76755_L.clear();
            this.field_76762_K.add(new SpawnListEntry(EntityMooshroom.class, 8, 4, 8));
         }

         if(this.id == 5) {
            this.field_76762_K.clear();
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.grass = 4;
            this.field_76760_I.tl1amount = 1;
            this.field_76752_A = (byte)Block.field_71939_E.field_71990_ca;
            this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
         }

         if(this.id == 6) {
            this.field_76762_K.clear();
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.grass = 4;
            this.field_76760_I.tl1amount = 1;
            this.field_76752_A = (byte)Block.field_71939_E.field_71990_ca;
            this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
         }
      } else if(this.type == 2) {
         if(this.id == 1) {
            this.field_76760_I.mayrandtrees = false;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.redflowers = 3;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.grass = 6;
            this.field_76760_I.brownmush = 1;
            this.field_76760_I.redmush = 1;
            this.field_76760_I.tl1amount = 12;
         }

         if(this.id == 2) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.grass = 3;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.tl1amount = 3;
         }

         if(this.id == 3) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.tl1amount = 5;
            this.field_76760_I.grass = 6;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 1;
            this.field_76760_I.brownmush = 1;
         }

         if(this.id == 4) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76760_I.tl1amount = -20;
            this.field_76760_I.grass = -10;
            this.field_76760_I.redflowers = -10;
            this.field_76760_I.yellowflowers = -10;
         }

         if(this.id == 5) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76760_I.tl1amount = -20;
            this.field_76760_I.grass = -10;
            this.field_76760_I.redflowers = -10;
            this.field_76760_I.yellowflowers = -10;
         }
      } else if(this.type == 3) {
         if(this.id == 1) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76760_I.grass = 8;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.tl1amount = 0;
            this.field_76760_I.tl1chance = 4;
         }

         if(this.id == 2) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.grass = 3;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.tl1amount = 3;
         }

         if(this.id == 3) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.grass = 3;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.tl1amount = 2;
         }

         if(this.id == 4) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.grass = 3;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.tl1amount = 3;
         }

         if(this.id == 5) {
            this.field_76760_I.mayrandtrees = false;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.redflowers = 3;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.grass = 6;
            this.field_76760_I.brownmush = 1;
            this.field_76760_I.redmush = 1;
            this.field_76760_I.tl1amount = 12;
         }

         if(this.id == 6) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.emeralds = true;
            this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
            this.field_76760_I.tl1amount = 4;
            this.field_76760_I.grass = 6;
            this.field_76760_I.redflowers = 2;
            this.field_76760_I.yellowflowers = 1;
            this.field_76760_I.brownmush = 1;
         }

         if(this.id == 7) {
            this.field_76760_I.emeralds = true;
            this.field_76760_I.tl1amount = -20;
            this.field_76760_I.grass = 10;
            this.field_76760_I.redflowers = 1;
            this.field_76760_I.yellowflowers = 1;
         }
      } else if(this.type == 4) {
         if(this.id == 1) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.redflowers = 4;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.sugarcane = 20;
            this.field_76760_I.grass = 8;
            this.field_76760_I.melon = 8;
            this.field_76760_I.tl1amount = 5;
            this.field_76761_J.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
            this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
         }

         if(this.id == 2 || this.id == 4) {
            this.field_76760_I.mayrandtrees = false;
            this.field_76760_I.redflowers = 4;
            this.field_76760_I.yellowflowers = 2;
            this.field_76760_I.sugarcane = 20;
            this.field_76760_I.grass = 8;
            this.field_76760_I.melon = 8;
            this.field_76761_J.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
            this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
            this.field_76760_I.tl1amount = 17;
            if(this.id != 4) {
               this.field_76760_I.waterlily = 4;
               this.field_76759_H = 10083127;
            }
         }

         if(this.id == 3 || this.id == 5) {
            this.field_76760_I.mayrandtrees = true;
            this.field_76760_I.tl1amount = 5;
            this.field_76760_I.redflowers = 0;
            this.field_76760_I.yellowflowers = 0;
            this.field_76760_I.grass = 6;
            this.field_76760_I.sugarcane = 40;
            this.field_76760_I.brownmush = 4;
            this.field_76760_I.redmush = 3;
            this.field_76760_I.deadBush = 1;
            this.field_76761_J.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));
            if(this.id != 5) {
               this.field_76760_I.waterlily = 4;
               this.field_76759_H = 10083127;
            }
         }
      } else if(this.type == 5) {
         if(this.id == 1) {
            this.field_76752_A = 0;
            this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
            this.field_76760_I.deadBush = 2;
            this.field_76760_I.cactus = 10;
            this.field_76762_K.clear();
         }

         if(this.id == 2) {
            this.field_76760_I.grass = 12;
            this.field_76760_I.tl1amount = 1;
            this.field_76760_I.tl1chance = 4;
         }

         if(this.id == 3) {
            this.field_76760_I.grass = 6;
            this.field_76760_I.tl1amount = 5;
         }

         if(this.id == 4) {
            this.field_76760_I.grass = 3;
            this.field_76760_I.tl1amount = 6;
            this.field_76760_I.tl1maxy = 80;
         }

         if(this.id == 5) {
            this.field_76762_K.clear();
         }
      } else if(this.type == 6) {
         if(this.id == 1) {
            this.field_76762_K.clear();
         }

         if(this.id == 2) {
            this.field_76762_K.clear();
         }

         if(this.id == 3) {
            this.field_76762_K.clear();
            this.field_76760_I.waterlily = 2;
            this.field_76759_H = 10083127;
            this.field_76760_I.tl1amount = -10;
         }

         if(this.id == 4) {
            this.field_76762_K.clear();
            this.field_76752_A = 0;
            this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
            this.field_76760_I.deadBush = 2;
            this.field_76760_I.cactus = 10;
         }
      }

   }

   public WorldGenerator func_76740_a(Random var1) {
      if(this.type == 1) {
         if(this.id == 1) {
            if(var1.nextInt(7) == 0) {
               return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
            }

            if(var1.nextInt(8) == 0) {
               return this.field_76764_P;
            }

            return this.field_76757_N;
         }

         if(this.id == 2) {
            if(var1.nextInt(10) == 0) {
               return new WorldGenShrub(3, 0);
            }

            if(var1.nextInt(12) == 0) {
               return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
            }

            if(var1.nextInt(5) == 0) {
               return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
            }

            return this.field_76757_N;
         }

         if(this.id == 3) {
            if(var1.nextInt(8) == 0) {
               return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
            }

            if(var1.nextInt(4) == 0) {
               return new WorldGenShrub(3, 0);
            }

            if(var1.nextInt(3) == 0) {
               return new WorldGenHugeTrees(false, 20 + var1.nextInt(5), 3, 3);
            }

            return this.field_76757_N;
         }

         if(this.id == 5) {
            if(var1.nextInt(7) == 0) {
               return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
            }

            if(var1.nextInt(8) == 0) {
               return this.field_76764_P;
            }

            return this.field_76757_N;
         }

         if(this.id == 6) {
            if(var1.nextInt(7) == 0) {
               return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
            }

            if(var1.nextInt(8) == 0) {
               return this.field_76764_P;
            }

            return this.field_76757_N;
         }
      } else if(this.type == 2) {
         if(this.id == 1) {
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

         if(this.id == 2) {
            if(var1.nextInt(7) == 0) {
               return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
            }

            if(var1.nextInt(8) == 0) {
               return this.field_76764_P;
            }

            return this.field_76757_N;
         }

         if(this.id == 3) {
            return (WorldGenerator)(var1.nextInt(3) == 0?new WorldGenTaiga1():new WorldGenTaiga2(false));
         }
      } else if(this.type == 3) {
         if(this.id == 1) {
            return new BWG4decoBigTree(4 + var1.nextInt(11), 0);
         }

         if(this.id == 2 || this.id == 3 || this.id == 4) {
            if(var1.nextInt(7) == 0) {
               return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
            }

            if(var1.nextInt(8) == 0) {
               return this.field_76764_P;
            }

            return this.field_76757_N;
         }

         if(this.id == 5) {
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

         if(this.id == 6) {
            return (WorldGenerator)(var1.nextInt(3) == 0?new WorldGenTaiga1():new WorldGenTaiga2(false));
         }

         if(this.id == 7) {
            ;
         }
      } else if(this.type == 4) {
         if(this.id == 1) {
            if(var1.nextInt(4) == 0) {
               return new BWG4decoBigTree(4 + var1.nextInt(11), 0);
            }

            return this.field_76757_N;
         }

         if(this.id == 2 || this.id == 4) {
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

         if(this.id == 3 || this.id == 5) {
            if(this.id == 5) {
               if(var1.nextInt(7) == 0) {
                  return new BWG4decoBigTree(4 + var1.nextInt(11), 0);
               }

               if(var1.nextInt(6) == 0) {
                  return new WorldGenShrub(3, 0);
               }

               if(var1.nextInt(6) == 0) {
                  return this.field_76757_N;
               }
            }

            return new BWG4decoSwampTrees(var1.nextInt(6) + 5);
         }
      } else if(this.type == 5) {
         if(this.id == 2) {
            return new BWG4decoGold4(2);
         }

         if(this.id == 3) {
            if(var1.nextInt(7) == 0) {
               return new WorldGenShrub(3, 0);
            }

            return new BWG4decoGold4(2);
         }

         if(this.id == 4) {
            return new WorldGenShrub(3, 0);
         }
      }

      return new WorldGenShrub(3, 0);
   }

   public WorldGenerator getRandomWorldGenForTrees2(Random var1) {
      return new BWG4decoSurvival(4);
   }

   public void func_76728_a(World var1, Random var2, int var3, int var4) {
      super.func_76728_a(var1, var2, var3, var4);
      int var5;
      int var6;
      int var7;
      if(this.type == 1 && this.id == 6) {
         for(var5 = 0; var5 < 10; ++var5) {
            var6 = var3 + var2.nextInt(16) + 8;
            var7 = var4 + var2.nextInt(16) + 8;
            (new BWG4decoDefault(1)).func_76484_a(var1, var2, var6, var1.func_72976_f(var6, var7), var7);
         }
      }

      if(this.type == 5 && this.id == 4) {
         for(var5 = 0; var5 < 8; ++var5) {
            var6 = var3 + var2.nextInt(16) + 8;
            var7 = var4 + var2.nextInt(16) + 8;
            (new BWG4decoGold4(1)).func_76484_a(var1, var2, var6, var1.func_72976_f(var6, var7), var7);
         }
      }

   }

   public WorldGenerator func_76730_b(Random var1) {
      return this.type == 4 && this.id == 1?(var1.nextInt(4) == 0?new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 2):new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1)):new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
   }

   public int func_76737_k() {
      if(this.type == 2) {
         return ColorizerGrass.func_77480_a(0.6000000238418579D, 0.6000000238418579D);
      } else {
         double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
         double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
         return ColorizerGrass.func_77480_a(var1, var3);
      }
   }

   public int func_76726_l() {
      if(this.type == 2) {
         return ColorizerFoliage.func_77470_a(0.6000000238418579D, 0.6000000238418579D);
      } else {
         double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
         double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
         return ColorizerFoliage.func_77470_a(var1, var3);
      }
   }
}
