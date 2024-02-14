/*
 * Copyright (c) 2024, Hakan Gezginci. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the MIT License, as published by the Open Source Initiative.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the MIT License for more details.
 *
 * You should have received a copy of the MIT License along with this work; 
 * if not, see <https://opensource.org/licenses/MIT>.
 *
 * Please contact Your Name or Company Name, Your Contact Information
 * if you need additional information or have any questions.
 */

package com.strategypattern;

import java.util.Random;
import java.sql.Date;
import java.util.Calendar;

/*
 * This is a simple demonstration of the Strategy Pattern applied to a shopping cart.
 * The ShoppingCart class can use different payment strategies (Paypal, Credit Card, Bitcoin).
 * The payment strategy can be changed at runtime.
 * This program also demonstrates how to manipulate dates in Java.
 */
public class App 
{
    public static void main(String[] args) {
        
        CreditCardStrategy creditCardStrategy = new CreditCardStrategy();
        BitcoinStrategy bitcoinStrategy = new BitcoinStrategy();
        PaypalStrategy paypalStrategy = new PaypalStrategy();
        ShoppingCart cart = new ShoppingCart();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            int daysToSubtract = random.nextInt(366);

            java.util.Date utilDate = new java.util.Date();
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(utilDate);
            calendar.add(Calendar.DATE, -daysToSubtract);
            utilDate = calendar.getTime();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            int strategyChoice = random.nextInt(3);
            if (strategyChoice == 0) {
                cart.setPaymentStrategy(paypalStrategy);
            } else if (strategyChoice == 1) {
                cart.setPaymentStrategy(creditCardStrategy);
            } else {
                cart.setPaymentStrategy(bitcoinStrategy);
            }

            int amount = random.nextInt(500) + 1;
            cart.pay(sqlDate, amount);
        }

        System.out.println("Bitcoin Transaction History:");
        bitcoinStrategy.transactionHistory();

        System.out.println("\r\nCredit Card Transaction History:");
        creditCardStrategy.transactionHistory();

        System.out.println("\r\nPaypal Transaction History:");
        paypalStrategy.transactionHistory();
        
    }
}
