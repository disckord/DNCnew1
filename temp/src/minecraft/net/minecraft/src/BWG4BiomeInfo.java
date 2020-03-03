package net.minecraft.src;


public class BWG4BiomeInfo {

   private String Setting;
   private boolean enabled;


   public BWG4BiomeInfo(String var1, boolean var2) {
      this.Setting = var1;
      this.enabled = var2;
   }

   public String getNAME() {
      return this.Setting;
   }

   public boolean getEnabled() {
      return this.enabled;
   }

   public void setEnabled(boolean var1) {
      this.enabled = var1;
   }

   public String toString() {
      String var1 = "";
      if(this.enabled) {
         var1 = this.Setting + "=true";
      } else {
         var1 = this.Setting + "=false";
      }

      return var1;
   }
}
