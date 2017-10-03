package org.avp.registry;

import org.avp.AliensVsPredator;
import org.avp.block.BlockReflective;
import org.avp.client.model.loaders.ReflectiveModelLoader;

import com.arisux.mdx.lib.game.registry.BlockRegistration;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public abstract class BlockRegistrationReflective extends BlockRegistration
{
    public BlockRegistrationReflective(String registryName, Block block)
    {
        super(registryName, block);
    }

    @Override
    public Block registerBlock(Register<Block> event)
    {
        this.block = this.applyModifiers(block);
        block.setRegistryName(registryName);
        block.setUnlocalizedName(block.getRegistryName().toString());
        event.getRegistry().register(this.block);

        if (AliensVsPredator.settings().isCompatibilityModeEnabled())
        {
            for (final String type : BlockReflective.SHAPE_COMPAT_TYPES)
            {
                Block b = new BlockReflective(Material.BARRIER, true);
                String shapeId = String.format("%s.%s", this.registryName, type);
                b.setRegistryName(shapeId);
                b.setUnlocalizedName(b.getRegistryName().toString());
                event.getRegistry().register(b);

                if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
                {
                    ReflectiveModelLoader.INSTANCE.registerDummy(shapeId);
                }
            }
        }

        return this.block;
    }
}