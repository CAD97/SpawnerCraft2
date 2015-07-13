package cad97.spawnercraft.item;

import cad97.spawnercraft.reference.Reference;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Collection;
import java.util.List;

public abstract class ItemMobSoul extends SpawnerCraftItem
{
	private IIcon overlayIcon;
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
			nbt.setString("entity_name", EntityList.getStringFromID(entityEggInfo.spawnedID));
			stack.setTagCompound(nbt);
			subItems.add(stack);
		}

		// TODO apparently the EntityRegistry change is not back in 1.7. Guess I'll just have to live with whatever
		// forge mobs
//		for (String name : cpw.mods.fml.common.registry.EntityRegistry.getEggs().keySet())
//		{
//			ItemStack stack = new ItemStack(item);
//			NBTTagCompound nbt = new NBTTagCompound();
//			nbt.setString("entity_name", name);
//			stack.setTagCompound(nbt);
//			subItems.add(stack);
//		}

		// TODO as stated in {@link Reference} the EggInfo for the WitherSkeleton would need a rework
		// WitherSkeleton
//		{
//			ItemStack stack = new ItemStack(item);
//			NBTTagCompound nbt = new NBTTagCompound();
//			nbt.setString("entity_name", Reference.witherSkeletonEggInfo.name);
//			stack.setTagCompound(nbt);
//			subItems.add(stack);
//		}
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
//		if (getEntityName(stack).equals(Reference.witherSkeletonEggInfo.name))
//		{
//			return Reference.witherSkeletonEggInfo;
//		}

		return (EntityList.EntityEggInfo) EntityList.entityEggs.get(getIDFromString(getEntityName(stack)));
	}

	// This sad panda had to copy the mapping from {@link EntityList} because 1.7 doesn't have a method for ID -> String
	protected static int getIDFromString(String entityName)
	{
		if (entityName.equals("Item")) return 1;
		if (entityName.equals("XPOrb")) return 2;
		if (entityName.equals("LeashKnot")) return 8;
		if (entityName.equals("Painting")) return 9;
		if (entityName.equals("Arrow")) return 10;
		if (entityName.equals("Snowball")) return 11;
		if (entityName.equals("Fireball")) return 12;
		if (entityName.equals("SmallFireball")) return 13;
		if (entityName.equals("ThrownEnderpearl")) return 14;
		if (entityName.equals("EyeOfEnderSignal")) return 15;
		if (entityName.equals("ThrownPotion")) return 16;
		if (entityName.equals("ThrownExpBottle")) return 17;
		if (entityName.equals("ItemFrame")) return 18;
		if (entityName.equals("WitherSkull")) return 19;
		if (entityName.equals("PrimedTnt")) return 20;
		if (entityName.equals("FallingSand")) return 21;
		if (entityName.equals("FireworksRocketEntity")) return 22;
		if (entityName.equals("Boat")) return 41;
		if (entityName.equals("MinecartRideable")) return 42;
		if (entityName.equals("MinecartChest")) return 43;
		if (entityName.equals("MinecartFurnace")) return 44;
		if (entityName.equals("MinecartTNT")) return 45;
		if (entityName.equals("MinecartHopper")) return 46;
		if (entityName.equals("MinecartSpawner")) return 47;
		if (entityName.equals("MinecartCommandBlock")) return 40;
		if (entityName.equals("Mob")) return 48;
		if (entityName.equals("Monster")) return 49;
		if (entityName.equals("Creeper")) return 50;
		if (entityName.equals("Skeleton")) return 51;
		if (entityName.equals("Spider")) return 52;
		if (entityName.equals("Giant")) return 53;
		if (entityName.equals("Zombie")) return 54;
		if (entityName.equals("Slime")) return 55;
		if (entityName.equals("Ghast")) return 56;
		if (entityName.equals("PigZombie")) return 57;
		if (entityName.equals("Enderman")) return 58;
		if (entityName.equals("CaveSpider")) return 59;
		if (entityName.equals("Silverfish")) return 60;
		if (entityName.equals("Blaze")) return 61;
		if (entityName.equals("LavaSlime")) return 62;
		if (entityName.equals("EnderDragon")) return 63;
		if (entityName.equals("WitherBoss")) return 64;
		if (entityName.equals("Bat")) return 65;
		if (entityName.equals("Witch")) return 66;
		if (entityName.equals("Pig")) return 90;
		if (entityName.equals("Sheep")) return 91;
		if (entityName.equals("Cow")) return 92;
		if (entityName.equals("Chicken")) return 93;
		if (entityName.equals("Squid")) return 94;
		if (entityName.equals("Wolf")) return 95;
		if (entityName.equals("MushroomCow")) return 96;
		if (entityName.equals("SnowMan")) return 97;
		if (entityName.equals("Ozelot")) return 98;
		if (entityName.equals("VillagerGolem")) return 99;
		if (entityName.equals("EntityHorse")) return 100;
		if (entityName.equals("Villager")) return 120;
		if (entityName.equals("EnderCrystal")) return 200;
		return 0;
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
		itemStack.setMetadata(0);
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses()
	{
		return true;
	}

	/**
	 * Gets an icon index based on an item's damage value and the given render pass
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int p_77618_1_, int p_77618_2_)
	{
		return p_77618_2_ > 0 ? this.overlayIcon : super.getIconFromDamageForRenderPass(p_77618_1_, p_77618_2_);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		super.registerIcons(register);
		this.overlayIcon = register.registerIcon(this.getIconString() + "_overlay");
	}
}
