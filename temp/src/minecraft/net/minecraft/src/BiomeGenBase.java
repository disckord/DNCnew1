package net.minecraft.src;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.src.BWG4BiomesAlpha;
import net.minecraft.src.BWG4BiomesBeta;
import net.minecraft.src.BWG4BiomesDefault;
import net.minecraft.src.BWG4BiomesIndev;
import net.minecraft.src.BWG4BiomesInfdev;
import net.minecraft.src.BWG4BiomesSurvival;
import net.minecraft.src.BiomeDecorator;
import net.minecraft.src.BiomeGenBeach;
import net.minecraft.src.BiomeGenDesert;
import net.minecraft.src.BiomeGenEnd;
import net.minecraft.src.BiomeGenForest;
import net.minecraft.src.BiomeGenHell;
import net.minecraft.src.BiomeGenHills;
import net.minecraft.src.BiomeGenJungle;
import net.minecraft.src.BiomeGenMushroomIsland;
import net.minecraft.src.BiomeGenOcean;
import net.minecraft.src.BiomeGenPlains;
import net.minecraft.src.BiomeGenRiver;
import net.minecraft.src.BiomeGenSnow;
import net.minecraft.src.BiomeGenSwamp;
import net.minecraft.src.BiomeGenTaiga;
import net.minecraft.src.Block;
import net.minecraft.src.ColorizerFoliage;
import net.minecraft.src.ColorizerGrass;
import net.minecraft.src.EntityBat;
import net.minecraft.src.EntityChicken;
import net.minecraft.src.EntityCow;
import net.minecraft.src.EntityCreeper;
import net.minecraft.src.EntityEnderman;
import net.minecraft.src.EntityPig;
import net.minecraft.src.EntitySheep;
import net.minecraft.src.EntitySkeleton;
import net.minecraft.src.EntitySlime;
import net.minecraft.src.EntitySpider;
import net.minecraft.src.EntitySquid;
import net.minecraft.src.EntityZombie;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.MathHelper;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.src.World;
import net.minecraft.src.WorldGenBigTree;
import net.minecraft.src.WorldGenForest;
import net.minecraft.src.WorldGenSwamp;
import net.minecraft.src.WorldGenTallGrass;
import net.minecraft.src.WorldGenTrees;
import net.minecraft.src.WorldGenerator;

public abstract class BiomeGenBase {

