package org.avp.common.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Boston Vanseghi
 */
public class ConfigValue {

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Category {}

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Number {
        long minValue() default 0;

        long maxValue() default 100;

        String description() default "";

        boolean requiresRestart() default false;
    }

    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Decimal {
        double minValue() default 0;

        double maxValue() default 100;

        String description() default "";

        boolean requiresRestart() default false;
    }
}
