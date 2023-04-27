package org.alien.common.entity;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import org.alien.common.block.init.AlienBlocks;
import org.alien.common.block.init.AlienEngineerBlocks;
import org.alien.common.entity.ai.selector.EntitySelectorAcidPool;
import org.alien.common.item.ItemArmorXeno;
import org.alien.common.potion.AlienPotions;
import org.avp.common.AVPDamageSources;
import org.avp.common.api.blocks.AcidResistant;
import org.avp.common.block.init.AVPBlocks;
import org.avp.common.block.init.AVPSlabBlocks;
import org.avp.common.block.init.AVPStairBlocks;
import org.avp.common.entity.EntityLiquidPool;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.PacketSyncEntitySize;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class EntityAcidPool extends EntityLiquidPool
{
    private static final HashSet<Block> BLOCK_DENYLIST = new HashSet<>();

    static
    {
        BLOCK_DENYLIST.add(Blocks.OBSIDIAN);
        BLOCK_DENYLIST.add(Blocks.BEDROCK);
        BLOCK_DENYLIST.add(Blocks.END_PORTAL_FRAME);
        BLOCK_DENYLIST.add(AVPBlocks.INDUSTRIAL_GLASS);
        BLOCK_DENYLIST.add(AVPSlabBlocks.INDUSTRIAL_GLASS_SLAB_HALF);
        BLOCK_DENYLIST.add(AVPStairBlocks.INDUSTRIAL_GLASS_STAIRS);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC_CIRCLE);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC_TILE);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC_TRI);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_BRICK_0);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_BRICK_1);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_BRICK_2);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_BRICK_3);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_COLUMN_1);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_COLUMN_2);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_FLOOR);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_GRAVEL);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_MATERIAL_0);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_MATERIAL_1);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_MATERIAL_2);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_ROCK_0);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_ROCK_1);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_ROCK_2);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_ROCK_3);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_WALL_0);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_WALL_1);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_WALL_2);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_WALL_3);
        BLOCK_DENYLIST.add(AlienEngineerBlocks.ENGINEER_WALL_4);
    }

    private float breakProgress = -1;
    protected int yOffset;
    protected Block block;

    private boolean isPushing;

    public EntityAcidPool(World world)
    {
        super(world);
        this.isImmuneToFire = false;
        this.ignoreFrustumCheck = true;
        this.setSize(1.65F, 0.09F);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            List<Entity> nearbyEntities = this.getNearbyEntities();
            this.mergeWithNearbyAcidPools(nearbyEntities);

            if (this.isPushing) {
                this.damageNearbyEntities(nearbyEntities);
                this.isPushing = false;
            }

            breakBlock();
        }

        if (world.isRemote && world.getTotalWorldTime() % 10 <= 0)
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + this.rand.nextDouble(), this.posY + this.rand.nextDouble(), this.posZ + this.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }

    }

    private void breakBlock() {
        if (!this.world.getGameRules().getBoolean("mobGriefing")) return;
        if ((this.world.getDifficulty() != EnumDifficulty.NORMAL && this.world.getDifficulty() != EnumDifficulty.HARD)) return;

        boolean isWithinDistance = this.getDistanceSq((int) this.posX, (int) (this.posY + yOffset), (int) this.posZ) < 4.0D;

        if (!isWithinDistance) return;

        boolean isOnValidBlock = block != Blocks.AIR && block != AlienBlocks.NATURAL_RESIN && block != Blocks.BEDROCK;

        if (!isOnValidBlock) return;

        BlockPos pos = new BlockPos((int) Math.floor(this.posX), (int) this.posY - 1, (int) Math.floor(this.posZ));
        IBlockState blockState = this.world.getBlockState(pos);
        Block destroy = blockState.getBlock();
        float hardness = 1F / blockState.getBlockHardness(this.world, pos) / 100F;

        if (this.rand.nextInt(20) == 0)
        {
            this.world.playSound(null, this.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 1F, 1F);
        }

        if (BLOCK_DENYLIST.contains(destroy) || destroy instanceof AcidResistant && ((AcidResistant) destroy).canAcidDestroy(this.world, pos, this))
        {
            return;
        }

        this.breakProgress += hardness;

        if (this.breakProgress >= 1F && block != Blocks.AIR)
        {
            this.world.destroyBlock(pos, true);
            this.breakProgress = 0;
        }
	}

    private void mergePools(EntityAcidPool other) {
        if (other == null ||
            other == this || // Do not merge with self
            other.isDead || // Do not merge if dead
            other.width > this.width
        )
            return;

        this.setLifetime(this.lifetime + other.lifetime);

        float newWidth = (this.width + other.width) / 1.5F;
        this.setSize(newWidth, this.height);

        // Entity bounding box changes do not automatically sync, so we must synchronize all clients with the changed box.
        AVPNetworking.instance.sendToAll(new PacketSyncEntitySize(this, newWidth, this.height));

        other.setDead();
    }

    private ArrayList<Entity> getNearbyEntities() {
        float radialWidth = (this.width / 2);
        AxisAlignedBB aabb = new AxisAlignedBB(
            this.posX - radialWidth,
            this.posY - this.height,
            this.posZ - radialWidth,

            this.posX + radialWidth,
            this.posY + this.height,
            this.posZ + radialWidth
        );
        return (ArrayList<Entity>) world.getEntitiesWithinAABB(Entity.class, aabb);
    }

    private void mergeWithNearbyAcidPools(List<Entity> entityList) {
        entityList.forEach(entity -> {
            if (entity instanceof EntityAcidPool) {
                this.mergePools((EntityAcidPool) entity);
            }
        });
    }

    private void damageNearbyEntities(List<Entity> entityList) {
        entityList.forEach(entity -> {
            if (!(entity instanceof EntityLivingBase)) {
                return;
            }

            EntityLivingBase livingEntity = (EntityLivingBase) entity;

            if (EntitySelectorAcidPool.instance.test(livingEntity)) {
                livingEntity.addPotionEffect(new PotionEffect(AlienPotions.ACID, (14 * 20), 0));

                // Try and damage player boots rapidly while the player is standing in acid.
                if (livingEntity instanceof EntityPlayer && this.tryDamageBoots((EntityPlayer) livingEntity)) {
                    return;
                }

                livingEntity.attackEntityFrom(AVPDamageSources.ACID, 4f);
            }
        });
    }

    private boolean tryDamageBoots(EntityPlayer player) {
        ItemStack bootsStack = Inventories.getBootSlotItemStack(player);

        if (!bootsStack.isEmpty() &&
                bootsStack != ItemStack.EMPTY &&
                bootsStack.getItem() instanceof ItemArmor &&
                !(bootsStack.getItem() instanceof ItemArmorXeno)
        ) {
            if (this.world.getTotalWorldTime() % 20 == 0) {
                bootsStack.damageItem(20, player);
                this.world.playSound(null, this.getPosition(), SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.NEUTRAL, 1F, 1F);
            }
            return true;
        }

        return false;
    }

    @Override
    public boolean canBePushed() {
        if (!this.world.isRemote) {
            this.isPushing = true;
        }
        return false;
    }
}
