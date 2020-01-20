package com.teamcitrus.fruitsforagingandfarming.common.entity;


import com.teamcitrus.fruitsforagingandfarming.common.registration.BlockRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.EntityTypeRegistration;
import com.teamcitrus.fruitsforagingandfarming.common.registration.ItemRegistration;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.FMLPlayMessages;
import net.minecraftforge.fml.network.NetworkHooks;

public class FFFBoat extends BoatEntity {

    private static final DataParameter<Integer> FFF_BOAT_TYPE = EntityDataManager.createKey(FFFBoat.class, DataSerializers.VARINT);


    public FFFBoat(World worldIn, double x, double y, double z) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.FFF_BOAT, worldIn);
        setPositionAndUpdate(x, y, z);
    }


    public FFFBoat(EntityType<BoatEntity> boatEntityEntityType, World world) {
        super(boatEntityEntityType, world);

    }

    public FFFBoat(FMLPlayMessages.SpawnEntity spawnEntity, World world) {
        super((EntityType<? extends BoatEntity>) EntityTypeRegistration.FFF_BOAT, world);


    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FFF_BOAT_TYPE, BoatEntity.Type.OAK.ordinal());

    }


    @Override
    public IPacket<?> createSpawnPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    public FFFBoat.FFFType getFFFBoatType() {
        return FFFBoat.FFFType.byId(this.dataManager.get(FFF_BOAT_TYPE));
    }

    public Item getItemBoat() {
        switch (this.getFFFBoatType()) {
            case PALM:
            default:
                return ItemRegistration.PALM_BOAT;

        }
    }

    public enum FFFType {
        PALM(BlockRegistration.PALM_PLANKS, "palm");

        private final String name;
        private final Block block;

        FFFType(Block p_i48146_3_, String p_i48146_4_) {
            this.name = p_i48146_4_;
            this.block = p_i48146_3_;
        }

        /**
         * Get a boat type by it's enum ordinal
         */
        public static FFFBoat.FFFType byId(int id) {
            FFFBoat.FFFType[] aboatentity$type = values();
            if (id < 0 || id >= aboatentity$type.length) {
                id = 0;
            }

            return aboatentity$type[id];
        }

        public static FFFBoat.FFFType getTypeFromString(String nameIn) {
            FFFBoat.FFFType[] aboatentity$type = values();

            for (int i = 0; i < aboatentity$type.length; ++i) {
                if (aboatentity$type[i].getName().equals(nameIn)) {
                    return aboatentity$type[i];
                }
            }

            return aboatentity$type[0];
        }

        public String getName() {
            return this.name;
        }

        public Block asPlank() {
            return this.block;
        }

        public String toString() {
            return this.name;
        }
    }

}