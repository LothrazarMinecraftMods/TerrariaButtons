package com.lothrazar.terrariabuttons;

import java.util.ArrayList;
import java.util.List;

import scala.actors.threadpool.Arrays;
import net.minecraftforge.common.config.Configuration;

public class ModConfig
{
	public static String position;
	public static boolean restockLeaveOne;

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
	
	public static List<String> blacklistGuis; 
	
	public static void syncConfig()
	{
		List<String> valid = new ArrayList<String>();
		valid.add(posLeft);
		valid.add(posRight);
		valid.add(posBottom); 

		restockLeaveOne = config.getBoolean("restock_leave_one", Configuration.CATEGORY_GENERAL, false, "By default (false) the Restock feature will empty your chests if possible.  If you change this to true, then using Restock will leave one behind of each item stack");
		
		position = config.getString("button_location", Configuration.CATEGORY_GENERAL, posRight, "Location of the buttons, "
				+ "valid entries are: "+String.join(",", valid));

		if(valid.contains(position) == false)
		{
			position = posRight;//default
		}
		
		String category = "blacklist_gui_class";
		config.addCustomCategoryComment(category, "Here you can blacklist any container, vanilla or modded.  Mostly for creating modpacks, if some containers shouldnt have these buttons showing up.");
		//the default
		String blacklistDefault = "net.minecraft.client.gui.inventory.GuiBrewingStand,"+ 
		   "net.minecraft.client.gui.inventory.GuiBeacon,"+ 
		   "net.minecraft.client.gui.inventory.GuiCrafting,"+ 
		   "net.minecraft.client.gui.inventory.GuiFurnace,"+ 
		   "net.minecraft.client.gui.inventory.GuiScreenHorseInventory";
	
		String csv = config.getString("classes_csv", category, blacklistDefault, "These containers are blocked from getting the buttons.  By default, anything that extends 'GuiContainer' will get the buttons.  ");
		//blacklistGuis = new ArrayList<String>();
		blacklistGuis = (List<String>)Arrays.asList(csv.split(","));
		if(blacklistGuis == null) blacklistGuis = new ArrayList<String>();//just being extra safe
		
		if(config.hasChanged()){config.save();}
	}
}
