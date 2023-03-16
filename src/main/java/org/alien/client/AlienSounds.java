package org.alien.client;

import com.asx.mdx.client.sound.Sound;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lib.registry.SoundRegistryUtil;

/**
 * @author Ri5ux
 */
public class AlienSounds implements IPreInitEvent
{
    public static final AlienSounds instance = new AlienSounds();

    private AlienSounds() {}
    public static final Sound ALIEN_LIVING                 = SoundRegistryUtil.createSound("xeno.living");
    public static final Sound  ALIEN_HURT                   = SoundRegistryUtil.createSound("xeno.hurt");
    public static final Sound  ALIEN_DEATH                  = SoundRegistryUtil.createSound("xeno.death");
    
    /** QUEEN SOUNDS **/
    public static final Sound  QUEEN_HURT                   = SoundRegistryUtil.createSound("queen.hurt");
    public static final Sound  QUEEN_LIVING_CONSTANT        = SoundRegistryUtil.createSound("queen.living.constant");
    public static final Sound  QUEEN_LIVING                 = SoundRegistryUtil.createSound("queen.living");
    public static final Sound  QUEEN_DEATH                  = SoundRegistryUtil.createSound("queen.death");

    /** PRAETORIAN SOUNDS **/
    public static final Sound  PRAETORIAN_HURT              = SoundRegistryUtil.createSound("praetorian.hurt");
    public static final Sound  PRAETORIAN_LIVING            = SoundRegistryUtil.createSound("praetorian.living");
    public static final Sound  PRAETORIAN_DEATH             = SoundRegistryUtil.createSound("praetorian.death");

    /** PRED-ALIEN SOUNDS **/
    public static final Sound  PREDALIEN_ATTACK             = SoundRegistryUtil.createSound("predalien.attack");
    public static final Sound  PREDALIEN_HURT               = SoundRegistryUtil.createSound("predalien.hurt");
    public static final Sound  PREDALIEN_LIVING             = SoundRegistryUtil.createSound("predalien.living");
    public static final Sound  PREDALIEN_DEATH              = SoundRegistryUtil.createSound("predalien.death");

    /** PREQUELMORPH SOUNDS **/
    public static final Sound  PREQUELMORPH_ATTACK          = SoundRegistryUtil.createSound("prequelmorph.attack");
    public static final Sound  PREQUELMORPH_HURT            = SoundRegistryUtil.createSound("prequelmorph.hurt");
    public static final Sound  PREQUELMORPH_LIVING          = SoundRegistryUtil.createSound("prequelmorph.living");
    public static final Sound  PREQUELMORPH_DEATH           = SoundRegistryUtil.createSound("prequelmorph.death");

    /** CHESTBURSTER SOUNDS **/
    public static final Sound  CHESTBURSTER_DEATH           = SoundRegistryUtil.createSound("chestburster.death");
    public static final Sound  CHESTBURSTER_HURT            = SoundRegistryUtil.createSound("chestburster.hurt");
    public static final Sound  CHESTBURSTER_ATTACK          = SoundRegistryUtil.createSound("chestburster.attack");
    public static final Sound  CHESTBURSTER_BURST           = SoundRegistryUtil.createSound("chestburster.burst");
    
    /** FACEHUGGER SOUNDS **/
    public static final Sound  FACEHUGGER_DEATH             = SoundRegistryUtil.createSound("facehugger.death");
    public static final Sound  FACEHUGGER_HURT              = SoundRegistryUtil.createSound("facehugger.hurt");
    public static final Sound  FACEHUGGER_IMPLANT           = SoundRegistryUtil.createSound("facehugger.implant");
    public static final Sound  FACEHUGGER_LIVING            = SoundRegistryUtil.createSound("facehugger.living");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        SoundRegistryUtil.registerSound(ALIEN_LIVING);
        SoundRegistryUtil.registerSound(ALIEN_HURT);
        SoundRegistryUtil.registerSound(ALIEN_DEATH);

        SoundRegistryUtil.registerSound(QUEEN_HURT);
        SoundRegistryUtil.registerSound(QUEEN_LIVING_CONSTANT);
        SoundRegistryUtil.registerSound(QUEEN_LIVING);
        SoundRegistryUtil.registerSound(QUEEN_DEATH);

        SoundRegistryUtil.registerSound(PRAETORIAN_HURT);
        SoundRegistryUtil.registerSound(PRAETORIAN_LIVING);
        SoundRegistryUtil.registerSound(PRAETORIAN_DEATH);

        SoundRegistryUtil.registerSound(PREDALIEN_ATTACK);
        SoundRegistryUtil.registerSound(PREDALIEN_HURT);
        SoundRegistryUtil.registerSound(PREDALIEN_LIVING);
        SoundRegistryUtil.registerSound(PREDALIEN_DEATH);

        SoundRegistryUtil.registerSound(PREQUELMORPH_ATTACK);
        SoundRegistryUtil.registerSound(PREQUELMORPH_HURT);
        SoundRegistryUtil.registerSound(PREQUELMORPH_LIVING);
        SoundRegistryUtil.registerSound(PREQUELMORPH_DEATH);

        SoundRegistryUtil.registerSound(CHESTBURSTER_DEATH);
        SoundRegistryUtil.registerSound(CHESTBURSTER_HURT);
        SoundRegistryUtil.registerSound(CHESTBURSTER_ATTACK);
        SoundRegistryUtil.registerSound(CHESTBURSTER_BURST);

        SoundRegistryUtil.registerSound(FACEHUGGER_DEATH);
        SoundRegistryUtil.registerSound(FACEHUGGER_HURT);
        SoundRegistryUtil.registerSound(FACEHUGGER_IMPLANT);
        SoundRegistryUtil.registerSound(FACEHUGGER_LIVING);
    }
}
