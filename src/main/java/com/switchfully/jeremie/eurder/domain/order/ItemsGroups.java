package com.switchfully.jeremie.eurder.domain.order;

import java.time.LocalDate;

public class ItemsGroups {

    private final int SHIPPING_DATE_WHEN_ITEM_IN_STOCK = 1;
    private final int SHIPPING_DATE_WHEN_ITEM_OUT_OF_STOCK = 8;
    private String itemId;
    private int stockAmount;
    private LocalDate shippingDate;

    public ItemsGroups(String itemId, int stockAmount) {
        this.itemId = itemId;
        this.stockAmount = stockAmount;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public int getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(int stockAmount) {
        this.stockAmount = stockAmount;
    }

    public LocalDate getShippingDate() {
        return shippingDate;
    }

    public void setShippingDate(LocalDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
