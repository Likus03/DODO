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
    private Long id;
    private Long idOrder;
    private String describe;
    private Float cost;
    private String address;
    private LocalTime deliveryTime;
    private Boolean completed;
}
