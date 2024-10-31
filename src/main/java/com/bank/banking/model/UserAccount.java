package com.bank.banking.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "User_Account"
, schema="online_schema")
public class UserAccount {
	
	public UserAccount() {}

	public UserAccount(long accountId, long userid, long accnm, @NotNull double bal, String acctyp, boolean isact,
			Date crdt) {
		super();
		this.accountId = accountId;
		this.userid = userid;
		this.accnm = accnm;
		this.bal = bal;
		this.acctyp = acctyp;
		this.isact = isact;
		this.crdt = crdt;
	}


	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public long getUserid() {
		return userid;
	}

	public void setUserid(long userid) {
		this.userid = userid;
	}

	public long getAccnm() {
		return accnm;
	}

	public void setAccnm(long accnm) {
		this.accnm = accnm;
	}

	public double getBal() {
		return bal;
	}

	public void setBal(double bal) {
		this.bal = bal;
	}

	public String getAcctyp() {
		return acctyp;
	}

	public void setAcctyp(String acctyp) {
		this.acctyp = acctyp;
	}

	public boolean isIsact() {
		return isact;
	}

	public void setIsact(boolean isact) {
		this.isact = isact;
	}

	public Date getCrdt() {
		return crdt;
	}

	public void setCrdt(Date crdt) {
		this.crdt = crdt;
	}

	@Id
	@GeneratedValue
	@Column(name = "account_id")
	private long accountId;

	@Column(name = "userId")
    private long userid;

	@Column(name = "accNum")
    private long accnm;
	
    @Column (name ="balance")
    @NotNull
    private double bal;
    
    @Column(name = "acctyp")
    private String acctyp;
	
    @Column(name = "isact")
    private boolean isact;
    
    @Column(name = "createddate")
    private Date crdt;

}
