package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.User_CarDTO;
import lk.ijse.spring.entity.Car;
import lk.ijse.spring.entity.User_Car;
import lk.ijse.spring.repo.CarRepo;
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
    private CarRepo car;

    @Autowired
    private ModelMapper mapper;
    @Override
    public void addBooking(User_CarDTO dto) {
        repo.save(mapper.map(dto, User_Car.class));
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
    public String  getdriverstatus(String id) {
       return repo.getReferenceById(id).getDriver_Status();
    }

    @Override
    public User_CarDTO searchBooking(String regno, String date) {
       return mapper.map(repo.findUser_CarByPickup_DateAndReg_No(regno,date),User_CarDTO.class);
    }

    @Override
    public List<User_CarDTO> getAllBookings() {
        return mapper.map(repo.findAllByUser_Car(),new TypeToken<List<User_CarDTO>>() {
        }.getType());
    }

    @Override
    public void calculatebill(User_CarDTO user) {
        int price=0;
        if (user.getRent_type().equals("Daily")) {
                        //Daily
            if (user.getDriver_Status().equals("No")) {
//                No Driver
                if ((user.getDuration()<=100)) {
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=carByReg_no.getDailyrate();
                }else{
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=(carByReg_no.getDailyrate())+((user.getDuration()-100)*carByReg_no.getExtra_Price());
                }
            }else{
//                Need Driver
                if ((user.getDuration()<=100)) {
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=(carByReg_no.getDailyrate()+1000);
                }else{
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=((carByReg_no.getDailyrate())+((user.getDuration()-100)*carByReg_no.getExtra_Price())+1000);
                }
            }
        }else{
                        //Monthly
            if (user.getDriver_Status().equals("No")) {
//                No Driver
                if ((user.getDuration()<=2400)) {
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=carByReg_no.getMonthlyrate();
                }else{
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=(carByReg_no.getMonthlyrate())+((user.getDuration()-2400)*carByReg_no.getExtra_Price());
                }
            }else{
//                Need Driver
                if ((user.getDuration()<=2400)) {
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=(carByReg_no.getMonthlyrate()+3000);
                }else{
                    Car carByReg_no = car.findCarByReg_No(user.getReg_No());
                    price=((carByReg_no.getMonthlyrate())+((user.getDuration()-2400)*carByReg_no.getExtra_Price())+30000);
                }
            }
        }
        User_CarDTO u = new User_CarDTO(user.getNic(),user.getReg_No(),user.getPickup_Date(),user.getReturn_Date(),user.getDriver_Status(),
                user.getRent_type(),user.getDriver_nic(),user.getDamagecost(),user.getDuration(),user.getStatus(),String.valueOf(price));
        repo.save(mapper.map(u, User_Car.class));
    }
}
