package nex.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

public class ItemMaterial extends Item
{
    private final String[] variants;

    public ItemMaterial(String[] variants)
    {
        this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.variants = variants;
    }

    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list)
    {
        for(int a = 0; a < this.variants.length; a++)
        {
            list.add(new ItemStack(this, 1, a));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return  "item." + this.variants[(stack.getItemDamage())] + "_" + super.getUnlocalizedName().substring(5) ;
    }
}
