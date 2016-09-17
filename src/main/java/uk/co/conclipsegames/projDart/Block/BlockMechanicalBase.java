package uk.co.conclipsegames.projDart.Block;

import com.sun.corba.se.spi.activation.ServerHelper;
import cpw.mods.fml.common.eventhandler.Event;
import net.minecraft.block.Block;
import net.minecraft.block.BlockGlass;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import uk.co.conclipsegames.projDart.ProjectDart;
import uk.co.conclipsegames.projDart.TileEntity.TileMechanicalBase;

import java.util.ArrayList;

public abstract class BlockMechanicalBase extends Block {

    protected boolean basicGui = true;

    public BlockMechanicalBase(Material material) {

        super(material);
        setStepSound(soundTypeStone);
        setCreativeTab(ProjectDart.pdtab);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase living, ItemStack stack) {

        TileEntity tile = world.getTileEntity(x, y, z);

        /*if (tile instanceof TileMechanicalBase) {
            ((TileMechanicalBase) tile).setInvName(ItemHelper.getNameFromItemStack(stack));
        }*/
        super.onBlockPlacedBy(world, x, y, z, living, stack);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int hitSide, float hitX, float hitY, float hitZ) {

        PlayerInteractEvent event = new PlayerInteractEvent(player, PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK, x, y, z, hitSide, world);
        if (MinecraftForge.EVENT_BUS.post(event) || event.getResult() == Event.Result.DENY || event.useBlock == Event.Result.DENY) {
            return false;
        }
        if (player.isSneaking()) {
            /*if (Utils.isHoldingUsableWrench(player, x, y, z)) {
                if (ServerHelper.isServerWorld(world) && canDismantle(player, world, x, y, z)) {
                    dismantleBlock(player, world, x, y, z, false);
                }
                Utils.usedWrench(player, x, y, z);
                return true;
            }*/
            return false;
        }
        TileMechanicalBase tile = (TileMechanicalBase) world.getTileEntity(x, y, z);

        if (tile == null) {
            return false;
        }
        /*if (Utils.isHoldingUsableWrench(player, x, y, z)) {
            if (ServerHelper.isServerWorld(world)) {
                tile.onWrench(player, hitSide);
            }
            Utils.usedWrench(player, x, y, z);
            return true;
        }*/
        if (basicGui) {
            if (ProjectDart.isServerWorld(world)) {
                return tile.openGui(player);
            }
            return tile.hasGui();
        }
        return false;
    }

    @Override
    public IIcon getIcon(int side, int metadata) {

        return null;
    }

    @Override
    public NBTTagCompound getItemStackTag(World world, int x, int y, int z) {

        TileEntity tile = world.getTileEntity(x, y, z);

        NBTTagCompound retTag = null;

        if (tile instanceof TileMechanicalBase && (!((TileMechanicalBase) tile).tileName.isEmpty())) {
            retTag = ProjectDart.setItemStackTagName(retTag, ((TileMechanicalBase) tile).tileName);
        }
        /*if (tile instanceof IRedstoneControl) {
            retTag = RedstoneControlHelper.setItemStackTagRS(retTag, (IRedstoneControl) tile);
        }*/
        return retTag;
    }

    /* Dismantle Helper */
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