package uk.co.conclipsegames.projDart.Block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.material.Material;

public class PDBlocks {

    public static BlockForceInfuser blockForceInfuser;

    public static void init() {
        GameRegistry.registerBlock(blockForceInfuser = new BlockForceInfuser("blockForceInfuser", Material.iron), "blockForceInfuser");
    }
}
