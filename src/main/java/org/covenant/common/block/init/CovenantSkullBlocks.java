package org.covenant.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPCreativeTabs;
import org.covenant.common.block.skull.BlockSkullNeomorph;
import org.covenant.common.block.skull.BlockSkullProtomorph;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class CovenantSkullBlocks implements IPreInitEvent {
    public static final CovenantSkullBlocks instance = new CovenantSkullBlocks();

    private CovenantSkullBlocks() {}

    public static final Block SKULL_PROTOMORPH = new BlockSkullProtomorph().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.protomorph");
    public static final Block SKULL_NEOMORPH = new BlockSkullNeomorph().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.neomorph");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(SKULL_PROTOMORPH);
        BlockRegistryUtil.registerStandardBlock(SKULL_NEOMORPH);
    }
}
