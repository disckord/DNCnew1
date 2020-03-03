package net.minecraft.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import net.minecraft.client.Minecraft;
import net.minecraft.src.a1Version;
public class VersionWriter 
{
	public static void writeGameVersionToFile() throws IOException
	{
		File currentVersionFile = new File(Minecraft.getMinecraftDir(), "currentVersion");
		if(currentVersionFile.createNewFile())
		{
			System.out.println("Created current version file");
		}
		else if(currentVersionFile.exists())
		{
			System.out.println("Current version file already existing. Will write to it.");
		}
		else
		{
			System.err.println("Could not create current version file!");
		}
		if(currentVersionFile.exists())
		{
			System.out.println("Writing version " + a1Version.gameVersion + " to current version file.");
			FileOutputStream writer = new FileOutputStream(currentVersionFile);
			writer.write(a1Version.gameVersion.getBytes(), 0, a1Version.gameVersion.length());
			writer.close();
		}
	}
	
}
