package org.avp.common.network;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
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

    @Override
    public void init(FMLInitializationEvent event) {
		// TODO: Use forge registry, instead.
    	DataSerializers.registerSerializer(CLOAK_STATE);
    }
}
