package com.hexagram2021.breedingpotion;

import com.hexagram2021.breedingpotion.common.brew.BPBrewingRecipes;
import com.hexagram2021.breedingpotion.common.config.BPCommonConfig;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(BreedingPotion.MODID)
public class BreedingPotion {
	public static final String MODID = "breedingpotion";

	public BreedingPotion() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(this::setup);

		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BPCommonConfig.getConfig());

		MinecraftForge.EVENT_BUS.register(this);
	}

	public void setup(FMLCommonSetupEvent event) {
		event.enqueueWork(BPBrewingRecipes::init);
	}
}
