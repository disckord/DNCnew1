package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.SpawnListEntry;

public class BWG4BiomesInfdev extends BiomeGenBase {

   public BWG4BiomesInfdev(int var1) {
      super(var1);
      this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 1, 2, 3));
   }

   public int func_76737_k() {
      return 11272039;
   }

   public int func_76726_l() {
      return 5242667;
   }

   public int func_76731_a(float var1) {
      return 9420543;
   }
}
