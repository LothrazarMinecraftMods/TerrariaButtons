package com.lothrazar.terrariabuttons;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = ModTerrariaButtons.MODID, version = ModTerrariaButtons.VERSION)
public class ModTerrariaButtons
{
    public static final String MODID = "terrariabuttons";
    public static final String VERSION = "1.8-1.0.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
}
