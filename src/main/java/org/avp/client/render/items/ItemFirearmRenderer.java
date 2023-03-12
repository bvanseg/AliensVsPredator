package org.avp.client.render.items;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.avp.common.item.firearms.ItemFirearm;

abstract class ItemFirearmRenderer<T extends Model> extends ItemRenderer<T>
{
	public ItemFirearmRenderer(MapModelTexture<T> model)
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
}
