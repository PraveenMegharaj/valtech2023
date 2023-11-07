package com.valtech.training.hibernate;

import java.io.Serializable;
import java.util.Objects;

public class BankAccountId implements Serializable {

	private String accountType;
	private int accountNum;

	public BankAccountId() {
	}

	public BankAccountId(String accountType, int accountNum) {
		this.accountType = accountType;
		this.accountNum = accountNum;
	}

	@Override
	public int hashCode() {
		return Objects.hash(accountNum, accountType);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccountId other = (BankAccountId) obj;
		return accountNum == other.accountNum && Objects.equals(accountType, other.accountType);
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public int getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}

}
