package nex.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockMeta extends ItemMultiTexture
{
    public ItemBlockMeta(Block block, String[] names, Boolean dummy)
    {
        super(block, block, names);
    }
}
