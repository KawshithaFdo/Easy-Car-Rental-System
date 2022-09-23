package lk.ijse.spring.service;

import lk.ijse.spring.dto.User_CarDTO;

import java.sql.Date;
import java.util.List;

public interface User_CarService {
    void addBooking(User_CarDTO dto);
    void deleteBooking(String nic,String regno);
    void updateBooking(User_CarDTO dto);
    String getdriverstatus(String id);
    User_CarDTO searchBooking(String regno, String date);
    List<User_CarDTO> getAllBookings();
    void calculatebill(User_CarDTO user);
}
