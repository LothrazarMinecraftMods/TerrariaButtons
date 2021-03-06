package com.lothrazar.terrariabuttons.client;

import com.lothrazar.terrariabuttons.ModTerrariaButtons;
import com.lothrazar.terrariabuttons.net.DepositAllPacket;
import com.lothrazar.terrariabuttons.util.Const;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound; 
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiButtonDepositAll extends GuiButton
{
	public GuiButtonDepositAll(int buttonId, int x, int y)
	{
		super(buttonId, x, y, Const.btnWidth, Const.btnHeight, I18n.translateToLocal("btn.deposit"));
    }

	
	@SideOnly(Side.CLIENT)
    @Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
    {
    	boolean pressed = super.mousePressed(mc, mouseX, mouseY);
    	
    	if(pressed)
    	{ 
    		//TODO: can we get TE xyz here
    		//Minecraft.getMinecraft().thePlayer.openContainer.
    		
    		ModTerrariaButtons.instance.network.sendToServer(new DepositAllPacket(new NBTTagCompound()));
    	}
    	
    	return pressed;
    }
}
