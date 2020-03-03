package net.minecraft.src;

import java.util.Random;

public class BiomeDecorator
{
    /** The world the BiomeDecorator is currently decorating */
    protected World currentWorld;

    /** The Biome Decorator's random number generator. */
    protected Random randomGenerator;

    /** The X-coordinate of the chunk currently being decorated */
    protected int chunk_X;

    /** The Z-coordinate of the chunk currently being decorated */
    protected int chunk_Z;

    /** The biome generator object. */
    protected BiomeGenBase biome;
    protected boolean usebwg4deco;
    public BWG4NoiseOctavesBeta TreeNoise;
    protected boolean mayrandtrees;
    protected int tl1miny;
    protected int tl1maxy;
    protected int tl1amount;
    protected int tl1chance;
    protected boolean usetl2;
    protected int tl2miny;
    protected int tl2maxy;
    protected int tl2amount;
    protected int tl2chance;
    protected boolean shiftoreheight;
    protected boolean disableoreheight;
    protected boolean emeralds;
    protected boolean silverfish;

    /** The dirt generator. */
    protected WorldGenerator dirtGen;
    protected WorldGenerator gravelGen;
    protected WorldGenerator coalGen;
    protected WorldGenerator ironGen;

    /** Field that holds gold WorldGenMinable */
    protected WorldGenerator goldGen;

    /** Field that holds redstone WorldGenMinable */
    protected WorldGenerator redstoneGen;

    /** Field that holds diamond WorldGenMinable */
    protected WorldGenerator diamondGen;

    /** Field that holds Lapis WorldGenMinable */
    protected WorldGenerator lapisGen;
    protected WorldGenerator emeraldGen;
    protected WorldGenerator silverfishGen;
    protected int bigMushrooms;
    protected int redflowers;
    protected int yellowflowers;
    protected int grass;
    protected int grassminy;
    protected int grassmaxy;
    protected int deadBush;
    protected int waterlily;
    protected int brownmush;
    protected int redmush;
    protected int sugarcane;
    protected int cactus;
    protected int melon;
    protected int pumpkin;
    protected int waterliquid;
    protected int lavaliquid;

    /** The clay generator. */
    protected WorldGenerator clayGen = new WorldGenClay(4);

    /** The sand generator. */
    protected WorldGenerator sandGen;

    /** The gravel generator. */
    protected WorldGenerator gravelAsSandGen;

    /** Field that holds one of the plantYellow WorldGenFlowers */
    protected WorldGenerator plantYellowGen;

    /** Field that holds one of the plantRed WorldGenFlowers */
    protected WorldGenerator plantRedGen;

    /** Field that holds mushroomBrown WorldGenFlowers */
    protected WorldGenerator mushroomBrownGen;

    /** Field that holds mushroomRed WorldGenFlowers */
    protected WorldGenerator mushroomRedGen;

    /** Field that holds big mushroom generator */
    protected WorldGenerator bigMushroomGen;

    /** Field that holds WorldGenReed */
    protected WorldGenerator reedGen;

    /** Field that holds WorldGenCactus */
    protected WorldGenerator cactusGen;

    /** The water lily generation! */
    protected WorldGenerator waterlilyGen;

    /** Amount of waterlilys per chunk. */
    protected int waterlilyPerChunk;

    /**
     * The number of trees to attempt to generate per chunk. Up to 10 in forests, none in deserts.
     */
    protected int treesPerChunk;

    /**
     * The number of yellow flower patches to generate per chunk. The game generates much less than this number, since
     * it attempts to generate them at a random altitude.
     */
    protected int flowersPerChunk;

    /** The amount of tall grass to generate per chunk. */
    protected int grassPerChunk;

    /**
     * The number of dead bushes to generate per chunk. Used in deserts and swamps.
     */
    protected int deadBushPerChunk;

