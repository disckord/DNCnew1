package net.minecraft.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.Perk;

public class PerkGetter {

	
	public static Perk getPerkByName(String name)
	{
		
		try( FileReader perkFileReader = new FileReader(Minecraft.getAppDir("DNCminecraft") + "/perks.json"))
		{
			 JSONObject	JsonObject = (JSONObject) JSONValue.parseWithException(perkFileReader);
			 String perkID =  JsonObject.get(name).toString();
			 int i = Integer.parseInt(perkID);
			 if(i <= 0 || i > Perk.perks.length)
			 {
				return null; 
			 }
			 return Perk.perks[i];
		}
		catch(NullPointerException | IOException | ParseException e)
		{
			e.printStackTrace();
		}
		System.out.println("getting hard-coded perk for " + name);
		if(name == null)
		{
			return null;
		}
		if(name.equals("Disharmony"))
		{
			return Perk.flame;
		}
		if(name.equals("disckord"))
		{
			//System.out.println("perkgetter name is equal to disckord!");
			return Perk.snow;
		}
		if(name.equals("Count_Napula"))
		{
			//System.out.println("perkgetter name is equal to Enbi!");
			return Perk.blossom;
		}
		else
		{
		//	System.out.println("perkgetter is returning None for " + name);
			return null;
		}
		
	}
}
