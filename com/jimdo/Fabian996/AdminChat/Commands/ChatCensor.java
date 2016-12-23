package com.jimdo.Fabian996.AdminChat.Commands;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.jimdo.Fabian996.AdminChat.Main.AdminChat;

public class ChatCensor implements CommandExecutor, Listener{

	private AdminChat plugin;
	
	public ChatCensor(AdminChat adminChat) {
		this.plugin = adminChat;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {
		Player p = (Player)cs;
			if(args.length == 2){
				if(p.hasPermission("adminchat.cc")){
					if(args[0].equalsIgnoreCase("remove")){	
						List<String> word = plugin.getConfig().getStringList("deniedWords");
						if(word.contains(args[1])){
							word.remove(args[1]);
							plugin.getConfig().set("deniedWords", word);
							plugin.saveConfig();
							p.sendMessage(AdminChat.APrefix + "You removed the word §c" + args[1] + " §rform the blaclist");
						}else{
							p.sendMessage(AdminChat.APrefix + "This word is not in the list!");
						}
					}else if(args[0].equalsIgnoreCase("add")){
						List<String> word = plugin.getConfig().getStringList("deniedWords");
						plugin.getConfig().set("deniedWords", word);
						word.add(args[1]);
						plugin.saveConfig();
						p.sendMessage(AdminChat.APrefix + "§You added the word §c" + args[1] + " §rto the blaclist");
					}
				}
			}
		return true;
	}

	
	@EventHandler
	public void PlayerChat(AsyncPlayerChatEvent e){
		Player p = e.getPlayer();
		String msg = e.getMessage();
		
		for(String worlds : plugin.getConfig().getStringList("deniedWords")){
			if(msg.contains(worlds)){
				e.setCancelled(true);
				p.sendMessage(AdminChat.APrefix + "§4Don't write such words!");
			}
		}
	}
}
