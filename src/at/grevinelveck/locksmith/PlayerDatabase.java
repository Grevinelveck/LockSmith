package at.grevinelveck.locksmith;

import java.util.List;

import javax.persistence.*;

import org.bukkit.Location;

import com.avaje.ebean.validation.NotNull;

@Entity
@Table(name = "LockSmith")
public class PlayerDatabase {
	@Id
	private int id;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@NotNull
	private String owner;
	
	private List<String> members;
	@NotNull
	private int totalvalue;
	@NotNull
	private int currentvalue;
	@NotNull
	private int lastupdated;
	@NotNull
	private Location bLoc;
	@NotNull
	private String worldname;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public List<String> getMembers() {
		return members;
	}

	public void setMembers(List<String> members) {
		this.members = members;
	}

	public int getTotalvalue() {
		return totalvalue;
	}

	public void setTotalvalue(int totalvalue) {
		this.totalvalue = totalvalue;
	}

	public int getCurrentvalue() {
		return currentvalue;
	}

	public void setCurrentvalue(int currentvalue) {
		this.currentvalue = currentvalue;
	}

	public int getLastupdated() {
		return lastupdated;
	}

	public void setLastupdated(int lastupdated) {
		this.lastupdated = lastupdated;
	}


	public Location getbLoc() {
		return bLoc;
	}

	public void setbLoc(Location bLoc) {
		this.bLoc = bLoc;
	}

	public String getWorldname() {
		return worldname;
	}

	public void setWorldname(String worldname) {
		this.worldname = worldname;
	}


}
