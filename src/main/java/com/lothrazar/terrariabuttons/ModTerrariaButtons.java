package com.lothrazar.terrariabuttons;
 
import com.lothrazar.terrariabuttons.net.*;

import net.minecraft.init.Blocks;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = ModTerrariaButtons.MODID, useMetadata=true, canBeDeactivated=false
		, version = ModTerrariaButtons.VERSION)
public class ModTerrariaButtons
{
    public static final String MODID = "terrariabuttons";
    public static final String VERSION = "1.8-1.0.0";
	@Instance(ModTerrariaButtons.MODID)
	public static ModTerrariaButtons instance;
	@SidedProxy(clientSide = "com.lothrazar.terrariabuttons.ClientProxy", serverSide = "com.lothrazar.terrariabuttons.CommonProxy")
	public static CommonProxy proxy;
	public SimpleNetworkWrapper network;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	network = NetworkRegistry.INSTANCE.newSimpleChannel(ModTerrariaButtons.MODID);
    	
    	/*
    	 //TODO
    	ModConfig.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));
*/
    	int packetID = 0;
    	network.registerMessage(DepositAllPacket.class,  DepositAllPacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(LootAllPacket.class,  LootAllPacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(QuickStackPacket.class,  QuickStackPacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(RenamePacket.class,  RenamePacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(RestockPacket.class,  RestockPacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(SortPacket.class,  SortPacket.class,  packetID++, Side.SERVER);
    	
    	proxy.registerHandlers();
    	
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {

    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent  event)
    {
    	
    }

    
    
    
    
    
    
    
    
}
