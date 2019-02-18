package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.ModelSupplyChute;
import org.avp.entities.EntitySupplyChute;
import org.avp.entities.EntitySupplyChuteMarines;
import org.avp.entities.EntitySupplyChuteSeegson;

import com.arisux.mdx.lib.client.util.models.MapModelTexture;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;
import com.arisux.mdx.lib.world.item.HookedItem;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSupplyChute extends HookedItem
{
    public static enum SupplyChuteType
    {
        UNBRANDED(0, EntitySupplyChute.class), MARINES(1, EntitySupplyChuteMarines.class), SEEGSON(2, EntitySupplyChuteSeegson.class);

        private int                                id;
        private Class<? extends EntitySupplyChute> entityType;

        private SupplyChuteType(int id, Class<? extends EntitySupplyChute> entityType)
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
                    return AliensVsPredator.blocks().crateMarines;

                case SEEGSON:
                    return AliensVsPredator.blocks().crateSeegson;

                default:
                    return AliensVsPredator.blocks().supplyCrate;
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

    private SupplyChuteType type;

    public ItemSupplyChute(SupplyChuteType type)
    {
        setTranslationKey("supplyChute");
        setMaxStackSize(1);
        this.type = type;
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        if (playerIn.capabilities.isCreativeMode || Inventories.consumeItem(playerIn, this))
        {
            int x = (int) (playerIn.posX + 1);
            int y = (int) (playerIn.posY + 80);
            int z = (int) (playerIn.posZ);

            if (!worldIn.isRemote)
            {
                worldIn.setBlockState(new BlockPos(x, y, z), this.type.getBlock().getDefaultState());
            }
        }
        return super.onItemRightClick(worldIn, playerIn, hand);
    }

    public SupplyChuteType getType()
    {
        return type;
    }
}
