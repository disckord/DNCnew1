package net.minecraft.src;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import net.minecraft.client.Minecraft;
import org.lwjgl.Sys;

public class GuiShaders extends GuiScreen
{
    protected GuiScreen parentGui;
    private int updateTimer = -1;
    public boolean needReinit;
    private GuiSlotShaders shaderList;

    public GuiShaders(GuiScreen var1, GameSettings var2)
    {
        this.parentGui = var1;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        if (Shaders.shadersConfig == null)
        {
            Shaders.loadConfig();
        }

        this.buttonList.add(new GuiSmallButton(9, this.width / 2 + 36, 30, "Cloud shadow: " + Shaders.configCloudShadow));
        this.buttonList.add(new GuiSmallButton(4, this.width / 2 + 36, 54, "New block breaking: " + Shaders.dtweak));
        this.buttonList.add(new GuiSmallButton(10, this.width / 2 + 36, 78, "Hand depth: " + Shaders.configHandDepthMul));
        this.buttonList.add(new GuiSmallButton(5, this.width / 4 - 64, this.height - 55, "Open shaderpacks folder"));
        this.buttonList.add(new GuiSmallButton(6, this.width / 2 + 36, this.height - 25, "Done"));
        this.shaderList = new GuiSlotShaders(this);
        this.shaderList.registerScrollButtons(this.buttonList, 7, 8);
        this.needReinit = false;
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton var1)
    {
        if (var1.enabled)
        {
            switch (var1.id)
            {
                case 4:
                    Shaders.dtweak = !Shaders.dtweak;
                    var1.displayString = "New block breaking: " + Shaders.dtweak;
                    break;

                case 5:
                    if (Minecraft.getOs() == EnumOS.MACOS)
                    {
                        try
                        {
                            Runtime.getRuntime().exec(new String[] {"/usr/bin/open", Shaders.shaderpacksdir.getAbsolutePath()});
                            return;
                        }
                        catch (IOException var8)
                        {
                            var8.printStackTrace();
                        }
                    }
                    else if (Minecraft.getOs() == EnumOS.WINDOWS)
                    {
                        String var9 = String.format("cmd.exe /C start \"Open file\" \"%s\"", new Object[] {Shaders.shaderpacksdir.getAbsolutePath()});

                        try
                        {
                            Runtime.getRuntime().exec(var9);
                            return;
                        }
                        catch (IOException var7)
                        {
                            var7.printStackTrace();
                        }
                    }

                    boolean var10 = false;

                    try
                    {
                        Class var3 = Class.forName("java.awt.Desktop");
                        Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                        var3.getMethod("browse", new Class[] {URI.class}).invoke(var4, new Object[] {(new File(Minecraft.getMinecraftDir(), Shaders.shaderpacksdirname)).toURI()});
                    }
                    catch (Throwable var6)
                    {
                        var6.printStackTrace();
                        var10 = true;
                    }

                    if (var10)
                    {
                        System.out.println("Opening via system class!");
                        Sys.openURL("file://" + Shaders.shaderpacksdir.getAbsolutePath());
                    }

                    break;

                case 6:
                    new File(Shaders.shadersdir, "current.cfg");

                    try
                    {
                        Shaders.storeConfig();
                    }
                    catch (Exception var5)
                    {
                        ;
                    }

                    if (this.needReinit)
                    {
                        this.needReinit = false;
                        Shaders.loadShaderPack();
                        Shaders.uninit();
                        this.mc.renderGlobal.loadRenderers();
                    }

                    this.mc.displayGuiScreen(this.parentGui);
                    break;

                case 7:
                case 8:
                default:
                    this.shaderList.actionPerformed(var1);
                    break;

                case 9:
                    Shaders.configCloudShadow = !Shaders.configCloudShadow;
                    var1.displayString = "Cloud shadow: " + Shaders.configCloudShadow;
                    break;

                case 10:
                    float var2 = Shaders.configHandDepthMul / 2.0F;

                    if (var2 < 0.0625F)
                    {
                        var2 = 1.0F;
                    }

                    Shaders.configHandDepthMul = var2;
                    var1.displayString = "Hand depth: " + Shaders.configHandDepthMul;
            }
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int var1, int var2, float var3)
    {
        this.shaderList.drawScreen(var1, var2, var3);

        if (this.updateTimer <= 0)
        {
            this.shaderList.updateList();
            this.updateTimer += 20;
        }

        this.drawCenteredString(this.fontRenderer, "Shaders ", this.width / 2, 16, 16777215);
        this.drawCenteredString(this.fontRenderer, " v" + Shaders.versiontostring(1014502), this.width - 30, 10, 8421504);
        this.drawCenteredString(this.fontRenderer, "( Place zipped Shader files here. )", this.width / 4 + 10, this.height - 26, 8421504);
        super.drawScreen(var1, var2, var3);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        super.updateScreen();
        --this.updateTimer;
    }
}
