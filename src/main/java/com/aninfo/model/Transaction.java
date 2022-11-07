package com.aninfo.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Double sum;

    private String type;

    private Long accountCbu;

    public Transaction(){
    }

    public Transaction(Double sum, String type, Long accountCbu) {
        this.sum = sum;
        this.type = type;
        this.accountCbu = accountCbu;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isWithdrawal() {
        return type.equals("withdrawal");
    }

    public boolean isDeposit() {
        return type.equals("deposit");
    }

    public Long getAccountCbu() {
        return accountCbu;
    }

    public void setAccountCbu(Long accountCbu) {
        this.accountCbu = accountCbu;
    }
}
