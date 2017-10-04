package org.avp.registry;

import com.arisux.mdx.MDX;

import net.minecraft.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class BlockFluidRegistration extends BlockRegistrationAVP
{
    protected Fluid                           fluid;
    protected Class<? extends BlockFluidBase> fluidBlockClass;

    public BlockFluidRegistration(String registryName, Class<? extends BlockFluidBase> c, Fluid fluid)
    {
        super(registryName, null);
        this.fluid = fluid;
        this.fluidBlockClass = c;
    }

    @Override
    public Block applyModifiers(Block block)
    {
        return super.applyModifiers(block);
    }

    @Override
    public Block registerBlock(RegistryEvent.Register<Block> event)
    {
        FluidRegistry.registerFluid(this.fluid);
        FluidRegistry.addBucketForFluid(this.fluid);

        try
        {
            this.block = (fluidBlockClass.getConstructor()).newInstance(new Object[] {});
            this.block = this.applyModifiers(this.block);
            this.block.setRegistryName(registryName);
            this.block.setUnlocalizedName(this.block.getRegistryName().toString());
            event.getRegistry().register(this.block);

            return this.block;
        }
        catch (Exception e)
        {
            MDX.log().warn("Failed to construct fluid block: " + (fluidBlockClass != null ? fluidBlockClass.getName() : fluidBlockClass));
            e.printStackTrace();
        }

        return super.registerBlock(event);
    }

    public Fluid getFluid()
    {
        return this.fluid;
    }

    @Override
    public BlockFluidBase getBlock()
    {
        return (BlockFluidBase) super.getBlock();
    }
}