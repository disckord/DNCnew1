package net.minecraft.src;

class BWG4GuiDefaultList extends GuiSlot
{
    final BWG4GuiDefault bwg4guidefault;
    public int selected;

    public BWG4GuiDefaultList(BWG4GuiDefault var1)
    {
        super(var1.mc, var1.width, var1.height, 43, var1.height - 60, 24);
        this.bwg4guidefault = var1;
        this.selected = -1;
    }

    /**
     * Gets the size of the current slot list.
     */
    protected int getSize()
    {
        return BWG4GuiDefault.getBiomeArray(this.bwg4guidefault).theBiomesList().size();
    }

    /**
     * the element in the slot that was clicked, boolean for wether it was double clicked or not
     */
    protected void elementClicked(int var1, boolean var2)
    {
        this.selected = var1;
        this.bwg4guidefault.setButtons();
    }

    /**
     * returns true if the element passed in is currently selected
     */
    protected boolean isSelected(int var1)
    {
        return var1 == this.selected;
    }

    protected void drawBackground() {}

    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5)
    {
        BWG4BiomeInfo var6 = (BWG4BiomeInfo)BWG4GuiDefault.getBiomeArray(this.bwg4guidefault).theBiomesList().get(BWG4GuiDefault.getBiomeArray(this.bwg4guidefault).theBiomesList().size() - var1 - 1);
        String var7 = var6.getNAME();
        boolean var8 = var6.getEnabled();

        if (var8)
        {
            this.bwg4guidefault.fontRenderer.drawString(var7, var2 + 1, var3 + 7, 16777215);
            this.bwg4guidefault.fontRenderer.drawString("YES", var2 + 179, var3 + 7, 16777215);
        }
        else
        {
            this.bwg4guidefault.fontRenderer.drawString(var7, var2 + 1, var3 + 7, 10526880);
            this.bwg4guidefault.fontRenderer.drawString("NO", var2 + 182, var3 + 7, 10526880);
        }
    }

    protected int getScrollBarX()
    {
        return this.bwg4guidefault.width - 70;
    }
}
