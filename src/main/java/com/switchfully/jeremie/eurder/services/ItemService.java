package com.switchfully.jeremie.eurder.services;

import com.switchfully.jeremie.eurder.api.mappers.ItemMapper;
import com.switchfully.jeremie.eurder.domain.Item;
import com.switchfully.jeremie.eurder.repesitory.ItemDatabase;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ItemService {
    private ItemDatabase itemDatabase;
    private ItemMapper itemMapper;
    UserDatabase userDatabase;
    private UserValidationService userValidationService;
    private ItemValidationService itemValidationService;

    @Autowired
    public ItemService(ItemDatabase itemDatabase, ItemMapper itemMapper, UserDatabase userDatabase, UserValidationService userValidationService,ItemValidationService itemValidationService) {
        this.itemDatabase = itemDatabase;
        this.itemMapper = itemMapper;
        this.userDatabase = userDatabase;
        this.userValidationService = userValidationService;
        this.itemValidationService = itemValidationService;
    }

    public Item addItem(Item item, UUID userId) {
        userValidationService.itemAdminValidation(userId, this);
        itemValidationService.ItemStateValidation(item);

        return itemDatabase.addItem(item);
    }

}
