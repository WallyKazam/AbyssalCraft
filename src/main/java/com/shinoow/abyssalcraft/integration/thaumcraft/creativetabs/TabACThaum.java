package com.shinoow.abyssalcraft.integration.thaumcraft.creativetabs;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.shinoow.abyssalcraft.integration.thaumcraft.ACThaumcraftIntegration;

public class TabACThaum extends CreativeTabs {

	public static TabACThaum instance;

	public ArrayList<ItemStack> creativeTabQueue = new ArrayList<ItemStack>();
	List list = new ArrayList();

	public TabACThaum() {
		super("acthaum");
	}

	@Override
	public Item getTabIconItem() {

		return ACThaumcraftIntegration.wandCap;
	}

	@Override
	public void displayAllReleventItems(List list) {
		list.addAll(this.list);
	}

	public void addWands(){
		list.add(ACThaumcraftIntegration.darkWand);
		list.add(ACThaumcraftIntegration.corWand);
		list.add(ACThaumcraftIntegration.dreadWand);
		list.add(ACThaumcraftIntegration.omotholWand);
		list.add(ACThaumcraftIntegration.endWand);
	}

	public void addItem(Item item) {
		item.getSubItems(item, this, creativeTabQueue);
	}

	public void addBlock(Block block) {
		block.getSubBlocks(Item.getItemFromBlock(block), this, creativeTabQueue);
	}

	public void addAllItemsAndBlocks() {
		list.addAll(creativeTabQueue);
	}
}