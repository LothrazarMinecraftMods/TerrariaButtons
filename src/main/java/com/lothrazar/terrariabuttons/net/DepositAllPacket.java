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
		// TODO Auto-generated method stub
		//TODO: get coordinates of the currently open container that the player is using
		/*
		 * posCurrent = new BlockPos(xLoop, yLoop, zLoop);
					if(player.worldObj.getTileEntity(posCurrent) instanceof IInventory)
					{ 
						found.add((IInventory)player.worldObj.getTileEntity(posCurrent));
					} 
		UtilInventory.dumpFromPlayerToIInventory(p.worldObj, inventory, p);
		
					*/
		
		
		return null;
	}
 
}
