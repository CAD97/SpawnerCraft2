package cad97.spawnercraft.handler;

import cad97.spawnercraft.init.ModBlocks;
import cad97.spawnercraft.init.ModItems;
import cad97.spawnercraft.reference.Reference;
import net.minecraft.block.BlockMobSpawner;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class DropsListener
{
	public static final DropsListener instance = new DropsListener();

	@SubscribeEvent
	public void onMobDrops(LivingDropsEvent event)
	{
		if (event.source.getSourceOfDamage() instanceof EntityPlayer &&
				(!ConfigHandler.requireMobFishing || ((EntityPlayer) event.source.getSourceOfDamage()).getCurrentEquippedItem().getItem() == ModItems.mobRod)
				)
		{
			Entity entity = event.entity;

			if (EntityList.entityEggs.containsKey(EntityList.getEntityID(entity)) || // vanilla
					EntityRegistry.getEggs().containsKey(EntityList.getEntityString(entity))) // forge
			{
				ItemStack stack = new ItemStack(ModItems.mobEssence);
				net.minecraft.nbt.NBTTagCompound nbt = new net.minecraft.nbt.NBTTagCompound();
				nbt.setString("entity_name", EntityList.getEntityString(entity));

				if (entity instanceof EntitySkeleton && ((EntitySkeleton)entity).getSkeletonType()==1)
				{
					// is Wither Skeleton
					nbt.setString("entity_name", Reference.witherSkeletonEggInfo.name);
				}

				stack.setTagCompound(nbt);
				entity.entityDropItem(stack, 0.0F);
			}
		}
	}

	@SubscribeEvent
	public void onBlockDrops(BlockEvent.HarvestDropsEvent event)
	{
		if (event.state.getBlock() instanceof BlockMobSpawner)
		{
			if (ConfigHandler.spawnerDropRequireSilk)
			{
				if (EnchantmentHelper.getSilkTouchModifier(event.harvester))
				{
					event.drops.add(new ItemStack(ModBlocks.mobCage, 1));
				}
			}
			else
			{
				event.drops.add(new ItemStack(ModBlocks.mobCage, 1));
			}

			// Drop some Essence of Mob?
			// No can do, can't get spawner to tell me what mob it is spawning.
		}
	}
}
