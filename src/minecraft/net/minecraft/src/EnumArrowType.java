package net.minecraft.src;

public enum EnumArrowType 
{
DEFAULT(4,1.0f,0),
IRONARROW(5,1.3f,0),
DIAMONDARROW(6,1.6f,0),
GOLDARROW(5,2.5f,1D);
	
private EnumArrowType(int Dmg, float addedVel, double flightModifier)
{
	this.damage = Dmg;
	this.addedVel = addedVel;
	this.flightModifier = flightModifier;
}
public int damage;
public float addedVel;
public double flightModifier;

public EnumArrowType getArrowTypeByOrdinal(int i)
{
	if(i == 0)
	{
		return this.DEFAULT;
	}
	else if(i == 1)
	{
		return this.IRONARROW;
	}
	else if(i == 2)
	{
		return this.DIAMONDARROW;
	}
	else if(i == 3)
	{
		return this.GOLDARROW;
	}
	
	return DEFAULT;
	
}
}
