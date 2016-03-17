package nex.item;

import nex.NEX;
import net.minecraft.item.Item;

public class ItemMeliora extends Item
{
    public ItemMeliora(String name)
    {
        this.setName(this, name);
        this.setCreativeTab(NEX.getCreativeTab());
    }

    public static void setName(Item item, String itemName)
    {
        item.setRegistryName(itemName);
        item.setUnlocalizedName(item.getRegistryName());
    }
}
