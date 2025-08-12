package com.example.CRUDOperation.DTO;

public class customerWithIdDTO {

	private long id;
	private String custname;
	private String email;
	private String phonenumber;
	private String pass;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "customerWithIdDTO [id=" + id + ", custname=" + custname + ", email=" + email + ", phonenumber="
				+ phonenumber + ", pass=" + pass + "]";
	}
}
