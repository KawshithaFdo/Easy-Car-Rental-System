package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.User_CarDTO;
import lk.ijse.spring.service.AdminService;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.service.User_CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@CrossOrigin
@RequestMapping("v1/admin")
public class AdminController {


    @Autowired
    CarService service;

    @Autowired
    UserService user;

    @Autowired
    User_CarService userCarService;

    @Autowired
    AdminService admin;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil saveCar(@RequestBody CarDTO car) {
        service.saveCar(car);
        return new ResponseUtil(200,"Save",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(params = {"user_Name","password"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil login(@RequestParam String user_Name,@RequestParam String password){
        admin.loginAdmin(user_Name,password);
        return new ResponseUtil(200,"Success",null);
    }


    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil updateCar(@RequestBody CarDTO car) {
        service.updateCar(car);
        return new ResponseUtil(200,"Updated",null);
    }

    @DeleteMapping(params = {"id"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil deletecar(@RequestParam String id) {
        service.deleteCar(id);
        return new ResponseUtil(200,"Deleted",null);
    }

    @GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil viewDriverSchedule(@RequestParam String id){
        return new ResponseUtil(200,"ok",userCarService.getdriverstatus(id));
    }

    @PostMapping(params={"reg_no"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil addDrivertoBooking(@RequestBody User_CarDTO user,@RequestParam String reg_no){
        admin.addBooking(user,reg_no);
        return new ResponseUtil(200,"ok",null);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(params={"reg_no","date"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getbookings(@RequestParam String reg_no,@RequestParam String date){
        return new ResponseUtil(200,"ok",userCarService.searchBooking(reg_no,date));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil viewUsers(){
       return new ResponseUtil(200,"ok",user.getAllUsers());
    }

    
}
