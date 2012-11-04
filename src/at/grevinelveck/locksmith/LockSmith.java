package at.grevinelveck.locksmith;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.PersistenceException;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.avaje.ebean.EbeanServer;

public class LockSmith extends JavaPlugin {

	public static EbeanServer database;
	public static LockSmith plugin;
	public final LockSmithEvents locklistener = new LockSmithEvents();
	
	
	@Override
	public void onDisable() {

	}
	public void loadConfiguration() {
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	@Override
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(locklistener, this);;
		System.out.println("yay test");
		database = getDatabase();
		setupDatabase();
		plugin = this;
		loadConfiguration();

	}

	private void setupDatabase() {
		try {
			database.find(PlayerDatabase.class).findRowCount();
		} catch (PersistenceException ex) {
			// ex.printStackTrace();
			System.out.println("Installing database for "
					+ getDescription().getName() + " due to first time use.");
			installDDL();
		} 
	}

	@Override
	public List<Class<?>> getDatabaseClasses() {
		List<Class<?>> list = new ArrayList<Class<?>>();
		list.add(PlayerDatabase.class);
		return list;
	}

}
