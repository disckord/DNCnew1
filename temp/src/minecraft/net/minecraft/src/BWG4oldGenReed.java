package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.Material;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4oldGenReed extends WorldGenerator {

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      for(int var6 = 0; var6 < 20; ++var6) {
         int var7 = var3 + var2.nextInt(4) - var2.nextInt(4);
         int var8 = var4;
         int var9 = var5 + var2.nextInt(4) - var2.nextInt(4);
         if(var1.func_72799_c(var7, var4, var9) && (var1.func_72803_f(var7 - 1, var4 - 1, var9) == Material.field_76244_g || var1.func_72803_f(var7 + 1, var4 - 1, var9) == Material.field_76244_g || var1.func_72803_f(var7, var4 - 1, var9 - 1) == Material.field_76244_g || var1.func_72803_f(var7, var4 - 1, var9 + 1) == Material.field_76244_g)) {
            int var10 = 2 + var2.nextInt(var2.nextInt(3) + 1);

            for(int var11 = 0; var11 < var10; ++var11) {
               if(Block.field_72040_aX.func_71854_d(var1, var7, var8 + var11, var9)) {
                  var1.func_94575_c(var7, var8 + var11, var9, Block.field_72040_aX.field_71990_ca);
               }
            }
         }
      }

      return true;
   }
}
