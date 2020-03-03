package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoPumpkin extends WorldGenerator {

   private int whatblock;


   public BWG4decoPumpkin(int var1) {
      this.whatblock = var1;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      for(int var6 = 0; var6 < 64; ++var6) {
         int var7 = var3 + var2.nextInt(8) - var2.nextInt(8);
         int var8 = var4 + var2.nextInt(4) - var2.nextInt(4);
         int var9 = var5 + var2.nextInt(8) - var2.nextInt(8);
         if(var1.func_72799_c(var7, var8, var9) && var1.func_72798_a(var7, var8 - 1, var9) == Block.field_71980_u.field_71990_ca && Block.field_72061_ba.func_71930_b(var1, var7, var8, var9)) {
            if(this.whatblock == 0) {
               var1.func_72832_d(var7, var8, var9, Block.field_72061_ba.field_71990_ca, var2.nextInt(4), 0);
            } else {
               var1.func_72832_d(var7, var8, var9, Block.field_71997_br.field_71990_ca, 0, 0);
            }
         }
      }

      return true;
   }
}
