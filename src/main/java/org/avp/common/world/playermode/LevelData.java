package org.avp.common.world.playermode;

import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LevelData
{
    private final int level;
//    private Achievement achievement;

    @SideOnly(Side.CLIENT)
    private MapModelTexture<? extends Model> modelTexMap;

    public LevelData(int level)
    {
        this.level = level;
    }

    public boolean isPlayerLevelReached(EntityPlayer player)
    {
        return player.experienceLevel >= this.level;
    }

    public boolean isLevelReached(int level)
    {
        return level >= this.level;
    }

    public int getLevel()
    {
        return level;
    }

    public MapModelTexture<? extends Model> getModelTexMap()
    {
        return modelTexMap;
    }

//    public Achievement getAchievement()
//    {
//        return achievement;
//    }

    @SideOnly(Side.CLIENT)
    public LevelData setModelTexMap(MapModelTexture<? extends Model> modelTexMap)
    {
        this.modelTexMap = modelTexMap;
        return this;
    }
}
