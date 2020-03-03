package net.minecraft.src;

public class GuiPerkOptions extends GuiScreen
{
    /**
     * An array of options that can be changed directly from the options GUI.
     */
    private static final EnumOptions[] relevantOptions = new EnumOptions[] {EnumOptions.FPPERKS, EnumOptions.PERKSOUND};

    /**
     * A reference to the screen object that created this. Used for navigating between screens.
     */
    private final GuiScreen parentScreen;

    /** Reference to the GameSettings object. */
    private final GameSettings options;

    /** The title string that is displayed in the top-center of the screen. */
    protected String screenTitle = "Perk Options";

    public GuiPerkOptions(GuiScreen par1GuiScreen, GameSettings par2GameSettings)
    {
        this.parentScreen = par1GuiScreen;
        this.options = par2GameSettings;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        StringTranslate var1 = StringTranslate.getInstance();
        int var2 = 0;
        this.screenTitle = "Perk Options";
        EnumOptions[] var3 = relevantOptions;
        int var4 = var3.length;
        int var5;
        int var7;
        for (var5 = 0; var5 < var4; ++var5)
        {
            EnumOptions var6 = var3[var5];
            var7 = this.width / 2 - 155 + var5 % 2 * 160;
            int var8 = this.height / 6 + 21 * (var5 / 2) - 10;

            if (var6.getEnumFloat())
            {
                this.buttonList.add(new GuiSlider(var6.returnEnumOrdinal(), var7, var8, var6, this.options.getKeyBinding(var6), this.options.getOptionFloatValue(var6)));
            }
            else
            {
            	//System.out.println(var6.returnEnumOrdinal());
                this.buttonList.add(new GuiSmallButton(var6.returnEnumOrdinal(), var7, var8, var6, this.options.getKeyBinding(var6)));
            }

            ++var2;
        }

      
     
    	  
      
        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168, var1.translateKey("gui.done")));
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.enabled)
        {
        	 if (par1GuiButton.id < 100 && par1GuiButton instanceof GuiSmallButton)
             {
                 this.options.setOptionValue(((GuiSmallButton)par1GuiButton).returnEnumOptions(), 1);
                 par1GuiButton.displayString = this.options.getKeyBinding(EnumOptions.getEnumOptions(par1GuiButton.id));
             }
            if (par1GuiButton.id == 200)
            {
                this.mc.gameSettings.saveOptions();
                this.mc.displayGuiScreen(this.parentScreen);
            }

        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRenderer, this.screenTitle, this.width / 2, 15, 16777215);
        super.drawScreen(par1, par2, par3);
    }
}
