package com.hexagram2021.breedingpotion.common.register;

import com.hexagram2021.breedingpotion.common.BPContent;
import com.hexagram2021.breedingpotion.common.effects.BreedingEffect;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

import static com.hexagram2021.breedingpotion.BreedingPotion.MODID;

public final class BPMobEffects {
	public static final MobEffect BREEDING = new BreedingEffect(MobEffectCategory.BENEFICIAL, 0xFE8086);


	private BPMobEffects() {
	}

	public static void init(BPContent.RegisterConsumer<MobEffect> register) {
		register.accept(new ResourceLocation(MODID, "breeding"), BREEDING);
	}
}
