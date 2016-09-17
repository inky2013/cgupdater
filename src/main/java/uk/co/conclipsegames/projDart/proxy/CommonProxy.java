package uk.co.conclipsegames.projDart.Proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import uk.co.conclipsegames.projDart.Crafting.PDCrafting;
import uk.co.conclipsegames.projDart.Block.PDBlocks;
import uk.co.conclipsegames.projDart.Item.PDItems;

public class CommonProxy {

    public void preInit(FMLPreInitializationEvent e) {
        System.out.println("PREINIT");
        PDItems.init();
        PDBlocks.init();
    }
    public void init(FMLInitializationEvent e) {
        PDCrafting.init();

    }
    public void postInit(FMLPostInitializationEvent e) {

    }
}
