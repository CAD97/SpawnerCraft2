package cad97.spawnercraft.item;

import cad97.spawnercraft.init.ModBlocks;
import net.minecraft.block.BlockFence;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

public class ItemMobSpirit extends ItemMobSoul
{
	public ItemMobSpirit()
	{
		super();
		setUnlocalizedName("mobSpirit");
	}

	/**
	 * code ~~stolen~~ inspired from ItemMonsterPlacer.class
	 * as my onClick should mimic ItemMonsterPlacer pretty closely
	 * differing only on what block is turned into a proper spawner.
	 *
	 * @param stack ItemStack being clicked with
	 * @param player Player doing clicking
	 * @param world World player is in
	 * @param pos The block being right-clicked
	 * @param side The side being right-clicked
	 * @param hitX Where the item is clicked on, X
	 * @param hitY Where the item is clicked on, Y
	 * @param hitZ Where the item is clicked on, Z
	 * @return true if used, false otherwise
	 */
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
			// World is remote, do not handle item use
			// return true because client should believe item can be used anywhere
		}
		else if (!player.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
			// Player is not allowed to edit here
			// return false to cancel action
		}
		else
		{
			IBlockState state = world.getBlockState(pos);
			if (state.getBlock() == ModBlocks.mobCage)
			{
				world.setBlockState(pos, Blocks.mob_spawner.getDefaultState());
				TileEntityMobSpawner tileEntity = (TileEntityMobSpawner) world.getTileEntity(pos);
				tileEntity.getSpawnerBaseLogic().setEntityName(EntityList.getStringFromID(stack.getMetadata()));
				tileEntity.markDirty();
				world.markBlockForUpdate(pos);

				if (!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}

				return true;
			}
			else if (state.getBlock() == Blocks.mob_spawner)
			{
				return false;
				// do nothing
				// prevent misuse of Spirit trying to change an active spawner
				// usage may be mistaken as we are stealing mob_egg's texture and functionality except that
			}
			else
			{
				// below is taken directly from ItemMonsterPlacer starting line 99
				// just with some cleaned up naming
				pos = pos.offset(side);
				double spawnHeight = 0;
				if (side == EnumFacing.UP && state instanceof BlockFence)
				{
					spawnHeight = 0.5;
				}

				Entity entity = ItemMonsterPlacer.spawnCreature(world, stack.getMetadata(), (double)pos.getX() + 0.5D, (double)pos.getY() + spawnHeight, (double)pos.getZ() + 0.5D);

				if (entity != null)
				{
					if (entity instanceof EntityLivingBase && stack.hasDisplayName())
					{
						entity.setCustomNameTag(stack.getDisplayName());
					}
//					if (/*isWitherSkeleton &&*/ entity instanceof EntitySkeleton)
//					{
//						((EntitySkeleton) entity).setSkeletonType(1);
//						((EntitySkeleton) entity).getEquipmentInSlot(0).setItem(Items.stone_sword);
//					}
				}
				if (!player.capabilities.isCreativeMode)
				{
					--stack.stackSize;
				}

				return true;
			}
		}
	}
}
