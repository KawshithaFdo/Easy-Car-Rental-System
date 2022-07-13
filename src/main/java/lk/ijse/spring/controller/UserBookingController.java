package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.dto.User_CarDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.service.User_CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

public class UserBookingController {

    @Autowired
    UserService userService;

    @Autowired
    User_CarService service;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(params = {"user_Name","password"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil login(@RequestParam String user_Name,@RequestParam String password){
       userService.loginUser(user_Name,password);
       return new ResponseUtil(200,"Success",null);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil placeRental(@ModelAttribute User_CarDTO user){
        service.addBooking(user);
        return new ResponseUtil(200,"Success",null);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@ModelAttribute UserDTO user){
        userService.saveUser(user);
        return new ResponseUtil(200,"Updated",null);
    }
}
