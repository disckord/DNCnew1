package net.minecraft.src;

import java.util.ArrayList;

class GuiSlotShaders extends GuiSlot
{
    private ArrayList shaderslist;
    final GuiShaders shadersGui;

    public GuiSlotShaders(GuiShaders var1)
    {
        super(var1.mc, var1.width / 2 + 20, var1.height, 32, var1.height - 60, 18);
        this.shadersGui = var1;
        this.shaderslist = Shaders.listofShaders();
    }

    public void updateList()
    {
        this.shaderslist = Shaders.listofShaders();
    }

    /**
     * Gets the size of the current slot list.
     */
    protected int getSize()
    {
        return this.shaderslist.size();
    }

    /**
     * the element in the slot that was clicked, boolean for wether it was double clicked or not
     */
    protected void elementClicked(int var1, boolean var2)
    {
        Shaders.setShaderPack((String)this.shaderslist.get(var1));
        this.shadersGui.needReinit = false;
        Shaders.loadShaderPack();
        Shaders.uninit();
        this.shadersGui.mc.renderGlobal.loadRenderers();
    }

    /**
     * returns true if the element passed in is currently selected
     */
    protected boolean isSelected(int var1)
    {
        return ((String)this.shaderslist.get(var1)).equals(Shaders.currentshadername);
    }

    /**
     * return the height of the content being scrolled
     */
    protected int getContentHeight()
    {
        return this.getSize() * 18;
    }

    protected void drawBackground()
    {
        this.shadersGui.drawDefaultBackground();
    }

    protected void drawSlot(int var1, int var2, int var3, int var4, Tessellator var5)
    {
        this.shadersGui.drawCenteredString(this.shadersGui.fontRenderer, (String)this.shaderslist.get(var1), this.shadersGui.width / 4 + 10, var3 + 1, 16777215);
    }
}
