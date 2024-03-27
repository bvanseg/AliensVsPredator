package org.avp.common.item;

import mod.azure.azurelib.common.api.common.animatable.GeoItem;
import mod.azure.azurelib.common.internal.client.RenderProvider;
import mod.azure.azurelib.common.internal.common.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.common.internal.common.core.animation.AnimatableManager;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Consumer;
import java.util.function.Supplier;

import org.avp.api.item.weapon.WeaponItemData;

public abstract class AbstractAVPWeaponItem extends Item implements GeoItem {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    private final Supplier<Object> renderProvider = GeoItem.makeRenderer(this);

    private final WeaponItemData weaponItemData;

    protected AbstractAVPWeaponItem(Properties properties, WeaponItemData weaponItemData) {
        super(properties);
        this.weaponItemData = weaponItemData;
    }

    protected abstract BlockEntityWithoutLevelRenderer createRenderer();

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand interactionHand) {
        var fireRateInTicks = this.getWeaponItemData().getFireRateInTicks();
        var fireSound = this.getWeaponItemData().getFireSound().get();

        if (!level.isClientSide) {
            player.getCooldowns().addCooldown(this, fireRateInTicks);
        }

        level.playSound(player, player.blockPosition(), fireSound, SoundSource.PLAYERS);

        return super.use(level, player, interactionHand);
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
