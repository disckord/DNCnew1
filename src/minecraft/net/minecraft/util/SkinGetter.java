package net.minecraft.util;

import java.io.IOException;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

public class SkinGetter{
	 public static String getUUID(String name) 
	 {
		 	String url = "https://api.mojang.com/users/profiles/minecraft/"+name;
		 	
		 	try{
		 /*	URL testUrl = new URL("https://www.minecraft.net");
		 	URLConnection testConnection = testUrl.openConnection();
		 	testConnection.connect();*/
			System.out.println((new StringBuilder()).append("SENDING REQUEST TO: ").append(url).toString());
            String UUIDJson = IOUtils.toString(new URL(url));           
            if(UUIDJson.isEmpty())
            {
            return  "invalid name";
            }
            
            
			
            JSONObject	UUIDObject = (JSONObject) JSONValue.parseWithException(UUIDJson);
            return UUIDObject.get("id").toString();
		 	}
		 	catch(IOException | ParseException e)
		 	{
		 		e.printStackTrace();
		 	}
            
       
            return"error";
            
		 
	       
	  }
	 

}
