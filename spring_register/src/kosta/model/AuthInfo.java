package kosta.model;

import java.io.Serializable;

public class AuthInfo implements Serializable {
	private Long id;
	private String email;
	private String name;
	
	public AuthInfo(){}
		
	public AuthInfo(String email, String name) {		
		this.email = email;
		this.name = name;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
