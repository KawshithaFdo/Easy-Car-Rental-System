package lk.ijse.spring.controller;

import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.dto.User_CarDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.service.User_CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("v1/booking")
public class UserBookingController {

    @Autowired
    UserService userService;

    @Autowired
    User_CarService service;

    @Autowired
    AdminService adminService;

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(params = {"user_Name","password"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil login(@RequestParam String user_Name,@RequestParam String password){
       userService.loginUser(user_Name,password);
       return new ResponseUtil(200,"Success",null);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil placebooking(@RequestBody User_CarDTO user){
        service.addBooking(user);
        return new ResponseUtil(200,"Success",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateUser(@RequestBody UserDTO user){
        userService.updateUser(user);
        return new ResponseUtil(200,"Updated",null);
    }

    @GetMapping(params = {"nic"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchuser(@RequestParam String nic){
        UserDTO userDTO = userService.searchUser(nic);
        return new ResponseUtil(200,"Success",userDTO);
    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllUsers(){
        return new ResponseUtil(200,"ok",userService.getAllUsers());
    }
}
