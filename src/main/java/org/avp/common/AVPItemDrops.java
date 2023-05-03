package org.avp.common;

import org.alien.common.AlienItems;
import org.alien.common.block.init.AlienSkullBlocks;
import org.avp.common.item.init.AVPItems;
import org.lib.common.inventory.ItemDrop;
import org.predator.common.PredatorItems;
import org.predator.common.block.init.PredatorBlocks;
import org.weapon.common.item.init.WeaponItems;

public class AVPItemDrops
{
    private AVPItemDrops() {}

    public static final ItemDrop ROYAL_JELLY = new ItemDrop.Builder(AlienItems.ITEM_ROYAL_JELLY).setMaximumDropAmount(4).build();
    public static final ItemDrop NBT_DRIVE = new ItemDrop.Builder(AVPItems.ITEM_FLASH_DRIVE).setDropWeight(50).build();

    public static final ItemDrop PHIAL = new ItemDrop.Builder(AlienItems.ITEM_PHIAL).setDropWeight(50).build();
    public static final ItemDrop PHIAL_EMPTY = new ItemDrop.Builder(AlienItems.ITEM_PHIAL_EMPTY).setDropWeight(50).build();

    public static final ItemDrop XENO_HELM = new ItemDrop.Builder(AlienItems.HELM_XENO).setDropWeight(5).build();
    public static final ItemDrop XENO_TORSO = new ItemDrop.Builder(AlienItems.PLATE_XENO).setDropWeight(5).build();
    public static final ItemDrop XENO_LEGS = new ItemDrop.Builder(AlienItems.LEGS_XENO).setDropWeight(5).build();
    public static final ItemDrop XENO_FEET = new ItemDrop.Builder(AlienItems.BOOTS_XENO).setDropWeight(5).build();

    public static final ItemDrop SKULL_ENGINEER = new ItemDrop.Builder(AlienSkullBlocks.SKULL_ENGINEER).setDropWeight(1).build();
    public static final ItemDrop SKULL_SPACEJOCKEY = new ItemDrop.Builder(AlienSkullBlocks.SKULL_JOCKEY).setDropWeight(1).build();
    public static final ItemDrop SKULL_XENO_DRONE = new ItemDrop.Builder(AlienSkullBlocks.SKULL_XENO).setDropWeight(1).build();
    public static final ItemDrop SKULL_XENO_WARRIOR = new ItemDrop.Builder(AlienSkullBlocks.SKULL_XENO_WARRIOR).setDropWeight(1).build();
    public static final ItemDrop SKULL_PREDATOR = new ItemDrop.Builder(PredatorBlocks.SKULL_YAUTJA).setDropWeight(1).build();
    public static final ItemDrop SKULL_AETHON = new ItemDrop.Builder(AlienSkullBlocks.HEAD_AETHON).setDropWeight(1).build();
    public static final ItemDrop HEAD_GIGER = new ItemDrop.Builder(AlienSkullBlocks.HEAD_GIGER_ALIEN).setDropWeight(1).build();

    public static final ItemDrop PREDATOR_ARTIFACT = new ItemDrop.Builder(PredatorItems.ITEM_ARTIFACT_TECH).setDropWeight(25).build();
    public static final ItemDrop PLASMACANNON = new ItemDrop.Builder(PredatorItems.ITEM_PLASMA_CANNON).setDropWeight(2).build();
    public static final ItemDrop WRISTBRACER = new ItemDrop.Builder(PredatorItems.ITEM_WRISTBRACER).setDropWeight(2).build();
    public static final ItemDrop WRISTBRACER_BLADES = new ItemDrop.Builder(PredatorItems.ITEM_WRISTBRACER_BLADES).setDropWeight(7).build();
    public static final ItemDrop SHURIKEN = new ItemDrop.Builder(PredatorItems.ITEM_SHURIKEN).setDropWeight(7).build();
    public static final ItemDrop SILICON = new ItemDrop.Builder(AVPItems.ITEM_SILICON).setDropWeight(25).build();
    public static final ItemDrop BIOMASK = new ItemDrop.Builder(PredatorBlocks.BIOMASK_CLASSIC).setDropWeight(3).build();
    public static final ItemDrop BIOMASK_BERSERKER = new ItemDrop.Builder(PredatorBlocks.BIOMASK_BERSERKER).setDropWeight(3).build();
    public static final ItemDrop BIOMASK_FALCONER = new ItemDrop.Builder(PredatorBlocks.BIOMASK_FALCONER).setDropWeight(3).build();
    public static final ItemDrop BIOMASK_TRACKER = new ItemDrop.Builder(PredatorBlocks.BIOMASK_TRACKER).setDropWeight(3).build();

    public static final ItemDrop AMMO_AR = new ItemDrop.Builder(WeaponItems.ITEM_AMMO_AR).setDropWeight(75).build();

    public static final ItemDrop M4 = new ItemDrop.Builder(WeaponItems.ITEM_M4).setDropWeight(15).build();
}
