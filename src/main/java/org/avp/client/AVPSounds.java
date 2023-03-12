package org.avp.client;

import com.asx.mdx.core.mods.IPreInitEvent;
import com.asx.mdx.lib.util.Sound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.avp.AVP;

/**
 * @author Ri5ux
 */
public class AVPSounds implements IPreInitEvent
{
    public static final AVPSounds instance = new AVPSounds();

    private AVPSounds() {}

    public static final Sound FX_WRISTBRACER_ALARM          = createSound("weapon.blades.alarm");
    public static final Sound FX_WEAPON_PISTOL              = createSound("weapon.pistol");
    public static final Sound  ALIEN_LIVING                 = createSound("xeno.living");
    public static final Sound  ALIEN_HURT                   = createSound("xeno.hurt");
    public static final Sound  ALIEN_DEATH                  = createSound("xeno.death");
    
    /** QUEEN SOUNDS **/
    public static final Sound  QUEEN_HURT                   = createSound("queen.hurt");
    public static final Sound  QUEEN_LIVING_CONSTANT        = createSound("queen.living.constant");
    public static final Sound  QUEEN_LIVING                 = createSound("queen.living");
    public static final Sound  QUEEN_DEATH                  = createSound("queen.death");

    /** PRAETORIAN SOUNDS **/
    public static final Sound  PRAETORIAN_HURT              = createSound("praetorian.hurt");
    public static final Sound  PRAETORIAN_LIVING            = createSound("praetorian.living");
    public static final Sound  PRAETORIAN_DEATH             = createSound("praetorian.death");

    /** PRED-ALIEN SOUNDS **/
    public static final Sound  PREDALIEN_ATTACK             = createSound("predalien.attack");
    public static final Sound  PREDALIEN_HURT               = createSound("predalien.hurt");
    public static final Sound  PREDALIEN_LIVING             = createSound("predalien.living");
    public static final Sound  PREDALIEN_DEATH              = createSound("predalien.death");

    /** PREQUELMORPH SOUNDS **/
    public static final Sound  PREQUELMORPH_ATTACK          = createSound("prequelmorph.attack");
    public static final Sound  PREQUELMORPH_HURT            = createSound("prequelmorph.hurt");
    public static final Sound  PREQUELMORPH_LIVING          = createSound("prequelmorph.living");
    public static final Sound  PREQUELMORPH_DEATH           = createSound("prequelmorph.death");

    /** CHESTBURSTER SOUNDS **/
    public static final Sound  CHESTBURSTER_DEATH           = createSound("chestburster.death");
    public static final Sound  CHESTBURSTER_HURT            = createSound("chestburster.hurt");
    public static final Sound  CHESTBURSTER_ATTACK          = createSound("chestburster.attack");
    public static final Sound  CHESTBURSTER_BURST           = createSound("chestburster.burst");
    
    /** FACEHUGGER SOUNDS **/
    public static final Sound  FACEHUGGER_DEATH             = createSound("facehugger.death");
    public static final Sound  FACEHUGGER_HURT              = createSound("facehugger.hurt");
    public static final Sound  FACEHUGGER_IMPLANT           = createSound("facehugger.implant");
    public static final Sound  FACEHUGGER_LIVING            = createSound("facehugger.living");
    
    /** MARINE SOUNDS **/
    public static final Sound  MARINE_HURT                  = createSound("marine.hurt");
    public static final Sound  MARINE_DEATH                 = createSound("marine.death");
    
    /** YAUTJA SOUNDS **/
    public static final Sound  YAUTJA_LIVING                = createSound("predator.living");
    public static final Sound  YAUTJA_HURT                  = createSound("predator.hurt");
    public static final Sound  YAUTJA_DEATH                 = createSound("predator.death");
    public static final Sound  YAUTJA_CLOAK                 = createSound("predator.cloaking");
    public static final Sound  YAUTJA_DECLOAK               = createSound("predator.decloaking");

    /** YAUTJA VISION SOUNDS **/
    public static final Sound  YAUTJA_VISION_SWITCH         = createSound("predator.vision.switch");

