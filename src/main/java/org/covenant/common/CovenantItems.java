package org.covenant.common;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPCreativeTabs;
import org.covenant.common.item.ItemSporePod;
import org.lib.common.registry.ItemRegistryUtil;

public class CovenantItems implements IPreInitEvent {
    public static final CovenantItems instance = new CovenantItems();

    private CovenantItems() {}

    public static final Item SUMMONER_SPORE_POD = new ItemSporePod().setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.sporepod");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItem(SUMMONER_SPORE_POD);
    }
}
