package com.strategypattern;

import java.sql.Date;

public class Transaction {
    private Date transactionDate;
    private int  transactionAmount;

    public Transaction(Date transactionDate,int transactionAmount){
        this.transactionDate=transactionDate;
        this.transactionAmount=transactionAmount;
    }

    public Date getDate(){
        return transactionDate;
    }

    public int getTransactionAmount(){
        return transactionAmount;
    }

    @Override
    public String toString() {
        return "Transaction Date : "+transactionDate+" Transaction Amount: "+transactionAmount;
    }
}
