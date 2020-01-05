package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.mojang.datafixers.DataFixUtils;
import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import com.teamcitrus.fruitsforagingandfarming.common.item.PalmBoatItem;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.datafix.DataFixesManager;
import net.minecraft.util.datafix.TypeReferences;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(FruitsForagingAndFarming.MODID)
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TileEntityRegistration {

//    public static  TileEntityType<SignTileEntity>  PALM_SIGN = TileEntityType.Builder.create(SignTileEntity::new,BlockRegistration.PALM_PLANKS).build(    DataFixesManager.getDataFixer().getSchema(DataFixUtils.makeKey(SharedConstants.getVersion().getWorldVersion())).getChoiceType(TypeReferences.BLOCK_ENTITY, "palm_sign"));







    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<TileEntityType<?>> event) {

//                PALM_SIGN.setRegistryName("palm_sign");
            event.getRegistry().registerAll
                (
                        //PALM_SIGN

                );
    }



}
