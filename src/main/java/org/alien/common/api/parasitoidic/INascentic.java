package org.alien.common.api.parasitoidic;

import net.minecraft.entity.EntityLivingBase;

public interface INascentic extends IMaturable
{
    void vitalize(EntityLivingBase host);
    
    void grow(EntityLivingBase host);
}
