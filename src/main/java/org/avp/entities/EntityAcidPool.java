package org.avp.entities;

import java.util.ArrayList;
import java.util.HashSet;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.api.blocks.IAcidResistant;
import org.avp.entities.living.species.SpeciesAlien;

import com.google.common.base.Predicate;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
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

    private static final HashSet<Block> blockBlacklist = new HashSet<>();

    static
    {
    	blockBlacklist.add(Blocks.OBSIDIAN);
    	blockBlacklist.add(Blocks.BEDROCK);
    	blockBlacklist.add(Blocks.END_PORTAL_FRAME);
    	blockBlacklist.add(AliensVsPredator.blocks().industrialglass);
    	blockBlacklist.add(AliensVsPredator.blocks().industrialGlassSlab);
    	blockBlacklist.add(AliensVsPredator.blocks().industrialGlassStairs);
        blockBlacklist.add(AliensVsPredator.blocks().plastic);
        blockBlacklist.add(AliensVsPredator.blocks().plasticcircle);
        blockBlacklist.add(AliensVsPredator.blocks().plastictile);
        blockBlacklist.add(AliensVsPredator.blocks().plastictri);
        blockBlacklist.add(AliensVsPredator.blocks().engineerbrick0);
        blockBlacklist.add(AliensVsPredator.blocks().engineerbrick1);
        blockBlacklist.add(AliensVsPredator.blocks().engineerbrick2);
        blockBlacklist.add(AliensVsPredator.blocks().engineerbrick3);
        blockBlacklist.add(AliensVsPredator.blocks().engineercolumn1);
        blockBlacklist.add(AliensVsPredator.blocks().engineercolumn2);
        blockBlacklist.add(AliensVsPredator.blocks().engineerfloor);
        blockBlacklist.add(AliensVsPredator.blocks().engineergravel);
        blockBlacklist.add(AliensVsPredator.blocks().engineermaterial0);
        blockBlacklist.add(AliensVsPredator.blocks().engineermaterial1);
        blockBlacklist.add(AliensVsPredator.blocks().engineermaterial2);
        blockBlacklist.add(AliensVsPredator.blocks().engineerrock0);
        blockBlacklist.add(AliensVsPredator.blocks().engineerrock1);
        blockBlacklist.add(AliensVsPredator.blocks().engineerrock2);
        blockBlacklist.add(AliensVsPredator.blocks().engineerrock3);
        blockBlacklist.add(AliensVsPredator.blocks().engineerwall0);
        blockBlacklist.add(AliensVsPredator.blocks().engineerwall1);
        blockBlacklist.add(AliensVsPredator.blocks().engineerwall2);
        blockBlacklist.add(AliensVsPredator.blocks().engineerwall3);
        blockBlacklist.add(AliensVsPredator.blocks().engineerwall4);
    }

    public EntityAcidPool(World world)
    {
        super(world);
        this.isImmuneToFire = false;
        this.ignoreFrustumCheck = true;
        this.setSize(1.65F, 0.09F);
    }

    private static final Predicate<EntityLivingBase> SELECTOR = (EntityLivingBase living) -> {
	    if (living instanceof SpeciesAlien)
	    	return false;
	    if (living instanceof EntityPlayer && ((EntityPlayer)living).capabilities.isCreativeMode)
	    	return false;

        return true;
    };

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        if (!this.world.isRemote)
        {
            damageNearbyEntities();
        }

        if (world.isRemote && world.getTotalWorldTime() % 10 <= 0)
        {
            this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX + this.rand.nextDouble(), this.posY + this.rand.nextDouble(), this.posZ + this.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
        }
        
        breakBlock();
    }

	private void breakBlock() {
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

                if (this.breakProgress >= 1F && block != Blocks.AIR)
                {
                    this.world.destroyBlock(pos, true);
                    this.breakProgress = 0;
                }
            }
        }
	}

	private void damageNearbyEntities() {
		ArrayList<EntityLivingBase> entityItemList = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(this.posX - 1, this.posY, this.posZ - 1, this.posX + 1, this.posY + 1, this.posZ + 1));

		entityItemList.forEach(e -> {
		    if(SELECTOR.apply(e))
		    {
		        e.addPotionEffect(new PotionEffect(MobEffects.POISON, (14 * 20), 0));
		        e.attackEntityFrom(DamageSources.acid, 4f);
		    }
		});
	}
}
