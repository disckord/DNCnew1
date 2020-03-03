package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.lwjgl.opengl.GL11;

public class WorldRenderer
{
	Tessellator tessellator = Tessellator.instance;
    /** Reference to the World object. */
    public World worldObj;
    protected int glRenderList = -1;
    public static volatile int chunksUpdated = 0;
    public int posX;
    public int posY;
    public int posZ;

    /** Pos X minus */
    public int posXMinus;

    /** Pos Y minus */
    public int posYMinus;

    /** Pos Z minus */
    public int posZMinus;

    /** Pos X clipped */
    public int posXClip;

    /** Pos Y clipped */
    public int posYClip;

    /** Pos Z clipped */
    public int posZClip;
    public boolean isInFrustum = false;

    /** Should this renderer skip this render pass */
    public boolean[] skipRenderPass = new boolean[2];

    /** Pos X plus */
    public int posXPlus;

    /** Pos Y plus */
    public int posYPlus;

    /** Pos Z plus */
    public int posZPlus;

    /** Boolean for whether this renderer needs to be updated or not */
    public volatile boolean needsUpdate;

    /** Axis aligned bounding box */
    public AxisAlignedBB rendererBoundingBox;

    /** Chunk index */
    public int chunkIndex;

    /** Is this renderer visible according to the occlusion query */
    public boolean isVisible = true;

    /** Is this renderer waiting on the result of the occlusion query */
    public boolean isWaitingOnOcclusionQuery;

    /** OpenGL occlusion query */
    public int glOcclusionQuery;

    /** Is the chunk lit */
    public boolean isChunkLit;
    protected boolean isInitialized = false;

    /** All the tile entities that have special rendering code for this chunk */
    public List tileEntityRenderers = new ArrayList();
    protected List tileEntities;

    /** Bytes sent to the GPU */
    protected int bytesDrawn;
    public boolean isVisibleFromPosition = false;
    public double visibleFromX;
    public double visibleFromY;
    public double visibleFromZ;
    public boolean isInFrustrumFully = false;
    protected boolean needsBoxUpdate = false;
    public volatile boolean isUpdating = false;
    public static int globalChunkOffsetX = 0;
    public static int globalChunkOffsetZ = 0;

    public WorldRenderer(World par1World, List par2List, int par3, int par4, int par5, int par6)
    {
        this.worldObj = par1World;
        this.tileEntities = par2List;
        this.glRenderList = par6;
        this.posX = -999;
        this.setPosition(par3, par4, par5);
        this.needsUpdate = false;
    }

    /**
     * Sets a new position for the renderer and setting it up so it can be reloaded with the new data for that position
     */
    public void setPosition(int par1, int par2, int par3)
    {
        if (par1 != this.posX || par2 != this.posY || par3 != this.posZ)
        {
            this.setDontDraw();
            this.posX = par1;
            this.posY = par2;
            this.posZ = par3;
            this.posXPlus = par1 + 8;
            this.posYPlus = par2 + 8;
            this.posZPlus = par3 + 8;
            this.posXClip = par1 & 1023;
            this.posYClip = par2;
            this.posZClip = par3 & 1023;
            this.posXMinus = par1 - this.posXClip;
            this.posYMinus = par2 - this.posYClip;
            this.posZMinus = par3 - this.posZClip;
            float var4 = 0.0F;
            this.rendererBoundingBox = AxisAlignedBB.getBoundingBox((double)((float)par1 - var4), (double)((float)par2 - var4), (double)((float)par3 - var4), (double)((float)(par1 + 16) + var4), (double)((float)(par2 + 16) + var4), (double)((float)(par3 + 16) + var4));
            this.needsBoxUpdate = true;
            this.markDirty();
            this.isVisibleFromPosition = false;
        }
    }

    private void setupGLTranslation()
    {
        GL11.glTranslatef((float)this.posXClip, (float)this.posYClip, (float)this.posZClip);
    }

