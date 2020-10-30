package com.switchfully.jeremie.eurder.services;

import com.switchfully.jeremie.eurder.domain.order.ItemsGroups;
import com.switchfully.jeremie.eurder.domain.order.OrderItems;
import com.switchfully.jeremie.eurder.repesitory.ItemDatabase;
import com.switchfully.jeremie.eurder.repesitory.OrderDatabase;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderService {
    private OrderDatabase orderDatabase;
    private UserDatabase userDatabase;
    private ItemDatabase itemDatabase;

    @Autowired
    public OrderService(OrderDatabase orderDatabase, UserDatabase userDatabase, ItemDatabase itemDatabase) {
        this.orderDatabase = orderDatabase;
        this.userDatabase = userDatabase;
        this.itemDatabase = itemDatabase;
    }
    public OrderItems createNewOrder(String customerId, List<ItemsGroups> orderItems){

        OrderItems newOrder = new OrderItems()
    }

    private double calculateTotalPriceOfTheNewOrder(List<ItemsGroups> itemsGroups){
        return itemsGroups.stream()
                .map()
    }

}
