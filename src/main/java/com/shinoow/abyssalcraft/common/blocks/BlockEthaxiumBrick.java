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
package com.shinoow.abyssalcraft.common.blocks;

import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

public class BlockEthaxiumBrick extends BlockACBasic {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockEthaxiumBrick.EnumBrickType.class);

	public BlockEthaxiumBrick(float hardness) {
		super(Material.ROCK, "pickaxe", 8, hardness, Float.MAX_VALUE, SoundType.STONE);
		setDefaultState(blockState.getBaseState().withProperty(TYPE, EnumBrickType.NORMAL));

	}

	@Override
	public int damageDropped (IBlockState state) {
		return ((EnumBrickType)state.getValue(TYPE)).getMeta();
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		par3List.add(new ItemStack(par1, 1, 0));
		par3List.add(new ItemStack(par1, 1, 1));
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(TYPE, EnumBrickType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumBrickType)state.getValue(TYPE)).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { TYPE });
	}

	public enum EnumBrickType implements IStringSerializable {
		NORMAL(0, "normal"),
		CHISELED(1, "chiseled");

		private static final BlockEthaxiumBrick.EnumBrickType[] META_LOOKUP = new BlockEthaxiumBrick.EnumBrickType[values().length];

		private int meta;
		private String name;

		private EnumBrickType(int meta, String name) {
			this.meta = meta;
			this.name = name;
		}

		public static BlockEthaxiumBrick.EnumBrickType byMetadata(int meta)
		{
			if (meta < 0 || meta >= META_LOOKUP.length)
				meta = 0;

			return META_LOOKUP[meta];
		}

		@Override
		public String getName() {
			return name;
		}

		public int getMeta() {
			return meta;
		}

		@Override
		public String toString() {
			return getName();
		}

		static {
			for(BlockEthaxiumBrick.EnumBrickType type : values())
				META_LOOKUP[type.getMeta()] = type;
		}
	}
}