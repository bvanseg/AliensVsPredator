package org.avp.packets.server;

import org.avp.DamageSources;
import org.avp.block.BlockHiveResin;
import org.avp.item.ItemFirearm;
import org.avp.item.ItemFirearm.FirearmProfile;
import org.avp.world.hives.HiveHandler;

import com.asx.mdx.lib.world.entity.Entities;

import io.netty.buffer.ByteBuf;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketFirearmSync implements IMessage, IMessageHandler<PacketFirearmSync, PacketFirearmSync>
{
    public int hitType;
    public int entityId;
    public int hitX;
    public int hitY;
    public int hitZ;
    public int firearmId;

    public PacketFirearmSync()
    {
        ;
    }

    public PacketFirearmSync(RayTraceResult.Type hitType, Entity entity, int hitX, int hitY, int hitZ, FirearmProfile firearm)
    {
        this.hitType = hitType.ordinal();
        this.entityId = entity != null ? entity.getEntityId() : -1;
        this.hitX = hitX;
        this.hitY = hitY;
        this.hitZ = hitZ;
        this.firearmId = firearm.getGlobalId();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.hitType = buf.readInt();
        this.entityId = buf.readInt();
        this.hitX = buf.readInt();
        this.hitY = buf.readInt();
        this.hitZ = buf.readInt();
        this.firearmId = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.hitType);
        buf.writeInt(this.entityId);
        buf.writeInt(this.hitX);
        buf.writeInt(this.hitY);
        buf.writeInt(this.hitZ);
        buf.writeInt(this.firearmId);
    }

    @Override
    public PacketFirearmSync onMessage(PacketFirearmSync packet, MessageContext ctx)
    {
        ctx.getServerHandler().player.getServerWorld().addScheduledTask(new Runnable()
        {
            @Override
            public void run()
            {
                if (ctx.getServerHandler().player.getHeldItemMainhand() != null)
                {
                    EntityPlayer player = ctx.getServerHandler().player;
                    World world = player.world;
                    RayTraceResult.Type hitType = Entities.getMovingObjectType(packet.hitType);
                    
                    ItemFirearm itemFirearm = null;
                    if(ctx.getServerHandler().player.getHeldItemMainhand().getItem() instanceof ItemFirearm)
                        itemFirearm = (ItemFirearm) ctx.getServerHandler().player.getHeldItemMainhand().getItem();
                    else if(ctx.getServerHandler().player.getHeldItemOffhand().getItem() instanceof ItemFirearm)
                            itemFirearm = (ItemFirearm) ctx.getServerHandler().player.getHeldItemOffhand().getItem();
                    
                    FirearmProfile firearm = ItemFirearm.getFirearmForGlobalId(packet.firearmId);

                    if (itemFirearm != null && itemFirearm.canSoundPlay())
                    {
                        world.playSound(player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), firearm.getSound().event(), SoundCategory.PLAYERS, 1F, 1F, true);
                        itemFirearm.setLastSoundPlayed(System.currentTimeMillis());
                    }

                    if (hitType == RayTraceResult.Type.ENTITY)
                    {
                        if (packet.entityId != -1)
                        {
                            Entity entity = ctx.getServerHandler().player.world.getEntityByID(packet.entityId);

                            if (entity != null)
                            {
                                entity.hurtResistantTime = 0;
                                entity.attackEntityFrom(DamageSources.causeBulletDamage(ctx.getServerHandler().player), firearm.getClassification().getBaseDamage());
                            }
                        }
                    }

                    if (hitType == RayTraceResult.Type.BLOCK)
                    {
                        int targetX = packet.hitX;
                        int targetY = packet.hitY;
                        int targetZ = packet.hitZ;
                        int blockIndex = targetX * targetY * targetZ;
                        BlockPos pos = new BlockPos(packet.hitX, packet.hitY, packet.hitZ);
                        IBlockState blockstate = world.getBlockState(pos);
                        Block target = blockstate.getBlock();
                        float hardness = 1F / blockstate.getBlockHardness(world, pos) / 100F;

                        itemFirearm.setBreakProgress(itemFirearm.getBreakProgress() + hardness);

                        if (blockIndex != itemFirearm.getBlockBreakingIndex())
                        {
                            itemFirearm.setBreakProgress(0F);
                        }

                        world.sendBlockBreakProgress(blockIndex, pos, (int) (itemFirearm.getBreakProgress() * 10.0F) - 1);

                        if (itemFirearm.getBreakProgress() >= 1F)
                        {

                            if (target != null && blockIndex == itemFirearm.getBlockBreakingIndex())
                            {
                                if (target instanceof BlockHiveResin)
                                {
                                    HiveHandler.breakResinAt(world, targetX, targetY, targetZ);
                                }
                                else
                                {
                                    target.breakBlock(world, pos, blockstate);
                                    world.setBlockToAir(pos);
                                }

                                // world.playAuxSFX(2001, targetX, targetY, targetZ, Block.getIdFromBlock(target));
                                itemFirearm.setBreakProgress(0F);
                            }
                        }
                        itemFirearm.setBlockBreakingIndex(blockIndex);
                    }
                }
            }
        });

        return null;
    }
}
