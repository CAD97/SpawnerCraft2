package cad97.spawnercraft.init;

import cad97.spawnercraft.item.ItemMobAgglomeration;
import cad97.spawnercraft.item.ItemMobEssence;
import cad97.spawnercraft.item.ItemMobRod;
import cad97.spawnercraft.item.ItemMobSpirit;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ModItems
{
	public static final Item mobEssence = new ItemMobEssence();
	public static final Item mobAgglomeration = new ItemMobAgglomeration();
	public static final Item mobSpirit = new ItemMobSpirit();
	public static final Item mobRod = new ItemMobRod();

	public static void init(Side side)
	{
		// register items
		GameRegistry.registerItem(mobEssence, "mobEssence");
		GameRegistry.registerItem(mobAgglomeration, "mobAgglomeration");
		GameRegistry.registerItem(mobSpirit, "mobSpirit");
		GameRegistry.registerItem(mobRod, "mobRod");

		if (side.isClient())
		{
			registerTextures();
		}

		LogHelper.info(Reference.MOD_NAME + " Items initialized");
	}

	@SideOnly(Side.CLIENT)
	private static void registerTextures()
	{
		// register item textures
		ModelLoader.setCustomModelResourceLocation(mobEssence, 0, new ModelResourceLocation("spawnercraft:mobEssence", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mobAgglomeration, 0, new ModelResourceLocation("spawnercraft:mobAgglomeration", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mobSpirit, 0, new ModelResourceLocation("spawnercraft:mobSpirit", "inventory"));
		ModelLoader.setCustomModelResourceLocation(mobRod, 0, new ModelResourceLocation("spawnercraft:mobRod", "inventory"));
	}
}
