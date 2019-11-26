package org.avp.entities;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Nullable;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.api.blocks.IAcidResistant;
import org.avp.entities.living.species.SpeciesAlien;

import com.asx.mdx.lib.util.GameSounds;
import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityAcidPool extends EntityLiquidPool
{

    private float                         breakProgress  = -1;
    protected int                         yOffset;
    protected Block                       block;

    private static final ArrayList<Block> blockBlacklist = new ArrayList<Block>();

    static
    {
        blacklist(Blocks.OBSIDIAN);
        blacklist(Blocks.BEDROCK);
        blacklist(Blocks.END_PORTAL_FRAME);
        blacklist(AliensVsPredator.blocks().industrialglass);
        blacklist(AliensVsPredator.blocks().industrialGlassSlab);
        blacklist(AliensVsPredator.blocks().industrialGlassStairs);
        blacklist(AliensVsPredator.blocks().plastic);
        blacklist(AliensVsPredator.blocks().plasticcircle);
        blacklist(AliensVsPredator.blocks().plastictile);
        blacklist(AliensVsPredator.blocks().plastictri);
        blacklist(AliensVsPredator.blocks().engineerbrick0);
        blacklist(AliensVsPredator.blocks().engineerbrick1);
        blacklist(AliensVsPredator.blocks().engineerbrick2);
        blacklist(AliensVsPredator.blocks().engineerbrick3);
        blacklist(AliensVsPredator.blocks().engineercolumn1);
        blacklist(AliensVsPredator.blocks().engineercolumn2);
        blacklist(AliensVsPredator.blocks().engineerfloor);
        blacklist(AliensVsPredator.blocks().engineergravel);
        blacklist(AliensVsPredator.blocks().engineermaterial0);
        blacklist(AliensVsPredator.blocks().engineermaterial1);
        blacklist(AliensVsPredator.blocks().engineermaterial2);
        blacklist(AliensVsPredator.blocks().engineerrock0);
        blacklist(AliensVsPredator.blocks().engineerrock1);
        blacklist(AliensVsPredator.blocks().engineerrock2);
        blacklist(AliensVsPredator.blocks().engineerrock3);
        blacklist(AliensVsPredator.blocks().engineerwall0);
        blacklist(AliensVsPredator.blocks().engineerwall1);
        blacklist(AliensVsPredator.blocks().engineerwall2);
        blacklist(AliensVsPredator.blocks().engineerwall3);
        blacklist(AliensVsPredator.blocks().engineerwall4);
    }

    public EntityAcidPool(World world)
    {
        super(world);
        this.isImmuneToFire = false;
        this.ignoreFrustumCheck = true;
        this.setSize(1.65F, 0.09F);

    }

    public static Block blacklist(Block block)
    {
        blockBlacklist.add(block);
        return block;
    }

    public static Block[] blacklist(Block[] blocks)
    {
        for (Block block : new ArrayList<Block>(Arrays.asList(blocks)))
        {
            blockBlacklist.add(block);

        }
        return blocks;
    }

    private static final Predicate<EntityLivingBase> SELECTOR = new Predicate<EntityLivingBase>() {
        @Override
        public boolean apply(@Nullable EntityLivingBase living)
        {
            if (living instanceof SpeciesAlien)
            {
                return false;
            }

            return true;
        }
    };

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return false;
    }

    @Override
    public boolean canBePushed()
    {
        return false;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean isInRangeToRenderDist(double range)
    {
        return true;
    }

    @Override
    public void applyEntityCollision(Entity target)
    {
        if (!this.world.isRemote && target instanceof EntityLivingBase)
        {
            if (target != null && SELECTOR.apply((EntityLivingBase) target))
            {
                target.attackEntityFrom(DamageSources.acid, 4F);
            }
        }
    }

    public float getAcidIntensity()
    {
        return 1F - (1F / this.getLifetime() / (1F / this.ticksExisted));
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();


        if (world.isRemote && world.getTotalWorldTime() % 4 <= 0)
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + this.rand.nextDouble(), this.posY + this.rand.nextDouble(), this.posZ + this.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
        
        if (this.world.getGameRules().getBoolean("mobGriefing"))
        {
            System.out.println(this.breakProgress);
            if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) && this.getDistanceSq((int) this.posX, (int) this.posY + yOffset, (int) this.posZ) < 4.0D && block != Blocks.AIR && block != AliensVsPredator.blocks().naturalResin && block != Blocks.BEDROCK)
            {
                BlockPos pos = new BlockPos((int) Math.floor(this.posX), (int) this.posY - 1, (int) Math.floor(this.posZ));
                IBlockState blockstate = this.world.getBlockState(pos);
                Block destroy = blockstate.getBlock();
                float hardness = 1F / blockstate.getBlockHardness(this.world, pos) / 100F;

                if (this.rand.nextInt(20) == 0)
                {
                    GameSounds.fxMinecraftFizz.playSound(this.world, this.getPosition(), 1F, 1F);
                }

                if (blockBlacklist.contains(destroy) || destroy instanceof IAcidResistant && ((IAcidResistant) destroy).canAcidDestroy(this.world, pos, this))
                {
                    return;
                }

                this.breakProgress += hardness;
                // this.theEntity.world.destroyBlockInWorldPartially(this.theEntity.getEntityId(),
                // (int) Math.floor(this.theEntity.posX), (int) this.theEntity.posY + yOffset,
                // (int) Math.floor(this.theEntity.posZ), (int) (this.breakProgress * 10.0F) -
                // 1);

                if (this.breakProgress >= 1F)
                {
                    if (block != Blocks.AIR)
                    {
                        this.world.destroyBlock(pos, true);
                        this.breakProgress = 0;
                    }
                }
            }
        }
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer player)
    {
        if (!this.world.isRemote)
        {
            if (!player.capabilities.isCreativeMode)
            {
                player.addPotionEffect(new PotionEffect(MobEffects.POISON, (14 * 20), 0));
            }
        }
    }

    public int getLifetime()
    {
        return lifetime;
    }
}
