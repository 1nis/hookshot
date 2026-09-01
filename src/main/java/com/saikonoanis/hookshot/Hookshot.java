package com.saikonoanis.hookshot;

import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
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
	public static EntityType<HookshotEntity> HOOKSHOT_ENTITY;

	@Override
	public void onInitialize() {
		registerItems();
		registerEntities();
		LOGGER.info("Hookshot chargé!");
	}

	// Création objet HookShot en tant qu'item
	public void registerItems(){
		RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, id("hookshot_item"));
		Item.Settings settings = new Item.Settings().registryKey(itemKey);
		HOOKSHOT_ITEM = new HookshotItem(settings);
		Registry.register(Registries.ITEM, itemKey, HOOKSHOT_ITEM);
	}

	// Création entité fil (ligne de pêche) du grappin
	public void registerEntities(){
		RegistryKey<EntityType<?>> entityKey = RegistryKey.of(RegistryKeys.ENTITY_TYPE, id("hookshot_entity"));
		EntityType.Builder fabric = EntityType.Builder.create(HookshotEntity::new, SpawnGroup.MISC);
		fabric = fabric.dimensions(0.25F, 0.25F);
		HOOKSHOT_ENTITY = fabric.build(entityKey);
		Registry.register(Registries.ENTITY_TYPE, entityKey, HOOKSHOT_ENTITY);
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}
