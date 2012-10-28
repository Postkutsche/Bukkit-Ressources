package de.postkutsche.bukkitressources;

import net.minecraft.server.NBTTagCompound;

import org.bukkit.craftbukkit.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;

public class NamedItemStack {

	private final ItemStack itemStack;
	
	public NamedItemStack(ItemStack itemStack) {
		this.itemStack = itemStack;
		CraftItemStack cis = ((CraftItemStack)this.itemStack);
		NBTTagCompound tag = cis.getHandle().getTag();
		if (tag == null) {
			cis.getHandle().setTag(new NBTTagCompound());
		}
	}
	
	private boolean hasDisplay() {
		return this.getDisplay() == null ? false : true;
	}
	
	private NBTTagCompound getDisplay() {
		return ((CraftItemStack)this.itemStack).getHandle().getTag().getCompound("display");
	}
	
	private NBTTagCompound addDisplay() {
		NBTTagCompound display = new NBTTagCompound();
		((CraftItemStack)this.itemStack).getHandle().getTag().setCompound("display", display);
		return display;
	}
	
	public String getName() {
		if (!hasDisplay()) {
			return null;
		}
		System.out.println(getDisplay().get("Name"));
		return getDisplay().getString("Name");
	}
	
	public void setName(String name) {
		NBTTagCompound display = this.getDisplay();
		if (!hasDisplay()) {
			display = this.addDisplay();
		}
		display.setString("Name", name);
	}
}
