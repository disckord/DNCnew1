package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.ChunkProviderFlat;
import net.minecraft.src.ChunkProviderGenerate;
import net.minecraft.src.IChunkProvider;
import net.minecraft.src.World;
import net.minecraft.src.WorldChunkManager;
import net.minecraft.src.WorldChunkManagerHell;

public class WorldType {

   public static final WorldType[] field_77139_a = new WorldType[32];
   public static final WorldType field_77137_b = (new WorldType(0, "default", 1)).func_77129_f();
   public static final WorldType field_77138_c = new WorldType(1, "flat");
   public static final WorldType field_77135_d = new WorldType(2, "largeBiomes");
   public static final WorldType field_77136_e = (new WorldType(8, "default_1_1", 0)).func_77124_a(false);
   public static final WorldType BWG4DEFAULT = (new WorldType(10, "BetterDefault")).func_77124_a(false);
   public static final WorldType BWG4LARGE = (new WorldType(11, "LargeDefault")).func_77124_a(false);
   public static final WorldType BWG4BETA1 = new WorldType(12, "Beta");
   public static final WorldType BWG4BETA2 = (new WorldType(13, "BetaDefault")).func_77124_a(false);
   public static final WorldType BWG4ALPHA = new WorldType(14, "Alpha");
   public static final WorldType BWG4INFDEV = new WorldType(15, "Infdev");
   public static final WorldType BWG4INDEV1 = new WorldType(16, "Indev");
   public static final WorldType BWG4INDEV2 = (new WorldType(17, "Indev_floating")).func_77124_a(false);
   public static final WorldType BWG4ISLAND = new WorldType(21, "Survival Island");
   public static final WorldType BWG4SKYLAND = new WorldType(22, "Survival Skyland");
   public static final WorldType BWG4SKYBLOCK = new WorldType(23, "Skyblock");
   public static final WorldType BWG4SKY1 = new WorldType(25, "Sky Dimension");
   public static final WorldType BWG4SKY2 = (new WorldType(26, "SkyDimensionBeta")).func_77124_a(false);
   public static final WorldType BWG4CAVE = (new WorldType(27, "Cave Dimension")).func_77124_a(false);
   public static final WorldType BWG4HARD = (new WorldType(28, "Hardcore")).func_77124_a(false);
   public static final WorldType BWG4WASTE = (new WorldType(29, "WasteLand")).func_77124_a(false);
   private final int field_82748_f;
   private final String field_77133_f;
   private final int field_77134_g;
   private boolean field_77140_h;
   private boolean field_77141_i;


   public WorldType(int p_i3737_1_, String p_i3737_2_) {
      this(p_i3737_1_, p_i3737_2_, 0);
   }

   public WorldType(int p_i3738_1_, String p_i3738_2_, int p_i3738_3_) {
      this.field_77133_f = p_i3738_2_;
      this.field_77134_g = p_i3738_3_;
      this.field_77140_h = true;
      this.field_82748_f = p_i3738_1_;
      field_77139_a[p_i3738_1_] = this;
   }

   public String func_77127_a() {
      return this.field_77133_f;
   }

   public String func_77128_b() {
      return this.field_77133_f != "default" && this.field_77133_f != "flat" && this.field_77133_f != "largeBiomes" && this.field_77133_f != "default_1_1"?this.field_77133_f:"generator." + this.field_77133_f;
   }

   public int func_77131_c() {
      return this.field_77134_g;
   }

   public WorldType func_77132_a(int p_77132_1_) {
      return this == field_77137_b && p_77132_1_ == 0?field_77136_e:this;
   }

   private WorldType func_77124_a(boolean p_77124_1_) {
      this.field_77140_h = p_77124_1_;
      return this;
   }

   public boolean func_77126_d() {
      return this.field_77140_h;
   }

   private WorldType func_77129_f() {
      this.field_77141_i = true;
      return this;
   }

   public boolean func_77125_e() {
      return this.field_77141_i;
   }

   public static WorldType func_77130_a(String p_77130_0_) {
      for(int var1 = 0; var1 < field_77139_a.length; ++var1) {
         if(field_77139_a[var1] != null && field_77139_a[var1].field_77133_f.equalsIgnoreCase(p_77130_0_)) {
            return field_77139_a[var1];
         }
      }

      return null;
   }

   public int func_82747_f() {
      return this.field_82748_f;
   }

   public WorldChunkManager getChunkManager(World var1) {
      return (WorldChunkManager)(this == field_77138_c?new WorldChunkManagerHell(BiomeGenBase.field_76772_c, 0.5F, 0.5F):new WorldChunkManager(var1));
   }

   public IChunkProvider getChunkGenerator(World var1) {
      return (IChunkProvider)(this == field_77138_c?new ChunkProviderFlat(var1, var1.func_72905_C(), var1.func_72912_H().func_76089_r(), var1.func_72912_H().func_82571_y()):new ChunkProviderGenerate(var1, var1.func_72905_C(), var1.func_72912_H().func_76089_r()));
   }

   public IChunkProvider getChunkGenerator(World var1, String var2) {
      return (IChunkProvider)(this == field_77138_c?new ChunkProviderFlat(var1, var1.func_72905_C(), var1.func_72912_H().func_76089_r(), var1.func_72912_H().func_82571_y()):new ChunkProviderGenerate(var1, var1.func_72905_C(), var1.func_72912_H().func_76089_r()));
   }

   public int getSeaLevel(World var1) {
      return this != field_77138_c?64:4;
   }

   public boolean hasVoidParticles(boolean var1) {
      return this != field_77138_c && !var1;
   }

   public double voidFadeMagnitude() {
      return this != field_77138_c?0.03125D:1.0D;
   }

}
