package com.saikonoanis.hookshot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.HitResult;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;

public class HookshotItem extends Item {
    double distanceMax = 100;
    float tickDelta = 1.0F;
    boolean includeFluids = false;
    Vec3d pointCible;

    public HookshotItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {

        if (world.isClient()) {
            return ActionResult.PASS;
        }

        if (pointCible == null) {
            HitResult resultat;
            resultat = user.raycast(distanceMax, tickDelta, includeFluids);
            if (resultat.getType() == HitResult.Type.BLOCK) {
                pointCible = resultat.getPos();
                user.sendMessage(Text.of("Grappin lancé"), false);
            }

        } else {
            Vec3d posJoueur = user.getEntityPos();
            Vec3d direction = pointCible.subtract(posJoueur);
            direction = direction.normalize();
            user.setVelocity(direction.multiply(5));
            user.velocityDirty = true;
            if (user instanceof ServerPlayerEntity serverPlayer) {
                serverPlayer.networkHandler.sendPacket(new EntityVelocityUpdateS2CPacket(user));
            }
            user.sendMessage(Text.of("Grappin tiré"), false);
            pointCible = null;
        }

        return ActionResult.PASS;
    }

}