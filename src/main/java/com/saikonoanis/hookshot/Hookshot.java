package com.saikonoanis.hookshot;

import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.minecraft.item.Item;
import net.minecraft.registry.Registry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

public class Hookshot implements ModInitializer {
	public static final String MOD_ID = "hookshot";


	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	public static Item HOOKSHOT_ITEM;

	@Override
	public void onInitialize() {
		registerItems();

		LOGGER.info("Hookshot chargé!");
	}

	public void registerItems(){
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id("hookshot_item"));
		Item.Settings settings = new Item.Settings().registryKey(itemKey);
		HOOKSHOT_ITEM = new HookshotItem(settings);
		Registry.register(Registries.ITEM, itemKey, HOOKSHOT_ITEM);
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
