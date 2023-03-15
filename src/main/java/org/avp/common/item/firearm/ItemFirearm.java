package org.avp.common.item.firearm;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.asx.mdx.lib.world.item.HookedItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.server.PacketFirearmSync;
import org.avp.common.network.packet.server.PacketReloadFirearm;

import java.util.List;

public class ItemFirearm extends HookedItem
{
    
    private final FirearmProfile profile;
    private int                  ammo;
    private int                  reloadTimer;
    private long                 lastSoundPlayed;
    private float                breakProgress;
    private int                  breakingIndex;

    public ItemFirearm(FirearmProfile profile)
    {
        this.profile = profile;
        this.setMaxStackSize(1);
        this.reloadTimer = 0;
        this.ammo = 0;
        this.lastSoundPlayed = 0;
    }

    @Override
    public void onUpdate(ItemStack itemstack, World world, Entity entity, int slot, boolean selected)
    {
        super.onUpdate(itemstack, world, entity, slot, selected);
        this.reloadTimer--;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        if (world.isRemote)
        {
            if (this.ammo > 0 || player.capabilities.isCreativeMode)
            {
                RayTraceResult trace = Entities.rayTraceSpecial(128, 1.0F);

                this.renderRecoil();
                this.fixDelay();

                if (this.profile != null && this.canSoundPlay())
                {
                    world.playSound(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), this.profile.getSound().event(), SoundCategory.PLAYERS, 1F, 1F, true);
                    this.setLastSoundPlayed(System.currentTimeMillis());
                }

                // TODO: The client shouldn't tell the server what it hit.
                if (trace != null && trace.typeOfHit == Type.BLOCK)
                {
                    AVPNetworking.instance.sendToServer(new PacketFirearmSync(trace.typeOfHit, trace.entityHit, (int) trace.hitVec.x, (int) trace.hitVec.y, (int) trace.hitVec.z, this.profile));
                }

                // TODO: The client shouldn't tell the server what it hit.
                if (trace != null && trace.typeOfHit == Type.ENTITY)
                {
                    AVPNetworking.instance.sendToServer(new PacketFirearmSync(trace.typeOfHit, trace.entityHit, 0, 0, 0, this.profile));
                }

                if (!player.capabilities.isCreativeMode)
                {
                    this.ammo -= this.profile.getAmmoConsumptionRate();
                }
            }
            else if (hasAmmunitionFor(this.profile, player))
            {
                this.reload(player);
            }
        }

        return super.onItemRightClick(world, player, hand);
    }

    public boolean canFire(EntityPlayer player)
    {
        return true;
    }

    // TODO: Instead of iterating twice (once for simulation and once for consumption), just return a result data type and then consume on that result type if needed.
    public static boolean hasAmmunitionFor(FirearmProfile firearm, EntityPlayer player)
    {
        return consumeAmmunition(firearm, player, true);
    }

    // TODO: Instead of iterating twice (once for simulation and once for consumption), just return a result data type and then consume on that result type if needed.
    public static boolean consumeAmmunition(FirearmProfile firearm, EntityPlayer player)
    {
        return consumeAmmunition(firearm, player, false);
    }

    public static boolean consumeAmmunition(FirearmProfile firearm, EntityPlayer player, boolean simulate)
    {
    	// Main-hand inventory.
    	if (tryConsumeAmmoForFirearm(player, firearm, player.inventory.mainInventory, simulate)) {
    		return true;
    	}
    	// Off-hand inventory.
    	else if (tryConsumeAmmoForFirearm(player, firearm, player.inventory.offHandInventory, simulate)) {
    		return true;
    	}

        return false;
    }
    
    private static boolean tryConsumeAmmoForFirearm(EntityPlayer player, FirearmProfile firearm, NonNullList<ItemStack> inventory, Boolean simulate) {
    	for (ItemStack itemstack : inventory)
        {
            if (itemstack != null && itemstack.getItem() instanceof ItemAmmunition)
            {
                ItemAmmunition ammunition = (ItemAmmunition) itemstack.getItem();

                if (ammunition.getClassification() == firearm.getClassification())
                {
                    if (!simulate)
                    {
                        Inventories.consumeItem(player, ammunition);
                    }

                    return true;
                }
            }
        }
    	
    	return false;
    }

    public void reload(EntityPlayer player)
    {
        if (!player.world.isRemote)
        {
            consumeAmmunition(this.profile, player);
        }
        else {
        	// TODO: Try and avoid the client telling the server what to do.
            AVPNetworking.instance.sendToServer(new PacketReloadFirearm());
        }

        this.ammo = this.profile.getAmmoMax();
    }

    public boolean canSoundPlay()
    {
        long major = System.currentTimeMillis() / 1000 - this.getLastSoundPlayTime() / 1000;
        long minor = Math.abs((System.currentTimeMillis() - this.getLastSoundPlayTime()) - (major * 1000));
        // TODO: We can just do bit manipulation instead of whatever this is. Also use ticks instead of system time.
        double time = Double.parseDouble(String.format("%s.%s", major, minor));
        return this.getLastSoundPlayTime() == 0 || (time >= this.getProfile().getSoundLength());
    }

    public void setAmmoCount(int ammoCount)
    {
        this.ammo = ammoCount;
    }

    @SideOnly(Side.CLIENT)
    public void renderRecoil()
    {
        Game.minecraft().player.renderArmPitch -= this.profile.getRecoil() * 40.0F;
        Game.minecraft().player.renderArmYaw += this.profile.getRecoil() * 5.0F;
        Game.minecraft().player.rotationPitch -= this.profile.getRecoil() * 1.4F;
    }

    @SideOnly(Side.CLIENT)
    public void fixDelay()
    {
        Game.setEquippedProgress(0.85F);
        Game.setRightClickDelayTimer((int) (60 /** seconds **/ / this.getProfile().getRoundsPerMinute() * 20 /** ticks **/));
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
        return true;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack itemstack, BlockPos pos, EntityPlayer player)
    {
        return false;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BOW;
    }
    
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        tooltip.add("Left click to aim, Right click to fire");
        tooltip.add("Press R to reload");
    }

    public int getReload()
    {
        return reloadTimer;
    }

    public int getAmmoCount()
    {
        return this.ammo;
    }

    public long getLastSoundPlayTime()
    {
        return this.lastSoundPlayed;
    }

    public void setLastSoundPlayed(long lastSoundPlayed)
    {
        this.lastSoundPlayed = lastSoundPlayed;
    }

    public FirearmProfile getProfile()
    {
        return profile;
    }

    public float getBreakProgress()
    {
        return breakProgress;
    }

    public int getBlockBreakingIndex()
    {
        return breakingIndex;
    }

    public void setBlockBreakingIndex(int breakingIndex)
    {
        this.breakingIndex = breakingIndex;
    }

    public void setBreakProgress(float breakProgress)
    {
        this.breakProgress = breakProgress;
    }
}
