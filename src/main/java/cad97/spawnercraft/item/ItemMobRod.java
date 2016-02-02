package cad97.spawnercraft.item;

import com.google.common.collect.Multimap;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMobRod extends SpawnerCraftItem
{
	public ItemMobRod()
	{
		super();
		setUnlocalizedName("spawnercraft.mobRod");
		setMaxDamage(1024);
		setMaxStackSize(1);
	}

	/**
	 * @return True if the item is renderer in full 3D when hold.
	 */
	@SideOnly(Side.CLIENT)
	public boolean isFull3D()
	{
		return true;
	}

	/**
	 * @return true if this item should be rotated by 180 degrees around the Y axis when being held in an entities
	 * hands.
	 */
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering()
	{
		return true;
	}

	public boolean hitEntity(ItemStack stack, EntityLivingBase target, EntityLivingBase attacker)
	{
		stack.damageItem(1, attacker);
		return true;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
	{
		ItemStack mat = new ItemStack(Items.stick);
		return net.minecraftforge.oredict.OreDictionary.itemMatches(mat, repair, false) || super.getIsRepairable(toRepair, repair);
	}

	@Override
	@SuppressWarnings("unchecked")
	public Multimap getAttributeModifiers(ItemStack stack)
	{
		Multimap multimap = super.getAttributeModifiers(stack);
		multimap.put(SharedMonsterAttributes.attackDamage.getAttributeUnlocalizedName(), new AttributeModifier(itemModifierUUID, "Weapon modifier", 5.0, 0));
		return multimap;
	}
}
