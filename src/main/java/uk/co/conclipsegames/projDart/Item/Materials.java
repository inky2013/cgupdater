package uk.co.conclipsegames.projDart.Item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import uk.co.conclipsegames.projDart.Constants;
import uk.co.conclipsegames.projDart.ProjectDart;

import java.util.List;

public class Materials extends Item
{
    @SideOnly(Side.CLIENT)
    private IIcon[] texture;

    final static String[] materials = new String[] {
            "forceGem",
            "forgeIngot"
    };

    protected Materials(){
        super();
        this.setCreativeTab(ProjectDart.pdtab);
        this.setHasSubtypes(true);
        //RegisterHelper.registerItem(this, "Materials");
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return "item."+ Constants.MODID+"."+materials[stack.getItemDamage()];
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister){
        texture = new IIcon[materials.length];
        for(int i = 0; i < materials.length; i++){
            texture[i] = iconRegister.registerIcon(Constants.MODID + ":" + "material_" + materials[i]);
        }
    }
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs creativeTabs, List list){
        for (int i = 0; i < materials.length; i++){
            list.add(new ItemStack(item, 1, i));
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return texture[meta];
    }
}