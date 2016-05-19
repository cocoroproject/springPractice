package kosta.model;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable {
	private Long id;
	private String email;
	private String password;
	private String name;
	private Date registerDate;
	
	public Member(){}

	public Member(Long id, String email, String password, String name,
			Date registerDate) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.registerDate = registerDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new IdPasswordNotMatchingException();
		this.password = newPassword;
	}

	public boolean matchPassword(String pwd) {
		return this.password.equals(pwd);
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", email=" + email + ", password="
				+ password + ", name=" + name + ", registerDate="
				+ registerDate + "]";
	}
	
	
}
