package com.switchfully.jeremie.eurder.repesitory;

import com.switchfully.jeremie.eurder.domain.Item;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ItemDatabase {
    Map<String, Item> items = new HashMap<>();

    public Item addItem(Item item){
        items.put(item.getId(), item);
        return item;
    }

    public Item getItem(String id){
        return items.get(id);
    }


}
