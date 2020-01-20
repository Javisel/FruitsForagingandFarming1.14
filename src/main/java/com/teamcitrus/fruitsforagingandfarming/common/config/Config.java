package com.teamcitrus.fruitsforagingandfarming.common.config;

import net.minecraft.item.Food;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.ArrayList;
import java.util.List;

public class Config 
{

    private  static List<FoodData> foodDataList = new ArrayList<>();
    
    
    public static FoodData AVOCADO = new FoodData("avocado",3,.6);
    public static FoodData BANANA = new FoodData("banana",2,.21);
    public static FoodData BLUEBERRY = new FoodData("blueberry",1,0.125);
    public static FoodData COCONUT_CHUNK = new FoodData("coconut_chunk",3,0.3);
    public static FoodData CORN = new FoodData("corn",3,.25f);
    public static FoodData CHOCOLATE_MILK_BOTTLE = new FoodData("chocolate_milk_bottle",1,0.2);
    public static FoodData CHOCOLATE_MILK_BUCKET = new FoodData("chocolate_milk_bucket",1,.2);
    public static FoodData CHOCOLATE_CAKE_SLICE = new FoodData("chocolate_cake_slice",2,0.3);
    public static FoodData DURIAN = new FoodData("durian",4,0.25);
    public static FoodData HONEYMELON_SLICE = new FoodData("honeymleon_slice",4,.25f);
    public static FoodData INFESTED_EGGS = new FoodData("infested_eggs",1,0);
    public static FoodData KIWI = new FoodData("kiwi",3,.5);
    public static FoodData KIWANO = new FoodData("kiwano",3,0.5);
    public static FoodData LEMON = new FoodData("lemon",2,.3);
    public static FoodData LIME = new FoodData("lime",2,0.35);
    public static FoodData MANGO = new FoodData("mango",3,0.4);
    public static FoodData ORANGE = new FoodData("orange",1,0.5);
    public static FoodData PEAR = new FoodData("pear",3,0.5);
    public static FoodData PINEAPPLE = new FoodData("pineapple",3,.5);
    public static FoodData PLUM = new FoodData("plum",1,0.5);
    public static FoodData TURNIP= new FoodData("turnip",1,.5);
    public static void init(ForgeConfigSpec.Builder server) {

        server.push("Food Configurations");
        for (FoodData data : foodDataList) 
        {

            server.push(data.name + " data");
            data.shanksRestored = server.comment(data.name + " shanks restored").defineInRange(data.name + "shanks", data.defaultshanksRestored, -20, 100);
            data.saturation = server.comment(data.name + " saturation provided").defineInRange(data.name + "saturation", data.defaultSaturation, -100, 100);
            server.pop();

        }
        server.pop();
    }

    public static class FoodData 
    {

        public ForgeConfigSpec.IntValue shanksRestored;
        public ForgeConfigSpec.DoubleValue saturation;
        public  final int defaultshanksRestored;
        public  final double defaultSaturation;
        public String name;

        public FoodData(String name, int defaultShanks, double defaultSaturation) {
            this.name=name;
            defaultshanksRestored=defaultShanks;
            this.defaultSaturation=defaultSaturation;
            foodDataList.add(this);
            
        }

        public float getSaturation() 
        {

            return  saturation.get().floatValue();
            
        }

        public int getShanks() 
        {

            return shanksRestored.get();
            
        }

        public Food getDefaultFood() 
        {

            return new Food.Builder().hunger(getShanks()).saturation(getSaturation()).build();
            
        }
    }
}
