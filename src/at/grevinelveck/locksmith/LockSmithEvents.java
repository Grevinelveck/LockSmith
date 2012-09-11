package at.grevinelveck.locksmith;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class LockSmithEvents implements Listener {
	
	/*Todo
	 * Check if player is owner, if owner allow acces if not and object is locked deny access
	 * If is owner and item in hand is a lockmaterial request they hit it again to begin locksmithing
	 * Send message with each upgrade telling them current strength and max
	 * If not owner and matirial is lockmatierial request they hit again to start.
	 * They will not be informed anything untill chest is unlocked.
	 * Sign place event if block behind is lockable and placer is owner of the sign and the first line is addmember
	 * Add the names to members.  Destroy sign
	 * Opposit for remove member*/

	
	@EventHandler
	public void lBlock(BlockPlaceEvent event){
		if (config.contains("LockableBlocks."+event.getBlock().getType())){
			if (config.getBoolean("LockableBlocks."+event.getBlock().getType())){
				//Store in database
			}
		}
	}
	
	@EventHandler
	public void useListener(PlayerInteractEvent event) {
		if (!config.contains("LockableBlocks."+event.getClickedBlock().getType())){
			return;
	}

}
}