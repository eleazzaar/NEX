package nex.client.model;

import nex.block.BlockNetherrack;
import nex.block.BlockStone;
import nex.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.resources.model.ModelBakery;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.Set;

@SideOnly(Side.CLIENT)
public class ModelManager
{
    public static final ModelManager INSTANCE = new ModelManager();

    private ModelManager() {}

    public void preInit()
    {
        registerBlockModels();
        registerItemModels();
    }

    private void registerBlockModels()
    {
        for(BlockStone.EnumType type : BlockStone.EnumType.values())
        {
            registerBlockItemModelForMeta(ModBlocks.stone, type.getMeta(), "variant=" + type.getName());
        }

        for(BlockNetherrack.EnumType type : BlockNetherrack.EnumType.values())
        {
            registerBlockItemModelForMeta(ModBlocks.netherrack, type.getMeta(), "variant=" + type.getName());
        }

    }

    private void registerBlockItemModel(Block block)
    {
        Item item = Item.getItemFromBlock(block);

        if (item != null)
        {
            registerItemModel(item);
        }
    }

    private void registerBlockItemModel(Block block, String modelLocation)
    {
        registerItemModel(Item.getItemFromBlock(block), modelLocation);
    }

    private void registerBlockItemModel(Block block, ModelResourceLocation fullModelLocation)
    {
        registerItemModel(Item.getItemFromBlock(block), fullModelLocation);
    }

    private void registerBlockItemModelForMeta(Block block, int metadata, String variant)
    {
        registerItemModelForMeta(Item.getItemFromBlock(block), metadata, variant);
    }

    private final Set<Item> items = new HashSet<>();

    private void registerItemModels()
    {

    }

    private void registerItemModel(Item item)
    {
        registerItemModel(item, item.getRegistryName());
    }

    private void registerItemModel(Item item, String modelLocation)
    {
        final ModelResourceLocation fullModelLocation = new ModelResourceLocation(modelLocation, "inventory");
        registerItemModel(item, fullModelLocation);
    }

    private void registerItemModel(Item item, ModelResourceLocation fullModelLocation)
    {
        ModelBakery.registerItemVariants(item, fullModelLocation);
        registerItemModel(item, MeshDefinitionFix.create(stack -> fullModelLocation));
    }

    private void registerItemModel(Item item, ItemMeshDefinition meshDefinition)
    {
        items.add(item);
        ModelLoader.setCustomMeshDefinition(item, meshDefinition);
    }

    private void registerItemModelForMeta(Item item, int metadata, String variant)
    {
        registerItemModelForMeta(item, metadata, new ModelResourceLocation(item.getRegistryName(), variant));
    }

    private void registerItemModelForMeta(Item item, int metadata, ModelResourceLocation modelResourceLocation)
    {
        items.add(item);
        ModelLoader.setCustomModelResourceLocation(item, metadata, modelResourceLocation);
    }
}
