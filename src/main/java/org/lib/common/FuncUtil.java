package org.lib.common;

import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author Boston Vanseghi
 */
public class FuncUtil {

    private FuncUtil() {}

    public static <T, R> R let(T value, Function<T, R> callback) {
        if (value == null) return null;
        return callback.apply(value);
    }

    public static <T> void letc(T value, Consumer<T> callback) {
        if (value == null) return;
        callback.accept(value);
    }
}
