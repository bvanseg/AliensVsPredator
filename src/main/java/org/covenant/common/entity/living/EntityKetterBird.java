package org.covenant.common.entity.living;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.covenant.common.CovenantItems;

/**
 * @author Boston Vanseghi
 */
public class EntityKetterBird extends EntityCreature {
    private static final DataParameter<Byte> VARIANT = EntityDataManager.createKey(EntityKetterBird.class, DataSerializers.BYTE);

    public EntityKetterBird(World world) {
        super(world);
        this.setSize(0.5F, 1.0F);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(VARIANT, (byte) this.rand.nextInt(3));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5599999761581421D);
    }

    public byte getVariant() {
        return this.dataManager.get(VARIANT);
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target) {
        return new ItemStack(CovenantItems.SUMMONER_KETTER_BIRD);
    }
}
