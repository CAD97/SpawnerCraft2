package cad97.spawnercraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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

	@SideOnly(Side.CLIENT)
	public EnumWorldBlockLayer getBlockLayer()
	{
		return EnumWorldBlockLayer.CUTOUT;
	}
	// as for BlockMobSpawner
}
