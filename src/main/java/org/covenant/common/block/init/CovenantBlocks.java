package org.covenant.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

/**
 * @author Boston Vanseghi
 */
public class CovenantBlocks implements IPreInitEvent {
    public static final CovenantBlocks instance = new CovenantBlocks();

    private CovenantBlocks() {}

    @Override
    public void pre(FMLPreInitializationEvent event) {
        CovenantParadiseBlocks.instance.pre(event);
        CovenantSkullBlocks.instance.pre(event);
    }
}
