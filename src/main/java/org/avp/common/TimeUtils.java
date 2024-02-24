package org.avp.common;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Boston Vanseghi
 */
public class TimeUtils {

    public static boolean isHalloween() {
        LocalDate now = LocalDate.now();
        return now.getMonth() == Month.OCTOBER && now.getDayOfMonth() == 31;
    }

    private TimeUtils() { throw new UnsupportedOperationException(); }
}
