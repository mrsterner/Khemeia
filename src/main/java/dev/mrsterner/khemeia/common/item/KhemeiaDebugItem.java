package dev.mrsterner.khemeia.common.item;

import dev.mrsterner.khemeia.common.body.BodyParts;
import dev.mrsterner.khemeia.common.registry.KhemeiaComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class KhemeiaDebugItem extends Item {
    public DebugMode mode = DebugMode.HEAD;
    public KhemeiaDebugItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(user.isSneaking() && !world.isClient){
            mode = mode.next();
            System.out.println(mode);
        }else if(!user.isSneaking()){
            switch (mode){
                case HEAD -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.HEAD, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.HEAD));
                case TORSO -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.TORSO, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.TORSO));
                case LEFTARM -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.LEFTARM, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.LEFTARM));
                case RIGHTARM -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.RIGHTARM, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.RIGHTARM));
                case LEFTLEG -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.LEFTLEG, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.LEFTLEG));
                case RIGHTLEG -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.RIGHTLEG, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.RIGHTLEG));
                case EYES -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.EYES, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.EYES));
                case STOMACH -> KhemeiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.STOMACH, !KhemeiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.STOMACH));
            }
            user.calculateDimensions();
        }
        return super.use(world, user, hand);
    }

    public enum DebugMode {
        HEAD,
        TORSO,
        LEFTARM,
        RIGHTARM,
        LEFTLEG,
        RIGHTLEG,
        EYES,
        STOMACH;
        private static DebugMode[] vals = values();
        public DebugMode next(){
            return vals[(this.ordinal()+1)% vals.length];
        }
    }
}
