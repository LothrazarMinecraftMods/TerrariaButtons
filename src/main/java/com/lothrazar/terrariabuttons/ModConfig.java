package com.lothrazar.terrariabuttons;

import java.util.ArrayList;
import java.util.List;

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
	
	private static String allClasses;
	public static ArrayList<Class> classes = new ArrayList<Class>();
	
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
		
		String category = "the_classes";
		
		
		
		String all = "net.minecraft.client.gui.inventory.GuiChest,"+
		   "net.minecraft.client.gui.inventory.GuiDispenser,"+ 
		   "net.minecraft.client.gui.inventory.GuiBrewingStand,"+ 
		   "net.minecraft.client.gui.inventory.GuiBeacon,"+ 
		   "net.minecraft.client.gui.inventory.GuiCrafting,"+ 
		   "net.minecraft.client.gui.inventory.GuiFurnace,"+ 
		   "net.minecraft.client.gui.inventory.GuiScreenHorseInventory,"+
		   "com.jaquadro.minecraft.storagedrawers.client.gui.GuiDrawers,"+
		   "cpw.mods.ironchest.client.GUIChest ";
	
		allClasses = config.getString("classes_csv", category, all, "DO NOT touch unless you have other mods installed with containers that you want to add compatibility for.  The class and package of every GUI screen that has these buttons show up.  ");

		if(config.hasChanged()){config.save();}
	}

	static void classesFromCsv()
	{ 
		classes = new ArrayList<Class>();
	
		String[] csv = allClasses.split(",");
		for(String s : csv)
		{
			try{
				classes.add(Class.forName(s));
			}
			catch(Exception e){
				//TODO: use a real logger?
				System.out.println(e.getMessage());
			}
		}
	}
}
