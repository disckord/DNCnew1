package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4NoiseOctavesBeta;
import net.minecraft.src.BWG4decoPumpkin;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigMushroom;
import net.minecraft.src.WorldGenCactus;
import net.minecraft.src.WorldGenClay;
import net.minecraft.src.WorldGenDeadBush;
import net.minecraft.src.WorldGenFlowers;
import net.minecraft.src.WorldGenLiquids;
import net.minecraft.src.WorldGenMinable;
import net.minecraft.src.WorldGenPumpkin;
import net.minecraft.src.WorldGenReed;
import net.minecraft.src.WorldGenSand;
import net.minecraft.src.WorldGenWaterlily;
import net.minecraft.src.WorldGenerator;

public class BiomeDecorator {

   protected World field_76815_a;
   protected Random field_76813_b;
   protected int field_76814_c;
   protected int field_76811_d;
   protected BiomeGenBase field_76812_e;
   protected boolean usebwg4deco;
   public BWG4NoiseOctavesBeta TreeNoise;
   protected boolean mayrandtrees;
   protected int tl1miny;
   protected int tl1maxy;
   protected int tl1amount;
   protected int tl1chance;
   protected boolean usetl2;
   protected int tl2miny;
   protected int tl2maxy;
   protected int tl2amount;
   protected int tl2chance;
   protected boolean shiftoreheight;
   protected boolean disableoreheight;
   protected boolean emeralds;
   protected boolean silverfish;
   protected WorldGenerator field_76823_i;
   protected WorldGenerator field_76820_j;
   protected WorldGenerator field_76821_k;
   protected WorldGenerator field_76818_l;
   protected WorldGenerator field_76819_m;
   protected WorldGenerator field_76816_n;
   protected WorldGenerator field_76817_o;
   protected WorldGenerator field_76831_p;
   protected WorldGenerator emeraldGen;
   protected WorldGenerator silverfishGen;
   protected int bigMushrooms;
   protected int redflowers;
   protected int yellowflowers;
   protected int grass;
   protected int grassminy;
   protected int grassmaxy;
   protected int deadBush;
   protected int waterlily;
   protected int brownmush;
   protected int redmush;
   protected int sugarcane;
   protected int cactus;
   protected int melon;
   protected int pumpkin;
   protected int waterliquid;
   protected int lavaliquid;
   protected WorldGenerator field_76809_f = new WorldGenClay(4);
   protected WorldGenerator field_76810_g;
   protected WorldGenerator field_76822_h;
   protected WorldGenerator field_76830_q;
   protected WorldGenerator field_76829_r;
   protected WorldGenerator field_76828_s;
   protected WorldGenerator field_76827_t;
   protected WorldGenerator field_76826_u;
   protected WorldGenerator field_76825_v;
   protected WorldGenerator field_76824_w;
   protected WorldGenerator field_76834_x;
   protected int field_76833_y;
   protected int field_76832_z;
   protected int field_76802_A;
   protected int field_76803_B;
   protected int field_76804_C;
   protected int field_76798_D;
   protected int field_76799_E;
   protected int field_76800_F;
   protected int field_76801_G;
   protected int field_76805_H;
   protected int field_76806_I;
   protected int field_76807_J;
   public boolean field_76808_K;


