package org.avp.common.block.util;

import net.minecraft.util.IStringSerializable;

public enum EnumAlignment implements IStringSerializable
{
    TOP("top"), BOTTOM("bottom"), SIDE("side");

    private final String name;

    private EnumAlignment(String name)
    {
        this.name = name;
    }

    public String toString()
    {
        return this.name;
    }

    public String getName()
    {
        return this.name;
    }
}