   public static final BiomeGenBase[] field_76773_a = new BiomeGenBase[256];
   public static final BiomeGenBase field_76771_b = (new BiomeGenOcean(0)).func_76739_b(112).func_76735_a("Ocean").func_76725_b(-1.0F, 0.4F);
   public static final BiomeGenBase field_76772_c = (new BiomeGenPlains(1)).func_76739_b(9286496).func_76735_a("Plains").func_76732_a(0.8F, 0.4F);
   public static final BiomeGenBase field_76769_d = (new BiomeGenDesert(2)).func_76739_b(16421912).func_76735_a("Desert").func_76745_m().func_76732_a(2.0F, 0.0F).func_76725_b(0.1F, 0.2F);
   public static final BiomeGenBase field_76770_e = (new BiomeGenHills(3)).func_76739_b(6316128).func_76735_a("Extreme Hills").func_76725_b(0.3F, 1.5F).func_76732_a(0.2F, 0.3F);
   public static final BiomeGenBase field_76767_f = (new BiomeGenForest(4)).func_76739_b(353825).func_76735_a("Forest").func_76733_a(5159473).func_76732_a(0.7F, 0.8F);
   public static final BiomeGenBase field_76768_g = (new BiomeGenTaiga(5)).func_76739_b(747097).func_76735_a("Taiga").func_76733_a(5159473).func_76742_b().func_76732_a(0.05F, 0.8F).func_76725_b(0.1F, 0.4F);
   public static final BiomeGenBase field_76780_h = (new BiomeGenSwamp(6)).func_76739_b(522674).func_76735_a("Swampland").func_76733_a(9154376).func_76725_b(-0.2F, 0.1F).func_76732_a(0.8F, 0.9F);
   public static final BiomeGenBase field_76781_i = (new BiomeGenRiver(7)).func_76739_b(255).func_76735_a("River").func_76725_b(-0.5F, 0.0F);
   public static final BiomeGenBase field_76778_j = (new BiomeGenHell(8)).func_76739_b(16711680).func_76735_a("Hell").func_76745_m().func_76732_a(2.0F, 0.0F);
   public static final BiomeGenBase field_76779_k = (new BiomeGenEnd(9)).func_76739_b(8421631).func_76735_a("Sky").func_76745_m();
   public static final BiomeGenBase field_76776_l = (new BiomeGenOcean(10)).func_76739_b(9474208).func_76735_a("FrozenOcean").func_76742_b().func_76725_b(-1.0F, 0.5F).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76777_m = (new BiomeGenRiver(11)).func_76739_b(10526975).func_76735_a("FrozenRiver").func_76742_b().func_76725_b(-0.5F, 0.0F).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76774_n = (new BiomeGenSnow(12)).func_76739_b(16777215).func_76735_a("Ice Plains").func_76742_b().func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76775_o = (new BiomeGenSnow(13)).func_76739_b(10526880).func_76735_a("Ice Mountains").func_76742_b().func_76725_b(0.3F, 1.3F).func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase field_76789_p = (new BiomeGenMushroomIsland(14)).func_76739_b(16711935).func_76735_a("MushroomIsland").func_76732_a(0.9F, 1.0F).func_76725_b(0.2F, 1.0F);
   public static final BiomeGenBase field_76788_q = (new BiomeGenMushroomIsland(15)).func_76739_b(10486015).func_76735_a("MushroomIslandShore").func_76732_a(0.9F, 1.0F).func_76725_b(-1.0F, 0.1F);
   public static final BiomeGenBase field_76787_r = (new BiomeGenBeach(16)).func_76739_b(16440917).func_76735_a("Beach").func_76732_a(0.8F, 0.4F).func_76725_b(0.0F, 0.1F);
   public static final BiomeGenBase field_76786_s = (new BiomeGenDesert(17)).func_76739_b(13786898).func_76735_a("DesertHills").func_76745_m().func_76732_a(2.0F, 0.0F).func_76725_b(0.3F, 0.8F);
   public static final BiomeGenBase field_76785_t = (new BiomeGenForest(18)).func_76739_b(2250012).func_76735_a("ForestHills").func_76733_a(5159473).func_76732_a(0.7F, 0.8F).func_76725_b(0.3F, 0.7F);
   public static final BiomeGenBase field_76784_u = (new BiomeGenTaiga(19)).func_76739_b(1456435).func_76735_a("TaigaHills").func_76742_b().func_76733_a(5159473).func_76732_a(0.05F, 0.8F).func_76725_b(0.3F, 0.8F);
   public static final BiomeGenBase field_76783_v = (new BiomeGenHills(20)).func_76739_b(7501978).func_76735_a("Extreme Hills Edge").func_76725_b(0.2F, 0.8F).func_76732_a(0.2F, 0.3F);
   public static final BiomeGenBase field_76782_w = (new BiomeGenJungle(21)).func_76739_b(5470985).func_76735_a("Jungle").func_76733_a(5470985).func_76732_a(1.2F, 0.9F).func_76725_b(0.2F, 0.4F);
   public static final BiomeGenBase field_76792_x = (new BiomeGenJungle(22)).func_76739_b(2900485).func_76735_a("JungleHills").func_76733_a(5470985).func_76732_a(1.2F, 0.9F).func_76725_b(1.8F, 0.5F);
   public static final BiomeGenBase BETArainforest = (new BWG4BiomesBeta(80)).func_76739_b(353825).func_76735_a("rainforest").func_76732_a(0.95F, 0.95F);
   public static final BiomeGenBase BETAswampland = (new BWG4BiomesBeta(81)).func_76739_b(353825).func_76735_a("swampland").func_76732_a(0.55F, 0.65F);
   public static final BiomeGenBase BETAseasonalForest = (new BWG4BiomesBeta(82)).func_76739_b(353825).func_76735_a("seasonalForest").func_76732_a(0.95F, 0.7F);
   public static final BiomeGenBase BETAforest = (new BWG4BiomesBeta(83)).func_76739_b(353825).func_76735_a("forest").func_76732_a(0.8F, 0.6F);
   public static final BiomeGenBase BETAsavanna = (new BWG4BiomesBeta(84)).func_76739_b(16421912).func_76735_a("savanna").func_76732_a(0.7F, 0.1F);
   public static final BiomeGenBase BETAshrubland = (new BWG4BiomesBeta(85)).func_76739_b(353825).func_76735_a("shrubland").func_76732_a(0.7F, 0.3F);
   public static final BiomeGenBase BETAtaiga = (new BWG4BiomesBeta(86)).func_76739_b(16777215).func_76735_a("taiga").func_76732_a(0.1F, 0.35F).func_76742_b();
   public static final BiomeGenBase BETAdesert = (new BWG4BiomesBeta(87)).func_76739_b(16421912).func_76735_a("desert").func_76732_a(0.95F, 0.1F).func_76745_m();
   public static final BiomeGenBase BETAplains = (new BWG4BiomesBeta(88)).func_76739_b(353825).func_76735_a("plains").func_76732_a(0.95F, 0.35F);
   public static final BiomeGenBase BETAtundra = (new BWG4BiomesBeta(89)).func_76739_b(16777215).func_76735_a("tundra").func_76732_a(0.1F, 0.1F).func_76742_b();
   public static final BiomeGenBase ALPHArainforest = (new BWG4BiomesAlpha(90)).func_76739_b(353825).func_76735_a("rainforest").func_76732_a(0.95F, 0.95F);
   public static final BiomeGenBase ALPHAswampland = (new BWG4BiomesAlpha(91)).func_76739_b(353825).func_76735_a("swampland").func_76732_a(0.55F, 0.65F);
   public static final BiomeGenBase ALPHAseasonalForest = (new BWG4BiomesAlpha(92)).func_76739_b(353825).func_76735_a("seasonalForest").func_76732_a(0.95F, 0.7F);
   public static final BiomeGenBase ALPHAforest = (new BWG4BiomesAlpha(93)).func_76739_b(353825).func_76735_a("forest").func_76732_a(0.8F, 0.6F);
   public static final BiomeGenBase ALPHAsavanna = (new BWG4BiomesAlpha(94)).func_76739_b(353825).func_76735_a("savanna").func_76732_a(0.7F, 0.1F);
   public static final BiomeGenBase ALPHAshrubland = (new BWG4BiomesAlpha(95)).func_76739_b(353825).func_76735_a("shrubland").func_76732_a(0.7F, 0.3F);
   public static final BiomeGenBase ALPHAtaiga = (new BWG4BiomesAlpha(96)).func_76739_b(353825).func_76735_a("taiga").func_76732_a(0.1F, 0.35F).func_76742_b();
   public static final BiomeGenBase ALPHAdesert = (new BWG4BiomesAlpha(97)).func_76739_b(353825).func_76735_a("desert").func_76732_a(0.95F, 0.1F).func_76745_m();
   public static final BiomeGenBase ALPHAplains = (new BWG4BiomesAlpha(98)).func_76739_b(353825).func_76735_a("plains").func_76732_a(0.95F, 0.35F);
   public static final BiomeGenBase ALPHAtundra = (new BWG4BiomesAlpha(99)).func_76739_b(353825).func_76735_a("tundra").func_76732_a(0.1F, 0.1F).func_76742_b();
   public static final BiomeGenBase INFDEVdefault = (new BWG4BiomesInfdev(100)).func_76739_b(353825).func_76735_a("Infdev");
   public static final BiomeGenBase INFDEVsnow = (new BWG4BiomesInfdev(101)).func_76739_b(353825).func_76735_a("Infdev Snow").func_76742_b().func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase INDEVnormal = (new BWG4BiomesIndev(102)).func_76739_b(353825).func_76735_a("Indev");
   public static final BiomeGenBase INDEVhell = (new BWG4BiomesIndev(103)).func_76739_b(353825).func_76735_a("Indev");
   public static final BiomeGenBase INDEVparadise = (new BWG4BiomesIndev(104)).func_76739_b(353825).func_76735_a("Indev");
   public static final BiomeGenBase INDEVwoods = (new BWG4BiomesIndev(105)).func_76739_b(353825).func_76735_a("Indev");
   public static final BiomeGenBase INDEVsnow = (new BWG4BiomesIndev(106)).func_76739_b(353825).func_76735_a("Indev").func_76742_b().func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase ISLANDnormal = (new BWG4BiomesSurvival(107)).func_76739_b(353825).func_76735_a("Survival Island").func_76732_a(0.9F, 0.8F);
   public static final BiomeGenBase ISLANDparadise = (new BWG4BiomesSurvival(110)).func_76739_b(353825).func_76735_a("Survival Island").func_76732_a(0.9F, 0.8F);
   public static final BiomeGenBase SKYLANDnormal = (new BWG4BiomesSurvival(113)).func_76739_b(353825).func_76735_a("Survival Skyland").func_76732_a(0.9F, 0.8F);
   public static final BiomeGenBase SKYLANDice = (new BWG4BiomesSurvival(115)).func_76739_b(353825).func_76735_a("Survival Skyland").func_76732_a(0.0F, 0.5F);
   public static final BiomeGenBase SKYLANDjungle = (new BWG4BiomesSurvival(116)).func_76739_b(353825).func_76735_a("Survival Skyland").func_76732_a(0.9F, 0.8F);
   public static final BiomeGenBase SURVIVALnether = (new BWG4BiomesSurvival(119)).func_76739_b(353825).func_76735_a("Hell").func_76732_a(0.8F, 0.6F);
   public static final BiomeGenBase SKYBLOCKworld = (new BWG4BiomesSurvival(120)).func_76739_b(353825).func_76735_a("Survival Skyblock").func_76732_a(0.9F, 0.8F);
   public static final BiomeGenBase BDocean = (new BWG4BiomesDefault(121, 1, 1)).func_76739_b(353825).func_76735_a("Ocean").func_76732_a(0.8F, 0.6F).func_76725_b(-1.1F, 0.3F).beach(2);
   public static final BiomeGenBase BDtropicalisland = (new BWG4BiomesDefault(122, 1, 2)).func_76739_b(353825).func_76735_a("Tropical Island").func_76732_a(1.0F, 1.0F).func_76725_b(0.2F, 0.3F).beach(2);
   public static final BiomeGenBase BDjungleisland = (new BWG4BiomesDefault(123, 1, 3)).func_76739_b(353825).func_76735_a("Jungle Island").func_76732_a(1.0F, 1.0F).func_76725_b(0.2F, 0.3F).beach(2);
   public static final BiomeGenBase BDmushroomisland = (new BWG4BiomesDefault(124, 1, 4)).func_76739_b(353825).func_76735_a("Mushroom Island").func_76732_a(0.8F, 0.6F).func_76725_b(0.2F, 0.3F).beach(0);
   public static final BiomeGenBase BDbeach = (new BWG4BiomesDefault(125, 1, 5)).func_76739_b(353825).func_76735_a("Beach").func_76732_a(0.8F, 0.6F).func_76725_b(0.0F, 0.1F).beach(2).defaultbeach();
   public static final BiomeGenBase BDbeachDunes = (new BWG4BiomesDefault(126, 1, 6)).func_76739_b(353825).func_76735_a("Beach Dunes").func_76732_a(0.8F, 0.6F).func_76725_b(0.3F, 0.2F).beach(2).defaultbeach();
   public static final BiomeGenBase BDsnowpines = (new BWG4BiomesDefault(127, 2, 1)).func_76739_b(353825).func_76735_a("Snow Pines").func_76732_a(0.0F, 0.0F).func_76725_b(0.2F, 0.9F).func_76742_b().beach(1);
   public static final BiomeGenBase BDsnowforest = (new BWG4BiomesDefault(128, 2, 2)).func_76739_b(353825).func_76735_a("Snow Forest").func_76732_a(0.0F, 0.0F).func_76725_b(0.2F, 0.7F).func_76742_b().beach(1);
   public static final BiomeGenBase BDsnowtaiga = (new BWG4BiomesDefault(129, 2, 3)).func_76739_b(353825).func_76735_a("Snow Taiga").func_76732_a(0.0F, 0.0F).func_76725_b(0.2F, 0.9F).func_76742_b().beach(1);
   public static final BiomeGenBase BDsnowplains = (new BWG4BiomesDefault(130, 2, 4)).func_76739_b(353825).func_76735_a("Snow Plains").func_76732_a(0.0F, 0.0F).func_76725_b(0.3F, 0.3F).func_76742_b().beach(1);
   public static final BiomeGenBase BDsnowhills = (new BWG4BiomesDefault(131, 2, 5)).func_76739_b(353825).func_76735_a("Snow Hills").func_76732_a(0.0F, 0.0F).func_76725_b(0.3F, 1.3F).func_76742_b().beach(1);
   public static final BiomeGenBase BDplains = (new BWG4BiomesDefault(132, 3, 1)).func_76739_b(353825).func_76735_a("Plains").func_76732_a(0.8F, 0.6F).func_76725_b(0.2F, 0.3F).beach(1);
   public static final BiomeGenBase BDforest = (new BWG4BiomesDefault(133, 3, 2)).func_76739_b(353825).func_76735_a("Forest").func_76732_a(0.8F, 0.6F).func_76725_b(0.2F, 1.0F).beach(1);
   public static final BiomeGenBase BDforesthills = (new BWG4BiomesDefault(134, 3, 3)).func_76739_b(353825).func_76735_a("Forest Hills").func_76732_a(0.8F, 0.6F).func_76725_b(0.3F, 1.5F).beach(1);
   public static final BiomeGenBase BDforestlakes = (new BWG4BiomesDefault(135, 3, 4)).func_76739_b(353825).func_76735_a("Forest Lakes").func_76732_a(0.8F, 0.6F).func_76725_b(-0.2F, 0.9F).beach(1);
   public static final BiomeGenBase BDpines = (new BWG4BiomesDefault(136, 3, 5)).func_76739_b(353825).func_76735_a("Pines").func_76732_a(0.8F, 0.6F).func_76725_b(0.2F, 0.9F).beach(1);
   public static final BiomeGenBase BDtaiga = (new BWG4BiomesDefault(137, 3, 6)).func_76739_b(353825).func_76735_a("Taiga").func_76732_a(0.8F, 0.6F).func_76725_b(0.2F, 0.9F).beach(1);
   public static final BiomeGenBase BDgrassland = (new BWG4BiomesDefault(138, 3, 7)).func_76739_b(353825).func_76735_a("Grassland").func_76732_a(0.8F, 0.6F).func_76725_b(0.2F, 1.3F).beach(1);
   public static final BiomeGenBase BDrainforest = (new BWG4BiomesDefault(139, 4, 1)).func_76739_b(353825).func_76735_a("Rainforest").func_76725_b(0.3F, 1.2F).func_76732_a(0.8F, 1.0F).beach(0);
   public static final BiomeGenBase BDjungle = (new BWG4BiomesDefault(140, 4, 2)).func_76739_b(353825).func_76735_a("Jungle").func_76725_b(0.2F, 1.2F).func_76732_a(1.0F, 1.0F).beach(0);
   public static final BiomeGenBase BDswampland = (new BWG4BiomesDefault(141, 4, 3)).func_76739_b(353825).func_76735_a("Swampland").func_76725_b(-0.2F, 0.3F).func_76732_a(0.9F, 1.0F).beach(0);
   public static final BiomeGenBase BDdesert = (new BWG4BiomesDefault(142, 5, 1)).func_76739_b(353825).func_76735_a("Desert").func_76725_b(0.3F, 0.8F).func_76732_a(1.0F, 0.0F).beach(2).disableLakes();
   public static final BiomeGenBase BDsavanna = (new BWG4BiomesDefault(143, 5, 2)).func_76739_b(353825).func_76735_a("Savanna").func_76725_b(0.3F, 0.2F).func_76732_a(1.0F, 0.2F).beach(0).disableLakes();
   public static final BiomeGenBase BDsavannaforest = (new BWG4BiomesDefault(144, 5, 3)).func_76739_b(353825).func_76735_a("Savanna Forest").func_76725_b(0.3F, 0.6F).func_76732_a(1.0F, 0.2F).beach(0);
   public static final BiomeGenBase BDshrubland = (new BWG4BiomesDefault(145, 5, 4)).func_76739_b(353825).func_76735_a("Shrubland").func_76725_b(0.3F, 0.2F).func_76732_a(0.9F, 0.0F).canyon().beach(0).disableLakes();
   public static final BiomeGenBase BDshrublandHill = (new BWG4BiomesDefault(146, 5, 5)).func_76739_b(353825).func_76735_a("SandStone Hill").func_76725_b(2.5F, 0.2F).func_76732_a(0.9F, 0.0F).canyon().beach(0).disableLakes();
   public static final BiomeGenBase BDiceriver = (new BWG4BiomesDefault(147, 6, 1)).func_76739_b(353825).func_76735_a("River_ice").func_76732_a(0.0F, 0.5F).func_76725_b(-0.8F, 0.0F).func_76742_b();
   public static final BiomeGenBase BDriver = (new BWG4BiomesDefault(148, 6, 2)).func_76739_b(353825).func_76735_a("River_normal").func_76732_a(0.8F, 0.6F).func_76725_b(-0.8F, 0.0F);
   public static final BiomeGenBase BDgreenriver = (new BWG4BiomesDefault(149, 6, 3)).func_76739_b(353825).func_76735_a("River_green").func_76732_a(0.8F, 1.0F).func_76725_b(-0.8F, 0.0F);
   public static final BiomeGenBase BDsandriver = (new BWG4BiomesDefault(150, 6, 4)).func_76739_b(353825).func_76735_a("River_sand").func_76732_a(0.9F, 0.1F).func_76725_b(-0.8F, 0.0F);
   public static final BiomeGenBase BDjungle_nocolor = (new BWG4BiomesDefault(151, 4, 4)).func_76739_b(353825).func_76735_a("Jungle").func_76725_b(0.2F, 0.8F).func_76732_a(1.0F, 1.0F).beach(0);
   public static final BiomeGenBase BDswampland_nocolor = (new BWG4BiomesDefault(152, 4, 5)).func_76739_b(353825).func_76735_a("Swampland").func_76725_b(-0.2F, 0.3F).func_76732_a(0.9F, 1.0F).beach(0);
   public String field_76791_y;
   public int field_76790_z;
   public byte field_76752_A;
   public byte field_76753_B;
   public int field_76754_C;
   public float field_76748_D;
   public float field_76749_E;
   public float field_76750_F;
   public float field_76751_G;
   public int field_76759_H;
   public BiomeDecorator field_76760_I;
   protected List field_76761_J;
   protected List field_76762_K;
   protected List field_76755_L;
   protected List field_82914_M;
   private boolean field_76766_R;
   private boolean field_76765_S;
   public final int field_76756_M;
   protected WorldGenTrees field_76757_N;
   protected WorldGenBigTree field_76758_O;
   protected WorldGenForest field_76764_P;
   protected WorldGenSwamp field_76763_Q;
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