    /**
     * Will update this chunk renderer
     */
    public void updateRenderer()
    {
        if (this.worldObj != null && this.needsUpdate)
        {
            if (this.needsBoxUpdate)
            {
                float var1 = 0.0F;
                GL11.glNewList(this.glRenderList + 2, GL11.GL_COMPILE);
                RenderItem.renderAABB(AxisAlignedBB.getAABBPool().getAABB((double)((float)this.posXClip - var1), (double)((float)this.posYClip - var1), (double)((float)this.posZClip - var1), (double)((float)(this.posXClip + 16) + var1), (double)((float)(this.posYClip + 16) + var1), (double)((float)(this.posZClip + 16) + var1)));
                GL11.glEndList();
                this.needsBoxUpdate = false;
            }

            this.isVisible = true;
            this.isVisibleFromPosition = false;
            this.needsUpdate = false;
            int var25 = this.posX;
            int var2 = this.posY;
            int var3 = this.posZ;
            int var4 = this.posX + 16;
            int var5 = this.posY + 16;
            int var6 = this.posZ + 16;

            for (int var7 = 0; var7 < 2; ++var7)
            {
                this.skipRenderPass[var7] = true;
            }

            if (Reflector.LightCache.exists())
            {
                Object var26 = Reflector.getFieldValue(Reflector.LightCache_cache);
                Reflector.callVoid(var26, Reflector.LightCache_clear, new Object[0]);
                Reflector.callVoid(Reflector.BlockCoord_resetPool, new Object[0]);
            }

            Chunk.isLit = false;
            HashSet var27 = new HashSet();
            var27.addAll(this.tileEntityRenderers);
            this.tileEntityRenderers.clear();
            byte var8 = 1;
            ChunkCache var9 = new ChunkCache(this.worldObj, var25 - var8, var2 - var8, var3 - var8, var4 + var8, var5 + var8, var6 + var8, var8);

            if (!var9.extendedLevelsInChunkCache())
            {
                ++chunksUpdated;
                RenderBlocks var10 = new RenderBlocks(var9);
                this.bytesDrawn = 0;
                Tessellator var11 = Tessellator.instance;
                Tessellator var12 = Tessellator.instance;
                boolean var13 = Reflector.ForgeHooksClient.exists();

                for (int var14 = 0; var14 < 2; ++var14)
                {
                    boolean var15 = false;
                    boolean var16 = false;
                    boolean var17 = false;

                    for (int var18 = var2; var18 < var5; ++var18)
                    {
                        for (int var19 = var3; var19 < var6; ++var19)
                        {
                            for (int var20 = var25; var20 < var4; ++var20)
                            {
                                int var21 = var9.getBlockId(var20, var18, var19);

                                if (var21 > 0)
                                {
                                    if (!var17)
                                    {
                                        var17 = true;
                                        GL11.glNewList(this.glRenderList + var14, GL11.GL_COMPILE);
                                        tessellator.setRenderingChunk(true);
                                        tessellator.startDrawingQuads();
                                        tessellator.setTranslation((double)(-globalChunkOffsetX), 0.0D, (double)(-globalChunkOffsetZ));
                                    }

                                    Block var22 = Block.blocksList[var21];

                                    if (var22 != null)
                                    {
                                        if (var14 == 0 && var22.hasTileEntity())
                                        {
                                            TileEntity var23 = var9.getBlockTileEntity(var20, var18, var19);

                                            if (TileEntityRenderer.instance.hasSpecialRenderer(var23))
                                            {
                                                this.tileEntityRenderers.add(var23);
                                            }
                                        }

                                        int var29 = var22.getRenderBlockPass();
                                        boolean var24 = true;

                                        if (var29 != var14)
                                        {
                                            var15 = true;
                                            var24 = false;
                                        }

                                        if (var13)
                                        {
                                            var24 = Reflector.callBoolean(var22, Reflector.ForgeBlock_canRenderInPass, new Object[] {Integer.valueOf(var14)});
                                        }

                                        if (var24)
                                        {
                                        	tessellator.setEntity(var21, 0);
                                            var16 |= var10.renderBlockByRenderType(var22, var20, var18, var19);
                                            tessellator.setEntity(-1, 0);
                                        }
                                    }
                                }
                            }
                        }
                    }

                    if (var17)
                    {
                        this.bytesDrawn += var11.draw();
                        GL11.glEndList();
                        var11.setRenderingChunk(false);
                        var11.setTranslation(0.0D, 0.0D, 0.0D);
                    }
                    else
                    {
                        var16 = false;
                    }

                    if (var16)
                    {
                        this.skipRenderPass[var14] = false;
                    }

                    if (!var15)
                    {
                        break;
                    }
                }
            }

            HashSet var28 = new HashSet();
            var28.addAll(this.tileEntityRenderers);
            var28.removeAll(var27);
            this.tileEntities.addAll(var28);
            var27.removeAll(this.tileEntityRenderers);
            this.tileEntities.removeAll(var27);
            this.isChunkLit = Chunk.isLit;
            this.isInitialized = true;
        }
    }

    /**
     * Returns the distance of this chunk renderer to the entity without performing the final normalizing square root,
     * for performance reasons.
     */
    public float distanceToEntitySquared(Entity par1Entity)
    {
        float var2 = (float)(par1Entity.posX - (double)this.posXPlus);
        float var3 = (float)(par1Entity.posY - (double)this.posYPlus);
        float var4 = (float)(par1Entity.posZ - (double)this.posZPlus);
        return var2 * var2 + var3 * var3 + var4 * var4;
    }

    /**
     * When called this renderer won't draw anymore until its gets initialized again
     */
    public void setDontDraw()
    {
        for (int var1 = 0; var1 < 2; ++var1)
        {
            this.skipRenderPass[var1] = true;
        }

        this.isInFrustum = false;
        this.isInitialized = false;
    }

    public void stopRendering()
    {
        this.setDontDraw();
        this.worldObj = null;
    }

    /**
     * Takes in the pass the call list is being requested for. Args: renderPass
     */
    public int getGLCallListForPass(int par1)
    {
        return !this.isInFrustum ? -1 : (!this.skipRenderPass[par1] ? this.glRenderList + par1 : -1);
    }

    public void updateInFrustum(ICamera par1ICamera)
    {
        this.isInFrustum = par1ICamera.isBoundingBoxInFrustum(this.rendererBoundingBox);

        if (this.isInFrustum && Config.isOcclusionEnabled() && Config.isOcclusionFancy())
        {
            this.isInFrustrumFully = par1ICamera.isBoundingBoxInFrustumFully(this.rendererBoundingBox);
        }
        else
        {
            this.isInFrustrumFully = false;
        }
    }

    /**
     * Renders the occlusion query GL List
     */
    public void callOcclusionQueryList()
    {
        GL11.glCallList(this.glRenderList + 2);
    }

    /**
     * Checks if all render passes are to be skipped. Returns false if the renderer is not initialized
     */
    public boolean skipAllRenderPasses()
    {
        return !this.isInitialized ? false : this.skipRenderPass[0] && this.skipRenderPass[1];
    }

    /**
     * Marks the current renderer data as dirty and needing to be updated.
     */
    public void markDirty()
    {
        this.needsUpdate = true;
    }
}
