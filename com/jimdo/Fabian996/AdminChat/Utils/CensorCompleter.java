package com.jimdo.Fabian996.AdminChat.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class CensorCompleter implements TabCompleter {

	@Override
	public List<String> onTabComplete(CommandSender cs, Command cmd, String lable, String[] args) {
	
		List<String> function = new ArrayList<>();
		function.add("add");
		function.add("remove");
		
		if(args.length == 1){
 			return function;
		}else{
			return null;
		}
	}
}
