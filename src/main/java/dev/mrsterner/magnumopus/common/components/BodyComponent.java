package dev.mrsterner.magnumopus.common.components;

import dev.mrsterner.magnumopus.common.body.BodyParts;
import dev.mrsterner.magnumopus.common.registry.MOComponents;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.entity.PlayerComponent;
import net.fabricmc.fabric.api.util.NbtType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BodyComponent implements IBody, AutoSyncedComponent, PlayerComponent<BodyComponent> {
    public Map<BodyParts, Boolean> PARTS = new LinkedHashMap<>();
    private final PlayerEntity player;

    public BodyComponent(PlayerEntity player) {
        PARTS.put(BodyParts.HEAD, true);
        PARTS.put(BodyParts.TORSO, true);
        PARTS.put(BodyParts.LEFTARM, true);
        PARTS.put(BodyParts.RIGHTARM, true);
        PARTS.put(BodyParts.LEFTLEG, true);
        PARTS.put(BodyParts.RIGHTLEG, true);
        this.player = player;
    }

    @Override
    public void setBodyPart(BodyParts bodyPart, boolean b) {
        if(!hasBodyPart(bodyPart)){
            PARTS.replace(bodyPart, true);
            MOComponents.BODY_COMPONENT.sync(player);
        }
    }

    @Override
    public Map<BodyParts, Boolean> getBodyPart() {
        return PARTS;
    }

    @Override
    public boolean hasBodyPart(BodyParts bodyParts) {
        return PARTS.get(bodyParts);
    }

    @Override
    public void serverTick() {

    }

    @Override
    public void copyForRespawn(BodyComponent original, boolean lossless, boolean keepInventory, boolean sameCharacter) {
        if(lossless){
            copyFrom(original);
        }else{
            PARTS = original.PARTS;
        }
    }

    @Override
    public void readFromNbt(NbtCompound tag) {
        int index = 0;
        NbtList bodyPartList = tag.getList("BodyParts", NbtType.COMPOUND);
        for(Map.Entry<BodyParts, Boolean> entry : PARTS.entrySet()){
            NbtCompound bodyCompund = bodyPartList.getCompound(index);
            setBodyPart(entry.getKey().fromString(bodyCompund.getString("BodyPart")), entry.getValue());
            index++;
        }
    }

    @Override
    public void writeToNbt(NbtCompound tag) {
        tag.put("BodyParts", toNbtBody());
    }


    public NbtList toNbtBody() {
        NbtList bodyList = new NbtList();
        PARTS.forEach((bodyParts, aBoolean) -> {
            NbtCompound bodyCompound = new NbtCompound();
            bodyCompound.putString("BodyPart", bodyParts.toString());
            bodyCompound.putBoolean("Has", aBoolean);
            bodyList.add(bodyCompound);

        });
        return bodyList;
    }


}
