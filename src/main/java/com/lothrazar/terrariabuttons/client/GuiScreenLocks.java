package com.lothrazar.terrariabuttons.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;

public class GuiScreenLocks extends GuiScreen
{
	private final EntityPlayer entityPlayer;
	public GuiScreenLocks(EntityPlayer entityPlayer)
	{
		this.entityPlayer = entityPlayer;
	}
	@Override
	public void initGui()
	{
		int buttonId = 0;
		int x = Minecraft.getMinecraft().displayWidth/2;
		int y = Minecraft.getMinecraft().displayHeight/2;
		int padding = 8;
		for(int rows = 0; rows < 3; rows++){
			for(int cols = 0; cols < 9; cols++){

				buttonId = rows + cols;
				x = cols * 20 + padding;
				y = rows * 20 + padding;
				buttonList.add(new GuiButtonSlotSingle(buttonId, x,y));
			}
		}
	}
}
