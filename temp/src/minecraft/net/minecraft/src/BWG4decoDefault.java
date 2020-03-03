package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoDefault extends WorldGenerator {

   private int objectID;


   public BWG4decoDefault(int var1) {
      this.objectID = var1;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      if(this.objectID != 1) {
         return true;
      } else {
         int var6;
         for(boolean var7 = false; ((var6 = var1.func_72798_a(var3, var4, var5)) == 0 || var6 == Block.field_71952_K.field_71990_ca) && var4 > 0; --var4) {
            ;
         }

         for(int var12 = 0; var12 < 128; ++var12) {
            int var8 = var3 + var2.nextInt(8) - var2.nextInt(8);
            int var9 = var4 + var2.nextInt(4) - var2.nextInt(4);
            int var10 = var5 + var2.nextInt(8) - var2.nextInt(8);
            int var11 = var1.func_72798_a(var8, var9 - 1, var10);
            if(var1.func_72799_c(var8, var9, var10) && var11 == Block.field_71939_E.field_71990_ca && var9 > 66) {
               if(var2.nextInt(8) != 0) {
                  var1.func_72832_d(var8, var9, var10, Block.field_71962_X.field_71990_ca, 1, 0);
               } else {
                  var1.func_72832_d(var8, var9, var10, Block.field_71952_K.field_71990_ca, 4, 0);
               }

               var1.func_94575_c(var8, var9 - 1, var10, Block.field_71980_u.field_71990_ca);
            }
         }

         return true;
      }
   }
}
