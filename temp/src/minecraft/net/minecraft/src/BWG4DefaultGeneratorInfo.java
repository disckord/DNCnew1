package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.src.BWG4BiomeInfo;

public class BWG4DefaultGeneratorInfo {

   private final List Biomelist = new ArrayList();


   public List theBiomesList() {
      return this.Biomelist;
   }

   public static BWG4DefaultGeneratorInfo defaultBiomesList() {
      BWG4DefaultGeneratorInfo var0 = new BWG4DefaultGeneratorInfo();
      var0.theBiomesList().add(new BWG4BiomeInfo("Shrubland", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Savanna", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Desert", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Swampland", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Jungle", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("RainForest", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Grassland", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Taiga", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Pines", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Forest Lakes", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Forest Hills", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Forest", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Plains", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Snow Hills", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Snow Plains", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Snow Taiga", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Snow Forest", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Snow Pines", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Beach Dunes", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Beach", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Mushroom Island", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Jungle Island", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Tropical Island", true));
      var0.theBiomesList().add(new BWG4BiomeInfo("Ocean", true));
      return var0;
   }

   public String toString() {
      StringBuilder var1 = new StringBuilder();
      var1.append("1&");

      for(int var2 = 0; var2 < this.Biomelist.size(); ++var2) {
         if(var2 > 0) {
            var1.append(";");
         }

         var1.append(((BWG4BiomeInfo)this.Biomelist.get(var2)).toString());
      }

      return var1.toString();
   }

   public static BWG4DefaultGeneratorInfo FromString(String var0) {
      BWG4DefaultGeneratorInfo var1 = new BWG4DefaultGeneratorInfo();
      if(var0 != "") {
         String[] var2 = var0.split("&");
         String[] var3 = var2[1].split(";");

         for(int var6 = 0; var6 < var3.length; ++var6) {
            String[] var7 = var3[var6].split("=");
            String var4 = var7[0];
            boolean var5;
            if(var7[1].equals("true")) {
               var5 = true;
            } else {
               var5 = false;
            }

            var1.theBiomesList().add(new BWG4BiomeInfo(var4, var5));
         }

         return var1;
      } else {
         return defaultBiomesList();
      }
   }
}
