package cad97.spawnercraft.init;

import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.world.World;

public class NBTSensitiveShapedRecipe extends ShapedRecipes
{

	public NBTSensitiveShapedRecipe(int width, int height, ItemStack[] p_i1917_3_, ItemStack output)
	{
		super(width, height, p_i1917_3_, output);
	}

	@Override
	/**
	 * Used to check if a recipe matches current crafting inventory
	 * Actually a direct copy from {@link ShapedRecipes} but pointing at local checkMatch
	 */
	public boolean matches(InventoryCrafting inv, World worldIn)
	{
		for (int i = 0; i <= 3 - this.recipeWidth; ++i)
		{
			for (int j = 0; j <= 3 - this.recipeHeight; ++j)
			{
				if (this.checkMatch(inv, i, j, true))
				{
					return true;
				}

				if (this.checkMatch(inv, i, j, false))
				{
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * Checks if the region of a crafting inventory is match for the recipe.
	 * Almost all the same but added check for NBT
	 */
	private boolean checkMatch(InventoryCrafting p_77573_1_, int p_77573_2_, int p_77573_3_, boolean p_77573_4_)
	{
		for (int k = 0; k < 3; ++k)
		{
			for (int l = 0; l < 3; ++l)
			{
				int i1 = k - p_77573_2_;
				int j1 = l - p_77573_3_;
				ItemStack itemstack = null;

				if (i1 >= 0 && j1 >= 0 && i1 < this.recipeWidth && j1 < this.recipeHeight)
				{
					if (p_77573_4_)
					{
						itemstack = this.recipeItems[this.recipeWidth - i1 - 1 + j1 * this.recipeWidth];
					}
					else
					{
						itemstack = this.recipeItems[i1 + j1 * this.recipeWidth];
					}
				}

				ItemStack itemstack1 = p_77573_1_.getStackInRowAndColumn(k, l);

				if (itemstack1 != null || itemstack != null)
				{
					if (itemstack1 == null && itemstack != null || itemstack1 != null && itemstack == null)
					{
						return false;
					}

					if (itemstack.getItem() != itemstack1.getItem())
					{
						return false;
					}

					if (itemstack.getMetadata() != 32767 && itemstack.getMetadata() != itemstack1.getMetadata())
					{
						return false;
					}

					// === Added code below ===
					if (itemstack.hasTagCompound()) {
						if (!itemstack1.hasTagCompound() || !itemstack.getTagCompound().equals(itemstack1.getTagCompound()))
						{
							return false;
						}
					}
					// === Added code above ===
				}
			}
		}

		return true;
	}
}
