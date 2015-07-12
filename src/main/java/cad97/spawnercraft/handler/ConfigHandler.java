package cad97.spawnercraft.handler;

import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

public class ConfigHandler
{
	public static Configuration config;

	public static boolean spawnerCraftable;
	public static boolean spawnerDropRequireSilk;
	public static boolean requireMobFishing;

	public static void init(File configFile)
	{
		// Create configuration object from given file
		if (config == null)
		{
			config = new Configuration(configFile);
			loadConfiguration();
		}

		LogHelper.info("ConfigHandler initialized");
	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event)
	{
		if (event.modID.equalsIgnoreCase(Reference.MOD_ID))
		{
			loadConfiguration();
		}
	}

	private static void loadConfiguration()
	{
		spawnerCraftable = config.get(Configuration.CATEGORY_GENERAL, "spawnerCraftable", false, "Whether you can craft an Empty Spawner from iron bars").setRequiresMcRestart(true).getBoolean();
		spawnerDropRequireSilk = config.get(Configuration.CATEGORY_GENERAL, "spawnerDropRequireSilk",  false, "Whether Empty Spawner drop requires Silk Touch").getBoolean();
		requireMobFishing = config.get(Configuration.CATEGORY_GENERAL, "requireMobFishing", true, "Whether a Mob Fishing Pole is required to drop Essence of Mob").getBoolean();

		if (config.hasChanged())
		{
			config.save();
		}
	}
}
