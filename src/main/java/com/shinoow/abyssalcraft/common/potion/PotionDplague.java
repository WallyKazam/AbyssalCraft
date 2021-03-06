/*******************************************************************************
 * AbyssalCraft
 * Copyright (c) 2012 - 2016 Shinoow.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v3
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-3.0.txt
 * 
 * Contributors:
 *     Shinoow -  implementation
 ******************************************************************************/
package com.shinoow.abyssalcraft.common.potion;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.shinoow.abyssalcraft.api.AbyssalCraftAPI;
import com.shinoow.abyssalcraft.api.entity.IDreadEntity;
import com.shinoow.abyssalcraft.common.entity.*;
import com.shinoow.abyssalcraft.common.entity.anti.*;
import com.shinoow.abyssalcraft.common.entity.demon.*;

public class PotionDplague extends Potion{

	public PotionDplague(boolean par2, int par3) {
		super(par2, par3);
	}

	@Override
	public Potion setIconIndex(int par1, int par2) {
		super.setIconIndex(par1, par2);
		return this;
	}

	@Override
	public void performEffect(EntityLivingBase par1EntityLivingBase, int par2){

		if(par1EntityLivingBase instanceof IDreadEntity)
			par1EntityLivingBase.removePotionEffect(this);
		else par1EntityLivingBase.attackEntityFrom(AbyssalCraftAPI.dread, 1);

		if(par1EntityLivingBase instanceof EntityPlayer)
			((EntityPlayer)par1EntityLivingBase).addExhaustion(0.025F * (par2+2));
		if(!par1EntityLivingBase.worldObj.isRemote && !par1EntityLivingBase.isEntityAlive()
				&& par1EntityLivingBase.worldObj.rand.nextBoolean())
			if(par1EntityLivingBase instanceof EntityZombie || par1EntityLivingBase instanceof EntityPlayer
					|| par1EntityLivingBase instanceof EntityAbyssalZombie || par1EntityLivingBase instanceof EntityAntiPlayer
					|| par1EntityLivingBase instanceof EntityAntiAbyssalZombie || par1EntityLivingBase instanceof EntityAntiZombie
					|| par1EntityLivingBase instanceof EntitySkeleton || par1EntityLivingBase instanceof EntityAntiSkeleton){
				EntityDreadling dreadling = new EntityDreadling(par1EntityLivingBase.worldObj);
				dreadling.copyLocationAndAnglesFrom(par1EntityLivingBase);
				par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
				dreadling.onInitialSpawn(null, null);
				par1EntityLivingBase.worldObj.spawnEntityInWorld(dreadling);
			}
			else if(par1EntityLivingBase instanceof EntitySkeletonGoliath){
				EntityDreadguard dg = new EntityDreadguard(par1EntityLivingBase.worldObj);
				dg.copyLocationAndAnglesFrom(par1EntityLivingBase);
				par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
				dg.onInitialSpawn(par1EntityLivingBase.worldObj.getDifficultyForLocation(par1EntityLivingBase.getPosition()),(IEntityLivingData)null);
				par1EntityLivingBase.worldObj.spawnEntityInWorld(dg);
			}
			else if(par1EntityLivingBase instanceof EntityPig){
				EntityDemonPig dp = new EntityDemonPig(par1EntityLivingBase.worldObj);
				dp.copyLocationAndAnglesFrom(par1EntityLivingBase);
				par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
				dp.onInitialSpawn(par1EntityLivingBase.worldObj.getDifficultyForLocation(par1EntityLivingBase.getPosition()),(IEntityLivingData)null);
				par1EntityLivingBase.worldObj.spawnEntityInWorld(dp);
			}
			else if(par1EntityLivingBase instanceof EntityCow){
				EntityDemonCow dc = new EntityDemonCow(par1EntityLivingBase.worldObj);
				dc.copyLocationAndAnglesFrom(par1EntityLivingBase);
				par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
				dc.onInitialSpawn(par1EntityLivingBase.worldObj.getDifficultyForLocation(par1EntityLivingBase.getPosition()),(IEntityLivingData)null);
				par1EntityLivingBase.worldObj.spawnEntityInWorld(dc);
			}
			else if(par1EntityLivingBase instanceof EntityChicken){
				EntityDemonChicken dc = new EntityDemonChicken(par1EntityLivingBase.worldObj);
				dc.copyLocationAndAnglesFrom(par1EntityLivingBase);
				par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
				dc.onInitialSpawn(par1EntityLivingBase.worldObj.getDifficultyForLocation(par1EntityLivingBase.getPosition()),(IEntityLivingData)null);
				par1EntityLivingBase.worldObj.spawnEntityInWorld(dc);
			}
			else if(par1EntityLivingBase instanceof EntityLivingBase && !(par1EntityLivingBase instanceof EntityAntiGhoul)){
				EntityDreadSpawn spawn = new EntityDreadSpawn(par1EntityLivingBase.worldObj);
				spawn.copyLocationAndAnglesFrom(par1EntityLivingBase);
				par1EntityLivingBase.worldObj.removeEntity(par1EntityLivingBase);
				spawn.onInitialSpawn(null, null);
				par1EntityLivingBase.worldObj.spawnEntityInWorld(spawn);
			}
	}

	@Override
	public boolean isReady(int par1, int par2)
	{
		int k = 25 >> par2;
		return k > 0 ? par1 % k == 0 : true;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getStatusIconIndex()
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("abyssalcraft:textures/misc/potionFX.png"));
		return 1;
	}
}
