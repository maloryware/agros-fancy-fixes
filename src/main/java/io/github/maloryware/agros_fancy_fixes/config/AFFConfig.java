package io.github.maloryware.agros_fancy_fixes.config;

import com.google.common.collect.Lists;
import eu.midnightdust.lib.config.MidnightConfig;

import java.util.List;

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

    /* General tab*/
    @Server
    @Entry(category = GENERAL) public static boolean maintenance_mode = false;

    @Server
    @Entry(category = GENERAL) public static boolean should_prefix_commands = false;

    @Server
    @Entry(category = GENERAL) public static String maintenance_motd = "server closed for maintenance, brb!";

    @Server
    @Entry(category = GENERAL) public static List<String> allowed_maintenance_playerlist = Lists.newArrayList("");

    @Comment(category = GENERAL, centered = true) public static Comment recipes_divider;
    @Entry(category = GENERAL) public static boolean enable_diamond_recipes = false;
    @Entry(category = GENERAL) public static boolean enable_better_enchantment_recipes = false;
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


}
