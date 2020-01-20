package com.teamcitrus.fruitsforagingandfarming.common.effect;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;

public class EffectBase extends Effect {
    protected EffectBase(String name, EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
        setRegistryName(name);

    }
}
