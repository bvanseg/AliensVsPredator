package org.avp.api.block.drop.key;

public class BlockDropKeys {

    public static final BlockDropKey LEAF = new BlockDropKey();
    public static final BlockDropKey OTHER = new BlockDropKey();
    public static final BlockDropKey ORE = new BlockDropKey();
    public static final BlockDropKey SELF = new BlockDropKey();
    public static final BlockDropKey SILK_TOUCH_ONLY = new BlockDropKey();

    private BlockDropKeys() {
        throw new UnsupportedOperationException();
    }
}
