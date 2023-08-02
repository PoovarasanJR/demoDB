package demoDB.demoDB.bean1;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class secondary_details {
	private String location;
	@Id
	private long mobile;
	public secondary_details(String location, long mobile) {
		this.location = location;
		this.mobile = mobile;
	}
	public secondary_details() {
		// TODO Auto-generated constructor stub
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "secondary_details [location=" + location + ", mobile=" + mobile + "]";
	}
	
}
