package com.lothrazar.terrariabuttons.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiButtonSlotSingle extends GuiButton
{ 
	public GuiButtonSlotSingle(int buttonId, int x, int y)
	{
		super(buttonId, x, y, "btn");
		this.width=20;
		this.height=20; 
	} 
	
	@SideOnly(Side.CLIENT)
    @Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
    {
    	boolean pressed = super.mousePressed(mc, mouseX, mouseY);
    	
    	if(pressed)
    	{ 
    		System.out.printf("\n",this.id,row,col);
    		//ModTerrariaButtons.instance.network.sendToServer(new LootAllPacket(new NBTTagCompound()));
    	}
    	
    	return pressed;
    }

	private int row;
	private int col;
	public void setLoc(int r, int c)
	{
		row=r;
		col=c;
	}
}
