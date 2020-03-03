package net.minecraft.src;

import java.util.HashSet;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class WorldRendererThreaded extends WorldRenderer
{
    private int glRenderListStable;
    private int glRenderListBoundingBox;

    public WorldRendererThreaded(World var1, List var2, int var3, int var4, int var5, int var6)
    {
        super(var1, var2, var3, var4, var5, var6);
        this.glRenderListStable = this.glRenderList + 393216;
        this.glRenderListBoundingBox = this.glRenderList + 2;
    }

    /**
     * Will update this chunk renderer
     */
    public void updateRenderer()
    {
        if (this.worldObj != null)
        {
            this.updateRenderer((IWrUpdateListener)null);
            this.finishUpdate();
        }
    }

    public void updateRenderer(IWrUpdateListener var1)
    {
    	  if (this.worldObj != null)
        {
            this.needsUpdate = false;
            int var2 = this.posX;
            int var3 = this.posY;
            int var4 = this.posZ;
            int var5 = this.posX + 16;
            int var6 = this.posY + 16;
            int var7 = this.posZ + 16;
            boolean[] var8 = new boolean[2];

            for (int var9 = 0; var9 < var8.length; ++var9)
            {
                var8[var9] = true;
            }

            if (Reflector.LightCache.exists())
            {
                Object var28 = Reflector.getFieldValue(Reflector.LightCache_cache);
                Reflector.callVoid(var28, Reflector.LightCache_clear, new Object[0]);
                Reflector.callVoid(Reflector.BlockCoord_resetPool, new Object[0]);
            }

            Chunk.isLit = false;
            HashSet var29 = new HashSet();
            var29.addAll(this.tileEntityRenderers);
            this.tileEntityRenderers.clear();
            byte var10 = 1;
            ChunkCache var11 = new ChunkCache(this.worldObj, var2 - var10, var3 - var10, var4 - var10, var5 + var10, var6 + var10, var7 + var10, var10);

            if (!var11.extendedLevelsInChunkCache())
            {
                ++chunksUpdated;
                RenderBlocks var12 = new RenderBlocks(var11);
                this.bytesDrawn = 0;
                Tessellator var13 = Tessellator.instance;
                Tessellator var14 = Tessellator.instance;
                boolean var15 = Reflector.ForgeHooksClient.exists();
                WrUpdateControl var16 = new WrUpdateControl();

                for (int var17 = 0; var17 < 2; ++var17)
                {
                    var16.setRenderPass(var17);
                    boolean var18 = false;
                    boolean var19 = false;
                    boolean var20 = false;

                    for (int var21 = var3; var21 < var6; ++var21)
                    {
                        if (var19 && var1 != null)
                        {
                            var1.updating(var16);
                        }

                        for (int var22 = var4; var22 < var7; ++var22)
                        {
                            for (int var23 = var2; var23 < var5; ++var23)
                            {
                                int var24 = var11.getBlockId(var23, var21, var22);

                                if (var24 > 0)
                                {
                                    if (!var20)
                                    {
                                        var20 = true;
                                        GL11.glNewList(this.glRenderList + var17, GL11.GL_COMPILE);
                                        var13.setRenderingChunk(true);
                                        var13.startDrawingQuads();
                                        var13.setTranslation((double)(-globalChunkOffsetX), 0.0D, (double)(-globalChunkOffsetZ));
                                    }

                                    Block var25 = Block.blocksList[var24];

                                    if (var17 == 0 && var25.hasTileEntity())
                                    {
                                        TileEntity var26 = var11.getBlockTileEntity(var23, var21, var22);

                                        if (TileEntityRenderer.instance.hasSpecialRenderer(var26))
                                        {
                                            this.tileEntityRenderers.add(var26);
                                        }
                                    }

                                    int var32 = var25.getRenderBlockPass();
                                    boolean var27 = true;

                                    if (var32 != var17)
                                    {
                                        var18 = true;
                                        var27 = false;
                                    }

                                    if (var15)
                                    {
                                        var27 = Reflector.callBoolean(var25, Reflector.ForgeBlock_canRenderInPass, new Object[] {Integer.valueOf(var17)});
                                    }

                                    if (var27)
                                    {
                                        var14.setEntity(var24, 0);
                                        var19 |= var12.renderBlockByRenderType(var25, var23, var21, var22);
                                        var14.setEntity(-1, 0);
                                    }
                                }
                            }
                        }
                    }

                    if (var20)
                    {
                        if (var1 != null)
                        {
                            var1.updating(var16);
                        }

                        this.bytesDrawn += var13.draw();
                        GL11.glEndList();
                        var13.setRenderingChunk(false);
                        var13.setTranslation(0.0D, 0.0D, 0.0D);
                    }
                    else
                    {
                        var19 = false;
                    }

                    if (var19)
                    {
                        var8[var17] = false;
                    }

                    if (!var18)
                    {
                        break;
                    }
                }
            }

            for (int var30 = 0; var30 < 2; ++var30)
            {
                this.skipRenderPass[var30] = var8[var30];
            }

            HashSet var31 = new HashSet();
            var31.addAll(this.tileEntityRenderers);
            var31.removeAll(var29);
            this.tileEntities.addAll(var31);
            var29.removeAll(this.tileEntityRenderers);
            this.tileEntities.removeAll(var29);
            this.isChunkLit = Chunk.isLit;
            this.isInitialized = true;
            this.isVisible = true;
            this.isVisibleFromPosition = false;
        }
    }

    public void finishUpdate()
    {
        int var1 = this.glRenderList;
        this.glRenderList = this.glRenderListStable;
        this.glRenderListStable = var1;

        for (int var2 = 0; var2 < 2; ++var2)
        {
            if (!this.skipRenderPass[var2])
            {
                GL11.glNewList(this.glRenderList + var2, GL11.GL_COMPILE);
                GL11.glEndList();
            }
        }

        if (this.needsBoxUpdate && !this.skipAllRenderPasses())
        {
            float var3 = 0.0F;
            GL11.glNewList(this.glRenderListBoundingBox, GL11.GL_COMPILE);
            RenderItem.renderAABB(AxisAlignedBB.getAABBPool().getAABB((double)((float)this.posXClip - var3), (double)((float)this.posYClip - var3), (double)((float)this.posZClip - var3), (double)((float)(this.posXClip + 16) + var3), (double)((float)(this.posYClip + 16) + var3), (double)((float)(this.posZClip + 16) + var3)));
            GL11.glEndList();
            this.needsBoxUpdate = false;
        }
    }

    /**
     * Takes in the pass the call list is being requested for. Args: renderPass
     */
    public int getGLCallListForPass(int var1)
    {
        return !this.isInFrustum ? -1 : (!this.skipRenderPass[var1] ? this.glRenderListStable + var1 : -1);
    }

    /**
     * Renders the occlusion query GL List
     */
    public void callOcclusionQueryList()
    {
        GL11.glCallList(this.glRenderListBoundingBox);
    }
}