   public BiomeDecorator(BiomeGenBase p_i3750_1_) {
      this.field_76812_e = p_i3750_1_;
      this.usebwg4deco = false;
      this.mayrandtrees = true;
      this.tl1miny = 0;
      this.tl1maxy = 128;
      this.tl1amount = 2;
      this.tl1chance = 1;
      this.usetl2 = false;
      this.tl2miny = 0;
      this.tl2maxy = 128;
      this.tl2amount = 0;
      this.tl2chance = 1;
      this.shiftoreheight = false;
      this.disableoreheight = false;
      this.emeralds = false;
      this.silverfish = false;
      this.field_76823_i = new WorldGenMinable(Block.field_71979_v.field_71990_ca, 32);
      this.field_76820_j = new WorldGenMinable(Block.field_71940_F.field_71990_ca, 32);
      this.field_76821_k = new WorldGenMinable(Block.field_71950_I.field_71990_ca, 16);
      this.field_76818_l = new WorldGenMinable(Block.field_71949_H.field_71990_ca, 8);
      this.field_76819_m = new WorldGenMinable(Block.field_71941_G.field_71990_ca, 8);
      this.field_76816_n = new WorldGenMinable(Block.field_72047_aN.field_71990_ca, 7);
      this.field_76817_o = new WorldGenMinable(Block.field_72073_aw.field_71990_ca, 7);
      this.field_76831_p = new WorldGenMinable(Block.field_71947_N.field_71990_ca, 6);
      this.emeraldGen = new WorldGenMinable(Block.field_72068_bR.field_71990_ca, 1);
      this.silverfishGen = new WorldGenMinable(Block.field_72006_bl.field_71990_ca, 1);
      this.bigMushrooms = 0;
      this.redflowers = 1;
      this.yellowflowers = 1;
      this.grass = 1;
      this.grassminy = 0;
      this.grassmaxy = 128;
      this.deadBush = 0;
      this.waterlily = 0;
      this.brownmush = 0;
      this.redmush = 0;
      this.sugarcane = 10;
      this.cactus = 0;
      this.melon = 32;
      this.pumpkin = 32;
      this.waterliquid = 50;
      this.lavaliquid = 20;
      this.field_76810_g = new WorldGenSand(7, Block.field_71939_E.field_71990_ca);
      this.field_76822_h = new WorldGenSand(6, Block.field_71940_F.field_71990_ca);
      this.field_76830_q = new WorldGenFlowers(Block.field_72097_ad.field_71990_ca);
      this.field_76829_r = new WorldGenFlowers(Block.field_72107_ae.field_71990_ca);
      this.field_76828_s = new WorldGenFlowers(Block.field_72109_af.field_71990_ca);
      this.field_76827_t = new WorldGenFlowers(Block.field_72103_ag.field_71990_ca);
      this.field_76826_u = new WorldGenBigMushroom();
      this.field_76825_v = new WorldGenReed();
      this.field_76824_w = new WorldGenCactus();
      this.field_76834_x = new WorldGenWaterlily();
      this.field_76833_y = 0;
      this.field_76832_z = 0;
      this.field_76802_A = 2;
      this.field_76803_B = 1;
      this.field_76804_C = 0;
      this.field_76798_D = 0;
      this.field_76799_E = 0;
      this.field_76800_F = 0;
      this.field_76801_G = 1;
      this.field_76805_H = 3;
      this.field_76806_I = 1;
      this.field_76807_J = 0;
      this.field_76808_K = true;
   }

   public void func_76796_a(World p_76796_1_, Random p_76796_2_, int p_76796_3_, int p_76796_4_) {
      if(this.field_76815_a != null) {
         throw new RuntimeException("Already decorating!!");
      } else {
         this.field_76815_a = p_76796_1_;
         this.TreeNoise = new BWG4NoiseOctavesBeta(p_76796_2_, 8);
         this.field_76813_b = p_76796_2_;
         this.field_76814_c = p_76796_3_;
         this.field_76811_d = p_76796_4_;
         this.func_76794_a();
         this.field_76815_a = null;
         this.field_76813_b = null;
      }
   }

