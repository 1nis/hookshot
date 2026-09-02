package com.saikonoanis.hookshot;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HookshotClient implements ClientModInitializer {
    public static final String MOD_ID = "hookshot";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(Hookshot.HOOKSHOT_ENTITY, HookshotEntityRenderer::new);
        LOGGER.info("Hookshot Client chargé!");
    }
}
