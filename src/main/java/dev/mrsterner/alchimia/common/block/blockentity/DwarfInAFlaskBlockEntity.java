package dev.mrsterner.alchimia.common.block.blockentity;

import dev.mrsterner.alchimia.common.registry.AlchimiaEntityTypes;
import dev.mrsterner.alchimia.common.registry.AlchimiaObjects;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class DwarfInAFlaskBlockEntity extends BlockEntity implements IAnimatable {
    public int hit = 0;
    private final AnimationFactory factory = new AnimationFactory(this);
    public DwarfInAFlaskBlockEntity(BlockPos pos, BlockState state) {
        super(AlchimiaEntityTypes.DWARF_IN_A_FLASK_BLOCK_ENTITY, pos, state);
    }

    private <E extends BlockEntity & IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        if(hit==0){
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dwarf.idle", true));
        }else{
            event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.dwarf.hit", true));
            hit=0;
        }

        return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}
