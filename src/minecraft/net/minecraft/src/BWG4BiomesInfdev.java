package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class BWG4BiomesInfdev extends BiomeGenBase
{
    public BWG4BiomesInfdev(int var1)
    {
        super(var1);
        this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 1, 2, 3));
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {	if(Minecraft.getMinecraft().gameSettings.alphaFoliage)
        return 16777215;
    else
        return 11272039;
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {if(Minecraft.getMinecraft().gameSettings.alphaFoliage)
    	return 16777215;
    else
        return 5242667;
    }

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float var1)
    {
        return 9420543;
    }
}
