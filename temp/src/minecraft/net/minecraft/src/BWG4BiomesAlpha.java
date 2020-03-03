package net.minecraft.src;

import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.EntityOcelot;
import net.minecraft.src.EntityWolf;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;

public class BWG4BiomesAlpha extends BiomeGenBase {

   private int biomeid;


   public BWG4BiomesAlpha(int var1) {
      super(var1);
      this.biomeid = var1;
      if(var1 == 90) {
         this.field_76761_J.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
      }

      if(var1 == 91 || var1 == 92 || var1 == 93 || var1 == 96) {
         this.field_76762_K.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
      }

      if(var1 == 98) {
         this.field_76762_K.clear();
         this.field_76752_A = (byte)Block.field_71939_E.field_71990_ca;
         this.field_76753_B = (byte)Block.field_71939_E.field_71990_ca;
      }

   }

   public int func_76737_k() {
      if(this.biomeid != 96 && this.biomeid != 99) {
         if(this.biomeid == 97) {
            return ColorizerGrass.func_77480_a(1.0D, 0.4000000059604645D);
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
      if(this.biomeid != 96 && this.biomeid != 99) {
         if(this.biomeid == 97) {
            return ColorizerFoliage.func_77470_a(1.0D, 0.4000000059604645D);
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
