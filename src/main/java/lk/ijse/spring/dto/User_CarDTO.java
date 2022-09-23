package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import java.sql.Date;
import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class User_CarDTO {
    private String nic;
    private String reg_No;
    private String pickup_Date;
    private String return_Date;
    private String driver_Status;
    private String rent_type;
    private String driver_nic;
    private int damagecost;
    private int duration;
    private String status;
    private String price;
}
