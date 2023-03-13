package org.alien.common.api.parasitoidic;

import net.minecraft.entity.EntityLivingBase;

public interface Nascentic extends Maturable
{
    void vitalize(EntityLivingBase host);
    
    void grow(EntityLivingBase host);
}
