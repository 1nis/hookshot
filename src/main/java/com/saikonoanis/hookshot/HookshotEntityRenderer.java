package com.saikonoanis.hookshot;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;

public class HookshotEntityRenderer extends EntityRenderer<HookshotEntity, EntityRenderState> {

    protected HookshotEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public EntityRenderState createRenderState() {
        return new EntityRenderState();
    }
}
