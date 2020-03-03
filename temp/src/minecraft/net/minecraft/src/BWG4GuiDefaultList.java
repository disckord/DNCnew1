package net.minecraft.src;

import net.minecraft.src.BWG4BiomeInfo;
import net.minecraft.src.BWG4GuiDefault;
import net.minecraft.src.GuiSlot;
import net.minecraft.src.Tessellator;

class BWG4GuiDefaultList extends GuiSlot {

   final BWG4GuiDefault bwg4guidefault;
   public int selected;


   public BWG4GuiDefaultList(BWG4GuiDefault var1) {
      super(var1.field_73882_e, var1.field_73880_f, var1.field_73881_g, 43, var1.field_73881_g - 60, 24);
      this.bwg4guidefault = var1;
      this.selected = -1;
   }

   protected int func_77217_a() {
      return BWG4GuiDefault.getBiomeArray(this.bwg4guidefault).theBiomesList().size();
   }

   protected void func_77213_a(int var1, boolean var2) {
      this.selected = var1;
      this.bwg4guidefault.setButtons();
   }

   protected boolean func_77218_a(int var1) {
      return var1 == this.selected;
   }

   protected void func_77221_c() {}

   protected void func_77214_a(int var1, int var2, int var3, int var4, Tessellator var5) {
      BWG4BiomeInfo var6 = (BWG4BiomeInfo)BWG4GuiDefault.getBiomeArray(this.bwg4guidefault).theBiomesList().get(BWG4GuiDefault.getBiomeArray(this.bwg4guidefault).theBiomesList().size() - var1 - 1);
      String var7 = var6.getNAME();
      boolean var8 = var6.getEnabled();
      if(var8) {
         this.bwg4guidefault.field_73886_k.func_78276_b(var7, var2 + 1, var3 + 7, 16777215);
         this.bwg4guidefault.field_73886_k.func_78276_b("YES", var2 + 179, var3 + 7, 16777215);
      } else {
         this.bwg4guidefault.field_73886_k.func_78276_b(var7, var2 + 1, var3 + 7, 10526880);
         this.bwg4guidefault.field_73886_k.func_78276_b("NO", var2 + 182, var3 + 7, 10526880);
      }

   }

   protected int func_77225_g() {
      return this.bwg4guidefault.field_73880_f - 70;
   }
}
