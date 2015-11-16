package com.lothrazar.terrariabuttons.net;

import com.lothrazar.terrariabuttons.util.UtilInventory;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
 
public class RestockPacket  implements IMessage , IMessageHandler<RestockPacket, IMessage>
{
	NBTTagCompound tags = new NBTTagCompound(); 
	public RestockPacket(){}
	public RestockPacket(NBTTagCompound ptags)
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
	public IMessage onMessage(RestockPacket message, MessageContext ctx)
	{
		EntityPlayer p = ctx.getServerHandler().playerEntity;

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
			 
			//Reverse of quickstack
			UtilInventory.sortFromInventoryToPlayer(p.worldObj, openInventory, p);
			
			UtilInventory.updatePlayerContainerClient(p);
		}
		
		return null;
	}
 
}
