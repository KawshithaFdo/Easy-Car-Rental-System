package lk.ijse.spring.repo;

import lk.ijse.spring.entity.User_Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface User_CarRepo extends JpaRepository<User_Car,String> {
    @Query(value = "delete  from User_Car where nic=?1 and reg_No=?2", nativeQuery = true)
    User_Car deleteUser_CarByNicAndReg_No(String nic, String reg_No);

    @Query(value = "select * from User_Car", nativeQuery = true)
    List<User_Car> findAllByUser_Car();

    @Query(value = "select * from User_Car where reg_No=?1 and pickup_Date=?2", nativeQuery = true)
    User_Car findUser_CarByPickup_DateAndReg_No(String reg_no, String date);
}
