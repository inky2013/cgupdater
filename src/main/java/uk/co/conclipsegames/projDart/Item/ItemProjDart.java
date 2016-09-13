package uk.co.conclipsegames.projDart.Item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import uk.co.conclipsegames.projDart.Constants;
import uk.co.conclipsegames.projDart.ProjectDart;

public class ItemProjDart extends Item {

    public ItemProjDart() {
        super();
        setCreativeTab(ProjectDart.pdtab);
    }
    public void registerIcons(IIconRegister register)
    {
        itemIcon = register.registerIcon(Constants.MODID+":" + getUnlocalizedName().replace("item.", ""));
    }
}
