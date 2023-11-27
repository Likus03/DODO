package by.It.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Courier {
    private Long id;
    private String firstname;
    private String surname;
    private String phoneNumber;
    private String deliveryType;
}
