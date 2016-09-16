package uk.co.conclipsegames.projDart.Afterthoughts;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import uk.co.conclipsegames.projDart.Item.PDItems;

public class PDCrafting {

    public static void init() {

        GameRegistry.addShapelessRecipe(new ItemStack(PDItems.itemIngot, 2, 1), new Object[] {Items.gold_ingot, Items.gold_ingot, PDItems.forceGem});
        GameRegistry.addShapelessRecipe(new ItemStack(PDItems.itemIngot, 1, 1), new Object[] {Items.gold_ingot, PDItems.forceGem});
        GameRegistry.addShapelessRecipe(new ItemStack(PDItems.itemIngot, 1, 1), new Object[] {Items.iron_ingot, Items.iron_ingot, PDItems.forceGem});
        GameRegistry.addSmelting(new ItemStack(PDItems.itemDust, 1, 3), new ItemStack(PDItems.itemIngot, 1, 1), 4F);

    }
}
