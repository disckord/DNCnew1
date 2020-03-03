package net.minecraft.src;

import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4decoSurvival;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Chunk;
import net.minecraft.src.ChunkPosition;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.IProgressUpdate;
import net.minecraft.src.World;

public class BWG4ChunkProviderSkyBlock implements IChunkProvider {

   private Random endRNG;
   private World endWorld;
   private double[] densities;
   private BiomeGenBase[] biomesForGeneration;
   int[][] field_73203_h = new int[32][32];
   int getSize = 1;
   private boolean isNether = false;
   private boolean themeClassic = false;
   private boolean themeExtended = false;
   private boolean themeEndless = false;


   public BWG4ChunkProviderSkyBlock(World var1, long var2, boolean var4, int var5) {
      this.endWorld = var1;
      this.endRNG = new Random(var2);
      this.isNether = var4;
      if(var5 == 1) {
         this.themeClassic = true;
      } else if(var5 == 2) {
         this.themeExtended = true;
      } else if(var5 == 3) {
         this.themeEndless = true;
      } else {
         this.themeClassic = true;
      }

   }

   public Chunk func_73158_c(int var1, int var2) {
      return this.func_73154_d(var1, var2);
   }

   public Chunk func_73154_d(int var1, int var2) {
      this.endRNG.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
      byte[] var3 = new byte['\u8000'];
      Chunk var4 = new Chunk(this.endWorld, var3, var1, var2);
      byte[] var5 = var4.func_76605_m();
      this.biomesForGeneration = this.endWorld.func_72959_q().func_76933_b(this.biomesForGeneration, var1 * 16, var2 * 16, 16, 16);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         var5[var6] = (byte)this.biomesForGeneration[var6].field_76756_M;
      }

      var4.func_76603_b();
      return var4;
   }

   public boolean func_73149_a(int var1, int var2) {
      return true;
   }

   public void func_73153_a(IChunkProvider var1, int var2, int var3) {
      int var4 = var2 * 16;
      int var5 = var3 * 16;
      BiomeGenBase var6 = this.endWorld.func_72807_a(var4 + 16, var5 + 16);
      var6.func_76728_a(this.endWorld, this.endWorld.field_73012_v, var4, var5);
      if(this.themeEndless) {
         if(var2 == 0 && var3 == 0) {
            (new BWG4decoSurvival(6)).func_76484_a(this.endWorld, this.endRNG, 0, 70, 0);
         } else {
            if(this.endRNG.nextInt(8) == 0) {
               (new BWG4decoSurvival(20 + this.endRNG.nextInt(2))).func_76484_a(this.endWorld, this.endRNG, var4 + this.endRNG.nextInt(16), 5 + this.endRNG.nextInt(240), var5 + this.endRNG.nextInt(16));
            }

            if(this.endRNG.nextInt(15) == 0) {
               (new BWG4decoSurvival(20 + this.endRNG.nextInt(4))).func_76484_a(this.endWorld, this.endRNG, var4 + this.endRNG.nextInt(16), 5 + this.endRNG.nextInt(60), var5 + this.endRNG.nextInt(16));
            }

            if(this.endRNG.nextInt(30) == 0) {
               (new BWG4decoSurvival(24 + this.endRNG.nextInt(3))).func_76484_a(this.endWorld, this.endRNG, var4 + this.endRNG.nextInt(16), 5 + this.endRNG.nextInt(40), var5 + this.endRNG.nextInt(16));
            }
         }
      } else if(var2 == 0 && var3 == 0) {
         if(this.isNether) {
            if(this.themeClassic) {
               (new BWG4decoSurvival(8)).func_76484_a(this.endWorld, this.endRNG, 10, 80, 0);
            }

            if(this.themeExtended) {
               (new BWG4decoSurvival(8)).func_76484_a(this.endWorld, this.endRNG, 10, 80, 0);
               (new BWG4decoSurvival(12)).func_76484_a(this.endWorld, this.endRNG, 30, 80, 20);
            }
         } else {
            if(this.themeClassic) {
               (new BWG4decoSurvival(6)).func_76484_a(this.endWorld, this.endRNG, 0, 70, 0);
               (new BWG4decoSurvival(7)).func_76484_a(this.endWorld, this.endRNG, 0, 80, 60);
            }

            if(this.themeExtended) {
               (new BWG4decoSurvival(6)).func_76484_a(this.endWorld, this.endRNG, 0, 70, 0);
               (new BWG4decoSurvival(7)).func_76484_a(this.endWorld, this.endRNG, 0, 80, 60);
               (new BWG4decoSurvival(9)).func_76484_a(this.endWorld, this.endRNG, 0, 78, -80);
               (new BWG4decoSurvival(10)).func_76484_a(this.endWorld, this.endRNG, 80, 78, 0);
               (new BWG4decoSurvival(11)).func_76484_a(this.endWorld, this.endRNG, -80, 78, 0);
            }
         }
      }

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

   public void func_104112_b() {}

   public void func_82695_e(int var1, int var2) {}
}
