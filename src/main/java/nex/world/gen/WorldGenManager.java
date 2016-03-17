package nex.world.gen;

import com.google.common.base.Predicate;
import nex.config.Constants;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockHelper;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Random;

public class WorldGenManager implements IWorldGenerator
{

    private final float frequency;
    private final WorldGenMinable oreGen;
    private final int maxY;
    private final long hash;

    private final Block ore;

    public WorldGenManager(Block oreBlock, int maxHeight, float spawnFrequency, int spawnQuantity, long hash, Predicate<IBlockState> target)
    {
        this.oreGen = new WorldGenMinable(oreBlock.getDefaultState(), spawnQuantity, target);
        this.frequency = spawnFrequency;
        this.maxY = maxHeight;
        this.ore = oreBlock;
        this.hash = hash;
    }

    public WorldGenManager(Block oreBlock, int meta, int maxHeight, float spawnFrequency, int spawnQuantity, long hash, Predicate<IBlockState> target)
    {
        this.oreGen = new WorldGenMinable(oreBlock.getStateFromMeta(meta), spawnQuantity, target);
        this.frequency = spawnFrequency;
        this.maxY = maxHeight;
        this.ore = oreBlock;
        this.hash = hash;
    }

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        final float r = random.nextFloat();

        random.setSeed(random.nextLong() ^ this.hash);
        random.nextInt();

        for (float f = this.frequency; f > r; f -= 1)
        {
            int x = (chunkX << 4) + random.nextInt(16);
            int z = (chunkZ << 4) + random.nextInt(16);

            if (this.maxY == 16)
            {
                int y = random.nextInt(this.maxY);
                this.oreGen.generate(world, random, new BlockPos(x, y, z));
            }

            if (this.maxY == 32)
            {
                int y = random.nextInt(this.maxY - 17) + 17;
                this.oreGen.generate(world, random, new BlockPos(x, y, z));
            }

            if (this.maxY == 48)
            {
                int y = random.nextInt(this.maxY - 33) + 33;
                this.oreGen.generate(world, random, new BlockPos(x, y, z));
            }

            if (maxY == 64)
            {
                int y = random.nextInt(this.maxY - 49) + 49;
                this.oreGen.generate(world, random, new BlockPos(x, y, z));
            }

            if (maxY == 256)
            {
                int y = random.nextInt(this.maxY - 65) + 65;
                this.oreGen.generate(world, random, new BlockPos(x, y, z));
            }
        }
    }

    public static void addGen(Block oreBlock, int meta, int maxY, float spawnFrequency, int spawnQuantity, Block block)
    {
        GameRegistry.registerWorldGenerator(new WorldGenManager(oreBlock, meta, maxY, spawnFrequency, spawnQuantity, (Constants.ORE_WEIGHT * 25214903917L) + 11L, BlockHelper.forBlock(block)), Constants.ORE_WEIGHT++);
    }

    public static void addGen(Block oreBlock, int meta, float spawnFrequency, int spawnQuantity, Block block)
    {
        GameRegistry.registerWorldGenerator(new WorldGenManager(oreBlock, meta, spawnFrequency, spawnQuantity, (Constants.ORE_WEIGHT * 25214903917L) + 11L, BlockHelper.forBlock(block)), Constants.ORE_WEIGHT++);
    }
}
