package org.alien.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.init.SoundEvents;

/**
 * @author Boston Vanseghi
 */
public class AlienSoundTypes {

    private AlienSoundTypes() {}

    public static final SoundType RESIN = new SoundType(1.0F, 0.3F, SoundEvents.BLOCK_GRAVEL_BREAK, SoundEvents.BLOCK_SLIME_STEP, SoundEvents.BLOCK_GRAVEL_PLACE, SoundEvents.BLOCK_GRAVEL_HIT, SoundEvents.BLOCK_SLIME_FALL);
}
