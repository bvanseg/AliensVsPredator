package org.alien.common.potion;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * @author Boston Vanseghi
 */
public class AlienPotions implements IPreInitEvent {

    public static final AlienPotions instance = new AlienPotions();

    private AlienPotions() {}

    public static final Potion ACID = new AcidPotionEffect();

    @Override
    public void pre(FMLPreInitializationEvent event) {
        ForgeRegistries.POTIONS.register(ACID);
    }
}
