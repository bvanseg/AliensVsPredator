package org.covenant.common;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.covenant.common.entity.living.EntityKetterBird;
import org.covenant.common.entity.living.EntityPaintedMink;
import org.covenant.common.entity.living.EntityStripedDevil;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.item.ItemEntitySummoner;
import org.covenant.common.item.ItemSporePod;
import org.lib.common.registry.ItemRegistryUtil;

public class CovenantItems implements IPreInitEvent {
    public static final CovenantItems instance = new CovenantItems();

    private CovenantItems() {}

    public static final Item SUMMONER_SPORE_POD = new ItemSporePod().setCreativeTab(AVPCreativeTabs.ENTITIES).setRegistryName("summon.sporepod");

    public static final Item SUMMONER_KETTER_BIRD = new ItemEntitySummoner<>(EntityKetterBird.class, EntityKetterBird::new).setRegistryName("summon.ketterbird");
    public static final Item SUMMONER_PAINTED_MINK = new ItemEntitySummoner<>(EntityPaintedMink.class, EntityPaintedMink::new).setRegistryName("summon.paintedmink");
    public static final Item SUMMONER_STRIPED_DEVIL = new ItemEntitySummoner<>(EntityStripedDevil.class, EntityStripedDevil::new).setRegistryName("summon.stripeddevil");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        ItemRegistryUtil.registerItem(SUMMONER_SPORE_POD);

        ItemRegistryUtil.registerItem(SUMMONER_KETTER_BIRD, true);
        ItemRegistryUtil.registerItem(SUMMONER_PAINTED_MINK, true);
        ItemRegistryUtil.registerItem(SUMMONER_STRIPED_DEVIL, true);
    }
}
