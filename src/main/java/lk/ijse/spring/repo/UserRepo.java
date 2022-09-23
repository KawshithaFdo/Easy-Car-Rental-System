package lk.ijse.spring.repo;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import lk.ijse.spring.dto.UserDTO;
import lk.ijse.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<User,String> {
    @Query(value =  "select * from user where user_Name=?1" ,nativeQuery=true)
    User loginuser(String username);
}
