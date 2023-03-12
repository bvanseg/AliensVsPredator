package org.alien.common.entity.living.xenomorph.parasite;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.ItemHandler;
import org.avp.common.world.Embryo;
import org.avp.common.world.capability.IOrganism.Organism;
import org.avp.common.world.capability.IOrganism.Provider;

public class EntityRoyalFacehugger extends EntityFacehugger
{
    public EntityRoyalFacehugger(World world)
    {
        super(world);
        this.setSize(1F, 1F);
        this.experienceValue = 300;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(175.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    public int getTotalArmorValue()
    {
        return 4;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        return false;
    }

    @Override
    public void implantEmbryo(EntityLivingBase living)
    {
        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);
        organism.impregnate(Embryo.QUEEN);
        organism.syncWithClients(living);
        this.setFertility(false);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerRoyalFacehugger);
    }
}
