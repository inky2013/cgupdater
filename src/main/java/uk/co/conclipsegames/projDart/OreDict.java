package uk.co.conclipsegames.projDart;

import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import uk.co.conclipsegames.projDart.Item.ItemIngot;
import uk.co.conclipsegames.projDart.Item.PDItems;

public class OreDict {

    public static void init() {
        OreDictionary.registerOre("ingotCopper", new ItemStack(PDItems.itemIngot, 2, 1));
        OreDictionary.registerOre("ingotTin", new ItemStack(PDItems.itemIngot, 3, 1));
        OreDictionary.registerOre("ingotForce", new ItemStack(PDItems.itemIngot, 4, 1));
        OreDictionary.registerOre("ingotMithril", new ItemStack(PDItems.itemIngot, 4, 1)); //Force Ingot
        OreDictionary.registerOre("ingotSilver", new ItemStack(PDItems.itemIngot, 5, 1));
        OreDictionary.registerOre("ingotLead", new ItemStack(PDItems.itemIngot, 6, 1));
        OreDictionary.registerOre("ingotAluminum", new ItemStack(PDItems.itemIngot, 7, 1));
        OreDictionary.registerOre("ingotAluminium", new ItemStack(PDItems.itemIngot, 7, 1));

    }

}
