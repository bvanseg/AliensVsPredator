package org.avp.common.network;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.registries.DataSerializerEntry;
import org.avp.AVP;
import org.avp.common.entity.living.MarineDecorator;
import org.predator.common.entity.state.CloakState;

/**
 *
 * @author Boston Vanseghi
 *
 */
public class AvpDataSerializers implements IInitEvent {
	public static final AvpDataSerializers instance = new AvpDataSerializers();
	private AvpDataSerializers() {}
	
	public static final DataSerializer<CloakState> CLOAK_STATE = new DataSerializer<CloakState>() {
		
        public void write(PacketBuffer buf, CloakState value) {
            buf.writeEnumValue(value);
        }
        
        public CloakState read(PacketBuffer buf) {
            return buf.readEnumValue(CloakState.class);
        }
        
        public DataParameter<CloakState> createKey(int id) {
            return new DataParameter<>(id, this);
        }
        
        public CloakState copyValue(CloakState value) {
            return value;
        }
    };

    public static final DataSerializer<MarineDecorator.MarineRank> MARINE_RANK = new DataSerializer<MarineDecorator.MarineRank>() {

        public void write(PacketBuffer buf, MarineDecorator.MarineRank value) {
            buf.writeEnumValue(value);
        }

        public MarineDecorator.MarineRank read(PacketBuffer buf) {
            return buf.readEnumValue(MarineDecorator.MarineRank.class);
        }

        public DataParameter<MarineDecorator.MarineRank> createKey(int id) {
            return new DataParameter<>(id, this);
        }

        public MarineDecorator.MarineRank copyValue(MarineDecorator.MarineRank value) {
            return value;
        }
    };

    @Override
    public void init(FMLInitializationEvent event) {
        ForgeRegistries.DATA_SERIALIZERS.register(new DataSerializerEntry(CLOAK_STATE).setRegistryName(AVP.Properties.ID, "cloak_state"));
        ForgeRegistries.DATA_SERIALIZERS.register(new DataSerializerEntry(MARINE_RANK).setRegistryName(AVP.Properties.ID, "marine_rank"));
        // TODO: Use forge registry, instead.
//    	DataSerializers.registerSerializer(CLOAK_STATE);
//        DataSerializers.registerSerializer(MARINE_RANK);
    }
}
