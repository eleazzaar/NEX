package nex.world.gen;

import nex.init.ModBlocks;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenNether implements IWorldGenerator
{
    WorldGenMinable netherrack;

    public WorldGenNether()
    {
        this.netherrack = new WorldGenMinable(ModBlocks.netherrack.getStateFromMeta(1), 32, BlockHelper.forBlock(Blocks.netherrack));
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        if (world.provider.getDimensionId() == -1)
        {
            this.generateNetherrack(world, random, chunkX * 16, chunkZ * 16);
        }
    }

    public void generateNetherrack(World world, Random rand, int chunkX, int chunkZ)
    {
        for (int i = 0; i < 64; i++)
        {
            int hi = rand.nextInt(256);
            int randX = chunkX + rand.nextInt(16);
            int randZ = chunkZ + rand.nextInt(16);
            this.netherrack.generate(world, rand, new BlockPos(randX, hi, randZ));
        }
    }
}
