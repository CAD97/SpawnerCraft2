package cad97.spawnercraft.init;

import cad97.spawnercraft.block.BlockMobCage;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;

public class ModBlocks
{
	public static final Block mobCage = new BlockMobCage();

	public static void init(Side side)
	{
		GameRegistry.registerBlock(mobCage, "mobCage");

		if (side.isClient())
		{
			registerTextures();
		}

		LogHelper.info(Reference.MOD_NAME + " Blocks initialized");
	}

	@SideOnly(Side.CLIENT)
	private static void registerTextures()
	{
		mobCage.setTextureName("minecraft:mob_spawner");
	}
}
