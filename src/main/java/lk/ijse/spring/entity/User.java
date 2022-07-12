package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class User {
    @Id
    private String nic;
    private String email;
    private String user_Name;
    private String password;
    private String drivingNo;
    private String address;
    private String contact;

    @OneToMany(mappedBy = "User",cascade = CascadeType.ALL)
    private List<User_Car> userdetails;
}
