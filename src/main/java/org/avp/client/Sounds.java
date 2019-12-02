package org.avp.client;

import java.lang.reflect.Field;

import org.avp.AliensVsPredator;

import com.asx.mdx.MDX;
import com.asx.mdx.lib.util.Sound;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Sounds
{
    public static final Sounds instance                     = new Sounds();

    public static final Sound  fxWristbracerAlarm           = sound("weapon.blades.alarm");
    public static final Sound  fxWeaponPistol               = sound("weapon.pistol");
    public static final Sound  ALIEN_LIVING                 = sound("xeno.living");
    public static final Sound  ALIEN_HURT                   = sound("xeno.hurt");
    public static final Sound  ALIEN_DEATH                  = sound("xeno.death");
    
    /** QUEEN SOUNDS **/
    public static final Sound  QUEEN_HURT                   = sound("queen.hurt");
    public static final Sound  QUEEN_LIVING_CONSTANT        = sound("queen.living.constant");
    public static final Sound  QUEEN_LIVING                 = sound("queen.living");
    public static final Sound  QUEEN_DEATH                  = sound("queen.death");
    
    /** PRAETORIAN SOUNDS **/
    public static final Sound  PRAETORIAN_HURT                   = sound("praetorian.hurt");
    public static final Sound  PRAETORIAN_LIVING                 = sound("praetorian.living");
    public static final Sound  PRAETORIAN_DEATH                  = sound("praetorian.death");
    
    /** CHESTBURSTER SOUNDS **/
    public static final Sound  CHESTBURSTER_DEATH           = sound("chestburster.death");
    public static final Sound  CHESTBURSTER_HURT            = sound("chestburster.hurt");
    public static final Sound  CHESTBURSTER_ATTACK          = sound("chestburster.attack");
    public static final Sound  CHESTBURSTER_BURST           = sound("chestburster.burst");
    
    /** FACEHUGGER SOUNDS **/
    public static final Sound  FACEHUGGER_DEATH             = sound("facehugger.death");
    public static final Sound  FACEHUGGER_HURT              = sound("facehugger.hurt");
    public static final Sound  FACEHUGGER_IMPLANT           = sound("facehugger.implant");
    public static final Sound  FACEHUGGER_LIVING            = sound("facehugger.living");
    
    public static final Sound  MARINE_HURT                  = sound("marine.hurt");
    public static final Sound  MARINE_DEATH                 = sound("marine.death");
    public static final Sound  YAUTJA_LIVING                = sound("predator.living");
    public static final Sound  YAUTJA_HURT                  = sound("predator.hurt");
    public static final Sound  YAUTJA_DEATH                 = sound("predator.death");
    public static final Sound  WEAPON_FLAMETHROWER          = sound("weapon.flamethrower");
    public static final Sound  WEAPON_GUNSHOT               = sound("weapon.gunshot");
    public static final Sound  WEAPON_PLASMACASTER          = sound("weapon.plasmacaster");
    public static final Sound  WEAPON_PLASMACASTER_CHARGE   = sound("weapon.plasmacaster.charge");
    public static final Sound  WEAPON_PLASMACASTER_NOENERGY = sound("weapon.plasmacaster.noenergy");
    public static final Sound  WEAPON_PLASMA_EXPLOSION      = sound("weapon.plasmacaster.explosion");
    public static final Sound  WEAPON_WRISTBLADES           = sound("weapon.blades");
    public static final Sound  WEAPON_SNIPER                = sound("weapon.sniper");
    public static final Sound  WEAPON_PULSERIFLE            = sound("weapon.pulserifle");
    public static final Sound  WEAPON_STUNBATON             = sound("weapon.stunbaton");
    public static final Sound  WEAPON_M56SG                 = sound("weapon.m56sg");
    public static final Sound  MOTIONTRACKER_PING           = sound("motiontracker.ping");
    public static final Sound  MOTIONTRACKER_PONG           = sound("motiontracker.pong");
    public static final Sound  BLASTDOOR_SEVASTOPOL_OPEN    = sound("blocks.blastdoor.sevastopol.open");
    public static final Sound  BLASTDOOR_SEVASTOPOL_CLOSE   = sound("blocks.blastdoor.sevastopol.close");
    public static final Sound  BLASTDOOR_OPEN               = sound("blocks.blastdoor.open");
    public static final Sound  BLASTDOOR_CLOSE              = sound("blocks.blastdoor.close");
    public static final Sound  BLASTDOOR_UNLOCK             = sound("blocks.blastdoor.unlock");
    public static final Sound  BLASTDOOR_LOCK               = sound("blocks.blastdoor.lock");
    public static final Sound  BLASTDOOR_PASSWORD_DENIED    = sound("blocks.blastdoor.pass_deny");
    public static final Sound  ALARM_ACCESS                 = sound("blocks.alarm.access");
    public static final Sound  ALARM_BUZZER                 = sound("blocks.alarm.buzzer");
    public static final Sound  ALARM_EMERGENCY              = sound("blocks.alarm.emergency");

    @Mod.EventBusSubscriber(modid = AliensVsPredator.Properties.ID)
    public static class RegistrationHandler
    {
        @SubscribeEvent
        public static void registerSoundEvents(final RegistryEvent.Register<SoundEvent> event)
        {
            for (Field field : AliensVsPredator.sounds().getClass().getDeclaredFields())
            {
                if (field.getType() == Sound.class)
                {
                    try
                    {
                        field.setAccessible(true);
                        Sound sound = (Sound) field.get(AliensVsPredator.sounds());
                        event.getRegistry().register(sound.createSoundEvent(sound.getLocation().getPath()));
                    }
                    catch (Exception e1)
                    {
                        try
                        {
                            MDX.log().info(String.format("Failed to register sound %s: %s", ((Sound) field.get(AliensVsPredator.sounds())).getLocation(), e1));
                        }
                        catch (Exception e2)
                        {
                            e2.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static Sound sound(String name)
    {
        return new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + name));
    }
}
