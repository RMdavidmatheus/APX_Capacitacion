package com.bbva.cmek.dto.payments;

import com.bbva.cmek.dto.accounts.AccountDTO;

import java.util.Objects;

public class PaymentDTO {
    private String id;
    private AccountDTO account;
    private BillDTO bill;
    private String operationDateTime;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public AccountDTO getAccount() {
        return account;
    }

    public void setAccount(AccountDTO account) {
        this.account = account;
    }

    public BillDTO getBill() {
        return bill;
    }

    public void setBill(BillDTO bill) {
        this.bill = bill;
    }

    public String getOperationDateTime() {
        return operationDateTime;
    }

    public void setOperationDateTime(String operationDateTime) {
        this.operationDateTime = operationDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentDTO)) return false;
        PaymentDTO that = (PaymentDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(account, that.account) && Objects.equals(bill, that.bill) && Objects.equals(operationDateTime, that.operationDateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, account, bill, operationDateTime);
    }

    @Override
    public String toString() {
        return "PaymentDTO{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", bill=" + bill +
                ", operationDateTime='" + operationDateTime + '\'' +
                '}';
    }
}
