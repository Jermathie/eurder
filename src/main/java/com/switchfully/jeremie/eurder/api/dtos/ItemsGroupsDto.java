package com.switchfully.jeremie.eurder.api.dtos;

public class ItemsGroupsDto {
    private final String id;
    private final int amount;

    public ItemsGroupsDto(String id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }


}
