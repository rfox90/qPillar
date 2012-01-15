package me.quaz3l.qPillar;


import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockListener;
import org.bukkit.event.block.BlockPlaceEvent;

public class bListener extends BlockListener
{

	public static qPillar plugin;
	
	public bListener(qPillar instance) 
	{
		plugin = instance;
	}
	
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