package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoGold4 extends WorldGenerator {

   private int objectID;
   private int input1;


   public BWG4decoGold4(int var1) {
      this.objectID = var1;
   }

   public BWG4decoGold4(int var1, int var2) {
      this.objectID = var1;
      this.input1 = var2;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      int var7;
      int var8;
      if(this.objectID == 1) {
         var6 = var1.func_72798_a(var3, var4 - 1, var5);
         if(var6 != Block.field_71980_u.field_71990_ca) {
            return false;
         }

         if(var1.func_72803_f(var3 - 1, var4, var5).func_76220_a()) {
            return false;
         }

         if(var1.func_72803_f(var3 + 1, var4, var5).func_76220_a()) {
            return false;
         }

         if(var1.func_72803_f(var3, var4, var5 - 1).func_76220_a()) {
            return false;
         }

         if(var1.func_72803_f(var3, var4, var5 + 1).func_76220_a()) {
            return false;
         }

         var1.func_94575_c(var3, var4 - 1, var5, Block.field_71939_E.field_71990_ca);
         var7 = 2 + var2.nextInt(var2.nextInt(3) + 1);

         for(var8 = 0; var8 < var7; ++var8) {
            var1.func_94575_c(var3, var4 + var8, var5, Block.field_72038_aV.field_71990_ca);
         }
      } else if(this.objectID == 2) {
         var6 = var1.func_72798_a(var3, var4 - 1, var5);
         if(var6 != Block.field_71980_u.field_71990_ca) {
            return false;
         }

         var7 = 4 + var2.nextInt(3);

         for(var8 = 0; var8 < var7; ++var8) {
            var1.func_94575_c(var3, var4 + var8, var5, Block.field_71951_J.field_71990_ca);
         }

         if(var2.nextInt(4) == 0) {
            var1.func_94575_c(var3 + 0, var4 + var7 + 1, var5 + 1, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 1, var4 + var7 + 2, var5 + 2, Block.field_71951_J.field_71990_ca);
            this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 2, var5 + 2, 3);
            this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 3, var5 + 2, 2);
         }

         if(var2.nextInt(4) == 0) {
            var1.func_94575_c(var3 + 1, var4 + var7 + 0, var5 + 0, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 2, var4 + var7 + 1, var5 + 0, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 3, var4 + var7 + 2, var5 - 1, Block.field_71951_J.field_71990_ca);
            this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 3, var5 - 1, 3);
            this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 4, var5 - 1, 2);
         }

         if(var2.nextInt(4) == 0) {
            var1.func_94575_c(var3 - 1, var4 + var7 + 0, var5 + 0, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 - 2, var4 + var7 + 1, var5 + 0, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 - 3, var4 + var7 + 2, var5 - 1, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 - 4, var4 + var7 + 3, var5 - 2, Block.field_71951_J.field_71990_ca);
            this.createSavannaLeaves(var1, var2, var3 - 4, var4 + var7 + 4, var5 - 2, 3);
            this.createSavannaLeaves(var1, var2, var3 - 4, var4 + var7 + 5, var5 - 2, 2);
         }

         if(var2.nextInt(4) == 0) {
            var1.func_94575_c(var3 + 0, var4 + var7 + 0, var5 - 1, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 1, var4 + var7 + 1, var5 - 2, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 2, var4 + var7 + 2, var5 - 2, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 3, var4 + var7 + 3, var5 - 2, Block.field_71951_J.field_71990_ca);
            this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 3, var5 - 2, 3);
            this.createSavannaLeaves(var1, var2, var3 + 3, var4 + var7 + 4, var5 - 2, 2);
         }

         if(var2.nextInt(4) == 0) {
            var1.func_94575_c(var3 + 0, var4 + var7 + 0, var5 - 1, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 0, var4 + var7 + 0, var5 - 2, Block.field_71951_J.field_71990_ca);
            var1.func_94575_c(var3 + 1, var4 + var7 + 1, var5 - 3, Block.field_71951_J.field_71990_ca);
            this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 1, var5 - 3, 3);
            this.createSavannaLeaves(var1, var2, var3 + 1, var4 + var7 + 2, var5 - 3, 2);
         }

         var1.func_94575_c(var3 - 0, var4 + var7 + 0, var5 + 0, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 - 0, var4 + var7 + 1, var5 + 0, Block.field_71951_J.field_71990_ca);
         var1.func_94575_c(var3 - 0, var4 + var7 + 2, var5 - 0, Block.field_71951_J.field_71990_ca);
         this.createSavannaLeaves(var1, var2, var3 + 0, var4 + var7 + 3, var5 - 0, 3);
         this.createSavannaLeaves(var1, var2, var3 + 0, var4 + var7 + 4, var5 - 0, 2);
      }

      return true;
   }

   private void createSavannaLeaves(World var1, Random var2, int var3, int var4, int var5, int var6) {
      for(int var7 = -var6 + var3; var7 < var6 + 1 + var3; ++var7) {
         for(int var8 = -var6 + var5; var8 < var6 + 1 + var5; ++var8) {
            int var9 = var1.func_72798_a(var7, var4, var8);
            if(var9 == 0 && (var7 != -var6 + var3 || var8 != -var6 + var5) && (var7 != -var6 + var3 || var8 != var6 + var5) && (var7 != var6 + var3 || var8 != -var6 + var5) && (var7 != var6 + var3 || var8 != var6 + var5)) {
               var1.func_94575_c(var7, var4, var8, Block.field_71952_K.field_71990_ca);
            }
         }
      }

      if(var6 == 3) {
         var1.func_94575_c(var3, var4, var5, Block.field_71951_J.field_71990_ca);
      }

   }

   private ItemStack getChestList(int var1, Random var2, World var3) {
      return null;
   }
}
