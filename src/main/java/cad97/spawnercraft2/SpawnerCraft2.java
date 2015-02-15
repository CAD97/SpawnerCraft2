package cad97.spawnercraft2;

import cad97.spawnercraft2.reference.Reference;
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
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		//stub
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		//stub
	}
}
