package net.minecraft.src;

import java.util.Random;

public class Perk {
	public static Perk[] perks = new Perk[64];
	public int id = 0;
	public String name = "none";
	public String particleEffect;
	public String soundEffect;
	public int particleMaxRange = 1;
	public int particleRange = 1;
	public int soundMaxRange;
	public int soundRange;
	public float soundVolume;
	public float vertVel;
	public float soundSpeed;
	public boolean hasSound = false;
	public double heightVariationMultiplier = 0.6D;
	public double spawnHeight;
	public Perk(int id, String name, String particleEffect, String soundEffect)
	{
		if(perks[id] != null)
		{
			 throw new IllegalArgumentException("Slot " + id + " is already occupied by " + perks[id] + " when adding " + this);
		}
		else
		{
			this.particleEffect = particleEffect;
			this.soundEffect = soundEffect;
			this.name = name;
			this.id = id;
			perks[id] = this;
		}
	}
	public Perk(int id, String name, String particleEffect)
	{
		this(id,name,particleEffect,"");
	}
	
	public boolean getParticleChance(Random rand)
	{
		return rand.nextInt(particleMaxRange) <= particleRange;
	}
	public boolean getSoundChance(Random rand)
	{
		return rand.nextInt(soundMaxRange) <= soundRange;
	}
	
	private Perk setParticleFrequency(int maxRange, int range)
	{
		this.particleMaxRange = maxRange;
		this.particleRange = range;
		return this;
	}
	
	private Perk setSoundFrequency(int maxRange, int range)
	{
		this.soundMaxRange = maxRange;
		this.soundRange = range;
		return this;
	}
	
	private Perk setSoundVolume(float vol)
	{
		this.soundVolume = vol;
		return this;
	}
	
	private Perk setVertVelocity(float vel)
	{
		this.vertVel = vel;
		return this;
	}
	private Perk setSoundSpeed(float speed)
	{
		this.soundSpeed = speed;
		return this;
	}
	private Perk setHasSound(boolean flag)
	{
		this.hasSound = flag;
		return this;
	}
	private Perk setHeightVarMult(double d)
	{
		this.heightVariationMultiplier = d;
		return this;
	}
	private Perk setSpawnHeight(double d)
	{
		this.spawnHeight = d;
		return this;
	}
	public static Perk none = new Perk(0, "none", "", "");
	public static Perk flame = new Perk(1, "flames", "flame", "fire.fire").setSpawnHeight(-0.3D).setParticleFrequency(100, 75).setSoundFrequency(200, 0).setSoundVolume(0.05F).setVertVelocity(0.005f).setSoundSpeed(1.2f).setHasSound(true).setHeightVarMult(1.0D);
	public static Perk bubbles = new Perk(2, "bubbles", "bubble", "liquid.bubble").setParticleFrequency(100, 75).setSoundFrequency(200, 0).setSoundVolume(0.05F).setSoundSpeed(1.5f).setHasSound(true).setHeightVarMult(1.5D).setSpawnHeight(-0.5D);
	public static Perk blossom = new Perk(3, "blossom", "cherry", "random.wind").setParticleFrequency(3, 0).setSoundFrequency(300, 0).setSoundVolume(0.6F).setSoundSpeed(1.1f).setHasSound(true).setHeightVarMult(0.0D).setSpawnHeight(1.5D);
	public static Perk hearts = new Perk(4, "hearts", "smallheart").setParticleFrequency(3, 0);
	public static Perk snow = new Perk(5, "snow", "snow").setParticleFrequency(2,0).setSpawnHeight(2.0D).setHeightVarMult(0.0D);
	public static Perk smoke = new Perk(6, "smoke", "smoke").setParticleFrequency(2,0);

}
