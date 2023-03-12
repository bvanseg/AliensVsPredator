package org.avp.common.world.dimension;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldServer;
import org.alien.AlienBlocks;
import org.avp.AVP;

import java.util.Random;

public class TeleporterLV extends Teleporter
{
    private final WorldServer worldServer;
    private final Random rand;
    public Block portal;

    public TeleporterLV(WorldServer worldServer)
    {
        super(worldServer);
        this.worldServer = worldServer;
        this.rand = new Random(worldServer.getSeed());
    }
    
    @Override
    public void placeInPortal(Entity entity, float yaw)
    {
        portal = this.worldServer.provider.getDimension() == AVP.dimensions().VARDA.getId() ? AlienBlocks.PORTAL_VARDA : AlienBlocks.PORTAL_ACHERON;

        if (this.worldServer.provider.getDimension() != 1)
        {
            if (!this.placeInExistingPortal(entity, yaw))
            {
                this.makePortal(entity);
                this.placeInExistingPortal(entity, yaw);
            }
        }
        else
        {
            int x = MathHelper.floor(entity.posX);
            int y = MathHelper.floor(entity.posY) - 1;
            int z = MathHelper.floor(entity.posZ);
            byte b0 = 1;
            byte b1 = 0;

            for (int l = -2; l <= 2; ++l)
            {
                for (int i1 = -2; i1 <= 2; ++i1)
                {
                    for (int j1 = -1; j1 < 3; ++j1)
                    {
                        int bX = x + i1 * b0 + l * b1;
                        int bY = y + j1;
                        int bZ = z + i1 * b1 - l * b0;
                        this.worldServer.setBlockState(new BlockPos(bX, bY, bZ), AlienBlocks.ENGINEER_FLOOR.getDefaultState());
                    }
                }
            }

            entity.setLocationAndAngles((double) x, (double) y, (double) z, entity.rotationYaw, 0.0F);
            entity.motionX = entity.motionY = entity.motionZ = 0.0D;
        }
    }

