package com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree;

import com.teamcitrus.fruitsforagingandfarming.common.block.HangingFruit;
import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class BananaTree extends Tree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new FruitTreeFeature(NoFeatureConfig::deserialize, true, (HangingFruit) BlockRegistration.BANANA_FRUIT);
    }
}
