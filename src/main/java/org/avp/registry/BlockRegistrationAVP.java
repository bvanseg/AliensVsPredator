package org.avp.registry;

import org.avp.AliensVsPredator;

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
        block.setCreativeTab(AliensVsPredator.tabs().blocks);
        return super.applyModifiers(block);
    }
}