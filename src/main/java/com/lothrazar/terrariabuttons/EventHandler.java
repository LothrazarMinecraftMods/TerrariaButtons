package com.lothrazar.terrariabuttons;
  
import com.lothrazar.terrariabuttons.client.*;
import com.lothrazar.terrariabuttons.util.Const;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiScreenEvent.InitGuiEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent.OnConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandler
{
    @SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onGuiPostInit(InitGuiEvent.Post event)
	{
		if(event.gui == null){return;}//probably doesnt ever happen
		
		//EntityPlayer p = Minecraft.getMinecraft().thePlayer;
		
		
		//TODO: get a blacklist//whitelist from config?
		/*
		//blacklist method
		if (event.gui instanceof GuiContainer && 
			!(event.gui instanceof net.minecraft.client.gui.GuiMerchant) &&
			!(event.gui instanceof net.minecraft.client.gui.GuiRepair) &&
			!(event.gui instanceof net.minecraft.client.gui.inventory.GuiBeacon) &&
			!(event.gui instanceof net.minecraft.client.gui.inventory.GuiInventory) //players inventory
			)*/
		
		//System.out.println(event.gui.getClass().getName());
		//whitelist method
		if(event.gui instanceof net.minecraft.client.gui.inventory.GuiChest || 
		   event.gui instanceof net.minecraft.client.gui.inventory.GuiDispenser || 
		   event.gui instanceof net.minecraft.client.gui.inventory.GuiBrewingStand || 
		   event.gui instanceof net.minecraft.client.gui.inventory.GuiBeacon || 
		   event.gui instanceof net.minecraft.client.gui.inventory.GuiCrafting || 
		   event.gui instanceof net.minecraft.client.gui.inventory.GuiFurnace || 
		   event.gui instanceof net.minecraft.client.gui.inventory.GuiScreenHorseInventory
		)
		{
			int button_id = 256;
			
			// TODO: config for different locations - left right bottom top
			int x=0,y=0,padding = 6, yDelta = 24, xDelta = 0;

			if(ModConfig.position.equalsIgnoreCase(ModConfig.posLeft))
			{
				x = padding;
				y = padding;
				//we are moving top to bottom, so 
				xDelta = 0;
				yDelta = Const.btnHeight + padding;
			}
			else if(ModConfig.position.equalsIgnoreCase(ModConfig.posRight))
			{
				x = Minecraft.getMinecraft().displayWidth/2 - Const.btnWidth - padding;//align to right side
				y = padding;
				//we are moving top to bottom, so 
				xDelta = 0;
				yDelta = Const.btnHeight + padding;
			}
			else if(ModConfig.position.equalsIgnoreCase(ModConfig.posBottom))
			{
				//test bottom
				x = padding;
				y = Minecraft.getMinecraft().displayHeight/2 - padding - Const.btnHeight;
				xDelta = Const.btnWidth + padding;
				yDelta = 0;
			}
 
			event.buttonList.add(new GuiButtonLootAll(button_id++, x,y));

			x += xDelta;
			y += yDelta;

			event.buttonList.add(new GuiButtonDepositAll(button_id++, x,y));

			x += xDelta;
			y += yDelta;

			event.buttonList.add(new GuiButtonQuickStack(button_id++, x,y));

			x += xDelta;
			y += yDelta;

			event.buttonList.add(new GuiButtonRestock(button_id++, x,y));

			//y += ypadding;

			//event.buttonList.add(new GuiButtonRename(button_id++, x,y));
		}
	}
    
	@SubscribeEvent
	public void onConfigChanged(OnConfigChangedEvent event) 
	{
		if (event.modID.equals(Const.MODID)) {ModConfig.syncConfig();}
	}
}
