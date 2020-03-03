package net.minecraft.src;

import java.util.Random;

public class BWG4BiomesDefault extends BiomeGenBase
{
    private int biomeid;
    private int type;
    private int id;

    public BWG4BiomesDefault(int var1, int var2, int var3)
    {
        super(var1);
        this.biomeid = var1;
        this.type = var2;
        this.id = var3;
        this.theBiomeDecorator.usebwg4deco = true;

        if (this.type == 1)
        {
            if (this.id == 1)
            {
                this.spawnableCreatureList.clear();
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.grass = 4;
                this.theBiomeDecorator.tl1amount = 1;
            }

            if (this.id == 2)
            {
                this.theBiomeDecorator.mayrandtrees = false;
                this.theBiomeDecorator.grass = 8;
                this.theBiomeDecorator.redflowers = 4;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.sugarcane = 20;
                this.theBiomeDecorator.melon = 8;
                this.theBiomeDecorator.tl1amount = 5;
                this.theBiomeDecorator.cactus = 1;
                this.theBiomeDecorator.usetl2 = true;
                this.theBiomeDecorator.tl2miny = 0;
                this.theBiomeDecorator.tl2maxy = 75;
                this.theBiomeDecorator.tl2amount = 4;
            }

            if (this.id == 3)
            {
                this.theBiomeDecorator.mayrandtrees = false;
                this.theBiomeDecorator.redflowers = 4;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.waterlily = 5;
                this.theBiomeDecorator.sugarcane = 20;
                this.theBiomeDecorator.grass = 8;
                this.theBiomeDecorator.melon = 8;
                this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
                this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 1, 2));
                this.theBiomeDecorator.tl1amount = 15;
            }

            if (this.id == 4)
            {
                this.theBiomeDecorator.bigMushrooms = 1;
                this.theBiomeDecorator.brownmush = 1;
                this.theBiomeDecorator.redmush = 1;
                this.theBiomeDecorator.tl1amount = -20;
                this.theBiomeDecorator.redflowers = -20;
                this.theBiomeDecorator.yellowflowers = -20;
                this.topBlock = (byte)Block.mycelium.blockID;
                this.spawnableMonsterList.clear();
                this.spawnableCreatureList.clear();
                this.spawnableWaterCreatureList.clear();
                this.spawnableCreatureList.add(new SpawnListEntry(EntityMooshroom.class, 8, 4, 8));
            }

            if (this.id == 5)
            {
                this.spawnableCreatureList.clear();
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.grass = 4;
                this.theBiomeDecorator.tl1amount = 1;
                this.topBlock = (byte)Block.sand.blockID;
                this.fillerBlock = (byte)Block.sand.blockID;
            }

