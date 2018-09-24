package org.avp.item;

import java.util.ArrayList;
import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.client.Sounds;
import org.avp.packets.server.PacketFirearmSync;
import org.avp.packets.server.PacketReloadFirearm;

import com.arisux.mdx.lib.client.Sound;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.world.entity.Entities;
import com.arisux.mdx.lib.world.entity.player.inventory.Inventories;
import com.arisux.mdx.lib.world.item.HookedItem;

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
    private static final ArrayList<FirearmProfile> FIREARMS         = new ArrayList<FirearmProfile>();
    private static int                             lastRegisteredId = 0;

    public static FirearmProfile getFirearmForGlobalId(int globalId)
    {
        for (FirearmProfile firearm : FIREARMS)
        {
            if (firearm.getGlobalId() == globalId)
            {
                return firearm;
            }
        }

        return null;
    }

    /**
     * An enum of the different firearm classifications used to mix and match firearms with different types of ammo.
     */
    public static enum Classification
    {
        SUB_MACHINE_GUN(1.0F),
        LIGHT_MACHINE_GUN(1.2F),
        RIFLE(1.8F),
        ASSAULT_RIFLE(1.0F),
        SHOTGUN(2.0F),
        PISTOL(1.0F);

        private float baseDamage;

        private Classification(float baseDamage)
        {
            this.baseDamage = baseDamage;
        }

        public float getBaseDamage()
        {
            return this.baseDamage;
        }
    }

    /**
     * A singleton used to register types of firearms.
     */
    public static class FirearmProfile
    {
        private Classification classification;
        private int            ammoMax;
        private int            ammoConsumptionRate;
        private float          recoil;
        private double         rpm;
        private int            reloadTime;
        private double         soundLength;
        private Sound          sound;

        private int            globalId;

        public FirearmProfile(Classification classification)
        {
            this.globalId = -1;
            this.classification = classification;
            this.ammoMax = 128;
            this.recoil = 0.2F;
            this.rpm = 400;
            this.reloadTime = 6 * 20;
            this.ammoConsumptionRate = 1;
            this.soundLength = 0;
            this.sound = Sounds.fxWeaponPistol;
            this.register();
        }

        public FirearmProfile register()
        {
            if (this.globalId == -1)
            {
                FIREARMS.add(this);
                this.globalId = ItemFirearm.lastRegisteredId++;
            }

            return this;
        }

        public int getGlobalId()
        {
            return globalId;
        }

        public Classification getClassification()
        {
            return classification;
        }

        public FirearmProfile setAmmoMax(int ammoMax)
        {
            this.ammoMax = ammoMax;
            return this;
        }

        public int getAmmoMax()
        {
            return ammoMax;
        }

        public FirearmProfile setRecoil(float recoil)
        {
            this.recoil = recoil;
            return this;
        }

        public float getRecoil()
        {
            return recoil;
        }

        public FirearmProfile setRoundsPerMinute(double rpm)
        {
            this.rpm = rpm;
            return this;
        }

        public double getRoundsPerMinute()
        {
            return rpm;
        }
        
        public int getShotsPerTick()
        {
            return (int) Math.round(this.rpm / (1 * 60 * 20));
        }

        public FirearmProfile setReloadTime(int reloadTime)
        {
            this.reloadTime = reloadTime;
            return this;
        }

        public int getReloadTime()
        {
            return reloadTime;
        }

        public FirearmProfile setSound(Sound sound)
        {
            this.sound = sound;
            return this;
        }

        public Sound getSound()
        {
            return sound;
        }

        public FirearmProfile setAmmoConsumptionRate(int ammoConsumptionRate)
        {
            this.ammoConsumptionRate = ammoConsumptionRate;
            return this;
        }

        public int getAmmoConsumptionRate()
        {
            return ammoConsumptionRate;
        }

        public FirearmProfile setSoundLength(double seconds)
        {
            this.soundLength = seconds;
            return this;
        }

        public double getSoundLength()
        {
            return this.soundLength;
        }
    }

    public static class ItemAmmunition extends HookedItem
    {
        protected Classification ammoClass;

        public ItemAmmunition(Classification ammoClass)
        {
            super();
            this.ammoClass = ammoClass;
        }

        public Classification getClassification()
        {
            return ammoClass;
        }
    }

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
                    world.playSound(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), this.profile.getSound().event(), SoundCategory.PLAYERS, 0.5F, 1F, true);
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
        Game.setRightClickDelayTimer(this.getProfile().getShotsPerTick());
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
