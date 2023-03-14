package org.alien.common.api.parasitoidic;

/**
 * Provides the ability to prevent certain entities from being infected by parasites 
 * or the ability to prevent said entities from being infected at the current time.
 */
public interface Host
{
    boolean canParasiteAttach();
    
    boolean canHostParasite();
}
