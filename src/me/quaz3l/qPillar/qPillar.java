package me.quaz3l.qPillar;

import java.util.logging.Logger;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class qPillar extends JavaPlugin {
	
	// Standard Setup
		public static qPillar plugin;
		public String prefix = "[qPillar] ";
		public final Logger logger = Logger.getLogger(("Minecraft"));
		
	// Listeners
		private final bListener blockListener = new bListener(this);
		
	@Override
	public void onDisable() 
	{
		PluginDescriptionFile pdfFile = this.getDescription();	
		this.logger.info(this.prefix + "Version " + pdfFile.getVersion() + " by Quaz3l: Disabled");
	}

	@Override
	public void onEnable() 
	{	
		// Configuration Stuff Stuff
		if(!getConfig().getBoolean("configSet"))
		{
			getConfig().set("configSet", true);
			getConfig().set("heightOfPillar", 5);
			getConfig().set("pillarAbove", 64);
			// getConfig().set("logPillar", true);
			getConfig().set("enforce.deletePillar", false);
			getConfig().set("enforce.killPlayer", false);
			getConfig().set("enforce.kickPlayer", false);
			getConfig().set("enforce.banPlayer", false);
			getConfig().set("enforce.offServer.reason", "No Pillars!");
			saveConfig();
		}
		
		// Register Block Event
		getServer().getPluginManager().registerEvent(Event.Type.BLOCK_PLACE, blockListener, Event.Priority.Normal, this);
		
		// Notify Console
		PluginDescriptionFile pdfFile = this.getDescription();	
		this.logger.info(this.prefix + "Version " + pdfFile.getVersion() + " by Quaz3l: Enabled");
		
	}
	
	public boolean ifPillarBlock(Block b)
	{
			if(b.getRelative(0, -1, 0) != null || b.getRelative(0, -1, 0).getTypeId() != 0) 
			{
				if(b.getRelative(1, 0, 0) == null || b.getRelative(1, 0, 0).getTypeId() == 0) 
				{
					if(b.getRelative(-1, 0, 0) == null || b.getRelative(-1, 0, 0).getTypeId() == 0) 
					{
						if(b.getRelative(0, 0, 1) == null || b.getRelative(0, 0, 1).getTypeId() == 0) 
						{
							if(b.getRelative(0, 0, -1) == null || b.getRelative(0, 0, -1).getTypeId() == 0) 
							{
								return true;
							}
						}
					}
				}
			}
		return false;
	}

	public boolean checkForPillar(Player p, Block b, Integer s, Integer a)
	{
		if(!(b.getY() < a))
		{
			switch(s)
			{
				case 0:
					if(ifPillarBlock(b)) return true;
					break;
				case 1:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) return true;
					break;
				case 2:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) return true;
					break;
				case 3:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) return true;
					break;
				case 4:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) return true;
					break;
				case 5:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) if(ifPillarBlock(b.getRelative(0, -5, 0))) return true;
					break;
				case 6:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) if(ifPillarBlock(b.getRelative(0, -5, 0))) if(ifPillarBlock(b.getRelative(0, -6, 0))) return true;
					break;
				case 7:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) if(ifPillarBlock(b.getRelative(0, -5, 0))) if(ifPillarBlock(b.getRelative(0, -6, 0))) if(ifPillarBlock(b.getRelative(0, -7, 0))) return true;
					break;
				case 8:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) if(ifPillarBlock(b.getRelative(0, -5, 0))) if(ifPillarBlock(b.getRelative(0, -6, 0))) if(ifPillarBlock(b.getRelative(0, -7, 0))) if(ifPillarBlock(b.getRelative(0, -8, 0))) return true;
					break;
				case 9:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) if(ifPillarBlock(b.getRelative(0, -5, 0))) if(ifPillarBlock(b.getRelative(0, -6, 0))) if(ifPillarBlock(b.getRelative(0, -7, 0))) if(ifPillarBlock(b.getRelative(0, -8, 0))) if(ifPillarBlock(b.getRelative(0, -9, 0))) return true;
					break;
				case 10:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) if(ifPillarBlock(b.getRelative(0, -5, 0))) if(ifPillarBlock(b.getRelative(0, -6, 0))) if(ifPillarBlock(b.getRelative(0, -7, 0))) if(ifPillarBlock(b.getRelative(0, -8, 0))) if(ifPillarBlock(b.getRelative(0, -9, 0))) if(ifPillarBlock(b.getRelative(0, -10, 0))) return true;
					break;
				case 11:
					if(ifPillarBlock(b)) if(ifPillarBlock(b.getRelative(0, -1, 0))) if(ifPillarBlock(b.getRelative(0, -2, 0))) if(ifPillarBlock(b.getRelative(0, -3, 0))) if(ifPillarBlock(b.getRelative(0, -4, 0))) if(ifPillarBlock(b.getRelative(0, -5, 0))) if(ifPillarBlock(b.getRelative(0, -6, 0))) if(ifPillarBlock(b.getRelative(0, -7, 0))) if(ifPillarBlock(b.getRelative(0, -8, 0))) if(ifPillarBlock(b.getRelative(0, -9, 0))) if(ifPillarBlock(b.getRelative(0, -10, 0))) if(ifPillarBlock(b.getRelative(0, -11, 0))) return true;
					break;
			}
		}
		return false;
	}
	
	public boolean actOnPillar(Player p, Block b)
	{
		if(this.getConfig().getBoolean("enforce.deletePillar")) 
		{
			for (Integer blockY = this.getConfig().getInt("heightOfPillar"); blockY > -1; blockY--) 
			{
				if(blockY != 0) b.getRelative(0, -(blockY), 0).setTypeId(0); else b.setTypeId(0);
			}
		}
		if(this.getConfig().getBoolean("enforce.killPlayer")) 
		{
			p.setHealth(0);
		}
		if(this.getConfig().getBoolean("enforce.kickPlayer")) 
		{
			p.kickPlayer(this.getConfig().getString("enforce.offServer.reason"));
		}
		if(this.getConfig().getBoolean("enforce.banPlayer")) 
		{
			p.setBanned(true);
		}
		return false;
	}
}
