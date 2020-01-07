package com.teamcitrus.fruitsforagingandfarming.client.config;

import com.teamcitrus.fruitsforagingandfarming.common.config.Config;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {


    public static ForgeConfigSpec.BooleanValue foodTooltip;



    public static void init(ForgeConfigSpec.Builder server) {

        foodTooltip = server.comment("Should hovering over food display it's stats?").define("tooltip",true);



    }
}
