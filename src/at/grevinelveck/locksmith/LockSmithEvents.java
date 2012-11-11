package at.grevinelveck.locksmith;

import java.util.ArrayList;
import java.util.Iterator;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class LockSmithEvents implements Listener {

	// Store the data on a place event
	@EventHandler
	public void lBlock(BlockPlaceEvent event) {
		if (!LockSmith.plugin.getConfig().contains(
				"LockableBlocks." + event.getBlock().getType())) {
			return;
		}
		PlayerDatabase toadd = new PlayerDatabase();
		toadd.setCurrentvalue(0);
		toadd.setLastupdated(0);
		toadd.setMembers(new ArrayList<String>());
		toadd.setOwner(event.getPlayer().getName());
		toadd.setTotalvalue(0);
		toadd.setWorldname(event.getBlock().getWorld().getName());
		toadd.setbLoc(event.getBlock().getLocation());
		LockSmith.database.save(toadd);

	}

	/**********************************************
	 * on a block break event check the location. Special actions are, check if
	 * locked, if locked is player owner or member. If not cancel event. If they
	 * are a owner or member remove block from the database.
	 * *******************************************/
	public void bBlock(BlockBreakEvent event)

	{
		if (LockSmith.database.createQuery(PlayerDatabase.class).where()
				.eq("bLoc", event.getBlock().getLocation()) == null) {
			return;
		}
		PlayerDatabase dB=LockSmith.database.find(PlayerDatabase.class)
				.where().eq("bLock", event.getBlock().getLocation()).findUnique();
		String dBOwner=dB.getOwner();
		Iterator<String> dBMembers=dB.getMembers().iterator();
		boolean found=false;
		if (event.getPlayer().getName().equalsIgnoreCase(dBOwner)){
			found=true;
		}else{
			while (dBMembers.hasNext()||!found==true){
				String cName=dBMembers.next();
				if (cName.equalsIgnoreCase(event.getPlayer().getName())){
					found=true;
				}
				if (found==true){
					event.setCancelled(true);
					event.getPlayer().sendMessage(ChatColor.RED+"This chest isn't yours");
					return;
				}
			}
		}
		
	}
}