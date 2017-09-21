package org.avp;

import java.util.ArrayList;

import org.avp.block.BlockBlackGoo;
import org.avp.block.BlockMist;

import com.arisux.mdx.MDX;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidHandler
{
    public static FluidHandler instance = new FluidHandler();
    
    private final ArrayList<FluidRegistration> fluids = new ArrayList<FluidRegistration>();

    public static class FluidRegistration
    {
        private String id;
        private Class<? extends BlockFluidBase> blockClass;
        private BlockFluidBase blockFluid;
        private Fluid fluid;
        
        public FluidRegistration(String id, Class<? extends BlockFluidBase> blockClass, Fluid fluid)
        {
            this.id = id;
            this.blockClass = blockClass;
            this.fluid = fluid;
        }
        
        public String getId()
        {
            return id;
        }
        
        public Class<? extends BlockFluidBase> getBlockClass()
        {
            return blockClass;
        }
        
        public Fluid getFluid()
        {
            return fluid;
        }
        
        public void setBlockFluid(BlockFluidBase blockFluid)
        {
            this.blockFluid = blockFluid;
        }
        
        public BlockFluidBase getBlockFluid()
        {
            return blockFluid;
        }
    }
    
    public FluidHandler()
    {
        this.add("blackgoo", BlockBlackGoo.class, BlockBlackGoo.fluid);
        this.add("mist", BlockMist.class, BlockMist.fluid);
    }
    
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        this.registerFluids();
        this.registerBuckets();
        
        for (FluidRegistration registration : this.fluids)
        {
            BlockFluidBase block = constructFluidBlock(registration.getBlockClass());
            block.setRegistryName(registration.getId());
            block.setUnlocalizedName(block.getRegistryName().toString());
            block.setCreativeTab(AliensVsPredator.tabBlocks());
            event.getRegistry().register(block);
            registration.setBlockFluid(block);
        }
    }

    public void registerItems(Register<Item> event)
    {
        for (FluidRegistration registration : this.fluids)
        {
            ItemBlock itemblock = new ItemBlock(registration.getBlockFluid());
            itemblock.setRegistryName(registration.getId());
            itemblock.setUnlocalizedName(itemblock.getRegistryName().toString());
            event.getRegistry().register(itemblock);
        }        
    }
    
    public static BlockFluidBase constructFluidBlock(Class<? extends BlockFluidBase> c)
    {
        try
        {
            return (c.getConstructor()).newInstance(new Object[] { });
        }
        catch (Exception e)
        {
            MDX.log().warn("Failed to construct fluid block: " + (c != null ? c.getName() : c));
            e.printStackTrace();
        }
        return null;
    }
    
    public void add(String id, Class<? extends BlockFluidBase> blockClass, Fluid fluid)
    {
        this.fluids.add(new FluidRegistration(id, blockClass, fluid));
    }

    private void registerFluids()
    {
        for (FluidRegistration registration : this.fluids)
        {
            FluidRegistry.registerFluid(registration.getFluid());
        }
    }

    private void registerBuckets()
    {
        for (FluidRegistration registration : this.fluids)
        {
            FluidRegistry.addBucketForFluid(registration.getFluid());
        }
    }
    
    public ArrayList<FluidRegistration> getFluidRegistrations()
    {
        return fluids;
    }
}