            if (this.id == 6)
            {
                this.spawnableCreatureList.clear();
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.grass = 4;
                this.theBiomeDecorator.tl1amount = 1;
                this.topBlock = (byte)Block.sand.blockID;
                this.fillerBlock = (byte)Block.sand.blockID;
            }
        }
        else if (this.type == 2)
        {
            if (this.id == 1)
            {
                this.theBiomeDecorator.mayrandtrees = false;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.redflowers = 3;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.grass = 6;
                this.theBiomeDecorator.brownmush = 1;
                this.theBiomeDecorator.redmush = 1;
                this.theBiomeDecorator.tl1amount = 12;
            }

            if (this.id == 2)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.grass = 3;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.tl1amount = 3;
            }

            if (this.id == 3)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.tl1amount = 5;
                this.theBiomeDecorator.grass = 6;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 1;
                this.theBiomeDecorator.brownmush = 1;
            }

            if (this.id == 4)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.theBiomeDecorator.tl1amount = -20;
                this.theBiomeDecorator.grass = -10;
                this.theBiomeDecorator.redflowers = -10;
                this.theBiomeDecorator.yellowflowers = -10;
            }

            if (this.id == 5)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.theBiomeDecorator.tl1amount = -20;
                this.theBiomeDecorator.grass = -10;
                this.theBiomeDecorator.redflowers = -10;
                this.theBiomeDecorator.yellowflowers = -10;
            }
        }
        else if (this.type == 3)
        {
            if (this.id == 1)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.theBiomeDecorator.grass = 8;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.tl1amount = 0;
                this.theBiomeDecorator.tl1chance = 4;
            }

            if (this.id == 2)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.grass = 3;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.tl1amount = 3;
            }

            if (this.id == 3)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.grass = 3;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.tl1amount = 2;
            }

            if (this.id == 4)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.grass = 3;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.tl1amount = 3;
            }

            if (this.id == 5)
            {
                this.theBiomeDecorator.mayrandtrees = false;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.redflowers = 3;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.grass = 6;
                this.theBiomeDecorator.brownmush = 1;
                this.theBiomeDecorator.redmush = 1;
                this.theBiomeDecorator.tl1amount = 12;
            }

            if (this.id == 6)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.emeralds = true;
                this.spawnableCreatureList.add(new SpawnListEntry(EntityWolf.class, 8, 4, 4));
                this.theBiomeDecorator.tl1amount = 4;
                this.theBiomeDecorator.grass = 6;
                this.theBiomeDecorator.redflowers = 2;
                this.theBiomeDecorator.yellowflowers = 1;
                this.theBiomeDecorator.brownmush = 1;
            }

            if (this.id == 7)
            {
                this.theBiomeDecorator.emeralds = true;
                this.theBiomeDecorator.tl1amount = -20;
                this.theBiomeDecorator.grass = 10;
                this.theBiomeDecorator.redflowers = 1;
                this.theBiomeDecorator.yellowflowers = 1;
            }
        }
        else if (this.type == 4)
        {
            if (this.id == 1)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.redflowers = 4;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.sugarcane = 20;
                this.theBiomeDecorator.grass = 8;
                this.theBiomeDecorator.melon = 8;
                this.theBiomeDecorator.tl1amount = 5;
                this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
                this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
            }

            if (this.id == 2 || this.id == 4)
            {
                this.theBiomeDecorator.mayrandtrees = false;
                this.theBiomeDecorator.redflowers = 4;
                this.theBiomeDecorator.yellowflowers = 2;
                this.theBiomeDecorator.sugarcane = 20;
                this.theBiomeDecorator.grass = 8;
                this.theBiomeDecorator.melon = 8;
                this.spawnableMonsterList.add(new SpawnListEntry(EntityOcelot.class, 2, 1, 1));
                this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
                this.theBiomeDecorator.tl1amount = 17;

                if (this.id != 4)
                {
                    this.theBiomeDecorator.waterlily = 4;
                    this.waterColorMultiplier = 10083127;
                }
            }

            if (this.id == 3 || this.id == 5)
            {
                this.theBiomeDecorator.mayrandtrees = true;
                this.theBiomeDecorator.tl1amount = 5;
                this.theBiomeDecorator.redflowers = 0;
                this.theBiomeDecorator.yellowflowers = 0;
                this.theBiomeDecorator.grass = 6;
                this.theBiomeDecorator.sugarcane = 40;
                this.theBiomeDecorator.brownmush = 4;
                this.theBiomeDecorator.redmush = 3;
                this.theBiomeDecorator.deadBush = 1;
                this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 1, 1, 1));

                if (this.id != 5)
                {
                    this.theBiomeDecorator.waterlily = 4;
                    this.waterColorMultiplier = 10083127;
                }
            }
        }
        else if (this.type == 5)
        {
            if (this.id == 1)
            {
                this.topBlock = 0;
                this.fillerBlock = (byte)Block.sand.blockID;
                this.theBiomeDecorator.deadBush = 2;
                this.theBiomeDecorator.cactus = 10;
                this.spawnableCreatureList.clear();
            }

            if (this.id == 2)
            {
                this.theBiomeDecorator.grass = 12;
                this.theBiomeDecorator.tl1amount = 1;
                this.theBiomeDecorator.tl1chance = 4;
            }

            if (this.id == 3)
            {
                this.theBiomeDecorator.grass = 6;
                this.theBiomeDecorator.tl1amount = 5;
            }

            if (this.id == 4)
            {
                this.theBiomeDecorator.grass = 3;
                this.theBiomeDecorator.tl1amount = 6;
                this.theBiomeDecorator.tl1maxy = 80;
            }

            if (this.id == 5)
            {
                this.spawnableCreatureList.clear();
            }
        }
        else if (this.type == 6)
        {
            if (this.id == 1)
            {
                this.spawnableCreatureList.clear();
            }

            if (this.id == 2)
            {
                this.spawnableCreatureList.clear();
            }

            if (this.id == 3)
            {
                this.spawnableCreatureList.clear();
                this.theBiomeDecorator.waterlily = 2;
                this.waterColorMultiplier = 10083127;
                this.theBiomeDecorator.tl1amount = -10;
            }

            if (this.id == 4)
            {
                this.spawnableCreatureList.clear();
                this.topBlock = 0;
                this.fillerBlock = (byte)Block.sand.blockID;
                this.theBiomeDecorator.deadBush = 2;
                this.theBiomeDecorator.cactus = 10;
            }
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random var1)
    {
        if (this.type == 1)
        {
            if (this.id == 1)
            {
                if (var1.nextInt(7) == 0)
                {
                    return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
                }

                if (var1.nextInt(8) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }

            if (this.id == 2)
            {
                if (var1.nextInt(10) == 0)
                {
                    return new WorldGenShrub(3, 0);
                }

                if (var1.nextInt(12) == 0)
                {
                    return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
                }

                if (var1.nextInt(5) == 0)
                {
                    return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
                }

                return this.worldGeneratorTrees;
            }

            if (this.id == 3)
            {
                if (var1.nextInt(8) == 0)
                {
                    return new BWG4decoBigTree(8 + var1.nextInt(7), 0);
                }

                if (var1.nextInt(4) == 0)
                {
                    return new WorldGenShrub(3, 0);
                }

                if (var1.nextInt(3) == 0)
                {
                    return new WorldGenHugeTrees(false, 20 + var1.nextInt(5), 3, 3);
                }

                return this.worldGeneratorTrees;
            }

            if (this.id == 5)
            {
                if (var1.nextInt(7) == 0)
                {
                    return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
                }

                if (var1.nextInt(8) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }

            if (this.id == 6)
            {
                if (var1.nextInt(7) == 0)
                {
                    return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
                }

                if (var1.nextInt(8) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }
        }
        else if (this.type == 2)
        {
            if (this.id == 1)
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

            if (this.id == 2)
            {
                if (var1.nextInt(7) == 0)
                {
                    return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
                }

                if (var1.nextInt(8) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }

            if (this.id == 3)
            {
                return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2(false));
            }
        }
        else if (this.type == 3)
        {
            if (this.id == 1)
            {
                return new BWG4decoBigTree(4 + var1.nextInt(11), 0);
            }

            if (this.id == 2 || this.id == 3 || this.id == 4)
            {
                if (var1.nextInt(7) == 0)
                {
                    return new BWG4decoBigTree(6 + var1.nextInt(9), 0);
                }

                if (var1.nextInt(8) == 0)
                {
                    return this.worldGeneratorForest;
                }

                return this.worldGeneratorTrees;
            }

            if (this.id == 5)
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

            if (this.id == 6)
            {
                return (WorldGenerator)(var1.nextInt(3) == 0 ? new WorldGenTaiga1() : new WorldGenTaiga2(false));
            }

            if (this.id == 7)
            {
                ;
            }
        }
        else if (this.type == 4)
        {
            if (this.id == 1)
            {
                if (var1.nextInt(4) == 0)
                {
                    return new BWG4decoBigTree(4 + var1.nextInt(11), 0);
                }

                return this.worldGeneratorTrees;
            }

            if (this.id == 2 || this.id == 4)
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

            if (this.id == 3 || this.id == 5)
            {
                if (this.id == 5)
                {
                    if (var1.nextInt(7) == 0)
                    {
                        return new BWG4decoBigTree(4 + var1.nextInt(11), 0);
                    }

                    if (var1.nextInt(6) == 0)
                    {
                        return new WorldGenShrub(3, 0);
                    }

                    if (var1.nextInt(6) == 0)
                    {
                        return this.worldGeneratorTrees;
                    }
                }

                return new BWG4decoSwampTrees(var1.nextInt(6) + 5);
            }
        }
        else if (this.type == 5)
        {
            if (this.id == 2)
            {
                return new BWG4decoGold4(2);
            }

            if (this.id == 3)
            {
                if (var1.nextInt(7) == 0)
                {
                    return new WorldGenShrub(3, 0);
                }

                return new BWG4decoGold4(2);
            }

            if (this.id == 4)
            {
                return new WorldGenShrub(3, 0);
            }
        }

        return new WorldGenShrub(3, 0);
    }

    public WorldGenerator getRandomWorldGenForTrees2(Random var1)
    {
        return new BWG4decoSurvival(4);
    }

    public void decorate(World var1, Random var2, int var3, int var4)
    {
        super.decorate(var1, var2, var3, var4);
        int var5;
        int var6;
        int var7;

        if (this.type == 1 && this.id == 6)
        {
            for (var5 = 0; var5 < 10; ++var5)
            {
                var6 = var3 + var2.nextInt(16) + 8;
                var7 = var4 + var2.nextInt(16) + 8;
                (new BWG4decoDefault(1)).generate(var1, var2, var6, var1.getHeightValue(var6, var7), var7);
            }
        }

        if (this.type == 5 && this.id == 4)
        {
            for (var5 = 0; var5 < 8; ++var5)
            {
                var6 = var3 + var2.nextInt(16) + 8;
                var7 = var4 + var2.nextInt(16) + 8;
                (new BWG4decoGold4(1)).generate(var1, var2, var6, var1.getHeightValue(var6, var7), var7);
            }
        }
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random var1)
    {
        return this.type == 4 && this.id == 1 ? (var1.nextInt(4) == 0 ? new WorldGenTallGrass(Block.tallGrass.blockID, 2) : new WorldGenTallGrass(Block.tallGrass.blockID, 1)) : new WorldGenTallGrass(Block.tallGrass.blockID, 1);
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        if (this.type == 2)
        {
            return ColorizerGrass.getGrassColor(0.6000000238418579D, 0.6000000238418579D);
        }
        else
        {
            double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
            return ColorizerGrass.getGrassColor(var1, var3);
        }
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        if (this.type == 2)
        {
            return ColorizerFoliage.getFoliageColor(0.6000000238418579D, 0.6000000238418579D);
        }
        else
        {
            double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
            double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
            return ColorizerFoliage.getFoliageColor(var1, var3);
        }
    }
}
