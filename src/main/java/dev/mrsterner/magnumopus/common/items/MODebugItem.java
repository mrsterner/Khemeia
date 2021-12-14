package dev.mrsterner.magnumopus.common.items;

import dev.mrsterner.magnumopus.common.body.BodyParts;
import dev.mrsterner.magnumopus.common.registry.MOComponents;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class MODebugItem extends Item {
    public DebugMode mode = DebugMode.HEAD;
    public MODebugItem(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

        if(user.isSneaking() && !world.isClient){
            mode = mode.next();
            System.out.println(mode);
        }else if(!user.isSneaking()){
            switch (mode){
                case HEAD -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.HEAD, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.HEAD));
                case TORSO -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.TORSO, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.TORSO));
                case LEFTARM -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.LEFTARM, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.LEFTARM));
                case RIGHTARM -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.RIGHTARM, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.RIGHTARM));
                case LEFTLEG -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.LEFTLEG, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.LEFTLEG));
                case RIGHTLEG -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.RIGHTLEG, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.RIGHTLEG));
                case EYES -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.EYES, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.EYES));
                case STOMACH -> MOComponents.BODY_COMPONENT.get(user).setBodyPart(BodyParts.STOMACH, !MOComponents.BODY_COMPONENT.get(user).getBodyPart().get(BodyParts.STOMACH));
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
