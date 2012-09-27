package at.grevinelveck.locksmith;

import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.avaje.ebean.Query;

public class LockSmithEvents implements Listener {

	/*TODO Setup database
	 * TODO Store information about lockable items when placed
	 * TODO Set up locking
	 * TODO Set up unlocking
	 * TODO Set up adding members
	 * TODO Set up removing members
	 * TODO Set up list members
	 * TODO Add a permissions bypass to everything.*/

	@EventHandler
	public void lBlock(BlockPlaceEvent event) {
		System.out.println(event.getBlock().getTypeId());
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
		toadd.setX(event.getBlock().getX());
		toadd.setY(event.getBlock().getY());
		toadd.setZ(event.getBlock().getZ());
		LockSmith.database.save(toadd);

	}

	@EventHandler
	public void useListener(PlayerInteractEvent event) {
		System.out.println(event.getItem().getTypeId());
		if (!LockSmith.plugin.getConfig().contains("LockItems."
		+ event.getItem().getType())
				|| LockSmith.database.createQuery(PlayerDatabase.class).where()
						.eq("location", event.getClickedBlock().getLocation())

						.findRowCount() == 0) {
			return;

		}
if(LockSmith.database.createQuery(PlayerDatabase.class).where().eq("Owner", event.getPlayer().getName()) != null);
	}
}