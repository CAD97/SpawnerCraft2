package cad97.spawnercraft.block;

import cad97.spawnercraft.creativetabs.SpawnerCraftTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class SpawnerCraftBlock extends Block
{
	public SpawnerCraftBlock(Material material)
	{
		super(material);
		setCreativeTab(SpawnerCraftTab.tabSC);
	}
}
