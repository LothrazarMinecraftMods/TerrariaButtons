package com.lothrazar.terrariabuttons;
 
import net.minecraftforge.common.MinecraftForge; 

public class CommonProxy
{
	public boolean isClient()
	{
		return false;
	}
	
	public void registerHandlers()
	{
		EventHandler handler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(handler); 
    }
}
