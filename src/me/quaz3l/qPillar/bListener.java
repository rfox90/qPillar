package me.quaz3l.qPillar;


import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class bListener implements Listener
{

	public static qPillar plugin;
	
	public bListener(qPillar instance) 
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent e)
	{
		Block b = e.getBlock();
		Player p = e.getPlayer();
		if(plugin.checkForPillar(p, b, plugin.getConfig().getInt("heightOfPillar"), plugin.getConfig().getInt("pillarAbove")))
		{
			plugin.actOnPillar(p, b);
		}
	}
}