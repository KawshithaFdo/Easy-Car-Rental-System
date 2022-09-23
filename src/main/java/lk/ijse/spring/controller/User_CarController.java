package lk.ijse.spring.controller;

import lk.ijse.spring.dto.User_CarDTO;
import lk.ijse.spring.service.User_CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("v1/user_car")
public class User_CarController {

    @Autowired
    User_CarService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAll(){
        return new ResponseUtil(200,"ok",service.getAllBookings());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(params={"reg_no","date"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getbookings(@RequestParam String reg_no,@RequestParam String date){
        return new ResponseUtil(200,"ok",service.searchBooking(reg_no,date));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil calculatebill(@RequestBody User_CarDTO user){
        service.calculatebill(user);
        return new ResponseUtil(200,"ok",null);
    }
}
