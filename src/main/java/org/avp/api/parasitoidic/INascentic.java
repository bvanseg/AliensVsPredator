package org.avp.api.parasitoidic;

import net.minecraft.entity.EntityLivingBase;

public interface INascentic extends IMaturable
{
    public void vitalize(EntityLivingBase host);
    
    public void grow(EntityLivingBase host);
}
