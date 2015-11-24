package com.lothrazar.terrariabuttons;
 
import com.lothrazar.terrariabuttons.client.GuiScreenLocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler; 
import net.minecraftforge.fml.common.network.IGuiHandler;

public class CommonProxy  implements IGuiHandler
{
	public boolean isClient()
	{
		return false;
	}
	
	public void registerHandlers()
	{
		EventHandler handler = new EventHandler();
		MinecraftForge.EVENT_BUS.register(handler);
		FMLCommonHandler.instance().bus().register(handler); 
    }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		 if (ID == ModTerrariaButtons.GUI_ID)
            return new GuiScreenLocks(player);
		// TODO Auto-generated method stub
		return null;
	}
}
