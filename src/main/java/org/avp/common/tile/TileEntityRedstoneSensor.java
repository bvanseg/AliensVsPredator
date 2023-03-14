package org.avp.common.tile;

import com.asx.mdx.lib.world.Pos;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import org.avp.common.api.power.IVoltageProvider;

import java.util.ArrayList;


public class TileEntityRedstoneSensor extends TileEntityElectrical implements IVoltageProvider
{
    public boolean isActiveRedstoneWireAttached;

    public TileEntityRedstoneSensor()
    {
        super(true);
    }

    @Override
    public void update()
    {
        if (this.canOutputPower())
        {
            this.setVoltage(12);
        }
        else
        {
            this.setVoltage(0);
        }
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.voltage;
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 10000;
    }

    public boolean canOutputPower()
    {
        World world = this.getWorld();
        int x = this.getPos().getX();
        int y = this.getPos().getY();
        int z = this.getPos().getZ();

        ArrayList<Pos> locations = new ArrayList<Pos>();
        Pos loc = new Pos(x, y, z);
        Pos right = loc.add(1, 0, 0);
        Pos left = loc.add(-1, 0, 0);
        Pos front = loc.add(0, 0, 1);
        Pos back = loc.add(0, 0, -1);
        Pos up = loc.add(0, 1, 0);
        Pos down = loc.add(0, -1, 0);

        locations.add(right);
        locations.add(left);
        locations.add(front);
        locations.add(back);
        locations.add(up);
        locations.add(down);

        this.isActiveRedstoneWireAttached = false;

        for (Pos location : locations)
        {
            if (location.getBlockState(world).getMaterial() == Material.CIRCUITS)
            {
                if (location.getBlock(world) == Blocks.REDSTONE_WIRE && location.getBlockMetadata(world) > 0)
                {
                    this.isActiveRedstoneWireAttached = true;
                    break;
                }
                if (location.getBlock(world) == Blocks.LEVER && location.getBlockMetadata(world) >= 9)
                {
                    this.isActiveRedstoneWireAttached = true;
                    break;
                }
                if (location.getBlock(world) == Blocks.DETECTOR_RAIL && location.getBlockMetadata(world) >= 8)
                {
                    this.isActiveRedstoneWireAttached = true;
                    break;
                }
                if (location.getBlock(world) == Blocks.POWERED_REPEATER)
                {
                    this.isActiveRedstoneWireAttached = true;
                    break;
                }
                if (location.getBlock(world) == Blocks.REDSTONE_TORCH)
                {
                    this.isActiveRedstoneWireAttached = true;
                    break;
                }
            }
        }

        return this.isActiveRedstoneWireAttached;
    }
}
