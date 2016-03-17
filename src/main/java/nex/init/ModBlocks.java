package nex.init;

import nex.block.BlockNetherrack;
import nex.block.BlockStone;
import nex.item.ItemBlockMeta;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
    public static Block stone;
    public static Block netherrack;

    public static void preInit()
    {
        stone = registerBlock(new BlockStone(), ItemBlockMeta.class, BlockStone.EnumType.getNames(), true);
        netherrack = registerBlock(new BlockNetherrack(), ItemBlockMeta.class, BlockNetherrack.EnumType.getNames(), true);
    }

    public static Block registerBlock(Block block, String name)
    {
        GameRegistry.registerBlock(block, name);
        return block;
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> clazz, String name)
    {
        GameRegistry.registerBlock(block, clazz, name);
        return block;
    }

    public static Block registerBlock(Block block, Class<? extends ItemBlock> clazz, Object... args)
    {
        GameRegistry.registerBlock(block, clazz, args);
        return block;
    }

    public static void registerTileEntity(Class<? extends TileEntity> tile, String name)
    {
        GameRegistry.registerTileEntity(tile, name);
    }

    public static Fluid registerFluid(Fluid fluid)
    {
        FluidRegistry.registerFluid(fluid);
        return fluid;
    }

    public static Block registerFluidBlock(Fluid fluid, BlockFluidBase block, String name)
    {
        block.setUnlocalizedName(name);
        GameRegistry.registerBlock(block, name);
        fluid.setBlock(block);
        return block;
    }
}
