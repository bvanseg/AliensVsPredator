package org.alien.common.entity;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import org.alien.common.AlienBlocks;
import org.alien.common.entity.ai.selector.EntitySelectorAcidPool;
import org.avp.common.block.init.AVPBlocks;
import org.avp.common.AVPDamageSources;
import org.avp.common.api.blocks.AcidResistant;
import org.avp.common.block.init.AVPSlabBlocks;
import org.avp.common.block.init.AVPStairBlocks;
import org.avp.common.entity.EntityLiquidPool;

import java.util.ArrayList;
import java.util.HashSet;

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
        BLOCK_DENYLIST.add(AVPSlabBlocks.INDUSTRIAL_GLASS_SLAB_DOUBLE);
        BLOCK_DENYLIST.add(AVPStairBlocks.INDUSTRIAL_GLASS_STAIRS);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC_CIRCLE);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC_TILE);
        BLOCK_DENYLIST.add(AVPBlocks.PLASTIC_TRI);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_BRICK_0);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_BRICK_1);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_BRICK_2);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_BRICK_3);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_COLUMN_1);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_COLUMN_2);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_FLOOR);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_GRAVEL);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_MATERIAL_0);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_MATERIAL_1);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_MATERIAL_2);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_ROCK_0);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_ROCK_1);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_ROCK_2);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_ROCK_3);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_WALL_0);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_WALL_1);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_WALL_2);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_WALL_3);
        BLOCK_DENYLIST.add(AlienBlocks.ENGINEER_WALL_4);
    }

    private float                         breakProgress  = -1;
    protected int                         yOffset;
    protected Block                       block;

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
            if (this.isPushing) {
                damageNearbyEntities();
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

    private void damageNearbyEntities() {
        ArrayList<EntityLivingBase> entityItemList = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(this.posX - 1, this.posY, this.posZ - 1, this.posX + 1, this.posY + 1, this.posZ + 1));

        entityItemList.forEach(livingEntity -> {
            if (EntitySelectorAcidPool.instance.test(livingEntity)) {
                livingEntity.addPotionEffect(new PotionEffect(MobEffects.POISON, (14 * 20), 0));
                livingEntity.attackEntityFrom(AVPDamageSources.ACID, 4f);
            }
        });
    }

    @Override
    public boolean canBePushed() {
        if (!this.world.isRemote) {
            this.isPushing = true;
        }
        return false;
    }
}
