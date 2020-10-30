package com.switchfully.jeremie.eurder.services;

import com.switchfully.jeremie.eurder.domain.order.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemValidationService {
    public void ItemStateValidation(Item item) {
        if (item.getId() == null || item.getId().equals("")) {
            throw new IllegalArgumentException("Id can't be empty");
        }
        if (item.getName() == null || item.getName().equals("")) {
            throw new IllegalArgumentException("Name can't be empty");
        }
        if (item.getDescription() == null || item.getDescription().equals("")) {
            throw new IllegalArgumentException("Description can't be empty");
        }
        if (item.getPrice() <= 0) {
            throw new IllegalArgumentException("The price can't be less than or equal to zero.");
        }
        if (item.getStockAmount() < 1 ) {
            throw new IllegalArgumentException("The stock amount can't be less than one.");
        }
    }
}
