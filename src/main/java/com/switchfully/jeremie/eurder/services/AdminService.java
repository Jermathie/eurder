package com.switchfully.jeremie.eurder.services;

import com.switchfully.jeremie.eurder.repesitory.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    UserDatabase userDatabase;
    UserValidationService userValidationService;

    @Autowired
    public AdminService(UserDatabase userDatabase, UserValidationService userValidationService) {
        this.userDatabase = userDatabase;
        this.userValidationService = userValidationService;
    }
}
