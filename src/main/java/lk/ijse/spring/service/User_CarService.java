package lk.ijse.spring.service;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.User_CarDTO;

import java.util.List;

public interface User_CarService {
    void addBooking(User_CarDTO dto);
    void deleteBooking(String nic,String regno);
    void updateBooking(User_CarDTO dto);
    User_CarDTO searchBooking(String nic,String regno);
    List<User_CarDTO> getAllBookings();
}
