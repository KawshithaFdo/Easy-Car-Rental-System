package lk.ijse.spring.controller;

import lk.ijse.spring.entity.User;
import lk.ijse.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public class UserBookingController {

    @Autowired
    UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(params = {"user_Name","password"},produces = MediaType.APPLICATION_JSON_VALUE)
    public void login(@RequestParam String user_Name,@RequestParam String password){
       userService.loginUser(user_Name,password);
    }

//    @PostMapping
    public void placeRental(){}

//    @GetMapping
    public void viewRentalStatus(){}

//    @PutMapping
    public void updateCustomer(){}
}
