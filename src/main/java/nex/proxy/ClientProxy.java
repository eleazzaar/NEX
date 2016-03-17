package nex.proxy;

import nex.client.model.ModelManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientProxy implements IProxy
{
    @Override
    public void preInit()
    {
        ModelManager.INSTANCE.preInit();
    }

    @Override
    public void init()
    {

    }

    @Override
    public void postInit()
    {

    }
}
