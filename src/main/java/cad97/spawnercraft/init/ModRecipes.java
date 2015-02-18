package cad97.spawnercraft.init;

import cad97.spawnercraft.handler.ConfigHandler;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Collection;

public class ModRecipes
{
	@SuppressWarnings("unchecked")
	public static void init()
	{
		for (EntityList.EntityEggInfo entityEggInfo : (Collection<EntityList.EntityEggInfo>) EntityList.entityEggs.values()) {
			int meta = entityEggInfo.spawnedID;

			GameRegistry.addShapedRecipe(
					new ItemStack(ModItems.mobAgglomeration, 1, meta),
					// from
					"EE",
					"EE",
					'E', new ItemStack(ModItems.mobEssence, 1, meta));
			GameRegistry.addShapedRecipe(
					new ItemStack(ModItems.mobSpirit, 1, meta),
					// from
					"AA",
					"AA",
					'A', new ItemStack(ModItems.mobAgglomeration, 1, meta)
			);

			GameRegistry.addShapedRecipe(
					new ItemStack(ModItems.mobRod),
					// from
					"R",
					"C",
					'R', Items.fishing_rod,
					'C', ModBlocks.mobCage
			);

			if (ConfigHandler.spawnerCraftable)
			{
				GameRegistry.addShapedRecipe(
						new ItemStack(ModBlocks.mobCage),
						// from
						"III",
						"I I",
						"III",
						'I', new ItemStack(Blocks.iron_bars)
				);
			}
		}

		LogHelper.info(Reference.MOD_NAME + " Recipes initialized");
	}
}
