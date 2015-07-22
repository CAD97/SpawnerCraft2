package cad97.spawnercraft.reference;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.EntityList;

public class Reference
{
	public static final String MOD_ID = "spawnercraft";
	public static final String MOD_NAME = "SpawnerCraft";
	public static final String VERSION = "1.7.10-2.2.1";

	public static final String GUI_FACTORY_CLASS = "cad97.spawnercraft.client.gui.GuiFactory";

	// Reverse coloration of regular skeletons
	// TODO is Wither Skeleton doable in 1.7? EntityEggInfo doesn't take Strings it seems
//	public static final EntityList.EntityEggInfo witherSkeletonEggInfo = new EntityList.EntityEggInfo("WitherSkeleton", 4802889, 12698049);
}
