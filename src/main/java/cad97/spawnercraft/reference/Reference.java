package cad97.spawnercraft.reference;

import net.minecraft.entity.EntityList;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class Reference
{
	public static final String MOD_ID = "spawnercraft";
	public static final String MOD_NAME = "SpawnerCraft";
	public static final String VERSION = "1.8-2.2.3";

	public static final String GUI_FACTORY_CLASS = "cad97.spawnercraft.client.gui.GuiFactory";

	// Reverse coloration of regular skeletons
	public static final EntityList.EntityEggInfo witherSkeletonEggInfo = new EntityList.EntityEggInfo("WitherSkeleton", 4802889, 12698049);

	public static final NBTTagCompound witherSkeletonSpawnerNBT = new NBTTagCompound();
	static {                                                        // {
		witherSkeletonSpawnerNBT.setString("EntityId", "Skeleton"); //   EntityId:Skeleton,
		NBTTagCompound spawnData = new NBTTagCompound();            //   SpawnData:{
		spawnData.setByte("SkeletonType", (byte) 1);                //     SkeletonType:1,
		NBTTagList equipment = new NBTTagList();                    //     Equipment:[
		NBTTagCompound item = new NBTTagCompound();                 //       {
		item.setByte("Count",(byte)1);                              //         Count:1,
		item.setString("id","minecraft:stone_sword");               //         id:minecraft:stone_sword
		equipment.appendTag(item);                                  //       }
		spawnData.setTag("Equipment", equipment);                   //     ]
		witherSkeletonSpawnerNBT.setTag("SpawnData", spawnData);    //   }
		System.out.println(witherSkeletonSpawnerNBT.toString());    // }
	}
}
