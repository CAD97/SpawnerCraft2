package cad97.spawnercraft.init;

import cad97.spawnercraft.handler.ConfigHandler;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Collection;

public class ModRecipes
{
	@SuppressWarnings("unchecked")
	public static void init()
	{
		for (EntityList.EntityEggInfo entityEggInfo : (Collection<EntityList.EntityEggInfo>) EntityList.entityEggs.values()) {
			registerEggCrafting(entityEggInfo);
		}
		for (EntityList.EntityEggInfo entityEggInfo : EntityRegistry.getEggs().values())
		{
			registerEggCrafting(entityEggInfo);
		}
		registerEggCrafting(Reference.witherSkeletonEggInfo);

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

		LogHelper.info(Reference.MOD_NAME + " Recipes initialized");
	}

	private static void registerEggCrafting(EntityList.EntityEggInfo entityEggInfo)
	{
		net.minecraft.nbt.NBTTagCompound nbt = new net.minecraft.nbt.NBTTagCompound();
		nbt.setString("entity_name", entityEggInfo.name);

		ItemStack essenceStack = new ItemStack(ModItems.mobEssence);
		ItemStack agglomerationStack = new ItemStack(ModItems.mobAgglomeration);
		ItemStack spiritStack = new ItemStack(ModItems.mobSpirit);

		essenceStack.setTagCompound(nbt);
		agglomerationStack.setTagCompound(nbt);
		spiritStack.setTagCompound(nbt);

		GameRegistry.addRecipe(new NBTSensitiveShapedRecipe(
				2,2,
				new ItemStack[] {essenceStack,essenceStack,essenceStack,essenceStack},
				agglomerationStack
		));
		GameRegistry.addRecipe(new NBTSensitiveShapedRecipe(
				2,2,
				new ItemStack[] {agglomerationStack,agglomerationStack,agglomerationStack,agglomerationStack},
				spiritStack
		));
	}
}
