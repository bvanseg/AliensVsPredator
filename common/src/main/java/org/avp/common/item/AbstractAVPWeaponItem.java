package org.avp.common.item;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.common.internal.common.core.animation.AnimatableManager;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import org.avp.api.item.weapon.WeaponItemData;
import org.avp.common.sound.AVPSoundEvents;
import org.avp.common.util.GameObject;
import org.avp.mixin.MixinMinecraftAccessor;

public abstract class AbstractAVPWeaponItem extends Item implements GeoItem {

    // TODO: CLEAR THIS PERIODICALLY.
    // FIXME: FR FR ON JAH, CLEAN THIS RN
    private static final Map<BlockPos, Float> BLOCK_BREAK_PROGRESS_MAP = new HashMap<>();

    private static final String AMMUNITION_KEY = "Ammunition";

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    private final WeaponItemData weaponItemData;

    protected AbstractAVPWeaponItem(Properties properties, WeaponItemData weaponItemData) {
        super(properties);
        this.weaponItemData = weaponItemData;
    }

    protected abstract BlockEntityWithoutLevelRenderer createRenderer();

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(
        @NotNull Level level,
        @NotNull Player player,
        @NotNull InteractionHand interactionHand
    ) {
        var itemStack = player.getItemInHand(interactionHand);
        var tag = itemStack.getOrCreateTag();
        var ammunition = tag.getInt(AMMUNITION_KEY);

        if (level.isClientSide) {
            ((MixinMinecraftAccessor) Minecraft.getInstance()).setRightClickDelay(0);
        }

        if (!level.isClientSide) {
            if (ammunition <= 0) {
                reload(level, player, itemStack);
                return super.use(level, player, interactionHand);
            } else {
                fire(level, player, tag);
            }
        }

        if (level.isClientSide) {
            var recoil = this.getWeaponItemData().getRecoil();
            player.attackAnim = recoil;
            player.oAttackAnim = recoil;
        }

        return super.use(level, player, interactionHand);
    }

    private void fire(@NotNull Level level, @NotNull Player player, CompoundTag tag) {
        var fireRateInTicks = this.getWeaponItemData().getFireRateInTicks();
        tag.putInt(AMMUNITION_KEY, tag.getInt(AMMUNITION_KEY) - 1);

        if (fireRateInTicks > 0) {
            player.getCooldowns().addCooldown(this, fireRateInTicks);
        }

        var fireSound = this.getWeaponItemData().getFireSound().get();
        level.playSound(null, player.blockPosition(), fireSound, SoundSource.PLAYERS);

        var hitResult = ProjectileUtil.getHitResultOnViewVector(player, entity -> true, 128.0D);

        switch (hitResult.getType()) {
            case BLOCK -> damageBlock(level, (BlockHitResult) hitResult);
            case ENTITY -> damageEntity(level, (EntityHitResult) hitResult);
        }
    }

    private void damageEntity(@NotNull Level level, EntityHitResult hitResult) {
        var damage = this.getWeaponItemData().getDamage();
        var entity = hitResult.getEntity();

        entity.invulnerableTime = 0;
        entity.hurt(level.damageSources().generic(), damage);
    }

    private void damageBlock(@NotNull Level level, BlockHitResult hitResult) {
        var blockPos = hitResult.getBlockPos();
        var blockState = level.getBlockState(blockPos);
        var block = blockState.getBlock();
        var soundType = block.getSoundType(blockState);

        GameObject<SoundEvent> ricochetSfx = getRicochetSound(soundType);

        level.playSound(null, blockPos, ricochetSfx.get(), SoundSource.BLOCKS);

        BLOCK_BREAK_PROGRESS_MAP.compute(blockPos, (key, value) -> {
            var _value = value == null ? 0 : value;
            var newValue = _value + (this.getWeaponItemData().getDamage() / (2F + block.defaultDestroyTime() / 2F));
            var progress = (int) Mth.clamp(newValue, 0F, 9F);
            level.destroyBlockProgress(Objects.hash(blockPos), blockPos, progress);

            if (progress >= 9) {
                level.destroyBlock(blockPos, false);
                return null;
            }
            return newValue;
        });

        // FIXME: Use packet to emit particles, otherwise will crash server.
        Minecraft.getInstance().particleEngine.crack(blockPos, hitResult.getDirection());
    }

    private static GameObject<SoundEvent> getRicochetSound(SoundType soundType) {
        GameObject<SoundEvent> ricochetSfx;

        if (soundType == SoundType.GLASS) {
            ricochetSfx = AVPSoundEvents.ITEM_WEAPON_FX_RICOCHET_GLASS;
        } else if (soundType == SoundType.GRAVEL) {
            ricochetSfx = AVPSoundEvents.ITEM_WEAPON_FX_RICOCHET_DIRT;
        } else if (soundType == SoundType.METAL) {
            ricochetSfx = AVPSoundEvents.ITEM_WEAPON_FX_RICOCHET_METAL;
        } else {
            ricochetSfx = AVPSoundEvents.ITEM_WEAPON_FX_RICOCHET_GENERIC;
        }
        return ricochetSfx;
    }

    private void reload(Level level, Player player, ItemStack itemStack) {
        var maxAmmunition = this.getWeaponItemData().getMaxAmmunition();
        var reloadTimeInTicks = this.getWeaponItemData().getReloadTimeInTicks();

        player.getCooldowns().addCooldown(this, reloadTimeInTicks);
        var tag = itemStack.getOrCreateTag();
        tag.putInt(AMMUNITION_KEY, maxAmmunition);
        // TODO: Consume ammunition item.

        var reloadSound = this.getWeaponItemData().getReloadSound().get();
        level.playSound(null, player.blockPosition(), reloadSound, SoundSource.PLAYERS);
    }

    @Override
    public @NotNull UseAnim getUseAnimation(@NotNull ItemStack itemStack) {
        return UseAnim.NONE;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // Do nothing
    }

    @Override
    public void createRenderer(Consumer<Object> consumer) {
        consumer.accept(new RenderProvider() {

            private final BlockEntityWithoutLevelRenderer renderer = AbstractAVPWeaponItem.this.createRenderer();

            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                return this.renderer;
            }
        });
    }

    public WeaponItemData getWeaponItemData() {
        return weaponItemData;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Override
    public Supplier<Object> getRenderProvider() {
        return renderProvider;
    }
}
