package nex.init;

import nex.NEX;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities
{
    public static void preInit()
    {
    }

    private static Entity registerMonster(Class entityClass, String entityName, int id, BiomeGenBase genBase, int solidColor, int spotColor)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true, solidColor, spotColor);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.MONSTER, genBase);
        }
        return null;
    }

    private static Entity registerMonster(Class entityClass, String entityName, int id, BiomeGenBase genBase)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.MONSTER, genBase);
        }
        return null;
    }

    private static Entity registerCreature(Class entityClass, String entityName, int id, BiomeGenBase genBase, int solidColor, int spotColor)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true, solidColor, spotColor);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.CREATURE, genBase);
        }
        return null;
    }

    private static Entity registerCreature(Class entityClass, String entityName, int id, BiomeGenBase genBase)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.CREATURE, genBase);
        }
        return null;
    }

    private static Entity registerWaterCreature(Class entityClass, String entityName, int id, BiomeGenBase genBase, int solidColor, int spotColor)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true, solidColor, spotColor);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.WATER_CREATURE, genBase);
        }
        return null;
    }

    private static Entity registerWaterCreature(Class entityClass, String entityName, int id, BiomeGenBase genBase)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.WATER_CREATURE, genBase);
        }
        return null;
    }

    private static Entity registerAmbient(Class entityClass, String entityName, int id, BiomeGenBase genBase)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.AMBIENT, genBase);
        }
        return null;
    }

    private static Entity registerAmbient(Class entityClass, String entityName, int id, BiomeGenBase genBase, int solidColor, int spotColor)
    {
        EntityRegistry.registerModEntity(entityClass, entityName, id, NEX.getInstance(), 64, 1, true, solidColor, spotColor);

        if(genBase != null)
        {
            EntityRegistry.addSpawn(entityClass, 0, 0, 0, EnumCreatureType.AMBIENT, genBase);
        }
        return null;
    }
}
