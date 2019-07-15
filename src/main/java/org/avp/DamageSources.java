package org.avp;

import org.avp.entities.EntityFlame;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;

public class DamageSources extends DamageSource
{
    public static DamageSource acid = (new DamageSource("acid")).setDamageBypassesArmor();
    public static DamageSource electricity = (new DamageSource("electricity")).setDamageBypassesArmor().setFireDamage();
    public static DamageSource acidProjectile = (new DamageSource("acidshot")).setDamageBypassesArmor().setProjectile();
    public static DamageSource chestburster = (new DamageSource("chestburster")).setDamageIsAbsolute().setDamageBypassesArmor();
    public static DamageSource deaconBurster = (new DamageSource("deaconBurster")).setDamageIsAbsolute().setDamageBypassesArmor();
    public static DamageSource vardaAtmosphere = new DamageSource("atmosphere.varda").setDamageBypassesArmor();
    public static DamageSource bullet = (new DamageSource("bullet")).setProjectile();
    public static DamageSource smartdisc = (new DamageSource("smartdisc")).setProjectile();
    public static DamageSource shuriken = (new DamageSource("shuriken")).setProjectile();
    public static DamageSource wristbracer = (new DamageSource("wristbracer"));
    public static DamageSource spear = (new DamageSource("spear")).setProjectile();
    public static DamageSource plasmacaster = (new DamageSource("plasmacaster")).setProjectile().setMagicDamage().setDamageBypassesArmor();
    public static DamageSource flamethrower = (new DamageSource("flamethrower")).setProjectile().setFireDamage().setDifficultyScaled();
    public static DamageSource laserMine = (new DamageSource("laserMine")).setProjectile().setExplosion();
    public static DamageSource silicaStorm = (new DamageSource("silicaStorm")).setDifficultyScaled().setDamageBypassesArmor().setDamageIsAbsolute();

    public DamageSources(String source)
    {
        super(source);
    }

    public static DamageSource causeLaserMineDamage(Entity entityLaserMine, Entity entity)
    {
        return (new EntityDamageSourceIndirect(laserMine.getDamageType(), entityLaserMine, entity)).setProjectile().setExplosion();
    }

    public static DamageSource causePlasmaCasterDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(plasmacaster.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeSpearDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(spear.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeWristbracerDamage(Entity sourceEntity)
    {
        return wristbracer;
    }

    public static DamageSource causeShurikenDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(shuriken.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeSmartDiscDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(smartdisc.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeBulletDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(bullet.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeChestbursterDamage(Entity sourceEntity, Entity entity)
    {
        return (new EntityDamageSourceIndirect(chestburster.getDamageType(), sourceEntity, entity)).setDamageIsAbsolute().setDamageBypassesArmor();
    }

    public static DamageSource causeDeaconBursterDamage(Entity sourceEntity, Entity entity)
    {
        return (new EntityDamageSourceIndirect(deaconBurster.getDamageType(), sourceEntity, entity)).setDamageIsAbsolute().setDamageBypassesArmor();
    }

    public static DamageSource causeAcidicProjectileDamage(Entity sourceEntity, Entity entity)
    {
        return (new EntityDamageSourceIndirect(acidProjectile.getDamageType(), sourceEntity, entity)).setProjectile();
    }

    public static DamageSource causeFlamethrowerDamage(EntityFlame entityFlame)
    {
        return (new EntityDamageSource(flamethrower.getDamageType(), entityFlame).setProjectile().setFireDamage().setDifficultyScaled());
    }
}
