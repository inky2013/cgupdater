package uk.co.conclipsegames.projDart.Block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import uk.co.conclipsegames.projDart.Constants;
import uk.co.conclipsegames.projDart.ProjectDart;

public class BlockForceInfuser extends Block {

    protected BlockForceInfuser(String unlocName, Material material) {
        super(material);
        this.setBlockName(unlocName);
        this.setCreativeTab(ProjectDart.pdtab);
        this.setBlockTextureName(Constants.MODID+":"+unlocName);
        this.setHardness(2.0F);
        this.setResistance(1600F);
    }
}
