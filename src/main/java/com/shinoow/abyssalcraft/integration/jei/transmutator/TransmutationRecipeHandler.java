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
package com.shinoow.abyssalcraft.integration.jei.transmutator;

import javax.annotation.Nonnull;

import mezz.jei.api.recipe.IRecipeHandler;
import mezz.jei.api.recipe.IRecipeWrapper;

import com.shinoow.abyssalcraft.integration.jei.AbyssalCraftRecipeCategoryUid;

public class TransmutationRecipeHandler implements IRecipeHandler<TransmutationRecipe> {

	@Override
	@Nonnull
	public Class<TransmutationRecipe> getRecipeClass() {
		return TransmutationRecipe.class;
	}

	@Nonnull
	@Override
	public String getRecipeCategoryUid() {
		return AbyssalCraftRecipeCategoryUid.TRANSMUTATION;
	}

	@Override
	@Nonnull
	public IRecipeWrapper getRecipeWrapper(@Nonnull TransmutationRecipe recipe) {
		return recipe;
	}

	@Override
	public boolean isRecipeValid(@Nonnull TransmutationRecipe recipe) {
		return recipe.getInputs().size() != 0 && recipe.getOutputs().size() > 0;
	}

	@Override
	public String getRecipeCategoryUid(TransmutationRecipe recipe) {

		return AbyssalCraftRecipeCategoryUid.TRANSMUTATION;
	}
}
