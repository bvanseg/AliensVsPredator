package org.avp.common;

import net.minecraft.entity.Entity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import org.weapon.common.entity.EntityFlame;

public class AVPDamageSources extends DamageSource
{
    public static final String WRISTBRACER = "wristbracer";

    public static final DamageSource ACID = (new DamageSource("acid")).setDamageBypassesArmor();
    public static final DamageSource ELECTRICITY = (new DamageSource("electricity")).setDamageBypassesArmor();
    public static final DamageSource ACID_PROJECTILE = (new DamageSource("acidshot")).setDamageBypassesArmor().setProjectile();
    public static final DamageSource CHESTBURSTER = (new DamageSource("chestburster")).setDamageIsAbsolute().setDamageBypassesArmor();
    public static final DamageSource DEACON_BURSTER = (new DamageSource("deaconBurster")).setDamageIsAbsolute().setDamageBypassesArmor();
    public static final DamageSource VARDA_ATMOSPHERE = new DamageSource("atmosphere.varda").setDamageBypassesArmor();
    public static final DamageSource BULLET = (new DamageSource("bullet")).setProjectile();
    public static final DamageSource SMART_DISC = (new DamageSource("smartdisc")).setProjectile();
    public static final DamageSource SHURIKEN = (new DamageSource("shuriken")).setProjectile();
    public static final DamageSource SPEAR = (new DamageSource("spear")).setProjectile();
    public static final DamageSource PLASMA_CASTER = (new DamageSource("plasmacaster")).setProjectile().setMagicDamage().setDamageBypassesArmor();
    public static final DamageSource FLAMETHROWER = (new DamageSource("flamethrower")).setProjectile().setFireDamage().setDifficultyScaled();
    public static final DamageSource LASER_MINE = (new DamageSource("laserMine")).setProjectile().setExplosion();
    public static final DamageSource SILICA_STORM = (new DamageSource("silicaStorm")).setDifficultyScaled().setDamageBypassesArmor().setDamageIsAbsolute();

    public AVPDamageSources(String source)
    {
        super(source);
    }

    public static DamageSource causeLaserMineDamage(Entity entityLaserMine, Entity entity)
    {
        return (new EntityDamageSourceIndirect(LASER_MINE.getDamageType(), entityLaserMine, entity)).setProjectile().setExplosion();
    }

    public static DamageSource causePlasmaCasterDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(PLASMA_CASTER.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeSpearDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(SPEAR.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeShurikenDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(SHURIKEN.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeSmartDiscDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(SMART_DISC.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeBulletDamage(Entity sourceEntity)
    {
        return (new EntityDamageSource(BULLET.getDamageType(), sourceEntity)).setProjectile();
    }

    public static DamageSource causeChestbursterDamage(Entity sourceEntity, Entity entity)
    {
        return (new EntityDamageSourceIndirect(CHESTBURSTER.getDamageType(), sourceEntity, entity)).setDamageIsAbsolute().setDamageBypassesArmor();
    }

    public static DamageSource causeDeaconBursterDamage(Entity sourceEntity, Entity entity)
    {
        return (new EntityDamageSourceIndirect(DEACON_BURSTER.getDamageType(), sourceEntity, entity)).setDamageIsAbsolute().setDamageBypassesArmor();
    }

    public static DamageSource causeAcidicProjectileDamage(Entity sourceEntity, Entity entity)
    {
        return (new EntityDamageSourceIndirect(ACID_PROJECTILE.getDamageType(), sourceEntity, entity)).setProjectile();
    }

    public static DamageSource causeFlamethrowerDamage(EntityFlame entityFlame)
    {
        return (new EntityDamageSource(FLAMETHROWER.getDamageType(), entityFlame).setProjectile().setFireDamage().setDifficultyScaled());
    }
}
