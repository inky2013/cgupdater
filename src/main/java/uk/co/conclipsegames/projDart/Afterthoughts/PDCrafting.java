package uk.co.conclipsegames.projDart.Afterthoughts;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;
import uk.co.conclipsegames.projDart.Item.PDItems;

public class PDCrafting {

    public static void init() {

        GameRegistry.addShapelessRecipe(new ItemStack(PDItems.itemIngot));

    }
}
