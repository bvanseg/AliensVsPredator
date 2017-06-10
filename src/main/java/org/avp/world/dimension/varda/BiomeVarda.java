package org.avp.world.dimension.varda;

import org.avp.AliensVsPredator;
import org.avp.entities.living.EntityDeaconShark;
import org.avp.world.dimension.BiomeGenLV;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeDecorator;

public class BiomeVarda extends BiomeGenLV
{
    public static BiomeVarda vardaBadlands = new BiomeVarda(new BiomeProperties(AliensVsPredator.properties().BIOME_NAME_VARDA_BADLANDS).setBaseHeight(1.0F).setHeightVariation(2.0F).setRainDisabled().setWaterColor(0xFFFF66));
    public static BiomeVarda vardaForest   = new BiomeVarda(new BiomeProperties(AliensVsPredator.properties().BIOME_NAME_VARDA_FOREST).setBaseHeight(1.0F).setHeightVariation(8.0F).setTemperature(0.7F).setRainfall(0.1F).setWaterColor(0xFFFF66));
    
    public BiomeVarda(BiomeProperties properties)
    {
        super(properties);
        this.topBlock = AliensVsPredator.blocks().unidirt.getDefaultState();
        this.fillerBlock = AliensVsPredator.blocks().unistone.getDefaultState();
        this.spawnableCaveCreatureList.clear();
        this.spawnableCreatureList.clear();
        this.spawnableMonsterList.clear();
        this.spawnableWaterCreatureList.clear();
        this.spawnableWaterCreatureList.add(new Biome.SpawnListEntry(EntityDeaconShark.class, 1, 0, 1));
    }
    
    @Override
    public BiomeDecorator createBiomeDecorator()
    {
        return this.theBiomeDecorator = new BiomeDecoratorVarda(this);
    }
}
