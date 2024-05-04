package com.hexagram2021.breedingpotion.common.register;

import com.hexagram2021.breedingpotion.common.BPContent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.alchemy.Potion;

import static com.hexagram2021.breedingpotion.BreedingPotion.MODID;

public final class BPPotions {
	public static final ResourceLocation ID_BREEDING_POTION = new ResourceLocation(MODID, "breeding");
	public static final ResourceLocation ID_LONG_BREEDING_POTION = new ResourceLocation(MODID, "long_breeding");
	public static final ResourceLocation ID_STRONG_BREEDING_POTION = new ResourceLocation(MODID, "strong_breeding");

	public static final Potion BREEDING = new Potion(ID_BREEDING_POTION.getPath(), new MobEffectInstance(BPMobEffects.BREEDING, 300));
	public static final Potion LONG_BREEDING = new Potion(ID_BREEDING_POTION.getPath(), new MobEffectInstance(BPMobEffects.BREEDING, 600));
	public static final Potion STRONG_BREEDING = new Potion(ID_BREEDING_POTION.getPath(), new MobEffectInstance(BPMobEffects.BREEDING, 150, 1));

	private BPPotions() {
	}

	public static void init(BPContent.RegisterConsumer<Potion> register) {
		register.accept(ID_BREEDING_POTION, BREEDING);
		register.accept(ID_LONG_BREEDING_POTION, LONG_BREEDING);
		register.accept(ID_STRONG_BREEDING_POTION, STRONG_BREEDING);
	}
}
