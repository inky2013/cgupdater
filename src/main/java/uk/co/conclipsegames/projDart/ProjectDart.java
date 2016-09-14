package uk.co.conclipsegames.projDart;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import uk.co.conclipsegames.projDart.Item.PDItems;
import uk.co.conclipsegames.projDart.Proxy.CommonProxy;

import java.util.HashMap;
import java.util.Map;

@Mod(name = Constants.MODNAME, version = Constants.VERSION, modid = Constants.MODID)
public class ProjectDart {

    Map<String, Boolean> loadedMods = new HashMap<String, Boolean>();

    public ProjectDart() {
        String[] supportedMods = {
                "ThermalFoundation"
        };

        for(String item : supportedMods) {
            if (Loader.isModLoaded(item)) {
                loadedMods.put(item, true);
            } else {
                loadedMods.put(item, false);
            }
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
            return PDItems.forceGem;
        }
    };

}