   protected BiomeGenBase(int p_i3747_1_) {
      this.field_76752_A = (byte)Block.field_71980_u.field_71990_ca;
      this.field_76753_B = (byte)Block.field_71979_v.field_71990_ca;
      this.field_76754_C = 5169201;
      this.field_76748_D = 0.1F;
      this.field_76749_E = 0.3F;
      this.field_76750_F = 0.5F;
      this.field_76751_G = 0.5F;
      this.field_76759_H = 16777215;
      this.field_76761_J = new ArrayList();
      this.field_76762_K = new ArrayList();
      this.field_76755_L = new ArrayList();
      this.field_82914_M = new ArrayList();
      this.field_76765_S = true;
      this.field_76757_N = new WorldGenTrees(false);
      this.field_76758_O = new WorldGenBigTree(false);
      this.field_76764_P = new WorldGenForest(false);
      this.field_76763_Q = new WorldGenSwamp();
      this.field_76756_M = p_i3747_1_;
      field_76773_a[p_i3747_1_] = this;
      this.beachID = 0;
      this.mountainStart = 128;
      this.mountainSnow = false;
      this.defaultbeach = false;
      this.lakesDisabled = false;
      this.snowLevel = 0;
      this.isCanyon = false;
      this.randblock = 0;
      this.topBlock2 = (byte)Block.field_71980_u.field_71990_ca;
      this.fillerBlock2 = (byte)Block.field_71979_v.field_71990_ca;
      this.field_76760_I = this.func_76729_a();
      this.field_76762_K.add(new SpawnListEntry(EntitySheep.class, 12, 4, 4));
      this.field_76762_K.add(new SpawnListEntry(EntityPig.class, 10, 4, 4));
      this.field_76762_K.add(new SpawnListEntry(EntityChicken.class, 10, 4, 4));
      this.field_76762_K.add(new SpawnListEntry(EntityCow.class, 8, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntitySpider.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntityZombie.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntitySkeleton.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntityCreeper.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntitySlime.class, 10, 4, 4));
      this.field_76761_J.add(new SpawnListEntry(EntityEnderman.class, 1, 1, 4));
      this.field_76755_L.add(new SpawnListEntry(EntitySquid.class, 10, 4, 4));
      this.field_82914_M.add(new SpawnListEntry(EntityBat.class, 10, 8, 8));
   }

