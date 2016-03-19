package nex.block;

import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.util.math.BlockPos;
import nex.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.world.World;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class BlockNetherrack extends BlockMeliora
{
    private static final IProperty<EnumType> VARIANT = PropertyEnum.create("variant", EnumType.class);

    public BlockNetherrack()
    {
        super(Material.rock, "netherrack");
        this.setHardness(0.4F);
        this.setTickRandomly(true);
    }

    @Override
    public int tickRate(World world)
    {
        return 2;
    }

    public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
    {
        if (!worldIn.isRemote)
        {
            if (this.getBlockState().getBlock() == ModBlocks.netherrack && this.getMetaFromState(state) == 2)
            {
                BlockPos blockpos1 = pos.add(rand.nextInt(3) - 1, rand.nextInt(5) - 3, rand.nextInt(3) - 1);
                IBlockState iblockstate1 = worldIn.getBlockState(blockpos1);
                if (iblockstate1.getBlock() == Blocks.netherrack)
                {
                    worldIn.setBlockState(blockpos1, this.getActualState(state, worldIn, pos));
                }
            }
        }
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer(this, VARIANT);
    }

    @Override
    public IBlockState getStateFromMeta(int meta)
    {
        return getDefaultState().withProperty(VARIANT, EnumType.byMetadata(meta));
    }

    @Override
    public int getMetaFromState(IBlockState state)
    {
        return state.getValue(VARIANT).getMeta();
    }

    @Override
    public int damageDropped(IBlockState state)
    {
        return getMetaFromState(state);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
    {
        for (EnumType enumType : EnumType.values())
        {
            list.add(new ItemStack(this, 1, enumType.getMeta()));
        }
    }
    public enum EnumType implements IStringSerializable
    {
        CHILLED(0, "chilled"),
        ERODED(1, "eroded"),
        REACTIVE(2, "reactive"),
        SHADOWY(3, "shadowy");

        private static final EnumType[] META_LOOKUP = Stream.of(values()).sorted(Comparator.comparing(EnumType::getMeta)).toArray(EnumType[]::new);

        private final int meta;
        private final String name;

        EnumType(int meta, String name)
        {
            this.meta = meta;
            this.name = name;
        }

        public int getMeta()
        {
            return meta;
        }

        @Override
        public String getName()
        {
            return name;
        }

        public static EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }

        public static String[] getNames()
        {
            return Stream.of(META_LOOKUP).map(EnumType::getName).toArray(String[]::new);
        }
    }
}
