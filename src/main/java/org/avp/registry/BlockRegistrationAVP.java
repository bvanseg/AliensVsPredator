package org.avp.registry;

import org.avp.CreativeTab;

import com.arisux.mdx.lib.game.registry.BlockRegistration;

import net.minecraft.block.Block;

public class BlockRegistrationAVP extends BlockRegistration
{
    public BlockRegistrationAVP(String registryName, Block block)
    {
        super(registryName, block);
    }
    
    @Override
    public Block applyModifiers(Block block)
    {
        block.setCreativeTab(CreativeTab.tabBlocks);
        return super.applyModifiers(block);
    }
}