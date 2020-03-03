package net.minecraft.src;

import java.util.Random;

public class BWG4BiomesSurvival extends BiomeGenBase
{
    int biomeID;

    public BWG4BiomesSurvival(int var1)
    {
        super(var1);
        this.biomeID = var1;

        if (this.biomeID == 107)
        {
            this.theBiomeDecorator.usebwg4deco = true;
            this.theBiomeDecorator.tl1amount = -20;
        }
        else if (this.biomeID == 108)
        {
            this.theBiomeDecorator.usebwg4deco = true;
            this.theBiomeDecorator.tl1amount = -20;
        }
        else if (this.biomeID == 109)
        {
            this.theBiomeDecorator.usebwg4deco = true;
            this.theBiomeDecorator.tl1amount = -20;
        }
        else if (this.biomeID == 110)
        {
            this.theBiomeDecorator.usebwg4deco = true;
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.tl1amount = 4;
            this.theBiomeDecorator.usetl2 = true;
            this.theBiomeDecorator.tl2miny = 0;
            this.theBiomeDecorator.tl2maxy = 75;
            this.theBiomeDecorator.tl2amount = 1;
            this.theBiomeDecorator.redflowers = 3;
            this.theBiomeDecorator.yellowflowers = 3;
            this.theBiomeDecorator.grass = 4;
            this.theBiomeDecorator.deadBush = 1;
            this.theBiomeDecorator.sugarcane = 20;
            this.theBiomeDecorator.cactus = 1;
            this.theBiomeDecorator.melon = 25;
            this.theBiomeDecorator.pumpkin = 25;
            this.theBiomeDecorator.waterliquid = 50;
            this.theBiomeDecorator.lavaliquid = 20;
        }
        else if (this.biomeID == 113)
        {
            this.theBiomeDecorator.usebwg4deco = true;
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.tl1amount = 4;
            this.theBiomeDecorator.redflowers = 3;
            this.theBiomeDecorator.yellowflowers = 3;
            this.theBiomeDecorator.grass = 4;
            this.theBiomeDecorator.melon = 8;
            this.theBiomeDecorator.pumpkin = 8;
        }
        else if (this.biomeID == 115)
        {
            this.theBiomeDecorator.usebwg4deco = true;
            this.theBiomeDecorator.mayrandtrees = true;
            this.theBiomeDecorator.tl1amount = 10;
            this.theBiomeDecorator.yellowflowers = 1;
            this.theBiomeDecorator.redflowers = 2;
            this.theBiomeDecorator.grass = 4;
            this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 5, 4, 4));
        }
        else if (this.biomeID == 116)
        {
            this.theBiomeDecorator.usebwg4deco = true;
            this.theBiomeDecorator.mayrandtrees = false;
            this.theBiomeDecorator.redflowers = 4;
            this.theBiomeDecorator.yellowflowers = 2;
            this.theBiomeDecorator.waterlily = 5;
            this.theBiomeDecorator.sugarcane = 20;
            this.theBiomeDecorator.grass = 8;
            this.theBiomeDecorator.melon = 8;
            this.theBiomeDecorator.tl1amount = 14;
            this.waterColorMultiplier = 10083127;
            this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
            this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
        }
        else if (this.biomeID == 119)
        {
            this.spawnableMonsterList.clear();
            this.spawnableCreatureList.clear();
            this.spawnableWaterCreatureList.clear();
            this.spawnableCaveCreatureList.clear();
            this.spawnableMonsterList.add(new SpawnListEntry(EntityGhast.class, 50, 4, 4));
            this.spawnableMonsterList.add(new SpawnListEntry(EntityPigZombie.class, 100, 4, 4));
        //    this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
         //   this.spawnableMonsterList.add(new SpawnListEntry(EntityMagmaCube.class, 1, 4, 4));
           // this.spawnableMonsterList.add(new SpawnListEntry(EntityBlaze.class, 25, 4, 4));
        }
        else if (this.biomeID == 120)
        {
            ;
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        if (this.biomeID != 107 && this.biomeID != 108 && this.biomeID != 109)
        {
            if (this.biomeID == 110)
            {
                if (var1.nextInt(5) == 0)
                {
                    return this.worldGeneratorForest;
                }

                if (var1.nextInt(4) == 0)
                {
                    return new BWG4decoBigTree(var1.nextInt(5) + 9, 0);
                }

                return new BWG4oldGenTrees(2);
            }

            if (this.biomeID == 113)
            {
                if (var1.nextInt(5) == 0)
                {
                    return this.worldGeneratorForest;
                }

                if (var1.nextInt(4) == 0)
                {
                    return new BWG4decoBigTree(var1.nextInt(5) + 9, 0);
                }

                return new BWG4oldGenTrees(2);
            }

            if (this.biomeID == 115)
            {
                if (var1.nextInt(5) == 0)
                {
                    return new BWG4decoGold1(3, 6, 16, 3);
                }

                if (var1.nextInt(2) == 0)
                {
                    return new BWG4decoGold1(1, 6, 14, 0);
                }

                if (var1.nextInt(2) == 0)
                {
                    return new BWG4decoGold1(2, 6, 12, 3);
                }

                return this.worldGeneratorTrees;
            }

            if (this.biomeID == 116)
            {
                if (var1.nextInt(8) == 0)
                {
                    return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
                }

                if (var1.nextInt(4) == 0)
                {
                    return new WorldGenShrub(3, 0);
                }

                if (var1.nextInt(3) != 0)
                {
                    return new WorldGenHugeTrees(false, 15 + var1.nextInt(10), 3, 3);
                }

                return new WorldGenTrees(false, 4 + var1.nextInt(7), 3, 3, true);
            }
        }

        return new BWG4oldGenTrees(2);
    }

    public WorldGenerator getRandomWorldGenForTrees2(Random var1)
    {
        return (WorldGenerator)(this.biomeID == 110 ? new BWG4decoSurvival(4) : new BWG4oldGenTrees(2));
    }

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        super.decorate(var1, var2, var3, var4);

        if (this.biomeID == 116)
        {
            WorldGenVines var5 = new WorldGenVines();

            for (int var6 = 0; var6 < 50; ++var6)
            {
                int var7 = var3 + var2.nextInt(16) + 8;
                byte var8 = 64;
                int var9 = var4 + var2.nextInt(16) + 8;
                var5.generate(var1, var2, var7, var8, var9);
            }
        }
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        if (this.biomeID != 109 && this.biomeID != 115)
        {
            double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
            return ColorizerGrass.getGrassColor(var1, var3);
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
        if (this.biomeID != 109 && this.biomeID != 115)
        {
            double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
            return ColorizerFoliage.getFoliageColor(var1, var3);
        }
        else
        {
            return ColorizerFoliage.getFoliageColor(0.6000000238418579D, 0.6000000238418579D);
        }
    }
}
