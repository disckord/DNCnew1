package net.minecraft.src;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import net.minecraft.client.Minecraft;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.ARBFragmentShader;
import org.lwjgl.opengl.ARBShaderObjects;
import org.lwjgl.opengl.ARBVertexProgram;
import org.lwjgl.opengl.ARBVertexShader;
import org.lwjgl.opengl.ContextCapabilities;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GLContext;
import org.lwjgl.util.glu.GLU;

public class Shaders
{
    public static boolean isInitialized = false;
    private static int renderDisplayWidth = 0;
    private static int renderDisplayHeight = 0;
    public static int renderWidth = 0;
    public static int renderHeight = 0;
    private static Minecraft mc = null;
    public static boolean isRenderingWorld = false;
    public static boolean isRenderingSky = false;
    public static boolean isCompositeRendered = false;
    public static boolean isRenderingDfb = false;
    public static boolean isShadowPass = false;
    private static float[] sunPosition = new float[3];
    private static float[] moonPosition = new float[3];
    private static float[] clearColor = new float[3];
    private static long worldTime = 0L;
    private static long lastWorldTime = 0L;
    private static long diffWorldTime = 0L;
    private static float sunAngle = 0.0F;
    private static float shadowAngle = 0.0F;
    private static float rainStrength = 0.0F;
    private static float wetness = 0.0F;
    public static float wetnessHalfLife = 600.0F;
    public static float drynessHalfLife = 200.0F;
    private static boolean usewetness = false;
    private static int isEyeInWater = 0;
    private static int eyeBrightness = 0;
    private static float eyeBrightnessFadeX = 0.0F;
    private static float eyeBrightnessFadeY = 0.0F;
    private static float eyePosY = 0.0F;
    private static boolean lightmapEnabled = false;
    private static boolean fogEnabled = true;
    public static int entityAttrib = -1;
    public static boolean useEntityHurtFlash;
    public static int uniformEntityHurt = -1;
    public static int uniformEntityFlash = -1;
    private static FloatBuffer previousProjection = BufferUtils.createFloatBuffer(16);
    private static FloatBuffer projection = BufferUtils.createFloatBuffer(16);
    private static FloatBuffer projectionInverse = null;
    private static FloatBuffer previousModelView = null;
    private static FloatBuffer modelView = null;
    private static FloatBuffer modelViewInverse = null;
    private static double[] previousCameraPosition = new double[3];
    private static double[] cameraPosition = new double[3];
    private static int shadowPassInterval = 0;
    private static int shadowMapWidth = 4096;
    private static int shadowMapHeight = 4096;
    private static float shadowMapFOV = 90.0F;
    private static float shadowMapHalfPlane = 160.0F;
    private static boolean shadowMapIsOrtho = true;
    private static int gbufferFormat_gdepth = 6408;
    private static int gbufferFormat_gaux4 = 6408;
    private static int gbufferFormat_gnormal = 6408;
    private static int shadowPassCounter = 0;
    private static int preShadowPassThirdPersonView;
    public static boolean shouldSkipDefaultShadow = false;
    private static int sfb = 0;
    private static int sfbColorTexture = 0;
    private static int sfbDepthTexture = 0;
    private static int sfbWaterDepthTexture = 0;
    private static int sfbRenderBuffer = 0;
    private static int sfbDepthBuffer = 0;
    private static FloatBuffer shadowProjection = null;
    private static FloatBuffer shadowProjectionInverse = null;
    private static FloatBuffer shadowModelView = null;
    private static FloatBuffer shadowModelViewInverse = null;
    private static final int MaxColorBuffers = 8;
    private static final int MaxDrawBuffers = 8;
    private static int usedColorBuffers = 0;
    private static int usedColorAttachs = 0;
    private static int usedDrawBuffers = 0;
    private static IntBuffer dfbDrawBuffers = null;
    private static IntBuffer dfbTextures = null;
    private static IntBuffer drawBuffersLast = null;
    private static IntBuffer drawBuffersAll = null;
    private static IntBuffer drawBuffersClear0 = null;
    private static IntBuffer drawBuffersClear1 = null;
    private static IntBuffer drawBuffersClearColor = null;
    private static int dfb = 0;
    private static int dfbDepthTexture = 0;
    public static int activeProgram = 0;
    public static final int ProgramNone = 0;
    public static final int ProgramBasic = 1;
    public static final int ProgramTextured = 2;
    public static final int ProgramTexturedLit = 3;
    public static final int ProgramSkyBasic = 4;
    public static final int ProgramSkyTextured = 5;
    public static final int ProgramTerrain = 6;
    public static final int ProgramEntities = 7;
    public static final int ProgramHand = 8;
    public static final int ProgramWater = 9;
    public static final int ProgramWeather = 10;
    public static final int ProgramComposite = 11;
    public static final int ProgramComposite1 = 12;
    public static final int ProgramComposite2 = 13;
    public static final int ProgramComposite3 = 14;
    public static final int ProgramComposite4 = 15;
    public static final int ProgramComposite5 = 16;
    public static final int ProgramComposite6 = 17;
    public static final int ProgramComposite7 = 18;
    public static final int ProgramFinal = 19;
    public static final int ProgramCount = 20;
    public static final int MaxCompositePasses = 8;
    private static final String[] programNames = new String[] {"", "gbuffers_basic", "gbuffers_textured", "gbuffers_textured_lit", "gbuffers_skybasic", "gbuffers_skytextured", "gbuffers_terrain", "gbuffers_entities", "gbuffers_hand", "gbuffers_water", "gbuffers_weather", "composite", "composite1", "composite2", "composite3", "composite4", "composite5", "composite6", "composite7", "final"};
    private static final int[] programBackups = new int[] {0, 0, 1, 2, 1, 2, 3, 3, 3, 6, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private static int[] programs = new int[20];
    private static int[] programsRef = new int[20];
    private static String newDrawBufSetting = null;
    private static String[] programsDrawBufSettings = new String[20];
    private static IntBuffer[] programsDrawBuffers = new IntBuffer[20];
    private static IntBuffer activeDrawBuffers = null;
    private static String newColorAtmSetting = null;
    private static String[] programsColorAtmSettings = new String[20];
    private static String activeColorAtmSettings = null;
    public static Properties loadedShaders = null;
    public static Properties shadersConfig = null;
    public static RenderEngine renderEngine = null;
    public static HashMap textureIdMap = new HashMap();
    public static HashMap textureIdByNameMap = new HashMap();
    public static HashMap textureIdByUrlMap = new HashMap();
    public static HashMap defaultTextureImageMap = new HashMap();
    public static BufferedImage defaultTextureImage_d = null;
    public static BufferedImage defaultTextureImage_n = null;
    public static BufferedImage defaultTextureImage_s = null;
    public static BufferedImage transparentImage = null;
    public static int[] defaultTextureIdArray = null;
    public static int[] terrainTextureIdArray = null;
    public static boolean normalMapEnabled = false;
    private static ByteBuffer tempDirectByteBuffer = null;
    private static IntBuffer tempDirectIntBuffer = null;
    public static boolean dtweak = false;
    public static boolean configCloudShadow = true;
    public static float configHandDepthMul = 0.125F;
    static IShaderPack shaderPack = null;
    static File currentshader;
    static String currentshadername;
    static String packNameNone = "(none)";
    static String packNameDefault = "(internal)";
    static String shaderpacksdirname = "shaderpacks";
    static String optionsfilename = "optionsshaders.txt";
    static File shadersdir = new File(Minecraft.getMinecraftDir(), "shaders");
    static File shaderpacksdir = new File(Minecraft.getMinecraftDir(), shaderpacksdirname);
    static File configFile = new File(Minecraft.getMinecraftDir(), optionsfilename);
    public static final boolean enableShadersOption = true;
    private static final boolean enableShadersDebug = true;
    static final String ofVersion = "OptiFine_1.5.2_HD_U_D2";
    public static final int version = 1014502;

    public static void loadConfig()
    {
        try
        {
            if (!shaderpacksdir.exists())
            {
                shaderpacksdir.mkdir();
            }
        }
        catch (Exception var3)
        {
            ;
        }

        shadersConfig = new Properties();
        shadersConfig.setProperty("shaderPack", "");
        FileReader var0;

        if (configFile.exists())
        {
            try
            {
                var0 = new FileReader(configFile);
                shadersConfig.load(var0);
                var0.close();
            }
            catch (Exception var2)
            {
                ;
            }
        }

        if (!configFile.exists())
        {
            try
            {
                storeConfig();
            }
            catch (Exception var1)
            {
                ;
            }
        }

        var0 = null;
        dtweak = Boolean.parseBoolean(shadersConfig.getProperty("dtweak", "false"));
        configCloudShadow = Boolean.parseBoolean(shadersConfig.getProperty("cloudShadow", "true"));
        configHandDepthMul = Float.parseFloat(shadersConfig.getProperty("handDepthMul", "0.125"));
        currentshadername = shadersConfig.getProperty("shaderPack", packNameDefault);
        loadShaderPack();
    }

    public static void storeConfig()
    {
        System.out.println("Shaders.storeConfig");
        shadersConfig.setProperty("dtweak", Boolean.toString(dtweak));
        shadersConfig.setProperty("cloudShadow", Boolean.toString(configCloudShadow));
        shadersConfig.setProperty("handDepthMul", Float.toString(configHandDepthMul));

        try
        {
            FileWriter var0 = new FileWriter(configFile);
            shadersConfig.store(var0, (String)null);
            var0.close();
        }
        catch (Exception var1)
        {
            ;
        }
    }

    public static void setShaderPack(String var0)
    {
        currentshadername = var0;
        shadersConfig.setProperty("shaderPack", var0);
    }

    public static void loadShaderPack()
    {
        if (shaderPack != null)
        {
            shaderPack.close();
            shaderPack = null;
        }

        String var0 = shadersConfig.getProperty("shaderPack", packNameDefault);

        if (!var0.isEmpty() && !var0.equals(packNameNone))
        {
            if (var0.equals(packNameDefault))
            {
                shaderPack = new ShaderPackDefault();
            }
            else
            {
                try
                {
                    File var1 = new File(shaderpacksdir, var0);

                    if (var1.isDirectory())
                    {
                        shaderPack = new ShaderPackFolder(var0, var1);
                    }
                    else if (var1.isFile() && var0.toLowerCase().endsWith(".zip"))
                    {
                        shaderPack = new ShaderPackZip(var0, var1);
                    }
                }
                catch (Exception var2)
                {
                    ;
                }
            }
        }

        if (shaderPack == null)
        {
            shaderPack = new ShaderPackNone();
        }
    }

    static ArrayList listofShaders()
    {
        ArrayList var0 = new ArrayList();
        var0.add(packNameNone);
        var0.add(packNameDefault);

        try
        {
            if (!shaderpacksdir.exists())
            {
                shaderpacksdir.mkdir();
            }

            File[] var1 = shaderpacksdir.listFiles();

            for (int var2 = 0; var2 < var1.length; ++var2)
            {
                File var3 = var1[var2];
                String var4 = var3.getName();

                if (var3.isDirectory() || var3.isFile() && var4.toLowerCase().endsWith(".zip"))
                {
                    var0.add(var4);
                }
            }
        }
        catch (Exception var5)
        {
            ;
        }

        return var0;
    }

    static String versiontostring(int var0)
    {
        String var1 = Integer.toString(var0);
        return Integer.toString(Integer.parseInt(var1.substring(1, 3))) + "." + Integer.toString(Integer.parseInt(var1.substring(3, 5))) + "." + Integer.toString(Integer.parseInt(var1.substring(5)));
    }

    static void checkOptifine()
    {
        try
        {
            System.out.println("[Shaders] Required OptiFine version : OptiFine_1.5.2_HD_U_D2");
            String var0 = (String)((String)Config.class.getDeclaredField("VERSION").get((Object)null));
            System.out.println("[Shaders] Detected OptiFine version : " + var0);

            if (var0.equals("OptiFine_1.5.2_HD_U_D2"))
            {
                System.out.println("[Shaders] ShadersMod loaded. version: " + versiontostring(1014502));
            }
            else
            {
                System.err.println("[Shaders] Wrong OptiFine version!");
                System.exit(-1);
            }
        }
        catch (Exception var1)
        {
            System.err.println("[Shaders] OptiFine missing or wrong version! Install OptiFine OptiFine_1.5.2_HD_U_D2 first and then the ShadersMod!");
            System.exit(-1);
        }
    }

    public static int checkGLError(String var0)
    {
        int var1 = GL11.glGetError();

        if (var1 != 0)
        {
            String var2 = "GL Error " + var1 + ": " + GLU.gluErrorString(var1) + " @" + var0;
            System.err.println(var2);
        }

        return var1;
    }

    public static int checkGLError(String var0, String var1)
    {
        int var2 = GL11.glGetError();

        if (var2 != 0)
        {
            String var3 = "GL Error " + var2 + ": " + GLU.gluErrorString(var2) + " @" + var0 + " " + var1;
            System.err.println(var3);
        }

        return var2;
    }

    public static void init()
    {
        if (!isInitialized)
        {
            mc = Minecraft.getMinecraft();
            checkGLError("Shaders.init pre");
            ContextCapabilities var0 = GLContext.getCapabilities();
            System.out.println("[Shaders] OpenGL 2.0 = " + var0.OpenGL20 + "    OpenGL 2.1 = " + var0.OpenGL21 + "    OpenGL 3.0 = " + var0.OpenGL30 + "    OpenGL 3.2 = " + var0.OpenGL32);

            if (!var0.OpenGL20)
            {
                printChatAndLogError("[Shaders] No OpenGL 2.0.");
            }

            if (!var0.OpenGL21)
            {
                printChatAndLogError("[Shaders] No OpenGL 2.1.");
            }

            if (!var0.GL_EXT_framebuffer_object)
            {
                printChatAndLogError("[Shaders] No EXT_framebuffer_object.");
            }

            if (!var0.OpenGL20 || !var0.GL_EXT_framebuffer_object)
            {
                System.out.println("[Shaders] Your GPU is not compatible with the Shaders mod.");
                System.exit(-1);
            }

            if (tempDirectByteBuffer == null)
            {
                tempDirectByteBuffer = ByteBuffer.allocateDirect(16);
                tempDirectIntBuffer = tempDirectByteBuffer.asIntBuffer();
            }

            if (dfbDrawBuffers == null)
            {
                dfbDrawBuffers = BufferUtils.createIntBuffer(8);
            }

            if (dfbTextures == null)
            {
                dfbTextures = BufferUtils.createIntBuffer(8);
            }

            int var1 = GL11.glGetInteger(GL20.GL_MAX_DRAW_BUFFERS);
            int var2 = GL11.glGetInteger(36063);
            System.out.println("[Shaders] GL_MAX_DRAW_BUFFERS = " + var1);
            System.out.println("[Shaders] GL_MAX_COLOR_ATTACHMENTS_EXT = " + var2);
            System.out.println("[Shaders] GL_MAX_TEXTURE_IMAGE_UNITS = " + GL11.glGetInteger(GL20.GL_MAX_TEXTURE_IMAGE_UNITS));
            usedColorBuffers = 4;
            usedColorAttachs = 1;
            usedDrawBuffers = 1;
            gbufferFormat_gdepth = 6408;
            gbufferFormat_gaux4 = 6408;
            gbufferFormat_gnormal = 6408;
            int var3;
            int var4;

            for (var3 = 0; var3 < 20; ++var3)
            {
                if (programNames[var3] == "")
                {
                    programs[var3] = programsRef[var3] = 0;
                    programsDrawBufSettings[var3] = null;
                    programsColorAtmSettings[var3] = null;
                }
                else
                {
                    newDrawBufSetting = null;
                    newColorAtmSetting = null;
                    var4 = setupProgram(var3, "/shaders/" + programNames[var3] + ".vsh", "/shaders/" + programNames[var3] + ".fsh");
                    programs[var3] = programsRef[var3] = var4;
                    programsDrawBufSettings[var3] = var4 != 0 ? newDrawBufSetting : null;
                    programsColorAtmSettings[var3] = var4 != 0 ? newColorAtmSetting : null;
                }
            }

            for (var3 = 0; var3 < 20; ++var3)
            {
                if (var3 == 19)
                {
                    programsDrawBuffers[var3] = null;
                }
                else if (programs[var3] == 0)
                {
                    programsDrawBuffers[var3] = dfbDrawBuffers;
                }
                else
                {
                    String var11 = programsDrawBufSettings[var3];

                    if (var11 != null)
                    {
                        IntBuffer var5 = BufferUtils.createIntBuffer(8);
                        int var6 = var11.length();

                        if (var6 > usedDrawBuffers)
                        {
                            usedDrawBuffers = var6;
                        }

                        if (var6 > var1)
                        {
                            var6 = var1;
                        }

                        programsDrawBuffers[var3] = var5;
                        var5.limit(usedColorBuffers);

                        for (int var7 = 0; var7 < var6; ++var7)
                        {
                            int var8 = 0;

                            if (var11.length() > var7)
                            {
                                char var9 = var11.charAt(var7);

                                if (var9 >= 48 && var9 <= 55)
                                {
                                    int var10 = var9 - 48;
                                    var8 = var10 + 36064;

                                    if (var10 > usedColorAttachs)
                                    {
                                        usedColorAttachs = var10;
                                    }

                                    if (var10 > usedColorBuffers)
                                    {
                                        usedColorBuffers = var10;
                                    }
                                }
                            }

                            var5.put(var7, var8);
                        }
                    }
                    else
                    {
                        programsDrawBuffers[var3] = dfbDrawBuffers;
                        usedDrawBuffers = usedColorBuffers;
                    }
                }
            }

            usedColorAttachs = usedColorBuffers;
            dfbDrawBuffers.limit(usedColorBuffers);
            dfbTextures.limit(usedColorBuffers);

            for (var3 = 0; var3 < usedColorBuffers; ++var3)
            {
                dfbDrawBuffers.put(var3, 36064 + var3);
            }

            if (usedDrawBuffers > var1)
            {
                printChatAndLogError("[Shaders] Not enough draw buffers! Requires " + usedDrawBuffers + ".  Has " + var1 + ".");
            }

            for (var3 = 0; var3 < 20; ++var3)
            {
                for (var4 = var3; programs[var4] == 0 && programBackups[var4] != var4; var4 = programBackups[var4])
                {
                    ;
                }

                if (var4 != var3)
                {
                    programs[var3] = programs[var4];
                    programsDrawBufSettings[var3] = programsDrawBufSettings[var4];
                    programsDrawBuffers[var3] = programsDrawBuffers[var4];
                }
            }

            resize();
            setupShadowMap();
            isInitialized = true;
            checkGLError("Shaders.init");
        }
    }

    private static IntBuffer fillIntBufferZero(IntBuffer var0)
    {
        int var1 = var0.limit();

        for (int var2 = var0.position(); var2 < var1; ++var2)
        {
            var0.put(var2, 0);
        }

        return var0;
    }

    public static void uninit()
    {
        if (isInitialized)
        {
            checkGLError("Shaders.uninit pre");

            for (int var0 = 0; var0 < 20; ++var0)
            {
                if (programsRef[var0] != 0)
                {
                    ARBShaderObjects.glDeleteObjectARB(programsRef[var0]);
                    checkGLError("del programRef[" + var0 + "] " + programsRef[var0]);
                }

                programsRef[var0] = 0;
                programs[var0] = 0;
                programsDrawBufSettings[var0] = null;
                programsDrawBuffers[var0] = null;
            }

            if (dfb != 0)
            {
                EXTFramebufferObject.glDeleteFramebuffersEXT(dfb);
                dfb = 0;
                checkGLError("del dfb");
            }

            if (sfb != 0)
            {
                EXTFramebufferObject.glDeleteFramebuffersEXT(sfb);
                sfb = 0;
                checkGLError("del sfb");
            }

            if (dfbDepthTexture != 0)
            {
                GL11.glDeleteTextures(dfbDepthTexture);
                dfbDepthTexture = 0;
                checkGLError("del dfbDepthTexture");
            }

            if (dfbTextures != null)
            {
                GL11.glDeleteTextures(dfbTextures);
                fillIntBufferZero(dfbTextures);
                checkGLError("del dfbTextures");
            }

            if (sfbDepthTexture != 0)
            {
                GL11.glDeleteTextures(sfbDepthTexture);
                sfbDepthTexture = 0;
                checkGLError("del shadow depth");
            }

            if (sfbWaterDepthTexture != 0)
            {
                GL11.glDeleteTextures(sfbWaterDepthTexture);
                sfbWaterDepthTexture = 0;
                checkGLError("del shadow water");
            }

            if (dfbDrawBuffers != null)
            {
                fillIntBufferZero(dfbDrawBuffers);
            }

            shadowPassInterval = 0;
            shouldSkipDefaultShadow = false;
            isInitialized = false;
            checkGLError("Shaders.uninit");
        }
    }

    private static void resize()
    {
        renderDisplayWidth = mc.displayWidth;
        renderDisplayHeight = mc.displayHeight;
        renderWidth = mc.displayWidth;
        renderHeight = mc.displayHeight;
        setupFrameBuffer();
    }

    private static void setupFrameBuffer()
    {
        if (dfb != 0)
        {
            EXTFramebufferObject.glDeleteFramebuffersEXT(dfb);
            GL11.glDeleteTextures(dfbDepthTexture);
            GL11.glDeleteTextures(dfbTextures);
        }

        dfb = EXTFramebufferObject.glGenFramebuffersEXT();
        dfbDepthTexture = GL11.glGenTextures();
        GL11.glGenTextures(dfbTextures);
        EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
        ByteBuffer var0 = ByteBuffer.allocateDirect(renderWidth * renderHeight * 4 * 4);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbDepthTexture);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
        GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL14.GL_DEPTH_TEXTURE_MODE, GL11.GL_LUMINANCE);
        GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_DEPTH_COMPONENT, renderWidth, renderHeight, 0, GL11.GL_DEPTH_COMPONENT, GL11.GL_FLOAT, var0);
        EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, dfbDepthTexture, 0);
        checkGLError("FT d");
        int var1;

        for (var1 = 0; var1 < usedColorBuffers; ++var1)
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(var1));
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);

            if (var1 == 1 && gbufferFormat_gdepth != 6408)
            {
                GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, gbufferFormat_gdepth, renderWidth, renderHeight, 0, GL11.GL_RGBA, GL11.GL_FLOAT, var0);
            }
            else if (var1 == 2 && gbufferFormat_gnormal != 6408)
            {
                GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, gbufferFormat_gaux4, renderWidth, renderHeight, 0, GL11.GL_RGBA, GL11.GL_FLOAT, var0);
            }
            else if (var1 == 7 && gbufferFormat_gaux4 != 6408)
            {
                GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, gbufferFormat_gaux4, renderWidth, renderHeight, 0, GL11.GL_RGBA, GL11.GL_FLOAT, var0);
            }
            else
            {
                GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, renderWidth, renderHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, var0);
            }

            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, dfbDrawBuffers.get(var1), 3553, dfbTextures.get(var1), 0);
            checkGLError("FT c");
        }

        var1 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);

        if (var1 == 36058)
        {
            printChatAndLogError("Failed using multiple internal formats in frame buffer.");

            for (int var2 = 0; var2 < usedColorBuffers; ++var2)
            {
                GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(var2));

                if (var2 == 1 && gbufferFormat_gdepth != 6408)
                {
                    GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, renderWidth, renderHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, var0);
                }
                else if (var2 == 2 && gbufferFormat_gnormal != 6408)
                {
                    GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, renderWidth, renderHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, var0);
                }
                else if (var2 == 7 && gbufferFormat_gaux4 != 6408)
                {
                    GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA, renderWidth, renderHeight, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, var0);
                }

                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, dfbDrawBuffers.get(var2), 3553, dfbTextures.get(var2), 0);
                checkGLError("FT c");
            }

            var1 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);

            if (var1 == 36053)
            {
                printChatAndLogError("Using low quality workaround!");
            }
        }

        if (var1 != 36053)
        {
            printChatAndLogError("Failed creating framebuffer! (Status " + var1 + ")");
        }
    }

    private static void setupShadowMap()
    {
        setupShadowFrameBuffer();
    }

    private static void setupShadowFrameBuffer()
    {
        if (shadowPassInterval > 0)
        {
            setupShadowRenderTexture();
            EXTFramebufferObject.glDeleteFramebuffersEXT(sfb);
            sfb = EXTFramebufferObject.glGenFramebuffersEXT();
            EXTFramebufferObject.glBindFramebufferEXT(36160, sfb);
            GL11.glDrawBuffer(0);
            GL11.glReadBuffer(0);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbDepthTexture, 0);
            int var0 = EXTFramebufferObject.glCheckFramebufferStatusEXT(36160);

            if (var0 != 36053)
            {
                printChatAndLogError("Failed creating shadow framebuffer! (Status " + var0 + ")");
            }
        }
    }

    private static void setupShadowRenderTexture()
    {
        if (shadowPassInterval > 0)
        {
            GL11.glDeleteTextures(sfbDepthTexture);
            GL11.glDeleteTextures(sfbWaterDepthTexture);
            sfbDepthTexture = GL11.glGenTextures();
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, sfbDepthTexture);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10496.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10496.0F);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
            ByteBuffer var0 = ByteBuffer.allocateDirect(shadowMapWidth * shadowMapHeight * 4);
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_DEPTH_COMPONENT, shadowMapWidth, shadowMapHeight, 0, GL11.GL_DEPTH_COMPONENT, GL11.GL_FLOAT, var0);
            sfbWaterDepthTexture = GL11.glGenTextures();
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, sfbWaterDepthTexture);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, 10496.0F);
            GL11.glTexParameterf(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, 10496.0F);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
            GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
            ByteBuffer var1 = ByteBuffer.allocateDirect(shadowMapWidth * shadowMapHeight * 4);
            GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_DEPTH_COMPONENT, shadowMapWidth, shadowMapHeight, 0, GL11.GL_DEPTH_COMPONENT, GL11.GL_FLOAT, var1);
        }
    }

    private static String printChatAndLogError(String var0)
    {
        mc.ingameGUI.getChatGUI().printChatMessage(var0);
        System.err.println(var0);
        return var0;
    }

    public static void setRenderEngine(RenderEngine var0)
    {
        mc = Minecraft.getMinecraft();

        if (renderEngine != null)
        {
            System.out.println("Shaders: Multiple RenderEngine!");
        }

        renderEngine = var0;
        defaultTextureImage_d = new BufferedImage(1, 1, 2);
        defaultTextureImage_d.setRGB(0, 0, -8355712);
        defaultTextureImage_n = new BufferedImage(1, 1, 2);
        defaultTextureImage_n.setRGB(0, 0, -8421378);
        defaultTextureImage_s = new BufferedImage(1, 1, 2);
        defaultTextureImage_s.setRGB(0, 0, -16777216);
        transparentImage = new BufferedImage(1, 1, 2);
        transparentImage.setRGB(0, 0, 0);
        defaultTextureIdArray = new int[3];
        defaultTextureIdArray[0] = renderEngine.allocateAndSetupTexture(defaultTextureImage_d);
        defaultTextureIdArray[1] = renderEngine.allocateAndSetupTexture(defaultTextureImage_n);
        defaultTextureIdArray[2] = renderEngine.allocateAndSetupTexture(defaultTextureImage_s);
        textureIdMap.put(Integer.valueOf(-1), defaultTextureIdArray);
        terrainTextureIdArray = defaultTextureIdArray;
        textureIdMap.put(Integer.valueOf(0), terrainTextureIdArray);
        checkOptifine();
        loadConfig();
    }

    public static void bindNormalMap(int[] var0)
    {
        GL13.glActiveTexture(GL13.GL_TEXTURE2);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, defaultTextureIdArray[1]);
        GL13.glActiveTexture(GL13.GL_TEXTURE3);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, defaultTextureIdArray[2]);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
    }

    public static void bindNormalMap(int var0)
    {
        int[] var1 = (int[])((int[])textureIdMap.get(Integer.valueOf(var0)));
        bindNormalMap(var1 != null ? var1 : defaultTextureIdArray);
    }

    public static void bindTextures(int[] var0)
    {
        GL13.glActiveTexture(GL13.GL_TEXTURE2);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, var0[1]);
        GL13.glActiveTexture(GL13.GL_TEXTURE3);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, var0[2]);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, var0[0]);
    }

    public static void bindTextures(int var0)
    {
        int[] var1 = (int[])((int[])textureIdMap.get(Integer.valueOf(var0)));

        if (var1 != null)
        {
            bindTextures(var1);
        }
        else
        {
            bindNormalMap(defaultTextureIdArray);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, var0);
        }
    }

    public static void enableVertexEnt(Tessellator var0)
    {
        if (entityAttrib >= 0)
        {
            ARBVertexProgram.glEnableVertexAttribArrayARB(entityAttrib);
            ARBVertexProgram.glVertexAttribPointerARB(entityAttrib, 2, false, false, 4, (ByteBuffer)var0.shadersBuffer.position(0));
        }
    }

    public static void disableVertexEnt()
    {
        if (entityAttrib >= 0)
        {
            ARBVertexProgram.glDisableVertexAttribArrayARB(entityAttrib);
        }
    }

    public static void beginRender(Minecraft var0, float var1, long var2)
    {
        if (!isShadowPass)
        {
            checkGLError("pre beginRender");
            mc = var0;
            mc.mcProfiler.startSection("init");

            if (!isInitialized)
            {
                init();
            }

            if (mc.displayWidth != renderDisplayWidth || mc.displayHeight != renderDisplayHeight)
            {
                resize();
            }

            worldTime = mc.theWorld.getWorldTime();
            diffWorldTime = (worldTime - lastWorldTime) % 24000L;

            if (diffWorldTime < 0L)
            {
                diffWorldTime += 24000L;
            }

            lastWorldTime = worldTime;
            rainStrength = var0.theWorld.getRainStrength(var1);
            //System.out.println(rainStrength);
            float var4 = (float)Math.exp(Math.log(0.5D) * (double)diffWorldTime / (double)(wetness < rainStrength ? drynessHalfLife : wetnessHalfLife));
            wetness = wetness * var4 + rainStrength * (1.0F - var4);
            EntityLiving var7 = mc.renderViewEntity;
            eyePosY = (float)var7.posY * var1 + (float)var7.lastTickPosY * (1.0F - var1);
            eyeBrightness = var7.getBrightnessForRender(var1);
            float var5 = 20.0F;
            float var6 = (float)Math.exp(Math.log(0.5D) * (double)diffWorldTime / (double)var5);
            eyeBrightnessFadeX = eyeBrightnessFadeX * var6 + (float)(eyeBrightness & 65535) * (1.0F - var6);
            eyeBrightnessFadeY = eyeBrightnessFadeY * var6 + (float)(eyeBrightness >> 16) * (1.0F - var6);
            isEyeInWater = mc.gameSettings.thirdPersonView == 0 && !mc.renderViewEntity.isPlayerSleeping() && mc.thePlayer.isInsideOfMaterial(Material.water) ? 1 : 0;
            isRenderingWorld = true;
            isCompositeRendered = false;

            if (shadowPassInterval > 0 && --shadowPassCounter <= 0)
            {
                mc.mcProfiler.endStartSection("shadow pass");
                preShadowPassThirdPersonView = mc.gameSettings.thirdPersonView;
                mc.gameSettings.thirdPersonView = 1;
                isShadowPass = true;
                shadowPassCounter = shadowPassInterval;
                EXTFramebufferObject.glBindFramebufferEXT(36160, sfb);
                useProgram(0);
                mc.entityRenderer.renderWorld(var1, var2);
                GL11.glFlush();
                isShadowPass = false;
                mc.gameSettings.thirdPersonView = preShadowPassThirdPersonView;
            }

            mc.mcProfiler.endSection();
            GL11.glViewport(0, 0, renderWidth, renderHeight);
            useProgram(lightmapEnabled ? 3 : 2);
            checkGLError("end beginRender");
        }
    }

    public static void beginRenderPass(Minecraft var0, float var1, long var2)
    {
        if (!isShadowPass)
        {
            EXTFramebufferObject.glBindFramebufferEXT(36160, dfb);
            isRenderingDfb = true;
            GL11.glEnable(GL11.GL_CULL_FACE);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL20.glDrawBuffers(0);
            useProgram(lightmapEnabled ? 3 : 2);
        }
    }

    public static void setClearColor(float var0, float var1, float var2)
    {
        clearColor[0] = var0;
        clearColor[1] = var1;
        clearColor[2] = var2;

        if (isShadowPass)
        {
            GL11.glClearColor(clearColor[0], clearColor[1], clearColor[2], 1.0F);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbWaterDepthTexture, 0);
            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
            EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbDepthTexture, 0);
            GL11.glClear(GL11.GL_DEPTH_BUFFER_BIT);
        }
        else
        {
            GL20.glDrawBuffers(36064);
            GL11.glClearColor(clearColor[0], clearColor[1], clearColor[2], 1.0F);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL20.glDrawBuffers(36065);
            GL11.glClearColor(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

            for (int var3 = 2; var3 < usedColorBuffers; ++var3)
            {
                GL20.glDrawBuffers(36064 + var3);
                GL11.glClearColor(0.0F, 0.0F, 0.0F, 0.0F);
                GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            }

            GL20.glDrawBuffers(dfbDrawBuffers);
        }
    }

    public static void setCamera(float var0)
    {
        EntityLiving var1 = mc.renderViewEntity;
        double var2 = var1.lastTickPosX + (var1.posX - var1.lastTickPosX) * (double)var0;
        double var4 = var1.lastTickPosY + (var1.posY - var1.lastTickPosY) * (double)var0;
        double var6 = var1.lastTickPosZ + (var1.posZ - var1.lastTickPosZ) * (double)var0;

        if (isShadowPass)
        {
            GL11.glViewport(0, 0, shadowMapWidth, shadowMapHeight);
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();

            if (shadowMapIsOrtho)
            {
                GL11.glOrtho((double)(-shadowMapHalfPlane), (double)shadowMapHalfPlane, (double)(-shadowMapHalfPlane), (double)shadowMapHalfPlane, 0.05000000074505806D, 256.0D);
            }
            else
            {
                GLU.gluPerspective(shadowMapFOV, (float)shadowMapWidth / (float)shadowMapHeight, 0.05F, 256.0F);
            }

            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glTranslatef(0.0F, 0.0F, -100.0F);
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            float var10 = mc.theWorld.getCelestialAngle(var0);
            sunAngle = var10 < 0.75F ? var10 + 0.25F : var10 - 0.75F;
            float var9 = var10 * -360.0F;

            if ((double)sunAngle <= 0.5D)
            {
                GL11.glRotatef(var9, 0.0F, 0.0F, 1.0F);
                shadowAngle = sunAngle;
            }
            else
            {
                GL11.glRotatef(var9 + 180.0F, 0.0F, 0.0F, 1.0F);
                shadowAngle = sunAngle - 0.5F;
            }

            if (shadowMapIsOrtho)
            {
                GL11.glTranslatef((float)var2 % 10.0F - 5.0F, (float)var4 % 10.0F - 5.0F, (float)var6 % 10.0F - 5.0F);
            }

            shadowProjection = BufferUtils.createFloatBuffer(16);
            GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, shadowProjection);
            shadowProjectionInverse = invertMat4x(shadowProjection);
            shadowModelView = BufferUtils.createFloatBuffer(16);
            GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, shadowModelView);
            shadowModelViewInverse = invertMat4x(shadowModelView);
        }
        else
        {
            FloatBuffer var8 = previousProjection;
            var8.clear();
            previousProjection = projection;
            projection = var8;
            GL11.glGetFloat(GL11.GL_PROJECTION_MATRIX, projection);
            projectionInverse = invertMat4x(projection);
            previousModelView = modelView;
            modelView = BufferUtils.createFloatBuffer(16);
            GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelView);
            modelViewInverse = invertMat4x(modelView);
            previousCameraPosition[0] = cameraPosition[0];
            previousCameraPosition[1] = cameraPosition[1];
            previousCameraPosition[2] = cameraPosition[2];
            cameraPosition[0] = var2;
            cameraPosition[1] = var4;
            cameraPosition[2] = var6;
        }
    }

    public static void setCelestialPosition()
    {
        FloatBuffer var0 = BufferUtils.createFloatBuffer(16);
        GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, var0);
        float[] var1 = new float[16];
        var0.get(var1, 0, 16);
        float[] var2 = multiplyMat4xVec4(var1, new float[] {0.0F, 100.0F, 0.0F, 0.0F});
        sunPosition = var2;
        float[] var3 = multiplyMat4xVec4(var1, new float[] {0.0F, -100.0F, 0.0F, 0.0F});
        moonPosition = var3;
    }

    private static float[] multiplyMat4xVec4(float[] var0, float[] var1)
    {
        float[] var2 = new float[] {var0[0] * var1[0] + var0[4] * var1[1] + var0[8] * var1[2] + var0[12] * var1[3], var0[1] * var1[0] + var0[5] * var1[1] + var0[9] * var1[2] + var0[13] * var1[3], var0[2] * var1[0] + var0[6] * var1[1] + var0[10] * var1[2] + var0[14] * var1[3], var0[3] * var1[0] + var0[7] * var1[1] + var0[11] * var1[2] + var0[15] * var1[3]};
        return var2;
    }

    private static FloatBuffer invertMat4x(FloatBuffer var0)
    {
        float[] var1 = new float[16];
        float[] var2 = new float[16];
        int var4;

        for (var4 = 0; var4 < 16; ++var4)
        {
            var1[var4] = var0.get(var4);
        }

        var2[0] = var1[5] * var1[10] * var1[15] - var1[5] * var1[11] * var1[14] - var1[9] * var1[6] * var1[15] + var1[9] * var1[7] * var1[14] + var1[13] * var1[6] * var1[11] - var1[13] * var1[7] * var1[10];
        var2[4] = -var1[4] * var1[10] * var1[15] + var1[4] * var1[11] * var1[14] + var1[8] * var1[6] * var1[15] - var1[8] * var1[7] * var1[14] - var1[12] * var1[6] * var1[11] + var1[12] * var1[7] * var1[10];
        var2[8] = var1[4] * var1[9] * var1[15] - var1[4] * var1[11] * var1[13] - var1[8] * var1[5] * var1[15] + var1[8] * var1[7] * var1[13] + var1[12] * var1[5] * var1[11] - var1[12] * var1[7] * var1[9];
        var2[12] = -var1[4] * var1[9] * var1[14] + var1[4] * var1[10] * var1[13] + var1[8] * var1[5] * var1[14] - var1[8] * var1[6] * var1[13] - var1[12] * var1[5] * var1[10] + var1[12] * var1[6] * var1[9];
        var2[1] = -var1[1] * var1[10] * var1[15] + var1[1] * var1[11] * var1[14] + var1[9] * var1[2] * var1[15] - var1[9] * var1[3] * var1[14] - var1[13] * var1[2] * var1[11] + var1[13] * var1[3] * var1[10];
        var2[5] = var1[0] * var1[10] * var1[15] - var1[0] * var1[11] * var1[14] - var1[8] * var1[2] * var1[15] + var1[8] * var1[3] * var1[14] + var1[12] * var1[2] * var1[11] - var1[12] * var1[3] * var1[10];
        var2[9] = -var1[0] * var1[9] * var1[15] + var1[0] * var1[11] * var1[13] + var1[8] * var1[1] * var1[15] - var1[8] * var1[3] * var1[13] - var1[12] * var1[1] * var1[11] + var1[12] * var1[3] * var1[9];
        var2[13] = var1[0] * var1[9] * var1[14] - var1[0] * var1[10] * var1[13] - var1[8] * var1[1] * var1[14] + var1[8] * var1[2] * var1[13] + var1[12] * var1[1] * var1[10] - var1[12] * var1[2] * var1[9];
        var2[2] = var1[1] * var1[6] * var1[15] - var1[1] * var1[7] * var1[14] - var1[5] * var1[2] * var1[15] + var1[5] * var1[3] * var1[14] + var1[13] * var1[2] * var1[7] - var1[13] * var1[3] * var1[6];
        var2[6] = -var1[0] * var1[6] * var1[15] + var1[0] * var1[7] * var1[14] + var1[4] * var1[2] * var1[15] - var1[4] * var1[3] * var1[14] - var1[12] * var1[2] * var1[7] + var1[12] * var1[3] * var1[6];
        var2[10] = var1[0] * var1[5] * var1[15] - var1[0] * var1[7] * var1[13] - var1[4] * var1[1] * var1[15] + var1[4] * var1[3] * var1[13] + var1[12] * var1[1] * var1[7] - var1[12] * var1[3] * var1[5];
        var2[14] = -var1[0] * var1[5] * var1[14] + var1[0] * var1[6] * var1[13] + var1[4] * var1[1] * var1[14] - var1[4] * var1[2] * var1[13] - var1[12] * var1[1] * var1[6] + var1[12] * var1[2] * var1[5];
        var2[3] = -var1[1] * var1[6] * var1[11] + var1[1] * var1[7] * var1[10] + var1[5] * var1[2] * var1[11] - var1[5] * var1[3] * var1[10] - var1[9] * var1[2] * var1[7] + var1[9] * var1[3] * var1[6];
        var2[7] = var1[0] * var1[6] * var1[11] - var1[0] * var1[7] * var1[10] - var1[4] * var1[2] * var1[11] + var1[4] * var1[3] * var1[10] + var1[8] * var1[2] * var1[7] - var1[8] * var1[3] * var1[6];
        var2[11] = -var1[0] * var1[5] * var1[11] + var1[0] * var1[7] * var1[9] + var1[4] * var1[1] * var1[11] - var1[4] * var1[3] * var1[9] - var1[8] * var1[1] * var1[7] + var1[8] * var1[3] * var1[5];
        var2[15] = var1[0] * var1[5] * var1[10] - var1[0] * var1[6] * var1[9] - var1[4] * var1[1] * var1[10] + var1[4] * var1[2] * var1[9] + var1[8] * var1[1] * var1[6] - var1[8] * var1[2] * var1[5];
        float var3 = var1[0] * var2[0] + var1[1] * var2[4] + var1[2] * var2[8] + var1[3] * var2[12];
        FloatBuffer var5 = BufferUtils.createFloatBuffer(16);

        if ((double)var3 == 0.0D)
        {
            return var5;
        }
        else
        {
            for (var4 = 0; var4 < 16; ++var4)
            {
                var5.put(var4, var2[var4] / var3);
            }

            return var5;
        }
    }

    public static void drawComposite()
    {
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(0));
        GL13.glActiveTexture(GL13.GL_TEXTURE1);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(1));
        GL13.glActiveTexture(GL13.GL_TEXTURE2);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(2));
        GL13.glActiveTexture(GL13.GL_TEXTURE3);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(3));

        if (usedColorBuffers >= 5)
        {
            GL13.glActiveTexture(GL13.GL_TEXTURE7);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(4));

            if (usedColorBuffers >= 6)
            {
                GL13.glActiveTexture(GL13.GL_TEXTURE8);
                GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(5));

                if (usedColorBuffers >= 7)
                {
                    GL13.glActiveTexture(GL13.GL_TEXTURE9);
                    GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(6));

                    if (usedColorBuffers >= 8)
                    {
                        GL13.glActiveTexture(GL13.GL_TEXTURE10);
                        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbTextures.get(7));
                    }
                }
            }
        }

        if (shadowPassInterval > 0)
        {
            GL13.glActiveTexture(GL13.GL_TEXTURE4);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, sfbDepthTexture);
            GL13.glActiveTexture(GL13.GL_TEXTURE5);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, sfbWaterDepthTexture);
        }

        GL13.glActiveTexture(GL13.GL_TEXTURE6);
        GL11.glBindTexture(GL11.GL_TEXTURE_2D, dfbDepthTexture);
        GL13.glActiveTexture(GL13.GL_TEXTURE0);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0.0F, 0.0F);
        GL11.glVertex3f(0.0F, 0.0F, 0.0F);
        GL11.glTexCoord2f(1.0F, 0.0F);
        GL11.glVertex3f(1.0F, 0.0F, 0.0F);
        GL11.glTexCoord2f(1.0F, 1.0F);
        GL11.glVertex3f(1.0F, 1.0F, 0.0F);
        GL11.glTexCoord2f(0.0F, 1.0F);
        GL11.glVertex3f(0.0F, 1.0F, 0.0F);
        GL11.glEnd();
    }

    public static void renderCompositeFinal()
    {
        if (isShadowPass)
        {
            useProgram(0);
        }
        else
        {
            checkGLError("pre-renderCompositeFinal");
            GL11.glPushMatrix();
            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(0.0D, 1.0D, 0.0D, 1.0D, 0.0D, 1.0D);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDepthFunc(GL11.GL_ALWAYS);
            GL11.glDepthMask(false);
            GL20.glDrawBuffers(dfbDrawBuffers);
            checkGLError("pre-composite");

            for (int var0 = 0; var0 < 8; ++var0)
            {
                if (programs[11 + var0] != 0)
                {
                    useProgram(11 + var0);
                    checkGLError(programNames[11 + var0]);
                    drawComposite();
                }
            }

            isRenderingDfb = false;
            EXTFramebufferObject.glBindFramebufferEXT(36160, 0);
            GL11.glViewport(0, 0, mc.displayWidth, mc.displayHeight);

            if (EntityRenderer.anaglyphEnable)
            {
                boolean var1 = EntityRenderer.anaglyphField != 0;
                GL11.glColorMask(var1, !var1, !var1, true);
            }

            GL11.glDepthMask(true);
            GL11.glClearColor(clearColor[0], clearColor[1], clearColor[2], 1.0F);
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glDisable(GL11.GL_ALPHA_TEST);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_DEPTH_TEST);
            GL11.glDepthFunc(GL11.GL_ALWAYS);
            GL11.glDepthMask(false);
            checkGLError("pre-final");
            useProgram(19);
            checkGLError("final");
            drawComposite();
            checkGLError("renderCompositeFinal");
            isCompositeRendered = true;
            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glEnable(GL11.GL_ALPHA_TEST);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
            GL11.glDepthMask(true);
            GL11.glPopMatrix();
            useProgram(0);
        }
    }

    public static void endRender()
    {
        if (isShadowPass)
        {
            useProgram(0);
        }
        else
        {
            if (!isCompositeRendered)
            {
                renderCompositeFinal();
            }

            isRenderingWorld = false;
            GL11.glColorMask(true, true, true, true);
            GL11.glEnable(GL11.GL_BLEND);
            useProgram(0);
            checkGLError("endRender end");
        }
    }

    public static void beginSky()
    {
        isRenderingSky = true;
        useProgram(5);
        Tessellator.instance.setEntity(-2, 0);
    }

    public static void endSky()
    {
        isRenderingSky = false;
        useProgram(lightmapEnabled ? 3 : 2);
        Tessellator.instance.setEntity(-1, 0);
    }

    public static void beginTerrain()
    {
        if (isRenderingWorld)
        {
            useProgram(6);
            bindNormalMap(terrainTextureIdArray);
        }
    }

    public static void endTerrain()
    {
        if (isRenderingWorld)
        {
            useProgram(lightmapEnabled ? 3 : 2);
        }
    }

    public static void beginBlockDestroyProgress()
    {
        if (isRenderingWorld)
        {
            useProgram(6);
        }
    }

    public static void endBlockDestroyProgress()
    {
        if (isRenderingWorld)
        {
            useProgram(3);
        }
    }

    public static void beginEntities()
    {
        if (isRenderingWorld)
        {
            useProgram(7);

            if (programs[activeProgram] != 0)
            {
                uniformEntityHurt = ARBShaderObjects.glGetUniformLocationARB(programs[activeProgram], "entityHurt");
                uniformEntityFlash = ARBShaderObjects.glGetUniformLocationARB(programs[activeProgram], "entityFlash");
                useEntityHurtFlash = uniformEntityHurt != -1 || uniformEntityFlash != -1;
                ARBShaderObjects.glUniform1iARB(uniformEntityHurt, 0);
                ARBShaderObjects.glUniform1iARB(uniformEntityFlash, 0);
            }
            else
            {
                useEntityHurtFlash = false;
            }
        }
    }

    public static void endEntities()
    {
        if (isRenderingWorld)
        {
            useProgram(lightmapEnabled ? 3 : 2);
        }
    }

    public static void setEntityHurtFlash(int var0, int var1)
    {
        if (isRenderingWorld)
        {
            ARBShaderObjects.glUniform1iARB(uniformEntityHurt, var0);
            ARBShaderObjects.glUniform1iARB(uniformEntityFlash, var1 >> 24);
        }
    }
