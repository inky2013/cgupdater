package uk.co.conclipsegames.projDart.Item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import uk.co.conclipsegames.projDart.Constants;

import java.util.List;

public class ItemIngot extends ItemProjDart {

    public IIcon[] icons = new IIcon[256];



    public ItemIngot()
    {
        super();
        setHasSubtypes(true);
    }

    @Override
    public void registerIcons(IIconRegister register)
    {
        for(int i = 0; i < Resource.values().length; i++)
        {
            if (!(Resource.values()[i].getName() == "iron") || (Resource.values()[i].getName() == "gold")) {
                icons[i] = register.registerIcon(Constants.MODID + ":" + Resource.values()[i].getName() + "Ingot");
            }
        }
    }

    @Override
    public IIcon getIconFromDamage(int meta)
    {
        return icons[meta];
    }

    @Override
    public void getSubItems(Item item, CreativeTabs tabs, List itemList)
    {
        for(int counter = 0; counter < Resource.values().length; counter++)
        {
            itemList.add(new ItemStack(this, 1, counter));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack item)
    {
        if(item.getItemDamage() <= Resource.values().length-1)
        {
            if (!(Resource.values()[item.getItemDamage()].getName() == "iron") || (Resource.values()[item.getItemDamage()].getName() == "gold")) {
                return "item." + Resource.values()[item.getItemDamage()].getName().toLowerCase() + "Ingot";
            }
        }

        return "Invalid";
    }

}