   public WorldGenerator getRandomWorldGenForTrees2(Random var1) {
      return (WorldGenerator)(var1.nextInt(10) == 0?this.field_76758_O:this.field_76757_N);
   }

   private BiomeGenBase beach(int var1) {
      this.beachID = var1;
      return this;
   }

   private BiomeGenBase mountain(int var1, boolean var2) {
      this.mountainStart = var1;
      this.mountainSnow = var2;
      return this;
   }

   private BiomeGenBase defaultbeach() {
      this.defaultbeach = true;
      return this;
   }

   private BiomeGenBase canyon() {
      this.isCanyon = true;
      return this;
   }

   private BiomeGenBase disableLakes() {
      this.lakesDisabled = true;
      return this;
   }

   private BiomeGenBase randBlock(int var1) {
      this.randblock = var1;
      return this;
   }

   private BiomeGenBase snow(int var1) {
      this.snowLevel = var1;
      this.field_76766_R = true;
      return this;
   }

   public final int getSnowLevel() {
      return this.snowLevel;
   }

   protected BiomeDecorator func_76729_a() {
      return new BiomeDecorator(this);
   }

   private BiomeGenBase func_76732_a(float p_76732_1_, float p_76732_2_) {
      if(p_76732_1_ > 0.1F && p_76732_1_ < 0.2F) {
         throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
      } else {
         this.field_76750_F = p_76732_1_;
         this.field_76751_G = p_76732_2_;
         return this;
      }
   }

