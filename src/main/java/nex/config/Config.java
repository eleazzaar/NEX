package nex.config;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class Config
{
    private static Configuration config;

    public static void preInit(FMLPreInitializationEvent event)
    {
        File configFolder = event.getModConfigurationDirectory();
        File configFile = new File(configFolder.getAbsolutePath() + "/NEX/Settings.cfg");
        config = new Configuration(configFile);
        update();
    }

    public static void update()
    {
        String currentCategory;

        currentCategory = "Items";
        config.addCustomCategoryComment(currentCategory, "Item options");

        currentCategory = "Blocks";
        config.addCustomCategoryComment(currentCategory, "Block options");

        currentCategory = "Miscellaneous";
        config.addCustomCategoryComment(currentCategory, "Miscellaneous options");

        if(config.hasChanged())
        {
            config.save();
        }
    }

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event)
    {
        if(Constants.MOD_ID.equals(event.modID))
        {
            update();
        }
    }
}
