package org.predator.common.entity.state;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Boston Vanseghi
 *
 */
public enum CloakState {
	CLOAKED(0),
	CLOAKING(1),
	DECLOAKED(2),
	DECLOAKING_FORCED(3),
	DECLOAKING_MANUAL(4);
	
	public int id;
	
	CloakState(int id) {
		this.id = id;
	}
	
	private static final HashMap<Integer, CloakState> valuesById = new HashMap<>();
	
	static {
		for (CloakState value: CloakState.values()) {
			valuesById.put(value.id, value);
		}
	}
	
	public static Map<Integer, CloakState> getValuesByIdMap() {
		return Collections.unmodifiableMap(valuesById);
	}
	
	public CloakState getById(int id) {
		return valuesById.get(id);
	}
}