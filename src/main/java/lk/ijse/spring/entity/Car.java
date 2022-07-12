package lk.ijse.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Car {
    @Id
    private String reg_No;
    private String color;
    private String brand;
    private String type;
    private String no_ofPassengers;
    private String transmission;
    private String fuel;
    private String daily_Price;
    private String monthly_Price;
    private String free_Milage;
    private String extra_Price;
}
