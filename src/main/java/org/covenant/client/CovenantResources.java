package org.covenant.client;


import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.texture.Texture;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.AVP;
import org.covenant.client.model.entity.ModelSporePod;
import org.covenant.client.model.skull.ModelNeomorphSkull;
import org.covenant.client.model.skull.ModelProtomorphSkull;
import org.covenant.client.model.tile.plant.ModelGroundFern;
import org.covenant.client.model.tile.plant.ModelTreeFern;

@SideOnly(Side.CLIENT)
public class CovenantResources {

    private CovenantResources() {}

    @SideOnly(Side.CLIENT)
    public static class Models {

        private Models() {}

        public static final MapModelTexture<ModelProtomorphSkull> PROTOMORPH_SKULL = new MapModelTexture<>(new ModelProtomorphSkull(), new Texture(AVP.Properties.ID, "textures/tile/skulls/protomorph_skull.png"));
        public static final MapModelTexture<ModelNeomorphSkull> NEOMORPH_SKULL = new MapModelTexture<>(new ModelNeomorphSkull(), new Texture(AVP.Properties.ID, "textures/tile/skulls/neomorph_skull.png"));

        public static final MapModelTexture<ModelGroundFern> GROUND_FERN = new MapModelTexture<>(new ModelGroundFern(), new Texture(AVP.Properties.ID, "textures/tile/plants/paradisiangroundfern.png"));
        public static final MapModelTexture<ModelTreeFern> TREE_FERN = new MapModelTexture<>(new ModelTreeFern(), new Texture(AVP.Properties.ID, "textures/tile/plants/paradisiantreefern.png"));
        public static final MapModelTexture<ModelSporePod> SPORE_POD = new MapModelTexture<>(new ModelSporePod(), new Texture(AVP.Properties.ID, "textures/mob/sporepods.png"));
    }
}
