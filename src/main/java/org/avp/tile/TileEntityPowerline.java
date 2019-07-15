package org.avp.tile;

import java.util.Random;

import org.avp.DamageSources;
import org.avp.api.power.IVoltageProvider;
import org.avp.api.power.IVoltageReceiver;
import org.avp.block.BlockPowerline;

import com.asx.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.MDXMath;
import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityPowerline extends TileEntityElectrical implements IVoltageProvider, IVoltageReceiver
{
    public TileEntityPowerline()
    {
        super(false);
    }

    @Override
    public void update()
    {
        super.update();
        this.updateEnergyAsReceiver();

        if (this.voltage > 600 && this.world.getWorldTime() % 8 == 0)
        {
            int connections = 0;

            for (EnumFacing direction : EnumFacing.VALUES)
            {
                TileEntity tile = this.world.getTileEntity(this.getPos().offset(direction));

                if (tile != null && tile instanceof TileEntityElectrical)
                {
                    TileEntityElectrical electrical = (TileEntityElectrical) tile;

                    if (electrical instanceof IVoltageProvider)
                    {
                        IVoltageProvider provider = (IVoltageProvider) electrical;

                        if (electrical.canProvideEnergyToReceiver(direction) && provider.canConnectPower(direction))
                        {
                            connections++;
                        }
                    }

                    if (electrical instanceof IVoltageReceiver)
                    {
                        if (electrical.getVoltage() < this.getVoltage())
                        {
                            connections++;
                        }
                    }
                }
            }

            boolean canArc = connections <= 1;

            if (canArc)
            {
                Random rand = new Random();
                double maxArcDist = (this.getVoltage() / 600);
                float m = 1.75F;
                double x = this.pos.getX() + 0.5;
                double y = this.pos.getY() + 0.5;
                double z = this.pos.getZ() + 0.5;
                Pos t = getNextGroundingPoint(new Pos(x, y + 1, z), this.world);
                Entity target = Entities.getRandomEntityInCoordsRange(world, EntityLivingBase.class, new Pos(this), (int) Math.floor(maxArcDist));
                double distG = y - t.y;
                double distE = 1000;
                double dist = distG;
                double arcWidth = MDXMath.map((double) this.voltage, 600D, 10000D, 0.05D, 0.5D);
                float damageMult = (float) (arcWidth * 100F);

                if (target != null)
                {
                    Pos p = new Pos(target.getPosition()).add(target.width / 2, 0, target.width / 2);
                    m = 8F;
                    distE = target.getDistance(x, y, z);

                    if (distE <= distG && distE <= maxArcDist)
                    {
                        t = p;
                        dist = distE;
                        target.attackEntityFrom(DamageSources.electricity, damageMult);
                        target.setFire(3);
                    }
                }

                if (dist <= maxArcDist)
                {
                    if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
                    {
                        this.spawnArc(t, m, rand, dist, x, y, z, arcWidth);
                    }
                }
            }
        }
    }

    @SideOnly(Side.CLIENT)
    public void spawnArc(Pos t, float m, Random rand, double dist, double x, double y, double z, double arcWidth)
    {
        float targetX = (float) (t.x + (rand.nextFloat() / m) - (rand.nextFloat() / m));
        float targetY = (float) (t.y + 1);
        float targetZ = (float) (t.z + (rand.nextFloat() / m) - (rand.nextFloat() / m));
        int age = 4;
        int color = 0xFF8866CC;
        EntityFXElectricArc arc = new EntityFXElectricArc(world, x, y, z, targetX, targetY, targetZ, age, 0.24F * dist, 0.1F, (float) arcWidth, color);
        Game.minecraft().effectRenderer.addEffect(arc);
    }

    public static Pos getNextGroundingPoint(Pos pos, World world)
    {
        for (int y = (int) pos.y; y > 0; y--)
        {
            Pos position = new Pos(pos.x, y - 1, pos.z);

            if (isPositionAcceptable(position, world))
            {
                return position;
            }
        }

        return pos;
    }

    public static boolean isPositionAcceptable(Pos pos, World world)
    {
        if (pos != null && world != null)
        {
            Pos newPos = new Pos(pos.x, pos.y, pos.z);
            Block b = newPos.getBlock(world);
            return b != net.minecraft.init.Blocks.AIR && !(b instanceof BlockPowerline);
        }

        return false;
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
}