    /**
     * The number of extra mushroom patches per chunk. It generates 1/4 this number in brown mushroom patches, and 1/8
     * this number in red mushroom patches. These mushrooms go beyond the default base number of mushrooms.
     */
    protected int mushroomsPerChunk;

    /**
     * The number of reeds to generate per chunk. Reeds won't generate if the randomly selected placement is unsuitable.
     */
    protected int reedsPerChunk;

    /**
     * The number of cactus plants to generate per chunk. Cacti only work on sand.
     */
    protected int cactiPerChunk;

    /**
     * The number of sand patches to generate per chunk. Sand patches only generate when part of it is underwater.
     */
    protected int sandPerChunk;

    /**
     * The number of sand patches to generate per chunk. Sand patches only generate when part of it is underwater. There
     * appear to be two separate fields for this.
     */
    protected int sandPerChunk2;

    /**
     * The number of clay patches to generate per chunk. Only generates when part of it is underwater.
     */
    protected int clayPerChunk;

    /** Amount of big mushrooms per chunk */
    protected int bigMushroomsPerChunk;

    /** True if decorator should generate surface lava & water */
    public boolean generateLakes;

    public BiomeDecorator(BiomeGenBase par1BiomeGenBase)
    {
        this.biome = par1BiomeGenBase;
        this.usebwg4deco = false;
        this.mayrandtrees = true;
        this.tl1miny = 0;
        this.tl1maxy = 128;
        this.tl1amount = 2;
        this.tl1chance = 1;
        this.usetl2 = false;
        this.tl2miny = 0;
        this.tl2maxy = 128;
        this.tl2amount = 0;
        this.tl2chance = 1;
        this.shiftoreheight = false;
        this.disableoreheight = false;
        this.emeralds = false;
        this.silverfish = false;
        this.dirtGen = new WorldGenMinable(Block.dirt.blockID, 32);
        this.gravelGen = new WorldGenMinable(Block.gravel.blockID, 32);
        this.coalGen = new WorldGenMinable(Block.oreCoal.blockID, 16);
        this.ironGen = new WorldGenMinable(Block.oreIron.blockID, 8);
        this.goldGen = new WorldGenMinable(Block.oreGold.blockID, 8);
        this.redstoneGen = new WorldGenMinable(Block.oreRedstone.blockID, 7);
        this.diamondGen = new WorldGenMinable(Block.oreDiamond.blockID, 7);
        this.lapisGen = new WorldGenMinable(Block.oreLapis.blockID, 6);
        this.emeraldGen = new WorldGenMinable(Block.oreEmerald.blockID, 1);
        this.silverfishGen = new WorldGenMinable(Block.silverfish.blockID, 1);
        this.bigMushrooms = 0;
        this.redflowers = 1;
        this.yellowflowers = 1;
        this.grass = 1;
        this.grassminy = 0;
        this.grassmaxy = 128;
        this.deadBush = 0;
        this.waterlily = 0;
        this.brownmush = 0;
        this.redmush = 0;
        this.sugarcane = 10;
        this.cactus = 0;
        this.melon = 32;
        this.pumpkin = 32;
        this.waterliquid = 50;
        this.lavaliquid = 20;
        this.sandGen = new WorldGenSand(7, Block.sand.blockID);
        this.gravelAsSandGen = new WorldGenSand(6, Block.gravel.blockID);
        this.plantYellowGen = new WorldGenFlowers(Block.plantYellow.blockID);
        this.plantRedGen = new WorldGenFlowers(Block.plantRed.blockID);
        this.mushroomBrownGen = new WorldGenFlowers(Block.mushroomBrown.blockID);
        this.mushroomRedGen = new WorldGenFlowers(Block.mushroomRed.blockID);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.reedGen = new WorldGenReed();
        this.cactusGen = new WorldGenCactus();
        this.waterlilyGen = new WorldGenWaterlily();
        this.waterlilyPerChunk = 0;
        this.treesPerChunk = 0;
        this.flowersPerChunk = 2;
        this.grassPerChunk = 1;
        this.deadBushPerChunk = 0;
        this.mushroomsPerChunk = 0;
        this.reedsPerChunk = 0;
        this.cactiPerChunk = 0;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.bigMushroomsPerChunk = 0;
        this.generateLakes = true;
    }

