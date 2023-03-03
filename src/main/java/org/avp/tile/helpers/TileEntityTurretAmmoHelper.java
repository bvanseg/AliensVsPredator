package org.avp.tile.helpers;

import java.util.ArrayList;

import org.avp.AliensVsPredator;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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
    private int curAmmo;
    private int rounds;
    private int roundsMax;
    
    public TileEntityTurretAmmoHelper() {
        this.inventoryAmmo = new InventoryBasic("TurretAmmoBay", true, 9);
        this.itemAmmo = AliensVsPredator.items().itemAmmoSMG;
        this.curAmmo = 0;
        this.ammoDisplayEnabled = false;
    }
    
    public void update(World world, Pos pos) {
        this.pickUpAmmunition(world, pos);
        this.updateAmmunitionCount(world);
        this.tryReload();
    }

    public void tryReload() {
        if (this.curAmmo < this.getMaxAmmo() && this.curAmmo <= 0)
        {
            this.reload();
        }
    }

    public void updateAmmunitionCount(World world)
    {
        if (world.getTotalWorldTime() % 8L == 0L)
        {
            this.roundsMax = (9 * 64);
            this.rounds = 0;

            for (int i = 0; i < 9; i++)
            {
                ItemStack stack = this.inventoryAmmo.getStackInSlot(i);

                if (stack != null)
                {
                    if (stack.getItem() == this.itemAmmo)
                    {
                        this.rounds = this.rounds + (stack.getCount());
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
        if (this.rounds >= 1)
        {
            this.curAmmo = this.getMaxAmmo();

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

    public int getCurAmmo()
    {
        return curAmmo;
    }

    public int getMaxAmmo()
    {
        return 128;
    }

    public void setCurAmmo(int curAmmo)
    {
        this.curAmmo = curAmmo;
    }

    public Item getItemAmmo()
    {
        return itemAmmo;
    }

    public void setItemAmmo(Item itemAmmo)
    {
        this.itemAmmo = itemAmmo;
    }

    public int getCurRounds()
    {
        return rounds;
    }

    public int getMaxRounds()
    {
        return roundsMax;
    }

    public void setCurRounds(int curRounds)
    {
        this.rounds = curRounds;
    }

    public void setMaxRounds(int maxRounds)
    {
        this.roundsMax = maxRounds;
    }
}
