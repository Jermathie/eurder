package com.switchfully.jeremie.eurder.services.items;

import com.switchfully.jeremie.eurder.api.mappers.ItemMapper;
import com.switchfully.jeremie.eurder.domain.Item;
import com.switchfully.jeremie.eurder.domain.users.Admin;
import com.switchfully.jeremie.eurder.domain.users.Customer;
import com.switchfully.jeremie.eurder.exceptions.AdminPrivilegeException;
import com.switchfully.jeremie.eurder.repesitory.ItemDatabase;
import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import com.switchfully.jeremie.eurder.services.ItemService;
import com.switchfully.jeremie.eurder.services.ItemValidationService;
import com.switchfully.jeremie.eurder.services.UserValidationService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ItemServiceTest {
    @Test
    void givenNewItem_ICanAddToItemDatabase() {
        Item item = new Item("123E","eggs","package of 6 eggs", 3.5,10);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"),"admin","admin","admin@admin.com");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();

        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);
        itemService.addItem(item,admin.getId());

        Assertions.assertEquals(itemDatabase.getItem(item.getId()),item);

    }

    @Test
    void givenNewItem_itWillBeRejectedIfIdIsNull() {
        Item item = new Item(null,"eggs","package of 6 eggs", 3.5,10);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"),"admin","admin","admin@admin.com");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();
        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemService.addItem(item,admin.getId()));
    }

    @Test
    void givenNewItem_itWillBeRejectedIfNameIsNull() {
        Item item = new Item("12",null,"package of 6 eggs", 3.5,10);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"),"admin","admin","admin@admin.com");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();
        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemService.addItem(item,admin.getId()));
    }
    @Test
    void givenNewItem_itWillBeRejectedIfDescriptionIsNull() {
        Item item = new Item("1","eggs",null, 3.5,10);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"),"admin","admin","admin@admin.com");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();
        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemService.addItem(item,admin.getId()));
    }
    @Test
    void givenNewItem_itWillBeRejectedIfPriceIsEqualToZero() {
        Item item = new Item("1","eggs","package of 6 eggs", 0,10);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"),"admin","admin","admin@admin.com");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();
        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemService.addItem(item,admin.getId()));
    }
    @Test
    void givenNewItem_itWillBeRejectedIfPriceIsLowerThanZero() {
        Item item = new Item("1","eggs","package of 6 eggs", -5,10);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"),"admin","admin","admin@admin.com");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();
        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemService.addItem(item,admin.getId()));
    }
    @Test
    void givenNewItem_itWillBeRejectedIfStockAmountIsLowerThanOne() {
        Item item = new Item("1","eggs","package of 6 eggs", 5,0);
        Admin admin = new Admin(UUID.fromString("96e35a5e-bdbd-492b-aafb-8b9d2c6e96b9"),"admin","admin","admin@admin.com");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();
        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);

        Assertions.assertThrows(IllegalArgumentException.class, () -> itemService.addItem(item,admin.getId()));
    }

    @Test
    void givenNewItem_itWillBeRejectedIfNotAnAdminId() {
        Item item = new Item("1","eggs","package of 6 eggs", 3.5,10);
        Customer customer = new Customer(UUID.fromString("1f8767ee-e926-4b5a-bcdd-cb6aa3c04c21"), "John", "Doe", "johndoe@gmail.com", "BeCentral", "1",
                "1000", "Brussels", "023522536");

        ItemDatabase itemDatabase = new ItemDatabase();
        UserDatabase userDatabase = new UserDatabase();
        ItemMapper itemMapper = new ItemMapper();
        UserValidationService userValidationService = new UserValidationService();
        ItemValidationService itemValidationService = new ItemValidationService();
        ItemService itemService = new ItemService(itemDatabase,itemMapper,userDatabase,userValidationService,itemValidationService);

        userDatabase.addCustomer(customer);

        Assertions.assertThrows(AdminPrivilegeException.class, () -> itemService.addItem(item,customer.getId()));
    }



}