package org.avp.common.world;

import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.avp.common.item.firearm.ItemFirearm;

public enum MarineTypes
{
    M4(0, (ItemFirearm) AVP.items().itemM4), AK47(1, (ItemFirearm) AVP.items().itemAK47), M41A(2, (ItemFirearm) AVP.items().itemM41A), SNIPER(3, (ItemFirearm) AVP.items().itemSniper), M56SG(4, (ItemFirearm) AVP.items().itemM56SG);

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
                return AVP.resources().models().M4;
            case AK47:
                return AVP.resources().models().AK47;
            case M41A:
                return AVP.resources().models().M41A;
            case SNIPER:
                return AVP.resources().models().SNIPER;
            case M56SG:
                return AVP.resources().models().M56SG;
        }

        return null;
    }
}
