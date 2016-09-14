package uk.co.conclipsegames.projDart.InitialisationStuff;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import uk.co.conclipsegames.projDart.Constants;

public class Registerer {

    public static void registerItem(Item item){
        GameRegistry.registerItem(item, Constants.MODID + " " + item.getUnlocalizedName().substring(5));
    }

}
