package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.SpawnListEntry;

public class BWG4BiomesIndev extends BiomeGenBase {

   private int indevID;


   public BWG4BiomesIndev(int var1) {
      super(var1);
      this.indevID = var1 - 101;
      this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 1, 2, 3));
   }

   public int func_76737_k() {
      return 11272039;
   }

   public int func_76726_l() {
      return 5242667;
   }

   public int func_76731_a(float var1) {
      return this.indevID == 2?2164736:(this.indevID == 3?13033215:(this.indevID == 4?7699847:10079487));
   }
}
