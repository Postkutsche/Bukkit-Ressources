package de.postkutsche.bukkitressources;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Testing extends JavaPlugin {

	public void onEnable() {
		
	}
	
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) {
			return false;
		}
		Player p = (Player) cs;
		
		NamedItemStack item = new NamedItemStack(p.getItemInHand());
		
		if (args.length == 1) {
			item.setName(args[0]);
		} else {
			String name = item.getName();
			if (name == null) {
				p.sendMessage("Dieser Gegenstand hat keinen Namen");
			} else {
				p.sendMessage(name);
			}
		}
		
	//	p.sendMessage(((CraftItemStack)p.getItemInHand()).getHandle().getTag()..get("title").toString());
	//	p.sendMessage(((CraftItemStack)p.getItemInHand()).getHandle().getTag().get("author").toString());
		return false;
	}
	
}
