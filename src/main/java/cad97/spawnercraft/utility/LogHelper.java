package cad97.spawnercraft.utility;

import cad97.spawnercraft.reference.Reference;
import cpw.mods.fml.common.FMLLog;
import org.apache.logging.log4j.Level;


public class LogHelper
{
	public static void log(Level level, Object data)
	{
		FMLLog.log(Reference.MOD_NAME, level, "%s", data);
	}

	public static void fatal(Object data)
	{
		log(Level.FATAL, data);
	}

	public static void error(Object data)
	{
		log(Level.ERROR, data);
	}

	public static void warn(Object data)
	{
		log(Level.WARN, data);
	}

	public static void info(Object data)
	{
		log(Level.INFO, data);
	}

	public static void debug(Object data)
	{
		log(Level.DEBUG, data);
	}

	public static void trace(Object data)
	{
		log(Level.TRACE, data);
	}
}
