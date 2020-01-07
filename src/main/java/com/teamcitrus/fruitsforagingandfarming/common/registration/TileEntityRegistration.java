package com.teamcitrus.fruitsforagingandfarming.common.registration;

import com.teamcitrus.fruitsforagingandfarming.FruitsForagingAndFarming;
import net.minecraft.tileentity.TileEntityType;
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
