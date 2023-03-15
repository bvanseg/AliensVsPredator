package org.predator.client.input.handler;

import com.asx.mdx.lib.util.Game;
import org.avp.client.KeybindHandler;
import org.avp.client.input.IInputHandler;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.server.PacketPlasmaDischarge;
import org.predator.client.PredatorSounds;
import org.predator.common.item.ItemWristbracer;

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
            float potentialChargeSize = Math.min(this.chargeSize, this.getMaxChargeSize());
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

            if (KeybindHandler.instance.specialSecondary.isKeyDown())
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
        PredatorSounds.WEAPON_PLASMACASTER_NOENERGY.playSound(Game.minecraft().player, 0.6F, 1.0F);;
    }

    private void onChargeStart()
    {
        PredatorSounds.WEAPON_PLASMACASTER_CHARGE.playSound(Game.minecraft().player, 0.6F, 1.0F);;
    }

    private void onChargeRelease(float chargeSize, float energyUsed)
    {
        this.energy -= energyUsed;
        AVPNetworking.instance.sendToServer(new PacketPlasmaDischarge(chargeSize));
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
