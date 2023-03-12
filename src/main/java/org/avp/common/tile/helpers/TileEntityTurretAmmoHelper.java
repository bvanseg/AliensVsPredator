package org.avp.common.tile.helpers;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.avp.AVP;

import java.util.ArrayList;

/**
 * 
 * @author Ri5ux
 * @author Boston Vanseghi
 *
 */
public class TileEntityTurretAmmoHelper {
	
    public InventoryBasic inventoryAmmo;
    private Item itemAmmo;
    private boolean ammoDisplayEnabled;
    private int currentAmmoCount;
    private int currentRounds;
    private int roundsMax;
    
    public TileEntityTurretAmmoHelper() {
        this.inventoryAmmo = new InventoryBasic("TurretAmmoBay", true, 9);
        this.itemAmmo = AVP.items().itemAmmoSMG;
        this.currentAmmoCount = 0;
        this.ammoDisplayEnabled = false;
    }
    
    public void update(World world, Pos pos) {
        this.pickUpAmmunition(world, pos);
        this.updateAmmunitionCount(world);
        this.tryReload();
    }

    public void tryReload() {
        if (this.currentAmmoCount < this.getMaxAmmo() && this.currentAmmoCount <= 0)
        {
            this.reload();
        }
    }

    public void updateAmmunitionCount(World world)
    {
        if (world.getTotalWorldTime() % 8L == 0L)
        {
            this.roundsMax = (9 * 64);
            this.currentRounds = 0;

            for (int i = 0; i < 9; i++)
            {
                ItemStack stack = this.inventoryAmmo.getStackInSlot(i);

                if (stack != null)
                {
                    if (stack.getItem() == this.itemAmmo)
                    {
                        this.currentRounds = this.currentRounds + (stack.getCount());
                    }
                }
            }
        }
    }

    public void pickUpAmmunition(World world, Pos pos)
    {
        if (this.inventoryAmmo != null)
        {
            ArrayList<EntityItem> entityItemList = (ArrayList<EntityItem>) Entities.getEntitiesInCoordsRange(world, EntityItem.class, pos, 1);

            for (EntityItem entityItem : entityItemList)
            {
                if (!entityItem.cannotPickup())
                {
                    ItemStack stack = entityItem.getItem();

                    if (stack.getItem() == this.itemAmmo)
                    {
                        for (int x = 0; x < 9; x++)
                        {
                            ItemStack invStack = this.inventoryAmmo.getStackInSlot(x);

                            if (invStack == null || invStack != null && invStack.getCount() < 64)
                            {
                                this.inventoryAmmo.setInventorySlotContents(x, stack);
                                entityItem.setDead();
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    public void reload()
    {
        if (this.currentRounds >= 1)
        {
            this.currentAmmoCount = this.getMaxAmmo();

            for (int x = 0; x < 9; x++)
            {
                ItemStack stack = this.inventoryAmmo.getStackInSlot(x);

                if (stack != null && stack.getItem() == this.getItemAmmo())
                {
                    stack.shrink(1);

                    if (stack.getCount() <= 0)
                    {
                        this.inventoryAmmo.setInventorySlotContents(x, ItemStack.EMPTY);
                    }

                    break;
                }
            }
        }
    }

    public void setAmmoDisplayEnabled(boolean ammoDisplayEnabled)
    {
        this.ammoDisplayEnabled = ammoDisplayEnabled;
    }

    public boolean isAmmoDisplayEnabled()
    {
        return ammoDisplayEnabled;
    }

    public int getCurrentAmmo()
    {
        return currentAmmoCount;
    }

    public int getMaxAmmo()
    {
        return 128;
    }

    public void setCurrentAmmoCount(int currentAmmoCount)
    {
        this.currentAmmoCount = currentAmmoCount;
    }

    public Item getItemAmmo()
    {
        return itemAmmo;
    }

    public void setItemAmmo(Item itemAmmo)
    {
        this.itemAmmo = itemAmmo;
    }

    public int getCurrentRounds()
    {
        return currentRounds;
    }

    public int getMaxRounds()
    {
        return roundsMax;
    }

    public void setCurrentRounds(int currentRounds)
    {
        this.currentRounds = currentRounds;
    }

    public void setMaxRounds(int maxRounds)
    {
        this.roundsMax = maxRounds;
    }
	
    public void readFromNBT(NBTTagCompound nbt)
    {
        this.setCurrentAmmoCount(nbt.getInteger("CurrentAmmoCount"));
    }

    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("CurrentAmmoCount", this.getCurrentAmmo());
        return nbt;
    }
}
