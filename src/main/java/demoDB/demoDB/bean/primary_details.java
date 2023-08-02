package demoDB.demoDB.bean;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class primary_details {
	private String name;
	@Id
	private long mobile;
	
	public primary_details(String name, long mobile) {
		this.name = name;
		this.mobile = mobile;
	}
	
	public primary_details() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "primary_details [name=" + name + ", mobile=" + mobile + "]";
	}
	
}
