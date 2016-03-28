package com.lothrazar.terrariabuttons.client;

import com.lothrazar.terrariabuttons.ModTerrariaButtons;
import com.lothrazar.terrariabuttons.net.LootAllPacket;
import com.lothrazar.terrariabuttons.util.Const;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.nbt.NBTTagCompound; 
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiButtonLootAll extends GuiButton
{
	public GuiButtonLootAll(int buttonId, int x, int y)
	{
		super(buttonId, x, y, Const.btnWidth, Const.btnHeight, I18n.translateToLocal("btn.lootall"));
	}

	@SideOnly(Side.CLIENT)
    @Override
    public boolean mousePressed(Minecraft mc, int mouseX, int mouseY)
    {
    	boolean pressed = super.mousePressed(mc, mouseX, mouseY);
    	
    	if(pressed)
    	{ 
    		ModTerrariaButtons.instance.network.sendToServer(new LootAllPacket(new NBTTagCompound()));
    	}
    	
    	return pressed;
    }


}
