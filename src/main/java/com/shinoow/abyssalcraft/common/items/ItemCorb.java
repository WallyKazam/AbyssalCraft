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
package com.shinoow.abyssalcraft.common.items;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import com.shinoow.abyssalcraft.api.block.ACBlocks;
import com.shinoow.abyssalcraft.lib.ACTabs;

public class ItemCorb extends Item {

	public ItemCorb() {
		super();
		maxStackSize = 1;
		setMaxDamage(1000);
		setUnlocalizedName("transmutationgem");
		setCreativeTab(ACTabs.tabTools);
	}

	@Override
	public String getItemStackDisplayName(ItemStack par1ItemStack) {

		return TextFormatting.AQUA + super.getItemStackDisplayName(par1ItemStack);
	}

	@Override
	public EnumActionResult onItemUse(ItemStack is, EntityPlayer player, World w, BlockPos pos, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ){
		if(w.getBlockState(pos).getBlock() == Blocks.STONE){
			w.setBlockState(pos, ACBlocks.darkstone.getDefaultState());
			is.damageItem(50, player);
		}else if(w.getBlockState(pos).getBlock() == ACBlocks.darkstone){
			w.setBlockState(pos, Blocks.STONE.getDefaultState());
			is.damageItem(50, player);
		}else if(w.getBlockState(pos).getBlock() == Blocks.COBBLESTONE){
			w.setBlockState(pos, ACBlocks.darkstone_cobblestone.getDefaultState());
			is.damageItem(50, player);
		}else if(w.getBlockState(pos).getBlock() == ACBlocks.darkstone_cobblestone){
			w.setBlockState(pos, Blocks.COBBLESTONE.getDefaultState());
			is.damageItem(50, player);
		}else if(w.getBlockState(pos).getBlock() == Blocks.STONEBRICK){
			w.setBlockState(pos, ACBlocks.darkstone_brick.getDefaultState());
			is.damageItem(50, player);
		}else if(w.getBlockState(pos).getBlock() == ACBlocks.darkstone_brick){
			w.setBlockState(pos, Blocks.STONEBRICK.getDefaultState());
			is.damageItem(50, player);
		}
		return EnumActionResult.PASS;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void addInformation(ItemStack is, EntityPlayer player, List l, boolean B){
		l.add(I18n.translateToLocal("tooltip.corb.1"));
		l.add(I18n.translateToLocal("tooltip.corb.2"));
		l.add(I18n.translateToLocal("tooltip.corb.3"));
		l.add(I18n.translateToLocal("tooltip.corb.4"));
	}

	@Override
	public boolean hasEffect(ItemStack is){
		return true;
	}
}