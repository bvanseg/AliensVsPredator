package org.avp.network;

import java.io.IOException;

import org.avp.entities.state.CloakState;

import net.minecraft.network.PacketBuffer;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializer;
import net.minecraft.network.datasync.DataSerializers;

/**
 *
 * @author Boston Vanseghi
 *
 */
public class AvpDataSerializers {
	
	private AvpDataSerializers() {}
	
	public static final DataSerializer<CloakState> CLOAK_STATE = new DataSerializer<CloakState>() {
		
        public void write(PacketBuffer buf, CloakState value) {
            buf.writeEnumValue(value);
        }
        
        public CloakState read(PacketBuffer buf) throws IOException {
            return (CloakState)buf.readEnumValue(CloakState.class);
        }
        
        public DataParameter<CloakState> createKey(int id) {
            return new DataParameter<CloakState>(id, this);
        }
        
        public CloakState copyValue(CloakState value) {
            return value;
        }
    };
    
    public static void init() {
		// TODO: Use forge registry, instead.
    	DataSerializers.registerSerializer(CLOAK_STATE);
    }
}
