package dev.mrsterner.alchimia.common.item;

import dev.mrsterner.alchimia.common.body.BodyParts;
import dev.mrsterner.alchimia.common.registry.AlchimiaComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class AlchimiaDebugItem extends Item {
    public DebugMode mode = DebugMode.HEAD;
    public AlchimiaDebugItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(user.isSneaking() && !world.isClient){
            mode = mode.next();
            System.out.println(mode);
        }else if(!user.isSneaking()){
            switch (mode){
                case HEAD -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.HEAD, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.HEAD));
                case TORSO -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.TORSO, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.TORSO));
                case LEFTARM -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.LEFTARM, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.LEFTARM));
                case RIGHTARM -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.RIGHTARM, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.RIGHTARM));
                case LEFTLEG -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.LEFTLEG, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.LEFTLEG));
                case RIGHTLEG -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.RIGHTLEG, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.RIGHTLEG));
                case EYES -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.EYES, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.EYES));
                case STOMACH -> AlchimiaComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.STOMACH, !AlchimiaComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.STOMACH));
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
