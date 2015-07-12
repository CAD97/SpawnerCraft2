package cad97.spawnercraft.block;

import net.minecraft.block.material.Material;

public class BlockMobCage extends SpawnerCraftBlock
{
	public BlockMobCage()
	{
		super(Material.rock);
		// as for BlockMobSpawner

		setHardness(5.0F);
		setStepSound(soundTypeMetal);
		disableStats();
		// as BlockMobSpawner registered in Block.registerBlocks()

		setUnlocalizedName("mobCage");
		setHarvestLevel("pickaxe", 1);
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
}
