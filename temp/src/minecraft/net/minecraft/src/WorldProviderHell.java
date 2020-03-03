package net.minecraft.src;

import net.minecraft.src.BWG4ChunkProviderSky;
import net.minecraft.src.BWG4ChunkProviderSkyBlock;
import net.minecraft.src.BWG4ChunkProviderSurvivalNether;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkProviderHell;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.Vec3;
import net.minecraft.src.WorldChunkManagerHell;
import net.minecraft.src.WorldProvider;
import net.minecraft.src.WorldType;

public class WorldProviderHell extends WorldProvider {

   public void func_76572_b() {
      if(this.field_76579_a.func_72912_H().func_76067_t() != WorldType.BWG4ISLAND && this.field_76579_a.func_72912_H().func_76067_t() != WorldType.BWG4SKYLAND) {
         if(this.field_76579_a.func_72912_H().func_76067_t() != WorldType.BWG4SKY1 && this.field_76579_a.func_72912_H().func_76067_t() != WorldType.BWG4SKY2) {
            this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.field_76778_j, 1.0F, 0.0F);
         } else {
            this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.SURVIVALnether, 1.0F, 0.0F);
         }
      } else {
         this.field_76578_c = new WorldChunkManagerHell(BiomeGenBase.SURVIVALnether, 1.0F, 0.0F);
      }

      this.field_76575_d = true;
      this.field_76576_e = true;
      this.field_76574_g = -1;
   }

   public Vec3 func_76562_b(float p_76562_1_, float p_76562_2_) {
      return this.field_76579_a.func_82732_R().func_72345_a(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
   }

   protected void func_76556_a() {
      float var1 = 0.1F;

      for(int var2 = 0; var2 <= 15; ++var2) {
         float var3 = 1.0F - (float)var2 / 15.0F;
         this.field_76573_f[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
      }

   }

   public IChunkProvider func_76555_c() {
      byte var1 = 1;
      String var2 = "";
      String var3 = "1";
      String var4 = "2";
      String var5 = "3";
      String var6 = "4";
      String var7 = "5";
      String var8 = this.field_76579_a.func_72912_H().func_82571_y();
      if(var8.equals(var2)) {
         var1 = 1;
      }

      if(var8.equals(var3)) {
         var1 = 1;
      }

      if(var8.equals(var4)) {
         var1 = 2;
      }

      if(var8.equals(var5)) {
         var1 = 3;
      }

      if(var8.equals(var6)) {
         var1 = 4;
      }

      if(var8.equals(var7)) {
         var1 = 5;
      }

      return (IChunkProvider)(this.field_76577_b != WorldType.BWG4ISLAND && this.field_76577_b != WorldType.BWG4SKYLAND?(this.field_76577_b != WorldType.BWG4SKY1 && this.field_76577_b != WorldType.BWG4SKY2?(this.field_76577_b == WorldType.BWG4SKYBLOCK?new BWG4ChunkProviderSkyBlock(this.field_76579_a, this.field_76579_a.func_72905_C(), true, var1):new ChunkProviderHell(this.field_76579_a, this.field_76579_a.func_72905_C())):new BWG4ChunkProviderSky(this.field_76579_a, this.field_76579_a.func_72905_C(), this.field_76579_a.func_72912_H().func_76089_r(), 4)):new BWG4ChunkProviderSurvivalNether(this.field_76579_a, this.field_76579_a.func_72905_C()));
   }

   public boolean func_76569_d() {
      return false;
   }

   public boolean func_76566_a(int p_76566_1_, int p_76566_2_) {
      return false;
   }

   public float func_76563_a(long p_76563_1_, float p_76563_3_) {
      return 0.5F;
   }

   public boolean func_76567_e() {
      return false;
   }

   public boolean func_76568_b(int p_76568_1_, int p_76568_2_) {
      return true;
   }

   public String func_80007_l() {
      return "Nether";
   }
}
