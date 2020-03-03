package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.Block;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenerator;

public class BWG4decoIndevHouse extends WorldGenerator {

   private int typeID;


   public BWG4decoIndevHouse(int var1) {
      this.typeID = var1;
   }

   public boolean func_76484_a(World var1, Random var2, int var3, int var4, int var5) {
      int var6;
      int var7;
      for(var6 = -3 + var3; var6 < 4 + var3; ++var6) {
         for(var7 = -3 + var5; var7 < 4 + var5; ++var7) {
            this.func_76486_a(var1, var6, var4 - 1, var7, Block.field_71981_t.field_71990_ca);
         }
      }

      for(var6 = -3 + var3; var6 < 4 + var3; ++var6) {
         for(var7 = -3 + var5; var7 < 4 + var5; ++var7) {
            this.func_76486_a(var1, var6, var4 - 2, var7, Block.field_71981_t.field_71990_ca);
         }
      }

      for(var6 = -3 + var3; var6 < 4 + var3; ++var6) {
         for(var7 = -3 + var5; var7 < 4 + var5; ++var7) {
            this.func_76486_a(var1, var6, var4 - 3, var7, Block.field_71981_t.field_71990_ca);
         }
      }

      int var8;
      if(this.typeID == 2) {
         for(var6 = -3 + var3; var6 < 4 + var3; ++var6) {
            for(var7 = 0 + var4; var7 < 4 + var4; ++var7) {
               for(var8 = -3 + var5; var8 < 4 + var5; ++var8) {
                  this.func_76486_a(var1, var6, var7, var8, Block.field_72087_ao.field_71990_ca);
               }
            }
         }
      } else {
         for(var6 = -3 + var3; var6 < 4 + var3; ++var6) {
            for(var7 = 0 + var4; var7 < 4 + var4; ++var7) {
               for(var8 = -3 + var5; var8 < 4 + var5; ++var8) {
                  this.func_76486_a(var1, var6, var7, var8, Block.field_71988_x.field_71990_ca);
               }
            }
         }
      }

      for(var6 = -2 + var3; var6 < 3 + var3; ++var6) {
         for(var7 = 0 + var4; var7 < 3 + var4; ++var7) {
            for(var8 = -2 + var5; var8 < 3 + var5; ++var8) {
               this.func_76486_a(var1, var6, var7, var8, 0);
            }
         }
      }

      if((!var1.func_72799_c(var3 - 4, var4 + 1, var5) || var1.func_72799_c(var3 - 4, var4 - 1, var5)) && var1.func_72799_c(var3 - 4, var4 - 2, var5)) {
         if((!var1.func_72799_c(var3 + 4, var4 + 1, var5) || var1.func_72799_c(var3 + 4, var4 - 1, var5)) && var1.func_72799_c(var3 + 4, var4 - 2, var5)) {
            if((!var1.func_72799_c(var3, var4 + 1, var5 - 4) || var1.func_72799_c(var3, var4 - 1, var5 - 4)) && var1.func_72799_c(var3, var4 - 2, var5 - 4)) {
               if((!var1.func_72799_c(var3, var4 + 1, var5 + 4) || var1.func_72799_c(var3, var4 - 1, var5 + 4)) && var1.func_72799_c(var3, var4 - 2, var5 + 4)) {
                  this.func_76486_a(var1, var3 - 3, var4, var5, 0);
                  this.func_76486_a(var1, var3 - 3, var4 + 1, var5, 0);
                  this.func_76486_a(var1, var3 - 4, var4, var5, 0);
                  this.func_76486_a(var1, var3 - 4, var4 + 1, var5, 0);
                  var1.func_94575_c(var3, var4 + 1, var5 + 2, Block.field_72069_aq.field_71990_ca);
                  var1.func_94575_c(var3, var4 + 1, var5 - 2, Block.field_72069_aq.field_71990_ca);
               } else {
                  this.func_76486_a(var1, var3, var4, var5 + 3, 0);
                  this.func_76486_a(var1, var3, var4 + 1, var5 + 3, 0);
                  this.func_76486_a(var1, var3, var4, var5 + 4, 0);
                  this.func_76486_a(var1, var3, var4 + 1, var5 + 4, 0);
                  var1.func_94575_c(var3 + 2, var4 + 1, var5, Block.field_72069_aq.field_71990_ca);
                  var1.func_94575_c(var3 - 2, var4 + 1, var5, Block.field_72069_aq.field_71990_ca);
               }
            } else {
               this.func_76486_a(var1, var3, var4, var5 - 3, 0);
               this.func_76486_a(var1, var3, var4 + 1, var5 - 3, 0);
               this.func_76486_a(var1, var3, var4, var5 - 4, 0);
               this.func_76486_a(var1, var3, var4 + 1, var5 - 4, 0);
               var1.func_94575_c(var3 + 2, var4 + 1, var5, Block.field_72069_aq.field_71990_ca);
               var1.func_94575_c(var3 - 2, var4 + 1, var5, Block.field_72069_aq.field_71990_ca);
            }
         } else {
            this.func_76486_a(var1, var3 + 3, var4, var5, 0);
            this.func_76486_a(var1, var3 + 3, var4 + 1, var5, 0);
            this.func_76486_a(var1, var3 + 4, var4, var5, 0);
            this.func_76486_a(var1, var3 + 4, var4 + 1, var5, 0);
            var1.func_94575_c(var3, var4 + 1, var5 + 2, Block.field_72069_aq.field_71990_ca);
            var1.func_94575_c(var3, var4 + 1, var5 - 2, Block.field_72069_aq.field_71990_ca);
         }
      } else {
         this.func_76486_a(var1, var3 - 3, var4, var5, 0);
         this.func_76486_a(var1, var3 - 3, var4 + 1, var5, 0);
         this.func_76486_a(var1, var3 - 4, var4, var5, 0);
         this.func_76486_a(var1, var3 - 4, var4 + 1, var5, 0);
         var1.func_94575_c(var3, var4 + 1, var5 + 2, Block.field_72069_aq.field_71990_ca);
         var1.func_94575_c(var3, var4 + 1, var5 - 2, Block.field_72069_aq.field_71990_ca);
      }

      return true;
   }
}
