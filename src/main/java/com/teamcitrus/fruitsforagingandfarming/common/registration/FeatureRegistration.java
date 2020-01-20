package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.block.HangingFruit;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.FruitTreeFeature;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.PalmTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FeatureRegistration {

    public static Feature PALM_TREE = null;
    public static Feature BANANA_TREE = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Feature<?>> event) {
        System.out.println("FEATURE!");
        event.getRegistry().registerAll
                (
                        PALM_TREE = new PalmTreeFeature(NoFeatureConfig::deserialize, false),
                        BANANA_TREE = new FruitTreeFeature(NoFeatureConfig::deserialize, true, (HangingFruit) BlockRegistration.BANANA_FRUIT)
                );
    }


}
