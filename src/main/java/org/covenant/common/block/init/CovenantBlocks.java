package org.covenant.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.AlienDimensions;
import org.alien.common.block.BlockPortal;
import org.avp.common.AVPCreativeTabs;
import org.covenant.common.CovenantDimensions;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class CovenantBlocks implements IPreInitEvent {
    public static final CovenantBlocks instance = new CovenantBlocks();

    public static final Block PORTAL_PARADISE = new BlockPortal(CovenantDimensions.PARADISE).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("portal.paradise");


    private CovenantBlocks() {}

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();

        CovenantParadiseBlocks.instance.pre(event);
        CovenantSkullBlocks.instance.pre(event);
        CovenantStairsBlocks.instance.pre(event);
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(PORTAL_PARADISE);
    }
}
