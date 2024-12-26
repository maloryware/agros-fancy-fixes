package io.github.maloryware.agros_fancy_fixes.config;

import eu.midnightdust.lib.config.MidnightConfig;

// lang format: agros-fancy-fixes.midnightconfig.objectname(.tooltip)
// enums: (...) .enum.EnumName.VALUE
// always have a title!

/**
 * Color codes:
 * <pre>
 * {@code
 * DARK RED = "§4";
 * RED = "§c";
 * GOLD = "§6";
 * YELLOW = "§e";
 * DARK GREEN = "§2";
 * GREEN = "§a";
 * AQUA = "§b";
 * DARK AQUA = "§3";
 * DARK BLUE = "§1";
 * BLUE = "§9";
 * LIGHT PURPLE = "§d";
 * DARK PURPLE = "§5";
 * WHITE = "§f";
 * GRAY = "§7";
 * DARK GRAY = "§8";
 * BLACK = "§0";
 * OBF = "§k";
 * BOLD = "§l";
 * STRIKE = "§m";
 * UNDERLINE = "§n";
 * ITALIC = "§o";
 * RESET = "§r";
 * }
 * </pre>
 */
@SuppressWarnings("unused")
public class AFFConfig extends MidnightConfig {

    public static final String GENERAL = "general";
    public static final String MODS = "mods";
    public static final String INFO = "info";

    /* General tab*/
    @Comment(category = GENERAL, centered = true) public static Comment recipes_divider;
    @Entry(category = GENERAL) public static boolean enableDiamondRecipes = false;
    @Comment(category = GENERAL, centered = true) public static Comment general_spacer;

    /* Mods tab  */

    // Header - Dungeons and Taverns
    @Comment(category = MODS, centered = true) public static Comment dnt_divider;
    @Entry(category = MODS) public static E2EConversion enchant_conversion = E2EConversion.FIXED;


    public enum E2EConversion {
        DISABLED,
        FIXED,
        SCALING_STATIC,
        SCALING_DYNAMIC
    }
    @Comment(category = MODS, centered = true) public static Comment mods_spacer;

    /* Info tab */

    // Title
    @Comment(category = INFO, centered = true) public static Comment info_title;
    @Comment(category = INFO) public static Comment info_intro;
    // Header - Mods
    @Comment(category = INFO, centered = true) public static Comment info_spacer;
    @Comment(category = INFO, centered = true) public static Comment header_general;
    @Comment(category = INFO, centered = true) public static Comment general_recipes;
    @Comment(category = INFO) public static Comment general_recipes_title1;
    @Comment(category = INFO) public static Comment general_recipes_field1;
    @Comment(category = INFO) public static Comment info_spacer2;
    @Comment(category = INFO, centered = true) public static Comment header_mods;
    @Comment(category = INFO, centered = true) public static Comment mods_dnt;
    @Comment(category = INFO) public static Comment mods_dnt_title1;
    @Comment(category = INFO) public static Comment mods_dnt_field1;



}
