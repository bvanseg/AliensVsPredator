package org.avp.client.render.entity.layer;

import com.asx.mdx.client.ClientGame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.item.init.AVPArmorItems;
import org.lib.common.inventory.InventorySnapshot;

/**
 * @author Boston Vanseghi
 */
public class LayerFollowIcon implements LayerRenderer<EntityMarine> {

    private static final ItemStack FOOD_ITEM_STACK = new ItemStack(Items.COOKED_BEEF, 1);
    private static final ItemStack STANDARD_FOLLOW_ITEM_STACK = new ItemStack(AVPArmorItems.HELM_MARINE, 1);
    private static final ItemStack STANDARD_GUARD_ITEM_STACK = new ItemStack(AVPArmorItems.BOOTS_MARINE, 1);

    @Override
    public void doRenderLayer(EntityMarine entityMarine, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (!entityMarine.getSquadLeader().isPresent() ||
                !entityMarine.getSquadLeader().get().getUniqueID().equals(ClientGame.instance.minecraft().player.getUniqueID())) return;

        GlStateManager.pushMatrix();
        GlStateManager.translate(0.0F, -0.9F, 0.0F);
        GlStateManager.rotate(-180.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.scale(0.8F, 0.8F, 0.8F);

        InventorySnapshot inventorySnapshot = entityMarine.getInventorySnapshot();

        ItemStack contextStack;

        if (this.marineNeedsAmmo(entityMarine, inventorySnapshot))
        {
            Item item = entityMarine.getMarineType().getFirearmItem().getFirearmProperties().getConsumablesForReload().stream().findFirst().get();
            contextStack = new ItemStack(item, 1);
        }
        else if (this.marineNeedsFood(entityMarine, inventorySnapshot))
        {
            contextStack = FOOD_ITEM_STACK;
        }
        else
        {
            if (entityMarine.isGuarding()) {
                contextStack = STANDARD_GUARD_ITEM_STACK;
            } else {
                contextStack = STANDARD_FOLLOW_ITEM_STACK;
            }
        }

        Minecraft.getMinecraft().getItemRenderer().renderItemSide(entityMarine, contextStack, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, false);

        GlStateManager.popMatrix();
    }

    private boolean marineNeedsFood(EntityMarine entityMarine, InventorySnapshot inventorySnapshot) {
        return entityMarine.getHealth() < entityMarine.getMaxHealth() && inventorySnapshot.getItemsMatchingPredicate(ItemFood.class::isInstance).isEmpty();
    }

    private boolean marineNeedsAmmo(EntityMarine entityMarine, InventorySnapshot inventorySnapshot) {
        return inventorySnapshot.getItemsMatchingPredicate(item -> entityMarine.getMarineType().getFirearmItem().getFirearmProperties().getConsumablesForReload().contains(item)).isEmpty();
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}