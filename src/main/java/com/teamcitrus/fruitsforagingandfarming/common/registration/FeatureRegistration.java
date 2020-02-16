package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.block.HangingFruit;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.FruitTreeFeature;
import com.teamcitrus.fruitsforagingandfarming.common.world.feature.tree.PalmTreeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FeatureRegistration {

    public static Feature PALM_TREE = null;
    public static Feature BANANA_TREE = null;
    public static Feature LEMON_TREE = null;
    public static Feature AVOCADO_TREE = null;
    public static Feature PEAR_TREE = null;
    public static Feature LIME_TREE = null;
    @SubscribeEvent
    public static void registerFeatures(final RegistryEvent.Register<Feature<?>> event) {
        event.getRegistry().registerAll
                (
                        PALM_TREE = new PalmTreeFeature(NoFeatureConfig::deserialize, false),
                        BANANA_TREE = new FruitTreeFeature(NoFeatureConfig::deserialize, true, (HangingFruit) BlockRegistration.BANANA_FRUIT, (IPlantable) BlockRegistration.BANANA_SAPLING),
                      LEMON_TREE = new FruitTreeFeature(NoFeatureConfig::deserialize, true, (HangingFruit) BlockRegistration.LEMON_FRUIT, (IPlantable) BlockRegistration.LEMON_SAPLING),
                        AVOCADO_TREE = new FruitTreeFeature(NoFeatureConfig::deserialize, true, (HangingFruit) BlockRegistration.AVOCADO_FRUIT, (IPlantable) BlockRegistration.AVOCADO_SAPLING),
                        PEAR_TREE = new FruitTreeFeature(NoFeatureConfig::deserialize, true, (HangingFruit) BlockRegistration.PEAR_FRUIT, (IPlantable) BlockRegistration.PEAR_SAPLING),
                        LIME_TREE = new FruitTreeFeature(NoFeatureConfig::deserialize, true, (HangingFruit) BlockRegistration.LIME_FRUIT, (IPlantable) BlockRegistration.LIME_SAPLING)



                );
    }


}
