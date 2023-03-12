package org.avp.util.brain.flag;

/**
 * This type of flag represents states that are not bound to memory (Ex. the entity does not 'remember' movement or look states
 * since there is nothing to remember. However, the fact that the entity *is* moving is important, because almost all entities
 * can only move towards a single task at a time.
 * 
 * @author Boston Vanseghi
 *
 */
public class BrainActionFlag extends AbstractBrainFlag {
	
	public BrainActionFlag(String identifier) {
		super(identifier);
	}
	
}
