package by.It.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private long id;
    private int idOrder;
    private String describe;
    private float cost;
    private String address;
    private LocalTime deliveryTime;
    private boolean completed;
}
