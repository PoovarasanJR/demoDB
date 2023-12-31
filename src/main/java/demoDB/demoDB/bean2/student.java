package demoDB.demoDB.bean2;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class student {
	@Id
	private String name;
	private String password;
	private String mail;
	private long mobile;
	public student(String name, String password, String mail, long mobile) {
		this.name = name;
		this.password = password;
		this.mail = mail;
		this.mobile = mobile;
	}
	public student() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	@Override
	public String toString() {
		return "student [name=" + name + ", password=" + password + ", mail=" + mail + ", mobile=" + mobile + "]";
	}
	
}
