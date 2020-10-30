package com.switchfully.jeremie.eurder.domain.order;

public class Item {

    private final String id;
    private final String name;
    private final String description;
    private final double price;
    private final int stockAmount;

    public Item(String id, String name, String description, double price, int stockAmount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockAmount = stockAmount;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getStockAmount() {
        return stockAmount;
    }


}