   private BiomeGenBase func_76725_b(float p_76725_1_, float p_76725_2_) {
      this.field_76748_D = p_76725_1_;
      this.field_76749_E = p_76725_2_;
      return this;
   }

   private BiomeGenBase func_76745_m() {
      this.field_76765_S = false;
      return this;
   }

   public WorldGenerator func_76740_a(Random p_76740_1_) {
      return (WorldGenerator)(p_76740_1_.nextInt(10) == 0?this.field_76758_O:this.field_76757_N);
   }

   public WorldGenerator func_76730_b(Random p_76730_1_) {
      return new WorldGenTallGrass(Block.field_71962_X.field_71990_ca, 1);
   }

   protected BiomeGenBase func_76742_b() {
      this.field_76766_R = true;
      return this;
   }

   protected BiomeGenBase func_76735_a(String p_76735_1_) {
      this.field_76791_y = p_76735_1_;
      return this;
   }

   protected BiomeGenBase func_76733_a(int p_76733_1_) {
      this.field_76754_C = p_76733_1_;
      return this;
   }

   protected BiomeGenBase func_76739_b(int p_76739_1_) {
      this.field_76790_z = p_76739_1_;
      return this;
   }

   public int func_76731_a(float p_76731_1_) {
      p_76731_1_ /= 3.0F;
      if(p_76731_1_ < -1.0F) {
         p_76731_1_ = -1.0F;
      }

      if(p_76731_1_ > 1.0F) {
         p_76731_1_ = 1.0F;
      }

      return Color.getHSBColor(0.62222224F - p_76731_1_ * 0.05F, 0.5F + p_76731_1_ * 0.1F, 1.0F).getRGB();
   }

