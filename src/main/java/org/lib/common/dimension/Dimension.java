//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.lib.common.dimension;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Teleporter;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldServer;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class Dimension {
    protected String name;
    protected String suffix;
    protected Class<? extends WorldProvider> provider;
    protected boolean keepLoaded;

    private DimensionType type;

    public Dimension(String name, String suffix, Class<? extends WorldProvider> provider, boolean keepLoaded) {
        this.name = name;
        this.suffix = suffix;
        this.provider = provider;
        this.keepLoaded = keepLoaded;
    }

    public static void transferEntityTo(Entity entity, int dimensionId) {
        final WorldServer worldServer = entity.getEntityWorld().getMinecraftServer().getWorld(dimensionId);
        Teleporter teleporter = new Teleporter(worldServer) {
            @Override
            public void placeInPortal(Entity entityIn, float rotationYaw) {
                Pos coord = Entities.getSafePositionAboveBelow(new Pos(entityIn.posX, worldServer.provider.getAverageGroundLevel(), entityIn.posZ), worldServer);
                entityIn.setLocationAndAngles(coord.x, coord.y, coord.z, entityIn.rotationYaw, entityIn.rotationPitch);
            }

            @Override
            public boolean placeInExistingPortal(Entity entityIn, float rotationYaw) {
                return false;
            }

            @Override
            public boolean makePortal(Entity entity) {
                return false;
            }
        };

        entity.changeDimension(dimensionId, teleporter);
    }

    public int getId() {
        return this.getType().getId();
    }

    public String getName() {
        return this.name;
    }

    public String getSuffix() {
        return this.suffix;
    }

    public Class<? extends WorldProvider> getProvider() {
        return this.provider;
    }

    public boolean shouldKeepLoaded() {
        return this.keepLoaded;
    }

    public DimensionType getType() {
        return this.type;
    }

    public void setType(DimensionType type) {
        this.type = type;
    }

    public void transferEntityTo(Entity e) {
        transferEntityTo(e, this.getId());
    }
}
