package org.avp.item;

import java.util.Random;

import com.arisux.mdx.lib.client.entityfx.EntityFXElectricArc;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemStunBaton extends ItemSword
{
    // TODO: Fix this, the ToolMaterial passed into this constructor is DIAMOND,
    // didnt know what custom material to put, n dont wanna make a new one that
    // might not be what u guys want
    public ItemStunBaton(ToolMaterial material)
    {
        super(material);
        // TODO: Find out if this is a proper max damage. Remove this if a damage is
        // specified later by a custom material
        this.setMaxDamage(120);
        this.maxStackSize = 1;
    }

    // TODO: adjust these particles once MDX 2.0.0.25 is added to the dev
    // environment
    @Override
    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        addArcEffect(player, entity);
        return super.onLeftClickEntity(stack, player, entity);
    }

    @SideOnly(Side.CLIENT)
    private static void addArcEffect(EntityPlayer player, Entity target)
    {
        Random rand = new Random();
        float mult = 100F;
        int span = (int) (target.width * mult);

        float targetYOrigin = (float) (target.posY + (target.height / 2));
        float targetX = (float) (target.posX + (rand.nextInt(span) / mult) - (rand.nextInt(span) / mult));
        float targetY = (float) (targetYOrigin + (rand.nextInt(span) / mult) - (rand.nextInt(span) / mult));
        float targetZ = (float) (target.posZ + (rand.nextInt(span) / mult) - (rand.nextInt(span) / mult));

        Game.minecraft().effectRenderer.addEffect(new EntityFXElectricArc(player.world, target.posX, targetYOrigin, target.posZ, targetX, targetY, targetZ, 1, 1F, 0.1F, 0.05F, 0xFF8866CC));
    }
}