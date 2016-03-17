package nex.block;

import nex.NEX;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockMeliora extends Block
{
    public BlockMeliora(Material material, MapColor mapColor, String name)
    {
        super(material, mapColor);
        this.setName(this, name);
        this.setCreativeTab(NEX.getCreativeTab());
    }

    public BlockMeliora(Material materialIn, String blockName)
    {
        this(materialIn, materialIn.getMaterialMapColor(), blockName);
    }

    public static void setName(Block block, String blockName)
    {
        block.setRegistryName(blockName);
        block.setUnlocalizedName(block.getRegistryName());
    }

}
