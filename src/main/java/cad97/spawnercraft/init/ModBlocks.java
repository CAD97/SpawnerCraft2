package cad97.spawnercraft.init;

import cad97.spawnercraft.block.BlockMobCage;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mobCage), 0, new ModelResourceLocation("minecraft:mob_spawner", "inventory"));
	}
}
