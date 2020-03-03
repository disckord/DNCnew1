package net.minecraft.src;

import java.util.Random;
import net.minecraft.src.BWG4GuiDefault;
import net.minecraft.src.ChatAllowedCharacters;
import net.minecraft.src.EnumGameType;
import net.minecraft.src.GuiButton;
import net.minecraft.src.GuiCreateFlatWorld;
import net.minecraft.src.GuiScreen;
import net.minecraft.src.GuiTextField;
import net.minecraft.src.ISaveFormat;
import net.minecraft.src.MathHelper;
import net.minecraft.src.StatCollector;
import net.minecraft.src.StringTranslate;
import net.minecraft.src.WorldInfo;
import net.minecraft.src.WorldSettings;
import net.minecraft.src.WorldType;
import org.lwjgl.input.Keyboard;

public class GuiCreateWorld extends GuiScreen {

   private GuiScreen field_73924_a;
   private GuiTextField field_73919_b;
   private GuiTextField field_73921_c;
   private String field_73918_d;
   private String field_73927_m = "survival";
   private boolean field_73925_n = true;
   private boolean field_73926_o = false;
   private boolean field_73935_p = false;
   private boolean field_73934_q = false;
   private boolean field_73933_r = false;
   private boolean field_73932_s;
   private boolean field_73931_t;
   private GuiButton field_73930_u;
   private GuiButton field_73929_v;
   private GuiButton field_73928_w;
   private GuiButton field_73938_x;
   private GuiButton field_73937_y;
   private GuiButton field_73936_z;
   private GuiButton field_82289_B;
   private String field_73920_A;
   private String field_73922_B;
   private String field_73923_C;
   private String field_73915_D;
   private int field_73916_E = 0;
   public String field_82290_a = "";
   private GuiButton buttonDefault;
   private GuiButton buttonLargeBiomes;
   private GuiButton buttonBeta;
   private GuiButton buttonInfdev;
   private GuiButton buttonIndev1;
   private GuiButton buttonIndev2;
   private GuiButton buttonIsland;
   private GuiButton buttonSkyland;
   private GuiButton buttonSkydimension;
   private GuiButton buttonCave;
   private GuiButton buttonCustomDefault1;
   private GuiButton buttonCustomDefault2;
   private GuiButton buttonSkyBlock;
   private int selectDefault = 1;
   private int selectLargeBiomes = 1;
   private int selectBeta = 0;
   private int selectInfdev = 0;
   private int selectIndev1 = 0;
   private int selectIndev2 = 0;
   private int selectIsland = 0;
   private int selectSkyland = 0;
   private int selectSkydimension = 0;
   private int selectCave = 0;
   private int selectSkyBlock = 0;
   private int currentWorldtype = 1;
   private int maxWorldtype = 0;
   private static final String[] field_73917_F = new String[]{"CON", "COM", "PRN", "AUX", "CLOCK$", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9"};


   public GuiCreateWorld(GuiScreen p_i3036_1_) {
      this.field_73924_a = p_i3036_1_;
      this.field_73923_C = "";
      this.field_73915_D = StatCollector.func_74838_a("selectWorld.newWorld");
      this.maxWorldtype = 0;

      for(int var2 = 0; var2 < WorldType.field_77139_a.length; ++var2) {
         if(WorldType.field_77139_a[var2] != null && WorldType.field_77139_a[var2].func_77126_d()) {
            ++this.maxWorldtype;
         }
      }

   }

   public void func_73876_c() {
      this.field_73919_b.func_73780_a();
      this.field_73921_c.func_73780_a();
   }

   public void func_73866_w_() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      Keyboard.enableRepeatEvents(true);
      this.field_73887_h.clear();
      this.field_73887_h.add(new GuiButton(0, this.field_73880_f / 2 - 155, this.field_73881_g - 28, 150, 20, var1.func_74805_b("selectWorld.create")));
      this.field_73887_h.add(new GuiButton(1, this.field_73880_f / 2 + 5, this.field_73881_g - 28, 150, 20, var1.func_74805_b("gui.cancel")));
      this.field_73887_h.add(this.field_73930_u = new GuiButton(2, this.field_73880_f / 2 - 75, 115, 150, 20, var1.func_74805_b("selectWorld.gameMode")));
      this.field_73887_h.add(this.field_73929_v = new GuiButton(3, this.field_73880_f / 2 - 75, 187, 150, 20, var1.func_74805_b("selectWorld.moreWorldOptions")));
      this.field_73887_h.add(this.field_73928_w = new GuiButton(4, this.field_73880_f / 2 - 165, 100, 160, 20, var1.func_74805_b("selectWorld.mapFeatures")));
      this.field_73928_w.field_73748_h = false;
      this.field_73887_h.add(this.field_73938_x = new GuiButton(7, this.field_73880_f / 2 - 165, 125, 160, 20, var1.func_74805_b("selectWorld.bonusItems")));
      this.field_73938_x.field_73748_h = false;
      this.field_73887_h.add(this.field_73937_y = new GuiButton(5, this.field_73880_f / 2 + 5, 100, 160, 20, var1.func_74805_b("selectWorld.mapType")));
      this.field_73937_y.field_73748_h = false;
      this.field_73887_h.add(this.field_73936_z = new GuiButton(6, this.field_73880_f / 2 - 165, 151, 160, 20, var1.func_74805_b("selectWorld.allowCommands")));
      this.field_73936_z.field_73748_h = false;
      this.field_73887_h.add(this.field_82289_B = new GuiButton(8, this.field_73880_f / 2 + 5, 125, 160, 20, var1.func_74805_b("selectWorld.customizeType")));
      this.field_82289_B.field_73748_h = false;
      this.field_73887_h.add(this.buttonDefault = new GuiButton(9, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonDefault"));
      this.field_73887_h.add(this.buttonLargeBiomes = new GuiButton(10, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonLargeBiomes"));
      this.field_73887_h.add(this.buttonBeta = new GuiButton(11, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonBeta"));
      this.field_73887_h.add(this.buttonInfdev = new GuiButton(12, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonInfdev"));
      this.field_73887_h.add(this.buttonIndev1 = new GuiButton(13, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonIndev1"));
      this.field_73887_h.add(this.buttonIndev2 = new GuiButton(17, this.field_73880_f / 2 + 5, 150, 160, 20, "buttonIndev2"));
      this.field_73887_h.add(this.buttonIsland = new GuiButton(14, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonIsland"));
      this.field_73887_h.add(this.buttonSkyland = new GuiButton(15, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonSkyland"));
      this.field_73887_h.add(this.buttonSkydimension = new GuiButton(16, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonSkydimension"));
      this.field_73887_h.add(this.buttonCave = new GuiButton(18, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonCave"));
      this.field_73887_h.add(this.buttonCustomDefault1 = new GuiButton(19, this.field_73880_f / 2 + 5, 150, 160, 20, var1.func_74805_b("selectWorld.customizeType")));
      this.field_73887_h.add(this.buttonCustomDefault2 = new GuiButton(20, this.field_73880_f / 2 + 5, 150, 160, 20, var1.func_74805_b("selectWorld.customizeType")));
      this.field_73887_h.add(this.buttonSkyBlock = new GuiButton(21, this.field_73880_f / 2 + 5, 125, 160, 20, "buttonSkyBlock"));
      this.buttonDefault.field_73748_h = false;
      this.buttonLargeBiomes.field_73748_h = false;
      this.buttonBeta.field_73748_h = false;
      this.buttonInfdev.field_73748_h = false;
      this.buttonIndev1.field_73748_h = false;
      this.buttonIndev2.field_73748_h = false;
      this.buttonIsland.field_73748_h = false;
      this.buttonSkyland.field_73748_h = false;
      this.buttonSkydimension.field_73748_h = false;
      this.buttonCave.field_73748_h = false;
      this.buttonCustomDefault1.field_73748_h = false;
      this.buttonCustomDefault2.field_73748_h = false;
      this.buttonSkyBlock.field_73748_h = false;
      this.field_73919_b = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
      this.field_73919_b.func_73796_b(true);
      this.field_73919_b.func_73782_a(this.field_73915_D);
      this.field_73921_c = new GuiTextField(this.field_73886_k, this.field_73880_f / 2 - 100, 60, 200, 20);
      this.field_73921_c.func_73782_a(this.field_73923_C);
      this.func_82288_a(this.field_73931_t);
      this.func_73912_g();
      this.func_73914_h();
      if(this.field_82290_a.length() < 2) {
         this.field_82290_a = "1&Shrubland=true;Savanna=true;Desert=true;Swampland=true;Jungle=true;RainForest=true;Grassland=true;Taiga=true;Pines=true;Forest Lakes=true;Forest Hills=true;Forest=true;Plains=true;Snow Hills=true;Snow Plains=true;Snow Taiga=true;Snow Forest=true;Snow Pines=true;Beach Dunes=true;Beach=true;Mushroom Island=true;Jungle Island=true;Tropical Island=true;Ocean=true";
      }

   }

   private void func_73912_g() {
      this.field_73918_d = this.field_73919_b.func_73781_b().trim();
      char[] var1 = ChatAllowedCharacters.field_71567_b;
      int var2 = var1.length;

      for(int var3 = 0; var3 < var2; ++var3) {
         char var4 = var1[var3];
         this.field_73918_d = this.field_73918_d.replace(var4, '_');
      }

      if(MathHelper.func_76139_a(this.field_73918_d)) {
         this.field_73918_d = "World";
      }

      this.field_73918_d = func_73913_a(this.field_73882_e.func_71359_d(), this.field_73918_d);
   }

   private void func_73914_h() {
      StringTranslate var1 = StringTranslate.func_74808_a();
      this.field_73930_u.field_73744_e = var1.func_74805_b("selectWorld.gameMode") + " " + var1.func_74805_b("selectWorld.gameMode." + this.field_73927_m);
      this.field_73920_A = var1.func_74805_b("selectWorld.gameMode." + this.field_73927_m + ".line1");
      this.field_73922_B = var1.func_74805_b("selectWorld.gameMode." + this.field_73927_m + ".line2");
      this.field_73928_w.field_73744_e = var1.func_74805_b("selectWorld.mapFeatures") + " ";
      if(this.field_73925_n) {
         this.field_73928_w.field_73744_e = this.field_73928_w.field_73744_e + var1.func_74805_b("options.on");
      } else {
         this.field_73928_w.field_73744_e = this.field_73928_w.field_73744_e + var1.func_74805_b("options.off");
      }

      this.field_73938_x.field_73744_e = var1.func_74805_b("selectWorld.bonusItems") + " ";
      if(this.field_73934_q && !this.field_73933_r) {
         this.field_73938_x.field_73744_e = this.field_73938_x.field_73744_e + var1.func_74805_b("options.on");
      } else {
         this.field_73938_x.field_73744_e = this.field_73938_x.field_73744_e + var1.func_74805_b("options.off");
      }

      this.field_73937_y.field_73744_e = var1.func_74805_b("selectWorld.mapType") + " " + var1.func_74805_b(WorldType.field_77139_a[this.field_73916_E].func_77128_b());
      this.field_73936_z.field_73744_e = var1.func_74805_b("selectWorld.allowCommands") + " ";
      if(this.field_73926_o && !this.field_73933_r) {
         this.field_73936_z.field_73744_e = this.field_73936_z.field_73744_e + var1.func_74805_b("options.on");
      } else {
         this.field_73936_z.field_73744_e = this.field_73936_z.field_73744_e + var1.func_74805_b("options.off");
      }

      if(this.selectDefault == 0) {
         this.buttonDefault.field_73744_e = "Better Default: " + var1.func_74805_b("options.off");
      } else {
         this.buttonDefault.field_73744_e = "Better Default: " + var1.func_74805_b("options.on");
      }

      if(this.selectLargeBiomes == 0) {
         this.buttonLargeBiomes.field_73744_e = "Better Default: " + var1.func_74805_b("options.off");
      } else {
         this.buttonLargeBiomes.field_73744_e = "Better Default: " + var1.func_74805_b("options.on");
      }

      if(this.selectBeta == 0) {
         this.buttonBeta.field_73744_e = "Biomes: Beta";
      } else {
         this.buttonBeta.field_73744_e = "Biomes: Default";
      }

      if(this.selectInfdev == 0) {
         this.buttonInfdev.field_73744_e = "Snow World: " + var1.func_74805_b("options.off");
      } else {
         this.buttonInfdev.field_73744_e = "Snow World: " + var1.func_74805_b("options.on");
      }

      if(this.selectIndev1 == 0) {
         this.buttonIndev1.field_73744_e = "Type: Inland";
      } else {
         this.buttonIndev1.field_73744_e = "Type: Floating";
      }

      if(this.selectIndev2 == 0) {
         this.buttonIndev2.field_73744_e = "Theme: Normal";
      } else if(this.selectIndev2 == 1) {
         this.buttonIndev2.field_73744_e = "Theme: Hell";
      } else if(this.selectIndev2 == 2) {
         this.buttonIndev2.field_73744_e = "Theme: Paradise";
      } else if(this.selectIndev2 == 3) {
         this.buttonIndev2.field_73744_e = "Theme: Woods";
      } else {
         this.buttonIndev2.field_73744_e = "Theme: Snow";
      }

      if(this.selectIsland == 0) {
         this.buttonIsland.field_73744_e = "Theme: Normal";
      } else if(this.selectIsland == 1) {
         this.buttonIsland.field_73744_e = "Theme: -";
      } else if(this.selectIsland == 2) {
         this.buttonIsland.field_73744_e = "Theme: -";
      } else if(this.selectIsland == 3) {
         this.buttonIsland.field_73744_e = "Theme: Paradise";
      } else {
         this.buttonIsland.field_73744_e = "Theme: -";
      }

      if(this.selectSkyland == 0) {
         this.buttonSkyland.field_73744_e = "Theme: Normal";
      } else if(this.selectSkyland == 1) {
         this.buttonSkyland.field_73744_e = "Theme: -";
      } else if(this.selectSkyland == 2) {
         this.buttonSkyland.field_73744_e = "Theme: Snow";
      } else if(this.selectSkyland == 3) {
         this.buttonSkyland.field_73744_e = "Theme: Jungle";
      } else {
         this.buttonSkyland.field_73744_e = "Theme: -";
      }

      if(this.selectSkyBlock == 0) {
         this.buttonSkyBlock.field_73744_e = "Type: Classic";
      } else if(this.selectSkyBlock == 1) {
         this.buttonSkyBlock.field_73744_e = "Type: Extended";
      } else {
         this.buttonSkyBlock.field_73744_e = "Type: 3";
      }

      if(this.selectSkydimension == 0) {
         this.buttonSkydimension.field_73744_e = "Biomes: Default";
      } else if(this.selectSkydimension == 1) {
         this.buttonSkydimension.field_73744_e = "Biomes: Beta";
      } else {
         this.buttonSkydimension.field_73744_e = "Biomes: Adventure";
      }

      if(this.selectCave == 0) {
         this.buttonCave.field_73744_e = "Theme: Default";
      } else if(this.selectCave == 1) {
         this.buttonCave.field_73744_e = "Theme: Stone Only";
      } else {
         this.buttonCave.field_73744_e = "Theme: Desert";
      }

   }

   public static String func_73913_a(ISaveFormat p_73913_0_, String p_73913_1_) {
      p_73913_1_ = p_73913_1_.replaceAll("[\\./\"]", "_");
      String[] var2 = field_73917_F;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         String var5 = var2[var4];
         if(p_73913_1_.equalsIgnoreCase(var5)) {
            p_73913_1_ = "_" + p_73913_1_ + "_";
         }
      }

      while(p_73913_0_.func_75803_c(p_73913_1_) != null) {
         p_73913_1_ = p_73913_1_ + "-";
      }

      return p_73913_1_;
   }

   public void func_73874_b() {
      Keyboard.enableRepeatEvents(false);
   }

   protected void func_73875_a(GuiButton p_73875_1_) {
      if(p_73875_1_.field_73742_g) {
         if(p_73875_1_.field_73741_f == 1) {
            this.field_73882_e.func_71373_a(this.field_73924_a);
         } else if(p_73875_1_.field_73741_f == 0) {
            this.field_73882_e.func_71373_a((GuiScreen)null);
            if(this.field_73932_s) {
               return;
            }

            this.field_73932_s = true;
            long var2 = (new Random()).nextLong();
            String var4 = this.field_73921_c.func_73781_b();
            if(!MathHelper.func_76139_a(var4)) {
               try {
                  long var5 = Long.parseLong(var4);
                  if(var5 != 0L) {
                     var2 = var5;
                  }
               } catch (NumberFormatException var7) {
                  var2 = (long)var4.hashCode();
               }
            }

            if(this.selectDefault == 1 && this.field_73916_E == 0) {
               this.field_73916_E = 10;
            }

            if(this.selectLargeBiomes == 1 && this.field_73916_E == 2) {
               this.field_73916_E = 11;
            }

            if(this.selectBeta == 1 && this.field_73916_E == 12) {
               this.field_73916_E = 13;
            }

            if(this.selectBeta == 2 && this.field_73916_E == 12) {
               this.field_73916_E = 14;
            }

            if(this.selectIndev1 == 1 && this.field_73916_E == 17) {
               this.field_73916_E = 18;
            }

            if(this.selectSkydimension == 1 && this.field_73916_E == 25) {
               this.field_73916_E = 26;
            }

            if(this.selectSkydimension == 2 && this.field_73916_E == 25) {
               this.field_73916_E = 27;
            }

            EnumGameType var8 = EnumGameType.func_77142_a(this.field_73927_m);
            WorldSettings var6 = new WorldSettings(var2, var8, this.field_73925_n, this.field_73933_r, WorldType.field_77139_a[this.field_73916_E]);
            if(this.selectIndev2 == 1 && this.field_73916_E == 17) {
               var6.func_82750_a("2");
            } else if(this.selectIndev2 == 2 && this.field_73916_E == 17) {
               var6.func_82750_a("3");
            } else if(this.selectIndev2 == 3 && this.field_73916_E == 17) {
               var6.func_82750_a("4");
            } else if(this.selectIndev2 == 4 && this.field_73916_E == 17) {
               var6.func_82750_a("5");
            } else if(this.selectIndev2 == 1 && this.field_73916_E == 18) {
               var6.func_82750_a("2");
            } else if(this.selectIndev2 == 2 && this.field_73916_E == 18) {
               var6.func_82750_a("3");
            } else if(this.selectIndev2 == 3 && this.field_73916_E == 18) {
               var6.func_82750_a("4");
            } else if(this.selectIndev2 == 4 && this.field_73916_E == 18) {
               var6.func_82750_a("5");
            } else if(this.selectInfdev == 0 && this.field_73916_E == 16) {
               var6.func_82750_a("1");
            } else if(this.selectInfdev == 1 && this.field_73916_E == 16) {
               var6.func_82750_a("2");
            } else if(this.selectIsland == 0 && this.field_73916_E == 21) {
               var6.func_82750_a("1");
            } else if(this.selectIsland == 1 && this.field_73916_E == 21) {
               var6.func_82750_a("2");
            } else if(this.selectIsland == 2 && this.field_73916_E == 21) {
               var6.func_82750_a("3");
            } else if(this.selectIsland == 3 && this.field_73916_E == 21) {
               var6.func_82750_a("4");
            } else if(this.selectIsland == 4 && this.field_73916_E == 21) {
               var6.func_82750_a("5");
            } else if(this.selectSkyland == 0 && this.field_73916_E == 22) {
               var6.func_82750_a("1");
            } else if(this.selectSkyland == 1 && this.field_73916_E == 22) {
               var6.func_82750_a("2");
            } else if(this.selectSkyland == 2 && this.field_73916_E == 22) {
               var6.func_82750_a("3");
            } else if(this.selectSkyland == 3 && this.field_73916_E == 22) {
               var6.func_82750_a("4");
            } else if(this.selectSkyland == 4 && this.field_73916_E == 22) {
               var6.func_82750_a("5");
            } else if(this.selectCave == 1 && this.field_73916_E == 28) {
               var6.func_82750_a("1");
            } else if(this.selectCave == 2 && this.field_73916_E == 28) {
               var6.func_82750_a("2");
            } else if(this.selectCave == 3 && this.field_73916_E == 28) {
               var6.func_82750_a("3");
            } else if(this.selectSkyBlock == 0 && this.field_73916_E == 23) {
               var6.func_82750_a("1");
            } else if(this.selectSkyBlock == 1 && this.field_73916_E == 23) {
               var6.func_82750_a("2");
            } else if(this.selectSkyBlock == 2 && this.field_73916_E == 23) {
               var6.func_82750_a("3");
            }

            if(this.field_73916_E == 1 || this.field_73916_E == 10 || this.field_73916_E == 11) {
               var6.func_82750_a(this.field_82290_a);
            }

            if(this.field_73934_q && !this.field_73933_r) {
               var6.func_77159_a();
            }

            if(this.field_73926_o && !this.field_73933_r) {
               var6.func_77166_b();
            }

            this.field_73882_e.func_71371_a(this.field_73918_d, this.field_73919_b.func_73781_b().trim(), var6);
         } else if(p_73875_1_.field_73741_f == 3) {
            this.func_82287_i();
         } else if(p_73875_1_.field_73741_f == 2) {
            if(this.field_73927_m.equals("survival")) {
               if(!this.field_73935_p) {
                  this.field_73926_o = false;
               }

               this.field_73933_r = false;
               this.field_73927_m = "hardcore";
               this.field_73933_r = true;
               this.field_73936_z.field_73742_g = false;
               this.field_73938_x.field_73742_g = false;
               this.func_73914_h();
            } else if(this.field_73927_m.equals("hardcore")) {
               if(!this.field_73935_p) {
                  this.field_73926_o = true;
               }

               this.field_73933_r = false;
               this.field_73927_m = "creative";
               this.func_73914_h();
               this.field_73933_r = false;
               this.field_73936_z.field_73742_g = true;
               this.field_73938_x.field_73742_g = true;
            } else {
               if(!this.field_73935_p) {
                  this.field_73926_o = false;
               }

               this.field_73927_m = "survival";
               this.func_73914_h();
               this.field_73936_z.field_73742_g = true;
               this.field_73938_x.field_73742_g = true;
               this.field_73933_r = false;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 4) {
            this.field_73925_n = !this.field_73925_n;
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 7) {
            this.field_73934_q = !this.field_73934_q;
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 5) {
            ++this.currentWorldtype;
            if(this.currentWorldtype > this.maxWorldtype) {
               this.currentWorldtype = 1;
            }

            ++this.field_73916_E;
            if(this.field_73916_E >= WorldType.field_77139_a.length) {
               this.field_73916_E = 0;
            }

            while(WorldType.field_77139_a[this.field_73916_E] == null || !WorldType.field_77139_a[this.field_73916_E].func_77126_d()) {
               ++this.field_73916_E;
               if(this.field_73916_E >= WorldType.field_77139_a.length) {
                  this.field_73916_E = 0;
               }
            }

            if(this.field_73916_E != 0 && this.field_73916_E != 2) {
               this.field_82290_a = "";
            } else {
               this.field_82290_a = "1&Shrubland=true;Savanna=true;Desert=true;Swampland=true;Jungle=true;RainForest=true;Grassland=true;Taiga=true;Pines=true;Forest Lakes=true;Forest Hills=true;Forest=true;Plains=true;Snow Hills=true;Snow Plains=true;Snow Taiga=true;Snow Forest=true;Snow Pines=true;Beach Dunes=true;Beach=true;Mushroom Island=true;Jungle Island=true;Tropical Island=true;Ocean=true";
            }

            this.func_73914_h();
            this.func_82288_a(this.field_73931_t);
         } else if(p_73875_1_.field_73741_f == 6) {
            this.field_73935_p = true;
            this.field_73926_o = !this.field_73926_o;
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 8) {
            this.field_73882_e.func_71373_a(new GuiCreateFlatWorld(this, this.field_82290_a));
         } else if(p_73875_1_.field_73741_f == 9) {
            if(this.selectDefault == 0) {
               this.selectDefault = 1;
            } else {
               this.selectDefault = 0;
            }

            this.func_82288_a(this.field_73931_t);
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 10) {
            if(this.selectLargeBiomes == 0) {
               this.selectLargeBiomes = 1;
            } else {
               this.selectLargeBiomes = 0;
            }

            this.func_82288_a(this.field_73931_t);
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 11) {
            if(this.selectBeta == 0) {
               this.selectBeta = 1;
            } else {
               this.selectBeta = 0;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 12) {
            if(this.selectInfdev == 0) {
               this.selectInfdev = 1;
            } else {
               this.selectInfdev = 0;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 13) {
            if(this.selectIndev1 == 0) {
               this.selectIndev1 = 1;
            } else {
               this.selectIndev1 = 0;
            }

            this.func_82288_a(this.field_73931_t);
            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 14) {
            if(this.selectIsland == 0) {
               this.selectIsland = 3;
            } else {
               this.selectIsland = 0;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 15) {
            if(this.selectSkyland == 0) {
               this.selectSkyland = 2;
            } else if(this.selectSkyland == 2) {
               this.selectSkyland = 3;
            } else {
               this.selectSkyland = 0;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 16) {
            if(this.selectSkydimension == 0) {
               this.selectSkydimension = 1;
            } else {
               this.selectSkydimension = 0;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 17) {
            if(this.selectIndev2 == 0) {
               this.selectIndev2 = 1;
            } else if(this.selectIndev2 == 1) {
               this.selectIndev2 = 2;
            } else if(this.selectIndev2 == 2) {
               this.selectIndev2 = 3;
            } else if(this.selectIndev2 == 3) {
               this.selectIndev2 = 4;
            } else {
               this.selectIndev2 = 0;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 18) {
            if(this.selectCave == 0) {
               this.selectCave = 1;
            } else if(this.selectCave == 1) {
               this.selectCave = 2;
            } else {
               this.selectCave = 0;
            }

            this.func_73914_h();
         } else if(p_73875_1_.field_73741_f == 19) {
            this.field_73882_e.func_71373_a(new BWG4GuiDefault(this, this.field_82290_a));
         } else if(p_73875_1_.field_73741_f == 20) {
            this.field_73882_e.func_71373_a(new BWG4GuiDefault(this, this.field_82290_a));
         } else if(p_73875_1_.field_73741_f == 21) {
            if(this.selectSkyBlock == 0) {
               this.selectSkyBlock = 1;
            } else if(this.selectSkyBlock == 1) {
               this.selectSkyBlock = 0;
            } else {
               this.selectSkyBlock = 0;
            }

            this.func_73914_h();
         }
      }

   }

   private void func_82287_i() {
      this.func_82288_a(!this.field_73931_t);
   }

   private void func_82288_a(boolean p_82288_1_) {
      this.field_73931_t = p_82288_1_;
      this.field_73930_u.field_73748_h = !this.field_73931_t;
      this.field_73928_w.field_73748_h = this.field_73931_t;
      this.field_73938_x.field_73748_h = this.field_73931_t;
      this.field_73937_y.field_73748_h = this.field_73931_t;
      this.field_73936_z.field_73748_h = this.field_73931_t;
      this.field_82289_B.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.field_77138_c;
      this.buttonDefault.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.field_77137_b;
      this.buttonCustomDefault1.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.field_77137_b && this.selectDefault == 1;
      this.buttonLargeBiomes.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.field_77135_d;
      this.buttonCustomDefault2.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.field_77135_d && this.selectLargeBiomes == 1;
      this.buttonBeta.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4BETA1;
      this.buttonInfdev.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4INFDEV;
      this.buttonIndev1.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4INDEV1;
      this.buttonIndev2.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4INDEV1;
      this.buttonIsland.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4ISLAND;
      this.buttonSkyland.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4SKYLAND;
      this.buttonSkydimension.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4SKY1;
      this.buttonCave.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4CAVE;
      this.buttonSkyBlock.field_73748_h = this.field_73931_t && WorldType.field_77139_a[this.field_73916_E] == WorldType.BWG4SKYBLOCK;
      StringTranslate var2;
      if(this.field_73931_t) {
         var2 = StringTranslate.func_74808_a();
         this.field_73929_v.field_73744_e = var2.func_74805_b("gui.done");
      } else {
         var2 = StringTranslate.func_74808_a();
         this.field_73929_v.field_73744_e = var2.func_74805_b("selectWorld.moreWorldOptions");
      }

   }

   protected void func_73869_a(char p_73869_1_, int p_73869_2_) {
      if(this.field_73919_b.func_73806_l() && !this.field_73931_t) {
         this.field_73919_b.func_73802_a(p_73869_1_, p_73869_2_);
         this.field_73915_D = this.field_73919_b.func_73781_b();
      } else if(this.field_73921_c.func_73806_l() && this.field_73931_t) {
         this.field_73921_c.func_73802_a(p_73869_1_, p_73869_2_);
         this.field_73923_C = this.field_73921_c.func_73781_b();
      }

      if(p_73869_1_ == 13) {
         this.func_73875_a((GuiButton)this.field_73887_h.get(0));
      }

      ((GuiButton)this.field_73887_h.get(0)).field_73742_g = this.field_73919_b.func_73781_b().length() > 0;
      this.func_73912_g();
   }

   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
      super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
      if(this.field_73931_t) {
         this.field_73921_c.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      } else {
         this.field_73919_b.func_73793_a(p_73864_1_, p_73864_2_, p_73864_3_);
      }

   }

   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
      StringTranslate var4 = StringTranslate.func_74808_a();
      this.func_73873_v_();
      this.func_73732_a(this.field_73886_k, var4.func_74805_b("selectWorld.create"), this.field_73880_f / 2, 20, 16777215);
      if(this.field_73931_t) {
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.enterSeed"), this.field_73880_f / 2 - 100, 47, 10526880);
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.seedInfo"), this.field_73880_f / 2 - 100, 85, 10526880);
         this.field_73921_c.func_73795_f();
         this.func_73731_b(this.field_73886_k, "(" + this.currentWorldtype + "/" + this.maxWorldtype + ")", this.field_73880_f / 2 + 120, 90, 10526880);
      } else {
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.enterName"), this.field_73880_f / 2 - 100, 47, 10526880);
         this.func_73731_b(this.field_73886_k, var4.func_74805_b("selectWorld.resultFolder") + " " + this.field_73918_d, this.field_73880_f / 2 - 100, 85, 10526880);
         this.field_73919_b.func_73795_f();
         this.func_73731_b(this.field_73886_k, this.field_73920_A, this.field_73880_f / 2 - 100, 137, 10526880);
         this.func_73731_b(this.field_73886_k, this.field_73922_B, this.field_73880_f / 2 - 100, 149, 10526880);
      }

      super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
   }

   public void func_82286_a(WorldInfo p_82286_1_) {
      this.field_73915_D = StatCollector.func_74837_a("selectWorld.newWorld.copyOf", new Object[]{p_82286_1_.func_76065_j()});
      this.field_73923_C = p_82286_1_.func_76063_b() + "";
      this.field_73916_E = p_82286_1_.func_76067_t().func_82747_f();
      this.field_82290_a = p_82286_1_.func_82571_y();
      this.field_73925_n = p_82286_1_.func_76089_r();
      this.field_73926_o = p_82286_1_.func_76086_u();
      if(this.field_73916_E == 10) {
         this.selectDefault = 1;
         this.field_73916_E = 0;
      } else if(this.field_73916_E == 11) {
         this.selectLargeBiomes = 1;
         this.field_73916_E = 2;
      } else if(this.field_73916_E == 13) {
         this.selectBeta = 1;
         this.field_73916_E = 12;
      } else if(this.field_73916_E == 14) {
         this.selectBeta = 2;
         this.field_73916_E = 12;
      } else if(this.field_73916_E == 18) {
         this.selectIndev1 = 1;
         this.field_73916_E = 17;
      } else if(this.field_73916_E == 26) {
         this.selectSkydimension = 1;
         this.field_73916_E = 25;
      } else if(this.field_73916_E == 27) {
         this.selectSkydimension = 2;
         this.field_73916_E = 25;
      }

      int var2 = 1;

      for(int var3 = 0; var3 < WorldType.field_77139_a.length; ++var3) {
         if(WorldType.field_77139_a[var3] != null && WorldType.field_77139_a[var3].func_77126_d()) {
            if(var3 == this.field_73916_E) {
               this.currentWorldtype = var2;
            } else {
               ++var2;
            }
         }
      }

      if(p_82286_1_.func_76093_s()) {
         this.field_73927_m = "hardcore";
      } else if(p_82286_1_.func_76077_q().func_77144_e()) {
         this.field_73927_m = "survival";
      } else if(p_82286_1_.func_76077_q().func_77145_d()) {
         this.field_73927_m = "creative";
      }

   }

}
