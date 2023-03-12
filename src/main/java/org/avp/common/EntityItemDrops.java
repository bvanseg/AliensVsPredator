package org.avp.common;

import com.asx.mdx.lib.world.entity.ItemDrop;
import com.asx.mdx.lib.world.entity.ItemDrop.DropType;

import net.minecraft.item.ItemStack;
import org.alien.AlienBlocks;
import org.avp.AVP;
import org.predator.PredatorBlocks;

public class EntityItemDrops
{
    private static final ItemHandler items = AVP.items();

    public static final ItemDrop ROYAL_JELLY_GENERIC = new ItemDrop(100, new ItemStack(items.itemRoyalJelly, 4));
    public static final ItemDrop ROYAL_JELLY_SINGLE = new ItemDrop(100, new ItemStack(items.itemRoyalJelly, 1));
    public static final ItemDrop NBT_DRIVE = new ItemDrop(50, new ItemStack(items.itemFlashDrive));
    public static final ItemDrop PHIAL = new ItemDrop(50, new ItemStack(items.itemPhial));
    public static final ItemDrop PHIAL_EMPTY = new ItemDrop(50, new ItemStack(items.itemPhialEmpty));
    public static final ItemDrop XENO_HELM = new ItemDrop(5, new ItemStack(items.helmXeno));
    public static final ItemDrop XENO_TORSO = new ItemDrop(5, new ItemStack(items.plateXeno));
    public static final ItemDrop XENO_LEGS = new ItemDrop(5, new ItemStack(items.legsXeno));
    public static final ItemDrop XENO_FEET = new ItemDrop(5, new ItemStack(items.bootsXeno));
    public static final ItemDrop SKULL_ENGINEER = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_ENGINEER));
    public static final ItemDrop SKULL_SPACEJOCKEY = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_JOCKEY));
    public static final ItemDrop SKULL_XENO_DRONE = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_XENO));
    public static final ItemDrop SKULL_XENO_WARRIOR = new ItemDrop(1, new ItemStack(AlienBlocks.SKULL_XENO_WARRIOR));
    public static final ItemDrop SKULL_PREDATOR = new ItemDrop(1, new ItemStack(PredatorBlocks.SKULL_YAUTJA));
    public static final ItemDrop SKULL_AETHON = new ItemDrop(1, new ItemStack(AlienBlocks.HEAD_AETHON));
    public static final ItemDrop HEAD_GIGER = new ItemDrop(1, new ItemStack(AlienBlocks.HEAD_GIGER_ALIEN));
    public static final ItemDrop SKULLS_XENO = new ItemDrop(1, DropType.RATE_PERDROP_SINGLE, new ItemStack(AlienBlocks.SKULL_XENO_WARRIOR), new ItemStack(AlienBlocks.SKULL_XENO));
    public static final ItemDrop PREDATOR_ARTIFACT = new ItemDrop(25, new ItemStack(items.itemArtifactTech));
    public static final ItemDrop PLASMACANNON = new ItemDrop(2, new ItemStack(items.itemPlasmaCannon));
    public static final ItemDrop WRISTBRACER = new ItemDrop(2, new ItemStack(items.itemWristbracer));
    public static final ItemDrop WRISTBRACER_BLADES = new ItemDrop(7, new ItemStack(items.itemWristbracerBlades));
    public static final ItemDrop SHURIKEN = new ItemDrop(7, new ItemStack(items.itemShuriken));
    public static final ItemDrop SILICON = new ItemDrop(25, new ItemStack(items.itemSilicon));
    public static final ItemDrop BIOMASK = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_CLASSIC));
    public static final ItemDrop BIOMASK_BERSERKER = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_BERSERKER));
    public static final ItemDrop BIOMASK_FALCONER = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_FALCONER));
    public static final ItemDrop BIOMASK_TRACKER = new ItemDrop(3, new ItemStack(PredatorBlocks.BIOMASK_TRACKER));
    public static final ItemDrop AMMUNITION = new ItemDrop(75, DropType.RATE_PERSTACK_MULTIPLE, new ItemStack(items.itemAmmoAR), new ItemStack(items.itemAmmoPistol), new ItemStack(items.itemAmmoSMG), new ItemStack(items.itemAmmoSniper));
    public static final ItemDrop FIREARMS = new ItemDrop(15, DropType.RATE_PERSTACK_SINGLE, new ItemStack(items.itemM56SG), new ItemStack(items.itemPistol), new ItemStack(items.itemM4), new ItemStack(items.itemM41A), new ItemStack(items.itemSniper));
}
