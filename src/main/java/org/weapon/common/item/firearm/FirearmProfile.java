package org.weapon.common.item.firearm;

import com.asx.mdx.client.sound.Sound;
import org.avp.client.AVPSounds;

import java.util.ArrayList;

/**
 * A singleton used to register types of firearms.
 */
public class FirearmProfile
{
    private static final ArrayList<FirearmProfile> FIREARMS         = new ArrayList<>();
    private static int                             lastRegisteredId = 0;

    public static FirearmProfile getFirearmForGlobalId(int globalId)
    {
        for (FirearmProfile firearm : FirearmProfile.FIREARMS)
        {
            if (firearm.getGlobalId() == globalId)
            {
                return firearm;
            }
        }

        return null;
    }
    
    private final Classification classification;
    private int            ammoMax;
    private int            ammoConsumptionRate;
    private float          recoil;
    private double         rpm;
    private int            reloadTime;
    private double         soundLength;
    private Sound          sound;

    private int            globalId;

    public FirearmProfile(Classification classification)
    {
        this.globalId = -1;
        this.classification = classification;
        this.ammoMax = 128;
        this.recoil = 0.2F;
        this.rpm = 400;
        this.reloadTime = 6 * 20;
        this.ammoConsumptionRate = 1;
        this.soundLength = 0;
        this.sound = AVPSounds.FX_WEAPON_PISTOL;
        this.register();
    }

    public FirearmProfile register()
    {
        if (this.globalId == -1)
        {
            FIREARMS.add(this);
            this.globalId = lastRegisteredId++;
        }

        return this;
    }

    public int getGlobalId()
    {
        return globalId;
    }

    public Classification getClassification()
    {
        return classification;
    }

    public FirearmProfile setAmmoMax(int ammoMax)
    {
        this.ammoMax = ammoMax;
        return this;
    }

    public int getAmmoMax()
    {
        return ammoMax;
    }

    public FirearmProfile setRecoil(float recoil)
    {
        this.recoil = recoil;
        return this;
    }

    public float getRecoil()
    {
        return recoil;
    }

    public FirearmProfile setRoundsPerMinute(double rpm)
    {
        this.rpm = rpm;
        return this;
    }

    public double getRoundsPerMinute()
    {
        return rpm;
    }
    
    public int getShotsPerTick()
    {
        return (int) Math.round(this.rpm / 20);
    }

    public FirearmProfile setReloadTime(int reloadTime)
    {
        this.reloadTime = reloadTime;
        return this;
    }

    public int getReloadTime()
    {
        return reloadTime;
    }

    public FirearmProfile setSound(Sound sound)
    {
        this.sound = sound;
        return this;
    }

    public Sound getSound()
    {
        return sound;
    }

    public FirearmProfile setAmmoConsumptionRate(int ammoConsumptionRate)
    {
        this.ammoConsumptionRate = ammoConsumptionRate;
        return this;
    }

    public int getAmmoConsumptionRate()
    {
        return ammoConsumptionRate;
    }

    public FirearmProfile setSoundLength(double seconds)
    {
        this.soundLength = seconds;
        return this;
    }

    public double getSoundLength()
    {
        return this.soundLength;
    }
}

