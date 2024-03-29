package lk.ijse.spring.controller;

import lk.ijse.spring.dto.CarDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.CarService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("v1/car")
public class CarController {

    @Autowired
    CarService service;

    @GetMapping(params = {"nic"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil searchcar(@RequestParam String nic) {
        return new ResponseUtil(200,"Ok",service.searchCar(nic));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllCars(){
        return new ResponseUtil(200,"ok",service.getAllCars());
    }
}
