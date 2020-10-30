package com.switchfully.jeremie.eurder.repesitory;

import com.switchfully.jeremie.eurder.domain.order.ItemsGroups;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ItemsGroupsDatabase {
    Map<String,ItemsGroups> itemsGroupsDatabase = new HashMap<>();

    public String addItemsGroupsInDatabase(String customerId,ItemsGroups itemsGroups){
        itemsGroupsDatabase.put(customerId, itemsGroups);
        return itemsGroups.getItemId();
    }



}