    /**
     * Decorates the world. Calls code that was formerly (pre-1.8) in ChunkProviderGenerate.populate
     */
    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        if (this.currentWorld != null)
        {
            throw new RuntimeException("Already decorating!!");
        }
        else
        {
            this.currentWorld = par1World;
            this.TreeNoise = new BWG4NoiseOctavesBeta(par2Random, 8);
            this.randomGenerator = par2Random;
            this.chunk_X = par3;
            this.chunk_Z = par4;
            this.decorate();
            this.currentWorld = null;
            this.randomGenerator = null;
        }
    }

    /**
     * The method that does the work of actually decorating chunks
     */
    protected void decorate()
    {
        int var3;
        int var4;
        int var5;

        if (this.usebwg4deco)
        {
            this.generateOres();
            double var1 = 0.5D;
            var3 = (int)((this.TreeNoise.func_806_a((double)this.chunk_X * var1, (double)this.chunk_Z * var1) / 8.0D + this.randomGenerator.nextDouble() * 4.0D + 4.0D) / 3.0D);

            if (var3 < 0)
            {
                var3 = 0;
            }

            var3 += this.tl1amount;

            if (!this.mayrandtrees)
            {
                var3 = this.tl1amount;
            }

            if (this.randomGenerator.nextInt(10) == 0)
            {
                ++var3;
            }

            int var6;

            for (var4 = 0; var4 < var3; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;

                if (this.currentWorld.getHeightValue(var5, var6) < this.tl1maxy && this.currentWorld.getHeightValue(var5, var6) > this.tl1miny && this.randomGenerator.nextInt(this.tl1chance) == 0)
                {
                    WorldGenerator var7 = this.biome.getRandomWorldGenForTrees(this.randomGenerator);
                    var7.setScale(1.0D, 1.0D, 1.0D);
                    var7.generate(this.currentWorld, this.randomGenerator, var5, this.currentWorld.getHeightValue(var5, var6), var6);
                }
            }

            WorldGenerator var8;
            int var10;

            if (this.usetl2)
            {
                var4 = (int)((this.TreeNoise.func_806_a((double)this.chunk_X * var1, (double)this.chunk_Z * var1) / 8.0D + this.randomGenerator.nextDouble() * 4.0D + 4.0D) / 3.0D);

                if (var4 < 0)
                {
                    var4 = 0;
                }

                var4 += this.tl2amount;

                if (!this.mayrandtrees)
                {
                    var4 = this.tl2amount;
                }

                if (this.randomGenerator.nextInt(10) == 0)
                {
                    ++var4;
                }

                for (var5 = 0; var5 < var4; ++var5)
                {
                    var6 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;

                    if (this.currentWorld.getHeightValue(var6, var10) < this.tl2maxy && this.currentWorld.getHeightValue(var6, var10) > this.tl2miny && this.randomGenerator.nextInt(this.tl2chance) == 0)
                    {
                        var8 = this.biome.getRandomWorldGenForTrees2(this.randomGenerator);
                        var8.setScale(1.0D, 1.0D, 1.0D);
                        var8.generate(this.currentWorld, this.randomGenerator, var6, this.currentWorld.getHeightValue(var6, var10), var10);
                    }
                }
            }

            for (var4 = 0; var4 < this.bigMushrooms; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenBigMushroom()).generate(this.currentWorld, this.randomGenerator, var5, this.currentWorld.getHeightValue(var5, var6), var6);
            }

            for (var4 = 0; var4 < this.yellowflowers; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.randomGenerator.nextInt(128);
                var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantYellow.blockID)).generate(this.currentWorld, this.randomGenerator, var5, var6, var10);
            }

            for (var4 = 0; var4 < this.redflowers; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.randomGenerator.nextInt(128);
                var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenFlowers(Block.plantRed.blockID)).generate(this.currentWorld, this.randomGenerator, var5, var6, var10);
            }

            for (var4 = 0; var4 < this.grass; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.randomGenerator.nextInt(128);
                var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;

                if (var6 > this.grassminy && var6 < this.grassmaxy)
                {
                    var8 = this.biome.getRandomWorldGenForGrass(this.randomGenerator);
                    var8.generate(this.currentWorld, this.randomGenerator, var5, var6, var10);
                }
            }

            for (var4 = 0; var4 < this.deadBush; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.randomGenerator.nextInt(128);
                var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenDeadBush(Block.deadBush.blockID)).generate(this.currentWorld, this.randomGenerator, var5, var6, var10);
            }

            for (var4 = 0; var4 < this.waterlily; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;

                for (var10 = this.randomGenerator.nextInt(128); var10 > 0 && this.currentWorld.getBlockId(var5, var10 - 1, var6) == 0; --var10)
                {
                    ;
                }

                (new WorldGenWaterlily()).generate(this.currentWorld, this.randomGenerator, var5, var10, var6);
            }

            for (var4 = 0; var4 < this.brownmush; ++var4)
            {
                if (this.randomGenerator.nextInt(4) == 0)
                {
                    var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                    var10 = this.currentWorld.getHeightValue(var5, var6);
                    this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, var5, var10, var6);
                }
            }

            for (var4 = 0; var4 < this.redmush; ++var4)
            {
                if (this.randomGenerator.nextInt(6) == 0)
                {
                    var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                    var10 = this.currentWorld.getHeightValue(var5, var6);
                    this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, var5, var10, var6);
                }
            }

            if (this.randomGenerator.nextInt(4) == 0)
            {
                var4 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var5 = this.randomGenerator.nextInt(128);
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, var4, var5, var6);
            }

            if (this.randomGenerator.nextInt(8) == 0)
            {
                var4 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var5 = this.randomGenerator.nextInt(128);
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, var4, var5, var6);
            }

            for (var4 = 0; var4 < this.sugarcane; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                var10 = this.randomGenerator.nextInt(128);
                this.reedGen.generate(this.currentWorld, this.randomGenerator, var5, var10, var6);
            }

            if (this.randomGenerator.nextInt(this.melon) == 0)
            {
                var4 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var5 = this.randomGenerator.nextInt(128);
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new BWG4decoPumpkin(1)).generate(this.currentWorld, this.randomGenerator, var4, var5, var6);
            }

            if (this.randomGenerator.nextInt(this.pumpkin) == 0)
            {
                var4 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var5 = this.randomGenerator.nextInt(128);
                var6 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new BWG4decoPumpkin(0)).generate(this.currentWorld, this.randomGenerator, var4, var5, var6);
            }

            for (var4 = 0; var4 < this.cactus; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.randomGenerator.nextInt(128);
                var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.cactusGen.generate(this.currentWorld, this.randomGenerator, var5, var6, var10);
            }

            for (var4 = 0; var4 < this.waterliquid; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.randomGenerator.nextInt(this.randomGenerator.nextInt(120) + 8);
                var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Block.waterMoving.blockID)).generate(this.currentWorld, this.randomGenerator, var5, var6, var10);
            }

            for (var4 = 0; var4 < this.lavaliquid; ++var4)
            {
                var5 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var6 = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(112) + 8) + 8);
                var10 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(this.currentWorld, this.randomGenerator, var5, var6, var10);
            }
        }
        else
        {
            this.generateOres();
            int var2;
            int var9;

            for (var9 = 0; var9 < this.sandPerChunk2; ++var9)
            {
                var2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var3 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.sandGen.generate(this.currentWorld, this.randomGenerator, var2, this.currentWorld.getTopSolidOrLiquidBlock(var2, var3), var3);
            }

            for (var9 = 0; var9 < this.clayPerChunk; ++var9)
            {
                var2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var3 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.clayGen.generate(this.currentWorld, this.randomGenerator, var2, this.currentWorld.getTopSolidOrLiquidBlock(var2, var3), var3);
            }

            for (var9 = 0; var9 < this.sandPerChunk; ++var9)
            {
                var2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var3 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.sandGen.generate(this.currentWorld, this.randomGenerator, var2, this.currentWorld.getTopSolidOrLiquidBlock(var2, var3), var3);
            }

            var9 = this.treesPerChunk;

            if (this.randomGenerator.nextInt(10) == 0)
            {
                ++var9;
            }

            for (var2 = 0; var2 < var9; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                WorldGenerator var11 = this.biome.getRandomWorldGenForTrees(this.randomGenerator);
                var11.setScale(1.0D, 1.0D, 1.0D);
                var11.generate(this.currentWorld, this.randomGenerator, var3, this.currentWorld.getHeightValue(var3, var4), var4);
            }

            for (var2 = 0; var2 < this.bigMushroomsPerChunk; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.bigMushroomGen.generate(this.currentWorld, this.randomGenerator, var3, this.currentWorld.getHeightValue(var3, var4), var4);
            }

            for (var2 = 0; var2 < this.flowersPerChunk; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.randomGenerator.nextInt(128);
                var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.plantYellowGen.generate(this.currentWorld, this.randomGenerator, var3, var4, var5);

                if (this.randomGenerator.nextInt(4) == 0)
                {
                    var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var4 = this.randomGenerator.nextInt(128);
                    var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                    this.plantRedGen.generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
                }
            }

            for (var2 = 0; var2 < this.grassPerChunk; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.randomGenerator.nextInt(128);
                var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                WorldGenerator var12 = this.biome.getRandomWorldGenForGrass(this.randomGenerator);
                var12.generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
            }

            for (var2 = 0; var2 < this.deadBushPerChunk; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.randomGenerator.nextInt(128);
                var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenDeadBush(Block.deadBush.blockID)).generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
            }

            for (var2 = 0; var2 < this.waterlilyPerChunk; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;

                for (var5 = this.randomGenerator.nextInt(128); var5 > 0 && this.currentWorld.getBlockId(var3, var5 - 1, var4) == 0; --var5)
                {
                    ;
                }

                this.waterlilyGen.generate(this.currentWorld, this.randomGenerator, var3, var5, var4);
            }

            for (var2 = 0; var2 < this.mushroomsPerChunk; ++var2)
            {
                if (this.randomGenerator.nextInt(4) == 0)
                {
                    var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                    var5 = this.currentWorld.getHeightValue(var3, var4);
                    this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, var3, var5, var4);
                }

                if (this.randomGenerator.nextInt(8) == 0)
                {
                    var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                    var5 = this.randomGenerator.nextInt(128);
                    this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, var3, var5, var4);
                }
            }

            if (this.randomGenerator.nextInt(4) == 0)
            {
                var2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var3 = this.randomGenerator.nextInt(128);
                var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, var2, var3, var4);
            }

            if (this.randomGenerator.nextInt(8) == 0)
            {
                var2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var3 = this.randomGenerator.nextInt(128);
                var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, var2, var3, var4);
            }

            for (var2 = 0; var2 < this.reedsPerChunk; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                var5 = this.randomGenerator.nextInt(128);
                this.reedGen.generate(this.currentWorld, this.randomGenerator, var3, var5, var4);
            }

            for (var2 = 0; var2 < 10; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.randomGenerator.nextInt(128);
                var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.reedGen.generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
            }

            if (this.randomGenerator.nextInt(32) == 0)
            {
                var2 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var3 = this.randomGenerator.nextInt(128);
                var4 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                (new WorldGenPumpkin()).generate(this.currentWorld, this.randomGenerator, var2, var3, var4);
            }

            for (var2 = 0; var2 < this.cactiPerChunk; ++var2)
            {
                var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                var4 = this.randomGenerator.nextInt(128);
                var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                this.cactusGen.generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
            }

            if (this.generateLakes)
            {
                for (var2 = 0; var2 < 50; ++var2)
                {
                    var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var4 = this.randomGenerator.nextInt(this.randomGenerator.nextInt(120) + 8);
                    var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                    (new WorldGenLiquids(Block.waterMoving.blockID)).generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
                }

                for (var2 = 0; var2 < 20; ++var2)
                {
                    var3 = this.chunk_X + this.randomGenerator.nextInt(16) + 8;
                    var4 = this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(112) + 8) + 8);
                    var5 = this.chunk_Z + this.randomGenerator.nextInt(16) + 8;
                    (new WorldGenLiquids(Block.lavaMoving.blockID)).generate(this.currentWorld, this.randomGenerator, var3, var4, var5);
                }
            }
        }
    }

    /**
     * Standard ore generation helper. Generates most ores.
     */
    protected void genStandardOre1(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
    {
        for (int var5 = 0; var5 < par1; ++var5)
        {
            int var6 = this.chunk_X + this.randomGenerator.nextInt(16);
            int var7 = this.chunk_Z + this.randomGenerator.nextInt(16);
            int var8;

            if (this.shiftoreheight)
            {
                if (par4 < 17)
                {
                    var8 = this.randomGenerator.nextInt(32) + 16;
                }
                else if (par4 > 111)
                {
                    var8 = this.randomGenerator.nextInt(par4 - 16) + 16;
                }
                else
                {
                    var8 = this.randomGenerator.nextInt(par4) + 16;
                }
            }
            else if (this.disableoreheight)
            {
                var8 = this.randomGenerator.nextInt(128);
            }
            else
            {
                var8 = this.randomGenerator.nextInt(par4 - par3) + par3;
            }

            par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, var6, var8, var7);
        }
    }

    /**
     * Standard ore generation helper. Generates Lapis Lazuli.
     */
    protected void genStandardOre2(int par1, WorldGenerator par2WorldGenerator, int par3, int par4)
    {
        for (int var5 = 0; var5 < par1; ++var5)
        {
            int var6 = this.chunk_X + this.randomGenerator.nextInt(16);
            int var7 = this.randomGenerator.nextInt(par4) + this.randomGenerator.nextInt(par4) + (par3 - par4);
            int var8 = this.chunk_Z + this.randomGenerator.nextInt(16);
            par2WorldGenerator.generate(this.currentWorld, this.randomGenerator, var6, var7, var8);
        }
    }

    /**
     * Generates ores in the current chunk
     */
    protected void generateOres()
    {
        this.genStandardOre1(20, this.dirtGen, 0, 128);
        this.genStandardOre1(10, this.gravelGen, 0, 128);
        this.genStandardOre1(20, this.coalGen, 0, 128);
        this.genStandardOre1(20, this.ironGen, 0, 64);
        this.genStandardOre1(2, this.goldGen, 0, 32);
        this.genStandardOre1(8, this.redstoneGen, 0, 16);

        if (this.emeralds)
        {
            this.genStandardOre1(3 + this.randomGenerator.nextInt(6), this.emeraldGen, 4, 32);
        }

        if (this.silverfish)
        {
            this.genStandardOre1(7, this.silverfishGen, 0, 64);
        }

        if (this.disableoreheight)
        {
            this.genStandardOre1(2, this.diamondGen, 0, 128);
        }
        else
        {
            this.genStandardOre1(1, this.diamondGen, 0, 16);
        }

        this.genStandardOre2(1, this.lapisGen, 16, 16);
    }
}
