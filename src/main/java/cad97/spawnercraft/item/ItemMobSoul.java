package cad97.spawnercraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Collection;
import java.util.List;

public abstract class ItemMobSoul extends SpawnerCraftItem
{
	// base for mobEssence, mobAgglomeration, and mobSpirit

	public ItemMobSoul()
	{
		setMaxStackSize(64);
		setHasSubtypes(true);
		// so that the creative menu will check which damage values to display
	}

	/**
	 * Gets the display name based on damage value.
	 * (I.E. the mob it represents.)
	 * Works the same way as in {@link ItemMonsterPlacer}
	 *
	 * @param stack a stack of ItemMobSoul
	 * @return the name that should be displayed
	 */
	@Override
	public String getItemStackDisplayName(ItemStack stack)
	{
		String itemName = StatCollector.translateToLocal(this.getUnlocalizedName() + ".name").trim();
		String mobName = getEntityName(stack);

		if (mobName != null)
		{
			mobName = StatCollector.translateToLocal("entity." + mobName + ".name");
		}

		itemName = String.format(itemName, mobName);

		return itemName;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int renderPass)
	{
		EntityList.EntityEggInfo entityegginfo = getEggInfo(stack);

		int color = 0xFFFFFF;
		if (entityegginfo != null)
		{
			if (renderPass == 0)
			{
				color = entityegginfo.primaryColor;
			} else
			{
				color = entityegginfo.secondaryColor;
			}
		}
		return color;
	}

	@Override
	@SuppressWarnings("unchecked")
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item item, CreativeTabs tab, List subItems)
	{
		// vanilla mobs
		for (EntityList.EntityEggInfo entityEggInfo : (Collection<EntityList.EntityEggInfo>) EntityList.entityEggs.values())
		{
			subItems.add(new ItemStack(item, 1, entityEggInfo.spawnedID));
		}

		// forge mobs
		for (String name : net.minecraftforge.fml.common.registry.EntityRegistry.getEggs().keySet())
		{
			ItemStack stack = new ItemStack(item);
			net.minecraft.nbt.NBTTagCompound nbt = new net.minecraft.nbt.NBTTagCompound();
			nbt.setString("entity_name", name);
			stack.setTagCompound(nbt);
			subItems.add(stack);
		}
	}

	// Copied from ItemMonsterPlacer because I need it but cannot use it with it being private.
	// So much simpler than messing with ASM and changing the scope at run.
	// Why is this a method I can't access, anyway?
	protected static String getEntityName(ItemStack stack)
	{
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("entity_name", 8))
			return stack.getTagCompound().getString("entity_name");
		return EntityList.getStringFromID(stack.getMetadata());
	}

	protected static EntityList.EntityEggInfo getEggInfo(ItemStack stack)
	{
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("entity_name", 8))
			return net.minecraftforge.fml.common.registry.EntityRegistry.getEggs().get(stack.getTagCompound().getString("entity_name"));
		return (EntityList.EntityEggInfo)EntityList.entityEggs.get(stack.getMetadata());
	}
}
