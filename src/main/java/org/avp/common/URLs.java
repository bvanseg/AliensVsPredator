package org.avp.common;

public class URLs
{
    private URLs() {}

    public static final String DOMAIN              = "https://aliensvspredator.org";
    public static final String UPDATER             = DOMAIN + "/page/beta/aliensvspredator/latest.php";
    public static final String SUBMIT_FEEDBACK     = DOMAIN + "/page/beta/submit.php?user=%s&uuid=%s&info=%s";
    public static final String FEEDBACK_VALIDATION = DOMAIN + "/page/beta/validate.php?uuid=%s";
    public static final String SKINS               = DOMAIN + "/page/skins";
    public static final String SKIN_AK47           = SKINS + "/ak47/%s.png";
    public static final String SKIN_M4             = SKINS + "/m4/%s.png";
    public static final String SKIN_M41A           = SKINS + "/m41a/%s.png";
    public static final String SKIN_M56SG          = SKINS + "/m56sg/%s.png";
    public static final String SKIN_SNIPER         = SKINS + "/sniper/%s.png";
}
