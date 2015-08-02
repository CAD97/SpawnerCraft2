package cad97.spawnercraft.item;

import cad97.spawnercraft.reference.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.common.registry.EntityRegistry;
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
	 * Gets the display name based on mob data.
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
			ItemStack stack = new ItemStack(item);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("entity_name", entityEggInfo.name);
			stack.setTagCompound(nbt);
			subItems.add(stack);

			// WitherSkeleton
			if (entityEggInfo.name.equals("Skeleton")) {
				stack = new ItemStack(item);
				nbt = new NBTTagCompound();
				nbt.setString("entity_name", Reference.witherSkeletonEggInfo.name);
				stack.setTagCompound(nbt);
				subItems.add(stack);
			}
		}

		// forge mobs
		for (String name : net.minecraftforge.fml.common.registry.EntityRegistry.getEggs().keySet())
		{
			ItemStack stack = new ItemStack(item);
			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setString("entity_name", name);
			stack.setTagCompound(nbt);
			subItems.add(stack);
		}
	}

	/** These two methods are directly inspired by those in {@link ItemMonsterPlacer} */
	protected static String getEntityName(ItemStack stack)
	{
		return getNBTSafely(stack).getString("entity_name");
	}

	/** These two methods are directly inspired by those in {@link ItemMonsterPlacer} */
	protected static EntityList.EntityEggInfo getEggInfo(ItemStack stack)
	{
		assert (stack.hasTagCompound() && stack.getTagCompound().hasKey("entity_name", 8));
		if (getEntityName(stack).equals(Reference.witherSkeletonEggInfo.name))
		{
			return Reference.witherSkeletonEggInfo;
		}
		EntityList.EntityEggInfo eei = EntityRegistry.getEggs().get(getEntityName(stack));
		if (eei == null)
		{
			eei = (EntityList.EntityEggInfo) EntityList.entityEggs.get(EntityList.getIDFromString(getEntityName(stack)));
		}
		return eei;
	}

	public static NBTTagCompound getNBTSafely(ItemStack stack)
	{
		if (!(stack.getItem() instanceof ItemMobSoul))
			return stack.getTagCompound();

		if (!stack.hasTagCompound())
		{
			updateItemStackFromMetadataToNBT(stack);
		}
		return stack.getTagCompound();
	}

	private static void updateItemStackFromMetadataToNBT(ItemStack itemStack)
	{
		if (!(itemStack.getItem() instanceof ItemMobSoul))
			return;

		if (itemStack.getMetadata() == 0 && itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("entity_name"))
			return;

		NBTTagCompound nbt = itemStack.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();
		if (EntityList.getStringFromID(itemStack.getMetadata()) == null)
		{
			nbt.setString("entity_name", "null");
		} else
		{
			nbt.setString("entity_name", EntityList.getStringFromID(itemStack.getMetadata()));
		}
		itemStack.setTagCompound(nbt);
		itemStack.setItemDamage(0);
	}
}
