package org.lib.common;

import java.util.function.Function;

/**
 * @author Boston Vanseghi
 */
public class FuncUtil {

    private FuncUtil() {}

    public static <T, R> R let(T value, Function<T, R> callback) {
        if (value == null) {
            return null;
        }
        return callback.apply(value);
    }
}
