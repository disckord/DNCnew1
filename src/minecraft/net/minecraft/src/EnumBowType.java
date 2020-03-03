package net.minecraft.src;

public enum EnumBowType {
	DEFAULT(384,   0   ,0.1f,1.0f, 0),
	IRONBOW(750,   1   , 0.2f,0.6f, 0),
	DIAMONDBOW(1250,   4   ,0.4f, 0.5f, 0),
	GOLDBOW(680,   1   ,0.7f, 0.1f, 0.01D);
	
private EnumBowType(int durability, int addeddamage, float velocity, float accuracy, double flightModifier)
{
	this.durability = durability;
	this.addedDmg = addeddamage;
	this.velocity = velocity;
	this.accuracy = accuracy;
	this.flightModifier = flightModifier;
}
public int durability;
public int addedDmg;
public float velocity;
public float accuracy;
public double flightModifier;
}


