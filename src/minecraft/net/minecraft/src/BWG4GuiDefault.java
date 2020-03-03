package net.minecraft.src;

public class BWG4GuiDefault extends GuiScreen
{
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

    public BWG4GuiDefault(GuiCreateWorld var1, String var2)
    {
        this.createWorldGui = var1;
        this.setGeneratorInfo(var2);
        this.customize = false;
    }

    public String getGeneratorInfo()
    {
        return this.theDefaultGeneratorInfo.toString();
    }

    public void setGeneratorInfo(String var1)
    {
        this.theDefaultGeneratorInfo = BWG4DefaultGeneratorInfo.FromString(var1);
    }

    static BWG4DefaultGeneratorInfo getBiomeArray(BWG4GuiDefault var0)
    {
        return var0.theDefaultGeneratorInfo;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.buttonList.clear();
        this.bwg4guidefaultlist = new BWG4GuiDefaultList(this);
        this.buttonList.add(new GuiButton(0, this.width / 2 - 155, this.height - 28, 100, 20, StatCollector.translateToLocal("gui.done")));
        this.buttonList.add(new GuiButton(1, this.width / 2 - 50, this.height - 28, 100, 20, StatCollector.translateToLocal("gui.cancel")));
        this.buttonList.add(this.buttonEnable = new GuiButton(2, this.width / 2 - 155, this.height - 52, 100, 20, "Enable/Disable"));
        this.buttonList.add(this.buttonAll = new GuiButton(3, this.width / 2 - 50, this.height - 52, 100, 20, "Disable All"));
        this.buttonList.add(this.buttonBiome = new GuiButton(4, this.width / 2 + 55, this.height - 52, 100, 20, "-"));
        this.buttonList.add(this.buttonSetting = new GuiButton(5, this.width / 2 + 55, this.height - 28, 100, 20, "-"));
        this.setButtons();
        this.switchScreen();
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton var1)
    {
        int var2 = this.theDefaultGeneratorInfo.theBiomesList().size() - this.bwg4guidefaultlist.selected - 1;

        if (var1.id == 0)
        {
            this.createWorldGui.generatorOptionsToUse = this.getGeneratorInfo();
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (var1.id == 1)
        {
            this.createWorldGui.generatorOptionsToUse = this.getGeneratorInfo();
            this.mc.displayGuiScreen(this.createWorldGui);
        }
        else if (var1.id == 2)
        {
            BWG4BiomeInfo var3 = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(this.theDefaultGeneratorInfo.theBiomesList().size() - this.bwg4guidefaultlist.selected - 1);

            if (var3.getEnabled())
            {
                var3.setEnabled(false);
            }
            else
            {
                var3.setEnabled(true);
            }
        }
        else if (var1.id == 3)
        {
            BWG4BiomeInfo var4;
            int var5;

            if (!this.all)
            {
                for (var5 = 0; var5 < this.theDefaultGeneratorInfo.theBiomesList().size(); ++var5)
                {
                    var4 = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(var5);
                    var4.setEnabled(false);
                }

                this.all = true;
            }
            else
            {
                for (var5 = 0; var5 < this.theDefaultGeneratorInfo.theBiomesList().size(); ++var5)
                {
                    var4 = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(var5);
                    var4.setEnabled(true);
                }

                this.all = false;
            }

            this.updateButtons();
        }
        else if (var1.id == 4)
        {
            this.biome = (BWG4BiomeInfo)this.theDefaultGeneratorInfo.theBiomesList().get(this.theDefaultGeneratorInfo.theBiomesList().size() - this.bwg4guidefaultlist.selected - 1);
            this.customize = false;
            this.biomescreen = true;
            this.switchScreen();
        }
        else if (var1.id == 5)
        {
            if (this.biomescreen)
            {
                this.biomescreen = false;
                this.customize = false;
            }
            else if (this.customize)
            {
                this.customize = false;
            }
            else
            {
                this.customize = true;
            }

            this.switchScreen();
        }
    }

    public void updateButtons()
    {
        if (this.all)
        {
            this.buttonAll.displayString = "Enable All";
        }
        else
        {
            this.buttonAll.displayString = "Disable All";
        }
    }

    public void setButtons()
    {
        boolean var1 = this.checkPossible();
        this.buttonEnable.enabled = var1;
        this.buttonBiome.enabled = false;
        this.buttonSetting.enabled = false;
    }

    private boolean checkPossible()
    {
        return this.bwg4guidefaultlist.selected > -1 && this.bwg4guidefaultlist.selected < this.theDefaultGeneratorInfo.theBiomesList().size();
    }

    public void switchScreen()
    {
        if (this.customize)
        {
            this.buttonEnable.drawButton = false;
            this.buttonAll.drawButton = false;
            this.buttonBiome.drawButton = false;
            this.buttonSetting.displayString = "-";
        }
        else if (this.biomescreen)
        {
            this.buttonEnable.drawButton = false;
            this.buttonAll.drawButton = false;
            this.buttonBiome.drawButton = false;
            this.buttonSetting.displayString = "-";
        }
        else
        {
            this.buttonEnable.drawButton = true;
            this.buttonAll.drawButton = true;
            this.buttonBiome.drawButton = true;
            this.buttonSetting.displayString = "-";
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int var1, int var2, float var3)
    {
        this.drawDefaultBackground();

        if (this.customize)
        {
            this.drawCenteredString(this.fontRenderer, "World Settings", this.width / 2, 8, 16777215);
        }
        else if (this.biomescreen)
        {
            this.drawCenteredString(this.fontRenderer, "Biome: " + this.biome.getNAME(), this.width / 2, 8, 16777215);
        }
        else
        {
            this.bwg4guidefaultlist.drawScreen(var1, var2, var3);
            this.drawCenteredString(this.fontRenderer, "Biome List", this.width / 2, 8, 16777215);
            this.drawCenteredString(this.fontRenderer, "Biome Name", this.width / 2 - 80, 32, 16777215);
            this.drawCenteredString(this.fontRenderer, "Enabled", this.width / 2 + 80, 32, 16777215);
        }

        super.drawScreen(var1, var2, var3);
    }
}
