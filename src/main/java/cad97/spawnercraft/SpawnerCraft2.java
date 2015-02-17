package cad97.spawnercraft;

import cad97.spawnercraft.handler.ConfigHandler;
import cad97.spawnercraft.handler.DropsListener;
import cad97.spawnercraft.init.ModBlocks;
import cad97.spawnercraft.init.ModItems;
import cad97.spawnercraft.init.ModRecipes;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class SpawnerCraft2
{
	@Mod.Instance(Reference.MOD_ID)
	public static SpawnerCraft2 instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigHandler());

		ModItems.init();
		ModBlocks.init();

		LogHelper.info(Reference.MOD_NAME + " preInit finished");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		MinecraftForge.EVENT_BUS.register(DropsListener.instance);

		ModRecipes.init();

		LogHelper.info(Reference.MOD_NAME + " init finished");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//stub
		LogHelper.info(Reference.MOD_NAME + " postInit finished");
	}
}
