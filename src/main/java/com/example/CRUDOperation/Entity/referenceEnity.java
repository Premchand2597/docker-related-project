package com.example.CRUDOperation.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reference")
public class referenceEnity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String refername;
	private String referemail;
	private String referphonenumber;
	private String relation;
	private String address;
	private long custid;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRefername() {
		return refername;
	}
	public void setRefername(String refername) {
		this.refername = refername;
	}
	public String getReferemail() {
		return referemail;
	}
	public void setReferemail(String referemail) {
		this.referemail = referemail;
	}
	public String getReferphonenumber() {
		return referphonenumber;
	}
	public void setReferphonenumber(String referphonenumber) {
		this.referphonenumber = referphonenumber;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getCustid() {
		return custid;
	}
	public void setCustid(long custid) {
		this.custid = custid;
	}
	@Override
	public String toString() {
		return "referenceEnity [id=" + id + ", refername=" + refername + ", referemail=" + referemail
				+ ", referphonenumber=" + referphonenumber + ", relation=" + relation + ", address=" + address
				+ ", custid=" + custid + "]";
	}
}
