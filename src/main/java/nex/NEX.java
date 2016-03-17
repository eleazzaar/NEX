package nex;

import nex.config.Config;
import nex.config.Constants;
import nex.init.ModBiomes;
import nex.init.ModBlocks;
import nex.init.ModEntities;
import nex.init.ModGenerators;
import nex.proxy.IProxy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Constants.MOD_ID, name = Constants.NAME, version = Constants.VERSION, acceptedMinecraftVersions = "[1.8.9]", dependencies = "required-after:Forge@[11.15.1.1722,);")
public class NEX
{
    @Mod.Instance(Constants.MOD_ID)
    private static NEX instance;

    @SidedProxy(clientSide = "nex.proxy.ClientProxy", serverSide = "nex.proxy.CommonProxy")
    private static IProxy proxy;

    private static CreativeTabs creativeTab = new CreativeTabs("nex")
    {
        @Override
        public Item getTabIconItem()
        {
            return Items.nether_star;
        }
    };

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        ModBlocks.preInit();
        ModBiomes.preInit();
        ModEntities.preInit();
        Config.preInit(event);
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        ModGenerators.preInit();
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
        proxy.postInit();
    }

    public static CreativeTabs getCreativeTab()
    {
        return creativeTab;
    }

    public static NEX getInstance()
    {
        return instance;
    }

    public static IProxy getProxy()
    {
        return proxy;
    }
}
