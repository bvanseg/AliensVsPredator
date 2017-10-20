package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.entities.EntitySpear;

import com.arisux.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.GameSounds;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemStunBaton extends ItemSword
{
	//TODO: Fix this, the ToolMaterial passed into this constructor is DIAMOND, didnt know what custom material to put, n dont wanna make a new one that might not be what u guys want
    public ItemStunBaton(ToolMaterial material)
    {
        super(material);
        //TODO: Find out if this is a proper max damage. Remove this if a damage is specified later by a custom material
        this.setMaxDamage(120);
        this.maxStackSize = 1;
    }
    
    //TODO: adjust these particles once MDX 2.0.0.25 is added to the dev environment
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity) 
    {
    	Game.minecraft().effectRenderer.addEffect(new EntityFXElectricArc(player.world, entity.posX, entity.posY, entity.posZ, entity.posX, entity.posY + 1, entity.posZ, 1, 1F, 1F, 1F, 0xFF00CCFF));
    	return super.onLeftClickEntity(stack, player, entity);
    }
}