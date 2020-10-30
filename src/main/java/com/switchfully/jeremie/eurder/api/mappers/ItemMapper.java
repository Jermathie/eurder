package com.switchfully.jeremie.eurder.api.mappers;


import com.switchfully.jeremie.eurder.api.dtos.ItemDto;
import com.switchfully.jeremie.eurder.domain.order.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

    public ItemDto convertItemToItemDto(Item item) {
        ItemDto itemDto = new ItemDto(item.getId(),
                item.getName(),
                item.getDescription(),
                item.getPrice(),
                item.getStockAmount());
        return itemDto;
    }

    public Item convertItemDtoToItem(ItemDto itemDto) {
        Item item = new Item(itemDto.getId(),
                itemDto.getName(),
                itemDto.getDescription(),
                itemDto.getPrice(),
                itemDto.getStockAmount());
        return item;
    }

}
