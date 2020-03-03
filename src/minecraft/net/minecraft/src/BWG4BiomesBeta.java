package net.minecraft.src;

import java.util.Random;

public class BWG4BiomesBeta extends BiomeGenBase
{
    private int biomeid;

    public BWG4BiomesBeta(int var1)
    {
        super(var1);
        this.biomeid = var1;

        if (var1 == 80 || var1 == 90)
        {
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
        }

        if (var1 == 81 || var1 == 82 || var1 == 83 || var1 == 86)
        {
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 1, 2));
        }

        if (var1 == 87)
        {
            this.spawnableCreatureList.clear();
            this.topBlock = (byte)Block.sand.blockID;
            this.fillerBlock = (byte)Block.sand.blockID;
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        return (WorldGenerator)(this.biomeid == 80 ? (var1.nextInt(3) == 0 ? new BWG4oldGenBigTree(2) : new BWG4oldGenTrees(2)) : (this.biomeid == 83 ? (var1.nextInt(5) == 0 ? this.worldGeneratorForest : (var1.nextInt(3) == 0 ? new BWG4oldGenBigTree(2) : new BWG4oldGenTrees(2))) : (this.biomeid == 86 ? (var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2(false)) : (this.biomeid == 90 ? (var1.nextInt(10) == 0 ? new BWG4oldGenBigTree(2) : (var1.nextInt(3) == 0 ? new WorldGenShrub(3, 0) : (var1.nextInt(2) == 0 ? (var1.nextInt(40) == 0 ? new WorldGenHugeTrees(false, 60 + var1.nextInt(5), 3, 3) : new WorldGenHugeTrees(false, 20 + var1.nextInt(15), 3, 3)) : new WorldGenTrees(false, 4 + var1.nextInt(7), 3, 3, true)))) : (var1.nextInt(10) == 0 ? new BWG4oldGenBigTree(2) : new BWG4oldGenTrees(2))))));
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        if (this.biomeid != 86 && this.biomeid != 89)
        {
            if (this.biomeid == 87)
            {
                return ColorizerFoliage.getFoliageColor(0.800000011920929D, 0.20000000298023224D);
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
        if (this.biomeid != 86 && this.biomeid != 89)
        {
            if (this.biomeid == 87)
            {
                return ColorizerFoliage.getFoliageColor(0.800000011920929D, 0.20000000298023224D);
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
