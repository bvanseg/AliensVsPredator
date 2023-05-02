package org.predator.client;

import com.asx.mdx.client.sound.Sound;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lib.common.registry.SoundRegistryUtil;

/**
 * @author Ri5ux
 */
public class PredatorSounds implements IPreInitEvent
{
    public static final PredatorSounds instance = new PredatorSounds();

    private PredatorSounds() {}

    public static final Sound FX_WRISTBRACER_ALARM          = SoundRegistryUtil.createSound("weapon.blades.alarm");
    
    /** YAUTJA SOUNDS **/
    public static final Sound  YAUTJA_LIVING                = SoundRegistryUtil.createSound("predator.living");
    public static final Sound  YAUTJA_HURT                  = SoundRegistryUtil.createSound("predator.hurt");
    public static final Sound  YAUTJA_DEATH                 = SoundRegistryUtil.createSound("predator.death");
    public static final Sound  YAUTJA_CLOAK                 = SoundRegistryUtil.createSound("predator.cloaking");
    public static final Sound  YAUTJA_DECLOAK               = SoundRegistryUtil.createSound("predator.decloaking");

    /** YAUTJA VISION SOUNDS **/
    public static final Sound  YAUTJA_VISION_LOOP         = SoundRegistryUtil.createSound("predator.vision.loop");
    public static final Sound  YAUTJA_VISION_SWITCH         = SoundRegistryUtil.createSound("predator.vision.switch");
    public static final Sound  WEAPON_PLASMACASTER          = SoundRegistryUtil.createSound("weapon.plasmacaster");
    public static final Sound  WEAPON_PLASMACASTER_CHARGE   = SoundRegistryUtil.createSound("weapon.plasmacaster.charge");
    public static final Sound  WEAPON_PLASMACASTER_NOENERGY = SoundRegistryUtil.createSound("weapon.plasmacaster.noenergy");
    public static final Sound  WEAPON_PLASMA_EXPLOSION      = SoundRegistryUtil.createSound("weapon.plasmacaster.explosion");
    public static final Sound  WEAPON_WRISTBLADES           = SoundRegistryUtil.createSound("weapon.blades");

    // Wristbracer Console FX
    public static final Sound WRISTBRACER_CONSOLE_OPEN      = SoundRegistryUtil.createSound("wristbracer.console.open");
    public static final Sound WRISTBRACER_CONSOLE_CLOSE     = SoundRegistryUtil.createSound("wristbracer.console.close");
    public static final Sound WRISTBRACER_CONSOLE_INTERACT  = SoundRegistryUtil.createSound("wristbracer.console.interact");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        SoundRegistryUtil.registerSound(FX_WRISTBRACER_ALARM);

        SoundRegistryUtil.registerSound(YAUTJA_LIVING);
        SoundRegistryUtil.registerSound(YAUTJA_HURT);
        SoundRegistryUtil.registerSound(YAUTJA_DEATH);
        SoundRegistryUtil.registerSound(YAUTJA_CLOAK);
        SoundRegistryUtil.registerSound(YAUTJA_DECLOAK);
        SoundRegistryUtil.registerSound(YAUTJA_VISION_LOOP);
        SoundRegistryUtil.registerSound(YAUTJA_VISION_SWITCH);

        SoundRegistryUtil.registerSound(WEAPON_PLASMACASTER);
        SoundRegistryUtil.registerSound(WEAPON_PLASMACASTER_CHARGE);
        SoundRegistryUtil.registerSound(WEAPON_PLASMACASTER_NOENERGY);
        SoundRegistryUtil.registerSound(WEAPON_PLASMA_EXPLOSION);
        SoundRegistryUtil.registerSound(WEAPON_WRISTBLADES);

        SoundRegistryUtil.registerSound(WRISTBRACER_CONSOLE_OPEN);
        SoundRegistryUtil.registerSound(WRISTBRACER_CONSOLE_CLOSE);
        SoundRegistryUtil.registerSound(WRISTBRACER_CONSOLE_INTERACT);
    }
}
