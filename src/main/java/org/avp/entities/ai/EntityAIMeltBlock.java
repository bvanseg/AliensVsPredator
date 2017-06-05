package org.avp.entities.ai;

import java.util.ArrayList;
import java.util.Arrays;

import org.avp.AliensVsPredator;
import org.avp.api.blocks.IAcidResistant;

import com.arisux.mdx.lib.game.GameSounds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.EnumDifficulty;

public class EntityAIMeltBlock extends EntityAIYOffsetBlockInteract
{
    private static final ArrayList<Block> blockBlacklist = new ArrayList<Block>();
    private EntityLiving                  theEntity;
    private float                         breakProgress  = -1;

    public EntityAIMeltBlock(EntityLiving theEntity)
    {
        this(theEntity, 0);
    }

    public EntityAIMeltBlock(EntityLiving theEntity, int yOffset)
    {
        super(theEntity, yOffset);
        this.theEntity = theEntity;
        this.yOffset = yOffset;
        blacklist(Blocks.OBSIDIAN);
        blacklist(Blocks.BEDROCK);
        blacklist(Blocks.END_PORTAL_FRAME);
        blacklist(AliensVsPredator.blocks().industrialGlassShapes);
        blacklist(AliensVsPredator.blocks().blockIndustrialGlass);
        blacklist(AliensVsPredator.blocks().blockIndustrialGlassSlab);
        blacklist(AliensVsPredator.blocks().blockIndustrialGlassStairs);
        blacklist(AliensVsPredator.blocks().plasticShapes);
        blacklist(AliensVsPredator.blocks().plasticCircleShapes);
        blacklist(AliensVsPredator.blocks().plasticTileShapes);
        blacklist(AliensVsPredator.blocks().plasticTriShapes);
        blacklist(AliensVsPredator.blocks().engineerShipBrick0Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipBrick1Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipBrick2Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipBrick3Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipColumn1Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipColumn2Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipFloorShapes);
        blacklist(AliensVsPredator.blocks().engineerShipGravelShapes);
        blacklist(AliensVsPredator.blocks().engineerShipMaterial0Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipMaterial1Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipMaterial2Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipRock0Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipRock1Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipRock2Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipRock3Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipWall0Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipWall1Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipWall2Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipWall3Shapes);
        blacklist(AliensVsPredator.blocks().engineerShipWall4Shapes);
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

    @Override
    public boolean shouldExecute()
    {
        return this.theEntity.world.getGameRules().getBoolean("mobGriefing");
    }

    @Override
    public void startExecuting()
    {
        super.startExecuting();
    }

    @Override
    public boolean continueExecuting()
    {
        return (this.theEntity.world.getDifficulty() == EnumDifficulty.NORMAL || this.theEntity.world.getDifficulty() == EnumDifficulty.HARD) && this.theEntity.getDistanceSq((int) this.theEntity.posX, (int) this.theEntity.posY + yOffset, (int) this.theEntity.posZ) < 4.0D && block != Blocks.AIR && block != AliensVsPredator.blocks().terrainHiveResin && block != Blocks.BEDROCK;
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        this.breakProgress = 0F;
    }

    @Override
    public void updateTask()
    {
        super.updateTask();
        
        BlockPos pos = new BlockPos((int) Math.floor(this.theEntity.posX), (int) this.theEntity.posY - 1, (int) Math.floor(this.theEntity.posZ));
        IBlockState blockstate = this.theEntity.world.getBlockState(pos);
        Block destroy = blockstate.getBlock();
        float hardness = 1F / blockstate.getBlockHardness(this.theEntity.world, pos) / 100F;

        if (this.theEntity.getRNG().nextInt(20) == 0)
        {
            GameSounds.fxMinecraftFizz.playSound(this.theEntity.world, this.theEntity.getPosition(), 1F, 1F);
        }

        if (blockBlacklist.contains(destroy) || destroy instanceof IAcidResistant && ((IAcidResistant) destroy).canAcidDestroy(this.theEntity.world, pos, this.theEntity))
        {
            return;
        }

        this.breakProgress += hardness;
        //this.theEntity.world.destroyBlockInWorldPartially(this.theEntity.getEntityId(), (int) Math.floor(this.theEntity.posX), (int) this.theEntity.posY + yOffset, (int) Math.floor(this.theEntity.posZ), (int) (this.breakProgress * 10.0F) - 1);

        if (this.breakProgress >= 1F)
        {
            if (block != Blocks.AIR)
            {
                this.theEntity.world.destroyBlock(pos, true);
                //this.theEntity.world.playAuxSFX(2001, (int) Math.floor(this.theEntity.posX), (int) this.theEntity.posY + yOffset, (int) Math.floor(this.theEntity.posZ), Block.getIdFromBlock(this.block));
                this.resetTask();
            }
        }
    }
}
