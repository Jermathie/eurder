package com.switchfully.jeremie.eurder.domain.order;

import java.util.List;

public class OrderItems {


    private final String id;
    private final List<ItemsGroups> items;
    private final String customerId;
    private final double totalOrderPrice;

    public OrderItems(String id, List<ItemsGroups> items, String customerId, double totalOrderPrice) {
        this.id = id;
        this.items = items;
        this.customerId = customerId;
        this.totalOrderPrice = totalOrderPrice;
    }

    public String getId() {
        return id;
    }

    public List<ItemsGroups> getItems() {
        return items;
    }

    public String getCustomerId() {
        return customerId;
    }

    public double getTotalOrderPrice() {
        return totalOrderPrice;
    }
}
