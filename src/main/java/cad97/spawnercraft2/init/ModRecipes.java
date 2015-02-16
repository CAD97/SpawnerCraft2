package cad97.spawnercraft2.init;

import cad97.spawnercraft2.handler.ConfigHandler;
import cad97.spawnercraft2.reference.Reference;
import cad97.spawnercraft2.utility.LogHelper;
import net.minecraft.entity.EntityList;
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
					new ItemStack(ModItems.mobSpirit),
					// from
					"AA",
					"AA",
					'A', new ItemStack(ModItems.mobAgglomeration, 1, meta)
			);

			if (ConfigHandler.spawnerCraftable)
			{
				// mobCage
			}
		}

		LogHelper.info(Reference.MOD_NAME + " Recipes initialized");
	}
}
