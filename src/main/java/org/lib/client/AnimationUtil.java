package org.lib.client;

public class AnimationUtil {

    private AnimationUtil() {}

    public static float lerp(float pointA, float pointB, float percentage) {
        return (pointA * (1.0f - percentage)) + (pointB * percentage);
    }
}
