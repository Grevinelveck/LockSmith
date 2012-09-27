package at.grevinelveck.locksmith;

import java.util.List;

import javax.persistence.*;

import com.avaje.ebean.validation.NotNull;

@Entity
@Table(name = "LockSmith")
public class PlayerDatabase {
	@Id
	private int id;
	@NotNull
	private String owner;
	@NotNull
	private List<String> members;
	@NotNull
	private int totalvalue;
	@NotNull
	private int currentvalue;
	@NotNull
	private int lastupdated;
	@NotNull
	private int x, y, z;
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

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getZ() {
		return z;
	}

	public void setZ(int z) {
		this.z = z;
	}

	public String getWorldname() {
		return worldname;
	}

	public void setWorldname(String worldname) {
		this.worldname = worldname;
	}

}
