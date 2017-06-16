package org.avp.client;

import java.lang.reflect.Field;

import org.avp.AliensVsPredator;

import com.arisux.mdx.MDX;
import com.arisux.mdx.lib.client.Sound;
import com.arisux.mdx.lib.game.IPreInitEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Sounds implements IPreInitEvent
{
    public static final Sounds instance                           = new Sounds();

    public static final Sound  fxWristbracerAlarm                 = new Sound(new ResourceLocation("avp:weapon.blades.alarm"));
    public static final Sound  fxAlarm                            = new Sound(new ResourceLocation("avp:alarm"));
    public static final Sound  fxAlarm0                           = new Sound(new ResourceLocation("avp:alarm0"));
    public static final Sound  fxAlarm1                           = new Sound(new ResourceLocation("avp:alarm1"));
    public static final Sound  fxAutomaticGun                     = new Sound(new ResourceLocation("avp:automatic-gun"));
    public static final Sound  fxBlastDoorOpen                    = new Sound(new ResourceLocation("avp:blast-door-open"));
    public static final Sound  fxLabDoorClose                     = new Sound(new ResourceLocation("avp:lab-door-close"));
    public static final Sound  fxLabDoorOpen                      = new Sound(new ResourceLocation("avp:lab-door-open"));
    public static final Sound  fxPistol                           = new Sound(new ResourceLocation("avp:pistol"));
    public static final Sound  fxPistolHeavy                      = new Sound(new ResourceLocation("avp:pistol-heavy"));
    public static final Sound  fxPulserifle                       = new Sound(new ResourceLocation("avp:pulserifle"));
    public static final Sound  fxSmartGun                         = new Sound(new ResourceLocation("avp:smartgun"));
    public static final Sound  fxStepGlass                        = new Sound(new ResourceLocation("avp:step-glass"));
    public static final Sound  fxStepHive                         = new Sound(new ResourceLocation("avp:step-hive"));
    public static final Sound  fxTurret                           = new Sound(new ResourceLocation("avp:turret"));
    public static final Sound  fxPowerBurnout                     = new Sound(new ResourceLocation("avp:burnout"));
    public static final Sound  fxPowerGenerator                   = new Sound(new ResourceLocation("avp:generator-humming"));
    public static final Sound  fxPowerLightFlicker                = new Sound(new ResourceLocation("avp:light-flicker"));
    public static final Sound  fxPowerLightOn                     = new Sound(new ResourceLocation("avp:light-on"));
    public static final Sound  fxPowerPlasma                      = new Sound(new ResourceLocation("avp:plasma"));
    public static final Sound  fxPowerShortout                    = new Sound(new ResourceLocation("avp:shortout"));

    public static final Sound  SOUND_ALIEN_LIVING                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.living"));
    public static final Sound  SOUND_ALIEN_HURT                   = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.hurt"));
    public static final Sound  SOUND_ALIEN_DEATH                  = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.death"));
    public static final Sound  SOUND_PRAETORIAN_HURT              = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "praetorian.hurt"));
    public static final Sound  SOUND_PRAETORIAN_LIVING            = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "praetorian.living"));
    public static final Sound  SOUND_PRAETORIAN_DEATH             = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.death"));
    public static final Sound  SOUND_QUEEN_HURT                   = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "queen.hurt"));
    public static final Sound  SOUND_QUEEN_LIVING_CONSTANT                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "queen.living.constant"));
    public static final Sound  SOUND_QUEEN_LIVING                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "queen.living"));
    public static final Sound  SOUND_QUEEN_DEATH                  = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "queen.death"));
    public static final Sound  SOUND_SPITTER_HURT                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "praetorian.hurt"));
    public static final Sound  SOUND_SPITTER_LIVING               = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "praetorian.living"));
    public static final Sound  SOUND_SPITTER_DEATH                = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.death"));
    public static final Sound  SOUND_WARRIOR_HURT                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.hurt"));
    public static final Sound  SOUND_WARRIOR_LIVING               = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.living"));
    public static final Sound  SOUND_WARRIOR_DEATH                = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.death"));
    public static final Sound  SOUND_CRUSHER_HURT                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "praetorian.hurt"));
    public static final Sound  SOUND_CRUSHER_LIVING               = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "praetorian.living"));
    public static final Sound  SOUND_CRUSHER_DEATH                = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "xeno.death"));
    public static final Sound  SOUND_CHESTBURSTER_DEATH           = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "chestburster.death"));
    public static final Sound  SOUND_CHESTBURSTER_HURT            = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "chestburster.hurt"));
    public static final Sound  SOUND_CHESTBURSTER_ATTACK          = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "chestburster.attack"));
    public static final Sound  SOUND_CHESTBURSTER_BURST           = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "chestburster.burst"));
    public static final Sound  SOUND_FACEHUGGER_DEATH             = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "facehugger.death"));
    public static final Sound  SOUND_FACEHUGGER_HURT              = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "facehugger.hurt"));
    public static final Sound  SOUND_FACEHUGGER_LIVING            = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "facehugger.living"));
    public static final Sound  SOUND_MARINE_HURT                  = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "marine.hurt"));
    public static final Sound  SOUND_MARINE_DEATH                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "marine.death"));
    public static final Sound  SOUND_YAUTJA_LIVING                = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "predator.living"));
    public static final Sound  SOUND_YAUTJA_HURT                  = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "predator.hurt"));
    public static final Sound  SOUND_YAUTJA_DEATH                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "predator.death"));
    public static final Sound  SOUND_WEAPON_FLAMETHROWER          = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.flamethrower"));
    public static final Sound  SOUND_WEAPON_GUNSHOT               = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.gunshot"));
    public static final Sound  SOUND_WEAPON_PLASMACASTER          = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.plasmacaster"));
    public static final Sound  SOUND_WEAPON_PLASMACASTER_CHARGE   = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.plasmacaster.charge"));
    public static final Sound  SOUND_WEAPON_PLASMACASTER_NOENERGY = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.plasmacaster.noenergy"));
    public static final Sound  SOUND_WEAPON_PLASMA_EXPLOSION      = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.plasmacaster.explosion"));
    public static final Sound  SOUND_WEAPON_WRISTBLADES           = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.blades"));
    public static final Sound  SOUND_WEAPON_SNIPER                = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.sniper"));
    public static final Sound  SOUND_WEAPON_PULSERIFLE            = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.pulserifle"));
    public static final Sound  SOUND_WEAPON_M56SG                 = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "weapon.m56sg"));
    public static final Sound  SOUND_MOTIONTRACKER_PING           = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "motiontracker.ping"));
    public static final Sound  SOUND_MOTIONTRACKER_PONG           = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "motiontracker.pong"));
    public static final Sound  SOUND_BLASTDOOR_OPEN               = new Sound(new ResourceLocation(AliensVsPredator.Properties.DOMAIN + "blocks.blastdoor.open"));

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        for (Field field : this.getClass().getDeclaredFields())
        {
            if (field.getType() == Sound.class)
            {
                try
                {
                    field.setAccessible(true);
                    Sound sound = (Sound) field.get(this);
                    sound.register(sound.getLocation().getResourcePath());
                }
                catch (Exception e1)
                {
                    try
                    {
                        MDX.log().info(String.format("Failed to register sound %s: %s", ((Sound) field.get(this)).getLocation(), e1));
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
