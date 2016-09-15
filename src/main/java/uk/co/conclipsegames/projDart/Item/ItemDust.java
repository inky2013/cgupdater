package uk.co.conclipsegames.projDart.Item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import uk.co.conclipsegames.projDart.Constants;

import java.util.List;

public class ItemDust extends ItemProjDart {

    public IIcon[] icons = new IIcon[256];

    public static String[] en_USNames = Constants.DustMaterials;

    public ItemDust()
    {
        super();
        setHasSubtypes(true);
    }

    @Override
    public void registerIcons(IIconRegister register)
    {
        for(int i = 0; i <= 6; i++)
        {
            icons[i] = register.registerIcon(Constants.MODID+":" + en_USNames[i] + "Dust");
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
        for(int counter = 0; counter <= 6; counter++)
        {
            itemList.add(new ItemStack(item, 1, counter));
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack item)
    {
        return "item." + en_USNames[item.getItemDamage()].toLowerCase() + "Dust";
    }
}