package net.minecraft.src;

import net.minecraft.src.BWG4BiomeInfo;
import net.minecraft.src.BWG4DefaultGeneratorInfo;
import net.minecraft.src.BWG4GuiDefaultList;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiCreateWorld;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.StatCollector;

public class BWG4GuiDefault extends GuiScreen {

   private final GuiCreateWorld createWorldGui;
   private BWG4GuiDefaultList bwg4guidefaultlist;
   private BWG4DefaultGeneratorInfo theDefaultGeneratorInfo = BWG4DefaultGeneratorInfo.defaultBiomesList();
   private GuiButton buttonEnable;
   private GuiButton buttonAll;
   private GuiButton buttonBiome;
   private GuiButton buttonSetting;
   private boolean all = false;
   private boolean customize;
   private boolean biomescreen;
   private BWG4BiomeInfo biome;


   public BWG4GuiDefault(GuiCreateWorld var1, String var2) {
      this.createWorldGui = var1;
      this.setGeneratorInfo(var2);
      this.customize = false;
   }

   public String getGeneratorInfo() {
      return this.theDefaultGeneratorInfo.toString();
   }

   public void setGeneratorInfo(String var1) {
      this.theDefaultGeneratorInfo = BWG4DefaultGeneratorInfo.FromString(var1);
   }

   static BWG4DefaultGeneratorInfo getBiomeArray(BWG4GuiDefault var0) {
      return var0.theDefaultGeneratorInfo;
   }

   public void func_73866_w_() {
      this.field_73887_h.clear();
      this.bwg4guidefaultlist = new BWG4GuiDefaultList(this);
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 100, 20, StatCollector.func_74838_a("gui.done")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 - 50, this.field_73881_g - 28, 100, 20, StatCollector.func_74838_a("gui.cancel")));
      this.field_73887_h.add(this.buttonEnable = new GuiButton(2, this.field_73880_f / 2 - 155, this.field_73881_g - 52, 100, 20, "Enable/Disable"));
      this.field_73887_h.add(this.buttonAll = new GuiButton(3, this.field_73880_f / 2 - 50, this.field_73881_g - 52, 100, 20, "Disable All"));
      this.field_73887_h.add(this.buttonBiome = new GuiButton(4, this.field_73880_f / 2 + 55, this.field_73881_g - 52, 100, 20, "-"));
      this.field_73887_h.add(this.buttonSetting = new GuiButton(5, this.field_73880_f / 2 + 55, this.field_73881_g - 28, 100, 20, "-"));
      this.setButtons();
      this.switchScreen();
   }

   protected void func_73875_a(GuiButton var1) {
      int var2 = this.theDefaultGeneratorInfo.theBiomesList().size() - this.bwg4guidefaultlist.selected - 1;
      if(var1.field_73741_f == 0) {
         this.createWorldGui.field_82290_a = this.getGeneratorInfo();
         this.field_73882_e.func_71373_a(this.createWorldGui);
      } else if(var1.field_73741_f == 1) {
         this.createWorldGui.field_82290_a = this.getGeneratorInfo();
         this.field_73882_e.func_71373_a(this.createWorldGui);
      } else if(var1.field_73741_f == 2) {
         BWG4BiomeInfo var3 = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(this.theDefaultGeneratorInfo.theBiomesList().size() - this.bwg4guidefaultlist.selected - 1);
         if(var3.getEnabled()) {
            var3.setEnabled(false);
         } else {
            var3.setEnabled(true);
         }
      } else if(var1.field_73741_f == 3) {
         BWG4BiomeInfo var4;
         int var5;
         if(!this.all) {
            for(var5 = 0; var5 < this.theDefaultGeneratorInfo.theBiomesList().size(); ++var5) {
               var4 = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(var5);
               var4.setEnabled(false);
            }

            this.all = true;
         } else {
            for(var5 = 0; var5 < this.theDefaultGeneratorInfo.theBiomesList().size(); ++var5) {
               var4 = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(var5);
               var4.setEnabled(true);
            }

            this.all = false;
         }

         this.updateButtons();
      } else if(var1.field_73741_f == 4) {
         this.biome = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(this.theDefaultGeneratorInfo.theBiomesList().size() - this.bwg4guidefaultlist.selected - 1);
         this.customize = false;
         this.biomescreen = true;
         this.switchScreen();
      } else if(var1.field_73741_f == 5) {
         if(this.biomescreen) {
            this.biomescreen = false;
            this.customize = false;
         } else if(this.customize) {
            this.customize = false;
         } else {
            this.customize = true;
         }

         this.switchScreen();
      }

   }

   public void updateButtons() {
      if(this.all) {
         this.buttonAll.field_73744_e = "Enable All";
      } else {
         this.buttonAll.field_73744_e = "Disable All";
      }

   }

   public void setButtons() {
      boolean var1 = this.checkPossible();
      this.buttonEnable.field_73742_g = var1;
      this.buttonBiome.field_73742_g = false;
      this.buttonSetting.field_73742_g = false;
   }

   private boolean checkPossible() {
      return this.bwg4guidefaultlist.selected > -1 && this.bwg4guidefaultlist.selected < this.theDefaultGeneratorInfo.theBiomesList().size();
   }

   public void switchScreen() {
      if(this.customize) {
         this.buttonEnable.field_73748_h = false;
         this.buttonAll.field_73748_h = false;
         this.buttonBiome.field_73748_h = false;
         this.buttonSetting.field_73744_e = "-";
      } else if(this.biomescreen) {
         this.buttonEnable.field_73748_h = false;
         this.buttonAll.field_73748_h = false;
         this.buttonBiome.field_73748_h = false;
         this.buttonSetting.field_73744_e = "-";
      } else {
         this.buttonEnable.field_73748_h = true;
         this.buttonAll.field_73748_h = true;
         this.buttonBiome.field_73748_h = true;
         this.buttonSetting.field_73744_e = "-";
      }

   }

   public void func_73863_a(int var1, int var2, float var3) {
      this.func_73873_v_();
      if(this.customize) {
         this.func_73732_a(this.field_73886_k, "World Settings", this.field_73880_f / 2, 8, 16777215);
      } else if(this.biomescreen) {
         this.func_73732_a(this.field_73886_k, "Biome: " + this.biome.getNAME(), this.field_73880_f / 2, 8, 16777215);
      } else {
         this.bwg4guidefaultlist.func_77211_a(var1, var2, var3);
         this.func_73732_a(this.field_73886_k, "Biome List", this.field_73880_f / 2, 8, 16777215);
         this.func_73732_a(this.field_73886_k, "Biome Name", this.field_73880_f / 2 - 80, 32, 16777215);
         this.func_73732_a(this.field_73886_k, "Enabled", this.field_73880_f / 2 + 80, 32, 16777215);
      }

      super.func_73863_a(var1, var2, var3);
   }
}
