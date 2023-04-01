package org.avp.client.render.item;

import com.asx.mdx.client.render.item.ItemRenderer;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.avp.common.item.firearm.ItemFirearm;

public abstract class ItemFirearmRenderer<T extends Model> extends ItemRenderer<T>
{
	protected ItemFirearmRenderer(MapModelTexture<T> model)
	{
		super(model);
	}
	
	public boolean isDualWielding(EntityLivingBase entity)
	{
		if(!(entity instanceof EntityPlayer))
			return false;
		
		EntityPlayer player = (EntityPlayer) entity;
		
		if(player.getHeldItemMainhand().getItem() instanceof ItemFirearm && player.getHeldItemOffhand().getItem() instanceof ItemFirearm)
			return true;
		
		return false;
	}

	public boolean canAimWeapon(EntityLivingBase entity) {
		if(!(entity instanceof EntityPlayer))
			return false;

		EntityPlayer player = (EntityPlayer) entity;

		boolean mainhandCheck = player.getHeldItemMainhand().getItem() instanceof ItemFirearm && player.getHeldItemOffhand().isEmpty();
		boolean offhandCheck = player.getHeldItemOffhand().getItem() instanceof ItemFirearm && player.getHeldItemMainhand().isEmpty();
		return mainhandCheck || offhandCheck;
	}
}