   protected void func_76794_a() {
      int var3;
      int var4;
      int var5;
      if(this.usebwg4deco) {
         this.func_76797_b();
         double var1 = 0.5D;
         var3 = (int)((this.TreeNoise.func_806_a((double)this.field_76814_c * var1, (double)this.field_76811_d * var1) / 8.0D + this.field_76813_b.nextDouble() * 4.0D + 4.0D) / 3.0D);
         if(var3 < 0) {
            var3 = 0;
         }

         var3 += this.tl1amount;
         if(!this.mayrandtrees) {
            var3 = this.tl1amount;
         }

         if(this.field_76813_b.nextInt(10) == 0) {
            ++var3;
         }

         int var6;
         for(var4 = 0; var4 < var3; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            if(this.field_76815_a.func_72976_f(var5, var6) < this.tl1maxy && this.field_76815_a.func_72976_f(var5, var6) > this.tl1miny && this.field_76813_b.nextInt(this.tl1chance) == 0) {
               WorldGenerator var7 = this.field_76812_e.func_76740_a(this.field_76813_b);
               var7.func_76487_a(1.0D, 1.0D, 1.0D);
               var7.func_76484_a(this.field_76815_a, this.field_76813_b, var5, this.field_76815_a.func_72976_f(var5, var6), var6);
            }
         }

         WorldGenerator var8;
         int var10;
         if(this.usetl2) {
            var4 = (int)((this.TreeNoise.func_806_a((double)this.field_76814_c * var1, (double)this.field_76811_d * var1) / 8.0D + this.field_76813_b.nextDouble() * 4.0D + 4.0D) / 3.0D);
            if(var4 < 0) {
               var4 = 0;
            }

            var4 += this.tl2amount;
            if(!this.mayrandtrees) {
               var4 = this.tl2amount;
            }

            if(this.field_76813_b.nextInt(10) == 0) {
               ++var4;
            }

            for(var5 = 0; var5 < var4; ++var5) {
               var6 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               if(this.field_76815_a.func_72976_f(var6, var10) < this.tl2maxy && this.field_76815_a.func_72976_f(var6, var10) > this.tl2miny && this.field_76813_b.nextInt(this.tl2chance) == 0) {
                  var8 = this.field_76812_e.getRandomWorldGenForTrees2(this.field_76813_b);
                  var8.func_76487_a(1.0D, 1.0D, 1.0D);
                  var8.func_76484_a(this.field_76815_a, this.field_76813_b, var6, this.field_76815_a.func_72976_f(var6, var10), var10);
               }
            }
         }

         for(var4 = 0; var4 < this.bigMushrooms; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenBigMushroom()).func_76484_a(this.field_76815_a, this.field_76813_b, var5, this.field_76815_a.func_72976_f(var5, var6), var6);
         }

         for(var4 = 0; var4 < this.yellowflowers; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(128);
            var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72097_ad.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var5, var6, var10);
         }

         for(var4 = 0; var4 < this.redflowers; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(128);
            var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenFlowers(Block.field_72107_ae.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var5, var6, var10);
         }

         for(var4 = 0; var4 < this.grass; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(128);
            var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            if(var6 > this.grassminy && var6 < this.grassmaxy) {
               var8 = this.field_76812_e.func_76730_b(this.field_76813_b);
               var8.func_76484_a(this.field_76815_a, this.field_76813_b, var5, var6, var10);
            }
         }

