package cad97.spawnercraft.init;

import cad97.spawnercraft.block.BlockMobCage;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraft.block.Block;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModBlocks
{
	public static final Block mobCage = new BlockMobCage();

	public static void init()
	{
		GameRegistry.registerBlock(mobCage, "mobCage");

		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(mobCage), 0, new ModelResourceLocation("minecraft:mob_spawner", "inventory"));

		LogHelper.info(Reference.MOD_NAME + " Blocks initialized");
	}
}
