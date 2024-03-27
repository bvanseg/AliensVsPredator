package org.avp.api.item.weapon;

public class FireModes {

    public static final FireMode AUTOMATIC = new FireMode();

    public static final FireMode SEMI_AUTOMATIC = new FireMode();

    private FireModes() {
        throw new UnsupportedOperationException();
    }
}