    @Override
    public boolean makePortal(Entity entity)
    {
        byte b0 = 16;
        double d0 = -1.0D;
        int i = MathHelper.floor(entity.posX);
        int j = MathHelper.floor(entity.posY);
        int k = MathHelper.floor(entity.posZ);
        int l = i;
        int i1 = j;
        int j1 = k;
        int k1 = 0;
        int l1 = this.rand.nextInt(4);
        int x;
        double d1;
        int z;
        double d2;
        int y;
        int j3;
        int k3;
        int l3;
        int i4;
        int j4;
        int k4;
        int l4;
        int i5;
        double d3;
        double d4;

        for (x = i - b0; x <= i + b0; ++x)
        {
            d1 = (double) x + 0.5D - entity.posX;

            for (z = k - b0; z <= k + b0; ++z)
            {
                d2 = (double) z + 0.5D - entity.posZ;
                label274:

                for (y = this.worldServer.getActualHeight() - 1; y >= 0; --y)
                {
                    if (this.worldServer.isAirBlock(new BlockPos(x, y, z)))
                    {
                        while (y > 0 && this.worldServer.isAirBlock(new BlockPos(x, y - 1, z)))
                        {
                            --y;
                        }

                        for (j3 = l1; j3 < l1 + 4; ++j3)
                        {
                            k3 = j3 % 2;
                            l3 = 1 - k3;

                            if (j3 % 4 >= 2)
                            {
                                k3 = -k3;
                                l3 = -l3;
                            }

                            for (i4 = 0; i4 < 3; ++i4)
                            {
                                for (j4 = 0; j4 < 4; ++j4)
                                {
                                    for (k4 = -1; k4 < 4; ++k4)
                                    {
                                        l4 = x + (j4 - 1) * k3 + i4 * l3;
                                        i5 = y + k4;
                                        int j5 = z + (j4 - 1) * l3 - i4 * k3;
                                        BlockPos pos = new BlockPos(l4, i5, j5);

                                        if (k4 < 0 && !this.worldServer.getBlockState(pos).getMaterial().isSolid() || k4 >= 0 && !this.worldServer.isAirBlock(pos))
                                        {
                                            continue label274;
                                        }
                                    }
                                }
                            }

                            d3 = (double) y + 0.5D - entity.posY;
                            d4 = d1 * d1 + d3 * d3 + d2 * d2;

                            if (d0 < 0.0D || d4 < d0)
                            {
                                d0 = d4;
                                l = x;
                                i1 = y;
                                j1 = z;
                                k1 = j3 % 4;
                            }
                        }
                    }
                }
            }
        }

        if (d0 < 0.0D)
        {
            for (x = i - b0; x <= i + b0; ++x)
            {
                d1 = (double) x + 0.5D - entity.posX;

                for (z = k - b0; z <= k + b0; ++z)
                {
                    d2 = (double) z + 0.5D - entity.posZ;
                    label222:

                    for (y = this.worldServer.getActualHeight() - 1; y >= 0; --y)
                    {
                        if (this.worldServer.isAirBlock(new BlockPos(x, y, z)))
                        {
                            while (y > 0 && this.worldServer.isAirBlock(new BlockPos(x, y - 1, z)))
                            {
                                --y;
                            }

                            for (j3 = l1; j3 < l1 + 2; ++j3)
                            {
                                k3 = j3 % 2;
                                l3 = 1 - k3;

                                for (i4 = 0; i4 < 4; ++i4)
                                {
                                    for (j4 = -1; j4 < 4; ++j4)
                                    {
                                        k4 = x + (i4 - 1) * k3;
                                        l4 = y + j4;
                                        i5 = z + (i4 - 1) * l3;
                                        BlockPos pos = new BlockPos(k4, l4, i5);
                                        
                                        if (j4 < 0 && !this.worldServer.getBlockState(pos).getMaterial().isSolid() || j4 >= 0 && !this.worldServer.isAirBlock(pos))
                                        {
                                            continue label222;
                                        }
                                    }
                                }

                                d3 = (double) y + 0.5D - entity.posY;
                                d4 = d1 * d1 + d3 * d3 + d2 * d2;

                                if (d0 < 0.0D || d4 < d0)
                                {
                                    d0 = d4;
                                    l = x;
                                    i1 = y;
                                    j1 = z;
                                    k1 = j3 % 2;
                                }
                            }
                        }
                    }
                }
            }
        }

        int k5 = l;
        int j2 = i1;
        z = j1;
        int l5 = k1 % 2;
        int l2 = 1 - l5;

        if (k1 % 4 >= 2)
        {
            l5 = -l5;
            l2 = -l2;
        }

        boolean flag;

        if (d0 < 0.0D)
        {
            if (i1 < 70)
            {
                i1 = 70;
            }

            if (i1 > this.worldServer.getActualHeight() - 10)
            {
                i1 = this.worldServer.getActualHeight() - 10;
            }

            j2 = i1;

            for (y = -1; y <= 1; ++y)
            {
                for (j3 = 1; j3 < 3; ++j3)
                {
                    for (k3 = -1; k3 < 3; ++k3)
                    {
                        l3 = k5 + (j3 - 1) * l5 + y * l2;
                        i4 = j2 + k3;
                        j4 = z + (j3 - 1) * l2 - y * l5;
                        flag = k3 < 0;
                        this.worldServer.setBlockState(new BlockPos(l3, i4, j4), flag ? AlienBlocks.ENGINEER_FLOOR.getDefaultState() : Blocks.AIR.getDefaultState());
                    }
                }
            }
        }

        for (y = 0; y < 4; ++y)
        {
            for (j3 = 0; j3 < 4; ++j3)
            {
                for (k3 = -1; k3 < 4; ++k3)
                {
                    l3 = k5 + (j3 - 1) * l5;
                    i4 = j2 + k3;
                    j4 = z + (j3 - 1) * l2;
                    flag = j3 == 0 || j3 == 3 || k3 == -1 || k3 == 3;
                    this.worldServer.setBlockState(new BlockPos(l3, i4, j4), (flag ? AlienBlocks.ENGINEER_FLOOR.getDefaultState() : portal.getDefaultState()));
                }
            }

            for (j3 = 0; j3 < 4; ++j3)
            {
                for (k3 = -1; k3 < 4; ++k3)
                {
                    l3 = k5 + (j3 - 1) * l5;
                    i4 = j2 + k3;
                    j4 = z + (j3 - 1) * l2;
                    this.worldServer.notifyNeighborsOfStateChange(new BlockPos(l3, i4, j4), this.worldServer.getBlockState(new BlockPos(l3, i4, j4)).getBlock(), true);
                }
            }
        }

        return true;
    }
}
