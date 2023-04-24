package org.avp.common.item;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.AVP;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.server.PacketSpawnEntity;

import java.util.List;
import java.util.function.Function;

public class ItemEntitySummoner<T extends Entity> extends HookedItem
{
    private final Class<T> entityClass;
    private final Function<World, T> deferredEntityConstructor;

    public ItemEntitySummoner(Class<T> entityClass, Function<World, T> deferredEntityConstructor)
    {
        super();
        this.entityClass = entityClass;
        this.deferredEntityConstructor = deferredEntityConstructor;
        this.setDescription("Summoner for " + entityClass.getSimpleName().replace("Entity", ""));
        this.setTranslationKey(AVP.Properties.DOMAIN + "summon." + entityClass.getSimpleName());
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        Inventories.consumeItem(player, this);

        if (world.isRemote)
        {
            RayTraceResult ray = player.rayTrace(50D, 1F);

            if (ray == null) return super.onItemRightClick(world, player, hand);

            if(player.isSneaking() && player.isCreative()) {
                AVPNetworking.instance.sendToServer(new PacketSpawnEntity(ray.hitVec.x + 0.5, ray.hitVec.y + 1D, ray.hitVec.z + 0.5, Entities.getEntityRegistrationId(this.entityClass), 5));
            } else {
                AVPNetworking.instance.sendToServer(new PacketSpawnEntity(ray.hitVec.x + 0.5, ray.hitVec.y + 1D, ray.hitVec.z + 0.5, Entities.getEntityRegistrationId(this.entityClass), 1));
            }
        
        }

        return super.onItemRightClick(world, player, hand);
    }

    public Entity createNewEntity(World world)
    {
        return this.deferredEntityConstructor.apply(world);
    }
    
    @Override
    public void addInformation(ItemStack arg0, World arg1, List<String> tooltip, ITooltipFlag arg3) {
    	super.addInformation(arg0, arg1, tooltip, arg3);
        // TODO: Localize.
        tooltip.add("Right click to spawn 1.");
        tooltip.add("Shift + right click to spawn 5.");
    }
}
