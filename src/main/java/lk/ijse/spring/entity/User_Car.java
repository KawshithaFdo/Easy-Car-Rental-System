package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class User_Car {
    @Id
    private String nic;
    @Id
    private String reg_No;
    private LocalDate pickup_Date;
    private LocalDate return_Date;
    private String driver_Status;

    @ManyToOne
    @JoinColumn(name = "nic",referencedColumnName = "nic",insertable = false,updatable = false)
    private User users;

    //Out-verse
    @ManyToOne
    @JoinColumn(name = "reg_No",referencedColumnName = "reg_No",insertable = false,updatable = false)
    private Car cars;
}