    public static final Sound  WEAPON_FLAMETHROWER          = createSound("weapon.flamethrower");
    public static final Sound  WEAPON_GUNSHOT               = createSound("weapon.gunshot");
    public static final Sound  WEAPON_PLASMACASTER          = createSound("weapon.plasmacaster");
    public static final Sound  WEAPON_PLASMACASTER_CHARGE   = createSound("weapon.plasmacaster.charge");
    public static final Sound  WEAPON_PLASMACASTER_NOENERGY = createSound("weapon.plasmacaster.noenergy");
    public static final Sound  WEAPON_PLASMA_EXPLOSION      = createSound("weapon.plasmacaster.explosion");
    public static final Sound  WEAPON_WRISTBLADES           = createSound("weapon.blades");
    public static final Sound  WEAPON_SNIPER                = createSound("weapon.sniper");
    public static final Sound  WEAPON_PULSERIFLE            = createSound("weapon.pulserifle");
    public static final Sound  WEAPON_STUNBATON             = createSound("weapon.stunbaton");
    public static final Sound  WEAPON_M56SG                 = createSound("weapon.m56sg");
    public static final Sound  MOTIONTRACKER_PING           = createSound("motiontracker.ping");
    public static final Sound  MOTIONTRACKER_PONG           = createSound("motiontracker.pong");
    public static final Sound  BLASTDOOR_SEVASTOPOL_OPEN    = createSound("blocks.blastdoor.sevastopol.open");
    public static final Sound  BLASTDOOR_SEVASTOPOL_CLOSE   = createSound("blocks.blastdoor.sevastopol.close");
    public static final Sound  BLASTDOOR_OPEN               = createSound("blocks.blastdoor.open");
    public static final Sound  BLASTDOOR_CLOSE              = createSound("blocks.blastdoor.close");
    public static final Sound  BLASTDOOR_UNLOCK             = createSound("blocks.blastdoor.unlock");
    public static final Sound  BLASTDOOR_LOCK               = createSound("blocks.blastdoor.lock");
    public static final Sound  BLASTDOOR_PASSWORD_DENIED    = createSound("blocks.blastdoor.pass_deny");
    public static final Sound  ALARM_ACCESS                 = createSound("blocks.alarm.access");
    public static final Sound  ALARM_BUZZER                 = createSound("blocks.alarm.buzzer");
    public static final Sound  ALARM_EMERGENCY              = createSound("blocks.alarm.emergency");

    public static Sound createSound(String name)
    {
        return new Sound(new ResourceLocation(AVP.Properties.DOMAIN + name));
    }

    private void registerSound(Sound sound) {
        ForgeRegistries.SOUND_EVENTS.register(sound.createSoundEvent(sound.getLocation().getPath()));
    }

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        registerSound(FX_WRISTBRACER_ALARM);
        registerSound(FX_WEAPON_PISTOL);

        registerSound(ALIEN_LIVING);
        registerSound(ALIEN_HURT);
        registerSound(ALIEN_DEATH);

        registerSound(QUEEN_HURT);
        registerSound(QUEEN_LIVING_CONSTANT);
        registerSound(QUEEN_LIVING);
        registerSound(QUEEN_DEATH);

        registerSound(PRAETORIAN_HURT);
        registerSound(PRAETORIAN_LIVING);
        registerSound(PRAETORIAN_DEATH);

        registerSound(PREDALIEN_ATTACK);
        registerSound(PREDALIEN_HURT);
        registerSound(PREDALIEN_LIVING);
        registerSound(PREDALIEN_DEATH);

        registerSound(PREQUELMORPH_ATTACK);
        registerSound(PREQUELMORPH_HURT);
        registerSound(PREQUELMORPH_LIVING);
        registerSound(PREQUELMORPH_DEATH);

        registerSound(CHESTBURSTER_DEATH);
        registerSound(CHESTBURSTER_HURT);
        registerSound(CHESTBURSTER_ATTACK);
        registerSound(CHESTBURSTER_BURST);

        registerSound(FACEHUGGER_DEATH);
        registerSound(FACEHUGGER_HURT);
        registerSound(FACEHUGGER_IMPLANT);
        registerSound(FACEHUGGER_LIVING);

        registerSound(MARINE_HURT);
        registerSound(MARINE_DEATH);

        registerSound(YAUTJA_LIVING);
        registerSound(YAUTJA_HURT);
        registerSound(YAUTJA_DEATH);
        registerSound(YAUTJA_CLOAK);
        registerSound(YAUTJA_DECLOAK);
        registerSound(YAUTJA_VISION_SWITCH);

        registerSound(WEAPON_FLAMETHROWER);
        registerSound(WEAPON_GUNSHOT);
        registerSound(WEAPON_PLASMACASTER);
        registerSound(WEAPON_PLASMACASTER_CHARGE);
        registerSound(WEAPON_PLASMACASTER_NOENERGY);
        registerSound(WEAPON_PLASMA_EXPLOSION);
        registerSound(WEAPON_WRISTBLADES);
        registerSound(WEAPON_SNIPER);
        registerSound(WEAPON_PULSERIFLE);
        registerSound(WEAPON_STUNBATON);
        registerSound(WEAPON_M56SG);
        registerSound(MOTIONTRACKER_PING);
        registerSound(MOTIONTRACKER_PONG);

        registerSound(BLASTDOOR_SEVASTOPOL_OPEN);
        registerSound(BLASTDOOR_SEVASTOPOL_CLOSE);
        registerSound(BLASTDOOR_OPEN);
        registerSound(BLASTDOOR_CLOSE);
        registerSound(BLASTDOOR_UNLOCK);
        registerSound(BLASTDOOR_LOCK);
        registerSound(BLASTDOOR_PASSWORD_DENIED);
        registerSound(ALARM_ACCESS);
        registerSound(ALARM_BUZZER);
        registerSound(ALARM_EMERGENCY);
    }
}
