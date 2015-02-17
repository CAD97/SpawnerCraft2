package cad97.spawnercraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
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
	 * Damage value is the entity ID of the entity it represents.
	 *
	 * @param stack a stack of ItemMobSoul
	 * @return the name that should be displayed
	 */
	@Override
	public String getItemStackDisplayName(final ItemStack stack)
	{
		String itemName = StatCollector.translateToLocal(this.getUnlocalizedName() + ".name").trim();
		String mobName = EntityList.getStringFromID(stack.getMetadata());

		if (mobName != null)
		{
			mobName = StatCollector.translateToLocal("entity." + mobName + ".name");
		}
		else
		{
			mobName = "Mob";
		}

		itemName = String.format(itemName, mobName);

		return itemName;
	}

	// below this line is rendering
	// therefor, @SideOnly(Side.CLIENT)

	@Override
	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack stack, int renderPass)
	{
		EntityList.EntityEggInfo entityegginfo = (EntityList.EntityEggInfo)EntityList.entityEggs.get(stack.getMetadata());

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
		for (EntityList.EntityEggInfo entityEggInfo : (Collection<EntityList.EntityEggInfo>) EntityList.entityEggs.values())
		{
			subItems.add(new ItemStack(item, 1, entityEggInfo.spawnedID));
		}
	}
}
