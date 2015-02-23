package mca.items;

import java.util.List;

import mca.core.MCA;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import radixcore.constant.Color16;
import radixcore.item.ItemColorable;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemColoredEngagementRing extends ItemColorable
{
	private boolean isRoseGold;
	private IIcon[] icons = new IIcon[2];

	public ItemColoredEngagementRing(boolean isRoseGold)
	{
		final String name = isRoseGold ? "ColoredEngagementRingRG" : "ColoredEngagementRing";
		
		this.isRoseGold = isRoseGold;
		this.setHasSubtypes(true);
		this.setMaxDamage(0);
		
		this.setUnlocalizedName(name);
		this.setTextureName("mca:" + name);
		GameRegistry.registerItem(this, name);

		this.setCreativeTab(MCA.getCreativeTabGemCutting());
	}

	@Override
	public boolean requiresMultipleRenderPasses() 
	{
		return true;
	}

	@Override
	public int getColorFromItemStack(ItemStack itemStack, int pass)
	{
		return pass == 0 ? super.getColorFromItemStack(itemStack, pass) : 0xFFFFFF;
	}
	
	@Override
	public IIcon getIconFromDamageForRenderPass(int damage, int pass) 
	{
		return icons[pass];
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) 
	{
		final String name = isRoseGold ? "ColoredEngagementRingRG" : "ColoredEngagementRing";
		
		icons[0] = iconRegister.registerIcon("mca:" + name);
		icons[1] = iconRegister.registerIcon(isRoseGold ? "mca:RingBottomRG" : "mca:RingBottom");
	}
}