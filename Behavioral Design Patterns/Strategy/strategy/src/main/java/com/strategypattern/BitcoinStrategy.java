package com.strategypattern;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class BitcoinStrategy implements PaymentStrategy {
    private List<Transaction> transactionList;

    BitcoinStrategy() {
        transactionList = new ArrayList<Transaction>();
    }
    
    @Override
    public void pay(Date date,int amount) {
        transactionList.add(new Transaction(date,amount));
    }

    @Override
    public void transactionHistory() {
        for(int i=0;i<transactionList.size();i++){
            System.out.println(transactionList.get(i).toString());
        }
    }
}
