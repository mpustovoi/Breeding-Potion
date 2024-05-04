package com.hexagram2021.breedingpotion.common.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Objects;

public class BPCommonConfig {
	public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
	protected static final ForgeConfigSpec SPEC;

	protected static final ForgeConfigSpec.ConfigValue<String> INGREDIENT_BREWING;
	public static final ForgeConfigSpec.ConfigValue<List<? extends String>> IGNORE_ANIMALS;

	static {
		BUILDER.push("breedingpotion-common-config");
		INGREDIENT_BREWING = BUILDER.comment("Ingredient of brewing recipe of breeding potion.")
				.define("INGREDIENT_BREWING", Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(Items.ENCHANTED_GOLDEN_APPLE)).toString());
		IGNORE_ANIMALS = BUILDER.comment("These animals will never turn into breeding mode and only regenerate after gaining breeding effect.")
				.defineList("IGNORE_ANIMALS", List.of(
						new ResourceLocation(ResourceLocation.DEFAULT_NAMESPACE, "polar_bear").toString()
				), o -> o instanceof String s && ResourceLocation.isValidResourceLocation(s));
		BUILDER.pop();

		SPEC = BUILDER.build();
	}

	public static Item getBrewingIngredient() {
		Item ret = ForgeRegistries.ITEMS.getValue(new ResourceLocation(INGREDIENT_BREWING.get()));
		return ret == null ? Items.ENCHANTED_GOLDEN_APPLE : ret;
	}

	public static ForgeConfigSpec getConfig() {
		return SPEC;
	}
}
