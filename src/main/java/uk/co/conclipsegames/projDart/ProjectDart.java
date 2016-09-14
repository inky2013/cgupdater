package uk.co.conclipsegames.projDart;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import uk.co.conclipsegames.projDart.Proxy.CommonProxy;

@Mod(name = Constants.MODNAME, version = Constants.VERSION, modid = Constants.MODID)
public class ProjectDart {

    public ProjectDart() {
        String[] supportedMods = {
                "ThermalFoundation"
        };

        for(String item : supportedMods) {
            //Do the loady thing later
        }
    }

    @Mod.Instance
    public static ProjectDart instance = new ProjectDart();

    @SidedProxy(clientSide=Constants.ClientProxy, serverSide=Constants.ServerProxy)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        Configuration Config = new Configuration(e.getSuggestedConfigurationFile());

        proxy.preInit(e);
    }
    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }
    @Mod.EventHandler
    public void preInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }

    public static final CreativeTabs pdtab = new CreativeTabs("pdtab") {
        @Override public Item getTabIconItem() {
            return Items.golden_apple;
        }
    };

}
