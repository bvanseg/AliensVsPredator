package org.avp.common;

import com.asx.mdx.lib.world.entity.ItemDrop;
import com.asx.mdx.lib.world.entity.ItemDrop.DropType;
import net.minecraft.item.ItemStack;
import org.alien.common.AlienBlocks;
import org.alien.common.AlienItems;
import org.predator.common.PredatorBlocks;
import org.predator.common.PredatorItems;

public class EntityItemDrops
{
    public static final ItemDrop ROYAL_JELLY_GENERIC = new ItemDrop(100, new ItemStack(AlienItems.ITEM_ROYAL_JELLY, 4));
    public static final ItemDrop ROYAL_JELLY_SINGLE = new ItemDrop(100, new ItemStack(AlienItems.ITEM_ROYAL_JELLY, 1));
    public static final ItemDrop NBT_DRIVE = new ItemDrop(50, new ItemStack(AVPItems.ITEM_FLASH_DRIVE));
    public static final ItemDrop PHIAL = new ItemDrop(50, new ItemStack(AlienItems.ITEM_PHIAL));
    public static final ItemDrop PHIAL_EMPTY = new ItemDrop(50, new ItemStack(AlienItems.ITEM_PHIAL_EMPTY));
    public static final ItemDrop XENO_HELM = new ItemDrop(5, new ItemStack(AlienItems.HELM_XENO));
    public static final ItemDrop XENO_TORSO = new ItemDrop(5, new ItemStack(AlienItems.PLATE_XENO));
    public static final ItemDrop XENO_LEGS = new ItemDrop(5, new ItemStack(AlienItems.LEGS_XENO));
    public static final ItemDrop XENO_FEET = new ItemDrop(5, new ItemStack(AlienItems.BOOTS_XENO));
    public static final ItemDrop SKULL_ENGINEER = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_ENGINEER));
    public static final ItemDrop SKULL_SPACEJOCKEY = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_JOCKEY));
    public static final ItemDrop SKULL_XENO_DRONE = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_XENO));
    public static final ItemDrop SKULL_XENO_WARRIOR = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_XENO_WARRIOR));
    public static final ItemDrop SKULL_PREDATOR = new ItemDrop(1, new ItemStack(PredatorBlocks.SKULL_YAUTJA));
    public static final ItemDrop SKULL_AETHON = new ItemDrop(1, new ItemStack(AlienBlocks.HEAD_AETHON));
    public static final ItemDrop HEAD_GIGER = new ItemDrop(1, new ItemStack(AlienBlocks.HEAD_GIGER_ALIEN));
    public static final ItemDrop SKULLS_XENO = new ItemDrop(1, DropType.RATE_PERDROP_SINGLE, new ItemStack(AlienBlocks.SKULL_XENO_WARRIOR), new ItemStack(AlienBlocks.SKULL_XENO));
    public static final ItemDrop PREDATOR_ARTIFACT = new ItemDrop(25, new ItemStack(PredatorItems.ITEM_ARTIFACT_TECH));
    public static final ItemDrop PLASMACANNON = new ItemDrop(2, new ItemStack(PredatorItems.ITEM_PLASMA_CANNON));
    public static final ItemDrop WRISTBRACER = new ItemDrop(2, new ItemStack(PredatorItems.ITEM_WRISTBRACER));
    public static final ItemDrop WRISTBRACER_BLADES = new ItemDrop(7, new ItemStack(PredatorItems.ITEM_WRISTBRACER_BLADES));
    public static final ItemDrop SHURIKEN = new ItemDrop(7, new ItemStack(PredatorItems.ITEM_SHURIKEN));
    public static final ItemDrop SILICON = new ItemDrop(25, new ItemStack(AVPItems.ITEM_SILICON));
    public static final ItemDrop BIOMASK = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_CLASSIC));
    public static final ItemDrop BIOMASK_BERSERKER = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_BERSERKER));
    public static final ItemDrop BIOMASK_FALCONER = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_FALCONER));
    public static final ItemDrop BIOMASK_TRACKER = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_TRACKER));
    public static final ItemDrop AMMUNITION = new ItemDrop(75, DropType.RATE_PERSTACK_MULTIPLE, new ItemStack(AVPItems.ITEM_AMMO_AR), new ItemStack(AVPItems.ITEM_AMMO_PISTOL), new ItemStack(AVPItems.ITEM_AMMO_SMG), new ItemStack(AVPItems.ITEM_AMMO_SNIPER));
    public static final ItemDrop FIREARMS = new ItemDrop(15, DropType.RATE_PERSTACK_SINGLE, new ItemStack(AVPItems.ITEM_M56SG), new ItemStack(AVPItems.ITEM_PISTOL), new ItemStack(AVPItems.ITEM_M4), new ItemStack(AVPItems.ITEM_M41A), new ItemStack(AVPItems.ITEM_SNIPER));
}
