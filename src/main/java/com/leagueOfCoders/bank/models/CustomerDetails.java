package com.leagueOfCoders.bank.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class CustomerDetails {
	
	public CustomerDetails() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cust_id;
	private String password;
	private String firstname;
	private String lastname;
	private String email;
	private String phoneNum;
	
    @Column(unique = true)
	private String panId;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Account> accounts = new HashSet<>();
	
	public CustomerDetails(long cust_id, String username, String password, String firstname, String lastname, String email,
			String phoneNum, String panId) {
		this.cust_id = cust_id;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phoneNum = phoneNum;
		this.panId = panId;
		
	}
	
	public long getCust_id() {
		return cust_id;
	}
	
	public void setCust_id(long cust_id) {
		this.cust_id = cust_id;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPanId() {
		return panId;
	}
	public void setPanId(String panId) {
		this.panId = panId;
	}
	
	@Override
	public String toString() {
		return "CustomerDetails [cust_id=" + cust_id + ", password=" + password + ", firstname="
				+ firstname + ", lastname=" + lastname + ", email=" + email + ", phoneNum=" + phoneNum + ", panId=" + panId
				+ "]";
	}

}
