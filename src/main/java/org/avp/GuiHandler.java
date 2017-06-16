package org.avp;

import org.avp.client.gui.GuiAssembler;
import org.avp.client.gui.GuiLocker;
import org.avp.client.gui.GuiModSettings;
import org.avp.client.gui.GuiSupplyCrate;
import org.avp.client.gui.GuiTurret;
import org.avp.client.gui.GuiWristbracer;
import org.avp.inventory.ContainerWristbracer;
import org.avp.item.ItemWristbracer;
import org.avp.tile.TileEntityAssembler;
import org.avp.tile.TileEntityLocker;
import org.avp.tile.TileEntitySupplyCrate;
import org.avp.tile.TileEntityTurret;

import com.arisux.mdx.lib.game.IInitEvent;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class GuiHandler implements IGuiHandler, IInitEvent
{
    public static final GuiHandler instance             = new GuiHandler();
    public final int               GUI_ASSEMBLER        = 0;
    public final int               GUI_TURRET           = 1;
    public final int               GUI_WRISTBRACER      = 2;
    public final int               GUI_LOCKER           = 3;
    public final int               GUI_SUPPLYCRATE      = 4;
    public final int               GUI_GRAPHICSSETTINGS = 5;

    @Override
    public void init(FMLInitializationEvent event)
    {
        NetworkRegistry.INSTANCE.registerGuiHandler(AliensVsPredator.instance(), this);
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

            if (item == AliensVsPredator.items().itemWristbracer)
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

        return null;
    }
}
