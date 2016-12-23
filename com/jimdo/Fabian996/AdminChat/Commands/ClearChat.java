package com.jimdo.Fabian996.AdminChat.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.jimdo.Fabian996.AdminChat.Main.AdminChat;

public class ClearChat implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String lable, String[] args) {
		if((cs instanceof Player)){
			Player p = (Player)cs;
			if(cmd.getName().equalsIgnoreCase("cc")){
				if(p.hasPermission("adminchat.cc") || (p.hasPermission("adminchat.*"))){
					for(Player target : Bukkit.getOnlinePlayers()){
						for(int i = 0 ; i < 120; i++){
							target.sendMessage(" ");
						}
						target.sendMessage(AdminChat.APrefix + "§7Der Chat würde gelöscht durch §6" + p.getName());
					}
				}
			}
		}
		return true;
	}
}
