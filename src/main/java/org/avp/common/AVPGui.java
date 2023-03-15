package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import org.avp.AVP;
import org.avp.client.gui.*;
import org.avp.common.tile.*;
import org.predator.client.gui.GuiWristbracer;
import org.predator.common.PredatorItems;
import org.predator.common.inventory.ContainerWristbracer;
import org.predator.common.item.ItemWristbracer;

public class AVPGui implements IGuiHandler, IInitEvent
{
    public static final AVPGui            instance                = new AVPGui();
    public static final int               GUI_ASSEMBLER           = 0;
    public static final int               GUI_TURRET              = 1;
    public static final int               GUI_WRISTBRACER         = 2;
    public static final int               GUI_LOCKER              = 3;
    public static final int               GUI_SUPPLYCRATE         = 4;
    public static final int               GUI_GRAPHICSSETTINGS    = 5;
    public static final int               GUI_BLASTDOOR_PSWD      = 6;
    public static final int               GUI_NETWORK_RACK        = 7;
    public static final int               GUI_REPULSION_GENERATOR = 8;

    private AVPGui() {}

    @Override
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(AVP.instance, this);
    }

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos blockpos = new BlockPos(x, y, z);

        if (id == GUI_ASSEMBLER)
            return ((TileEntityAssembler) world.getTileEntity(blockpos)).getNewContainer(player);

        if (id == GUI_TURRET)
            return ((TileEntityTurret) world.getTileEntity(blockpos)).getNewContainer(player);

        if (id == GUI_WRISTBRACER && player != null && player.getHeldItemMainhand() != null)
        {
            Item item = player.getHeldItemMainhand().getItem();

            if (item instanceof ItemWristbracer)
            {
                return ((ItemWristbracer) item).getNewContainer(player);
            }
        }

        if (id == GUI_LOCKER)
        {
            TileEntityLocker locker = (TileEntityLocker) (world.getTileEntity(blockpos));
            return locker.getNewContainer(player);
        }

        if (id == GUI_SUPPLYCRATE)
        {
            TileEntitySupplyCrate supplyCrate = (TileEntitySupplyCrate) (world.getTileEntity(blockpos));
            return supplyCrate.getNewContainer(player);
        }

        if (id == GUI_NETWORK_RACK)
        {
            TileEntityNetworkRack networkRack = (TileEntityNetworkRack) (world.getTileEntity(blockpos));
            return networkRack.getNewContainer(player);
        }

        if (id == GUI_REPULSION_GENERATOR)
        {
            TileEntityRepulsionGenerator generator = (TileEntityRepulsionGenerator) (world.getTileEntity(blockpos));
            return generator.getNewContainer(player);
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
    {
        BlockPos blockpos = new BlockPos(x, y, z);

        if (id == GUI_ASSEMBLER)
        {
            return new GuiAssembler(player.inventory, (TileEntityAssembler) world.getTileEntity(blockpos), world, x, y, z);
        }

        if (id == GUI_TURRET)
        {
            return new GuiTurret(player, (TileEntityTurret) world.getTileEntity(blockpos), world, x, y, z);
        }

        if (id == GUI_WRISTBRACER)
        {
            Item item = player.getHeldItemMainhand().getItem();

            if (item == PredatorItems.ITEM_WRISTBRACER)
            {
                return new GuiWristbracer(player, (ContainerWristbracer) ((ItemWristbracer) item).getNewContainer(player));
            }
        }

        if (id == GUI_LOCKER)
        {
            return new GuiLocker(player, (TileEntityLocker) (world.getTileEntity(blockpos)));
        }

        if (id == GUI_SUPPLYCRATE)
        {
            return new GuiSupplyCrate(player, (TileEntitySupplyCrate) (world.getTileEntity(blockpos)));
        }

        if (id == GUI_GRAPHICSSETTINGS)
        {
            return new GuiModSettings(Minecraft.getMinecraft().currentScreen);
        }

        if (id == GUI_BLASTDOOR_PSWD)
        {
            return new GuiBlastdoor((TileEntityBlastdoor) world.getTileEntity(blockpos));
        }

        if (id == GUI_NETWORK_RACK)
        {
            return new GuiNetworkRack(player, (TileEntityNetworkRack) world.getTileEntity(blockpos));
        }
        
        if (id == GUI_REPULSION_GENERATOR)
        {
            return new GuiRepulsionGenerator(player, (TileEntityRepulsionGenerator) world.getTileEntity(blockpos));
        }

        return null;
    }
}
