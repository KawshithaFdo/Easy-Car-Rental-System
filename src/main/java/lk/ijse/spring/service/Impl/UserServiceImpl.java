package lk.ijse.spring.service.Impl;

import javafx.scene.control.Alert;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import lk.ijse.spring.repo.UserRepo;
import lk.ijse.spring.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveUser(UserDTO dto) {
        if (!repo.existsById(dto.getNic())) {
            repo.save(mapper.map(dto, User.class));
        } else {
            throw new RuntimeException("User Already Exist..!");
        }
    }

    @Override
    public void loginUser(String user_Name, String password) {
        if (!(repo.loginuser(user_Name).getPassword().equals(password))){
            throw new RuntimeException("Invalid User_Name or Password.");

        }else{
            System.out.println("equal");
        }
    }


    @Override
    public void deleteUser(String id) {
        repo.deleteById(id);
    }

    @Override
    public void updateUser(UserDTO dto) {
        if (repo.existsById(dto.getNic())){
            repo.save(mapper.map(dto,User.class));
        }else{
            throw new RuntimeException("Not Registerd User.");
        }
    }

    @Override
    public UserDTO searchUser(String id) {
        if (repo.existsById(id)) {
            return mapper.map(repo.findById(id).get(), UserDTO.class);
        } else {
            throw new RuntimeException("No User For " + id + " ..!");
        }
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return mapper.map(repo.findAll(), new TypeToken<List<UserDTO>>() {
        }.getType());
    }

}
