package uk.co.conclipsegames.projDart;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import uk.co.conclipsegames.projDart.Proxy.CommonProxy;

@Mod(name = Constants.MODNAME, version = Constants.VERSION, modid = Constants.MODID)
public class ProjectDart {

    @SidedProxy(clientSide=Constants.BaseClassPath+".Proxy.ClientProxy", serverSide=Constants.BaseClassPath+".Proxy.ServerProxy")
    public static CommonProxy proxy;

    public void preInit(FMLPreInitializationEvent e) {
        System.out.println("NOTICE ME SENPAI");
    }

    public static final CreativeTabs pdtab = new CreativeTabs("pdtab") {
        @Override public Item getTabIconItem() {
            return Items.golden_apple;
        }
    };

}
