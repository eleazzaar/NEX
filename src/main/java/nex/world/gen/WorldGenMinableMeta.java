package nex.world.gen;

import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenMinableMeta extends WorldGenerator
{
    private final IBlockState oreBlock;
    private final int blockMaxMeta;
    private final int numberOfBlocks;
    private final Predicate<IBlockState> target;

    public WorldGenMinableMeta(IBlockState blockState, int maxMeta, int size, Block target)
    {
        this(blockState, maxMeta, size, BlockMatcher.forBlock(target));
    }

    private WorldGenMinableMeta(IBlockState blockState, int maxMeta, int size, Predicate<IBlockState> target)
    {
        this.oreBlock = blockState;
        this.blockMaxMeta = maxMeta;
        this.numberOfBlocks = size;
        this.target = target;
    }

    public boolean generate(World worldIn, Random random, BlockPos pos)
    {
        int blockMeta = random.nextInt(this.blockMaxMeta);

        float f = random.nextFloat() * (float) Math.PI;
        double d0 = (double) ((float) (pos.getX() + 8) + MathHelper.sin(f) * (float) this.numberOfBlocks / 8.0F);
        double d1 = (double) ((float) (pos.getX() + 8) - MathHelper.sin(f) * (float) this.numberOfBlocks / 8.0F);
        double d2 = (double) ((float) (pos.getZ() + 8) + MathHelper.cos(f) * (float) this.numberOfBlocks / 8.0F);
        double d3 = (double) ((float) (pos.getZ() + 8) - MathHelper.cos(f) * (float) this.numberOfBlocks / 8.0F);
        double d4 = (double) (pos.getY() + random.nextInt(3) - 2);
        double d5 = (double) (pos.getY() + random.nextInt(3) - 2);

        for (int i = 0; i < this.numberOfBlocks; ++i)
        {
            float f1 = (float) i / (float) this.numberOfBlocks;
            double d6 = d0 + (d1 - d0) * (double) f1;
            double d7 = d4 + (d5 - d4) * (double) f1;
            double d8 = d2 + (d3 - d2) * (double) f1;
            double d9 = random.nextDouble() * (double) this.numberOfBlocks / 16.0D;
            double d10 = (double) (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
            double d11 = (double) (MathHelper.sin((float) Math.PI * f1) + 1.0F) * d9 + 1.0D;
            int j = MathHelper.floor_double(d6 - d10 / 2.0D);
            int k = MathHelper.floor_double(d7 - d11 / 2.0D);
            int l = MathHelper.floor_double(d8 - d10 / 2.0D);
            int i1 = MathHelper.floor_double(d6 + d10 / 2.0D);
            int j1 = MathHelper.floor_double(d7 + d11 / 2.0D);
            int k1 = MathHelper.floor_double(d8 + d10 / 2.0D);

            for (int l1 = j; l1 <= i1; ++l1)
            {
                double d12 = ((double) l1 + 0.5D - d6) / (d10 / 2.0D);

                if (d12 * d12 < 1.0D)
                {
                    for (int i2 = k; i2 <= j1; ++i2)
                    {
                        double d13 = ((double) i2 + 0.5D - d7) / (d11 / 2.0D);

                        if (d12 * d12 + d13 * d13 < 1.0D)
                        {
                            for (int j2 = l; j2 <= k1; ++j2)
                            {
                                double d14 = ((double) j2 + 0.5D - d8) / (d10 / 2.0D);

                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0D)
                                {
                                    BlockPos blockpos1 = new BlockPos(l1, i2, j2);

                                    if (worldIn.getBlockState(blockpos1).getBlock().isReplaceableOreGen(worldIn.getBlockState(blockpos1), worldIn, blockpos1, this.target))
                                    {
                                        worldIn.setBlockState(blockpos1, this.oreBlock.getBlock().getStateFromMeta(blockMeta), 2);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }

}
