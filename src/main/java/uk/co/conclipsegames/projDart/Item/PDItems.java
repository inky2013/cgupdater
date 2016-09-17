package uk.co.conclipsegames.projDart.Item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import uk.co.conclipsegames.projDart.Constants;
import uk.co.conclipsegames.projDart.ProjectDart;

public class PDItems {
    public static Item forceGem;
    public static ItemDust itemDust;
    public static ItemIngot itemIngot;
    public static ItemIgnitedForce itemIgnitedForce;

    public static final void init() {
        forceGem = new Item().setUnlocalizedName("forceGem").setCreativeTab(ProjectDart.pdtab).setTextureName(Constants.MODID+":forceGem");
        itemDust = new ItemDust();
        itemIgnitedForce = new ItemIgnitedForce();
        itemIngot = new ItemIngot();
        GameRegistry.registerItem(forceGem, "forceGem");
        GameRegistry.registerItem(itemIgnitedForce, "itemIgnitedForce");
        GameRegistry.registerItem(itemDust, "itemDust");
        GameRegistry.registerItem(itemIngot, "itemIngot");
    }
}
