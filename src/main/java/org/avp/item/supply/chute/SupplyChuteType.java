package org.avp.item.supply.chute;

import org.avp.AVPBlocks;
import org.avp.AliensVsPredator;
import org.avp.client.model.entities.ModelSupplyChute;
import org.avp.entities.EntitySupplyChute;
import org.avp.entities.EntitySupplyChuteMarines;
import org.avp.entities.EntitySupplyChuteSeegson;

import com.asx.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum SupplyChuteType {
        UNBRANDED(0, EntitySupplyChute.class), MARINES(1, EntitySupplyChuteMarines.class), SEEGSON(2, EntitySupplyChuteSeegson.class);

        private int                                id;
        private Class<? extends EntitySupplyChute> entityType;

        SupplyChuteType(int id, Class<? extends EntitySupplyChute> entityType)
        {
            this.id = id;
            this.entityType = entityType;
        }

        public int id()
        {
            return id;
        }

        public static SupplyChuteType get(int id)
        {
            for (SupplyChuteType type : values())
            {
                if (type.id == id)
                {
                    return type;
                }
            }

            return UNBRANDED;
        }

        public static SupplyChuteType get(Class<? extends EntitySupplyChute> entityType)
        {
            for (SupplyChuteType type : values())
            {
                if (type.getEntityClassType() == entityType)
                {
                    return type;
                }
            }

            return UNBRANDED;
        }

        public static SupplyChuteType get(Block block)
        {
            for (SupplyChuteType type : values())
            {
                if (type.getBlock() == block)
                {
                    return type;
                }
            }

            return UNBRANDED;
        }

        @SideOnly(Side.CLIENT)
        public MapModelTexture<ModelSupplyChute> getModel()
        {
            return SupplyChuteType.getModel(this);
        }

        @SideOnly(Side.CLIENT)
        public static MapModelTexture<ModelSupplyChute> getModel(SupplyChuteType type)
        {
            switch (type)
            {
                case MARINES:
                    return AliensVsPredator.resources().models().SUPPLY_CHUTE_MARINES;

                case SEEGSON:
                    return AliensVsPredator.resources().models().SUPPLY_CHUTE_SEEGSON;

                default:
                    return AliensVsPredator.resources().models().SUPPLY_CHUTE;

            }
        }

        public Block getBlock()
        {
            return SupplyChuteType.getBlock(this);
        }

        public static Block getBlock(SupplyChuteType type)
        {
            switch (type)
            {
                case MARINES:
                    return AVPBlocks.CRATE_MARINES;

                case SEEGSON:
                    return AVPBlocks.CRATE_SEEGSON;

                default:
                    return AVPBlocks.SUPPLY_CRATE;
            }
        }

        public Class<? extends EntitySupplyChute> getEntityClassType()
        {
            return entityType;
        }

        public EntitySupplyChute createEntity(World world, double x, double y, double z)
        {
            try
            {
                return (this.getEntityClassType().getConstructor(World.class, double.class, double.class, double.class)).newInstance(new Object[] { world, x, y, z });
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            return null;
        }
    }