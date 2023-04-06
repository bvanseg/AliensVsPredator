package org.lib.common;

import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * @author Boston Vanseghi
 */
public class StreamUtil {

    private StreamUtil() {}

    public static <T, R> Stream<R> mapNotNull(Stream<T> stream, Function<T, R> mapperFunction) {
        return stream.map(mapperFunction).filter(Objects::nonNull);
    }
}
