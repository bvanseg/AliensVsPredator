package org.weapon.common.item.firearm;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.common.AVPNetworking;
import org.weapon.common.network.packet.server.PacketFirearmSync;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;

import java.util.List;
import java.util.Set;

public class ItemFirearm extends HookedItem
{
    
    private final FirearmProfile firearmProfile;
    private long                 lastSoundPlayed;
    private float                breakProgress;
    private int                  breakingIndex;

    public ItemFirearm(FirearmProfile firearmProfile)
    {
        this.firearmProfile = firearmProfile;
        this.setMaxStackSize(1);
        this.lastSoundPlayed = 0;
    }

    private static final String AMMUNITION_NBT_KEY = "Ammunition";

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack itemStack = player.getHeldItem(hand);

        int ammunition = this.getAmmoCount(itemStack);

        if (ammunition <= 0) {
            this.reload(player, itemStack);
            return super.onItemRightClick(world, player, hand);
        }

        // Decrement ammo count on fire.
        NBTTagCompound weaponNBT = itemStack.getTagCompound();
        int ammoCount = weaponNBT.getInteger(AMMUNITION_NBT_KEY);
        weaponNBT.setInteger(AMMUNITION_NBT_KEY, ammoCount - firearmProfile.getAmmoConsumptionRate());
        itemStack.setTagCompound(weaponNBT);

        if (!world.isRemote) {
            // TODO: Send firearm shoot packet here with player look vector info.
        }

        if (world.isRemote) {
            this.renderRecoil();
            this.fixDelay();

            if (this.canSoundPlay()) {
                world.playSound(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), this.firearmProfile.getSound().event(), SoundCategory.PLAYERS, 1F, 1F, true);
                this.setLastSoundPlayed(System.currentTimeMillis());
            }

            // TODO: Move this logic server-side.
            RayTraceResult trace = Entities.rayTraceSpecial(128, 1.0F);

            // TODO: The client shouldn't tell the server what it hit.
            if (trace != null && trace.typeOfHit == Type.BLOCK)
            {
                AVPNetworking.instance.sendToServer(new PacketFirearmSync(trace.typeOfHit, trace.entityHit, (int) trace.hitVec.x, (int) trace.hitVec.y, (int) trace.hitVec.z, this.firearmProfile));
            }

            // TODO: The client shouldn't tell the server what it hit.
            if (trace != null && trace.typeOfHit == Type.ENTITY)
            {
                AVPNetworking.instance.sendToServer(new PacketFirearmSync(trace.typeOfHit, trace.entityHit, 0, 0, 0, this.firearmProfile));
            }
        }

        return super.onItemRightClick(world, player, hand);
    }
    
    private boolean tryConsumeAmmoForFirearm(EntityPlayer player) {
        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

        // Find ammunition items.
        Set<Item> ammoItems = inventorySnapshot.getItemsMatchingPredicate(
                item -> item instanceof ItemAmmunition &&
                        ((ItemAmmunition)item).getClassification() == this.firearmProfile.getClassification()
        );

        // If no ammo, failed to consume.
        if (ammoItems.isEmpty()) return false;

        inventorySnapshot.consumeItem(ammoItems.iterator().next());
    	
    	return true;
    }

    public void reload(EntityPlayer player, ItemStack itemStack) {
        boolean flag = tryConsumeAmmoForFirearm(player);

        if (flag) {
            NBTTagCompound weaponNBT = itemStack.getTagCompound();

            if (weaponNBT == null) {
                weaponNBT = new NBTTagCompound();
            }

            weaponNBT.setInteger(AMMUNITION_NBT_KEY, this.firearmProfile.getAmmoMax());
            itemStack.setTagCompound(weaponNBT);
        }
    }

    public boolean canSoundPlay()
    {
        long major = System.currentTimeMillis() / 1000 - this.getLastSoundPlayTime() / 1000;
        long minor = Math.abs((System.currentTimeMillis() - this.getLastSoundPlayTime()) - (major * 1000));
        // TODO: We can just do bit manipulation instead of whatever this is. Also use ticks instead of system time.
        double time = Double.parseDouble(String.format("%s.%s", major, minor));
        return this.getLastSoundPlayTime() == 0 || (time >= this.getFirearmProfile().getSoundLength());
    }

    @SideOnly(Side.CLIENT)
    public void renderRecoil()
    {
        ClientGame.instance.minecraft().player.renderArmPitch -= this.firearmProfile.getRecoil() * 40.0F;
        ClientGame.instance.minecraft().player.renderArmYaw += this.firearmProfile.getRecoil() * 5.0F;
        ClientGame.instance.minecraft().player.rotationPitch -= this.firearmProfile.getRecoil() * 1.4F;
    }

    @SideOnly(Side.CLIENT)
    public void fixDelay()
    {
        ClientGame.instance.setEquippedProgress(0.85F);
        ClientGame.instance.setRightClickDelayTimer((int) (60 /** seconds **/ / this.getFirearmProfile().getRoundsPerMinute() * 20 /** ticks **/));
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

    public int getAmmoCount(ItemStack itemStack)
    {
        if (!(itemStack.getItem() instanceof ItemFirearm)) {
            throw new UnsupportedOperationException("Can not read ammo count of a non-firearm item!");
        }

        NBTTagCompound weaponNBT = itemStack.getTagCompound();

        if (weaponNBT == null) {
            weaponNBT = new NBTTagCompound();
            itemStack.setTagCompound(weaponNBT);
        }

        return weaponNBT.getInteger(AMMUNITION_NBT_KEY);
    }

    public long getLastSoundPlayTime()
    {
        return this.lastSoundPlayed;
    }

    public void setLastSoundPlayed(long lastSoundPlayed)
    {
        this.lastSoundPlayed = lastSoundPlayed;
    }

    public FirearmProfile getFirearmProfile()
    {
        return firearmProfile;
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
