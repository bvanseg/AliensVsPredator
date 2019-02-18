package org.avp.client.render;

import com.asx.mdx.lib.util.MDXMath;

public enum XenomorphJawState
{
    CLOSED(0, 43, 40),
    OPEN(1.5F, 65, 60);
    
    public final float jawOffset;
    public final float lowerJawAngle;
    public final float innerJawAngle;
    
    XenomorphJawState(float jawOffset, float lowerJawAngle, float innerJawAngle)
    {
        this.jawOffset = jawOffset;
        this.lowerJawAngle = lowerJawAngle;
        this.innerJawAngle = innerJawAngle;
    }
    
    public static float interpolateLowerJawAngle(float progress)
    {
        return MDXMath.interpolateRotation(CLOSED.lowerJawAngle, OPEN.lowerJawAngle, progress);
    }
    
    public static float interpolateInnerJawAngle(float progress)
    {
        return MDXMath.interpolateRotation(CLOSED.innerJawAngle, OPEN.innerJawAngle, progress);
    }
    
    public static float calculateJawOffset(float progress)
    {
        return progress * OPEN.jawOffset;
    }
}