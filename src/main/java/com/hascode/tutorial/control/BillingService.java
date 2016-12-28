package com.hascode.tutorial.control;

import java.util.ArrayList;
import java.util.List;

import com.hascode.tutorial.entity.Order;

public class BillingService {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        System.out.printf("adding order to the billing service: %s\n", order);
        orders.add(order);
    }
}
