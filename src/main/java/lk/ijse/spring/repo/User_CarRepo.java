package lk.ijse.spring.repo;

import lk.ijse.spring.entity.User_Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface User_CarRepo extends JpaRepository<User_Car,String> {
    User_Car deleteUser_CarByNicAndReg_No(String nic,String reg_no);
    User_Car findUser_CarByNicAndReg_No(String nic,String regno);
   List<User_Car> findAllByUser_Car();
}
