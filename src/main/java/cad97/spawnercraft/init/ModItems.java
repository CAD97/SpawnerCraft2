package cad97.spawnercraft.init;

import cad97.spawnercraft.item.ItemMobEssence;
import cad97.spawnercraft.item.ItemMobAgglomeration;
import cad97.spawnercraft.item.ItemMobRod;
import cad97.spawnercraft.item.ItemMobSpirit;
import cad97.spawnercraft.reference.Reference;
import cad97.spawnercraft.utility.LogHelper;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Collection;

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
	@SuppressWarnings("unchecked")
	private static void registerTextures()
	{
		// register item textures
		mobEssence.setTextureName("spawnercraft:mobEssence");
		mobAgglomeration.setTextureName("spawnercraft:mobAgglomeration");
		mobSpirit.setTextureName("spawnercraft:mobSpirit");
		mobRod.setTextureName("spawnercraft:mobRod");
	}
}
