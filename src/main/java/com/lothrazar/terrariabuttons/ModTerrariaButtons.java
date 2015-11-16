package com.lothrazar.terrariabuttons;
 
import com.lothrazar.terrariabuttons.net.*;
import com.lothrazar.terrariabuttons.util.Const; 
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

@Mod(modid = Const.MODID, useMetadata=true, canBeDeactivated=false 
		,  guiFactory ="com.lothrazar."+Const.MODID+".IngameConfigHandler")
public class ModTerrariaButtons
{ 
	@Instance(Const.MODID)
	public static ModTerrariaButtons instance;
	@SidedProxy(clientSide = "com.lothrazar.terrariabuttons.ClientProxy", serverSide = "com.lothrazar.terrariabuttons.CommonProxy")
	public static CommonProxy proxy;
	public SimpleNetworkWrapper network;
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
    	network = NetworkRegistry.INSTANCE.newSimpleChannel(Const.MODID);
    	
    	ModConfig.loadConfig(new Configuration(event.getSuggestedConfigurationFile()));

    	int packetID = 0;
    	network.registerMessage(DepositAllPacket.class,  DepositAllPacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(LootAllPacket.class,  LootAllPacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(QuickStackPacket.class,  QuickStackPacket.class,  packetID++, Side.SERVER);
    	network.registerMessage(RestockPacket.class,  RestockPacket.class,  packetID++, Side.SERVER);
    	//network.registerMessage(RestockPacket.class,  RestockPacket.class,  packetID++, Side.SERVER);
    	
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
