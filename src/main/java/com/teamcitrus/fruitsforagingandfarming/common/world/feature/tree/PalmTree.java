package com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree;

import net.minecraft.block.trees.Tree;
import net.minecraft.world.gen.feature.AbstractTreeFeature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import javax.annotation.Nullable;
import java.util.Random;

public class PalmTree extends Tree {
    @Nullable
    protected AbstractTreeFeature<NoFeatureConfig> getTreeFeature(Random random) {
        return new PalmTreeFeature(NoFeatureConfig::deserialize, true);
    }
}
