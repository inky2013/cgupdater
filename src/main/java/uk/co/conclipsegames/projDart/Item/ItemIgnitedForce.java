package uk.co.conclipsegames.projDart.Item;

import cpw.mods.fml.common.IFuelHandler;
import net.minecraft.item.ItemStack;
import uk.co.conclipsegames.projDart.Constants;

public class ItemIgnitedForce extends ItemProjDart implements IFuelHandler {

    public ItemIgnitedForce() {

        this.setUnlocalizedName("itemIgnitedForce");
        this.setTextureName(Constants.MODID + ":hotForceGem");
    }

    @Override
    public int getBurnTime(ItemStack fuel) {
        return 180;
    }
}
