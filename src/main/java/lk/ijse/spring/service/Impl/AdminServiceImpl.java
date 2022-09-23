package lk.ijse.spring.service.Impl;

import lk.ijse.spring.dto.User_CarDTO;
import lk.ijse.spring.entity.User_Car;
import lk.ijse.spring.repo.AdminRepo;
import lk.ijse.spring.repo.User_CarRepo;
import lk.ijse.spring.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

@Transactional
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepo repo;

    @Autowired
    private User_CarRepo r;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void loginAdmin(String user_Name, String password) {
        if (!(repo.loginadmin(user_Name).getPassword().equals(password))){
            throw new RuntimeException("Invalid Admin_Name or Password.");
        }
    }

    @Override
    public void addBooking(User_CarDTO dto,String id) {

        r.save(mapper.map(dto, User_Car.class));
    }



}
