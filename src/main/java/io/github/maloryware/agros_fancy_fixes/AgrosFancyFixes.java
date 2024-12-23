package io.github.maloryware.agros_fancy_fixes;

import io.github.maloryware.agros_fancy_fixes.recipe.RecipeUtils;
import io.github.maloryware.agros_fancy_fixes.util.LootTableModifications;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


// ok let's see
// TODO:
//  Figure out a way to make the Enchanted Books -> Essence shit work.
//

// DONE:
//  Iron golems no longer drop ingots.
//	Disable all diamond recipes

public class AgrosFancyFixes implements ModInitializer {
	public static final String MOD_ID = "agros-fancy-fixes";

	public static final Logger AGROLOGGER = LoggerFactory.getLogger(MOD_ID);

	public static Identifier id(String path){
		return Identifier.of(MOD_ID, path);
	}

	public static String idString(String path){
		return MOD_ID + ":" + path;
	}

	@Override
	public void onInitialize() {

		AGROLOGGER.info("Hello Agro world!");

		LootTableModifications.init();
		RecipeUtils.Serializers.register();

	}
}