@Deprecated
    public static void beginLivingDamage()
    {
       /* if (isRenderingWorld)
        {
            bindTextures(defaultTextureIdArray);

            if (!isShadowPass)
            {
                ;
            }
        }*/
    }

    @Deprecated
    public static void endLivingDamage()
    {/*
        if (isRenderingWorld && !isShadowPass)
        {
            ;
        }*/
    }

    public static void beginLitParticles()
    {
        Tessellator.instance.setNormal(0.0F, 0.0F, 0.0F);
        useProgram(3);
    }

    public static void beginParticles()
    {
        Tessellator.instance.setNormal(0.0F, 0.0F, 0.0F);
        useProgram(3);
    }

    public static void endParticles()
    {
        Tessellator.instance.setNormal(0.0F, 0.0F, 0.0F);
        useProgram(3);
    }

    public static void beginWater()
    {
        if (isRenderingWorld)
        {
            useProgram(9);
            bindNormalMap(terrainTextureIdArray);

            if (isShadowPass)
            {
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbWaterDepthTexture, 0);
            }
        }
    }

    public static void endWater()
    {
        if (isRenderingWorld)
        {
            if (isShadowPass)
            {
                EXTFramebufferObject.glFramebufferTexture2DEXT(36160, 36096, 3553, sfbDepthTexture, 0);
            }

            useProgram(lightmapEnabled ? 3 : 2);
        }
    }

    public static void beginWeather()
    {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        useProgram(10);
    }

    public static void endWeather()
    {
        GL11.glDisable(GL11.GL_BLEND);
        useProgram(lightmapEnabled ? 3 : 2);
    }

    public static void beginHand()
    {
        useProgram(8);
    }

    public static void endHand()
    {
        useProgram(lightmapEnabled ? 3 : 2);
    }

    public static void beginFPOverlay()
    {
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
    }

    public static void endFPOverlay()
    {
        GL11.glDisable(GL11.GL_BLEND);
    }

    public static void glEnableWrapper(int var0)
    {
        if (var0 == 3553)
        {
            sglEnableT2D(var0);
        }
        else if (var0 == 2912)
        {
            sglEnableFog(var0);
        }
        else
        {
            GL11.glEnable(var0);
        }
    }

    public static void glDisableWrapper(int var0)
    {
        if (var0 == 3553)
        {
            sglDisableT2D(var0);
        }
        else if (var0 == 2912)
        {
            sglDisableFog(var0);
        }
        else
        {
            GL11.glDisable(var0);
        }
    }

    public static void sglEnableT2D(int var0)
    {
        GL11.glEnable(var0);

        if (isRenderingSky)
        {
            useProgram(5);
        }
        else if (activeProgram == 1)
        {
            useProgram(lightmapEnabled ? 3 : 2);
        }
    }

    public static void sglDisableT2D(int var0)
    {
        GL11.glDisable(var0);

        if (isRenderingSky)
        {
            useProgram(4);
        }
        else if (activeProgram == 2 || activeProgram == 3)
        {
            useProgram(1);
        }
    }

    public static void sglEnableFog(int var0)
    {
        GL11.glEnable(var0);
        fogEnabled = true;

        if (programs[activeProgram] != 0)
        {
            setProgramUniform1i("fogMode", GL11.glGetInteger(GL11.GL_FOG_MODE));
        }
    }

    public static void sglDisableFog(int var0)
    {
        GL11.glDisable(var0);
        fogEnabled = false;

        if (programs[activeProgram] != 0)
        {
            setProgramUniform1i("fogMode", 0);
        }
    }

    public static void enableLightmap()
    {
        lightmapEnabled = true;

        if (activeProgram == 2)
        {
            useProgram(3);
        }
    }

    public static void disableLightmap()
    {
        lightmapEnabled = false;

        if (activeProgram == 3)
        {
            useProgram(2);
        }
    }

    private static int setupProgram(int var0, String var1, String var2)
    {
        int var3 = ARBShaderObjects.glCreateProgramObjectARB();

        if (var3 != 0)
        {
            int var4 = createVertShader(var1);
            int var5 = createFragShader(var2);

            if (var4 == 0 && var5 == 0)
            {
                ARBShaderObjects.glDeleteObjectARB(var3);
                var3 = 0;
            }
            else
            {
                if (var4 != 0)
                {
                    ARBShaderObjects.glAttachObjectARB(var3, var4);
                }

                if (var5 != 0)
                {
                    ARBShaderObjects.glAttachObjectARB(var3, var5);
                }

                if (entityAttrib >= 0)
                {
                    ARBVertexShader.glBindAttribLocationARB(var3, entityAttrib, "mc_Entity");
                }

                ARBShaderObjects.glLinkProgramARB(var3);

                if (var4 != 0)
                {
                    ARBShaderObjects.glDetachObjectARB(var3, var4);
                    ARBShaderObjects.glDeleteObjectARB(var4);
                }

                if (var5 != 0)
                {
                    ARBShaderObjects.glDetachObjectARB(var3, var5);
                    ARBShaderObjects.glDeleteObjectARB(var5);
                }

                ARBShaderObjects.glValidateProgramARB(var3);
                printLogInfo(var3, var1 + "," + var2);
                int var6 = GL20.glGetProgram(var3, GL20.GL_VALIDATE_STATUS);

                if (var6 == 1)
                {
                    System.out.println("Program " + programNames[var0] + " loaded");
                }
                else
                {
                    printChatAndLogError("[Shaders] Error : Invalid program " + programNames[var0]);
                    ARBShaderObjects.glDeleteObjectARB(var3);
                    var3 = 0;
                }
            }
        }

        return var3;
    }

    private static int createVertShader(String var0)
    {
        int var1 = ARBShaderObjects.glCreateShaderObjectARB(ARBVertexShader.GL_VERTEX_SHADER_ARB);

        if (var1 == 0)
        {
            return 0;
        }
        else
        {
            String var2 = "";
            BufferedReader var4;

            try
            {
                var4 = new BufferedReader(new InputStreamReader(shaderPack.getResourceAsStream(var0)));
            }
            catch (Exception var9)
            {
                try
                {
                    var4 = new BufferedReader(new FileReader(new File(var0)));
                }
                catch (Exception var8)
                {
                    System.out.println("Couldn\'t open " + var0);
                    ARBShaderObjects.glDeleteObjectARB(var1);
                    return 0;
                }
            }

            String var3;

            try
            {
                while ((var3 = var4.readLine()) != null)
                {
                    var2 = var2 + var3 + "\n";

                    if (var3.matches("attribute [_a-zA-Z0-9]+ mc_Entity.*"))
                    {
                        entityAttrib = 10;
                    }
                }
            }
            catch (Exception var10)
            {
                System.out.println("Couldn\'t read " + var0 + "!");
                ARBShaderObjects.glDeleteObjectARB(var1);
                return 0;
            }

            try
            {
                var4.close();
            }
            catch (Exception var7)
            {
                System.out.println("Couldn\'t close " + var0 + "!");
            }

            ARBShaderObjects.glShaderSourceARB(var1, var2);
            ARBShaderObjects.glCompileShaderARB(var1);
            printLogInfo(var1, var0);
            return var1;
        }
    }

    private static int createFragShader(String var0)
    {
        int var1 = ARBShaderObjects.glCreateShaderObjectARB(ARBFragmentShader.GL_FRAGMENT_SHADER_ARB);

        if (var1 == 0)
        {
            return 0;
        }
        else
        {
            StringBuilder var2 = new StringBuilder(1048576);
            BufferedReader var4;

            try
            {
                var4 = new BufferedReader(new InputStreamReader(shaderPack.getResourceAsStream(var0)));
            }
            catch (Exception var9)
            {
                try
                {
                    var4 = new BufferedReader(new FileReader(new File(var0)));
                }
                catch (Exception var8)
                {
                    System.out.println("Couldn\'t open " + var0);
                    ARBShaderObjects.glDeleteObjectARB(var1);
                    return 0;
                }
            }

            String var3;

            try
            {
                while ((var3 = var4.readLine()) != null)
                {
                    var2.append(var3).append('\n');

                    if (!var3.matches("#version .*"))
                    {
                        if (var3.matches("uniform [ _a-zA-Z0-9]+ shadow;.*"))
                        {
                            shadowPassInterval = 1;
                            shouldSkipDefaultShadow = true;
                        }
                        else if (var3.matches("uniform [ _a-zA-Z0-9]+ gdepth;.*"))
                        {
                            gbufferFormat_gdepth = 34837;
                        }
                        else if (usedColorBuffers < 5 && var3.matches("uniform [ _a-zA-Z0-9]+ gaux1;.*"))
                        {
                            usedColorBuffers = 5;
                        }
                        else if (usedColorBuffers < 6 && var3.matches("uniform [ _a-zA-Z0-9]+ gaux2;.*"))
                        {
                            usedColorBuffers = 6;
                        }
                        else if (usedColorBuffers < 7 && var3.matches("uniform [ _a-zA-Z0-9]+ gaux3;.*"))
                        {
                            usedColorBuffers = 7;
                        }
                        else if (usedColorBuffers < 8 && var3.matches("uniform [ _a-zA-Z0-9]+ gaux4;.*"))
                        {
                            usedColorBuffers = 8;
                        }
                        else if (usedColorBuffers < 5 && var3.matches("uniform [ _a-zA-Z0-9]+ colortex4;.*"))
                        {
                            usedColorBuffers = 5;
                        }
                        else if (usedColorBuffers < 6 && var3.matches("uniform [ _a-zA-Z0-9]+ colortex5;.*"))
                        {
                            usedColorBuffers = 6;
                        }
                        else if (usedColorBuffers < 7 && var3.matches("uniform [ _a-zA-Z0-9]+ colortex6;.*"))
                        {
                            usedColorBuffers = 7;
                        }
                        else if (usedColorBuffers < 8 && var3.matches("uniform [ _a-zA-Z0-9]+ colortex7;.*"))
                        {
                            usedColorBuffers = 8;
                        }
                        else
                        {
                            String[] var5;

                            if (var3.matches("/\\* SHADOWRES:[0-9]+ \\*/.*"))
                            {
                                var5 = var3.split("(:| )", 4);
                                System.out.println("Shadow map resolution: " + var5[2]);
                                shadowMapWidth = shadowMapHeight = Integer.parseInt(var5[2]);
                            }
                            else if (var3.matches("/\\* SHADOWFOV:[0-9\\.]+ \\*/.*"))
                            {
                                var5 = var3.split("(:| )", 4);
                                System.out.println("Shadow map field of view: " + var5[2]);
                                shadowMapFOV = Float.parseFloat(var5[2]);
                                shadowMapIsOrtho = false;
                            }
                            else if (var3.matches("/\\* SHADOWHPL:[0-9\\.]+ \\*/.*"))
                            {
                                var5 = var3.split("(:| )", 4);
                                System.out.println("Shadow map half-plane: " + var5[2]);
                                shadowMapHalfPlane = Float.parseFloat(var5[2]);
                                shadowMapIsOrtho = true;
                            }
                            else if (var3.matches("/\\* WETNESSHL:[0-9\\.]+ \\*/.*"))
                            {
                                var5 = var3.split("(:| )", 4);
                                System.out.println("Wetness halflife: " + var5[2]);
                                wetnessHalfLife = Float.parseFloat(var5[2]);
                            }
                            else if (var3.matches("/\\* DRYNESSHL:[0-9\\.]+ \\*/.*"))
                            {
                                var5 = var3.split("(:| )", 4);
                                System.out.println("Dryness halflife: " + var5[2]);
                                drynessHalfLife = Float.parseFloat(var5[2]);
                            }
                            else if (var3.matches("/\\* GNORMALFORMAT:RGBA32F \\*/.*"))
                            {
                                System.out.println("gnormal format : RGB32AF");
                                gbufferFormat_gnormal = 34836;
                            }
                            else if (var3.matches("/\\* GNORMALFORMAT:RGB32F \\*/.*"))
                            {
                                System.out.println("gnormal format : RGB32F");
                                gbufferFormat_gnormal = 34837;
                            }
                            else if (var3.matches("/\\* GAUX4FORMAT:RGBA32F \\*/.*"))
                            {
                                System.out.println("gaux4 format : RGB32AF");
                                gbufferFormat_gaux4 = 34836;
                            }
                            else if (var3.matches("/\\* GAUX4FORMAT:RGB32F \\*/.*"))
                            {
                                System.out.println("gaux4 format : RGB32F");
                                gbufferFormat_gaux4 = 34837;
                            }
                            else if (var3.matches("/\\* DRAWBUFFERS:[0-7N]* \\*/.*"))
                            {
                                var5 = var3.split("(:| )", 4);
                                newDrawBufSetting = var5[2];
                            }
                        }
                    }
                }
            }
            catch (Exception var10)
            {
                System.out.println("Couldn\'t read " + var0 + "!");
                ARBShaderObjects.glDeleteObjectARB(var1);
                return 0;
            }

            try
            {
                var4.close();
            }
            catch (Exception var7)
            {
                System.out.println("Couldn\'t close " + var0 + "!");
            }

            ARBShaderObjects.glShaderSourceARB(var1, var2);
            ARBShaderObjects.glCompileShaderARB(var1);
            printLogInfo(var1, var0);
            return var1;
        }
    }

    private static boolean printLogInfo(int var0, String var1)
    {
        IntBuffer var2 = BufferUtils.createIntBuffer(1);
        ARBShaderObjects.glGetObjectParameterARB(var0, ARBShaderObjects.GL_OBJECT_INFO_LOG_LENGTH_ARB, var2);
        int var3 = var2.get();

        if (var3 > 1)
        {
            ByteBuffer var4 = BufferUtils.createByteBuffer(var3);
            var2.flip();
            ARBShaderObjects.glGetInfoLogARB(var0, var2, var4);
            byte[] var5 = new byte[var3];
            var4.get(var5);

            if (var5[var3 - 1] == 0)
            {
                var5[var3 - 1] = 10;
            }

            String var6 = new String(var5);
            System.out.println("Info log: " + var1 + "\n" + var6);
            return false;
        }
        else
        {
            return true;
        }
    }

    public static void useProgram(int var0)
    {
        checkGLError("pre-useProgram");

        if (activeProgram != var0)
        {
            if (isShadowPass)
            {
                activeProgram = 0;
                ARBShaderObjects.glUseProgramObjectARB(0);
                normalMapEnabled = false;
            }
            else
            {
                activeProgram = var0;
                ARBShaderObjects.glUseProgramObjectARB(programs[var0]);

                if (programs[var0] == 0)
                {
                    normalMapEnabled = false;
                }
                else
                {
                    if (checkGLError("useProgram ", programNames[var0]) != 0)
                    {
                        programs[var0] = 0;
                    }

                    IntBuffer var1 = programsDrawBuffers[var0];

                    if (isRenderingDfb && activeDrawBuffers != var1)
                    {
                        activeDrawBuffers = var1;
                        GL20.glDrawBuffers(var1);
                        checkGLError(programNames[var0] + " draw buffers = " + programsDrawBufSettings[var0]);
                    }

                    switch (var0)
                    {
                        case 2:
                            normalMapEnabled = false;
                            setProgramUniform1i("texture", 0);
                            setProgramUniform1i("shadow", 8);
                            setProgramUniform1i("watershadow", 9);
                            break;

                        case 3:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            normalMapEnabled = true;
                            setProgramUniform1i("texture", 0);
                            setProgramUniform1i("lightmap", 1);
                            setProgramUniform1i("normals", 2);
                            setProgramUniform1i("specular", 3);
                            setProgramUniform1i("shadow", 8);
                            setProgramUniform1i("watershadow", 9);
                            break;

                        case 4:
                        case 5:
                        default:
                            normalMapEnabled = false;
                            break;

                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        case 18:
                        case 19:
                            normalMapEnabled = false;
                            setProgramUniform1i("gcolor", 0);
                            setProgramUniform1i("gdepth", 1);
                            setProgramUniform1i("gnormal", 2);
                            setProgramUniform1i("composite", 3);
                            setProgramUniform1i("gaux1", 7);
                            setProgramUniform1i("gaux2", 8);
                            setProgramUniform1i("gaux3", 9);
                            setProgramUniform1i("gaux4", 10);
                            setProgramUniform1i("colortex0", 0);
                            setProgramUniform1i("colortex1", 1);
                            setProgramUniform1i("colortex2", 2);
                            setProgramUniform1i("colortex3", 3);
                            setProgramUniform1i("colortex4", 7);
                            setProgramUniform1i("colortex5", 8);
                            setProgramUniform1i("colortex6", 9);
                            setProgramUniform1i("colortex7", 10);
                            setProgramUniform1i("shadow", 4);
                            setProgramUniform1i("watershadow", 5);
                            setProgramUniform1i("gdepthtex", 6);
                            setProgramUniform1i("depthtex0", 6);
                            setProgramUniformMatrix4ARB("gbufferPreviousProjection", false, previousProjection);
                            setProgramUniformMatrix4ARB("gbufferProjection", false, projection);
                            setProgramUniformMatrix4ARB("gbufferProjectionInverse", false, projectionInverse);
                            setProgramUniformMatrix4ARB("gbufferPreviousModelView", false, previousModelView);

                            if (shadowPassInterval > 0)
                            {
                                setProgramUniformMatrix4ARB("shadowProjection", false, shadowProjection);
                                setProgramUniformMatrix4ARB("shadowProjectionInverse", false, shadowProjectionInverse);
                                setProgramUniformMatrix4ARB("shadowModelView", false, shadowModelView);
                                setProgramUniformMatrix4ARB("shadowModelViewInverse", false, shadowModelViewInverse);
                            }
                    }

                    ItemStack var2 = mc.thePlayer.inventory.getCurrentItem();
                    setProgramUniform1i("heldItemId", var2 == null ? -1 : var2.itemID);
                    setProgramUniform1i("heldBlockLightValue", var2 != null && var2.itemID < 256 ? Block.lightValue[var2.itemID] : 0);
                    setProgramUniform1i("fogMode", fogEnabled ? GL11.glGetInteger(GL11.GL_FOG_MODE) : 0);
                    setProgramUniform1i("worldTime", (int)worldTime % 24000);
                    setProgramUniform1f("sunAngle", sunAngle);
                    setProgramUniform1f("shadowAngle", shadowAngle);
                    setProgramUniform1f("rainStrength", rainStrength);
                    setProgramUniform1f("aspectRatio", (float)renderWidth / (float)renderHeight);
                    setProgramUniform1f("viewWidth", (float)renderWidth);
                    setProgramUniform1f("viewHeight", (float)renderHeight);
                    setProgramUniform1f("near", 0.05F);
                    setProgramUniform1f("far", (float)(32 << 3 - mc.gameSettings.renderDistance));
                    setProgramUniform3f("sunPosition", sunPosition[0], sunPosition[1], sunPosition[2]);
                    setProgramUniform3f("moonPosition", moonPosition[0], moonPosition[1], moonPosition[2]);
                    setProgramUniform3f("previousCameraPosition", (float)previousCameraPosition[0], (float)previousCameraPosition[1], (float)previousCameraPosition[2]);
                    setProgramUniform3f("cameraPosition", (float)cameraPosition[0], (float)cameraPosition[1], (float)cameraPosition[2]);
                    setProgramUniformMatrix4ARB("gbufferModelView", false, modelView);
                    setProgramUniformMatrix4ARB("gbufferModelViewInverse", false, modelViewInverse);
                    setProgramUniform1f("wetness", wetness);
                    setProgramUniform1f("eyeAltitude", eyePosY);
                    setProgramUniform2i("eyeBrightness", eyeBrightness & 65535, eyeBrightness >> 16);
                    setProgramUniform2i("eyeBrightnessSmooth", Math.round(eyeBrightnessFadeX), Math.round(eyeBrightnessFadeY));
                    setProgramUniform1i("isEyeInWater", isEyeInWater);
                    setProgramUniform1i("hideGUI", mc.gameSettings.hideGUI ? 1 : 0);
                    checkGLError("useProgram ", programNames[var0]);
                }
            }
        }
    }

    public static void setProgramUniform1i(String var0, int var1)
    {
        int var2 = programs[activeProgram];

        if (var2 != 0)
        {
            int var3 = ARBShaderObjects.glGetUniformLocationARB(var2, var0);
            ARBShaderObjects.glUniform1iARB(var3, var1);
            checkGLError(programNames[activeProgram], var0);
        }
    }

    public static void setProgramUniform2i(String var0, int var1, int var2)
    {
        int var3 = programs[activeProgram];

        if (var3 != 0)
        {
            int var4 = ARBShaderObjects.glGetUniformLocationARB(var3, var0);
            ARBShaderObjects.glUniform2iARB(var4, var1, var2);
            checkGLError(programNames[activeProgram], var0);
        }
    }

    public static void setProgramUniform1f(String var0, float var1)
    {
        int var2 = programs[activeProgram];

        if (var2 != 0)
        {
            int var3 = ARBShaderObjects.glGetUniformLocationARB(var2, var0);
            ARBShaderObjects.glUniform1fARB(var3, var1);
            checkGLError(programNames[activeProgram], var0);
        }
    }

    public static void setProgramUniform3f(String var0, float var1, float var2, float var3)
    {
        int var4 = programs[activeProgram];

        if (var4 != 0)
        {
            int var5 = ARBShaderObjects.glGetUniformLocationARB(var4, var0);
            ARBShaderObjects.glUniform3fARB(var5, var1, var2, var3);
            checkGLError(programNames[activeProgram], var0);
        }
    }

    public static void setProgramUniformMatrix4ARB(String var0, boolean var1, FloatBuffer var2)
    {
        int var3 = programs[activeProgram];

        if (var3 != 0 && var2 != null)
        {
            int var4 = ARBShaderObjects.glGetUniformLocationARB(var3, var0);
            ARBShaderObjects.glUniformMatrix4ARB(var4, var1, var2);
            checkGLError(programNames[activeProgram], var0);
        }
    }
}
