package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
@IdClass(User_CarPK.class)
public class User_Car {
    @Id
    private String nic;
    @Id
    private String reg_No;
    private String pickup_Date;
    private String return_Date;
    private String driver_Status;
    private String rent_type;
    private int damagecost;
    private int duration;
    private String status;
    private String driver_nic;
    private String price;

    @ManyToOne
    @JoinColumn(name = "nic",referencedColumnName = "nic",insertable = false,updatable = false)
    private User users;

    @ManyToOne
    @JoinColumn(name = "reg_No",referencedColumnName = "reg_No",insertable = false,updatable = false)
    private Car cars;

}
