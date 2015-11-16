package com.lothrazar.terrariabuttons;

import java.util.ArrayList;
import java.util.List;

import net.minecraftforge.common.config.Configuration;

public class ModConfig
{
	public static String position;

	public static String posLeft = "topleft";
	public static String posRight = "topright";
	public static String posBottom = "bottomleft";
	
	public static Configuration config;
	public static void loadConfig(Configuration c)
	{
		config = c;
    	config.load();
    	syncConfig();
	}
	
	public static void syncConfig()
	{
		List<String> valid = new ArrayList<String>();
		valid.add(posLeft);
		valid.add(posRight);
		valid.add(posBottom); 
		
		position = config.getString("button_location", Configuration.CATEGORY_GENERAL, posRight, "Location of the buttons, "
				+ "valid entries are: "+String.join(",", valid));
		
		if(valid.contains(position) == false)
		{
			position = posRight;//default
		}
		
		if(config.hasChanged()){config.save();}
	}
}
