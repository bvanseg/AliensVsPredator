package org.avp.common.world;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.Resources;
import org.avp.common.AVPItems;
import org.avp.common.item.firearm.ItemFirearm;

public enum MarineTypes
{
    M4(0, (ItemFirearm) AVPItems.ITEM_M4),
    AK47(1, (ItemFirearm) AVPItems.ITEM_AK47),
    M41A(2, (ItemFirearm) AVPItems.ITEM_M41A),
    SNIPER(3, (ItemFirearm) AVPItems.ITEM_SNIPER),
    M56SG(4, (ItemFirearm) AVPItems.ITEM_M56SG);

    private final int id;
    private final ItemFirearm itemFirearm;

    MarineTypes(int id, ItemFirearm itemFirearm)
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
                return Resources.instance.models().M4;
            case AK47:
                return Resources.instance.models().AK47;
            case M41A:
                return Resources.instance.models().M41A;
            case SNIPER:
                return Resources.instance.models().SNIPER;
            case M56SG:
                return Resources.instance.models().M56SG;
        }

        return null;
    }
}
