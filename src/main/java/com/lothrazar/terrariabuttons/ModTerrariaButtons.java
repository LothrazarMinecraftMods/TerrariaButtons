package com.lothrazar.terrariabuttons;
 
import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ModTerrariaButtons.MODID, version = ModTerrariaButtons.VERSION)
public class ModTerrariaButtons
{
    public static final String MODID = "terrariabuttons";
    public static final String VERSION = "1.8-1.0.0";
	@SidedProxy(clientSide = "com.lothrazar.terrariabuttons.ClientProxy", serverSide = "com.lothrazar.terrariabuttons.CommonProxy")
	public static CommonProxy proxy;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	proxy.registerHandlers();
    	
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
        System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent  event)
    {
    	
    }

    
    
    
    
    
    
    
    
}
