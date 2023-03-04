package org.avp.item;

import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.item.firearms.FirearmProfile;
import org.avp.item.firearms.ItemAmmunition;
import org.avp.packets.server.PacketFirearmSync;
import org.avp.packets.server.PacketReloadFirearm;

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
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("unchecked")
public class ItemFirearm extends HookedItem
{
    
    private FirearmProfile profile;
    private int            ammo;
    private int            reloadTimer;
    private long           lastSoundPlayed;
    private float          breakProgress;
    private int            breakingIndex;

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


                if (trace != null && trace.typeOfHit == Type.BLOCK)
                {
                    AliensVsPredator.network().sendToServer(new PacketFirearmSync(trace.typeOfHit, trace.entityHit, (int) trace.hitVec.x, (int) trace.hitVec.y, (int) trace.hitVec.z, this.profile));
                }

                if (trace != null && trace.typeOfHit == Type.ENTITY)
                {
                    AliensVsPredator.network().sendToServer(new PacketFirearmSync(trace.typeOfHit, trace.entityHit, 0, 0, 0, this.profile));
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

    public static boolean hasAmmunitionFor(FirearmProfile firearm, EntityPlayer player)
    {
        return consumeAmmunition(firearm, player, true);
    }

    public static boolean consumeAmmunition(FirearmProfile firearm, EntityPlayer player)
    {
        return consumeAmmunition(firearm, player, false);
    }

    public static boolean consumeAmmunition(FirearmProfile firearm, EntityPlayer player, boolean simulate)
    {
        for (ItemStack itemstack : player.inventory.mainInventory)
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
        
        for (ItemStack itemstack : player.inventory.offHandInventory)
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

        if (player.world.isRemote)
        {
            AliensVsPredator.network().sendToServer(new PacketReloadFirearm());
        }

        this.ammo = this.profile.getAmmoMax();
    }

    public boolean canSoundPlay()
    {
        long major = System.currentTimeMillis() / 1000 - this.getLastSoundPlayTime() / 1000;
        long minor = Math.abs((System.currentTimeMillis() - this.getLastSoundPlayTime()) - (major * 1000));
        double time = Double.valueOf(String.format("%s.%s", major, minor));
        return this.getLastSoundPlayTime() == 0 ? true : (time >= this.getProfile().getSoundLength());
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
