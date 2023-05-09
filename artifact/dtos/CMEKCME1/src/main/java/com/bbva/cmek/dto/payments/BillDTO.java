package com.bbva.cmek.dto.payments;

import java.util.Objects;

public class BillDTO {
    private String idBill;
    private String number;
    private long value;

    public String getIdBill() {
        return idBill;
    }

    public void setIdBill(String idBill) {
        this.idBill = idBill;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BillDTO)) return false;
        BillDTO billDTO = (BillDTO) o;
        return value == billDTO.value && Objects.equals(idBill, billDTO.idBill) && Objects.equals(number, billDTO.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBill, number, value);
    }

    @Override
    public String toString() {
        return "BillDTO{" +
                "idBill='" + idBill + '\'' +
                ", number='" + number + '\'' +
                ", value=" + value +
                '}';
    }
}
