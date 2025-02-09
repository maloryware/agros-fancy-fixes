package io.github.maloryware.agros_fancy_fixes;

import eu.midnightdust.lib.config.MidnightConfig;
import io.github.maloryware.agros_fancy_fixes.config.AFFConfig;
import io.github.maloryware.agros_fancy_fixes.enchantment.NovaEnchantments;
import io.github.maloryware.agros_fancy_fixes.util.Utils;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




// DONE:
//  Iron golems no longer drop ingots.
//	Disable all diamond recipes
//  Enchanted books can now be converted to Essence



public class AgrosFancyFixes implements ModInitializer {

	public static final String ID = "agros-fancy-fixes";
	public static final Logger AGROLOGGER = LoggerFactory.getLogger(ID);

	public static Identifier id(String path){
		return Identifier.of(ID, path);
	}

	@Override
	public void onInitialize() {


		AGROLOGGER.info("Hello Agro world!");

		NovaEnchantments.init();

		Utils.Events.init();
		//Utils.Datapacks.init();
		Utils.Serializers.register();
		MidnightConfig.init(ID, AFFConfig.class);



	}
}