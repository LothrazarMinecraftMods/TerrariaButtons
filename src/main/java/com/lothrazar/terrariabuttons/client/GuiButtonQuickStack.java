package com.lothrazar.terrariabuttons.client;

import com.lothrazar.terrariabuttons.ModTerrariaButtons;
import com.lothrazar.terrariabuttons.net.QuickStackPacket;
import com.lothrazar.terrariabuttons.util.Const;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiButtonQuickStack extends GuiButton
{
	public GuiButtonQuickStack(int buttonId, int x, int y)
	{
		super(buttonId, x, y, Const.btnWidth, Const.btnHeight, StatCollector.translateToLocal("btn.quickstack"));
	}
 
	@SideOnly(Side.CLIENT)
    @Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
    {
    	boolean pressed = super.mousePressed(mc, mouseX, mouseY);
    	
    	if(pressed)
    	{ 
    		ModTerrariaButtons.instance.network.sendToServer(new QuickStackPacket(new NBTTagCompound()));
    	}
    	
    	return pressed;
    }
}
