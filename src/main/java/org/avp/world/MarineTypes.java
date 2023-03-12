package org.avp.world;

import org.avp.AliensVsPredator;
import org.avp.item.firearms.ItemFirearm;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public enum MarineTypes
{
    M4(0, (ItemFirearm) AliensVsPredator.items().itemM4), AK47(1, (ItemFirearm) AliensVsPredator.items().itemAK47), M41A(2, (ItemFirearm) AliensVsPredator.items().itemM41A), SNIPER(3, (ItemFirearm) AliensVsPredator.items().itemSniper), M56SG(4, (ItemFirearm) AliensVsPredator.items().itemM56SG);

    private int id;
    private ItemFirearm itemFirearm;

    private MarineTypes(int id, ItemFirearm itemFirearm)
    {
        this.id = id;
        this.itemFirearm = itemFirearm;
    }

    public int getValue()
    {
        return id;
    }

    public SoundEvent getGunfireSound()
    {
        return itemFirearm.getProfile().getSound().event();
    }

    public ItemFirearm getFirearmItem()
    {
        return itemFirearm;
    }

    public static MarineTypes getTypeForId(int id)
    {
        for (MarineTypes type : values())
        {
            if (type.id == id)
            {
                return type;
            }
        }

        return null;
    }

    @SideOnly(Side.CLIENT)
    public MapModelTexture<? extends Model> getFirearmModelTexMap()
    {
        switch (this)
        {
            case M4:
                return AliensVsPredator.resources().models().M4;
            case AK47:
                return AliensVsPredator.resources().models().AK47;
            case M41A:
                return AliensVsPredator.resources().models().M41A;
            case SNIPER:
                return AliensVsPredator.resources().models().SNIPER;
            case M56SG:
                return AliensVsPredator.resources().models().M56SG;
        }

        return null;
    }
}
