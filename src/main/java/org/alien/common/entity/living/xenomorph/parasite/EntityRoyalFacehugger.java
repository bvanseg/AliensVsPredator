package org.alien.common.entity.living.xenomorph.parasite;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.world.Embryo;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;

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
    public void implantEmbryo(EntityLivingBase living)
    {
        OrganismImpl organism = (OrganismImpl) living.getCapability(Provider.CAPABILITY, null);
        organism.impregnate(Embryo.QUEEN);
        if(this.getImplantSound() != null)
            this.playSound(this.getImplantSound(), 0.5F, 1F);
        organism.syncWithClients(living);
        this.setFertility(false);
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_ROYAL_FACEHUGGER);
    }
}
