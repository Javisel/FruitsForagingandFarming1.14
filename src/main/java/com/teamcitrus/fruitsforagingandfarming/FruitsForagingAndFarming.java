package com.teamcitrus.fruitsforagingandfarming;

import com.teamcitrus.fruitsforagingandfarming.client.RenderRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.FruitsForagingAndFarmingItemGroup;
import com.teamcitrus.fruitsforagingandfarming.common.config.ConfigSetup;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.DamageSource;
import net.minecraft.world.FoliageColors;
import net.minecraft.world.biome.BiomeColors;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

import static com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration.PALM_LEAVES;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("fruits_foraging_and_farming")
public class FruitsForagingAndFarming {
    public static final String MODID = "fruits_foraging_and_farming";
    public static final ItemGroup itemGroup = new FruitsForagingAndFarmingItemGroup();
    public static final DamageSource silverfishAlien = new SilverfishAlien();
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public FruitsForagingAndFarming() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, ConfigSetup.SERVER, "fruits_foraging_and_farming_server.toml");
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigSetup.CLIENT, "fruits_foraging_and_farming_client.toml");
        ConfigSetup.loadConfig(ConfigSetup.SERVER, FMLPaths.CONFIGDIR.get().resolve("fruits_foraging_and_farming_server.toml"));
        ConfigSetup.loadConfig(ConfigSetup.CLIENT, FMLPaths.CONFIGDIR.get().resolve("fruits_foraging_and_farming_client.toml"));

        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        // Register the doClientStuff method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new EventHandler());

    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

        RenderRegistration.registryEntityRenders();
        BlockColors blockColors = Minecraft.getInstance().getBlockColors();
        ItemColors itemColors = Minecraft.getInstance().getItemColors();
        blockColors.register((state, world, pos, tintIndex) ->
                        world != null && pos != null ? BiomeColors.getFoliageColor(world, pos) : FoliageColors.getDefault(),
                PALM_LEAVES);

        itemColors.register((stack, tintIndex) -> {
                    BlockState BlockState = ((BlockItem) stack.getItem()).getBlock().getDefaultState();
                    return blockColors.getColor(BlockState, null, null, tintIndex);
                },
                PALM_LEAVES);
    }
    // do something that can only be done on the client


    private void enqueueIMC(final InterModEnqueueEvent event) {
        // some example code to dispatch IMC to another mod
    }

    private void processIMC(final InterModProcessEvent event) {
        // some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m -> m.getMessageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        // do something when the server starts
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent) {
            // register a new block here
        }
    }
}
