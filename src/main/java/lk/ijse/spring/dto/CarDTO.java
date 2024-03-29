package lk.ijse.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CarDTO {
    private String reg_No;
    private String color;
    private String brand;
    private String no_ofPassengers;
    private String transmission;
    private String fuel;
    private int dailyrate;
    private int monthlyrate;
    private int free_Milage_forDay;
    private int free_Milage_forMonth;
    private int extra_Price;
    private String car_type;
}
