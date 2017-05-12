package org.avp.item;

import org.avp.AliensVsPredator;
import org.avp.packets.server.PacketSpawnEntity;

import com.arisux.mdxlib.lib.world.entity.Entities;
import com.arisux.mdxlib.lib.world.entity.player.inventory.Inventories;
import com.arisux.mdxlib.lib.world.item.HookedItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class ItemEntitySummoner extends HookedItem
{
    private Class<? extends Entity> c;

    public ItemEntitySummoner(Class<? extends Entity> c)
    {
        super();
        this.c = c;
        this.setDescription("Summoner for " + c.getSimpleName().replace("Entity", ""));
        this.setUnlocalizedName(AliensVsPredator.properties().DOMAIN + "summon." + c.getSimpleName());
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemstack, World world, EntityPlayer player, EnumHand hand)
    {
        Entity entity = createNewEntity(world);
        Inventories.consumeItem(player, this);

        if (world.isRemote && entity != null)
        {
            RayTraceResult ray = player.rayTrace(50D, 1F);
            AliensVsPredator.network().sendToServer(new PacketSpawnEntity(ray.hitVec.xCoord + 0.5, ray.hitVec.yCoord + 1D, ray.hitVec.zCoord + 0.5, Entities.getEntityRegistrationId(c)));
        }

        return super.onItemRightClick(itemstack, world, player, hand);
    }

    public Class<? extends Entity> getEntityClass()
    {
        return c;
    }

    public Entity createNewEntity(World world)
    {
        return Entities.constructEntity(world, c);
    }
}
