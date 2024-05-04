package com.hexagram2021.breedingpotion.common.brew;

import com.hexagram2021.breedingpotion.common.config.BPCommonConfig;
import com.hexagram2021.breedingpotion.common.register.BPPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.brewing.BrewingRecipe;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;

public final class BPBrewingRecipes {
	public static void init() {
		addFullRecipe(
				Potions.REGENERATION, Potions.LONG_REGENERATION, Potions.STRONG_REGENERATION,
				BPCommonConfig.getBrewingIngredient(),
				BPPotions.BREEDING, BPPotions.LONG_BREEDING, BPPotions.STRONG_BREEDING
		);
	}

	private BPBrewingRecipes() {
	}

	@SuppressWarnings("SameParameterValue")
	private static void addFullRecipe(Potion input, Potion inputLonger, Potion inputStronger, ItemLike add, Potion origin, Potion longer, Potion stronger) {
		addRecipe(input, add, origin);
		addRecipe(inputLonger, add, longer);
		addRecipe(inputStronger, add, stronger);
		addProlongRecipe(origin, longer);
		addStrengthenRecipe(origin, stronger);
	}
	private static void addProlongRecipe(Potion origin, Potion longer) {
		addRecipe(origin, Items.REDSTONE, longer);
	}
	private static void addStrengthenRecipe(Potion origin, Potion stronger) {
		addRecipe(origin, Items.GLOWSTONE_DUST, stronger);
	}

	private static void addRecipe(Potion input, ItemLike add, Potion output) {
		BrewingRecipeRegistry.addRecipe(new BPBrewingRecipe(
				PotionUtils.setPotion(new ItemStack(Items.POTION), input),
				add,
				PotionUtils.setPotion(new ItemStack(Items.POTION), output)
		));
		BrewingRecipeRegistry.addRecipe(new BPBrewingRecipe(
				PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), input),
				add,
				PotionUtils.setPotion(new ItemStack(Items.SPLASH_POTION), output)
		));
		BrewingRecipeRegistry.addRecipe(new BPBrewingRecipe(
				PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), input),
				add,
				PotionUtils.setPotion(new ItemStack(Items.LINGERING_POTION), output)
		));
	}

	private static final class BPBrewingRecipe extends BrewingRecipe {
		public BPBrewingRecipe(ItemStack input, ItemLike add, ItemStack output) {
			super(Ingredient.of(input), Ingredient.of(add), output);
		}

		@Override
		public boolean isInput(ItemStack input) {
			for(ItemStack itemstack : this.getInput().getItems()) {
				if (ItemStack.isSameItem(itemstack, input) && PotionUtils.getPotion(input).equals(PotionUtils.getPotion(itemstack))) {
					return true;
				}
			}
			return false;
		}
	}
}
