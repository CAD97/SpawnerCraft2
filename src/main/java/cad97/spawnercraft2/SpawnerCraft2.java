package cad97.spawnercraft2;

import cad97.spawnercraft2.reference.Reference;
import cad97.spawnercraft2.utility.LogHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION)
public class SpawnerCraft2
{
	@Mod.Instance(Reference.MOD_ID)
	public static SpawnerCraft2 instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		//stub
		LogHelper.info(Reference.MOD_NAME + " preInit finished");
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		//stub
		LogHelper.info(Reference.MOD_NAME + " init finished");
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//stub
		LogHelper.info(Reference.MOD_NAME + " postInit finished");
	}
}
