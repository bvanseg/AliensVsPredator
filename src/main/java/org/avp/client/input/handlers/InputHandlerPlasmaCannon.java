package org.avp.client.input.handlers;

import org.avp.AliensVsPredator;
import org.avp.client.Sounds;
import org.avp.client.input.IInputHandler;
import org.avp.common.item.ItemWristbracer;
import org.avp.common.packets.server.PacketPlasmaDischarge;

import com.asx.mdx.lib.util.Game;

public class InputHandlerPlasmaCannon implements IInputHandler
{
    public static final InputHandlerPlasmaCannon instance = new InputHandlerPlasmaCannon();

    private float                                chargeSize;
    private float                                chargeSizePrev;
    private float                                energy;
    private boolean                              recharging;

    @Override
    public void handleInput()
    {
        if (ItemWristbracer.hasPlasmaCannon(ItemWristbracer.wristbracer(Game.minecraft().player)))
        {
            float potentialChargeSize = this.chargeSize >= this.getMaxChargeSize() ? this.getMaxChargeSize() : this.chargeSize;
            float potentialEnergyUsed = this.getMaxStoredEnergy() * potentialChargeSize / this.getMaxChargeSize();
            
            if (this.energy <= this.getMaxStoredEnergy() / 20)
            {
                this.recharging = true;
            }

            if (this.energy < this.getMaxStoredEnergy())
            {
                this.energy++;
            }
            else if (this.energy >= this.getMaxStoredEnergy())
            {
                this.recharging = false;
            }

            if (AliensVsPredator.keybinds().specialSecondary.isKeyDown())
            {
                if (this.energy >= potentialEnergyUsed && !this.recharging)
                {
                    if (this.chargeSize == 0)
                    {
                        this.onChargeStart();
                    }

                    this.chargeSize += this.getRechargeRate();
                }
                else
                {
                    this.onNoEnergy();
                }
            }

            if (this.chargeSize == this.chargeSizePrev)
            {
                this.chargeSize = 0F;
            }

            if (this.chargeSize == 0F && this.chargeSizePrev != 0F)
            {
                if (this.energy >= potentialEnergyUsed)
                {
                    this.onChargeRelease(potentialChargeSize, potentialEnergyUsed);
                }
            }

            this.chargeSizePrev = this.chargeSize;
        }
    }

    private void onNoEnergy()
    {
        Sounds.WEAPON_PLASMACASTER_NOENERGY.playSound(Game.minecraft().player, 0.6F, 1.0F);;
    }

    private void onChargeStart()
    {
        Sounds.WEAPON_PLASMACASTER_CHARGE.playSound(Game.minecraft().player, 0.6F, 1.0F);;
    }

    private void onChargeRelease(float chargeSize, float energyUsed)
    {
        this.energy -= energyUsed;
        AliensVsPredator.network().sendToServer(new PacketPlasmaDischarge(chargeSize));
    }

    public float getChargeSize()
    {
        return this.chargeSize;
    }

    public float getMaxChargeSize()
    {
        return 1.0F;
    }

    public float getRechargeRate()
    {
        return 0.025F;
    }

    public float getMaxStoredEnergy()
    {
        return 20 * 10;
    }

    public float getStoredEnergy()
    {
        return this.energy;
    }
    
    public boolean isRecharging()
    {
        return recharging;
    }
}
