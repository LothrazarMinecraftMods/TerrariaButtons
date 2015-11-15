package com.lothrazar.terrariabuttons;
 
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.*;
import net.minecraft.client.gui.inventory.*; 
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.StatCollector;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandler
{
    
    
    @SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onGuiPostInit(InitGuiEvent.Post event)
	{
		if(event.gui == null){return;}//probably doesnt ever happen
		
		EntityPlayer p = Minecraft.getMinecraft().thePlayer;
		int button_id = 256;
		
		int padding = 10;
		int h = 20, w = 50;
		int x = Minecraft.getMinecraft().displayWidth/2 - w - padding;//align to right side
		int y = 4*padding;
		
		//TODO: get a blacklist from config?
		if (event.gui instanceof GuiContainer && 
			!(event.gui instanceof net.minecraft.client.gui.GuiMerchant) &&
			!(event.gui instanceof net.minecraft.client.gui.GuiRepair) &&
			!(event.gui instanceof net.minecraft.client.gui.inventory.GuiBeacon) &&
			!(event.gui instanceof net.minecraft.client.gui.inventory.GuiInventory) //players inventory
			)
		{
			//TODO: ... button does nothing for now
			event.buttonList.add(new GuiButton(button_id++, x,y,w,h,StatCollector.translateToLocal("button.t")));

		}
	}
    
}
