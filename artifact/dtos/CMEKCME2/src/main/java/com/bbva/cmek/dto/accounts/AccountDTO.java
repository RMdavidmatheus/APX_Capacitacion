package com.bbva.cmek.dto.accounts;

import java.util.Objects;

public class AccountDTO {

    private String id;
    private long balance;
    private boolean status;
    private String ownerAccount;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getOwnerAccount() {
        return ownerAccount;
    }

    public void setOwnerAccount(String ownerAccount) {
        this.ownerAccount = ownerAccount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AccountDTO)) return false;
        AccountDTO that = (AccountDTO) o;
        return balance == that.balance && status == that.status && Objects.equals(id, that.id) && Objects.equals(ownerAccount, that.ownerAccount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, status, ownerAccount);
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                ", status=" + status +
                ", ownerAccount='" + ownerAccount + '\'' +
                '}';
    }
}
