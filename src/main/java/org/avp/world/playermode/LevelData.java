package org.avp.world.playermode;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.TexturedModel;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.Achievement;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class LevelData
{
    private int level;
    private Achievement achievement;

    @SideOnly(Side.CLIENT)
    private TexturedModel<? extends Model> modelTexMap;

    public LevelData(int level)
    {
        this(level, null);
    }

    public LevelData(int level, Achievement achievement)
    {
        this.level = level;
        this.achievement = achievement;
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

    public TexturedModel<? extends Model> getModelTexMap()
    {
        return modelTexMap;
    }

    public Achievement getAchievement()
    {
        return achievement;
    }

    @SideOnly(Side.CLIENT)
    public LevelData setModelTexMap(TexturedModel<? extends Model> modelTexMap)
    {
        this.modelTexMap = modelTexMap;
        return this;
    }
}
