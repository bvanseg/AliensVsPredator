package org.avp.common.config;

public class ConfigLabel {
    public @interface Number {
        int minValue() default 0;

        int maxValue() default 100;
    }
}
