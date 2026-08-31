package com.saikonoanis.hookshot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

public class HookshotItem extends Item {

    public HookshotItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        Vec3d vecteur = user.getRotationVector();
        user.setVelocity(vecteur.multiply(3));
        return ActionResult.PASS;
    }

}