   public List func_76747_a(EnumCreatureType p_76747_1_) {
      return p_76747_1_ == EnumCreatureType.monster?this.field_76761_J:(p_76747_1_ == EnumCreatureType.creature?this.field_76762_K:(p_76747_1_ == EnumCreatureType.waterCreature?this.field_76755_L:(p_76747_1_ == EnumCreatureType.ambient?this.field_82914_M:null)));
   }

   public boolean func_76746_c() {
      return this.field_76766_R;
   }

   public boolean func_76738_d() {
      return this.field_76766_R?false:this.field_76765_S;
   }

   public boolean func_76736_e() {
      return this.field_76751_G > 0.85F;
   }

   public float func_76741_f() {
      return 0.1F;
   }

   public final int func_76744_g() {
      return (int)(this.field_76751_G * 65536.0F);
   }

   public final int func_76734_h() {
      return (int)(this.field_76750_F * 65536.0F);
   }

   public final float func_76727_i() {
      return this.field_76751_G;
   }

   public final float func_76743_j() {
      return this.field_76750_F;
   }

   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
      this.field_76760_I.func_76796_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
   }

   public int func_76737_k() {
      double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
      return ColorizerGrass.func_77480_a(var1, var3);
   }

   public int func_76726_l() {
      double var1 = (double)MathHelper.func_76131_a(this.func_76743_j(), 0.0F, 1.0F);
      double var3 = (double)MathHelper.func_76131_a(this.func_76727_i(), 0.0F, 1.0F);
      return ColorizerFoliage.func_77470_a(var1, var3);
   }

}
