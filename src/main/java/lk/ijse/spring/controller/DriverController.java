package lk.ijse.spring.controller;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.service.DriverService;
import lk.ijse.spring.service.UserService;
import lk.ijse.spring.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@CrossOrigin
@RequestMapping("v1/driver")
public class DriverController {

    @Autowired
    DriverService driverService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil SaveDriver(@RequestBody DriverDTO d){
        driverService.saveDriver(d);
        return new ResponseUtil(200,"Saved",null);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getAllDetails(){
        return new ResponseUtil(200,"ok",driverService.getAllDrivers());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @GetMapping(params={"nic"},produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseUtil getdriver(@RequestParam String nic){
        return new ResponseUtil(200,"ok",driverService.searchDriver(nic));
    }
}
