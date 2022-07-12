package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.DriverDTO;
import lk.ijse.spring.dto.User_CarDTO;
import lk.ijse.spring.entity.Driver;
import lk.ijse.spring.entity.User_Car;
import lk.ijse.spring.repo.User_CarRepo;
import lk.ijse.spring.service.User_CarService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class User_CarServiceImpl implements User_CarService {

    @Autowired
    private User_CarRepo repo;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addBooking(User_CarDTO dto) {
        if (!repo.existsById(dto.getNic())) {
            if (!repo.existsById(dto.getReg_No())) {
                repo.save(mapper.map(dto, User_Car.class));
            }
        } else {
            throw new RuntimeException("Booking Already Added..!");
        }
    }

    @Override
    public void deleteBooking(String nic,String regno) {
        repo.deleteUser_CarByNicAndReg_No(nic,regno);
    }

    @Override
    public void updateBooking(User_CarDTO dto) {
        if (repo.existsById(dto.getNic())) {
            if (repo.existsById(dto.getReg_No())) {
                repo.save(mapper.map(dto, User_Car.class));
            }
        } else {
            throw new RuntimeException("Booking Isn't Added..!");
        }
    }

    @Override
    public User_CarDTO searchBooking(String nic,String regno) {
       return mapper.map(repo.findUser_CarByNicAndReg_No(nic,regno).getCars(),User_CarDTO.class);
    }

    @Override
    public List<User_CarDTO> getAllBookings() {
        return mapper.map(repo.findAllByUser_Car(),new TypeToken<List<User_CarDTO>>() {
        }.getType());
    }
}
