package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.MathHelper;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4oldGenMinable extends WorldGenerator {

   private int minableBlockId;
   private int numberOfBlocks;
   private int generatortype;


   public BWG4oldGenMinable(int var1, int var2, int var3) {
      this.minableBlockId = var1;
      this.numberOfBlocks = var2;
      this.generatortype = var3;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      float var6;
      double var7;
      double var9;
      double var11;
      double var13;
      double var15;
      double var17;
      int var19;
      double var20;
      double var22;
      double var24;
      double var26;
      double var28;
      double var30;
      int var32;
      int var33;
      int var34;
      double var39;
      if(this.generatortype != 0 && this.generatortype != 1) {
         var6 = var2.nextFloat() * 3.141593F;
         var7 = (double)((float)(var3 + 8) + MathHelper.func_76126_a(var6) * (float)this.numberOfBlocks / 8.0F);
         var9 = (double)((float)(var3 + 8) - MathHelper.func_76126_a(var6) * (float)this.numberOfBlocks / 8.0F);
         var11 = (double)((float)(var5 + 8) + MathHelper.func_76134_b(var6) * (float)this.numberOfBlocks / 8.0F);
         var13 = (double)((float)(var5 + 8) - MathHelper.func_76134_b(var6) * (float)this.numberOfBlocks / 8.0F);
         var15 = (double)(var4 + var2.nextInt(3) + 2);
         var17 = (double)(var4 + var2.nextInt(3) + 2);

         for(var19 = 0; var19 <= this.numberOfBlocks; ++var19) {
            var20 = var7 + (var9 - var7) * (double)var19 / (double)this.numberOfBlocks;
            var22 = var15 + (var17 - var15) * (double)var19 / (double)this.numberOfBlocks;
            var24 = var11 + (var13 - var11) * (double)var19 / (double)this.numberOfBlocks;
            var26 = var2.nextDouble() * (double)this.numberOfBlocks / 16.0D;
            var28 = (double)(MathHelper.func_76126_a((float)var19 * 3.141593F / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
            var30 = (double)(MathHelper.func_76126_a((float)var19 * 3.141593F / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
            var32 = MathHelper.func_76128_c(var20 - var28 / 2.0D);
            var33 = MathHelper.func_76128_c(var22 - var30 / 2.0D);
            var34 = MathHelper.func_76128_c(var24 - var28 / 2.0D);
            int var47 = MathHelper.func_76128_c(var20 + var28 / 2.0D);
            int var36 = MathHelper.func_76128_c(var22 + var30 / 2.0D);
            int var48 = MathHelper.func_76128_c(var24 + var28 / 2.0D);

            for(int var38 = var32; var38 <= var47; ++var38) {
               var39 = ((double)var38 + 0.5D - var20) / (var28 / 2.0D);
               if(var39 * var39 < 1.0D) {
                  for(int var41 = var33; var41 <= var36; ++var41) {
                     double var42 = ((double)var41 + 0.5D - var22) / (var30 / 2.0D);
                     if(var39 * var39 + var42 * var42 < 1.0D) {
                        for(int var44 = var34; var44 <= var48; ++var44) {
                           double var45 = ((double)var44 + 0.5D - var24) / (var28 / 2.0D);
                           if(var39 * var39 + var42 * var42 + var45 * var45 < 1.0D && var1.func_72798_a(var38, var41, var44) == Block.field_71981_t.field_71990_ca) {
                              var1.func_94575_c(var38, var41, var44, this.minableBlockId);
                           }
                        }
                     }
                  }
               }
            }
         }

         return true;
      } else {
         var6 = var2.nextFloat() * 3.141593F;
         var7 = (double)((float)(var3 + 8) + MathHelper.func_76126_a(var6) * (float)this.numberOfBlocks / 8.0F);
         var9 = (double)((float)(var3 + 8) - MathHelper.func_76126_a(var6) * (float)this.numberOfBlocks / 8.0F);
         var11 = (double)((float)(var5 + 8) + MathHelper.func_76134_b(var6) * (float)this.numberOfBlocks / 8.0F);
         var13 = (double)((float)(var5 + 8) - MathHelper.func_76134_b(var6) * (float)this.numberOfBlocks / 8.0F);
         var15 = (double)(var4 + var2.nextInt(3) + 2);
         var17 = (double)(var4 + var2.nextInt(3) + 2);

         for(var19 = 0; var19 <= this.numberOfBlocks; ++var19) {
            var20 = var7 + (var9 - var7) * (double)var19 / (double)this.numberOfBlocks;
            var22 = var15 + (var17 - var15) * (double)var19 / (double)this.numberOfBlocks;
            var24 = var11 + (var13 - var11) * (double)var19 / (double)this.numberOfBlocks;
            var26 = var2.nextDouble() * (double)this.numberOfBlocks / 16.0D;
            var28 = (double)(MathHelper.func_76126_a((float)var19 * 3.141593F / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;
            var30 = (double)(MathHelper.func_76126_a((float)var19 * 3.141593F / (float)this.numberOfBlocks) + 1.0F) * var26 + 1.0D;

            for(var32 = (int)(var20 - var28 / 2.0D); var32 <= (int)(var20 + var28 / 2.0D); ++var32) {
               for(var33 = (int)(var22 - var30 / 2.0D); var33 <= (int)(var22 + var30 / 2.0D); ++var33) {
                  for(var34 = (int)(var24 - var28 / 2.0D); var34 <= (int)(var24 + var28 / 2.0D); ++var34) {
                     double var35 = ((double)var32 + 0.5D - var20) / (var28 / 2.0D);
                     double var37 = ((double)var33 + 0.5D - var22) / (var30 / 2.0D);
                     var39 = ((double)var34 + 0.5D - var24) / (var28 / 2.0D);
                     if(var35 * var35 + var37 * var37 + var39 * var39 < 1.0D && var1.func_72798_a(var32, var33, var34) == Block.field_71981_t.field_71990_ca) {
                        var1.func_94575_c(var32, var33, var34, this.minableBlockId);
                     }
                  }
               }
            }
         }

         return true;
      }
   }
}
