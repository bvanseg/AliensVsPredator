package org.avp.entities;

import java.util.ArrayList;
import java.util.Arrays;

import javax.annotation.Nullable;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.api.blocks.IAcidResistant;
import org.avp.entities.living.species.SpeciesAlien;
import com.google.common.base.Predicate;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
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
            if (living instanceof EntityPlayer && ((EntityPlayer)living).capabilities.isCreativeMode)
            {
                return false;
            }
            else if (living instanceof SpeciesAlien)
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
    public boolean isInRangeToRenderDist(double range)
    {
        return true;
    }
    
    public float getAcidIntensity()
    {
        return 1F - (1F / this.getLifetime() / (1F / this.ticksExisted));
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        ArrayList<EntityLivingBase> entityItemList = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(this.posX - 1, this.posY, this.posZ - 1, this.posX + 1, this.posY + 1, this.posZ + 1));

        if (!this.world.isRemote && !entityItemList.isEmpty())
        {
            entityItemList.forEach(e -> {
                if(SELECTOR.apply(e))
                {
                    e.addPotionEffect(new PotionEffect(MobEffects.POISON, (14 * 20), 0));
                    e.attackEntityFrom(DamageSources.acid, 4f);
                }
            });
        }

        if (world.isRemote && world.getTotalWorldTime() % 10 <= 0)
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + this.rand.nextDouble(), this.posY + this.rand.nextDouble(), this.posZ + this.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
        
        if (this.world.getGameRules().getBoolean("mobGriefing"))
        {
            if ((this.world.getDifficulty() == EnumDifficulty.NORMAL || this.world.getDifficulty() == EnumDifficulty.HARD) && this.getDistanceSq((int) this.posX, (int) this.posY + yOffset, (int) this.posZ) < 4.0D && block != Blocks.AIR && block != AliensVsPredator.blocks().naturalResin && block != Blocks.BEDROCK)
            {
                BlockPos pos = new BlockPos((int) Math.floor(this.posX), (int) this.posY - 1, (int) Math.floor(this.posZ));
                IBlockState blockstate = this.world.getBlockState(pos);
                Block destroy = blockstate.getBlock();
                float hardness = 1F / blockstate.getBlockHardness(this.world, pos) / 100F;

                if (this.rand.nextInt(20) == 0)
                {
                    //GameSounds.fxMinecraftFizz.playSound(this.world, this.getPosition(), 1F, 1F);
                    // FIXME: This crashes the game, we can't access sounds through raw resource locations.
                }

                if (blockBlacklist.contains(destroy) || destroy instanceof IAcidResistant && ((IAcidResistant) destroy).canAcidDestroy(this.world, pos, this))
                {
                    return;
                }

                this.breakProgress += hardness;

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

    public int getLifetime()
    {
        return lifetime;
    }
}