         for(var4 = 0; var4 < this.deadBush; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(128);
            var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.field_71961_Y.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var5, var6, var10);
         }

         for(var4 = 0; var4 < this.waterlily; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;

            for(var10 = this.field_76813_b.nextInt(128); var10 > 0 && this.field_76815_a.func_72798_a(var5, var10 - 1, var6) == 0; --var10) {
               ;
            }

            (new WorldGenWaterlily()).func_76484_a(this.field_76815_a, this.field_76813_b, var5, var10, var6);
         }

         for(var4 = 0; var4 < this.brownmush; ++var4) {
            if(this.field_76813_b.nextInt(4) == 0) {
               var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               var10 = this.field_76815_a.func_72976_f(var5, var6);
               this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, var5, var10, var6);
            }
         }

         for(var4 = 0; var4 < this.redmush; ++var4) {
            if(this.field_76813_b.nextInt(6) == 0) {
               var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               var10 = this.field_76815_a.func_72976_f(var5, var6);
               this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, var5, var10, var6);
            }
         }

         if(this.field_76813_b.nextInt(4) == 0) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76813_b.nextInt(128);
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var5, var6);
         }

         if(this.field_76813_b.nextInt(8) == 0) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76813_b.nextInt(128);
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, var4, var5, var6);
         }

         for(var4 = 0; var4 < this.sugarcane; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            var10 = this.field_76813_b.nextInt(128);
            this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, var5, var10, var6);
         }

         if(this.field_76813_b.nextInt(this.melon) == 0) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76813_b.nextInt(128);
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new BWG4decoPumpkin(1)).func_76484_a(this.field_76815_a, this.field_76813_b, var4, var5, var6);
         }

         if(this.field_76813_b.nextInt(this.pumpkin) == 0) {
            var4 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76813_b.nextInt(128);
            var6 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new BWG4decoPumpkin(0)).func_76484_a(this.field_76815_a, this.field_76813_b, var4, var5, var6);
         }

         for(var4 = 0; var4 < this.cactus; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(128);
            var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76824_w.func_76484_a(this.field_76815_a, this.field_76813_b, var5, var6, var10);
         }

         for(var4 = 0; var4 < this.waterliquid; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(this.field_76813_b.nextInt(120) + 8);
            var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_71942_A.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var5, var6, var10);
         }

         for(var4 = 0; var4 < this.lavaliquid; ++var4) {
            var5 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var6 = this.field_76813_b.nextInt(this.field_76813_b.nextInt(this.field_76813_b.nextInt(112) + 8) + 8);
            var10 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenLiquids(Block.field_71944_C.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var5, var6, var10);
         }
      } else {
         this.func_76797_b();

         int var2;
         int var9;
         for(var9 = 0; var9 < this.field_76805_H; ++var9) {
            var2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var3 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76810_g.func_76484_a(this.field_76815_a, this.field_76813_b, var2, this.field_76815_a.func_72825_h(var2, var3), var3);
         }

         for(var9 = 0; var9 < this.field_76806_I; ++var9) {
            var2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var3 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76809_f.func_76484_a(this.field_76815_a, this.field_76813_b, var2, this.field_76815_a.func_72825_h(var2, var3), var3);
         }

         for(var9 = 0; var9 < this.field_76801_G; ++var9) {
            var2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var3 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76810_g.func_76484_a(this.field_76815_a, this.field_76813_b, var2, this.field_76815_a.func_72825_h(var2, var3), var3);
         }

         var9 = this.field_76832_z;
         if(this.field_76813_b.nextInt(10) == 0) {
            ++var9;
         }

         for(var2 = 0; var2 < var9; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            WorldGenerator var11 = this.field_76812_e.func_76740_a(this.field_76813_b);
            var11.func_76487_a(1.0D, 1.0D, 1.0D);
            var11.func_76484_a(this.field_76815_a, this.field_76813_b, var3, this.field_76815_a.func_72976_f(var3, var4), var4);
         }

         for(var2 = 0; var2 < this.field_76807_J; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76826_u.func_76484_a(this.field_76815_a, this.field_76813_b, var3, this.field_76815_a.func_72976_f(var3, var4), var4);
         }

         for(var2 = 0; var2 < this.field_76802_A; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76813_b.nextInt(128);
            var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76830_q.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
            if(this.field_76813_b.nextInt(4) == 0) {
               var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var4 = this.field_76813_b.nextInt(128);
               var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               this.field_76829_r.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
            }
         }

         for(var2 = 0; var2 < this.field_76803_B; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76813_b.nextInt(128);
            var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            WorldGenerator var12 = this.field_76812_e.func_76730_b(this.field_76813_b);
            var12.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
         }

         for(var2 = 0; var2 < this.field_76804_C; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76813_b.nextInt(128);
            var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenDeadBush(Block.field_71961_Y.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
         }

         for(var2 = 0; var2 < this.field_76833_y; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;

            for(var5 = this.field_76813_b.nextInt(128); var5 > 0 && this.field_76815_a.func_72798_a(var3, var5 - 1, var4) == 0; --var5) {
               ;
            }

            this.field_76834_x.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var5, var4);
         }

         for(var2 = 0; var2 < this.field_76798_D; ++var2) {
            if(this.field_76813_b.nextInt(4) == 0) {
               var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               var5 = this.field_76815_a.func_72976_f(var3, var4);
               this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var5, var4);
            }

            if(this.field_76813_b.nextInt(8) == 0) {
               var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               var5 = this.field_76813_b.nextInt(128);
               this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var5, var4);
            }
         }

         if(this.field_76813_b.nextInt(4) == 0) {
            var2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var3 = this.field_76813_b.nextInt(128);
            var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, var2, var3, var4);
         }

         if(this.field_76813_b.nextInt(8) == 0) {
            var2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var3 = this.field_76813_b.nextInt(128);
            var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, var2, var3, var4);
         }

         for(var2 = 0; var2 < this.field_76799_E; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            var5 = this.field_76813_b.nextInt(128);
            this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var5, var4);
         }

         for(var2 = 0; var2 < 10; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76813_b.nextInt(128);
            var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
         }

         if(this.field_76813_b.nextInt(32) == 0) {
            var2 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var3 = this.field_76813_b.nextInt(128);
            var4 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            (new WorldGenPumpkin()).func_76484_a(this.field_76815_a, this.field_76813_b, var2, var3, var4);
         }

         for(var2 = 0; var2 < this.field_76800_F; ++var2) {
            var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
            var4 = this.field_76813_b.nextInt(128);
            var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
            this.field_76824_w.func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
         }

         if(this.field_76808_K) {
            for(var2 = 0; var2 < 50; ++var2) {
               var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var4 = this.field_76813_b.nextInt(this.field_76813_b.nextInt(120) + 8);
               var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               (new WorldGenLiquids(Block.field_71942_A.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
            }

            for(var2 = 0; var2 < 20; ++var2) {
               var3 = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
               var4 = this.field_76813_b.nextInt(this.field_76813_b.nextInt(this.field_76813_b.nextInt(112) + 8) + 8);
               var5 = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
               (new WorldGenLiquids(Block.field_71944_C.field_71990_ca)).func_76484_a(this.field_76815_a, this.field_76813_b, var3, var4, var5);
            }
         }
      }

   }

   protected void func_76795_a(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_) {
      for(int var5 = 0; var5 < p_76795_1_; ++var5) {
         int var6 = this.field_76814_c + this.field_76813_b.nextInt(16);
         int var7 = this.field_76811_d + this.field_76813_b.nextInt(16);
         int var8;
         if(this.shiftoreheight) {
            if(p_76795_4_ < 17) {
               var8 = this.field_76813_b.nextInt(32) + 16;
            } else if(p_76795_4_ > 111) {
               var8 = this.field_76813_b.nextInt(p_76795_4_ - 16) + 16;
            } else {
               var8 = this.field_76813_b.nextInt(p_76795_4_) + 16;
            }
         } else if(this.disableoreheight) {
            var8 = this.field_76813_b.nextInt(128);
         } else {
            var8 = this.field_76813_b.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
         }

         p_76795_2_.func_76484_a(this.field_76815_a, this.field_76813_b, var6, var8, var7);
      }

   }

   protected void func_76793_b(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_) {
      for(int var5 = 0; var5 < p_76793_1_; ++var5) {
         int var6 = this.field_76814_c + this.field_76813_b.nextInt(16);
         int var7 = this.field_76813_b.nextInt(p_76793_4_) + this.field_76813_b.nextInt(p_76793_4_) + (p_76793_3_ - p_76793_4_);
         int var8 = this.field_76811_d + this.field_76813_b.nextInt(16);
         p_76793_2_.func_76484_a(this.field_76815_a, this.field_76813_b, var6, var7, var8);
      }

   }

   protected void func_76797_b() {
      this.func_76795_a(20, this.field_76823_i, 0, 128);
      this.func_76795_a(10, this.field_76820_j, 0, 128);
      this.func_76795_a(20, this.field_76821_k, 0, 128);
      this.func_76795_a(20, this.field_76818_l, 0, 64);
      this.func_76795_a(2, this.field_76819_m, 0, 32);
      this.func_76795_a(8, this.field_76816_n, 0, 16);
      if(this.emeralds) {
         this.func_76795_a(3 + this.field_76813_b.nextInt(6), this.emeraldGen, 4, 32);
      }

      if(this.silverfish) {
         this.func_76795_a(7, this.silverfishGen, 0, 64);
      }

      if(this.disableoreheight) {
         this.func_76795_a(2, this.field_76817_o, 0, 128);
      } else {
         this.func_76795_a(1, this.field_76817_o, 0, 16);
      }

      this.func_76793_b(1, this.field_76831_p, 16, 16);
   }
}
