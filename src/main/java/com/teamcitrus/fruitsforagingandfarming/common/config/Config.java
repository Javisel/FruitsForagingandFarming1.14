package com.teamcitrus.fruitsforagingandfarming.common.config;

import net.minecraft.item.Food;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class Config {

    public static FoodData AVOCADO_DATA = new FoodData("avocado",3,.6);
    public static FoodData COCONUT_CHUNK_DATA = new FoodData("coconut_chunk",3,0.3);
    public static FoodData CORN = new FoodData("corn",3,.25f);

    public static FoodData HONEYMELON_SLICE = new FoodData("honeymleon_slice",4,.25f);


    private  static List<FoodData> foodDataList = new ArrayList<>();




    static {

        foodDataList.add(AVOCADO_DATA);
        foodDataList.add(COCONUT_CHUNK_DATA);
        foodDataList.add(CORN);


    }


    public static void init(ForgeConfigSpec.Builder server) {

        server.push("Food Configurations");
        for (FoodData data : foodDataList) {

            server.push(data.name + " data");
            data.shanksRestored = server.comment(data.name + " shanks restored").defineInRange(data.name + "shanks", data.defaultshanksRestored, 0, 100);
            data.saturation = server.comment(data.name + " saturation provided").defineInRange(data.name + "saturation", data.defaultSaturation, 0, 100);
            server.pop();


        }
        server.pop();


    }





    public static class FoodData {

        public ForgeConfigSpec.IntValue shanksRestored;
        public ForgeConfigSpec.DoubleValue saturation;
        public  final int defaultshanksRestored;
        public  final double defaultSaturation;
        public String name;

        public FoodData(String name, int defaultShanks, double defaultSaturation) {
            this.name=name;
            defaultshanksRestored=defaultShanks;
            this.defaultSaturation=defaultSaturation;
        }

        public float getSaturation() {


            return  saturation.get().floatValue();
        }

        public int getShanks() {


            return shanksRestored.get();
        }

        public Food getDefaultFood() {


            return new Food.Builder().hunger(getShanks()).saturation(getSaturation()).build();
        }



    }







}
