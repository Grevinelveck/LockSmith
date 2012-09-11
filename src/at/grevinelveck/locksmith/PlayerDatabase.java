package at.grevinelveck.locksmith;

import java.util.List;

import javax.persistence.*;

import org.bukkit.Location;

@Entity
@Table(name="LockSmith")
public class PlayerDatabase {
	@Id
	private int id;
	private String owner;
	private List<String> members;
	private Location location;
	private int totalvalue;
	private int currentvalue;
	private int lastupdated;
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
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
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


	



}
