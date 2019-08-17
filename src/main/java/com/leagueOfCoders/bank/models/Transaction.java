package com.leagueOfCoders.bank.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;



import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long tid;
	private long ammount;
	@ManyToOne
	@JoinColumn(name="account_number", nullable = false)
    private Account fromAccount;
    
    @ManyToOne
	@JoinColumn(name="to_account", nullable = false)
    private Account toAccount;
    
	public long getTid() {
		return tid;
	}
	public void setTid(long tid) {
		this.tid = tid;
	}
	public long getAmmount() {
		return ammount;
	}
	public void setAmmount(long ammount) {
		this.ammount = ammount;
	}
	
	public Account getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(Account fromAccount) {
		this.fromAccount = fromAccount;
	}
	public Account getToAccount() {
		return toAccount;
	}
	public void setToAccount(Account toAccount) {
		this.toAccount = toAccount;
	}
	public Transaction() {
		super();
	}
	public Transaction(long tid, long ammount, Account fromAccount, Account toAccount) {
		super();
		this.tid = tid;
		this.ammount = ammount;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
	}
	
    
    
}
