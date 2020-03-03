package net.minecraft.src;

public class WorldProviderHell extends WorldProvider
{
    /**
     * creates a new world chunk manager for WorldProvider
     */
    public void registerWorldChunkManager()
    {
        if (this.worldObj.getWorldInfo().getTerrainType() != WorldType.BWG4ISLAND && this.worldObj.getWorldInfo().getTerrainType() != WorldType.BWG4SKYLAND)
        {
            if (this.worldObj.getWorldInfo().getTerrainType() != WorldType.BWG4SKY1 && this.worldObj.getWorldInfo().getTerrainType() != WorldType.BWG4SKY2)
            {
                this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.hell, 1.0F, 0.0F);
            }
            else
            {
                this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.SURVIVALnether, 1.0F, 0.0F);
            }
        }
        else
        {
            this.worldChunkMgr = new WorldChunkManagerHell(BiomeGenBase.SURVIVALnether, 1.0F, 0.0F);
        }

        this.isHellWorld = true;
        this.hasNoSky = true;
        this.dimensionId = -1;
    }

    /**
     * Return Vec3D with biome specific fog color
     */
    public Vec3 getFogColor(float par1, float par2)
    {
        return this.worldObj.getWorldVec3Pool().getVecFromPool(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
    }

    /**
     * Creates the light to brightness table
     */
    protected void generateLightBrightnessTable()
    {
        float var1 = 0.1F;

        for (int var2 = 0; var2 <= 15; ++var2)
        {
            float var3 = 1.0F - (float)var2 / 15.0F;
            this.lightBrightnessTable[var2] = (1.0F - var3) / (var3 * 3.0F + 1.0F) * (1.0F - var1) + var1;
        }
    }

    /**
     * Returns a new chunk provider which generates chunks for this world
     */
    public IChunkProvider createChunkGenerator()
    {
        byte var1 = 1;
        String var2 = "";
        String var3 = "1";
        String var4 = "2";
        String var5 = "3";
        String var6 = "4";
        String var7 = "5";
        String var8 = this.worldObj.getWorldInfo().getGeneratorOptions();

        if (var8.equals(var2))
        {
            var1 = 1;
        }

        if (var8.equals(var3))
        {
            var1 = 1;
        }

        if (var8.equals(var4))
        {
            var1 = 2;
        }

        if (var8.equals(var5))
        {
            var1 = 3;
        }

        if (var8.equals(var6))
        {
            var1 = 4;
        }

        if (var8.equals(var7))
        {
            var1 = 5;
        }

        return (IChunkProvider)(this.terrainType != WorldType.BWG4ISLAND && this.terrainType != WorldType.BWG4SKYLAND ? (this.terrainType != WorldType.BWG4SKY1 && this.terrainType != WorldType.BWG4SKY2 ? (this.terrainType == WorldType.BWG4SKYBLOCK ? new BWG4ChunkProviderSkyBlock(this.worldObj, this.worldObj.getSeed(), true, var1) : new ChunkProviderHell(this.worldObj, this.worldObj.getSeed())) : new BWG4ChunkProviderSky(this.worldObj, this.worldObj.getSeed(), this.worldObj.getWorldInfo().isMapFeaturesEnabled(), 4)) : new BWG4ChunkProviderSurvivalNether(this.worldObj, this.worldObj.getSeed()));
    }

    /**
     * Returns 'true' if in the "main surface world", but 'false' if in the Nether or End dimensions.
     */
    public boolean isSurfaceWorld()
    {
        return false;
    }

    /**
     * Will check if the x, z position specified is alright to be set as the map spawn point
     */
    public boolean canCoordinateBeSpawn(int par1, int par2)
    {
        return false;
    }

    /**
     * Calculates the angle of sun and moon in the sky relative to a specified time (usually worldTime)
     */
    public float calculateCelestialAngle(long par1, float par3)
    {
        return 0.5F;
    }

    /**
     * True if the player can respawn in this dimension (true = overworld, false = nether).
     */
    public boolean canRespawnHere()
    {
        return false;
    }

    /**
     * Returns true if the given X,Z coordinate should show environmental fog.
     */
    public boolean doesXZShowFog(int par1, int par2)
    {
        return true;
    }

    /**
     * Returns the dimension's name, e.g. "The End", "Nether", or "Overworld".
     */
    public String getDimensionName()
    {
        return "Nether";
    }
}
