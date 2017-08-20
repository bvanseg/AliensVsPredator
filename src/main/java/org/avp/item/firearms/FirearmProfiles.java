package org.avp.item.firearms;

import org.avp.client.Sounds;
import org.avp.item.ItemFirearm.Classification;
import org.avp.item.ItemFirearm.FirearmProfile;

public class FirearmProfiles
{
    public static final FirearmProfile SNIPER = new FirearmProfile(Classification.RIFLE).setAmmoMax(6).setRecoil(1.5F).setRoundsPerMinute(30).setReloadTime(150).setSound(Sounds.WEAPON_SNIPER);
    public static final FirearmProfile PISTOL = new FirearmProfile(Classification.PISTOL).setAmmoMax(12).setRecoil(2.0F).setRoundsPerMinute(80).setReloadTime(120).setSound(Sounds.WEAPON_GUNSHOT);
    public static final FirearmProfile M4     = new FirearmProfile(Classification.ASSAULT_RIFLE).setAmmoMax(24).setRecoil(0.5F).setRoundsPerMinute(800).setReloadTime(120).setSound(Sounds.WEAPON_GUNSHOT).setSoundLength(0.75D);
    public static final FirearmProfile M41A   = new FirearmProfile(Classification.ASSAULT_RIFLE).setAmmoMax(99).setRecoil(0.5F).setRoundsPerMinute(900).setReloadTime(120).setSound(Sounds.WEAPON_PULSERIFLE).setSoundLength(1.25D);
    public static final FirearmProfile M56SG  = new FirearmProfile(Classification.LIGHT_MACHINE_GUN).setAmmoMax(500).setRecoil(0.2F).setRoundsPerMinute(1200).setReloadTime(120).setSound(Sounds.WEAPON_M56SG);
    public static final FirearmProfile AK47   = new FirearmProfile(Classification.ASSAULT_RIFLE).setAmmoMax(32).setRecoil(0.6F).setRoundsPerMinute(600).setReloadTime(100).setSound(Sounds.WEAPON_GUNSHOT);
}
