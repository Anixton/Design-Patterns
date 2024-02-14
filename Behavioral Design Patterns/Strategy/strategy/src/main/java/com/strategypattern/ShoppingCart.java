package com.strategypattern;

import java.sql.Date;

public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(Date date,int amount) {
        paymentStrategy.pay(date,amount);
    }

    public void displayTransactionHistory() {
        paymentStrategy.transactionHistory();
    }
}
