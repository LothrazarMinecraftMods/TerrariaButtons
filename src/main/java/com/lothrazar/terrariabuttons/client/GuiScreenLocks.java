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
		int x = Minecraft.getMinecraft().displayWidth/4;
		int y;// = Minecraft.getMinecraft().displayHeight/2;
		int w = 20; // button width is fixed
		int padding = 8;//space between
		GuiButtonSlotSingle b;
		for(int rows = 0; rows < 3; rows++){
			y = Minecraft.getMinecraft().displayHeight/2 + rows*20 + padding;
			for(int cols = 0; cols < 9; cols++){

				buttonId = rows + cols;
				x += w + padding;
				b = new GuiButtonSlotSingle(buttonId, x,y);
				b.setLoc(rows,cols);
				buttonList.add(b);
			}
		}
	}
}
