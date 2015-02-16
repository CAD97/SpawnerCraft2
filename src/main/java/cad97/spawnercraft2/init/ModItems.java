package cad97.spawnercraft2.init;

import cad97.spawnercraft2.item.ItemMobEssence;
import cad97.spawnercraft2.item.ItemMobAgglomeration;
import cad97.spawnercraft2.item.ItemMobSpirit;
import cad97.spawnercraft2.reference.Reference;
import cad97.spawnercraft2.utility.LogHelper;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Collection;

public class ModItems
{
	public static final Item mobEssence = new ItemMobEssence();
	public static final Item mobAgglomeration = new ItemMobAgglomeration();
	public static final Item mobSpirit = new ItemMobSpirit();

	@SuppressWarnings("unchecked")
	public static void init()
	{
		// register items
		GameRegistry.registerItem(mobEssence, "mobEssence");
		GameRegistry.registerItem(mobAgglomeration, "mobAgglomeration");
		GameRegistry.registerItem(mobSpirit, "mobSpirit");

		// register item textures
		for (EntityList.EntityEggInfo entityEggInfo : (Collection<EntityList.EntityEggInfo>) EntityList.entityEggs.values())
		{
			ModelLoader.setCustomModelResourceLocation(mobEssence, entityEggInfo.spawnedID, new ModelResourceLocation("spawnercraft2:mobEssence", "inventory"));
			ModelLoader.setCustomModelResourceLocation(mobAgglomeration, entityEggInfo.spawnedID, new ModelResourceLocation("spawnercraft2:mobAgglomeration", "inventory"));
			ModelLoader.setCustomModelResourceLocation(mobSpirit, entityEggInfo.spawnedID, new ModelResourceLocation("minecraft:spawn_egg", "inventory"));
		}

		LogHelper.info(Reference.MOD_NAME + " Items initialized");
	}
}
