package com.strategypattern;

import java.sql.Date;

// Strategy Interface
public interface PaymentStrategy {
    public void pay(Date date,int amount);
    public void transactionHistory();
}

