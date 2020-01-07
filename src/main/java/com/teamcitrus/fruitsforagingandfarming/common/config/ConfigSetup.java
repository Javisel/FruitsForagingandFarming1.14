package com.teamcitrus.fruitsforagingandfarming.common.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import com.teamcitrus.fruitsforagingandfarming.client.config.ClientConfig;
import net.minecraftforge.common.ForgeConfigSpec;

import java.nio.file.Path;

public class ConfigSetup {

    private static final ForgeConfigSpec.Builder SERVER_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SERVER;

    private static final ForgeConfigSpec.Builder CLIENT_BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec CLIENT;

    static
    {
        Config.init(SERVER_BUILDER);
        SERVER = SERVER_BUILDER.build();
        ClientConfig.init(CLIENT_BUILDER);
        CLIENT = CLIENT_BUILDER.build();


    }


    public static void loadConfig(ForgeConfigSpec spec, Path path) {

        CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        configData.load();
        spec.setConfig(configData);
    }



}
