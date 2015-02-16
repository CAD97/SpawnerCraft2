package cad97.spawnercraft.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class SpawnerCraftTab
{
	public static final CreativeTabs tabSC = new CreativeTabs("tabSC")
	{
		@Override
		public Item getTabIconItem()
		{
			return Item.getItemFromBlock(Blocks.mob_spawner);
		}
	};
}
