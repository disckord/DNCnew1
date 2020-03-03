package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class BiomeGenBase
{
    /** An array of all the biomes, indexed by biome id. */
    public static final BiomeGenBase[] biomeList = new BiomeGenBase[256];
    public static final BiomeGenBase ocean = (new BiomeGenOcean(0)).setColor(112).setBiomeName("Ocean").setMinMaxHeight(-1.0F, 0.4F);
    public static final BiomeGenBase plains = (new BiomeGenPlains(1)).setColor(9286496).setBiomeName("Plains").setTemperatureRainfall(0.8F, 0.4F);
    public static final BiomeGenBase desert = (new BiomeGenDesert(2)).setColor(16421912).setBiomeName("Desert").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.1F, 0.2F);
    public static final BiomeGenBase extremeHills = (new BiomeGenHills(3)).setColor(6316128).setBiomeName("Extreme Hills").setMinMaxHeight(0.3F, 1.5F).setTemperatureRainfall(0.2F, 0.3F);
    public static final BiomeGenBase forest = (new BiomeGenForest(4)).setColor(353825).setBiomeName("Forest").func_76733_a(5159473).setTemperatureRainfall(0.7F, 0.8F);
    public static final BiomeGenBase taiga = (new BiomeGenTaiga(5)).setColor(747097).setBiomeName("Taiga").func_76733_a(5159473).setEnableSnow().setTemperatureRainfall(0.05F, 0.8F).setMinMaxHeight(0.1F, 0.4F);
    public static final BiomeGenBase swampland = (new BiomeGenSwamp(6)).setColor(522674).setBiomeName("Swampland").func_76733_a(9154376).setMinMaxHeight(-0.2F, 0.1F).setTemperatureRainfall(0.8F, 0.9F);
    public static final BiomeGenBase river = (new BiomeGenRiver(7)).setColor(255).setBiomeName("River").setMinMaxHeight(-0.5F, 0.0F);
    public static final BiomeGenBase hell = (new BiomeGenHell(8)).setColor(16711680).setBiomeName("Hell").setDisableRain().setTemperatureRainfall(2.0F, 0.0F);

    /** Is the biome used for sky world. */
    public static final BiomeGenBase sky = (new BiomeGenEnd(9)).setColor(8421631).setBiomeName("Sky").setDisableRain();
    public static final BiomeGenBase frozenOcean = (new BiomeGenOcean(10)).setColor(9474208).setBiomeName("FrozenOcean").setEnableSnow().setMinMaxHeight(-1.0F, 0.5F).setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase frozenRiver = (new BiomeGenRiver(11)).setColor(10526975).setBiomeName("FrozenRiver").setEnableSnow().setMinMaxHeight(-0.5F, 0.0F).setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase icePlains = (new BiomeGenSnow(12)).setColor(16777215).setBiomeName("Ice Plains").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase iceMountains = (new BiomeGenSnow(13)).setColor(10526880).setBiomeName("Ice Mountains").setEnableSnow().setMinMaxHeight(0.3F, 1.3F).setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase mushroomIsland = (new BiomeGenMushroomIsland(14)).setColor(16711935).setBiomeName("MushroomIsland").setTemperatureRainfall(0.9F, 1.0F).setMinMaxHeight(0.2F, 1.0F);
    public static final BiomeGenBase mushroomIslandShore = (new BiomeGenMushroomIsland(15)).setColor(10486015).setBiomeName("MushroomIslandShore").setTemperatureRainfall(0.9F, 1.0F).setMinMaxHeight(-1.0F, 0.1F);

    /** Beach biome. */
    public static final BiomeGenBase beach = (new BiomeGenBeach(16)).setColor(16440917).setBiomeName("Beach").setTemperatureRainfall(0.8F, 0.4F).setMinMaxHeight(0.0F, 0.1F);

    /** Desert Hills biome. */
    public static final BiomeGenBase desertHills = (new BiomeGenDesert(17)).setColor(13786898).setBiomeName("DesertHills").setDisableRain().setTemperatureRainfall(2.0F, 0.0F).setMinMaxHeight(0.3F, 0.8F);

    /** Forest Hills biome. */
    public static final BiomeGenBase forestHills = (new BiomeGenForest(18)).setColor(2250012).setBiomeName("ForestHills").func_76733_a(5159473).setTemperatureRainfall(0.7F, 0.8F).setMinMaxHeight(0.3F, 0.7F);

    /** Taiga Hills biome. */
    public static final BiomeGenBase taigaHills = (new BiomeGenTaiga(19)).setColor(1456435).setBiomeName("TaigaHills").setEnableSnow().func_76733_a(5159473).setTemperatureRainfall(0.05F, 0.8F).setMinMaxHeight(0.3F, 0.8F);

    /** Extreme Hills Edge biome. */
    public static final BiomeGenBase extremeHillsEdge = (new BiomeGenHills(20)).setColor(7501978).setBiomeName("Extreme Hills Edge").setMinMaxHeight(0.2F, 0.8F).setTemperatureRainfall(0.2F, 0.3F);

    /** Jungle biome identifier */
    public static final BiomeGenBase jungle = (new BiomeGenJungle(21)).setColor(5470985).setBiomeName("Jungle").func_76733_a(5470985).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(0.2F, 0.4F);
    public static final BiomeGenBase jungleHills = (new BiomeGenJungle(22)).setColor(2900485).setBiomeName("JungleHills").func_76733_a(5470985).setTemperatureRainfall(1.2F, 0.9F).setMinMaxHeight(1.8F, 0.5F);
    public static final BiomeGenBase BETArainforest = (new BWG4BiomesBeta(80)).setColor(353825).setBiomeName("rainforest").setTemperatureRainfall(0.95F, 0.95F);
    public static final BiomeGenBase BETAswampland = (new BWG4BiomesBeta(81)).setColor(353825).setBiomeName("swampland").setTemperatureRainfall(0.55F, 0.65F);
    public static final BiomeGenBase BETAseasonalForest = (new BWG4BiomesBeta(82)).setColor(353825).setBiomeName("seasonalForest").setTemperatureRainfall(0.95F, 0.7F);
    public static final BiomeGenBase BETAforest = (new BWG4BiomesBeta(83)).setColor(353825).setBiomeName("forest").setTemperatureRainfall(0.8F, 0.6F);
    public static final BiomeGenBase BETAsavanna = (new BWG4BiomesBeta(84)).setColor(16421912).setBiomeName("savanna").setTemperatureRainfall(0.7F, 0.1F);
    public static final BiomeGenBase BETAshrubland = (new BWG4BiomesBeta(85)).setColor(353825).setBiomeName("shrubland").setTemperatureRainfall(0.7F, 0.3F);
    public static final BiomeGenBase BETAtaiga = (new BWG4BiomesBeta(86)).setColor(16777215).setBiomeName("taiga").setTemperatureRainfall(0.1F, 0.35F).setEnableSnow();
    public static final BiomeGenBase BETAdesert = (new BWG4BiomesBeta(87)).setColor(16421912).setBiomeName("desert").setTemperatureRainfall(0.95F, 0.1F).setDisableRain();
    public static final BiomeGenBase BETAplains = (new BWG4BiomesBeta(88)).setColor(353825).setBiomeName("plains").setTemperatureRainfall(0.95F, 0.35F);
    public static final BiomeGenBase BETAtundra = (new BWG4BiomesBeta(89)).setColor(16777215).setBiomeName("tundra").setTemperatureRainfall(0.1F, 0.1F).setEnableSnow();
    public static final BiomeGenBase ALPHArainforest = (new BWG4BiomesAlpha(90)).setColor(353825).setBiomeName("rainforest").setTemperatureRainfall(0.95F, 0.95F);
    public static final BiomeGenBase ALPHAswampland = (new BWG4BiomesAlpha(91)).setColor(353825).setBiomeName("swampland").setTemperatureRainfall(0.55F, 0.65F);
    public static final BiomeGenBase ALPHAseasonalForest = (new BWG4BiomesAlpha(92)).setColor(353825).setBiomeName("seasonalForest").setTemperatureRainfall(0.95F, 0.7F);
    public static final BiomeGenBase ALPHAforest = (new BWG4BiomesAlpha(93)).setColor(353825).setBiomeName("forest").setTemperatureRainfall(0.8F, 0.6F);
    public static final BiomeGenBase ALPHAsavanna = (new BWG4BiomesAlpha(94)).setColor(353825).setBiomeName("savanna").setTemperatureRainfall(0.7F, 0.1F);
    public static final BiomeGenBase ALPHAshrubland = (new BWG4BiomesAlpha(95)).setColor(353825).setBiomeName("shrubland").setTemperatureRainfall(0.7F, 0.3F);
    public static final BiomeGenBase ALPHAtaiga = (new BWG4BiomesAlpha(96)).setColor(353825).setBiomeName("taiga").setTemperatureRainfall(0.1F, 0.35F).setEnableSnow();
    public static final BiomeGenBase ALPHAdesert = (new BWG4BiomesAlpha(97)).setColor(353825).setBiomeName("desert").setTemperatureRainfall(0.95F, 0.1F).setDisableRain();
    public static final BiomeGenBase ALPHAplains = (new BWG4BiomesAlpha(98)).setColor(353825).setBiomeName("plains").setTemperatureRainfall(0.95F, 0.35F);
    public static final BiomeGenBase ALPHAtundra = (new BWG4BiomesAlpha(99)).setColor(353825).setBiomeName("tundra").setTemperatureRainfall(0.1F, 0.1F).setEnableSnow();
    public static final BiomeGenBase INFDEVdefault = (new BWG4BiomesInfdev(100)).setColor(353825).setBiomeName("Infdev");
    public static final BiomeGenBase INFDEVsnow = (new BWG4BiomesInfdev(101)).setColor(353825).setBiomeName("Infdev Snow").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase INDEVnormal = (new BWG4BiomesIndev(102)).setColor(353825).setBiomeName("Indev");
    public static final BiomeGenBase INDEVhell = (new BWG4BiomesIndev(103)).setColor(353825).setBiomeName("Indev");
    public static final BiomeGenBase INDEVparadise = (new BWG4BiomesIndev(104)).setColor(353825).setBiomeName("Indev");
    public static final BiomeGenBase INDEVwoods = (new BWG4BiomesIndev(105)).setColor(353825).setBiomeName("Indev");
    public static final BiomeGenBase INDEVsnow = (new BWG4BiomesIndev(106)).setColor(353825).setBiomeName("Indev").setEnableSnow().setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase ISLANDnormal = (new BWG4BiomesSurvival(107)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.8F);
    public static final BiomeGenBase ISLANDparadise = (new BWG4BiomesSurvival(110)).setColor(353825).setBiomeName("Survival Island").setTemperatureRainfall(0.9F, 0.8F);
    public static final BiomeGenBase SKYLANDnormal = (new BWG4BiomesSurvival(113)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.8F);
    public static final BiomeGenBase SKYLANDice = (new BWG4BiomesSurvival(115)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.0F, 0.5F);
    public static final BiomeGenBase SKYLANDjungle = (new BWG4BiomesSurvival(116)).setColor(353825).setBiomeName("Survival Skyland").setTemperatureRainfall(0.9F, 0.8F);
    public static final BiomeGenBase SURVIVALnether = (new BWG4BiomesSurvival(119)).setColor(353825).setBiomeName("Hell").setTemperatureRainfall(0.8F, 0.6F);
    public static final BiomeGenBase SKYBLOCKworld = (new BWG4BiomesSurvival(120)).setColor(353825).setBiomeName("Survival Skyblock").setTemperatureRainfall(0.9F, 0.8F);
    public static final BiomeGenBase BDocean = (new BWG4BiomesDefault(121, 1, 1)).setColor(353825).setBiomeName("Ocean").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(-1.1F, 0.3F).beach(2);
    public static final BiomeGenBase BDtropicalisland = (new BWG4BiomesDefault(122, 1, 2)).setColor(353825).setBiomeName("Tropical Island").setTemperatureRainfall(1.0F, 1.0F).setMinMaxHeight(0.2F, 0.3F).beach(2);
    public static final BiomeGenBase BDjungleisland = (new BWG4BiomesDefault(123, 1, 3)).setColor(353825).setBiomeName("Jungle Island").setTemperatureRainfall(1.0F, 1.0F).setMinMaxHeight(0.2F, 0.3F).beach(2);
    public static final BiomeGenBase BDmushroomisland = (new BWG4BiomesDefault(124, 1, 4)).setColor(353825).setBiomeName("Mushroom Island").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.3F).beach(0);
    public static final BiomeGenBase BDbeach = (new BWG4BiomesDefault(125, 1, 5)).setColor(353825).setBiomeName("Beach").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.0F, 0.1F).beach(2).defaultbeach();
    public static final BiomeGenBase BDbeachDunes = (new BWG4BiomesDefault(126, 1, 6)).setColor(353825).setBiomeName("Beach Dunes").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.3F, 0.2F).beach(2).defaultbeach();
    public static final BiomeGenBase BDsnowpines = (new BWG4BiomesDefault(127, 2, 1)).setColor(353825).setBiomeName("Snow Pines").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.2F, 0.9F).setEnableSnow().beach(1);
    public static final BiomeGenBase BDsnowforest = (new BWG4BiomesDefault(128, 2, 2)).setColor(353825).setBiomeName("Snow Forest").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.2F, 0.7F).setEnableSnow().beach(1);
    public static final BiomeGenBase BDsnowtaiga = (new BWG4BiomesDefault(129, 2, 3)).setColor(353825).setBiomeName("Snow Taiga").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.2F, 0.9F).setEnableSnow().beach(1);
    public static final BiomeGenBase BDsnowplains = (new BWG4BiomesDefault(130, 2, 4)).setColor(353825).setBiomeName("Snow Plains").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.3F, 0.3F).setEnableSnow().beach(1);
    public static final BiomeGenBase BDsnowhills = (new BWG4BiomesDefault(131, 2, 5)).setColor(353825).setBiomeName("Snow Hills").setTemperatureRainfall(0.0F, 0.0F).setMinMaxHeight(0.3F, 1.3F).setEnableSnow().beach(1);
    public static final BiomeGenBase BDplains = (new BWG4BiomesDefault(132, 3, 1)).setColor(353825).setBiomeName("Plains").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.3F).beach(1);
    public static final BiomeGenBase BDforest = (new BWG4BiomesDefault(133, 3, 2)).setColor(353825).setBiomeName("Forest").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 1.0F).beach(1);
    public static final BiomeGenBase BDforesthills = (new BWG4BiomesDefault(134, 3, 3)).setColor(353825).setBiomeName("Forest Hills").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.3F, 1.5F).beach(1);
    public static final BiomeGenBase BDforestlakes = (new BWG4BiomesDefault(135, 3, 4)).setColor(353825).setBiomeName("Forest Lakes").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(-0.2F, 0.9F).beach(1);
    public static final BiomeGenBase BDpines = (new BWG4BiomesDefault(136, 3, 5)).setColor(353825).setBiomeName("Pines").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.9F).beach(1);
    public static final BiomeGenBase BDtaiga = (new BWG4BiomesDefault(137, 3, 6)).setColor(353825).setBiomeName("Taiga").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 0.9F).beach(1);
    public static final BiomeGenBase BDgrassland = (new BWG4BiomesDefault(138, 3, 7)).setColor(353825).setBiomeName("Grassland").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(0.2F, 1.3F).beach(1);
    public static final BiomeGenBase BDrainforest = (new BWG4BiomesDefault(139, 4, 1)).setColor(353825).setBiomeName("Rainforest").setMinMaxHeight(0.3F, 1.2F).setTemperatureRainfall(0.8F, 1.0F).beach(0);
    public static final BiomeGenBase BDjungle = (new BWG4BiomesDefault(140, 4, 2)).setColor(353825).setBiomeName("Jungle").setMinMaxHeight(0.2F, 1.2F).setTemperatureRainfall(1.0F, 1.0F).beach(0);
    public static final BiomeGenBase BDswampland = (new BWG4BiomesDefault(141, 4, 3)).setColor(353825).setBiomeName("Swampland").setMinMaxHeight(-0.2F, 0.3F).setTemperatureRainfall(0.9F, 1.0F).beach(0);
    public static final BiomeGenBase BDdesert = (new BWG4BiomesDefault(142, 5, 1)).setColor(353825).setBiomeName("Desert").setMinMaxHeight(0.3F, 0.8F).setTemperatureRainfall(1.0F, 0.0F).beach(2).disableLakes();
    public static final BiomeGenBase BDsavanna = (new BWG4BiomesDefault(143, 5, 2)).setColor(353825).setBiomeName("Savanna").setMinMaxHeight(0.3F, 0.2F).setTemperatureRainfall(1.0F, 0.2F).beach(0).disableLakes();
    public static final BiomeGenBase BDsavannaforest = (new BWG4BiomesDefault(144, 5, 3)).setColor(353825).setBiomeName("Savanna Forest").setMinMaxHeight(0.3F, 0.6F).setTemperatureRainfall(1.0F, 0.2F).beach(0);
    public static final BiomeGenBase BDshrubland = (new BWG4BiomesDefault(145, 5, 4)).setColor(353825).setBiomeName("Shrubland").setMinMaxHeight(0.3F, 0.2F).setTemperatureRainfall(0.9F, 0.0F).canyon().beach(0).disableLakes();
    public static final BiomeGenBase BDshrublandHill = (new BWG4BiomesDefault(146, 5, 5)).setColor(353825).setBiomeName("SandStone Hill").setMinMaxHeight(2.5F, 0.2F).setTemperatureRainfall(0.9F, 0.0F).canyon().beach(0).disableLakes();
    public static final BiomeGenBase BDiceriver = (new BWG4BiomesDefault(147, 6, 1)).setColor(353825).setBiomeName("River_ice").setTemperatureRainfall(0.0F, 0.5F).setMinMaxHeight(-0.8F, 0.0F).setEnableSnow();
    public static final BiomeGenBase BDriver = (new BWG4BiomesDefault(148, 6, 2)).setColor(353825).setBiomeName("River_normal").setTemperatureRainfall(0.8F, 0.6F).setMinMaxHeight(-0.8F, 0.0F);
    public static final BiomeGenBase BDgreenriver = (new BWG4BiomesDefault(149, 6, 3)).setColor(353825).setBiomeName("River_green").setTemperatureRainfall(0.8F, 1.0F).setMinMaxHeight(-0.8F, 0.0F);
    public static final BiomeGenBase BDsandriver = (new BWG4BiomesDefault(150, 6, 4)).setColor(353825).setBiomeName("River_sand").setTemperatureRainfall(0.9F, 0.1F).setMinMaxHeight(-0.8F, 0.0F);
    public static final BiomeGenBase BDjungle_nocolor = (new BWG4BiomesDefault(151, 4, 4)).setColor(353825).setBiomeName("Jungle").setMinMaxHeight(0.2F, 0.8F).setTemperatureRainfall(1.0F, 1.0F).beach(0);
    public static final BiomeGenBase BDswampland_nocolor = (new BWG4BiomesDefault(152, 4, 5)).setColor(353825).setBiomeName("Swampland").setMinMaxHeight(-0.2F, 0.3F).setTemperatureRainfall(0.9F, 1.0F).beach(0);
    public String biomeName;
    public int color;

    /** The block expected to be on the top of this biome */
    public byte topBlock;

    /** The block to fill spots in when not on the top */
    public byte fillerBlock;
    public int field_76754_C;

    /** The minimum height of this biome. Default 0.1. */
    public float minHeight;

    /** The maximum height of this biome. Default 0.3. */
    public float maxHeight;

    /** The temperature of this biome. */
    public float temperature;

    /** The rainfall in this biome. */
    public float rainfall;

    /** Color tint applied to water depending on biome */
    public int waterColorMultiplier;

    /** The biome decorator. */
    public BiomeDecorator theBiomeDecorator;

    /**
     * Holds the classes of IMobs (hostile mobs) that can be spawned in the biome.
     */
    protected List spawnableMonsterList;

    /**
     * Holds the classes of any creature that can be spawned in the biome as friendly creature.
     */
    protected List spawnableCreatureList;

    /**
     * Holds the classes of any aquatic creature that can be spawned in the water of the biome.
     */
    protected List spawnableWaterCreatureList;
    protected List spawnableCaveCreatureList;

    /** Set to true if snow is enabled for this biome. */
    private boolean enableSnow;

    /**
     * Is true (default) if the biome support rain (desert and nether can't have rain)
     */
    private boolean enableRain;

    /** The id number to this biome, and its index in the biomeList array. */
    public final int biomeID;

    /** The tree generator. */
    protected WorldGenTrees worldGeneratorTrees;

    /** The big tree generator. */
    protected WorldGenBigTree worldGeneratorBigTree;

    /** The forest generator. */
    protected WorldGenForest worldGeneratorForest;

    /** The swamp tree generator. */
    protected WorldGenSwamp worldGeneratorSwamp;
    public int beachID;
    public int mountainStart;
    public boolean mountainSnow;
    public boolean defaultbeach;
    public boolean lakesDisabled;
    public int snowLevel;
    public boolean isCanyon;
    public int randblock;
    public byte topBlock2;
    public byte fillerBlock2;

    protected BiomeGenBase(int par1)
    {
        this.topBlock = (byte)Block.grass.blockID;
        this.fillerBlock = (byte)Block.dirt.blockID;
        this.field_76754_C = 5169201;
        this.minHeight = 0.1F;
        this.maxHeight = 0.3F;
        this.temperature = 0.5F;
        this.rainfall = 0.5F;
        this.waterColorMultiplier = 0;
        this.spawnableMonsterList = new ArrayList();
        this.spawnableCreatureList = new ArrayList();
        this.spawnableWaterCreatureList = new ArrayList();
        this.spawnableCaveCreatureList = new ArrayList();
        this.enableRain = true;
        this.worldGeneratorTrees = new WorldGenTrees(false);
        this.worldGeneratorBigTree = new WorldGenBigTree(false);
        this.worldGeneratorForest = new WorldGenForest(false);
        this.worldGeneratorSwamp = new WorldGenSwamp();
        this.biomeID = par1;
        biomeList[par1] = this;
        this.beachID = 0;
        this.mountainStart = 128;
        this.mountainSnow = false;
        this.defaultbeach = false;
        this.lakesDisabled = false;
        this.snowLevel = 0;
        this.isCanyon = false;
        this.randblock = 0;
        this.topBlock2 = (byte)Block.grass.blockID;
        this.fillerBlock2 = (byte)Block.dirt.blockID;
        this.theBiomeDecorator = this.createBiomeDecorator();
        this.spawnableCreatureList.add(new SpawnListEntry(EntitySheep.class, 12, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityPig.class, 10, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityChicken.class, 10, 1, 2));
        this.spawnableCreatureList.add(new SpawnListEntry(EntityCow.class, 8, 1, 2));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntityCreeper.class, 10, 4, 4));
        this.spawnableMonsterList.add(new SpawnListEntry(EntitySlime.class, 10, 4, 4));
        //this.spawnableMonsterList.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 4));
        this.spawnableWaterCreatureList.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
        //this.spawnableCaveCreatureList.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
    }

    public WorldGenerator getRandomWorldGenForTrees2(Random var1)
    {
        return (WorldGenerator)(var1.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees);
    }

    private BiomeGenBase beach(int var1)
    {
        this.beachID = var1;
        return this;
    }

    private BiomeGenBase mountain(int var1, boolean var2)
    {
        this.mountainStart = var1;
        this.mountainSnow = var2;
        return this;
    }

    private BiomeGenBase defaultbeach()
    {
        this.defaultbeach = true;
        return this;
    }

    private BiomeGenBase canyon()
    {
        this.isCanyon = true;
        return this;
    }

    private BiomeGenBase disableLakes()
    {
        this.lakesDisabled = true;
        return this;
    }

    private BiomeGenBase randBlock(int var1)
    {
        this.randblock = var1;
        return this;
    }

    private BiomeGenBase snow(int var1)
    {
        this.snowLevel = var1;
        this.enableSnow = true;
        return this;
    }

    public final int getSnowLevel()
    {
        return this.snowLevel;
    }

    /**
     * Allocate a new BiomeDecorator for this BiomeGenBase
     */
    protected BiomeDecorator createBiomeDecorator()
    {
        return new BiomeDecorator(this);
    }

    /**
     * Sets the temperature and rainfall of this biome.
     */
    private BiomeGenBase setTemperatureRainfall(float par1, float par2)
    {
        if (par1 > 0.1F && par1 < 0.2F)
        {
            throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
        }
        else
        {
            this.temperature = par1;
            this.rainfall = par2;
            return this;
        }
    }

    /**
     * Sets the minimum and maximum height of this biome. Seems to go from -2.0 to 2.0.
     */
    private BiomeGenBase setMinMaxHeight(float par1, float par2)
    {
        this.minHeight = par1;
        this.maxHeight = par2;
        return this;
    }

    /**
     * Disable the rain for the biome.
     */
    private BiomeGenBase setDisableRain()
    {
        this.enableRain = false;
        return this;
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
    {
        return (WorldGenerator)(par1Random.nextInt(10) == 0 ? this.worldGeneratorBigTree : this.worldGeneratorTrees);
    }

    /**
     * Gets a WorldGen appropriate for this biome.
     */
    public WorldGenerator getRandomWorldGenForGrass(Random par1Random)
    {
        return new WorldGenTallGrass(Block.tallGrass.blockID, 1);
    }

    /**
     * sets enableSnow to true during biome initialization. returns BiomeGenBase.
     */
    protected BiomeGenBase setEnableSnow()
    {
        this.enableSnow = true;
        return this;
    }

    protected BiomeGenBase setBiomeName(String par1Str)
    {
        this.biomeName = par1Str;
        return this;
    }

    protected BiomeGenBase func_76733_a(int par1)
    {
        this.field_76754_C = par1;
        return this;
    }

    protected BiomeGenBase setColor(int par1)
    {
        this.color = 353825;
        return this;
    }

    /**
     * takes temperature, returns color
     */
    public int getSkyColorByTemp(float par1)
    {
        par1 /= 3.0F;

        if (par1 < -1.0F)
        {
            par1 = -1.0F;
        }

        if (par1 > 1.0F)
        {
            par1 = 1.0F;
        }

        return Color.getHSBColor(0.62222224F - par1 * 0.05F, 0.5F + par1 * 0.1F, 1.0F).getRGB();
    }

    /**
     * Returns the correspondent list of the EnumCreatureType informed.
     */
    public List getSpawnableList(EnumCreatureType par1EnumCreatureType)
    {
        return par1EnumCreatureType == EnumCreatureType.monster ? this.spawnableMonsterList : (par1EnumCreatureType == EnumCreatureType.creature ? this.spawnableCreatureList : (par1EnumCreatureType == EnumCreatureType.waterCreature ? this.spawnableWaterCreatureList : (par1EnumCreatureType == EnumCreatureType.ambient ? this.spawnableCaveCreatureList : null)));
    }

    /**
     * Returns true if the biome have snowfall instead a normal rain.
     */
    public boolean getEnableSnow()
    {
        return this.enableSnow;
    }

    /**
     * Return true if the biome supports lightning bolt spawn, either by have the bolts enabled and have rain enabled.
     */
    public boolean canSpawnLightningBolt()
    {
        return this.enableSnow ? false : this.enableRain;
    }

    /**
     * Checks to see if the rainfall level of the biome is extremely high
     */
    public boolean isHighHumidity()
    {
        return this.rainfall > 0.85F;
    }

    /**
     * returns the chance a creature has to spawn.
     */
    public float getSpawningChance()
    {
        return 0.1F;
    }

    /**
     * Gets an integer representation of this biome's rainfall
     */
    public final int getIntRainfall()
    {
        return (int)(this.rainfall * 65536.0F);
    }

    /**
     * Gets an integer representation of this biome's temperature
     */
    public final int getIntTemperature()
    {
        return (int)(this.temperature * 65536.0F);
    }

    /**
     * Gets a floating point representation of this biome's rainfall
     */
    public final float getFloatRainfall()
    {
        return this.rainfall;
    }

    /**
     * Gets a floating point representation of this biome's temperature
     */
    public final float getFloatTemperature()
    {
        return this.temperature;
    }

    public void decorate(World par1World, Random par2Random, int par3, int par4)
    {
        this.theBiomeDecorator.decorate(par1World, par2Random, par3, par4);
    }

    /**
     * Provides the basic grass color based on the biome temperature and rainfall
     */
    public int getBiomeGrassColor()
    {
        double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
        double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
        return ColorizerGrass.getGrassColor(var1, var3);
    }

    /**
     * Provides the basic foliage color based on the biome temperature and rainfall
     */
    public int getBiomeFoliageColor()
    {
        double var1 = (double)MathHelper.clamp_float(this.getFloatTemperature(), 0.0F, 1.0F);
        double var3 = (double)MathHelper.clamp_float(this.getFloatRainfall(), 0.0F, 1.0F);
        return ColorizerFoliage.getFoliageColor(var1, var3);
    }
}
