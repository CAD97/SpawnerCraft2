package cad97.spawnercraft2.utility;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemModelMesher;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class Registrar
{
	private static ItemModelMesher itemModelMesher = Minecraft.getMinecraft().getRenderItem().getItemModelMesher();

	public static void registerItem(Item item, int meta, ModelResourceLocation modelResourceLocation)
	{
		itemModelMesher.register(item, meta, modelResourceLocation);
	}
}
