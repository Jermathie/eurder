package com.switchfully.jeremie.eurder.api.dtos;

public class ItemDto {

    private String id;
    private String name;
    private String description;
    private double price;
    private int stockAmount;

    public ItemDto(String id, String name, String description, double price, int stockAmount) {
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
