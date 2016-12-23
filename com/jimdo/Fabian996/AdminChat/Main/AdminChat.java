package com.jimdo.Fabian996.AdminChat.Main;

import org.bukkit.plugin.java.JavaPlugin;

import com.jimdo.Fabian996.AdminChat.Commands.ChatCensor;
import com.jimdo.Fabian996.AdminChat.Commands.ClearChat;
import com.jimdo.Fabian996.AdminChat.Utils.CensorCompleter;

public class AdminChat extends JavaPlugin{

	//Prefix
	public static final String APrefix = "§8[§eAdminChat§8] §r";
	
	@Override
	public void onEnable() {
		
		loadConfig();
		registerCommands();
		registerListener();
		
	}
	
	
	private void loadConfig() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public void registerListener(){
		getServer().getPluginManager().registerEvents(new ChatCensor(this), this);
	}


	public void registerCommands() {
		getCommand("cc").setExecutor(new ClearChat());
		//getCommand("gmute").setExecutor(new GlobalMute());
		getCommand("censor").setExecutor(new ChatCensor(this));
		getCommand("censor").setTabCompleter(new CensorCompleter());
	}


	@Override
	public void onDisable() {
		
	}
}
