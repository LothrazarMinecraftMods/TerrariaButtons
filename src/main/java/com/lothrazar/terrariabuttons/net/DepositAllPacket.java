package com.lothrazar.terrariabuttons.net;
 

import com.lothrazar.terrariabuttons.util.UtilInventory;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
public class DepositAllPacket  implements IMessage , IMessageHandler<DepositAllPacket, IMessage>
{
	NBTTagCompound tags = new NBTTagCompound(); 
	public DepositAllPacket(){}
	public DepositAllPacket(NBTTagCompound ptags)
	{
		tags = ptags;
	}

	@Override
	public void fromBytes(ByteBuf buf) 
	{
		tags = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeTag(buf, this.tags);
	}
	@Override
	public IMessage onMessage(DepositAllPacket message, MessageContext ctx)
	{
		EntityPlayer p = ctx.getServerHandler().playerEntity;
		System.out.println("DepositAllPacket");
		
		if(p.openContainer == null || p.openContainer.getSlot(0) == null || p.openContainer.getSlot(0).inventory == null)
		{
			//TODO: use logger
			System.out.println("ERROR LOG: null container inventory");
			 
		}
		else
		{
			//a workaround since player does not reference the inventory, only the container
			//and Container has no get method
			IInventory openInventory = p.openContainer.getSlot(0).inventory;
			
			
			UtilInventory.dumpFromPlayerToIInventory(p.worldObj, openInventory, p);
			
			//TODO: find out a way to sync visibility without closescreen
			p.closeScreen();
		}
		
		return null;
	}
 
}
