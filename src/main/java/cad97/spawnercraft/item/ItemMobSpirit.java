package cad97.spawnercraft.item;

import cad97.spawnercraft.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.Facing;
import net.minecraft.world.World;

public class ItemMobSpirit extends ItemMobSoul
{
	public ItemMobSpirit()
	{
		super();
		setUnlocalizedName("mobSpirit");
	}

	/**
	 * code ~~stolen~~ edited from ItemMonsterPlacer.class
	 * as my onClick should mimic ItemMonsterPlacer pretty closely
	 * differing only on what block is turned into a proper spawner.
	 */
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int facing, float hitX, float hitY, float hitZ)
	{
		if (world.isRemote)
		{
			return true;
		}
		else
		{
			Block block = world.getBlock(x, y, z);
			if (block == ModBlocks.mobCage)
			{
				world.setBlock(x, y, z, Blocks.mob_spawner);
				TileEntityMobSpawner tileEntity = (TileEntityMobSpawner) world.getTileEntity(x, y, z);

				String entityName = getEntityName(stack);
//				if (entityName.equals(Reference.witherSkeletonEggInfo.name))
//				{
//					entityName = "Skeleton";
//				}
				tileEntity.func_145881_a().setEntityName(entityName); // func_145881_a == getSpawnerBaseLogic
				tileEntity.markDirty();
				world.markBlockForUpdate(x, y, z);

				if (!player.capabilities.isCreativeMode)
				{
					stack.stackSize--;
				}

				return true;
			} else if (block == Blocks.mob_spawner)
			{
				return false;
			} else
			{
				x += Facing.offsetsXForSide[facing];
				y += Facing.offsetsYForSide[facing];
				z += Facing.offsetsZForSide[facing];
				double d0 = 0.0D;

				if (facing == 1 && block.getRenderType() == 11) {
					d0 = 0.5D;
				}

				Entity entity = ItemMonsterPlacer.spawnCreature(world, getIDFromString(getEntityName(stack)), (double) x + 0.5D, (double) y + d0, (double) z + 0.5D);

				if (entity != null) {
					if (entity instanceof EntityLivingBase && stack.hasDisplayName()) {
						((EntityLiving) entity).setCustomNameTag(stack.getDisplayName());
					}

					if (!player.capabilities.isCreativeMode) {
						--stack.stackSize;
					}
				}

				return true;
			}
		}
	}
}
