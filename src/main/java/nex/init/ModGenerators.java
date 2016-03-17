package nex.init;

import nex.world.gen.WorldGenNether;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModGenerators
{
    public static void preInit()
    {
        registerGenerator(new WorldGenNether(), 0);
    }

    public static void registerGenerator(IWorldGenerator clazz, int weight)
    {
        GameRegistry.registerWorldGenerator(clazz, weight);
    }
}
