package org.avp.client;

import com.asx.mdx.client.sound.Sound;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lib.registry.SoundRegistryUtil;

/**
 * @author Ri5ux
 */
public class AVPSounds implements IPreInitEvent
{
    public static final AVPSounds instance = new AVPSounds();

    private AVPSounds() {}

    public static final Sound FX_WEAPON_PISTOL              = SoundRegistryUtil.createSound("weapon.pistol");
    
    /** MARINE SOUNDS **/
    public static final Sound  MARINE_HURT                  = SoundRegistryUtil.createSound("marine.hurt");
    public static final Sound  MARINE_DEATH                 = SoundRegistryUtil.createSound("marine.death");

    public static final Sound  WEAPON_FLAMETHROWER          = SoundRegistryUtil.createSound("weapon.flamethrower");
    public static final Sound  WEAPON_GUNSHOT               = SoundRegistryUtil.createSound("weapon.gunshot");
    public static final Sound  WEAPON_SNIPER                = SoundRegistryUtil.createSound("weapon.sniper");
    public static final Sound  WEAPON_PULSERIFLE            = SoundRegistryUtil.createSound("weapon.pulserifle");
    public static final Sound  WEAPON_STUNBATON             = SoundRegistryUtil.createSound("weapon.stunbaton");
    public static final Sound  WEAPON_M56SG                 = SoundRegistryUtil.createSound("weapon.m56sg");
    public static final Sound  MOTIONTRACKER_PING           = SoundRegistryUtil.createSound("motiontracker.ping");
    public static final Sound  MOTIONTRACKER_PONG           = SoundRegistryUtil.createSound("motiontracker.pong");
    public static final Sound  BLASTDOOR_SEVASTOPOL_OPEN    = SoundRegistryUtil.createSound("blocks.blastdoor.sevastopol.open");
    public static final Sound  BLASTDOOR_SEVASTOPOL_CLOSE   = SoundRegistryUtil.createSound("blocks.blastdoor.sevastopol.close");
    public static final Sound  BLASTDOOR_OPEN               = SoundRegistryUtil.createSound("blocks.blastdoor.open");
    public static final Sound  BLASTDOOR_CLOSE              = SoundRegistryUtil.createSound("blocks.blastdoor.close");
    public static final Sound  BLASTDOOR_UNLOCK             = SoundRegistryUtil.createSound("blocks.blastdoor.unlock");
    public static final Sound  BLASTDOOR_LOCK               = SoundRegistryUtil.createSound("blocks.blastdoor.lock");
    public static final Sound  BLASTDOOR_PASSWORD_DENIED    = SoundRegistryUtil.createSound("blocks.blastdoor.pass_deny");
    public static final Sound  ALARM_ACCESS                 = SoundRegistryUtil.createSound("blocks.alarm.access");
    public static final Sound  ALARM_BUZZER                 = SoundRegistryUtil.createSound("blocks.alarm.buzzer");
    public static final Sound  ALARM_EMERGENCY              = SoundRegistryUtil.createSound("blocks.alarm.emergency");

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        SoundRegistryUtil.registerSound(FX_WEAPON_PISTOL);

        SoundRegistryUtil.registerSound(MARINE_HURT);
        SoundRegistryUtil.registerSound(MARINE_DEATH);

        SoundRegistryUtil.registerSound(WEAPON_FLAMETHROWER);
        SoundRegistryUtil.registerSound(WEAPON_GUNSHOT);
        SoundRegistryUtil.registerSound(WEAPON_SNIPER);
        SoundRegistryUtil.registerSound(WEAPON_PULSERIFLE);
        SoundRegistryUtil.registerSound(WEAPON_STUNBATON);
        SoundRegistryUtil.registerSound(WEAPON_M56SG);
        SoundRegistryUtil.registerSound(MOTIONTRACKER_PING);
        SoundRegistryUtil.registerSound(MOTIONTRACKER_PONG);

        SoundRegistryUtil.registerSound(BLASTDOOR_SEVASTOPOL_OPEN);
        SoundRegistryUtil.registerSound(BLASTDOOR_SEVASTOPOL_CLOSE);
        SoundRegistryUtil.registerSound(BLASTDOOR_OPEN);
        SoundRegistryUtil.registerSound(BLASTDOOR_CLOSE);
        SoundRegistryUtil.registerSound(BLASTDOOR_UNLOCK);
        SoundRegistryUtil.registerSound(BLASTDOOR_LOCK);
        SoundRegistryUtil.registerSound(BLASTDOOR_PASSWORD_DENIED);
        SoundRegistryUtil.registerSound(ALARM_ACCESS);
        SoundRegistryUtil.registerSound(ALARM_BUZZER);
        SoundRegistryUtil.registerSound(ALARM_EMERGENCY);
    }
}
