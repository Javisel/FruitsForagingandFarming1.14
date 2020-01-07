package com.teamcitrus.fruitsforagingandfarming.client.config;

import com.teamcitrus.fruitsforagingandfarming.common.config.Config;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {


    public static ForgeConfigSpec.BooleanValue foodTooltip;



    public static void init(ForgeConfigSpec.Builder server) {

        foodTooltip = server.comment("Tooltip enabled").define("tooltip",true);



    }
}
