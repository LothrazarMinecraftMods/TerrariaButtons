package com.lothrazar.terrariabuttons;

import com.lothrazar.terrariabuttons.util.Const;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

public class IngameConfigGui extends GuiConfig 
{
	//thanks to the http://jabelarminecraft.blogspot.ca/p/minecraft-modding-configuration-guis.html
	public IngameConfigGui(GuiScreen parent) 
    {
        super(parent, new ConfigElement(
        		ModConfig.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Const.MODID, 
                false, 
                false, 
                "Overpowered Inventory");
        this.titleLine2 = "See the "+Const.MODID+".cfg file for even more options";
    }
	
	@Override
    public void initGui()
    {
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button)
    {
        super.actionPerformed(button);
    }
}
