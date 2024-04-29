package com.hexagram2021.breedingpotion.common;

import com.hexagram2021.breedingpotion.common.register.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

import java.util.function.BiConsumer;

import static com.hexagram2021.breedingpotion.BreedingPotion.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BPContent {

	@SubscribeEvent
	public static void onRegister(RegisterEvent event) {
		event.register(Registries.POTION, helper -> BPPotions.init(helper::register));
		event.register(Registries.MOB_EFFECT, helper -> BPMobEffects.init(helper::register));
	}

	public interface RegisterConsumer<T> extends BiConsumer<ResourceLocation, T> {
	}
}
