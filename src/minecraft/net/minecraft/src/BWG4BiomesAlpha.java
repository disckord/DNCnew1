package net.minecraft.src;

public class BWG4BiomesAlpha extends BiomeGenBase
{
    private int biomeid;

    public BWG4BiomesAlpha(int var1)
    {
        super(var1);
        this.biomeid = var1;

        if (var1 == 90)
        {
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        }

        if (var1 == 91 || var1 == 92 || var1 == 93 || var1 == 96)
        {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
        }

        if (var1 == 98)
        {
            this.spawnableCreatureList.clear();
            this.topBlock = (byte)Block.sand.blockID;
            this.fillerBlock = (byte)Block.sand.blockID;
        }
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        if (this.biomeid != 96 && this.biomeid != 99)
        {
            if (this.biomeid == 97)
            {
                return ColorizerGrass.getGrassColor(1.0D, 0.4000000059604645D);
            }
            else
            {
                double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
                double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
                return ColorizerGrass.getGrassColor(var1, var3);
            }
        }
        else
        {
            return ColorizerGrass.getGrassColor(0.6000000238418579D, 0.6000000238418579D);
        }
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        if (this.biomeid != 96 && this.biomeid != 99)
        {
            if (this.biomeid == 97)
            {
                return ColorizerFoliage.getFoliageColor(1.0D, 0.4000000059604645D);
            }
            else
            {
                double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
                double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
                return ColorizerFoliage.getFoliageColor(var1, var3);
            }
        }
        else
        {
            return ColorizerFoliage.getFoliageColor(0.6000000238418579D, 0.6000000238418579D);
        }
    }
}
