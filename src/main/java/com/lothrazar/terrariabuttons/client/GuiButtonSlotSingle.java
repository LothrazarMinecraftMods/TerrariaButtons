package com.lothrazar.terrariabuttons.client;

import net.minecraft.client.gui.GuiButton;

public class GuiButtonSlotSingle extends GuiButton
{ 
	public GuiButtonSlotSingle(int buttonId, int x, int y)
	{
		super(buttonId, x, y, "btn");
		this.width=20;
		this.height=20; 
	} 
}
