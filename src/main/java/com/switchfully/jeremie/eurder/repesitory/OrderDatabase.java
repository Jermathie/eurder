package com.switchfully.jeremie.eurder.repesitory;


import com.switchfully.jeremie.eurder.domain.order.OrderItems;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class OrderDatabase {

    private Map<String, OrderItems> orderDatabase = new HashMap<>();

    public void createOrder(OrderItems newOrder) {
        orderDatabase.put(newOrder.getId(), newOrder);
    }

    public Map<String, OrderItems> getAllOrders() {
        return orderDatabase;
    }

    public List<OrderItems> getAllOrdersByCustomer(String customerId) {
        return orderDatabase.values().stream()
                .filter(orderItems -> orderItems.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
    }


}
