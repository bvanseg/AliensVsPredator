package org.weapon.common.item.firearm;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.sound.Sound;
import com.asx.mdx.common.minecraft.item.HookedItem;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
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
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.RayTraceResult.Type;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.common.AVPDamageSources;
import org.lib.common.RayTraceUtil;
import org.lib.common.inventory.CachedInventoryHandler;
import org.lib.common.inventory.InventorySnapshot;
import org.weapon.common.delay.DelayHandler;
import org.weapon.common.item.firearm.rework.FirearmProperties;
import org.weapon.common.item.firearm.rework.mode.FireMode;
import org.weapon.common.reload.ReloadHandler;

import java.util.List;
import java.util.Set;

public class ItemFirearm extends HookedItem
{
    private final FirearmProperties firearmProperties;

    public ItemFirearm(FirearmProperties firearmProperties)
    {
        this.firearmProperties = firearmProperties;
        this.setMaxStackSize(1);
    }

    private static final String AMMUNITION_NBT_KEY = "Ammunition";
    private static final String FIRE_MODE_ID_NBT_KEY = "FireModeId";

    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, EntityPlayer player, EnumHand hand)
    {
        ItemStack itemStack = player.getHeldItem(hand);
        FireMode activeFireMode = this.getActiveFireMode(itemStack);

        // Remove MC's hardcoded delay for right-clicking.
        if (world.isRemote) {
            ClientGame.instance.setRightClickDelayTimer(0);
        }

        // If the weapon has an active delay, return early.
        if (DelayHandler.instance.hasDelay(player, hand) || ReloadHandler.instance.isReloading(player, hand)) {
            return super.onItemRightClick(world, player, hand);
        }

        if (!player.isCreative() && !player.isSpectator()) {
            int ammunition = this.getAmmoCount(itemStack);

            if (ammunition <= 0) {
                this.reload(player, itemStack, hand);
                return super.onItemRightClick(world, player, hand);
            }

            // Decrement ammo count on fire.
            this.consumeAmmunition(itemStack, activeFireMode);
        }

        if (!world.isRemote) {
            RayTraceResult result = RayTraceUtil.rayTrace(player, 128, 1.0F);

            if (result != null && result.typeOfHit == Type.ENTITY) {
                Entity entity = result.entityHit;
                entity.hurtResistantTime = 0;
                entity.attackEntityFrom(AVPDamageSources.causeBulletDamage(player), firearmProperties.getDamageMultiplier());
            }

            Sound soundForFireMode = this.firearmProperties.getFireSounds().get(activeFireMode);

            if (soundForFireMode != null) {
                world.playSound(null, player.getPosition(), soundForFireMode.event(), SoundCategory.PLAYERS, 2.5F, 1F);
            }
        }

        if (world.isRemote) {
            // Render recoil after the weapon as fired. Otherwise, weapons with massive recoil (snipers, for example) will nearly always miss the target.
            this.renderRecoil();
            ClientGame.instance.setEquippedProgress(0.85F);
        }

        int delay = this.firearmProperties.getTickDelayBetweenShots();
        DelayHandler.instance.setDelay(player, hand, player.world.getTotalWorldTime() + delay);

        return super.onItemRightClick(world, player, hand);
    }

    private void consumeAmmunition(ItemStack itemStack, FireMode activeFireMode) {
        NBTTagCompound weaponNBT = itemStack.getTagCompound();
        int ammoCount = weaponNBT.getInteger(AMMUNITION_NBT_KEY);
        int newAmmoCount = MathHelper.clamp(ammoCount - activeFireMode.getShotsPerTriggerPull(), 0, this.firearmProperties.getMaxAmmunition());
        weaponNBT.setInteger(AMMUNITION_NBT_KEY, newAmmoCount);
        itemStack.setTagCompound(weaponNBT);
    }

    private boolean tryConsumeRoundsForFirearm(EntityPlayer player) {
        InventorySnapshot inventorySnapshot = CachedInventoryHandler.instance.getInventorySnapshotForPlayer(player);

        // Find ammunition items.
        Set<Item> ammoItems = inventorySnapshot.getItemsMatchingPredicate(
                item -> this.firearmProperties.getConsumablesForReload().contains(item)
        );

        // If no ammo, failed to consume.
        if (ammoItems.isEmpty()) return false;

        inventorySnapshot.consumeItem(ammoItems.iterator().next());
    	
    	return true;
    }

    public void reload(EntityPlayer player, ItemStack itemStack, EnumHand hand) {
        // If a reload is already scheduled, do not run again.
        if (ReloadHandler.instance.isReloading(player, hand)) {
            return;
        }

        boolean ableToConsumeRounds = tryConsumeRoundsForFirearm(player);

        if (ableToConsumeRounds) {
            long reloadTime = player.world.getTotalWorldTime() + this.firearmProperties.getReloadTimeInTicks();
            ReloadHandler.instance.scheduleReload(player, hand, () -> {
                NBTTagCompound weaponNBT = itemStack.getTagCompound();

                if (weaponNBT == null) {
                    weaponNBT = new NBTTagCompound();
                }

                weaponNBT.setInteger(AMMUNITION_NBT_KEY, this.firearmProperties.getMaxAmmunition());
                itemStack.setTagCompound(weaponNBT);
            }, reloadTime);
        }
    }

    @SideOnly(Side.CLIENT)
    public void renderRecoil()
    {
        ClientGame.instance.minecraft().player.renderArmPitch -= this.firearmProperties.getRecoil() * 40.0F;
        ClientGame.instance.minecraft().player.renderArmYaw += this.firearmProperties.getRecoil() * 5.0F;
        ClientGame.instance.minecraft().player.rotationPitch -= this.firearmProperties.getRecoil() * 1.4F;
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

    public FireMode getActiveFireMode(ItemStack itemStack) {
        if (!(itemStack.getItem() instanceof ItemFirearm)) {
            throw new UnsupportedOperationException("Can not read active fire mode of a non-firearm item!");
        }

        NBTTagCompound weaponNBT = itemStack.getTagCompound();

        if (weaponNBT == null) {
            weaponNBT = new NBTTagCompound();
            itemStack.setTagCompound(weaponNBT);
        }

        if (!weaponNBT.hasKey(FIRE_MODE_ID_NBT_KEY)) {
            weaponNBT.setInteger(FIRE_MODE_ID_NBT_KEY, this.firearmProperties.getDefaultFireMode().getId());
        }

        int fireModeId = weaponNBT.getInteger(FIRE_MODE_ID_NBT_KEY);

        FireMode activeFireMode = FireMode.getById(fireModeId);

        return activeFireMode != null ? activeFireMode : this.firearmProperties.getDefaultFireMode();
    }

    public FirearmProperties getFirearmProperties()
    {
        return this.firearmProperties;
    }

    @Override
    public boolean canDestroyBlockInCreative(World world, BlockPos pos, ItemStack stack, EntityPlayer player) {
        return false;
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        return 0F;
    }
}
