package uk.co.conclipsegames.projDart.TileEntity;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class TileMechanicalBase extends TileEntity{

    public TileMechanicalBase() {

    }
    @Override
    public ArrayList<ItemStack> dismantleBlock(EntityPlayer player, NBTTagCompound nbt, World world, int x, int y, int z, boolean returnDrops, boolean simulate) {

        TileEntity tile = world.getTileEntity(x, y, z);
        int bMeta = world.getBlockMetadata(x, y, z);

        ItemStack dropBlock = new ItemStack(this, 1, bMeta);

        if (nbt != null && !nbt.hasNoTags()) {
            dropBlock.setTagCompound(nbt);
        }
        if (!simulate) {
            if (tile instanceof TileMechanicalBase) {
                ((TileMechanicalBase) tile).blockDismantled();
            }
            world.setBlockToAir(x, y, z);

            if (!returnDrops) {
                float f = 0.3F;
                double x2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                double y2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                double z2 = world.rand.nextFloat() * f + (1.0F - f) * 0.5D;
                EntityItem item = new EntityItem(world, x + x2, y + y2, z + z2, dropBlock);
                item.delayBeforeCanPickup = 10;
                world.spawnEntityInWorld(item);
            }
        }
        ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
        ret.add(dropBlock);
        return ret;
    }

}
